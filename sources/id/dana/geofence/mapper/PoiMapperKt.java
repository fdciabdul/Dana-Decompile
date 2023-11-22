package id.dana.geofence.mapper;

import com.google.android.gms.location.Geofence;
import id.dana.domain.geofence.model.Poi;
import id.dana.geofence.GeofenceConstant;
import id.dana.geofence.model.PoiModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00050\u0000¢\u0006\u0004\b\u0006\u0010\u0004"}, d2 = {"", "Lid/dana/geofence/model/PoiModel;", "Lcom/google/android/gms/location/Geofence;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/domain/geofence/model/Poi;", "BuiltInFictitiousFunctionClassFactory"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PoiMapperKt {
    public static final List<PoiModel> BuiltInFictitiousFunctionClassFactory(List<Poi> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<Poi> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Poi poi : list2) {
            Intrinsics.checkNotNullParameter(poi, "");
            arrayList.add(new PoiModel(poi.getPoiId(), poi.getLatitude(), poi.getLongitude(), poi.getRadius()));
        }
        return arrayList;
    }

    public static final List<Geofence> MyBillsEntityDataFactory(List<PoiModel> list) {
        Geofence geofence;
        int i;
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        for (PoiModel poiModel : list) {
            try {
                Intrinsics.checkNotNullParameter(poiModel, "");
                Geofence.Builder requestId = new Geofence.Builder().setRequestId(poiModel.MyBillsEntityDataFactory);
                GeofenceConstant geofenceConstant = GeofenceConstant.INSTANCE;
                i = GeofenceConstant.PlaceComponentResult;
                Geofence.Builder circularRegion = requestId.setLoiteringDelay(i).setTransitionTypes(5).setCircularRegion(((Number) poiModel.getAuthRequestContext.getValue()).doubleValue(), ((Number) poiModel.BuiltInFictitiousFunctionClassFactory.getValue()).doubleValue(), poiModel.getErrorConfigVersion <= 0 ? 700 : poiModel.getErrorConfigVersion);
                GeofenceConstant geofenceConstant2 = GeofenceConstant.INSTANCE;
                geofence = circularRegion.setExpirationDuration(GeofenceConstant.PlaceComponentResult()).build();
                Intrinsics.checkNotNullExpressionValue(geofence, "");
            } catch (Exception e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GEOFENCE_TAG, "Error creating geofences", e);
                geofence = null;
            }
            if (geofence != null) {
                arrayList.add(geofence);
            }
        }
        return arrayList;
    }
}
