package com.iap.ac.android.acs.operation.downgrade.jsapi;

import android.content.Context;
import android.os.Build;
import com.iap.ac.android.acs.operation.downgrade.jsapi.interceptor.IAPImplementedJSAPIInterceptor;
import com.iap.ac.android.acs.operation.utils.Constants;
import com.iap.ac.android.acs.operation.utils.MonitorUtil;
import com.iap.ac.android.acs.operation.utils.Utils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class IAPJSAPIInterceptorManager {
    public static final String TAG = Utils.logTag("IAPJSAPIInterceptorManager");
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
    }

    public void registerJSAPIInterceptor() {
        final IAPImplementedJSAPIInterceptor iAPImplementedJSAPIInterceptor = new IAPImplementedJSAPIInterceptor();
        Context context = ACManager.getInstance().getContext();
        String appId = ACManager.getInstance().getAppId();
        if (Build.VERSION.SDK_INT >= 23) {
            registerJSAPIInterceptorInner(iAPImplementedJSAPIInterceptor, JSAPIRegisterUtils.getJSAPIRegisterList(context, appId));
        } else {
            JSAPIRegisterUtils.getJSAPIRegisterList(context, appId, new JSAPIConfigCallback<JSAPIRegisterBean>() { // from class: com.iap.ac.android.acs.operation.downgrade.jsapi.IAPJSAPIInterceptorManager.1
                @Override // com.iap.ac.android.acs.operation.downgrade.jsapi.JSAPIConfigCallback
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
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WebContainer.getInstance("ac_biz").registerJSAPIInterceptor((String) it.next(), bridgeInterceptor);
        }
        MonitorUtil.monitorJSAPIRegisterList(String.valueOf(arrayList));
    }
}
