package id.dana.data.content.mapper;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SpaceResultMapper_MembersInjector implements MembersInjector<SpaceResultMapper> {
    private final Provider<ContentEntityMapper> contentEntityMapperProvider;

    public SpaceResultMapper_MembersInjector(Provider<ContentEntityMapper> provider) {
        this.contentEntityMapperProvider = provider;
    }

    public static MembersInjector<SpaceResultMapper> create(Provider<ContentEntityMapper> provider) {
        return new SpaceResultMapper_MembersInjector(provider);
    }

    public final void injectMembers(SpaceResultMapper spaceResultMapper) {
        injectContentEntityMapper(spaceResultMapper, this.contentEntityMapperProvider.get());
    }

    public static void injectContentEntityMapper(SpaceResultMapper spaceResultMapper, ContentEntityMapper contentEntityMapper) {
        spaceResultMapper.contentEntityMapper = contentEntityMapper;
    }
}
