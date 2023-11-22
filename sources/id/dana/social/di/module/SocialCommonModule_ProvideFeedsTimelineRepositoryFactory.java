package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.timeline.FeedsTimelineEntityRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SocialCommonModule_ProvideFeedsTimelineRepositoryFactory implements Factory<FeedsTimelineRepository> {
    private final Provider<FeedsTimelineEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final SocialCommonModule getAuthRequestContext;

    private SocialCommonModule_ProvideFeedsTimelineRepositoryFactory(SocialCommonModule socialCommonModule, Provider<FeedsTimelineEntityRepository> provider) {
        this.getAuthRequestContext = socialCommonModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SocialCommonModule_ProvideFeedsTimelineRepositoryFactory PlaceComponentResult(SocialCommonModule socialCommonModule, Provider<FeedsTimelineEntityRepository> provider) {
        return new SocialCommonModule_ProvideFeedsTimelineRepositoryFactory(socialCommonModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsTimelineRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
