package id.dana.feeds.domain.config.interactor;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetFeedConfig_Factory implements Factory<GetFeedConfig> {
    private final Provider<FeedsConfigRepository> PlaceComponentResult;

    private GetFeedConfig_Factory(Provider<FeedsConfigRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetFeedConfig_Factory MyBillsEntityDataFactory(Provider<FeedsConfigRepository> provider) {
        return new GetFeedConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetFeedConfig(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
