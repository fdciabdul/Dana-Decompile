package id.dana.data.content.mapper;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ContentMapper_MembersInjector implements MembersInjector<ContentMapper> {
    private final Provider<ContentEntityMapper> contentEntityMapperProvider;

    public ContentMapper_MembersInjector(Provider<ContentEntityMapper> provider) {
        this.contentEntityMapperProvider = provider;
    }

    public static MembersInjector<ContentMapper> create(Provider<ContentEntityMapper> provider) {
        return new ContentMapper_MembersInjector(provider);
    }

    public final void injectMembers(ContentMapper contentMapper) {
        injectContentEntityMapper(contentMapper, this.contentEntityMapperProvider.get());
    }

    public static void injectContentEntityMapper(ContentMapper contentMapper, ContentEntityMapper contentEntityMapper) {
        contentMapper.contentEntityMapper = contentEntityMapper;
    }
}
