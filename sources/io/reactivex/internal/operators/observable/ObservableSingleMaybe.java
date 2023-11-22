package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableSingleMaybe<T> extends Maybe<T> {
    final ObservableSource<T> BuiltInFictitiousFunctionClassFactory;

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
    }

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new SingleElementObserver(maybeObserver));
    }

    /* loaded from: classes6.dex */
    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        boolean BuiltInFictitiousFunctionClassFactory;
        T KClassImpl$Data$declaredNonStaticMembers$2;
        final MaybeObserver<? super T> MyBillsEntityDataFactory;
        Disposable getAuthRequestContext;

        SingleElementObserver(MaybeObserver<? super T> maybeObserver) {
            this.MyBillsEntityDataFactory = maybeObserver;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.BuiltInFictitiousFunctionClassFactory = true;
                this.getAuthRequestContext.dispose();
                this.MyBillsEntityDataFactory.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            if (t == null) {
                this.MyBillsEntityDataFactory.onComplete();
            } else {
                this.MyBillsEntityDataFactory.onSuccess(t);
            }
        }
    }
}
