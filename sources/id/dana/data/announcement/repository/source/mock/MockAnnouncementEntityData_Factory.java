package id.dana.data.announcement.repository.source.mock;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MockAnnouncementEntityData_Factory implements Factory<MockAnnouncementEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public MockAnnouncementEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MockAnnouncementEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static MockAnnouncementEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new MockAnnouncementEntityData_Factory(provider, provider2);
    }

    public static MockAnnouncementEntityData newInstance(Context context, Serializer serializer) {
        return new MockAnnouncementEntityData(context, serializer);
    }
}
