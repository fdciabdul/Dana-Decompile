package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.useremailaddress.repository.UserEmailAddressEntityRepository;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserEmailAddressRepositoryFactory implements Factory<UserEmailAddressRepository> {
    private final Provider<UserEmailAddressEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideUserEmailAddressRepositoryFactory(ApplicationModule applicationModule, Provider<UserEmailAddressEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideUserEmailAddressRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<UserEmailAddressEntityRepository> provider) {
        return new ApplicationModule_ProvideUserEmailAddressRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserEmailAddressRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
