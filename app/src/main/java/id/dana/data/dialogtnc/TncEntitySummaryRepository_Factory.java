package id.dana.data.dialogtnc;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TncEntitySummaryRepository_Factory implements Factory<TncEntitySummaryRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;

    public TncEntitySummaryRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.configEntityDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final TncEntitySummaryRepository get() {
        return newInstance(this.configEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static TncEntitySummaryRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new TncEntitySummaryRepository_Factory(provider, provider2);
    }

    public static TncEntitySummaryRepository newInstance(ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new TncEntitySummaryRepository(configEntityDataFactory, holdLoginV1EntityRepository);
    }
}
