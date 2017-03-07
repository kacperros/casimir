package pl.casimir.casimir.persistance.shared_prefs;


import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPreferencesFacadeImpl implements SharedPreferencesFacade {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static final String EMPTY = "not_found";

    public SharedPreferencesFacadeImpl(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public void putString(String key, String val) {
        editor = preferences.edit();
        editor.putString(key, val);
        editor.apply();
    }

    @Override
    public String getString(String key) {
        return preferences.getString(key, EMPTY);
    }

    @Override
    public void putObject(String key, Object object) {
        Gson gson = new Gson();
        putString(key, gson.toJson(object));
    }

    @Override
    public <T> T getObject(String key, Class<T> object) {
        Gson gson = new Gson();
        return gson.fromJson(preferences.getString(key, ""), object);
    }
}
