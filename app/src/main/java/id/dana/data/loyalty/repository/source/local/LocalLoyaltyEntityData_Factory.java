package id.dana.data.loyalty.repository.source.local;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalLoyaltyEntityData_Factory implements Factory<LocalLoyaltyEntityData> {
    private final Provider<BasePersistenceDao> persistenceDaoProvider;

    public LocalLoyaltyEntityData_Factory(Provider<BasePersistenceDao> provider) {
        this.persistenceDaoProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalLoyaltyEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.persistenceDaoProvider));
    }

    public static LocalLoyaltyEntityData_Factory create(Provider<BasePersistenceDao> provider) {
        return new LocalLoyaltyEntityData_Factory(provider);
    }

    public static LocalLoyaltyEntityData newInstance(Lazy<BasePersistenceDao> lazy) {
        return new LocalLoyaltyEntityData(lazy);
    }
}
