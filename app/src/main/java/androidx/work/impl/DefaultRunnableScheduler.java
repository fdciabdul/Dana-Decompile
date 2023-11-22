package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

/* loaded from: classes.dex */
public class DefaultRunnableScheduler implements RunnableScheduler {
    private final Handler MyBillsEntityDataFactory = HandlerCompat.MyBillsEntityDataFactory(Looper.getMainLooper());

    @Override // androidx.work.RunnableScheduler
    public final void getAuthRequestContext(long j, Runnable runnable) {
        this.MyBillsEntityDataFactory.postDelayed(runnable, j);
    }

    @Override // androidx.work.RunnableScheduler
    public final void MyBillsEntityDataFactory(Runnable runnable) {
        this.MyBillsEntityDataFactory.removeCallbacks(runnable);
    }
}
