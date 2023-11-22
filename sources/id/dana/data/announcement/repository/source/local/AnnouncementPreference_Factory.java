package id.dana.data.announcement.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AnnouncementPreference_Factory implements Factory<AnnouncementPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public AnnouncementPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final AnnouncementPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static AnnouncementPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new AnnouncementPreference_Factory(provider, provider2);
    }

    public static AnnouncementPreference newInstance(Context context, Serializer serializer) {
        return new AnnouncementPreference(context, serializer);
    }
}
