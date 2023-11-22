package com.iap.ac.android.biz.common.internal.foundation.facade;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.rpc.ssl.IAPSslPinner;
import com.iap.ac.android.biz.common.utils.SignatureUtils;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.interfaces.SslPinningPlugin;
import com.iap.ac.android.rpc.RpcProxyImpl;
import com.iap.ac.android.rpc.multigateway.RpcGatewayController;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

/* loaded from: classes8.dex */
public class NetworkFacade extends BaseFacade {
    public static boolean mInitialized;

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public void initComponent(Context context, String str, final CommonConfig commonConfig) {
        super.initComponent(context, str, commonConfig);
        synchronized (this) {
            mInitialized = false;
            if (Utils.checkClassExist("com.iap.ac.android.rpc.RpcProxyImpl") && Utils.checkClassExist("com.iap.ac.android.rpc.multigateway.RpcGatewayController")) {
                RpcProxyImpl rpcProxyImpl = RpcProxyImpl.getInstance(str);
                RpcAppInfo rpcAppInfo = new RpcAppInfo();
                if ("SANDBOX".equals(commonConfig.envType)) {
                    rpcAppInfo.appId = String.format(CommonConfig.SANDBOXMOCK, commonConfig.appId);
                    StringBuilder sb = new StringBuilder();
                    sb.append(rpcAppInfo.appId);
                    sb.append("_ANDROID");
                    rpcAppInfo.appKey = sb.toString();
                } else {
                    rpcAppInfo.appId = commonConfig.appId;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(commonConfig.appId);
                    sb2.append("_ANDROID");
                    rpcAppInfo.appKey = sb2.toString();
                }
                String authCodeForSecurityGuard = SignatureUtils.getAuthCodeForSecurityGuard(context, "0a6a", commonConfig.envType, commonConfig.gpSignature);
                try {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("authCode for SG is: ");
                    sb3.append(authCodeForSecurityGuard);
                    ACLog.i(Constants.TAG, sb3.toString());
                    if (Utils.checkClassExist(SecurityConstants.SG_CLASS)) {
                        SecurityGuardManager.getInstance(context, authCodeForSecurityGuard);
                    }
                } catch (Throwable th) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("init security guard exception, errorMessage is: ");
                    sb4.append(Utils.formatSecurityGuardException(th));
                    ACLog.e(Constants.TAG, sb4.toString());
                }
                rpcAppInfo.authCode = authCodeForSecurityGuard;
                rpcAppInfo.rpcGateWayUrl = commonConfig.gatewayUrl;
                rpcAppInfo.addHeader("workspaceId", commonConfig.getWorkspaceId());
                rpcProxyImpl.setSslPinningPlugin(new SslPinningPlugin() { // from class: com.iap.ac.android.biz.common.internal.foundation.facade.NetworkFacade.1
                    @Override // com.iap.ac.android.common.rpc.interfaces.SslPinningPlugin
                    public void verifyConnection(HttpsURLConnection httpsURLConnection) throws SSLException {
                        if (httpsURLConnection == null || httpsURLConnection.getURL() == null) {
                            return;
                        }
                        String host = httpsURLConnection.getURL().getHost();
                        try {
                            if (TextUtils.equals(Uri.parse(commonConfig.gatewayUrl).getHost(), host)) {
                                IAPSslPinner.INSTANCE.verifyConnection(httpsURLConnection);
                            }
                        } catch (SSLException e) {
                            ACLogEvent newLogger = ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_SSLPINNING_CHECK_FAIL);
                            StringBuilder a2 = a.a("Verify ssl pinning error! error: ");
                            a2.append(e.getMessage());
                            newLogger.addParams("resultMessage", a2.toString()).addParams("sdkVersion", "2.37.0").addParams("url", host).setEventType(LogEventType.CRUCIAL_LOG).event();
                            throw e;
                        }
                    }
                });
                rpcProxyImpl.initialize(context, rpcAppInfo);
                RPCProxyHost.setRpcProxy(rpcProxyImpl, str);
                RpcGatewayController.initGatewayController(context, str);
                ACLog.i(Constants.TAG, "Network component initialize finish");
                mInitialized = true;
                return;
            }
            FoundationProxy.getInstance(str).setNetworkType(FoundationProxy.NetworkType.NETWORK_TYPE_EXTERNAL);
            ACLog.e(Constants.TAG, "NetworkFacade init error, without dependent libraries");
        }
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public boolean isInitialized() {
        return mInitialized;
    }
}
