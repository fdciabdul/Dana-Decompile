package id.dana.data.recentrecipient.source.persistence;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceRecentRecipientEntityData_Factory implements Factory<PersistenceRecentRecipientEntityData> {
    private final Provider<BasePersistenceDao> basePersistenceDaoProvider;

    public PersistenceRecentRecipientEntityData_Factory(Provider<BasePersistenceDao> provider) {
        this.basePersistenceDaoProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PersistenceRecentRecipientEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.basePersistenceDaoProvider));
    }

    public static PersistenceRecentRecipientEntityData_Factory create(Provider<BasePersistenceDao> provider) {
        return new PersistenceRecentRecipientEntityData_Factory(provider);
    }

    public static PersistenceRecentRecipientEntityData newInstance(Lazy<BasePersistenceDao> lazy) {
        return new PersistenceRecentRecipientEntityData(lazy);
    }
}
