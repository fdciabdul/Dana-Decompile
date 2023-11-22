package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import id.dana.domain.nearbyme.interactor.merchantreview.UploadMerchantReviewImage;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantReviewModule_ProvidesUploadImageFactory implements Factory<UploadMerchantReviewImage> {
    private final Provider<MerchantReviewRepository> getAuthRequestContext;

    public static UploadMerchantReviewImage BuiltInFictitiousFunctionClassFactory(MerchantReviewRepository merchantReviewRepository) {
        return (UploadMerchantReviewImage) Preconditions.BuiltInFictitiousFunctionClassFactory(MerchantReviewModule.MyBillsEntityDataFactory(merchantReviewRepository));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UploadMerchantReviewImage) Preconditions.BuiltInFictitiousFunctionClassFactory(MerchantReviewModule.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
