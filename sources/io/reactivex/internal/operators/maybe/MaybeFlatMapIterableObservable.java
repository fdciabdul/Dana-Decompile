package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

/* loaded from: classes9.dex */
public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {
    final MaybeSource<T> MyBillsEntityDataFactory;
    final Function<? super T, ? extends Iterable<? extends R>> getAuthRequestContext;

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(new FlatMapIterableObserver(observer, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {
        final Function<? super T, ? extends Iterable<? extends R>> BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super R> MyBillsEntityDataFactory;
        volatile Iterator<? extends R> PlaceComponentResult;
        volatile boolean getAuthRequestContext;
        Disposable getErrorConfigVersion;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.MyBillsEntityDataFactory = observer;
            this.BuiltInFictitiousFunctionClassFactory = function;
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getErrorConfigVersion, disposable)) {
                this.getErrorConfigVersion = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            Observer<? super R> observer = this.MyBillsEntityDataFactory;
            try {
                Iterator<? extends R> it = this.BuiltInFictitiousFunctionClassFactory.apply(t).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                this.PlaceComponentResult = it;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    observer.onNext(null);
                    observer.onComplete();
                    return;
                }
                while (!this.getAuthRequestContext) {
                    try {
                        observer.onNext((R) it.next());
                        if (this.getAuthRequestContext) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                observer.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            observer.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        observer.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                observer.onError(th3);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.getErrorConfigVersion = DisposableHelper.DISPOSED;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext = true;
            this.getErrorConfigVersion.dispose();
            this.getErrorConfigVersion = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.PlaceComponentResult = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.PlaceComponentResult == null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final R poll() throws Exception {
            Iterator<? extends R> it = this.PlaceComponentResult;
            if (it != null) {
                R r = (R) ObjectHelper.PlaceComponentResult(it.next(), "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.PlaceComponentResult = null;
                }
                return r;
            }
            return null;
        }
    }
}
