package j$.util.stream;

import j$.util.IntSummaryStatistics;
import j$.util.OptionalConversions;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.IntBinaryOperator;
import j$.util.function.IntConsumer;
import j$.util.function.IntFunction;
import j$.util.function.IntPredicate;
import j$.util.function.IntToDoubleFunction;
import j$.util.function.IntToLongFunction;
import j$.util.function.IntUnaryOperator;
import j$.util.function.ObjIntConsumer;
import j$.util.function.Supplier;
import j$.util.stream.BaseStream;
import j$.util.stream.DoubleStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;

/* loaded from: classes.dex */
public interface IntStream extends BaseStream {
    IntStream B();

    IntStream BuiltInFictitiousFunctionClassFactory(IntFunction intFunction);

    LongStream BuiltInFictitiousFunctionClassFactory(IntToLongFunction intToLongFunction);

    void BuiltInFictitiousFunctionClassFactory(IntConsumer intConsumer);

    boolean BuiltInFictitiousFunctionClassFactory(IntPredicate intPredicate);

    OptionalInt FragmentBottomSheetPaymentSettingBinding();

    LongStream GetContactSyncConfig();

    int KClassImpl$Data$declaredNonStaticMembers$2(int i, IntBinaryOperator intBinaryOperator);

    OptionalInt KClassImpl$Data$declaredNonStaticMembers$2(IntBinaryOperator intBinaryOperator);

    void KClassImpl$Data$declaredNonStaticMembers$2(IntConsumer intConsumer);

    boolean KClassImpl$Data$declaredNonStaticMembers$2(IntPredicate intPredicate);

    IntStream MyBillsEntityDataFactory(long j);

    OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda3();

    OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda4();

    IntStream NetworkUserEntityData$$ExternalSyntheticLambda5();

    PrimitiveIterator.OfInt NetworkUserEntityData$$ExternalSyntheticLambda6();

    OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda7();

    Stream NetworkUserEntityData$$ExternalSyntheticLambda8();

    DoubleStream PlaceComponentResult(IntToDoubleFunction intToDoubleFunction);

    IntStream PlaceComponentResult(IntConsumer intConsumer);

    IntStream PlaceComponentResult(IntPredicate intPredicate);

    Stream PlaceComponentResult(IntFunction intFunction);

    OptionalDouble PrepareContext();

    IntSummaryStatistics SubSequence();

    IntStream getAuthRequestContext(long j);

    IntStream getAuthRequestContext(IntUnaryOperator intUnaryOperator);

    Object getAuthRequestContext(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer);

    boolean getAuthRequestContext(IntPredicate intPredicate);

    int[] getCallingPid();

    Spliterator.OfInt getSupportButtonTintMode();

    DoubleStream initRecordTimeStamp();

    long isLayoutRequested();

    IntStream newProxyInstance();

    IntStream readMicros();

    int whenAvailable();

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntStream {
        final /* synthetic */ java.util.stream.IntStream getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.stream.IntStream intStream) {
            this.getAuthRequestContext = intStream;
        }

