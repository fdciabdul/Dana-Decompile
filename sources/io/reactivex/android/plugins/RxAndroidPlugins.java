package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class RxAndroidPlugins {
    private static volatile Function<Callable<Scheduler>, Scheduler> MyBillsEntityDataFactory;
    private static volatile Function<Scheduler, Scheduler> getAuthRequestContext;

    public static Scheduler PlaceComponentResult(Callable<Scheduler> callable) {
        Function<Callable<Scheduler>, Scheduler> function = MyBillsEntityDataFactory;
        if (function == null) {
            return getAuthRequestContext(callable);
        }
        Scheduler scheduler = (Scheduler) PlaceComponentResult(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static Scheduler getAuthRequestContext(Scheduler scheduler) {
        if (scheduler == null) {
            throw new NullPointerException("scheduler == null");
        }
        Function<Scheduler, Scheduler> function = getAuthRequestContext;
        return function == null ? scheduler : (Scheduler) PlaceComponentResult(function, scheduler);
    }

    private static Scheduler getAuthRequestContext(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.getAuthRequestContext(th);
        }
    }

    private static <T, R> R PlaceComponentResult(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.getAuthRequestContext(th);
        }
    }

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }
}
