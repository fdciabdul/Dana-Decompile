package id.dana.data.here.source.network;

import android.location.Location;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.geocode.repository.source.GeocodeEntityData;
import id.dana.data.here.AddressNotFoundException;
import id.dana.data.here.HereOauthManager;
import id.dana.data.here.model.Address;
import id.dana.data.here.model.HereGeocodeResponse;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.data.here.model.Item;
import id.dana.data.nearbyplaces.mapper.AddressMapperKt;
import id.dana.data.util.LocaleUtils;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0019\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b'\u0010(J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0007J%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0015R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/data/here/source/network/NetworkHereGeocodeEntityData;", "Lid/dana/data/geocode/repository/source/GeocodeEntityData;", "Lid/dana/domain/globalsearch/model/LatLng;", "latLng", "Lio/reactivex/Observable;", "", "getCountryCodeByLocation", "(Lid/dana/domain/globalsearch/model/LatLng;)Lio/reactivex/Observable;", "getCountryCodeFromGeocoderApi", "Landroid/location/Location;", "location", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "getDistrictNameByLocation", "(Landroid/location/Location;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "getLatestLocationSubdisivision", "()Lio/reactivex/Observable;", "getLatestProvinceLandmark", BridgeName.LOCATION_NAME, "getLocationFromLocationName", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/miniprogram/model/Address;", "getReverseGeocodeByLoc", "(Landroid/location/Location;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "getSubdivisionsFromGeocoder", "locationSubdisivision", "", "saveLatestLocationSubdisivision", "(Lid/dana/domain/geocode/model/LocationSubdisivision;)Lio/reactivex/Observable;", "provinceName", "saveLatestProvinceLandmark", "Lid/dana/data/here/source/network/HereGeocodeApi;", "geocodeApi", "Lid/dana/data/here/source/network/HereGeocodeApi;", "Lid/dana/data/here/HereOauthManager;", "oauthManager", "Lid/dana/data/here/HereOauthManager;", "<init>", "(Lid/dana/data/here/source/network/HereGeocodeApi;Lid/dana/data/here/HereOauthManager;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkHereGeocodeEntityData implements GeocodeEntityData {
    private static final String GLOBAL_NETWORK_SOURCE = "Global Network";
    private final HereGeocodeApi geocodeApi;
    private final HereOauthManager oauthManager;

    @Inject
    public NetworkHereGeocodeEntityData(HereGeocodeApi hereGeocodeApi, HereOauthManager hereOauthManager) {
        Intrinsics.checkNotNullParameter(hereGeocodeApi, "");
        Intrinsics.checkNotNullParameter(hereOauthManager, "");
        this.geocodeApi = hereGeocodeApi;
        this.oauthManager = hereOauthManager;
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<String> getDistrictNameByLocation(Location location, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        sb.append(',');
        sb.append(location.getLongitude());
        final String obj = sb.toString();
        hereMixPanelTrackerData.setUsage(TrackerDataKey.HEREProperties.UsageProperties.REVERSE_GEOCODE);
        Observable<String> flatMap = this.oauthManager.executeHereApi(hereMixPanelTrackerData, new Function1<String, Observable<HereGeocodeResponse>>() { // from class: id.dana.data.here.source.network.NetworkHereGeocodeEntityData$getDistrictNameByLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<HereGeocodeResponse> invoke(String str) {
                HereGeocodeApi hereGeocodeApi;
                Intrinsics.checkNotNullParameter(str, "");
                hereGeocodeApi = NetworkHereGeocodeEntityData.this.geocodeApi;
                return hereGeocodeApi.geocodeReverse(obj, HereUrlConstant.LANG_US, str);
            }
        }).flatMap(new Function() { // from class: id.dana.data.here.source.network.NetworkHereGeocodeEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                ObservableSource m1361getDistrictNameByLocation$lambda0;
                m1361getDistrictNameByLocation$lambda0 = NetworkHereGeocodeEntityData.m1361getDistrictNameByLocation$lambda0((HereGeocodeResponse) obj2);
                return m1361getDistrictNameByLocation$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getDistrictNameByLocation$lambda-0 */
    public static final ObservableSource m1361getDistrictNameByLocation$lambda0(HereGeocodeResponse hereGeocodeResponse) {
        Observable just;
        Item item;
        Address address;
        Intrinsics.checkNotNullParameter(hereGeocodeResponse, "");
        List<Item> hereItems = hereGeocodeResponse.getHereItems();
        String district = (hereItems == null || (item = (Item) CollectionsKt.firstOrNull((List) hereItems)) == null || (address = item.getAddress()) == null) ? null : address.getDistrict();
        if (district == null) {
            district = "";
        }
        if (district.length() == 0) {
            just = Observable.error(new AddressNotFoundException());
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            just = Observable.just(district);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<IndoSubdivisions> getSubdivisionsFromGeocoder(Location location, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        sb.append(',');
        sb.append(location.getLongitude());
        final String obj = sb.toString();
        hereMixPanelTrackerData.setUsage(TrackerDataKey.HEREProperties.UsageProperties.REVERSE_GEOCODE);
        Observable<IndoSubdivisions> flatMap = this.oauthManager.executeHereApi(hereMixPanelTrackerData, new Function1<String, Observable<HereGeocodeResponse>>() { // from class: id.dana.data.here.source.network.NetworkHereGeocodeEntityData$getSubdivisionsFromGeocoder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<HereGeocodeResponse> invoke(String str) {
                HereGeocodeApi hereGeocodeApi;
                Intrinsics.checkNotNullParameter(str, "");
                hereGeocodeApi = NetworkHereGeocodeEntityData.this.geocodeApi;
                return hereGeocodeApi.geocodeReverse(obj, HereUrlConstant.LANG_US, str);
            }
        }).flatMap(new Function() { // from class: id.dana.data.here.source.network.NetworkHereGeocodeEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                ObservableSource m1362getSubdivisionsFromGeocoder$lambda1;
                m1362getSubdivisionsFromGeocoder$lambda1 = NetworkHereGeocodeEntityData.m1362getSubdivisionsFromGeocoder$lambda1((HereGeocodeResponse) obj2);
                return m1362getSubdivisionsFromGeocoder$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getSubdivisionsFromGeocoder$lambda-1 */
    public static final ObservableSource m1362getSubdivisionsFromGeocoder$lambda1(HereGeocodeResponse hereGeocodeResponse) {
        Observable error;
        Intrinsics.checkNotNullParameter(hereGeocodeResponse, "");
        List<Item> hereItems = hereGeocodeResponse.getHereItems();
        Item item = hereItems != null ? (Item) CollectionsKt.firstOrNull((List) hereItems) : null;
        if ((item != null ? item.getAddress() : null) != null) {
            error = Observable.just(AddressMapperKt.generateSubdivision(item.getAddress()));
            Intrinsics.checkNotNullExpressionValue(error, "");
        } else {
            error = Observable.error(new AddressNotFoundException());
            Intrinsics.checkNotNullExpressionValue(error, "");
        }
        return error;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Location> getLocationFromLocationName(String r3) {
        Intrinsics.checkNotNullParameter(r3, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<id.dana.domain.miniprogram.model.Address> getReverseGeocodeByLoc(Location location) {
        Intrinsics.checkNotNullParameter(location, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<String> getLatestProvinceLandmark() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Boolean> saveLatestProvinceLandmark(String provinceName) {
        Intrinsics.checkNotNullParameter(provinceName, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<LocationSubdisivision> getLatestLocationSubdisivision() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Boolean> saveLatestLocationSubdisivision(LocationSubdisivision locationSubdisivision) {
        Intrinsics.checkNotNullParameter(locationSubdisivision, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<String> getCountryCodeByLocation(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "");
        LocaleUtils.INSTANCE.initIsoCodes();
        return getCountryCodeFromGeocoderApi(latLng);
    }

    private final Observable<String> getCountryCodeFromGeocoderApi(LatLng latLng) {
        StringBuilder sb = new StringBuilder();
        sb.append(latLng.getLatitude());
        sb.append(',');
        sb.append(latLng.getLongitude());
        final String obj = sb.toString();
        Observable<String> flatMap = this.oauthManager.executeHereApi(new HereMixPanelTrackerData(GLOBAL_NETWORK_SOURCE, null, false, null, null, 30, null), new Function1<String, Observable<HereGeocodeResponse>>() { // from class: id.dana.data.here.source.network.NetworkHereGeocodeEntityData$getCountryCodeFromGeocoderApi$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<HereGeocodeResponse> invoke(String str) {
                HereGeocodeApi hereGeocodeApi;
                Intrinsics.checkNotNullParameter(str, "");
                hereGeocodeApi = NetworkHereGeocodeEntityData.this.geocodeApi;
                return hereGeocodeApi.geocodeReverse(obj, HereUrlConstant.LANG_US, str);
            }
        }).flatMap(new Function() { // from class: id.dana.data.here.source.network.NetworkHereGeocodeEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                ObservableSource m1360getCountryCodeFromGeocoderApi$lambda2;
                m1360getCountryCodeFromGeocoderApi$lambda2 = NetworkHereGeocodeEntityData.m1360getCountryCodeFromGeocoderApi$lambda2((HereGeocodeResponse) obj2);
                return m1360getCountryCodeFromGeocoderApi$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getCountryCodeFromGeocoderApi$lambda-2 */
    public static final ObservableSource m1360getCountryCodeFromGeocoderApi$lambda2(HereGeocodeResponse hereGeocodeResponse) {
        Address address;
        String countryCode;
        String str = "";
        Intrinsics.checkNotNullParameter(hereGeocodeResponse, "");
        List<Item> hereItems = hereGeocodeResponse.getHereItems();
        Item item = hereItems != null ? (Item) CollectionsKt.firstOrNull((List) hereItems) : null;
        LocaleUtils localeUtils = LocaleUtils.INSTANCE;
        if (item != null && (address = item.getAddress()) != null && (countryCode = address.getCountryCode()) != null) {
            str = countryCode;
        }
        return Observable.just(localeUtils.getIso2CountryCode(str));
    }
}
