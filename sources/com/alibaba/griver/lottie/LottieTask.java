package com.alibaba.griver.lottie;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.griver.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* loaded from: classes6.dex */
public class LottieTask<T> {
    public static Executor EXECUTOR = AsyncTask.THREAD_POOL_EXECUTOR;
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    private volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new LottieResult<>(th));
                return;
            }
        }
        EXECUTOR.execute(new LottieFutureTask(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(LottieResult<T> lottieResult) {
        if (this.result != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.result = lottieResult;
        notifyListeners();
    }

    public LottieTask<T> addListener(LottieListener<T> lottieListener) {
        synchronized (this) {
            if (this.result != null && this.result.getValue() != null) {
                lottieListener.onResult(this.result.getValue());
            }
            this.successListeners.add(lottieListener);
        }
        return this;
    }

    public LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        synchronized (this) {
            this.successListeners.remove(lottieListener);
        }
        return this;
    }

    public LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        synchronized (this) {
            if (this.result != null && this.result.getException() != null) {
                lottieListener.onResult(this.result.getException());
            }
            this.failureListeners.add(lottieListener);
        }
        return this;
    }

    public LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        synchronized (this) {
            this.failureListeners.remove(lottieListener);
        }
        return this;
    }

    private void notifyListeners() {
        this.handler.post(new Runnable() { // from class: com.alibaba.griver.lottie.LottieTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (LottieTask.this.result == null) {
                    return;
                }
                LottieResult lottieResult = LottieTask.this.result;
                if (lottieResult.getValue() != null) {
                    LottieTask.this.notifySuccessListeners(lottieResult.getValue());
                } else {
                    LottieTask.this.notifyFailureListeners(lottieResult.getException());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySuccessListeners(T t) {
        synchronized (this) {
            Iterator it = new ArrayList(this.successListeners).iterator();
            while (it.hasNext()) {
                ((LottieListener) it.next()).onResult(t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailureListeners(Throwable th) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList(this.failureListeners);
            if (arrayList.isEmpty()) {
                Logger.warning("Lottie encountered an error but no failure listener was added:", th);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((LottieListener) it.next()).onResult(th);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                LottieTask.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                LottieTask.this.setResult(new LottieResult(e));
            }
        }
    }
}
