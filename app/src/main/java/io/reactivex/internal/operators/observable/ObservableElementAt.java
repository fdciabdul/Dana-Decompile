package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final T BuiltInFictitiousFunctionClassFactory;
    final long KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean MyBillsEntityDataFactory;

    public ObservableElementAt(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.BuiltInFictitiousFunctionClassFactory = t;
        this.MyBillsEntityDataFactory = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new ElementAtObserver(observer, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes6.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        long KClassImpl$Data$declaredNonStaticMembers$2;
        final boolean MyBillsEntityDataFactory;
        final long NetworkUserEntityData$$ExternalSyntheticLambda0;
        final T PlaceComponentResult;
        boolean getAuthRequestContext;
        Disposable scheduleImpl;

        ElementAtObserver(Observer<? super T> observer, long j, T t, boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = j;
            this.PlaceComponentResult = t;
            this.MyBillsEntityDataFactory = z;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.scheduleImpl, disposable)) {
                this.scheduleImpl = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.scheduleImpl.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.scheduleImpl.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.getAuthRequestContext) {
                return;
            }
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (j == this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                this.getAuthRequestContext = true;
                this.scheduleImpl.dispose();
                this.BuiltInFictitiousFunctionClassFactory.onNext(t);
                this.BuiltInFictitiousFunctionClassFactory.onComplete();
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j + 1;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = true;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            T t = this.PlaceComponentResult;
            if (t == null && this.MyBillsEntityDataFactory) {
                this.BuiltInFictitiousFunctionClassFactory.onError(new NoSuchElementException());
                return;
            }
            if (t != null) {
                this.BuiltInFictitiousFunctionClassFactory.onNext(t);
            }
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }
}
