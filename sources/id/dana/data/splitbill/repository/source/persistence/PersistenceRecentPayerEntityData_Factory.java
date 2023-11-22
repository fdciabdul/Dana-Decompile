package id.dana.data.splitbill.repository.source.persistence;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceRecentPayerEntityData_Factory implements Factory<PersistenceRecentPayerEntityData> {
    private final Provider<BasePersistenceDao> persistenceDaoProvider;

    public PersistenceRecentPayerEntityData_Factory(Provider<BasePersistenceDao> provider) {
        this.persistenceDaoProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PersistenceRecentPayerEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.persistenceDaoProvider));
    }

    public static PersistenceRecentPayerEntityData_Factory create(Provider<BasePersistenceDao> provider) {
        return new PersistenceRecentPayerEntityData_Factory(provider);
    }

    public static PersistenceRecentPayerEntityData newInstance(Lazy<BasePersistenceDao> lazy) {
        return new PersistenceRecentPayerEntityData(lazy);
    }
}
