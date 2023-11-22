package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.payasset.PayAssetEntityRepository;
import id.dana.domain.payasset.repository.PayAssetRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePayAssetRepositoryFactory implements Factory<PayAssetRepository> {
    private final Provider<PayAssetEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvidePayAssetRepositoryFactory(ApplicationModule applicationModule, Provider<PayAssetEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvidePayAssetRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<PayAssetEntityRepository> provider) {
        return new ApplicationModule_ProvidePayAssetRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayAssetRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
