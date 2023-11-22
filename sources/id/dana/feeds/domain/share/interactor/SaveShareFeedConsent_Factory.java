package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveShareFeedConsent_Factory implements Factory<SaveShareFeedConsent> {
    private final Provider<FeedsShareRepository> PlaceComponentResult;

    private SaveShareFeedConsent_Factory(Provider<FeedsShareRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SaveShareFeedConsent_Factory MyBillsEntityDataFactory(Provider<FeedsShareRepository> provider) {
        return new SaveShareFeedConsent_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveShareFeedConsent(this.PlaceComponentResult.get());
    }
}
