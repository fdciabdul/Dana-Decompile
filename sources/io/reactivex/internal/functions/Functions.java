package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
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
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes.dex */
public final class Functions {
    static final Function<Object, Object> NetworkUserEntityData$$ExternalSyntheticLambda0 = new Identity();
    public static final Runnable getErrorConfigVersion = new EmptyRunnable();
    public static final Action KClassImpl$Data$declaredNonStaticMembers$2 = new EmptyAction();
    static final Consumer<Object> MyBillsEntityDataFactory = new EmptyConsumer();
    public static final Consumer<Throwable> scheduleImpl = new ErrorConsumer();
    public static final Consumer<Throwable> DatabaseTableConfigUtil = new OnErrorMissingConsumer();
    public static final LongConsumer PlaceComponentResult = new EmptyLongConsumer();
    static final Predicate<Object> getAuthRequestContext = new TruePredicate();
    static final Predicate<Object> BuiltInFictitiousFunctionClassFactory = new FalsePredicate();
    static final Callable<Object> lookAheadTest = new NullCallable();
    static final Comparator<Object> moveToNextValue = new NaturalObjectComparator();
    public static final Consumer<Subscription> initRecordTimeStamp = new MaxRequestSubscription();

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T1, T2, R> Function<Object[], R> MyBillsEntityDataFactory(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.PlaceComponentResult(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static <T1, T2, T3, R> Function<Object[], R> BuiltInFictitiousFunctionClassFactory(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.PlaceComponentResult(function3, "f is null");
        return new Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> KClassImpl$Data$declaredNonStaticMembers$2(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.PlaceComponentResult(function4, "f is null");
        return new Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> getAuthRequestContext(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.PlaceComponentResult(function5, "f is null");
        return new Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> getAuthRequestContext(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.PlaceComponentResult(function6, "f is null");
        return new Array6Func(function6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> KClassImpl$Data$declaredNonStaticMembers$2(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.PlaceComponentResult(function7, "f is null");
        return new Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> MyBillsEntityDataFactory(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.PlaceComponentResult(function8, "f is null");
        return new Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> MyBillsEntityDataFactory(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.PlaceComponentResult(function9, "f is null");
        return new Array9Func(function9);
    }

    public static <T> Function<T, T> MyBillsEntityDataFactory() {
        return (Function<T, T>) NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public static <T> Consumer<T> PlaceComponentResult() {
        return (Consumer<T>) MyBillsEntityDataFactory;
    }

    public static <T> Predicate<T> BuiltInFictitiousFunctionClassFactory() {
        return (Predicate<T>) getAuthRequestContext;
    }

    public static <T> Predicate<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return (Predicate<T>) BuiltInFictitiousFunctionClassFactory;
    }

    public static <T> Callable<T> lookAheadTest() {
        return (Callable<T>) lookAheadTest;
    }

    public static <T> Comparator<T> scheduleImpl() {
        return (Comparator<T>) moveToNextValue;
    }

    /* loaded from: classes2.dex */
    public static final class FutureAction implements Action {
        final Future<?> BuiltInFictitiousFunctionClassFactory;

        FutureAction(Future<?> future) {
            this.BuiltInFictitiousFunctionClassFactory = future;
        }

        @Override // io.reactivex.functions.Action
        public final void run() throws Exception {
            this.BuiltInFictitiousFunctionClassFactory.get();
        }
    }

    public static Action KClassImpl$Data$declaredNonStaticMembers$2(Future<?> future) {
        return new FutureAction(future);
    }

    /* loaded from: classes2.dex */
    public static final class JustValue<T, U> implements Callable<U>, Function<T, U> {
        final U getAuthRequestContext;

        JustValue(U u) {
            this.getAuthRequestContext = u;
        }

        @Override // java.util.concurrent.Callable
        public final U call() throws Exception {
            return this.getAuthRequestContext;
        }

        @Override // io.reactivex.functions.Function
        public final U apply(T t) throws Exception {
            return this.getAuthRequestContext;
        }
    }

    public static <T> Callable<T> MyBillsEntityDataFactory(T t) {
        return new JustValue(t);
    }

    public static <T, U> Function<T, U> PlaceComponentResult(U u) {
        return new JustValue(u);
    }

    /* loaded from: classes2.dex */
    public static final class CastToClass<T, U> implements Function<T, U> {
        final Class<U> KClassImpl$Data$declaredNonStaticMembers$2;

        CastToClass(Class<U> cls) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cls;
        }

        @Override // io.reactivex.functions.Function
        public final U apply(T t) throws Exception {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.cast(t);
        }
    }

    public static <T, U> Function<T, U> PlaceComponentResult(Class<U> cls) {
        return new CastToClass(cls);
    }

    /* loaded from: classes2.dex */
    public static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {
        final int KClassImpl$Data$declaredNonStaticMembers$2;

        ArrayListCapacityCallable(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            return new ArrayList(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public static <T> Callable<List<T>> getAuthRequestContext(int i) {
        return new ArrayListCapacityCallable(i);
    }

    /* loaded from: classes2.dex */
    public static final class EqualsPredicate<T> implements Predicate<T> {
        final T BuiltInFictitiousFunctionClassFactory;

        EqualsPredicate(T t) {
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(T t) throws Exception {
            return ObjectHelper.getAuthRequestContext(t, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static <T> Predicate<T> KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        return new EqualsPredicate(t);
    }

    /* loaded from: classes2.dex */
    public enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public final Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    public static <T> Callable<Set<T>> getAuthRequestContext() {
        return HashSetCallable.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public static final class NotificationOnNext<T> implements Consumer<T> {
        final Consumer<? super Notification<T>> getAuthRequestContext;

        NotificationOnNext(Consumer<? super Notification<T>> consumer) {
            this.getAuthRequestContext = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) throws Exception {
            this.getAuthRequestContext.accept(Notification.BuiltInFictitiousFunctionClassFactory(t));
        }
    }

    /* loaded from: classes2.dex */
    public static final class NotificationOnError<T> implements Consumer<Throwable> {
        final Consumer<? super Notification<T>> MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Throwable th) throws Exception {
            this.MyBillsEntityDataFactory.accept(Notification.MyBillsEntityDataFactory(th));
        }

        NotificationOnError(Consumer<? super Notification<T>> consumer) {
            this.MyBillsEntityDataFactory = consumer;
        }
    }

    /* loaded from: classes2.dex */
    public static final class NotificationOnComplete<T> implements Action {
        final Consumer<? super Notification<T>> getAuthRequestContext;

        NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
            this.getAuthRequestContext = consumer;
        }

        @Override // io.reactivex.functions.Action
        public final void run() throws Exception {
            this.getAuthRequestContext.accept(Notification.MyBillsEntityDataFactory());
        }
    }

    public static <T> Consumer<T> PlaceComponentResult(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    public static <T> Consumer<Throwable> BuiltInFictitiousFunctionClassFactory(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Action KClassImpl$Data$declaredNonStaticMembers$2(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    /* loaded from: classes2.dex */
    public static final class ActionConsumer<T> implements Consumer<T> {
        final Action MyBillsEntityDataFactory;

        ActionConsumer(Action action) {
            this.MyBillsEntityDataFactory = action;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) throws Exception {
            this.MyBillsEntityDataFactory.run();
        }
    }

    public static <T> Consumer<T> BuiltInFictitiousFunctionClassFactory(Action action) {
        return new ActionConsumer(action);
    }

    /* loaded from: classes2.dex */
    public static final class ClassFilter<T, U> implements Predicate<T> {
        final Class<U> BuiltInFictitiousFunctionClassFactory;

        ClassFilter(Class<U> cls) {
            this.BuiltInFictitiousFunctionClassFactory = cls;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(T t) throws Exception {
            return this.BuiltInFictitiousFunctionClassFactory.isInstance(t);
        }
    }

    public static <T, U> Predicate<T> KClassImpl$Data$declaredNonStaticMembers$2(Class<U> cls) {
        return new ClassFilter(cls);
    }

    /* loaded from: classes2.dex */
    public static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {
        final BooleanSupplier MyBillsEntityDataFactory;

        BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.MyBillsEntityDataFactory = booleanSupplier;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(T t) throws Exception {
            return !this.MyBillsEntityDataFactory.getAsBoolean();
        }
    }

    public static <T> Predicate<T> MyBillsEntityDataFactory(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    /* loaded from: classes2.dex */
    public static final class TimestampFunction<T> implements Function<T, Timed<T>> {
        final Scheduler BuiltInFictitiousFunctionClassFactory;
        final TimeUnit MyBillsEntityDataFactory;

        TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.MyBillsEntityDataFactory = timeUnit;
            this.BuiltInFictitiousFunctionClassFactory = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new Timed(obj, this.BuiltInFictitiousFunctionClassFactory.now(this.MyBillsEntityDataFactory), this.MyBillsEntityDataFactory);
        }
    }

    public static <T> Function<T, Timed<T>> KClassImpl$Data$declaredNonStaticMembers$2(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    /* loaded from: classes2.dex */
    public static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {
        private final Function<? super T, ? extends K> PlaceComponentResult;

        @Override // io.reactivex.functions.BiConsumer
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Object obj, Object obj2) throws Exception {
            ((Map) obj).put(this.PlaceComponentResult.apply(obj2), obj2);
        }

        ToMapKeySelector(Function<? super T, ? extends K> function) {
            this.PlaceComponentResult = function;
        }
    }

    public static <T, K> BiConsumer<Map<K, T>, T> MyBillsEntityDataFactory(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    /* loaded from: classes2.dex */
    public static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {
        private final Function<? super T, ? extends K> PlaceComponentResult;
        private final Function<? super T, ? extends V> getAuthRequestContext;

        @Override // io.reactivex.functions.BiConsumer
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Object obj, Object obj2) throws Exception {
            ((Map) obj).put(this.PlaceComponentResult.apply(obj2), this.getAuthRequestContext.apply(obj2));
        }

        ToMapKeyValueSelector(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.getAuthRequestContext = function;
            this.PlaceComponentResult = function2;
        }
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> MyBillsEntityDataFactory(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    /* loaded from: classes2.dex */
    public static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {
        private final Function<? super T, ? extends V> BuiltInFictitiousFunctionClassFactory;
        private final Function<? super K, ? extends Collection<? super V>> MyBillsEntityDataFactory;
        private final Function<? super T, ? extends K> PlaceComponentResult;

        @Override // io.reactivex.functions.BiConsumer
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Object obj, Object obj2) throws Exception {
            Map map = (Map) obj;
            K apply = this.PlaceComponentResult.apply(obj2);
            Collection<? super V> collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = this.MyBillsEntityDataFactory.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.BuiltInFictitiousFunctionClassFactory.apply(obj2));
        }

        ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.MyBillsEntityDataFactory = function;
            this.BuiltInFictitiousFunctionClassFactory = function2;
            this.PlaceComponentResult = function3;
        }
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> getAuthRequestContext(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }

    /* loaded from: classes2.dex */
    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static <T> Comparator<T> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return NaturalComparator.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public static final class ListSorter<T> implements Function<List<T>, List<T>> {
        final Comparator<? super T> MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object obj) throws Exception {
            List list = (List) obj;
            Collections.sort(list, this.MyBillsEntityDataFactory);
            return list;
        }

        ListSorter(Comparator<? super T> comparator) {
            this.MyBillsEntityDataFactory = comparator;
        }
    }

    public static <T> Function<List<T>, List<T>> getAuthRequestContext(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    /* loaded from: classes2.dex */
    public static final class Array2Func<T1, T2, R> implements Function<Object[], R> {
        final BiFunction<? super T1, ? super T2, ? extends R> getAuthRequestContext;

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Array of size 2 expected but got ");
                sb.append(objArr2.length);
                throw new IllegalArgumentException(sb.toString());
            }
            return this.getAuthRequestContext.apply(objArr2[0], objArr2[1]);
        }

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.getAuthRequestContext = biFunction;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {
        final Function3<T1, T2, T3, R> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length != 3) {
                StringBuilder sb = new StringBuilder();
                sb.append("Array of size 3 expected but got ");
                sb.append(objArr2.length);
                throw new IllegalArgumentException(sb.toString());
            }
            return this.BuiltInFictitiousFunctionClassFactory.apply(objArr2[0], objArr2[1], objArr2[2]);
        }

        Array3Func(Function3<T1, T2, T3, R> function3) {
            this.BuiltInFictitiousFunctionClassFactory = function3;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {
        final Function4<T1, T2, T3, T4, R> getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Array of size 4 expected but got ");
                sb.append(objArr2.length);
                throw new IllegalArgumentException(sb.toString());
            }
            return this.getAuthRequestContext.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3]);
        }

        Array4Func(Function4<T1, T2, T3, T4, R> function4) {
            this.getAuthRequestContext = function4;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {
        private final Function5<T1, T2, T3, T4, T5, R> getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("Array of size 5 expected but got ");
                sb.append(objArr2.length);
                throw new IllegalArgumentException(sb.toString());
            }
            return this.getAuthRequestContext.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4]);
        }

        Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.getAuthRequestContext = function5;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {
        final Function6<T1, T2, T3, T4, T5, T6, R> MyBillsEntityDataFactory;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length != 6) {
                StringBuilder sb = new StringBuilder();
                sb.append("Array of size 6 expected but got ");
                sb.append(objArr2.length);
                throw new IllegalArgumentException(sb.toString());
            }
            return this.MyBillsEntityDataFactory.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5]);
        }

        Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.MyBillsEntityDataFactory = function6;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {
        final Function7<T1, T2, T3, T4, T5, T6, T7, R> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length != 7) {
                StringBuilder sb = new StringBuilder();
                sb.append("Array of size 7 expected but got ");
                sb.append(objArr2.length);
                throw new IllegalArgumentException(sb.toString());
            }
            return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6]);
        }

        Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.BuiltInFictitiousFunctionClassFactory = function7;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {
        final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length != 8) {
                StringBuilder sb = new StringBuilder();
                sb.append("Array of size 8 expected but got ");
                sb.append(objArr2.length);
                throw new IllegalArgumentException(sb.toString());
            }
            return this.BuiltInFictitiousFunctionClassFactory.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6], objArr2[7]);
        }

        Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.BuiltInFictitiousFunctionClassFactory = function8;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {
        final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> MyBillsEntityDataFactory;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object[] objArr) throws Exception {
            Object[] objArr2 = objArr;
            if (objArr2.length != 9) {
                StringBuilder sb = new StringBuilder();
                sb.append("Array of size 9 expected but got ");
                sb.append(objArr2.length);
                throw new IllegalArgumentException(sb.toString());
            }
            return this.MyBillsEntityDataFactory.apply(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6], objArr2[7], objArr2[8]);
        }

        Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.MyBillsEntityDataFactory = function9;
        }
    }

    /* loaded from: classes.dex */
    static final class Identity implements Function<Object, Object> {
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return obj;
        }

        public final String toString() {
            return "IdentityFunction";
        }

        Identity() {
        }
    }

    /* loaded from: classes.dex */
    static final class EmptyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }

        public final String toString() {
            return "EmptyRunnable";
        }

        EmptyRunnable() {
        }
    }

    /* loaded from: classes.dex */
    static final class EmptyAction implements Action {
        @Override // io.reactivex.functions.Action
        public final void run() {
        }

        public final String toString() {
            return "EmptyAction";
        }

        EmptyAction() {
        }
    }

    /* loaded from: classes.dex */
    static final class EmptyConsumer implements Consumer<Object> {
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object obj) {
        }

        public final String toString() {
            return "EmptyConsumer";
        }

        EmptyConsumer() {
        }
    }

    /* loaded from: classes.dex */
    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Throwable th) throws Exception {
            RxJavaPlugins.PlaceComponentResult(th);
        }
    }

    /* loaded from: classes.dex */
    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Throwable th) throws Exception {
            RxJavaPlugins.PlaceComponentResult(new OnErrorNotImplementedException(th));
        }
    }

    /* loaded from: classes.dex */
    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }
    }

    /* loaded from: classes.dex */
    static final class TruePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object obj) {
            return true;
        }

        TruePredicate() {
        }
    }

    /* loaded from: classes.dex */
    static final class FalsePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object obj) {
            return false;
        }

        FalsePredicate() {
        }
    }

    /* loaded from: classes.dex */
    static final class NullCallable implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return null;
        }

        NullCallable() {
        }
    }

    /* loaded from: classes.dex */
    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes.dex */
    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Subscription subscription) throws Exception {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    /* loaded from: classes2.dex */
    public static class BoundedConsumer implements Consumer<Subscription> {
        final int MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.Consumer
        public /* synthetic */ void accept(Subscription subscription) throws Exception {
            subscription.request(this.MyBillsEntityDataFactory);
        }
    }
}
