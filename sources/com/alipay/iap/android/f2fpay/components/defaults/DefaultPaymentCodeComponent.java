package com.alipay.iap.android.f2fpay.components.defaults;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.product.delegate.IAPUserDelegate;
import com.alipay.iap.android.common.task.AsyncTaskExecutor;
import com.alipay.iap.android.f2fpay.a.a;
import com.alipay.iap.android.f2fpay.client.IF2FPayClient;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback;
import com.alipay.iap.android.f2fpay.common.F2FPayCallbacks;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.common.F2FPayErrorCode;
import com.alipay.iap.android.f2fpay.common.IF2FPayCallbackHolder;
import com.alipay.iap.android.f2fpay.common.KeyValueRegistry;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayTimeSyncComponent;
import com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.alipay.iap.android.f2fpay.otp.OtpInitResult;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import com.alipay.iap.android.f2fpay.paymentcode.a;
import com.alipay.iap.android.f2fpay.util.ConvertUtils;
import com.alipay.iap.android.f2fpay.util.MonitorUtils;
import java.util.List;

/* loaded from: classes3.dex */
public class DefaultPaymentCodeComponent extends DefaultBaseComponent implements IF2FPayPaymentCodeComponent {

    /* renamed from: a */
    private long f6959a;
    protected boolean mRefreshTaskStarted;
    protected int mRefreshTimeMillSeconds = 60000;
    protected a mActivePaymentCodeQueue = new a();
    protected F2FPayCallbacks<IF2FPaymentCodeCallback> mCallbacks = new F2FPayCallbacks<>();
    private a.b b = new a.b() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultPaymentCodeComponent.5
        {
            DefaultPaymentCodeComponent.this = this;
        }

        @Override // com.alipay.iap.android.f2fpay.a.a.b
        public void call() {
            AsyncTaskExecutor.getInstance().execute(DefaultPaymentCodeComponent.this.c, "PaymentCodeGenerate");
        }

