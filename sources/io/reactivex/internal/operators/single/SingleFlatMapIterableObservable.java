package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

/* loaded from: classes9.dex */
public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {
    final SingleSource<T> BuiltInFictitiousFunctionClassFactory;
    final Function<? super T, ? extends Iterable<? extends R>> MyBillsEntityDataFactory;

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new FlatMapIterableObserver(observer, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final Observer<? super R> downstream;
        volatile Iterator<? extends R> it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        Disposable upstream;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.downstream = observer;
            this.mapper = function;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            Observer<? super R> observer = this.downstream;
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                if (this.outputFused) {
                    this.it = it;
                    observer.onNext(null);
                    observer.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        observer.onNext((R) it.next());
                        if (this.cancelled) {
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
                this.downstream.onError(th3);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.it = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.it == null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it != null) {
                R r = (R) ObjectHelper.PlaceComponentResult(it.next(), "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.it = null;
                }
                return r;
            }
            return null;
        }
    }
}
