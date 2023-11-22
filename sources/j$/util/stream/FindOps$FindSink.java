package j$.util.stream;

import j$.util.Optional;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.OptionalLong;
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
abstract class FindOps$FindSink implements TerminalSink {
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    Object getAuthRequestContext;

    /* loaded from: classes.dex */
    final class OfDouble extends FindOps$FindSink implements Sink.OfDouble {
        @Override // j$.util.stream.FindOps$FindSink, j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final void accept(double d) {
            accept((Object) Double.valueOf(d));
        }

        @Override // j$.util.function.DoubleConsumer
        public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
        }

        @Override // j$.util.function.Supplier
        public final Object get() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return OptionalDouble.KClassImpl$Data$declaredNonStaticMembers$2(((Double) this.getAuthRequestContext).doubleValue());
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    final class OfInt extends FindOps$FindSink implements Sink.OfInt {
        @Override // j$.util.stream.FindOps$FindSink, j$.util.stream.Sink
        public final void accept(int i) {
            accept((Object) Integer.valueOf(i));
        }

        @Override // j$.util.function.IntConsumer
        public final IntConsumer andThen(IntConsumer intConsumer) {
            return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
        }

        @Override // j$.util.function.Supplier
        public final Object get() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return OptionalInt.MyBillsEntityDataFactory(((Integer) this.getAuthRequestContext).intValue());
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    final class OfLong extends FindOps$FindSink implements Sink.OfLong {
        @Override // j$.util.stream.FindOps$FindSink, j$.util.stream.Sink
        public final void accept(long j) {
            accept((Object) Long.valueOf(j));
        }

        @Override // j$.util.function.LongConsumer
        public final LongConsumer andThen(LongConsumer longConsumer) {
            return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
        }

        @Override // j$.util.function.Supplier
        public final Object get() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return OptionalLong.PlaceComponentResult(((Long) this.getAuthRequestContext).longValue());
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    final class OfRef extends FindOps$FindSink {
        @Override // j$.util.function.Supplier
        public final Object get() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return Optional.MyBillsEntityDataFactory(this.getAuthRequestContext);
            }
            return null;
        }
    }

    FindOps$FindSink() {
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

    public /* bridge */ /* synthetic */ void accept(Double d) {
        accept((Object) d);
    }

    public /* bridge */ /* synthetic */ void accept(Integer num) {
        accept((Object) num);
    }

    public /* bridge */ /* synthetic */ void accept(Long l) {
        accept((Object) l);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getAuthRequestContext = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void begin(long j) {
    }

    @Override // j$.util.stream.Sink
    public final boolean cancellationRequested() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void end() {
    }
}
