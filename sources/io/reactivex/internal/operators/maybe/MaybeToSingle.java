package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.NoSuchElementException;

/* loaded from: classes9.dex */
public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {
    final T MyBillsEntityDataFactory;
    final MaybeSource<T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.PlaceComponentResult.PlaceComponentResult(new ToSingleMaybeSubscriber(singleObserver, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;
        final T MyBillsEntityDataFactory;
        final SingleObserver<? super T> PlaceComponentResult;

        ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.PlaceComponentResult = singleObserver;
            this.MyBillsEntityDataFactory = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            this.PlaceComponentResult.onSuccess(t);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            T t = this.MyBillsEntityDataFactory;
            if (t != null) {
                this.PlaceComponentResult.onSuccess(t);
            } else {
                this.PlaceComponentResult.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }
    }
}
