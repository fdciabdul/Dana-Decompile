package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.qrpay.QrPayEntityRepository;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideQrPayRepositoryFactory implements Factory<QrPayRepository> {
    private final Provider<QrPayEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideQrPayRepositoryFactory(ApplicationModule applicationModule, Provider<QrPayEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideQrPayRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<QrPayEntityRepository> provider) {
        return new ApplicationModule_ProvideQrPayRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (QrPayRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
