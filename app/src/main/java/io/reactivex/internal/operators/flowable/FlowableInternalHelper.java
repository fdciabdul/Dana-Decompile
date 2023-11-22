package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes6.dex */
public final class FlowableInternalHelper {
    private FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    /* loaded from: classes9.dex */
    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.BiFunction
        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            this.MyBillsEntityDataFactory.accept((Emitter) obj2);
            return obj;
        }
    }

    /* loaded from: classes9.dex */
    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> getAuthRequestContext;

        @Override // io.reactivex.functions.BiFunction
        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(obj, (Emitter) obj2);
            return obj;
        }
    }

    /* loaded from: classes9.dex */
    static final class SubscriberOnNext<T> implements Consumer<T> {
        final Subscriber<T> BuiltInFictitiousFunctionClassFactory;

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) throws Exception {
            this.BuiltInFictitiousFunctionClassFactory.onNext(t);
        }
    }

    /* loaded from: classes9.dex */
    static final class SubscriberOnError<T> implements Consumer<Throwable> {
        final Subscriber<T> PlaceComponentResult;

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Throwable th) throws Exception {
            this.PlaceComponentResult.onError(th);
        }
    }

    /* loaded from: classes9.dex */
    static final class SubscriberOnComplete<T> implements Action {
        final Subscriber<T> BuiltInFictitiousFunctionClassFactory;

        @Override // io.reactivex.functions.Action
        public final void run() throws Exception {
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final T BuiltInFictitiousFunctionClassFactory;
        private final BiFunction<? super T, ? super U, ? extends R> MyBillsEntityDataFactory;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.MyBillsEntityDataFactory = biFunction;
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // io.reactivex.functions.Function
        public final R apply(U u) throws Exception {
            return this.MyBillsEntityDataFactory.apply((T) this.BuiltInFictitiousFunctionClassFactory, u);
        }
    }

    /* loaded from: classes6.dex */
    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Subscription subscription) throws Exception {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    /* loaded from: classes9.dex */
    static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        private final Function<? super Object[], ? extends R> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return Flowable.BuiltInFictitiousFunctionClassFactory((List) obj, this.KClassImpl$Data$declaredNonStaticMembers$2, Flowable.BuiltInFictitiousFunctionClassFactory());
        }
    }

    /* loaded from: classes9.dex */
    static final class ReplayFunction<T, R> implements Function<Flowable<T>, Publisher<R>> {
        private final Scheduler MyBillsEntityDataFactory;
        private final Function<? super Flowable<T>, ? extends Publisher<R>> PlaceComponentResult;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            Flowable PlaceComponentResult = Flowable.PlaceComponentResult((Publisher) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply((Flowable) obj), "The selector returned a null Publisher"));
            Scheduler scheduler = this.MyBillsEntityDataFactory;
            int BuiltInFictitiousFunctionClassFactory = Flowable.BuiltInFictitiousFunctionClassFactory();
            ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
            ObjectHelper.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "bufferSize");
            return RxJavaPlugins.getAuthRequestContext(new FlowableObserveOn(PlaceComponentResult, scheduler, BuiltInFictitiousFunctionClassFactory));
        }
    }

    /* loaded from: classes9.dex */
    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> KClassImpl$Data$declaredNonStaticMembers$2;
        private final Function<? super T, ? extends Publisher<? extends U>> getAuthRequestContext;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new FlowableMapPublisher((Publisher) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(obj), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.KClassImpl$Data$declaredNonStaticMembers$2, obj));
        }
    }

    /* loaded from: classes9.dex */
    static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new FlowableFromIterable((Iterable) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    /* loaded from: classes9.dex */
    static final class ReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            return FlowableReplay.PlaceComponentResult((Flowable) this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferedReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final Flowable<T> PlaceComponentResult;

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            Flowable<T> flowable = this.PlaceComponentResult;
            int i = this.BuiltInFictitiousFunctionClassFactory;
            ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
            return FlowableReplay.PlaceComponentResult(flowable, i);
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferedTimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final long KClassImpl$Data$declaredNonStaticMembers$2;
        private final Flowable<T> MyBillsEntityDataFactory;
        private final Scheduler PlaceComponentResult;
        private final TimeUnit getAuthRequestContext;

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            Flowable<T> flowable = this.MyBillsEntityDataFactory;
            int i = this.BuiltInFictitiousFunctionClassFactory;
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            TimeUnit timeUnit = this.getAuthRequestContext;
            Scheduler scheduler = this.PlaceComponentResult;
            ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
            ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
            ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
            ObjectHelper.BuiltInFictitiousFunctionClassFactory(i, "bufferSize");
            return FlowableReplay.MyBillsEntityDataFactory(flowable, j, timeUnit, scheduler, i);
        }
    }

    /* loaded from: classes9.dex */
    static final class TimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2;
        private final long MyBillsEntityDataFactory;
        private final Scheduler PlaceComponentResult;
        private final TimeUnit getAuthRequestContext;

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            Flowable<T> flowable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            long j = this.MyBillsEntityDataFactory;
            TimeUnit timeUnit = this.getAuthRequestContext;
            Scheduler scheduler = this.PlaceComponentResult;
            ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
            ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
            return FlowableReplay.MyBillsEntityDataFactory(flowable, j, timeUnit, scheduler);
        }
    }

    /* loaded from: classes9.dex */
    static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {
        final Function<? super T, ? extends Publisher<U>> MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            FlowableTakePublisher flowableTakePublisher = new FlowableTakePublisher((Publisher) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.apply(obj), "The itemDelay returned a null Publisher"));
            Function PlaceComponentResult = Functions.PlaceComponentResult(obj);
            ObjectHelper.PlaceComponentResult(PlaceComponentResult, "mapper is null");
            Flowable authRequestContext = RxJavaPlugins.getAuthRequestContext(new FlowableMap(flowableTakePublisher, PlaceComponentResult));
            ObjectHelper.PlaceComponentResult(obj, "defaultItem is null");
            Flowable KClassImpl$Data$declaredNonStaticMembers$2 = Flowable.KClassImpl$Data$declaredNonStaticMembers$2(obj);
            ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "other is null");
            return RxJavaPlugins.getAuthRequestContext(new FlowableSwitchIfEmpty(authRequestContext, KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }
}
