package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.electronicmoney.ElectronicmoneyEntityRepository;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideElectronicmoneyRepositoryFactory implements Factory<ElectronicmoneyRepository> {
    private final Provider<ElectronicmoneyEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideElectronicmoneyRepositoryFactory(ApplicationModule applicationModule, Provider<ElectronicmoneyEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideElectronicmoneyRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<ElectronicmoneyEntityRepository> provider) {
        return new ApplicationModule_ProvideElectronicmoneyRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ElectronicmoneyRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
