package id.dana.data.wallet_v3.repository.source.persistence;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.wallet_v3.mapper.KtpInfoResultMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceWalletV3EntityData_Factory implements Factory<PersistenceWalletV3EntityData> {
    private final Provider<KtpInfoResultMapper> ktpInfoResultMapperProvider;
    private final Provider<BasePersistenceDao> persistenceDaoProvider;

    public PersistenceWalletV3EntityData_Factory(Provider<BasePersistenceDao> provider, Provider<KtpInfoResultMapper> provider2) {
        this.persistenceDaoProvider = provider;
        this.ktpInfoResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PersistenceWalletV3EntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.persistenceDaoProvider), DoubleCheck.MyBillsEntityDataFactory(this.ktpInfoResultMapperProvider));
    }

    public static PersistenceWalletV3EntityData_Factory create(Provider<BasePersistenceDao> provider, Provider<KtpInfoResultMapper> provider2) {
        return new PersistenceWalletV3EntityData_Factory(provider, provider2);
    }

    public static PersistenceWalletV3EntityData newInstance(Lazy<BasePersistenceDao> lazy, Lazy<KtpInfoResultMapper> lazy2) {
        return new PersistenceWalletV3EntityData(lazy, lazy2);
    }
}
