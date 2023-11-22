package id.dana.data.announcement.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalAnnouncementEntityData_Factory implements Factory<LocalAnnouncementEntityData> {
    private final Provider<AnnouncementPreference> announcementPreferenceProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public LocalAnnouncementEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<AnnouncementPreference> provider3) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
        this.announcementPreferenceProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final LocalAnnouncementEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get(), this.announcementPreferenceProvider.get());
    }

    public static LocalAnnouncementEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2, Provider<AnnouncementPreference> provider3) {
        return new LocalAnnouncementEntityData_Factory(provider, provider2, provider3);
    }

    public static LocalAnnouncementEntityData newInstance(Context context, Serializer serializer, AnnouncementPreference announcementPreference) {
        return new LocalAnnouncementEntityData(context, serializer, announcementPreference);
    }
}
