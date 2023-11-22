package io.reactivex.subscribers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription, Disposable {
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {104, -68, 0, 44, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int lookAheadTest = 107;
    private QueueSubscription<T> DatabaseTableConfigUtil;
    private final Subscriber<? super T> GetContactSyncConfig;
    private final AtomicReference<Subscription> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private volatile boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final AtomicLong initRecordTimeStamp;

    /* loaded from: classes9.dex */
    enum EmptySubscriber implements FlowableSubscriber<Object> {
        INSTANCE;

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(Object obj) {
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 12
            int r7 = 15 - r7
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r0 = io.reactivex.subscribers.TestSubscriber.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r8 = r8 * 7
            int r8 = r8 + 99
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L38
        L1c:
            r3 = 0
        L1d:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subscribers.TestSubscriber.a(byte, byte, byte, java.lang.Object[]):void");
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE);
    }

    private TestSubscriber(Subscriber<? super T> subscriber) {
        this.GetContactSyncConfig = subscriber;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new AtomicReference<>();
        this.initRecordTimeStamp = new AtomicLong(LongCompanionObject.MAX_VALUE);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        try {
            byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[2];
            Object[] objArr = new Object[1];
            a(b, b, (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            Object[] objArr2 = new Object[1];
            a(b2, b2, NetworkUserEntityData$$ExternalSyntheticLambda0[2], objArr2);
            this.getErrorConfigVersion = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            if (subscription == null) {
                this.getAuthRequestContext.add(new NullPointerException("onSubscribe received a null Subscription"));
            } else if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, null, subscription)) {
                subscription.cancel();
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.get() != SubscriptionHelper.CANCELLED) {
                    List<Throwable> list = this.getAuthRequestContext;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSubscribe received multiple subscriptions: ");
                    sb.append(subscription);
                    list.add(new IllegalStateException(sb.toString()));
                }
            } else {
                if (this.scheduleImpl != 0 && (subscription instanceof QueueSubscription)) {
                    QueueSubscription<T> queueSubscription = (QueueSubscription) subscription;
                    this.DatabaseTableConfigUtil = queueSubscription;
                    int requestFusion = queueSubscription.requestFusion(this.scheduleImpl);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = requestFusion;
                    if (requestFusion == 1) {
                        this.BuiltInFictitiousFunctionClassFactory = true;
                        try {
                            byte b3 = NetworkUserEntityData$$ExternalSyntheticLambda0[2];
                            Object[] objArr3 = new Object[1];
                            a(b3, b3, (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr3);
                            Class<?> cls2 = Class.forName((String) objArr3[0]);
                            byte b4 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                            Object[] objArr4 = new Object[1];
                            a(b4, b4, NetworkUserEntityData$$ExternalSyntheticLambda0[2], objArr4);
                            this.getErrorConfigVersion = (Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null);
                            while (true) {
                                try {
                                    T poll = this.DatabaseTableConfigUtil.poll();
                                    if (poll != null) {
                                        this.moveToNextValue.add(poll);
                                    } else {
                                        this.PlaceComponentResult++;
                                        return;
                                    }
                                } catch (Throwable th) {
                                    this.getAuthRequestContext.add(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Throwable cause = th2.getCause();
                            if (cause == null) {
                                throw th2;
                            }
                            throw cause;
                        }
                    }
                }
                this.GetContactSyncConfig.onSubscribe(subscription);
                long andSet = this.initRecordTimeStamp.getAndSet(0L);
                if (andSet != 0) {
                    subscription.request(andSet);
                }
            }
        } catch (Throwable th3) {
            Throwable cause2 = th3.getCause();
            if (cause2 == null) {
                throw th3;
            }
            throw cause2;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.get() == null) {
                this.getAuthRequestContext.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[2];
            Object[] objArr = new Object[1];
            a(b, b, (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            Object[] objArr2 = new Object[1];
            a(b2, b2, NetworkUserEntityData$$ExternalSyntheticLambda0[2], objArr2);
            this.getErrorConfigVersion = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 2) {
                this.moveToNextValue.add(t);
                if (t == null) {
                    this.getAuthRequestContext.add(new NullPointerException("onNext received a null value"));
                }
                this.GetContactSyncConfig.onNext(t);
                return;
            }
            while (true) {
                try {
                    T poll = this.DatabaseTableConfigUtil.poll();
                    if (poll == null) {
                        return;
                    }
                    this.moveToNextValue.add(poll);
                } catch (Throwable th) {
                    this.getAuthRequestContext.add(th);
                    this.DatabaseTableConfigUtil.cancel();
                    return;
                }
            }
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.get() == null) {
                this.getAuthRequestContext.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            try {
                byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[2];
                Object[] objArr = new Object[1];
                a(b, b, (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                Object[] objArr2 = new Object[1];
                a(b2, b2, NetworkUserEntityData$$ExternalSyntheticLambda0[2], objArr2);
                this.getErrorConfigVersion = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                this.getAuthRequestContext.add(th);
                if (th == null) {
                    this.getAuthRequestContext.add(new IllegalStateException("onError received a null Throwable"));
                }
                this.GetContactSyncConfig.onError(th);
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        } finally {
            this.MyBillsEntityDataFactory.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.get() == null) {
                this.getAuthRequestContext.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            try {
                byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[2];
                Object[] objArr = new Object[1];
                a(b, b, (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                Object[] objArr2 = new Object[1];
                a(b2, b2, NetworkUserEntityData$$ExternalSyntheticLambda0[2], objArr2);
                this.getErrorConfigVersion = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                this.PlaceComponentResult++;
                this.GetContactSyncConfig.onComplete();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } finally {
            this.MyBillsEntityDataFactory.countDown();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.initRecordTimeStamp, j);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        SubscriptionHelper.cancel(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }
}
