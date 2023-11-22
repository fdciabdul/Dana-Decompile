package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.mybills.repository.MyBillsEntityRepository;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMyBillsRepositoryFactory implements Factory<MyBillsRepository> {
    private final Provider<MyBillsEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideMyBillsRepositoryFactory(ApplicationModule applicationModule, Provider<MyBillsEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideMyBillsRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<MyBillsEntityRepository> provider) {
        return new ApplicationModule_ProvideMyBillsRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyBillsRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
