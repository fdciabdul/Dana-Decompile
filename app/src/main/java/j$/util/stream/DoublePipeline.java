package j$.util.stream;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.DoubleSummaryStatistics;
import j$.util.OptionalDouble;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.DoubleBinaryOperator;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleFunction;
import j$.util.function.DoublePredicate;
import j$.util.function.DoubleToIntFunction;
import j$.util.function.DoubleToLongFunction;
import j$.util.function.DoubleUnaryOperator;
import j$.util.function.IntFunction;
import j$.util.function.ObjDoubleConsumer;
import j$.util.function.Supplier;
import j$.util.stream.ForEachOps$ForEachOp;
import j$.util.stream.IntPipeline;
import j$.util.stream.Node;
import j$.util.stream.Nodes;
import j$.util.stream.SpinedBuffer;
import j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class DoublePipeline extends AbstractPipeline implements DoubleStream {
    public static final /* synthetic */ int BuiltInFictitiousFunctionClassFactory = 0;

    /* loaded from: classes2.dex */
    public final class Head extends DoublePipeline {
        public Head(Spliterator spliterator, int i) {
            super(spliterator, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.DoublePipeline, j$.util.stream.DoubleStream
        public final void PlaceComponentResult(DoubleConsumer doubleConsumer) {
            if (MyBillsEntityDataFactory()) {
                super.PlaceComponentResult(doubleConsumer);
            } else {
                DoublePipeline.KClassImpl$Data$declaredNonStaticMembers$2(lookAheadTest()).getAuthRequestContext(doubleConsumer);
            }
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.DoublePipeline, j$.util.stream.DoubleStream
        public final void getAuthRequestContext(DoubleConsumer doubleConsumer) {
            if (MyBillsEntityDataFactory()) {
                super.getAuthRequestContext(doubleConsumer);
            } else {
                DoublePipeline.KClassImpl$Data$declaredNonStaticMembers$2(lookAheadTest()).getAuthRequestContext(doubleConsumer);
            }
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream getCallingPid() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream whenAvailable() {
            moveToNextValue();
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class StatefulOp extends DoublePipeline {
        public StatefulOp(AbstractPipeline abstractPipeline, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return true;
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream getCallingPid() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream whenAvailable() {
            moveToNextValue();
            return this;
        }
    }

    /* loaded from: classes.dex */
    public abstract class StatelessOp extends DoublePipeline {
        public StatelessOp(AbstractPipeline abstractPipeline, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return false;
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream getCallingPid() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.DoubleStream
        public final /* synthetic */ DoubleStream whenAvailable() {
            moveToNextValue();
            return this;
        }
    }

    DoublePipeline(Spliterator spliterator, int i) {
        super(spliterator, i, false);
    }

    DoublePipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    public static Spliterator.OfDouble KClassImpl$Data$declaredNonStaticMembers$2(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfDouble) {
            return (Spliterator.OfDouble) spliterator;
        }
        if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
            Tripwire.MyBillsEntityDataFactory(AbstractPipeline.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator BuiltInFictitiousFunctionClassFactory(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        return new StreamSpliterators$DoubleWrappingSpliterator(cc, collectors$$ExternalSyntheticLambda25, z);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream BuiltInFictitiousFunctionClassFactory(DoubleFunction doubleFunction) {
        return new IntPipeline.AnonymousClass6(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, doubleFunction, 2);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream BuiltInFictitiousFunctionClassFactory(DoublePredicate doublePredicate) {
        return new IntPipeline.AnonymousClass6(this, StreamOpFlag.NOT_SIZED, doublePredicate, 3);
    }

    @Override // j$.util.stream.Node.CC
    public final Node.Builder BuiltInFictitiousFunctionClassFactory(long j, IntFunction intFunction) {
        return Nodes.MyBillsEntityDataFactory(j);
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node BuiltInFictitiousFunctionClassFactory(Node.CC cc, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.getAuthRequestContext(cc, spliterator, z);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream FragmentBottomSheetPaymentSettingBinding() {
        return new StatefulOp(this) { // from class: j$.util.stream.SortedOps$OfDouble
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i = StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED;
            }

            @Override // j$.util.stream.AbstractPipeline
            public final Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline) {
                if (StreamOpFlag.SORTED.isKnown(abstractPipeline.getAuthRequestContext())) {
                    return abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, false, intFunction);
                }
                double[] dArr = (double[]) ((Node.OfDouble) abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, true, intFunction)).getErrorConfigVersion();
                Arrays.sort(dArr);
                return new Nodes.DoubleArrayNode(dArr);
            }

            @Override // j$.util.stream.AbstractPipeline
            public final Sink getAuthRequestContext(int i, final Sink sink) {
                return StreamOpFlag.SORTED.isKnown(i) ? sink : StreamOpFlag.SIZED.isKnown(i) ? new SortedOps$AbstractDoubleSortingSink(sink) { // from class: j$.util.stream.SortedOps$SizedDoubleSortingSink
                    private int BuiltInFictitiousFunctionClassFactory;
                    private double[] KClassImpl$Data$declaredNonStaticMembers$2;

                    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                    public final void accept(double d) {
                        double[] dArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        int i2 = this.BuiltInFictitiousFunctionClassFactory;
                        this.BuiltInFictitiousFunctionClassFactory = i2 + 1;
                        dArr[i2] = d;
                    }

                    @Override // j$.util.stream.Sink
                    public final void begin(long j) {
                        if (j >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = new double[(int) j];
                    }

                    @Override // j$.util.stream.Sink.ChainedDouble, j$.util.stream.Sink
                    public final void end() {
                        int i2 = 0;
                        Arrays.sort(this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.BuiltInFictitiousFunctionClassFactory);
                        this.MyBillsEntityDataFactory.begin(this.BuiltInFictitiousFunctionClassFactory);
                        if (this.PlaceComponentResult) {
                            while (i2 < this.BuiltInFictitiousFunctionClassFactory && !this.MyBillsEntityDataFactory.cancellationRequested()) {
                                this.MyBillsEntityDataFactory.accept(this.KClassImpl$Data$declaredNonStaticMembers$2[i2]);
                                i2++;
                            }
                        } else {
                            while (i2 < this.BuiltInFictitiousFunctionClassFactory) {
                                this.MyBillsEntityDataFactory.accept(this.KClassImpl$Data$declaredNonStaticMembers$2[i2]);
                                i2++;
                            }
                        }
                        this.MyBillsEntityDataFactory.end();
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    }
                } : new SortedOps$AbstractDoubleSortingSink(sink) { // from class: j$.util.stream.SortedOps$DoubleSortingSink
                    private SpinedBuffer.OfDouble getAuthRequestContext;

                    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                    public final void accept(double d) {
                        this.getAuthRequestContext.accept(d);
                    }

                    @Override // j$.util.stream.Sink
                    public final void begin(long j) {
                        if (j >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.getAuthRequestContext = j > 0 ? new SpinedBuffer.OfDouble((int) j) : new SpinedBuffer.OfDouble();
                    }

                    @Override // j$.util.stream.Sink.ChainedDouble, j$.util.stream.Sink
                    public final void end() {
                        double[] dArr = (double[]) this.getAuthRequestContext.getErrorConfigVersion();
                        Arrays.sort(dArr);
                        this.MyBillsEntityDataFactory.begin(dArr.length);
                        int i2 = 0;
                        if (this.PlaceComponentResult) {
                            int length = dArr.length;
                            while (i2 < length) {
                                double d = dArr[i2];
                                if (this.MyBillsEntityDataFactory.cancellationRequested()) {
                                    break;
                                }
                                this.MyBillsEntityDataFactory.accept(d);
                                i2++;
                            }
                        } else {
                            int length2 = dArr.length;
                            while (i2 < length2) {
                                this.MyBillsEntityDataFactory.accept(dArr[i2]);
                                i2++;
                            }
                        }
                        this.MyBillsEntityDataFactory.end();
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble GetContactSyncConfig() {
        FindOps$$ExternalSyntheticLambda1 findOps$$ExternalSyntheticLambda1 = new FindOps$$ExternalSyntheticLambda1(10);
        double[] dArr = (double[]) MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(new FindOps$$ExternalSyntheticLambda1(12), 1), new FindOps$$ExternalSyntheticLambda1(11), findOps$$ExternalSyntheticLambda1, 2));
        if (dArr[2] > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            Set set = Collectors.getAuthRequestContext;
            double d = dArr[0] + dArr[1];
            double d2 = dArr[dArr.length - 1];
            if (Double.isNaN(d) && Double.isInfinite(d2)) {
                d = d2;
            }
            return OptionalDouble.KClassImpl$Data$declaredNonStaticMembers$2(d / dArr[2]);
        }
        return OptionalDouble.PlaceComponentResult();
    }

    @Override // j$.util.stream.AbstractPipeline
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return 4;
    }

    @Override // j$.util.stream.DoubleStream
    public final IntStream KClassImpl$Data$declaredNonStaticMembers$2(DoubleToIntFunction doubleToIntFunction) {
        return new IntPipeline.AnonymousClass3(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, doubleToIntFunction, 1);
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator MyBillsEntityDataFactory(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfDouble(supplier);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream MyBillsEntityDataFactory(DoubleConsumer doubleConsumer) {
        return new IntPipeline.AnonymousClass6(this, 0, doubleConsumer, 4);
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean MyBillsEntityDataFactory(DoublePredicate doublePredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.ANY;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(3, matchOps$MatchKind, doublePredicate)))).booleanValue();
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return !BuiltInFictitiousFunctionClassFactory() ? this : new IntPipeline.AnonymousClass2(this, StreamOpFlag.NOT_ORDERED, 1);
    }

    @Override // j$.util.stream.DoubleStream
    public final double NetworkUserEntityData$$ExternalSyntheticLambda3() {
        double[] dArr = (double[]) MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(new FindOps$$ExternalSyntheticLambda1(8), 1), new FindOps$$ExternalSyntheticLambda1(7), new FindOps$$ExternalSyntheticLambda1(14), 2));
        Set set = Collectors.getAuthRequestContext;
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (Double.isNaN(d) && Double.isInfinite(d2)) ? d2 : d;
    }

    @Override // j$.util.stream.DoubleStream
    public final Spliterator.OfDouble NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return KClassImpl$Data$declaredNonStaticMembers$2(super.NetworkUserEntityData$$ExternalSyntheticLambda2());
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return (OptionalDouble) MyBillsEntityDataFactory(new ReduceOps$2(new Node$$ExternalSyntheticLambda0(2), 1));
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda6() {
        int i = 1;
        return (OptionalDouble) MyBillsEntityDataFactory(new ReduceOps$2(new Node$$ExternalSyntheticLambda0(i), i));
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return (OptionalDouble) MyBillsEntityDataFactory(new FindOps$FindOp(false, OptionalDouble.PlaceComponentResult(), new Node$$ExternalSyntheticLambda0(6), new FindOps$$ExternalSyntheticLambda1(0)));
    }

    @Override // j$.util.stream.DoubleStream
    public final double PlaceComponentResult(final double d, final DoubleBinaryOperator doubleBinaryOperator) {
        return ((Double) MyBillsEntityDataFactory(new Nodes() { // from class: j$.util.stream.ReduceOps$11
            @Override // j$.util.stream.Nodes
            public final ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$2() {
                return new ReduceOps$11ReducingSink(d, DoubleBinaryOperator.this);
            }
        })).doubleValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble PlaceComponentResult(DoubleBinaryOperator doubleBinaryOperator) {
        return (OptionalDouble) MyBillsEntityDataFactory(new ReduceOps$2(doubleBinaryOperator, 1));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream PlaceComponentResult(long j) {
        if (j >= 0) {
            return j == 0 ? this : Node.CC.MyBillsEntityDataFactory(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.DoubleStream
    public final LongStream PlaceComponentResult(DoubleToLongFunction doubleToLongFunction) {
        return new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, doubleToLongFunction, 1);
    }

    @Override // j$.util.stream.DoubleStream
    public void PlaceComponentResult(DoubleConsumer doubleConsumer) {
        MyBillsEntityDataFactory((TerminalOp) new ForEachOps$ForEachOp.OfDouble(doubleConsumer, false));
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean PlaceComponentResult(DoublePredicate doublePredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.NONE;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(3, matchOps$MatchKind, doublePredicate)))).booleanValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble PrepareContext() {
        return (OptionalDouble) MyBillsEntityDataFactory(new FindOps$FindOp(true, OptionalDouble.PlaceComponentResult(), new Node$$ExternalSyntheticLambda0(6), new FindOps$$ExternalSyntheticLambda1(0)));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleSummaryStatistics SubSequence() {
        SliceOps$$ExternalSyntheticLambda0 sliceOps$$ExternalSyntheticLambda0 = new SliceOps$$ExternalSyntheticLambda0(16);
        return (DoubleSummaryStatistics) MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(new Node$$ExternalSyntheticLambda0(5), 1), new Node$$ExternalSyntheticLambda0(4), sliceOps$$ExternalSyntheticLambda0, 2));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream getAuthRequestContext(long j) {
        if (j >= 0) {
            return Node.CC.MyBillsEntityDataFactory(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream getAuthRequestContext(DoubleUnaryOperator doubleUnaryOperator) {
        return new IntPipeline.AnonymousClass6(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, doubleUnaryOperator, 1);
    }

    @Override // j$.util.stream.DoubleStream
    public final Stream getAuthRequestContext(DoubleFunction doubleFunction) {
        return new IntPipeline.AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, doubleFunction, 1);
    }

    @Override // j$.util.stream.DoubleStream
    public final Object getAuthRequestContext(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(biConsumer, 1), objDoubleConsumer, supplier, 2));
    }

    @Override // j$.util.stream.AbstractPipeline
    final void getAuthRequestContext(Spliterator spliterator, Sink sink) {
        DoubleConsumer doublePipeline$$ExternalSyntheticLambda5;
        Spliterator.OfDouble KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(spliterator);
        if (sink instanceof DoubleConsumer) {
            doublePipeline$$ExternalSyntheticLambda5 = (DoubleConsumer) sink;
        } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
            Tripwire.MyBillsEntityDataFactory(AbstractPipeline.class, "using DoubleStream.adapt(Sink<Double> s)");
            throw null;
        } else {
            doublePipeline$$ExternalSyntheticLambda5 = new DoublePipeline$$ExternalSyntheticLambda5(0, sink);
        }
        while (!sink.cancellationRequested() && KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(doublePipeline$$ExternalSyntheticLambda5)) {
        }
    }

    @Override // j$.util.stream.DoubleStream
    public void getAuthRequestContext(DoubleConsumer doubleConsumer) {
        MyBillsEntityDataFactory((TerminalOp) new ForEachOps$ForEachOp.OfDouble(doubleConsumer, true));
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean getAuthRequestContext(DoublePredicate doublePredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.ALL;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(3, matchOps$MatchKind, doublePredicate)))).booleanValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final double[] getSupportButtonTintMode() {
        return (double[]) Nodes.MyBillsEntityDataFactory((Node.OfDouble) KClassImpl$Data$declaredNonStaticMembers$2(new FindOps$$ExternalSyntheticLambda1(6))).getErrorConfigVersion();
    }

    @Override // j$.util.stream.DoubleStream
    public final Stream initRecordTimeStamp() {
        return new IntPipeline.AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new Node$$ExternalSyntheticLambda0(3), 1);
    }

    @Override // j$.util.stream.DoubleStream
    public final long newProxyInstance() {
        return ((Long) new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new FindOps$$ExternalSyntheticLambda1(9), 1).MyBillsEntityDataFactory(new ReduceOps$8(new Node$$ExternalSyntheticLambda0(19), 0L))).longValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream isLayoutRequested() {
        return new IntPipeline.AnonymousClass6(new DistinctOps$1(new IntPipeline.AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new Node$$ExternalSyntheticLambda0(3), 1), StreamOpFlag.IS_DISTINCT | StreamOpFlag.NOT_SIZED), StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new FindOps$$ExternalSyntheticLambda1(13), 6);
    }

    @Override // j$.util.stream.DoubleStream
    public final PrimitiveIterator.OfDouble NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return Spliterators.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2(super.NetworkUserEntityData$$ExternalSyntheticLambda2()));
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ Iterator DatabaseTableConfigUtil() {
        return Spliterators.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2(super.NetworkUserEntityData$$ExternalSyntheticLambda2()));
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    public final /* synthetic */ Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return KClassImpl$Data$declaredNonStaticMembers$2(super.NetworkUserEntityData$$ExternalSyntheticLambda2());
    }
}
