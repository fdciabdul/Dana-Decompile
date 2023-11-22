package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes9.dex */
public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends R> MyBillsEntityDataFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super R> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new MapMaybeObserver(maybeObserver, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super R> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        final Function<? super T, ? extends R> getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends R> function) {
            this.MyBillsEntityDataFactory = maybeObserver;
            this.getAuthRequestContext = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Disposable disposable = this.PlaceComponentResult;
            this.PlaceComponentResult = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            try {
                this.MyBillsEntityDataFactory.onSuccess(ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}
