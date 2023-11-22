package id.dana.data.autoroute.repository.source.mock;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MockAutoRouteEntityData_Factory implements Factory<MockAutoRouteEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public MockAutoRouteEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MockAutoRouteEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static MockAutoRouteEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new MockAutoRouteEntityData_Factory(provider, provider2);
    }

    public static MockAutoRouteEntityData newInstance(Context context, Serializer serializer) {
        return new MockAutoRouteEntityData(context, serializer);
    }
}
