package io.reactivex;

import com.ap.zoloz.hummer.biz.HummerConstants;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservablePublishClassic;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;

/* loaded from: classes.dex */
public abstract class Observable<T> implements ObservableSource<T> {
    protected abstract void subscribeActual(Observer<? super T> observer);

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.PlaceComponentResult(iterable, "sources is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableAmb(null, iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        ObjectHelper.PlaceComponentResult(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableAmb(observableSourceArr, null));
    }

    public static int bufferSize() {
        return Flowable.BuiltInFictitiousFunctionClassFactory();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.PlaceComponentResult(iterable, "sources is null");
        ObjectHelper.PlaceComponentResult(function, "combiner is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCombineLatest(null, iterable, function, i << 1, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatest(observableSourceArr, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.PlaceComponentResult(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.PlaceComponentResult(function, "combiner is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        return combineLatest(Functions.MyBillsEntityDataFactory((BiFunction) biFunction), bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        return combineLatest(Functions.BuiltInFictitiousFunctionClassFactory(function3), bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        return combineLatest(Functions.KClassImpl$Data$declaredNonStaticMembers$2((Function4) function4), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        return combineLatest(Functions.getAuthRequestContext(function5), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        ObjectHelper.PlaceComponentResult(observableSource6, "source6 is null");
        return combineLatest(Functions.getAuthRequestContext(function6), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        ObjectHelper.PlaceComponentResult(observableSource6, "source6 is null");
        ObjectHelper.PlaceComponentResult(observableSource7, "source7 is null");
        return combineLatest(Functions.KClassImpl$Data$declaredNonStaticMembers$2((Function7) function7), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        ObjectHelper.PlaceComponentResult(observableSource6, "source6 is null");
        ObjectHelper.PlaceComponentResult(observableSource7, "source7 is null");
        ObjectHelper.PlaceComponentResult(observableSource8, "source8 is null");
        return combineLatest(Functions.MyBillsEntityDataFactory((Function8) function8), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        ObjectHelper.PlaceComponentResult(observableSource6, "source6 is null");
        ObjectHelper.PlaceComponentResult(observableSource7, "source7 is null");
        ObjectHelper.PlaceComponentResult(observableSource8, "source8 is null");
        ObjectHelper.PlaceComponentResult(observableSource9, "source9 is null");
        return combineLatest(Functions.MyBillsEntityDataFactory((Function9) function9), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(observableSourceArr, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError(observableSourceArr, function, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        ObjectHelper.PlaceComponentResult(function, "combiner is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.PlaceComponentResult(iterable, "sources is null");
        ObjectHelper.PlaceComponentResult(function, "combiner is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCombineLatest(null, iterable, function, i << 1, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.PlaceComponentResult(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.MyBillsEntityDataFactory(), bufferSize(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concat(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMap(observableSource, Functions.MyBillsEntityDataFactory(), i, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        return concatArray(observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMap(fromArray(observableSourceArr), Functions.MyBillsEntityDataFactory(), bufferSize(), ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return concatDelayError(fromArray(observableSourceArr));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEager(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.MyBillsEntityDataFactory(), i, i2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEagerDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), observableSourceArr);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEagerDelayError(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.MyBillsEntityDataFactory(), i, i2, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.PlaceComponentResult(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i, boolean z) {
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMap(observableSource, Functions.MyBillsEntityDataFactory(), i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatEager(observableSource, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i, int i2) {
        return wrap(observableSource).concatMapEager(Functions.MyBillsEntityDataFactory(), i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.MyBillsEntityDataFactory(), i, i2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.PlaceComponentResult(observableOnSubscribe, "source is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCreate(observableOnSubscribe));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        ObjectHelper.PlaceComponentResult(callable, "supplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDefer(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> empty() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(ObservableEmpty.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.PlaceComponentResult(callable, "errorSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableError(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> error(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "exception is null");
        return error(Functions.MyBillsEntityDataFactory(th));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromArray(T... tArr) {
        ObjectHelper.PlaceComponentResult(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFromArray(tArr));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.PlaceComponentResult(callable, "supplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory((Observable) new ObservableFromCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.PlaceComponentResult(future, "future is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFromFuture(future, 0L, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.PlaceComponentResult(future, "future is null");
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFromFuture(future, j, timeUnit));
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(scheduler);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.PlaceComponentResult(iterable, "source is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFromIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> Observable<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.PlaceComponentResult(publisher, "publisher is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFromPublisher(publisher));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.PlaceComponentResult(consumer, "generator is null");
        return generate(Functions.lookAheadTest(), ObservableInternalHelper.MyBillsEntityDataFactory(consumer), Functions.PlaceComponentResult());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.PlaceComponentResult(biConsumer, "generator is null");
        return generate(callable, ObservableInternalHelper.getAuthRequestContext(biConsumer), Functions.PlaceComponentResult());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.PlaceComponentResult(biConsumer, "generator is null");
        return generate(callable, ObservableInternalHelper.getAuthRequestContext(biConsumer), consumer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, Functions.PlaceComponentResult());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.PlaceComponentResult(callable, "initialState is null");
        ObjectHelper.PlaceComponentResult(biFunction, "generator is null");
        ObjectHelper.PlaceComponentResult(consumer, "disposeState is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableGenerate(callable, biFunction, consumer));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return interval(j, j2, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> interval(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return interval(j, j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Observable<Long> interval(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j, j, timeUnit, scheduler);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return intervalRange(j, j2, j3, j4, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Observable<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (j2 == 0) {
            return empty().delay(j3, timeUnit, scheduler);
        } else {
            long j5 = j + (j2 - 1);
            if (j > 0 && j5 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
            ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableIntervalRange(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, scheduler));
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t) {
        ObjectHelper.PlaceComponentResult(t, "item is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory((Observable) new ObservableJust(t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        return fromArray(t, t2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        ObjectHelper.PlaceComponentResult(t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        ObjectHelper.PlaceComponentResult(t3, "item3 is null");
        ObjectHelper.PlaceComponentResult(t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        ObjectHelper.PlaceComponentResult(t3, "item3 is null");
        ObjectHelper.PlaceComponentResult(t4, "item4 is null");
        ObjectHelper.PlaceComponentResult(t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        ObjectHelper.PlaceComponentResult(t3, "item3 is null");
        ObjectHelper.PlaceComponentResult(t4, "item4 is null");
        ObjectHelper.PlaceComponentResult(t5, "item5 is null");
        ObjectHelper.PlaceComponentResult(t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        ObjectHelper.PlaceComponentResult(t3, "item3 is null");
        ObjectHelper.PlaceComponentResult(t4, "item4 is null");
        ObjectHelper.PlaceComponentResult(t5, "item5 is null");
        ObjectHelper.PlaceComponentResult(t6, "item6 is null");
        ObjectHelper.PlaceComponentResult(t7, "item7 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        ObjectHelper.PlaceComponentResult(t3, "item3 is null");
        ObjectHelper.PlaceComponentResult(t4, "item4 is null");
        ObjectHelper.PlaceComponentResult(t5, "item5 is null");
        ObjectHelper.PlaceComponentResult(t6, "item6 is null");
        ObjectHelper.PlaceComponentResult(t7, "item7 is null");
        ObjectHelper.PlaceComponentResult(t8, "item8 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        ObjectHelper.PlaceComponentResult(t3, "item3 is null");
        ObjectHelper.PlaceComponentResult(t4, "item4 is null");
        ObjectHelper.PlaceComponentResult(t5, "item5 is null");
        ObjectHelper.PlaceComponentResult(t6, "item6 is null");
        ObjectHelper.PlaceComponentResult(t7, "item7 is null");
        ObjectHelper.PlaceComponentResult(t8, "item8 is null");
        ObjectHelper.PlaceComponentResult(t9, "item9 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        ObjectHelper.PlaceComponentResult(t, "item1 is null");
        ObjectHelper.PlaceComponentResult(t2, "item2 is null");
        ObjectHelper.PlaceComponentResult(t3, "item3 is null");
        ObjectHelper.PlaceComponentResult(t4, "item4 is null");
        ObjectHelper.PlaceComponentResult(t5, "item5 is null");
        ObjectHelper.PlaceComponentResult(t6, "item6 is null");
        ObjectHelper.PlaceComponentResult(t7, "item7 is null");
        ObjectHelper.PlaceComponentResult(t8, "item8 is null");
        ObjectHelper.PlaceComponentResult(t9, "item9 is null");
        ObjectHelper.PlaceComponentResult(t10, "item10 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.MyBillsEntityDataFactory(), false, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArray(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.MyBillsEntityDataFactory(), false, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.MyBillsEntityDataFactory());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.MyBillsEntityDataFactory(), i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlatMap(observableSource, Functions.MyBillsEntityDataFactory(), false, Integer.MAX_VALUE, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "maxConcurrency");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlatMap(observableSource, Functions.MyBillsEntityDataFactory(), false, i, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.MyBillsEntityDataFactory(), false, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.MyBillsEntityDataFactory(), false, 3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.MyBillsEntityDataFactory(), false, 4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.MyBillsEntityDataFactory(), observableSourceArr.length);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.MyBillsEntityDataFactory(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.MyBillsEntityDataFactory(), true, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArrayDelayError(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.MyBillsEntityDataFactory(), true, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.MyBillsEntityDataFactory(), true, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlatMap(observableSource, Functions.MyBillsEntityDataFactory(), true, Integer.MAX_VALUE, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "maxConcurrency");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlatMap(observableSource, Functions.MyBillsEntityDataFactory(), true, i, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.MyBillsEntityDataFactory(), true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.MyBillsEntityDataFactory(), true, 3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.MyBillsEntityDataFactory(), true, 4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.MyBillsEntityDataFactory(), true, observableSourceArr.length);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> never() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(ObservableNever.MyBillsEntityDataFactory);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable<Integer> range(int i, int i2) {
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 == 0) {
            return empty();
        } else {
            if (i2 == 1) {
                return just(Integer.valueOf(i));
            }
            if (i + ((long) (i2 - 1)) > 2147483647L) {
                throw new IllegalArgumentException("Integer overflow");
            }
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRange(i, i2));
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable<Long> rangeLong(long j, long j2) {
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (j2 == 0) {
            return empty();
        } else {
            if (j2 == 1) {
                return just(Long.valueOf(j));
            }
            if (j > 0 && (j2 - 1) + j < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRangeLong(j, j2));
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.KClassImpl$Data$declaredNonStaticMembers$2(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(biPredicate, "isEqual is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.KClassImpl$Data$declaredNonStaticMembers$2(), i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchMap(observableSource, Functions.MyBillsEntityDataFactory(), i, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchMap(observableSource, Functions.MyBillsEntityDataFactory(), i, true));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> timer(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return timer(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Observable<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTimer(Math.max(j, 0L), timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> unsafeCreate(ObservableSource<T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "onSubscribe is null");
        if (observableSource instanceof Observable) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFromUnsafeSource(observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        ObjectHelper.PlaceComponentResult(callable, "resourceSupplier is null");
        ObjectHelper.PlaceComponentResult(function, "sourceSupplier is null");
        ObjectHelper.PlaceComponentResult(consumer, "disposer is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableUsing(callable, function, consumer, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> wrap(ObservableSource<T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "source is null");
        if (observableSource instanceof Observable) {
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory((Observable) observableSource);
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFromUnsafeSource(observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.PlaceComponentResult(function, "zipper is null");
        ObjectHelper.PlaceComponentResult(iterable, "sources is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableZip(null, iterable, function, bufferSize(), false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        ObjectHelper.PlaceComponentResult(function, "zipper is null");
        ObjectHelper.PlaceComponentResult(observableSource, "sources is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableToList(observableSource).flatMap(ObservableInternalHelper.BuiltInFictitiousFunctionClassFactory(function)));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        return zipArray(Functions.MyBillsEntityDataFactory((BiFunction) biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        return zipArray(Functions.MyBillsEntityDataFactory((BiFunction) biFunction), z, bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        return zipArray(Functions.MyBillsEntityDataFactory((BiFunction) biFunction), z, i, observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        return zipArray(Functions.BuiltInFictitiousFunctionClassFactory(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        return zipArray(Functions.KClassImpl$Data$declaredNonStaticMembers$2((Function4) function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        return zipArray(Functions.getAuthRequestContext(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        ObjectHelper.PlaceComponentResult(observableSource6, "source6 is null");
        return zipArray(Functions.getAuthRequestContext(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        ObjectHelper.PlaceComponentResult(observableSource6, "source6 is null");
        ObjectHelper.PlaceComponentResult(observableSource7, "source7 is null");
        return zipArray(Functions.KClassImpl$Data$declaredNonStaticMembers$2((Function7) function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        ObjectHelper.PlaceComponentResult(observableSource6, "source6 is null");
        ObjectHelper.PlaceComponentResult(observableSource7, "source7 is null");
        ObjectHelper.PlaceComponentResult(observableSource8, "source8 is null");
        return zipArray(Functions.MyBillsEntityDataFactory((Function8) function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.PlaceComponentResult(observableSource, "source1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "source2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "source3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "source4 is null");
        ObjectHelper.PlaceComponentResult(observableSource5, "source5 is null");
        ObjectHelper.PlaceComponentResult(observableSource6, "source6 is null");
        ObjectHelper.PlaceComponentResult(observableSource7, "source7 is null");
        ObjectHelper.PlaceComponentResult(observableSource8, "source8 is null");
        ObjectHelper.PlaceComponentResult(observableSource9, "source9 is null");
        return zipArray(Functions.MyBillsEntityDataFactory((Function9) function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.PlaceComponentResult(function, "zipper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableZip(observableSourceArr, null, function, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(function, "zipper is null");
        ObjectHelper.PlaceComponentResult(iterable, "sources is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableZip(null, iterable, function, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.PlaceComponentResult(predicate, "predicate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableAllSingle(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> ambWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.PlaceComponentResult(predicate, "predicate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableAnySingle(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R as(ObservableConverter<T, ? extends R> observableConverter) {
        return (R) ((ObservableConverter) ObjectHelper.PlaceComponentResult(observableConverter, "converter is null")).getAuthRequestContext();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingFirst() {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T MyBillsEntityDataFactory = blockingFirstObserver.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory != null) {
            return MyBillsEntityDataFactory;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingFirst(T t) {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T MyBillsEntityDataFactory = blockingFirstObserver.MyBillsEntityDataFactory();
        return MyBillsEntityDataFactory != null ? MyBillsEntityDataFactory : t;
    }

    @SchedulerSupport("none")
    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                ((Disposable) it).dispose();
                throw ExceptionHelper.MyBillsEntityDataFactory(th);
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingIterable(int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return new BlockingObservableIterable(this, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingLast() {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T MyBillsEntityDataFactory = blockingLastObserver.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory != null) {
            return MyBillsEntityDataFactory;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingLast(T t) {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T MyBillsEntityDataFactory = blockingLastObserver.MyBillsEntityDataFactory();
        return MyBillsEntityDataFactory != null ? MyBillsEntityDataFactory : t;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingMostRecent(T t) {
        return new BlockingObservableMostRecent(this, t);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingSingle() {
        T PlaceComponentResult = singleElement().PlaceComponentResult();
        if (PlaceComponentResult != null) {
            return PlaceComponentResult;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingSingle(T t) {
        return single(t).r_();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureObserver());
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        ObservableBlockingSubscribe.getAuthRequestContext(this);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.MyBillsEntityDataFactory(this, consumer, Functions.DatabaseTableConfigUtil, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.MyBillsEntityDataFactory(this, consumer, consumer2, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObservableBlockingSubscribe.MyBillsEntityDataFactory(this, consumer, consumer2, action);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Observer<? super T> observer) {
        ObservableBlockingSubscribe.PlaceComponentResult(this, observer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<List<T>> buffer(int i, int i2) {
        return (Observable<List<T>>) buffer(i, i2, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(int i, int i2, Callable<U> callable) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "count");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i2, HummerConstants.HUMMER_SKIP);
        ObjectHelper.PlaceComponentResult(callable, "bufferSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableBuffer(this, i, i2, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, callable);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return (Observable<List<T>>) buffer(j, j2, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<List<T>>) buffer(j, j2, timeUnit, scheduler, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        ObjectHelper.PlaceComponentResult(callable, "bufferSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableBufferTimed(this, j, j2, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return buffer(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, Integer.MAX_VALUE);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return buffer(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, i);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return (Observable<List<T>>) buffer(j, timeUnit, scheduler, i, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i, Callable<U> callable, boolean z) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        ObjectHelper.PlaceComponentResult(callable, "bufferSupplier is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "count");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableBufferTimed(this, j, j, timeUnit, scheduler, callable, i, z));
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<List<T>>) buffer(j, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return (Observable<List<T>>) buffer(observableSource, function, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.PlaceComponentResult(observableSource, "openingIndicator is null");
        ObjectHelper.PlaceComponentResult(function, "closingIndicator is null");
        ObjectHelper.PlaceComponentResult(callable, "bufferSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableBufferBoundary(this, observableSource, function, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource) {
        return (Observable<List<T>>) buffer(observableSource, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource, int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "initialCapacity");
        return (Observable<List<T>>) buffer(observableSource, Functions.getAuthRequestContext(i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        ObjectHelper.PlaceComponentResult(observableSource, "boundary is null");
        ObjectHelper.PlaceComponentResult(callable, "bufferSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableBufferExactBoundary(this, observableSource, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return (Observable<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        ObjectHelper.PlaceComponentResult(callable, "boundarySupplier is null");
        ObjectHelper.PlaceComponentResult(callable2, "bufferSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableBufferBoundarySupplier(this, callable, callable2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> cacheWithInitialCapacity(int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "initialCapacity");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCache(this, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> cast(Class<U> cls) {
        ObjectHelper.PlaceComponentResult(cls, "clazz is null");
        return (Observable<U>) map(Functions.PlaceComponentResult((Class) cls));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.PlaceComponentResult(callable, "initialValueSupplier is null");
        ObjectHelper.PlaceComponentResult(biConsumer, "collector is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCollectSingle(this, callable, biConsumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.PlaceComponentResult(u, "initialValue is null");
        return collect(Functions.MyBillsEntityDataFactory(u), biConsumer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        return wrap(((ObservableTransformer) ObjectHelper.PlaceComponentResult(observableTransformer, "composer is null")).MyBillsEntityDataFactory(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        Observable<R> BuiltInFictitiousFunctionClassFactory;
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call != null) {
                BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableScalarXMap.ScalarXMapObservable(call, function));
                return BuiltInFictitiousFunctionClassFactory;
            }
            return empty();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMap(this, function, i, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
        Observable<R> BuiltInFictitiousFunctionClassFactory;
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMap(this, function, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        Object call = ((ScalarCallable) this).call();
        if (call != null) {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableScalarXMap.ScalarXMapObservable(call, function));
            return BuiltInFictitiousFunctionClassFactory;
        }
        return empty();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapEager(function, Integer.MAX_VALUE, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "maxConcurrency");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i2, "prefetch");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i, i2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2, boolean z) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "maxConcurrency");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i2, "prefetch");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMapEager(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i, i2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "capacityHint");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z) {
        return concatMapCompletableDelayError(function, z, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new ObservableConcatMapCompletable(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlattenIterable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        return (Observable<U>) concatMap(ObservableInternalHelper.MyBillsEntityDataFactory(function), i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int i) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        return concatMapMaybeDelayError(function, z, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMapMaybe(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int i) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        return concatMapSingleDelayError(function, z, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "prefetch");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatMapSingle(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return concat(this, observableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.PlaceComponentResult(singleSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatWithSingle(this, singleSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.PlaceComponentResult(maybeSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatWithMaybe(this, maybeSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(CompletableSource completableSource) {
        ObjectHelper.PlaceComponentResult(completableSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableConcatWithCompletable(this, completableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.PlaceComponentResult(obj, "element is null");
        return any(Functions.KClassImpl$Data$declaredNonStaticMembers$2(obj));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Long> count() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCountSingle(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.PlaceComponentResult(function, "debounceSelector is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDebounce(this, function));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> debounce(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return debounce(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> debounce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDebounceTimed(this, j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> defaultIfEmpty(T t) {
        ObjectHelper.PlaceComponentResult(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.PlaceComponentResult(function, "itemDelay is null");
        return (Observable<T>) flatMap(ObservableInternalHelper.getAuthRequestContext(function));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delay(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return delay(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delay(long j, TimeUnit timeUnit, boolean z) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return delay(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, z);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDelay(this, j, timeUnit, scheduler, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> delay(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        return delaySubscription(observableSource).delay(function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDelaySubscriptionOther(this, observableSource));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delaySubscription(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return delaySubscription(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Deprecated
    public final <T2> Observable<T2> dematerialize() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDematerialize(this, Functions.MyBillsEntityDataFactory()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> dematerialize(Function<? super T, Notification<R>> function) {
        ObjectHelper.PlaceComponentResult(function, "selector is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDematerialize(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinct() {
        return distinct(Functions.MyBillsEntityDataFactory(), Functions.getAuthRequestContext());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.getAuthRequestContext());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.PlaceComponentResult(function, "keySelector is null");
        ObjectHelper.PlaceComponentResult(callable, "collectionSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDistinct(this, function, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.MyBillsEntityDataFactory());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.PlaceComponentResult(function, "keySelector is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDistinctUntilChanged(this, function, ObjectHelper.KClassImpl$Data$declaredNonStaticMembers$2()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.PlaceComponentResult(biPredicate, "comparer is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDistinctUntilChanged(this, Functions.MyBillsEntityDataFactory(), biPredicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.PlaceComponentResult(consumer, "onAfterNext is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDoAfterNext(this, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doAfterTerminate(Action action) {
        ObjectHelper.PlaceComponentResult(action, "onFinally is null");
        return doOnEach(Functions.PlaceComponentResult(), Functions.PlaceComponentResult(), Functions.KClassImpl$Data$declaredNonStaticMembers$2, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doFinally(Action action) {
        ObjectHelper.PlaceComponentResult(action, "onFinally is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDoFinally(this, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnDispose(Action action) {
        return doOnLifecycle(Functions.PlaceComponentResult(), action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnComplete(Action action) {
        return doOnEach(Functions.PlaceComponentResult(), Functions.PlaceComponentResult(), action, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    private Observable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.PlaceComponentResult(consumer, "onNext is null");
        ObjectHelper.PlaceComponentResult(consumer2, "onError is null");
        ObjectHelper.PlaceComponentResult(action, "onComplete is null");
        ObjectHelper.PlaceComponentResult(action2, "onAfterTerminate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.PlaceComponentResult(consumer, "onNotification is null");
        return doOnEach(Functions.PlaceComponentResult((Consumer) consumer), Functions.BuiltInFictitiousFunctionClassFactory(consumer), Functions.KClassImpl$Data$declaredNonStaticMembers$2((Consumer) consumer), Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnEach(Observer<? super T> observer) {
        ObjectHelper.PlaceComponentResult(observer, "observer is null");
        return doOnEach(ObservableInternalHelper.MyBillsEntityDataFactory(observer), ObservableInternalHelper.PlaceComponentResult(observer), ObservableInternalHelper.BuiltInFictitiousFunctionClassFactory(observer), Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer<? super T> PlaceComponentResult = Functions.PlaceComponentResult();
        Action action = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
        return doOnEach(PlaceComponentResult, consumer, action, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        ObjectHelper.PlaceComponentResult(consumer, "onSubscribe is null");
        ObjectHelper.PlaceComponentResult(action, "onDispose is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDoOnLifecycle(this, consumer, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        Consumer<? super Throwable> PlaceComponentResult = Functions.PlaceComponentResult();
        Action action = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
        return doOnEach(consumer, PlaceComponentResult, action, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnTerminate(Action action) {
        ObjectHelper.PlaceComponentResult(action, "onTerminate is null");
        return doOnEach(Functions.PlaceComponentResult(), Functions.BuiltInFictitiousFunctionClassFactory(action), action, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> elementAt(long j) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("index >= 0 required but it was ");
            sb.append(j);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return RxJavaPlugins.getAuthRequestContext(new ObservableElementAtMaybe(this, j));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> elementAt(long j, T t) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("index >= 0 required but it was ");
            sb.append(j);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        ObjectHelper.PlaceComponentResult(t, "defaultItem is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableElementAtSingle(this, j, t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> elementAtOrError(long j) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("index >= 0 required but it was ");
            sb.append(j);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableElementAtSingle(this, j, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.PlaceComponentResult(predicate, "predicate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFilter(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> firstElement() {
        return elementAt(0L);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> first(T t) {
        return elementAt(0L, t);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> firstOrError() {
        return elementAtOrError(0L);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap((Function) function, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return flatMap(function, z, Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i) {
        return flatMap(function, z, i, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i, int i2) {
        Observable<R> BuiltInFictitiousFunctionClassFactory;
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "maxConcurrency");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i2, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call != null) {
                BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableScalarXMap.ScalarXMapObservable(call, function));
                return BuiltInFictitiousFunctionClassFactory;
            }
            return empty();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlatMap(this, function, z, i, i2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        ObjectHelper.PlaceComponentResult(function, "onNextMapper is null");
        ObjectHelper.PlaceComponentResult(function2, "onErrorMapper is null");
        ObjectHelper.PlaceComponentResult(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i) {
        ObjectHelper.PlaceComponentResult(function, "onNextMapper is null");
        ObjectHelper.PlaceComponentResult(function2, "onErrorMapper is null");
        ObjectHelper.PlaceComponentResult(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable), i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        return flatMap((Function) function, false, i, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return flatMap(function, biFunction, z, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return flatMap(function, biFunction, z, i, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i, int i2) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.PlaceComponentResult(biFunction, "combiner is null");
        return flatMap(ObservableInternalHelper.getAuthRequestContext(function, biFunction), z, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        return flatMap(function, biFunction, false, i, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new ObservableFlatMapCompletableCompletable(this, function, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlattenIterable(this, function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.PlaceComponentResult(biFunction, "resultSelector is null");
        return (Observable<V>) flatMap(ObservableInternalHelper.MyBillsEntityDataFactory(function), biFunction, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlatMapMaybe(this, function, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableFlatMapSingle(this, function, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.DatabaseTableConfigUtil, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.PlaceComponentResult(predicate, "onNext is null");
        ObjectHelper.PlaceComponentResult(consumer, "onError is null");
        ObjectHelper.PlaceComponentResult(action, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return (Observable<GroupedObservable<K, T>>) groupBy(function, Functions.MyBillsEntityDataFactory(), false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z) {
        return (Observable<GroupedObservable<K, T>>) groupBy(function, Functions.MyBillsEntityDataFactory(), z, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z) {
        return groupBy(function, function2, z, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(function, "keySelector is null");
        ObjectHelper.PlaceComponentResult(function2, "valueSelector is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableGroupBy(this, function, function2, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        ObjectHelper.PlaceComponentResult(function, "leftEnd is null");
        ObjectHelper.PlaceComponentResult(function2, "rightEnd is null");
        ObjectHelper.PlaceComponentResult(biFunction, "resultSelector is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> hide() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableHide(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ignoreElements() {
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new ObservableIgnoreElementsCompletable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> isEmpty() {
        return all(Functions.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        ObjectHelper.PlaceComponentResult(function, "leftEnd is null");
        ObjectHelper.PlaceComponentResult(function2, "rightEnd is null");
        ObjectHelper.PlaceComponentResult(biFunction, "resultSelector is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.getAuthRequestContext(new ObservableLastMaybe(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> last(T t) {
        ObjectHelper.PlaceComponentResult(t, "defaultItem is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableLastSingle(this, t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> lastOrError() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableLastSingle(this, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        ObjectHelper.PlaceComponentResult(observableOperator, "lifter is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableLift(this, observableOperator));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableMap(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Notification<T>> materialize() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableMaterialize(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return merge(this, observableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.PlaceComponentResult(singleSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableMergeWithSingle(this, singleSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.PlaceComponentResult(maybeSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableMergeWithMaybe(this, maybeSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(CompletableSource completableSource) {
        ObjectHelper.PlaceComponentResult(completableSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableMergeWithCompletable(this, completableSource));
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler scheduler, boolean z) {
        return observeOn(scheduler, z, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler scheduler, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableObserveOn(this, scheduler, z, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> ofType(Class<U> cls) {
        ObjectHelper.PlaceComponentResult(cls, "clazz is null");
        return filter(Functions.KClassImpl$Data$declaredNonStaticMembers$2((Class) cls)).cast(cls);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.PlaceComponentResult(function, "resumeFunction is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableOnErrorNext(this, function, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "next is null");
        return onErrorResumeNext(Functions.PlaceComponentResult(observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.PlaceComponentResult(function, "valueSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableOnErrorReturn(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorReturnItem(T t) {
        ObjectHelper.PlaceComponentResult(t, "item is null");
        return onErrorReturn(Functions.PlaceComponentResult(t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "next is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableOnErrorNext(this, Functions.PlaceComponentResult(observableSource), true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onTerminateDetach() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableDetach(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> publish() {
        return ObservablePublish.PlaceComponentResult(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.PlaceComponentResult(function, "selector is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservablePublishSelector(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.PlaceComponentResult(biFunction, "reducer is null");
        return RxJavaPlugins.getAuthRequestContext(new ObservableReduceMaybe(this, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.PlaceComponentResult(r, "seed is null");
        ObjectHelper.PlaceComponentResult(biFunction, "reducer is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableReduceSeedSingle(this, r, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.PlaceComponentResult(callable, "seedSupplier is null");
        ObjectHelper.PlaceComponentResult(biFunction, "reducer is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableReduceWithSingle(this, callable, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeat() {
        return repeat(LongCompanionObject.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeat(long j) {
        if (j >= 0) {
            if (j == 0) {
                return empty();
            }
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRepeat(this, j));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("times >= 0 required but it was ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.PlaceComponentResult(booleanSupplier, "stop is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRepeatUntil(this, booleanSupplier));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        ObjectHelper.PlaceComponentResult(function, "handler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRepeatWhen(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> replay() {
        return ObservableReplay.getAuthRequestContext(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.PlaceComponentResult(function, "selector is null");
        return ObservableReplay.PlaceComponentResult(ObservableInternalHelper.BuiltInFictitiousFunctionClassFactory(this), function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i) {
        ObjectHelper.PlaceComponentResult(function, "selector is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return ObservableReplay.PlaceComponentResult(ObservableInternalHelper.MyBillsEntityDataFactory(this, i), function);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return replay(function, i, j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(function, "selector is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return ObservableReplay.PlaceComponentResult(ObservableInternalHelper.MyBillsEntityDataFactory(this, i, j, timeUnit, scheduler), function);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(function, "selector is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return ObservableReplay.PlaceComponentResult(ObservableInternalHelper.MyBillsEntityDataFactory(this, i), ObservableInternalHelper.PlaceComponentResult(function, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return replay(function, j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(function, "selector is null");
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return ObservableReplay.PlaceComponentResult(ObservableInternalHelper.KClassImpl$Data$declaredNonStaticMembers$2(this, j, timeUnit, scheduler), function);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(function, "selector is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return ObservableReplay.PlaceComponentResult(ObservableInternalHelper.BuiltInFictitiousFunctionClassFactory(this), ObservableInternalHelper.PlaceComponentResult(function, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return ObservableReplay.getAuthRequestContext(this, i);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int i, long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return replay(i, j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return ObservableReplay.PlaceComponentResult(this, j, timeUnit, scheduler, i);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int i, Scheduler scheduler) {
        ConnectableObservable<T> authRequestContext;
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        authRequestContext = RxJavaPlugins.getAuthRequestContext(new ObservableReplay.Replay(r2, replay(i).observeOn(scheduler)));
        return authRequestContext;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return replay(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return ObservableReplay.PlaceComponentResult(this, j, timeUnit, scheduler);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        ConnectableObservable<T> authRequestContext;
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        authRequestContext = RxJavaPlugins.getAuthRequestContext(new ObservableReplay.Replay(r0, replay().observeOn(scheduler)));
        return authRequestContext;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry() {
        return retry(LongCompanionObject.MAX_VALUE, Functions.BuiltInFictitiousFunctionClassFactory());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.PlaceComponentResult(biPredicate, "predicate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRetryBiPredicate(this, biPredicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(long j) {
        return retry(j, Functions.BuiltInFictitiousFunctionClassFactory());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(long j, Predicate<? super Throwable> predicate) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("times >= 0 required but it was ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        ObjectHelper.PlaceComponentResult(predicate, "predicate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRetryPredicate(this, j, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(LongCompanionObject.MAX_VALUE, predicate);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.PlaceComponentResult(booleanSupplier, "stop is null");
        return retry(LongCompanionObject.MAX_VALUE, Functions.MyBillsEntityDataFactory(booleanSupplier));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        ObjectHelper.PlaceComponentResult(function, "handler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRetryWhen(this, function));
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(Observer<? super T> observer) {
        ObjectHelper.PlaceComponentResult(observer, "observer is null");
        if (observer instanceof SafeObserver) {
            subscribe(observer);
        } else {
            subscribe(new SafeObserver(observer));
        }
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> sample(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return sample(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> sample(long j, TimeUnit timeUnit, boolean z) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return sample(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, z);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSampleTimed(this, j, timeUnit, scheduler, false));
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSampleTimed(this, j, timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> sample(ObservableSource<U> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "sampler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSampleWithObservable(this, observableSource, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> sample(ObservableSource<U> observableSource, boolean z) {
        ObjectHelper.PlaceComponentResult(observableSource, "sampler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSampleWithObservable(this, observableSource, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.PlaceComponentResult(biFunction, "accumulator is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableScan(this, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.PlaceComponentResult(r, "initialValue is null");
        return scanWith(Functions.MyBillsEntityDataFactory(r), biFunction);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.PlaceComponentResult(callable, "seedSupplier is null");
        ObjectHelper.PlaceComponentResult(biFunction, "accumulator is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableScanSeed(this, callable, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> serialize() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSerialized(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> share() {
        ConnectableObservable<T> publish = publish();
        if (publish instanceof ObservablePublishClassic) {
            publish = RxJavaPlugins.getAuthRequestContext(new ObservablePublishAlt(((ObservablePublishClassic) publish).getAuthRequestContext()));
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableRefCount(publish));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.getAuthRequestContext(new ObservableSingleMaybe(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> single(T t) {
        ObjectHelper.PlaceComponentResult(t, "defaultItem is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSingleSingle(this, t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> singleOrError() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSingleSingle(this, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skip(long j) {
        if (j <= 0) {
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(this);
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSkip(this, j));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> skip(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skipLast(int i) {
        if (i >= 0) {
            if (i == 0) {
                return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(this);
            }
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSkipLast(this, i));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("count >= 0 required but it was ");
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, Schedulers.PlaceComponentResult(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, Schedulers.PlaceComponentResult(), z, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return skipLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSkipLastTimed(this, j, timeUnit, scheduler, i << 1, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> skipUntil(ObservableSource<U> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSkipUntil(this, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.PlaceComponentResult(predicate, "predicate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSkipWhile(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> sorted() {
        Observable<T> BuiltInFictitiousFunctionClassFactory;
        Comparator comparator;
        Single<List<T>> list = toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        comparator = Functions.NaturalComparator.INSTANCE;
        return BuiltInFictitiousFunctionClassFactory.map(Functions.getAuthRequestContext(comparator)).flatMapIterable(Functions.MyBillsEntityDataFactory());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> sorted(Comparator<? super T> comparator) {
        Observable<T> BuiltInFictitiousFunctionClassFactory;
        ObjectHelper.PlaceComponentResult(comparator, "sortFunction is null");
        Single<List<T>> list = toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        return BuiltInFictitiousFunctionClassFactory.map(Functions.getAuthRequestContext(comparator)).flatMapIterable(Functions.MyBillsEntityDataFactory());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(T t) {
        ObjectHelper.PlaceComponentResult(t, "item is null");
        return concatArray(just(t), this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWithArray(T... tArr) {
        Observable fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(this);
        }
        return concatArray(fromArray, this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.PlaceComponentResult(), Functions.DatabaseTableConfigUtil, Functions.KClassImpl$Data$declaredNonStaticMembers$2, Functions.PlaceComponentResult());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.DatabaseTableConfigUtil, Functions.KClassImpl$Data$declaredNonStaticMembers$2, Functions.PlaceComponentResult());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.KClassImpl$Data$declaredNonStaticMembers$2, Functions.PlaceComponentResult());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.PlaceComponentResult());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.PlaceComponentResult(consumer, "onNext is null");
        ObjectHelper.PlaceComponentResult(consumer2, "onError is null");
        ObjectHelper.PlaceComponentResult(action, "onComplete is null");
        ObjectHelper.PlaceComponentResult(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @Override // io.reactivex.ObservableSource
    @SchedulerSupport("none")
    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.PlaceComponentResult(observer, "observer is null");
        try {
            Observer<? super T> MyBillsEntityDataFactory = RxJavaPlugins.MyBillsEntityDataFactory(this, observer);
            ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(MyBillsEntityDataFactory);
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends Observer<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchIfEmpty(this, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        Observable<R> BuiltInFictitiousFunctionClassFactory;
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call != null) {
                BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableScalarXMap.ScalarXMapObservable(call, function));
                return BuiltInFictitiousFunctionClassFactory;
            }
            return empty();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchMap(this, function, i, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable switchMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new ObservableSwitchMapCompletable(this, function, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable switchMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new ObservableSwitchMapCompletable(this, function, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchMapMaybe(this, function, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchMapMaybe(this, function, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchMapSingle(this, function, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchMapSingle(this, function, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        Observable<R> BuiltInFictitiousFunctionClassFactory;
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call != null) {
                BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableScalarXMap.ScalarXMapObservable(call, function));
                return BuiltInFictitiousFunctionClassFactory;
            }
            return empty();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableSwitchMap(this, function, i, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> take(long j) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTake(this, j));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> take(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeLast(int i) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i == 0) {
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableIgnoreElements(this));
        } else {
            if (i == 1) {
                return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTakeLastOne(this));
            }
            return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTakeLast(this, i));
        }
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, Schedulers.PlaceComponentResult(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, j2, timeUnit, scheduler, false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(j);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTakeLastTimed(this, j, j2, timeUnit, scheduler, i, z));
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, Schedulers.PlaceComponentResult(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, Schedulers.PlaceComponentResult(), z, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return takeLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        return takeLast(LongCompanionObject.MAX_VALUE, j, timeUnit, scheduler, z, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTakeUntil(this, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.PlaceComponentResult(predicate, "stopPredicate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTakeUntilPredicate(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.PlaceComponentResult(predicate, "predicate is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTakeWhile(this, predicate));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleFirst(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return throttleFirst(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> throttleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableThrottleFirstTimed(this, j, timeUnit, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> throttleLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j, timeUnit, scheduler);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleLatest(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return throttleLatest(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleLatest(long j, TimeUnit timeUnit, boolean z) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return throttleLatest(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, z);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> throttleLatest(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return throttleLatest(j, timeUnit, scheduler, false);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> throttleLatest(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableThrottleLatest(this, j, timeUnit, scheduler, z));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> throttleWithTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval() {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return timeInterval(timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return timeInterval(timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTimeInterval(this, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        return timeout0(null, function, null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return timeout0(null, function, observableSource);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> timeout(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return timeout0(j, timeUnit, null, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> timeout(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return timeout0(j, timeUnit, observableSource, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return timeout0(j, timeUnit, observableSource, scheduler);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, null, scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.PlaceComponentResult(observableSource, "firstTimeoutIndicator is null");
        return timeout0(observableSource, function, null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.PlaceComponentResult(observableSource, "firstTimeoutIndicator is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "other is null");
        return timeout0(observableSource, function, observableSource2);
    }

    private Observable<T> timeout0(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "timeUnit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTimeoutTimed(this, j, timeUnit, scheduler, observableSource));
    }

    private <U, V> Observable<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.PlaceComponentResult(function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp() {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return timestamp(timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return timestamp(timeUnit, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return (Observable<Timed<T>>) map(Functions.KClassImpl$Data$declaredNonStaticMembers$2(timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(Function<? super Observable<T>, R> function) {
        try {
            return (R) ((Function) ObjectHelper.PlaceComponentResult(function, "converter is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toList() {
        return toList(16);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toList(int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "capacityHint");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableToListSingle(this, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.PlaceComponentResult(callable, "collectionSupplier is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableToListSingle(this, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.PlaceComponentResult(function, "keySelector is null");
        return (Single<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.MyBillsEntityDataFactory((Function) function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.PlaceComponentResult(function, "keySelector is null");
        ObjectHelper.PlaceComponentResult(function2, "valueSelector is null");
        return (Single<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.MyBillsEntityDataFactory(function, function2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.PlaceComponentResult(function, "keySelector is null");
        ObjectHelper.PlaceComponentResult(function2, "valueSelector is null");
        ObjectHelper.PlaceComponentResult(callable, "mapSupplier is null");
        return (Single<Map<K, V>>) collect(callable, Functions.MyBillsEntityDataFactory(function, function2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return (Single<Map<K, Collection<T>>>) toMultimap(function, Functions.MyBillsEntityDataFactory(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.PlaceComponentResult(function, "keySelector is null");
        ObjectHelper.PlaceComponentResult(function2, "valueSelector is null");
        ObjectHelper.PlaceComponentResult(callable, "mapSupplier is null");
        ObjectHelper.PlaceComponentResult(function3, "collectionFactory is null");
        return (Single<Map<K, Collection<V>>>) collect(callable, Functions.getAuthRequestContext(function, function2, function3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i = AnonymousClass1.getAuthRequestContext[backpressureStrategy.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return RxJavaPlugins.getAuthRequestContext(new FlowableOnBackpressureError(flowableFromObservable));
                    }
                    int BuiltInFictitiousFunctionClassFactory = Flowable.BuiltInFictitiousFunctionClassFactory();
                    ObjectHelper.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "capacity");
                    return RxJavaPlugins.getAuthRequestContext(new FlowableOnBackpressureBuffer(flowableFromObservable, BuiltInFictitiousFunctionClassFactory, Functions.KClassImpl$Data$declaredNonStaticMembers$2));
                }
                return flowableFromObservable;
            }
            return RxJavaPlugins.getAuthRequestContext(new FlowableOnBackpressureLatest(flowableFromObservable));
        }
        return RxJavaPlugins.getAuthRequestContext((Flowable) new FlowableOnBackpressureDrop(flowableFromObservable));
    }

    /* renamed from: io.reactivex.Observable$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.scheduleImpl());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.PlaceComponentResult(comparator, "comparator is null");
        Single<List<T>> list = toList();
        Function authRequestContext = Functions.getAuthRequestContext(comparator);
        ObjectHelper.PlaceComponentResult(authRequestContext, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(list, authRequestContext));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i) {
        ObjectHelper.PlaceComponentResult(comparator, "comparator is null");
        Single<List<T>> list = toList(i);
        Function authRequestContext = Functions.getAuthRequestContext(comparator);
        ObjectHelper.PlaceComponentResult(authRequestContext, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(list, authRequestContext));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(int i) {
        return toSortedList(Functions.scheduleImpl(), i);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableUnsubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, long j2, int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(j, "count");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(j2, HummerConstants.HUMMER_SKIP);
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWindow(this, j, j2, i));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return window(j, j2, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, j2, timeUnit, scheduler, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(j, "timespan");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(j2, "timeskip");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWindowTimed(this, j, j2, timeUnit, scheduler, LongCompanionObject.MAX_VALUE, i, false));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return window(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, (long) LongCompanionObject.MAX_VALUE, false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, long j2) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return window(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, j2, false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        return window(j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2, j2, z);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, timeUnit, scheduler, (long) LongCompanionObject.MAX_VALUE, false);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2) {
        return window(j, timeUnit, scheduler, j2, false);
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z) {
        return window(j, timeUnit, scheduler, j2, z, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z, int i) {
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(j2, "count");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWindowTimed(this, j, j, timeUnit, scheduler, j2, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource) {
        return window(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "boundary is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWindowBoundary(this, observableSource, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return window(observableSource, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i) {
        ObjectHelper.PlaceComponentResult(observableSource, "openingIndicator is null");
        ObjectHelper.PlaceComponentResult(function, "closingIndicator is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWindowBoundarySelector(this, observableSource, function, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return window(callable, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable, int i) {
        ObjectHelper.PlaceComponentResult(callable, "boundary is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWindowBoundarySupplier(this, callable, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        ObjectHelper.PlaceComponentResult(biFunction, "combiner is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.PlaceComponentResult(observableSource, "o1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "o2 is null");
        ObjectHelper.PlaceComponentResult(function3, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2}, Functions.BuiltInFictitiousFunctionClassFactory(function3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.PlaceComponentResult(observableSource, "o1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "o2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "o3 is null");
        ObjectHelper.PlaceComponentResult(function4, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.KClassImpl$Data$declaredNonStaticMembers$2((Function4) function4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.PlaceComponentResult(observableSource, "o1 is null");
        ObjectHelper.PlaceComponentResult(observableSource2, "o2 is null");
        ObjectHelper.PlaceComponentResult(observableSource3, "o3 is null");
        ObjectHelper.PlaceComponentResult(observableSource4, "o4 is null");
        ObjectHelper.PlaceComponentResult(function5, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.getAuthRequestContext(function5));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        ObjectHelper.PlaceComponentResult(observableSourceArr, "others is null");
        ObjectHelper.PlaceComponentResult(function, "combiner is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWithLatestFromMany(this, observableSourceArr, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.PlaceComponentResult(iterable, "others is null");
        ObjectHelper.PlaceComponentResult(function, "combiner is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableWithLatestFromMany(this, iterable, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.PlaceComponentResult(iterable, "other is null");
        ObjectHelper.PlaceComponentResult(biFunction, "zipper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableZipIterable(this, iterable, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.PlaceComponentResult(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return zip(this, observableSource, biFunction, z);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return zip(this, observableSource, biFunction, z, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }
}
