package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.promoquest.repository.PromoQuestEntityRepository;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePromoQuestRepositoryFactory implements Factory<PromoQuestRepository> {
    private final Provider<PromoQuestEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvidePromoQuestRepositoryFactory(ApplicationModule applicationModule, Provider<PromoQuestEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvidePromoQuestRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<PromoQuestEntityRepository> provider) {
        return new ApplicationModule_ProvidePromoQuestRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoQuestRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
