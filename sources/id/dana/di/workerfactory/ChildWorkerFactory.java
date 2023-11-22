package id.dana.di.workerfactory;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

/* loaded from: classes2.dex */
public interface ChildWorkerFactory {
    ListenableWorker MyBillsEntityDataFactory(Context context, WorkerParameters workerParameters);
}
