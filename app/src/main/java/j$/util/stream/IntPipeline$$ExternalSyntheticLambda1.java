package j$.util.stream;

import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.IntPipeline;

/* loaded from: classes.dex */
public final /* synthetic */ class IntPipeline$$ExternalSyntheticLambda1 implements IntConsumer {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ Sink getAuthRequestContext;

    public /* synthetic */ IntPipeline$$ExternalSyntheticLambda1(int i, Sink sink) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = sink;
    }

    @Override // j$.util.function.IntConsumer
    public final void accept(int i) {
        (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0 ? ((IntPipeline.AnonymousClass1.C01991) this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2 : this.getAuthRequestContext).accept(i);
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 != 0 ? new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer) : new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }
}
