package id.dana.feeds.domain.detail.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetFeedComment_Factory implements Factory<GetFeedComment> {
    private final Provider<MixpanelRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsDetailRepository> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetFeedComment(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
