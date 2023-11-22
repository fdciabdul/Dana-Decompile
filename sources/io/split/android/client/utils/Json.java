package io.split.android.client.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import io.split.android.client.utils.serializer.DoubleSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class Json {
    private static final Gson mJson = new GsonBuilder().serializeNulls().registerTypeAdapter(Double.class, new DoubleSerializer()).create();
    private static volatile Gson mNonNullJson;

    public static String toJson(Object obj) {
        return mJson.toJson(obj);
    }

    public static String toJsonIgnoringNulls(Object obj) {
        return getNonNullsGsonInstance().toJson(obj);
    }

    public static <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        return (T) mJson.fromJson(str, type);
    }

    public static <T> List<T> fromJsonList(String str, Class<T> cls) throws JsonSyntaxException {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<T>>() { // from class: io.split.android.client.utils.Json.1
        }.getType());
    }

    public static <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) mJson.fromJson(str, (Class) cls);
    }

    public static Map<String, Object> genericValueMapFromJson(String str, Type type) {
        Map<String, Object> map = (Map) mJson.fromJson(str, type);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if ((entry.getValue() instanceof Double) && ((Double) entry.getValue()).doubleValue() % 1.0d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                entry.setValue(Integer.valueOf(((Double) entry.getValue()).intValue()));
            }
        }
        return map;
    }

    private static Gson getNonNullsGsonInstance() {
        if (mNonNullJson == null) {
            synchronized (Json.class) {
                if (mNonNullJson == null) {
                    mNonNullJson = new GsonBuilder().registerTypeAdapter(Double.class, new DoubleSerializer()).create();
                }
            }
        }
        return mNonNullJson;
    }
}
