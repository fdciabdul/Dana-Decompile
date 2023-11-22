package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    T BuiltInFictitiousFunctionClassFactory;
    Disposable KClassImpl$Data$declaredNonStaticMembers$2;
    volatile boolean PlaceComponentResult;
    Throwable getAuthRequestContext;

    public BlockingBaseObserver() {
        super(1);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
        if (this.PlaceComponentResult) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.PlaceComponentResult = true;
        Disposable disposable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.PlaceComponentResult;
    }

    public final T MyBillsEntityDataFactory() {
        if (getCount() != 0) {
            try {
                BlockingHelper.getAuthRequestContext();
                await();
            } catch (InterruptedException e) {
                dispose();
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
