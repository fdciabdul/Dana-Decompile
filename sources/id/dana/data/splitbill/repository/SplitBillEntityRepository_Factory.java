package id.dana.data.splitbill.repository;

import dagger.internal.Factory;
import id.dana.data.deeplink.repository.source.GenerateLinkEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.splitbill.mapper.SplitBillDetailResultMapper;
import id.dana.data.splitbill.mapper.SplitBillDetailToSplitBillHistoryEntityMapper;
import id.dana.data.splitbill.mapper.SplitBillHistoriesMapper;
import id.dana.data.splitbill.mapper.SplitBillHistoryEntitiesMapper;
import id.dana.data.splitbill.repository.source.SplitBillEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitBillEntityRepository_Factory implements Factory<SplitBillEntityRepository> {
    private final Provider<GenerateLinkEntityDataFactory> generateLinkEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<SplitBillDetailResultMapper> splitBillDetailResultMapperProvider;
    private final Provider<SplitBillDetailToSplitBillHistoryEntityMapper> splitBillDetailToSplitBillHistoryEntityMapperProvider;
    private final Provider<SplitBillEntityDataFactory> splitBillEntityDataFactoryProvider;
    private final Provider<SplitBillHistoriesMapper> splitBillHistoriesMapperProvider;
    private final Provider<SplitBillHistoryEntitiesMapper> splitBillHistoryEntitiesMapperProvider;

    public SplitBillEntityRepository_Factory(Provider<SplitBillEntityDataFactory> provider, Provider<SplitBillHistoriesMapper> provider2, Provider<SplitBillHistoryEntitiesMapper> provider3, Provider<SplitBillDetailResultMapper> provider4, Provider<SplitBillDetailToSplitBillHistoryEntityMapper> provider5, Provider<GenerateLinkEntityDataFactory> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        this.splitBillEntityDataFactoryProvider = provider;
        this.splitBillHistoriesMapperProvider = provider2;
        this.splitBillHistoryEntitiesMapperProvider = provider3;
        this.splitBillDetailResultMapperProvider = provider4;
        this.splitBillDetailToSplitBillHistoryEntityMapperProvider = provider5;
        this.generateLinkEntityDataFactoryProvider = provider6;
        this.holdLoginV1EntityRepositoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final SplitBillEntityRepository get() {
        return newInstance(this.splitBillEntityDataFactoryProvider.get(), this.splitBillHistoriesMapperProvider.get(), this.splitBillHistoryEntitiesMapperProvider.get(), this.splitBillDetailResultMapperProvider.get(), this.splitBillDetailToSplitBillHistoryEntityMapperProvider.get(), this.generateLinkEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static SplitBillEntityRepository_Factory create(Provider<SplitBillEntityDataFactory> provider, Provider<SplitBillHistoriesMapper> provider2, Provider<SplitBillHistoryEntitiesMapper> provider3, Provider<SplitBillDetailResultMapper> provider4, Provider<SplitBillDetailToSplitBillHistoryEntityMapper> provider5, Provider<GenerateLinkEntityDataFactory> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        return new SplitBillEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SplitBillEntityRepository newInstance(SplitBillEntityDataFactory splitBillEntityDataFactory, SplitBillHistoriesMapper splitBillHistoriesMapper, SplitBillHistoryEntitiesMapper splitBillHistoryEntitiesMapper, SplitBillDetailResultMapper splitBillDetailResultMapper, SplitBillDetailToSplitBillHistoryEntityMapper splitBillDetailToSplitBillHistoryEntityMapper, GenerateLinkEntityDataFactory generateLinkEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new SplitBillEntityRepository(splitBillEntityDataFactory, splitBillHistoriesMapper, splitBillHistoryEntitiesMapper, splitBillDetailResultMapper, splitBillDetailToSplitBillHistoryEntityMapper, generateLinkEntityDataFactory, holdLoginV1EntityRepository);
    }
}
