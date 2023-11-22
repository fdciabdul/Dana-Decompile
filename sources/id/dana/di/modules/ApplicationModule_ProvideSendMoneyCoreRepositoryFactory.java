package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository;
import id.dana.sendmoney.domain.core.SendMoneyCoreRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSendMoneyCoreRepositoryFactory implements Factory<SendMoneyCoreRepository> {
    private final Provider<SendMoneyCoreEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideSendMoneyCoreRepositoryFactory(ApplicationModule applicationModule, Provider<SendMoneyCoreEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideSendMoneyCoreRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<SendMoneyCoreEntityRepository> provider) {
        return new ApplicationModule_ProvideSendMoneyCoreRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyCoreRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
