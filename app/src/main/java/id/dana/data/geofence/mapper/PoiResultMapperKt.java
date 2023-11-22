package id.dana.data.geofence.mapper;

import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.UrlParam;
import id.dana.data.geofence.model.PoiInfoEntity;
import id.dana.data.geofence.model.PoiNotificationInfo;
import id.dana.data.geofence.repository.source.network.result.PoiFetchResult;
import id.dana.data.geofence.repository.source.persistence.entity.RecentPoiEntity;
import id.dana.domain.geofence.model.Poi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b*\u00020\n¢\u0006\u0004\b\b\u0010\f\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b*\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b\b\u0010\r\u001a\u0011\u0010\u000f\u001a\u00020\u0006*\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b*\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0004\b\u000f\u0010\r\u001a%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b*\b\u0012\u0004\u0012\u00020\u00000\u000b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0004\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u000e*\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b*\u00020\n¢\u0006\u0004\b\u0014\u0010\f\u001a\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b*\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b\u0014\u0010\r"}, d2 = {"", "poiId", UrlParam.REQUEST_ID, "Lid/dana/data/geofence/model/PoiNotificationInfo;", "toPoiNotificationInfo", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/geofence/model/PoiNotificationInfo;", "Lid/dana/data/geofence/model/PoiInfoEntity;", "Lid/dana/domain/geofence/model/Poi;", "toPoi", "(Lid/dana/data/geofence/model/PoiInfoEntity;)Lid/dana/domain/geofence/model/Poi;", "Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;", "", "(Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;)Ljava/util/List;", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;", "toPoiInfoEntity", "(Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;)Lid/dana/data/geofence/model/PoiInfoEntity;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "(Ljava/util/List;Lid/dana/data/config/DeviceInformationProvider;)Ljava/util/List;", "toRecentPoiEntity", "(Lid/dana/data/geofence/model/PoiInfoEntity;)Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PoiResultMapperKt {
    public static final List<Poi> toPoi(List<PoiInfoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PoiInfoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPoi((PoiInfoEntity) it.next()));
        }
        return arrayList;
    }

    public static final List<RecentPoiEntity> toRecentPoiEntity(List<PoiInfoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PoiInfoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRecentPoiEntity((PoiInfoEntity) it.next()));
        }
        return arrayList;
    }

    public static final List<PoiInfoEntity> toPoiInfoEntity(List<RecentPoiEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RecentPoiEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPoiInfoEntity((RecentPoiEntity) it.next()));
        }
        return arrayList;
    }

    public static final PoiInfoEntity toPoiInfoEntity(RecentPoiEntity recentPoiEntity) {
        Intrinsics.checkNotNullParameter(recentPoiEntity, "");
        return new PoiInfoEntity(recentPoiEntity.getPoiId(), recentPoiEntity.getLongitude(), recentPoiEntity.getLatitude(), recentPoiEntity.getRadius());
    }

    public static final List<Poi> toPoi(PoiFetchResult poiFetchResult) {
        Intrinsics.checkNotNullParameter(poiFetchResult, "");
        return toPoi(poiFetchResult.getPois());
    }

    public static final List<RecentPoiEntity> toRecentPoiEntity(PoiFetchResult poiFetchResult) {
        Intrinsics.checkNotNullParameter(poiFetchResult, "");
        return toRecentPoiEntity(poiFetchResult.getPois());
    }

    public static final Poi toPoi(PoiInfoEntity poiInfoEntity) {
        Intrinsics.checkNotNullParameter(poiInfoEntity, "");
        return new Poi(poiInfoEntity.getPoiId(), poiInfoEntity.getLatitude(), poiInfoEntity.getLongitude(), poiInfoEntity.getRadius());
    }

    public static final RecentPoiEntity toRecentPoiEntity(PoiInfoEntity poiInfoEntity) {
        Intrinsics.checkNotNullParameter(poiInfoEntity, "");
        return new RecentPoiEntity(poiInfoEntity.getPoiId(), poiInfoEntity.getRadius(), poiInfoEntity.getLongitude(), poiInfoEntity.getLatitude(), null, 16, null);
    }

    public static final List<PoiNotificationInfo> toPoiNotificationInfo(List<String> list, DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (String str : list2) {
            String deviceUUID = deviceInformationProvider.getDeviceUUID();
            Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
            arrayList.add(toPoiNotificationInfo(str, deviceUUID));
        }
        return arrayList;
    }

    public static final PoiNotificationInfo toPoiNotificationInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return new PoiNotificationInfo(str, str2);
    }
}
