package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class CompletablePeek extends Completable {
    final Action BuiltInFictitiousFunctionClassFactory;
    final Consumer<? super Disposable> KClassImpl$Data$declaredNonStaticMembers$2;
    final Consumer<? super Throwable> MyBillsEntityDataFactory;
    final Action NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Action PlaceComponentResult;
    final Action getAuthRequestContext;
    final CompletableSource scheduleImpl;

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.scheduleImpl = completableSource;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = consumer;
        this.MyBillsEntityDataFactory = consumer2;
        this.BuiltInFictitiousFunctionClassFactory = action;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = action2;
        this.PlaceComponentResult = action3;
        this.getAuthRequestContext = action4;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.scheduleImpl.getAuthRequestContext(new CompletableObserverImplementation(completableObserver));
    }

    /* loaded from: classes6.dex */
    final class CompletableObserverImplementation implements CompletableObserver, Disposable {
        final CompletableObserver MyBillsEntityDataFactory;
        Disposable getAuthRequestContext;

        CompletableObserverImplementation(CompletableObserver completableObserver) {
            CompletablePeek.this = r1;
            this.MyBillsEntityDataFactory = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            try {
                CompletablePeek.this.KClassImpl$Data$declaredNonStaticMembers$2.accept(disposable);
                if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                    this.getAuthRequestContext = disposable;
                    this.MyBillsEntityDataFactory.onSubscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                disposable.dispose();
                this.getAuthRequestContext = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th, this.MyBillsEntityDataFactory);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext == DisposableHelper.DISPOSED) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            try {
                CompletablePeek.this.MyBillsEntityDataFactory.accept(th);
                CompletablePeek.this.NetworkUserEntityData$$ExternalSyntheticLambda0.run();
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.MyBillsEntityDataFactory.onError(th);
            try {
                CompletablePeek.this.PlaceComponentResult.run();
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                RxJavaPlugins.PlaceComponentResult(th3);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            if (this.getAuthRequestContext == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                CompletablePeek.this.BuiltInFictitiousFunctionClassFactory.run();
                CompletablePeek.this.NetworkUserEntityData$$ExternalSyntheticLambda0.run();
                this.MyBillsEntityDataFactory.onComplete();
                try {
                    CompletablePeek.this.PlaceComponentResult.run();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.MyBillsEntityDataFactory.onError(th2);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            try {
                CompletablePeek.this.getAuthRequestContext.run();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
            }
            this.getAuthRequestContext.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }
    }
}
