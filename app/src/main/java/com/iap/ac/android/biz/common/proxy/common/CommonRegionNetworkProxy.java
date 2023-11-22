package com.iap.ac.android.biz.common.proxy.common;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.http.HttpTransportFactory;

/* loaded from: classes3.dex */
public class CommonRegionNetworkProxy {
    public static final String TAG = "CommonRegionNetworkProxy";
    public static CommonRegionNetworkProxy mInstance;

    public static CommonRegionNetworkProxy getInstance() {
        if (mInstance == null) {
            synchronized (CommonRegionNetworkProxy.class) {
                if (mInstance == null) {
                    mInstance = new CommonRegionNetworkProxy();
                }
            }
        }
        return mInstance;
    }

    public void setHttpTransporter(ProxyScene proxyScene, NetworkProxy networkProxy) throws IllegalArgumentException {
        ACLog.i(TAG, "set network proxy");
        if (proxyScene != null && networkProxy != null) {
            if (proxyScene == ProxyScene.PROXY_SCENE_PAY) {
                HttpTransportFactory.setCreater(HttpTransportCreatorUtils.createHttpTransporter(networkProxy, proxyScene), "ac_biz");
                return;
            } else if (proxyScene == ProxyScene.PROXY_SCENE_MINI_PROGRAM) {
                HttpTransportFactory.setCreater(HttpTransportCreatorUtils.createHttpTransporter(networkProxy, proxyScene), "region_biz");
                return;
            } else {
                ACLog.i(TAG, "no common network proxy for this proxy scene");
                return;
            }
        }
        ACLog.i(TAG, "proxy scene or proxy implementation is null");
    }
}
