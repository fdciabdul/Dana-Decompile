package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.home.repository.HomeWidgetEntityRepository;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideHomeWidgetRepositoryFactory implements Factory<HomeWidgetRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<HomeWidgetEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideHomeWidgetRepositoryFactory(ApplicationModule applicationModule, Provider<HomeWidgetEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideHomeWidgetRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<HomeWidgetEntityRepository> provider) {
        return new ApplicationModule_ProvideHomeWidgetRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeWidgetRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
