package id.dana.feeds.data.activation.source;

import dagger.internal.Factory;
import id.dana.feeds.data.activation.source.local.PreferenceFeedInitEntityData;
import id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedInitEntityDataFactory_Factory implements Factory<FeedInitEntityDataFactory> {
    private final Provider<PreferenceFeedInitEntityData> MyBillsEntityDataFactory;
    private final Provider<NetworkFeedInitEntityData> PlaceComponentResult;

    private FeedInitEntityDataFactory_Factory(Provider<PreferenceFeedInitEntityData> provider, Provider<NetworkFeedInitEntityData> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static FeedInitEntityDataFactory_Factory PlaceComponentResult(Provider<PreferenceFeedInitEntityData> provider, Provider<NetworkFeedInitEntityData> provider2) {
        return new FeedInitEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedInitEntityDataFactory(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
