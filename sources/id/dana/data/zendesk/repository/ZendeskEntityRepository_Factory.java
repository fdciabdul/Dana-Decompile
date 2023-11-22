package id.dana.data.zendesk.repository;

import dagger.internal.Factory;
import id.dana.data.zendesk.repository.source.ZendeskEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ZendeskEntityRepository_Factory implements Factory<ZendeskEntityRepository> {
    private final Provider<ZendeskEntityDataFactory> zendeskEntityDataFactoryProvider;

    public ZendeskEntityRepository_Factory(Provider<ZendeskEntityDataFactory> provider) {
        this.zendeskEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ZendeskEntityRepository get() {
        return newInstance(this.zendeskEntityDataFactoryProvider.get());
    }

    public static ZendeskEntityRepository_Factory create(Provider<ZendeskEntityDataFactory> provider) {
        return new ZendeskEntityRepository_Factory(provider);
    }

    public static ZendeskEntityRepository newInstance(ZendeskEntityDataFactory zendeskEntityDataFactory) {
        return new ZendeskEntityRepository(zendeskEntityDataFactory);
    }
}
