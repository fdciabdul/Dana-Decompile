package com.iap.ac.android.common.task.async;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.common.errorcode.IAPError;
import com.iap.ac.android.common.errorcode.IAPException;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.AsyncTaskExecutor;
import java.lang.reflect.UndeclaredThrowableException;

/* loaded from: classes3.dex */
public abstract class IAPAsyncTask extends AsyncTask<Void, Void, Object> {
    public IAPAsyncCallback callback;

    /* loaded from: classes3.dex */
    public interface Runner<T> extends IAPAsyncCallback<T> {
        T execute() throws Exception;
    }

    public IAPAsyncTask(IAPAsyncCallback iAPAsyncCallback) {
        this.callback = iAPAsyncCallback;
    }

    public static <T> void asyncTask(final Runner<T> runner) {
        new IAPAsyncTask(runner) { // from class: com.iap.ac.android.common.task.async.IAPAsyncTask.1
            @Override // com.iap.ac.android.common.task.async.IAPAsyncTask, android.os.AsyncTask
            public final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) {
                return super.doInBackground(voidArr);
            }

            @Override // com.iap.ac.android.common.task.async.IAPAsyncTask
            public final Object run() throws Exception {
                return runner.execute();
            }
        }.executeOnExecutor(AsyncTaskExecutor.getInstance().getExecutor(), new Void[0]);
    }

    public IAPError createIAPError(Exception exc) {
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

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        if (this.callback == null) {
            return;
        }
        if (obj instanceof Exception) {
            ACLog.d("IAPAsyncTask", "call back on failure");
            this.callback.onFailure((Exception) obj);
            return;
        }
        ACLog.d("IAPAsyncTask", "call back on success");
        this.callback.onSuccess(obj);
    }

    @Deprecated
    public void printError(Exception exc) {
    }

    public abstract Object run() throws Exception;

    @Override // android.os.AsyncTask
    public Object doInBackground(Void... voidArr) {
        try {
            return run();
        } catch (Exception e) {
            ACLog.e("IAPAsyncTask", e.getMessage(), e);
            return e;
        }
    }

    public static void asyncTask(final Runnable runnable) {
        new IAPAsyncTask(null) { // from class: com.iap.ac.android.common.task.async.IAPAsyncTask.2
            @Override // com.iap.ac.android.common.task.async.IAPAsyncTask, android.os.AsyncTask
            public final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) {
                return super.doInBackground(voidArr);
            }

            @Override // com.iap.ac.android.common.task.async.IAPAsyncTask
            public final Object run() throws Exception {
                runnable.run();
                return null;
            }
        }.executeOnExecutor(AsyncTaskExecutor.getInstance().getExecutor(), new Void[0]);
    }
}
