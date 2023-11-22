package com.alipay.iap.android.f2fpay.common;

import android.os.AsyncTask;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.task.AsyncTaskExecutor;
import com.alipay.iap.android.common.task.async.IAPAsyncCallback;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipayplus.mobile.component.common.facade.base.result.BaseServiceResult;

/* loaded from: classes3.dex */
public abstract class F2FPayAsyncTask extends IAPAsyncTask {

    /* loaded from: classes3.dex */
    public static abstract class F2FPayRunner<T> implements IAPAsyncTask.Runner<T> {
        @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
        public void onFailure(IAPError iAPError) {
            if (iAPError != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onFailure: ");
                sb.append(iAPError.toString());
                LoggerWrapper.e(F2FPayConstants.TAG, sb.toString());
            }
        }

        @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
        public void onSuccess(T t) {
            if (t instanceof BaseServiceResult) {
                BaseServiceResult baseServiceResult = (BaseServiceResult) t;
                LoggerWrapper.e(F2FPayConstants.TAG, String.format("onSuccess: success = %s, errorCode = %s, errorMsg = %s", String.valueOf(baseServiceResult.success), baseServiceResult.errorCode, baseServiceResult.errorMessage));
            }
        }
    }

    public F2FPayAsyncTask(IAPAsyncCallback iAPAsyncCallback) {
        super(iAPAsyncCallback);
    }

    @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask
    public IAPError createIAPError(Exception exc) {
        return exc instanceof RpcException ? new IAPError((RpcException) exc) : new IAPError(F2FPayErrorCode.ILLEGAL_ACCESS, exc.getMessage());
    }

    public AsyncTask<Void, Void, Object> executeOnDefaultExecutor() {
        return executeOnExecutor(AsyncTaskExecutor.getInstance().getExecutor(), new Void[0]);
    }

    @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask
    public void printError(Exception exc) {
        LoggerWrapper.e(F2FPayConstants.TAG, exc.getMessage(), exc);
    }
}
