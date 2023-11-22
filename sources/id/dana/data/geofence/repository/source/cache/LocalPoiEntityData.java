package id.dana.data.geofence.repository.source.cache;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.geofence.mapper.PoiResultMapperKt;
import id.dana.data.geofence.model.PoiNotificationInfo;
import id.dana.data.geofence.repository.GeoFenceEntityData;
import id.dana.data.geofence.repository.source.network.result.PoiFetchResult;
import id.dana.data.geofence.repository.source.persistence.TimeHelperKt;
import id.dana.data.geofence.repository.source.persistence.entity.RecentPoiEntity;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\bJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0011"}, d2 = {"Lid/dana/data/geofence/repository/source/cache/LocalPoiEntityData;", "Lid/dana/data/base/BasePersistence;", "Lid/dana/data/geofence/repository/GeoFenceEntityData;", "", "name", "Lio/reactivex/Observable;", "Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;", "getListPoi", "(Ljava/lang/String;)Lio/reactivex/Observable;", "poiId", "", "hasNotifiedToday", "", "Lid/dana/data/geofence/model/PoiNotificationInfo;", "poiNotificationInfos", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "notifyPois", "(Ljava/util/List;)Lio/reactivex/Observable;", "poiIds", "", "saveLastPoiNotificationDate", "Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;", "pois", "", "saveListPoi", "Ldagger/Lazy;", "Lid/dana/data/base/BasePersistenceDao;", "persistenceDao", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalPoiEntityData extends BasePersistence implements GeoFenceEntityData {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LocalPoiEntityData(Lazy<BasePersistenceDao> lazy) {
        super(lazy);
        Intrinsics.checkNotNullParameter(lazy, "");
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<BaseRpcResult> notifyPois(List<PoiNotificationInfo> poiNotificationInfos) {
        Intrinsics.checkNotNullParameter(poiNotificationInfos, "");
        Observable<BaseRpcResult> just = Observable.just(new BaseRpcResult());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<long[]> saveListPoi(List<RecentPoiEntity> pois) {
        Intrinsics.checkNotNullParameter(pois, "");
        Observable<long[]> just = Observable.just(getDb().geofenceDao().insertPois(pois));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<PoiFetchResult> getListPoi(String name) {
        Intrinsics.checkNotNullParameter(name, "");
        Observable<PoiFetchResult> map = Observable.just(getDb().geofenceDao().getAllPois()).map(new Function() { // from class: id.dana.data.geofence.repository.source.cache.LocalPoiEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PoiFetchResult m1322getListPoi$lambda0;
                m1322getListPoi$lambda0 = LocalPoiEntityData.m1322getListPoi$lambda0((List) obj);
                return m1322getListPoi$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getListPoi$lambda-0  reason: not valid java name */
    public static final PoiFetchResult m1322getListPoi$lambda0(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return new PoiFetchResult(PoiResultMapperKt.toPoiInfoEntity(list));
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<Integer> saveLastPoiNotificationDate(List<String> poiIds) {
        Intrinsics.checkNotNullParameter(poiIds, "");
        Observable<Integer> just = Observable.just(Integer.valueOf(getDb().geofenceDao().updateLastNotification(poiIds, TimeHelperKt.getTime())));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.geofence.repository.GeoFenceEntityData
    public final Observable<Boolean> hasNotifiedToday(String poiId) {
        Intrinsics.checkNotNullParameter(poiId, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(!getDb().geofenceDao().hasNotifiedToday(poiId, TimeHelperKt.getTime()).isEmpty()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
