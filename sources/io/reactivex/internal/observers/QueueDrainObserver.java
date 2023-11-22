package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

/* loaded from: classes9.dex */
public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    protected Throwable BuiltInFictitiousFunctionClassFactory;
    protected final Observer<? super V> KClassImpl$Data$declaredNonStaticMembers$2;
    protected volatile boolean MyBillsEntityDataFactory;
    public volatile boolean PlaceComponentResult;
    public final SimplePlainQueue<U> getAuthRequestContext;

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void MyBillsEntityDataFactory(Observer<? super V> observer, U u) {
    }

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
        this.getAuthRequestContext = simplePlainQueue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.moveToNextValue.getAndIncrement() == 0;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.moveToNextValue.get() == 0 && this.moveToNextValue.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(U u, Disposable disposable) {
        Observer<? super V> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        SimplePlainQueue<U> simplePlainQueue = this.getAuthRequestContext;
        if (this.moveToNextValue.get() == 0 && this.moveToNextValue.compareAndSet(0, 1)) {
            MyBillsEntityDataFactory(observer, u);
            if (this.moveToNextValue.addAndGet(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!MyBillsEntityDataFactory()) {
                return;
            }
        }
        QueueDrainHelper.getAuthRequestContext(simplePlainQueue, observer, false, disposable, this);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(U u, Disposable disposable) {
        Observer<? super V> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        SimplePlainQueue<U> simplePlainQueue = this.getAuthRequestContext;
        if (this.moveToNextValue.get() == 0 && this.moveToNextValue.compareAndSet(0, 1)) {
            if (simplePlainQueue.isEmpty()) {
                MyBillsEntityDataFactory(observer, u);
                if (this.moveToNextValue.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
            }
        } else {
            simplePlainQueue.offer(u);
            if (!MyBillsEntityDataFactory()) {
                return;
            }
        }
        QueueDrainHelper.getAuthRequestContext(simplePlainQueue, observer, false, disposable, this);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final Throwable PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int getAuthRequestContext(int i) {
        return this.moveToNextValue.addAndGet(i);
    }
}
