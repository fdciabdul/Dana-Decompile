package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface Sink extends Consumer {

    /* loaded from: classes.dex */
    public abstract class ChainedDouble implements OfDouble {
        protected final Sink MyBillsEntityDataFactory;

        public ChainedDouble(Sink sink) {
            this.MyBillsEntityDataFactory = sink;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.stream.Sink.OfDouble
        public final /* synthetic */ void accept(Double d) {
            Node.CC.BuiltInFictitiousFunctionClassFactory(this, d);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            Node.CC.MyBillsEntityDataFactory(this, obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.function.DoubleConsumer
        public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
        }

        @Override // j$.util.stream.Sink
        public boolean cancellationRequested() {
            return this.MyBillsEntityDataFactory.cancellationRequested();
        }

        @Override // j$.util.stream.Sink
        public void end() {
            this.MyBillsEntityDataFactory.end();
        }
    }

    /* loaded from: classes.dex */
    public abstract class ChainedInt implements OfInt {
        protected final Sink KClassImpl$Data$declaredNonStaticMembers$2;

        public ChainedInt(Sink sink) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = sink;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.stream.Sink.OfInt
        public final /* synthetic */ void accept(Integer num) {
            Node.CC.MyBillsEntityDataFactory(this, num);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            Node.CC.PlaceComponentResult(this, obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.function.IntConsumer
        public final IntConsumer andThen(IntConsumer intConsumer) {
            return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
        }

        @Override // j$.util.stream.Sink
        public boolean cancellationRequested() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.cancellationRequested();
        }

        @Override // j$.util.stream.Sink
        public void end() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.end();
        }
    }

    /* loaded from: classes.dex */
    public abstract class ChainedLong implements OfLong {
        protected final Sink getAuthRequestContext;

        public ChainedLong(Sink sink) {
            this.getAuthRequestContext = sink;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink.OfLong
        public final /* synthetic */ void accept(Long l) {
            Node.CC.PlaceComponentResult(this, l);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            Node.CC.BuiltInFictitiousFunctionClassFactory(this, obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.function.LongConsumer
        public final LongConsumer andThen(LongConsumer longConsumer) {
            return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
        }

        @Override // j$.util.stream.Sink
        public boolean cancellationRequested() {
            return this.getAuthRequestContext.cancellationRequested();
        }

        @Override // j$.util.stream.Sink
        public void end() {
            this.getAuthRequestContext.end();
        }
    }

    /* loaded from: classes.dex */
    public abstract class ChainedReference implements Sink {
        protected final Sink MyBillsEntityDataFactory;

        public ChainedReference(Sink sink) {
            this.MyBillsEntityDataFactory = sink;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public boolean cancellationRequested() {
            return this.MyBillsEntityDataFactory.cancellationRequested();
        }

        @Override // j$.util.stream.Sink
        public void end() {
            this.MyBillsEntityDataFactory.end();
        }
    }

    /* loaded from: classes.dex */
    public interface OfDouble extends Sink, DoubleConsumer {
        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        void accept(double d);

        void accept(Double d);
    }

    /* loaded from: classes.dex */
    public interface OfInt extends Sink, IntConsumer {
        @Override // j$.util.stream.Sink
        void accept(int i);

        void accept(Integer num);
    }

    /* loaded from: classes.dex */
    public interface OfLong extends Sink, LongConsumer {
        @Override // j$.util.stream.Sink
        void accept(long j);

        void accept(Long l);
    }

    void accept(double d);

    void accept(int i);

    void accept(long j);

    void begin(long j);

    boolean cancellationRequested();

    void end();
}
