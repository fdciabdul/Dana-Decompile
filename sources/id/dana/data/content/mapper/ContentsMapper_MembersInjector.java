package id.dana.data.content.mapper;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ContentsMapper_MembersInjector implements MembersInjector<ContentsMapper> {
    private final Provider<ContentEntityMapper> contentEntityMapperProvider;

    public ContentsMapper_MembersInjector(Provider<ContentEntityMapper> provider) {
        this.contentEntityMapperProvider = provider;
    }

    public static MembersInjector<ContentsMapper> create(Provider<ContentEntityMapper> provider) {
        return new ContentsMapper_MembersInjector(provider);
    }

    public final void injectMembers(ContentsMapper contentsMapper) {
        injectContentEntityMapper(contentsMapper, this.contentEntityMapperProvider.get());
    }

    public static void injectContentEntityMapper(ContentsMapper contentsMapper, ContentEntityMapper contentEntityMapper) {
        contentsMapper.contentEntityMapper = contentEntityMapper;
    }
}
