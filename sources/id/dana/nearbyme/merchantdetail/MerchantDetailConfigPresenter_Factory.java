package id.dana.nearbyme.merchantdetail;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailActionConfig;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantDetailConfigPresenter_Factory implements Factory<MerchantDetailConfigPresenter> {
    private final Provider<GetMerchantDetailActionConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetMerchantDetailPromoConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MerchantDetailConfigContract.View> MyBillsEntityDataFactory;

    private MerchantDetailConfigPresenter_Factory(Provider<MerchantDetailConfigContract.View> provider, Provider<GetMerchantDetailActionConfig> provider2, Provider<GetMerchantDetailPromoConfig> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static MerchantDetailConfigPresenter_Factory getAuthRequestContext(Provider<MerchantDetailConfigContract.View> provider, Provider<GetMerchantDetailActionConfig> provider2, Provider<GetMerchantDetailPromoConfig> provider3) {
        return new MerchantDetailConfigPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantDetailConfigPresenter(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
