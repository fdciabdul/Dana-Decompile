package com.alipay.iap.android.f2fpay.components.defaults;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.ap.mobileprod.biz.f2fpay.rpc.F2fpaySwitchFacade;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.rpcintegration.EnvironmentInfo;
import com.alipay.iap.android.common.rpcintegration.EnvironmentInfoHost;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import com.alipay.iap.android.f2fpay.client.CheckOpenStrategy;
import com.alipay.iap.android.f2fpay.client.F2FPayClientContext;
import com.alipay.iap.android.f2fpay.client.IF2FPayClient;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPaySwitchOnVerifier;
import com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask;
import com.alipay.iap.android.f2fpay.common.F2FPayCallbacks;
import com.alipay.iap.android.f2fpay.common.IF2FPayCallbackHolder;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.alipay.iap.android.f2fpay.util.MonitorUtils;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.alipayplus.mobile.component.common.facade.base.result.BaseServiceResult;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.f2fpay.service.request.F2fpaySwitchOffRequest;
import com.alipayplus.mobile.component.f2fpay.service.request.F2fpaySwitchOnRequest;
import com.alipayplus.mobile.component.f2fpay.service.result.F2fpayCheckOpenResult;

/* loaded from: classes3.dex */
public class DefaultOpenComponent extends DefaultBaseComponent implements IF2FPayOpenComponent {

    /* renamed from: a */
    private long f6958a;
    private long b;
    private long c;
    protected F2fpayCheckOpenResult mCachedCheckResult;
    protected boolean mIsOpen;
    protected F2FPayCallbacks<IF2FPayOpenCallback> mOpenCallbacks = new F2FPayCallbacks<>();
    protected IF2FPaySwitchOnVerifier mSwitchOnVerifier;

    private F2fpaySwitchOnRequest a() {
        F2fpaySwitchOnRequest f2fpaySwitchOnRequest = new F2fpaySwitchOnRequest();
        f2fpaySwitchOnRequest.envInfo = getMobileEnvInfo(this.mPayClient.getContext());
        f2fpaySwitchOnRequest.verificationType = "nonPwd";
        f2fpaySwitchOnRequest.password = "";
        return f2fpaySwitchOnRequest;
    }

