package com.iap.ac.android.biz.core;

import android.content.Context;
import com.alipay.multigateway.sdk.BuildConfig;
import com.iap.ac.android.biz.a.a;
import com.iap.ac.android.biz.a.b;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.biz.common.internal.rpc.ACRpcInterceptor;
import com.iap.ac.android.biz.common.internal.rpc.RpcAccelerateUrlInterceptor;
import com.iap.ac.android.biz.common.internal.rpc.ShadowRpcInterceptor;
import com.iap.ac.android.biz.common.internal.rpc.SignRpcRequestPluginImpl;
import com.iap.ac.android.biz.common.internal.rpc.SignV2RpcRequestPluginImpl;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.proxy.common.ProxyScene;
import com.iap.ac.android.biz.common.risk.RiskControlManager;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class ACCoreManager {
    public static volatile ACCoreManager d;

    /* renamed from: a */
    public a f7546a;
    public b b;
    public boolean c = false;

    public static ACCoreManager getInstance() {
        if (d == null) {
            synchronized (ACCoreManager.class) {
                if (d == null) {
                    d = new ACCoreManager();
                }
            }
        }
        return d;
    }

    public void clear() {
        if (initialized()) {
            this.f7546a.clear();
        }
    }

    public Set<String> getCrashWhiteList() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.iap.ac");
        hashSet.add(BuildConfig.APPLICATION_ID);
        hashSet.add("com.alibaba.wireless.security");
        hashSet.add("com.alipay.iap.android.webapp");
        hashSet.add("com.alipay.mobile.nebula");
        hashSet.add("com.alipay.mobile.nebulacore");
        hashSet.add("com.alipay.mobile.nebulaappcenter");
        hashSet.add("com.alipay.mobile.h5container");
        hashSet.add("com.alibaba.ariver");
        hashSet.add("com.alibaba.griver");
        return hashSet;
    }

    public void init(Context context, InitConfig initConfig) {
        ACLog.d(Constants.TAG, "ACCoreManager init begin");
        FoundationProxy foundationProxy = FoundationProxy.getInstance("ac_biz");
        CommonConfig commonConfig = ACManager.getInstance().getCommonConfig();
        commonConfig.crashWhiteListSet = getCrashWhiteList();
        commonConfig.acLogDisabled = initConfig.acLogDisabled;
        foundationProxy.init(context, ACManager.getInstance().getCommonConfig());
        if (initConfig.networkProxy != null) {
            FoundationProxy.getInstance("ac_biz").setNetworkType(FoundationProxy.NetworkType.NETWORK_TYPE_PROXY);
        }
        this.f7546a = new a("ac_biz");
        this.b = new b("ac_biz");
        RPCProxyHost.getInstance("ac_biz").addRpcInterceptor(this.f7546a);
        if (initConfig.getCommonNetworkProxy(ProxyScene.PROXY_SCENE_PAY) != null) {
            RPCProxyHost.getInstance("ac_biz").removeRpcInterceptor(this.f7546a);
        }
        RPCProxyHost.getInstance("ac_biz").addRpcInterceptor(this.b);
        RPCProxyHost.getInstance("ac_biz").addRpcInterceptor(new ACRpcInterceptor());
        if (initConfig.shadow) {
            RPCProxyHost.getInstance("ac_biz").addRpcInterceptor(new ShadowRpcInterceptor());
        }
        RPCProxyHost.getInstance("ac_biz").addRpcInterceptor(new RpcAccelerateUrlInterceptor());
        if (Utils.checkClassExist("com.alipay.plus.security.lite.SecurityGuardLiteManager")) {
            RPCProxyHost.getInstance("ac_biz").setSignV2Request(new SignV2RpcRequestPluginImpl());
        }
        RPCProxyHost.getInstance("ac_biz").setSignRequest(new SignRpcRequestPluginImpl());
        ConfigCenter.INSTANCE.init();
        RiskControlManager.getInstance().init();
        this.c = true;
    }

    public boolean initialized() {
        return this.c;
    }
}
