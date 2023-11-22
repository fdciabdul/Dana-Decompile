package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantDetailConfigModule_ProvidesPresenterFactory implements Factory<MerchantDetailConfigContract.Presenter> {
    private final MerchantDetailConfigModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MerchantDetailConfigPresenter> getAuthRequestContext;

    private MerchantDetailConfigModule_ProvidesPresenterFactory(MerchantDetailConfigModule merchantDetailConfigModule, Provider<MerchantDetailConfigPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantDetailConfigModule;
        this.getAuthRequestContext = provider;
    }

    public static MerchantDetailConfigModule_ProvidesPresenterFactory MyBillsEntityDataFactory(MerchantDetailConfigModule merchantDetailConfigModule, Provider<MerchantDetailConfigPresenter> provider) {
        return new MerchantDetailConfigModule_ProvidesPresenterFactory(merchantDetailConfigModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailConfigContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
