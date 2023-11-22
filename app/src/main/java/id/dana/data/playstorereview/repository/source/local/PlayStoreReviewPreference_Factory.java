package id.dana.data.playstorereview.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PlayStoreReviewPreference_Factory implements Factory<PlayStoreReviewPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public PlayStoreReviewPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PlayStoreReviewPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static PlayStoreReviewPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PlayStoreReviewPreference_Factory(provider, provider2);
    }

    public static PlayStoreReviewPreference newInstance(Context context, Serializer serializer) {
        return new PlayStoreReviewPreference(context, serializer);
    }
}
