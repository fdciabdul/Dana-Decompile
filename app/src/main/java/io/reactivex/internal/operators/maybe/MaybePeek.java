package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes9.dex */
public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
    final Action BuiltInFictitiousFunctionClassFactory;
    final Action MyBillsEntityDataFactory;
    final Consumer<? super Throwable> PlaceComponentResult;
    final Action getAuthRequestContext;
    final Consumer<? super Disposable> getErrorConfigVersion;
    final Consumer<? super T> scheduleImpl;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new MaybePeekObserver(maybeObserver, this));
    }

    /* loaded from: classes9.dex */
    static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;
        final MaybeObserver<? super T> MyBillsEntityDataFactory;
        final MaybePeek<T> getAuthRequestContext;

        MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
            this.MyBillsEntityDataFactory = maybeObserver;
            this.getAuthRequestContext = maybePeek;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            try {
                this.getAuthRequestContext.MyBillsEntityDataFactory.run();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
            }
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
                try {
                    this.getAuthRequestContext.getErrorConfigVersion.accept(disposable);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                    this.MyBillsEntityDataFactory.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    disposable.dispose();
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.MyBillsEntityDataFactory);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.getAuthRequestContext.scheduleImpl.accept(t);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
                this.MyBillsEntityDataFactory.onSuccess(t);
                try {
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                getAuthRequestContext(th2);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == DisposableHelper.DISPOSED) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                getAuthRequestContext(th);
            }
        }

        private void getAuthRequestContext(Throwable th) {
            try {
                this.getAuthRequestContext.PlaceComponentResult.accept(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
            this.MyBillsEntityDataFactory.onError(th);
            try {
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.run();
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                RxJavaPlugins.PlaceComponentResult(th3);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.getAuthRequestContext.getAuthRequestContext.run();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = DisposableHelper.DISPOSED;
                this.MyBillsEntityDataFactory.onComplete();
                try {
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                getAuthRequestContext(th2);
            }
        }
    }
}
