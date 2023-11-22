package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFeedsRelationshipRepositoryFactory implements Factory<FeedsRelationshipRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsRelationshipEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideFeedsRelationshipRepositoryFactory(ApplicationModule applicationModule, Provider<FeedsRelationshipEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideFeedsRelationshipRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<FeedsRelationshipEntityRepository> provider) {
        return new ApplicationModule_ProvideFeedsRelationshipRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsRelationshipRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
