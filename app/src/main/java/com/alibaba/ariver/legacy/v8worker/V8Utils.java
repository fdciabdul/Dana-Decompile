package com.alibaba.ariver.legacy.v8worker;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.jsengine.v8.Releasable;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8ArrayBuffer;
import com.alipay.mobile.jsengine.v8.V8Object;
import com.alipay.mobile.jsengine.v8.V8Value;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
class V8Utils {
    static final int MAX_DEPTH = 500;
    private static final String TAG = "V8Worker";
    private static RVConfigService sConfigService;

    V8Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RVConfigService getConfigService() {
        if (sConfigService == null) {
            sConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        }
        return sConfigService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getBooleanConfig(Bundle bundle, String str, String str2, String str3, boolean z) {
        String[] split;
        if (str != null) {
            String string = BundleUtils.getString(bundle, str, null);
            if ("YES".equalsIgnoreCase(string) || "1".equals(string)) {
                return true;
            }
        }
        RVConfigService rVConfigService = sConfigService;
        if (rVConfigService != null && str2 != null && str3 != null) {
            try {
                String config = rVConfigService.getConfig(str2, "");
                if (config == null) {
                    return z;
                }
                String trim = config.trim();
                if (TextUtils.isEmpty(trim) || (split = trim.split(",")) == null) {
                    return z;
                }
                if (split.length == 1 && "*".equals(split[0])) {
                    return true;
                }
                for (String str4 : split) {
                    if (str3.equals(str4.trim())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                RVLogger.e(TAG, "getConfig exception", e);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mergeJSONArrayToSet(Set<String> set, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.size(); i++) {
                addStringToSet(set, jSONArray.getString(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addStringToSet(Set<String> set, String str) {
        String trim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(trim)) {
            return;
        }
        set.add(trim);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String makeLogMsg(Throwable th) {
        try {
            String obj = th.toString();
            int length = obj.length();
            if (length > 3000) {
                String substring = obj.substring(0, 1500);
                String substring2 = obj.substring(length - 1500);
                StringBuilder sb = new StringBuilder();
                sb.append(substring.trim());
                sb.append(" ... ");
                sb.append(substring2.trim());
                return sb.toString();
            }
            return obj;
        } catch (Throwable unused) {
            return "*** makeLogMsg :(";
        }
    }

    static boolean shouldReportJSError() {
        RVConfigService configService = getConfigService();
        if (configService != null) {
            try {
                return "1".equals(configService.getConfig("ta_v8ReportJSError", "").trim());
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject fromV8Object(Object obj) {
        if (obj != null && (obj instanceof V8Object)) {
            try {
                return (JSONObject) fromV8((V8Object) obj, 0);
            } catch (Throwable th) {
                RVLogger.e(TAG, "Exception", th);
                return null;
            }
        }
        return null;
    }

    static JSON fromV8(V8Value v8Value, int i) {
        JSONObject jSONObject = null;
        if (v8Value == null || v8Value.isUndefined()) {
            return null;
        }
        if (i >= 500) {
            throw new IllegalArgumentException("Failed to convert V8 to JSON - Exceed max depth (500)");
        }
        int i2 = 0;
        if (v8Value instanceof V8Array) {
            JSONArray jSONArray = new JSONArray();
            V8Array v8Array = (V8Array) v8Value;
            while (i2 < v8Array.length()) {
                Object obj = v8Array.get(i2);
                if (obj instanceof ByteBuffer) {
                    jSONArray.add(copyArrayBuffer(obj));
                } else if (obj instanceof V8Value) {
                    jSONArray.add(fromV8((V8Value) obj, i + 1));
                } else if (obj instanceof Double) {
                    jSONArray.add(copyNumber(obj));
                } else {
                    jSONArray.add(obj);
                }
                if (obj != null && (obj instanceof Releasable)) {
                    ((Releasable) obj).release();
                }
                i2++;
            }
            v8Array.release();
            return jSONArray;
        }
        if (v8Value instanceof V8Object) {
            jSONObject = new JSONObject();
            V8Object v8Object = (V8Object) v8Value;
            String[] keys = v8Object.getKeys();
            while (keys != null && i2 < keys.length) {
                String str = keys[i2];
                Object obj2 = v8Object.get(str);
                if (obj2 instanceof ByteBuffer) {
                    jSONObject.put(str, (Object) copyArrayBuffer(obj2));
                } else if (obj2 instanceof V8Value) {
                    jSONObject.put(str, (Object) fromV8((V8Value) obj2, i + 1));
                } else if (obj2 instanceof Double) {
                    jSONObject.put(str, copyNumber(obj2));
                } else {
                    jSONObject.put(str, obj2);
                }
                if (obj2 != null && (obj2 instanceof Releasable)) {
                    ((Releasable) obj2).release();
                }
                i2++;
            }
            v8Object.release();
        }
        return jSONObject;
    }

    static Object copyNumber(Object obj) {
        Double d = (Double) obj;
        double doubleValue = d.doubleValue();
        if (-9.223372036854776E18d >= doubleValue || doubleValue >= 9.223372036854776E18d) {
            return obj;
        }
        long longValue = d.longValue();
        return ((double) longValue) == doubleValue ? Long.valueOf(longValue) : obj;
    }

    static byte[] copyArrayBuffer(Object obj) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        byte[] bArr = new byte[byteBuffer.capacity()];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static V8Value toV8(V8 v8, Object obj) {
        Object[] objArr;
        int i = 0;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            V8Object v8Object = new V8Object(v8);
            int i2 = 0;
            while (true) {
                objArr = null;
                if (i2 >= 10) {
                    break;
                }
                try {
                    objArr = jSONObject.entrySet().toArray();
                    break;
                } catch (Throwable unused) {
                    i2++;
                }
            }
            while (objArr != null && i < objArr.length) {
                Map.Entry entry = (Map.Entry) objArr[i];
                String str = (String) entry.getKey();
                if (!TextUtils.isEmpty(str)) {
                    Object value = entry.getValue();
                    if (value == null) {
                        v8Object.addNull(str);
                    } else if (value instanceof Boolean) {
                        v8Object.add(str, ((Boolean) value).booleanValue());
                    } else if (value instanceof Float) {
                        v8Object.add(str, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        v8Object.add(str, ((Double) value).doubleValue());
                    } else if (value instanceof BigDecimal) {
                        v8Object.add(str, ((BigDecimal) value).doubleValue());
                    } else if (value instanceof Integer) {
                        v8Object.add(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        v8Object.add(str, ((Long) value).doubleValue());
                    } else if (value instanceof String) {
                        v8Object.add(str, (String) value);
                    } else if (value instanceof ByteBuffer) {
                        ByteBuffer byteBuffer = (ByteBuffer) value;
                        if (byteBuffer.isDirect()) {
                            V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v8, byteBuffer);
                            v8Object.add(str, v8ArrayBuffer);
                            v8ArrayBuffer.release();
                        } else {
                            V8ArrayBuffer v8ArrayBuffer2 = new V8ArrayBuffer(v8, byteBuffer.capacity());
                            v8ArrayBuffer2.put(byteBuffer);
                            v8Object.add(str, v8ArrayBuffer2);
                            v8ArrayBuffer2.release();
                        }
                    } else if (value instanceof byte[]) {
                        RVLogger.d(TAG, "http-request responseType is arrayBuffer");
                        byte[] bArr = (byte[]) value;
                        V8ArrayBuffer v8ArrayBuffer3 = new V8ArrayBuffer(v8, bArr.length);
                        v8ArrayBuffer3.put(bArr);
                        v8Object.add(str, v8ArrayBuffer3);
                        v8ArrayBuffer3.release();
                    } else {
                        V8Value v82 = toV8(v8, JSON.toJSON(value));
                        v8Object.add(str, v82);
                        v82.release();
                    }
                }
                i++;
            }
            return v8Object;
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            V8Array v8Array = new V8Array(v8);
            while (i < jSONArray.size()) {
                Object obj2 = jSONArray.get(i);
                if (obj2 == null) {
                    v8Array.pushNull();
                } else if (obj2 instanceof Boolean) {
                    v8Array.push((Boolean) obj2);
                } else if (obj2 instanceof Float) {
                    v8Array.push(((Float) obj2).floatValue());
                } else if (obj2 instanceof Double) {
                    v8Array.push((Double) obj2);
                } else if (obj2 instanceof BigDecimal) {
                    v8Array.push(((BigDecimal) obj2).doubleValue());
                } else if (obj2 instanceof Integer) {
                    v8Array.push((Integer) obj2);
                } else if (obj2 instanceof Long) {
                    v8Array.push(((Long) obj2).doubleValue());
                } else if (obj2 instanceof String) {
                    v8Array.push((String) obj2);
                } else if (obj2 instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) obj2;
                    if (byteBuffer2.isDirect()) {
                        V8ArrayBuffer v8ArrayBuffer4 = new V8ArrayBuffer(v8, byteBuffer2);
                        v8Array.push((V8Value) v8ArrayBuffer4);
                        v8ArrayBuffer4.release();
                    } else {
                        V8ArrayBuffer v8ArrayBuffer5 = new V8ArrayBuffer(v8, byteBuffer2.capacity());
                        v8ArrayBuffer5.put(byteBuffer2);
                        v8Array.push((V8Value) v8ArrayBuffer5);
                        v8ArrayBuffer5.release();
                    }
                } else if (obj2 instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj2;
                    V8ArrayBuffer v8ArrayBuffer6 = new V8ArrayBuffer(v8, bArr2.length);
                    v8ArrayBuffer6.put(bArr2);
                    v8Array.push((V8Value) v8ArrayBuffer6);
                    v8ArrayBuffer6.release();
                } else {
                    V8Value v83 = toV8(v8, JSON.toJSON(obj2));
                    v8Array.push(v83);
                    v83.release();
                }
                i++;
            }
            return v8Array;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to convert JSON to V8 - unsupported data: ");
            sb.append(obj);
            sb.append(", class: ");
            sb.append(obj.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static String readRawFile(Context context, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InputStream openRawResource = context.getResources().openRawResource(i);
            for (int read = openRawResource.read(); read != -1; read = openRawResource.read()) {
                byteArrayOutputStream.write(read);
            }
            openRawResource.close();
            return byteArrayOutputStream.toString();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("readRawFile error: ");
            sb.append(th);
            RVLogger.e(TAG, sb.toString());
            return null;
        }
    }
}
