package io.reactivex;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class Completable implements CompletableSource {
    protected abstract void MyBillsEntityDataFactory(CompletableObserver completableObserver);

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable MyBillsEntityDataFactory() {
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(CompletableEmpty.BuiltInFictitiousFunctionClassFactory);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable BuiltInFictitiousFunctionClassFactory(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.PlaceComponentResult(completableOnSubscribe, "source is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableCreate(completableOnSubscribe));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable PlaceComponentResult(Action action) {
        ObjectHelper.PlaceComponentResult(action, "run is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableFromAction(action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable KClassImpl$Data$declaredNonStaticMembers$2(Callable<?> callable) {
        ObjectHelper.PlaceComponentResult(callable, "callable is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableFromCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable MyBillsEntityDataFactory(Future<?> future) {
        ObjectHelper.PlaceComponentResult(future, "future is null");
        Action KClassImpl$Data$declaredNonStaticMembers$2 = Functions.KClassImpl$Data$declaredNonStaticMembers$2(future);
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "run is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableFromAction(KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable PlaceComponentResult(Runnable runnable) {
        ObjectHelper.PlaceComponentResult(runnable, "run is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableFromRunnable(runnable));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Completable BuiltInFictitiousFunctionClassFactory(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableTimer(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Completable KClassImpl$Data$declaredNonStaticMembers$2(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableTimer(5L, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable KClassImpl$Data$declaredNonStaticMembers$2(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        ObjectHelper.PlaceComponentResult(consumer, "onSubscribe is null");
        ObjectHelper.PlaceComponentResult(consumer2, "onError is null");
        ObjectHelper.PlaceComponentResult(action, "onComplete is null");
        ObjectHelper.PlaceComponentResult(action2, "onTerminate is null");
        ObjectHelper.PlaceComponentResult(action3, "onAfterTerminate is null");
        ObjectHelper.PlaceComponentResult(action4, "onDispose is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    @SchedulerSupport("none")
    public final Disposable q_() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        getAuthRequestContext(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    @Override // io.reactivex.CompletableSource
    @SchedulerSupport("none")
    public final void getAuthRequestContext(CompletableObserver completableObserver) {
        ObjectHelper.PlaceComponentResult(completableObserver, "observer is null");
        try {
            CompletableObserver PlaceComponentResult = RxJavaPlugins.PlaceComponentResult(this, completableObserver);
            ObjectHelper.PlaceComponentResult(PlaceComponentResult, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            MyBillsEntityDataFactory(PlaceComponentResult);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            RxJavaPlugins.PlaceComponentResult(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable getAuthRequestContext(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.PlaceComponentResult(consumer, "onError is null");
        ObjectHelper.PlaceComponentResult(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        getAuthRequestContext(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable KClassImpl$Data$declaredNonStaticMembers$2(Action action) {
        ObjectHelper.PlaceComponentResult(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        getAuthRequestContext(callbackCompletableObserver);
        return callbackCompletableObserver;
    }
}
