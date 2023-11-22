package j$.util.stream;

import j$.util.LongSummaryStatistics;
import j$.util.OptionalConversions;
import j$.util.OptionalDouble;
import j$.util.OptionalLong;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.LongBinaryOperator;
import j$.util.function.LongConsumer;
import j$.util.function.LongFunction;
import j$.util.function.LongPredicate;
import j$.util.function.LongToDoubleFunction;
import j$.util.function.LongToIntFunction;
import j$.util.function.LongUnaryOperator;
import j$.util.function.ObjLongConsumer;
import j$.util.function.Supplier;
import j$.util.stream.BaseStream;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.PrimitiveIterator;

/* loaded from: classes.dex */
public interface LongStream extends BaseStream {
    LongStream FragmentBottomSheetPaymentSettingBinding();

    OptionalDouble GetContactSyncConfig();

    long KClassImpl$Data$declaredNonStaticMembers$2(long j, LongBinaryOperator longBinaryOperator);

    LongStream KClassImpl$Data$declaredNonStaticMembers$2(long j);

    Stream KClassImpl$Data$declaredNonStaticMembers$2(LongFunction longFunction);

    boolean KClassImpl$Data$declaredNonStaticMembers$2(LongPredicate longPredicate);

    LongStream MyBillsEntityDataFactory(LongConsumer longConsumer);

    LongStream MyBillsEntityDataFactory(LongFunction longFunction);

    LongStream MyBillsEntityDataFactory(LongPredicate longPredicate);

    OptionalLong NetworkUserEntityData$$ExternalSyntheticLambda3();

    OptionalLong NetworkUserEntityData$$ExternalSyntheticLambda4();

    Spliterator.OfLong NetworkUserEntityData$$ExternalSyntheticLambda5();

    PrimitiveIterator.OfLong NetworkUserEntityData$$ExternalSyntheticLambda6();

    long NetworkUserEntityData$$ExternalSyntheticLambda7();

    LongStream NetworkUserEntityData$$ExternalSyntheticLambda8();

    IntStream PlaceComponentResult(LongToIntFunction longToIntFunction);

    LongStream PlaceComponentResult(long j);

    LongStream PlaceComponentResult(LongUnaryOperator longUnaryOperator);

    void PlaceComponentResult(LongConsumer longConsumer);

    boolean PlaceComponentResult(LongPredicate longPredicate);

    Stream PrepareContext();

    long SubSequence();

    OptionalLong getAuthRequestContext(LongBinaryOperator longBinaryOperator);

    DoubleStream getAuthRequestContext(LongToDoubleFunction longToDoubleFunction);

    Object getAuthRequestContext(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    void getAuthRequestContext(LongConsumer longConsumer);

    boolean getAuthRequestContext(LongPredicate longPredicate);

    LongSummaryStatistics getCallingPid();

    LongStream getSupportButtonTintMode();

    DoubleStream initRecordTimeStamp();

    OptionalLong isLayoutRequested();

    OptionalLong newProxyInstance();

    LongStream readMicros();

    long[] whenAvailable();

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements LongStream {
        final /* synthetic */ java.util.stream.LongStream KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.stream.LongStream longStream) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = longStream;
        }

