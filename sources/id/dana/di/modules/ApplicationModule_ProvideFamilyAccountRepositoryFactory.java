package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.familyaccount.repository.FamilyAccountEntityRepository;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFamilyAccountRepositoryFactory implements Factory<FamilyAccountRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FamilyAccountEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideFamilyAccountRepositoryFactory(ApplicationModule applicationModule, Provider<FamilyAccountEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideFamilyAccountRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<FamilyAccountEntityRepository> provider) {
        return new ApplicationModule_ProvideFamilyAccountRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyAccountRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.PlaceComponentResult.get()));
    }
}
