package id.dana.di.modules;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierEventHandler;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideCashierEventHandlerFactory implements Factory<CashierEventHandler> {
    private final GContainerModule PlaceComponentResult;
    private final Provider<GetCashierNativeConfig> getAuthRequestContext;

    private GContainerModule_ProvideCashierEventHandlerFactory(GContainerModule gContainerModule, Provider<GetCashierNativeConfig> provider) {
        this.PlaceComponentResult = gContainerModule;
        this.getAuthRequestContext = provider;
    }

    public static GContainerModule_ProvideCashierEventHandlerFactory getAuthRequestContext(GContainerModule gContainerModule, Provider<GetCashierNativeConfig> provider) {
        return new GContainerModule_ProvideCashierEventHandlerFactory(gContainerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierEventHandler) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext)));
    }
}
