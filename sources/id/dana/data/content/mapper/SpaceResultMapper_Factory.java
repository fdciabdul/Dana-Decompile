package id.dana.data.content.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SpaceResultMapper_Factory implements Factory<SpaceResultMapper> {
    private final Provider<ContentEntityMapper> contentEntityMapperProvider;

    public SpaceResultMapper_Factory(Provider<ContentEntityMapper> provider) {
        this.contentEntityMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SpaceResultMapper get() {
        SpaceResultMapper newInstance = newInstance();
        SpaceResultMapper_MembersInjector.injectContentEntityMapper(newInstance, this.contentEntityMapperProvider.get());
        return newInstance;
    }

    public static SpaceResultMapper_Factory create(Provider<ContentEntityMapper> provider) {
        return new SpaceResultMapper_Factory(provider);
    }

    public static SpaceResultMapper newInstance() {
        return new SpaceResultMapper();
    }
}
