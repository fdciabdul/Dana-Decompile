package j$.util.stream;

import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final /* synthetic */ class Node$OfDouble$$ExternalSyntheticLambda0 implements DoubleConsumer {
    public final /* synthetic */ int getAuthRequestContext;

    @Override // j$.util.function.DoubleConsumer
    public final void accept(double d) {
    }

    @Override // j$.util.function.DoubleConsumer
    public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return this.getAuthRequestContext != 0 ? new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer) : new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
    }
}