    public void a(final F2fpaySwitchOnRequest f2fpaySwitchOnRequest) {
        this.f6958a = SystemClock.elapsedRealtime();
        IAPAsyncTask.asyncTask(new F2FPayAsyncTask.F2FPayRunner<BaseServiceResult>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.4
            {
                DefaultOpenComponent.this = this;
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public BaseServiceResult execute() throws Exception {
                return DefaultOpenComponent.access$000().switchOn(f2fpaySwitchOnRequest);
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask.F2FPayRunner, com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(final IAPError iAPError) {
                super.onFailure(iAPError);
                DefaultOpenComponent.this.setF2FOpen(false);
                StringBuilder sb = new StringBuilder();
                sb.append("Switch on failed RPC request error: ");
                sb.append(iAPError);
                MonitorUtils.switchOn(BehaviorLogger.errorCode.RPC_RESULT_FAILED, sb.toString() == null ? "" : iAPError.errorMessage, SystemClock.elapsedRealtime() - DefaultOpenComponent.this.f6958a, false);
                DefaultOpenComponent.this.mOpenCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayOpenCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.4.2
                    {
                        AnonymousClass4.this = this;
                    }

                    @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                    public void invoke(IF2FPayOpenCallback iF2FPayOpenCallback) {
                        iF2FPayOpenCallback.onSwitchOnFailed(iAPError.errorMessage);
                    }
                });
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask.F2FPayRunner, com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(final BaseServiceResult baseServiceResult) {
                super.onSuccess((AnonymousClass4) baseServiceResult);
                DefaultOpenComponent.this.setF2FOpen(baseServiceResult.success);
                if (baseServiceResult.success) {
                    MonitorUtils.switchOn(BehaviorLogger.errorCode.RPC_SUCCESS, "Switch on RPC success", SystemClock.elapsedRealtime() - DefaultOpenComponent.this.f6958a, true);
                    MonitorUtils.funnelSwitchOn();
                    DefaultOpenComponent.this.initializeOtpInfo();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Switch on failed RPC result.success is zero: ");
                    sb.append(baseServiceResult.errorMessage);
                    MonitorUtils.switchOn(BehaviorLogger.errorCode.RPC_RESULT_SUCCESS_ZERO, sb.toString(), SystemClock.elapsedRealtime() - DefaultOpenComponent.this.f6958a, false);
                }
                DefaultOpenComponent.this.mOpenCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayOpenCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.4.1
                    {
                        AnonymousClass4.this = this;
                    }

                    @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                    public void invoke(IF2FPayOpenCallback iF2FPayOpenCallback) {
                        BaseServiceResult baseServiceResult2 = baseServiceResult;
                        if (baseServiceResult2.success) {
                            iF2FPayOpenCallback.onSwitchStatusChanged(true, IF2FPayOpenCallback.StatusChangeCausedBy.SwitchOn);
                        } else {
                            iF2FPayOpenCallback.onSwitchOnFailed(baseServiceResult2.errorMessage);
                        }
                    }
                });
            }
        });
    }

    static /* synthetic */ F2fpaySwitchFacade access$000() {
        return b();
    }

    private static F2fpaySwitchFacade b() {
        return (F2fpaySwitchFacade) RPCProxyHost.getInterfaceProxy(F2fpaySwitchFacade.class);
    }

    public static F2fpaySwitchOnRequest buildPasswordSwitchOnRequest(Context context, String str, String str2) {
        F2fpaySwitchOnRequest f2fpaySwitchOnRequest = new F2fpaySwitchOnRequest();
        f2fpaySwitchOnRequest.envInfo = getMobileEnvInfo(context);
        f2fpaySwitchOnRequest.verificationType = "AccPwd";
        if (TextUtils.isEmpty(str2)) {
            f2fpaySwitchOnRequest.password = str;
        } else {
            f2fpaySwitchOnRequest.password = RSAHelper.encrypt(str, str2);
        }
        return f2fpaySwitchOnRequest;
    }

    public static MobileEnvInfo getMobileEnvInfo(Context context) {
        MobileEnvInfo mobileEnvInfo = new MobileEnvInfo();
        EnvironmentInfo environmentInfo = EnvironmentInfoHost.getEnvironmentInfo(context);
        mobileEnvInfo.tokenId = environmentInfo.tokenId;
        mobileEnvInfo.clientIp = environmentInfo.clientIp;
        mobileEnvInfo.terminalType = environmentInfo.terminalType;
        mobileEnvInfo.osType = environmentInfo.osType;
        mobileEnvInfo.osVersion = environmentInfo.osVersion;
        mobileEnvInfo.cashierSdkVersion = environmentInfo.cashierSdkVersion;
        mobileEnvInfo.appVersion = environmentInfo.appVersion;
        mobileEnvInfo.clientKey = environmentInfo.clientKey;
        mobileEnvInfo.extendInfo = environmentInfo.extendInfo;
        return mobileEnvInfo;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent
    public IF2FPayCallbackHolder addOpenCallback(IF2FPayOpenCallback iF2FPayOpenCallback) {
        return this.mOpenCallbacks.addCallback(iF2FPayOpenCallback);
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent
    public void checkOpen() {
        MonitorUtils.checkOpenState(this.mIsOpen);
        if (CheckOpenStrategy.FORCE_CHECK != getClientContext().getCheckOpenStrategy()) {
            this.mOpenCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayOpenCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.1
                {
                    DefaultOpenComponent.this = this;
                }

                @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                public void invoke(IF2FPayOpenCallback iF2FPayOpenCallback) {
                    iF2FPayOpenCallback.onSwitchStatusChanged(DefaultOpenComponent.this.mIsOpen, IF2FPayOpenCallback.StatusChangeCausedBy.CheckOpen);
                }
            });
            if (!this.mIsOpen) {
                switchOn();
                return;
            }
        }
        this.c = SystemClock.elapsedRealtime();
        IAPAsyncTask.asyncTask(new F2FPayAsyncTask.F2FPayRunner<F2fpayCheckOpenResult>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.2
            {
                DefaultOpenComponent.this = this;
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public F2fpayCheckOpenResult execute() throws Exception {
                return DefaultOpenComponent.access$000().checkOpen(new BaseRpcRequest());
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask.F2FPayRunner, com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(IAPError iAPError) {
                super.onFailure(iAPError);
                StringBuilder sb = new StringBuilder();
                sb.append("check open RPC request failed : ");
                sb.append(iAPError);
                MonitorUtils.checkOpen(BehaviorLogger.errorCode.RPC_RESULT_FAILED, sb.toString() == null ? "" : iAPError.errorMessage, SystemClock.elapsedRealtime() - DefaultOpenComponent.this.c, false);
                DefaultOpenComponent defaultOpenComponent = DefaultOpenComponent.this;
                defaultOpenComponent.mCachedCheckResult = null;
                defaultOpenComponent.onCheckOpenFailed(iAPError.errorMessage);
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask.F2FPayRunner, com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(final F2fpayCheckOpenResult f2fpayCheckOpenResult) {
                super.onSuccess((AnonymousClass2) f2fpayCheckOpenResult);
                DefaultOpenComponent defaultOpenComponent = DefaultOpenComponent.this;
                defaultOpenComponent.mCachedCheckResult = f2fpayCheckOpenResult;
                if (!f2fpayCheckOpenResult.success) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("check open RPC result.success is zero: ");
                    sb.append(f2fpayCheckOpenResult.errorMessage);
                    MonitorUtils.checkOpen(BehaviorLogger.errorCode.RPC_RESULT_SUCCESS_ZERO, sb.toString(), SystemClock.elapsedRealtime() - DefaultOpenComponent.this.c, false);
                    DefaultOpenComponent.this.onCheckOpenFailed(f2fpayCheckOpenResult.errorMessage);
                    return;
                }
                defaultOpenComponent.setF2FOpen(f2fpayCheckOpenResult.openFlag);
                if (!f2fpayCheckOpenResult.openFlag) {
                    ((IF2FPayInitializeComponent) DefaultOpenComponent.this.getComponent(IF2FPayInitializeComponent.class)).clearOtpInfo();
                    DefaultOpenComponent.this.mPayClient.refreshPaymentCode(0);
                }
                DefaultOpenComponent.this.mOpenCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayOpenCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.2.1
                    {
                        AnonymousClass2.this = this;
                    }

                    @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                    public void invoke(IF2FPayOpenCallback iF2FPayOpenCallback) {
                        iF2FPayOpenCallback.onSwitchStatusChanged(f2fpayCheckOpenResult.openFlag, IF2FPayOpenCallback.StatusChangeCausedBy.CheckOpen);
                    }
                });
                if (!f2fpayCheckOpenResult.openFlag) {
                    MonitorUtils.checkOpen(BehaviorLogger.errorCode.OPEN_CHECK_OPEN_SUCCESS_RPC_RESULT_CLOSE, "check open success and status is close", SystemClock.elapsedRealtime() - DefaultOpenComponent.this.c, true);
                    DefaultOpenComponent.this.switchOn();
                    return;
                }
                DefaultOpenComponent defaultOpenComponent2 = DefaultOpenComponent.this;
                if (!defaultOpenComponent2.mIsOpen) {
                    defaultOpenComponent2.initializeOtpInfo();
                }
                MonitorUtils.checkOpen(BehaviorLogger.errorCode.OPEN_CHECK_OPEN_SUCCESS_RPC_RESULT_OPEN, "check open success and status is open", SystemClock.elapsedRealtime() - DefaultOpenComponent.this.c, true);
            }
        });
    }

    @Override // com.alipay.iap.android.f2fpay.components.defaults.DefaultBaseComponent, com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent
    public void initialize(IF2FPayClient iF2FPayClient) {
        super.initialize(iF2FPayClient);
        F2FPayClientContext clientContext = getClientContext();
        if (CheckOpenStrategy.FORCE_CHECK != clientContext.getCheckOpenStrategy()) {
            this.mIsOpen = clientContext.getSecureStorage().checkOtpInfoExist(generateUserIdentity());
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent
    public boolean isOpen() {
        return this.mIsOpen;
    }

    protected void onCheckOpenFailed(String str) {
    }

    protected void setF2FOpen(boolean z) {
        this.mIsOpen = z;
        if (z) {
            return;
        }
        ((IF2FPayInitializeComponent) getComponent(IF2FPayInitializeComponent.class)).clearOtpInfo();
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent
    public void setLocalOpenFlag(boolean z) {
        this.mIsOpen = z;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent
    public void setSwitchOnVerifier(IF2FPaySwitchOnVerifier iF2FPaySwitchOnVerifier) {
        this.mSwitchOnVerifier = iF2FPaySwitchOnVerifier;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent
    public void switchOff() {
        this.b = SystemClock.elapsedRealtime();
        IAPAsyncTask.asyncTask(new F2FPayAsyncTask.F2FPayRunner<BaseServiceResult>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.5
            {
                DefaultOpenComponent.this = this;
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public BaseServiceResult execute() throws Exception {
                F2fpaySwitchOffRequest f2fpaySwitchOffRequest = new F2fpaySwitchOffRequest();
                f2fpaySwitchOffRequest.tid = DefaultOpenComponent.this.generateTerminalIdentifier();
                return DefaultOpenComponent.access$000().switchOff(f2fpaySwitchOffRequest);
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask.F2FPayRunner, com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(final IAPError iAPError) {
                StringBuilder sb = new StringBuilder();
                sb.append("Switch on failed rpc request error: ");
                sb.append(iAPError);
                MonitorUtils.switchOff(BehaviorLogger.errorCode.RPC_RESULT_FAILED, sb.toString() == null ? "" : iAPError.errorMessage, SystemClock.elapsedRealtime() - DefaultOpenComponent.this.b, false);
                super.onFailure(iAPError);
                DefaultOpenComponent.this.mOpenCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayOpenCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.5.2
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                    public void invoke(IF2FPayOpenCallback iF2FPayOpenCallback) {
                        iF2FPayOpenCallback.onSwitchOffFailed(iAPError.errorMessage);
                    }
                });
            }

            @Override // com.alipay.iap.android.f2fpay.common.F2FPayAsyncTask.F2FPayRunner, com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(final BaseServiceResult baseServiceResult) {
                super.onSuccess((AnonymousClass5) baseServiceResult);
                DefaultOpenComponent.this.setF2FOpen(false);
                if (baseServiceResult.success) {
                    MonitorUtils.switchOff(BehaviorLogger.errorCode.RPC_SUCCESS, "Switch off RPC success", SystemClock.elapsedRealtime() - DefaultOpenComponent.this.b, true);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Switch off failed Rpc result.success is zero: ");
                    sb.append(baseServiceResult.errorMessage);
                    MonitorUtils.switchOff(BehaviorLogger.errorCode.RPC_RESULT_SUCCESS_ZERO, sb.toString(), SystemClock.elapsedRealtime() - DefaultOpenComponent.this.b, false);
                }
                DefaultOpenComponent.this.mOpenCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayOpenCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.5.1
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                    public void invoke(IF2FPayOpenCallback iF2FPayOpenCallback) {
                        BaseServiceResult baseServiceResult2 = baseServiceResult;
                        if (baseServiceResult2.success) {
                            iF2FPayOpenCallback.onSwitchStatusChanged(false, IF2FPayOpenCallback.StatusChangeCausedBy.SwitchOff);
                        } else {
                            iF2FPayOpenCallback.onSwitchOffFailed(baseServiceResult2.errorMessage);
                        }
                    }
                });
            }
        });
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent
    public void switchOn() {
        IF2FPaySwitchOnVerifier iF2FPaySwitchOnVerifier = this.mSwitchOnVerifier;
        if (iF2FPaySwitchOnVerifier == null) {
            a(a());
        } else {
            iF2FPaySwitchOnVerifier.verifySwitchOnF2FPay(this.mCachedCheckResult, new IF2FPaySwitchOnVerifier.Callback() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.3
                {
                    DefaultOpenComponent.this = this;
                }

                @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPaySwitchOnVerifier.Callback
                public void onVerifyCallback(F2fpaySwitchOnRequest f2fpaySwitchOnRequest) {
                    DefaultOpenComponent.this.a(f2fpaySwitchOnRequest);
                }

                @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPaySwitchOnVerifier.Callback
                public void onVerifyCanceled() {
                    DefaultOpenComponent.this.mOpenCallbacks.callback(new F2FPayCallbacks.Invoker<IF2FPayOpenCallback>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.DefaultOpenComponent.3.1
                        {
                            AnonymousClass3.this = this;
                        }

                        @Override // com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.Invoker
                        public void invoke(IF2FPayOpenCallback iF2FPayOpenCallback) {
                            iF2FPayOpenCallback.onSwitchOnCanceled();
                        }
                    });
                }
            });
        }
    }
}
