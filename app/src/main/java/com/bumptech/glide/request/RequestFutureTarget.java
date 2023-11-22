package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter getAuthRequestContext = new Waiter();
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private GlideException MyBillsEntityDataFactory;
    private R NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final int PlaceComponentResult;
    private Request getErrorConfigVersion;
    private final int initRecordTimeStamp;
    private boolean lookAheadTest;
    private boolean moveToNextValue;
    private final Waiter scheduleImpl;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    public RequestFutureTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE, getAuthRequestContext);
    }

    private RequestFutureTarget(int i, int i2, Waiter waiter) {
        this.initRecordTimeStamp = Integer.MIN_VALUE;
        this.PlaceComponentResult = Integer.MIN_VALUE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.scheduleImpl = waiter;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            Waiter.PlaceComponentResult(this);
            Request request = null;
            if (z) {
                Request request2 = this.getErrorConfigVersion;
                this.getErrorConfigVersion = null;
                request = request2;
            }
            if (request != null) {
                request.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this) {
            z = this.BuiltInFictitiousFunctionClassFactory;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this) {
            if (!this.BuiltInFictitiousFunctionClassFactory && !this.lookAheadTest) {
                z = this.moveToNextValue;
            }
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return PlaceComponentResult(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return PlaceComponentResult(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp, this.PlaceComponentResult);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        synchronized (this) {
            this.getErrorConfigVersion = request;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        Request request;
        synchronized (this) {
            request = this.getErrorConfigVersion;
        }
        return request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        synchronized (this) {
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(R r, Transition<? super R> transition) {
        synchronized (this) {
        }
    }

    private R PlaceComponentResult(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 && !isDone()) {
                Util.getAuthRequestContext();
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                throw new CancellationException();
            }
            if (this.moveToNextValue) {
                throw new ExecutionException(this.MyBillsEntityDataFactory);
            }
            if (this.lookAheadTest) {
                return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            if (l == null) {
                Waiter.BuiltInFictitiousFunctionClassFactory(this, 0L);
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    Waiter.BuiltInFictitiousFunctionClassFactory(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.moveToNextValue) {
                throw new ExecutionException(this.MyBillsEntityDataFactory);
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                throw new CancellationException();
            }
            if (!this.lookAheadTest) {
                throw new TimeoutException();
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target<R> target, boolean z) {
        synchronized (this) {
            this.moveToNextValue = true;
            this.MyBillsEntityDataFactory = glideException;
            Waiter.PlaceComponentResult(this);
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        synchronized (this) {
            this.lookAheadTest = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = r;
            Waiter.PlaceComponentResult(this);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Waiter {
        Waiter() {
        }

        static void BuiltInFictitiousFunctionClassFactory(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        static void PlaceComponentResult(Object obj) {
            obj.notifyAll();
        }
    }
}
