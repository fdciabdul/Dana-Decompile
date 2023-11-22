package j$.util;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;
import java.util.PrimitiveIterator;

/* loaded from: classes.dex */
public interface PrimitiveIterator extends java.util.Iterator {

    /* loaded from: classes.dex */
    public interface OfDouble extends PrimitiveIterator {

        /* loaded from: classes6.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfDouble, Iterator {
            final /* synthetic */ PrimitiveIterator.OfDouble KClassImpl$Data$declaredNonStaticMembers$2;

            private /* synthetic */ VivifiedWrapper(PrimitiveIterator.OfDouble ofDouble) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = ofDouble;
            }

            public static /* synthetic */ OfDouble KClassImpl$Data$declaredNonStaticMembers$2(PrimitiveIterator.OfDouble ofDouble) {
                if (ofDouble == null) {
                    return null;
                }
                return ofDouble instanceof Wrapper ? OfDouble.this : new VivifiedWrapper(ofDouble);
            }

            @Override // j$.util.PrimitiveIterator.OfDouble
            public final /* synthetic */ Double KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.next();
            }

            @Override // j$.util.PrimitiveIterator.OfDouble
            public final /* synthetic */ double MyBillsEntityDataFactory() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.nextDouble();
            }

            @Override // j$.util.PrimitiveIterator
            public final /* synthetic */ void MyBillsEntityDataFactory(Object obj) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining((PrimitiveIterator.OfDouble) obj);
            }

            @Override // j$.util.PrimitiveIterator.OfDouble
            public final /* synthetic */ void PlaceComponentResult(DoubleConsumer doubleConsumer) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining(DoubleConsumer.Wrapper.PlaceComponentResult(doubleConsumer));
            }

            @Override // j$.util.PrimitiveIterator.OfDouble, j$.util.Iterator
            public final /* synthetic */ void forEachRemaining(Consumer consumer) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Iterator
            public final /* synthetic */ boolean hasNext() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.hasNext();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ Object next() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.next();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void remove() {
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove();
            }
        }

        /* loaded from: classes6.dex */
        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfDouble {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ PrimitiveIterator.OfDouble BuiltInFictitiousFunctionClassFactory(OfDouble ofDouble) {
                if (ofDouble == null) {
                    return null;
                }
                return ofDouble instanceof VivifiedWrapper ? ((VivifiedWrapper) ofDouble).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
            }

            @Override // java.util.PrimitiveIterator
            public final /* synthetic */ void forEachRemaining(java.util.function.DoubleConsumer doubleConsumer) {
                OfDouble.this.MyBillsEntityDataFactory(doubleConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfDouble.this.forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public final /* synthetic */ void forEachRemaining2(java.util.function.DoubleConsumer doubleConsumer) {
                OfDouble.this.PlaceComponentResult(DoubleConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleConsumer));
            }

            @Override // java.util.Iterator
            public final /* synthetic */ boolean hasNext() {
                return OfDouble.this.hasNext();
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public final /* synthetic */ Double next() {
                return OfDouble.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
            public final /* synthetic */ Object next() {
                return OfDouble.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            public final /* synthetic */ double nextDouble() {
                return OfDouble.this.MyBillsEntityDataFactory();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void remove() {
                OfDouble.this.remove();
            }
        }

        Double KClassImpl$Data$declaredNonStaticMembers$2();

        double MyBillsEntityDataFactory();

        void PlaceComponentResult(DoubleConsumer doubleConsumer);

        void forEachRemaining(Consumer consumer);
    }

    /* loaded from: classes.dex */
    public interface OfInt extends PrimitiveIterator {

        /* loaded from: classes6.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfInt, Iterator {
            final /* synthetic */ PrimitiveIterator.OfInt MyBillsEntityDataFactory;

            private /* synthetic */ VivifiedWrapper(PrimitiveIterator.OfInt ofInt) {
                this.MyBillsEntityDataFactory = ofInt;
            }

            public static /* synthetic */ OfInt getAuthRequestContext(PrimitiveIterator.OfInt ofInt) {
                if (ofInt == null) {
                    return null;
                }
                return ofInt instanceof Wrapper ? OfInt.this : new VivifiedWrapper(ofInt);
            }

            @Override // j$.util.PrimitiveIterator.OfInt
            public final /* synthetic */ Integer MyBillsEntityDataFactory() {
                return this.MyBillsEntityDataFactory.next();
            }

            @Override // j$.util.PrimitiveIterator
            public final /* synthetic */ void MyBillsEntityDataFactory(Object obj) {
                this.MyBillsEntityDataFactory.forEachRemaining((PrimitiveIterator.OfInt) obj);
            }

            @Override // j$.util.PrimitiveIterator.OfInt
            public final /* synthetic */ void PlaceComponentResult(IntConsumer intConsumer) {
                this.MyBillsEntityDataFactory.forEachRemaining(IntConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer));
            }

            @Override // j$.util.PrimitiveIterator.OfInt, j$.util.Iterator
            public final /* synthetic */ void forEachRemaining(Consumer consumer) {
                this.MyBillsEntityDataFactory.forEachRemaining(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // j$.util.PrimitiveIterator.OfInt
            public final /* synthetic */ int getAuthRequestContext() {
                return this.MyBillsEntityDataFactory.nextInt();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ boolean hasNext() {
                return this.MyBillsEntityDataFactory.hasNext();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ Object next() {
                return this.MyBillsEntityDataFactory.next();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void remove() {
                this.MyBillsEntityDataFactory.remove();
            }
        }

        /* loaded from: classes6.dex */
        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfInt {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ PrimitiveIterator.OfInt BuiltInFictitiousFunctionClassFactory(OfInt ofInt) {
                if (ofInt == null) {
                    return null;
                }
                return ofInt instanceof VivifiedWrapper ? ((VivifiedWrapper) ofInt).MyBillsEntityDataFactory : new Wrapper();
            }

            @Override // java.util.PrimitiveIterator
            public final /* synthetic */ void forEachRemaining(java.util.function.IntConsumer intConsumer) {
                OfInt.this.MyBillsEntityDataFactory(intConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfInt.this.forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.PrimitiveIterator.OfInt
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public final /* synthetic */ void forEachRemaining2(java.util.function.IntConsumer intConsumer) {
                OfInt.this.PlaceComponentResult(IntConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(intConsumer));
            }

            @Override // java.util.Iterator
            public final /* synthetic */ boolean hasNext() {
                return OfInt.this.hasNext();
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public final /* synthetic */ Integer next() {
                return OfInt.this.MyBillsEntityDataFactory();
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
            public final /* synthetic */ Object next() {
                return OfInt.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfInt
            public final /* synthetic */ int nextInt() {
                return OfInt.this.getAuthRequestContext();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void remove() {
                OfInt.this.remove();
            }
        }

        Integer MyBillsEntityDataFactory();

        void PlaceComponentResult(IntConsumer intConsumer);

        void forEachRemaining(Consumer consumer);

        int getAuthRequestContext();
    }

    /* loaded from: classes.dex */
    public interface OfLong extends PrimitiveIterator {

        /* loaded from: classes6.dex */
        public final /* synthetic */ class VivifiedWrapper implements OfLong, Iterator {
            final /* synthetic */ PrimitiveIterator.OfLong KClassImpl$Data$declaredNonStaticMembers$2;

            private /* synthetic */ VivifiedWrapper(PrimitiveIterator.OfLong ofLong) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = ofLong;
            }

            public static /* synthetic */ OfLong MyBillsEntityDataFactory(PrimitiveIterator.OfLong ofLong) {
                if (ofLong == null) {
                    return null;
                }
                return ofLong instanceof Wrapper ? OfLong.this : new VivifiedWrapper(ofLong);
            }

            @Override // j$.util.PrimitiveIterator.OfLong
            public final /* synthetic */ long BuiltInFictitiousFunctionClassFactory() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.nextLong();
            }

            @Override // j$.util.PrimitiveIterator
            public final /* synthetic */ void MyBillsEntityDataFactory(Object obj) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining((PrimitiveIterator.OfLong) obj);
            }

            @Override // j$.util.PrimitiveIterator.OfLong
            public final /* synthetic */ Long PlaceComponentResult() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.next();
            }

            @Override // j$.util.PrimitiveIterator.OfLong
            public final /* synthetic */ void PlaceComponentResult(LongConsumer longConsumer) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining(LongConsumer.Wrapper.getAuthRequestContext(longConsumer));
            }

            @Override // j$.util.PrimitiveIterator.OfLong, j$.util.Iterator
            public final /* synthetic */ void forEachRemaining(Consumer consumer) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.forEachRemaining(Consumer.Wrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.Iterator
            public final /* synthetic */ boolean hasNext() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.hasNext();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ Object next() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.next();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void remove() {
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove();
            }
        }

        /* loaded from: classes6.dex */
        public final /* synthetic */ class Wrapper implements PrimitiveIterator.OfLong {
            private /* synthetic */ Wrapper() {
            }

            public static /* synthetic */ PrimitiveIterator.OfLong PlaceComponentResult(OfLong ofLong) {
                if (ofLong == null) {
                    return null;
                }
                return ofLong instanceof VivifiedWrapper ? ((VivifiedWrapper) ofLong).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
            }

            @Override // java.util.PrimitiveIterator
            public final /* synthetic */ void forEachRemaining(java.util.function.LongConsumer longConsumer) {
                OfLong.this.MyBillsEntityDataFactory(longConsumer);
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                OfLong.this.forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            @Override // java.util.PrimitiveIterator.OfLong
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public final /* synthetic */ void forEachRemaining2(java.util.function.LongConsumer longConsumer) {
                OfLong.this.PlaceComponentResult(LongConsumer.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longConsumer));
            }

            @Override // java.util.Iterator
            public final /* synthetic */ boolean hasNext() {
                return OfLong.this.hasNext();
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public final /* synthetic */ Long next() {
                return OfLong.this.PlaceComponentResult();
            }

            @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
            public final /* synthetic */ Object next() {
                return OfLong.this.next();
            }

            @Override // java.util.PrimitiveIterator.OfLong
            public final /* synthetic */ long nextLong() {
                return OfLong.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ void remove() {
                OfLong.this.remove();
            }
        }

        long BuiltInFictitiousFunctionClassFactory();

        Long PlaceComponentResult();

        void PlaceComponentResult(LongConsumer longConsumer);

        void forEachRemaining(Consumer consumer);
    }

    void MyBillsEntityDataFactory(Object obj);
}
