package androidx.emoji2.text;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public final /* synthetic */ class ConcurrencyHelpers$$ExternalSyntheticLambda1 implements Executor {
    public final /* synthetic */ Handler MyBillsEntityDataFactory;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.MyBillsEntityDataFactory.post(runnable);
    }
}
