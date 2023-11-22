package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.usereducation.repository.UserEducationEntityRepository;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserEducationRepositoryFactory implements Factory<UserEducationRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<UserEducationEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideUserEducationRepositoryFactory(ApplicationModule applicationModule, Provider<UserEducationEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideUserEducationRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<UserEducationEntityRepository> provider) {
        return new ApplicationModule_ProvideUserEducationRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserEducationRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
