package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserPersonalizationEntityRepositoryFactory implements Factory<UserPersonalizationRepository> {
    private final Provider<UserPersonalizationEntityRepository> MyBillsEntityDataFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideUserPersonalizationEntityRepositoryFactory(ApplicationModule applicationModule, Provider<UserPersonalizationEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideUserPersonalizationEntityRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<UserPersonalizationEntityRepository> provider) {
        return new ApplicationModule_ProvideUserPersonalizationEntityRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserPersonalizationRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
