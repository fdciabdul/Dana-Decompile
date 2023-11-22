package id.dana.data.here.source.network;

import android.location.Location;
import com.alipay.mobile.map.model.MapConstant;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.here.AddressNotFoundException;
import id.dana.data.here.HereOauthManager;
import id.dana.data.here.model.Address;
import id.dana.data.here.model.HereAutoCompleteResponse;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.data.here.model.Item;
import id.dana.data.here.model.Position;
import id.dana.data.nearbyplaces.NearbyPlaceEntityData;
import id.dana.data.nearbyplaces.repository.source.network.result.PlacePredictionResult;
import id.dana.data.nearbyplaces.repository.source.network.result.PlaceStructuredFormattingResult;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0019\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJK\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u00152\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017JM\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u00152\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/data/here/source/network/NetworkHereLocationEntityData;", "Lid/dana/data/nearbyplaces/NearbyPlaceEntityData;", "Lid/dana/data/here/model/Item;", "it", "", "composeAddressText", "(Lid/dana/data/here/model/Item;)Ljava/lang/String;", "composeSubdistrictName", "", FirebaseAnalytics.Param.ITEMS, "Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;", "generatePlacePredictionResult", "(Ljava/util/List;)Ljava/util/List;", "keyword", "", "lat", "lng", "ontology", "uuid", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lio/reactivex/Observable;", "getChainQuery", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", MapConstant.EXTRA_LON, "", HereUrlConstant.LIMIT, "getListNearbyLocations", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/Integer;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/data/here/source/network/HereAutosuggestApi;", "hereAutosuggestApi", "Lid/dana/data/here/source/network/HereAutosuggestApi;", "Lid/dana/data/here/HereOauthManager;", "hereOauthManager", "Lid/dana/data/here/HereOauthManager;", "<init>", "(Lid/dana/data/here/source/network/HereAutosuggestApi;Lid/dana/data/here/HereOauthManager;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkHereLocationEntityData implements NearbyPlaceEntityData {
    public static final String CATEGORY_QUERY = "categoryQuery";
    public static final String CHAIN_QUERY = "chainQuery";
    public static final int DEFAULT_LIMIT = 20;
    private final HereAutosuggestApi hereAutosuggestApi;
    private final HereOauthManager hereOauthManager;

    @Inject
    public NetworkHereLocationEntityData(HereAutosuggestApi hereAutosuggestApi, HereOauthManager hereOauthManager) {
        Intrinsics.checkNotNullParameter(hereAutosuggestApi, "");
        Intrinsics.checkNotNullParameter(hereOauthManager, "");
        this.hereAutosuggestApi = hereAutosuggestApi;
        this.hereOauthManager = hereOauthManager;
    }

    @Override // id.dana.data.nearbyplaces.NearbyPlaceEntityData
    public final Observable<List<PlacePredictionResult>> getListNearbyLocations(final String keyword, double lat, double lon, String uuid, Integer limit, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(uuid, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        StringBuilder sb = new StringBuilder();
        sb.append(lat);
        sb.append(',');
        sb.append(lon);
        final String obj = sb.toString();
        final int intValue = limit != null ? limit.intValue() : 20;
        hereMixPanelTrackerData.setUsage(TrackerDataKey.HEREProperties.UsageProperties.AUTO_SUGGEST);
        Observable<List<PlacePredictionResult>> flatMap = this.hereOauthManager.executeHereApi(hereMixPanelTrackerData, new Function1<String, Observable<HereAutoCompleteResponse>>() { // from class: id.dana.data.here.source.network.NetworkHereLocationEntityData$getListNearbyLocations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<HereAutoCompleteResponse> invoke(String str) {
                HereAutosuggestApi hereAutosuggestApi;
                Intrinsics.checkNotNullParameter(str, "");
                hereAutosuggestApi = NetworkHereLocationEntityData.this.hereAutosuggestApi;
                String str2 = obj;
                int i = intValue;
                return hereAutosuggestApi.autoSuggest(str2, HereUrlConstant.LANG_US, String.valueOf(i), keyword, HereUrlConstant.COUNTRY_CODE_IDN, str);
            }
        }).flatMap(new Function() { // from class: id.dana.data.here.source.network.NetworkHereLocationEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                ObservableSource m1365getListNearbyLocations$lambda0;
                m1365getListNearbyLocations$lambda0 = NetworkHereLocationEntityData.m1365getListNearbyLocations$lambda0(NetworkHereLocationEntityData.this, (HereAutoCompleteResponse) obj2);
                return m1365getListNearbyLocations$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getListNearbyLocations$lambda-0  reason: not valid java name */
    public static final ObservableSource m1365getListNearbyLocations$lambda0(NetworkHereLocationEntityData networkHereLocationEntityData, HereAutoCompleteResponse hereAutoCompleteResponse) {
        Observable error;
        Intrinsics.checkNotNullParameter(networkHereLocationEntityData, "");
        Intrinsics.checkNotNullParameter(hereAutoCompleteResponse, "");
        if (hereAutoCompleteResponse.getItems() != null) {
            error = Observable.just(networkHereLocationEntityData.generatePlacePredictionResult(hereAutoCompleteResponse.getItems()));
            Intrinsics.checkNotNullExpressionValue(error, "");
        } else {
            error = Observable.error(new AddressNotFoundException());
            Intrinsics.checkNotNullExpressionValue(error, "");
        }
        return error;
    }

    private final List<PlacePredictionResult> generatePlacePredictionResult(List<Item> items) {
        Double lng;
        Double lat;
        List<Item> list = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Item item : list) {
            boolean z = Intrinsics.areEqual(item.getResultType(), CHAIN_QUERY) || Intrinsics.areEqual(item.getResultType(), CATEGORY_QUERY);
            String title = item.getTitle();
            String str = title == null ? "" : title;
            Integer distance = item.getDistance();
            long intValue = distance != null ? distance.intValue() : 0;
            String id2 = item.getId();
            String str2 = id2 == null ? "" : id2;
            String id3 = item.getId();
            String str3 = id3 == null ? "" : id3;
            String title2 = item.getTitle();
            if (title2 == null) {
                title2 = "";
            }
            PlaceStructuredFormattingResult placeStructuredFormattingResult = new PlaceStructuredFormattingResult(title2, composeAddressText(item));
            String href = item.getHref();
            Location location = new Location("");
            Position position = item.getPosition();
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            location.setLatitude((position == null || (lat = position.getLat()) == null) ? 0.0d : lat.doubleValue());
            Position position2 = item.getPosition();
            if (position2 != null && (lng = position2.getLng()) != null) {
                d = lng.doubleValue();
            }
            location.setLongitude(d);
            Unit unit = Unit.INSTANCE;
            arrayList.add(new PlacePredictionResult(str, intValue, str2, str3, placeStructuredFormattingResult, href, z, location));
        }
        return arrayList;
    }

    private final String composeAddressText(Item it) {
        String district;
        String composeSubdistrictName = composeSubdistrictName(it);
        StringBuilder sb = new StringBuilder();
        sb.append(composeSubdistrictName);
        Address address = it.getAddress();
        String district2 = address != null ? address.getDistrict() : null;
        if (district2 == null) {
            district2 = "";
        }
        sb.append(district2);
        if (sb.toString().length() == 0) {
            Address address2 = it.getAddress();
            String street = address2 != null ? address2.getStreet() : null;
            if (street == null || street.length() == 0) {
                Address address3 = it.getAddress();
                district = address3 != null ? address3.getLabel() : null;
                if (district == null) {
                    return "";
                }
            } else {
                Address address4 = it.getAddress();
                district = address4 != null ? address4.getStreet() : null;
                if (district == null) {
                    return "";
                }
            }
            return district;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(composeSubdistrictName);
        Address address5 = it.getAddress();
        district = address5 != null ? address5.getDistrict() : null;
        sb2.append(district != null ? district : "");
        return sb2.toString();
    }

    private final String composeSubdistrictName(Item it) {
        Address address = it.getAddress();
        String subdistrict = address != null ? address.getSubdistrict() : null;
        if (subdistrict == null || subdistrict.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Address address2 = it.getAddress();
        sb.append(address2 != null ? address2.getSubdistrict() : null);
        sb.append(", ");
        return sb.toString();
    }

    @Override // id.dana.data.nearbyplaces.NearbyPlaceEntityData
    public final Observable<List<PlacePredictionResult>> getChainQuery(final String keyword, double lat, double lng, final String ontology, String uuid, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(ontology, "");
        Intrinsics.checkNotNullParameter(uuid, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        StringBuilder sb = new StringBuilder();
        sb.append(lat);
        sb.append(',');
        sb.append(lng);
        final String obj = sb.toString();
        hereMixPanelTrackerData.setUsage(TrackerDataKey.HEREProperties.UsageProperties.DISCOVER);
        Observable<List<PlacePredictionResult>> flatMap = this.hereOauthManager.executeHereApi(hereMixPanelTrackerData, new Function1<String, Observable<HereAutoCompleteResponse>>() { // from class: id.dana.data.here.source.network.NetworkHereLocationEntityData$getChainQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<HereAutoCompleteResponse> invoke(String str) {
                HereAutosuggestApi hereAutosuggestApi;
                Intrinsics.checkNotNullParameter(str, "");
                hereAutosuggestApi = NetworkHereLocationEntityData.this.hereAutosuggestApi;
                return hereAutosuggestApi.discover(obj, HereUrlConstant.LANG_US, ontology, "20", keyword, HereUrlConstant.COUNTRY_CODE_IDN, str);
            }
        }).flatMap(new Function() { // from class: id.dana.data.here.source.network.NetworkHereLocationEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                ObservableSource m1364getChainQuery$lambda5;
                m1364getChainQuery$lambda5 = NetworkHereLocationEntityData.m1364getChainQuery$lambda5(NetworkHereLocationEntityData.this, (HereAutoCompleteResponse) obj2);
                return m1364getChainQuery$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getChainQuery$lambda-5  reason: not valid java name */
    public static final ObservableSource m1364getChainQuery$lambda5(NetworkHereLocationEntityData networkHereLocationEntityData, HereAutoCompleteResponse hereAutoCompleteResponse) {
        Observable error;
        Double lng;
        Double lat;
        Intrinsics.checkNotNullParameter(networkHereLocationEntityData, "");
        Intrinsics.checkNotNullParameter(hereAutoCompleteResponse, "");
        if (hereAutoCompleteResponse.getItems() != null) {
            List<Item> items = hereAutoCompleteResponse.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (Item item : items) {
                String title = item.getTitle();
                String str = title == null ? "" : title;
                Integer distance = item.getDistance();
                long intValue = distance != null ? distance.intValue() : 0;
                String id2 = item.getId();
                String str2 = id2 == null ? "" : id2;
                String id3 = item.getId();
                String str3 = id3 == null ? "" : id3;
                String title2 = item.getTitle();
                if (title2 == null) {
                    title2 = "";
                }
                PlaceStructuredFormattingResult placeStructuredFormattingResult = new PlaceStructuredFormattingResult(title2, networkHereLocationEntityData.composeAddressText(item));
                Location location = new Location("");
                Position position = item.getPosition();
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                location.setLatitude((position == null || (lat = position.getLat()) == null) ? 0.0d : lat.doubleValue());
                Position position2 = item.getPosition();
                if (position2 != null && (lng = position2.getLng()) != null) {
                    d = lng.doubleValue();
                }
                location.setLongitude(d);
                Unit unit = Unit.INSTANCE;
                arrayList.add(new PlacePredictionResult(str, intValue, str2, str3, placeStructuredFormattingResult, null, false, location, 96, null));
            }
            error = Observable.just(arrayList);
            Intrinsics.checkNotNullExpressionValue(error, "");
        } else {
            String errorMessage = hereAutoCompleteResponse.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "";
            }
            error = Observable.error(new Throwable(errorMessage));
            Intrinsics.checkNotNullExpressionValue(error, "");
        }
        return error;
    }
}
