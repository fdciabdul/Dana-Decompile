package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.uploadfiles.UploadFilesEntityRepository;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUploadFilesRepositoryFactory implements Factory<UploadFilesRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<UploadFilesEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideUploadFilesRepositoryFactory(ApplicationModule applicationModule, Provider<UploadFilesEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideUploadFilesRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<UploadFilesEntityRepository> provider) {
        return new ApplicationModule_ProvideUploadFilesRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UploadFilesRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
