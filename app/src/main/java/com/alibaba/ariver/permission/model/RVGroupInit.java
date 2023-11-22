package com.alibaba.ariver.permission.model;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.permission.api.RVGroup;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.fastjson.JSONArray;
import com.iap.ac.android.container.js.plugin.ACContainerJSPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class RVGroupInit {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6184a;

    public static void init(Map<String, Map<String, Permission>> map) {
        synchronized (RVGroupInit.class) {
            if (f6184a) {
                return;
            }
            f6184a = true;
            synchronized (RVGroupInit.class) {
                a(map);
                a();
            }
        }
    }

    private static void a(Map<String, Map<String, Permission>> map) {
        if (map == null) {
            return;
        }
        RVGroup[] rVGroupArr = {RVGroup.LEVEL_HIGH, RVGroup.LEVEL_ABOVE_MEDIUM, RVGroup.LEVEL_MEDIUM, RVGroup.LEVEL_LOW, RVGroup.LEVEL_NONE};
        for (int i = 0; i < 5; i++) {
            rVGroupArr[i].clearPermissions();
        }
        for (int i2 = 0; i2 < 5; i2++) {
            RVGroup rVGroup = rVGroupArr[i2];
            Map<String, Permission> map2 = map.get(rVGroup.groupName());
            if (map2 != null) {
                for (int i3 = 0; i3 < 5; i3++) {
                    RVGroup rVGroup2 = rVGroupArr[i3];
                    if (rVGroup2.ordinal() <= rVGroup.ordinal()) {
                        rVGroup2.assignPermissions(map2);
                    }
                }
            }
        }
    }

    private static void a() {
        RVGroup.LEVEL_APP_DEFAULT.clearPermissions();
        ArrayList<Permission> arrayList = new ArrayList();
        arrayList.add(new BridgePermission(ACContainerJSPlugin.SHOW_NETWORK_CHECK_ACTIVITY, ACContainerJSPlugin.SHOW_NETWORK_CHECK_ACTIVITY));
        arrayList.add(new BridgePermission("showUCFailDialog", "showUCFailDialog"));
        arrayList.add(new BridgePermission("setKeyboardType", "setKeyboardType"));
        arrayList.add(new BridgePermission("monitorH5Performance", "monitorH5Performance"));
        arrayList.add(new BridgePermission("getStartupParams", "getStartupParams"));
        arrayList.add(new BridgePermission("inputBlurEvent", "inputBlurEvent"));
        arrayList.add(new BridgePermission("hideCustomKeyBoard", "hideCustomKeyBoard"));
        arrayList.add(new BridgePermission("hideCustomInputMethod4NativeInput", "hideCustomInputMethod4NativeInput"));
        arrayList.add(new BridgePermission("updateNativeKeyBoardInput", "updateNativeKeyBoardInput"));
        arrayList.add(new BridgePermission("setInputTextChanged", "setInputTextChanged"));
        arrayList.add(new BridgePermission(TinyAppLogUtil.TINY_APP_STANDARD_LOG, TinyAppLogUtil.TINY_APP_STANDARD_LOG));
        arrayList.add(new BridgePermission(RDConstant.TINY_DEBUG_CONSOLE, RDConstant.TINY_DEBUG_CONSOLE));
        arrayList.add(new BridgePermission("internalAPI", "internalAPI"));
        arrayList.add(new BridgePermission("setShowShareMenu", "setShowShareMenu"));
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("h5_white_jsapiList");
        if (configJSONArray != null && !configJSONArray.isEmpty()) {
            Iterator<Object> it = configJSONArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof String) {
                    String str = (String) next;
                    if (str.length() > 0) {
                        arrayList.add(new BridgePermission(str, str));
                    }
                }
            }
        }
        HashMap hashMap = new HashMap();
        for (Permission permission : arrayList) {
            hashMap.put(permission.authority(), permission);
        }
        RVGroup.LEVEL_APP_DEFAULT.assignPermissions(hashMap);
    }
}
