package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.share.FeedsShareEntityRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFeedsShareRepositoryFactory implements Factory<FeedsShareRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsShareEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideFeedsShareRepositoryFactory(ApplicationModule applicationModule, Provider<FeedsShareEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideFeedsShareRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<FeedsShareEntityRepository> provider) {
        return new ApplicationModule_ProvideFeedsShareRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsShareRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
