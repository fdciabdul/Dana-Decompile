package id.dana.data.storage;

import java.util.Map;

/* loaded from: classes2.dex */
public interface PreferenceFacade {

    /* renamed from: id.dana.data.storage.PreferenceFacade$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static String $default$createKey(PreferenceFacade preferenceFacade, String str) {
            return str;
        }
    }

    Map<String, ?> all();

    void clearAllData();

    void clearData(String str);

    String createKey(String str);

    Boolean getBoolean(String str);

    Boolean getBoolean(String str, boolean z);

    Float getFloat(String str);

    Integer getInteger(String str);

    Long getLong(String str);

    <T> T getObject(String str, Class<T> cls);

    String getString(String str);

    void saveData(String str, Boolean bool);

    void saveData(String str, Float f);

    void saveData(String str, Integer num);

    void saveData(String str, Long l);

    <T> void saveData(String str, T t);

    void saveData(String str, String str2);
}
