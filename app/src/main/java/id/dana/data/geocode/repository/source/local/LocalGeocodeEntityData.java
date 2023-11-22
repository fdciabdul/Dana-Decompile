package id.dana.data.geocode.repository.source.local;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.text.TextUtils;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.geocode.repository.source.GeocodeEntityData;
import id.dana.data.here.AddressNotFoundException;
import id.dana.data.storage.GeneralPreferences;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.utils.exception.CallableReturnNullError;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00012B!\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b0\u00101J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u0012J\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\t2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\t2\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\u0019R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Lid/dana/data/geocode/repository/source/local/LocalGeocodeEntityData;", "Lid/dana/data/geocode/repository/source/GeocodeEntityData;", "Landroid/location/Location;", "location", "Landroid/location/Address;", "getAddressFromGeocoderNative", "(Landroid/location/Location;)Landroid/location/Address;", "Lid/dana/domain/globalsearch/model/LatLng;", "latLng", "Lio/reactivex/Observable;", "", "getCountryCodeByLocation", "(Lid/dana/domain/globalsearch/model/LatLng;)Lio/reactivex/Observable;", "getDistrictName", "(Landroid/location/Location;)Ljava/lang/String;", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "getDistrictNameByLocation", "(Landroid/location/Location;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "getLatestLocationSubdisivision", "()Lio/reactivex/Observable;", "getLatestProvinceLandmark", BridgeName.LOCATION_NAME, "getLocationFromLocationName", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/miniprogram/model/Address;", "getReverseGeocodeByLoc", "(Landroid/location/Location;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "getSubdivisionsFromGeocoder", "locationSubdisivision", "", "saveLatestLocationSubdisivision", "(Lid/dana/domain/geocode/model/LocationSubdisivision;)Lio/reactivex/Observable;", "provinceName", "saveLatestProvinceLandmark", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "emptyCountryCodeMessage", "Ljava/lang/String;", "Lid/dana/data/storage/GeneralPreferences;", "generalPreferences", "Lid/dana/data/storage/GeneralPreferences;", "Lid/dana/data/geocode/repository/source/local/LatestProvinceLandmarkPreferences;", "latestProvinceLandmarkPreferences", "Lid/dana/data/geocode/repository/source/local/LatestProvinceLandmarkPreferences;", "<init>", "(Lid/dana/data/storage/GeneralPreferences;Lid/dana/data/geocode/repository/source/local/LatestProvinceLandmarkPreferences;Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalGeocodeEntityData implements GeocodeEntityData {
    public static final String LATEST_LOCATION_INDO_SUBDIVISION = "LATEST_LOCATION_INDO_SUBDIVISION";
    private final Context context;
    private final String emptyCountryCodeMessage;
    private final GeneralPreferences generalPreferences;
    private final LatestProvinceLandmarkPreferences latestProvinceLandmarkPreferences;

    @Inject
    public LocalGeocodeEntityData(GeneralPreferences generalPreferences, LatestProvinceLandmarkPreferences latestProvinceLandmarkPreferences, Context context) {
        Intrinsics.checkNotNullParameter(generalPreferences, "");
        Intrinsics.checkNotNullParameter(latestProvinceLandmarkPreferences, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.generalPreferences = generalPreferences;
        this.latestProvinceLandmarkPreferences = latestProvinceLandmarkPreferences;
        this.context = context;
        this.emptyCountryCodeMessage = "empty countryCode";
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<String> getDistrictNameByLocation(final Location location, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Observable<String> onErrorReturnItem = Observable.fromCallable(new Callable() { // from class: id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String m1298getDistrictNameByLocation$lambda0;
                m1298getDistrictNameByLocation$lambda0 = LocalGeocodeEntityData.m1298getDistrictNameByLocation$lambda0(LocalGeocodeEntityData.this, location);
                return m1298getDistrictNameByLocation$lambda0;
            }
        }).onErrorReturnItem("");
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDistrictNameByLocation$lambda-0  reason: not valid java name */
    public static final String m1298getDistrictNameByLocation$lambda0(LocalGeocodeEntityData localGeocodeEntityData, Location location) {
        Intrinsics.checkNotNullParameter(localGeocodeEntityData, "");
        Intrinsics.checkNotNullParameter(location, "");
        String districtName = localGeocodeEntityData.getDistrictName(location);
        if (districtName != null) {
            return districtName;
        }
        throw new CallableReturnNullError("LocalGeocodeEntityData#getDistrictNameByLocation");
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Location> getLocationFromLocationName(String locationName) {
        Intrinsics.checkNotNullParameter(locationName, "");
        Address address = null;
        try {
            List<Address> fromLocationName = new Geocoder(this.context, Locale.getDefault()).getFromLocationName(locationName, 1);
            if (fromLocationName != null) {
                address = fromLocationName.get(0);
            }
        } catch (IOException e) {
            e.getMessage();
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.NEARBY_LOCATION, sb.toString(), e);
        }
        if (address != null && address.hasLatitude() && address.hasLongitude()) {
            Location location = new Location("");
            location.setLatitude(address.getLatitude());
            location.setLongitude(address.getLongitude());
            Observable<Location> just = Observable.just(location);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<Location> error = Observable.error(new AddressNotFoundException());
        Intrinsics.checkNotNullExpressionValue(error, "");
        return error;
    }

    private final String getDistrictName(Location location) {
        List<Address> fromLocation = new Geocoder(this.context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        Address address = fromLocation != null ? fromLocation.get(0) : null;
        String subLocality = address != null ? address.getSubLocality() : null;
        return subLocality == null ? "" : subLocality;
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<IndoSubdivisions> getSubdivisionsFromGeocoder(final Location location, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Observable<IndoSubdivisions> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                IndoSubdivisions m1301getSubdivisionsFromGeocoder$lambda9;
                m1301getSubdivisionsFromGeocoder$lambda9 = LocalGeocodeEntityData.m1301getSubdivisionsFromGeocoder$lambda9(LocalGeocodeEntityData.this, location);
                return m1301getSubdivisionsFromGeocoder$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSubdivisionsFromGeocoder$lambda-9  reason: not valid java name */
    public static final IndoSubdivisions m1301getSubdivisionsFromGeocoder$lambda9(LocalGeocodeEntityData localGeocodeEntityData, Location location) {
        Intrinsics.checkNotNullParameter(localGeocodeEntityData, "");
        Intrinsics.checkNotNullParameter(location, "");
        IndoSubdivisions.Builder builder = new IndoSubdivisions.Builder();
        Address addressFromGeocoderNative = localGeocodeEntityData.getAddressFromGeocoderNative(location);
        if (addressFromGeocoderNative != null) {
            String countryCode = addressFromGeocoderNative.getCountryCode();
            if (countryCode != null) {
                Intrinsics.checkNotNullExpressionValue(countryCode, "");
                builder.withCountryCode(countryCode);
            }
            String countryName = addressFromGeocoderNative.getCountryName();
            if (countryName != null) {
                Intrinsics.checkNotNullExpressionValue(countryName, "");
                builder.withCountryName(countryName);
            }
            String adminArea = addressFromGeocoderNative.getAdminArea();
            if (adminArea != null) {
                Intrinsics.checkNotNullExpressionValue(adminArea, "");
                builder.withProvinceName(adminArea);
            }
            String subAdminArea = addressFromGeocoderNative.getSubAdminArea();
            if (subAdminArea != null) {
                Intrinsics.checkNotNullExpressionValue(subAdminArea, "");
                builder.withCityName(subAdminArea);
            }
            String locality = addressFromGeocoderNative.getLocality();
            if (locality != null) {
                Intrinsics.checkNotNullExpressionValue(locality, "");
                builder.withDistrictName(locality);
            }
            String subLocality = addressFromGeocoderNative.getSubLocality();
            if (subLocality != null) {
                Intrinsics.checkNotNullExpressionValue(subLocality, "");
                builder.withSubdistrictName(subLocality);
            }
        }
        IndoSubdivisions create = builder.create();
        if (create != null) {
            return create;
        }
        throw new CallableReturnNullError("LocalGeocodeEntityData#getSubdivisionsFromGeocoder");
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<id.dana.domain.miniprogram.model.Address> getReverseGeocodeByLoc(Location location) {
        Intrinsics.checkNotNullParameter(location, "");
        final Address addressFromGeocoderNative = getAddressFromGeocoderNative(location);
        if (addressFromGeocoderNative == null) {
            Observable<id.dana.domain.miniprogram.model.Address> error = Observable.error(new AddressNotFoundException());
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        Observable<id.dana.domain.miniprogram.model.Address> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                id.dana.domain.miniprogram.model.Address m1300getReverseGeocodeByLoc$lambda10;
                m1300getReverseGeocodeByLoc$lambda10 = LocalGeocodeEntityData.m1300getReverseGeocodeByLoc$lambda10(addressFromGeocoderNative);
                return m1300getReverseGeocodeByLoc$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReverseGeocodeByLoc$lambda-10  reason: not valid java name */
    public static final id.dana.domain.miniprogram.model.Address m1300getReverseGeocodeByLoc$lambda10(Address address) {
        String obj = address.getFeatureName().toString();
        double latitude = address.getLatitude();
        double longitude = address.getLongitude();
        return new id.dana.domain.miniprogram.model.Address(obj, String.valueOf(latitude), String.valueOf(longitude), address.getAddressLine(0).toString());
    }

    private final Address getAddressFromGeocoderNative(Location location) {
        try {
            List<Address> fromLocation = new Geocoder(this.context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation != null) {
                return fromLocation.get(0);
            }
            return null;
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GEOCODE, sb.toString(), e);
            return null;
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getClass().getName());
            sb2.append(e2.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GEOCODE, sb2.toString(), e2);
            return null;
        }
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Boolean> saveLatestLocationSubdisivision(final LocationSubdisivision locationSubdisivision) {
        Intrinsics.checkNotNullParameter(locationSubdisivision, "");
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m1302saveLatestLocationSubdisivision$lambda11;
                m1302saveLatestLocationSubdisivision$lambda11 = LocalGeocodeEntityData.m1302saveLatestLocationSubdisivision$lambda11(LocalGeocodeEntityData.this, locationSubdisivision);
                return m1302saveLatestLocationSubdisivision$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveLatestLocationSubdisivision$lambda-11  reason: not valid java name */
    public static final Boolean m1302saveLatestLocationSubdisivision$lambda11(LocalGeocodeEntityData localGeocodeEntityData, LocationSubdisivision locationSubdisivision) {
        Intrinsics.checkNotNullParameter(localGeocodeEntityData, "");
        Intrinsics.checkNotNullParameter(locationSubdisivision, "");
        return Boolean.valueOf(localGeocodeEntityData.generalPreferences.saveData(LATEST_LOCATION_INDO_SUBDIVISION, locationSubdisivision));
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<LocationSubdisivision> getLatestLocationSubdisivision() {
        Observable<LocationSubdisivision> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LocationSubdisivision m1299getLatestLocationSubdisivision$lambda12;
                m1299getLatestLocationSubdisivision$lambda12 = LocalGeocodeEntityData.m1299getLatestLocationSubdisivision$lambda12(LocalGeocodeEntityData.this);
                return m1299getLatestLocationSubdisivision$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLatestLocationSubdisivision$lambda-12  reason: not valid java name */
    public static final LocationSubdisivision m1299getLatestLocationSubdisivision$lambda12(LocalGeocodeEntityData localGeocodeEntityData) {
        Intrinsics.checkNotNullParameter(localGeocodeEntityData, "");
        LocationSubdisivision locationSubdisivision = (LocationSubdisivision) localGeocodeEntityData.generalPreferences.getObject(LATEST_LOCATION_INDO_SUBDIVISION, LocationSubdisivision.class);
        if (locationSubdisivision != null) {
            return locationSubdisivision;
        }
        throw new Exception("No cache found");
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<String> getLatestProvinceLandmark() {
        Observable<String> just = Observable.just(this.latestProvinceLandmarkPreferences.getLatestProvinceLandmark());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<Boolean> saveLatestProvinceLandmark(String provinceName) {
        Intrinsics.checkNotNullParameter(provinceName, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.latestProvinceLandmarkPreferences.saveLatestProvinceLandmark(provinceName)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.geocode.repository.source.GeocodeEntityData
    public final Observable<String> getCountryCodeByLocation(final LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "");
        Observable<String> create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.geocode.repository.source.local.LocalGeocodeEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                LocalGeocodeEntityData.m1297getCountryCodeByLocation$lambda13(LocalGeocodeEntityData.this, latLng, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCountryCodeByLocation$lambda-13  reason: not valid java name */
    public static final void m1297getCountryCodeByLocation$lambda13(LocalGeocodeEntityData localGeocodeEntityData, LatLng latLng, ObservableEmitter observableEmitter) {
        Address address;
        String str = "";
        Intrinsics.checkNotNullParameter(localGeocodeEntityData, "");
        Intrinsics.checkNotNullParameter(latLng, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        try {
            List<Address> fromLocation = new Geocoder(localGeocodeEntityData.context, Locale.getDefault()).getFromLocation(latLng.getLatitude(), latLng.getLongitude(), 1);
            String countryCode = (fromLocation == null || (address = fromLocation.get(0)) == null) ? null : address.getCountryCode();
            if (countryCode != null) {
                str = countryCode;
            }
            if (!TextUtils.isEmpty(str)) {
                observableEmitter.onNext(str);
            } else {
                observableEmitter.onError(new Throwable(localGeocodeEntityData.emptyCountryCodeMessage));
            }
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(localGeocodeEntityData.getClass().getName());
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(localGeocodeEntityData.getClass().getName());
            sb2.append(InputCardNumberView.DIVIDER);
            sb2.append(e.getMessage());
            observableEmitter.onError(new Throwable(sb2.toString()));
        }
    }
}
