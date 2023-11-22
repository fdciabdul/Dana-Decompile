package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.card.repository.CardEntityRepository;
import id.dana.domain.card.repository.CardRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideCardRepositoryFactory implements Factory<CardRepository> {
    private final Provider<CardEntityRepository> PlaceComponentResult;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideCardRepositoryFactory(ApplicationModule applicationModule, Provider<CardEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideCardRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<CardEntityRepository> provider) {
        return new ApplicationModule_ProvideCardRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CardRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
