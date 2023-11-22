package com.alibaba.ariver.v8worker;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.js.Arguments;
import com.alibaba.jsi.standard.js.JSArray;
import com.alibaba.jsi.standard.js.JSArrayBuffer;
import com.alibaba.jsi.standard.js.JSBoolean;
import com.alibaba.jsi.standard.js.JSBooleanObject;
import com.alibaba.jsi.standard.js.JSNumber;
import com.alibaba.jsi.standard.js.JSNumberObject;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSString;
import com.alibaba.jsi.standard.js.JSStringObject;
import com.alibaba.jsi.standard.js.JSValue;
import com.alibaba.jsi.standard.js.JSVoid;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes6.dex */
public class V8Utils {
    static final int MAX_DEPTH = 500;
    private static final String TAG = "V8Worker_JSI";
    private static RVConfigService sConfigService;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RVConfigService getConfigService() {
        if (sConfigService == null) {
            sConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        }
        return sConfigService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getConfig(String str, String str2) {
        try {
            String config = getConfigService().getConfig(str, null);
            return !TextUtils.isEmpty(config) ? config : str2;
        } catch (Exception e) {
            RVLogger.e(TAG, "getConfigForAB exception", e);
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getBooleanConfig(String str, boolean z) {
        try {
            String config = getConfigService().getConfig(str, null);
            return TextUtils.isEmpty(config) ? z : trueify(config);
        } catch (Exception e) {
            RVLogger.e(TAG, "getBooleanConfig exception", e);
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntConfig(String str, int i) {
        try {
            String config = getConfigService().getConfig(str, null);
            return TextUtils.isEmpty(config) ? i : Integer.valueOf(config.trim()).intValue();
        } catch (Exception e) {
            RVLogger.e(TAG, "getIntConfig exception", e);
            return i;
        }
    }

    static boolean getBooleanConfig(Bundle bundle, String str, String str2, String str3, boolean z) {
        String[] split;
        if (str != null) {
            String string = BundleUtils.getString(bundle, str, null);
            if ("YES".equalsIgnoreCase(string) || "1".equals(string)) {
                return true;
            }
        }
        if (getConfigService() != null && str2 != null && str3 != null) {
            try {
                String config = getConfigService().getConfig(str2, "");
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

    static boolean isInnerApp(App app) {
        try {
            TinyAppInnerProxy tinyAppInnerProxy = (TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class);
            if (tinyAppInnerProxy != null) {
                return tinyAppInnerProxy.isInner(app);
            }
            return false;
        } catch (Throwable th) {
            RVLogger.e(TAG, th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b A[Catch: Exception -> 0x007b, TRY_LEAVE, TryCatch #0 {Exception -> 0x007b, blocks: (B:6:0x000a, B:9:0x0016, B:12:0x0021, B:15:0x002a, B:17:0x002f, B:20:0x003a, B:22:0x0040, B:27:0x004a, B:31:0x0057, B:35:0x0064, B:37:0x006b), top: B:44:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isAppInList(java.lang.String r5, com.alibaba.ariver.app.api.App r6, boolean r7) {
        /*
            com.alibaba.ariver.kernel.common.service.RVConfigService r0 = getConfigService()
            if (r0 == 0) goto L83
            if (r5 == 0) goto L83
            if (r6 == 0) goto L83
            com.alibaba.ariver.kernel.common.service.RVConfigService r0 = getConfigService()     // Catch: java.lang.Exception -> L7b
            r1 = 0
            java.lang.String r5 = r0.getConfig(r5, r1)     // Catch: java.lang.Exception -> L7b
            if (r5 != 0) goto L16
            return r7
        L16:
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Exception -> L7b
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L7b
            if (r0 == 0) goto L21
            return r7
        L21:
            java.lang.String r0 = ","
            java.lang.String[] r5 = r5.split(r0)     // Catch: java.lang.Exception -> L7b
            if (r5 != 0) goto L2a
            return r7
        L2a:
            int r0 = r5.length     // Catch: java.lang.Exception -> L7b
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L3a
            java.lang.String r0 = "*"
            r3 = r5[r1]     // Catch: java.lang.Exception -> L7b
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Exception -> L7b
            if (r0 == 0) goto L3a
            return r2
        L3a:
            boolean r0 = com.alibaba.ariver.kernel.common.utils.ProcessUtils.isMainProcess()     // Catch: java.lang.Exception -> L7b
            if (r0 != 0) goto L49
            boolean r0 = isInnerApp(r6)     // Catch: java.lang.Exception -> L7b
            if (r0 == 0) goto L47
            goto L49
        L47:
            r0 = 0
            goto L4a
        L49:
            r0 = 1
        L4a:
            java.lang.String r3 = "inner"
            r4 = r5[r1]     // Catch: java.lang.Exception -> L7b
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> L7b
            if (r3 == 0) goto L57
            if (r0 == 0) goto L57
            return r2
        L57:
            java.lang.String r3 = "outer"
            r4 = r5[r1]     // Catch: java.lang.Exception -> L7b
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> L7b
            if (r3 == 0) goto L64
            if (r0 != 0) goto L64
            return r2
        L64:
            java.lang.String r6 = r6.getAppId()     // Catch: java.lang.Exception -> L7b
            int r0 = r5.length     // Catch: java.lang.Exception -> L7b
        L69:
            if (r1 >= r0) goto L83
            r3 = r5[r1]     // Catch: java.lang.Exception -> L7b
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Exception -> L7b
            boolean r3 = r6.equals(r3)     // Catch: java.lang.Exception -> L7b
            if (r3 == 0) goto L78
            return r2
        L78:
            int r1 = r1 + 1
            goto L69
        L7b:
            r5 = move-exception
            java.lang.String r6 = "V8Worker_JSI"
            java.lang.String r0 = "getConfigForAB exception"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r6, r0, r5)
        L83:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.V8Utils.isAppInList(java.lang.String, com.alibaba.ariver.app.api.App, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAppIdInList(String str, String str2, boolean z) {
        String[] split;
        if (getConfigService() != null && str != null && str2 != null) {
            try {
                String config = getConfigService().getConfig(str, null);
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
                for (String str3 : split) {
                    if (str2.equals(str3.trim())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                RVLogger.e(TAG, "getConfigForAB exception", e);
            }
        }
        return z;
    }

    public static boolean RVAGetSwitch(String str, String str2, boolean z) {
        JSONObject parseObject;
        try {
            String config = getConfig(str, null);
            if (TextUtils.isEmpty(config) || (parseObject = JSONUtils.parseObject(config)) == null) {
                return z;
            }
            JSONArray jSONArray = JSONUtils.getJSONArray(parseObject, "blacklist", null);
            if (jSONArray == null || !jSONArray.contains(str2)) {
                JSONArray jSONArray2 = JSONUtils.getJSONArray(parseObject, "whitelist", null);
                if (jSONArray2 == null || !jSONArray2.contains(str2)) {
                    return JSONUtils.getBoolean(parseObject, "switch", true);
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            RVLogger.e(TAG, "RVAGetSwitch exception", e);
            return z;
        }
    }

    public static boolean isSupportNonIsolatedMode(App app) {
        if (RVAGetSwitch("ta_disableAppContextIsolateSwitch", app.getAppId(), true)) {
            try {
                AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make("YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "appxRouteFramework")) ? "68687209" : "66666692"));
                if (appModel != null && appModel.getExtendInfos() != null) {
                    return JSONUtils.getBoolean(JSONUtils.getJSONObject(appModel.getExtendInfos(), RVConstants.EXTRA_RES_LAUNCH_PARAMS, null), "isAppxSupportNonIsolatedMode", false);
                }
            } catch (Exception e) {
                RVLogger.e(TAG, "isSupportNonIsolatedMode exception", e);
            }
        }
        return false;
    }

    public static boolean trueify(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        return "YES".equalsIgnoreCase(trim) || "TRUE".equalsIgnoreCase(trim) || "1".equals(trim);
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

    public static String makeLogMsg(String str) {
        int length = str.length();
        if (length > 3000) {
            String substring = str.substring(0, 1500);
            String substring2 = str.substring(length - 1500);
            StringBuilder sb = new StringBuilder();
            sb.append(substring.trim());
            sb.append(" ... ");
            sb.append(substring2.trim());
            return sb.toString();
        }
        return str;
    }

    public static String makeLogMsg(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = th.toString();
        }
        return makeLogMsg(message);
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

    public static boolean isSerializableObject(Object obj) {
        Object value;
        if ((obj instanceof ByteBuffer) || (obj instanceof byte[])) {
            return false;
        }
        if (obj == null) {
            return true;
        }
        if (obj instanceof JSONObject) {
            for (Map.Entry<String, Object> entry : ((JSONObject) obj).entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && !isSerializableObject(value)) {
                    return false;
                }
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.size(); i++) {
                if (!isSerializableObject(jSONArray.get(i))) {
                    return false;
                }
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                if (entry2.getKey() != null && !isSerializableObject(entry2.getValue())) {
                    return false;
                }
            }
        } else if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                if (!isSerializableObject(it.next())) {
                    return false;
                }
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                if (!isSerializableObject(Array.get(obj, i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static JSONObject fromJsApiArgs(Arguments arguments) {
        JSONObject jSONObject;
        JSONObject fromV8Object;
        JSValue jSValue = arguments.get(2);
        if (jSValue == null) {
            return null;
        }
        String jSValue2 = jSValue.toString(arguments.getContext());
        jSValue.delete();
        JSONObject parseObject = JSONUtils.parseObject(jSValue2);
        JSValue jSValue3 = arguments.get(3);
        if (jSValue3 != null && !jSValue3.isVoid() && (jSONObject = JSONUtils.getJSONObject(parseObject, "data", null)) != null && (fromV8Object = fromV8Object(jSValue3, arguments.getContext())) != null) {
            jSONObject.putAll(fromV8Object);
        }
        if (jSValue3 != null) {
            jSValue3.delete();
        }
        return parseObject;
    }

    public static JSONObject copyJSONObject(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject2.put(key, copyObject(entry.getValue()));
                }
            }
            return jSONObject2;
        } catch (Throwable th) {
            RVLogger.e(TAG, "copyJSONObject exception", th);
            return jSONObject;
        }
    }

    private static Object copyObject(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof byte[]) || (obj instanceof ByteBuffer)) {
            return obj;
        }
        if (obj instanceof JSONObject) {
            return copyJSONObject((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return copyJSONArray((JSONArray) obj);
        }
        if (obj instanceof Map) {
            return copyMap((Map) obj);
        }
        if (obj instanceof Collection) {
            return copyCollection((Collection) obj);
        }
        return obj.getClass().isArray() ? copyArray(obj) : obj;
    }

    private static JSONArray copyJSONArray(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.size(); i++) {
            jSONArray2.add(copyObject(jSONArray.get(i)));
        }
        return jSONArray2;
    }

    private static JSONObject copyMap(Map<Object, Object> map) {
        int size = map.size();
        JSONObject jSONObject = new JSONObject(map instanceof LinkedHashMap ? new LinkedHashMap(size) : map instanceof TreeMap ? new TreeMap() : new HashMap(size));
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key != null) {
                jSONObject.put(key.toString(), copyObject(entry.getValue()));
            }
        }
        return jSONObject;
    }

    private static JSONArray copyCollection(Collection<Object> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Object> it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.add(copyObject(it.next()));
        }
        return jSONArray;
    }

    private static JSONArray copyArray(Object obj) {
        int length = Array.getLength(obj);
        JSONArray jSONArray = new JSONArray(length);
        for (int i = 0; i < length; i++) {
            jSONArray.add(copyObject(Array.get(obj, i)));
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject fromV8Object(JSValue jSValue, JSContext jSContext) {
        if (jSValue == null || jSValue.isVoid()) {
            return null;
        }
        try {
            return (JSONObject) fromV8(jSValue, jSContext, 0);
        } catch (Throwable th) {
            RVLogger.e(TAG, "Exception", th);
            return null;
        }
    }

    static JSON fromV8(JSValue jSValue, JSContext jSContext, int i) {
        if (jSValue == null || jSValue.isVoid()) {
            return null;
        }
        if (i >= 500) {
            throw new IllegalArgumentException("Failed to convert V8 to JSON - Exceed max depth (500)");
        }
        int i2 = 0;
        if (jSValue.isArray()) {
            JSONArray jSONArray = new JSONArray();
            JSArray jSArray = (JSArray) jSValue;
            while (i2 < jSArray.length(jSContext)) {
                JSValue jSValue2 = jSArray.get(jSContext, i2);
                if (jSValue2.isBoolean()) {
                    jSONArray.add(Boolean.valueOf(copyBoolean((JSBoolean) jSValue2)));
                } else if (jSValue2.isBooleanObject()) {
                    jSONArray.add(Boolean.valueOf(copyBooleanObject((JSBooleanObject) jSValue2, jSContext)));
                } else if (jSValue2.isNumber()) {
                    jSONArray.add(copyNumber((JSNumber) jSValue2));
                } else if (jSValue2.isNumberObject()) {
                    jSONArray.add(copyNumberObject((JSNumberObject) jSValue2, jSContext));
                } else if (jSValue2.isString()) {
                    jSONArray.add(copyString((JSString) jSValue2));
                } else if (jSValue2.isStringObject()) {
                    jSONArray.add(copyStringObject((JSStringObject) jSValue2, jSContext));
                } else if (jSValue2.isArrayBuffer()) {
                    jSONArray.add(copyArrayBuffer(jSContext, (JSArrayBuffer) jSValue2));
                } else if (jSValue2.isVoid()) {
                    jSONArray.add(null);
                } else if (!jSValue2.isFunction() && (jSValue2.isArray() || jSValue2.isJSObject())) {
                    jSONArray.add(fromV8(jSValue2, jSContext, i + 1));
                }
                jSValue2.delete();
                i2++;
            }
            jSArray.delete();
            return jSONArray;
        } else if (jSValue.isJSObject()) {
            JSONObject jSONObject = new JSONObject();
            JSObject jSObject = (JSObject) jSValue;
            JSArray ownPropertyNames = jSObject.getOwnPropertyNames(jSContext, 2L);
            while (ownPropertyNames != null && i2 < ownPropertyNames.length(jSContext)) {
                JSValue jSValue3 = ownPropertyNames.get(jSContext, i2);
                JSValue jSValue4 = jSObject.get(jSContext, jSValue3);
                String jSValue5 = jSValue3.toString(jSContext);
                if (jSValue4.isBoolean()) {
                    jSONObject.put(jSValue5, (Object) Boolean.valueOf(copyBoolean((JSBoolean) jSValue4)));
                } else if (jSValue4.isBooleanObject()) {
                    jSONObject.put(jSValue5, (Object) Boolean.valueOf(copyBooleanObject((JSBooleanObject) jSValue4, jSContext)));
                } else if (jSValue4.isNumber()) {
                    jSONObject.put(jSValue5, copyNumber((JSNumber) jSValue4));
                } else if (jSValue4.isNumberObject()) {
                    jSONObject.put(jSValue5, copyNumberObject((JSNumberObject) jSValue4, jSContext));
                } else if (jSValue4.isString()) {
                    jSONObject.put(jSValue5, (Object) copyString((JSString) jSValue4));
                } else if (jSValue4.isStringObject()) {
                    jSONObject.put(jSValue5, (Object) copyStringObject((JSStringObject) jSValue4, jSContext));
                } else if (jSValue4.isArrayBuffer()) {
                    jSONObject.put(jSValue5, (Object) copyArrayBuffer(jSContext, (JSArrayBuffer) jSValue4));
                } else if (jSValue4.isVoid() && !((JSVoid) jSValue4).isUndefined()) {
                    jSONObject.put(jSValue5, (Object) null);
                } else if (!jSValue4.isFunction() && (jSValue4.isArray() || jSValue4.isJSObject())) {
                    jSONObject.put(jSValue5, (Object) fromV8(jSValue4, jSContext, i + 1));
                }
                if (jSValue4 != null) {
                    jSValue4.delete();
                }
                if (jSValue3 != null) {
                    jSValue3.delete();
                }
                i2++;
            }
            if (jSObject != null) {
                jSObject.delete();
            }
            if (ownPropertyNames != null) {
                ownPropertyNames.delete();
            }
            return jSONObject;
        } else {
            return null;
        }
    }

    static boolean copyBoolean(JSBoolean jSBoolean) {
        return jSBoolean.valueOf();
    }

    static boolean copyBooleanObject(JSBooleanObject jSBooleanObject, JSContext jSContext) {
        return jSBooleanObject.valueOf(jSContext);
    }

    static String copyString(JSString jSString) {
        return jSString.valueOf();
    }

    static String copyStringObject(JSStringObject jSStringObject, JSContext jSContext) {
        return jSStringObject.valueOf(jSContext);
    }

    static Object copyNumber(JSNumber jSNumber) {
        Double valueOf = Double.valueOf(jSNumber.valueOf());
        double doubleValue = valueOf.doubleValue();
        if (-2.147483648E9d < doubleValue && doubleValue < 2.147483647E9d) {
            int intValue = valueOf.intValue();
            if (intValue == doubleValue) {
                return Integer.valueOf(intValue);
            }
        }
        if (-9.223372036854776E18d >= doubleValue || doubleValue >= 9.223372036854776E18d) {
            return valueOf;
        }
        long longValue = valueOf.longValue();
        return ((double) longValue) == doubleValue ? Long.valueOf(longValue) : valueOf;
    }

    static Object copyNumberObject(JSNumberObject jSNumberObject, JSContext jSContext) {
        Double valueOf = Double.valueOf(jSNumberObject.valueOf(jSContext));
        double doubleValue = valueOf.doubleValue();
        if (-2.147483648E9d < doubleValue && doubleValue < 2.147483647E9d) {
            int intValue = valueOf.intValue();
            if (intValue == doubleValue) {
                return Integer.valueOf(intValue);
            }
        }
        if (-9.223372036854776E18d >= doubleValue || doubleValue >= 9.223372036854776E18d) {
            return valueOf;
        }
        long longValue = valueOf.longValue();
        return ((double) longValue) == doubleValue ? Long.valueOf(longValue) : valueOf;
    }

    static byte[] copyArrayBuffer(JSContext jSContext, JSArrayBuffer jSArrayBuffer) {
        ByteBuffer data = jSArrayBuffer.data(jSContext);
        byte[] bArr = new byte[data.capacity()];
        data.get(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSValue toV8(JSContext jSContext, Object obj) {
        if (obj instanceof JSONObject) {
            JSObject jSObject = new JSObject(jSContext);
            Object[] array = ((JSONObject) obj).entrySet().toArray();
            for (int i = 0; array != null && i < array.length; i++) {
                Map.Entry entry = (Map.Entry) array[i];
                String str = (String) entry.getKey();
                if (!TextUtils.isEmpty(str)) {
                    Object value = entry.getValue();
                    if (value == null) {
                        JSVoid jSVoid = new JSVoid(false);
                        jSObject.set(jSContext, str, jSVoid);
                        jSVoid.delete();
                    } else if (value instanceof Boolean) {
                        JSBoolean jSBoolean = new JSBoolean(((Boolean) value).booleanValue());
                        jSObject.set(jSContext, str, jSBoolean);
                        jSBoolean.delete();
                    } else if (value instanceof Float) {
                        JSNumber jSNumber = new JSNumber(((Float) value).doubleValue());
                        jSObject.set(jSContext, str, jSNumber);
                        jSNumber.delete();
                    } else if (value instanceof Double) {
                        JSNumber jSNumber2 = new JSNumber(((Double) value).doubleValue());
                        jSObject.set(jSContext, str, jSNumber2);
                        jSNumber2.delete();
                    } else if (value instanceof BigDecimal) {
                        JSNumber jSNumber3 = new JSNumber(((BigDecimal) value).doubleValue());
                        jSObject.set(jSContext, str, jSNumber3);
                        jSNumber3.delete();
                    } else if (value instanceof Integer) {
                        JSNumber jSNumber4 = new JSNumber(((Integer) value).intValue());
                        jSObject.set(jSContext, str, jSNumber4);
                        jSNumber4.delete();
                    } else if (value instanceof Long) {
                        JSNumber jSNumber5 = new JSNumber(((Long) value).doubleValue());
                        jSObject.set(jSContext, str, jSNumber5);
                        jSNumber5.delete();
                    } else if (value instanceof String) {
                        JSString jSString = new JSString((String) value);
                        jSObject.set(jSContext, str, jSString);
                        jSString.delete();
                    } else if (value instanceof ByteBuffer) {
                        ByteBuffer byteBuffer = (ByteBuffer) value;
                        if (byteBuffer.isDirect()) {
                            JSArrayBuffer jSArrayBuffer = new JSArrayBuffer(jSContext, 0, byteBuffer);
                            jSObject.set(jSContext, str, jSArrayBuffer);
                            jSArrayBuffer.delete();
                        } else {
                            JSArrayBuffer jSArrayBuffer2 = new JSArrayBuffer(jSContext, 0, byteBuffer.capacity());
                            jSArrayBuffer2.data(jSContext).put(byteBuffer.array());
                            jSObject.set(jSContext, str, jSArrayBuffer2);
                            jSArrayBuffer2.delete();
                        }
                    } else if (value instanceof byte[]) {
                        byte[] bArr = (byte[]) value;
                        JSArrayBuffer jSArrayBuffer3 = new JSArrayBuffer(jSContext, 0, bArr.length);
                        jSArrayBuffer3.data(jSContext).put(bArr);
                        jSObject.set(jSContext, str, jSArrayBuffer3);
                        jSArrayBuffer3.delete();
                    } else {
                        JSValue v8 = toV8(jSContext, JSON.toJSON(value));
                        jSObject.set(jSContext, str, v8);
                        v8.delete();
                    }
                }
            }
            return jSObject;
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            JSArray jSArray = new JSArray(jSContext);
            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                Object obj2 = jSONArray.get(i2);
                if (obj2 == null) {
                    JSVoid jSVoid2 = new JSVoid(false);
                    jSArray.set(jSContext, i2, jSVoid2);
                    jSVoid2.delete();
                } else if (obj2 instanceof Boolean) {
                    JSBoolean jSBoolean2 = new JSBoolean(((Boolean) obj2).booleanValue());
                    jSArray.set(jSContext, i2, jSBoolean2);
                    jSBoolean2.delete();
                } else if (obj2 instanceof Float) {
                    JSNumber jSNumber6 = new JSNumber(((Float) obj2).doubleValue());
                    jSArray.set(jSContext, i2, jSNumber6);
                    jSNumber6.delete();
                } else if (obj2 instanceof Double) {
                    JSNumber jSNumber7 = new JSNumber(((Double) obj2).doubleValue());
                    jSArray.set(jSContext, i2, jSNumber7);
                    jSNumber7.delete();
                } else if (obj2 instanceof BigDecimal) {
                    JSNumber jSNumber8 = new JSNumber(((BigDecimal) obj2).doubleValue());
                    jSArray.set(jSContext, i2, jSNumber8);
                    jSNumber8.delete();
                } else if (obj2 instanceof Integer) {
                    JSNumber jSNumber9 = new JSNumber(((Integer) obj2).intValue());
                    jSArray.set(jSContext, i2, jSNumber9);
                    jSNumber9.delete();
                } else if (obj2 instanceof Long) {
                    JSNumber jSNumber10 = new JSNumber(((Long) obj2).doubleValue());
                    jSArray.set(jSContext, i2, jSNumber10);
                    jSNumber10.delete();
                } else if (obj2 instanceof String) {
                    JSString jSString2 = new JSString((String) obj2);
                    jSArray.set(jSContext, i2, jSString2);
                    jSString2.delete();
                } else if (obj2 instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) obj2;
                    if (byteBuffer2.isDirect()) {
                        JSArrayBuffer jSArrayBuffer4 = new JSArrayBuffer(jSContext, 0, byteBuffer2);
                        jSArray.set(jSContext, i2, jSArrayBuffer4);
                        jSArrayBuffer4.delete();
                    } else {
                        JSArrayBuffer jSArrayBuffer5 = new JSArrayBuffer(jSContext, 0, byteBuffer2.capacity());
                        jSArrayBuffer5.data(jSContext).put(byteBuffer2.array());
                        jSArray.set(jSContext, i2, jSArrayBuffer5);
                        jSArrayBuffer5.delete();
                    }
                } else if (obj2 instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj2;
                    JSArrayBuffer jSArrayBuffer6 = new JSArrayBuffer(jSContext, 0, bArr2.length);
                    jSArrayBuffer6.data(jSContext).put(bArr2);
                    jSArray.set(jSContext, i2, jSArrayBuffer6);
                    jSArrayBuffer6.delete();
                } else {
                    JSValue v82 = toV8(jSContext, JSON.toJSON(obj2));
                    jSArray.set(jSContext, i2, v82);
                    v82.delete();
                }
            }
            return jSArray;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to convert JSON to V8 - unsupported data: ");
            sb.append(obj);
            sb.append(", class: ");
            sb.append(obj.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static String argsToString(Arguments arguments) {
        int count = arguments.count();
        JSContext context = arguments.getContext();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(count);
        sb.append("] {");
        String obj = sb.toString();
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(", ");
                obj = sb2.toString();
            }
            JSValue jSValue = arguments.get(i);
            if (jSValue != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj);
                sb3.append(jSValue.toString(context));
                obj = sb3.toString();
                jSValue.delete();
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(obj);
                sb4.append("(null)");
                obj = sb4.toString();
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(obj);
        sb5.append("}");
        return sb5.toString();
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

    public static boolean startsWithIgnoreCase(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length < length2) {
            return false;
        }
        if (length == length2) {
            return str.equalsIgnoreCase(str2);
        }
        return str.substring(0, length2).equalsIgnoreCase(str2);
    }

    public static String deltaString(long j, long j2) {
        return String.valueOf(j2 - j);
    }
}
