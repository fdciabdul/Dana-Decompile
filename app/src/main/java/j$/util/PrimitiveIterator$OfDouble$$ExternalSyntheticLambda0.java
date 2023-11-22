package j$.util;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final /* synthetic */ class PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0 implements DoubleConsumer {
    public final /* synthetic */ Consumer BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(Consumer consumer) {
        this.BuiltInFictitiousFunctionClassFactory = consumer;
    }

    @Override // j$.util.function.DoubleConsumer
    public final void accept(double d) {
        this.BuiltInFictitiousFunctionClassFactory.accept(Double.valueOf(d));
    }

    @Override // j$.util.function.DoubleConsumer
    public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
    }
}
