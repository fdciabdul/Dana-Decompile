package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.auth.face.repository.FaceAuthenticationEntityRepository;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFaceAuthenticationRepositoryFactory implements Factory<FaceAuthenticationRepository> {
    private final Provider<FaceAuthenticationEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideFaceAuthenticationRepositoryFactory(ApplicationModule applicationModule, Provider<FaceAuthenticationEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideFaceAuthenticationRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<FaceAuthenticationEntityRepository> provider) {
        return new ApplicationModule_ProvideFaceAuthenticationRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FaceAuthenticationRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
