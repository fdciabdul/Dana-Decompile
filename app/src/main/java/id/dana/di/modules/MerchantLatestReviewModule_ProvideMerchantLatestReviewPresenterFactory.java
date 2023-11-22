package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantLatestReviewModule_ProvideMerchantLatestReviewPresenterFactory implements Factory<MerchantLatestReviewContract.Presenter> {
    private final MerchantLatestReviewModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<MerchantLatestReviewPresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    private MerchantLatestReviewModule_ProvideMerchantLatestReviewPresenterFactory(MerchantLatestReviewModule merchantLatestReviewModule, Provider<MerchantLatestReviewPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = merchantLatestReviewModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static MerchantLatestReviewModule_ProvideMerchantLatestReviewPresenterFactory getAuthRequestContext(MerchantLatestReviewModule merchantLatestReviewModule, Provider<MerchantLatestReviewPresenter> provider) {
        return new MerchantLatestReviewModule_ProvideMerchantLatestReviewPresenterFactory(merchantLatestReviewModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantLatestReviewContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
