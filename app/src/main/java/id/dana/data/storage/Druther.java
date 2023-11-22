package id.dana.data.storage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import java.util.Map;

/* loaded from: classes4.dex */
public class Druther implements PreferenceFacade {
    private final LocalStorageFactory.Builder builder;
    private SharedPreferences sharedPreferences;

    @Override // id.dana.data.storage.PreferenceFacade
    public /* synthetic */ String createKey(String str) {
        return PreferenceFacade.CC.$default$createKey(this, str);
    }

    public Druther(LocalStorageFactory.Builder builder) {
        this.builder = builder;
        if (TextUtils.isEmpty(builder.password)) {
            this.sharedPreferences = builder.context.getSharedPreferences(builder.preferenceGroup, 0);
        } else {
            SecurePreferenceExceptionKt.setException();
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, String str2) {
        this.sharedPreferences.edit().putString(createKey(str), str2).apply();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public String getString(String str) {
        return this.sharedPreferences.getString(createKey(str), null);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, Integer num) {
        this.sharedPreferences.edit().putInt(createKey(str), num.intValue()).apply();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Integer getInteger(String str) {
        return Integer.valueOf(this.sharedPreferences.getInt(createKey(str), -1));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, Long l) {
        this.sharedPreferences.edit().putLong(createKey(str), l.longValue()).apply();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Long getLong(String str) {
        return Long.valueOf(this.sharedPreferences.getLong(createKey(str), -1L));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, Float f) {
        this.sharedPreferences.edit().putFloat(createKey(str), f.floatValue()).apply();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Float getFloat(String str) {
        return Float.valueOf(this.sharedPreferences.getFloat(createKey(str), -1.0f));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, Boolean bool) {
        this.sharedPreferences.edit().putBoolean(createKey(str), bool.booleanValue()).apply();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Boolean getBoolean(String str) {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(createKey(str), false));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Boolean getBoolean(String str, boolean z) {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(createKey(str), z));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public <T> void saveData(String str, T t) {
        saveData(str, this.builder.serializerFacade.serialize(t));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public <T> T getObject(String str, Class<T> cls) {
        return (T) this.builder.serializerFacade.deserialize(getString(str), cls);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void clearData(String str) {
        this.sharedPreferences.edit().remove(createKey(str)).apply();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void clearAllData() {
        this.sharedPreferences.edit().clear().apply();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Map<String, ?> all() {
        return this.sharedPreferences.getAll();
    }
}
