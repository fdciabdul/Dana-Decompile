package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetFeedsSharingLastCheckedState_Factory implements Factory<GetFeedsSharingLastCheckedState> {
    private final Provider<FeedsShareRepository> PlaceComponentResult;

    private GetFeedsSharingLastCheckedState_Factory(Provider<FeedsShareRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetFeedsSharingLastCheckedState_Factory MyBillsEntityDataFactory(Provider<FeedsShareRepository> provider) {
        return new GetFeedsSharingLastCheckedState_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetFeedsSharingLastCheckedState(this.PlaceComponentResult.get());
    }
}
