package id.dana.feeds.domain.detail.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AddActivityComment_Factory implements Factory<AddActivityComment> {
    private final Provider<FeedsDetailRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MixpanelRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AddActivityComment(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