        @Override // com.alipay.iap.android.f2fpay.a.a.b
        public int nextDelayMillSeconds() {
            return DefaultPaymentCodeComponent.this.mRefreshTimeMillSeconds;
        }
    };
    private Runnable c = new Runnable() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultPaymentCodeComponent.6
        {
            DefaultPaymentCodeComponent.this = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DefaultPaymentCodeComponent.this.f6959a = SystemClock.elapsedRealtime();
                IAPUserDelegate userDelegate = DefaultPaymentCodeComponent.this.getUserDelegate();
                if (DefaultPaymentCodeComponent.this.mRefreshTaskStarted && userDelegate.checkPermission()) {
                    if (DefaultPaymentCodeComponent.this.isF2FPayOpen()) {
                        DefaultPaymentCodeComponent.this.generatePaymentCodeWithRetryInWorker(userDelegate.getUserId(), DefaultPaymentCodeComponent.this.generateTerminalIdentifier());
                        return;
                    }
                    LoggerWrapper.e(F2FPayConstants.TAG, "GeneratePaymentRunnable error, F2FPay is not opened");
                    DefaultPaymentCodeComponent.this.a(null);
                    MonitorUtils.generatePaymentCode(BehaviorLogger.errorCode.PAYMENT_CODE_GENERATE_FAILED_F2FPAY_CLOSE, "GeneratePaymentRunnable error, F2FPay is not opened", SystemClock.elapsedRealtime() - DefaultPaymentCodeComponent.this.f6959a, false);
                    return;
                }
                LoggerWrapper.e(F2FPayConstants.TAG, "GeneratePaymentRunnable error, task stopped or no permission");
                DefaultPaymentCodeComponent.this.a(null);
                if (userDelegate.checkPermission()) {
                    return;
                }
                MonitorUtils.generatePaymentCode(BehaviorLogger.errorCode.NO_USER_PERMISSION, "GeneratePaymentRunnable error, task stopped or no permission", SystemClock.elapsedRealtime() - DefaultPaymentCodeComponent.this.f6959a, false);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("GeneratePaymentRunnable error: ");
                sb.append(e.getMessage());
                LoggerWrapper.e(F2FPayConstants.TAG, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("GeneratePaymentRunnable error:");
                sb2.append(e.getMessage());
                MonitorUtils.generatePaymentCode(BehaviorLogger.errorCode.PAYMENT_CODE_GENERATE_FAILED_RUNNABLE_EXCEPTION, sb2.toString(), SystemClock.elapsedRealtime() - DefaultPaymentCodeComponent.this.f6959a, false);
                DefaultPaymentCodeComponent.this.a(null);
            }
        }
    };
    protected com.alipay.iap.android.f2fpay.a.a mTimerTaskManager = com.alipay.iap.android.f2fpay.a.a.a();

    /* loaded from: classes3.dex */
    public static class GenerateResult extends F2FPaymentCodeInfo {

        /* renamed from: a */
        private String f6960a;

        private GenerateResult() {
        }
    }

    public void a(final GenerateResult generateResult) {
        if (this.mRefreshTaskStarted) {
            if (generateResult == null || generateResult.isCodeEmpty()) {
                this.mCallbacks.postMainCallback(new F2FPayCallbacks.Invoker<IF2FPaymentCodeCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultPaymentCodeComponent.3
                    {
                        DefaultPaymentCodeComponent.this = this;
                    }

                    @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                    public void invoke(IF2FPaymentCodeCallback iF2FPaymentCodeCallback) {
                        iF2FPaymentCodeCallback.onPaymentCodeGenerateFailed();
                    }
                });
                return;
            }
            MonitorUtils.funnelGenCode();
            MonitorUtils.generatePaymentCode(BehaviorLogger.errorCode.PAYMENT_CODE_GENERATE_SUCCESS, "Payment code generate success", SystemClock.elapsedRealtime() - this.f6959a, true);
            this.mActivePaymentCodeQueue.a(generateResult.paymentCode, generateResult.totp);
            this.mCallbacks.postMainCallback(new F2FPayCallbacks.Invoker<IF2FPaymentCodeCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultPaymentCodeComponent.4
                {
                    DefaultPaymentCodeComponent.this = this;
                }

                @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                public void invoke(IF2FPaymentCodeCallback iF2FPaymentCodeCallback) {
                    iF2FPaymentCodeCallback.onPaymentCodeUpdated(new F2FPaymentCodeInfo(generateResult));
                }
            });
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public IF2FPayCallbackHolder addPaymentCodeCallback(IF2FPaymentCodeCallback iF2FPaymentCodeCallback) {
        return this.mCallbacks.addCallback(iF2FPaymentCodeCallback);
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public void clearWaitingResultPaymentCodes() {
        this.mActivePaymentCodeQueue.a();
    }

    protected GenerateResult generatePaymentCode(String str) {
        GenerateResult generateResult = new GenerateResult();
        String generatePaymentCodeInternal = generatePaymentCodeInternal(str);
        generateResult.paymentCode = generatePaymentCodeInternal;
        if (TextUtils.isEmpty(generatePaymentCodeInternal)) {
            generateResult.f6960a = F2FPayErrorCode.OTP_INFO_ERROR;
        } else {
            int length = generatePaymentCodeInternal.length();
            if (length >= 6) {
                generateResult.totp = generatePaymentCodeInternal.substring(length - 6);
            }
        }
        return generateResult;
    }

    protected String generatePaymentCodeInternal(String str) {
        IF2FPaySecureStorage secureStorage = getClientContext().getSecureStorage();
        if (!secureStorage.checkOtpInfoExist(str)) {
            MonitorUtils.generatePaymentCode(BehaviorLogger.errorCode.PAYMENT_CODE_NO_OTP_SEED, "GeneratePaymentRunnable error: identity is null", SystemClock.elapsedRealtime() - this.f6959a, false);
            return null;
        }
        String generateCode = getClientContext().getPaymentCodeGenerator().generateCode(this.mPayClient.getContext(), secureStorage.getOtpInfoByIdentity(str), ((IF2FPayTimeSyncComponent) this.mPayClient.getComponent(IF2FPayTimeSyncComponent.class)).getServerTime() / 1000, this.mPayClient.getSeedExtra());
        if (TextUtils.isEmpty(generateCode)) {
            MonitorUtils.generatePaymentCode(BehaviorLogger.errorCode.PAYMENT_CODE_GENERATE_FAILED_PAYMENT_CODE_EMPTY, "GeneratePaymentRunnable error: payment code is null", SystemClock.elapsedRealtime() - this.f6959a, false);
            secureStorage.clear();
        }
        return generateCode;
    }

    protected void generatePaymentCodeWithRetryInWorker(String str, String str2) {
        GenerateResult generateResult;
        String identity = ConvertUtils.getIdentity(str, str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            generateResult = null;
        } else {
            ((IF2FPayTimeSyncComponent) getComponent(IF2FPayTimeSyncComponent.class)).synchronizeTimeInWorker();
            generateResult = generatePaymentCode(identity);
        }
        if (generateResult == null) {
            LoggerWrapper.e(F2FPayConstants.TAG, "generatePaymentCodeWithRetryInWorker: generate payment code failed, result is null.");
            a(null);
            return;
        }
        if (generateResult.isCodeEmpty() && TextUtils.equals(generateResult.f6960a, F2FPayErrorCode.OTP_INFO_ERROR)) {
            ((IF2FPayInitializeComponent) getComponent(IF2FPayInitializeComponent.class)).initializeOtpInfoInWorker(str2, identity);
            generateResult = generatePaymentCode(identity);
        }
        a(generateResult);
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public long getPollingTimeStamp(String str) {
        return this.mActivePaymentCodeQueue.a(str);
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public int getRefreshTimeSeconds() {
        return this.mRefreshTimeMillSeconds / 1000;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public List<String> getWaitingResultPaymentCodes() {
        return this.mActivePaymentCodeQueue.b();
    }

    @Override // com.alipay.iap.android.f2fpay.components.defaults.DefaultBaseComponent, com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent
    public void initialize(IF2FPayClient iF2FPayClient) {
        super.initialize(iF2FPayClient);
        this.mActivePaymentCodeQueue.a(keyValueAccessor().getInt(KeyValueRegistry.QUERY_COUNT, 2));
        ((IF2FPayInitializeComponent) getComponent(IF2FPayInitializeComponent.class)).addInitializeCallback(new IF2FPayInitializeCallback() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultPaymentCodeComponent.1
            {
                DefaultPaymentCodeComponent.this = this;
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onInitializeFailed(String str) {
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onInitializeOtpSucceed() {
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onOtpInfoChanged(OtpInitResult otpInitResult) {
                DefaultPaymentCodeComponent.this.mActivePaymentCodeQueue.a(otpInitResult.queryCount);
                DefaultPaymentCodeComponent.this.requestRefresh(0);
            }
        });
        IF2FPayOpenComponent iF2FPayOpenComponent = (IF2FPayOpenComponent) getComponent(IF2FPayOpenComponent.class);
        if (iF2FPayOpenComponent != null) {
            iF2FPayOpenComponent.addOpenCallback(new IF2FPayOpenCallback.Adapter() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultPaymentCodeComponent.2
                {
                    DefaultPaymentCodeComponent.this = this;
                }

                @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback.Adapter, com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
                public void onSwitchStatusChanged(boolean z, IF2FPayOpenCallback.StatusChangeCausedBy statusChangeCausedBy) {
                    if (z) {
                        DefaultPaymentCodeComponent defaultPaymentCodeComponent = DefaultPaymentCodeComponent.this;
                        if (defaultPaymentCodeComponent.mRefreshTaskStarted) {
                            defaultPaymentCodeComponent.requestRefresh(0);
                        }
                    }
                }
            });
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public int paymentCodeResultHasHandled(String str) {
        return this.mActivePaymentCodeQueue.b(str);
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public void requestRefresh(int i) {
        stopRefreshTask();
        StringBuilder sb = new StringBuilder();
        sb.append("requestRefresh: request refresh code withe delay: ");
        sb.append(i);
        LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
        this.mRefreshTaskStarted = true;
        if (i > 0) {
            this.mTimerTaskManager.a(this.b, i);
        } else {
            this.mTimerTaskManager.b(this.b);
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public void setRefreshTimeSeconds(int i) {
        this.mRefreshTimeMillSeconds = i * 1000;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public void startRefreshTask() {
        if (this.mRefreshTaskStarted) {
            LoggerWrapper.d(F2FPayConstants.TAG, "startRefreshTask: PaymentCode generate task is already started!");
        } else {
            requestRefresh(0);
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent
    public void stopRefreshTask() {
        this.mTimerTaskManager.a(this.b);
        this.mRefreshTaskStarted = false;
    }
}
