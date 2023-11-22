package id.dana.data.geocode.repository.source.network;

import android.location.Location;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import id.dana.data.geocode.model.GeocoderResult;
import id.dana.data.geocode.repository.source.GeocodeEntityData;
import id.dana.data.globalnetwork.source.mapper.parser.GeoCodeParser;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0007\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\rJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0014R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/data/geocode/repository/source/network/NetworkGeocodeEntityData;", "Lid/dana/data/geocode/repository/source/GeocodeEntityData;", "Lid/dana/domain/globalsearch/model/LatLng;", "latLng", "Lio/reactivex/Observable;", "", "getCountryCodeByLocation", "(Lid/dana/domain/globalsearch/model/LatLng;)Lio/reactivex/Observable;", "Landroid/location/Location;", "location", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "getDistrictNameByLocation", "(Landroid/location/Location;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "getLatestLocationSubdisivision", "()Lio/reactivex/Observable;", "getLatestProvinceLandmark", BridgeName.LOCATION_NAME, "getLocationFromLocationName", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/miniprogram/model/Address;", "getReverseGeocodeByLoc", "(Landroid/location/Location;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "getSubdivisionsFromGeocoder", "locationSubdisivision", "", "saveLatestLocationSubdisivision", "(Lid/dana/domain/geocode/model/LocationSubdisivision;)Lio/reactivex/Observable;", "provinceName", "saveLatestProvinceLandmark", "Lid/dana/data/geocode/repository/source/network/GeocoderApi;", "geocoderApi", "Lid/dana/data/geocode/repository/source/network/GeocoderApi;", "<init>", "(Lid/dana/data/geocode/repository/source/network/GeocoderApi;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkGeocodeEntityData implements GeocodeEntityData {
    private static final String STATUS_OK = "OK";
    private final GeocoderApi geocoderApi;

    @Inject
    public NetworkGeocodeEntityData(GeocoderApi geocoderApi) {
        Intrinsics.checkNotNullParameter(geocoderApi, "");
        this.geocoderApi = geocoderApi;
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<String> getDistrictNameByLocation(Location location, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        sb.append(',');
        sb.append(location.getLongitude());
        Observable flatMap = this.geocoderApi.reverseGeocode(sb.toString(), "AIzaSyBr8axhuN2K9uREP6j4SjOmbp8OsDnrdC8").flatMap(new Function() { // from class: id.dana.data.geocode.repository.source.network.NetworkGeocodeEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1304getDistrictNameByLocation$lambda0;
                m1304getDistrictNameByLocation$lambda0 = NetworkGeocodeEntityData.m1304getDistrictNameByLocation$lambda0((GeocoderResult) obj);
                return m1304getDistrictNameByLocation$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDistrictNameByLocation$lambda-0  reason: not valid java name */
    public static final ObservableSource m1304getDistrictNameByLocation$lambda0(GeocoderResult geocoderResult) {
        Observable just;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        if (!Intrinsics.areEqual(geocoderResult.getStatus(), STATUS_OK)) {
            just = Observable.error(new Throwable(geocoderResult.getStatus()));
        } else {
            just = Observable.just(GeocoderResultMapperKt.toDistrictName(geocoderResult));
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
        Observable flatMap = this.geocoderApi.reverseGeocode(sb.toString(), "AIzaSyBr8axhuN2K9uREP6j4SjOmbp8OsDnrdC8").flatMap(new Function() { // from class: id.dana.data.geocode.repository.source.network.NetworkGeocodeEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1305getSubdivisionsFromGeocoder$lambda8;
                m1305getSubdivisionsFromGeocoder$lambda8 = NetworkGeocodeEntityData.m1305getSubdivisionsFromGeocoder$lambda8((GeocoderResult) obj);
                return m1305getSubdivisionsFromGeocoder$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubdivisionsFromGeocoder$lambda-8  reason: not valid java name */
    public static final ObservableSource m1305getSubdivisionsFromGeocoder$lambda8(GeocoderResult geocoderResult) {
        Observable just;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        if (!Intrinsics.areEqual(geocoderResult.getStatus(), STATUS_OK)) {
            just = Observable.error(new Throwable(geocoderResult.getStatus()));
        } else {
            IndoSubdivisions.Builder builder = new IndoSubdivisions.Builder();
            builder.withCountryCode(GeocoderResultMapperKt.toCountryCode(geocoderResult));
            builder.withCountryName(GeocoderResultMapperKt.toCountryName(geocoderResult));
            builder.withProvinceName(GeocoderResultMapperKt.toProvinceName(geocoderResult));
            builder.withCityName(GeocoderResultMapperKt.toCityName(geocoderResult));
            builder.withDistrictName(GeocoderResultMapperKt.toDistrictName2(geocoderResult));
            builder.withSubdistrictName(GeocoderResultMapperKt.toSubDistrictName(geocoderResult));
            just = Observable.just(builder.create());
        }
        return just;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Location> getLocationFromLocationName(String locationName) {
        Intrinsics.checkNotNullParameter(locationName, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Address> getReverseGeocodeByLoc(Location location) {
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

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Boolean> saveLatestLocationSubdisivision(LocationSubdisivision locationSubdisivision) {
        Intrinsics.checkNotNullParameter(locationSubdisivision, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<LocationSubdisivision> getLatestLocationSubdisivision() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<String> getCountryCodeByLocation(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "");
        StringBuilder sb = new StringBuilder();
        sb.append(latLng.getLatitude());
        sb.append(',');
        sb.append(latLng.getLongitude());
        Observable flatMap = this.geocoderApi.reverseGeocode(sb.toString(), "AIzaSyBr8axhuN2K9uREP6j4SjOmbp8OsDnrdC8").flatMap(new Function() { // from class: id.dana.data.geocode.repository.source.network.NetworkGeocodeEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1303getCountryCodeByLocation$lambda9;
                m1303getCountryCodeByLocation$lambda9 = NetworkGeocodeEntityData.m1303getCountryCodeByLocation$lambda9((GeocoderResult) obj);
                return m1303getCountryCodeByLocation$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCountryCodeByLocation$lambda-9  reason: not valid java name */
    public static final ObservableSource m1303getCountryCodeByLocation$lambda9(GeocoderResult geocoderResult) {
        Observable just;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        if (!Intrinsics.areEqual(geocoderResult.getStatus(), STATUS_OK)) {
            just = Observable.error(new Throwable(geocoderResult.getStatus()));
        } else {
            just = Observable.just(GeoCodeParser.INSTANCE.getCountryCode(geocoderResult));
        }
        return just;
    }
}
