package com.iap.ac.android.biz.common.internal.oauth;

import android.text.TextUtils;
import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.IAuthLoginCallback;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.biz.common.internal.oauth.holdlogin.HoldLoginProcessor;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.biz.common.utils.cookie.CookieUtils;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public abstract class BaseRewardsAutoOAuthInterceptor implements RpcInterceptor, IAuthLoginCallback {
    public static final String KEY_OPERATION_TYPE_PREFIX = "ap.alipayplusrewards";
    public String mBizCode;
    public RewardsOAuthManager mOAuthManager;
    public static final byte[] PlaceComponentResult = {88, 72, 91, 85, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 99;
    public final Object mGetAuthCodeLock = new Object();
    public ReentrantLock mInterceptorLock = new ReentrantLock();
    public AtomicInteger mAtomicCounter = new AtomicInteger(0);
    public boolean mAuthLoginResult = false;
    public boolean mAuthLoginHandled = false;
    public ThreadLocal<Boolean> mInLoop = new ThreadLocal<>();
    public HoldLoginProcessor mHoldLoginProcessor = new HoldLoginProcessor();

    public BaseRewardsAutoOAuthInterceptor(String str) {
        this.mBizCode = str;
        this.mOAuthManager = new RewardsOAuthManager(ACManager.getInstance().getContext(), this.mBizCode, getLoginSessionKeyInCookie());
        AccountManager.getInstance(this.mBizCode).setRewardsOAuthManager(this.mOAuthManager);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r9 = r9 + 4
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r0 = com.iap.ac.android.biz.common.internal.oauth.BaseRewardsAutoOAuthInterceptor.PlaceComponentResult
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            int r9 = r9 + 1
            r3 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L37:
            int r8 = r8 + r9
            int r8 = r8 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.internal.oauth.BaseRewardsAutoOAuthInterceptor.b(short, short, byte, java.lang.Object[]):void");
    }

    private boolean checkUserId() {
        boolean clearLoginStatus;
        synchronized (this) {
            clearLoginStatus = AccountManager.getInstance(this.mBizCode).clearLoginStatus();
        }
        return clearLoginStatus;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01ad A[Catch: all -> 0x01e5, Exception -> 0x01e7, TRY_LEAVE, TryCatch #4 {Exception -> 0x01e7, blocks: (B:12:0x00d7, B:14:0x00e0, B:16:0x00e4, B:18:0x013a, B:25:0x014d, B:27:0x015c, B:38:0x01a9, B:40:0x01ad, B:28:0x0168, B:20:0x0140, B:22:0x0146, B:29:0x0179, B:33:0x0188, B:37:0x0194), top: B:81:0x00d7, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void tryToLogin() {
        /*
            Method dump skipped, instructions count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.internal.oauth.BaseRewardsAutoOAuthInterceptor.tryToLogin():void");
    }

    public void clear() {
        ACUserInfoManager.getInstance(this.mBizCode).setUserInfo(null);
    }

    public abstract Set<String> getLoginIgnoredOpSet();

    public abstract String getLoginSessionKeyInCookie();

    public abstract OAuthConfig getOAuthConfig();

    public abstract boolean isLoginStatusRequired(String str);

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
        ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, after received");
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public void onBeforeSend(RpcRequest rpcRequest) {
        ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, before send request");
        if (FoundationProxy.getInstance(this.mBizCode).getNetworkType() != FoundationProxy.NetworkType.NETWORK_TYPE_ACRPC) {
            return;
        }
        if (rpcRequest == null) {
            ACLog.w(Constants.TAG, "RewardsAutoOAuthInterceptor, rpcRequest is null");
        } else if (ConfigCenter.INSTANCE.isRewardsInterceptorDisable()) {
            ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, onBeforeSend, the config:aplusrewards_interceptor_disable is true");
        } else if (!isLoginStatusRequired(rpcRequest.operationType)) {
            ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, onBeforeSend, the operationType don't need require login status");
        } else if (getLoginIgnoredOpSet().contains(rpcRequest.operationType)) {
            ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, onBeforeSend, skip login and holdLogin rpc");
        } else {
            String loginSessionKeyInCookie = getLoginSessionKeyInCookie();
            String gateWayUrl = FoundationProxy.getInstance(this.mBizCode).getGateWayUrl();
            if (TextUtils.isEmpty(gateWayUrl) || TextUtils.isEmpty(loginSessionKeyInCookie)) {
                return;
            }
            if (TextUtils.isEmpty(CookieUtils.getCookie(gateWayUrl, loginSessionKeyInCookie)) || !checkUserId()) {
                tryToLogin();
            }
        }
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
        ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, on exception occurred");
        if (FoundationProxy.getInstance(this.mBizCode).getNetworkType() != FoundationProxy.NetworkType.NETWORK_TYPE_ACRPC) {
            return null;
        }
        if (ConfigCenter.INSTANCE.isRewardsInterceptorDisable()) {
            ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, on exception, the config:aplusrewards_interceptor_disable is true");
            return null;
        } else if (rpcRequest != null && th != null) {
            String str = rpcRequest.operationType;
            if (str == null) {
                ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, on exception, operationType is null");
                return null;
            } else if (!str.startsWith("ap.alipayplusrewards")) {
                ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, on exception, the operationType is not start with ap.alipayplusrewards");
                return null;
            } else {
                if (th instanceof RpcException) {
                    RpcException rpcException = (RpcException) th;
                    Set<String> loginIgnoredOpSet = getLoginIgnoredOpSet();
                    if (loginIgnoredOpSet != null && loginIgnoredOpSet.contains(rpcRequest.operationType)) {
                        ACLog.i(Constants.TAG, "RewardsAutoOAuthInterceptor, on exception, skip login and holdLogin rpc");
                        return null;
                    } else if (rpcException.getCode() == 2000 && (this.mInLoop.get() == null || !this.mInLoop.get().booleanValue())) {
                        tryToLogin();
                        if (this.mAuthLoginResult) {
                            try {
                                Object invokeMethod = facadeInvoker.invokeMethod(method, rpcRequest);
                                RpcExceptionInterceptResult rpcExceptionInterceptResult = new RpcExceptionInterceptResult();
                                rpcExceptionInterceptResult.isHandled = true;
                                rpcExceptionInterceptResult.response = invokeMethod;
                                return rpcExceptionInterceptResult;
                            } catch (Exception e) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("RewardsAutoOAuthInterceptor, resend request exception: ");
                                sb.append(e);
                                ACLog.e(Constants.TAG, sb.toString());
                            }
                        } else {
                            ACLog.e(Constants.TAG, "RewardsAutoOAuthInterceptor, perform OAuth failed, skip it.");
                        }
                    }
                }
                return null;
            }
        } else {
            ACLog.i(Constants.TAG, "AuthOAuthInterceptor, on exception, rpcRequest or throws is null");
            return null;
        }
    }

    @Override // com.iap.ac.android.biz.common.callback.IAuthLoginCallback
    public void onFailed() {
        synchronized (this.mGetAuthCodeLock) {
            this.mAuthLoginResult = false;
            this.mAuthLoginHandled = true;
            this.mGetAuthCodeLock.notifyAll();
        }
    }

    @Override // com.iap.ac.android.biz.common.callback.IAuthLoginCallback
    public void onSuccess() {
        synchronized (this.mGetAuthCodeLock) {
            this.mAuthLoginResult = true;
            this.mAuthLoginHandled = true;
            this.mGetAuthCodeLock.notifyAll();
        }
    }
}
