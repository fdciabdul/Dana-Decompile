package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final int BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final Callable<U> PlaceComponentResult;

    public ObservableBuffer(ObservableSource<T> observableSource, int i, int i2, Callable<U> callable) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.PlaceComponentResult = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == i2) {
            BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i2, this.PlaceComponentResult);
            if (bufferExactObserver.BuiltInFictitiousFunctionClassFactory()) {
                this.getAuthRequestContext.subscribe(bufferExactObserver);
                return;
            }
            return;
        }
        this.getAuthRequestContext.subscribe(new BufferSkipObserver(observer, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        int BuiltInFictitiousFunctionClassFactory;
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        U MyBillsEntityDataFactory;
        final Observer<? super U> PlaceComponentResult;
        final Callable<U> getAuthRequestContext;
        Disposable getErrorConfigVersion;

        BufferExactObserver(Observer<? super U> observer, int i, Callable<U> callable) {
            this.PlaceComponentResult = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.getAuthRequestContext = callable;
        }

        final boolean BuiltInFictitiousFunctionClassFactory() {
            try {
                this.MyBillsEntityDataFactory = (U) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory = null;
                Disposable disposable = this.getErrorConfigVersion;
                if (disposable == null) {
                    EmptyDisposable.error(th, this.PlaceComponentResult);
                    return false;
                }
                disposable.dispose();
                this.PlaceComponentResult.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getErrorConfigVersion, disposable)) {
                this.getErrorConfigVersion = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getErrorConfigVersion.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getErrorConfigVersion.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            U u = this.MyBillsEntityDataFactory;
            if (u != null) {
                u.add(t);
                int i = this.BuiltInFictitiousFunctionClassFactory + 1;
                this.BuiltInFictitiousFunctionClassFactory = i;
                if (i >= this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    this.PlaceComponentResult.onNext(u);
                    this.BuiltInFictitiousFunctionClassFactory = 0;
                    BuiltInFictitiousFunctionClassFactory();
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = null;
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            U u = this.MyBillsEntityDataFactory;
            if (u != null) {
                this.MyBillsEntityDataFactory = null;
                if (!u.isEmpty()) {
                    this.PlaceComponentResult.onNext(u);
                }
                this.PlaceComponentResult.onComplete();
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        final Observer<? super U> downstream;
        long index;
        final int skip;
        Disposable upstream;

        BufferSkipObserver(Observer<? super U> observer, int i, int i2, Callable<U> callable) {
            this.downstream = observer;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) ObjectHelper.PlaceComponentResult(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.downstream.onNext(next);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }
    }
}
