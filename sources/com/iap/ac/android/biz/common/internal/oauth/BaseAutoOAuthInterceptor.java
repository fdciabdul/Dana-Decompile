package com.iap.ac.android.biz.common.internal.oauth;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.IAuthLoginCallback;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.biz.common.internal.oauth.holdlogin.HoldLoginProcessor;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.instance.InstanceInfo;
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
public abstract class BaseAutoOAuthInterceptor implements RpcInterceptor, IAuthLoginCallback {
    public static final String KEY_OPERATION_TYPE_PREFIX = "ap.alipayplusrewards";
    public String mBizCode;
    public OAuthManager mOAuthManager;
    public static final byte[] PlaceComponentResult = {97, -108, 86, -98, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 70;
    public final Object mGetAuthCodeLock = new Object();
    public ReentrantLock mInterceptorLock = new ReentrantLock();
    public AtomicInteger mAtomicCounter = new AtomicInteger(0);
    public boolean mAuthLoginResult = false;
    public boolean mAuthLoginHandled = false;
    public ThreadLocal<Boolean> mInLoop = new ThreadLocal<>();
    public HoldLoginProcessor mHoldLoginProcessor = new HoldLoginProcessor();

    public BaseAutoOAuthInterceptor(String str) {
        this.mBizCode = str;
        this.mOAuthManager = new OAuthManager(ACManager.getInstance().getContext(), this.mBizCode, getLoginSessionKeyInCookie());
        AccountManager.getInstance(this.mBizCode).setoAuthManager(this.mOAuthManager);
    }

    private static void c(byte b, short s, int i, Object[] objArr) {
        byte[] bArr = PlaceComponentResult;
        int i2 = (s * 3) + 13;
        int i3 = 106 - (i * 7);
        int i4 = 16 - (b * 12);
        byte[] bArr2 = new byte[i2];
        int i5 = i2 - 1;
        int i6 = 0;
        if (bArr == null) {
            i4++;
            i3 = i4 + i3 + 2;
        }
        while (true) {
            bArr2[i6] = (byte) i3;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i6++;
            byte b2 = bArr[i4];
            i4++;
            i3 = i3 + b2 + 2;
        }
    }

    private boolean checkUserId() {
        boolean clearLoginStatus;
        synchronized (this) {
            clearLoginStatus = AccountManager.getInstance(this.mBizCode).clearLoginStatus();
        }
        return clearLoginStatus;
    }

    private void tryToLogin() {
        int incrementAndGet;
        ACLogEvent addParams;
        Long valueOf;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_OAUTH_INTERCEPTOR_ENTER).event();
        StringBuilder sb = new StringBuilder();
        sb.append("AutoOAuthInterceptor, tryToLogin, thread: ");
        try {
            boolean z = true;
            byte b = (byte) (PlaceComponentResult[15] - 1);
            byte b2 = PlaceComponentResult[15];
            Object[] objArr = new Object[1];
            c(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = PlaceComponentResult[15];
            Object[] objArr2 = new Object[1];
            c(b3, (byte) (b3 - 1), PlaceComponentResult[15], objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            sb.append(" enter tryToLogin");
            ACLog.i(Constants.TAG, sb.toString());
            synchronized (this) {
                incrementAndGet = this.mAtomicCounter.incrementAndGet();
                this.mInterceptorLock.lock();
            }
            StringBuilder a2 = a.a("AutoOAuthInterceptor, tryToLogin, thread: ");
            try {
                byte b4 = (byte) (PlaceComponentResult[15] - 1);
                byte b5 = PlaceComponentResult[15];
                Object[] objArr3 = new Object[1];
                c(b4, b5, (byte) (b5 - 1), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b6 = PlaceComponentResult[15];
                Object[] objArr4 = new Object[1];
                c(b6, (byte) (b6 - 1), PlaceComponentResult[15], objArr4);
                a2.append(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getName());
                a2.append(" get lock, cntInQueue: ");
                a2.append(incrementAndGet);
                ACLog.i(Constants.TAG, a2.toString());
                synchronized (this.mGetAuthCodeLock) {
                    try {
                        try {
                            this.mInLoop.set(Boolean.TRUE);
                            if (incrementAndGet <= 1 || !this.mAuthLoginResult) {
                                this.mAuthLoginResult = false;
                                this.mAuthLoginHandled = false;
                                String fetch = ACManager.getInstance().fetch(ACManager.getInstance().getClientKeyStorageKey(this.mBizCode));
                                String instanceId = InstanceInfo.getInstanceId(ACManager.getInstance().getContext());
                                String openId = ACUserInfoManager.getInstance(this.mBizCode).getOpenId();
                                if (!OAuthUtil.getInstance().loginPreCheck(fetch, openId)) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("AutoOAuthInterceptor, begin to perform auth login, clientKey:");
                                    sb2.append(fetch != null);
                                    sb2.append(", openId: ");
                                    if (openId == null) {
                                        z = false;
                                    }
                                    sb2.append(z);
                                    ACLog.i(Constants.TAG, sb2.toString());
                                    this.mOAuthManager.doAuthLogin(getOAuthConfig(), this);
                                } else {
                                    ACLog.i(Constants.TAG, "AutoOAuthInterceptor, begin to perform hold Login");
                                    if (this.mHoldLoginProcessor.holdLoginInWorker(instanceId, fetch, openId)) {
                                        this.mAuthLoginResult = true;
                                        this.mAuthLoginHandled = true;
                                        ACLog.i(Constants.TAG, "AutoOAuthInterceptor, hold login success");
                                    } else {
                                        ACLog.i(Constants.TAG, "AutoOAuthInterceptor, hold login fail, client key expired, begin auth login in");
                                        this.mOAuthManager.doAuthLogin(getOAuthConfig(), this);
                                    }
                                }
                                if (!this.mAuthLoginHandled) {
                                    this.mGetAuthCodeLock.wait();
                                }
                            }
                            this.mAtomicCounter.decrementAndGet();
                            this.mInterceptorLock.unlock();
                            this.mInLoop.set(Boolean.FALSE);
                            addParams = ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_OAUTH_INTERCEPTOR).addParams("result", this.mAuthLoginResult ? "T" : LogConstants.RESULT_FALSE);
                            valueOf = Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime);
                        } catch (Exception e) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("OAuthInterceptor, wait exception: ");
                            sb3.append(e);
                            ACLog.e(Constants.TAG, sb3.toString());
                            this.mAtomicCounter.decrementAndGet();
                            this.mInterceptorLock.unlock();
                            this.mInLoop.set(Boolean.FALSE);
                            addParams = ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_OAUTH_INTERCEPTOR).addParams("result", this.mAuthLoginResult ? "T" : LogConstants.RESULT_FALSE);
                            valueOf = Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime);
                        }
                        addParams.addParams("timeCost", valueOf).event();
                    } catch (Throwable th) {
                        this.mAtomicCounter.decrementAndGet();
                        this.mInterceptorLock.unlock();
                        this.mInLoop.set(Boolean.FALSE);
                        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_OAUTH_INTERCEPTOR).addParams("result", this.mAuthLoginResult ? "T" : LogConstants.RESULT_FALSE).addParams("timeCost", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)).event();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        } catch (Throwable th3) {
            Throwable cause2 = th3.getCause();
            if (cause2 == null) {
                throw th3;
            }
            throw cause2;
        }
    }

    public void clear() {
        this.mOAuthManager.startOAuthLogout();
        ACUserInfoManager.getInstance(this.mBizCode).setUserInfo(null);
    }

    public abstract Set<String> getLoginIgnoredOpSet();

    public abstract Set<String> getLoginRequiredOpSet();

    public abstract String getLoginSessionKeyInCookie();

    public abstract OAuthConfig getOAuthConfig();

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
        ACLog.i(Constants.TAG, "AutoOAuthInterceptor, after received");
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public void onBeforeSend(RpcRequest rpcRequest) {
        ACLog.i(Constants.TAG, "AutoOAuthInterceptor, before send request");
        if (FoundationProxy.getInstance(this.mBizCode).getNetworkType() != FoundationProxy.NetworkType.NETWORK_TYPE_ACRPC) {
            return;
        }
        if (rpcRequest == null) {
            ACLog.w(Constants.TAG, "AutoOAuthInterceptor, rpcRequest is null");
        } else if (getLoginRequiredOpSet().contains(rpcRequest.operationType)) {
            String loginSessionKeyInCookie = getLoginSessionKeyInCookie();
            String gateWayUrl = FoundationProxy.getInstance(this.mBizCode).getGateWayUrl();
            if (TextUtils.isEmpty(gateWayUrl) || TextUtils.isEmpty(loginSessionKeyInCookie)) {
                return;
            }
            if (OAuthUtil.getInstance().hasSessionId(gateWayUrl, loginSessionKeyInCookie) && checkUserId()) {
                return;
            }
            tryToLogin();
        }
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
        ACLog.i(Constants.TAG, "AutoOAuthInterceptor, on exception occurred");
        if (FoundationProxy.getInstance(this.mBizCode).getNetworkType() != FoundationProxy.NetworkType.NETWORK_TYPE_ACRPC) {
            return null;
        }
        if (rpcRequest != null && th != null) {
            if (!ConfigCenter.INSTANCE.isRewardsInterceptorDisable() && rpcRequest.operationType.startsWith("ap.alipayplusrewards")) {
                ACLog.i(Constants.TAG, "AuthOAuthInterceptor, on exception,A+ Rewards rpcRequest occurs exception, and it has not beend intercept by A+Payment interceptor");
                return null;
            }
            if (th instanceof RpcException) {
                RpcException rpcException = (RpcException) th;
                Set<String> loginIgnoredOpSet = getLoginIgnoredOpSet();
                if (loginIgnoredOpSet != null && loginIgnoredOpSet.contains(rpcRequest.operationType)) {
                    ACLog.i(Constants.TAG, "AutoOAuthInterceptor, on exception, skip login and holdLogin rpc");
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
                            sb.append("AutoOAuthInterceptor, resend request exception: ");
                            sb.append(e);
                            ACLog.e(Constants.TAG, sb.toString());
                        }
                    } else {
                        ACLog.e(Constants.TAG, "AutoOAuthInterceptor, perform OAuth failed, skip it.");
                    }
                }
            }
            return null;
        }
        ACLog.i(Constants.TAG, "AuthOAuthInterceptor, on exception, rpcRequest or throws is null");
        return null;
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
