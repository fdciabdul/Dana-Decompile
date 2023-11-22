package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideOcrConfigRepositoryFactory implements Factory<OcrConfigRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<DefaultOcrConfigRepository> getAuthRequestContext;

    private ApplicationModule_ProvideOcrConfigRepositoryFactory(ApplicationModule applicationModule, Provider<DefaultOcrConfigRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideOcrConfigRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<DefaultOcrConfigRepository> provider) {
        return new ApplicationModule_ProvideOcrConfigRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OcrConfigRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
