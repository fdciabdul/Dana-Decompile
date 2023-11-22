package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {
    final long BuiltInFictitiousFunctionClassFactory;
    final ObservableSource<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final T PlaceComponentResult;

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j, T t) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = observableSource;
        this.BuiltInFictitiousFunctionClassFactory = j;
        this.PlaceComponentResult = t;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(new ElementAtObserver(singleObserver, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<T> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableElementAt(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, true));
    }

    /* loaded from: classes6.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final T BuiltInFictitiousFunctionClassFactory;
        final SingleObserver<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        long MyBillsEntityDataFactory;
        final long PlaceComponentResult;
        boolean getAuthRequestContext;
        Disposable moveToNextValue;

        ElementAtObserver(SingleObserver<? super T> singleObserver, long j, T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = singleObserver;
            this.PlaceComponentResult = j;
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.moveToNextValue, disposable)) {
                this.moveToNextValue = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
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
            if (this.getAuthRequestContext) {
                return;
            }
            long j = this.MyBillsEntityDataFactory;
            if (j == this.PlaceComponentResult) {
                this.getAuthRequestContext = true;
                this.moveToNextValue.dispose();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(t);
                return;
            }
            this.MyBillsEntityDataFactory = j + 1;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            T t = this.BuiltInFictitiousFunctionClassFactory;
            if (t != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(t);
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(new NoSuchElementException());
            }
        }
    }
}
