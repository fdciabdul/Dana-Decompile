package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.usersecurityquestions.repository.UserSecurityQuestionStateEntityRepository;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserSecurityQuestionStateRepositoryFactory implements Factory<UserSecurityQuestionStateRepository> {
    private final Provider<UserSecurityQuestionStateEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideUserSecurityQuestionStateRepositoryFactory(ApplicationModule applicationModule, Provider<UserSecurityQuestionStateEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideUserSecurityQuestionStateRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<UserSecurityQuestionStateEntityRepository> provider) {
        return new ApplicationModule_ProvideUserSecurityQuestionStateRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserSecurityQuestionStateRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
