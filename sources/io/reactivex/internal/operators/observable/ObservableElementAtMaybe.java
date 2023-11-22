package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {
    final long BuiltInFictitiousFunctionClassFactory;
    final ObservableSource<T> MyBillsEntityDataFactory;

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j) {
        this.MyBillsEntityDataFactory = observableSource;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.MyBillsEntityDataFactory.subscribe(new ElementAtObserver(maybeObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<T> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableElementAt(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, null, false));
    }

    /* loaded from: classes9.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final long KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        long PlaceComponentResult;
        final MaybeObserver<? super T> getAuthRequestContext;

        ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j) {
            this.getAuthRequestContext = maybeObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            long j = this.PlaceComponentResult;
            if (j == this.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.MyBillsEntityDataFactory = true;
                this.BuiltInFictitiousFunctionClassFactory.dispose();
                this.getAuthRequestContext.onSuccess(t);
                return;
            }
            this.PlaceComponentResult = j + 1;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.getAuthRequestContext.onComplete();
        }
    }
}
