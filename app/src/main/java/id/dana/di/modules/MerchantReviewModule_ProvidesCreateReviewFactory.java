package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantReviewModule_ProvidesCreateReviewFactory implements Factory<CreateMerchantReview> {
    private final Provider<MerchantReviewRepository> MyBillsEntityDataFactory;

    public static CreateMerchantReview BuiltInFictitiousFunctionClassFactory(MerchantReviewRepository merchantReviewRepository) {
        return (CreateMerchantReview) Preconditions.BuiltInFictitiousFunctionClassFactory(MerchantReviewModule.KClassImpl$Data$declaredNonStaticMembers$2(merchantReviewRepository));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CreateMerchantReview) Preconditions.BuiltInFictitiousFunctionClassFactory(MerchantReviewModule.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
