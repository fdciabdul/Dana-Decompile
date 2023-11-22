package com.iap.ac.android.biz.common.model;

import com.iap.ac.android.biz.common.callback.IOAuth;
import com.iap.ac.android.biz.common.callback.IPay;
import com.iap.ac.android.biz.common.callback.OpenAbilityDelegate;
import com.iap.ac.android.biz.common.callback.UserDelegate;
import com.iap.ac.android.biz.common.proxy.HttpTransporter;
import com.iap.ac.android.biz.common.proxy.common.NetworkProxy;
import com.iap.ac.android.biz.common.proxy.common.ProxyScene;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class InitConfig {
    public static final int PREDICT_HASH_MAP_MAX_CAPACITY = 3;
    public String appId;
    public String envType;
    @Deprecated
    public HttpTransporter networkProxy;
    public IOAuth oAuth;
    public OpenAbilityDelegate openAbilityDelegate;
    public IPay pay;
    public String tid;
    public String userAgent;
    public UserDelegate userDelegate;
    public boolean acLogDisabled = false;
    public boolean shadow = false;
    public final Map<ProxyScene, NetworkProxy> commonNetworkProxyMap = new ConcurrentHashMap(3);

    public NetworkProxy getCommonNetworkProxy(ProxyScene proxyScene) {
        return this.commonNetworkProxyMap.get(proxyScene);
    }

    public void registerNetworkProxy(ProxyScene proxyScene, NetworkProxy networkProxy) {
        this.commonNetworkProxyMap.put(proxyScene, networkProxy);
    }
}
