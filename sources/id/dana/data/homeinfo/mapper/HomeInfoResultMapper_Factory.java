package id.dana.data.homeinfo.mapper;

import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomeInfoResultMapper_Factory implements Factory<HomeInfoResultMapper> {
    private final Provider<Serializer> serializerProvider;

    public HomeInfoResultMapper_Factory(Provider<Serializer> provider) {
        this.serializerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HomeInfoResultMapper get() {
        return newInstance(this.serializerProvider.get());
    }

    public static HomeInfoResultMapper_Factory create(Provider<Serializer> provider) {
        return new HomeInfoResultMapper_Factory(provider);
    }

    public static HomeInfoResultMapper newInstance(Serializer serializer) {
        return new HomeInfoResultMapper(serializer);
    }
}
