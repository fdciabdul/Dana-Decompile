package id.dana.data.synccontact.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncContactPreferences_Factory implements Factory<SyncContactPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public SyncContactPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SyncContactPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static SyncContactPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new SyncContactPreferences_Factory(provider, provider2);
    }

    public static SyncContactPreferences newInstance(Context context, Serializer serializer) {
        return new SyncContactPreferences(context, serializer);
    }
}
