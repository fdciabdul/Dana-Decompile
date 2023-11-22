package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeEqualSingle<T> extends Single<Boolean> {
    final MaybeSource<? extends T> KClassImpl$Data$declaredNonStaticMembers$2;
    final BiPredicate<? super T, ? super T> PlaceComponentResult;
    final MaybeSource<? extends T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.PlaceComponentResult);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
    }

    /* loaded from: classes9.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        final SingleObserver<? super Boolean> downstream;
        final BiPredicate<? super T, ? super T> isEqual;
        final EqualObserver<T> observer1;
        final EqualObserver<T> observer2;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
            super(2);
            this.downstream = singleObserver;
            this.isEqual = biPredicate;
            this.observer1 = new EqualObserver<>(this);
            this.observer2 = new EqualObserver<>(this);
        }

        final void subscribe(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
            maybeSource.PlaceComponentResult(this.observer1);
            maybeSource2.PlaceComponentResult(this.observer2);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.observer1.dispose();
            this.observer2.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.observer1.get());
        }

        final void done() {
            if (decrementAndGet() == 0) {
                Object obj = this.observer1.value;
                Object obj2 = this.observer2.value;
                if (obj != null && obj2 != null) {
                    try {
                        this.downstream.onSuccess(Boolean.valueOf(this.isEqual.BuiltInFictitiousFunctionClassFactory(obj, obj2)));
                        return;
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        this.downstream.onError(th);
                        return;
                    }
                }
                this.downstream.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
            }
        }

        final void error(EqualObserver<T> equalObserver, Throwable th) {
            if (getAndSet(0) > 0) {
                EqualObserver<T> equalObserver2 = this.observer1;
                if (equalObserver == equalObserver2) {
                    this.observer2.dispose();
                } else {
                    equalObserver2.dispose();
                }
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        final EqualCoordinator<T> parent;
        Object value;

        EqualObserver(EqualCoordinator<T> equalCoordinator) {
            this.parent = equalCoordinator;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.value = t;
            this.parent.done();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.parent.done();
        }
    }
}
