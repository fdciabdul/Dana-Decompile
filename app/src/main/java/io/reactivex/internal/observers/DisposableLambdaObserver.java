package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes6.dex */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
    final Consumer<? super Disposable> KClassImpl$Data$declaredNonStaticMembers$2;
    final Action MyBillsEntityDataFactory;
    Disposable PlaceComponentResult;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.BuiltInFictitiousFunctionClassFactory = observer;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = consumer;
        this.MyBillsEntityDataFactory = action;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.accept(disposable);
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            disposable.dispose();
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        this.BuiltInFictitiousFunctionClassFactory.onNext(t);
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (this.PlaceComponentResult != DisposableHelper.DISPOSED) {
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
            return;
        }
        RxJavaPlugins.PlaceComponentResult(th);
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.PlaceComponentResult != DisposableHelper.DISPOSED) {
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Disposable disposable = this.PlaceComponentResult;
        if (disposable != DisposableHelper.DISPOSED) {
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            try {
                this.MyBillsEntityDataFactory.run();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
            }
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.PlaceComponentResult.isDisposed();
    }
}
