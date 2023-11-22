package com.iap.ac.android.biz.common.internal.rpc;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import com.iap.ac.android.rpc.RpcProxyImpl;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class RpcAccelerateUrlInterceptor implements RpcInterceptor {
    public static final String KEY_INNER_OPERATION = "inner_operation_type";
    public static final String TAG = "UrlInterceptor";
    public CookieManager cookieManager;

    private String getOperationType(RpcRequest rpcRequest) {
        RpcAppInfo rpcAppInfo;
        if (rpcRequest == null || TextUtils.isEmpty(rpcRequest.operationType) || (rpcAppInfo = rpcRequest.rpcAppInfo) == null) {
            return "";
        }
        String str = rpcRequest.operationType;
        Map<String, String> map = rpcAppInfo.headers;
        return (map == null || !map.containsKey(KEY_INNER_OPERATION)) ? str : map.get(KEY_INNER_OPERATION);
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
        RpcAppInfo rpcAppInfo;
        if (rpcRequest == null) {
            return null;
        }
        String str = rpcRequest.operationType;
        if (!TextUtils.isEmpty(str) && getOperationType(rpcRequest).contains("ac.mobilepayment.auth") && ConfigCenter.INSTANCE.isUrlInterceptEnalbe()) {
            String oldGateWayUrl = ConfigCenter.INSTANCE.getOldGateWayUrl();
            if (!TextUtils.isEmpty(oldGateWayUrl) && Utils.isUrlFormat(oldGateWayUrl)) {
                String newGateWayUrl = ConfigCenter.INSTANCE.getNewGateWayUrl();
                if (TextUtils.isEmpty(newGateWayUrl) || !Utils.isUrlFormat(newGateWayUrl) || (rpcAppInfo = rpcRequest.rpcAppInfo) == null) {
                    return null;
                }
                String str2 = rpcAppInfo.rpcGateWayUrl;
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                if (TextUtils.equals(newGateWayUrl, str2)) {
                    saveCookie(str2, oldGateWayUrl, str);
                } else {
                    saveCookie(str2, newGateWayUrl, str);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public void onBeforeSend(RpcRequest rpcRequest) {
        List<String> uRLInterceptRules;
        if (rpcRequest == null) {
            return;
        }
        String str = rpcRequest.operationType;
        RpcAppInfo rpcAppInfo = rpcRequest.getRpcAppInfo();
        if (rpcAppInfo == null) {
            RpcAppInfo rpcAppInfo2 = new RpcAppInfo(RpcProxyImpl.getInstance("ac_biz").getRpcAppInfo());
            rpcRequest.setRpcAppInfo(rpcAppInfo2);
            rpcAppInfo = rpcAppInfo2;
        }
        Map<String, String> map = rpcAppInfo.headers;
        if (map != null && map.containsKey(KEY_INNER_OPERATION)) {
            str = map.get(KEY_INNER_OPERATION);
        }
        StringBuilder a2 = a.a("before rpcGateWayUrl is ");
        a2.append(rpcAppInfo.rpcGateWayUrl);
        a2.append("--->operationType:");
        a2.append(str);
        ACLog.d(TAG, a2.toString());
        if (TextUtils.isEmpty(rpcAppInfo.rpcGateWayUrl) || TextUtils.isEmpty(str) || str.contains("ap.mobileamcs") || !ConfigCenter.INSTANCE.isUrlInterceptEnalbe()) {
            return;
        }
        String str2 = rpcAppInfo.rpcGateWayUrl;
        String oldGateWayUrl = ConfigCenter.INSTANCE.getOldGateWayUrl();
        if (Utils.isUrlFormat(oldGateWayUrl) && TextUtils.equals(str2, oldGateWayUrl)) {
            String newGateWayUrl = ConfigCenter.INSTANCE.getNewGateWayUrl();
            if (TextUtils.isEmpty(newGateWayUrl) || !Utils.isUrlFormat(newGateWayUrl) || (uRLInterceptRules = ConfigCenter.INSTANCE.getURLInterceptRules()) == null || uRLInterceptRules.size() == 0) {
                return;
            }
            for (String str3 : uRLInterceptRules) {
                if (!TextUtils.isEmpty(str3) && (str3.contains("*") || str.contains(str3))) {
                    rpcAppInfo.rpcGateWayUrl = newGateWayUrl;
                    return;
                }
            }
        }
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }

    public void saveCookie(String str, String str2, String str3) {
        try {
            this.cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            StringBuilder a2 = a.a("CookieManager.getInstance() exception occurs ");
            a2.append(th.getMessage());
            ACLog.e(TAG, a2.toString());
        }
        CookieManager cookieManager = this.cookieManager;
        if (cookieManager == null) {
            ACLog.e(TAG, "cookieManager is null!");
            return;
        }
        String cookie = cookieManager.getCookie(str.toString());
        if (TextUtils.isEmpty(cookie)) {
            return;
        }
        for (String str4 : cookie.split(";")) {
            this.cookieManager.setCookie(str2, str4);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.cookieManager.flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
    }
}
