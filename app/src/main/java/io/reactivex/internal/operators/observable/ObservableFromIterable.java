package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class ObservableFromIterable<T> extends Observable<T> {
    final Iterable<? extends T> MyBillsEntityDataFactory;

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.MyBillsEntityDataFactory = iterable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it = this.MyBillsEntityDataFactory.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(observer);
                    return;
                }
                FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it);
                observer.onSubscribe(fromIterableDisposable);
                if (fromIterableDisposable.getAuthRequestContext) {
                    return;
                }
                while (!fromIterableDisposable.isDisposed()) {
                    try {
                        fromIterableDisposable.KClassImpl$Data$declaredNonStaticMembers$2.onNext(ObjectHelper.PlaceComponentResult(fromIterableDisposable.scheduleImpl.next(), "The iterator returned a null value"));
                        if (fromIterableDisposable.isDisposed()) {
                            return;
                        }
                        try {
                            if (!fromIterableDisposable.scheduleImpl.hasNext()) {
                                if (fromIterableDisposable.isDisposed()) {
                                    return;
                                }
                                fromIterableDisposable.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            fromIterableDisposable.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        fromIterableDisposable.KClassImpl$Data$declaredNonStaticMembers$2.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                EmptyDisposable.error(th3, observer);
            }
        } catch (Throwable th4) {
            Exceptions.MyBillsEntityDataFactory(th4);
            EmptyDisposable.error(th4, observer);
        }
    }

    /* loaded from: classes6.dex */
    static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {
        boolean BuiltInFictitiousFunctionClassFactory;
        final Observer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        volatile boolean PlaceComponentResult;
        boolean getAuthRequestContext;
        final Iterator<? extends T> scheduleImpl;

        FromIterableDisposable(Observer<? super T> observer, Iterator<? extends T> it) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
            this.scheduleImpl = it;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.getAuthRequestContext = true;
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() {
            if (this.MyBillsEntityDataFactory) {
                return null;
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                if (!this.scheduleImpl.hasNext()) {
                    this.MyBillsEntityDataFactory = true;
                    return null;
                }
            } else {
                this.BuiltInFictitiousFunctionClassFactory = true;
            }
            return (T) ObjectHelper.PlaceComponentResult(this.scheduleImpl.next(), "The iterator returned a null value");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.MyBillsEntityDataFactory = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }
    }
}
