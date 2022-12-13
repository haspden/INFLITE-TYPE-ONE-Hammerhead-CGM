package cc.inflite.typeone.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.frybits.harmony.Harmony;

import cc.inflite.typeone.BuildConfig;
import cc.inflite.typeone.data.PreferenceData;

public class PreferenceStore {

    private static final String PREFERENCE_NAME = BuildConfig.APPLICATION_ID + ".Preferences";
    private static final String KEY_SERVER_ADDRESS = "ServerAddress";
    private static final String KEY_UPDATE_FREQUENCY = "UpdateFrequency";

    private static final String DEFAULT_SERVER_ADDRESS = "https://yoursubdomain.herokuapp.com/api/v1/entries/sgv.json";
    private static final int DEFAULT_UPDATE_FREQUENCY = 5;

    @NonNull
    public static PreferenceData getPreferences(@NonNull Context context) {
        SharedPreferences sharedPreferences = Harmony.getSharedPreferences(context, PREFERENCE_NAME);
        return new PreferenceData(
                sharedPreferences.getString(KEY_SERVER_ADDRESS, DEFAULT_SERVER_ADDRESS),
                sharedPreferences.getInt(KEY_UPDATE_FREQUENCY, DEFAULT_UPDATE_FREQUENCY));

    }

    public static void savePreferences(@NonNull Context context, @NonNull PreferenceData preferenceData) {
        SharedPreferences sharedPreferences = Harmony.getSharedPreferences(context, PREFERENCE_NAME);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SERVER_ADDRESS, preferenceData.getServerAddress());
        editor.putInt(KEY_UPDATE_FREQUENCY, preferenceData.getUpdateFrequency());
        editor.apply();
    }

}
