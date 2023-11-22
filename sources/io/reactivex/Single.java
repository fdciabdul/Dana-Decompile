package io.reactivex;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class Single<T> implements SingleSource<T> {
    protected abstract void PlaceComponentResult(SingleObserver<? super T> singleObserver);

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> MyBillsEntityDataFactory(SingleOnSubscribe<T> singleOnSubscribe) {
        ObjectHelper.PlaceComponentResult(singleOnSubscribe, "source is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleCreate(singleOnSubscribe));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> getAuthRequestContext(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "exception is null");
        Callable MyBillsEntityDataFactory = Functions.MyBillsEntityDataFactory(th);
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "errorSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleError(MyBillsEntityDataFactory));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> PlaceComponentResult(Callable<? extends T> callable) {
        ObjectHelper.PlaceComponentResult(callable, "callable is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFromCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> PlaceComponentResult(Future<? extends T> future) {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new FlowableSingleSingle(Flowable.getAuthRequestContext(future)));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> MyBillsEntityDataFactory(T t) {
        ObjectHelper.PlaceComponentResult(t, "item is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleJust(t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T r_() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        MyBillsEntityDataFactory((SingleObserver) blockingMultiObserver);
        return (T) blockingMultiObserver.PlaceComponentResult();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable MyBillsEntityDataFactory(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.PlaceComponentResult(consumer, "onSuccess is null");
        ObjectHelper.PlaceComponentResult(consumer2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
        MyBillsEntityDataFactory((SingleObserver) consumerSingleObserver);
        return consumerSingleObserver;
    }

    @Override // io.reactivex.SingleSource
    @SchedulerSupport("none")
    public final void MyBillsEntityDataFactory(SingleObserver<? super T> singleObserver) {
        ObjectHelper.PlaceComponentResult(singleObserver, "observer is null");
        SingleObserver<? super T> PlaceComponentResult = RxJavaPlugins.PlaceComponentResult(this, singleObserver);
        ObjectHelper.PlaceComponentResult(PlaceComponentResult, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            PlaceComponentResult(PlaceComponentResult);
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
