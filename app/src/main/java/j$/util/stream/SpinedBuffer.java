package j$.util.stream;

import j$.lang.Iterable;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SpinedBuffer extends AbstractSpinedBuffer implements Consumer, Iterable, Iterable {
    protected Object[] BuiltInFictitiousFunctionClassFactory = new Object[16];
    protected Object[][] moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.SpinedBuffer$1Splitr  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class C1Splitr implements Spliterator {
        final int BuiltInFictitiousFunctionClassFactory;
        Object[] KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        final int getAuthRequestContext;

        C1Splitr(int i, int i2, int i3, int i4) {
            this.MyBillsEntityDataFactory = i;
            this.getAuthRequestContext = i2;
            this.PlaceComponentResult = i3;
            this.BuiltInFictitiousFunctionClassFactory = i4;
            Object[][] objArr = SpinedBuffer.this.moveToNextValue;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = objArr == null ? SpinedBuffer.this.BuiltInFictitiousFunctionClassFactory : objArr[i];
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return 16464;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            int i = this.MyBillsEntityDataFactory;
            int i2 = this.getAuthRequestContext;
            if (i == i2) {
                return this.BuiltInFictitiousFunctionClassFactory - this.PlaceComponentResult;
            }
            long[] jArr = SpinedBuffer.this.PlaceComponentResult;
            return ((jArr[i2] + this.BuiltInFictitiousFunctionClassFactory) - jArr[i]) - this.PlaceComponentResult;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            int i = this.MyBillsEntityDataFactory;
            int i2 = this.getAuthRequestContext;
            if (i < i2 || (i == i2 && this.PlaceComponentResult < this.BuiltInFictitiousFunctionClassFactory)) {
                Object[] objArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i3 = this.PlaceComponentResult;
                this.PlaceComponentResult = i3 + 1;
                consumer.accept(objArr[i3]);
                if (this.PlaceComponentResult == this.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                    this.PlaceComponentResult = 0;
                    int i4 = this.MyBillsEntityDataFactory + 1;
                    this.MyBillsEntityDataFactory = i4;
                    Object[][] objArr2 = SpinedBuffer.this.moveToNextValue;
                    if (objArr2 != null && i4 <= this.getAuthRequestContext) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = objArr2[i4];
                    }
                }
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        /* renamed from: MyBillsEntityDataFactory */
        public final Spliterator moveToNextValue() {
            int i = this.MyBillsEntityDataFactory;
            int i2 = this.getAuthRequestContext;
            if (i < i2) {
                SpinedBuffer spinedBuffer = SpinedBuffer.this;
                int i3 = i2 - 1;
                C1Splitr c1Splitr = new C1Splitr(i, i3, this.PlaceComponentResult, spinedBuffer.moveToNextValue[i3].length);
                int i4 = this.getAuthRequestContext;
                this.MyBillsEntityDataFactory = i4;
                this.PlaceComponentResult = 0;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = SpinedBuffer.this.moveToNextValue[i4];
                return c1Splitr;
            } else if (i == i2) {
                int i5 = this.BuiltInFictitiousFunctionClassFactory;
                int i6 = this.PlaceComponentResult;
                int i7 = (i5 - i6) / 2;
                if (i7 == 0) {
                    return null;
                }
                Spliterator MyBillsEntityDataFactory = Spliterators.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, i6, i6 + i7);
                this.PlaceComponentResult += i7;
                return MyBillsEntityDataFactory;
            } else {
                return null;
            }
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public final void getAuthRequestContext(Consumer consumer) {
            int i;
            int i2 = this.MyBillsEntityDataFactory;
            int i3 = this.getAuthRequestContext;
            if (i2 < i3 || (i2 == i3 && this.PlaceComponentResult < this.BuiltInFictitiousFunctionClassFactory)) {
                int i4 = this.PlaceComponentResult;
                while (true) {
                    i = this.getAuthRequestContext;
                    if (i2 >= i) {
                        break;
                    }
                    Object[] objArr = SpinedBuffer.this.moveToNextValue[i2];
                    while (i4 < objArr.length) {
                        consumer.accept(objArr[i4]);
                        i4++;
                    }
                    i4 = 0;
                    i2++;
                }
                Object[] objArr2 = this.MyBillsEntityDataFactory == i ? this.KClassImpl$Data$declaredNonStaticMembers$2 : SpinedBuffer.this.moveToNextValue[i];
                int i5 = this.BuiltInFictitiousFunctionClassFactory;
                while (i4 < i5) {
                    consumer.accept(objArr2[i4]);
                    i4++;
                }
                this.MyBillsEntityDataFactory = this.getAuthRequestContext;
                this.PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OfDouble extends OfPrimitive implements DoubleConsumer {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.SpinedBuffer$OfDouble$1Splitr  reason: invalid class name */
        /* loaded from: classes.dex */
        public final class C1Splitr extends OfPrimitive.BaseSpliterator implements Spliterator.OfDouble {
            C1Splitr(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final Spliterator.OfPrimitive BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4) {
                return new C1Splitr(i, i2, i3, i4);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final Spliterator.OfPrimitive MyBillsEntityDataFactory(Object obj, int i, int i2) {
                return Spliterators.BuiltInFictitiousFunctionClassFactory((double[]) obj, i, i2 + i);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final void MyBillsEntityDataFactory(int i, Object obj, Object obj2) {
                ((DoubleConsumer) obj2).accept(((double[]) obj)[i]);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                Objects.PlaceComponentResult(this, consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfDouble() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfDouble(int i) {
            super(i);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final int KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            return ((double[]) obj).length;
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public Spliterator.OfDouble KClassImpl$Data$declaredNonStaticMembers$2() {
            return new C1Splitr(0, this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.getAuthRequestContext);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final void PlaceComponentResult(Object obj, int i, int i2, Object obj2) {
            double[] dArr = (double[]) obj;
            DoubleConsumer doubleConsumer = (DoubleConsumer) obj2;
            while (i < i2) {
                doubleConsumer.accept(dArr[i]);
                i++;
            }
        }

        public void accept(double d) {
            scheduleImpl();
            double[] dArr = (double[]) this.BuiltInFictitiousFunctionClassFactory;
            int i = this.getAuthRequestContext;
            this.getAuthRequestContext = i + 1;
            dArr[i] = d;
        }

        @Override // j$.util.function.DoubleConsumer
        public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
        }

        @Override // j$.lang.Iterable
        public final void forEach(Consumer consumer) {
            if (consumer instanceof DoubleConsumer) {
                getAuthRequestContext((DoubleConsumer) consumer);
            } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                throw null;
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(consumer);
            }
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public final Object getAuthRequestContext(int i) {
            return new double[i];
        }

        @Override // java.lang.Iterable
        public final Iterator iterator() {
            return Spliterators.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2());
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final Object[] moveToNextValue() {
            return new double[8];
        }

        public final String toString() {
            double[] dArr = (double[]) getErrorConfigVersion();
            return dArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), Arrays.toString(dArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), Arrays.toString(Arrays.copyOf(dArr, 200)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OfInt extends OfPrimitive implements IntConsumer {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.SpinedBuffer$OfInt$1Splitr  reason: invalid class name */
        /* loaded from: classes.dex */
        public final class C1Splitr extends OfPrimitive.BaseSpliterator implements Spliterator.OfInt {
            C1Splitr(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final Spliterator.OfPrimitive BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4) {
                return new C1Splitr(i, i2, i3, i4);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return Objects.MyBillsEntityDataFactory((Spliterator.OfInt) this, consumer);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final Spliterator.OfPrimitive MyBillsEntityDataFactory(Object obj, int i, int i2) {
                return Spliterators.MyBillsEntityDataFactory((int[]) obj, i, i2 + i);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final void MyBillsEntityDataFactory(int i, Object obj, Object obj2) {
                ((IntConsumer) obj2).accept(((int[]) obj)[i]);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfInt() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfInt(int i) {
            super(i);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final int KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            return ((int[]) obj).length;
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public Spliterator.OfInt KClassImpl$Data$declaredNonStaticMembers$2() {
            return new C1Splitr(0, this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.getAuthRequestContext);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final void PlaceComponentResult(Object obj, int i, int i2, Object obj2) {
            int[] iArr = (int[]) obj;
            IntConsumer intConsumer = (IntConsumer) obj2;
            while (i < i2) {
                intConsumer.accept(iArr[i]);
                i++;
            }
        }

        public void accept(int i) {
            scheduleImpl();
            int[] iArr = (int[]) this.BuiltInFictitiousFunctionClassFactory;
            int i2 = this.getAuthRequestContext;
            this.getAuthRequestContext = i2 + 1;
            iArr[i2] = i;
        }

        @Override // j$.util.function.IntConsumer
        public final IntConsumer andThen(IntConsumer intConsumer) {
            return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
        }

        @Override // j$.lang.Iterable
        public final void forEach(Consumer consumer) {
            if (consumer instanceof IntConsumer) {
                getAuthRequestContext((IntConsumer) consumer);
            } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                throw null;
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(consumer);
            }
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public final Object getAuthRequestContext(int i) {
            return new int[i];
        }

        @Override // java.lang.Iterable
        public final Iterator iterator() {
            return Spliterators.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2());
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final Object[] moveToNextValue() {
            return new int[8];
        }

        public final String toString() {
            int[] iArr = (int[]) getErrorConfigVersion();
            return iArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), Arrays.toString(iArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), Arrays.toString(Arrays.copyOf(iArr, 200)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OfLong extends OfPrimitive implements LongConsumer {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.SpinedBuffer$OfLong$1Splitr  reason: invalid class name */
        /* loaded from: classes.dex */
        public final class C1Splitr extends OfPrimitive.BaseSpliterator implements Spliterator.OfLong {
            C1Splitr(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final Spliterator.OfPrimitive BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4) {
                return new C1Splitr(i, i2, i3, i4);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return Objects.PlaceComponentResult(this, consumer);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final Spliterator.OfPrimitive MyBillsEntityDataFactory(Object obj, int i, int i2) {
                return Spliterators.MyBillsEntityDataFactory((long[]) obj, i, i2 + i);
            }

            @Override // j$.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            final void MyBillsEntityDataFactory(int i, Object obj, Object obj2) {
                ((LongConsumer) obj2).accept(((long[]) obj)[i]);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                Objects.getAuthRequestContext(this, consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfLong() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfLong(int i) {
            super(i);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final int KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            return ((long[]) obj).length;
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final void PlaceComponentResult(Object obj, int i, int i2, Object obj2) {
            long[] jArr = (long[]) obj;
            LongConsumer longConsumer = (LongConsumer) obj2;
            while (i < i2) {
                longConsumer.accept(jArr[i]);
                i++;
            }
        }

        public void accept(long j) {
            scheduleImpl();
            long[] jArr = (long[]) this.BuiltInFictitiousFunctionClassFactory;
            int i = this.getAuthRequestContext;
            this.getAuthRequestContext = i + 1;
            jArr[i] = j;
        }

        @Override // j$.util.function.LongConsumer
        public final LongConsumer andThen(LongConsumer longConsumer) {
            return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
        }

        @Override // j$.lang.Iterable
        public final void forEach(Consumer consumer) {
            if (consumer instanceof LongConsumer) {
                getAuthRequestContext((LongConsumer) consumer);
            } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(consumer);
            }
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public Spliterator.OfLong KClassImpl$Data$declaredNonStaticMembers$2() {
            return new C1Splitr(0, this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.getAuthRequestContext);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        public final Object getAuthRequestContext(int i) {
            return new long[i];
        }

        @Override // java.lang.Iterable
        public final Iterator iterator() {
            return Spliterators.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2());
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive
        protected final Object[] moveToNextValue() {
            return new long[8];
        }

        public final String toString() {
            long[] jArr = (long[]) getErrorConfigVersion();
            return jArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), Arrays.toString(jArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), Arrays.toString(Arrays.copyOf(jArr, 200)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class OfPrimitive extends AbstractSpinedBuffer implements Iterable, Iterable {
        Object BuiltInFictitiousFunctionClassFactory;
        Object[] scheduleImpl;

        /* loaded from: classes.dex */
        abstract class BaseSpliterator implements Spliterator.OfPrimitive {
            final int BuiltInFictitiousFunctionClassFactory;
            final int KClassImpl$Data$declaredNonStaticMembers$2;
            int lookAheadTest;
            Object moveToNextValue;
            int scheduleImpl;

            BaseSpliterator(int i, int i2, int i3, int i4) {
                this.lookAheadTest = i;
                this.BuiltInFictitiousFunctionClassFactory = i2;
                this.scheduleImpl = i3;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
                Object[] objArr = OfPrimitive.this.scheduleImpl;
                this.moveToNextValue = objArr == null ? OfPrimitive.this.BuiltInFictitiousFunctionClassFactory : objArr[i];
            }

            @Override // j$.util.Spliterator
            public final int BuiltInFictitiousFunctionClassFactory() {
                return 16464;
            }

            abstract Spliterator.OfPrimitive BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4);

            @Override // j$.util.Spliterator
            public final long KClassImpl$Data$declaredNonStaticMembers$2() {
                int i = this.lookAheadTest;
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                if (i == i2) {
                    return this.KClassImpl$Data$declaredNonStaticMembers$2 - this.scheduleImpl;
                }
                long[] jArr = OfPrimitive.this.PlaceComponentResult;
                return ((jArr[i2] + this.KClassImpl$Data$declaredNonStaticMembers$2) - jArr[i]) - this.scheduleImpl;
            }

            @Override // j$.util.Spliterator.OfPrimitive
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final void getAuthRequestContext(Object obj) {
                int i;
                int i2 = this.lookAheadTest;
                int i3 = this.BuiltInFictitiousFunctionClassFactory;
                if (i2 < i3 || (i2 == i3 && this.scheduleImpl < this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    int i4 = this.scheduleImpl;
                    while (true) {
                        i = this.BuiltInFictitiousFunctionClassFactory;
                        if (i2 >= i) {
                            break;
                        }
                        OfPrimitive ofPrimitive = OfPrimitive.this;
                        Object obj2 = ofPrimitive.scheduleImpl[i2];
                        ofPrimitive.PlaceComponentResult(obj2, i4, ofPrimitive.KClassImpl$Data$declaredNonStaticMembers$2(obj2), obj);
                        i4 = 0;
                        i2++;
                    }
                    OfPrimitive.this.PlaceComponentResult(this.lookAheadTest == i ? this.moveToNextValue : OfPrimitive.this.scheduleImpl[i], i4, this.KClassImpl$Data$declaredNonStaticMembers$2, obj);
                    this.lookAheadTest = this.BuiltInFictitiousFunctionClassFactory;
                    this.scheduleImpl = this.KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
            }

            abstract Spliterator.OfPrimitive MyBillsEntityDataFactory(Object obj, int i, int i2);

            abstract void MyBillsEntityDataFactory(int i, Object obj, Object obj2);

            public final /* bridge */ /* synthetic */ boolean MyBillsEntityDataFactory(IntConsumer intConsumer) {
                return PlaceComponentResult((Object) intConsumer);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final boolean PlaceComponentResult(Object obj) {
                int i = this.lookAheadTest;
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                if (i < i2 || (i == i2 && this.scheduleImpl < this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    Object obj2 = this.moveToNextValue;
                    int i3 = this.scheduleImpl;
                    this.scheduleImpl = i3 + 1;
                    MyBillsEntityDataFactory(i3, obj2, obj);
                    if (this.scheduleImpl == OfPrimitive.this.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue)) {
                        this.scheduleImpl = 0;
                        int i4 = this.lookAheadTest + 1;
                        this.lookAheadTest = i4;
                        Object[] objArr = OfPrimitive.this.scheduleImpl;
                        if (objArr != null && i4 <= this.BuiltInFictitiousFunctionClassFactory) {
                            this.moveToNextValue = objArr[i4];
                        }
                    }
                    return true;
                }
                return false;
            }

            @Override // j$.util.Spliterator
            /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0 */
            public final Spliterator.OfPrimitive moveToNextValue() {
                int i = this.lookAheadTest;
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                if (i < i2) {
                    int i3 = this.scheduleImpl;
                    OfPrimitive ofPrimitive = OfPrimitive.this;
                    int i4 = i2 - 1;
                    Spliterator.OfPrimitive BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i, i4, i3, ofPrimitive.KClassImpl$Data$declaredNonStaticMembers$2(ofPrimitive.scheduleImpl[i4]));
                    int i5 = this.BuiltInFictitiousFunctionClassFactory;
                    this.lookAheadTest = i5;
                    this.scheduleImpl = 0;
                    this.moveToNextValue = OfPrimitive.this.scheduleImpl[i5];
                    return BuiltInFictitiousFunctionClassFactory;
                } else if (i == i2) {
                    int i6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i7 = this.scheduleImpl;
                    int i8 = (i6 - i7) / 2;
                    if (i8 == 0) {
                        return null;
                    }
                    Spliterator.OfPrimitive MyBillsEntityDataFactory = MyBillsEntityDataFactory(this.moveToNextValue, i7, i8);
                    this.scheduleImpl += i8;
                    return MyBillsEntityDataFactory;
                } else {
                    return null;
                }
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ long PlaceComponentResult() {
                return Objects.getAuthRequestContext(this);
            }

            @Override // j$.util.Spliterator
            public final Comparator getAuthRequestContext() {
                throw new IllegalStateException();
            }

            public final /* synthetic */ Spliterator.OfDouble getErrorConfigVersion() {
                return (Spliterator.OfDouble) moveToNextValue();
            }

            /* renamed from: getErrorConfigVersion  reason: collision with other method in class */
            public final /* synthetic */ Spliterator.OfInt m3171getErrorConfigVersion() {
                return (Spliterator.OfInt) moveToNextValue();
            }

            public final /* synthetic */ Spliterator.OfLong moveToNextValue() {
                return (Spliterator.OfLong) moveToNextValue();
            }
        }

        OfPrimitive() {
            this.BuiltInFictitiousFunctionClassFactory = getAuthRequestContext(16);
        }

        OfPrimitive(int i) {
            super(i);
            this.BuiltInFictitiousFunctionClassFactory = getAuthRequestContext(1 << this.MyBillsEntityDataFactory);
        }

        public void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            long j = i;
            long s_ = s_() + j;
            if (s_ > KClassImpl$Data$declaredNonStaticMembers$2(obj) || s_ < j) {
                throw new IndexOutOfBoundsException("does not fit");
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                System.arraycopy(this.BuiltInFictitiousFunctionClassFactory, 0, obj, i, this.getAuthRequestContext);
                return;
            }
            for (int i2 = 0; i2 < this.KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
                Object obj2 = this.scheduleImpl[i2];
                System.arraycopy(obj2, 0, obj, i, KClassImpl$Data$declaredNonStaticMembers$2(obj2));
                i += KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl[i2]);
            }
            int i3 = this.getAuthRequestContext;
            if (i3 > 0) {
                System.arraycopy(this.BuiltInFictitiousFunctionClassFactory, 0, obj, i, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void BuiltInFictitiousFunctionClassFactory(long j) {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            long KClassImpl$Data$declaredNonStaticMembers$2 = i == 0 ? KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory) : KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl[i]) + this.PlaceComponentResult[i];
            if (j <= KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            if (this.scheduleImpl == null) {
                Object[] moveToNextValue = moveToNextValue();
                this.scheduleImpl = moveToNextValue;
                this.PlaceComponentResult = new long[8];
                moveToNextValue[0] = this.BuiltInFictitiousFunctionClassFactory;
            }
            int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            while (true) {
                i2++;
                if (j <= KClassImpl$Data$declaredNonStaticMembers$2) {
                    return;
                }
                Object[] objArr = this.scheduleImpl;
                if (i2 >= objArr.length) {
                    int length = objArr.length * 2;
                    this.scheduleImpl = Arrays.copyOf(objArr, length);
                    this.PlaceComponentResult = Arrays.copyOf(this.PlaceComponentResult, length);
                }
                int min = 1 << ((i2 == 0 || i2 == 1) ? this.MyBillsEntityDataFactory : Math.min((this.MyBillsEntityDataFactory + i2) - 1, 30));
                this.scheduleImpl[i2] = getAuthRequestContext(min);
                long[] jArr = this.PlaceComponentResult;
                jArr[i2] = jArr[i2 - 1] + KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl[r5]);
                KClassImpl$Data$declaredNonStaticMembers$2 += min;
            }
        }

        protected abstract int KClassImpl$Data$declaredNonStaticMembers$2(Object obj);

        public abstract Spliterator KClassImpl$Data$declaredNonStaticMembers$2();

        /* JADX INFO: Access modifiers changed from: protected */
        public final int MyBillsEntityDataFactory(long j) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                if (j < this.getAuthRequestContext) {
                    return 0;
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else if (j < s_()) {
                for (int i = 0; i <= this.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                    if (j < this.PlaceComponentResult[i] + KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl[i])) {
                        return i;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
        }

        protected abstract void PlaceComponentResult(Object obj, int i, int i2, Object obj2);

        public abstract Object getAuthRequestContext(int i);

        public void getAuthRequestContext(Object obj) {
            for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                Object obj2 = this.scheduleImpl[i];
                PlaceComponentResult(obj2, 0, KClassImpl$Data$declaredNonStaticMembers$2(obj2), obj);
            }
            PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, 0, this.getAuthRequestContext, obj);
        }

        public Object getErrorConfigVersion() {
            long s_ = s_();
            if (s_ < 2147483639) {
                Object authRequestContext = getAuthRequestContext((int) s_);
                BuiltInFictitiousFunctionClassFactory(0, authRequestContext);
                return authRequestContext;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        protected abstract Object[] moveToNextValue();

        protected final void scheduleImpl() {
            long KClassImpl$Data$declaredNonStaticMembers$2;
            if (this.getAuthRequestContext == KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory)) {
                if (this.scheduleImpl == null) {
                    Object[] moveToNextValue = moveToNextValue();
                    this.scheduleImpl = moveToNextValue;
                    this.PlaceComponentResult = new long[8];
                    moveToNextValue[0] = this.BuiltInFictitiousFunctionClassFactory;
                }
                int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i2 = i + 1;
                Object[] objArr = this.scheduleImpl;
                if (i2 >= objArr.length || objArr[i2] == null) {
                    if (i == 0) {
                        KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
                    } else {
                        KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(objArr[i]) + this.PlaceComponentResult[i];
                    }
                    BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2 + 1);
                }
                this.getAuthRequestContext = 0;
                int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
                this.BuiltInFictitiousFunctionClassFactory = this.scheduleImpl[i3];
            }
        }

        @Override // java.lang.Iterable
        public final /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2());
        }

        @Override // j$.util.stream.AbstractSpinedBuffer
        public final void t_() {
            Object[] objArr = this.scheduleImpl;
            if (objArr != null) {
                this.BuiltInFictitiousFunctionClassFactory = objArr[0];
                this.scheduleImpl = null;
                this.PlaceComponentResult = null;
            }
            this.getAuthRequestContext = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }
    }

    public Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
        return new C1Splitr(0, this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.getAuthRequestContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(long j) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        long length = i == 0 ? this.BuiltInFictitiousFunctionClassFactory.length : this.PlaceComponentResult[i] + this.moveToNextValue[i].length;
        if (j <= length) {
            return;
        }
        if (this.moveToNextValue == null) {
            Object[][] objArr = new Object[8];
            this.moveToNextValue = objArr;
            this.PlaceComponentResult = new long[8];
            objArr[0] = this.BuiltInFictitiousFunctionClassFactory;
        }
        while (true) {
            i++;
            if (j <= length) {
                return;
            }
            Object[][] objArr2 = this.moveToNextValue;
            if (i >= objArr2.length) {
                int length2 = objArr2.length * 2;
                this.moveToNextValue = (Object[][]) Arrays.copyOf(objArr2, length2);
                this.PlaceComponentResult = Arrays.copyOf(this.PlaceComponentResult, length2);
            }
            int min = 1 << ((i == 0 || i == 1) ? this.MyBillsEntityDataFactory : Math.min((this.MyBillsEntityDataFactory + i) - 1, 30));
            this.moveToNextValue[i] = new Object[min];
            long[] jArr = this.PlaceComponentResult;
            jArr[i] = jArr[i - 1] + r4[r6].length;
            length += min;
        }
    }

    public void accept(Object obj) {
        long length;
        int i = this.getAuthRequestContext;
        Object[] objArr = this.BuiltInFictitiousFunctionClassFactory;
        if (i == objArr.length) {
            if (this.moveToNextValue == null) {
                Object[][] objArr2 = new Object[8];
                this.moveToNextValue = objArr2;
                this.PlaceComponentResult = new long[8];
                objArr2[0] = objArr;
            }
            int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i3 = i2 + 1;
            Object[][] objArr3 = this.moveToNextValue;
            if (i3 >= objArr3.length || objArr3[i3] == null) {
                if (i2 == 0) {
                    length = objArr.length;
                } else {
                    length = objArr3[i2].length + this.PlaceComponentResult[i2];
                }
                MyBillsEntityDataFactory(length + 1);
            }
            this.getAuthRequestContext = 0;
            int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
            this.BuiltInFictitiousFunctionClassFactory = this.moveToNextValue[i4];
        }
        Object[] objArr4 = this.BuiltInFictitiousFunctionClassFactory;
        int i5 = this.getAuthRequestContext;
        this.getAuthRequestContext = i5 + 1;
        objArr4[i5] = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    public void forEach(Consumer consumer) {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
            for (Object obj : this.moveToNextValue[i]) {
                consumer.accept(obj);
            }
        }
        for (int i2 = 0; i2 < this.getAuthRequestContext; i2++) {
            consumer.accept(this.BuiltInFictitiousFunctionClassFactory[i2]);
        }
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return Spliterators.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // j$.util.stream.AbstractSpinedBuffer
    public final void t_() {
        Object[][] objArr = this.moveToNextValue;
        if (objArr != null) {
            this.BuiltInFictitiousFunctionClassFactory = objArr[0];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.BuiltInFictitiousFunctionClassFactory;
                if (i >= objArr2.length) {
                    break;
                }
                objArr2[i] = null;
                i++;
            }
            this.moveToNextValue = null;
            this.PlaceComponentResult = null;
        } else {
            for (int i2 = 0; i2 < this.getAuthRequestContext; i2++) {
                this.BuiltInFictitiousFunctionClassFactory[i2] = null;
            }
        }
        this.getAuthRequestContext = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        forEach(new Collectors$$ExternalSyntheticLambda25(9, arrayList));
        StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("SpinedBuffer:");
        PlaceComponentResult.append(arrayList.toString());
        return PlaceComponentResult.toString();
    }
}
