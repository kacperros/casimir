package pl.casimir.casimir.persistance.shared_prefs;


public interface SharedPreferencesFacade {

    void putString(String key, String val);

    String getString(String key);

    void putObject(String key, Object object);

    <T> T getObject(String key, Class<T> object);

}
