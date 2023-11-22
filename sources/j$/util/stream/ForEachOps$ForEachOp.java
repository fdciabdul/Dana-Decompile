package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
abstract class ForEachOps$ForEachOp implements TerminalOp, TerminalSink {
    private final boolean PlaceComponentResult;

    /* loaded from: classes.dex */
    final class OfDouble extends ForEachOps$ForEachOp implements Sink.OfDouble {
        final DoubleConsumer BuiltInFictitiousFunctionClassFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfDouble(DoubleConsumer doubleConsumer, boolean z) {
            super(z);
            this.BuiltInFictitiousFunctionClassFactory = doubleConsumer;
        }

        @Override // j$.util.stream.ForEachOps$ForEachOp, j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final void accept(double d) {
            this.BuiltInFictitiousFunctionClassFactory.accept(d);
        }

        @Override // j$.util.stream.Sink.OfDouble
        public final /* synthetic */ void accept(Double d) {
            Node.CC.BuiltInFictitiousFunctionClassFactory(this, d);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Double) obj);
        }

        @Override // j$.util.function.DoubleConsumer
        public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
        }
    }

    /* loaded from: classes.dex */
    final class OfInt extends ForEachOps$ForEachOp implements Sink.OfInt {
        final IntConsumer MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfInt(IntConsumer intConsumer, boolean z) {
            super(z);
            this.MyBillsEntityDataFactory = intConsumer;
        }

        @Override // j$.util.stream.ForEachOps$ForEachOp, j$.util.stream.Sink
        public final void accept(int i) {
            this.MyBillsEntityDataFactory.accept(i);
        }

        @Override // j$.util.stream.Sink.OfInt
        public final /* synthetic */ void accept(Integer num) {
            Node.CC.MyBillsEntityDataFactory(this, num);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Integer) obj);
        }

        @Override // j$.util.function.IntConsumer
        public final IntConsumer andThen(IntConsumer intConsumer) {
            return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
        }
    }

    /* loaded from: classes.dex */
    final class OfLong extends ForEachOps$ForEachOp implements Sink.OfLong {
        final LongConsumer getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfLong(LongConsumer longConsumer, boolean z) {
            super(z);
            this.getAuthRequestContext = longConsumer;
        }

        @Override // j$.util.stream.ForEachOps$ForEachOp, j$.util.stream.Sink
        public final void accept(long j) {
            this.getAuthRequestContext.accept(j);
        }

        @Override // j$.util.stream.Sink.OfLong
        public final /* synthetic */ void accept(Long l) {
            Node.CC.PlaceComponentResult(this, l);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Long) obj);
        }

        @Override // j$.util.function.LongConsumer
        public final LongConsumer andThen(LongConsumer longConsumer) {
            return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
        }
    }

    /* loaded from: classes.dex */
    final class OfRef extends ForEachOps$ForEachOp {
        final Consumer BuiltInFictitiousFunctionClassFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfRef(Consumer consumer, boolean z) {
            super(z);
            this.BuiltInFictitiousFunctionClassFactory = consumer;
        }

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            this.BuiltInFictitiousFunctionClassFactory.accept(obj);
        }
    }

    protected ForEachOps$ForEachOp(boolean z) {
        this.PlaceComponentResult = z;
    }

    @Override // j$.util.stream.TerminalOp
    public final int BuiltInFictitiousFunctionClassFactory() {
        if (this.PlaceComponentResult) {
            return 0;
        }
        return StreamOpFlag.NOT_ORDERED;
    }

    @Override // j$.util.stream.TerminalOp
    public final Object MyBillsEntityDataFactory(Node.CC cc, Spliterator spliterator) {
        cc.PlaceComponentResult(spliterator, this);
        return null;
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d) {
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public /* synthetic */ void accept(int i) {
        Node.CC.C();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public /* synthetic */ void accept(long j) {
        Node.CC.A();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void begin(long j) {
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // j$.util.stream.TerminalOp
    public final Object getAuthRequestContext(Node.CC cc, Spliterator spliterator) {
        (this.PlaceComponentResult ? new ForEachOps$ForEachOrderedTask(cc, spliterator, this) : new ForEachOps$ForEachTask(cc, spliterator, cc.getAuthRequestContext(this))).invoke();
        return null;
    }
}
