package id.dana.feeds.data.timeline.source.persistence;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import id.dana.feeds.data.mapper.ActivityItemEntityMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceFeedsTimelineEntityData_Factory implements Factory<PersistenceFeedsTimelineEntityData> {
    private final Provider<ActivityItemEntityMapper> PlaceComponentResult;
    private final Provider<BasePersistenceDao> getAuthRequestContext;

    private PersistenceFeedsTimelineEntityData_Factory(Provider<BasePersistenceDao> provider, Provider<ActivityItemEntityMapper> provider2) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static PersistenceFeedsTimelineEntityData_Factory MyBillsEntityDataFactory(Provider<BasePersistenceDao> provider, Provider<ActivityItemEntityMapper> provider2) {
        return new PersistenceFeedsTimelineEntityData_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PersistenceFeedsTimelineEntityData(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
