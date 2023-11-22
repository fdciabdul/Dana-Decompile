package id.dana.cashier;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierEventHandler_Factory implements Factory<CashierEventHandler> {
    private final Provider<GetCashierNativeConfig> KClassImpl$Data$declaredNonStaticMembers$2;

    private CashierEventHandler_Factory(Provider<GetCashierNativeConfig> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static CashierEventHandler_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetCashierNativeConfig> provider) {
        return new CashierEventHandler_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierEventHandler(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
