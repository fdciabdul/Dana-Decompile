package com.iap.ac.android.common.container.js.plugin;

import android.text.TextUtils;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.js.AlipayJSAPI;
import com.iap.ac.android.common.container.js.ContainerBridgeContext;
import com.iap.ac.android.common.container.js.model.JSBridgeMessageToNative;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseJSPlugin {
    public static final String TAG = "BaseJSPlugin";
    public HashMap<String, Method> jsMethods = new HashMap<>();
    public List<String> jsApiList = new ArrayList();

    public BaseJSPlugin() {
        addJSAPIMethods();
    }

    public void addJSAPIMethods() {
        for (Method method : getJSPluginClass().getDeclaredMethods()) {
            AlipayJSAPI alipayJSAPI = (AlipayJSAPI) method.getAnnotation(AlipayJSAPI.class);
            if (alipayJSAPI != null) {
                this.jsMethods.put(alipayJSAPI.api(), method);
                this.jsApiList.add(alipayJSAPI.api());
            }
        }
    }

    public boolean checkContainerPresenterExist(Map<String, String> map, IContainerPresenter iContainerPresenter) {
        if (iContainerPresenter == null) {
            if (map != null) {
                map.put("success", "false");
                map.put("msg", "ACContainer is not running.");
                return false;
            }
            return false;
        }
        return true;
    }

    public abstract Class<? extends BaseJSPlugin> getJSPluginClass();

    public List<String> getJsApiList() {
        return this.jsApiList;
    }

    public JSONObject onJSEvent(JSBridgeMessageToNative jSBridgeMessageToNative, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) throws InvocationTargetException, IllegalAccessException {
        HashMap hashMap = new HashMap();
        if (jSBridgeMessageToNative != null && !TextUtils.isEmpty(jSBridgeMessageToNative.func)) {
            Method method = this.jsMethods.get(jSBridgeMessageToNative.func);
            if (method == null) {
                return setResultFail(hashMap, "JSAPI method is null");
            }
            if (containerBridgeContext != null) {
                containerBridgeContext.setToNativeMsg(jSBridgeMessageToNative);
            }
            Object invoke = method.invoke(this, JsonUtils.fromJson(jSBridgeMessageToNative.param, method.getParameterTypes()[0]), iContainerPresenter, containerBridgeContext);
            if (invoke == null) {
                return null;
            }
            try {
                return new JSONObject(JsonUtils.toJson(invoke));
            } catch (Exception e) {
                ACLog.e(TAG, "onJSEvent: convert result to JsonObject error: ", e);
                return setResultFail(hashMap, "Convert result to JsonObject error!");
            }
        }
        return setResultFail(hashMap, "jsBridgeMessage is empty");
    }

    public JSONObject setResultFail(Map<String, String> map, String str) {
        map.put("success", "false");
        map.put("msg", str);
        return new JSONObject(map);
    }

    public void setResultSuccess(Map<String, String> map) {
        map.put("success", SummaryActivity.CHECKED);
        map.put("msg", "success");
    }
}
