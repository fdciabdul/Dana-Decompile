package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cardbinding.data.repository.CardBindingEntityRepository;
import id.dana.cardbinding.domain.CardBindingRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideNewCardBindingRepositoryFactory implements Factory<CardBindingRepository> {
    private final Provider<CardBindingEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideNewCardBindingRepositoryFactory(ApplicationModule applicationModule, Provider<CardBindingEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideNewCardBindingRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<CardBindingEntityRepository> provider) {
        return new ApplicationModule_ProvideNewCardBindingRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CardBindingRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
