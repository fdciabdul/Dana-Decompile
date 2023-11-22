package com.iap.ac.android.acs.operation.biz.region.oauth;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.common.rpc.RpcException;
import com.google.common.base.Ascii;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.acs.operation.biz.region.RegionConstants;
import com.iap.ac.android.acs.operation.biz.region.RegionManager;
import com.iap.ac.android.acs.operation.biz.region.bean.TrustLoginResult;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.acs.operation.biz.region.storage.RegionEncryptStorageProvider;
import com.iap.ac.android.acs.operation.biz.region.utils.CookieUtils;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.interfaces.FacadeInvoker;
import com.iap.ac.android.common.rpc.interfaces.RpcInterceptor;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import com.iap.ac.android.rpc.RpcProxyImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class RegionOAuthInterceptor implements RpcInterceptor {
    public static final String KEY_SESSION_ID_IN_COOKIE = "ALIPAYINTLECOJSESSIONID";
    public static final Set<String> LOGIN_IGNORED_OP_LIST;
    public static final String TAG = "RegionOAuthInterceptor";
    public static final byte[] PlaceComponentResult = {112, 91, -28, 61, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 66;
    public final Object mGetAuthCodeLock = new Object();
    public final ReentrantLock mInterceptorLock = new ReentrantLock();
    public final AtomicInteger mAtomicCounter = new AtomicInteger(0);
    public final ThreadLocal<Boolean> mInLoop = new ThreadLocal<>();
    public final TrustLoginProcessor mTrustLoginProcessor = new TrustLoginProcessor();
    public boolean mAuthLoginResult = false;

    static {
        HashSet hashSet = new HashSet();
        LOGIN_IGNORED_OP_LIST = hashSet;
        hashSet.add(RegionConstants.TRUST_LOGIN);
        hashSet.add(RegionConstants.LOGOUT);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.iap.ac.android.acs.operation.biz.region.oauth.RegionOAuthInterceptor.PlaceComponentResult
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r7 = r7 * 12
            int r7 = 15 - r7
            int r9 = r9 * 3
            int r9 = 16 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r4 = 0
            r8 = r7
            goto L2e
        L17:
            r3 = 0
        L18:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r6
        L2e:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + 2
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.operation.biz.region.oauth.RegionOAuthInterceptor.a(short, int, int, java.lang.Object[]):void");
    }

    private boolean checkUserId() {
        synchronized (this) {
            String str = RegionEncryptStorageProvider.getInstance(RegionManager.getInstance().getContext()).get(RegionConstants.KEY_TRUST_LOGIN_RESULT);
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            TrustLoginResult trustLoginResult = (TrustLoginResult) JsonUtils.fromJson(str, TrustLoginResult.class);
            if (trustLoginResult == null) {
                return true;
            }
            String openId = SPIManager.getInstance().getOpenId();
            if (TextUtils.isEmpty(openId)) {
                return true;
            }
            boolean equals = openId.equals(trustLoginResult.clientUserId);
            if (!equals) {
                RegionEncryptStorageProvider.getInstance(RegionManager.getInstance().getContext()).clear();
                CookieUtils.clearCookies(RegionManager.getInstance().getContext(), trustLoginResult.domainName, trustLoginResult.sessionIdKey);
            }
            return !equals;
        }
    }

    private Set<String> getLoginIgnoredOpSet() {
        return LOGIN_IGNORED_OP_LIST;
    }

    private void tryToLogin() {
        int incrementAndGet;
        TrustLoginResult trustLogin;
        SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("RegionOAuthInterceptor#tryToLogin, tryToLogin, thread: ");
        try {
            byte b = (byte) (PlaceComponentResult[15] + 1);
            byte b2 = (byte) (-PlaceComponentResult[15]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[15]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-PlaceComponentResult[15]), objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            sb.append(" enter tryToLogin");
            ACLog.i(RegionConstants.TAG, sb.toString());
            synchronized (this) {
                incrementAndGet = this.mAtomicCounter.incrementAndGet();
                this.mInterceptorLock.lock();
            }
            StringBuilder a2 = a.a("RegionOAuthInterceptor#tryToLogin, tryToLogin, thread: ");
            try {
                byte b4 = (byte) (PlaceComponentResult[15] + 1);
                byte b5 = (byte) (-PlaceComponentResult[15]);
                Object[] objArr3 = new Object[1];
                a(b4, b5, (byte) (b5 - 1), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b6 = (byte) (-PlaceComponentResult[15]);
                Object[] objArr4 = new Object[1];
                a(b6, (byte) (b6 - 1), (byte) (-PlaceComponentResult[15]), objArr4);
                a2.append(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getName());
                a2.append(" get lock, cntInQueue: ");
                a2.append(incrementAndGet);
                ACLog.i(RegionConstants.TAG, a2.toString());
                synchronized (this.mGetAuthCodeLock) {
                    try {
                        try {
                            this.mInLoop.set(Boolean.TRUE);
                            if (incrementAndGet <= 1 || !this.mAuthLoginResult) {
                                String instanceId = InstanceInfo.getInstanceId(RegionManager.getInstance().getContext());
                                String openId = SPIManager.getInstance().getOpenId();
                                if (!TextUtils.isEmpty(instanceId) && !TextUtils.isEmpty(openId) && (trustLogin = this.mTrustLoginProcessor.trustLogin(openId, instanceId)) != null && trustLogin.success) {
                                    this.mAuthLoginResult = true;
                                    CookieUtils.setCookieParts(trustLogin.domainName, trustLogin.sessionIdKey, trustLogin.sessionId);
                                    RegionEncryptStorageProvider.getInstance(RegionManager.getInstance().getContext()).save(RegionConstants.KEY_TRUST_LOGIN_RESULT, JsonUtils.toJson(trustLogin));
                                }
                            }
                            this.mAtomicCounter.decrementAndGet();
                            this.mInterceptorLock.unlock();
                            this.mInLoop.set(Boolean.FALSE);
                        } catch (Throwable th) {
                            this.mAtomicCounter.decrementAndGet();
                            this.mInterceptorLock.unlock();
                            this.mInLoop.set(Boolean.FALSE);
                            if (!this.mAuthLoginResult) {
                                throw new RpcException((Integer) 2000, "Oops! System busy. Try again later!");
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("OAuthInterceptor, wait exception: ");
                        sb2.append(e);
                        ACLog.e(RegionConstants.TAG, sb2.toString());
                        this.mAtomicCounter.decrementAndGet();
                        this.mInterceptorLock.unlock();
                        this.mInLoop.set(Boolean.FALSE);
                        if (!this.mAuthLoginResult) {
                            throw new RpcException((Integer) 2000, "Oops! System busy. Try again later!");
                        }
                    }
                    if (!this.mAuthLoginResult) {
                        throw new RpcException((Integer) 2000, "Oops! System busy. Try again later!");
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

    public String getLoginSessionKeyInCookie() {
        return KEY_SESSION_ID_IN_COOKIE;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method) {
        return null;
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public void onBeforeSend(RpcRequest rpcRequest) {
        ACLog.i(RegionConstants.TAG, "RegionOAuthInterceptor#onBeforeSend, before send request");
        if (RegionRPCConfigCenter.INSTANCE.isDirect()) {
            if (rpcRequest == null) {
                ACLog.w(RegionConstants.TAG, "RegionOAuthInterceptor, rpcRequest is null");
                return;
            }
            RpcAppInfo rpcAppInfo = rpcRequest.getRpcAppInfo();
            if (rpcAppInfo == null) {
                rpcAppInfo = new RpcAppInfo(RpcProxyImpl.getInstance("region_biz").getRpcAppInfo());
            }
            Map<String, String> map = rpcAppInfo.headers;
            if (RegionConstants.TRUST_LOGIN.equals(rpcRequest.operationType)) {
                map.put("regionRpcType", "SERVICE_PROXY");
            } else {
                map.put("regionRpcType", "DIRECT");
            }
            rpcRequest.setRpcAppInfo(rpcAppInfo);
            Set<String> loginIgnoredOpSet = getLoginIgnoredOpSet();
            if (loginIgnoredOpSet == null || !loginIgnoredOpSet.contains(rpcRequest.operationType)) {
                String loginSessionKeyInCookie = getLoginSessionKeyInCookie();
                String str = rpcAppInfo.rpcGateWayUrl;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(loginSessionKeyInCookie)) {
                    return;
                }
                if (TextUtils.isEmpty(CookieUtils.getCookie(str, loginSessionKeyInCookie)) || checkUserId()) {
                    tryToLogin();
                }
            }
        }
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.RpcInterceptor
    public RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method) {
        ACLog.i(RegionConstants.TAG, "RegionOAuthInterceptor#onExceptionOccurred, on exception occurred");
        if (RegionRPCConfigCenter.INSTANCE.isDirect()) {
            if (rpcRequest != null && th != null) {
                if (th instanceof RpcException) {
                    RpcException rpcException = (RpcException) th;
                    Set<String> loginIgnoredOpSet = getLoginIgnoredOpSet();
                    if (loginIgnoredOpSet != null && loginIgnoredOpSet.contains(rpcRequest.operationType)) {
                        ACLog.i(RegionConstants.TAG, "AutoOAuthInterceptor, on exception, skip login and holdLogin rpc");
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
                                ACLog.e(RegionConstants.TAG, sb.toString());
                            }
                        } else {
                            ACLog.e(RegionConstants.TAG, "AutoOAuthInterceptor, perform OAuth failed, skip it.");
                        }
                    }
                }
                return null;
            }
            ACLog.i(RegionConstants.TAG, "RegionOAuthInterceptor#onExceptionOccurred, on exception, rpcRequest or throws is null");
            return null;
        }
        return null;
    }
}
