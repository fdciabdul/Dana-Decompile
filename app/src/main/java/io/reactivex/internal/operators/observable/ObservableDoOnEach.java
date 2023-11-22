package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {
    final Consumer<? super T> BuiltInFictitiousFunctionClassFactory;
    final Action KClassImpl$Data$declaredNonStaticMembers$2;
    final Action MyBillsEntityDataFactory;
    final Consumer<? super Throwable> PlaceComponentResult;

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = consumer;
        this.PlaceComponentResult = consumer2;
        this.MyBillsEntityDataFactory = action;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = action2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new DoOnEachObserver(observer, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes6.dex */
    static final class DoOnEachObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Action MyBillsEntityDataFactory;
        final Consumer<? super Throwable> PlaceComponentResult;
        final Action getAuthRequestContext;
        final Consumer<? super T> lookAheadTest;
        Disposable moveToNextValue;

        DoOnEachObserver(Observer<? super T> observer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.lookAheadTest = consumer;
            this.PlaceComponentResult = consumer2;
            this.MyBillsEntityDataFactory = action;
            this.getAuthRequestContext = action2;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.moveToNextValue, disposable)) {
                this.moveToNextValue = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.moveToNextValue.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.moveToNextValue.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            try {
                this.lookAheadTest.accept(t);
                this.BuiltInFictitiousFunctionClassFactory.onNext(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.moveToNextValue.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            try {
                this.PlaceComponentResult.accept(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
            try {
                this.getAuthRequestContext.run();
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                RxJavaPlugins.PlaceComponentResult(th3);
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            try {
                this.MyBillsEntityDataFactory.run();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.BuiltInFictitiousFunctionClassFactory.onComplete();
                try {
                    this.getAuthRequestContext.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                onError(th2);
            }
        }
    }
}
