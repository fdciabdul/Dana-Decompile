package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideQrBarcodeRepositoryFactory implements Factory<QrBarcodeRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<QrBarcodeEntityRepository> MyBillsEntityDataFactory;

    private ApplicationModule_ProvideQrBarcodeRepositoryFactory(ApplicationModule applicationModule, Provider<QrBarcodeEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideQrBarcodeRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<QrBarcodeEntityRepository> provider) {
        return new ApplicationModule_ProvideQrBarcodeRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (QrBarcodeRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
