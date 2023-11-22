package com.iap.ac.android.acs.operation.biz.region.foundation.facade;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.iap.ac.android.acs.operation.biz.region.config.RegionCommonConfig;
import com.iap.ac.android.acs.operation.biz.region.foundation.BaseRegionFacade;
import com.iap.ac.android.acs.operation.biz.region.utils.SignatureUtils;
import com.iap.ac.android.biz.common.rpc.ssl.IAPSslPinner;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.interfaces.SslPinningPlugin;
import com.iap.ac.android.rpc.RpcProxyImpl;
import com.iap.ac.android.rpc.multigateway.RpcGatewayController;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

/* loaded from: classes8.dex */
public class RegionNetworkFacade extends BaseRegionFacade {
    public static boolean mInitialized;

    @Override // com.iap.ac.android.acs.operation.biz.region.foundation.BaseRegionFacade
    public void initComponent(Context context, String str, final RegionCommonConfig regionCommonConfig) {
        super.initComponent(context, str, regionCommonConfig);
        synchronized (this) {
            mInitialized = false;
            if (Utils.checkClassExist("com.iap.ac.android.rpc.RpcProxyImpl") && Utils.checkClassExist("com.iap.ac.android.rpc.multigateway.RpcGatewayController")) {
                RpcProxyImpl rpcProxyImpl = RpcProxyImpl.getInstance(str);
                RpcAppInfo rpcAppInfo = new RpcAppInfo();
                rpcAppInfo.appId = regionCommonConfig.appId;
                StringBuilder sb = new StringBuilder();
                sb.append(regionCommonConfig.appId);
                sb.append("_ANDROID");
                rpcAppInfo.appKey = sb.toString();
                String authCodeForSecurityGuard = SignatureUtils.getAuthCodeForSecurityGuard(context, "0a6a", regionCommonConfig.envType, regionCommonConfig.gpSignature);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("authCode for SG is: ");
                    sb2.append(authCodeForSecurityGuard);
                    ACLog.i("IAPConnectPlugin", sb2.toString());
                    SecurityGuardManager.getInstance(context, authCodeForSecurityGuard);
                } catch (Throwable th) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("init security guard exception, errorMessage is: ");
                    sb3.append(Utils.formatSecurityGuardException(th));
                    ACLog.e("IAPConnectPlugin", sb3.toString());
                }
                rpcAppInfo.authCode = authCodeForSecurityGuard;
                rpcAppInfo.rpcGateWayUrl = regionCommonConfig.gatewayUrl;
                rpcAppInfo.addHeader("workspaceId", regionCommonConfig.workerSpaceId);
                rpcProxyImpl.setSslPinningPlugin(new SslPinningPlugin() { // from class: com.iap.ac.android.acs.operation.biz.region.foundation.facade.RegionNetworkFacade.1
                    @Override // com.iap.ac.android.common.rpc.interfaces.SslPinningPlugin
                    public void verifyConnection(HttpsURLConnection httpsURLConnection) throws SSLException {
                        if (httpsURLConnection == null || httpsURLConnection.getURL() == null) {
                            return;
                        }
                        try {
                            if (TextUtils.equals(Uri.parse(regionCommonConfig.gatewayUrl).getHost(), httpsURLConnection.getURL().getHost())) {
                                IAPSslPinner.INSTANCE.verifyConnection(httpsURLConnection);
                            }
                        } catch (SSLException e) {
                            throw e;
                        }
                    }
                });
                rpcProxyImpl.initialize(context, rpcAppInfo);
                RPCProxyHost.setRpcProxy(rpcProxyImpl, str);
                RpcGatewayController.initGatewayController(context, str);
                ACLog.i("IAPConnectPlugin", "Network component initialize finish");
                mInitialized = true;
                return;
            }
            ACLog.e("IAPConnectPlugin", "NetworkFacade init error, without dependent libraries");
        }
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.foundation.BaseRegionFacade
    public boolean isInitialized() {
        return mInitialized;
    }
}
