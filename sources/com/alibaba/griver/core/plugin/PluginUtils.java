package com.alibaba.griver.core.plugin;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.rpc.GriverRpcExtension;

/* loaded from: classes6.dex */
public class PluginUtils {
    public static boolean hasPermission() {
        return true;
    }

    public static void updatePluginInfo(String str, String str2) {
    }

    public static JSONObject downloadMeta(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pluginId", (Object) str3);
        jSONObject.put("appId", (Object) str);
        jSONObject.put("appVersion", (Object) str2);
        jSONObject.put("pluginVersion", (Object) str4);
        return downloadPlugin(jSONObject);
    }

    public static JSONObject downloadPlugin(JSONObject jSONObject) {
        JSONObject invokeRpc = ((GriverRpcExtension) RVProxy.get(GriverRpcExtension.class)).invokeRpc("gmp.openplatform.container.fetchPluginInfo", jSONObject.toString(), null, null);
        if (invokeRpc != null) {
            return invokeRpc.getJSONObject("success");
        }
        return null;
    }
}
