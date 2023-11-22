package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.qriscrossborder.QrisCrossBorderEntityRepository;
import id.dana.domain.qriscrossborder.QrisCrossBorderRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideQrisCrossBorderRepositoryFactory implements Factory<QrisCrossBorderRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<QrisCrossBorderEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideQrisCrossBorderRepositoryFactory(ApplicationModule applicationModule, Provider<QrisCrossBorderEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideQrisCrossBorderRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<QrisCrossBorderEntityRepository> provider) {
        return new ApplicationModule_ProvideQrisCrossBorderRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (QrisCrossBorderRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
