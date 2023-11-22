package id.dana.data.content.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContentsMapper_Factory implements Factory<ContentsMapper> {
    private final Provider<ContentEntityMapper> contentEntityMapperProvider;

    public ContentsMapper_Factory(Provider<ContentEntityMapper> provider) {
        this.contentEntityMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ContentsMapper get() {
        ContentsMapper newInstance = newInstance();
        ContentsMapper_MembersInjector.injectContentEntityMapper(newInstance, this.contentEntityMapperProvider.get());
        return newInstance;
    }

    public static ContentsMapper_Factory create(Provider<ContentEntityMapper> provider) {
        return new ContentsMapper_Factory(provider);
    }

    public static ContentsMapper newInstance() {
        return new ContentsMapper();
    }
}
