package com.iap.ac.android.acs.operation.biz.region;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.iap.ac.android.acs.operation.biz.region.bean.TrustLoginResult;
import com.iap.ac.android.acs.operation.biz.region.config.RegionCommonConfig;
import com.iap.ac.android.acs.operation.biz.region.config.RegionConfigManager;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.acs.operation.biz.region.foundation.RegionFoundationProxy;
import com.iap.ac.android.acs.operation.biz.region.menu.RegionMenuProvider;
import com.iap.ac.android.acs.operation.biz.region.oauth.LogoutProcessor;
import com.iap.ac.android.acs.operation.biz.region.oauth.RegionOAuthInterceptor;
import com.iap.ac.android.acs.operation.biz.region.proxy.HttpTransportCreatorUtils;
import com.iap.ac.android.acs.operation.biz.region.storage.RegionEncryptStorageProvider;
import com.iap.ac.android.acs.operation.biz.region.utils.CookieUtils;
import com.iap.ac.android.acs.operation.biz.region.utils.RegionUtils;
import com.iap.ac.android.acs.operation.downgrade.jsapi.IAPJSAPIInterceptorManager;
import com.iap.ac.android.acs.operation.utils.ConfigUtils;
import com.iap.ac.android.acs.operation.utils.MonitorUtil;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.FetchLaunchableGroupsCallback;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.LaunchableGroupManager;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.LaunchableGroup;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.internal.rpc.SignRpcRequestPluginImpl;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.proxy.common.NetworkProxy;
import com.iap.ac.android.biz.common.proxy.common.ProxyScene;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.config.IConfigChangeListener;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.http.HttpTransportFactory;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RegionManager implements IRegionManager {
    public static volatile IRegionManager mInstance;
    public Context context;
    public InitConfig initConfig;
    public boolean isInit = false;
    public RegionCommonConfig mRegionCommonConfig;
    public RegionMenuProvider provider;

    public RegionManager() {
        if (RegionRPCConfigCenter.INSTANCE.getRegionBizHotBootToggle()) {
            return;
        }
        this.provider = new RegionMenuProvider();
    }

    public static IRegionManager getInstance() {
        if (mInstance == null) {
            synchronized (RegionManager.class) {
                if (mInstance == null) {
                    mInstance = new RegionManager();
                }
            }
        }
        return mInstance;
    }

    public void hotBootInit() {
        synchronized (this) {
            ACLog.i(RegionConstants.TAG, "initRegion begin with hot boot start");
            NetworkProxy commonNetworkProxy = this.initConfig.getCommonNetworkProxy(ProxyScene.PROXY_SCENE_MINI_PROGRAM);
            if (this.isInit || !RegionRPCConfigCenter.INSTANCE.getRegionBizToggle() || commonNetworkProxy == null) {
                MonitorUtil.regionBizBootMonitor(Boolean.valueOf(this.isInit), Boolean.TRUE, Boolean.FALSE, Boolean.valueOf(commonNetworkProxy != null));
                return;
            }
            Boolean valueOf = Boolean.valueOf(this.isInit);
            Boolean bool = Boolean.TRUE;
            MonitorUtil.regionBizBootMonitor(valueOf, bool, bool, Boolean.TRUE);
            ConfigUtils.registerConfigChangeListener(new IConfigChangeListener() { // from class: com.iap.ac.android.acs.operation.biz.region.RegionManager.1
                {
                    RegionManager.this = this;
                }

                @Override // com.iap.ac.android.common.config.IConfigChangeListener
                public void onConfigChanged(String str, Object obj) {
                    if (str.equals(RegionConstants.KEY_TOGGLE_REGION_BIZ)) {
                        RegionManager.this.hotBootInit();
                    }
                }

                @Override // com.iap.ac.android.common.config.IConfigChangeListener
                public void onSectionConfigChanged(String str, JSONObject jSONObject) {
                }
            });
            this.provider = new RegionMenuProvider();
            realInit();
        }
    }

    private void oldInitMode() {
        synchronized (this) {
            ACLog.i(RegionConstants.TAG, "initRegion begin with old logic");
            if (!this.isInit && RegionRPCConfigCenter.INSTANCE.getRegionBizToggle()) {
                MonitorUtil.regionBizBootMonitor(Boolean.valueOf(this.isInit), Boolean.FALSE, Boolean.TRUE, Boolean.valueOf(this.initConfig.getCommonNetworkProxy(ProxyScene.PROXY_SCENE_MINI_PROGRAM) != null));
                realInit();
                return;
            }
            boolean z = this.isInit;
            boolean z2 = this.initConfig.getCommonNetworkProxy(ProxyScene.PROXY_SCENE_MINI_PROGRAM) != null;
            Boolean valueOf = Boolean.valueOf(z);
            Boolean bool = Boolean.FALSE;
            MonitorUtil.regionBizBootMonitor(valueOf, bool, bool, Boolean.valueOf(z2));
        }
    }

    private void realInit() {
        this.isInit = true;
        this.mRegionCommonConfig = new RegionConfigManager(this.context).loadLocalConfig(this.initConfig);
        NetworkProxy commonNetworkProxy = this.initConfig.getCommonNetworkProxy(ProxyScene.PROXY_SCENE_MINI_PROGRAM);
        RegionFoundationProxy.getInstance().init(this.context, ACManager.getInstance().getCommonConfig(), this.mRegionCommonConfig);
        RPCProxyHost.getInstance("region_biz").addRpcInterceptor(new RegionOAuthInterceptor());
        if (Utils.checkClassExist("com.alipay.plus.security.lite.SecurityGuardLiteManager")) {
            RPCProxyHost.getInstance("region_biz").setSignV2Request(new SignV2RpcRequestPluginImpl());
        }
        if (Utils.checkClassExist(SecurityConstants.SG_CLASS)) {
            RPCProxyHost.getInstance("region_biz").setSignRequest(new SignRpcRequestPluginImpl());
        }
        if (RegionRPCConfigCenter.INSTANCE.isAllowRegisterCommonNetwork()) {
            HttpTransportFactory.setCreater(HttpTransportCreatorUtils.createHttpTransporter(commonNetworkProxy, ProxyScene.PROXY_SCENE_MINI_PROGRAM), "region_biz");
        }
        WebContainer.getInstance("ac_biz").registerAppEventHandler();
        WebContainer.getInstance("ac_biz").setProvider(ContainerUIProvider.class.getName(), this.provider);
        WebContainer.getInstance("ac_biz").registerContainerListener(new IContainerListener() { // from class: com.iap.ac.android.acs.operation.biz.region.RegionManager.2
            {
                RegionManager.this = this;
            }

            @Override // com.iap.ac.android.common.container.event.IContainerListener
            public void onContainerCreated(Bundle bundle) {
                RegionManager.this.provider.onContainerCreated(bundle);
            }

            @Override // com.iap.ac.android.common.container.event.IContainerListener
            public void onContainerDestroyed(Bundle bundle) {
                RegionManager.this.provider.onContainerDestroyed(bundle);
            }
        });
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.IRegionManager
    public void fetchLaunchableGroupsWithCodes(List<String> list, FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback) {
        if (this.isInit) {
            LaunchableGroupManager.getInstance().fetchLaunchableGroupsWithCodes(list, fetchLaunchableGroupsCallback, true);
        }
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.IRegionManager
    public Context getContext() {
        return this.context;
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.IRegionManager
    public InitConfig getInitConfig() {
        return this.initConfig;
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.IRegionManager
    public void initRegion(Context context, InitConfig initConfig) {
        this.context = context;
        this.initConfig = initConfig;
        if (RegionRPCConfigCenter.INSTANCE.getRegionBizHotBootToggle()) {
            hotBootInit();
        } else {
            oldInitMode();
        }
        IAPJSAPIInterceptorManager.getInstance().init();
    }

    public boolean isInit() {
        return this.isInit;
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.IRegionManager
    public boolean isRegionMiniProgram(String str, String str2) {
        return RegionUtils.isRegionMiniProgram(str, str2);
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.IRegionManager
    public void logout() {
        final TrustLoginResult trustLoginResult;
        String str = RegionEncryptStorageProvider.getInstance(getInstance().getContext()).get(RegionConstants.KEY_TRUST_LOGIN_RESULT);
        if (TextUtils.isEmpty(str) || (trustLoginResult = (TrustLoginResult) JsonUtils.fromJson(str, TrustLoginResult.class)) == null) {
            return;
        }
        final String instanceId = InstanceInfo.getInstanceId(this.context);
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.biz.region.RegionManager.3
            {
                RegionManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                new LogoutProcessor().logout(trustLoginResult.sessionId, instanceId);
                RegionEncryptStorageProvider.getInstance(RegionManager.getInstance().getContext()).clear();
                Context context = RegionManager.this.context;
                TrustLoginResult trustLoginResult2 = trustLoginResult;
                CookieUtils.clearCookies(context, trustLoginResult2.domainName, trustLoginResult2.sessionIdKey);
            }
        });
    }
}