        public static /* synthetic */ IntStream KClassImpl$Data$declaredNonStaticMembers$2(java.util.stream.IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof Wrapper ? IntStream.this : new VivifiedWrapper(intStream);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ LongStream BuiltInFictitiousFunctionClassFactory(IntToLongFunction intToLongFunction) {
            return LongStream.VivifiedWrapper.MyBillsEntityDataFactory(this.getAuthRequestContext.mapToLong(IntToLongFunction.Wrapper.BuiltInFictitiousFunctionClassFactory(intToLongFunction)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(IntConsumer intConsumer) {
            this.getAuthRequestContext.forEachOrdered(IntConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(IntPredicate intPredicate) {
            return this.getAuthRequestContext.allMatch(IntPredicate.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Iterator DatabaseTableConfigUtil() {
            return this.getAuthRequestContext.iterator();
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ OptionalInt FragmentBottomSheetPaymentSettingBinding() {
            return OptionalConversions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.min());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ LongStream GetContactSyncConfig() {
            return LongStream.VivifiedWrapper.MyBillsEntityDataFactory(this.getAuthRequestContext.asLongStream());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(int i, IntBinaryOperator intBinaryOperator) {
            return this.getAuthRequestContext.reduce(i, IntBinaryOperator.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intBinaryOperator));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ OptionalInt KClassImpl$Data$declaredNonStaticMembers$2(IntBinaryOperator intBinaryOperator) {
            return OptionalConversions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.reduce(IntBinaryOperator.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intBinaryOperator)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(IntConsumer intConsumer) {
            this.getAuthRequestContext.forEach(IntConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(IntPredicate intPredicate) {
            return this.getAuthRequestContext.noneMatch(IntPredicate.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ boolean MyBillsEntityDataFactory() {
            return this.getAuthRequestContext.isParallel();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.unordered());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
            return Spliterator.VivifiedWrapper.getAuthRequestContext(this.getAuthRequestContext.spliterator());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda3() {
            return OptionalConversions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.findFirst());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda4() {
            return OptionalConversions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.max());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfInt] */
        @Override // j$.util.stream.IntStream
        public final /* synthetic */ PrimitiveIterator.OfInt NetworkUserEntityData$$ExternalSyntheticLambda6() {
            return PrimitiveIterator.OfInt.VivifiedWrapper.getAuthRequestContext(this.getAuthRequestContext.iterator());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda7() {
            return OptionalConversions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.findAny());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ Stream NetworkUserEntityData$$ExternalSyntheticLambda8() {
            return Stream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.boxed());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ DoubleStream PlaceComponentResult(IntToDoubleFunction intToDoubleFunction) {
            return DoubleStream.VivifiedWrapper.getAuthRequestContext(this.getAuthRequestContext.mapToDouble(IntToDoubleFunction.Wrapper.getAuthRequestContext(intToDoubleFunction)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ Stream PlaceComponentResult(IntFunction intFunction) {
            return Stream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.mapToObj(IntFunction.Wrapper.getAuthRequestContext(intFunction)));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ OptionalDouble PrepareContext() {
            return OptionalConversions.MyBillsEntityDataFactory(this.getAuthRequestContext.average());
        }

        @Override // j$.util.stream.IntStream
        public final IntSummaryStatistics SubSequence() {
            this.getAuthRequestContext.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
        }

        @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            this.getAuthRequestContext.close();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream getAuthRequestContext(Runnable runnable) {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.onClose(runnable));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ Object getAuthRequestContext(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return this.getAuthRequestContext.collect(Supplier.Wrapper.BuiltInFictitiousFunctionClassFactory(supplier), ObjIntConsumer.Wrapper.getAuthRequestContext(objIntConsumer), BiConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(biConsumer));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ boolean getAuthRequestContext(IntPredicate intPredicate) {
            return this.getAuthRequestContext.anyMatch(IntPredicate.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate));
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ int[] getCallingPid() {
            return this.getAuthRequestContext.toArray();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfInt] */
        @Override // j$.util.stream.IntStream
        public final /* synthetic */ Spliterator.OfInt getSupportButtonTintMode() {
            return Spliterator.OfInt.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2((Spliterator.OfInt) this.getAuthRequestContext.spliterator());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ DoubleStream initRecordTimeStamp() {
            return DoubleStream.VivifiedWrapper.getAuthRequestContext(this.getAuthRequestContext.asDoubleStream());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ long isLayoutRequested() {
            return this.getAuthRequestContext.count();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream moveToNextValue() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.parallel());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream scheduleImpl() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.sequential());
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ int whenAvailable() {
            return this.getAuthRequestContext.sum();
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream newProxyInstance() {
            java.util.stream.IntStream distinct = this.getAuthRequestContext.distinct();
            if (distinct == null) {
                return null;
            }
            return distinct instanceof Wrapper ? IntStream.this : new VivifiedWrapper(distinct);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream PlaceComponentResult(IntPredicate intPredicate) {
            java.util.stream.IntStream filter = this.getAuthRequestContext.filter(IntPredicate.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate));
            if (filter == null) {
                return null;
            }
            return filter instanceof Wrapper ? IntStream.this : new VivifiedWrapper(filter);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream BuiltInFictitiousFunctionClassFactory(IntFunction intFunction) {
            java.util.stream.IntStream flatMap = this.getAuthRequestContext.flatMap(IntFunction.Wrapper.getAuthRequestContext(intFunction));
            if (flatMap == null) {
                return null;
            }
            return flatMap instanceof Wrapper ? IntStream.this : new VivifiedWrapper(flatMap);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream MyBillsEntityDataFactory(long j) {
            java.util.stream.IntStream limit = this.getAuthRequestContext.limit(j);
            if (limit == null) {
                return null;
            }
            return limit instanceof Wrapper ? IntStream.this : new VivifiedWrapper(limit);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream getAuthRequestContext(IntUnaryOperator intUnaryOperator) {
            java.util.stream.IntStream map = this.getAuthRequestContext.map(IntUnaryOperator.Wrapper.BuiltInFictitiousFunctionClassFactory(intUnaryOperator));
            if (map == null) {
                return null;
            }
            return map instanceof Wrapper ? IntStream.this : new VivifiedWrapper(map);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream readMicros() {
            java.util.stream.IntStream parallel = this.getAuthRequestContext.parallel();
            if (parallel == null) {
                return null;
            }
            return parallel instanceof Wrapper ? IntStream.this : new VivifiedWrapper(parallel);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream PlaceComponentResult(IntConsumer intConsumer) {
            java.util.stream.IntStream peek = this.getAuthRequestContext.peek(IntConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer));
            if (peek == null) {
                return null;
            }
            return peek instanceof Wrapper ? IntStream.this : new VivifiedWrapper(peek);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream B() {
            java.util.stream.IntStream sequential = this.getAuthRequestContext.sequential();
            if (sequential == null) {
                return null;
            }
            return sequential instanceof Wrapper ? IntStream.this : new VivifiedWrapper(sequential);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream getAuthRequestContext(long j) {
            java.util.stream.IntStream skip = this.getAuthRequestContext.skip(j);
            if (skip == null) {
                return null;
            }
            return skip instanceof Wrapper ? IntStream.this : new VivifiedWrapper(skip);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream NetworkUserEntityData$$ExternalSyntheticLambda5() {
            java.util.stream.IntStream sorted = this.getAuthRequestContext.sorted();
            if (sorted == null) {
                return null;
            }
            return sorted instanceof Wrapper ? IntStream.this : new VivifiedWrapper(sorted);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        private /* synthetic */ Wrapper() {
            IntStream.this = r1;
        }

        public static /* synthetic */ java.util.stream.IntStream BuiltInFictitiousFunctionClassFactory(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof VivifiedWrapper ? ((VivifiedWrapper) intStream).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean allMatch(java.util.function.IntPredicate intPredicate) {
            return IntStream.this.BuiltInFictitiousFunctionClassFactory(IntPredicate.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean anyMatch(java.util.function.IntPredicate intPredicate) {
            return IntStream.this.getAuthRequestContext(IntPredicate.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.DoubleStream asDoubleStream() {
            return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(IntStream.this.initRecordTimeStamp());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.LongStream asLongStream() {
            return LongStream.Wrapper.MyBillsEntityDataFactory(IntStream.this.GetContactSyncConfig());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.OptionalDouble average() {
            return OptionalConversions.PlaceComponentResult(IntStream.this.PrepareContext());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.MyBillsEntityDataFactory(IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda8());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            IntStream.this.close();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ Object collect(java.util.function.Supplier supplier, java.util.function.ObjIntConsumer objIntConsumer, java.util.function.BiConsumer biConsumer) {
            return IntStream.this.getAuthRequestContext(Supplier.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(supplier), ObjIntConsumer.VivifiedWrapper.MyBillsEntityDataFactory(objIntConsumer), BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ long count() {
            return IntStream.this.isLayoutRequested();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.OptionalInt findAny() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda7());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.OptionalInt findFirst() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda3());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ void forEach(java.util.function.IntConsumer intConsumer) {
            IntStream.this.KClassImpl$Data$declaredNonStaticMembers$2(IntConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(intConsumer));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ void forEachOrdered(java.util.function.IntConsumer intConsumer) {
            IntStream.this.BuiltInFictitiousFunctionClassFactory(IntConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(intConsumer));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ boolean isParallel() {
            return IntStream.this.MyBillsEntityDataFactory();
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public final /* synthetic */ Iterator<Integer> iterator() {
            return IntStream.this.DatabaseTableConfigUtil();
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: iterator */
        public final /* synthetic */ Iterator<Integer> iterator2() {
            return PrimitiveIterator.OfInt.Wrapper.BuiltInFictitiousFunctionClassFactory(IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda6());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.DoubleStream mapToDouble(java.util.function.IntToDoubleFunction intToDoubleFunction) {
            return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(IntStream.this.PlaceComponentResult(IntToDoubleFunction.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intToDoubleFunction)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.LongStream mapToLong(java.util.function.IntToLongFunction intToLongFunction) {
            return LongStream.Wrapper.MyBillsEntityDataFactory(IntStream.this.BuiltInFictitiousFunctionClassFactory(IntToLongFunction.VivifiedWrapper.MyBillsEntityDataFactory(intToLongFunction)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.Stream mapToObj(java.util.function.IntFunction intFunction) {
            return Stream.Wrapper.MyBillsEntityDataFactory(IntStream.this.PlaceComponentResult(IntFunction.VivifiedWrapper.MyBillsEntityDataFactory(intFunction)));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.OptionalInt max() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda4());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.OptionalInt min() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(IntStream.this.FragmentBottomSheetPaymentSettingBinding());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean noneMatch(java.util.function.IntPredicate intPredicate) {
            return IntStream.this.KClassImpl$Data$declaredNonStaticMembers$2(IntPredicate.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate));
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(IntStream.this.getAuthRequestContext(runnable));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream parallel() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(IntStream.this.moveToNextValue());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int reduce(int i, java.util.function.IntBinaryOperator intBinaryOperator) {
            return IntStream.this.KClassImpl$Data$declaredNonStaticMembers$2(i, IntBinaryOperator.VivifiedWrapper.getAuthRequestContext(intBinaryOperator));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.OptionalInt reduce(java.util.function.IntBinaryOperator intBinaryOperator) {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(IntStream.this.KClassImpl$Data$declaredNonStaticMembers$2(IntBinaryOperator.VivifiedWrapper.getAuthRequestContext(intBinaryOperator)));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream sequential() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(IntStream.this.scheduleImpl());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.Spliterator<Integer> spliterator() {
            return Spliterator.OfInt.Wrapper.getAuthRequestContext(IntStream.this.getSupportButtonTintMode());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: spliterator */
        public final /* synthetic */ java.util.Spliterator<Integer> spliterator2() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda2());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int sum() {
            return IntStream.this.whenAvailable();
        }

        @Override // java.util.stream.IntStream
        public final java.util.IntSummaryStatistics summaryStatistics() {
            IntStream.this.SubSequence();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int[] toArray() {
            return IntStream.this.getCallingPid();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream unordered() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda1());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream distinct() {
            IntStream newProxyInstance = IntStream.this.newProxyInstance();
            if (newProxyInstance == null) {
                return null;
            }
            return newProxyInstance instanceof VivifiedWrapper ? ((VivifiedWrapper) newProxyInstance).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream filter(java.util.function.IntPredicate intPredicate) {
            IntStream PlaceComponentResult = IntStream.this.PlaceComponentResult(IntPredicate.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate));
            if (PlaceComponentResult == null) {
                return null;
            }
            return PlaceComponentResult instanceof VivifiedWrapper ? ((VivifiedWrapper) PlaceComponentResult).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream flatMap(java.util.function.IntFunction intFunction) {
            IntStream BuiltInFictitiousFunctionClassFactory = IntStream.this.BuiltInFictitiousFunctionClassFactory(IntFunction.VivifiedWrapper.MyBillsEntityDataFactory(intFunction));
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream limit(long j) {
            IntStream MyBillsEntityDataFactory = IntStream.this.MyBillsEntityDataFactory(j);
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            return MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream map(java.util.function.IntUnaryOperator intUnaryOperator) {
            IntStream authRequestContext = IntStream.this.getAuthRequestContext(IntUnaryOperator.VivifiedWrapper.getAuthRequestContext(intUnaryOperator));
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: parallel */
        public final /* synthetic */ java.util.stream.IntStream parallel2() {
            IntStream readMicros = IntStream.this.readMicros();
            if (readMicros == null) {
                return null;
            }
            return readMicros instanceof VivifiedWrapper ? ((VivifiedWrapper) readMicros).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream peek(java.util.function.IntConsumer intConsumer) {
            IntStream PlaceComponentResult = IntStream.this.PlaceComponentResult(IntConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(intConsumer));
            if (PlaceComponentResult == null) {
                return null;
            }
            return PlaceComponentResult instanceof VivifiedWrapper ? ((VivifiedWrapper) PlaceComponentResult).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* renamed from: sequential */
        public final /* synthetic */ java.util.stream.IntStream sequential2() {
            IntStream B = IntStream.this.B();
            if (B == null) {
                return null;
            }
            return B instanceof VivifiedWrapper ? ((VivifiedWrapper) B).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream skip(long j) {
            IntStream authRequestContext = IntStream.this.getAuthRequestContext(j);
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream sorted() {
            IntStream NetworkUserEntityData$$ExternalSyntheticLambda5 = IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda5();
            if (NetworkUserEntityData$$ExternalSyntheticLambda5 == null) {
                return null;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda5 instanceof VivifiedWrapper ? ((VivifiedWrapper) NetworkUserEntityData$$ExternalSyntheticLambda5).getAuthRequestContext : new Wrapper();
        }
    }
}
