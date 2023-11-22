package id.dana.data.nearbyplaces.repository.source.network;

import com.alipay.mobile.map.model.MapConstant;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.data.nearbyplaces.NearbyPlaceEntityData;
import id.dana.data.nearbyplaces.repository.source.network.result.PlacePredictionResult;
import id.dana.data.nearbyplaces.repository.source.network.result.PlaceSearchListResult;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019JK\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJM\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/NetworkNearbyPlaceEntityData;", "Lid/dana/data/nearbyplaces/NearbyPlaceEntityData;", "", "keyword", "", "lat", "lng", "ontology", "uuid", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lio/reactivex/Observable;", "", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;", "getChainQuery", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", MapConstant.EXTRA_LON, "", HereUrlConstant.LIMIT, "getListNearbyLocations", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/Integer;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/data/nearbyplaces/repository/source/network/NearbyPlacesApi;", "nearbyPlacesApi", "Lid/dana/data/nearbyplaces/repository/source/network/NearbyPlacesApi;", "<init>", "(Lid/dana/data/nearbyplaces/repository/source/network/NearbyPlacesApi;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NetworkNearbyPlaceEntityData implements NearbyPlaceEntityData {
    private static final String FIELDS = "geometry";
    private static final int RADIUS = 50000;
    private static final String STATUS = "OK";
    private final NearbyPlacesApi nearbyPlacesApi;

    @Inject
    public NetworkNearbyPlaceEntityData(NearbyPlacesApi nearbyPlacesApi) {
        Intrinsics.checkNotNullParameter(nearbyPlacesApi, "");
        this.nearbyPlacesApi = nearbyPlacesApi;
    }

    @Override // id.dana.data.nearbyplaces.NearbyPlaceEntityData
    public final Observable<List<PlacePredictionResult>> getListNearbyLocations(String keyword, double lat, double lon, String uuid, Integer limit, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(uuid, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        StringBuilder sb = new StringBuilder();
        sb.append(lat);
        sb.append(',');
        sb.append(lon);
        String obj = sb.toString();
        Observable flatMap = this.nearbyPlacesApi.findPlaces(keyword, obj, obj, 50000, uuid, "AIzaSyBr8axhuN2K9uREP6j4SjOmbp8OsDnrdC8").flatMap(new Function() { // from class: id.dana.data.nearbyplaces.repository.source.network.NetworkNearbyPlaceEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                ObservableSource m1540getListNearbyLocations$lambda0;
                m1540getListNearbyLocations$lambda0 = NetworkNearbyPlaceEntityData.m1540getListNearbyLocations$lambda0((PlaceSearchListResult) obj2);
                return m1540getListNearbyLocations$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getListNearbyLocations$lambda-0  reason: not valid java name */
    public static final ObservableSource m1540getListNearbyLocations$lambda0(PlaceSearchListResult placeSearchListResult) {
        Intrinsics.checkNotNullParameter(placeSearchListResult, "");
        if (!Intrinsics.areEqual(placeSearchListResult.getStatus(), STATUS)) {
            Observable.error(new Throwable(placeSearchListResult.getStatus()));
        }
        return Observable.just(placeSearchListResult.getPredictions());
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.nearbyplaces.NearbyPlaceEntityData
    public final Observable<List<PlacePredictionResult>> getChainQuery(String keyword, double lat, double lng, String ontology, String uuid, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(ontology, "");
        Intrinsics.checkNotNullParameter(uuid, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }
}
