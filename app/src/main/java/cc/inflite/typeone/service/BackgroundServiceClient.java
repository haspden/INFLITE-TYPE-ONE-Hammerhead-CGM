package cc.inflite.typeone.service;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

import cc.inflite.typeone.BuildConfig;
import cc.inflite.typeone.data.PreferenceData;
import cc.inflite.typeone.data.SGVData;
import cc.inflite.typeone.data.SGVServiceData;
import cc.inflite.typeone.preferences.PreferenceStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import timber.log.Timber;

public class BackgroundServiceClient {

    public static final Lazy<BackgroundServiceClient> DEFAULT = LazyKt.lazy(BackgroundServiceClient::new);

    private final ExecutorService executor;
    private SGVServiceData sgvServiceData;

    private BackgroundServiceClient() {
        executor = Executors.newSingleThreadExecutor();
        sgvServiceData = new SGVServiceData(null, Instant.EPOCH);
    }

    public SGVServiceData getSGVData(Context context) {
        SGVServiceData sgvServiceData = this.sgvServiceData;
        PreferenceData preferences = PreferenceStore.getPreferences(context);

        if (sgvServiceData == null ||
                sgvServiceData.getTimestamp() == null ||
                sgvServiceData.getTimestamp().isBefore(Instant.now().minus(Duration.ofSeconds(preferences.getUpdateFrequency()))))
        {
            executor.submit(() -> {
                try {
                    Log.i(BuildConfig.APPLICATION_ID, "Obtaining SGV data");
                    this.sgvServiceData = new SGVServiceData(obtainSGVData(preferences.getServerAddress()), Instant.now());
                } catch (Exception e) {
                    Log.e(BuildConfig.APPLICATION_ID, "Unable to obtain data in the background: " + e);
                    this.sgvServiceData = new SGVServiceData(
                            sgvServiceData != null ? sgvServiceData.getData() : null,
                            sgvServiceData != null ? sgvServiceData.getTimestamp() : null,
                            true,
                            e.getMessage());
                }
            });
        }

        return sgvServiceData;
    }

    private SGVData obtainSGVData(String serverUrl) throws Exception {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(serverUrl);
            connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                throw new IOException("Server returned code: " + connection.getResponseCode() + " for URL: " + url);
            }

            InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStream);

            Type listType = new TypeToken<ArrayList<SGVData>>(){}.getType();
            ArrayList<SGVData> sgvData = new Gson().fromJson(bufferedReader, listType);

            inputStream.close();
            connection.disconnect();

            return sgvData.get(0);
        } catch (Exception e) {
            Log.e(BuildConfig.APPLICATION_ID, "Unable to get SGV data: " + e);
            throw e;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
