package j$.util.stream;

import j$.util.Optional;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.DoubleBinaryOperator;
import j$.util.function.IntBinaryOperator;
import j$.util.function.LongBinaryOperator;
import j$.util.stream.Node;

/* loaded from: classes2.dex */
final class ReduceOps$2 extends Nodes {
    final /* synthetic */ Object BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ int getAuthRequestContext;

    public /* synthetic */ ReduceOps$2(Object obj, int i) {
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = obj;
    }

    @Override // j$.util.stream.Nodes
    public final ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.getAuthRequestContext;
        if (i != 0) {
            return i != 1 ? i != 2 ? new ReduceOps$9ReducingSink((LongBinaryOperator) this.BuiltInFictitiousFunctionClassFactory) : new ReduceOps$6ReducingSink((IntBinaryOperator) this.BuiltInFictitiousFunctionClassFactory) : new ReduceOps$12ReducingSink((DoubleBinaryOperator) this.BuiltInFictitiousFunctionClassFactory);
        }
        final BinaryOperator binaryOperator = (BinaryOperator) this.BuiltInFictitiousFunctionClassFactory;
        return new ReduceOps$AccumulatingSink() { // from class: j$.util.stream.ReduceOps$2ReducingSink
            private Object KClassImpl$Data$declaredNonStaticMembers$2;
            private boolean MyBillsEntityDataFactory;

            @Override // j$.util.stream.ReduceOps$AccumulatingSink
            public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
                ReduceOps$2ReducingSink reduceOps$2ReducingSink = (ReduceOps$2ReducingSink) reduceOps$AccumulatingSink;
                if (reduceOps$2ReducingSink.MyBillsEntityDataFactory) {
                    return;
                }
                accept(reduceOps$2ReducingSink.KClassImpl$Data$declaredNonStaticMembers$2);
            }

            @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
            public final /* synthetic */ void accept(double d) {
                Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
                throw null;
            }

            @Override // j$.util.stream.Sink
            public final /* synthetic */ void accept(int i2) {
                Node.CC.C();
                throw null;
            }

            @Override // j$.util.stream.Sink
            public final /* synthetic */ void accept(long j) {
                Node.CC.A();
                throw null;
            }

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                if (this.MyBillsEntityDataFactory) {
                    this.MyBillsEntityDataFactory = false;
                } else {
                    obj = BinaryOperator.this.apply(this.KClassImpl$Data$declaredNonStaticMembers$2, obj);
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
            }

            @Override // j$.util.function.Consumer
            public final /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.PlaceComponentResult(this, consumer);
            }

            @Override // j$.util.stream.Sink
            public final void begin(long j) {
                this.MyBillsEntityDataFactory = true;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }

            @Override // j$.util.stream.Sink
            public final /* synthetic */ boolean cancellationRequested() {
                return false;
            }

            @Override // j$.util.stream.Sink
            public final /* synthetic */ void end() {
            }

            @Override // j$.util.function.Supplier
            public final Object get() {
                return this.MyBillsEntityDataFactory ? Optional.MyBillsEntityDataFactory() : Optional.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        };
    }
}
