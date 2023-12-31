package com.alibaba.griver.core.utils;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverConfig;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverWebRenderUtils {
    public static String getBridgeToken(Page page) {
        StringBuilder sb = new StringBuilder();
        sb.append("bridge_token_");
        sb.append(page.getNodeId());
        return sb.toString();
    }

    public static String loadJsBridgeByPreload(Map<String, String> map, Page page, String str) {
        String readAsset = IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), "GriverBridge/h5_bridge_part2.js");
        if (TextUtils.isEmpty(readAsset)) {
            RVLogger.d("GriverWebRenderUtils", "no bridge data defined!");
            return readAsset;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            sb.append(";AlipayJSBridge.");
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            sb.append(";");
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            readAsset = readAsset.replace("AlipayJSBridge.startupParams='{startupParams}'", sb.toString());
        } else {
            RVLogger.d("GriverWebRenderUtils", "no params data defined!");
        }
        return readAsset.replace("console.log(\"begin load AlipayJSBridge\");", "console.log(\"begin load AlipayJSBridge from core raw\");").replace("'{APVIEWID}'", str);
    }

    public static String loadJsBridge(Map<String, String> map, Page page, String str) {
        String readAsset = IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), "GriverBridge/h5_bridge.js");
        if (TextUtils.isEmpty(readAsset)) {
            RVLogger.d("WebRenderUtils", "no bridge data defined!");
            return readAsset;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            sb.append(";AlipayJSBridge.");
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            sb.append(";");
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            readAsset = readAsset.replace("AlipayJSBridge.startupParams='{startupParams}'", sb.toString());
        } else {
            RVLogger.d("WebRenderUtils", "no params data defined!");
        }
        return a(readAsset.replace("console.log(\"begin load AlipayJSBridge\");", "console.log(\"begin load AlipayJSBridge from core raw\");").replace("'{APVIEWID}'", str).replace("{bridge_token}", page != null ? getBridgeToken(page) : ""));
    }

    private static String a(String str) {
        String configWithProcessCache = GriverConfig.getConfigWithProcessCache(GriverConfigConstants.KEY_H5_PATCH_JS_BRIDGE, "");
        if (TextUtils.isEmpty(configWithProcessCache)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("\n");
        sb.append(configWithProcessCache);
        return sb.toString();
    }
}
