package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.nearbyme.repository.MerchantReviewEntityRepository;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantReviewModule_ProvideMerchantReviewRepositoryFactory implements Factory<MerchantReviewRepository> {
    private final Provider<MerchantReviewEntityRepository> getAuthRequestContext;

    public static MerchantReviewRepository PlaceComponentResult(MerchantReviewEntityRepository merchantReviewEntityRepository) {
        return (MerchantReviewRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(MerchantReviewModule.getAuthRequestContext(merchantReviewEntityRepository));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantReviewRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(MerchantReviewModule.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
