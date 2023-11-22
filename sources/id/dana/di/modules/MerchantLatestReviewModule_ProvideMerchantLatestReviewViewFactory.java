package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewContract;

/* loaded from: classes4.dex */
public final class MerchantLatestReviewModule_ProvideMerchantLatestReviewViewFactory implements Factory<MerchantLatestReviewContract.View> {
    private final MerchantLatestReviewModule MyBillsEntityDataFactory;

    private MerchantLatestReviewModule_ProvideMerchantLatestReviewViewFactory(MerchantLatestReviewModule merchantLatestReviewModule) {
        this.MyBillsEntityDataFactory = merchantLatestReviewModule;
    }

    public static MerchantLatestReviewModule_ProvideMerchantLatestReviewViewFactory getAuthRequestContext(MerchantLatestReviewModule merchantLatestReviewModule) {
        return new MerchantLatestReviewModule_ProvideMerchantLatestReviewViewFactory(merchantLatestReviewModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantLatestReviewContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
