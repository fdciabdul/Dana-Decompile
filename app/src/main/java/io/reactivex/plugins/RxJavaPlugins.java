package io.reactivex.plugins;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes.dex */
public final class RxJavaPlugins {
    static volatile boolean BuiltInFictitiousFunctionClassFactory;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> DatabaseTableConfigUtil;
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> FragmentBottomSheetPaymentSettingBinding;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> GetContactSyncConfig;
    static volatile Consumer<? super Throwable> KClassImpl$Data$declaredNonStaticMembers$2;
    static volatile Function<? super Completable, ? extends Completable> MyBillsEntityDataFactory;
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> NetworkUserEntityData$$ExternalSyntheticLambda0;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> NetworkUserEntityData$$ExternalSyntheticLambda1;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> NetworkUserEntityData$$ExternalSyntheticLambda2;
    static volatile Function<? super Scheduler, ? extends Scheduler> NetworkUserEntityData$$ExternalSyntheticLambda3;
    static volatile Function<? super Runnable, ? extends Runnable> NetworkUserEntityData$$ExternalSyntheticLambda4;
    static volatile Function<? super Single, ? extends Single> NetworkUserEntityData$$ExternalSyntheticLambda5;
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> NetworkUserEntityData$$ExternalSyntheticLambda6;
    static volatile Function<? super Maybe, ? extends Maybe> NetworkUserEntityData$$ExternalSyntheticLambda7;
    static volatile Function<? super Scheduler, ? extends Scheduler> NetworkUserEntityData$$ExternalSyntheticLambda8;
    static volatile boolean PlaceComponentResult;
    static volatile Function<? super Observable, ? extends Observable> PrepareContext;
    static volatile BooleanSupplier getAuthRequestContext;
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getErrorConfigVersion;
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> initRecordTimeStamp;
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> isLayoutRequested;
    static volatile Function<? super Flowable, ? extends Flowable> lookAheadTest;
    static volatile Function<? super Scheduler, ? extends Scheduler> moveToNextValue;
    static volatile Function<? super Scheduler, ? extends Scheduler> newProxyInstance;
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> scheduleImpl;
    public static final byte[] getSupportButtonTintMode = {116, 15, TarHeader.LF_BLK, -20, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int getCallingPid = 171;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002c -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 12
            int r6 = 15 - r6
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r0 = io.reactivex.plugins.RxJavaPlugins.getSupportButtonTintMode
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r8
            r4 = 0
            r8 = r7
            r7 = r6
            goto L32
        L1a:
            r3 = 0
        L1b:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L32:
            int r6 = r6 + r3
            int r6 = r6 + 2
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.plugins.RxJavaPlugins.a(short, byte, int, java.lang.Object[]):void");
    }

    public static boolean MyBillsEntityDataFactory() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static Scheduler BuiltInFictitiousFunctionClassFactory(Callable<Scheduler> callable) {
        ObjectHelper.PlaceComponentResult(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = GetContactSyncConfig;
        if (function == null) {
            return MyBillsEntityDataFactory(callable);
        }
        return (Scheduler) ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(function, callable), "Scheduler Callable result can't be null");
    }

    public static Scheduler PlaceComponentResult(Callable<Scheduler> callable) {
        ObjectHelper.PlaceComponentResult(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = DatabaseTableConfigUtil;
        if (function == null) {
            return MyBillsEntityDataFactory(callable);
        }
        return (Scheduler) ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(function, callable), "Scheduler Callable result can't be null");
    }

    public static Scheduler KClassImpl$Data$declaredNonStaticMembers$2(Callable<Scheduler> callable) {
        ObjectHelper.PlaceComponentResult(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (function == null) {
            return MyBillsEntityDataFactory(callable);
        }
        return (Scheduler) ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(function, callable), "Scheduler Callable result can't be null");
    }

    public static Scheduler getAuthRequestContext(Callable<Scheduler> callable) {
        ObjectHelper.PlaceComponentResult(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (function == null) {
            return MyBillsEntityDataFactory(callable);
        }
        return (Scheduler) ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(function, callable), "Scheduler Callable result can't be null");
    }

    public static Scheduler KClassImpl$Data$declaredNonStaticMembers$2(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = moveToNextValue;
        return function == null ? scheduler : (Scheduler) BuiltInFictitiousFunctionClassFactory(function, scheduler);
    }

