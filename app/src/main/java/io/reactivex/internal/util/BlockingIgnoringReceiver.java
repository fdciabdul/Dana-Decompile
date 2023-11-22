package io.reactivex.internal.util;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes9.dex */
public final class BlockingIgnoringReceiver extends CountDownLatch implements Consumer<Throwable>, Action {
    public Throwable getAuthRequestContext;

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Throwable th) throws Exception {
        this.getAuthRequestContext = th;
        countDown();
    }

    public BlockingIgnoringReceiver() {
        super(1);
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        countDown();
    }
}
