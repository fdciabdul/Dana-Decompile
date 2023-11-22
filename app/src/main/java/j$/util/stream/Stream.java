package j$.util.stream;

import j$.util.DesugarArrays;
import j$.util.Objects;
import j$.util.Optional;
import j$.util.OptionalConversions;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.BaseStream;
import j$.util.stream.Collector;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public interface Stream<T> extends BaseStream {
    Optional BuiltInFictitiousFunctionClassFactory(BinaryOperator binaryOperator);

    Optional BuiltInFictitiousFunctionClassFactory(Comparator comparator);

    DoubleStream BuiltInFictitiousFunctionClassFactory(Function function);

    <R, A> R BuiltInFictitiousFunctionClassFactory(Collector<? super T, A, R> collector);

    void BuiltInFictitiousFunctionClassFactory(Consumer consumer);

    Object[] BuiltInFictitiousFunctionClassFactory(IntFunction intFunction);

    @Override // j$.util.stream.BaseStream
    /* synthetic */ Iterator<T> DatabaseTableConfigUtil();

    long GetContactSyncConfig();

    IntStream KClassImpl$Data$declaredNonStaticMembers$2(ToIntFunction toIntFunction);

    Stream KClassImpl$Data$declaredNonStaticMembers$2(long j);

    <R> Stream<R> KClassImpl$Data$declaredNonStaticMembers$2(Function<? super T, ? extends R> function);

    Stream<T> KClassImpl$Data$declaredNonStaticMembers$2(Comparator<? super T> comparator);

    boolean KClassImpl$Data$declaredNonStaticMembers$2(Predicate predicate);

    DoubleStream MyBillsEntityDataFactory(ToDoubleFunction<? super T> toDoubleFunction);

    LongStream MyBillsEntityDataFactory(Function function);

    Object MyBillsEntityDataFactory(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2);

    <U> U MyBillsEntityDataFactory(U u, BiFunction<U, ? super T, U> biFunction, BinaryOperator<U> binaryOperator);

    boolean MyBillsEntityDataFactory(Predicate<? super T> predicate);

    Optional<T> NetworkUserEntityData$$ExternalSyntheticLambda7();

    Stream NetworkUserEntityData$$ExternalSyntheticLambda8();

    IntStream PlaceComponentResult(Function function);

    LongStream PlaceComponentResult(ToLongFunction toLongFunction);

    void PlaceComponentResult(Consumer<? super T> consumer);

    boolean PlaceComponentResult(Predicate predicate);

    Optional getAuthRequestContext(Comparator comparator);

    Stream<T> getAuthRequestContext(long j);

    Stream getAuthRequestContext(Consumer consumer);

    <R> Stream<R> getAuthRequestContext(Function<? super T, ? extends Stream<? extends R>> function);

    Stream<T> getAuthRequestContext(Predicate<? super T> predicate);

    T getAuthRequestContext(T t, BinaryOperator<T> binaryOperator);

    Stream initRecordTimeStamp();

    Optional isLayoutRequested();

    Object[] newProxyInstance();

    /* renamed from: j$.util.stream.Stream$-CC */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC<T> {
        public static <T> Stream<T> MyBillsEntityDataFactory(T t) {
            return StreamSupport.PlaceComponentResult(new Streams$StreamBuilderImpl(t), false);
        }

        public static <T> Stream<T> getAuthRequestContext(T... tArr) {
            return DesugarArrays.MyBillsEntityDataFactory(tArr);
        }

        public static <T> Stream<T> getAuthRequestContext(Stream<? extends T> stream, Stream<? extends T> stream2) {
            int i = 0;
            int i2 = 1;
            Stream PlaceComponentResult = StreamSupport.PlaceComponentResult(new Spliterator(stream.NetworkUserEntityData$$ExternalSyntheticLambda2(), stream2.NetworkUserEntityData$$ExternalSyntheticLambda2()) { // from class: j$.util.stream.Streams$ConcatSpliterator$OfRef
                final boolean BuiltInFictitiousFunctionClassFactory;
                boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
                protected final Spliterator MyBillsEntityDataFactory;
                protected final Spliterator PlaceComponentResult;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.PlaceComponentResult = r5;
                    this.MyBillsEntityDataFactory = r6;
                    this.BuiltInFictitiousFunctionClassFactory = r6.KClassImpl$Data$declaredNonStaticMembers$2() + r5.KClassImpl$Data$declaredNonStaticMembers$2() < 0;
                }

                @Override // j$.util.Spliterator
                public final int BuiltInFictitiousFunctionClassFactory() {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() & this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory() & (((this.BuiltInFictitiousFunctionClassFactory ? 16448 : 0) | 5) ^ (-1));
                    }
                    return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // j$.util.Spliterator
                public final long KClassImpl$Data$declaredNonStaticMembers$2() {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        long KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2() + this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
                        return KClassImpl$Data$declaredNonStaticMembers$2 < 0 ? LongCompanionObject.MAX_VALUE : KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                    return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // j$.util.Spliterator
                public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i3) {
                    return Objects.BuiltInFictitiousFunctionClassFactory(this, i3);
                }

                @Override // j$.util.Spliterator
                public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        boolean KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(consumer);
                        if (KClassImpl$Data$declaredNonStaticMembers$2) {
                            return KClassImpl$Data$declaredNonStaticMembers$2;
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    }
                    return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(consumer);
                }

                @Override // j$.util.Spliterator
                /* renamed from: MyBillsEntityDataFactory */
                public final Spliterator moveToNextValue() {
                    Spliterator moveToNextValue = this.KClassImpl$Data$declaredNonStaticMembers$2 ? this.PlaceComponentResult : this.MyBillsEntityDataFactory.moveToNextValue();
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    return moveToNextValue;
                }

                @Override // j$.util.Spliterator
                public final /* synthetic */ long PlaceComponentResult() {
                    return Objects.getAuthRequestContext(this);
                }

                @Override // j$.util.Spliterator
                public final Comparator getAuthRequestContext() {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        throw new IllegalStateException();
                    }
                    return this.MyBillsEntityDataFactory.getAuthRequestContext();
                }

                @Override // j$.util.Spliterator
                public final void getAuthRequestContext(Consumer consumer) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        this.PlaceComponentResult.getAuthRequestContext(consumer);
                    }
                    this.MyBillsEntityDataFactory.getAuthRequestContext(consumer);
                }
            }, stream.MyBillsEntityDataFactory() || stream2.MyBillsEntityDataFactory());
            Streams$1 streams$1 = new Streams$1(i2, stream, stream2);
            AbstractPipeline abstractPipeline = (AbstractPipeline) PlaceComponentResult;
            AbstractPipeline abstractPipeline2 = abstractPipeline.KClassImpl$Data$declaredNonStaticMembers$2;
            Runnable runnable = abstractPipeline2.PlaceComponentResult;
            if (runnable != null) {
                streams$1 = new Streams$1(i, runnable, streams$1);
            }
            abstractPipeline2.PlaceComponentResult = streams$1;
            return (Stream) abstractPipeline;
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements Stream {
        final /* synthetic */ java.util.stream.Stream KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.stream.Stream stream) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = stream;
        }

        public static /* synthetic */ Stream KClassImpl$Data$declaredNonStaticMembers$2(java.util.stream.Stream stream) {
            if (stream == null) {
                return null;
            }
            return stream instanceof Wrapper ? Stream.this : new VivifiedWrapper(stream);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Optional BuiltInFictitiousFunctionClassFactory(BinaryOperator binaryOperator) {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.reduce(BinaryOperator.Wrapper.BuiltInFictitiousFunctionClassFactory(binaryOperator)));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Optional BuiltInFictitiousFunctionClassFactory(Comparator comparator) {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.min(comparator));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ DoubleStream BuiltInFictitiousFunctionClassFactory(Function function) {
            return DoubleStream.VivifiedWrapper.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.flatMapToDouble(Function.Wrapper.getAuthRequestContext(function)));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Object BuiltInFictitiousFunctionClassFactory(Collector collector) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.collect(Collector.Wrapper.MyBillsEntityDataFactory(collector));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Consumer consumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.forEachOrdered(Consumer.Wrapper.PlaceComponentResult(consumer));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Object[] BuiltInFictitiousFunctionClassFactory(IntFunction intFunction) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.toArray(IntFunction.Wrapper.getAuthRequestContext(intFunction));
        }

        @Override // j$.util.stream.Stream, j$.util.stream.BaseStream
        public final /* synthetic */ Iterator DatabaseTableConfigUtil() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ long GetContactSyncConfig() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.count();
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ IntStream KClassImpl$Data$declaredNonStaticMembers$2(ToIntFunction toIntFunction) {
            return IntStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToInt(ToIntFunction.Wrapper.BuiltInFictitiousFunctionClassFactory(toIntFunction)));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Predicate predicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.allMatch(Predicate.Wrapper.MyBillsEntityDataFactory(predicate));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ DoubleStream MyBillsEntityDataFactory(ToDoubleFunction toDoubleFunction) {
            return DoubleStream.VivifiedWrapper.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToDouble(ToDoubleFunction.Wrapper.BuiltInFictitiousFunctionClassFactory(toDoubleFunction)));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ LongStream MyBillsEntityDataFactory(Function function) {
            return LongStream.VivifiedWrapper.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.flatMapToLong(Function.Wrapper.getAuthRequestContext(function)));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Object MyBillsEntityDataFactory(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.collect(Supplier.Wrapper.BuiltInFictitiousFunctionClassFactory(supplier), BiConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(biConsumer), BiConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(biConsumer2));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Object MyBillsEntityDataFactory(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.reduce(obj, BiFunction.Wrapper.getAuthRequestContext(biFunction), BinaryOperator.Wrapper.BuiltInFictitiousFunctionClassFactory(binaryOperator));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ boolean MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isParallel();
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ boolean MyBillsEntityDataFactory(Predicate predicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.anyMatch(Predicate.Wrapper.MyBillsEntityDataFactory(predicate));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.unordered());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
            return Spliterator.VivifiedWrapper.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.spliterator());
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Optional NetworkUserEntityData$$ExternalSyntheticLambda7() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.findAny());
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ IntStream PlaceComponentResult(Function function) {
            return IntStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.flatMapToInt(Function.Wrapper.getAuthRequestContext(function)));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ LongStream PlaceComponentResult(ToLongFunction toLongFunction) {
            return LongStream.VivifiedWrapper.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToLong(ToLongFunction.Wrapper.PlaceComponentResult(toLongFunction)));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ void PlaceComponentResult(Consumer consumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.forEach(Consumer.Wrapper.PlaceComponentResult(consumer));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ boolean PlaceComponentResult(Predicate predicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.noneMatch(Predicate.Wrapper.MyBillsEntityDataFactory(predicate));
        }

        @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.close();
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Optional getAuthRequestContext(Comparator comparator) {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.max(comparator));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream getAuthRequestContext(Runnable runnable) {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.onClose(runnable));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Object getAuthRequestContext(Object obj, BinaryOperator binaryOperator) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.reduce(obj, BinaryOperator.Wrapper.BuiltInFictitiousFunctionClassFactory(binaryOperator));
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Optional isLayoutRequested() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.findFirst());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream moveToNextValue() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.parallel());
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Object[] newProxyInstance() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.toArray();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream scheduleImpl() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.sequential());
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream initRecordTimeStamp() {
            java.util.stream.Stream<T> distinct = this.KClassImpl$Data$declaredNonStaticMembers$2.distinct();
            if (distinct == null) {
                return null;
            }
            return distinct instanceof Wrapper ? Stream.this : new VivifiedWrapper(distinct);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream getAuthRequestContext(Predicate predicate) {
            java.util.stream.Stream<T> filter = this.KClassImpl$Data$declaredNonStaticMembers$2.filter(Predicate.Wrapper.MyBillsEntityDataFactory(predicate));
            if (filter == null) {
                return null;
            }
            return filter instanceof Wrapper ? Stream.this : new VivifiedWrapper(filter);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream getAuthRequestContext(Function function) {
            java.util.stream.Stream flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.flatMap(Function.Wrapper.getAuthRequestContext(function));
            if (flatMap == null) {
                return null;
            }
            return flatMap instanceof Wrapper ? Stream.this : new VivifiedWrapper(flatMap);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream KClassImpl$Data$declaredNonStaticMembers$2(long j) {
            java.util.stream.Stream<T> limit = this.KClassImpl$Data$declaredNonStaticMembers$2.limit(j);
            if (limit == null) {
                return null;
            }
            return limit instanceof Wrapper ? Stream.this : new VivifiedWrapper(limit);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream KClassImpl$Data$declaredNonStaticMembers$2(Function function) {
            java.util.stream.Stream map = this.KClassImpl$Data$declaredNonStaticMembers$2.map(Function.Wrapper.getAuthRequestContext(function));
            if (map == null) {
                return null;
            }
            return map instanceof Wrapper ? Stream.this : new VivifiedWrapper(map);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream getAuthRequestContext(Consumer consumer) {
            java.util.stream.Stream<T> peek = this.KClassImpl$Data$declaredNonStaticMembers$2.peek(Consumer.Wrapper.PlaceComponentResult(consumer));
            if (peek == null) {
                return null;
            }
            return peek instanceof Wrapper ? Stream.this : new VivifiedWrapper(peek);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream getAuthRequestContext(long j) {
            java.util.stream.Stream<T> skip = this.KClassImpl$Data$declaredNonStaticMembers$2.skip(j);
            if (skip == null) {
                return null;
            }
            return skip instanceof Wrapper ? Stream.this : new VivifiedWrapper(skip);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream NetworkUserEntityData$$ExternalSyntheticLambda8() {
            java.util.stream.Stream<T> sorted = this.KClassImpl$Data$declaredNonStaticMembers$2.sorted();
            if (sorted == null) {
                return null;
            }
            return sorted instanceof Wrapper ? Stream.this : new VivifiedWrapper(sorted);
        }

        @Override // j$.util.stream.Stream
        public final /* synthetic */ Stream KClassImpl$Data$declaredNonStaticMembers$2(Comparator comparator) {
            java.util.stream.Stream<T> sorted = this.KClassImpl$Data$declaredNonStaticMembers$2.sorted(comparator);
            if (sorted == null) {
                return null;
            }
            return sorted instanceof Wrapper ? Stream.this : new VivifiedWrapper(sorted);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.Stream {
        private /* synthetic */ Wrapper() {
            Stream.this = r1;
        }

        public static /* synthetic */ java.util.stream.Stream MyBillsEntityDataFactory(Stream stream) {
            if (stream == null) {
                return null;
            }
            return stream instanceof VivifiedWrapper ? ((VivifiedWrapper) stream).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ boolean allMatch(java.util.function.Predicate predicate) {
            return Stream.this.KClassImpl$Data$declaredNonStaticMembers$2(Predicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ boolean anyMatch(java.util.function.Predicate predicate) {
            return Stream.this.MyBillsEntityDataFactory(Predicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            Stream.this.close();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ Object collect(java.util.function.Supplier supplier, java.util.function.BiConsumer biConsumer, java.util.function.BiConsumer biConsumer2) {
            return Stream.this.MyBillsEntityDataFactory(Supplier.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(supplier), BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer), BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer2));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ Object collect(java.util.stream.Collector collector) {
            return Stream.this.BuiltInFictitiousFunctionClassFactory(Collector.VivifiedWrapper.PlaceComponentResult(collector));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ long count() {
            return Stream.this.GetContactSyncConfig();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.Optional findAny() {
            return OptionalConversions.MyBillsEntityDataFactory(Stream.this.NetworkUserEntityData$$ExternalSyntheticLambda7());
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.Optional findFirst() {
            return OptionalConversions.MyBillsEntityDataFactory(Stream.this.isLayoutRequested());
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.DoubleStream flatMapToDouble(java.util.function.Function function) {
            return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(Stream.this.BuiltInFictitiousFunctionClassFactory(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function)));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.IntStream flatMapToInt(java.util.function.Function function) {
            return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(Stream.this.PlaceComponentResult(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function)));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.LongStream flatMapToLong(java.util.function.Function function) {
            return LongStream.Wrapper.MyBillsEntityDataFactory(Stream.this.MyBillsEntityDataFactory(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function)));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            Stream.this.PlaceComponentResult(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ void forEachOrdered(java.util.function.Consumer consumer) {
            Stream.this.BuiltInFictitiousFunctionClassFactory(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ boolean isParallel() {
            return Stream.this.MyBillsEntityDataFactory();
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ Iterator iterator() {
            return Stream.this.DatabaseTableConfigUtil();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.DoubleStream mapToDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
            return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(Stream.this.MyBillsEntityDataFactory(ToDoubleFunction.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(toDoubleFunction)));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.IntStream mapToInt(java.util.function.ToIntFunction toIntFunction) {
            return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(Stream.this.KClassImpl$Data$declaredNonStaticMembers$2(ToIntFunction.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(toIntFunction)));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.LongStream mapToLong(java.util.function.ToLongFunction toLongFunction) {
            return LongStream.Wrapper.MyBillsEntityDataFactory(Stream.this.PlaceComponentResult(ToLongFunction.VivifiedWrapper.MyBillsEntityDataFactory(toLongFunction)));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.Optional max(Comparator comparator) {
            return OptionalConversions.MyBillsEntityDataFactory(Stream.this.getAuthRequestContext(comparator));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.Optional min(Comparator comparator) {
            return OptionalConversions.MyBillsEntityDataFactory(Stream.this.BuiltInFictitiousFunctionClassFactory(comparator));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ boolean noneMatch(java.util.function.Predicate predicate) {
            return Stream.this.PlaceComponentResult(Predicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(Stream.this.getAuthRequestContext(runnable));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.BaseStream parallel() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(Stream.this.moveToNextValue());
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ Object reduce(Object obj, java.util.function.BiFunction biFunction, java.util.function.BinaryOperator binaryOperator) {
            return Stream.this.MyBillsEntityDataFactory((Stream) obj, (BiFunction<Stream, ? super T, Stream>) BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction), (BinaryOperator<Stream>) BinaryOperator.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(binaryOperator));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ Object reduce(Object obj, java.util.function.BinaryOperator binaryOperator) {
            return Stream.this.getAuthRequestContext(obj, BinaryOperator.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(binaryOperator));
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.Optional reduce(java.util.function.BinaryOperator binaryOperator) {
            return OptionalConversions.MyBillsEntityDataFactory(Stream.this.BuiltInFictitiousFunctionClassFactory(BinaryOperator.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(binaryOperator)));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.BaseStream sequential() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(Stream.this.scheduleImpl());
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(Stream.this.NetworkUserEntityData$$ExternalSyntheticLambda2());
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ Object[] toArray() {
            return Stream.this.newProxyInstance();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return Stream.this.BuiltInFictitiousFunctionClassFactory(IntFunction.VivifiedWrapper.MyBillsEntityDataFactory(intFunction));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.BaseStream unordered() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(Stream.this.NetworkUserEntityData$$ExternalSyntheticLambda1());
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream distinct() {
            Stream initRecordTimeStamp = Stream.this.initRecordTimeStamp();
            if (initRecordTimeStamp == null) {
                return null;
            }
            return initRecordTimeStamp instanceof VivifiedWrapper ? ((VivifiedWrapper) initRecordTimeStamp).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream filter(java.util.function.Predicate predicate) {
            Stream<T> authRequestContext = Stream.this.getAuthRequestContext(Predicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream flatMap(java.util.function.Function function) {
            Stream authRequestContext = Stream.this.getAuthRequestContext(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream limit(long j) {
            Stream KClassImpl$Data$declaredNonStaticMembers$2 = Stream.this.KClassImpl$Data$declaredNonStaticMembers$2(j);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream map(java.util.function.Function function) {
            Stream KClassImpl$Data$declaredNonStaticMembers$2 = Stream.this.KClassImpl$Data$declaredNonStaticMembers$2(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream peek(java.util.function.Consumer consumer) {
            Stream authRequestContext = Stream.this.getAuthRequestContext(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream skip(long j) {
            Stream<T> authRequestContext = Stream.this.getAuthRequestContext(j);
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream sorted() {
            Stream NetworkUserEntityData$$ExternalSyntheticLambda8 = Stream.this.NetworkUserEntityData$$ExternalSyntheticLambda8();
            if (NetworkUserEntityData$$ExternalSyntheticLambda8 == null) {
                return null;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda8 instanceof VivifiedWrapper ? ((VivifiedWrapper) NetworkUserEntityData$$ExternalSyntheticLambda8).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.Stream
        public final /* synthetic */ java.util.stream.Stream sorted(Comparator comparator) {
            Stream<T> KClassImpl$Data$declaredNonStaticMembers$2 = Stream.this.KClassImpl$Data$declaredNonStaticMembers$2(comparator);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }
    }
}
