package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
public class LottieTask<T> {
    public static Executor BuiltInFictitiousFunctionClassFactory = Executors.newCachedThreadPool();
    final Set<LottieListener<Throwable>> KClassImpl$Data$declaredNonStaticMembers$2;
    volatile LottieResult<T> MyBillsEntityDataFactory;
    private final Handler PlaceComponentResult;
    final Set<LottieListener<T>> getAuthRequestContext;

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.getAuthRequestContext = new LinkedHashSet(1);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashSet(1);
        this.PlaceComponentResult = new Handler(Looper.getMainLooper());
        this.MyBillsEntityDataFactory = null;
        if (z) {
            try {
                LottieResult<T> call = callable.call();
                if (this.MyBillsEntityDataFactory != null) {
                    throw new IllegalStateException("A task may only be set once.");
                }
                this.MyBillsEntityDataFactory = call;
                this.PlaceComponentResult.post(new LottieTask$$ExternalSyntheticLambda0(this));
                return;
            } catch (Throwable th) {
                LottieResult<T> lottieResult = new LottieResult<>(th);
                if (this.MyBillsEntityDataFactory != null) {
                    throw new IllegalStateException("A task may only be set once.");
                }
                this.MyBillsEntityDataFactory = lottieResult;
                this.PlaceComponentResult.post(new LottieTask$$ExternalSyntheticLambda0(this));
                return;
            }
        }
        BuiltInFictitiousFunctionClassFactory.execute(new LottieFutureTask(callable));
    }

    public final LottieTask<T> BuiltInFictitiousFunctionClassFactory(LottieListener<T> lottieListener) {
        synchronized (this) {
            LottieResult<T> lottieResult = this.MyBillsEntityDataFactory;
            if (lottieResult != null && lottieResult.PlaceComponentResult != null) {
                lottieListener.KClassImpl$Data$declaredNonStaticMembers$2(lottieResult.PlaceComponentResult);
            }
            this.getAuthRequestContext.add(lottieListener);
        }
        return this;
    }

    public final LottieTask<T> PlaceComponentResult(LottieListener<T> lottieListener) {
        synchronized (this) {
            this.getAuthRequestContext.remove(lottieListener);
        }
        return this;
    }

    public final LottieTask<T> getAuthRequestContext(LottieListener<Throwable> lottieListener) {
        synchronized (this) {
            LottieResult<T> lottieResult = this.MyBillsEntityDataFactory;
            if (lottieResult != null && lottieResult.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                lottieListener.KClassImpl$Data$declaredNonStaticMembers$2(lottieResult.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(lottieListener);
        }
        return this;
    }

    public final LottieTask<T> KClassImpl$Data$declaredNonStaticMembers$2(LottieListener<Throwable> lottieListener) {
        synchronized (this) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.remove(lottieListener);
        }
        return this;
    }

    /* loaded from: classes3.dex */
    class LottieFutureTask extends FutureTask<LottieResult<T>> {
        LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask.MyBillsEntityDataFactory(LottieTask.this, get());
            } catch (InterruptedException | ExecutionException e) {
                LottieTask.MyBillsEntityDataFactory(LottieTask.this, new LottieResult(e));
            }
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(LottieTask lottieTask, LottieResult lottieResult) {
        if (lottieTask.MyBillsEntityDataFactory != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        lottieTask.MyBillsEntityDataFactory = lottieResult;
        lottieTask.PlaceComponentResult.post(new LottieTask$$ExternalSyntheticLambda0(lottieTask));
    }
}
