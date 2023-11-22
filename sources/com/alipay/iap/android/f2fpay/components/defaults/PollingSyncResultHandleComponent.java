package com.alipay.iap.android.f2fpay.components.defaults;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.ap.mobileprod.service.facade.uniresultpage.model.UniResultF2fpayOrderInfo;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.product.delegate.IAPUserDelegate;
import com.alipay.iap.android.f2fpay.a.a;
import com.alipay.iap.android.f2fpay.client.IF2FPayClient;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayResultCallback;
import com.alipay.iap.android.f2fpay.client.pay.F2FPayResult;
import com.alipay.iap.android.f2fpay.client.pay.F2fPayOrderInfo;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.common.KeyValueRegistry;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayPaymentCodeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.alipay.iap.android.f2fpay.otp.F2FPayOtpInfo;
import com.alipay.iap.android.f2fpay.otp.OtpInitResult;
import com.alipay.iap.android.f2fpay.util.ConvertUtils;
import com.alipay.iap.android.f2fpay.util.MonitorUtils;
import com.alipay.plus.android.unipayresult.sdk.callback.IUnifierPayResultHandler;
import com.alipay.plus.android.unipayresult.sdk.client.IUnifierQuery;
import com.alipay.plus.android.unipayresult.sdk.client.UnifierQueryClient;
import com.alipay.plus.android.unipayresult.sdk.executor.UnifierPayResultInfo;
import com.alipay.plus.android.unipayresult.sdk.executor.UnifierPollingRpcExecutor;
import com.alipay.plus.android.unipayresult.sdk.executor.UnifierSyncQueryExecutor;
import com.alipay.plus.android.unipayresult.sdk.request.IUnifierQueryDelegate;
import com.alipay.plus.android.unipayresult.sdk.request.IUnifierRequest;
import com.alipay.plus.android.unipayresult.sdk.request.UnifierPollingRpcRequest;
import com.alipay.plus.android.unipayresult.sdk.request.UnifierSyncRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PollingSyncResultHandleComponent extends DefaultBaseComponent implements IF2FPayResultHandleComponent {
    protected static final int DEFAULT_CODE_GENERATE_INTERVAL = 3;
    protected static final int DEFAULT_POLLING_INTERVAL = 5000;
    protected static final String F2F_PAY_RESULT = "F2F_PAY_RESULT";
    protected static final String HANDLE_RESULT_POLLING = "POLLING";
    protected static final String HANDLE_RESULT_SYNC = "SYNC";

    /* renamed from: a */
    private boolean f6962a;
    protected List<Integer> mIntervals;
    protected IF2FPayResultCallback mPayResultCallback;
    protected IF2FPayResultHandleComponent.IPayResultDecoder mPayResultDecoder;
    protected boolean mRefreshTaskStarted;

    public PollingSyncResultHandleComponent() {
        ArrayList arrayList = new ArrayList();
        this.mIntervals = arrayList;
        this.f6962a = true;
        arrayList.add(5000);
    }

    public void a() {
        LoggerWrapper.d(F2FPayConstants.TAG, "startHandleResultInternal: start query result");
        Context context = getContext();
        UnifierPollingRpcExecutor unifierPollingRpcExecutor = new UnifierPollingRpcExecutor(context, this.mIntervals, new IUnifierQueryDelegate() { // from class: com.alipay.iap.android.f2fpay.components.defaults.PollingSyncResultHandleComponent.2
            {
                PollingSyncResultHandleComponent.this = this;
            }

            @Override // com.alipay.plus.android.unipayresult.sdk.request.IUnifierQueryDelegate
            public IUnifierRequest generateRequest() {
                List<String> list;
                IAPUserDelegate userDelegate = PollingSyncResultHandleComponent.this.getUserDelegate();
                UnifierPollingRpcRequest unifierPollingRpcRequest = new UnifierPollingRpcRequest();
                unifierPollingRpcRequest.mLinkTargetId = userDelegate.getUserId();
                unifierPollingRpcRequest.mBizNos = ((IF2FPayPaymentCodeComponent) PollingSyncResultHandleComponent.this.getComponent(IF2FPayPaymentCodeComponent.class)).getWaitingResultPaymentCodes();
                if (TextUtils.isEmpty(unifierPollingRpcRequest.mLinkTargetId) || (list = unifierPollingRpcRequest.mBizNos) == null || list.size() == 0) {
                    PollingSyncResultHandleComponent.this.stopHandleResult();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("startHandleResultInternal: polling request bizNo:");
                sb.append(unifierPollingRpcRequest.mBizNos.toString());
                LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
                return unifierPollingRpcRequest;
            }

            @Override // com.alipay.plus.android.unipayresult.sdk.request.IUnifierQueryDelegate
            public void parseBizResultInfo(String str, UnifierPayResultInfo unifierPayResultInfo) {
                PollingSyncResultHandleComponent.this.parseBizResultInfoInternal(str, unifierPayResultInfo, PollingSyncResultHandleComponent.HANDLE_RESULT_POLLING);
            }
        });
        UnifierSyncQueryExecutor unifierSyncQueryExecutor = new UnifierSyncQueryExecutor(context, new IUnifierQueryDelegate() { // from class: com.alipay.iap.android.f2fpay.components.defaults.PollingSyncResultHandleComponent.3
            {
                PollingSyncResultHandleComponent.this = this;
            }

            @Override // com.alipay.plus.android.unipayresult.sdk.request.IUnifierQueryDelegate
            public IUnifierRequest generateRequest() {
                return new UnifierSyncRequest();
            }

            @Override // com.alipay.plus.android.unipayresult.sdk.request.IUnifierQueryDelegate
            public void parseBizResultInfo(String str, UnifierPayResultInfo unifierPayResultInfo) {
                PollingSyncResultHandleComponent.this.parseBizResultInfoInternal(str, unifierPayResultInfo, PollingSyncResultHandleComponent.HANDLE_RESULT_SYNC);
            }
        });
        final Class<?> payOrderInfoClass = this.mPayResultDecoder.getPayOrderInfoClass();
        IUnifierQuery.QueryConfig queryConfig = new IUnifierQuery.QueryConfig("F2F_PAY_RESULT");
        queryConfig.addQueryExecutor(unifierPollingRpcExecutor).addQueryExecutor(unifierSyncQueryExecutor).setDeserializeBizOrderClazz(payOrderInfoClass).setPayResultHandler(new IUnifierPayResultHandler() { // from class: com.alipay.iap.android.f2fpay.components.defaults.PollingSyncResultHandleComponent.4
            {
                PollingSyncResultHandleComponent.this = this;
            }

            @Override // com.alipay.plus.android.unipayresult.sdk.callback.IUnifierPayResultHandler
            public boolean handlePayResult(UnifierPayResultInfo unifierPayResultInfo) {
                if (!payOrderInfoClass.isInstance(unifierPayResultInfo.mBizOrderInfo)) {
                    MonitorUtils.resultHandle(BehaviorLogger.errorCode.HANDLE_PAYMENT_RESULT_FAILED_CLASS_NOT_MATCH, "handlePayResult, class not match", 0L, false);
                    LoggerWrapper.d(F2FPayConstants.TAG, "handlePayResult, class not match ");
                    return false;
                }
                try {
                    return PollingSyncResultHandleComponent.this.processPayResultWithCallback(unifierPayResultInfo.mBizOrderInfo);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("handle payment result exception: ");
                    sb.append(e.getMessage());
                    MonitorUtils.resultHandle(BehaviorLogger.errorCode.HANDLE_PAYMENT_RESULT_EXCEPTION, sb.toString(), 0L, false);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Handle pay result failed with exception: ");
                    sb2.append(e.getMessage());
                    LoggerWrapper.e(F2FPayConstants.TAG, sb2.toString());
                    return false;
                }
            }
        });
        UnifierQueryClient.getInstance().startQuery(queryConfig);
    }

    public void a(String str) {
        this.mIntervals = ConvertUtils.parseQueryIntervals(str, 5000);
        StringBuilder sb = new StringBuilder();
        sb.append("setQueryInterval: ");
        sb.append(String.valueOf(this.mIntervals));
        LoggerWrapper.e(F2FPayConstants.TAG, sb.toString());
    }

    protected IF2FPayResultHandleComponent.IPayResultDecoder<UniResultF2fpayOrderInfo> createDefaultPayResultDecoder() {
        return new IF2FPayResultHandleComponent.IPayResultDecoder<UniResultF2fpayOrderInfo>() { // from class: com.alipay.iap.android.f2fpay.components.defaults.PollingSyncResultHandleComponent.5
            {
                PollingSyncResultHandleComponent.this = this;
            }

            @Override // com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent.IPayResultDecoder
            public F2fPayOrderInfo convertF2fPayOrderInfo(UniResultF2fpayOrderInfo uniResultF2fpayOrderInfo) {
                return new F2fPayOrderInfo(uniResultF2fpayOrderInfo);
            }

            @Override // com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent.IPayResultDecoder
            public Class<UniResultF2fpayOrderInfo> getPayOrderInfoClass() {
                return UniResultF2fpayOrderInfo.class;
            }
        };
    }

    protected int getPaymentCodeGenerateInterval(String str) {
        int i;
        F2FPayOtpInfo otpInfoByIdentity = getClientContext().getSecureStorage().getOtpInfoByIdentity(ConvertUtils.getIdentity(str, generateTerminalIdentifier()));
        if (otpInfoByIdentity == null || (i = otpInfoByIdentity.interval) <= 0) {
            return 3;
        }
        return i;
    }

    @Override // com.alipay.iap.android.f2fpay.components.defaults.DefaultBaseComponent, com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent
    public void initialize(IF2FPayClient iF2FPayClient) {
        super.initialize(iF2FPayClient);
        setPayResultDecoder(null);
        a(keyValueAccessor().getString(KeyValueRegistry.QUERY_INTERVAL, null));
        ((IF2FPayInitializeComponent) getComponent(IF2FPayInitializeComponent.class)).addInitializeCallback(new IF2FPayInitializeCallback() { // from class: com.alipay.iap.android.f2fpay.components.defaults.PollingSyncResultHandleComponent.1
            {
                PollingSyncResultHandleComponent.this = this;
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onInitializeFailed(String str) {
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onInitializeOtpSucceed() {
            }

            @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayInitializeCallback
            public void onOtpInfoChanged(OtpInitResult otpInitResult) {
                PollingSyncResultHandleComponent.this.a(otpInitResult.queryInterval);
                PollingSyncResultHandleComponent pollingSyncResultHandleComponent = PollingSyncResultHandleComponent.this;
                if (pollingSyncResultHandleComponent.mRefreshTaskStarted) {
                    pollingSyncResultHandleComponent.stopHandleResult();
                    PollingSyncResultHandleComponent.this.a();
                }
            }
        });
    }

    protected void notifyPayResultArrived(final F2FPayResult f2FPayResult) {
        a.a().a(new Runnable() { // from class: com.alipay.iap.android.f2fpay.components.defaults.PollingSyncResultHandleComponent.6
            {
                PollingSyncResultHandleComponent.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PollingSyncResultHandleComponent.this.mPayResultCallback != null) {
                    LoggerWrapper.d(F2FPayConstants.TAG, "notify pay result arrived");
                    PollingSyncResultHandleComponent.this.mPayResultCallback.onPayResultArrived(f2FPayResult);
                }
            }
        });
    }

    public void parseBizResultInfoInternal(String str, UnifierPayResultInfo unifierPayResultInfo, String str2) {
        unifierPayResultInfo.mLinkTargetId = getUserDelegate().getUserId();
        Object obj = unifierPayResultInfo.mBizOrderInfo;
        if (obj instanceof UniResultF2fpayOrderInfo) {
            unifierPayResultInfo.mBizNo = ((UniResultF2fpayOrderInfo) obj).tradeNo;
        }
        MonitorUtils.resultHandleFrom(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean processPayResultWithCallback(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.f2fpay.components.defaults.PollingSyncResultHandleComponent.processPayResultWithCallback(java.lang.Object):boolean");
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent
    public void setPayResultCallback(IF2FPayResultCallback iF2FPayResultCallback) {
        this.mPayResultCallback = iF2FPayResultCallback;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent
    public <T> void setPayResultDecoder(IF2FPayResultHandleComponent.IPayResultDecoder<T> iPayResultDecoder) {
        if (iPayResultDecoder == null) {
            iPayResultDecoder = (IF2FPayResultHandleComponent.IPayResultDecoder<T>) createDefaultPayResultDecoder();
        }
        this.mPayResultDecoder = iPayResultDecoder;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent
    public void setRefreshCodeWhenLastCodePayed(boolean z) {
        this.f6962a = z;
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent
    public void startHandleResult() {
        if (this.mRefreshTaskStarted) {
            LoggerWrapper.d(F2FPayConstants.TAG, "startHandleResult: Result handler task is already started!");
            return;
        }
        this.mRefreshTaskStarted = true;
        if (isF2FPayOpen()) {
            a();
        }
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayResultHandleComponent
    public void stopHandleResult() {
        LoggerWrapper.d(F2FPayConstants.TAG, "stop handle result");
        this.mRefreshTaskStarted = false;
        UnifierQueryClient.getInstance().stopQuery("F2F_PAY_RESULT");
        if (this.mPayClient == null) {
            LoggerWrapper.w(F2FPayConstants.TAG, "F2FPayClient has been recycled, can not clear waiting result payment codes");
        } else {
            ((IF2FPayPaymentCodeComponent) getComponent(IF2FPayPaymentCodeComponent.class)).clearWaitingResultPaymentCodes();
        }
    }
}
