package j$.util.stream;

import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final /* synthetic */ class Node$OfInt$$ExternalSyntheticLambda0 implements IntConsumer {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // j$.util.function.IntConsumer
    public final void accept(int i) {
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 != 0 ? new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer) : new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }
}
