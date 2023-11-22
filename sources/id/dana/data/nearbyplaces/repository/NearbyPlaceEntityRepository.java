package id.dana.data.nearbyplaces.repository;

import android.location.Location;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.data.nearbyplaces.NearbyPlaceEntityData;
import id.dana.data.nearbyplaces.mapper.PlaceResultMapperKt;
import id.dana.data.nearbyplaces.repository.source.NearbyPlaceEntityDataFactory;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.domain.nearbyplaces.model.SuggestedLocation;
import id.dana.domain.tracker.GeocodeTrackerData;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004JK\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013JE\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017JE\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/nearbyplaces/repository/NearbyPlaceEntityRepository;", "Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;", "Lid/dana/data/nearbyplaces/NearbyPlaceEntityData;", "createNearbyPlaceEntityData", "()Lid/dana/data/nearbyplaces/NearbyPlaceEntityData;", "", "keyword", "Landroid/location/Location;", "location", "ontology", "uuid", "Lid/dana/domain/tracker/GeocodeTrackerData;", "geocodeTrackerData", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lio/reactivex/Observable;", "", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "getChainQueryResult", "(Ljava/lang/String;Landroid/location/Location;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/tracker/GeocodeTrackerData;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "", HereUrlConstant.LIMIT, "getListNearbyLocations", "(Ljava/lang/String;Landroid/location/Location;Ljava/lang/String;Ljava/lang/Integer;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/domain/nearbyplaces/model/SuggestedLocation;", "getListSuggestedLocations", "Lid/dana/data/nearbyplaces/repository/source/NearbyPlaceEntityDataFactory;", "nearbyPlaceEntityDataFactory", "Lid/dana/data/nearbyplaces/repository/source/NearbyPlaceEntityDataFactory;", "<init>", "(Lid/dana/data/nearbyplaces/repository/source/NearbyPlaceEntityDataFactory;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NearbyPlaceEntityRepository implements NearbyPlaceRepository {
    public static final int CHAIN_QUERY_ITEM = 1;
    public static final int LOCATION_ITEM = 0;
    private final NearbyPlaceEntityDataFactory nearbyPlaceEntityDataFactory;

    @Inject
    public NearbyPlaceEntityRepository(NearbyPlaceEntityDataFactory nearbyPlaceEntityDataFactory) {
        Intrinsics.checkNotNullParameter(nearbyPlaceEntityDataFactory, "");
        this.nearbyPlaceEntityDataFactory = nearbyPlaceEntityDataFactory;
    }

    @Override // id.dana.domain.nearbyplaces.NearbyPlaceRepository
    public final Observable<List<NearbyLocation>> getListNearbyLocations(String keyword, Location location, String uuid, Integer limit, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(uuid, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Observable map = createNearbyPlaceEntityData().getListNearbyLocations(keyword, location.getLatitude(), location.getLongitude(), uuid, limit, hereMixPanelTrackerData).map(new Function() { // from class: id.dana.data.nearbyplaces.repository.NearbyPlaceEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PlaceResultMapperKt.toListNearbyLocation((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.nearbyplaces.NearbyPlaceRepository
    public final Observable<List<SuggestedLocation>> getListSuggestedLocations(String keyword, Location location, String uuid, Integer limit, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(uuid, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Observable map = createNearbyPlaceEntityData().getListNearbyLocations(keyword, location.getLatitude(), location.getLongitude(), uuid, limit, hereMixPanelTrackerData).map(new Function() { // from class: id.dana.data.nearbyplaces.repository.NearbyPlaceEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1538getListSuggestedLocations$lambda0;
                m1538getListSuggestedLocations$lambda0 = NearbyPlaceEntityRepository.m1538getListSuggestedLocations$lambda0((List) obj);
                return m1538getListSuggestedLocations$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getListSuggestedLocations$lambda-0  reason: not valid java name */
    public static final List m1538getListSuggestedLocations$lambda0(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return PlaceResultMapperKt.toListSuggestedLocation(list);
    }

    @Override // id.dana.domain.nearbyplaces.NearbyPlaceRepository
    public final Observable<List<NearbyLocation>> getChainQueryResult(String keyword, Location location, String ontology, String uuid, GeocodeTrackerData geocodeTrackerData, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(ontology, "");
        Intrinsics.checkNotNullParameter(uuid, "");
        Intrinsics.checkNotNullParameter(geocodeTrackerData, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Observable map = createNearbyPlaceEntityData().getChainQuery(keyword, location.getLatitude(), location.getLongitude(), ontology, uuid, hereMixPanelTrackerData).map(new Function() { // from class: id.dana.data.nearbyplaces.repository.NearbyPlaceEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1537getChainQueryResult$lambda1;
                m1537getChainQueryResult$lambda1 = NearbyPlaceEntityRepository.m1537getChainQueryResult$lambda1((List) obj);
                return m1537getChainQueryResult$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getChainQueryResult$lambda-1  reason: not valid java name */
    public static final List m1537getChainQueryResult$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return PlaceResultMapperKt.toListNearbyLocation(list);
    }

    private final NearbyPlaceEntityData createNearbyPlaceEntityData() {
        return this.nearbyPlaceEntityDataFactory.createData2("network");
    }
}
