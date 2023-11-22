package id.dana.data.home.repository.source.presistence;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceHomeWidgetEntityData_Factory implements Factory<PersistenceHomeWidgetEntityData> {
    private final Provider<BasePersistenceDao> MyBillsEntityDataFactory;

    private PersistenceHomeWidgetEntityData_Factory(Provider<BasePersistenceDao> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static PersistenceHomeWidgetEntityData_Factory PlaceComponentResult(Provider<BasePersistenceDao> provider) {
        return new PersistenceHomeWidgetEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PersistenceHomeWidgetEntityData(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
