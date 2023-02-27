package cc.inflite.typeone.preferences;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import cc.inflite.typeone.BuildConfig;
import cc.inflite.typeone.data.PreferenceData;
import io.hammerhead.sdk.v0.KeyValueStore;
import io.hammerhead.sdk.v0.SdkContext;

public class PreferenceStore {

    private static final String KEY_SERVER_ADDRESS = "ServerAddress";
    private static final String KEY_UPDATE_FREQUENCY = "UpdateFrequency";
    private static final String KEY_API_SECRET = "ApiSecret";

    private static final String DEFAULT_SERVER_ADDRESS = "https://haspdenbloodglucose.herokuapp.com/api/v1/entries/sgv.json";
    private static final int DEFAULT_UPDATE_FREQUENCY = 30;
    private static final String DEFAULT_API_SECRET = "";

    @NonNull
    public static PreferenceData getPreferences(@NonNull SdkContext sdkContext) {
        try {
            KeyValueStore keyValueStore = sdkContext.getKeyValueStore();
            String serverAddress = keyValueStore.getString(KEY_SERVER_ADDRESS);
            String updateIntervalString = keyValueStore.getString(KEY_UPDATE_FREQUENCY);
            String apiSecret = keyValueStore.getString(KEY_API_SECRET);

            if (serverAddress == null) {
                serverAddress = DEFAULT_SERVER_ADDRESS;
            }

            int updateInterval = DEFAULT_UPDATE_FREQUENCY;
            if (updateIntervalString != null) {
                updateInterval = Integer.parseInt(updateIntervalString);
            }

            if (apiSecret == null) {
                apiSecret = DEFAULT_API_SECRET;
            }

            return new PreferenceData(serverAddress, updateInterval, apiSecret);
        } catch (Exception e) {
            Log.e(BuildConfig.APPLICATION_ID, "Unable to get preferences", e);
        }

        return new PreferenceData(DEFAULT_SERVER_ADDRESS, DEFAULT_UPDATE_FREQUENCY, DEFAULT_API_SECRET);
    }

    @NonNull
    public static PreferenceData getPreferences(@NonNull Context context) {
        return getPreferences(SdkContext.buildSdkContext(context));
    }

    public static void savePreferences(@NonNull Context context, @NonNull PreferenceData preferenceData) {
        try {
            SdkContext sdkContext = SdkContext.buildSdkContext(context);
            KeyValueStore keyValueStore = sdkContext.getKeyValueStore();
            keyValueStore.putString(KEY_SERVER_ADDRESS, preferenceData.getServerAddress());
            keyValueStore.putString(KEY_UPDATE_FREQUENCY, String.valueOf(preferenceData.getUpdateFrequency()));
            keyValueStore.putString(KEY_API_SECRET, preferenceData.getApiSecret());
            Log.d(BuildConfig.APPLICATION_ID, "Saved preferences");
        } catch (Exception e) {
            Log.e(BuildConfig.APPLICATION_ID, "Unable to save preferences", e);
        }
    }

}
