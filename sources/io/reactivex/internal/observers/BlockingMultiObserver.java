package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    T BuiltInFictitiousFunctionClassFactory;
    volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
    Disposable MyBillsEntityDataFactory;
    Throwable getAuthRequestContext;

    public BlockingMultiObserver() {
        super(1);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        this.MyBillsEntityDataFactory = disposable;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        this.BuiltInFictitiousFunctionClassFactory = t;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        this.getAuthRequestContext = th;
        countDown();
    }

    @Override // io.reactivex.CompletableObserver
    public final void onComplete() {
        countDown();
    }

    public final T PlaceComponentResult() {
        if (getCount() != 0) {
            try {
                BlockingHelper.getAuthRequestContext();
                await();
            } catch (InterruptedException e) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                Disposable disposable = this.MyBillsEntityDataFactory;
                if (disposable != null) {
                    disposable.dispose();
                }
                throw ExceptionHelper.MyBillsEntityDataFactory(e);
            }
        }
        Throwable th = this.getAuthRequestContext;
        if (th != null) {
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
