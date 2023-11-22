package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;

/* loaded from: classes4.dex */
public final class MerchantDetailReviewModule_ProvideMerchantReviewDetailFactory implements Factory<MerchantDetailReviewContract.View> {
    private final MerchantDetailReviewModule MyBillsEntityDataFactory;

    private MerchantDetailReviewModule_ProvideMerchantReviewDetailFactory(MerchantDetailReviewModule merchantDetailReviewModule) {
        this.MyBillsEntityDataFactory = merchantDetailReviewModule;
    }

    public static MerchantDetailReviewModule_ProvideMerchantReviewDetailFactory getAuthRequestContext(MerchantDetailReviewModule merchantDetailReviewModule) {
        return new MerchantDetailReviewModule_ProvideMerchantReviewDetailFactory(merchantDetailReviewModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailReviewContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
