package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.user.UserEntityRepository;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
    private final Provider<UserEntityRepository> MyBillsEntityDataFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideUserRepositoryFactory(ApplicationModule applicationModule, Provider<UserEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideUserRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<UserEntityRepository> provider) {
        return new ApplicationModule_ProvideUserRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
