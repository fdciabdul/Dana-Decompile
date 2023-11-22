package io.branch.referral;

import android.os.AsyncTask;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class BranchAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public final AsyncTask<Params, Progress, Result> KClassImpl$Data$declaredNonStaticMembers$2(Params... paramsArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                return executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
            } catch (Throwable unused) {
                return execute(paramsArr);
            }
        }
        return execute(paramsArr);
    }
}
