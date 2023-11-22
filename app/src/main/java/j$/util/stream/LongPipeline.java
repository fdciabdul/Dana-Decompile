package j$.util.stream;

import j$.util.LongSummaryStatistics;
import j$.util.OptionalDouble;
import j$.util.OptionalLong;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.IntFunction;
import j$.util.function.LongBinaryOperator;
import j$.util.function.LongConsumer;
import j$.util.function.LongFunction;
import j$.util.function.LongPredicate;
import j$.util.function.LongToDoubleFunction;
import j$.util.function.LongToIntFunction;
import j$.util.function.LongUnaryOperator;
import j$.util.function.ObjLongConsumer;
import j$.util.function.Supplier;
import j$.util.stream.ForEachOps$ForEachOp;
import j$.util.stream.IntPipeline;
import j$.util.stream.Node;
import j$.util.stream.Nodes;
import j$.util.stream.SpinedBuffer;
import j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class LongPipeline extends AbstractPipeline implements LongStream {
    public static final /* synthetic */ int lookAheadTest = 0;

    /* loaded from: classes2.dex */
    public final class Head extends LongPipeline {
        public Head(Spliterator spliterator, int i) {
            super(spliterator, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.LongPipeline, j$.util.stream.LongStream
        public final void PlaceComponentResult(LongConsumer longConsumer) {
            if (MyBillsEntityDataFactory()) {
                super.PlaceComponentResult(longConsumer);
            } else {
                LongPipeline.BuiltInFictitiousFunctionClassFactory(lookAheadTest()).getAuthRequestContext(longConsumer);
            }
        }

        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.LongPipeline, j$.util.stream.LongStream
        public final void getAuthRequestContext(LongConsumer longConsumer) {
            if (MyBillsEntityDataFactory()) {
                super.getAuthRequestContext(longConsumer);
            } else {
                LongPipeline.BuiltInFictitiousFunctionClassFactory(lookAheadTest()).getAuthRequestContext(longConsumer);
            }
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream getSupportButtonTintMode() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream readMicros() {
            moveToNextValue();
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class StatefulOp extends LongPipeline {
        public StatefulOp(AbstractPipeline abstractPipeline, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return true;
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream getSupportButtonTintMode() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream readMicros() {
            moveToNextValue();
            return this;
        }
    }

    /* loaded from: classes.dex */
    public abstract class StatelessOp extends LongPipeline {
        public StatelessOp(AbstractPipeline abstractPipeline, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return false;
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream getSupportButtonTintMode() {
            scheduleImpl();
            return this;
        }

        @Override // j$.util.stream.LongStream
        public final /* synthetic */ LongStream readMicros() {
            moveToNextValue();
            return this;
        }
    }

    LongPipeline(Spliterator spliterator, int i) {
        super(spliterator, i, false);
    }

    LongPipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    public static Spliterator.OfLong BuiltInFictitiousFunctionClassFactory(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfLong) {
            return (Spliterator.OfLong) spliterator;
        }
        if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
            Tripwire.MyBillsEntityDataFactory(AbstractPipeline.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator BuiltInFictitiousFunctionClassFactory(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        return new StreamSpliterators$LongWrappingSpliterator(cc, collectors$$ExternalSyntheticLambda25, z);
    }

    @Override // j$.util.stream.Node.CC
    public final Node.Builder BuiltInFictitiousFunctionClassFactory(long j, IntFunction intFunction) {
        return Nodes.KClassImpl$Data$declaredNonStaticMembers$2(j);
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node BuiltInFictitiousFunctionClassFactory(Node.CC cc, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.MyBillsEntityDataFactory(cc, spliterator, z);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream FragmentBottomSheetPaymentSettingBinding() {
        return new StatefulOp(this) { // from class: j$.util.stream.SortedOps$OfLong
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i = StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED;
            }

            @Override // j$.util.stream.AbstractPipeline
            public final Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline) {
                if (StreamOpFlag.SORTED.isKnown(abstractPipeline.getAuthRequestContext())) {
                    return abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, false, intFunction);
                }
                long[] jArr = (long[]) ((Node.OfLong) abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, true, intFunction)).getErrorConfigVersion();
                Arrays.sort(jArr);
                return new Nodes.LongArrayNode(jArr);
            }

            @Override // j$.util.stream.AbstractPipeline
            public final Sink getAuthRequestContext(int i, final Sink sink) {
                return StreamOpFlag.SORTED.isKnown(i) ? sink : StreamOpFlag.SIZED.isKnown(i) ? new SortedOps$AbstractLongSortingSink(sink) { // from class: j$.util.stream.SortedOps$SizedLongSortingSink
                    private int BuiltInFictitiousFunctionClassFactory;
                    private long[] PlaceComponentResult;

                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public final void accept(long j) {
                        long[] jArr = this.PlaceComponentResult;
                        int i2 = this.BuiltInFictitiousFunctionClassFactory;
                        this.BuiltInFictitiousFunctionClassFactory = i2 + 1;
                        jArr[i2] = j;
                    }

                    @Override // j$.util.stream.Sink
                    public final void begin(long j) {
                        if (j >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.PlaceComponentResult = new long[(int) j];
                    }

                    @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                    public final void end() {
                        int i2 = 0;
                        Arrays.sort(this.PlaceComponentResult, 0, this.BuiltInFictitiousFunctionClassFactory);
                        this.getAuthRequestContext.begin(this.BuiltInFictitiousFunctionClassFactory);
                        if (this.MyBillsEntityDataFactory) {
                            while (i2 < this.BuiltInFictitiousFunctionClassFactory && !this.getAuthRequestContext.cancellationRequested()) {
                                this.getAuthRequestContext.accept(this.PlaceComponentResult[i2]);
                                i2++;
                            }
                        } else {
                            while (i2 < this.BuiltInFictitiousFunctionClassFactory) {
                                this.getAuthRequestContext.accept(this.PlaceComponentResult[i2]);
                                i2++;
                            }
                        }
                        this.getAuthRequestContext.end();
                        this.PlaceComponentResult = null;
                    }
                } : new SortedOps$AbstractLongSortingSink(sink) { // from class: j$.util.stream.SortedOps$LongSortingSink
                    private SpinedBuffer.OfLong KClassImpl$Data$declaredNonStaticMembers$2;

                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public final void accept(long j) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.accept(j);
                    }

                    @Override // j$.util.stream.Sink
                    public final void begin(long j) {
                        if (j >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = j > 0 ? new SpinedBuffer.OfLong((int) j) : new SpinedBuffer.OfLong();
                    }

                    @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                    public final void end() {
                        long[] jArr = (long[]) this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion();
                        Arrays.sort(jArr);
                        this.getAuthRequestContext.begin(jArr.length);
                        int i2 = 0;
                        if (this.MyBillsEntityDataFactory) {
                            int length = jArr.length;
                            while (i2 < length) {
                                long j = jArr[i2];
                                if (this.getAuthRequestContext.cancellationRequested()) {
                                    break;
                                }
                                this.getAuthRequestContext.accept(j);
                                i2++;
                            }
                        } else {
                            int length2 = jArr.length;
                            while (i2 < length2) {
                                this.getAuthRequestContext.accept(jArr[i2]);
                                i2++;
                            }
                        }
                        this.getAuthRequestContext.end();
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public final OptionalDouble GetContactSyncConfig() {
        int i = 1;
        long[] jArr = (long[]) MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(new SliceOps$$ExternalSyntheticLambda0(i), 2), new FindOps$$ExternalSyntheticLambda1(29), new FindOps$$ExternalSyntheticLambda1(28), i));
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

    @Override // j$.util.stream.AbstractPipeline
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return 3;
    }

    @Override // j$.util.stream.LongStream
    public final long KClassImpl$Data$declaredNonStaticMembers$2(long j, LongBinaryOperator longBinaryOperator) {
        return ((Long) MyBillsEntityDataFactory(new ReduceOps$8(longBinaryOperator, j))).longValue();
    }

    @Override // j$.util.stream.LongStream
    public final LongStream KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        if (j >= 0) {
            return Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.LongStream
    public final Stream KClassImpl$Data$declaredNonStaticMembers$2(LongFunction longFunction) {
        return new IntPipeline.AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, longFunction, 2);
    }

    @Override // j$.util.stream.LongStream
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(LongPredicate longPredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.ANY;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(4, matchOps$MatchKind, longPredicate)))).booleanValue();
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator MyBillsEntityDataFactory(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfLong(supplier);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream MyBillsEntityDataFactory(LongConsumer longConsumer) {
        return new IntPipeline.AnonymousClass5(this, 0, longConsumer, 5);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream MyBillsEntityDataFactory(LongFunction longFunction) {
        return new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, longFunction, 3);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream MyBillsEntityDataFactory(LongPredicate longPredicate) {
        return new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SIZED, longPredicate, 4);
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return !BuiltInFictitiousFunctionClassFactory() ? this : new IntPipeline.AnonymousClass1(this, StreamOpFlag.NOT_ORDERED, 1);
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return (OptionalLong) MyBillsEntityDataFactory(new ReduceOps$2(new Node$$ExternalSyntheticLambda0(16), 3));
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return (OptionalLong) MyBillsEntityDataFactory(new ReduceOps$2(new Node$$ExternalSyntheticLambda0(17), 3));
    }

    @Override // j$.util.stream.LongStream
    public final Spliterator.OfLong NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return BuiltInFictitiousFunctionClassFactory(super.NetworkUserEntityData$$ExternalSyntheticLambda2());
    }

    @Override // j$.util.stream.LongStream
    public final IntStream PlaceComponentResult(LongToIntFunction longToIntFunction) {
        return new IntPipeline.AnonymousClass3(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, longToIntFunction, 5);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream PlaceComponentResult(long j) {
        if (j >= 0) {
            return j == 0 ? this : Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.LongStream
    public final LongStream PlaceComponentResult(LongUnaryOperator longUnaryOperator) {
        return new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, longUnaryOperator, 2);
    }

    @Override // j$.util.stream.LongStream
    public void PlaceComponentResult(LongConsumer longConsumer) {
        MyBillsEntityDataFactory((TerminalOp) new ForEachOps$ForEachOp.OfLong(longConsumer, false));
    }

    @Override // j$.util.stream.LongStream
    public final boolean PlaceComponentResult(LongPredicate longPredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.NONE;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(4, matchOps$MatchKind, longPredicate)))).booleanValue();
    }

    @Override // j$.util.stream.LongStream
    public final Stream PrepareContext() {
        return new IntPipeline.AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new Node$$ExternalSyntheticLambda0(18), 2);
    }

    @Override // j$.util.stream.LongStream
    public final long SubSequence() {
        return ((Long) MyBillsEntityDataFactory(new ReduceOps$8(new Node$$ExternalSyntheticLambda0(19), 0L))).longValue();
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong getAuthRequestContext(LongBinaryOperator longBinaryOperator) {
        return (OptionalLong) MyBillsEntityDataFactory(new ReduceOps$2(longBinaryOperator, 3));
    }

    @Override // j$.util.stream.LongStream
    public final DoubleStream getAuthRequestContext(LongToDoubleFunction longToDoubleFunction) {
        return new IntPipeline.AnonymousClass6(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, longToDoubleFunction, 5);
    }

    @Override // j$.util.stream.LongStream
    public final Object getAuthRequestContext(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(biConsumer, 2), objLongConsumer, supplier, 1));
    }

    @Override // j$.util.stream.AbstractPipeline
    final void getAuthRequestContext(Spliterator spliterator, Sink sink) {
        LongConsumer longPipeline$$ExternalSyntheticLambda11;
        Spliterator.OfLong BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(spliterator);
        if (sink instanceof LongConsumer) {
            longPipeline$$ExternalSyntheticLambda11 = (LongConsumer) sink;
        } else if (Tripwire.KClassImpl$Data$declaredNonStaticMembers$2) {
            Tripwire.MyBillsEntityDataFactory(AbstractPipeline.class, "using LongStream.adapt(Sink<Long> s)");
            throw null;
        } else {
            longPipeline$$ExternalSyntheticLambda11 = new LongPipeline$$ExternalSyntheticLambda11(0, sink);
        }
        while (!sink.cancellationRequested() && BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(longPipeline$$ExternalSyntheticLambda11)) {
        }
    }

    @Override // j$.util.stream.LongStream
    public void getAuthRequestContext(LongConsumer longConsumer) {
        MyBillsEntityDataFactory((TerminalOp) new ForEachOps$ForEachOp.OfLong(longConsumer, true));
    }

    @Override // j$.util.stream.LongStream
    public final boolean getAuthRequestContext(LongPredicate longPredicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.ALL;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(4, matchOps$MatchKind, longPredicate)))).booleanValue();
    }

    @Override // j$.util.stream.LongStream
    public final LongSummaryStatistics getCallingPid() {
        SliceOps$$ExternalSyntheticLambda0 sliceOps$$ExternalSyntheticLambda0 = new SliceOps$$ExternalSyntheticLambda0(24);
        return (LongSummaryStatistics) MyBillsEntityDataFactory(new ReduceOps$1(new IntPipeline$$ExternalSyntheticLambda11(new Node$$ExternalSyntheticLambda0(21), 2), new Node$$ExternalSyntheticLambda0(20), sliceOps$$ExternalSyntheticLambda0, 1));
    }

    @Override // j$.util.stream.LongStream
    public final DoubleStream initRecordTimeStamp() {
        return new IntPipeline.AnonymousClass2(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, 2);
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong isLayoutRequested() {
        OptionalLong optionalLong;
        optionalLong = OptionalLong.MyBillsEntityDataFactory;
        return (OptionalLong) MyBillsEntityDataFactory(new FindOps$FindOp(false, optionalLong, new Node$$ExternalSyntheticLambda0(7), new FindOps$$ExternalSyntheticLambda1(15)));
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong newProxyInstance() {
        OptionalLong optionalLong;
        optionalLong = OptionalLong.MyBillsEntityDataFactory;
        return (OptionalLong) MyBillsEntityDataFactory(new FindOps$FindOp(true, optionalLong, new Node$$ExternalSyntheticLambda0(7), new FindOps$$ExternalSyntheticLambda1(15)));
    }

    @Override // j$.util.stream.LongStream
    public final long[] whenAvailable() {
        return (long[]) Nodes.getAuthRequestContext((Node.OfLong) KClassImpl$Data$declaredNonStaticMembers$2(new FindOps$$ExternalSyntheticLambda1(27))).getErrorConfigVersion();
    }

    @Override // j$.util.stream.LongStream
    public final long NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return ((Long) new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new FindOps$$ExternalSyntheticLambda1(25), 2).MyBillsEntityDataFactory(new ReduceOps$8(new Node$$ExternalSyntheticLambda0(19), 0L))).longValue();
    }

    @Override // j$.util.stream.LongStream
    public final LongStream NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return new IntPipeline.AnonymousClass5(new DistinctOps$1(new IntPipeline.AnonymousClass4(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new Node$$ExternalSyntheticLambda0(18), 2), StreamOpFlag.IS_DISTINCT | StreamOpFlag.NOT_SIZED), StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new FindOps$$ExternalSyntheticLambda1(26), 7);
    }

    @Override // j$.util.stream.LongStream
    public final PrimitiveIterator.OfLong NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return Spliterators.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(super.NetworkUserEntityData$$ExternalSyntheticLambda2()));
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ Iterator DatabaseTableConfigUtil() {
        return Spliterators.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(super.NetworkUserEntityData$$ExternalSyntheticLambda2()));
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    public final /* synthetic */ Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return BuiltInFictitiousFunctionClassFactory(super.NetworkUserEntityData$$ExternalSyntheticLambda2());
    }
}
