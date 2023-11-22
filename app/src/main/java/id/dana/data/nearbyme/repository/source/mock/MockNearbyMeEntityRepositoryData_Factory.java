package id.dana.data.nearbyme.repository.source.mock;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MockNearbyMeEntityRepositoryData_Factory implements Factory<MockNearbyMeEntityRepositoryData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public MockNearbyMeEntityRepositoryData_Factory(Provider<Serializer> provider, Provider<Context> provider2) {
        this.serializerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MockNearbyMeEntityRepositoryData get() {
        return newInstance(this.serializerProvider.get(), this.contextProvider.get());
    }

    public static MockNearbyMeEntityRepositoryData_Factory create(Provider<Serializer> provider, Provider<Context> provider2) {
        return new MockNearbyMeEntityRepositoryData_Factory(provider, provider2);
    }

    public static MockNearbyMeEntityRepositoryData newInstance(Serializer serializer, Context context) {
        return new MockNearbyMeEntityRepositoryData(serializer, context);
    }
}
