package id.dana.kyb.helper.service.strategy;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KybServiceActionStrategyFactory_Factory implements Factory<KybServiceActionStrategyFactory> {
    private final Provider<KybServiceUrlActionStrategy> BuiltInFictitiousFunctionClassFactory;
    private final Provider<KybServiceDeepLinkActionStrategy> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<KybServiceActionTypeStrategy> MyBillsEntityDataFactory;
    private final Provider<KybServiceJsApiActionStrategy> PlaceComponentResult;
    private final Provider<KybServiceAuthActionStrategy> getAuthRequestContext;

    private KybServiceActionStrategyFactory_Factory(Provider<KybServiceUrlActionStrategy> provider, Provider<KybServiceAuthActionStrategy> provider2, Provider<KybServiceJsApiActionStrategy> provider3, Provider<KybServiceDeepLinkActionStrategy> provider4, Provider<KybServiceActionTypeStrategy> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static KybServiceActionStrategyFactory_Factory getAuthRequestContext(Provider<KybServiceUrlActionStrategy> provider, Provider<KybServiceAuthActionStrategy> provider2, Provider<KybServiceJsApiActionStrategy> provider3, Provider<KybServiceDeepLinkActionStrategy> provider4, Provider<KybServiceActionTypeStrategy> provider5) {
        return new KybServiceActionStrategyFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybServiceActionStrategyFactory(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
