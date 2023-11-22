package j$.util.stream;

import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final /* synthetic */ class LongPipeline$$ExternalSyntheticLambda11 implements LongConsumer {
    public final /* synthetic */ int PlaceComponentResult;
    public final /* synthetic */ Sink getAuthRequestContext;

    public /* synthetic */ LongPipeline$$ExternalSyntheticLambda11(int i, Sink sink) {
        this.PlaceComponentResult = i;
        this.getAuthRequestContext = sink;
    }

    @Override // j$.util.function.LongConsumer
    public final void accept(long j) {
        (this.PlaceComponentResult != 0 ? ((LongPipeline$1$1) this.getAuthRequestContext).getAuthRequestContext : this.getAuthRequestContext).accept(j);
    }

    @Override // j$.util.function.LongConsumer
    public final LongConsumer andThen(LongConsumer longConsumer) {
        return this.PlaceComponentResult != 0 ? new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer) : new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
    }
}
