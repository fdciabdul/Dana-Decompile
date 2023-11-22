package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.promocode.repository.PromoCodeEntityRepository;
import id.dana.domain.promocode.repository.PromoCodeRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePromoCodeRepositoryFactory implements Factory<PromoCodeRepository> {
    private final Provider<PromoCodeEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvidePromoCodeRepositoryFactory(ApplicationModule applicationModule, Provider<PromoCodeEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvidePromoCodeRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<PromoCodeEntityRepository> provider) {
        return new ApplicationModule_ProvidePromoCodeRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoCodeRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
