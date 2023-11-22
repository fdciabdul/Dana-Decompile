package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes6.dex */
public final class QueueDrainHelper {
    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> void KClassImpl$Data$declaredNonStaticMembers$2(SimplePlainQueue<T> simplePlainQueue, Subscriber<? super U> subscriber, boolean z, Disposable disposable, QueueDrain<T, U> queueDrain) {
        int i = 1;
        while (true) {
            boolean PlaceComponentResult = queueDrain.PlaceComponentResult();
            T poll = simplePlainQueue.poll();
            boolean z2 = poll == null;
            if (MyBillsEntityDataFactory(PlaceComponentResult, z2, subscriber, false, simplePlainQueue, queueDrain)) {
                if (disposable != null) {
                    disposable.dispose();
                    return;
                }
                return;
            } else if (!z2) {
                long errorConfigVersion = queueDrain.getErrorConfigVersion();
                if (errorConfigVersion != 0) {
                    if (queueDrain.PlaceComponentResult(subscriber, poll) && errorConfigVersion != LongCompanionObject.MAX_VALUE) {
                        queueDrain.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    }
                } else {
                    simplePlainQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
            } else {
                i = queueDrain.BuiltInFictitiousFunctionClassFactory(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    private static <T, U> boolean MyBillsEntityDataFactory(boolean z, boolean z2, Subscriber<?> subscriber, boolean z3, SimpleQueue<?> simpleQueue, QueueDrain<T, U> queueDrain) {
        if (queueDrain.BuiltInFictitiousFunctionClassFactory()) {
            simpleQueue.clear();
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable scheduleImpl = queueDrain.scheduleImpl();
                    if (scheduleImpl != null) {
                        subscriber.onError(scheduleImpl);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable scheduleImpl2 = queueDrain.scheduleImpl();
            if (scheduleImpl2 != null) {
                simpleQueue.clear();
                subscriber.onError(scheduleImpl2);
                return true;
            } else if (z2) {
                subscriber.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        r0 = r14.getAuthRequestContext(-r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r0 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T, U> void getAuthRequestContext(io.reactivex.internal.fuseable.SimplePlainQueue<T> r10, io.reactivex.Observer<? super U> r11, boolean r12, io.reactivex.disposables.Disposable r13, io.reactivex.internal.util.ObservableQueueDrain<T, U> r14) {
        /*
            r12 = 1
            r0 = 1
        L2:
            boolean r1 = r14.getAuthRequestContext()
            boolean r2 = r10.isEmpty()
            r4 = 0
            r3 = r11
            r5 = r10
            r6 = r13
            r7 = r14
            boolean r1 = PlaceComponentResult(r1, r2, r3, r4, r5, r6, r7)
            if (r1 == 0) goto L16
            return
        L16:
            boolean r2 = r14.getAuthRequestContext()
            java.lang.Object r1 = r10.poll()
            if (r1 != 0) goto L22
            r9 = 1
            goto L24
        L22:
            r3 = 0
            r9 = 0
        L24:
            r5 = 0
            r3 = r9
            r4 = r11
            r6 = r10
            r7 = r13
            r8 = r14
            boolean r2 = PlaceComponentResult(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L31
            return
        L31:
            if (r9 == 0) goto L3b
            int r0 = -r0
            int r0 = r14.getAuthRequestContext(r0)
            if (r0 != 0) goto L2
            return
        L3b:
            r14.MyBillsEntityDataFactory(r11, r1)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.QueueDrainHelper.getAuthRequestContext(io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.Observer, boolean, io.reactivex.disposables.Disposable, io.reactivex.internal.util.ObservableQueueDrain):void");
    }

    private static <T, U> boolean PlaceComponentResult(boolean z, boolean z2, Observer<?> observer, boolean z3, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.KClassImpl$Data$declaredNonStaticMembers$2()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    Throwable PlaceComponentResult = observableQueueDrain.PlaceComponentResult();
                    if (PlaceComponentResult != null) {
                        observer.onError(PlaceComponentResult);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable PlaceComponentResult2 = observableQueueDrain.PlaceComponentResult();
            if (PlaceComponentResult2 != null) {
                simpleQueue.clear();
                if (disposable != null) {
                    disposable.dispose();
                }
                observer.onError(PlaceComponentResult2);
                return true;
            } else if (z2) {
                if (disposable != null) {
                    disposable.dispose();
                }
                observer.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static <T> SimpleQueue<T> MyBillsEntityDataFactory(int i) {
        if (i < 0) {
            return new SpscLinkedArrayQueue(-i);
        }
        return new SpscArrayQueue(i);
    }

    public static void MyBillsEntityDataFactory(Subscription subscription, int i) {
        subscription.request(i < 0 ? LongCompanionObject.MAX_VALUE : i);
    }

    public static <T> boolean KClassImpl$Data$declaredNonStaticMembers$2(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, BackpressureHelper.KClassImpl$Data$declaredNonStaticMembers$2(LongCompanionObject.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 == Long.MIN_VALUE) {
            MyBillsEntityDataFactory(j | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
            return true;
        }
        return false;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            return true;
        }
    }

    private static <T> boolean MyBillsEntityDataFactory(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (BuiltInFictitiousFunctionClassFactory(booleanSupplier)) {
                    return true;
                }
                Object obj = (T) queue.poll();
                if (obj == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(obj);
                j2++;
            } else if (BuiltInFictitiousFunctionClassFactory(booleanSupplier)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long addAndGet = atomicLong.addAndGet(-(j2 & LongCompanionObject.MAX_VALUE));
                    if ((LongCompanionObject.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j = addAndGet;
                    j2 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> void MyBillsEntityDataFactory(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            subscriber.onComplete();
            return;
        }
        if (MyBillsEntityDataFactory(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            return;
        }
        do {
            j = atomicLong.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            }
            j2 = j | Long.MIN_VALUE;
        } while (!atomicLong.compareAndSet(j, j2));
        if (j != 0) {
            MyBillsEntityDataFactory(j2, subscriber, queue, atomicLong, booleanSupplier);
        }
    }
}
