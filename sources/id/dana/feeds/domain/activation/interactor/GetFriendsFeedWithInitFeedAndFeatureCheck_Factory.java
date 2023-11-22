package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetFriendsFeedWithInitFeedAndFeatureCheck_Factory implements Factory<GetFriendsFeedWithInitFeedAndFeatureCheck> {
    private final Provider<MixpanelRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsConfigRepository> MyBillsEntityDataFactory;
    private final Provider<FeedInitRepository> PlaceComponentResult;
    private final Provider<FeedsTimelineRepository> getAuthRequestContext;

    private GetFriendsFeedWithInitFeedAndFeatureCheck_Factory(Provider<MixpanelRepository> provider, Provider<FeedsConfigRepository> provider2, Provider<FeedsTimelineRepository> provider3, Provider<FeedInitRepository> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static GetFriendsFeedWithInitFeedAndFeatureCheck_Factory getAuthRequestContext(Provider<MixpanelRepository> provider, Provider<FeedsConfigRepository> provider2, Provider<FeedsTimelineRepository> provider3, Provider<FeedInitRepository> provider4) {
        return new GetFriendsFeedWithInitFeedAndFeatureCheck_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetFriendsFeedWithInitFeedAndFeatureCheck(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
