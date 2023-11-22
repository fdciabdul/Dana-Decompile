package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.nearbyme.repository.MerchantReviewFormEntityRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMerchantReviewRepositoryFactory implements Factory<MerchantReviewFormRepository> {
    private final Provider<MerchantReviewFormEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideMerchantReviewRepositoryFactory(ApplicationModule applicationModule, Provider<MerchantReviewFormEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideMerchantReviewRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<MerchantReviewFormEntityRepository> provider) {
        return new ApplicationModule_ProvideMerchantReviewRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantReviewFormRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
