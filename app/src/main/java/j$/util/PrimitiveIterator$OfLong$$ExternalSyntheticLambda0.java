package j$.util;

import j$.util.function.Consumer;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final /* synthetic */ class PrimitiveIterator$OfLong$$ExternalSyntheticLambda0 implements LongConsumer {
    public final /* synthetic */ Consumer BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(Consumer consumer) {
        this.BuiltInFictitiousFunctionClassFactory = consumer;
    }

    @Override // j$.util.function.LongConsumer
    public final void accept(long j) {
        this.BuiltInFictitiousFunctionClassFactory.accept(Long.valueOf(j));
    }

    @Override // j$.util.function.LongConsumer
    public final LongConsumer andThen(LongConsumer longConsumer) {
        return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
    }
}
