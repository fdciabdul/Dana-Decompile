package id.dana.myprofile.mepagerevamp.smartpay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SmartPayModule_ProvidePresenterFactory implements Factory<SmartPayContract.Presenter> {
    private final SmartPayModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SmartPayPresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    private SmartPayModule_ProvidePresenterFactory(SmartPayModule smartPayModule, Provider<SmartPayPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = smartPayModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SmartPayModule_ProvidePresenterFactory MyBillsEntityDataFactory(SmartPayModule smartPayModule, Provider<SmartPayPresenter> provider) {
        return new SmartPayModule_ProvidePresenterFactory(smartPayModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SmartPayContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
