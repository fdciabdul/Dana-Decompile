package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class SafeObserver<T> implements Observer<T>, Disposable {
    Disposable BuiltInFictitiousFunctionClassFactory;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final Observer<? super T> PlaceComponentResult;

    public SafeObserver(Observer<? super T> observer) {
        this.PlaceComponentResult = observer;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
            this.BuiltInFictitiousFunctionClassFactory = disposable;
            try {
                this.PlaceComponentResult.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                try {
                    disposable.dispose();
                    RxJavaPlugins.PlaceComponentResult(th);
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    RxJavaPlugins.PlaceComponentResult(new CompositeException(th, th2));
                }
            }
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
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.PlaceComponentResult.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.PlaceComponentResult.onError(nullPointerException);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(new CompositeException(nullPointerException, th));
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(nullPointerException, th2));
            }
        } else if (t == null) {
            NullPointerException nullPointerException2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.BuiltInFictitiousFunctionClassFactory.dispose();
                onError(nullPointerException2);
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                onError(new CompositeException(nullPointerException2, th3));
            }
        } else {
            try {
                this.PlaceComponentResult.onNext(t);
            } catch (Throwable th4) {
                Exceptions.MyBillsEntityDataFactory(th4);
                try {
                    this.BuiltInFictitiousFunctionClassFactory.dispose();
                    onError(th4);
                } catch (Throwable th5) {
                    Exceptions.MyBillsEntityDataFactory(th5);
                    onError(new CompositeException(th4, th5));
                }
            }
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.PlaceComponentResult.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.PlaceComponentResult.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    RxJavaPlugins.PlaceComponentResult(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.PlaceComponentResult.onError(th);
        } catch (Throwable th4) {
            Exceptions.MyBillsEntityDataFactory(th4);
            RxJavaPlugins.PlaceComponentResult(new CompositeException(th, th4));
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            try {
                this.PlaceComponentResult.onComplete();
                return;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.PlaceComponentResult.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.PlaceComponentResult.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            Exceptions.MyBillsEntityDataFactory(th3);
            RxJavaPlugins.PlaceComponentResult(new CompositeException(nullPointerException, th3));
        }
    }
}
