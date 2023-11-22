package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    public volatile boolean GetContactSyncConfig;
    protected volatile boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected Throwable NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final SimplePlainQueue<U> PrepareContext;
    protected final Subscriber<? super V> newProxyInstance;

    public boolean PlaceComponentResult(Subscriber<? super V> subscriber, U u) {
        return false;
    }

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.newProxyInstance = subscriber;
        this.PrepareContext = simplePlainQueue;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.GetContactSyncConfig;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final boolean lookAheadTest() {
        return this.isLayoutRequested.getAndIncrement() == 0;
    }

    public final boolean moveToNextValue() {
        return this.isLayoutRequested.get() == 0 && this.isLayoutRequested.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void PlaceComponentResult(U u, Disposable disposable) {
        Subscriber<? super V> subscriber = this.newProxyInstance;
        SimplePlainQueue<U> simplePlainQueue = this.PrepareContext;
        if (moveToNextValue()) {
            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
            if (j != 0) {
                if (PlaceComponentResult(subscriber, (Subscriber<? super V>) u) && j != LongCompanionObject.MAX_VALUE) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                }
                if (this.isLayoutRequested.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!lookAheadTest()) {
                return;
            }
        }
        QueueDrainHelper.KClassImpl$Data$declaredNonStaticMembers$2((SimplePlainQueue) simplePlainQueue, (Subscriber) subscriber, false, disposable, (QueueDrain) this);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(U u, Disposable disposable) {
        Subscriber<? super V> subscriber = this.newProxyInstance;
        SimplePlainQueue<U> simplePlainQueue = this.PrepareContext;
        if (moveToNextValue()) {
            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
            if (j != 0) {
                if (simplePlainQueue.isEmpty()) {
                    if (PlaceComponentResult(subscriber, (Subscriber<? super V>) u) && j != LongCompanionObject.MAX_VALUE) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                    }
                    if (this.isLayoutRequested.addAndGet(-1) == 0) {
                        return;
                    }
                } else {
                    simplePlainQueue.offer(u);
                }
            } else {
                this.GetContactSyncConfig = true;
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!lookAheadTest()) {
                return;
            }
        }
        QueueDrainHelper.KClassImpl$Data$declaredNonStaticMembers$2((SimplePlainQueue) simplePlainQueue, (Subscriber) subscriber, false, disposable, (QueueDrain) this);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final Throwable scheduleImpl() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final int BuiltInFictitiousFunctionClassFactory(int i) {
        return this.isLayoutRequested.addAndGet(i);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long getErrorConfigVersion() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
    }
}
