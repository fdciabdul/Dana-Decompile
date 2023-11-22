package id.dana.data.geofence.repository.source.persistence.dao;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.data.geofence.repository.source.persistence.entity.RecentPoiEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/geofence/repository/source/persistence/dao/GeofenceDao;", "", "", "Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;", "getAllPois", "()Ljava/util/List;", "", "poiId", "", "now", "hasNotifiedToday", "(Ljava/lang/String;J)Ljava/util/List;", "poiEntities", "", "insertPois", "(Ljava/util/List;)[J", "poiIds", MaintenanceBroadcastResult.KEY_DATE, "", "updateLastNotification", "(Ljava/util/List;J)I"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GeofenceDao {
    List<RecentPoiEntity> getAllPois();

    List<RecentPoiEntity> hasNotifiedToday(String poiId, long now);

    long[] insertPois(List<RecentPoiEntity> poiEntities);

    int updateLastNotification(List<String> poiIds, long date);
}