    public static void PlaceComponentResult(Throwable th) {
        Consumer<? super Throwable> consumer = KClassImpl$Data$declaredNonStaticMembers$2;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!KClassImpl$Data$declaredNonStaticMembers$2(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                getAuthRequestContext(th2);
            }
        }
        getAuthRequestContext(th);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    private static void getAuthRequestContext(Throwable th) {
        try {
            byte b = (byte) (getSupportButtonTintMode[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getSupportButtonTintMode[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            thread.getUncaughtExceptionHandler().uncaughtException(thread, th);
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    public static Scheduler getAuthRequestContext(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = newProxyInstance;
        return function == null ? scheduler : (Scheduler) BuiltInFictitiousFunctionClassFactory(function, scheduler);
    }

    public static Scheduler BuiltInFictitiousFunctionClassFactory(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = NetworkUserEntityData$$ExternalSyntheticLambda8;
        return function == null ? scheduler : (Scheduler) BuiltInFictitiousFunctionClassFactory(function, scheduler);
    }

    public static Runnable KClassImpl$Data$declaredNonStaticMembers$2(Runnable runnable) {
        ObjectHelper.PlaceComponentResult(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = NetworkUserEntityData$$ExternalSyntheticLambda4;
        return function == null ? runnable : (Runnable) BuiltInFictitiousFunctionClassFactory(function, runnable);
    }

    public static Scheduler MyBillsEntityDataFactory(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = NetworkUserEntityData$$ExternalSyntheticLambda3;
        return function == null ? scheduler : (Scheduler) BuiltInFictitiousFunctionClassFactory(function, scheduler);
    }

    public static void getAuthRequestContext(Consumer<? super Throwable> consumer) {
        if (PlaceComponentResult) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = consumer;
    }

    public static <T> Subscriber<? super T> KClassImpl$Data$declaredNonStaticMembers$2(Flowable<T> flowable, Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = initRecordTimeStamp;
        return biFunction != null ? (Subscriber) getAuthRequestContext(biFunction, flowable, subscriber) : subscriber;
    }

    public static <T> Observer<? super T> MyBillsEntityDataFactory(Observable<T> observable, Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = NetworkUserEntityData$$ExternalSyntheticLambda6;
        return biFunction != null ? (Observer) getAuthRequestContext(biFunction, observable, observer) : observer;
    }

    public static <T> SingleObserver<? super T> PlaceComponentResult(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = FragmentBottomSheetPaymentSettingBinding;
        return biFunction != null ? (SingleObserver) getAuthRequestContext(biFunction, single, singleObserver) : singleObserver;
    }

    public static CompletableObserver PlaceComponentResult(Completable completable, CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = getErrorConfigVersion;
        return biFunction != null ? (CompletableObserver) getAuthRequestContext(biFunction, completable, completableObserver) : completableObserver;
    }

    public static <T> MaybeObserver<? super T> getAuthRequestContext(Maybe<T> maybe, MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = isLayoutRequested;
        return biFunction != null ? (MaybeObserver) getAuthRequestContext(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    public static <T> Maybe<T> getAuthRequestContext(Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = NetworkUserEntityData$$ExternalSyntheticLambda7;
        return function != null ? (Maybe) BuiltInFictitiousFunctionClassFactory(function, maybe) : maybe;
    }

    public static <T> Flowable<T> getAuthRequestContext(Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = lookAheadTest;
        return function != null ? (Flowable) BuiltInFictitiousFunctionClassFactory(function, flowable) : flowable;
    }

    public static <T> ConnectableFlowable<T> MyBillsEntityDataFactory(ConnectableFlowable<T> connectableFlowable) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = NetworkUserEntityData$$ExternalSyntheticLambda0;
        return function != null ? (ConnectableFlowable) BuiltInFictitiousFunctionClassFactory(function, connectableFlowable) : connectableFlowable;
    }

    public static <T> Observable<T> BuiltInFictitiousFunctionClassFactory(Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = PrepareContext;
        return function != null ? (Observable) BuiltInFictitiousFunctionClassFactory(function, observable) : observable;
    }

    public static <T> ConnectableObservable<T> getAuthRequestContext(ConnectableObservable<T> connectableObservable) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = scheduleImpl;
        return function != null ? (ConnectableObservable) BuiltInFictitiousFunctionClassFactory(function, connectableObservable) : connectableObservable;
    }

    public static <T> Single<T> BuiltInFictitiousFunctionClassFactory(Single<T> single) {
        Function<? super Single, ? extends Single> function = NetworkUserEntityData$$ExternalSyntheticLambda5;
        return function != null ? (Single) BuiltInFictitiousFunctionClassFactory(function, single) : single;
    }

    public static Completable KClassImpl$Data$declaredNonStaticMembers$2(Completable completable) {
        Function<? super Completable, ? extends Completable> function = MyBillsEntityDataFactory;
        return function != null ? (Completable) BuiltInFictitiousFunctionClassFactory(function, completable) : completable;
    }

    public static boolean PlaceComponentResult() {
        BooleanSupplier booleanSupplier = getAuthRequestContext;
        if (booleanSupplier != null) {
            try {
                return booleanSupplier.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.MyBillsEntityDataFactory(th);
            }
        }
        return false;
    }

    private static <T, R> R BuiltInFictitiousFunctionClassFactory(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    private static <T, U, R> R getAuthRequestContext(BiFunction<T, U, R> biFunction, T t, U u) {
        try {
            return biFunction.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    private static Scheduler MyBillsEntityDataFactory(Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.PlaceComponentResult(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }
}
