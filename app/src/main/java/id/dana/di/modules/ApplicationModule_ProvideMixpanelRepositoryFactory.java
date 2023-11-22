package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.tracker.MixpanelEntityRepository;
import id.dana.domain.tracker.MixpanelRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMixpanelRepositoryFactory implements Factory<MixpanelRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<MixpanelEntityRepository> MyBillsEntityDataFactory;

    private ApplicationModule_ProvideMixpanelRepositoryFactory(ApplicationModule applicationModule, Provider<MixpanelEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideMixpanelRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<MixpanelEntityRepository> provider) {
        return new ApplicationModule_ProvideMixpanelRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MixpanelRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
