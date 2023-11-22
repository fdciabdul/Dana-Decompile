package id.dana.data.nearbyplaces;

import com.alipay.mobile.map.model.MapConstant;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.data.nearbyplaces.repository.source.network.result.PlacePredictionResult;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&JM\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lid/dana/data/nearbyplaces/NearbyPlaceEntityData;", "", "getChainQuery", "Lio/reactivex/Observable;", "", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;", "keyword", "", "lat", "", "lng", "ontology", "uuid", "hereMixPanelTrackerData", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "getListNearbyLocations", MapConstant.EXTRA_LON, HereUrlConstant.LIMIT, "", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/Integer;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NearbyPlaceEntityData {
    Observable<List<PlacePredictionResult>> getChainQuery(String keyword, double lat, double lng, String ontology, String uuid, HereMixPanelTrackerData hereMixPanelTrackerData);

    Observable<List<PlacePredictionResult>> getListNearbyLocations(String keyword, double lat, double r4, String uuid, Integer r7, HereMixPanelTrackerData hereMixPanelTrackerData);

    /* renamed from: id.dana.data.nearbyplaces.NearbyPlaceEntityData$-CC */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getListNearbyLocations$default(NearbyPlaceEntityData nearbyPlaceEntityData, String str, double d, double d2, String str2, Integer num, HereMixPanelTrackerData hereMixPanelTrackerData, int i, Object obj) {
            if (obj == null) {
                return nearbyPlaceEntityData.getListNearbyLocations(str, d, d2, str2, (i & 16) != 0 ? null : num, hereMixPanelTrackerData);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListNearbyLocations");
        }
    }
}
