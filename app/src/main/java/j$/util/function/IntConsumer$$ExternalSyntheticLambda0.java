package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class IntConsumer$$ExternalSyntheticLambda0 implements IntConsumer {
    public final /* synthetic */ IntConsumer BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ IntConsumer MyBillsEntityDataFactory;

    public /* synthetic */ IntConsumer$$ExternalSyntheticLambda0(IntConsumer intConsumer, IntConsumer intConsumer2) {
        this.BuiltInFictitiousFunctionClassFactory = intConsumer;
        this.MyBillsEntityDataFactory = intConsumer2;
    }

    @Override // j$.util.function.IntConsumer
    public final void accept(int i) {
        IntConsumer intConsumer = this.BuiltInFictitiousFunctionClassFactory;
        IntConsumer intConsumer2 = this.MyBillsEntityDataFactory;
        intConsumer.accept(i);
        intConsumer2.accept(i);
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }
}
