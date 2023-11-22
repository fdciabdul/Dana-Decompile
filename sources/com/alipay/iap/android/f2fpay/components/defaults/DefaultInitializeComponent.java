package com.alipay.iap.android.f2fpay.components.defaults;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.ap.mobileprod.biz.f2fpay.rpc.F2fPayInitFacade;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.iap.android.common.securitydata.storage.provider.IDataStorageProvider;
import com.alipay.iap.android.common.securitydata.storage.provider.SpDataStorageProvider;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.iap.android.common.utils.DeviceUtils;
import com.alipay.iap.android.common.utils.NetworkUtils;
import com.alipay.iap.android.f2fpay.client.IF2FPayClient;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback;
import com.alipay.iap.android.f2fpay.common.F2FPayCallbacks;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.common.KeyValueAccessor;
import com.alipay.iap.android.f2fpay.common.KeyValueRegistry;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayTimeSyncComponent;
import com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.alipay.iap.android.f2fpay.otp.F2FPayOtpInfo;
import com.alipay.iap.android.f2fpay.otp.OtpInitResult;
import com.alipay.iap.android.f2fpay.util.ConvertUtils;
import com.alipay.iap.android.f2fpay.util.MonitorUtils;
import com.alipayplus.mobile.component.f2fpay.service.request.F2fPayInitRequest;
import com.alipayplus.mobile.component.f2fpay.service.result.F2fPayInitResult;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class DefaultInitializeComponent extends DefaultBaseComponent implements IF2FPayInitializeComponent {
    public static final String PLATFORM_TYPE = "ANDROID";
    private IDataStorageProvider c;
    protected IF2FPayInitializeComponent.Interceptor mInterceptor;
    protected int mPreviousRequestFinishTimeMark;
    protected String mPreviousRequestIdentity;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {95, 85, -94, TarHeader.LF_SYMLINK, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 35;

    /* renamed from: a */
    private int f6957a = -1;
    protected ReentrantLock mLocker = new ReentrantLock();
    protected ThreadLocal<Integer> mRequestTimeMark = new ThreadLocal<>();
    protected F2FPayCallbacks<IF2FPayInitializeCallback> mCallbacks = new F2FPayCallbacks<>();
    private long b = -1;
    private long d = -1;

    private int a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    private OtpInitResult a(String str, String str2) {
        String str3;
        F2fPayInitRequest f2fPayInitRequest = new F2fPayInitRequest();
        f2fPayInitRequest.tid = str;
        f2fPayInitRequest.osType = PLATFORM_TYPE;
        f2fPayInitRequest.osVersion = Build.VERSION.RELEASE;
        f2fPayInitRequest.imei = DeviceUtils.getDeviceId(getContext());
        HashMap hashMap = new HashMap();
        f2fPayInitRequest.extParams = hashMap;
        hashMap.put("seedExpire", SummaryActivity.CHECKED);
        IF2FPayInitializeComponent.Interceptor interceptor = this.mInterceptor;
        if (interceptor != null) {
            f2fPayInitRequest = interceptor.beforeExecute(f2fPayInitRequest);
        }
        F2fPayInitFacade f2fPayInitFacade = (F2fPayInitFacade) RPCProxyHost.getInterfaceProxy(F2fPayInitFacade.class);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            F2fPayInitResult init = f2fPayInitFacade.init(f2fPayInitRequest);
            if (init == null) {
                MonitorUtils.initializeOtp(BehaviorLogger.errorCode.RPC_RESULT_FAILED, "initialized otp rpc request failed: rpcResult is null", 0L, false);
                LoggerWrapper.e(F2FPayConstants.TAG, "refreshOtpInfoRpc initialized otp rpc request failed rpcResult is null ");
                return null;
            } else if (!init.success) {
                StringBuilder sb = new StringBuilder();
                sb.append("initialized otp rpc request: result.success is zero: ");
                sb.append(init.errorMessage);
                MonitorUtils.initializeOtp(BehaviorLogger.errorCode.RPC_RESULT_SUCCESS_ZERO, sb.toString(), 0L, false);
                LoggerWrapper.e(F2FPayConstants.TAG, "refreshOtpInfoRpc initialized otp rpc request: result.success is zero ");
                return null;
            } else {
                IF2FPayInitializeComponent.Interceptor interceptor2 = this.mInterceptor;
                if (interceptor2 != null) {
                    init = interceptor2.afterExecute(init);
                }
                final OtpInitResult otpInitResult = new OtpInitResult(init);
                otpInitResult.rpcTimeCostMillisecond = (int) (System.currentTimeMillis() - currentTimeMillis);
                KeyValueAccessor keyValueAccessor = keyValueAccessor();
                keyValueAccessor.save(KeyValueRegistry.QUERY_INTERVAL, otpInitResult.queryInterval);
                keyValueAccessor.save(KeyValueRegistry.QUERY_COUNT, otpInitResult.queryCount);
                saveOtpInfo(new F2FPayOtpInfo(otpInitResult.tidUidIndex, otpInitResult.otpSeed, otpInitResult.interval), str2);
                IF2FPayTimeSyncComponent iF2FPayTimeSyncComponent = (IF2FPayTimeSyncComponent) getComponent(IF2FPayTimeSyncComponent.class);
                iF2FPayTimeSyncComponent.setServerTime(otpInitResult.serverTime, otpInitResult.rpcTimeCostMillisecond);
                if (init.otpSeedValidHours > 0) {
                    long serverTime = iF2FPayTimeSyncComponent.getServerTime() + (r11 * 3600 * 1000);
                    this.b = serverTime;
                    this.c.save(F2FPayConstants.StorageKeyList.KEY_OTP_SEED_EXPIRED_TIME, String.valueOf(serverTime));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("refreshOtpInfoRpc seed will be expired after ");
                    sb2.append(this.b);
                    sb2.append("ms");
                    str3 = sb2.toString();
                } else {
                    this.c.delete(F2FPayConstants.StorageKeyList.KEY_OTP_SEED_EXPIRED_TIME);
                    str3 = "refreshOtpInfoRpc delete seed expired time";
                }
                LoggerWrapper.d(F2FPayConstants.TAG, str3);
                if (getStartRefreshFlag()) {
                    this.mCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayInitializeCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent.2
                        {
                            DefaultInitializeComponent.this = this;
                        }

                        @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                        public void invoke(IF2FPayInitializeCallback iF2FPayInitializeCallback) {
                            iF2FPayInitializeCallback.onOtpInfoChanged(otpInitResult);
                        }
                    });
                    return otpInitResult;
                }
                LoggerWrapper.e(F2FPayConstants.TAG, "refreshOtpInfoRpc stopRefreshTask called, skip callback");
                return otpInitResult;
            }
        } catch (Exception e) {
            LoggerWrapper.e(F2FPayConstants.TAG, "refreshOtpInfoRpc exception: ", e);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("refreshOtpInfoRpc exception: ");
            sb3.append(e.getMessage());
            MonitorUtils.initializeOtp(BehaviorLogger.errorCode.RPC_RESULT_EXCEPTION, sb3.toString(), 0L, false);
            return null;
        }
    }

    private void a(final String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onInitializeFailed: ");
        sb.append(str);
        LoggerWrapper.e(F2FPayConstants.TAG, sb.toString());
        this.mCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayInitializeCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent.3
            {
                DefaultInitializeComponent.this = this;
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
            public void invoke(IF2FPayInitializeCallback iF2FPayInitializeCallback) {
                iF2FPayInitializeCallback.onInitializeFailed(str);
            }
        });
    }

    public void b() {
        LoggerWrapper.d(F2FPayConstants.TAG, "onInitializeOtpSucceed");
        MonitorUtils.funnelInitOtp();
        this.mCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayInitializeCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent.4
            {
                DefaultInitializeComponent.this = this;
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
            public void invoke(IF2FPayInitializeCallback iF2FPayInitializeCallback) {
                iF2FPayInitializeCallback.onInitializeOtpSucceed();
            }
        });
    }

    private void b(String str, String str2) {
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            MonitorUtils.initializeOtp(BehaviorLogger.errorCode.DEVICE_OFFLINE, "initialized otp failed device offline", 0L, false);
        }
        if (TextUtils.isEmpty(str2)) {
            MonitorUtils.initializeOtp(BehaviorLogger.errorCode.IDENTITY_EMPTY, "initialized otp failed identity empty", 0L, false);
        }
        if (TextUtils.isEmpty(str)) {
            MonitorUtils.initializeOtp(BehaviorLogger.errorCode.TERMINAL_ID_EMPTY, "initialized otp failed terminal id empty", 0L, false);
        }
        if (getUserDelegate().checkPermission()) {
            return;
        }
        MonitorUtils.initializeOtp(BehaviorLogger.errorCode.NO_USER_PERMISSION, "initialized otp failed user permission", 0L, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r6 = r6 * 12
            int r6 = r6 + 4
            byte[] r0 = com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r8 = r8 + r6
            int r8 = r8 + 2
            int r6 = r7 + 1
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent.e(short, short, short, java.lang.Object[]):void");
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent
    public void addInitializeCallback(IF2FPayInitializeCallback iF2FPayInitializeCallback) {
        this.mCallbacks.addCallback(iF2FPayInitializeCallback);
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent
    public void asyncInitializeOtpInfo() {
        LoggerWrapper.e(F2FPayConstants.TAG, "asyncInitializeOtpInfo start");
        final String userId = getUserDelegate().getUserId();
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent.1
            {
                DefaultInitializeComponent.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                String generateTerminalIdentifier = DefaultInitializeComponent.this.generateTerminalIdentifier();
                String identity = ConvertUtils.getIdentity(userId, generateTerminalIdentifier);
                if (-1 != DefaultInitializeComponent.this.b) {
                    long serverTime = ((IF2FPayTimeSyncComponent) DefaultInitializeComponent.this.getComponent(IF2FPayTimeSyncComponent.class)).getServerTime();
                    z = DefaultInitializeComponent.this.b > serverTime;
                    DefaultInitializeComponent defaultInitializeComponent = DefaultInitializeComponent.this;
                    defaultInitializeComponent.d = defaultInitializeComponent.b - serverTime;
                } else {
                    z = true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("asyncInitializeOtpInfo otp is valid? ");
                sb.append(z);
                LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
                boolean checkExist = DefaultInitializeComponent.this.checkExist(identity);
                if (checkExist && z) {
                    LoggerWrapper.d(F2FPayConstants.TAG, "asyncInitializeOtpInfo optInfo exists, skip the Initialize RPC");
                    ((IF2FPayTimeSyncComponent) DefaultInitializeComponent.this.getComponent(IF2FPayTimeSyncComponent.class)).synchronizeTime();
                    DefaultInitializeComponent.this.b();
                    MonitorUtils.initializeOtp(BehaviorLogger.errorCode.INITIALIZE_OTP_SUCCESS_LOCAL_VALID, "initialize otp success otp is valid", 0L, true);
                    return;
                }
                if (checkExist) {
                    MonitorUtils.otpSeedExpired(DefaultInitializeComponent.this.d);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("asyncInitializeOtpInfo optInfo does not exist or expired, start initialize, expiredInterval: ");
                sb2.append(DefaultInitializeComponent.this.d);
                LoggerWrapper.d(F2FPayConstants.TAG, sb2.toString());
                DefaultInitializeComponent.this.initializeOtpInfoInWorker(generateTerminalIdentifier, identity);
            }
        });
    }

    protected boolean checkExist(String str) {
        IF2FPaySecureStorage secureStorage = getClientContext().getSecureStorage();
        if (secureStorage.checkOtpInfoExist(str)) {
            return true;
        }
        secureStorage.clear();
        return false;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent
    public void clearOtpInfo() {
        LoggerWrapper.d(F2FPayConstants.TAG, "initializeComponent clearOtpInfo");
        getClientContext().getSecureStorage().clear();
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent
    public int getRefreshInterval() {
        return this.f6957a;
    }

    @Override // com.alipay.iap.android.f2fpay.components.defaults.DefaultBaseComponent, com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent
    public void initialize(IF2FPayClient iF2FPayClient) {
        super.initialize(iF2FPayClient);
        SpDataStorageProvider spDataStorageProvider = new SpDataStorageProvider(getContext(), "iapf2fpay");
        this.c = spDataStorageProvider;
        String fetch = spDataStorageProvider.fetch(F2FPayConstants.StorageKeyList.KEY_OTP_SEED_EXPIRED_TIME);
        try {
            if (TextUtils.isEmpty(fetch)) {
                return;
            }
            this.b = Long.valueOf(fetch).longValue();
            StringBuilder sb = new StringBuilder();
            sb.append("initializeComponent initialize otp seed will expired after ");
            sb.append(this.b);
            LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
        } catch (Exception e) {
            LoggerWrapper.e(F2FPayConstants.TAG, "initializeComponent initialize otp exception: ", e);
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent
    public void initializeOtpInfoInWorker(String str, String str2) {
        if (!NetworkUtils.isNetworkAvailable(getContext()) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !getUserDelegate().checkPermission()) {
            StringBuilder sb = new StringBuilder();
            sb.append("initializeOtpInfoInWorker error, tid:");
            sb.append(str);
            sb.append(", identify:");
            sb.append(str2);
            sb.append(", online:");
            sb.append(NetworkUtils.isNetworkAvailable(getContext()));
            sb.append(", permission:");
            sb.append(getUserDelegate().checkPermission());
            a(sb.toString());
            b(str, str2);
            return;
        }
        this.mRequestTimeMark.set(Integer.valueOf(a()));
        Object[] objArr = new Object[2];
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr2 = new Object[1];
            e(b, (byte) (b - 1), BuiltInFictitiousFunctionClassFactory[15], objArr2);
            boolean z = false;
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
            byte b3 = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr3 = new Object[1];
            e(b2, b3, (byte) (b3 - 1), objArr3);
            objArr[0] = Long.valueOf(((Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null)).getId());
            objArr[1] = String.valueOf(this.mLocker.isLocked());
            LoggerWrapper.d(F2FPayConstants.TAG, String.format("Thread = %d, RequestLocker = %s", objArr));
            this.mLocker.lock();
            try {
                int intValue = this.mRequestTimeMark.get().intValue();
                this.mRequestTimeMark.remove();
                String str3 = this.mPreviousRequestIdentity;
                if (str3 != null && str3.equals(str2) && intValue <= this.mPreviousRequestFinishTimeMark) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("initializeOtpInfoInWorker error, initialize otp task has already done by another task, initializeOtpInfoInWorker After lock Thread:");
                    try {
                        byte b4 = BuiltInFictitiousFunctionClassFactory[15];
                        Object[] objArr4 = new Object[1];
                        e(b4, (byte) (b4 - 1), BuiltInFictitiousFunctionClassFactory[15], objArr4);
                        Class<?> cls2 = Class.forName((String) objArr4[0]);
                        byte b5 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                        byte b6 = BuiltInFictitiousFunctionClassFactory[15];
                        Object[] objArr5 = new Object[1];
                        e(b5, b6, (byte) (b6 - 1), objArr5);
                        sb2.append(((Thread) cls2.getMethod((String) objArr5[0], null).invoke(null, null)).getId());
                        sb2.append("is return");
                        LoggerWrapper.d(F2FPayConstants.TAG, sb2.toString());
                        return;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("initializeOtpInfoInWorker After lock Thread: ");
                try {
                    byte b7 = BuiltInFictitiousFunctionClassFactory[15];
                    Object[] objArr6 = new Object[1];
                    e(b7, (byte) (b7 - 1), BuiltInFictitiousFunctionClassFactory[15], objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    byte b8 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                    byte b9 = BuiltInFictitiousFunctionClassFactory[15];
                    Object[] objArr7 = new Object[1];
                    e(b8, b9, (byte) (b9 - 1), objArr7);
                    sb3.append(((Thread) cls3.getMethod((String) objArr7[0], null).invoke(null, null)).getId());
                    sb3.append(" working");
                    LoggerWrapper.d(F2FPayConstants.TAG, sb3.toString());
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    int i = 0;
                    while (true) {
                        if (i >= 3) {
                            break;
                        }
                        OtpInitResult a2 = a(str, str2);
                        if (a2 != null) {
                            this.mPreviousRequestIdentity = str2;
                            this.mPreviousRequestFinishTimeMark = a();
                            this.f6957a = a2.interval;
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (getStartRefreshFlag()) {
                        if (z) {
                            b();
                        } else {
                            a("refreshOtpInfoRpc rpc error");
                        }
                    }
                    if (z) {
                        MonitorUtils.initializeOtp(BehaviorLogger.errorCode.RPC_SUCCESS, "initialized otp rpc request success", SystemClock.elapsedRealtime() - elapsedRealtime, true);
                    }
                    return;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } finally {
                this.mLocker.unlock();
            }
            this.mLocker.unlock();
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 == null) {
                throw th3;
            }
            throw cause3;
        }
    }

    public void saveOtpInfo(F2FPayOtpInfo f2FPayOtpInfo, String str) {
        synchronized (this) {
            IF2FPaySecureStorage secureStorage = getClientContext().getSecureStorage();
            secureStorage.clear();
            secureStorage.saveOtpInfo(f2FPayOtpInfo, str);
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent
    public void setInitializeInterceptor(IF2FPayInitializeComponent.Interceptor interceptor) {
        this.mInterceptor = interceptor;
    }
}
