package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes6.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected int BuiltInFictitiousFunctionClassFactory;
    protected Disposable KClassImpl$Data$declaredNonStaticMembers$2;
    protected final Observer<? super R> MyBillsEntityDataFactory;
    protected boolean PlaceComponentResult;
    protected QueueDisposable<T> getAuthRequestContext;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.MyBillsEntityDataFactory = observer;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
            if (disposable instanceof QueueDisposable) {
                this.getAuthRequestContext = (QueueDisposable) disposable;
            }
            this.MyBillsEntityDataFactory.onSubscribe(this);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.PlaceComponentResult) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(Throwable th) {
        Exceptions.MyBillsEntityDataFactory(th);
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.PlaceComponentResult) {
            return;
        }
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        QueueDisposable<T> queueDisposable = this.getAuthRequestContext;
        if (queueDisposable == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i);
        if (requestFusion != 0) {
            this.BuiltInFictitiousFunctionClassFactory = requestFusion;
        }
        return requestFusion;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.getAuthRequestContext.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.getAuthRequestContext.clear();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
