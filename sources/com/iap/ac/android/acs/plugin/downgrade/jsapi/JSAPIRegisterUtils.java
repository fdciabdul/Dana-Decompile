package com.iap.ac.android.acs.plugin.downgrade.jsapi;

import android.content.Context;
import com.iap.ac.android.acs.plugin.downgrade.amcs.JSAPIModeManager;
import com.iap.ac.android.acs.plugin.downgrade.resource.JSAPIModeResourceManager;
import com.iap.ac.android.acs.plugin.utils.DeviceUtils;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class JSAPIRegisterUtils {
    public static JSAPIRegisterBean getJSAPIRegisterList(Context context, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        List<String> whiteList = JSAPIModeManager.getInstance().getWhiteList();
        List<String> blackList = JSAPIModeManager.getInstance().getBlackList();
        String str3 = "WHITE_LIST";
        if (whiteList.size() <= 0 || blackList.size() != 0) {
            str2 = "NOT_CONFIG";
        } else {
            arrayList = whiteList;
            str2 = "WHITE_LIST";
        }
        String str4 = "BLACK_LIST";
        if (whiteList.size() == 0 && blackList.size() > 0) {
            arrayList = blackList;
            str2 = "BLACK_LIST";
        }
        if (whiteList.size() > 0 && blackList.size() > 0) {
            if (!DeviceUtils.isApkInDebug(context)) {
                MonitorUtil.monitorJSAPIListError("JSAPIRegisterUtils#getJSAPIRegisterList: AMCS config error, there is also a black and white list.");
            } else {
                ACLog.e("IAPConnectPlugin", "JSAPIRegisterUtils#getJSAPIRegisterList: AMCS config error, there is also a black and white list.");
                throw new AssertionError("JSAPIRegisterUtils#getJSAPIRegisterList: AMCS config error, there is also a black and white list.");
            }
        }
        if (arrayList.size() == 0) {
            JSAPIModeResourceManager jSAPIModeResourceManager = new JSAPIModeResourceManager(context, str);
            List<String> jSAPIWhiteList = jSAPIModeResourceManager.getJSAPIWhiteList();
            List<String> jSAPIBlackList = jSAPIModeResourceManager.getJSAPIBlackList();
            if (jSAPIWhiteList.size() <= 0 || jSAPIBlackList.size() != 0) {
                str3 = str2;
            } else {
                arrayList = jSAPIWhiteList;
            }
            if (jSAPIWhiteList.size() != 0 || jSAPIBlackList.size() <= 0) {
                str4 = str3;
            } else {
                arrayList = jSAPIBlackList;
            }
        } else {
            str4 = str2;
        }
        return new JSAPIRegisterBean(str4, arrayList);
    }

    public static void parseAssetConfig(Context context, String str, final JSAPIConfigCallback<JSAPIRegisterBean> jSAPIConfigCallback) {
        final JSAPIModeResourceManager jSAPIModeResourceManager = new JSAPIModeResourceManager();
        jSAPIModeResourceManager.loadConfigFromAsset(context, str, new JSAPIReadAssetCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.jsapi.JSAPIRegisterUtils.1
            @Override // com.iap.ac.android.acs.plugin.downgrade.jsapi.JSAPIReadAssetCallback
            public final void onParseResult() {
                ArrayList arrayList;
                String str2;
                ArrayList arrayList2 = new ArrayList();
                List<String> jSAPIWhiteList = JSAPIModeResourceManager.this.getJSAPIWhiteList();
                List<String> jSAPIBlackList = JSAPIModeResourceManager.this.getJSAPIBlackList();
                if (jSAPIWhiteList.size() <= 0 || jSAPIBlackList.size() != 0) {
                    arrayList = arrayList2;
                    str2 = "NOT_CONFIG";
                } else {
                    str2 = "WHITE_LIST";
                    arrayList = jSAPIWhiteList;
                }
                if (jSAPIWhiteList.size() != 0 || jSAPIBlackList.size() <= 0) {
                    jSAPIBlackList = arrayList;
                } else {
                    str2 = "BLACK_LIST";
                }
                jSAPIConfigCallback.onParseResult(new JSAPIRegisterBean(str2, jSAPIBlackList));
            }
        });
    }

    public static void getJSAPIRegisterList(Context context, String str, JSAPIConfigCallback<JSAPIRegisterBean> jSAPIConfigCallback) {
        String str2;
        if (jSAPIConfigCallback == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<String> whiteList = JSAPIModeManager.getInstance().getWhiteList();
        List<String> blackList = JSAPIModeManager.getInstance().getBlackList();
        if (whiteList.size() <= 0 || blackList.size() != 0) {
            str2 = "NOT_CONFIG";
        } else {
            str2 = "WHITE_LIST";
            arrayList = whiteList;
        }
        if (whiteList.size() == 0 && blackList.size() > 0) {
            str2 = "BLACK_LIST";
            arrayList = blackList;
        }
        if (whiteList.size() > 0 && blackList.size() > 0) {
            if (!DeviceUtils.isApkInDebug(context)) {
                MonitorUtil.monitorJSAPIListError("JSAPIRegisterUtils#getJSAPIRegisterList: AMCS config error, there is also a black and white list.");
            } else {
                ACLog.e("IAPConnectPlugin", "JSAPIRegisterUtils#getJSAPIRegisterList: AMCS config error, there is also a black and white list.");
                throw new AssertionError("JSAPIRegisterUtils#getJSAPIRegisterList: AMCS config error, there is also a black and white list.");
            }
        }
        if (arrayList.size() > 0) {
            jSAPIConfigCallback.onParseResult(new JSAPIRegisterBean(str2, arrayList));
        } else {
            parseAssetConfig(context, str, jSAPIConfigCallback);
        }
    }
}
