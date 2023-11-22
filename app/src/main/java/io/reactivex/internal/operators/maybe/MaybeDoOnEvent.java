package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes9.dex */
public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {
    final BiConsumer<? super T, ? super Throwable> BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new DoOnEventMaybeObserver(maybeObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final BiConsumer<? super T, ? super Throwable> KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;
        final MaybeObserver<? super T> getAuthRequestContext;

        DoOnEventMaybeObserver(MaybeObserver<? super T> maybeObserver, BiConsumer<? super T, ? super Throwable> biConsumer) {
            this.getAuthRequestContext = maybeObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biConsumer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.dispose();
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(t, null);
                this.getAuthRequestContext.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(null, th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.MyBillsEntityDataFactory = DisposableHelper.DISPOSED;
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(null, null);
                this.getAuthRequestContext.onComplete();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.onError(th);
            }
        }
    }
}
