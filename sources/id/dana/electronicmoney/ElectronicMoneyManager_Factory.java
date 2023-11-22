package id.dana.electronicmoney;

import dagger.internal.Factory;
import id.dana.electronicmoney.bank.bri.BriBrizziManager;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ElectronicMoneyManager_Factory implements Factory<ElectronicMoneyManager> {
    private final Provider<MandiriEmoneyManager> BuiltInFictitiousFunctionClassFactory;
    private final Provider<BriBrizziManager> KClassImpl$Data$declaredNonStaticMembers$2;

    private ElectronicMoneyManager_Factory(Provider<MandiriEmoneyManager> provider, Provider<BriBrizziManager> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static ElectronicMoneyManager_Factory BuiltInFictitiousFunctionClassFactory(Provider<MandiriEmoneyManager> provider, Provider<BriBrizziManager> provider2) {
        return new ElectronicMoneyManager_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ElectronicMoneyManager(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
