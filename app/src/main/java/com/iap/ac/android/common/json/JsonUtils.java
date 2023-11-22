package com.iap.ac.android.common.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iap.ac.android.common.json.impl.GsonAdapter;
import com.iap.ac.android.common.log.ACLog;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsonUtils {
    public static final IJson DEFAULT_JSON_UTIL;
    public static final String NO_JSON_IMPL_MESSAGE = "Cannot find json parser. Please import gson library to your project or invoke JsonUtils.setJsonParser(IJson iJson) to set your own json parser.";
    public static final String TAG = "JsonUtils";
    public static IJson iJson;

    static {
        IJson iJson2 = new IJson() { // from class: com.iap.ac.android.common.json.JsonUtils.1
            @Override // com.iap.ac.android.common.json.IJson
            public final <T> T fromJson(String str, Class<T> cls) {
                if (JsonUtils.access$000()) {
                    return (T) GsonAdapter.gson().fromJson(str, (Class) cls);
                }
                ACLog.e(JsonUtils.TAG, JsonUtils.NO_JSON_IMPL_MESSAGE);
                return null;
            }

            @Override // com.iap.ac.android.common.json.IJson
            public final String getJsonObjectFieldAsString(String str, String str2) {
                if (JsonUtils.access$000()) {
                    JsonObject asJsonObject = new JsonParser().parse(str).getAsJsonObject();
                    if (asJsonObject == null || !asJsonObject.has(str2)) {
                        return null;
                    }
                    return asJsonObject.get(str2).toString();
                }
                ACLog.e(JsonUtils.TAG, JsonUtils.NO_JSON_IMPL_MESSAGE);
                return null;
            }

            @Override // com.iap.ac.android.common.json.IJson
            public final String toJson(Object obj) {
                if (JsonUtils.access$000()) {
                    return GsonAdapter.gson().toJson(obj);
                }
                ACLog.e(JsonUtils.TAG, JsonUtils.NO_JSON_IMPL_MESSAGE);
                return null;
            }

            @Override // com.iap.ac.android.common.json.IJson
            public final <T> T fromJson(String str, Type type) {
                if (JsonUtils.access$000()) {
                    return (T) GsonAdapter.gson().fromJson(str, type);
                }
                ACLog.e(JsonUtils.TAG, JsonUtils.NO_JSON_IMPL_MESSAGE);
                return null;
            }

            @Override // com.iap.ac.android.common.json.IJson
            public final <T> T fromJson(JSONObject jSONObject, Class<T> cls) {
                if (!JsonUtils.access$000()) {
                    ACLog.e(JsonUtils.TAG, JsonUtils.NO_JSON_IMPL_MESSAGE);
                    return null;
                } else if (jSONObject == null) {
                    return null;
                } else {
                    return (T) GsonAdapter.gson().fromJson(new JsonParser().parse(jSONObject.toString()), (Class) cls);
                }
            }
        };
        DEFAULT_JSON_UTIL = iJson2;
        iJson = iJson2;
    }

    public static /* synthetic */ boolean access$000() {
        return checkGsonExists();
    }

    public static boolean checkGsonExists() {
        try {
            return Class.forName("com.google.gson.Gson") != null;
        } catch (ClassNotFoundException e) {
            ACLog.e(TAG, "Gson library not found.", e);
            return false;
        }
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) iJson.fromJson(str, (Class) cls);
    }

    public static String getJsonObjectFieldAsString(String str, String str2) {
        return iJson.getJsonObjectFieldAsString(str, str2);
    }

    public static IJson getJsonParser() {
        return iJson;
    }

    public static void setJsonParser(IJson iJson2) {
        if (iJson2 == null) {
            return;
        }
        iJson = iJson2;
    }

    public static String toJson(Object obj) {
        return iJson.toJson(obj);
    }

    public static <T> T fromJson(String str, Type type) {
        return (T) iJson.fromJson(str, type);
    }

    public static <T> T fromJson(JSONObject jSONObject, Class<T> cls) {
        return (T) iJson.fromJson(jSONObject, cls);
    }
}
