package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class LongConsumer$$ExternalSyntheticLambda0 implements LongConsumer {
    public final /* synthetic */ LongConsumer BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ LongConsumer PlaceComponentResult;

    public /* synthetic */ LongConsumer$$ExternalSyntheticLambda0(LongConsumer longConsumer, LongConsumer longConsumer2) {
        this.BuiltInFictitiousFunctionClassFactory = longConsumer;
        this.PlaceComponentResult = longConsumer2;
    }

    @Override // j$.util.function.LongConsumer
    public final void accept(long j) {
        LongConsumer longConsumer = this.BuiltInFictitiousFunctionClassFactory;
        LongConsumer longConsumer2 = this.PlaceComponentResult;
        longConsumer.accept(j);
        longConsumer2.accept(j);
    }

    @Override // j$.util.function.LongConsumer
    public final LongConsumer andThen(LongConsumer longConsumer) {
        return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
    }
}
