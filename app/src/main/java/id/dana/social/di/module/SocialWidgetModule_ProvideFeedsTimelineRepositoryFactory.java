package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.timeline.FeedsTimelineEntityRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SocialWidgetModule_ProvideFeedsTimelineRepositoryFactory implements Factory<FeedsTimelineRepository> {
    private final Provider<FeedsTimelineEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final SocialWidgetModule getAuthRequestContext;

    private SocialWidgetModule_ProvideFeedsTimelineRepositoryFactory(SocialWidgetModule socialWidgetModule, Provider<FeedsTimelineEntityRepository> provider) {
        this.getAuthRequestContext = socialWidgetModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SocialWidgetModule_ProvideFeedsTimelineRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(SocialWidgetModule socialWidgetModule, Provider<FeedsTimelineEntityRepository> provider) {
        return new SocialWidgetModule_ProvideFeedsTimelineRepositoryFactory(socialWidgetModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsTimelineRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
