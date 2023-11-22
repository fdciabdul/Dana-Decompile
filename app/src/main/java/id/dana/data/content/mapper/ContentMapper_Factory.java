package id.dana.data.content.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContentMapper_Factory implements Factory<ContentMapper> {
    private final Provider<ContentEntityMapper> contentEntityMapperProvider;

    public ContentMapper_Factory(Provider<ContentEntityMapper> provider) {
        this.contentEntityMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ContentMapper get() {
        ContentMapper newInstance = newInstance();
        ContentMapper_MembersInjector.injectContentEntityMapper(newInstance, this.contentEntityMapperProvider.get());
        return newInstance;
    }

    public static ContentMapper_Factory create(Provider<ContentEntityMapper> provider) {
        return new ContentMapper_Factory(provider);
    }

    public static ContentMapper newInstance() {
        return new ContentMapper();
    }
}
