package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.saving.repository.SavingCategoryEntityRepository;
import id.dana.domain.saving.SavingCategoryRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSavingCategoryRepositoryFactory implements Factory<SavingCategoryRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<SavingCategoryEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideSavingCategoryRepositoryFactory(ApplicationModule applicationModule, Provider<SavingCategoryEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideSavingCategoryRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<SavingCategoryEntityRepository> provider) {
        return new ApplicationModule_ProvideSavingCategoryRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingCategoryRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
