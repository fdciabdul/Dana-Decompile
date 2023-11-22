package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.wallet_v3.repository.PersonalTabEntityRepository;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePersonalTabEntityRepositoryFactory implements Factory<PersonalTabRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PersonalTabEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvidePersonalTabEntityRepositoryFactory(ApplicationModule applicationModule, Provider<PersonalTabEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvidePersonalTabEntityRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<PersonalTabEntityRepository> provider) {
        return new ApplicationModule_ProvidePersonalTabEntityRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PersonalTabRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
