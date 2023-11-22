package j$.util;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;
import java.util.Spliterator;

/* loaded from: classes.dex */
public interface Spliterator<T> {
    int BuiltInFictitiousFunctionClassFactory();

    long KClassImpl$Data$declaredNonStaticMembers$2();

    boolean KClassImpl$Data$declaredNonStaticMembers$2(int i);

    boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer);

    Spliterator MyBillsEntityDataFactory();

    long PlaceComponentResult();

    java.util.Comparator getAuthRequestContext();

    void getAuthRequestContext(Consumer consumer);

    /* loaded from: classes.dex */
    public interface OfDouble extends OfPrimitive {
        void BuiltInFictitiousFunctionClassFactory(DoubleConsumer doubleConsumer);

        @Override // j$.util.Spliterator
        boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer);

        boolean PlaceComponentResult(DoubleConsumer doubleConsumer);

        @Override // j$.util.Spliterator
        void getAuthRequestContext(Consumer consumer);

        OfDouble getErrorConfigVersion();

        /* loaded from: classes6.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfDouble {
            final /* synthetic */ Spliterator.OfDouble MyBillsEntityDataFactory;

            private /* synthetic */ VivifiedWrapper(Spliterator.OfDouble ofDouble) {
                this.MyBillsEntityDataFactory = ofDouble;
            }

            public static /* synthetic */ OfDouble BuiltInFictitiousFunctionClassFactory(Spliterator.OfDouble ofDouble) {
                if (ofDouble == null) {
                    return null;
                }
                return ofDouble instanceof Wrapper ? OfDouble.this : new VivifiedWrapper(ofDouble);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
                return this.MyBillsEntityDataFactory.characteristics();
            }

            @Override // j$.util.Spliterator.OfDouble
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DoubleConsumer doubleConsumer) {
                this.MyBillsEntityDataFactory.forEachRemaining(DoubleConsumer.Wrapper.PlaceComponentResult(doubleConsumer));
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.MyBillsEntityDataFactory.estimateSize();
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                this.MyBillsEntityDataFactory.forEachRemaining((Spliterator.OfDouble) obj);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                return this.MyBillsEntityDataFactory.hasCharacteristics(i);
            }

            @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return this.MyBillsEntityDataFactory.tryAdvance(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ Spliterator MyBillsEntityDataFactory() {
                return VivifiedWrapper.getAuthRequestContext(this.MyBillsEntityDataFactory.trySplit());
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ boolean MyBillsEntityDataFactory(Object obj) {
                return this.MyBillsEntityDataFactory.tryAdvance((Spliterator.OfDouble) obj);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                return OfPrimitive.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.trySplit());
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long PlaceComponentResult() {
                return this.MyBillsEntityDataFactory.getExactSizeIfKnown();
            }

            @Override // j$.util.Spliterator.OfDouble
            public final /* synthetic */ boolean PlaceComponentResult(DoubleConsumer doubleConsumer) {
                return this.MyBillsEntityDataFactory.tryAdvance(DoubleConsumer.Wrapper.PlaceComponentResult(doubleConsumer));
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ java.util.Comparator getAuthRequestContext() {
                return this.MyBillsEntityDataFactory.getComparator();
            }

            @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                this.MyBillsEntityDataFactory.forEachRemaining(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.Spliterator.OfDouble
            public final /* synthetic */ OfDouble getErrorConfigVersion() {
                Spliterator.OfDouble trySplit = this.MyBillsEntityDataFactory.trySplit();
                if (trySplit == null) {
                    return null;
                }
                return trySplit instanceof Wrapper ? OfDouble.this : new VivifiedWrapper(trySplit);
            }
        }

        /* loaded from: classes6.dex */
        public final /* synthetic */ class Wrapper implements Spliterator.OfDouble {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Spliterator.OfDouble PlaceComponentResult(OfDouble ofDouble) {
                if (ofDouble == null) {
                    return null;
                }
                return ofDouble instanceof VivifiedWrapper ? ((VivifiedWrapper) ofDouble).MyBillsEntityDataFactory : new Wrapper();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ int characteristics() {
                return OfDouble.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ long estimateSize() {
                return OfDouble.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public final /* synthetic */ void forEachRemaining(java.util.function.DoubleConsumer doubleConsumer) {
                OfDouble.this.KClassImpl$Data$declaredNonStaticMembers$2(doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfDouble.this.getAuthRequestContext(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Spliterator.OfDouble
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public final /* synthetic */ void forEachRemaining2(java.util.function.DoubleConsumer doubleConsumer) {
                OfDouble.this.BuiltInFictitiousFunctionClassFactory(DoubleConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleConsumer));
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ java.util.Comparator getComparator() {
                return OfDouble.this.getAuthRequestContext();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ long getExactSizeIfKnown() {
                return OfDouble.this.PlaceComponentResult();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ boolean hasCharacteristics(int i) {
                return OfDouble.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public final /* synthetic */ boolean tryAdvance(java.util.function.DoubleConsumer doubleConsumer) {
                return OfDouble.this.MyBillsEntityDataFactory(doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
            public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
                return OfDouble.this.KClassImpl$Data$declaredNonStaticMembers$2(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Spliterator.OfDouble
            /* renamed from: tryAdvance  reason: avoid collision after fix types in other method */
            public final /* synthetic */ boolean tryAdvance2(java.util.function.DoubleConsumer doubleConsumer) {
                return OfDouble.this.PlaceComponentResult(DoubleConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleConsumer));
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return OfPrimitive.Wrapper.PlaceComponentResult(OfDouble.this.NetworkUserEntityData$$ExternalSyntheticLambda0());
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ java.util.Spliterator trySplit() {
                return Wrapper.BuiltInFictitiousFunctionClassFactory(OfDouble.this.MyBillsEntityDataFactory());
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ Spliterator.OfDouble trySplit() {
                OfDouble errorConfigVersion = OfDouble.this.getErrorConfigVersion();
                if (errorConfigVersion == null) {
                    return null;
                }
                return errorConfigVersion instanceof VivifiedWrapper ? ((VivifiedWrapper) errorConfigVersion).MyBillsEntityDataFactory : new Wrapper();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OfInt extends OfPrimitive {
        @Override // j$.util.Spliterator
        boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer);

        boolean MyBillsEntityDataFactory(IntConsumer intConsumer);

        @Override // j$.util.Spliterator
        void getAuthRequestContext(Consumer consumer);

        void getAuthRequestContext(IntConsumer intConsumer);

        OfInt getErrorConfigVersion();

        /* loaded from: classes6.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfInt {
            final /* synthetic */ Spliterator.OfInt BuiltInFictitiousFunctionClassFactory;

            private /* synthetic */ VivifiedWrapper(Spliterator.OfInt ofInt) {
                this.BuiltInFictitiousFunctionClassFactory = ofInt;
            }

            public static /* synthetic */ OfInt KClassImpl$Data$declaredNonStaticMembers$2(Spliterator.OfInt ofInt) {
                if (ofInt == null) {
                    return null;
                }
                return ofInt instanceof Wrapper ? OfInt.this : new VivifiedWrapper(ofInt);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
                return this.BuiltInFictitiousFunctionClassFactory.characteristics();
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.BuiltInFictitiousFunctionClassFactory.estimateSize();
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                this.BuiltInFictitiousFunctionClassFactory.forEachRemaining((Spliterator.OfInt) obj);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                return this.BuiltInFictitiousFunctionClassFactory.hasCharacteristics(i);
            }

            @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return this.BuiltInFictitiousFunctionClassFactory.tryAdvance(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ Spliterator MyBillsEntityDataFactory() {
                return VivifiedWrapper.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.trySplit());
            }

            @Override // j$.util.Spliterator.OfInt
            public final /* synthetic */ boolean MyBillsEntityDataFactory(IntConsumer intConsumer) {
                return this.BuiltInFictitiousFunctionClassFactory.tryAdvance(IntConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer));
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ boolean MyBillsEntityDataFactory(Object obj) {
                return this.BuiltInFictitiousFunctionClassFactory.tryAdvance((Spliterator.OfInt) obj);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                return OfPrimitive.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.trySplit());
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long PlaceComponentResult() {
                return this.BuiltInFictitiousFunctionClassFactory.getExactSizeIfKnown();
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ java.util.Comparator getAuthRequestContext() {
                return this.BuiltInFictitiousFunctionClassFactory.getComparator();
            }

            @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                this.BuiltInFictitiousFunctionClassFactory.forEachRemaining(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.Spliterator.OfInt
            public final /* synthetic */ void getAuthRequestContext(IntConsumer intConsumer) {
                this.BuiltInFictitiousFunctionClassFactory.forEachRemaining(IntConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer));
            }

            @Override // j$.util.Spliterator.OfInt
            public final /* synthetic */ OfInt getErrorConfigVersion() {
                Spliterator.OfInt trySplit = this.BuiltInFictitiousFunctionClassFactory.trySplit();
                if (trySplit == null) {
                    return null;
                }
                return trySplit instanceof Wrapper ? OfInt.this : new VivifiedWrapper(trySplit);
            }
        }

        /* loaded from: classes6.dex */
        public final /* synthetic */ class Wrapper implements Spliterator.OfInt {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Spliterator.OfInt getAuthRequestContext(OfInt ofInt) {
                if (ofInt == null) {
                    return null;
                }
                return ofInt instanceof VivifiedWrapper ? ((VivifiedWrapper) ofInt).BuiltInFictitiousFunctionClassFactory : new Wrapper();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ int characteristics() {
                return OfInt.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ long estimateSize() {
                return OfInt.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public final /* synthetic */ void forEachRemaining(java.util.function.IntConsumer intConsumer) {
                OfInt.this.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer);
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfInt.this.getAuthRequestContext(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Spliterator.OfInt
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public final /* synthetic */ void forEachRemaining2(java.util.function.IntConsumer intConsumer) {
                OfInt.this.getAuthRequestContext(IntConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(intConsumer));
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ java.util.Comparator getComparator() {
                return OfInt.this.getAuthRequestContext();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ long getExactSizeIfKnown() {
                return OfInt.this.PlaceComponentResult();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ boolean hasCharacteristics(int i) {
                return OfInt.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public final /* synthetic */ boolean tryAdvance(java.util.function.IntConsumer intConsumer) {
                return OfInt.this.MyBillsEntityDataFactory(intConsumer);
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator
            public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
                return OfInt.this.KClassImpl$Data$declaredNonStaticMembers$2(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Spliterator.OfInt
            /* renamed from: tryAdvance  reason: avoid collision after fix types in other method */
            public final /* synthetic */ boolean tryAdvance2(java.util.function.IntConsumer intConsumer) {
                return OfInt.this.MyBillsEntityDataFactory(IntConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(intConsumer));
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return OfPrimitive.Wrapper.PlaceComponentResult(OfInt.this.NetworkUserEntityData$$ExternalSyntheticLambda0());
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ java.util.Spliterator trySplit() {
                return Wrapper.BuiltInFictitiousFunctionClassFactory(OfInt.this.MyBillsEntityDataFactory());
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ Spliterator.OfInt trySplit() {
                OfInt errorConfigVersion = OfInt.this.getErrorConfigVersion();
                if (errorConfigVersion == null) {
                    return null;
                }
                return errorConfigVersion instanceof VivifiedWrapper ? ((VivifiedWrapper) errorConfigVersion).BuiltInFictitiousFunctionClassFactory : new Wrapper();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OfLong extends OfPrimitive {
        boolean BuiltInFictitiousFunctionClassFactory(LongConsumer longConsumer);

        @Override // j$.util.Spliterator
        boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer);

        @Override // j$.util.Spliterator
        void getAuthRequestContext(Consumer consumer);

        void getAuthRequestContext(LongConsumer longConsumer);

        OfLong moveToNextValue();

        /* loaded from: classes6.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfLong {
            final /* synthetic */ Spliterator.OfLong KClassImpl$Data$declaredNonStaticMembers$2;

            private /* synthetic */ VivifiedWrapper(Spliterator.OfLong ofLong) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = ofLong;
            }

            public static /* synthetic */ OfLong PlaceComponentResult(Spliterator.OfLong ofLong) {
                if (ofLong == null) {
                    return null;
                }
                return ofLong instanceof Wrapper ? OfLong.this : new VivifiedWrapper(ofLong);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.characteristics();
            }

            @Override // j$.util.Spliterator.OfLong
            public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(LongConsumer longConsumer) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.tryAdvance(LongConsumer.Wrapper.getAuthRequestContext(longConsumer));
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.estimateSize();
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining((Spliterator.OfLong) obj);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.hasCharacteristics(i);
            }

            @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.tryAdvance(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ Spliterator MyBillsEntityDataFactory() {
                return VivifiedWrapper.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.trySplit());
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ boolean MyBillsEntityDataFactory(Object obj) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.tryAdvance((Spliterator.OfLong) obj);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                return OfPrimitive.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.trySplit());
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long PlaceComponentResult() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.getExactSizeIfKnown();
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ java.util.Comparator getAuthRequestContext() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.getComparator();
            }

            @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.Spliterator.OfLong
            public final /* synthetic */ void getAuthRequestContext(LongConsumer longConsumer) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining(LongConsumer.Wrapper.getAuthRequestContext(longConsumer));
            }

            @Override // j$.util.Spliterator.OfLong
            public final /* synthetic */ OfLong moveToNextValue() {
                Spliterator.OfLong trySplit = this.KClassImpl$Data$declaredNonStaticMembers$2.trySplit();
                if (trySplit == null) {
                    return null;
                }
                return trySplit instanceof Wrapper ? OfLong.this : new VivifiedWrapper(trySplit);
            }
        }

        /* loaded from: classes6.dex */
        public final /* synthetic */ class Wrapper implements Spliterator.OfLong {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Spliterator.OfLong KClassImpl$Data$declaredNonStaticMembers$2(OfLong ofLong) {
                if (ofLong == null) {
                    return null;
                }
                return ofLong instanceof VivifiedWrapper ? ((VivifiedWrapper) ofLong).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ int characteristics() {
                return OfLong.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ long estimateSize() {
                return OfLong.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public final /* synthetic */ void forEachRemaining(java.util.function.LongConsumer longConsumer) {
                OfLong.this.KClassImpl$Data$declaredNonStaticMembers$2(longConsumer);
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfLong.this.getAuthRequestContext(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Spliterator.OfLong
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public final /* synthetic */ void forEachRemaining2(java.util.function.LongConsumer longConsumer) {
                OfLong.this.getAuthRequestContext(LongConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longConsumer));
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ java.util.Comparator getComparator() {
                return OfLong.this.getAuthRequestContext();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ long getExactSizeIfKnown() {
                return OfLong.this.PlaceComponentResult();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ boolean hasCharacteristics(int i) {
                return OfLong.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public final /* synthetic */ boolean tryAdvance(java.util.function.LongConsumer longConsumer) {
                return OfLong.this.MyBillsEntityDataFactory(longConsumer);
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator
            public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
                return OfLong.this.KClassImpl$Data$declaredNonStaticMembers$2(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Spliterator.OfLong
            /* renamed from: tryAdvance  reason: avoid collision after fix types in other method */
            public final /* synthetic */ boolean tryAdvance2(java.util.function.LongConsumer longConsumer) {
                return OfLong.this.BuiltInFictitiousFunctionClassFactory(LongConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longConsumer));
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return OfPrimitive.Wrapper.PlaceComponentResult(OfLong.this.NetworkUserEntityData$$ExternalSyntheticLambda0());
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ java.util.Spliterator trySplit() {
                return Wrapper.BuiltInFictitiousFunctionClassFactory(OfLong.this.MyBillsEntityDataFactory());
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ Spliterator.OfLong trySplit() {
                OfLong moveToNextValue = OfLong.this.moveToNextValue();
                if (moveToNextValue == null) {
                    return null;
                }
                return moveToNextValue instanceof VivifiedWrapper ? ((VivifiedWrapper) moveToNextValue).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OfPrimitive extends Spliterator {
        void KClassImpl$Data$declaredNonStaticMembers$2(Object obj);

        boolean MyBillsEntityDataFactory(Object obj);

        OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0();

        /* loaded from: classes6.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfPrimitive {
            final /* synthetic */ Spliterator.OfPrimitive getAuthRequestContext;

            private /* synthetic */ VivifiedWrapper(Spliterator.OfPrimitive ofPrimitive) {
                this.getAuthRequestContext = ofPrimitive;
            }

            public static /* synthetic */ OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(Spliterator.OfPrimitive ofPrimitive) {
                if (ofPrimitive == null) {
                    return null;
                }
                return ofPrimitive instanceof Wrapper ? OfPrimitive.this : new VivifiedWrapper(ofPrimitive);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
                return this.getAuthRequestContext.characteristics();
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.getAuthRequestContext.estimateSize();
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                this.getAuthRequestContext.forEachRemaining((Spliterator.OfPrimitive) obj);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                return this.getAuthRequestContext.hasCharacteristics(i);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return this.getAuthRequestContext.tryAdvance((java.util.function.Consumer) Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ Spliterator MyBillsEntityDataFactory() {
                return VivifiedWrapper.getAuthRequestContext(this.getAuthRequestContext.trySplit());
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ boolean MyBillsEntityDataFactory(Object obj) {
                return this.getAuthRequestContext.tryAdvance((Spliterator.OfPrimitive) obj);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long PlaceComponentResult() {
                return this.getAuthRequestContext.getExactSizeIfKnown();
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ java.util.Comparator getAuthRequestContext() {
                return this.getAuthRequestContext.getComparator();
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                this.getAuthRequestContext.forEachRemaining((java.util.function.Consumer) Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public final /* synthetic */ OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                Spliterator.OfPrimitive trySplit = this.getAuthRequestContext.trySplit();
                if (trySplit == null) {
                    return null;
                }
                return trySplit instanceof Wrapper ? OfPrimitive.this : new VivifiedWrapper(trySplit);
            }
        }

        /* loaded from: classes6.dex */
        public final /* synthetic */ class Wrapper implements Spliterator.OfPrimitive {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ Spliterator.OfPrimitive PlaceComponentResult(OfPrimitive ofPrimitive) {
                if (ofPrimitive == null) {
                    return null;
                }
                return ofPrimitive instanceof VivifiedWrapper ? ((VivifiedWrapper) ofPrimitive).getAuthRequestContext : new Wrapper();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ int characteristics() {
                return OfPrimitive.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ long estimateSize() {
                return OfPrimitive.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // java.util.Spliterator.OfPrimitive
            public final /* synthetic */ void forEachRemaining(Object obj) {
                OfPrimitive.this.KClassImpl$Data$declaredNonStaticMembers$2(obj);
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfPrimitive.this.getAuthRequestContext(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ java.util.Comparator getComparator() {
                return OfPrimitive.this.getAuthRequestContext();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ long getExactSizeIfKnown() {
                return OfPrimitive.this.PlaceComponentResult();
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ boolean hasCharacteristics(int i) {
                return OfPrimitive.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public final /* synthetic */ boolean tryAdvance(Object obj) {
                return OfPrimitive.this.MyBillsEntityDataFactory(obj);
            }

            @Override // java.util.Spliterator
            public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
                return OfPrimitive.this.KClassImpl$Data$declaredNonStaticMembers$2(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ java.util.Spliterator trySplit() {
                return Wrapper.BuiltInFictitiousFunctionClassFactory(OfPrimitive.this.MyBillsEntityDataFactory());
            }

            @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
                OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0 = OfPrimitive.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    return null;
                }
                return NetworkUserEntityData$$ExternalSyntheticLambda0 instanceof VivifiedWrapper ? ((VivifiedWrapper) NetworkUserEntityData$$ExternalSyntheticLambda0).getAuthRequestContext : new Wrapper();
            }
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements Spliterator {
        final /* synthetic */ java.util.Spliterator getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.Spliterator spliterator) {
            this.getAuthRequestContext = spliterator;
        }

        public static /* synthetic */ Spliterator getAuthRequestContext(java.util.Spliterator spliterator) {
            if (spliterator == null) {
                return null;
            }
            return spliterator instanceof Wrapper ? Spliterator.this : new VivifiedWrapper(spliterator);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext.characteristics();
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext.estimateSize();
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return this.getAuthRequestContext.hasCharacteristics(i);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return this.getAuthRequestContext.tryAdvance(Consumer.Wrapper.PlaceComponentResult(consumer));
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return this.getAuthRequestContext.getExactSizeIfKnown();
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ java.util.Comparator getAuthRequestContext() {
            return this.getAuthRequestContext.getComparator();
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            this.getAuthRequestContext.forEachRemaining(Consumer.Wrapper.PlaceComponentResult(consumer));
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ Spliterator MyBillsEntityDataFactory() {
            java.util.Spliterator<T> trySplit = this.getAuthRequestContext.trySplit();
            if (trySplit == null) {
                return null;
            }
            return trySplit instanceof Wrapper ? Spliterator.this : new VivifiedWrapper(trySplit);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.Spliterator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.Spliterator BuiltInFictitiousFunctionClassFactory(Spliterator spliterator) {
            if (spliterator == null) {
                return null;
            }
            return spliterator instanceof VivifiedWrapper ? ((VivifiedWrapper) spliterator).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.Spliterator
        public final /* synthetic */ int characteristics() {
            return Spliterator.this.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // java.util.Spliterator
        public final /* synthetic */ long estimateSize() {
            return Spliterator.this.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // java.util.Spliterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Spliterator.this.getAuthRequestContext(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Spliterator
        public final /* synthetic */ java.util.Comparator getComparator() {
            return Spliterator.this.getAuthRequestContext();
        }

        @Override // java.util.Spliterator
        public final /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.this.PlaceComponentResult();
        }

        @Override // java.util.Spliterator
        public final /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // java.util.Spliterator
        public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
            return Spliterator.this.KClassImpl$Data$declaredNonStaticMembers$2(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Spliterator
        public final /* synthetic */ java.util.Spliterator trySplit() {
            Spliterator MyBillsEntityDataFactory = Spliterator.this.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            return MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).getAuthRequestContext : new Wrapper();
        }
    }
}
