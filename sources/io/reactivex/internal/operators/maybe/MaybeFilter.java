package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class MaybeFilter<T> extends AbstractMaybeWithUpstream<T, T> {
    final Predicate<? super T> getAuthRequestContext;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new FilterMaybeObserver(maybeObserver, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class FilterMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final Predicate<? super T> PlaceComponentResult;
        final MaybeObserver<? super T> getAuthRequestContext;

        FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.getAuthRequestContext = maybeObserver;
            this.PlaceComponentResult = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Disposable disposable = this.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            try {
                if (this.PlaceComponentResult.test(t)) {
                    this.getAuthRequestContext.onSuccess(t);
                } else {
                    this.getAuthRequestContext.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.getAuthRequestContext.onComplete();
        }
    }
}
