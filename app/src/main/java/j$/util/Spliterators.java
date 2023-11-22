package j$.util;

import j$.util.Iterator;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public final class Spliterators {
    private static final Spliterator BuiltInFictitiousFunctionClassFactory = new Spliterators$EmptySpliterator$OfRef();
    private static final Spliterator.OfInt KClassImpl$Data$declaredNonStaticMembers$2 = new Spliterators$EmptySpliterator$OfInt();
    private static final Spliterator.OfLong MyBillsEntityDataFactory = new Spliterators$EmptySpliterator$OfLong();
    private static final Spliterator.OfDouble getAuthRequestContext = new Spliterators$EmptySpliterator$OfDouble();

    /* renamed from: j$.util.Spliterators$1Adapter  reason: invalid class name */
    /* loaded from: classes.dex */
    final class C1Adapter implements java.util.Iterator, Consumer {
        Object BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
        final /* synthetic */ Spliterator PlaceComponentResult;

        C1Adapter(Spliterator spliterator) {
            this.PlaceComponentResult = spliterator;
        }

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.BuiltInFictitiousFunctionClassFactory = obj;
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this);
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 || hasNext()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                return this.BuiltInFictitiousFunctionClassFactory;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class ArraySpliterator implements Spliterator {
        private int BuiltInFictitiousFunctionClassFactory;
        private final Object[] MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        private final int getAuthRequestContext;

        public ArraySpliterator(Object[] objArr, int i, int i2, int i3) {
            this.MyBillsEntityDataFactory = objArr;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = i2;
            this.getAuthRequestContext = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult - this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            if (i < 0 || i >= this.PlaceComponentResult) {
                return false;
            }
            Object[] objArr = this.MyBillsEntityDataFactory;
            this.BuiltInFictitiousFunctionClassFactory = i + 1;
            consumer.accept(objArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        /* renamed from: MyBillsEntityDataFactory */
        public final Spliterator moveToNextValue() {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            int i2 = (this.PlaceComponentResult + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            Object[] objArr = this.MyBillsEntityDataFactory;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            return new ArraySpliterator(objArr, i, i2, this.getAuthRequestContext);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final java.util.Comparator getAuthRequestContext() {
            if (Objects.BuiltInFictitiousFunctionClassFactory(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public final void getAuthRequestContext(Consumer consumer) {
            int i;
            Object[] objArr = this.MyBillsEntityDataFactory;
            int length = objArr.length;
            int i2 = this.PlaceComponentResult;
            if (length < i2 || (i = this.BuiltInFictitiousFunctionClassFactory) < 0) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = i2;
            if (i >= i2) {
                return;
            }
            do {
                consumer.accept(objArr[i]);
                i++;
            } while (i < i2);
        }
    }

    /* loaded from: classes.dex */
    final class DoubleArraySpliterator implements Spliterator.OfDouble {
        private final double[] BuiltInFictitiousFunctionClassFactory;
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final int PlaceComponentResult;
        private int getAuthRequestContext;

        public DoubleArraySpliterator(double[] dArr, int i, int i2, int i3) {
            this.BuiltInFictitiousFunctionClassFactory = dArr;
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(DoubleConsumer doubleConsumer) {
            int i;
            double[] dArr = this.BuiltInFictitiousFunctionClassFactory;
            int length = dArr.length;
            int i2 = this.PlaceComponentResult;
            if (length < i2 || (i = this.getAuthRequestContext) < 0) {
                return;
            }
            this.getAuthRequestContext = i2;
            if (i >= i2) {
                return;
            }
            do {
                doubleConsumer.accept(dArr[i]);
                i++;
            } while (i < i2);
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult - this.getAuthRequestContext;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: PlaceComponentResult */
        public final boolean MyBillsEntityDataFactory(DoubleConsumer doubleConsumer) {
            int i = this.getAuthRequestContext;
            if (i < 0 || i >= this.PlaceComponentResult) {
                return false;
            }
            double[] dArr = this.BuiltInFictitiousFunctionClassFactory;
            this.getAuthRequestContext = i + 1;
            doubleConsumer.accept(dArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public final java.util.Comparator getAuthRequestContext() {
            if (Objects.BuiltInFictitiousFunctionClassFactory(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public final Spliterator.OfDouble moveToNextValue() {
            int i = this.getAuthRequestContext;
            int i2 = (this.PlaceComponentResult + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            double[] dArr = this.BuiltInFictitiousFunctionClassFactory;
            this.getAuthRequestContext = i2;
            return new DoubleArraySpliterator(dArr, i, i2, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes.dex */
    final class IntArraySpliterator implements Spliterator.OfInt {
        private final int[] BuiltInFictitiousFunctionClassFactory;
        private int KClassImpl$Data$declaredNonStaticMembers$2;
        private final int PlaceComponentResult;
        private final int getAuthRequestContext;

        public IntArraySpliterator(int[] iArr, int i, int i2, int i3) {
            this.BuiltInFictitiousFunctionClassFactory = iArr;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = i2;
            this.getAuthRequestContext = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult - this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.MyBillsEntityDataFactory((Spliterator.OfInt) this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public final boolean MyBillsEntityDataFactory(IntConsumer intConsumer) {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i < 0 || i >= this.PlaceComponentResult) {
                return false;
            }
            int[] iArr = this.BuiltInFictitiousFunctionClassFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
            intConsumer.accept(iArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final java.util.Comparator getAuthRequestContext() {
            if (Objects.BuiltInFictitiousFunctionClassFactory(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: getAuthRequestContext */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(IntConsumer intConsumer) {
            int i;
            int[] iArr = this.BuiltInFictitiousFunctionClassFactory;
            int length = iArr.length;
            int i2 = this.PlaceComponentResult;
            if (length < i2 || (i = this.KClassImpl$Data$declaredNonStaticMembers$2) < 0) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            if (i >= i2) {
                return;
            }
            do {
                intConsumer.accept(iArr[i]);
                i++;
            } while (i < i2);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: getErrorConfigVersion  reason: merged with bridge method [inline-methods] */
        public final Spliterator.OfInt moveToNextValue() {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i2 = (this.PlaceComponentResult + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            int[] iArr = this.BuiltInFictitiousFunctionClassFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            return new IntArraySpliterator(iArr, i, i2, this.getAuthRequestContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class IteratorSpliterator implements Spliterator {
        private long BuiltInFictitiousFunctionClassFactory;
        private final java.util.Collection KClassImpl$Data$declaredNonStaticMembers$2;
        private int MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        private java.util.Iterator getAuthRequestContext;

        public IteratorSpliterator(int i, java.util.Collection collection) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = collection;
            this.getAuthRequestContext = null;
            this.PlaceComponentResult = (i & 4096) == 0 ? i | 64 | 16384 : i;
        }

        public IteratorSpliterator(java.util.Iterator it) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.getAuthRequestContext = it;
            this.BuiltInFictitiousFunctionClassFactory = LongCompanionObject.MAX_VALUE;
            this.PlaceComponentResult = 16;
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                long size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
                this.BuiltInFictitiousFunctionClassFactory = size;
                return size;
            }
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                this.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
            }
            if (this.getAuthRequestContext.hasNext()) {
                consumer.accept(this.getAuthRequestContext.next());
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        /* renamed from: MyBillsEntityDataFactory */
        public final Spliterator moveToNextValue() {
            long j;
            java.util.Iterator it = this.getAuthRequestContext;
            if (it == null) {
                it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                this.getAuthRequestContext = it;
                j = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
                this.BuiltInFictitiousFunctionClassFactory = j;
            } else {
                j = this.BuiltInFictitiousFunctionClassFactory;
            }
            if (j <= 1 || !it.hasNext()) {
                return null;
            }
            int i = this.MyBillsEntityDataFactory + 1024;
            if (i > j) {
                i = (int) j;
            }
            if (i > 33554432) {
                i = 33554432;
            }
            Object[] objArr = new Object[i];
            int i2 = 0;
            do {
                objArr[i2] = it.next();
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (it.hasNext());
            this.MyBillsEntityDataFactory = i2;
            long j2 = this.BuiltInFictitiousFunctionClassFactory;
            if (j2 != LongCompanionObject.MAX_VALUE) {
                this.BuiltInFictitiousFunctionClassFactory = j2 - i2;
            }
            return new ArraySpliterator(objArr, 0, i2, this.PlaceComponentResult);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getAuthRequestContext() {
            if (Objects.BuiltInFictitiousFunctionClassFactory(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public final void getAuthRequestContext(Consumer consumer) {
            java.util.Iterator it = this.getAuthRequestContext;
            if (it == null) {
                it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                this.getAuthRequestContext = it;
                this.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
            }
            if (it instanceof Iterator) {
                ((Iterator) it).forEachRemaining(consumer);
            } else {
                Iterator.CC.getAuthRequestContext(it, consumer);
            }
        }
    }

    /* loaded from: classes.dex */
    final class LongArraySpliterator implements Spliterator.OfLong {
        private final int BuiltInFictitiousFunctionClassFactory;
        private int KClassImpl$Data$declaredNonStaticMembers$2;
        private final int PlaceComponentResult;
        private final long[] getAuthRequestContext;

        public LongArraySpliterator(long[] jArr, int i, int i2, int i3) {
            this.getAuthRequestContext = jArr;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = i2;
            this.BuiltInFictitiousFunctionClassFactory = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: BuiltInFictitiousFunctionClassFactory */
        public final boolean MyBillsEntityDataFactory(LongConsumer longConsumer) {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i < 0 || i >= this.PlaceComponentResult) {
                return false;
            }
            long[] jArr = this.getAuthRequestContext;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
            longConsumer.accept(jArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult - this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final java.util.Comparator getAuthRequestContext() {
            if (Objects.BuiltInFictitiousFunctionClassFactory(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.getAuthRequestContext(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: getAuthRequestContext */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(LongConsumer longConsumer) {
            int i;
            long[] jArr = this.getAuthRequestContext;
            int length = jArr.length;
            int i2 = this.PlaceComponentResult;
            if (length < i2 || (i = this.KClassImpl$Data$declaredNonStaticMembers$2) < 0) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            if (i >= i2) {
                return;
            }
            do {
                longConsumer.accept(jArr[i]);
                i++;
            } while (i < i2);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public final Spliterator.OfLong moveToNextValue() {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i2 = (this.PlaceComponentResult + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            long[] jArr = this.getAuthRequestContext;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            return new LongArraySpliterator(jArr, i, i2, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static Spliterator.OfDouble BuiltInFictitiousFunctionClassFactory(double[] dArr, int i, int i2) {
        MyBillsEntityDataFactory(dArr.length, i, i2);
        return new DoubleArraySpliterator(dArr, i, i2, 1040);
    }

    public static Spliterator.OfInt BuiltInFictitiousFunctionClassFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static PrimitiveIterator.OfInt KClassImpl$Data$declaredNonStaticMembers$2(Spliterator.OfInt ofInt) {
        return new C2Adapter(ofInt);
    }

    public static PrimitiveIterator.OfDouble MyBillsEntityDataFactory(Spliterator.OfDouble ofDouble) {
        return new C4Adapter(ofDouble);
    }

    public static Spliterator.OfInt MyBillsEntityDataFactory(int[] iArr, int i, int i2) {
        MyBillsEntityDataFactory(iArr.length, i, i2);
        return new IntArraySpliterator(iArr, i, i2, 1040);
    }

    public static Spliterator.OfLong MyBillsEntityDataFactory(long[] jArr, int i, int i2) {
        MyBillsEntityDataFactory(jArr.length, i, i2);
        return new LongArraySpliterator(jArr, i, i2, 1040);
    }

    public static Spliterator MyBillsEntityDataFactory() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static Spliterator MyBillsEntityDataFactory(Object[] objArr, int i, int i2) {
        MyBillsEntityDataFactory(objArr.length, i, i2);
        return new ArraySpliterator(objArr, i, i2, 1040);
    }

    public static java.util.Iterator MyBillsEntityDataFactory(Spliterator spliterator) {
        return new C1Adapter(spliterator);
    }

    private static void MyBillsEntityDataFactory(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException(i2);
            }
            if (i3 > i) {
                throw new ArrayIndexOutOfBoundsException(i3);
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin(");
        sb.append(i2);
        sb.append(") > fence(");
        sb.append(i3);
        sb.append(")");
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    public static Spliterator.OfLong PlaceComponentResult() {
        return MyBillsEntityDataFactory;
    }

    public static <T> Spliterator<T> PlaceComponentResult(java.util.Iterator<? extends T> it) {
        return new IteratorSpliterator(it);
    }

    public static PrimitiveIterator.OfLong getAuthRequestContext(Spliterator.OfLong ofLong) {
        return new C3Adapter(ofLong);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.Spliterators$2Adapter  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class C2Adapter implements PrimitiveIterator.OfInt, IntConsumer, Iterator {
        boolean BuiltInFictitiousFunctionClassFactory = false;
        final /* synthetic */ Spliterator.OfInt KClassImpl$Data$declaredNonStaticMembers$2;
        int PlaceComponentResult;

        C2Adapter(Spliterator.OfInt ofInt) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ofInt;
        }

        @Override // j$.util.function.IntConsumer
        public final void accept(int i) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.PlaceComponentResult = i;
        }

        @Override // j$.util.function.IntConsumer
        public final IntConsumer andThen(IntConsumer intConsumer) {
            return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
        }

        @Override // j$.util.PrimitiveIterator.OfInt
        public final int getAuthRequestContext() {
            if (this.BuiltInFictitiousFunctionClassFactory || hasNext()) {
                this.BuiltInFictitiousFunctionClassFactory = false;
                return this.PlaceComponentResult;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (!this.BuiltInFictitiousFunctionClassFactory) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory((IntConsumer) this);
            }
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // j$.util.PrimitiveIterator.OfInt, j$.util.Iterator
        public final void forEachRemaining(Consumer consumer) {
            if (consumer instanceof IntConsumer) {
                IntConsumer intConsumer = (IntConsumer) consumer;
                while (hasNext()) {
                    if (!this.BuiltInFictitiousFunctionClassFactory && !hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.BuiltInFictitiousFunctionClassFactory = false;
                    intConsumer.accept(this.PlaceComponentResult);
                }
            } else if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C2Adapter.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
                throw null;
            } else {
                PrimitiveIterator$OfInt$$ExternalSyntheticLambda0 primitiveIterator$OfInt$$ExternalSyntheticLambda0 = new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer);
                while (hasNext()) {
                    if (!this.BuiltInFictitiousFunctionClassFactory && !hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.BuiltInFictitiousFunctionClassFactory = false;
                    primitiveIterator$OfInt$$ExternalSyntheticLambda0.accept(this.PlaceComponentResult);
                }
            }
        }

        @Override // j$.util.PrimitiveIterator.OfInt
        public final void PlaceComponentResult(IntConsumer intConsumer) {
            while (hasNext()) {
                if (!this.BuiltInFictitiousFunctionClassFactory && !hasNext()) {
                    throw new NoSuchElementException();
                }
                this.BuiltInFictitiousFunctionClassFactory = false;
                intConsumer.accept(this.PlaceComponentResult);
            }
        }

        @Override // j$.util.PrimitiveIterator
        public final /* synthetic */ void MyBillsEntityDataFactory(Object obj) {
            IntConsumer intConsumer = (IntConsumer) obj;
            while (hasNext()) {
                if (!this.BuiltInFictitiousFunctionClassFactory && !hasNext()) {
                    throw new NoSuchElementException();
                }
                this.BuiltInFictitiousFunctionClassFactory = false;
                intConsumer.accept(this.PlaceComponentResult);
            }
        }

        @Override // j$.util.PrimitiveIterator.OfInt
        public final Integer MyBillsEntityDataFactory() {
            if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C2Adapter.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
                throw null;
            } else if (this.BuiltInFictitiousFunctionClassFactory || hasNext()) {
                this.BuiltInFictitiousFunctionClassFactory = false;
                return Integer.valueOf(this.PlaceComponentResult);
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C2Adapter.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
                throw null;
            } else if (this.BuiltInFictitiousFunctionClassFactory || hasNext()) {
                this.BuiltInFictitiousFunctionClassFactory = false;
                return Integer.valueOf(this.PlaceComponentResult);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    /* renamed from: j$.util.Spliterators$3Adapter  reason: invalid class name */
    /* loaded from: classes.dex */
    final class C3Adapter implements PrimitiveIterator.OfLong, LongConsumer, Iterator {
        long BuiltInFictitiousFunctionClassFactory;
        boolean PlaceComponentResult = false;
        final /* synthetic */ Spliterator.OfLong getAuthRequestContext;

        C3Adapter(Spliterator.OfLong ofLong) {
            this.getAuthRequestContext = ofLong;
        }

        @Override // j$.util.PrimitiveIterator.OfLong
        public final long BuiltInFictitiousFunctionClassFactory() {
            if (this.PlaceComponentResult || hasNext()) {
                this.PlaceComponentResult = false;
                return this.BuiltInFictitiousFunctionClassFactory;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.function.LongConsumer
        public final void accept(long j) {
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory = j;
        }

        @Override // j$.util.function.LongConsumer
        public final LongConsumer andThen(LongConsumer longConsumer) {
            return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (!this.PlaceComponentResult) {
                this.getAuthRequestContext.MyBillsEntityDataFactory(this);
            }
            return this.PlaceComponentResult;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // j$.util.PrimitiveIterator.OfLong, j$.util.Iterator
        public final void forEachRemaining(Consumer consumer) {
            if (consumer instanceof LongConsumer) {
                LongConsumer longConsumer = (LongConsumer) consumer;
                while (hasNext()) {
                    if (!this.PlaceComponentResult && !hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.PlaceComponentResult = false;
                    longConsumer.accept(this.BuiltInFictitiousFunctionClassFactory);
                }
            } else if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C3Adapter.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
                throw null;
            } else {
                PrimitiveIterator$OfLong$$ExternalSyntheticLambda0 primitiveIterator$OfLong$$ExternalSyntheticLambda0 = new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer);
                while (hasNext()) {
                    if (!this.PlaceComponentResult && !hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.PlaceComponentResult = false;
                    primitiveIterator$OfLong$$ExternalSyntheticLambda0.accept(this.BuiltInFictitiousFunctionClassFactory);
                }
            }
        }

        @Override // j$.util.PrimitiveIterator.OfLong
        public final void PlaceComponentResult(LongConsumer longConsumer) {
            while (hasNext()) {
                if (!this.PlaceComponentResult && !hasNext()) {
                    throw new NoSuchElementException();
                }
                this.PlaceComponentResult = false;
                longConsumer.accept(this.BuiltInFictitiousFunctionClassFactory);
            }
        }

        @Override // j$.util.PrimitiveIterator
        public final /* synthetic */ void MyBillsEntityDataFactory(Object obj) {
            LongConsumer longConsumer = (LongConsumer) obj;
            while (hasNext()) {
                if (!this.PlaceComponentResult && !hasNext()) {
                    throw new NoSuchElementException();
                }
                this.PlaceComponentResult = false;
                longConsumer.accept(this.BuiltInFictitiousFunctionClassFactory);
            }
        }

        @Override // j$.util.PrimitiveIterator.OfLong
        public final Long PlaceComponentResult() {
            if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C3Adapter.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
                throw null;
            } else if (this.PlaceComponentResult || hasNext()) {
                this.PlaceComponentResult = false;
                return Long.valueOf(this.BuiltInFictitiousFunctionClassFactory);
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C3Adapter.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
                throw null;
            } else if (this.PlaceComponentResult || hasNext()) {
                this.PlaceComponentResult = false;
                return Long.valueOf(this.BuiltInFictitiousFunctionClassFactory);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    /* renamed from: j$.util.Spliterators$4Adapter  reason: invalid class name */
    /* loaded from: classes.dex */
    final class C4Adapter implements PrimitiveIterator.OfDouble, DoubleConsumer, Iterator {
        final /* synthetic */ Spliterator.OfDouble KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory = false;
        double PlaceComponentResult;

        C4Adapter(Spliterator.OfDouble ofDouble) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ofDouble;
        }

        @Override // j$.util.PrimitiveIterator.OfDouble
        public final double MyBillsEntityDataFactory() {
            if (this.MyBillsEntityDataFactory || hasNext()) {
                this.MyBillsEntityDataFactory = false;
                return this.PlaceComponentResult;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.function.DoubleConsumer
        public final void accept(double d) {
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult = d;
        }

        @Override // j$.util.function.DoubleConsumer
        public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (!this.MyBillsEntityDataFactory) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this);
            }
            return this.MyBillsEntityDataFactory;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // j$.util.PrimitiveIterator.OfDouble, j$.util.Iterator
        public final void forEachRemaining(Consumer consumer) {
            if (consumer instanceof DoubleConsumer) {
                DoubleConsumer doubleConsumer = (DoubleConsumer) consumer;
                while (hasNext()) {
                    if (!this.MyBillsEntityDataFactory && !hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.MyBillsEntityDataFactory = false;
                    doubleConsumer.accept(this.PlaceComponentResult);
                }
            } else if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C4Adapter.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
                throw null;
            } else {
                PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0 primitiveIterator$OfDouble$$ExternalSyntheticLambda0 = new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer);
                while (hasNext()) {
                    if (!this.MyBillsEntityDataFactory && !hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.MyBillsEntityDataFactory = false;
                    primitiveIterator$OfDouble$$ExternalSyntheticLambda0.accept(this.PlaceComponentResult);
                }
            }
        }

        @Override // j$.util.PrimitiveIterator.OfDouble
        public final void PlaceComponentResult(DoubleConsumer doubleConsumer) {
            while (hasNext()) {
                if (!this.MyBillsEntityDataFactory && !hasNext()) {
                    throw new NoSuchElementException();
                }
                this.MyBillsEntityDataFactory = false;
                doubleConsumer.accept(this.PlaceComponentResult);
            }
        }

        @Override // j$.util.PrimitiveIterator
        public final /* synthetic */ void MyBillsEntityDataFactory(Object obj) {
            DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
            while (hasNext()) {
                if (!this.MyBillsEntityDataFactory && !hasNext()) {
                    throw new NoSuchElementException();
                }
                this.MyBillsEntityDataFactory = false;
                doubleConsumer.accept(this.PlaceComponentResult);
            }
        }

        @Override // j$.util.PrimitiveIterator.OfDouble
        public final Double KClassImpl$Data$declaredNonStaticMembers$2() {
            if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C4Adapter.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
                throw null;
            } else if (this.MyBillsEntityDataFactory || hasNext()) {
                this.MyBillsEntityDataFactory = false;
                return Double.valueOf(this.PlaceComponentResult);
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            if (Tripwire.MyBillsEntityDataFactory) {
                Tripwire.MyBillsEntityDataFactory(C4Adapter.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
                throw null;
            } else if (this.MyBillsEntityDataFactory || hasNext()) {
                this.MyBillsEntityDataFactory = false;
                return Double.valueOf(this.PlaceComponentResult);
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
