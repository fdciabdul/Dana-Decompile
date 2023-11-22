package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class DoubleConsumer$$ExternalSyntheticLambda0 implements DoubleConsumer {
    public final /* synthetic */ DoubleConsumer KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ DoubleConsumer PlaceComponentResult;

    public /* synthetic */ DoubleConsumer$$ExternalSyntheticLambda0(DoubleConsumer doubleConsumer, DoubleConsumer doubleConsumer2) {
        this.PlaceComponentResult = doubleConsumer;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = doubleConsumer2;
    }

    @Override // j$.util.function.DoubleConsumer
    public final void accept(double d) {
        DoubleConsumer doubleConsumer = this.PlaceComponentResult;
        DoubleConsumer doubleConsumer2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        doubleConsumer.accept(d);
        doubleConsumer2.accept(d);
    }

    @Override // j$.util.function.DoubleConsumer
    public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
    }
}
