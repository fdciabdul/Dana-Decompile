package com.alibaba.griver.beehive.lottie.util;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class ParseUtils {
    private static final String TAG = "ParseUtils";

    private ParseUtils() {
    }

    public static Map<String, String> getVariableMap(Map<String, ?> map, String str) {
        if (map.containsKey(str)) {
            try {
                return (Map) JSON.parseObject((String) map.get(str), new TypeReference<HashMap<String, String>>() { // from class: com.alibaba.griver.beehive.lottie.util.ParseUtils.1
                }, new Feature[0]);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("get map value: ");
                sb.append(str);
                GriverLogger.e(TAG, sb.toString(), e);
                return null;
            }
        }
        return null;
    }

    public static String getString(Map<String, ?> map, String str, String str2) {
        if (map.containsKey(str)) {
            try {
                return (String) map.get(str);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("get string value: ");
                sb.append(str);
                GriverLogger.e(TAG, sb.toString(), e);
                return str2;
            }
        }
        return null;
    }

    public static float getFloat(Map<String, ?> map, String str, float f) {
        if (map.containsKey(str)) {
            try {
                return ((Number) map.get(str)).floatValue();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("get float value: ");
                sb.append(str);
                GriverLogger.e(TAG, sb.toString(), e);
                return f;
            }
        }
        return f;
    }

    public static boolean getBoolean(Map<String, ?> map, String str, boolean z) {
        if (map.containsKey(str)) {
            try {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    if (!TextUtils.equals("1", String.valueOf(obj))) {
                        if (!TextUtils.equals("0", String.valueOf(obj))) {
                            return Boolean.valueOf(String.valueOf(obj)).booleanValue();
                        }
                        return false;
                    }
                    return true;
                } else if (obj instanceof Integer) {
                    if (((Integer) obj).intValue() == 1) {
                        return true;
                    }
                    return false;
                } else {
                    return ((Boolean) obj).booleanValue();
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("get boolean value: ");
                sb.append(str);
                GriverLogger.e(TAG, sb.toString(), e);
                return z;
            }
        }
        return z;
    }

    public static int getInt(Map<String, ?> map, String str, int i) {
        if (map.containsKey(str)) {
            try {
                Object obj = map.get(str);
                if (obj instanceof Integer) {
                    i = ((Integer) obj).intValue();
                } else if (obj instanceof String) {
                    i = Float.valueOf((String) obj).intValue();
                } else {
                    i = ((Number) map.get(str)).intValue();
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("get int value: ");
                sb.append(str);
                GriverLogger.e(TAG, sb.toString(), e);
            }
            return i;
        }
        return i;
    }

    public static Map<String, String> getVariableMap(JSONObject jSONObject, String str) {
        if (jSONObject.containsKey(str)) {
            try {
                return (Map) JSON.parseObject(jSONObject.getString(str), new TypeReference<HashMap<String, String>>() { // from class: com.alibaba.griver.beehive.lottie.util.ParseUtils.2
                }, new Feature[0]);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("get map value: ");
                sb.append(str);
                GriverLogger.e(TAG, sb.toString(), e);
                return null;
            }
        }
        return null;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.containsKey(str) ? jSONObject.getString(str) : str2;
        } catch (Exception e) {
            GriverLogger.e(TAG, e.toString());
            return str2;
        }
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        try {
            return jSONObject.containsKey(str) ? jSONObject.getFloatValue(str) : f;
        } catch (Exception e) {
            GriverLogger.e(TAG, e.toString());
            return f;
        }
    }

    public static boolean getBoolean(JSONObject jSONObject, String str, boolean z) {
        try {
            return jSONObject.containsKey(str) ? jSONObject.getBooleanValue(str) : z;
        } catch (Exception e) {
            GriverLogger.e(TAG, e.toString());
            return z;
        }
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        try {
            return jSONObject.containsKey(str) ? jSONObject.getIntValue(str) : i;
        } catch (Exception e) {
            GriverLogger.e(TAG, e.toString());
            return i;
        }
    }
}
