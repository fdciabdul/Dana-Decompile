package id.dana.domain.nearbyplaces;

import android.location.Location;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.domain.nearbyplaces.model.SuggestedLocation;
import id.dana.domain.tracker.GeocodeTrackerData;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&JE\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0013JE\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;", "", "getChainQueryResult", "Lio/reactivex/Observable;", "", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "keyword", "", "location", "Landroid/location/Location;", "ontology", "uuid", "geocodeTrackerData", "Lid/dana/domain/tracker/GeocodeTrackerData;", "hereMixPanelTrackerData", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "getListNearbyLocations", HereUrlConstant.LIMIT, "", "(Ljava/lang/String;Landroid/location/Location;Ljava/lang/String;Ljava/lang/Integer;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "getListSuggestedLocations", "Lid/dana/domain/nearbyplaces/model/SuggestedLocation;", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NearbyPlaceRepository {
    Observable<List<NearbyLocation>> getChainQueryResult(String keyword, Location location, String ontology, String uuid, GeocodeTrackerData geocodeTrackerData, HereMixPanelTrackerData hereMixPanelTrackerData);

    Observable<List<NearbyLocation>> getListNearbyLocations(String keyword, Location location, String uuid, Integer limit, HereMixPanelTrackerData hereMixPanelTrackerData);

    Observable<List<SuggestedLocation>> getListSuggestedLocations(String keyword, Location location, String uuid, Integer limit, HereMixPanelTrackerData hereMixPanelTrackerData);

    /* renamed from: id.dana.domain.nearbyplaces.NearbyPlaceRepository$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getListNearbyLocations$default(NearbyPlaceRepository nearbyPlaceRepository, String str, Location location, String str2, Integer num, HereMixPanelTrackerData hereMixPanelTrackerData, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    num = null;
                }
                return nearbyPlaceRepository.getListNearbyLocations(str, location, str2, num, hereMixPanelTrackerData);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListNearbyLocations");
        }

        public static /* synthetic */ Observable getListSuggestedLocations$default(NearbyPlaceRepository nearbyPlaceRepository, String str, Location location, String str2, Integer num, HereMixPanelTrackerData hereMixPanelTrackerData, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    num = null;
                }
                return nearbyPlaceRepository.getListSuggestedLocations(str, location, str2, num, hereMixPanelTrackerData);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListSuggestedLocations");
        }
    }
}
