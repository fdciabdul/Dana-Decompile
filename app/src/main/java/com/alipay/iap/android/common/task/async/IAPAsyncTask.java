package com.alipay.iap.android.common.task.async;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.errorcode.IAPException;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.task.AsyncTaskExecutor;
import com.alipay.mobile.common.rpc.RpcException;
import java.lang.reflect.UndeclaredThrowableException;

/* loaded from: classes3.dex */
public abstract class IAPAsyncTask extends AsyncTask<Void, Void, Object> {
    protected IAPAsyncCallback callback;

    /* loaded from: classes3.dex */
    public interface Runner<T> extends IAPAsyncCallback<T> {
        T execute() throws Exception;
    }

    @Deprecated
    protected void printError(Exception exc) {
    }

    protected abstract Object run() throws Exception;

    public IAPAsyncTask(IAPAsyncCallback iAPAsyncCallback) {
        this.callback = iAPAsyncCallback;
    }

    protected IAPError createIAPError(Exception exc) {
        Throwable undeclaredThrowable;
        if (exc instanceof RpcException) {
            return new IAPError((RpcException) exc);
        }
        if (exc instanceof IAPException) {
            return ((IAPException) exc).getError();
        }
        String str = null;
        if ((exc instanceof UndeclaredThrowableException) && (undeclaredThrowable = ((UndeclaredThrowableException) exc).getUndeclaredThrowable()) != null) {
            str = undeclaredThrowable.toString();
        }
        if (TextUtils.isEmpty(str)) {
            str = exc.toString();
        }
        return new IAPError("unknown", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Object doInBackground(Void... voidArr) {
        try {
            return run();
        } catch (RpcException e) {
            LoggerWrapper.e("IAPAsyncTask", e.getMessage(), e);
            return new IAPError(e);
        } catch (Exception e2) {
            LoggerWrapper.e("IAPAsyncTask", e2.getMessage(), e2);
            return createIAPError(e2);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        if (this.callback == null) {
            return;
        }
        if (IAPError.class.isInstance(obj)) {
            LoggerWrapper.d("IAPAsyncTask", "call back on failure");
            this.callback.onFailure((IAPError) obj);
            return;
        }
        LoggerWrapper.d("IAPAsyncTask", "call back on success");
        this.callback.onSuccess(obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.alipay.iap.android.common.task.async.IAPAsyncTask$1] */
    public static <T> void asyncTask(final Runner<T> runner) {
        new IAPAsyncTask(runner) { // from class: com.alipay.iap.android.common.task.async.IAPAsyncTask.1
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask, android.os.AsyncTask
            protected final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) {
                return super.doInBackground(voidArr);
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask
            protected final Object run() throws Exception {
                return runner.execute();
            }
        }.executeOnExecutor(AsyncTaskExecutor.getInstance().getExecutor(), new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.alipay.iap.android.common.task.async.IAPAsyncTask$2] */
    public static void asyncTask(final Runnable runnable) {
        new IAPAsyncTask(null) { // from class: com.alipay.iap.android.common.task.async.IAPAsyncTask.2
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask, android.os.AsyncTask
            protected final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) {
                return super.doInBackground(voidArr);
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask
            protected final Object run() throws Exception {
                runnable.run();
                return null;
            }
        }.executeOnExecutor(AsyncTaskExecutor.getInstance().getExecutor(), new Void[0]);
    }
}
