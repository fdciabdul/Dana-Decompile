package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.SerializedSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Observable<Object>, ? extends ObservableSource<?>> KClassImpl$Data$declaredNonStaticMembers$2;

    public ObservableRepeatWhen(ObservableSource<T> observableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        SerializedSubject serializedSubject = new SerializedSubject(PublishSubject.PlaceComponentResult());
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(serializedSubject), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, serializedSubject, this.getAuthRequestContext);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, observer);
        }
    }

    /* loaded from: classes6.dex */
    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final Observer<? super T> downstream;
        final Subject<Object> signaller;
        final ObservableSource<T> source;
        final AtomicInteger wip = new AtomicInteger();
        final AtomicThrowable error = new AtomicThrowable();
        final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        RepeatWhenObserver(Observer<? super T> observer, Subject<Object> subject, ObservableSource<T> observableSource) {
            this.downstream = observer;
            this.signaller = subject;
            this.source = observableSource;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            HalfSerializer.BuiltInFictitiousFunctionClassFactory(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.inner);
            HalfSerializer.getAuthRequestContext(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(0);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        final void innerNext() {
            subscribeNext();
        }

        final void innerError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.getAuthRequestContext(this.downstream, th, this, this.error);
        }

        final void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.getAuthRequestContext(this.downstream, this, this.error);
        }

        final void subscribeNext() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.active) {
                    this.active = true;
                    this.source.subscribe(this);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* loaded from: classes6.dex */
        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            InnerRepeatObserver() {
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.Observer
            public final void onNext(Object obj) {
                RepeatWhenObserver.this.innerNext();
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                RepeatWhenObserver.this.innerError(th);
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                RepeatWhenObserver.this.innerComplete();
            }
        }
    }
}
