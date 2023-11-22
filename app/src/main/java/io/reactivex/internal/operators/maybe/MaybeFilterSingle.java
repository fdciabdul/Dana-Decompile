package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class MaybeFilterSingle<T> extends Maybe<T> {
    final SingleSource<T> BuiltInFictitiousFunctionClassFactory;
    final Predicate<? super T> PlaceComponentResult;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new FilterMaybeObserver(maybeObserver, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {
        final Predicate<? super T> BuiltInFictitiousFunctionClassFactory;
        Disposable MyBillsEntityDataFactory;
        final MaybeObserver<? super T> PlaceComponentResult;

        FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.PlaceComponentResult = maybeObserver;
            this.BuiltInFictitiousFunctionClassFactory = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Disposable disposable = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                if (this.BuiltInFictitiousFunctionClassFactory.test(t)) {
                    this.PlaceComponentResult.onSuccess(t);
                } else {
                    this.PlaceComponentResult.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.PlaceComponentResult.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onError(th);
        }
    }
}
