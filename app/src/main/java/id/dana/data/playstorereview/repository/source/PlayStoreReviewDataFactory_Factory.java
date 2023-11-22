package id.dana.data.playstorereview.repository.source;

import dagger.internal.Factory;
import id.dana.data.playstorereview.repository.source.local.PlayStoreReviewPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PlayStoreReviewDataFactory_Factory implements Factory<PlayStoreReviewDataFactory> {
    private final Provider<PlayStoreReviewPreference> playStoreReviewPreferenceProvider;

    public PlayStoreReviewDataFactory_Factory(Provider<PlayStoreReviewPreference> provider) {
        this.playStoreReviewPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PlayStoreReviewDataFactory get() {
        return newInstance(this.playStoreReviewPreferenceProvider.get());
    }

    public static PlayStoreReviewDataFactory_Factory create(Provider<PlayStoreReviewPreference> provider) {
        return new PlayStoreReviewDataFactory_Factory(provider);
    }

    public static PlayStoreReviewDataFactory newInstance(PlayStoreReviewPreference playStoreReviewPreference) {
        return new PlayStoreReviewDataFactory(playStoreReviewPreference);
    }
}
