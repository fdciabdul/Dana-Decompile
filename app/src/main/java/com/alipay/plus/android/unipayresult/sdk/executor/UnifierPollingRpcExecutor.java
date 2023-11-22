package com.alipay.plus.android.unipayresult.sdk.executor;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.task.async.IAPAsyncCallback;
import com.alipay.plus.android.unipayresult.sdk.executor.a.a;
import com.alipay.plus.android.unipayresult.sdk.request.IUnifierQueryDelegate;
import com.alipay.plus.android.unipayresult.sdk.request.UnifierPollingRpcRequest;
import com.alipayplus.mobile.component.uniresultpage.service.result.UniResultPageQueryResult;
import java.util.List;

/* loaded from: classes3.dex */
public class UnifierPollingRpcExecutor extends AbstractUnifierQueryExecutor {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f7398a;
    private HandlerThread b;
    private Handler c;
    private int d;
    private Runnable e;

    public UnifierPollingRpcExecutor(Context context, List<Integer> list, IUnifierQueryDelegate iUnifierQueryDelegate) {
        super(context, iUnifierQueryDelegate);
        this.d = 0;
        this.e = new Runnable() { // from class: com.alipay.plus.android.unipayresult.sdk.executor.UnifierPollingRpcExecutor.2
            @Override // java.lang.Runnable
            public void run() {
                if (!UnifierPollingRpcExecutor.this.mIsHandlingResult) {
                    LoggerWrapper.i("UnifierPollingRpcExecutor", "Task is stopped! Will not schedule next polling.");
                    return;
                }
                UnifierPollingRpcExecutor.this.a();
                UnifierPollingRpcExecutor.access$104(UnifierPollingRpcExecutor.this);
                UnifierPollingRpcExecutor.this.b();
            }
        };
        this.f7398a = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        UnifierPollingRpcRequest unifierPollingRpcRequest = (UnifierPollingRpcRequest) this.mQueryDelegate.generateRequest();
        if (unifierPollingRpcRequest == null || TextUtils.isEmpty(unifierPollingRpcRequest.mLinkTargetId) || unifierPollingRpcRequest.mBizNos == null || unifierPollingRpcRequest.mBizNos.size() == 0) {
            LoggerWrapper.w("UnifierPollingRpcExecutor", "Polling request illegal, do NOTHING!");
        } else {
            a.a(this.mQueryConfig.mBizType, unifierPollingRpcRequest, new IAPAsyncCallback<UniResultPageQueryResult>() { // from class: com.alipay.plus.android.unipayresult.sdk.executor.UnifierPollingRpcExecutor.1
                @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                public void onFailure(IAPError iAPError) {
                    LoggerWrapper.e("UnifierPollingRpcExecutor", String.format("Rpc query pay result FAILED! bizType = %s, error = %s", UnifierPollingRpcExecutor.this.mQueryConfig.mBizType, iAPError.toString()));
                }

                @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                public void onSuccess(UniResultPageQueryResult uniResultPageQueryResult) {
                    if (uniResultPageQueryResult == null) {
                        LoggerWrapper.w("UnifierPollingRpcExecutor", "Receive null pay rpc query message, do NOTHING!");
                        return;
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = UnifierPollingRpcExecutor.this.mQueryConfig.mBizType;
                    objArr[1] = Integer.valueOf(uniResultPageQueryResult.bizModelsJsonStr != null ? uniResultPageQueryResult.bizModelsJsonStr.length() : 0);
                    LoggerWrapper.i("UnifierPollingRpcExecutor", String.format("Receive pay rpc query result! bizType = %s, bytes = %d", objArr));
                    UnifierPollingRpcExecutor.this.handlePayResultInternal(uniResultPageQueryResult.bizModelsJsonStr);
                }
            });
        }
    }

    static /* synthetic */ int access$104(UnifierPollingRpcExecutor unifierPollingRpcExecutor) {
        int i = unifierPollingRpcExecutor.d + 1;
        unifierPollingRpcExecutor.d = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        handler.postDelayed(this.e, c());
    }

    private int c() {
        int i = this.d;
        int size = this.f7398a.size() - 1;
        if (i > size) {
            i = size;
        }
        return this.f7398a.get(i).intValue();
    }

    @Override // com.alipay.plus.android.unipayresult.sdk.executor.AbstractUnifierQueryExecutor
    public void start() {
        if (this.mQueryConfig == null) {
            LoggerWrapper.e("UnifierPollingRpcExecutor", "setQueryConfig should be called first");
            return;
        }
        LoggerWrapper.i("UnifierPollingRpcExecutor", String.format("Start polling-rpc query! BizType:%s", this.mQueryConfig.mBizType));
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("UnifierPollingRpcExecutor_Thread");
            this.b = handlerThread;
            handlerThread.start();
            this.c = new Handler(this.b.getLooper());
        }
        this.d = 0;
        this.mIsHandlingResult = true;
        this.c.removeCallbacks(this.e);
        b();
    }

    @Override // com.alipay.plus.android.unipayresult.sdk.executor.AbstractUnifierQueryExecutor
    public void stop() {
        if (this.mQueryConfig == null) {
            LoggerWrapper.e("UnifierPollingRpcExecutor", "setQueryConfig should be called first");
            return;
        }
        LoggerWrapper.i("UnifierPollingRpcExecutor", String.format("Stop polling-rpc query! BizType: %s", this.mQueryConfig.mBizType));
        this.mIsHandlingResult = false;
        this.d = 0;
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacks(this.e);
            this.c = null;
        }
        HandlerThread handlerThread = this.b;
        if (handlerThread != null) {
            handlerThread.quit();
            this.b = null;
        }
    }
}
