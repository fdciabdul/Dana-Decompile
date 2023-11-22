package id.dana.feeds.data.storage.persistence;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceRelationshipEntityData_Factory implements Factory<PersistenceRelationshipEntityData> {
    private final Provider<BasePersistenceDao> KClassImpl$Data$declaredNonStaticMembers$2;

    private PersistenceRelationshipEntityData_Factory(Provider<BasePersistenceDao> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static PersistenceRelationshipEntityData_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<BasePersistenceDao> provider) {
        return new PersistenceRelationshipEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PersistenceRelationshipEntityData(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
