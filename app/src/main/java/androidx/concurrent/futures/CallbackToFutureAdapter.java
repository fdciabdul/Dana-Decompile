package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public final class CallbackToFutureAdapter {

    /* loaded from: classes6.dex */
    public interface Resolver<T> {
    }

    private CallbackToFutureAdapter() {
    }

    /* loaded from: classes6.dex */
    static final class SafeFuture<T> implements ListenableFuture<T> {
        final WeakReference<Completer<T>> BuiltInFictitiousFunctionClassFactory;
        private final AbstractResolvableFuture<T> getAuthRequestContext;

        /* renamed from: androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass1 extends AbstractResolvableFuture<T> {
            final /* synthetic */ SafeFuture NetworkUserEntityData$$ExternalSyntheticLambda0;

            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            protected final String PlaceComponentResult() {
                Completer<T> completer = this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("tag=[");
                sb.append(completer.PlaceComponentResult);
                sb.append("]");
                return sb.toString();
            }
        }

        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            Completer<T> completer = this.BuiltInFictitiousFunctionClassFactory.get();
            boolean cancel = this.getAuthRequestContext.cancel(z);
            if (cancel && completer != null) {
                completer.PlaceComponentResult = null;
                completer.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                completer.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(null);
            }
            return cancel;
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2(T t) {
            return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(t);
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
            return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(th);
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.getAuthRequestContext.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            return this.getAuthRequestContext.isDone();
        }

        @Override // java.util.concurrent.Future
        public final T get() throws InterruptedException, ExecutionException {
            return this.getAuthRequestContext.get();
        }

        @Override // java.util.concurrent.Future
        public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.getAuthRequestContext.get(j, timeUnit);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            this.getAuthRequestContext.addListener(runnable, executor);
        }

        public final String toString() {
            return this.getAuthRequestContext.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class Completer<T> {
        ResolvableFuture<Void> BuiltInFictitiousFunctionClassFactory = ResolvableFuture.MyBillsEntityDataFactory();
        SafeFuture<T> KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean MyBillsEntityDataFactory;
        Object PlaceComponentResult;

        Completer() {
        }

        public final boolean PlaceComponentResult(T t) {
            this.MyBillsEntityDataFactory = true;
            SafeFuture<T> safeFuture = this.KClassImpl$Data$declaredNonStaticMembers$2;
            boolean z = safeFuture != null && safeFuture.KClassImpl$Data$declaredNonStaticMembers$2((SafeFuture<T>) t);
            if (z) {
                this.PlaceComponentResult = null;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
            return z;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(Throwable th) {
            this.MyBillsEntityDataFactory = true;
            SafeFuture<T> safeFuture = this.KClassImpl$Data$declaredNonStaticMembers$2;
            boolean z = safeFuture != null && safeFuture.KClassImpl$Data$declaredNonStaticMembers$2(th);
            if (z) {
                this.PlaceComponentResult = null;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
            return z;
        }

        protected final void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (safeFuture != null && !safeFuture.isDone()) {
                StringBuilder sb = new StringBuilder();
                sb.append("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
                sb.append(this.PlaceComponentResult);
                safeFuture.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) new FutureGarbageCollectedException(sb.toString()));
            }
            if (this.MyBillsEntityDataFactory || (resolvableFuture = this.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            resolvableFuture.BuiltInFictitiousFunctionClassFactory(null);
        }
    }

    /* loaded from: classes6.dex */
    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public final Throwable fillInStackTrace() {
            synchronized (this) {
            }
            return this;
        }
    }
}
