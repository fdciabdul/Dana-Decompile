package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.loyalty.repository.LoyaltyEntityRepository;
import id.dana.domain.loyalty.LoyaltyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideLoyaltyRepositoryFactory implements Factory<LoyaltyRepository> {
    private final Provider<LoyaltyEntityRepository> MyBillsEntityDataFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideLoyaltyRepositoryFactory(ApplicationModule applicationModule, Provider<LoyaltyEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideLoyaltyRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<LoyaltyEntityRepository> provider) {
        return new ApplicationModule_ProvideLoyaltyRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LoyaltyRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
