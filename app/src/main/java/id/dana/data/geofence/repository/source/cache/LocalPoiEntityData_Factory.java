package id.dana.data.geofence.repository.source.cache;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalPoiEntityData_Factory implements Factory<LocalPoiEntityData> {
    private final Provider<BasePersistenceDao> persistenceDaoProvider;

    public LocalPoiEntityData_Factory(Provider<BasePersistenceDao> provider) {
        this.persistenceDaoProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalPoiEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.persistenceDaoProvider));
    }

    public static LocalPoiEntityData_Factory create(Provider<BasePersistenceDao> provider) {
        return new LocalPoiEntityData_Factory(provider);
    }

    public static LocalPoiEntityData newInstance(Lazy<BasePersistenceDao> lazy) {
        return new LocalPoiEntityData(lazy);
    }
}
