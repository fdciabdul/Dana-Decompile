package io.reactivex.internal.operators.flowable;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean MyBillsEntityDataFactory;
    final Scheduler getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.getAuthRequestContext.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, createWorker, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory);
        subscriber.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }

    /* loaded from: classes9.dex */
    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Subscriber<? super T> downstream;
        final boolean nonScheduledRequests;
        Publisher<T> source;
        final Scheduler.Worker worker;
        public static final byte[] MyBillsEntityDataFactory = {111, -54, 77, -36, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 129;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r7, int r8, byte r9, java.lang.Object[] r10) {
            /*
                int r9 = r9 * 3
                int r9 = r9 + 13
                byte[] r0 = io.reactivex.internal.operators.flowable.FlowableSubscribeOn.SubscribeOnSubscriber.MyBillsEntityDataFactory
                int r7 = r7 * 7
                int r7 = r7 + 99
                int r8 = r8 * 12
                int r8 = r8 + 4
                byte[] r1 = new byte[r9]
                int r9 = r9 + (-1)
                r2 = 0
                if (r0 != 0) goto L1c
                r7 = r8
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L38
            L1c:
                r3 = 0
            L1d:
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r9) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r8
                r8 = r7
                r7 = r5
                r6 = r10
                r10 = r9
                r9 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r6
            L38:
                int r9 = -r9
                int r8 = r8 + r9
                int r8 = r8 + 2
                int r7 = r7 + 1
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L1d
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableSubscribeOn.SubscribeOnSubscriber.a(byte, int, byte, java.lang.Object[]):void");
        }

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean z) {
            this.downstream = subscriber;
            this.worker = worker;
            this.source = publisher;
            this.nonScheduledRequests = !z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                byte b = (byte) (-MyBillsEntityDataFactory[15]);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (MyBillsEntityDataFactory[15] + 1);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                lazySet(cls.getMethod((String) objArr2[0], null).invoke(null, null));
                Publisher<T> publisher = this.source;
                this.source = null;
                publisher.subscribe(this);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, subscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                Subscription subscription = this.upstream.get();
                if (subscription != null) {
                    requestUpstream(j, subscription);
                    return;
                }
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                Subscription subscription2 = this.upstream.get();
                if (subscription2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, subscription2);
                    }
                }
            }
        }

        final void requestUpstream(long j, Subscription subscription) {
            if (!this.nonScheduledRequests) {
                try {
                    byte b = (byte) (-MyBillsEntityDataFactory[15]);
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (MyBillsEntityDataFactory[15] + 1);
                    byte b4 = b3;
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != get()) {
                        this.worker.schedule(new Request(subscription, j));
                        return;
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            subscription.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public static final class Request implements Runnable {
            final long BuiltInFictitiousFunctionClassFactory;
            final Subscription PlaceComponentResult;

            Request(Subscription subscription, long j) {
                this.PlaceComponentResult = subscription;
                this.BuiltInFictitiousFunctionClassFactory = j;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.PlaceComponentResult.request(this.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }
}
