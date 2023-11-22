package j$.util.stream;

import j$.util.DoubleSummaryStatistics;
import j$.util.OptionalConversions;
import j$.util.OptionalDouble;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.DoubleBinaryOperator;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleFunction;
import j$.util.function.DoublePredicate;
import j$.util.function.DoubleToIntFunction;
import j$.util.function.DoubleToLongFunction;
import j$.util.function.DoubleUnaryOperator;
import j$.util.function.ObjDoubleConsumer;
import j$.util.function.Supplier;
import j$.util.stream.BaseStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;

/* loaded from: classes.dex */
public interface DoubleStream extends BaseStream {
    DoubleStream BuiltInFictitiousFunctionClassFactory(DoubleFunction doubleFunction);

    DoubleStream BuiltInFictitiousFunctionClassFactory(DoublePredicate doublePredicate);

    DoubleStream FragmentBottomSheetPaymentSettingBinding();

    OptionalDouble GetContactSyncConfig();

    IntStream KClassImpl$Data$declaredNonStaticMembers$2(DoubleToIntFunction doubleToIntFunction);

    DoubleStream MyBillsEntityDataFactory(DoubleConsumer doubleConsumer);

    boolean MyBillsEntityDataFactory(DoublePredicate doublePredicate);

    double NetworkUserEntityData$$ExternalSyntheticLambda3();

    Spliterator.OfDouble NetworkUserEntityData$$ExternalSyntheticLambda4();

    OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda5();

    OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda6();

    OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda7();

    PrimitiveIterator.OfDouble NetworkUserEntityData$$ExternalSyntheticLambda8();

    double PlaceComponentResult(double d, DoubleBinaryOperator doubleBinaryOperator);

    OptionalDouble PlaceComponentResult(DoubleBinaryOperator doubleBinaryOperator);

    DoubleStream PlaceComponentResult(long j);

    LongStream PlaceComponentResult(DoubleToLongFunction doubleToLongFunction);

    void PlaceComponentResult(DoubleConsumer doubleConsumer);

    boolean PlaceComponentResult(DoublePredicate doublePredicate);

    OptionalDouble PrepareContext();

    DoubleSummaryStatistics SubSequence();

    DoubleStream getAuthRequestContext(long j);

    DoubleStream getAuthRequestContext(DoubleUnaryOperator doubleUnaryOperator);

    Stream getAuthRequestContext(DoubleFunction doubleFunction);

    Object getAuthRequestContext(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    void getAuthRequestContext(DoubleConsumer doubleConsumer);

    boolean getAuthRequestContext(DoublePredicate doublePredicate);

    DoubleStream getCallingPid();

    double[] getSupportButtonTintMode();

    Stream initRecordTimeStamp();

    DoubleStream isLayoutRequested();

    long newProxyInstance();

    DoubleStream whenAvailable();

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoubleStream {
        final /* synthetic */ java.util.stream.DoubleStream KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.stream.DoubleStream doubleStream) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = doubleStream;
        }

