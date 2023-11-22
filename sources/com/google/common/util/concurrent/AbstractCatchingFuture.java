package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.lang.Throwable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    @CheckForNull
    Class<X> exceptionType;
    @CheckForNull
    F fallback;
    @CheckForNull
    ListenableFuture<? extends V> inputFuture;

    @ParametricNullness
    abstract T doFallback(F f, X x) throws Exception;

    abstract void setResult(@ParametricNullness T t);

    public static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
        return catchingFuture;
    }

    public static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class) Preconditions.checkNotNull(cls);
        this.fallback = (F) Preconditions.checkNotNull(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x007c  */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class<X extends java.lang.Throwable>, F] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r7 = this;
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r7.inputFuture
            java.lang.Class<X extends java.lang.Throwable> r1 = r7.exceptionType
            F r2 = r7.fallback
            r3 = 0
            r4 = 1
            if (r0 != 0) goto Lc
            r5 = 1
            goto Ld
        Lc:
            r5 = 0
        Ld:
            if (r1 != 0) goto L11
            r6 = 1
            goto L12
        L11:
            r6 = 0
        L12:
            if (r2 == 0) goto L15
            goto L16
        L15:
            r3 = 1
        L16:
            r4 = r5 | r6
            r3 = r3 | r4
            if (r3 != 0) goto La4
            boolean r3 = r7.isCancelled()
            if (r3 != 0) goto La4
            r3 = 0
            r7.inputFuture = r3
            boolean r4 = r0 instanceof com.google.common.util.concurrent.internal.InternalFutureFailureAccess
            if (r4 == 0) goto L36
            r4 = r0
            com.google.common.util.concurrent.internal.InternalFutureFailureAccess r4 = (com.google.common.util.concurrent.internal.InternalFutureFailureAccess) r4     // Catch: java.lang.Error -> L30 java.lang.RuntimeException -> L32 java.util.concurrent.ExecutionException -> L34
            java.lang.Throwable r4 = com.google.common.util.concurrent.internal.InternalFutures.tryInternalFastPathGetFailure(r4)     // Catch: java.lang.Error -> L30 java.lang.RuntimeException -> L32 java.util.concurrent.ExecutionException -> L34
            goto L37
        L30:
            r4 = move-exception
            goto L71
        L32:
            r4 = move-exception
            goto L71
        L34:
            r4 = move-exception
            goto L3e
        L36:
            r4 = r3
        L37:
            if (r4 != 0) goto L71
            java.lang.Object r5 = com.google.common.util.concurrent.Futures.getDone(r0)     // Catch: java.lang.Error -> L30 java.lang.RuntimeException -> L32 java.util.concurrent.ExecutionException -> L34
            goto L72
        L3e:
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L70
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Future type "
            r5.append(r6)
            java.lang.Class r6 = r0.getClass()
            r5.append(r6)
            java.lang.String r6 = " threw "
            r5.append(r6)
            java.lang.Class r4 = r4.getClass()
            r5.append(r4)
            java.lang.String r4 = " without a cause"
            r5.append(r4)
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            r5 = r4
        L70:
            r4 = r5
        L71:
            r5 = r3
        L72:
            if (r4 != 0) goto L7c
            java.lang.Object r0 = com.google.common.util.concurrent.NullnessCasts.uncheckedCastNullableTToT(r5)
            r7.set(r0)
            return
        L7c:
            boolean r1 = com.google.common.util.concurrent.Platform.isInstanceOfThrowableClass(r4, r1)
            if (r1 != 0) goto L86
            r7.setFuture(r0)
            return
        L86:
            java.lang.Object r0 = r7.doFallback(r2, r4)     // Catch: java.lang.Throwable -> L92
            r7.exceptionType = r3
            r7.fallback = r3
            r7.setResult(r0)
            return
        L92:
            r0 = move-exception
            com.google.common.util.concurrent.Platform.restoreInterruptIfIsInterruptedException(r0)     // Catch: java.lang.Throwable -> L9e
            r7.setException(r0)     // Catch: java.lang.Throwable -> L9e
            r7.exceptionType = r3
            r7.fallback = r3
            return
        L9e:
            r0 = move-exception
            r7.exceptionType = r3
            r7.fallback = r3
            throw r0
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractCatchingFuture.run():void");
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("inputFuture=[");
            sb.append(listenableFuture);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (cls == null || f == null) {
            if (pendingToString != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(pendingToString);
                return sb2.toString();
            }
            return null;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("exceptionType=[");
        sb3.append(cls);
        sb3.append("], fallback=[");
        sb3.append(f);
        sb3.append("]");
        return sb3.toString();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    /* loaded from: classes7.dex */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        final /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((AsyncFunction<? super AsyncFunction<? super X, ? extends V>, ? extends V>) obj, (AsyncFunction<? super X, ? extends V>) th);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        final /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((ListenableFuture) ((ListenableFuture) obj));
        }

        AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        final ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws Exception {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        final void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    /* loaded from: classes7.dex */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @ParametricNullness
        final /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((Function<? super Function<? super X, ? extends V>, ? extends V>) obj, (Function<? super X, ? extends V>) th);
        }

        CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        @ParametricNullness
        final V doFallback(Function<? super X, ? extends V> function, X x) throws Exception {
            return function.apply(x);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        final void setResult(@ParametricNullness V v) {
            set(v);
        }
    }
}
