package id.dana.data.splitbill.repository.source.persistence;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.splitbill.mapper.SplitBillHistoriesResultMapper;
import id.dana.data.splitbill.mapper.SplitBillHistoryEntityToSplitBillDetailResult;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceSplitBillEntityData_Factory implements Factory<PersistenceSplitBillEntityData> {
    private final Provider<BasePersistenceDao> persistenceDaoProvider;
    private final Provider<SplitBillHistoryEntityToSplitBillDetailResult> splitBillDetailResultMapperProvider;
    private final Provider<SplitBillHistoriesResultMapper> splitBillHistoriesResultMapperProvider;

    public PersistenceSplitBillEntityData_Factory(Provider<BasePersistenceDao> provider, Provider<SplitBillHistoriesResultMapper> provider2, Provider<SplitBillHistoryEntityToSplitBillDetailResult> provider3) {
        this.persistenceDaoProvider = provider;
        this.splitBillHistoriesResultMapperProvider = provider2;
        this.splitBillDetailResultMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final PersistenceSplitBillEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.persistenceDaoProvider), this.splitBillHistoriesResultMapperProvider.get(), this.splitBillDetailResultMapperProvider.get());
    }

    public static PersistenceSplitBillEntityData_Factory create(Provider<BasePersistenceDao> provider, Provider<SplitBillHistoriesResultMapper> provider2, Provider<SplitBillHistoryEntityToSplitBillDetailResult> provider3) {
        return new PersistenceSplitBillEntityData_Factory(provider, provider2, provider3);
    }

    public static PersistenceSplitBillEntityData newInstance(Lazy<BasePersistenceDao> lazy, SplitBillHistoriesResultMapper splitBillHistoriesResultMapper, SplitBillHistoryEntityToSplitBillDetailResult splitBillHistoryEntityToSplitBillDetailResult) {
        return new PersistenceSplitBillEntityData(lazy, splitBillHistoriesResultMapper, splitBillHistoryEntityToSplitBillDetailResult);
    }
}
