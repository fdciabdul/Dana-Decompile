package j$.util.stream;

import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final /* synthetic */ class Node$OfLong$$ExternalSyntheticLambda0 implements LongConsumer {
    public final /* synthetic */ int getAuthRequestContext;

    @Override // j$.util.function.LongConsumer
    public final void accept(long j) {
    }

    @Override // j$.util.function.LongConsumer
    public final LongConsumer andThen(LongConsumer longConsumer) {
        return this.getAuthRequestContext != 0 ? new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer) : new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
    }
}
