package id.dana.data.tracker.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MixpanelPreferences_Factory implements Factory<MixpanelPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public MixpanelPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MixpanelPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static MixpanelPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new MixpanelPreferences_Factory(provider, provider2);
    }

    public static MixpanelPreferences newInstance(Context context, Serializer serializer) {
        return new MixpanelPreferences(context, serializer);
    }
}
