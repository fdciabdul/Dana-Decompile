package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableEmpty;
import io.reactivex.internal.operators.flowable.FlowableError;
import io.reactivex.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class Flowable<T> implements Publisher<T> {
    public static final int PlaceComponentResult = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber);

    public static int BuiltInFictitiousFunctionClassFactory() {
        return PlaceComponentResult;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> getAuthRequestContext() {
        return RxJavaPlugins.getAuthRequestContext(FlowableEmpty.MyBillsEntityDataFactory);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> MyBillsEntityDataFactory(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "throwable is null");
        Callable MyBillsEntityDataFactory = Functions.MyBillsEntityDataFactory(th);
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "supplier is null");
        return RxJavaPlugins.getAuthRequestContext(new FlowableError(MyBillsEntityDataFactory));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> getAuthRequestContext(Future<? extends T> future) {
        ObjectHelper.PlaceComponentResult(future, "future is null");
        return RxJavaPlugins.getAuthRequestContext(new FlowableFromFuture(future));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> BuiltInFictitiousFunctionClassFactory(Iterable<? extends T> iterable) {
        ObjectHelper.PlaceComponentResult(iterable, "source is null");
        return RxJavaPlugins.getAuthRequestContext(new FlowableFromIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> PlaceComponentResult(Publisher<? extends T> publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.getAuthRequestContext((Flowable) publisher);
        }
        ObjectHelper.PlaceComponentResult(publisher, "source is null");
        return RxJavaPlugins.getAuthRequestContext(new FlowableFromPublisher(publisher));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        ObjectHelper.PlaceComponentResult(t, "item is null");
        return RxJavaPlugins.getAuthRequestContext((Flowable) new FlowableJust(t));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> getAuthRequestContext(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        return RxJavaPlugins.getAuthRequestContext(new FlowableTimer(Math.max(0L, j), timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> BuiltInFictitiousFunctionClassFactory(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.PlaceComponentResult(function, "zipper is null");
        ObjectHelper.PlaceComponentResult(iterable, "sources is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.getAuthRequestContext(new FlowableZip(iterable, function, i));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Disposable BuiltInFictitiousFunctionClassFactory(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        ObjectHelper.PlaceComponentResult(consumer, "onNext is null");
        ObjectHelper.PlaceComponentResult(consumer2, "onError is null");
        ObjectHelper.PlaceComponentResult(action, "onComplete is null");
        ObjectHelper.PlaceComponentResult(consumer3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, consumer3);
        getAuthRequestContext(lambdaSubscriber);
        return lambdaSubscriber;
    }

    @Override // org.reactivestreams.Publisher
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public final void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            getAuthRequestContext((FlowableSubscriber) subscriber);
            return;
        }
        ObjectHelper.PlaceComponentResult(subscriber, "s is null");
        getAuthRequestContext(new StrictSubscriber(subscriber));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public final void getAuthRequestContext(FlowableSubscriber<? super T> flowableSubscriber) {
        ObjectHelper.PlaceComponentResult(flowableSubscriber, "s is null");
        try {
            Subscriber<? super T> KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(this, flowableSubscriber);
            ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            KClassImpl$Data$declaredNonStaticMembers$2((Subscriber) KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            RxJavaPlugins.PlaceComponentResult(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
