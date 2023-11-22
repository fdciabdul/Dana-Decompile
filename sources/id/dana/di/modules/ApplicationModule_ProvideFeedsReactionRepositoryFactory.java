package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.reaction.FeedsReactionEntityRepository;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFeedsReactionRepositoryFactory implements Factory<FeedsReactionRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsReactionEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideFeedsReactionRepositoryFactory(ApplicationModule applicationModule, Provider<FeedsReactionEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideFeedsReactionRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<FeedsReactionEntityRepository> provider) {
        return new ApplicationModule_ProvideFeedsReactionRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsReactionRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
