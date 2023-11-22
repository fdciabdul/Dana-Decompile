package j$.util;

import j$.util.function.Consumer;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final /* synthetic */ class PrimitiveIterator$OfInt$$ExternalSyntheticLambda0 implements IntConsumer {
    public final /* synthetic */ Consumer PlaceComponentResult;

    public /* synthetic */ PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(Consumer consumer) {
        this.PlaceComponentResult = consumer;
    }

    @Override // j$.util.function.IntConsumer
    public final void accept(int i) {
        this.PlaceComponentResult.accept(Integer.valueOf(i));
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }
}
