package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
abstract class StreamSpliterators$ArrayBuffer {
    int PlaceComponentResult;

    /* loaded from: classes.dex */
    final class OfDouble extends OfPrimitive implements DoubleConsumer {
        final double[] KClassImpl$Data$declaredNonStaticMembers$2 = new double[128];

        @Override // j$.util.stream.StreamSpliterators$ArrayBuffer.OfPrimitive
        final void BuiltInFictitiousFunctionClassFactory(Object obj, long j) {
            DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
            for (int i = 0; i < j; i++) {
                doubleConsumer.accept(this.KClassImpl$Data$declaredNonStaticMembers$2[i]);
            }
        }

        @Override // j$.util.function.DoubleConsumer
        public final void accept(double d) {
            double[] dArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i + 1;
            dArr[i] = d;
        }

        @Override // j$.util.function.DoubleConsumer
        public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
        }
    }

    /* loaded from: classes.dex */
    final class OfInt extends OfPrimitive implements IntConsumer {
        final int[] BuiltInFictitiousFunctionClassFactory = new int[128];

        @Override // j$.util.stream.StreamSpliterators$ArrayBuffer.OfPrimitive
        public final void BuiltInFictitiousFunctionClassFactory(Object obj, long j) {
            IntConsumer intConsumer = (IntConsumer) obj;
            for (int i = 0; i < j; i++) {
                intConsumer.accept(this.BuiltInFictitiousFunctionClassFactory[i]);
            }
        }

        @Override // j$.util.function.IntConsumer
        public final void accept(int i) {
            int[] iArr = this.BuiltInFictitiousFunctionClassFactory;
            int i2 = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i2 + 1;
            iArr[i2] = i;
        }

        @Override // j$.util.function.IntConsumer
        public final IntConsumer andThen(IntConsumer intConsumer) {
            return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
        }
    }

    /* loaded from: classes.dex */
    final class OfLong extends OfPrimitive implements LongConsumer {
        final long[] BuiltInFictitiousFunctionClassFactory = new long[128];

        @Override // j$.util.stream.StreamSpliterators$ArrayBuffer.OfPrimitive
        public final void BuiltInFictitiousFunctionClassFactory(Object obj, long j) {
            LongConsumer longConsumer = (LongConsumer) obj;
            for (int i = 0; i < j; i++) {
                longConsumer.accept(this.BuiltInFictitiousFunctionClassFactory[i]);
            }
        }

        @Override // j$.util.function.LongConsumer
        public final void accept(long j) {
            long[] jArr = this.BuiltInFictitiousFunctionClassFactory;
            int i = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i + 1;
            jArr[i] = j;
        }

        @Override // j$.util.function.LongConsumer
        public final LongConsumer andThen(LongConsumer longConsumer) {
            return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
        }
    }

    /* loaded from: classes.dex */
    abstract class OfPrimitive extends StreamSpliterators$ArrayBuffer {
        int MyBillsEntityDataFactory;

        OfPrimitive() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void BuiltInFictitiousFunctionClassFactory(Object obj, long j);
    }

    /* loaded from: classes6.dex */
    final class OfRef extends StreamSpliterators$ArrayBuffer implements Consumer {
        final Object[] BuiltInFictitiousFunctionClassFactory = new Object[128];

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            Object[] objArr = this.BuiltInFictitiousFunctionClassFactory;
            int i = this.PlaceComponentResult;
            this.PlaceComponentResult = i + 1;
            objArr[i] = obj;
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }
    }

    StreamSpliterators$ArrayBuffer() {
    }
}
