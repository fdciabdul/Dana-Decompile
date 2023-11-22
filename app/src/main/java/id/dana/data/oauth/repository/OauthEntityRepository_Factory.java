package id.dana.data.oauth.repository;

import dagger.internal.Factory;
import id.dana.data.authcode.mapper.AuthMapper;
import id.dana.data.authcode.repository.source.AuthEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.oauth.mapper.OauthConfirmResultMapper;
import id.dana.data.oauth.mapper.OauthInitResultMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OauthEntityRepository_Factory implements Factory<OauthEntityRepository> {
    private final Provider<AuthEntityDataFactory> authEntityDataFactoryProvider;
    private final Provider<AuthMapper> authMapperProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<OauthConfirmResultMapper> oauthConfirmResultMapperProvider;
    private final Provider<OauthInitResultMapper> oauthInitResultMapperProvider;

    public OauthEntityRepository_Factory(Provider<OauthInitResultMapper> provider, Provider<AuthEntityDataFactory> provider2, Provider<OauthConfirmResultMapper> provider3, Provider<AuthMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        this.oauthInitResultMapperProvider = provider;
        this.authEntityDataFactoryProvider = provider2;
        this.oauthConfirmResultMapperProvider = provider3;
        this.authMapperProvider = provider4;
        this.holdLoginV1EntityRepositoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final OauthEntityRepository get() {
        return newInstance(this.oauthInitResultMapperProvider.get(), this.authEntityDataFactoryProvider.get(), this.oauthConfirmResultMapperProvider.get(), this.authMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static OauthEntityRepository_Factory create(Provider<OauthInitResultMapper> provider, Provider<AuthEntityDataFactory> provider2, Provider<OauthConfirmResultMapper> provider3, Provider<AuthMapper> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        return new OauthEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static OauthEntityRepository newInstance(OauthInitResultMapper oauthInitResultMapper, AuthEntityDataFactory authEntityDataFactory, OauthConfirmResultMapper oauthConfirmResultMapper, AuthMapper authMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new OauthEntityRepository(oauthInitResultMapper, authEntityDataFactory, oauthConfirmResultMapper, authMapper, holdLoginV1EntityRepository);
    }
}
