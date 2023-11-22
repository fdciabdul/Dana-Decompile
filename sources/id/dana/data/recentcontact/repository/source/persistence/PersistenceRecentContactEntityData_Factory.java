package id.dana.data.recentcontact.repository.source.persistence;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceRecentContactEntityData_Factory implements Factory<PersistenceRecentContactEntityData> {
    private final Provider<BasePersistenceDao> persistenceDaoProvider;

    public PersistenceRecentContactEntityData_Factory(Provider<BasePersistenceDao> provider) {
        this.persistenceDaoProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PersistenceRecentContactEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.persistenceDaoProvider));
    }

    public static PersistenceRecentContactEntityData_Factory create(Provider<BasePersistenceDao> provider) {
        return new PersistenceRecentContactEntityData_Factory(provider);
    }

    public static PersistenceRecentContactEntityData newInstance(Lazy<BasePersistenceDao> lazy) {
        return new PersistenceRecentContactEntityData(lazy);
    }
}
