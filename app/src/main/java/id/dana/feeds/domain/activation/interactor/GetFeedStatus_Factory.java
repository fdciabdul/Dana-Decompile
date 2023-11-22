package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetFeedStatus_Factory implements Factory<GetFeedStatus> {
    private final Provider<FeedInitRepository> MyBillsEntityDataFactory;

    private GetFeedStatus_Factory(Provider<FeedInitRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetFeedStatus_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedInitRepository> provider) {
        return new GetFeedStatus_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetFeedStatus(this.MyBillsEntityDataFactory.get());
    }
}
