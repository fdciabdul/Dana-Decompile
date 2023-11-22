package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.contactinjection.ContactInjectionEntityRepository;
import id.dana.domain.contactinjection.ContactInjectionRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideContactInjectionRepositoryFactory implements Factory<ContactInjectionRepository> {
    private final Provider<ContactInjectionEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideContactInjectionRepositoryFactory(ApplicationModule applicationModule, Provider<ContactInjectionEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideContactInjectionRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<ContactInjectionEntityRepository> provider) {
        return new ApplicationModule_ProvideContactInjectionRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ContactInjectionRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
