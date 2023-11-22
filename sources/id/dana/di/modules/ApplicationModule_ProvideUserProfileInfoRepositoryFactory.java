package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.userprofileinfo.UserProfileInfoEntityRepository;
import id.dana.domain.userprofileinfo.UserProfileInfoRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserProfileInfoRepositoryFactory implements Factory<UserProfileInfoRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<UserProfileInfoEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideUserProfileInfoRepositoryFactory(ApplicationModule applicationModule, Provider<UserProfileInfoEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideUserProfileInfoRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<UserProfileInfoEntityRepository> provider) {
        return new ApplicationModule_ProvideUserProfileInfoRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserProfileInfoRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
