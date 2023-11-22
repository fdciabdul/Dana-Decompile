package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class MaybeConcatArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.getAuthRequestContext);
        subscriber.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.drain();
    }

    /* loaded from: classes9.dex */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final Subscriber<? super T> downstream;
        int index;
        long produced;
        final MaybeSource<? extends T>[] sources;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable disposables = new SequentialDisposable();
        final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

        ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.downstream = subscriber;
            this.sources = maybeSourceArr;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.disposables.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            this.disposables.replace(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x004f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void drain() {
            /*
                r10 = this;
                int r0 = r10.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r10.current
                org.reactivestreams.Subscriber<? super T> r1 = r10.downstream
                io.reactivex.internal.disposables.SequentialDisposable r2 = r10.disposables
            Ld:
                boolean r3 = r2.isDisposed()
                r4 = 0
                if (r3 == 0) goto L18
                r0.lazySet(r4)
                return
            L18:
                java.lang.Object r3 = r0.get()
                if (r3 == 0) goto L5c
                io.reactivex.internal.util.NotificationLite r5 = io.reactivex.internal.util.NotificationLite.COMPLETE
                if (r3 == r5) goto L3c
                long r5 = r10.produced
                java.util.concurrent.atomic.AtomicLong r7 = r10.requested
                long r7 = r7.get()
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 == 0) goto L3a
                r7 = 1
                long r5 = r5 + r7
                r10.produced = r5
                r0.lazySet(r4)
                r1.onNext(r3)
                goto L3f
            L3a:
                r3 = 0
                goto L40
            L3c:
                r0.lazySet(r4)
            L3f:
                r3 = 1
            L40:
                if (r3 == 0) goto L5c
                boolean r3 = r2.isDisposed()
                if (r3 != 0) goto L5c
                int r3 = r10.index
                io.reactivex.MaybeSource<? extends T>[] r4 = r10.sources
                int r5 = r4.length
                if (r3 != r5) goto L53
                r1.onComplete()
                return
            L53:
                int r5 = r3 + 1
                r10.index = r5
                r3 = r4[r3]
                r3.PlaceComponentResult(r10)
            L5c:
                int r3 = r10.decrementAndGet()
                if (r3 != 0) goto Ld
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.maybe.MaybeConcatArray.ConcatMaybeObserver.drain():void");
        }
    }
}
