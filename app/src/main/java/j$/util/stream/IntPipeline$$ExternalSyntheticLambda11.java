package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class IntPipeline$$ExternalSyntheticLambda11 implements BinaryOperator {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ BiConsumer PlaceComponentResult;

    public /* synthetic */ IntPipeline$$ExternalSyntheticLambda11(BiConsumer biConsumer, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = biConsumer;
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 != 0 ? BiFunction.CC.MyBillsEntityDataFactory(this, function) : BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        BiConsumer biConsumer;
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 0) {
            biConsumer = this.PlaceComponentResult;
        } else if (i != 1) {
            biConsumer = this.PlaceComponentResult;
            int i2 = LongPipeline.lookAheadTest;
        } else {
            biConsumer = this.PlaceComponentResult;
            int i3 = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
        }
        biConsumer.accept(obj, obj2);
        return obj;
    }
}
