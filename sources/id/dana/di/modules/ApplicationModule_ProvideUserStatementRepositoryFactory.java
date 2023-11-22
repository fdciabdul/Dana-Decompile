package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.statement.repository.UserStatementEntityRepository;
import id.dana.domain.statement.UserStatementRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserStatementRepositoryFactory implements Factory<UserStatementRepository> {
    private final Provider<UserStatementEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideUserStatementRepositoryFactory(ApplicationModule applicationModule, Provider<UserStatementEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideUserStatementRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<UserStatementEntityRepository> provider) {
        return new ApplicationModule_ProvideUserStatementRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserStatementRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
