package j$.util.stream;

import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.IntFunction;
import j$.util.function.LongConsumer;
import j$.util.stream.Node;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators$SliceSpliterator;
import j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public interface Node {

    /* loaded from: classes.dex */
    public interface Builder extends Sink {

        /* loaded from: classes.dex */
        public interface OfDouble extends Builder, Sink.OfDouble {
            OfDouble getAuthRequestContext();
        }

        /* loaded from: classes.dex */
        public interface OfInt extends Builder, Sink.OfInt {
            OfInt getAuthRequestContext();
        }

        /* loaded from: classes.dex */
        public interface OfLong extends Builder, Sink.OfLong {
            OfLong MyBillsEntityDataFactory();
        }

        Node PlaceComponentResult();
    }

    /* loaded from: classes.dex */
    public interface OfDouble extends OfPrimitive {
    }

    /* loaded from: classes.dex */
    public interface OfInt extends OfPrimitive {
    }

    /* loaded from: classes.dex */
    public interface OfLong extends OfPrimitive {
    }

    /* loaded from: classes.dex */
    public interface OfPrimitive extends Node {
        void BuiltInFictitiousFunctionClassFactory(int i, Object obj);

        OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i);

        Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0();

        Object getAuthRequestContext(int i);

        void getAuthRequestContext(Object obj);

        Object getErrorConfigVersion();
    }

    int BuiltInFictitiousFunctionClassFactory();

    Node BuiltInFictitiousFunctionClassFactory(int i);

    Spliterator KClassImpl$Data$declaredNonStaticMembers$2();

    void forEach(Consumer consumer);

    Node getAuthRequestContext(long j, long j2, IntFunction intFunction);

    void getAuthRequestContext(Object[] objArr, int i);

    Object[] getAuthRequestContext(IntFunction intFunction);

    long s_();

    /* renamed from: j$.util.stream.Node$-CC */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static void A() {
            throw new IllegalStateException("called wrong accept method");
        }

        public static OfInt BuiltInFictitiousFunctionClassFactory(OfInt ofInt, long j, long j2) {
            if (j == 0 && j2 == ofInt.s_()) {
                return ofInt;
            }
            long j3 = j2 - j;
            Spliterator.OfInt ofInt2 = (Spliterator.OfInt) ofInt.NetworkUserEntityData$$ExternalSyntheticLambda0();
            Builder.OfInt BuiltInFictitiousFunctionClassFactory = Nodes.BuiltInFictitiousFunctionClassFactory(j3);
            BuiltInFictitiousFunctionClassFactory.begin(j3);
            int i = 0;
            for (int i2 = 0; i2 < j && ofInt2.MyBillsEntityDataFactory((IntConsumer) new Node$OfInt$$ExternalSyntheticLambda0(i)); i2++) {
            }
            while (i < j3 && ofInt2.MyBillsEntityDataFactory((IntConsumer) BuiltInFictitiousFunctionClassFactory)) {
                i++;
            }
            BuiltInFictitiousFunctionClassFactory.end();
            return BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        }

        public static void BuiltInFictitiousFunctionClassFactory(OfLong ofLong, Consumer consumer) {
            if (consumer instanceof LongConsumer) {
                ofLong.getAuthRequestContext((LongConsumer) consumer);
            } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofLong.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            } else {
                ((Spliterator.OfLong) ofLong.NetworkUserEntityData$$ExternalSyntheticLambda0()).getAuthRequestContext(consumer);
            }
        }

        public static void BuiltInFictitiousFunctionClassFactory(Sink.OfDouble ofDouble, Double d) {
            if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofDouble.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
                throw null;
            } else {
                ofDouble.accept(d.doubleValue());
            }
        }

        public static void C() {
            throw new IllegalStateException("called wrong accept method");
        }

        public static long KClassImpl$Data$declaredNonStaticMembers$2(long j, long j2, long j3) {
            if (j >= 0) {
                return Math.max(-1L, Math.min(j - j2, j3));
            }
            return -1L;
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(OfInt ofInt, Integer[] numArr, int i) {
            if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofInt.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
                throw null;
            }
            int[] iArr = (int[]) ofInt.getErrorConfigVersion();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                numArr[i + i2] = Integer.valueOf(iArr[i2]);
            }
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(OfLong ofLong, Long[] lArr, int i) {
            if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofLong.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
                throw null;
            }
            long[] jArr = (long[]) ofLong.getErrorConfigVersion();
            for (int i2 = 0; i2 < jArr.length; i2++) {
                lArr[i + i2] = Long.valueOf(jArr[i2]);
            }
        }

        public static OfDouble MyBillsEntityDataFactory(OfDouble ofDouble, long j, long j2) {
            if (j == 0 && j2 == ofDouble.s_()) {
                return ofDouble;
            }
            long j3 = j2 - j;
            Spliterator.OfDouble ofDouble2 = (Spliterator.OfDouble) ofDouble.NetworkUserEntityData$$ExternalSyntheticLambda0();
            Builder.OfDouble MyBillsEntityDataFactory = Nodes.MyBillsEntityDataFactory(j3);
            MyBillsEntityDataFactory.begin(j3);
            int i = 0;
            for (int i2 = 0; i2 < j && ofDouble2.MyBillsEntityDataFactory(new Node$OfDouble$$ExternalSyntheticLambda0(i)); i2++) {
            }
            while (i < j3 && ofDouble2.MyBillsEntityDataFactory(MyBillsEntityDataFactory)) {
                i++;
            }
            MyBillsEntityDataFactory.end();
            return MyBillsEntityDataFactory.getAuthRequestContext();
        }

        public static Node MyBillsEntityDataFactory(Node node, long j, long j2, IntFunction intFunction) {
            if (j == 0 && j2 == node.s_()) {
                return node;
            }
            Spliterator KClassImpl$Data$declaredNonStaticMembers$2 = node.KClassImpl$Data$declaredNonStaticMembers$2();
            long j3 = j2 - j;
            Builder BuiltInFictitiousFunctionClassFactory = Nodes.BuiltInFictitiousFunctionClassFactory(j3, intFunction);
            BuiltInFictitiousFunctionClassFactory.begin(j3);
            int i = 0;
            for (int i2 = 0; i2 < j && KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(new Node$$ExternalSyntheticLambda0(i)); i2++) {
            }
            while (i < j3 && KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory)) {
                i++;
            }
            BuiltInFictitiousFunctionClassFactory.end();
            return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        }

        public static void MyBillsEntityDataFactory(OfDouble ofDouble, Double[] dArr, int i) {
            if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofDouble.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
                throw null;
            }
            double[] dArr2 = (double[]) ofDouble.getErrorConfigVersion();
            for (int i2 = 0; i2 < dArr2.length; i2++) {
                dArr[i + i2] = Double.valueOf(dArr2[i2]);
            }
        }

        public static void MyBillsEntityDataFactory(OfInt ofInt, Consumer consumer) {
            if (consumer instanceof IntConsumer) {
                ofInt.getAuthRequestContext((IntConsumer) consumer);
            } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofInt.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                throw null;
            } else {
                ((Spliterator.OfInt) ofInt.NetworkUserEntityData$$ExternalSyntheticLambda0()).getAuthRequestContext(consumer);
            }
        }

        public static void MyBillsEntityDataFactory(Sink.OfInt ofInt, Integer num) {
            if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofInt.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
                throw null;
            } else {
                ofInt.accept(num.intValue());
            }
        }

        public static Object[] MyBillsEntityDataFactory(OfPrimitive ofPrimitive, IntFunction intFunction) {
            if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofPrimitive.getClass(), "{0} calling Node.OfPrimitive.asArray");
                throw null;
            } else if (ofPrimitive.s_() < 2147483639) {
                Object[] objArr = (Object[]) intFunction.MyBillsEntityDataFactory((int) ofPrimitive.s_());
                ofPrimitive.getAuthRequestContext(objArr, 0);
                return objArr;
            } else {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
        }

        public static Spliterator PlaceComponentResult(int i, Spliterator spliterator, long j, long j2) {
            long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
            long j4 = j3 < 0 ? Long.MAX_VALUE : j3;
            int[] iArr = SliceOps$5.PlaceComponentResult;
            if (i != 0) {
                int i2 = iArr[i - 1];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                return new StreamSpliterators$SliceSpliterator.OfDouble((Spliterator.OfDouble) spliterator, j, j4);
                            }
                            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Unknown shape ");
                            PlaceComponentResult.append(DayOfWeek$$ExternalSyntheticOutline0.BuiltInFictitiousFunctionClassFactory(i));
                            throw new IllegalStateException(PlaceComponentResult.toString());
                        }
                        return new StreamSpliterators$SliceSpliterator.OfLong((Spliterator.OfLong) spliterator, j, j4);
                    }
                    return new StreamSpliterators$SliceSpliterator.OfInt((Spliterator.OfInt) spliterator, j, j4);
                }
                return new StreamSpliterators$SliceSpliterator.OfRef(spliterator, j, j4);
            }
            throw null;
        }

        public static void PlaceComponentResult(Sink.OfLong ofLong, Long l) {
            if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofLong.getClass(), "{0} calling Sink.OfLong.accept(Long)");
                throw null;
            } else {
                ofLong.accept(l.longValue());
            }
        }

        public static void VerifyPinStateManager$executeRiskChallenge$2$1() {
            throw new IllegalStateException("called wrong accept method");
        }

        public static OfLong getAuthRequestContext(OfLong ofLong, long j, long j2) {
            if (j == 0 && j2 == ofLong.s_()) {
                return ofLong;
            }
            long j3 = j2 - j;
            Spliterator.OfLong ofLong2 = (Spliterator.OfLong) ofLong.NetworkUserEntityData$$ExternalSyntheticLambda0();
            Builder.OfLong KClassImpl$Data$declaredNonStaticMembers$2 = Nodes.KClassImpl$Data$declaredNonStaticMembers$2(j3);
            KClassImpl$Data$declaredNonStaticMembers$2.begin(j3);
            int i = 0;
            for (int i2 = 0; i2 < j && ofLong2.MyBillsEntityDataFactory(new Node$OfLong$$ExternalSyntheticLambda0(i)); i2++) {
            }
            while (i < j3 && ofLong2.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2)) {
                i++;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.end();
            return KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }

        public static void getAuthRequestContext(OfDouble ofDouble, Consumer consumer) {
            if (consumer instanceof DoubleConsumer) {
                ofDouble.getAuthRequestContext((DoubleConsumer) consumer);
            } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
                Tripwire.MyBillsEntityDataFactory(ofDouble.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            } else {
                ((Spliterator.OfDouble) ofDouble.NetworkUserEntityData$$ExternalSyntheticLambda0()).getAuthRequestContext(consumer);
            }
        }

        public abstract Builder BuiltInFictitiousFunctionClassFactory(long j, IntFunction intFunction);

        public abstract void KClassImpl$Data$declaredNonStaticMembers$2(Spliterator spliterator, Sink sink);

        public abstract void MyBillsEntityDataFactory(Spliterator spliterator, Sink sink);

        public abstract Sink PlaceComponentResult(Spliterator spliterator, Sink sink);

        public abstract int getAuthRequestContext();

        public abstract long getAuthRequestContext(Spliterator spliterator);

        public abstract Sink getAuthRequestContext(Sink sink);

        public static DoubleStream MyBillsEntityDataFactory(AbstractPipeline abstractPipeline, long j, long j2) {
            if (j >= 0) {
                return new SliceOps$4(abstractPipeline, (j2 != -1 ? StreamOpFlag.IS_SHORT_CIRCUIT : 0) | StreamOpFlag.NOT_SIZED, j, j2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Skip must be non-negative: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }

        public static IntStream getAuthRequestContext(AbstractPipeline abstractPipeline, long j, long j2) {
            if (j >= 0) {
                return new SliceOps$2(abstractPipeline, (j2 != -1 ? StreamOpFlag.IS_SHORT_CIRCUIT : 0) | StreamOpFlag.NOT_SIZED, j, j2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Skip must be non-negative: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }

        public static LongStream KClassImpl$Data$declaredNonStaticMembers$2(AbstractPipeline abstractPipeline, long j, long j2) {
            if (j >= 0) {
                return new SliceOps$3(abstractPipeline, (j2 != -1 ? StreamOpFlag.IS_SHORT_CIRCUIT : 0) | StreamOpFlag.NOT_SIZED, j, j2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Skip must be non-negative: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }

        public static Stream BuiltInFictitiousFunctionClassFactory(AbstractPipeline abstractPipeline, final long j, final long j2) {
            if (j >= 0) {
                return new ReferencePipeline.StatefulOp(abstractPipeline, (j2 != -1 ? StreamOpFlag.IS_SHORT_CIRCUIT : 0) | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.SliceOps$1
                    private static Spliterator getAuthRequestContext(Spliterator spliterator, long j3, long j4, long j5) {
                        long j6;
                        long j7;
                        if (j3 <= j5) {
                            long j8 = j5 - j3;
                            j7 = j4 >= 0 ? Math.min(j4, j8) : j8;
                            j6 = 0;
                        } else {
                            j6 = j3;
                            j7 = j4;
                        }
                        return new StreamSpliterators$UnorderedSliceSpliterator.OfRef(spliterator, j6, j7);
                    }

                    @Override // j$.util.stream.AbstractPipeline
                    final Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline2) {
                        long authRequestContext = abstractPipeline2.getAuthRequestContext(spliterator);
                        return (authRequestContext <= 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) ? !StreamOpFlag.ORDERED.isKnown(abstractPipeline2.getAuthRequestContext()) ? Nodes.BuiltInFictitiousFunctionClassFactory(this, getAuthRequestContext(abstractPipeline2.PlaceComponentResult(spliterator), j, j2, authRequestContext), true, intFunction) : (Node) new SliceOps$SliceTask(this, abstractPipeline2, spliterator, intFunction, j, j2).invoke() : Nodes.BuiltInFictitiousFunctionClassFactory(abstractPipeline2, Node.CC.PlaceComponentResult(abstractPipeline2.PlaceComponentResult(), spliterator, j, j2), true, intFunction);
                    }

                    @Override // j$.util.stream.AbstractPipeline
                    final Sink getAuthRequestContext(int i, Sink sink) {
                        return new Sink.ChainedReference(sink) { // from class: j$.util.stream.SliceOps$1.1
                            long BuiltInFictitiousFunctionClassFactory;
                            long KClassImpl$Data$declaredNonStaticMembers$2;

                            {
                                this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
                                long j3 = j2;
                                this.BuiltInFictitiousFunctionClassFactory = j3 < 0 ? LongCompanionObject.MAX_VALUE : j3;
                            }

                            @Override // j$.util.function.Consumer
                            public final void accept(Object obj) {
                                long j3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                                if (j3 != 0) {
                                    this.KClassImpl$Data$declaredNonStaticMembers$2 = j3 - 1;
                                    return;
                                }
                                long j4 = this.BuiltInFictitiousFunctionClassFactory;
                                if (j4 > 0) {
                                    this.BuiltInFictitiousFunctionClassFactory = j4 - 1;
                                    this.MyBillsEntityDataFactory.accept((Sink) obj);
                                }
                            }

                            @Override // j$.util.stream.Sink
                            public final void begin(long j3) {
                                this.MyBillsEntityDataFactory.begin(Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(j3, j, this.BuiltInFictitiousFunctionClassFactory));
                            }

                            @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                            public final boolean cancellationRequested() {
                                return this.BuiltInFictitiousFunctionClassFactory == 0 || this.MyBillsEntityDataFactory.cancellationRequested();
                            }
                        };
                    }

                    @Override // j$.util.stream.AbstractPipeline
                    final Spliterator MyBillsEntityDataFactory(AbstractPipeline abstractPipeline2, Spliterator spliterator) {
                        long authRequestContext = abstractPipeline2.getAuthRequestContext(spliterator);
                        if (authRequestContext <= 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) {
                            return !StreamOpFlag.ORDERED.isKnown(abstractPipeline2.getAuthRequestContext()) ? getAuthRequestContext(abstractPipeline2.PlaceComponentResult(spliterator), j, j2, authRequestContext) : ((Node) new SliceOps$SliceTask(this, abstractPipeline2, spliterator, new SliceOps$$ExternalSyntheticLambda0(0), j, j2).invoke()).KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                        Spliterator PlaceComponentResult = abstractPipeline2.PlaceComponentResult(spliterator);
                        long j3 = j;
                        long j4 = j2;
                        long j5 = j4 >= 0 ? j4 + j3 : Long.MAX_VALUE;
                        return new StreamSpliterators$SliceSpliterator.OfRef(PlaceComponentResult, j3, j5 >= 0 ? j5 : Long.MAX_VALUE);
                    }
                };
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Skip must be non-negative: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
