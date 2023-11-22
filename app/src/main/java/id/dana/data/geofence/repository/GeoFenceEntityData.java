package id.dana.data.geofence.repository;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.geofence.model.PoiNotificationInfo;
import id.dana.data.geofence.repository.source.network.result.PoiFetchResult;
import id.dana.data.geofence.repository.source.persistence.entity.RecentPoiEntity;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0007J#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH&¢\u0006\u0004\b\u0013\u0010\u0010J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bH&¢\u0006\u0004\b\u0017\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/geofence/repository/GeoFenceEntityData;", "", "", "name", "Lio/reactivex/Observable;", "Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;", "getListPoi", "(Ljava/lang/String;)Lio/reactivex/Observable;", "poiId", "", "hasNotifiedToday", "", "Lid/dana/data/geofence/model/PoiNotificationInfo;", "poiNotificationInfos", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "notifyPois", "(Ljava/util/List;)Lio/reactivex/Observable;", "poiIds", "", "saveLastPoiNotificationDate", "Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;", "pois", "", "saveListPoi"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GeoFenceEntityData {
    Observable<PoiFetchResult> getListPoi(String name);

    Observable<Boolean> hasNotifiedToday(String poiId);

    Observable<BaseRpcResult> notifyPois(List<PoiNotificationInfo> poiNotificationInfos);

    Observable<Integer> saveLastPoiNotificationDate(List<String> poiIds);

    Observable<long[]> saveListPoi(List<RecentPoiEntity> pois);
}
