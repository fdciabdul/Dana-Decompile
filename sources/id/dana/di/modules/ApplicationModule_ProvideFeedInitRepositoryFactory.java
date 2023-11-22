package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.activation.FeedInitEntityRepository;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFeedInitRepositoryFactory implements Factory<FeedInitRepository> {
    private final Provider<FeedInitEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideFeedInitRepositoryFactory(ApplicationModule applicationModule, Provider<FeedInitEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideFeedInitRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<FeedInitEntityRepository> provider) {
        return new ApplicationModule_ProvideFeedInitRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedInitRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
