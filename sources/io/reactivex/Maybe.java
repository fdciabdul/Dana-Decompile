package io.reactivex;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public abstract class Maybe<T> implements MaybeSource<T> {
    protected abstract void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver);

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Maybe<T> PlaceComponentResult(Callable<? extends T> callable) {
        ObjectHelper.PlaceComponentResult(callable, "callable is null");
        return RxJavaPlugins.getAuthRequestContext((Maybe) new MaybeFromCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T PlaceComponentResult() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        PlaceComponentResult(blockingMultiObserver);
        return (T) blockingMultiObserver.PlaceComponentResult();
    }

    @Override // io.reactivex.MaybeSource
    @SchedulerSupport("none")
    public final void PlaceComponentResult(MaybeObserver<? super T> maybeObserver) {
        ObjectHelper.PlaceComponentResult(maybeObserver, "observer is null");
        MaybeObserver<? super T> authRequestContext = RxJavaPlugins.getAuthRequestContext(this, maybeObserver);
        ObjectHelper.PlaceComponentResult(authRequestContext, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            MyBillsEntityDataFactory(authRequestContext);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
