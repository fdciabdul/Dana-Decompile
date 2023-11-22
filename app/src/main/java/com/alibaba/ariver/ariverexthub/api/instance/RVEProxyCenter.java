package com.alibaba.ariver.ariverexthub.api.instance;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.ariverexthub.api.RVEApiConfig;
import com.alibaba.ariver.ariverexthub.api.constant.RVEConstant;
import com.alibaba.ariver.ariverexthub.api.ipc.RVERemoteClient;
import com.alibaba.ariver.ariverexthub.api.manifest.RVEExthubManifest;
import com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo;
import com.alibaba.ariver.ariverexthub.api.model.RVEAriverExthubSource;
import com.alibaba.ariver.ariverexthub.api.model.RVEHandlerSource;
import com.alibaba.ariver.ariverexthub.api.provider.RVEBizProvider;
import com.alibaba.ariver.ariverexthub.api.provider.RVELogProvider;
import com.alibaba.ariver.ariverexthub.api.provider.RVEThreadService;
import com.alibaba.ariver.ariverexthub.api.provider.impl.RVEDefaultThreadServiceImpl;
import com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger;
import com.alibaba.ariver.ariverexthub.api.utils.RVEReflectUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class RVEProxyCenter {
    private static final HashMap<String, String> f = new HashMap() { // from class: com.alibaba.ariver.ariverexthub.api.instance.RVEProxyCenter.1
        {
            put(RVEConstant.RVE_BIZ_PROVIDER, RVEConstant.RVE_BIZ_PROVIDER_IMPL);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private RVEThreadService f6004a;
    private RVEApiConfig b;
    private RVELogProvider c;
    private RVEBizProvider d;
    private RVERemoteClient e;

    private RVEProxyCenter() {
        this.b = null;
        this.c = null;
        this.d = null;
        a();
        if (this.f6004a == null) {
            this.f6004a = new RVEDefaultThreadServiceImpl();
        }
    }

    private void a() {
        RVEApiConfig rVEApiConfig = new RVEApiConfig();
        this.b = rVEApiConfig;
        rVEApiConfig.handleApis(RVEExthubManifest.getExthubHandlers());
        RVEBizProvider rVEBizProvider = (RVEBizProvider) RVEReflectUtil.newInstance(f.get(RVEConstant.RVE_BIZ_PROVIDER));
        this.d = rVEBizProvider;
        if (rVEBizProvider != null) {
            rVEBizProvider.onInit();
            this.b.handleApis(this.d.getRVEBizApiList());
            this.c = this.d.getRveLogger();
            this.f6004a = this.d.getThreadService();
        }
        RVEBizProvider rVEBizProvider2 = this.d;
        if (rVEBizProvider2 == null || !rVEBizProvider2.isLiteProcess() || this.d.getCurrentAriverExthubSource() == RVEAriverExthubSource.ALIPAY) {
            return;
        }
        InstrumentInjector.log_d("RVEProxyCenter", "开始建立连接");
        RVERemoteClient rVERemoteClient = new RVERemoteClient(this.d.getCurrentContext());
        this.e = rVERemoteClient;
        rVERemoteClient.bindRVERemoteService();
    }

    public static RVEProxyCenter getInstance() {
        return RVEConfigHolder.f6005a;
    }

    /* loaded from: classes3.dex */
    static class RVEConfigHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final RVEProxyCenter f6005a = new RVEProxyCenter();

        private RVEConfigHolder() {
        }
    }

    public void registerCustomBizProvider(RVEBizProvider rVEBizProvider) {
        if (rVEBizProvider == null) {
            return;
        }
        this.b.handleApis(rVEBizProvider.getRVEBizApiList());
        if (rVEBizProvider.getRveLogger() != null) {
            this.c = rVEBizProvider.getRveLogger();
        }
    }

    public RVELogProvider getLogProvider() {
        return this.c;
    }

    @Deprecated
    public boolean isApiAvailable(String str) {
        if (TextUtils.isEmpty(str) || !this.b.isApiCanuse(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("apiName isApiAvailable = false，apiName = ");
            sb.append(str);
            ExtHubLogger.d("RVEProxyCenter", sb.toString());
            return false;
        }
        RVEBizProvider rVEBizProvider = this.d;
        if (rVEBizProvider != null) {
            return rVEBizProvider.enableApi(str);
        }
        return false;
    }

    public RVEApiInfo getApiInfo(String str) {
        RVEApiConfig rVEApiConfig;
        if (TextUtils.isEmpty(str) || (rVEApiConfig = this.b) == null) {
            return null;
        }
        return rVEApiConfig.getApiInfo(str);
    }

    public RVEApiInfo isApiAvailable(String str, String str2) {
        if (TextUtils.isEmpty(str) || !this.b.isApiCanuse(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("apiName isApiAvailable = false，apiName = ");
            sb.append(str);
            ExtHubLogger.d("RVEProxyCenter", sb.toString());
            return null;
        } else if (!RVEConstant.RVEHost.ARIVER_HOST.equalsIgnoreCase(str2)) {
            return this.b.getApiInfo(str);
        } else {
            RVEBizProvider rVEBizProvider = this.d;
            if (rVEBizProvider == null || !rVEBizProvider.enableApi(str) || this.b.getApiInfo(str).source == RVEHandlerSource.AriverExcept) {
                return null;
            }
            return this.b.getApiInfo(str);
        }
    }

    public String getConfig(String str) {
        RVEBizProvider rVEBizProvider = this.d;
        if (rVEBizProvider != null) {
            return rVEBizProvider.getConfig(str);
        }
        return null;
    }

    public boolean isLiteProcess() {
        RVEBizProvider rVEBizProvider = this.d;
        if (rVEBizProvider != null) {
            return rVEBizProvider.isLiteProcess();
        }
        return false;
    }

    public boolean interceptAPI(String str) {
        RVEBizProvider rVEBizProvider = this.d;
        if (rVEBizProvider != null) {
            return rVEBizProvider.interceptAPI(str);
        }
        return false;
    }

    public Activity getTopActivity() {
        RVEBizProvider rVEBizProvider = this.d;
        if (rVEBizProvider != null) {
            return rVEBizProvider.getTopActivity();
        }
        return null;
    }

    public RVEApiConfig getRveApiConfig() {
        return this.b;
    }

    public RVEThreadService getRVEThreadService() {
        return this.f6004a;
    }

    public void sendMessage(Bundle bundle) {
        RVERemoteClient rVERemoteClient = this.e;
        if (rVERemoteClient != null) {
            rVERemoteClient.sendMessageToServer(bundle);
        }
    }

    public Context getCurrentContext() {
        RVEBizProvider rVEBizProvider = this.d;
        if (rVEBizProvider != null) {
            return rVEBizProvider.getCurrentContext();
        }
        return null;
    }

    public RVEAriverExthubSource getCurrentSource() {
        RVEBizProvider rVEBizProvider = this.d;
        if (rVEBizProvider != null) {
            return rVEBizProvider.getCurrentAriverExthubSource();
        }
        return RVEAriverExthubSource.DEFAULT;
    }

    public RVEBizProvider getRVEBizProvider() {
        return this.d;
    }
}
