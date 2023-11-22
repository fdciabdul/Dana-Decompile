package id.dana.data.announcement.repository.source;

import dagger.internal.Factory;
import id.dana.data.announcement.repository.source.local.LocalAnnouncementEntityData;
import id.dana.data.announcement.repository.source.mock.MockAnnouncementEntityData;
import id.dana.data.announcement.repository.source.network.NetworkAnnouncementEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AnnouncementEntityDataFactory_Factory implements Factory<AnnouncementEntityDataFactory> {
    private final Provider<LocalAnnouncementEntityData> localAnnouncementEntityDataProvider;
    private final Provider<MockAnnouncementEntityData> mockAnnouncementEntityDataProvider;
    private final Provider<NetworkAnnouncementEntityData> networkAnnouncementEntityDataProvider;

    public AnnouncementEntityDataFactory_Factory(Provider<NetworkAnnouncementEntityData> provider, Provider<MockAnnouncementEntityData> provider2, Provider<LocalAnnouncementEntityData> provider3) {
        this.networkAnnouncementEntityDataProvider = provider;
        this.mockAnnouncementEntityDataProvider = provider2;
        this.localAnnouncementEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final AnnouncementEntityDataFactory get() {
        return newInstance(this.networkAnnouncementEntityDataProvider.get(), this.mockAnnouncementEntityDataProvider.get(), this.localAnnouncementEntityDataProvider.get());
    }

    public static AnnouncementEntityDataFactory_Factory create(Provider<NetworkAnnouncementEntityData> provider, Provider<MockAnnouncementEntityData> provider2, Provider<LocalAnnouncementEntityData> provider3) {
        return new AnnouncementEntityDataFactory_Factory(provider, provider2, provider3);
    }

    public static AnnouncementEntityDataFactory newInstance(NetworkAnnouncementEntityData networkAnnouncementEntityData, MockAnnouncementEntityData mockAnnouncementEntityData, LocalAnnouncementEntityData localAnnouncementEntityData) {
        return new AnnouncementEntityDataFactory(networkAnnouncementEntityData, mockAnnouncementEntityData, localAnnouncementEntityData);
    }
}