        public static /* synthetic */ LongStream MyBillsEntityDataFactory(java.util.stream.LongStream longStream) {
            if (longStream == null) {
                return null;
            }
            return longStream instanceof Wrapper ? LongStream.this : new VivifiedWrapper(longStream);
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Iterator DatabaseTableConfigUtil() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ OptionalDouble GetContactSyncConfig() {
            return OptionalConversions.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.average());
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2(long j, LongBinaryOperator longBinaryOperator) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.reduce(j, LongBinaryOperator.Wrapper.PlaceComponentResult(longBinaryOperator));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ Stream KClassImpl$Data$declaredNonStaticMembers$2(LongFunction longFunction) {
            return Stream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToObj(LongFunction.Wrapper.MyBillsEntityDataFactory(longFunction)));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(LongPredicate longPredicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.anyMatch(LongPredicate.Wrapper.BuiltInFictitiousFunctionClassFactory(longPredicate));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ boolean MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isParallel();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.unordered());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
            return Spliterator.VivifiedWrapper.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.spliterator());
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ OptionalLong NetworkUserEntityData$$ExternalSyntheticLambda3() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.min());
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ OptionalLong NetworkUserEntityData$$ExternalSyntheticLambda4() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.max());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfLong] */
        @Override // j$.util.stream.LongStream
        public final /* synthetic */ Spliterator.OfLong NetworkUserEntityData$$ExternalSyntheticLambda5() {
            return Spliterator.OfLong.VivifiedWrapper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.spliterator());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfLong] */
        @Override // j$.util.stream.LongStream
        public final /* synthetic */ PrimitiveIterator.OfLong NetworkUserEntityData$$ExternalSyntheticLambda6() {
            return PrimitiveIterator.OfLong.VivifiedWrapper.MyBillsEntityDataFactory((PrimitiveIterator.OfLong) this.KClassImpl$Data$declaredNonStaticMembers$2.iterator());
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ long NetworkUserEntityData$$ExternalSyntheticLambda7() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.count();
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ IntStream PlaceComponentResult(LongToIntFunction longToIntFunction) {
            return IntStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToInt(LongToIntFunction.Wrapper.getAuthRequestContext(longToIntFunction)));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ void PlaceComponentResult(LongConsumer longConsumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.forEach(LongConsumer.Wrapper.getAuthRequestContext(longConsumer));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ boolean PlaceComponentResult(LongPredicate longPredicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.noneMatch(LongPredicate.Wrapper.BuiltInFictitiousFunctionClassFactory(longPredicate));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ Stream PrepareContext() {
            return Stream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.boxed());
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ long SubSequence() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.sum();
        }

        @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.close();
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ OptionalLong getAuthRequestContext(LongBinaryOperator longBinaryOperator) {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.reduce(LongBinaryOperator.Wrapper.PlaceComponentResult(longBinaryOperator)));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream getAuthRequestContext(Runnable runnable) {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.onClose(runnable));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ DoubleStream getAuthRequestContext(LongToDoubleFunction longToDoubleFunction) {
            return DoubleStream.VivifiedWrapper.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToDouble(LongToDoubleFunction.Wrapper.getAuthRequestContext(longToDoubleFunction)));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ Object getAuthRequestContext(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.collect(Supplier.Wrapper.BuiltInFictitiousFunctionClassFactory(supplier), ObjLongConsumer.Wrapper.BuiltInFictitiousFunctionClassFactory(objLongConsumer), BiConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(biConsumer));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ void getAuthRequestContext(LongConsumer longConsumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.forEachOrdered(LongConsumer.Wrapper.getAuthRequestContext(longConsumer));
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ boolean getAuthRequestContext(LongPredicate longPredicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.allMatch(LongPredicate.Wrapper.BuiltInFictitiousFunctionClassFactory(longPredicate));
        }

        @Override // j$.util.stream.LongStream
        public final LongSummaryStatistics getCallingPid() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ DoubleStream initRecordTimeStamp() {
            return DoubleStream.VivifiedWrapper.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.asDoubleStream());
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ OptionalLong isLayoutRequested() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.findAny());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream moveToNextValue() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.parallel());
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ OptionalLong newProxyInstance() {
            return OptionalConversions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.findFirst());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream scheduleImpl() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.sequential());
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ long[] whenAvailable() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.toArray();
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream NetworkUserEntityData$$ExternalSyntheticLambda8() {
            java.util.stream.LongStream distinct = this.KClassImpl$Data$declaredNonStaticMembers$2.distinct();
            if (distinct == null) {
                return null;
            }
            return distinct instanceof Wrapper ? LongStream.this : new VivifiedWrapper(distinct);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream MyBillsEntityDataFactory(LongPredicate longPredicate) {
            java.util.stream.LongStream filter = this.KClassImpl$Data$declaredNonStaticMembers$2.filter(LongPredicate.Wrapper.BuiltInFictitiousFunctionClassFactory(longPredicate));
            if (filter == null) {
                return null;
            }
            return filter instanceof Wrapper ? LongStream.this : new VivifiedWrapper(filter);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream MyBillsEntityDataFactory(LongFunction longFunction) {
            java.util.stream.LongStream flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.flatMap(LongFunction.Wrapper.MyBillsEntityDataFactory(longFunction));
            if (flatMap == null) {
                return null;
            }
            return flatMap instanceof Wrapper ? LongStream.this : new VivifiedWrapper(flatMap);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream KClassImpl$Data$declaredNonStaticMembers$2(long j) {
            java.util.stream.LongStream limit = this.KClassImpl$Data$declaredNonStaticMembers$2.limit(j);
            if (limit == null) {
                return null;
            }
            return limit instanceof Wrapper ? LongStream.this : new VivifiedWrapper(limit);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream PlaceComponentResult(LongUnaryOperator longUnaryOperator) {
            java.util.stream.LongStream map = this.KClassImpl$Data$declaredNonStaticMembers$2.map(LongUnaryOperator.Wrapper.BuiltInFictitiousFunctionClassFactory(longUnaryOperator));
            if (map == null) {
                return null;
            }
            return map instanceof Wrapper ? LongStream.this : new VivifiedWrapper(map);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream readMicros() {
            java.util.stream.LongStream parallel = this.KClassImpl$Data$declaredNonStaticMembers$2.parallel();
            if (parallel == null) {
                return null;
            }
            return parallel instanceof Wrapper ? LongStream.this : new VivifiedWrapper(parallel);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream MyBillsEntityDataFactory(LongConsumer longConsumer) {
            java.util.stream.LongStream peek = this.KClassImpl$Data$declaredNonStaticMembers$2.peek(LongConsumer.Wrapper.getAuthRequestContext(longConsumer));
            if (peek == null) {
                return null;
            }
            return peek instanceof Wrapper ? LongStream.this : new VivifiedWrapper(peek);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream getSupportButtonTintMode() {
            java.util.stream.LongStream sequential = this.KClassImpl$Data$declaredNonStaticMembers$2.sequential();
            if (sequential == null) {
                return null;
            }
            return sequential instanceof Wrapper ? LongStream.this : new VivifiedWrapper(sequential);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream PlaceComponentResult(long j) {
            java.util.stream.LongStream skip = this.KClassImpl$Data$declaredNonStaticMembers$2.skip(j);
            if (skip == null) {
                return null;
            }
            return skip instanceof Wrapper ? LongStream.this : new VivifiedWrapper(skip);
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream FragmentBottomSheetPaymentSettingBinding() {
            java.util.stream.LongStream sorted = this.KClassImpl$Data$declaredNonStaticMembers$2.sorted();
            if (sorted == null) {
                return null;
            }
            return sorted instanceof Wrapper ? LongStream.this : new VivifiedWrapper(sorted);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.LongStream {
        private /* synthetic */ Wrapper() {
            LongStream.this = r1;
        }

        public static /* synthetic */ java.util.stream.LongStream MyBillsEntityDataFactory(LongStream longStream) {
            if (longStream == null) {
                return null;
            }
            return longStream instanceof VivifiedWrapper ? ((VivifiedWrapper) longStream).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ boolean allMatch(java.util.function.LongPredicate longPredicate) {
            return LongStream.this.getAuthRequestContext(LongPredicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longPredicate));
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ boolean anyMatch(java.util.function.LongPredicate longPredicate) {
            return LongStream.this.KClassImpl$Data$declaredNonStaticMembers$2(LongPredicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longPredicate));
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.DoubleStream asDoubleStream() {
            return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(LongStream.this.initRecordTimeStamp());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.OptionalDouble average() {
            return OptionalConversions.PlaceComponentResult(LongStream.this.GetContactSyncConfig());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.MyBillsEntityDataFactory(LongStream.this.PrepareContext());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            LongStream.this.close();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ Object collect(java.util.function.Supplier supplier, java.util.function.ObjLongConsumer objLongConsumer, java.util.function.BiConsumer biConsumer) {
            return LongStream.this.getAuthRequestContext(Supplier.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(supplier), ObjLongConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(objLongConsumer), BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer));
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ long count() {
            return LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.OptionalLong findAny() {
            return OptionalConversions.getAuthRequestContext(LongStream.this.isLayoutRequested());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.OptionalLong findFirst() {
            return OptionalConversions.getAuthRequestContext(LongStream.this.newProxyInstance());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ void forEach(java.util.function.LongConsumer longConsumer) {
            LongStream.this.PlaceComponentResult(LongConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longConsumer));
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ void forEachOrdered(java.util.function.LongConsumer longConsumer) {
            LongStream.this.getAuthRequestContext(LongConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longConsumer));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ boolean isParallel() {
            return LongStream.this.MyBillsEntityDataFactory();
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public final /* synthetic */ Iterator<Long> iterator() {
            return LongStream.this.DatabaseTableConfigUtil();
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        /* renamed from: iterator */
        public final /* synthetic */ Iterator<Long> iterator2() {
            return PrimitiveIterator.OfLong.Wrapper.PlaceComponentResult(LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda6());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.DoubleStream mapToDouble(java.util.function.LongToDoubleFunction longToDoubleFunction) {
            return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(LongStream.this.getAuthRequestContext(LongToDoubleFunction.VivifiedWrapper.getAuthRequestContext(longToDoubleFunction)));
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.IntStream mapToInt(java.util.function.LongToIntFunction longToIntFunction) {
            return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(LongStream.this.PlaceComponentResult(LongToIntFunction.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(longToIntFunction)));
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.Stream mapToObj(java.util.function.LongFunction longFunction) {
            return Stream.Wrapper.MyBillsEntityDataFactory(LongStream.this.KClassImpl$Data$declaredNonStaticMembers$2(LongFunction.VivifiedWrapper.PlaceComponentResult(longFunction)));
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.OptionalLong max() {
            return OptionalConversions.getAuthRequestContext(LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda4());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.OptionalLong min() {
            return OptionalConversions.getAuthRequestContext(LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda3());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ boolean noneMatch(java.util.function.LongPredicate longPredicate) {
            return LongStream.this.PlaceComponentResult(LongPredicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longPredicate));
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.stream.LongStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.LongStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(LongStream.this.getAuthRequestContext(runnable));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.LongStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.LongStream parallel() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(LongStream.this.moveToNextValue());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ long reduce(long j, java.util.function.LongBinaryOperator longBinaryOperator) {
            return LongStream.this.KClassImpl$Data$declaredNonStaticMembers$2(j, LongBinaryOperator.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(longBinaryOperator));
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.OptionalLong reduce(java.util.function.LongBinaryOperator longBinaryOperator) {
            return OptionalConversions.getAuthRequestContext(LongStream.this.getAuthRequestContext(LongBinaryOperator.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(longBinaryOperator)));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.LongStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.LongStream sequential() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(LongStream.this.scheduleImpl());
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.Spliterator<Long> spliterator() {
            return Spliterator.OfLong.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda5());
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        /* renamed from: spliterator */
        public final /* synthetic */ java.util.Spliterator<Long> spliterator2() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda2());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ long sum() {
            return LongStream.this.SubSequence();
        }

        @Override // java.util.stream.LongStream
        public final java.util.LongSummaryStatistics summaryStatistics() {
            LongStream.this.getCallingPid();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics");
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ long[] toArray() {
            return LongStream.this.whenAvailable();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.LongStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.LongStream unordered() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda1());
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.LongStream distinct() {
            LongStream NetworkUserEntityData$$ExternalSyntheticLambda8 = LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda8();
            if (NetworkUserEntityData$$ExternalSyntheticLambda8 == null) {
                return null;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda8 instanceof VivifiedWrapper ? ((VivifiedWrapper) NetworkUserEntityData$$ExternalSyntheticLambda8).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.LongStream filter(java.util.function.LongPredicate longPredicate) {
            LongStream MyBillsEntityDataFactory = LongStream.this.MyBillsEntityDataFactory(LongPredicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longPredicate));
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            return MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.LongStream flatMap(java.util.function.LongFunction longFunction) {
            LongStream MyBillsEntityDataFactory = LongStream.this.MyBillsEntityDataFactory(LongFunction.VivifiedWrapper.PlaceComponentResult(longFunction));
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            return MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.LongStream limit(long j) {
            LongStream KClassImpl$Data$declaredNonStaticMembers$2 = LongStream.this.KClassImpl$Data$declaredNonStaticMembers$2(j);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.LongStream map(java.util.function.LongUnaryOperator longUnaryOperator) {
            LongStream PlaceComponentResult = LongStream.this.PlaceComponentResult(LongUnaryOperator.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(longUnaryOperator));
            if (PlaceComponentResult == null) {
                return null;
            }
            return PlaceComponentResult instanceof VivifiedWrapper ? ((VivifiedWrapper) PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        /* renamed from: parallel */
        public final /* synthetic */ java.util.stream.LongStream parallel2() {
            LongStream readMicros = LongStream.this.readMicros();
            if (readMicros == null) {
                return null;
            }
            return readMicros instanceof VivifiedWrapper ? ((VivifiedWrapper) readMicros).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.LongStream peek(java.util.function.LongConsumer longConsumer) {
            LongStream MyBillsEntityDataFactory = LongStream.this.MyBillsEntityDataFactory(LongConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longConsumer));
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            return MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        /* renamed from: sequential */
        public final /* synthetic */ java.util.stream.LongStream sequential2() {
            LongStream supportButtonTintMode = LongStream.this.getSupportButtonTintMode();
            if (supportButtonTintMode == null) {
                return null;
            }
            return supportButtonTintMode instanceof VivifiedWrapper ? ((VivifiedWrapper) supportButtonTintMode).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.LongStream skip(long j) {
            LongStream PlaceComponentResult = LongStream.this.PlaceComponentResult(j);
            if (PlaceComponentResult == null) {
                return null;
            }
            return PlaceComponentResult instanceof VivifiedWrapper ? ((VivifiedWrapper) PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public final /* synthetic */ java.util.stream.LongStream sorted() {
            LongStream FragmentBottomSheetPaymentSettingBinding = LongStream.this.FragmentBottomSheetPaymentSettingBinding();
            if (FragmentBottomSheetPaymentSettingBinding == null) {
                return null;
            }
            return FragmentBottomSheetPaymentSettingBinding instanceof VivifiedWrapper ? ((VivifiedWrapper) FragmentBottomSheetPaymentSettingBinding).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }
    }
}
