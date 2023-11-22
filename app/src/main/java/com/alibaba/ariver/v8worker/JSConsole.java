package com.alibaba.ariver.v8worker;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.js.Arguments;
import com.alibaba.jsi.standard.js.JSBoolean;
import com.alibaba.jsi.standard.js.JSCallback;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSNumber;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSValue;

/* loaded from: classes6.dex */
public class JSConsole {
    private static final String TAG = "JSConsole";
    private static JSONObject limitJson;

    static /* synthetic */ boolean access$000() {
        return jsConsoleInvokeCallback();
    }

    static /* synthetic */ int access$200() {
        return getMaxLength();
    }

    public static String concat(Arguments arguments) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arguments.count(); i++) {
            JSValue jSValue = arguments.get(i);
            String jSValue2 = jSValue.toString(arguments.getContext());
            jSValue.delete();
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(jSValue2);
        }
        return sb.toString();
    }

    public static void setup(JSContext jSContext, final JSConsoleCallback jSConsoleCallback, final String str) {
        if (jSContext == null || jSContext.isDisposed()) {
            return;
        }
        JSObject globalObject = jSContext.globalObject();
        JSFunction jSFunction = new JSFunction(jSContext, new JSCallback() { // from class: com.alibaba.ariver.v8worker.JSConsole.1
            @Override // com.alibaba.jsi.standard.js.JSCallback
            public final JSValue onCallFunction(Arguments arguments) {
                try {
                    String concat = JSConsole.concat(arguments);
                    RVLogger.d(JSConsole.TAG, concat);
                    if (JSConsoleCallback.this != null && JSConsole.access$000()) {
                        JSConsoleCallback.this.onConsoleMessage(concat);
                    }
                    return null;
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("__nativeLog__ onCallFunction error: ");
                    sb.append(th);
                    RVLogger.e(JSConsole.TAG, sb.toString());
                    return null;
                }
            }
        }, "__nativeLog__");
        globalObject.set(jSContext, "__nativeLog__", jSFunction);
        jSFunction.delete();
        JSFunction jSFunction2 = new JSFunction(jSContext, new JSCallback() { // from class: com.alibaba.ariver.v8worker.JSConsole.2
            @Override // com.alibaba.jsi.standard.js.JSCallback
            public final JSValue onCallFunction(Arguments arguments) {
                try {
                    return new JSBoolean(JSConsole.isBanLog(str));
                } catch (Throwable th) {
                    RVLogger.e(JSConsole.TAG, "__nativeBanLog__ onCallFunction error: ", th);
                    return null;
                }
            }
        }, "__nativeBanLog__");
        globalObject.set(jSContext, "__nativeBanLog__", jSFunction2);
        jSFunction2.delete();
        JSFunction jSFunction3 = new JSFunction(jSContext, new JSCallback() { // from class: com.alibaba.ariver.v8worker.JSConsole.3
            @Override // com.alibaba.jsi.standard.js.JSCallback
            public final JSValue onCallFunction(Arguments arguments) {
                try {
                    return new JSNumber(JSConsole.access$200());
                } catch (Throwable th) {
                    RVLogger.e(JSConsole.TAG, "__nativeBanLog__ onCallFunction error: ", th);
                    return null;
                }
            }
        }, "__nativeLimitLogSize__");
        globalObject.set(jSContext, "__nativeLimitLogSize__", jSFunction3);
        jSFunction3.delete();
        globalObject.delete();
    }

    private static boolean jsConsoleInvokeCallback() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null) {
            return "yes".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("ta_jsConsoleCallback", "yes"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isBanLog(String str) {
        String string;
        initConfigJson();
        JSONObject jSONObject = limitJson;
        if (jSONObject == null || (string = jSONObject.getString("all")) == null || string.equals("")) {
            return false;
        }
        boolean equalsIgnoreCase = string.equalsIgnoreCase("YES");
        JSONArray jSONArray = limitJson.getJSONArray("blacklist");
        if (equalsIgnoreCase) {
            if (jSONArray == null || jSONArray.size() == 0) {
                return false;
            }
            return jSONArray.contains(str);
        }
        return true;
    }

    private static int getMaxLength() {
        initConfigJson();
        JSONObject jSONObject = limitJson;
        if (jSONObject != null) {
            return jSONObject.getIntValue("maxLogLength");
        }
        return 0;
    }

    private static void initConfigJson() {
        RVConfigService rVConfigService;
        if (limitJson != null || (rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class)) == null) {
            return;
        }
        limitJson = JSONUtils.parseObject(rVConfigService.getConfigWithProcessCache("h5_tinyAppConsoleLogToNative", null));
    }
}
