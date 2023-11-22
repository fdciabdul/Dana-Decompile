package j$.util.stream;

import j$.util.IntSummaryStatistics;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.Spliterators;
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
import j$.util.stream.DistinctOps$1;
import j$.util.stream.DoublePipeline;
import j$.util.stream.ForEachOps$ForEachOp;
import j$.util.stream.LongPipeline;
import j$.util.stream.Node;
import j$.util.stream.Nodes;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.SpinedBuffer;
import j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class IntPipeline extends AbstractPipeline implements IntStream {
    public static final /* synthetic */ int BuiltInFictitiousFunctionClassFactory = 0;

    /* renamed from: j$.util.stream.IntPipeline$2 */
    /* loaded from: classes2.dex */
    final class AnonymousClass2 extends DoublePipeline.StatelessOp {
        public final /* synthetic */ int moveToNextValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(AbstractPipeline abstractPipeline, int i, int i2) {
            super(abstractPipeline, i);
            this.moveToNextValue = i2;
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            int i2 = this.moveToNextValue;
            return i2 != 0 ? i2 != 1 ? new LongPipeline$1$1(this, sink, 0) : sink : new AnonymousClass1.C01991(this, sink, 2);
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$3 */
    /* loaded from: classes.dex */
    final class AnonymousClass3 extends StatelessOp {
        public final /* synthetic */ int lookAheadTest;
        final /* synthetic */ Object scheduleImpl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(AbstractPipeline abstractPipeline, int i, Object obj, int i2) {
            super(abstractPipeline, i);
            this.lookAheadTest = i2;
            this.scheduleImpl = obj;
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            int i2 = 3;
            switch (this.lookAheadTest) {
                case 0:
                    return new AnonymousClass1.C01991(this, sink, i2);
                case 1:
                    return new DoublePipeline$1$1(this, sink, 2);
                case 2:
                    return new AnonymousClass1.C01991(this, sink, 1);
                case 3:
                    return new AnonymousClass1.C01991(this, sink, 7);
                case 4:
                    return new AnonymousClass1.C01991(this, sink, 8);
                case 5:
                    return new LongPipeline$1$1(this, sink, i2);
                case 6:
                    return new ReferencePipeline$2$1(this, sink, i2);
                default:
                    return new DistinctOps$1.AnonymousClass2(this, sink);
            }
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$4 */
    /* loaded from: classes.dex */
    final class AnonymousClass4 extends ReferencePipeline.StatelessOp {
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Object NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass4(AbstractPipeline abstractPipeline, int i, Object obj, int i2) {
            super(abstractPipeline, i);
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obj;
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            int i2 = this.BuiltInFictitiousFunctionClassFactory;
            if (i2 != 0) {
                int i3 = 1;
                if (i2 != 1) {
                    return i2 != 2 ? i2 != 3 ? new ReferencePipeline$2$1(this, sink, 0) : new ReferencePipeline$2$1(this, sink, i3) : new LongPipeline$1$1(this, sink, 2);
                }
                return new DoublePipeline$1$1(this, sink, i3);
            }
            return new AnonymousClass1.C01991(this, sink, 4);
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$5 */
    /* loaded from: classes.dex */
    final class AnonymousClass5 extends LongPipeline.StatelessOp {
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Object NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass5(AbstractPipeline abstractPipeline, int i, Object obj, int i2) {
            super(abstractPipeline, i);
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obj;
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            int i2 = 5;
            switch (this.BuiltInFictitiousFunctionClassFactory) {
                case 0:
                    return new AnonymousClass1.C01991(this, sink, i2);
                case 1:
                    return new DoublePipeline$1$1(this, sink, 3);
                case 2:
                    return new LongPipeline$1$1(this, sink, 1);
                case 3:
                    return new LongPipeline$1$1(this, sink, i2);
                case 4:
                    return new LongPipeline$1$1(this, sink, 6);
                case 5:
                    return new LongPipeline$1$1(this, sink, 7);
                case 6:
                    return new DistinctOps$1.AnonymousClass2(this, sink);
                default:
                    return new ReferencePipeline$2$1(this, sink, 4);
            }
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$6 */
    /* loaded from: classes.dex */
    final class AnonymousClass6 extends DoublePipeline.StatelessOp {
        public final /* synthetic */ int NetworkUserEntityData$$ExternalSyntheticLambda0;
        final /* synthetic */ Object moveToNextValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass6(AbstractPipeline abstractPipeline, int i, Object obj, int i2) {
            super(abstractPipeline, i);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i2;
            this.moveToNextValue = obj;
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            int i2 = 5;
            int i3 = 4;
            int i4 = 6;
            switch (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                case 0:
                    return new AnonymousClass1.C01991(this, sink, i4);
                case 1:
                    return new DoublePipeline$1$1(this, sink, 0);
                case 2:
                    return new DoublePipeline$1$1(this, sink, i3);
                case 3:
                    return new DoublePipeline$1$1(this, sink, i2);
                case 4:
                    return new DoublePipeline$1$1(this, sink, i4);
                case 5:
                    return new LongPipeline$1$1(this, sink, i3);
                case 6:
                    return new ReferencePipeline$2$1(this, sink, i2);
                default:
                    return new DistinctOps$1.AnonymousClass2(this, sink);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class Head extends IntPipeline {
        public Head(Spliterator spliterator, int i) {
            super(spliterator, i);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream B() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.IntPipeline, j$.util.stream.IntStream
        public final void BuiltInFictitiousFunctionClassFactory(IntConsumer intConsumer) {
            if (MyBillsEntityDataFactory()) {
                super.BuiltInFictitiousFunctionClassFactory(intConsumer);
            } else {
                IntPipeline.MyBillsEntityDataFactory(lookAheadTest()).getAuthRequestContext(intConsumer);
            }
        }

        @Override // j$.util.stream.IntPipeline, j$.util.stream.IntStream
        public final void KClassImpl$Data$declaredNonStaticMembers$2(IntConsumer intConsumer) {
            if (MyBillsEntityDataFactory()) {
                super.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer);
            } else {
                IntPipeline.MyBillsEntityDataFactory(lookAheadTest()).getAuthRequestContext(intConsumer);
            }
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream readMicros() {
            moveToNextValue();
            return this;
        }
    }

    /* loaded from: classes.dex */
    abstract class StatefulOp extends IntPipeline {
        public StatefulOp(AbstractPipeline abstractPipeline, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream B() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return true;
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream readMicros() {
            moveToNextValue();
            return this;
        }
    }

    /* loaded from: classes.dex */
    public abstract class StatelessOp extends IntPipeline {
        StatelessOp(AbstractPipeline abstractPipeline, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream B() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return false;
        }

        @Override // j$.util.stream.IntStream
        public final /* synthetic */ IntStream readMicros() {
            moveToNextValue();
            return this;
        }
    }

    IntPipeline(Spliterator spliterator, int i) {
        super(spliterator, i, false);
    }

    IntPipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    public static Spliterator.OfInt MyBillsEntityDataFactory(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfInt) {
            return (Spliterator.OfInt) spliterator;
        }
        if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
            Tripwire.MyBillsEntityDataFactory(AbstractPipeline.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator BuiltInFictitiousFunctionClassFactory(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        return new StreamSpliterators$IntWrappingSpliterator(cc, collectors$$ExternalSyntheticLambda25, z);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream BuiltInFictitiousFunctionClassFactory(IntFunction intFunction) {
        return new AnonymousClass3(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, intFunction, 3);
    }

    @Override // j$.util.stream.IntStream
    public final LongStream BuiltInFictitiousFunctionClassFactory(IntToLongFunction intToLongFunction) {
        return new AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, intToLongFunction, 0);
    }

    @Override // j$.util.stream.Node.CC
    public final Node.Builder BuiltInFictitiousFunctionClassFactory(long j, IntFunction intFunction) {
        return Nodes.BuiltInFictitiousFunctionClassFactory(j);
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node BuiltInFictitiousFunctionClassFactory(Node.CC cc, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.PlaceComponentResult(cc, spliterator, z);
    }

    @Override // j$.util.stream.IntStream
    public void BuiltInFictitiousFunctionClassFactory(IntConsumer intConsumer) {
        MyBillsEntityDataFactory((TerminalOp) new ForEachOps$ForEachOp.OfInt(intConsumer, true));
    }

    @Override // j$.util.stream.IntStream
    public final boolean BuiltInFictitiousFunctionClassFactory(IntPredicate intPredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.ALL;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(0, matchOps$MatchKind, intPredicate)))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt FragmentBottomSheetPaymentSettingBinding() {
        return (OptionalInt) MyBillsEntityDataFactory(new ReduceOps$2(new Node$$ExternalSyntheticLambda0(10), 2));
    }

    @Override // j$.util.stream.IntStream
    public final LongStream GetContactSyncConfig() {
        return new AnonymousClass1(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, 0);
    }

    @Override // j$.util.stream.AbstractPipeline
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return 2;
    }

    @Override // j$.util.stream.IntStream
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i, IntBinaryOperator intBinaryOperator) {
        return ((Integer) MyBillsEntityDataFactory(new ReduceOps$5(intBinaryOperator, i))).intValue();
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt KClassImpl$Data$declaredNonStaticMembers$2(IntBinaryOperator intBinaryOperator) {
        return (OptionalInt) MyBillsEntityDataFactory(new ReduceOps$2(intBinaryOperator, 2));
    }

    @Override // j$.util.stream.IntStream
    public void KClassImpl$Data$declaredNonStaticMembers$2(IntConsumer intConsumer) {
        MyBillsEntityDataFactory((TerminalOp) new ForEachOps$ForEachOp.OfInt(intConsumer, false));
    }

    @Override // j$.util.stream.IntStream
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(IntPredicate intPredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.NONE;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(0, matchOps$MatchKind, intPredicate)))).booleanValue();
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator MyBillsEntityDataFactory(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfInt(supplier);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream MyBillsEntityDataFactory(long j) {
        if (j >= 0) {
            return Node.CC.getAuthRequestContext(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return !BuiltInFictitiousFunctionClassFactory() ? this : new StatelessOp(this, StreamOpFlag.NOT_ORDERED) { // from class: j$.util.stream.IntPipeline.8
            @Override // j$.util.stream.AbstractPipeline
            public final Sink getAuthRequestContext(int i, Sink sink) {
                return sink;
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda3() {
        OptionalInt optionalInt;
        optionalInt = OptionalInt.getAuthRequestContext;
        return (OptionalInt) MyBillsEntityDataFactory(new FindOps$FindOp(true, optionalInt, new Node$$ExternalSyntheticLambda0(9), new FindOps$$ExternalSyntheticLambda1(17)));
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return (OptionalInt) MyBillsEntityDataFactory(new ReduceOps$2(new Node$$ExternalSyntheticLambda0(15), 2));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return new StatefulOp(this) { // from class: j$.util.stream.SortedOps$OfInt
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i = StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED;
            }

            @Override // j$.util.stream.AbstractPipeline
            public final Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline) {
                if (StreamOpFlag.SORTED.isKnown(abstractPipeline.getAuthRequestContext())) {
                    return abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, false, intFunction);
                }
                int[] iArr = (int[]) ((Node.OfInt) abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, true, intFunction)).getErrorConfigVersion();
                Arrays.sort(iArr);
                return new Nodes.IntArrayNode(iArr);
            }

            @Override // j$.util.stream.AbstractPipeline
            public final Sink getAuthRequestContext(int i, final Sink sink) {
                return StreamOpFlag.SORTED.isKnown(i) ? sink : StreamOpFlag.SIZED.isKnown(i) ? new SortedOps$AbstractIntSortingSink(sink) { // from class: j$.util.stream.SortedOps$SizedIntSortingSink
                    private int BuiltInFictitiousFunctionClassFactory;
                    private int[] getAuthRequestContext;

                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public final void accept(int i2) {
                        int[] iArr = this.getAuthRequestContext;
                        int i3 = this.BuiltInFictitiousFunctionClassFactory;
                        this.BuiltInFictitiousFunctionClassFactory = i3 + 1;
                        iArr[i3] = i2;
                    }

                    @Override // j$.util.stream.Sink
                    public final void begin(long j) {
                        if (j >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.getAuthRequestContext = new int[(int) j];
                    }

                    @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
                    public final void end() {
                        int i2 = 0;
                        Arrays.sort(this.getAuthRequestContext, 0, this.BuiltInFictitiousFunctionClassFactory);
                        this.KClassImpl$Data$declaredNonStaticMembers$2.begin(this.BuiltInFictitiousFunctionClassFactory);
                        if (this.MyBillsEntityDataFactory) {
                            while (i2 < this.BuiltInFictitiousFunctionClassFactory && !this.KClassImpl$Data$declaredNonStaticMembers$2.cancellationRequested()) {
                                this.KClassImpl$Data$declaredNonStaticMembers$2.accept(this.getAuthRequestContext[i2]);
                                i2++;
                            }
                        } else {
                            while (i2 < this.BuiltInFictitiousFunctionClassFactory) {
                                this.KClassImpl$Data$declaredNonStaticMembers$2.accept(this.getAuthRequestContext[i2]);
                                i2++;
                            }
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2.end();
                        this.getAuthRequestContext = null;
                    }
                } : new SortedOps$AbstractIntSortingSink(sink) { // from class: j$.util.stream.SortedOps$IntSortingSink
                    private SpinedBuffer.OfInt getAuthRequestContext;

                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public final void accept(int i2) {
                        this.getAuthRequestContext.accept(i2);
                    }

                    @Override // j$.util.stream.Sink
                    public final void begin(long j) {
                        if (j >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.getAuthRequestContext = j > 0 ? new SpinedBuffer.OfInt((int) j) : new SpinedBuffer.OfInt();
                    }

                    @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
                    public final void end() {
                        int[] iArr = (int[]) this.getAuthRequestContext.getErrorConfigVersion();
                        Arrays.sort(iArr);
                        this.KClassImpl$Data$declaredNonStaticMembers$2.begin(iArr.length);
                        int i2 = 0;
                        if (this.MyBillsEntityDataFactory) {
                            int length = iArr.length;
                            while (i2 < length) {
                                int i3 = iArr[i2];
                                if (this.KClassImpl$Data$declaredNonStaticMembers$2.cancellationRequested()) {
                                    break;
                                }
                                this.KClassImpl$Data$declaredNonStaticMembers$2.accept(i3);
                                i2++;
                            }
                        } else {
                            int length2 = iArr.length;
                            while (i2 < length2) {
                                this.KClassImpl$Data$declaredNonStaticMembers$2.accept(iArr[i2]);
                                i2++;
                            }
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2.end();
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt NetworkUserEntityData$$ExternalSyntheticLambda7() {
        OptionalInt optionalInt;
        optionalInt = OptionalInt.getAuthRequestContext;
        return (OptionalInt) MyBillsEntityDataFactory(new FindOps$FindOp(false, optionalInt, new Node$$ExternalSyntheticLambda0(9), new FindOps$$ExternalSyntheticLambda1(17)));
    }

    @Override // j$.util.stream.IntStream
    public final Stream NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return new AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new Node$$ExternalSyntheticLambda0(14), 0);
    }

    @Override // j$.util.stream.IntStream
    public final DoubleStream PlaceComponentResult(IntToDoubleFunction intToDoubleFunction) {
        return new AnonymousClass6(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, intToDoubleFunction, 0);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream PlaceComponentResult(IntConsumer intConsumer) {
        return new AnonymousClass3(this, 0, intConsumer, 2);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream PlaceComponentResult(IntPredicate intPredicate) {
        return new AnonymousClass3(this, StreamOpFlag.NOT_SIZED, intPredicate, 4);
    }

    @Override // j$.util.stream.IntStream
    public final Stream PlaceComponentResult(IntFunction intFunction) {
        return new AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, intFunction, 0);
    }

    @Override // j$.util.stream.IntStream
    public final OptionalDouble PrepareContext() {
        long[] jArr = (long[]) MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(new FindOps$$ExternalSyntheticLambda1(23), 0), new FindOps$$ExternalSyntheticLambda1(22), new FindOps$$ExternalSyntheticLambda1(21), 4));
        long j = jArr[0];
        if (j > 0) {
            double d = jArr[1];
            double d2 = j;
            Double.isNaN(d);
            Double.isNaN(d2);
            return OptionalDouble.KClassImpl$Data$declaredNonStaticMembers$2(d / d2);
        }
        return OptionalDouble.PlaceComponentResult();
    }

    @Override // j$.util.stream.IntStream
    public final IntSummaryStatistics SubSequence() {
        SliceOps$$ExternalSyntheticLambda0 sliceOps$$ExternalSyntheticLambda0 = new SliceOps$$ExternalSyntheticLambda0(20);
        return (IntSummaryStatistics) MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(new Node$$ExternalSyntheticLambda0(13), 0), new Node$$ExternalSyntheticLambda0(12), sliceOps$$ExternalSyntheticLambda0, 4));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream getAuthRequestContext(long j) {
        if (j >= 0) {
            return j == 0 ? this : Node.CC.getAuthRequestContext(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream getAuthRequestContext(IntUnaryOperator intUnaryOperator) {
        return new AnonymousClass3(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, intUnaryOperator, 0);
    }

    @Override // j$.util.stream.IntStream
    public final Object getAuthRequestContext(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        return MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(biConsumer, 0), objIntConsumer, supplier, 4));
    }

    @Override // j$.util.stream.AbstractPipeline
    final void getAuthRequestContext(Spliterator spliterator, Sink sink) {
        IntConsumer intPipeline$$ExternalSyntheticLambda1;
        Spliterator.OfInt MyBillsEntityDataFactory = MyBillsEntityDataFactory(spliterator);
        if (sink instanceof IntConsumer) {
            intPipeline$$ExternalSyntheticLambda1 = (IntConsumer) sink;
        } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
            Tripwire.MyBillsEntityDataFactory(AbstractPipeline.class, "using IntStream.adapt(Sink<Integer> s)");
            throw null;
        } else {
            intPipeline$$ExternalSyntheticLambda1 = new IntPipeline$$ExternalSyntheticLambda1(0, sink);
        }
        while (!sink.cancellationRequested() && MyBillsEntityDataFactory.PlaceComponentResult(intPipeline$$ExternalSyntheticLambda1)) {
        }
    }

    @Override // j$.util.stream.IntStream
    public final boolean getAuthRequestContext(IntPredicate intPredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.ANY;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(0, matchOps$MatchKind, intPredicate)))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final int[] getCallingPid() {
        return (int[]) Nodes.BuiltInFictitiousFunctionClassFactory((Node.OfInt) KClassImpl$Data$declaredNonStaticMembers$2(new FindOps$$ExternalSyntheticLambda1(24))).getErrorConfigVersion();
    }

    @Override // j$.util.stream.IntStream
    public final Spliterator.OfInt getSupportButtonTintMode() {
        return MyBillsEntityDataFactory(super.NetworkUserEntityData$$ExternalSyntheticLambda2());
    }

    @Override // j$.util.stream.IntStream
    public final DoubleStream initRecordTimeStamp() {
        return new AnonymousClass2(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, 0);
    }

    @Override // j$.util.stream.IntStream
    public final int whenAvailable() {
        return ((Integer) MyBillsEntityDataFactory(new ReduceOps$5(new Node$$ExternalSyntheticLambda0(11), 0))).intValue();
    }

    /* renamed from: j$.util.stream.IntPipeline$1 */
    /* loaded from: classes2.dex */
    final class AnonymousClass1 extends LongPipeline.StatelessOp {
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(AbstractPipeline abstractPipeline, int i, int i2) {
            super(abstractPipeline, i);
            this.BuiltInFictitiousFunctionClassFactory = i2;
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            return this.BuiltInFictitiousFunctionClassFactory != 0 ? sink : new C01991(this, sink, 0);
        }

        /* renamed from: j$.util.stream.IntPipeline$1$1 */
        /* loaded from: classes.dex */
        final class C01991 extends Sink.ChainedInt {
            public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ AbstractPipeline getAuthRequestContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C01991(AbstractPipeline abstractPipeline, Sink sink, int i) {
                super(sink);
                this.BuiltInFictitiousFunctionClassFactory = i;
                this.getAuthRequestContext = abstractPipeline;
            }

            @Override // j$.util.stream.Sink
            public final void begin(long j) {
                int i = this.BuiltInFictitiousFunctionClassFactory;
                if (i == 7) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.begin(-1L);
                } else if (i != 8) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.begin(j);
                } else {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.begin(-1L);
                }
            }

            @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
            public final void accept(int i) {
                switch (this.BuiltInFictitiousFunctionClassFactory) {
                    case 0:
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept(i);
                        return;
                    case 1:
                        ((IntConsumer) ((AnonymousClass3) this.getAuthRequestContext).scheduleImpl).accept(i);
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept(i);
                        return;
                    case 2:
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept(i);
                        return;
                    case 3:
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept(((IntUnaryOperator.VivifiedWrapper) ((IntUnaryOperator) ((AnonymousClass3) this.getAuthRequestContext).scheduleImpl)).getAuthRequestContext.applyAsInt(i));
                        return;
                    case 4:
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept((Sink) ((IntFunction) ((AnonymousClass4) this.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory(i));
                        return;
                    case 5:
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept(((IntToLongFunction) ((AnonymousClass5) this.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda0).getAuthRequestContext(i));
                        return;
                    case 6:
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept(((IntToDoubleFunction.VivifiedWrapper) ((IntToDoubleFunction) ((AnonymousClass6) this.getAuthRequestContext).moveToNextValue)).PlaceComponentResult.applyAsDouble(i));
                        return;
                    case 7:
                        IntStream intStream = (IntStream) ((IntFunction) ((AnonymousClass3) this.getAuthRequestContext).scheduleImpl).MyBillsEntityDataFactory(i);
                        if (intStream != null) {
                            try {
                                intStream.B().KClassImpl$Data$declaredNonStaticMembers$2(new IntPipeline$$ExternalSyntheticLambda1(1, this));
                            } catch (Throwable th) {
                                try {
                                    intStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                        if (intStream != null) {
                            intStream.close();
                            return;
                        }
                        return;
                    default:
                        if (((IntPredicate.VivifiedWrapper) ((IntPredicate) ((AnonymousClass3) this.getAuthRequestContext).scheduleImpl)).KClassImpl$Data$declaredNonStaticMembers$2(i)) {
                            this.KClassImpl$Data$declaredNonStaticMembers$2.accept(i);
                            return;
                        }
                        return;
                }
            }
        }
    }

    @Override // j$.util.stream.IntStream
    public final long isLayoutRequested() {
        return ((Long) new AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new FindOps$$ExternalSyntheticLambda1(20), 0).MyBillsEntityDataFactory(new ReduceOps$8(new Node$$ExternalSyntheticLambda0(19), 0L))).longValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream newProxyInstance() {
        return new AnonymousClass3(new DistinctOps$1(new AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new Node$$ExternalSyntheticLambda0(14), 0), StreamOpFlag.IS_DISTINCT | StreamOpFlag.NOT_SIZED), StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new FindOps$$ExternalSyntheticLambda1(19), 6);
    }

    @Override // j$.util.stream.IntStream
    public final PrimitiveIterator.OfInt NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return Spliterators.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory(super.NetworkUserEntityData$$ExternalSyntheticLambda2()));
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ Iterator DatabaseTableConfigUtil() {
        return Spliterators.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory(super.NetworkUserEntityData$$ExternalSyntheticLambda2()));
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    public final /* synthetic */ Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return MyBillsEntityDataFactory(super.NetworkUserEntityData$$ExternalSyntheticLambda2());
    }
}
