package com.alibaba.griver.init.rpc;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.common.config.ConfigUtils;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.init.IAPConfig;
import com.alibaba.griver.init.rpc.interceptor.GriverAccelerateUrlInterceptor;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alipay.plus.security.lite.ISecurityGuardLiteManager;
import com.alipay.plus.security.lite.SecLiteException;
import com.alipay.plus.security.lite.SecurityGuardLiteManager;
import com.alipay.plus.security.lite.SecurityGuardLiteParamContext;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.rpc.ssl.IAPSslPinner;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.interfaces.SignRpcRequestPlugin;
import com.iap.ac.android.common.rpc.interfaces.SignV2RpcRequestPlugin;
import com.iap.ac.android.common.rpc.interfaces.SslPinningPlugin;
import com.iap.ac.android.rpc.RpcProxyImpl;
import com.iap.ac.android.rpc.multigateway.RpcGatewayController;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

/* loaded from: classes3.dex */
public class GriverRpcUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String f6644a = null;
    private static boolean b = true;

    public static void init(final Context context, final IAPConfig iAPConfig) {
        RpcProxyImpl rpcProxyImpl = RpcProxyImpl.getInstance("GriverAppContainer");
        RpcAppInfo rpcAppInfo = new RpcAppInfo();
        rpcAppInfo.appId = iAPConfig.getAppId();
        StringBuilder sb = new StringBuilder();
        sb.append(iAPConfig.getAppId());
        sb.append("_ANDROID");
        rpcAppInfo.appKey = sb.toString();
        rpcAppInfo.authCode = iAPConfig.getAuthCode();
        rpcAppInfo.rpcGateWayUrl = iAPConfig.getExtra().getGatewayUrl();
        rpcAppInfo.addHeader("workspaceId", iAPConfig.getExtra().getWorkSpaceId());
        rpcProxyImpl.setSslPinningPlugin(new SslPinningPlugin() { // from class: com.alibaba.griver.init.rpc.GriverRpcUtils.1
            @Override // com.iap.ac.android.common.rpc.interfaces.SslPinningPlugin
            public final void verifyConnection(HttpsURLConnection httpsURLConnection) throws SSLException {
                if (httpsURLConnection == null || httpsURLConnection.getURL() == null || !ReflectUtils.classExist("com.iap.ac.android.biz.common.rpc.ssl.IAPSslPinner")) {
                    return;
                }
                if (TextUtils.equals(Uri.parse(IAPConfig.this.getExtra().getGatewayUrl()).getHost(), httpsURLConnection.getURL().getHost())) {
                    IAPSslPinner.INSTANCE.verifyConnection(httpsURLConnection);
                }
            }
        });
        rpcProxyImpl.setCanMonit(false);
        rpcProxyImpl.initialize(context, rpcAppInfo);
        rpcProxyImpl.addRpcInterceptor(new GriverAccelerateUrlInterceptor());
        RPCProxyHost.setRpcProxy(rpcProxyImpl, "GriverAppContainer");
        RpcGatewayController.initGatewayController(context, "GriverAppContainer");
        if (Utils.checkClassExist("com.alipay.plus.security.lite.SecurityGuardLiteManager")) {
            RPCProxyHost.getInstance("GriverAppContainer").setSignV2Request(new SignV2RpcRequestPlugin() { // from class: com.alibaba.griver.init.rpc.GriverRpcUtils.2
                @Override // com.iap.ac.android.common.rpc.interfaces.SignV2RpcRequestPlugin
                public final String signV2Request(RpcAppInfo rpcAppInfo2, String str, String str2, Map<String, String> map) {
                    if (!GriverRpcUtils.b || GriverEnv.isUseSignV2Request()) {
                        Context context2 = context;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(iAPConfig.getAppId());
                        sb2.append("_ANDROID_PROD");
                        return GriverRpcUtils.a(context2, sb2.toString(), iAPConfig.getAuthCode(), 4, str2);
                    } else if (ConfigUtils.canUseTopWhiteList(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_RPC_SIGNV2_CONFIG_GRIVER, ""), str, false)) {
                        Context context3 = context;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iAPConfig.getAppId());
                        sb3.append("_ANDROID_PROD");
                        return GriverRpcUtils.a(context3, sb3.toString(), iAPConfig.getAuthCode(), 4, str2);
                    } else {
                        return null;
                    }
                }
            });
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("yw_1222_");
        sb2.append(iAPConfig.getAuthCode());
        sb2.append("_prod");
        if (a(context, sb2.toString()) == 0) {
            GriverExecutors.getScheduledExecutor().schedule(new Runnable() { // from class: com.alibaba.griver.init.rpc.GriverRpcUtils.3
                @Override // java.lang.Runnable
                public final void run() {
                    GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
                    if (griverAllRecordsExtension != null) {
                        griverAllRecordsExtension.addRecord(new Record.Builder(RecordError.ERROR_INITIALIZE_NO_KEY_RESOURCE).build());
                    }
                }
            }, 2L, TimeUnit.SECONDS);
        }
        if (!Utils.checkClassExist(SecurityConstants.SG_CLASS)) {
            b = false;
            GriverLogger.w(Constants.TAG, "check security guard not exist");
            return;
        }
        try {
            f6644a = GriverSignatureUtils.getAuthCodeForSecurityGuard(context, iAPConfig.getAuthCode(), iAPConfig.getEnv(), iAPConfig.getGpSignature());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("authCode for SG is: ");
            sb3.append(f6644a);
            GriverLogger.d("GriverRpcUtils", sb3.toString());
            SecurityGuardManager.getInstance(context, f6644a);
        } catch (Exception e) {
            GriverLogger.e("GriverRpcUtils", "init security guard exception, errorCode is: ", e);
        }
        RPCProxyHost.getInstance("GriverAppContainer").setSignRequest(new SignRpcRequestPlugin() { // from class: com.alibaba.griver.init.rpc.GriverRpcUtils.4
            @Override // com.iap.ac.android.common.rpc.interfaces.SignRpcRequestPlugin
            public final String signRequest(RpcAppInfo rpcAppInfo2, String str, Map<String, String> map) {
                Context context2 = context;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(iAPConfig.getAppId());
                sb4.append("_ANDROID");
                return GriverRpcUtils.b(context2, sb4.toString(), GriverRpcUtils.f6644a, 4, str);
            }
        });
        GriverLogger.d("GriverRpcUtils", "Network component initialize finish");
    }

    private static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(Context context, String str, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            GriverLogger.d("GriverRpcUtils", "the appkey is empty, will not do signing.");
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str3);
        SecurityGuardLiteParamContext securityGuardLiteParamContext = new SecurityGuardLiteParamContext();
        securityGuardLiteParamContext.paramMap = hashMap;
        securityGuardLiteParamContext.requestType = i;
        securityGuardLiteParamContext.appKey = str;
        try {
            ISecurityGuardLiteManager securityGuardLiteManager = SecurityGuardLiteManager.getInstance(context, str2);
            if (securityGuardLiteManager == null) {
                GriverLogger.d("GriverRpcUtils", "request data sign fail, sgMng is null");
                return null;
            }
            return securityGuardLiteManager.signRequest(securityGuardLiteParamContext, str2);
        } catch (SecLiteException e) {
            GriverLogger.e("GriverRpcUtils", String.format("Cannot sign request! appKey = %s, authCode = %s, requestType = %d", str, str2, Integer.valueOf(i)), e);
            GriverMonitor.commonException("SecurityGuardLiteException", "GriverAppContainer", String.valueOf(e.getErrorCode()), "V2 sign fail", null);
            return null;
        } catch (Throwable th) {
            GriverLogger.e("GriverRpcUtils", String.format("Cannot sign request! appKey = %s, authCode = %s, requestType = %d", str, str2, Integer.valueOf(i)), th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String str, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            GriverLogger.d("GriverRpcUtils", "the appkey is empty, will not do signing.");
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str3);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = i;
        securityGuardParamContext.appKey = str;
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager == null) {
                GriverLogger.d("GriverRpcUtils", "request data sign fail, sgMng is null");
                return null;
            }
            ISecureSignatureComponent secureSignatureComp = securityGuardManager.getSecureSignatureComp();
            if (secureSignatureComp == null) {
                GriverLogger.d("GriverRpcUtils", "request data sign fail, ssComp is null");
                return null;
            }
            String signRequest = secureSignatureComp.signRequest(securityGuardParamContext, str2);
            GriverLogger.d("GriverRpcUtils", String.format("Sign success: appKey = %s, authCode = %s, requestType = %d, sign = %s, content = %s", str, str2, Integer.valueOf(i), signRequest, str3));
            return signRequest;
        } catch (Exception e) {
            GriverLogger.e("GriverRpcUtils", String.format("Cannot sign request! appKey = %s, authCode = %s, requestType = %d", str, str2, Integer.valueOf(i)), e);
            return null;
        }
    }
}
