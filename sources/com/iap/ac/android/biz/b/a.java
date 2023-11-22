package com.iap.ac.android.biz.b;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alibaba.griver.init.IAPIntegrationConfiguration;
import com.alibaba.griver.init.IAPIntegrationHelper;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alipay.ac.pa.foundation.PSAadpterAC;
import com.iap.ac.android.acs.operation.biz.region.RegionManager;
import com.iap.ac.android.acs.plugin.downgrade.jsapi.IAPJSAPIInterceptorManager;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.rpc.RegionRpcInterceptor;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.model.InitErrorCode;
import com.iap.ac.android.biz.common.proxy.common.CommonRegionNetworkProxy;
import com.iap.ac.android.biz.common.proxy.common.NetworkProxy;
import com.iap.ac.android.biz.common.proxy.common.ProxyScene;
import com.iap.ac.android.biz.common.rpc.ssl.IAPSslPinner;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.biz.core.ACCoreManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.utils.MiscUtils;
import com.iap.ac.android.mpm.interceptor.provider.UAProvider;
import com.iap.safemode.api.IAPSafeModeMonitor;
import com.iap.safemode.api.IAPSafeModeTraceListener;
import java.util.List;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.iap.ac.android.biz.b.a$a */
    /* loaded from: classes3.dex */
    public static final class C0135a implements IAPSafeModeTraceListener {
        @Override // com.iap.safemode.api.IAPSafeModeTraceListener
        public final void onlog(String str) {
            ACLogEvent.newLogger("iapconnect_center", str).event();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements InitCallback {

        /* renamed from: a */
        public final /* synthetic */ Application f7538a;
        public final /* synthetic */ InitConfig b;
        public final /* synthetic */ InitCallback c;

        public b(Application application, InitConfig initConfig, InitCallback initCallback) {
            this.f7538a = application;
            this.b = initConfig;
            this.c = initCallback;
        }

        @Override // com.iap.ac.android.biz.common.callback.InitCallback
        public final void onFailure(InitErrorCode initErrorCode, String str) {
            InitCallback initCallback = this.c;
            if (initCallback != null) {
                initCallback.onFailure(initErrorCode, str);
            }
        }

        @Override // com.iap.ac.android.biz.common.callback.InitCallback
        public final void onSuccess() {
            com.iap.ac.android.biz.d.a.get().initContainer();
            if (Utils.checkClassExist(Constants.PACKAGE_NAME_AC_JSAPI_INTERCEPTOR_MANAGER)) {
                IAPJSAPIInterceptorManager.getInstance().init();
            }
            Application application = this.f7538a;
            InitConfig initConfig = this.b;
            ACLog.i(Constants.TAG, "initRegion begin");
            if (!Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_MANAGER)) {
                ACLog.w(Constants.TAG, "initRegion error, can not find the package, skip it");
            } else {
                RegionManager.getInstance().initRegion(application, initConfig);
                RPCProxyHost.getInstance("region_biz").addRpcInterceptor(new RegionRpcInterceptor());
            }
            InitCallback initCallback = this.c;
            if (initCallback != null) {
                initCallback.onSuccess();
            }
        }
    }

    public static void a(Application application, InitConfig initConfig, InitCallback initCallback) {
        if (application != null && initConfig != null) {
            if (!MiscUtils.isMainProcess(application)) {
                if (initCallback != null) {
                    initCallback.onFailure(InitErrorCode.INITIALIZE_UNKNOWN_EXCEPTION, "You should initialize the SDK in the main process");
                    return;
                }
                return;
            }
            try {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    IAPSafeModeMonitor.KClassImpl$Data$declaredNonStaticMembers$2(application, new C0135a());
                }
            } catch (Throwable th) {
                ACLog.e(Constants.TAG, th.toString());
            }
            if (Utils.checkClassExist(SecurityConstants.SG_CLASS)) {
                try {
                    SecurityGuardManager.getInstance(application).setReportSwitch(false);
                } catch (Throwable th2) {
                    ACLog.e(Constants.TAG, String.format("Just print, cannot close securityGuardManager report! %s", Utils.formatSecurityGuardException(th2)));
                }
            }
            a(application, initConfig);
            if (!ACManager.getInstance().isInitialized()) {
                ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_AC_COMMON_INIT).addParams("sdkVersion", "2.39.0").addParams("result", LogConstants.RESULT_FALSE).addParams("resultMessage", "parse preset config error, please import the resource file from AC").event();
                if (initCallback != null) {
                    initCallback.onFailure(InitErrorCode.INITIALIZE_UNKNOWN_EXCEPTION, "parse preset config error, please import the resource file from AC");
                    return;
                }
                return;
            }
            ACLog.i(Constants.TAG, "initACCore begin");
            if (!Utils.checkClassExist(Constants.PACKAGE_NAME_AC_CORE_MANAGER)) {
                ACLog.w(Constants.TAG, "initACCore error, can not find the package, skip it");
            } else {
                ACCoreManager.getInstance().init(application, initConfig);
            }
            ACLog.i(Constants.TAG, "InitPACore begin");
            if (!Utils.checkClassExist(Constants.PACKAGE_NAME_PA_CORE_MANAGER)) {
                ACLog.w(Constants.TAG, "initPACore error, can not find the package, skip it");
            } else {
                PSAadpterAC.getInstance().setupWithConfig(application, initConfig);
            }
            b bVar = new b(application, initConfig, initCallback);
            ACLog.i(Constants.TAG, "initGriver begin");
            if (Utils.checkClassExist("com.alibaba.griver.init.IAPIntegrationConfiguration") && Utils.checkClassExist("com.alibaba.griver.init.IAPIntegrationHelper")) {
                IAPIntegrationConfiguration iAPIntegrationConfiguration = new IAPIntegrationConfiguration();
                CommonConfig commonConfig = ACManager.getInstance().getCommonConfig();
                iAPIntegrationConfiguration.setEnv(commonConfig.envType);
                iAPIntegrationConfiguration.setAppendUserAgent(initConfig.userAgent);
                iAPIntegrationConfiguration.setAppId(commonConfig.appId);
                iAPIntegrationConfiguration.setGatewayUrl(commonConfig.gatewayUrl);
                iAPIntegrationConfiguration.setLogUploadURL(commonConfig.logGatewayUrl);
                iAPIntegrationConfiguration.setWorkSpaceId(commonConfig.getWorkspaceId());
                iAPIntegrationConfiguration.setLogProductId(commonConfig.getLogProductId());
                iAPIntegrationConfiguration.setBizCode("ac_biz");
                IAPIntegrationHelper.init(application, iAPIntegrationConfiguration, new com.iap.ac.android.biz.b.b(bVar));
                return;
            }
            ACLog.w(Constants.TAG, "initGriver error, can not find the package, skip it");
            bVar.onSuccess();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("empty input parameters, context: ");
        sb.append(application);
        sb.append(", initConfig:");
        sb.append(initConfig);
        String obj = sb.toString();
        ACLog.e(Constants.TAG, obj);
        if (initCallback != null) {
            initCallback.onFailure(InitErrorCode.INITIALIZE_PARAM_ILLEGAL, obj);
        }
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_AC_COMMON_INIT).addParams("sdkVersion", "2.39.0").addParams("result", LogConstants.RESULT_FALSE).addParams("resultMessage", obj).event();
    }

    public static void a(Context context, InitConfig initConfig) {
        ACManager.getInstance().init(context, initConfig);
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_DECODE_CHECKER)) {
            UAProvider.setPspUA(initConfig.userAgent);
        }
        NetworkProxy commonNetworkProxy = initConfig.getCommonNetworkProxy(ProxyScene.PROXY_SCENE_PAY);
        if (commonNetworkProxy != null) {
            CommonRegionNetworkProxy.getInstance().setHttpTransporter(ProxyScene.PROXY_SCENE_PAY, commonNetworkProxy);
        } else if (initConfig.networkProxy != null) {
            com.iap.ac.android.biz.common.proxy.NetworkProxy.getInstance().setHttpTransporter(initConfig.networkProxy);
        }
        List<String> sslCertList = ACManager.getInstance().getSslCertList();
        if ((sslCertList == null || sslCertList.size() == 0) ? false : true) {
            IAPSslPinner.INSTANCE.init(context);
        }
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_AC_COMMON_INIT).addParams("sdkVersion", "2.39.0").addParams("result", "T").event();
    }
}
