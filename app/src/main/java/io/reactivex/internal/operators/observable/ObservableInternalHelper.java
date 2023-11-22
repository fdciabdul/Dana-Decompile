package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ObservableInternalHelper {
    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.BiFunction
        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            this.MyBillsEntityDataFactory.accept((Emitter) obj2);
            return obj;
        }

        SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.MyBillsEntityDataFactory = consumer;
        }
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> MyBillsEntityDataFactory(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.BiFunction
        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(obj, (Emitter) obj2);
            return obj;
        }

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.MyBillsEntityDataFactory = biConsumer;
        }
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> getAuthRequestContext(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> getAuthRequestContext;

        ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.getAuthRequestContext = function;
        }

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new ObservableTake((ObservableSource) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(obj), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.PlaceComponentResult(obj)).defaultIfEmpty(obj);
        }
    }

    public static <T, U> Function<T, ObservableSource<T>> getAuthRequestContext(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ObserverOnNext<T> implements Consumer<T> {
        final Observer<T> getAuthRequestContext;

        ObserverOnNext(Observer<T> observer) {
            this.getAuthRequestContext = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) throws Exception {
            this.getAuthRequestContext.onNext(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ObserverOnError<T> implements Consumer<Throwable> {
        final Observer<T> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Throwable th) throws Exception {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        ObserverOnError(Observer<T> observer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ObserverOnComplete<T> implements Action {
        final Observer<T> KClassImpl$Data$declaredNonStaticMembers$2;

        ObserverOnComplete(Observer<T> observer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
        }

        @Override // io.reactivex.functions.Action
        public final void run() throws Exception {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }

    public static <T> Consumer<T> MyBillsEntityDataFactory(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Consumer<Throwable> PlaceComponentResult(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Action BuiltInFictitiousFunctionClassFactory(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    /* loaded from: classes6.dex */
    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> BuiltInFictitiousFunctionClassFactory;
        private final T KClassImpl$Data$declaredNonStaticMembers$2;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.BuiltInFictitiousFunctionClassFactory = biFunction;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
        }

        @Override // io.reactivex.functions.Function
        public final R apply(U u) throws Exception {
            return this.BuiltInFictitiousFunctionClassFactory.apply((T) this.KClassImpl$Data$declaredNonStaticMembers$2, u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final Function<? super T, ? extends ObservableSource<? extends U>> KClassImpl$Data$declaredNonStaticMembers$2;
        private final BiFunction<? super T, ? super U, ? extends R> getAuthRequestContext;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.getAuthRequestContext = biFunction;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
        }

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new ObservableMap((ObservableSource) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(obj), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.getAuthRequestContext, obj));
        }
    }

    public static <T, U, R> Function<T, ObservableSource<R>> getAuthRequestContext(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> KClassImpl$Data$declaredNonStaticMembers$2;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
        }

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new ObservableFromIterable((Iterable) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    public static <T, U> Function<T, ObservableSource<U>> MyBillsEntityDataFactory(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    /* loaded from: classes9.dex */
    enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    public static <T> Callable<ConnectableObservable<T>> BuiltInFictitiousFunctionClassFactory(Observable<T> observable) {
        return new ReplayCallable(observable);
    }

    public static <T> Callable<ConnectableObservable<T>> MyBillsEntityDataFactory(Observable<T> observable, int i) {
        return new BufferedReplayCallable(observable, i);
    }

    public static <T> Callable<ConnectableObservable<T>> MyBillsEntityDataFactory(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(observable, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> KClassImpl$Data$declaredNonStaticMembers$2(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, j, timeUnit, scheduler);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> PlaceComponentResult(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        private final Function<? super Object[], ? extends R> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return Observable.zipIterable((List) obj, this.KClassImpl$Data$declaredNonStaticMembers$2, false, Observable.bufferSize());
        }

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
        }
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> BuiltInFictitiousFunctionClassFactory(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> KClassImpl$Data$declaredNonStaticMembers$2;

        ReplayCallable(Observable<T> observable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observable;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> BuiltInFictitiousFunctionClassFactory;
        private final int getAuthRequestContext;

        BufferedReplayCallable(Observable<T> observable, int i) {
            this.BuiltInFictitiousFunctionClassFactory = observable;
            this.getAuthRequestContext = i;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            return this.BuiltInFictitiousFunctionClassFactory.replay(this.getAuthRequestContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Scheduler BuiltInFictitiousFunctionClassFactory;
        private final TimeUnit KClassImpl$Data$declaredNonStaticMembers$2;
        private final long MyBillsEntityDataFactory;
        private final Observable<T> PlaceComponentResult;
        private final int getAuthRequestContext;

        BufferedTimedReplayCallable(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.PlaceComponentResult = observable;
            this.getAuthRequestContext = i;
            this.MyBillsEntityDataFactory = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timeUnit;
            this.BuiltInFictitiousFunctionClassFactory = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            return this.PlaceComponentResult.replay(this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> BuiltInFictitiousFunctionClassFactory;
        private final long MyBillsEntityDataFactory;
        private final Scheduler PlaceComponentResult;
        private final TimeUnit getAuthRequestContext;

        TimedReplayCallable(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.BuiltInFictitiousFunctionClassFactory = observable;
            this.MyBillsEntityDataFactory = j;
            this.getAuthRequestContext = timeUnit;
            this.PlaceComponentResult = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            return this.BuiltInFictitiousFunctionClassFactory.replay(this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.PlaceComponentResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {
        private final Scheduler BuiltInFictitiousFunctionClassFactory;
        private final Function<? super Observable<T>, ? extends ObservableSource<R>> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return Observable.wrap((ObservableSource) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply((Observable) obj), "The selector returned a null ObservableSource")).observeOn(this.BuiltInFictitiousFunctionClassFactory);
        }

        ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
            this.BuiltInFictitiousFunctionClassFactory = scheduler;
        }
    }
}
