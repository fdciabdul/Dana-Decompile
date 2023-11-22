package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantDetailModule_ProvidePresenterFactory implements Factory<MerchantDetailContract.Presenter> {
    private final MerchantDetailModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MerchantDetailPresenter> getAuthRequestContext;

    private MerchantDetailModule_ProvidePresenterFactory(MerchantDetailModule merchantDetailModule, Provider<MerchantDetailPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantDetailModule;
        this.getAuthRequestContext = provider;
    }

    public static MerchantDetailModule_ProvidePresenterFactory MyBillsEntityDataFactory(MerchantDetailModule merchantDetailModule, Provider<MerchantDetailPresenter> provider) {
        return new MerchantDetailModule_ProvidePresenterFactory(merchantDetailModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
