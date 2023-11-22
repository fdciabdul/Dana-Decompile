package j$.util.stream;

import j$.util.Map;
import j$.util.StringJoiner;
import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Set;

/* loaded from: classes2.dex */
public final /* synthetic */ class Collectors$$ExternalSyntheticLambda41 implements BiConsumer, Supplier {
    public final /* synthetic */ Object BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ Object MyBillsEntityDataFactory;
    public final /* synthetic */ Object PlaceComponentResult;

    public /* synthetic */ Collectors$$ExternalSyntheticLambda41(Object obj, Object obj2, Object obj3) {
        this.MyBillsEntityDataFactory = obj;
        this.BuiltInFictitiousFunctionClassFactory = obj2;
        this.PlaceComponentResult = obj3;
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Function function = (Function) this.MyBillsEntityDataFactory;
        Function function2 = (Function) this.BuiltInFictitiousFunctionClassFactory;
        BinaryOperator binaryOperator = (BinaryOperator) this.PlaceComponentResult;
        Set set = Collectors.getAuthRequestContext;
        Map.EL.BuiltInFictitiousFunctionClassFactory((java.util.Map) obj, function.apply(obj2), function2.apply(obj2), binaryOperator);
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        CharSequence charSequence = (CharSequence) this.MyBillsEntityDataFactory;
        CharSequence charSequence2 = (CharSequence) this.BuiltInFictitiousFunctionClassFactory;
        CharSequence charSequence3 = (CharSequence) this.PlaceComponentResult;
        Set set = Collectors.getAuthRequestContext;
        return new StringJoiner(charSequence, charSequence2, charSequence3);
    }
}