        public static /* synthetic */ DoubleStream getAuthRequestContext(java.util.stream.DoubleStream doubleStream) {
            if (doubleStream == null) {
                return null;
            }
            return doubleStream instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(doubleStream);
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Iterator DatabaseTableConfigUtil() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ OptionalDouble GetContactSyncConfig() {
            return OptionalConversions.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.average());
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ IntStream KClassImpl$Data$declaredNonStaticMembers$2(DoubleToIntFunction doubleToIntFunction) {
            return IntStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToInt(DoubleToIntFunction.Wrapper.BuiltInFictitiousFunctionClassFactory(doubleToIntFunction)));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ boolean MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isParallel();
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ boolean MyBillsEntityDataFactory(DoublePredicate doublePredicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.anyMatch(DoublePredicate.Wrapper.PlaceComponentResult(doublePredicate));
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.unordered());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
            return Spliterator.VivifiedWrapper.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.spliterator());
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ double NetworkUserEntityData$$ExternalSyntheticLambda3() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.sum();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfDouble] */
        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ Spliterator.OfDouble NetworkUserEntityData$$ExternalSyntheticLambda4() {
            return Spliterator.OfDouble.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory((Spliterator.OfDouble) this.KClassImpl$Data$declaredNonStaticMembers$2.spliterator());
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda5() {
            return OptionalConversions.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.max());
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda6() {
            return OptionalConversions.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.min());
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda7() {
            return OptionalConversions.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.findAny());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfDouble] */
        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ PrimitiveIterator.OfDouble NetworkUserEntityData$$ExternalSyntheticLambda8() {
            return PrimitiveIterator.OfDouble.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.iterator());
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ double PlaceComponentResult(double d, DoubleBinaryOperator doubleBinaryOperator) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.reduce(d, DoubleBinaryOperator.Wrapper.getAuthRequestContext(doubleBinaryOperator));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ OptionalDouble PlaceComponentResult(DoubleBinaryOperator doubleBinaryOperator) {
            return OptionalConversions.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.reduce(DoubleBinaryOperator.Wrapper.getAuthRequestContext(doubleBinaryOperator)));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ LongStream PlaceComponentResult(DoubleToLongFunction doubleToLongFunction) {
            return LongStream.VivifiedWrapper.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToLong(DoubleToLongFunction.Wrapper.PlaceComponentResult(doubleToLongFunction)));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ void PlaceComponentResult(DoubleConsumer doubleConsumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.forEach(DoubleConsumer.Wrapper.PlaceComponentResult(doubleConsumer));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ boolean PlaceComponentResult(DoublePredicate doublePredicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.noneMatch(DoublePredicate.Wrapper.PlaceComponentResult(doublePredicate));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ OptionalDouble PrepareContext() {
            return OptionalConversions.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.findFirst());
        }

        @Override // j$.util.stream.DoubleStream
        public final DoubleSummaryStatistics SubSequence() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
        }

        @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.close();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream getAuthRequestContext(Runnable runnable) {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.onClose(runnable));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ Stream getAuthRequestContext(DoubleFunction doubleFunction) {
            return Stream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.mapToObj(DoubleFunction.Wrapper.PlaceComponentResult(doubleFunction)));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ Object getAuthRequestContext(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.collect(Supplier.Wrapper.BuiltInFictitiousFunctionClassFactory(supplier), ObjDoubleConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(objDoubleConsumer), BiConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(biConsumer));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ void getAuthRequestContext(DoubleConsumer doubleConsumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.forEachOrdered(DoubleConsumer.Wrapper.PlaceComponentResult(doubleConsumer));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ boolean getAuthRequestContext(DoublePredicate doublePredicate) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.allMatch(DoublePredicate.Wrapper.PlaceComponentResult(doublePredicate));
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ double[] getSupportButtonTintMode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.toArray();
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ Stream initRecordTimeStamp() {
            return Stream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.boxed());
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream moveToNextValue() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.parallel());
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ long newProxyInstance() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.count();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream scheduleImpl() {
            return BaseStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.sequential());
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream isLayoutRequested() {
            java.util.stream.DoubleStream distinct = this.KClassImpl$Data$declaredNonStaticMembers$2.distinct();
            if (distinct == null) {
                return null;
            }
            return distinct instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(distinct);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream BuiltInFictitiousFunctionClassFactory(DoublePredicate doublePredicate) {
            java.util.stream.DoubleStream filter = this.KClassImpl$Data$declaredNonStaticMembers$2.filter(DoublePredicate.Wrapper.PlaceComponentResult(doublePredicate));
            if (filter == null) {
                return null;
            }
            return filter instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(filter);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream BuiltInFictitiousFunctionClassFactory(DoubleFunction doubleFunction) {
            java.util.stream.DoubleStream flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.flatMap(DoubleFunction.Wrapper.PlaceComponentResult(doubleFunction));
            if (flatMap == null) {
                return null;
            }
            return flatMap instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(flatMap);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream getAuthRequestContext(long j) {
            java.util.stream.DoubleStream limit = this.KClassImpl$Data$declaredNonStaticMembers$2.limit(j);
            if (limit == null) {
                return null;
            }
            return limit instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(limit);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream getAuthRequestContext(DoubleUnaryOperator doubleUnaryOperator) {
            java.util.stream.DoubleStream map = this.KClassImpl$Data$declaredNonStaticMembers$2.map(DoubleUnaryOperator.Wrapper.PlaceComponentResult(doubleUnaryOperator));
            if (map == null) {
                return null;
            }
            return map instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(map);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream whenAvailable() {
            java.util.stream.DoubleStream parallel = this.KClassImpl$Data$declaredNonStaticMembers$2.parallel();
            if (parallel == null) {
                return null;
            }
            return parallel instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(parallel);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream MyBillsEntityDataFactory(DoubleConsumer doubleConsumer) {
            java.util.stream.DoubleStream peek = this.KClassImpl$Data$declaredNonStaticMembers$2.peek(DoubleConsumer.Wrapper.PlaceComponentResult(doubleConsumer));
            if (peek == null) {
                return null;
            }
            return peek instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(peek);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream getCallingPid() {
            java.util.stream.DoubleStream sequential = this.KClassImpl$Data$declaredNonStaticMembers$2.sequential();
            if (sequential == null) {
                return null;
            }
            return sequential instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(sequential);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream PlaceComponentResult(long j) {
            java.util.stream.DoubleStream skip = this.KClassImpl$Data$declaredNonStaticMembers$2.skip(j);
            if (skip == null) {
                return null;
            }
            return skip instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(skip);
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream FragmentBottomSheetPaymentSettingBinding() {
            java.util.stream.DoubleStream sorted = this.KClassImpl$Data$declaredNonStaticMembers$2.sorted();
            if (sorted == null) {
                return null;
            }
            return sorted instanceof Wrapper ? DoubleStream.this : new VivifiedWrapper(sorted);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.DoubleStream {
        private /* synthetic */ Wrapper() {
            DoubleStream.this = r1;
        }

        public static /* synthetic */ java.util.stream.DoubleStream BuiltInFictitiousFunctionClassFactory(DoubleStream doubleStream) {
            if (doubleStream == null) {
                return null;
            }
            return doubleStream instanceof VivifiedWrapper ? ((VivifiedWrapper) doubleStream).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ boolean allMatch(java.util.function.DoublePredicate doublePredicate) {
            return DoubleStream.this.getAuthRequestContext(DoublePredicate.VivifiedWrapper.MyBillsEntityDataFactory(doublePredicate));
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ boolean anyMatch(java.util.function.DoublePredicate doublePredicate) {
            return DoubleStream.this.MyBillsEntityDataFactory(DoublePredicate.VivifiedWrapper.MyBillsEntityDataFactory(doublePredicate));
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.OptionalDouble average() {
            return OptionalConversions.PlaceComponentResult(DoubleStream.this.GetContactSyncConfig());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.MyBillsEntityDataFactory(DoubleStream.this.initRecordTimeStamp());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            DoubleStream.this.close();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ Object collect(java.util.function.Supplier supplier, java.util.function.ObjDoubleConsumer objDoubleConsumer, java.util.function.BiConsumer biConsumer) {
            return DoubleStream.this.getAuthRequestContext(Supplier.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(supplier), ObjDoubleConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(objDoubleConsumer), BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer));
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ long count() {
            return DoubleStream.this.newProxyInstance();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.OptionalDouble findAny() {
            return OptionalConversions.PlaceComponentResult(DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda7());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.OptionalDouble findFirst() {
            return OptionalConversions.PlaceComponentResult(DoubleStream.this.PrepareContext());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ void forEach(java.util.function.DoubleConsumer doubleConsumer) {
            DoubleStream.this.PlaceComponentResult(DoubleConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleConsumer));
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ void forEachOrdered(java.util.function.DoubleConsumer doubleConsumer) {
            DoubleStream.this.getAuthRequestContext(DoubleConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleConsumer));
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ boolean isParallel() {
            return DoubleStream.this.MyBillsEntityDataFactory();
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public final /* synthetic */ Iterator<Double> iterator() {
            return DoubleStream.this.DatabaseTableConfigUtil();
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* renamed from: iterator */
        public final /* synthetic */ Iterator<Double> iterator2() {
            return PrimitiveIterator.OfDouble.Wrapper.BuiltInFictitiousFunctionClassFactory(DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda8());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.IntStream mapToInt(java.util.function.DoubleToIntFunction doubleToIntFunction) {
            return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(DoubleStream.this.KClassImpl$Data$declaredNonStaticMembers$2(DoubleToIntFunction.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(doubleToIntFunction)));
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.LongStream mapToLong(java.util.function.DoubleToLongFunction doubleToLongFunction) {
            return LongStream.Wrapper.MyBillsEntityDataFactory(DoubleStream.this.PlaceComponentResult(DoubleToLongFunction.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(doubleToLongFunction)));
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.Stream mapToObj(java.util.function.DoubleFunction doubleFunction) {
            return Stream.Wrapper.MyBillsEntityDataFactory(DoubleStream.this.getAuthRequestContext(DoubleFunction.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(doubleFunction)));
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.OptionalDouble max() {
            return OptionalConversions.PlaceComponentResult(DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda5());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.OptionalDouble min() {
            return OptionalConversions.PlaceComponentResult(DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda6());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ boolean noneMatch(java.util.function.DoublePredicate doublePredicate) {
            return DoubleStream.this.PlaceComponentResult(DoublePredicate.VivifiedWrapper.MyBillsEntityDataFactory(doublePredicate));
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.DoubleStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(DoubleStream.this.getAuthRequestContext(runnable));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.DoubleStream parallel() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(DoubleStream.this.moveToNextValue());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ double reduce(double d, java.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            return DoubleStream.this.PlaceComponentResult(d, DoubleBinaryOperator.VivifiedWrapper.getAuthRequestContext(doubleBinaryOperator));
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.OptionalDouble reduce(java.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            return OptionalConversions.PlaceComponentResult(DoubleStream.this.PlaceComponentResult(DoubleBinaryOperator.VivifiedWrapper.getAuthRequestContext(doubleBinaryOperator)));
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.DoubleStream sequential() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(DoubleStream.this.scheduleImpl());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public final /* synthetic */ java.util.Spliterator<Double> spliterator() {
            return Spliterator.OfDouble.Wrapper.PlaceComponentResult(DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda4());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* renamed from: spliterator */
        public final /* synthetic */ java.util.Spliterator<Double> spliterator2() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda2());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ double sum() {
            return DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda3();
        }

        @Override // java.util.stream.DoubleStream
        public final java.util.DoubleSummaryStatistics summaryStatistics() {
            DoubleStream.this.SubSequence();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.DoubleSummaryStatistics");
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ double[] toArray() {
            return DoubleStream.this.getSupportButtonTintMode();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.DoubleStream unordered() {
            return BaseStream.Wrapper.MyBillsEntityDataFactory(DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda1());
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.DoubleStream distinct() {
            DoubleStream isLayoutRequested = DoubleStream.this.isLayoutRequested();
            if (isLayoutRequested == null) {
                return null;
            }
            return isLayoutRequested instanceof VivifiedWrapper ? ((VivifiedWrapper) isLayoutRequested).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.DoubleStream filter(java.util.function.DoublePredicate doublePredicate) {
            DoubleStream BuiltInFictitiousFunctionClassFactory = DoubleStream.this.BuiltInFictitiousFunctionClassFactory(DoublePredicate.VivifiedWrapper.MyBillsEntityDataFactory(doublePredicate));
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.DoubleStream flatMap(java.util.function.DoubleFunction doubleFunction) {
            DoubleStream BuiltInFictitiousFunctionClassFactory = DoubleStream.this.BuiltInFictitiousFunctionClassFactory(DoubleFunction.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(doubleFunction));
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.DoubleStream limit(long j) {
            DoubleStream authRequestContext = DoubleStream.this.getAuthRequestContext(j);
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.DoubleStream map(java.util.function.DoubleUnaryOperator doubleUnaryOperator) {
            DoubleStream authRequestContext = DoubleStream.this.getAuthRequestContext(DoubleUnaryOperator.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleUnaryOperator));
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* renamed from: parallel */
        public final /* synthetic */ java.util.stream.DoubleStream parallel2() {
            DoubleStream whenAvailable = DoubleStream.this.whenAvailable();
            if (whenAvailable == null) {
                return null;
            }
            return whenAvailable instanceof VivifiedWrapper ? ((VivifiedWrapper) whenAvailable).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.DoubleStream peek(java.util.function.DoubleConsumer doubleConsumer) {
            DoubleStream MyBillsEntityDataFactory = DoubleStream.this.MyBillsEntityDataFactory(DoubleConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleConsumer));
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            return MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* renamed from: sequential */
        public final /* synthetic */ java.util.stream.DoubleStream sequential2() {
            DoubleStream callingPid = DoubleStream.this.getCallingPid();
            if (callingPid == null) {
                return null;
            }
            return callingPid instanceof VivifiedWrapper ? ((VivifiedWrapper) callingPid).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.DoubleStream skip(long j) {
            DoubleStream PlaceComponentResult = DoubleStream.this.PlaceComponentResult(j);
            if (PlaceComponentResult == null) {
                return null;
            }
            return PlaceComponentResult instanceof VivifiedWrapper ? ((VivifiedWrapper) PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public final /* synthetic */ java.util.stream.DoubleStream sorted() {
            DoubleStream FragmentBottomSheetPaymentSettingBinding = DoubleStream.this.FragmentBottomSheetPaymentSettingBinding();
            if (FragmentBottomSheetPaymentSettingBinding == null) {
                return null;
            }
            return FragmentBottomSheetPaymentSettingBinding instanceof VivifiedWrapper ? ((VivifiedWrapper) FragmentBottomSheetPaymentSettingBinding).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }
    }
}
