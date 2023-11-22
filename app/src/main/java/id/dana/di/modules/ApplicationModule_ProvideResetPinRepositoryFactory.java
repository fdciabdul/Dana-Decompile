package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.resetpin.ResetPinRepositoryImpl;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideResetPinRepositoryFactory implements Factory<ResetPinRepository> {
    private final Provider<ResetPinRepositoryImpl> MyBillsEntityDataFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideResetPinRepositoryFactory(ApplicationModule applicationModule, Provider<ResetPinRepositoryImpl> provider) {
        this.getAuthRequestContext = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideResetPinRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<ResetPinRepositoryImpl> provider) {
        return new ApplicationModule_ProvideResetPinRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ResetPinRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
