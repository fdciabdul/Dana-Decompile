package com.iap.ac.android.acs.plugin.downgrade.jsapi;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.iap.ac.android.acs.plugin.downgrade.amcs.JSAPICompatibilityConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor.IAPImplementedJSAPIInterceptor;
import com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor.IAPJSAPIPreInterceptor;
import com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor.IAPNotFoundJSAPIInterceptor;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class IAPJSAPIInterceptorManager {
    public static final String TAG = ApiDowngradeUtils.logTag("IAPJSAPIInterceptorManager");
    public static volatile IAPJSAPIInterceptorManager sInstance;

    public static IAPJSAPIInterceptorManager getInstance() {
        if (sInstance == null) {
            synchronized (IAPJSAPIInterceptorManager.class) {
                if (sInstance == null) {
                    sInstance = new IAPJSAPIInterceptorManager();
                }
            }
        }
        return sInstance;
    }

    public void init() {
        ACLog.d(TAG, "init the interceptor of implemented jsapi and the not found jsapi");
        registerJSAPIInterceptor();
        WebContainer.getInstance("ac_biz").registerNotFoundJSAPIInterceptor(new IAPNotFoundJSAPIInterceptor());
        WebContainer.getInstance("ac_biz").registerJSAPIPreInterceptor(new IAPJSAPIPreInterceptor());
        WebContainer.getInstance("ac_biz").registerAppEventHandler();
        if (JSAPICompatibilityConfigManager.getInstance().isConfigPreviewEnabled()) {
            WebContainer.getInstance("ac_biz").registerContainerListener(new IContainerListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.jsapi.IAPJSAPIInterceptorManager.1
                @Override // com.iap.ac.android.common.container.event.IContainerListener
                public void onContainerCreated(Bundle bundle) {
                    if (ApiDowngradeUtils.isScenePreview(bundle) && JSAPICompatibilityConfigManager.getInstance().isConfigPreviewEnabled()) {
                        ACConfig.getInstance("ac_biz").refreshConfig(null, false);
                    }
                }

                @Override // com.iap.ac.android.common.container.event.IContainerListener
                public void onContainerDestroyed(Bundle bundle) {
                }
            });
        }
    }

    public void registerJSAPIInterceptor() {
        final IAPImplementedJSAPIInterceptor iAPImplementedJSAPIInterceptor = new IAPImplementedJSAPIInterceptor();
        Context context = ACManager.getInstance().getContext();
        String appId = ACManager.getInstance().getAppId();
        if (Build.VERSION.SDK_INT >= 23) {
            registerJSAPIInterceptorInner(iAPImplementedJSAPIInterceptor, JSAPIRegisterUtils.getJSAPIRegisterList(context, appId));
        } else {
            JSAPIRegisterUtils.getJSAPIRegisterList(context, appId, new JSAPIConfigCallback<JSAPIRegisterBean>() { // from class: com.iap.ac.android.acs.plugin.downgrade.jsapi.IAPJSAPIInterceptorManager.2
                @Override // com.iap.ac.android.acs.plugin.downgrade.jsapi.JSAPIConfigCallback
                public void onParseResult(JSAPIRegisterBean jSAPIRegisterBean) {
                    IAPJSAPIInterceptorManager.this.registerJSAPIInterceptorInner(iAPImplementedJSAPIInterceptor, jSAPIRegisterBean);
                }
            });
        }
    }

    public void registerJSAPIInterceptorInner(BridgeInterceptor bridgeInterceptor, JSAPIRegisterBean jSAPIRegisterBean) {
        char c;
        ArrayList arrayList = new ArrayList(Constants.JS_API_LIST);
        String str = jSAPIRegisterBean.tag;
        int hashCode = str.hashCode();
        if (hashCode == -1123558146) {
            if (str.equals("BLACK_LIST")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 772975380) {
            if (hashCode == 1571022414 && str.equals("NOT_CONFIG")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("WHITE_LIST")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            List<String> list = jSAPIRegisterBean.registerList;
            MonitorUtil.monitorJSAPIBlackList(String.valueOf(list));
            arrayList.removeAll(list);
        } else if (c != 1) {
            ACLog.d("IAPConnectPlugin", "IAPJSAPIInterceptorManager#init: defaule load, register all jsapi.");
        } else {
            List<String> list2 = jSAPIRegisterBean.registerList;
            MonitorUtil.monitorJSAPIWhiteList(String.valueOf(list2));
            arrayList.retainAll(list2);
        }
        if (Utils.checkClassExist("com.iap.android.jsapi.AlipayPlusClientJSAPI")) {
            arrayList.removeAll(Constants.JS_API_EXCLUDE_LIST);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WebContainer.getInstance("ac_biz").registerJSAPIInterceptor((String) it.next(), bridgeInterceptor);
        }
        MonitorUtil.monitorJSAPIRegisterList(String.valueOf(arrayList));
    }
}
