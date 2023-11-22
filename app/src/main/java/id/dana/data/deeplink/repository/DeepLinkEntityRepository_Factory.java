package id.dana.data.deeplink.repository;

import dagger.internal.Factory;
import id.dana.data.authcode.repository.source.AuthEntityDataFactory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import id.dana.data.deeplink.mapper.DeepLinkPayloadEntityMapper;
import id.dana.data.deeplink.repository.source.DeepLinkEntityDataFactory;
import id.dana.data.deeplink.repository.source.LinkApiEntityDataFactory;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DeepLinkEntityRepository_Factory implements Factory<DeepLinkEntityRepository> {
    private final Provider<AuthEntityDataFactory> authEntityDataFactoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<DeepLinkEntityDataFactory> deepLinkEntityDataFactoryProvider;
    private final Provider<DeepLinkPayloadManager> deepLinkPayloadManagerProvider;
    private final Provider<DeepLinkPayloadEntityMapper> deepLinkPayloadMapperProvider;
    private final Provider<LinkApiEntityDataFactory> linkApiEntityDataFactoryProvider;
    private final Provider<ServicesRepository> servicesRepositoryProvider;

    public DeepLinkEntityRepository_Factory(Provider<DeepLinkEntityDataFactory> provider, Provider<LinkApiEntityDataFactory> provider2, Provider<DeepLinkPayloadEntityMapper> provider3, Provider<DeepLinkPayloadManager> provider4, Provider<AuthEntityDataFactory> provider5, Provider<ConfigEntityDataFactory> provider6, Provider<ServicesRepository> provider7) {
        this.deepLinkEntityDataFactoryProvider = provider;
        this.linkApiEntityDataFactoryProvider = provider2;
        this.deepLinkPayloadMapperProvider = provider3;
        this.deepLinkPayloadManagerProvider = provider4;
        this.authEntityDataFactoryProvider = provider5;
        this.configEntityDataFactoryProvider = provider6;
        this.servicesRepositoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final DeepLinkEntityRepository get() {
        return newInstance(this.deepLinkEntityDataFactoryProvider.get(), this.linkApiEntityDataFactoryProvider.get(), this.deepLinkPayloadMapperProvider.get(), this.deepLinkPayloadManagerProvider.get(), this.authEntityDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get(), this.servicesRepositoryProvider.get());
    }

    public static DeepLinkEntityRepository_Factory create(Provider<DeepLinkEntityDataFactory> provider, Provider<LinkApiEntityDataFactory> provider2, Provider<DeepLinkPayloadEntityMapper> provider3, Provider<DeepLinkPayloadManager> provider4, Provider<AuthEntityDataFactory> provider5, Provider<ConfigEntityDataFactory> provider6, Provider<ServicesRepository> provider7) {
        return new DeepLinkEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DeepLinkEntityRepository newInstance(DeepLinkEntityDataFactory deepLinkEntityDataFactory, LinkApiEntityDataFactory linkApiEntityDataFactory, DeepLinkPayloadEntityMapper deepLinkPayloadEntityMapper, DeepLinkPayloadManager deepLinkPayloadManager, AuthEntityDataFactory authEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, ServicesRepository servicesRepository) {
        return new DeepLinkEntityRepository(deepLinkEntityDataFactory, linkApiEntityDataFactory, deepLinkPayloadEntityMapper, deepLinkPayloadManager, authEntityDataFactory, configEntityDataFactory, servicesRepository);
    }
}
