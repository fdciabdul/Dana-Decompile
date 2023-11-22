package j$.util.stream;

import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.Predicate$$ExternalSyntheticLambda3;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.Collector;
import j$.util.stream.ForEachOps$ForEachOp;
import j$.util.stream.IntPipeline;
import j$.util.stream.Node;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
abstract class ReferencePipeline extends AbstractPipeline implements Stream {
    public static final /* synthetic */ int getErrorConfigVersion = 0;

    /* renamed from: j$.util.stream.ReferencePipeline$3  reason: invalid class name */
    /* loaded from: classes.dex */
    final class AnonymousClass3 extends StatelessOp {
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Function moveToNextValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(AbstractPipeline abstractPipeline, int i, Function function, int i2) {
            super(abstractPipeline, i);
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.moveToNextValue = function;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            return this.BuiltInFictitiousFunctionClassFactory != 0 ? new ReferencePipeline$2$1(this, sink, 6) : new ReferencePipeline$2$1(this, sink, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class Head extends ReferencePipeline {
        /* JADX INFO: Access modifiers changed from: package-private */
        public Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Head(Supplier supplier, int i) {
            super(supplier, i, false);
        }

        @Override // j$.util.stream.ReferencePipeline, j$.util.stream.Stream
        public final void BuiltInFictitiousFunctionClassFactory(Consumer consumer) {
            if (MyBillsEntityDataFactory()) {
                super.BuiltInFictitiousFunctionClassFactory(consumer);
            } else {
                lookAheadTest().getAuthRequestContext(consumer);
            }
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.ReferencePipeline, j$.util.stream.Stream
        public final void PlaceComponentResult(Consumer consumer) {
            if (MyBillsEntityDataFactory()) {
                super.PlaceComponentResult(consumer);
            } else {
                lookAheadTest().getAuthRequestContext(consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // j$.util.stream.AbstractPipeline
        public final Sink getAuthRequestContext(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class StatefulOp extends ReferencePipeline {
        /* JADX INFO: Access modifiers changed from: package-private */
        public StatefulOp(AbstractPipeline abstractPipeline, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class StatelessOp extends ReferencePipeline {
        /* JADX INFO: Access modifiers changed from: package-private */
        public StatelessOp(AbstractPipeline abstractPipeline, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return false;
        }
    }

    ReferencePipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    ReferencePipeline(Supplier supplier, int i, boolean z) {
        super(supplier, i, false);
    }

    ReferencePipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    @Override // j$.util.stream.Stream
    public final Optional BuiltInFictitiousFunctionClassFactory(BinaryOperator binaryOperator) {
        return (Optional) MyBillsEntityDataFactory(new ReduceOps$2(binaryOperator, 0));
    }

    @Override // j$.util.stream.Stream
    public final Optional BuiltInFictitiousFunctionClassFactory(Comparator comparator) {
        return (Optional) MyBillsEntityDataFactory(new ReduceOps$2(new Predicate$$ExternalSyntheticLambda3(2, comparator), 0));
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator BuiltInFictitiousFunctionClassFactory(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        return new StreamSpliterators$WrappingSpliterator(cc, collectors$$ExternalSyntheticLambda25, z);
    }

    @Override // j$.util.stream.Stream
    public final DoubleStream BuiltInFictitiousFunctionClassFactory(Function function) {
        return new IntPipeline.AnonymousClass6(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, function, 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.Node.CC
    public final Node.Builder BuiltInFictitiousFunctionClassFactory(long j, IntFunction intFunction) {
        return Nodes.BuiltInFictitiousFunctionClassFactory(j, intFunction);
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node BuiltInFictitiousFunctionClassFactory(Node.CC cc, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.BuiltInFictitiousFunctionClassFactory(cc, spliterator, z, intFunction);
    }

    @Override // j$.util.stream.Stream
    public final Object BuiltInFictitiousFunctionClassFactory(final Collector collector) {
        Object MyBillsEntityDataFactory;
        if (MyBillsEntityDataFactory() && collector.KClassImpl$Data$declaredNonStaticMembers$2().contains(Collector.Characteristics.CONCURRENT) && (!BuiltInFictitiousFunctionClassFactory() || collector.KClassImpl$Data$declaredNonStaticMembers$2().contains(Collector.Characteristics.UNORDERED))) {
            MyBillsEntityDataFactory = collector.BuiltInFictitiousFunctionClassFactory().get();
            PlaceComponentResult(new MatchOps$$ExternalSyntheticLambda0(5, collector.getAuthRequestContext(), MyBillsEntityDataFactory));
        } else {
            final Supplier BuiltInFictitiousFunctionClassFactory = collector.BuiltInFictitiousFunctionClassFactory();
            final BiConsumer authRequestContext = collector.getAuthRequestContext();
            final BinaryOperator PlaceComponentResult = collector.PlaceComponentResult();
            MyBillsEntityDataFactory = MyBillsEntityDataFactory(new Nodes() { // from class: j$.util.stream.ReduceOps$3
                @Override // j$.util.stream.Nodes, j$.util.stream.TerminalOp
                public final int BuiltInFictitiousFunctionClassFactory() {
                    if (collector.KClassImpl$Data$declaredNonStaticMembers$2().contains(Collector.Characteristics.UNORDERED)) {
                        return StreamOpFlag.NOT_ORDERED;
                    }
                    return 0;
                }

                @Override // j$.util.stream.Nodes
                public final ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$2() {
                    return new ReduceOps$3ReducingSink(BuiltInFictitiousFunctionClassFactory, authRequestContext, BinaryOperator.this);
                }
            });
        }
        return !collector.KClassImpl$Data$declaredNonStaticMembers$2().contains(Collector.Characteristics.IDENTITY_FINISH) ? collector.MyBillsEntityDataFactory().apply(MyBillsEntityDataFactory) : MyBillsEntityDataFactory;
    }

    @Override // j$.util.stream.Stream
    public void BuiltInFictitiousFunctionClassFactory(Consumer consumer) {
        MyBillsEntityDataFactory((TerminalOp) new ForEachOps$ForEachOp.OfRef(consumer, true));
    }

    @Override // j$.util.stream.Stream
    public final Object[] BuiltInFictitiousFunctionClassFactory(IntFunction intFunction) {
        return Nodes.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2(intFunction), intFunction).getAuthRequestContext(intFunction);
    }

    @Override // j$.util.stream.BaseStream
    public final Iterator DatabaseTableConfigUtil() {
        return Spliterators.MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda2());
    }

    @Override // j$.util.stream.Stream
    public final long GetContactSyncConfig() {
        return new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, new SliceOps$$ExternalSyntheticLambda0(10), 7).SubSequence();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractPipeline
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return 1;
    }

    @Override // j$.util.stream.Stream
    public final IntStream KClassImpl$Data$declaredNonStaticMembers$2(ToIntFunction toIntFunction) {
        return new IntPipeline.AnonymousClass3(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, toIntFunction, 6);
    }

    @Override // j$.util.stream.Stream
    public final Stream KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        if (j >= 0) {
            return Node.CC.BuiltInFictitiousFunctionClassFactory(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.Stream
    public final Stream KClassImpl$Data$declaredNonStaticMembers$2(Function function) {
        return new AnonymousClass3(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, function, 0);
    }

    @Override // j$.util.stream.Stream
    public final Stream KClassImpl$Data$declaredNonStaticMembers$2(Comparator comparator) {
        return new SortedOps$OfRef(this, comparator);
    }

    @Override // j$.util.stream.Stream
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Predicate predicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.ALL;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(2, matchOps$MatchKind, predicate)))).booleanValue();
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator MyBillsEntityDataFactory(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator(supplier);
    }

    @Override // j$.util.stream.Stream
    public final DoubleStream MyBillsEntityDataFactory(ToDoubleFunction toDoubleFunction) {
        return new IntPipeline.AnonymousClass6(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, toDoubleFunction, 6);
    }

    @Override // j$.util.stream.Stream
    public final LongStream MyBillsEntityDataFactory(Function function) {
        return new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, function, 6);
    }

    @Override // j$.util.stream.Stream
    public final Object MyBillsEntityDataFactory(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return MyBillsEntityDataFactory(new ReduceOps$1(biConsumer2, biConsumer, supplier, 3));
    }

    @Override // j$.util.stream.Stream
    public final Object MyBillsEntityDataFactory(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return MyBillsEntityDataFactory(new ReduceOps$1(binaryOperator, biFunction, obj, 0));
    }

    @Override // j$.util.stream.Stream
    public final boolean MyBillsEntityDataFactory(Predicate predicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.ANY;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(2, matchOps$MatchKind, predicate)))).booleanValue();
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return !BuiltInFictitiousFunctionClassFactory() ? this : new StatelessOp(this, StreamOpFlag.NOT_ORDERED) { // from class: j$.util.stream.ReferencePipeline.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // j$.util.stream.AbstractPipeline
            public final Sink getAuthRequestContext(int i, Sink sink) {
                return sink;
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final Optional NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return (Optional) MyBillsEntityDataFactory(new FindOps$FindOp(false, Optional.MyBillsEntityDataFactory(), new Node$$ExternalSyntheticLambda0(8), new FindOps$$ExternalSyntheticLambda1(16)));
    }

    @Override // j$.util.stream.Stream
    public final Stream NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return new SortedOps$OfRef(this);
    }

    @Override // j$.util.stream.Stream
    public final IntStream PlaceComponentResult(Function function) {
        return new IntPipeline.AnonymousClass3(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, function, 7);
    }

    @Override // j$.util.stream.Stream
    public final LongStream PlaceComponentResult(ToLongFunction toLongFunction) {
        return new IntPipeline.AnonymousClass5(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, toLongFunction, 7);
    }

    @Override // j$.util.stream.Stream
    public void PlaceComponentResult(Consumer consumer) {
        MyBillsEntityDataFactory((TerminalOp) new ForEachOps$ForEachOp.OfRef(consumer, false));
    }

    @Override // j$.util.stream.Stream
    public final boolean PlaceComponentResult(Predicate predicate) {
        MatchOps$MatchKind matchOps$MatchKind = MatchOps$MatchKind.NONE;
        return ((Boolean) MyBillsEntityDataFactory(new MatchOps$MatchOp(matchOps$MatchKind, new MatchOps$$ExternalSyntheticLambda0(2, matchOps$MatchKind, predicate)))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final Optional getAuthRequestContext(Comparator comparator) {
        return (Optional) MyBillsEntityDataFactory(new ReduceOps$2(new Predicate$$ExternalSyntheticLambda3(1, comparator), 0));
    }

    @Override // j$.util.stream.Stream
    public final Stream getAuthRequestContext(long j) {
        if (j >= 0) {
            return j == 0 ? this : Node.CC.BuiltInFictitiousFunctionClassFactory(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.Stream
    public final Stream getAuthRequestContext(Consumer consumer) {
        return new IntPipeline.AnonymousClass4(this, 0, consumer, 3);
    }

    @Override // j$.util.stream.Stream
    public final Stream getAuthRequestContext(Function function) {
        return new AnonymousClass3(this, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, function, 1);
    }

    @Override // j$.util.stream.Stream
    public final Stream getAuthRequestContext(Predicate predicate) {
        return new IntPipeline.AnonymousClass4(this, StreamOpFlag.NOT_SIZED, predicate, 4);
    }

    @Override // j$.util.stream.Stream
    public final Object getAuthRequestContext(Object obj, BinaryOperator binaryOperator) {
        return MyBillsEntityDataFactory(new ReduceOps$1(binaryOperator, binaryOperator, obj, 0));
    }

    @Override // j$.util.stream.AbstractPipeline
    final void getAuthRequestContext(Spliterator spliterator, Sink sink) {
        while (!sink.cancellationRequested() && spliterator.KClassImpl$Data$declaredNonStaticMembers$2(sink)) {
        }
    }

    @Override // j$.util.stream.Stream
    public final Stream initRecordTimeStamp() {
        return new DistinctOps$1(this, StreamOpFlag.IS_DISTINCT | StreamOpFlag.NOT_SIZED);
    }

    @Override // j$.util.stream.Stream
    public final Optional isLayoutRequested() {
        return (Optional) MyBillsEntityDataFactory(new FindOps$FindOp(true, Optional.MyBillsEntityDataFactory(), new Node$$ExternalSyntheticLambda0(8), new FindOps$$ExternalSyntheticLambda1(16)));
    }

    @Override // j$.util.stream.Stream
    public final Object[] newProxyInstance() {
        SliceOps$$ExternalSyntheticLambda0 sliceOps$$ExternalSyntheticLambda0 = new SliceOps$$ExternalSyntheticLambda0(9);
        return Nodes.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2((IntFunction) sliceOps$$ExternalSyntheticLambda0), sliceOps$$ExternalSyntheticLambda0).getAuthRequestContext(sliceOps$$ExternalSyntheticLambda0);
    }
}
