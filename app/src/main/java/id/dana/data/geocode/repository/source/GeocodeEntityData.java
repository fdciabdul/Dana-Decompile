package id.dana.data.geocode.repository.source;

import android.location.Location;
import id.dana.danah5.constant.BridgeName;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0019\u0010\rJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u001a\u001a\u00020\u000eH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u001e\u001a\u00020\u0005H&¢\u0006\u0004\b\u001f\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/geocode/repository/source/GeocodeEntityData;", "", "Lid/dana/domain/globalsearch/model/LatLng;", "latLng", "Lio/reactivex/Observable;", "", "getCountryCodeByLocation", "(Lid/dana/domain/globalsearch/model/LatLng;)Lio/reactivex/Observable;", "Landroid/location/Location;", "location", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "getDistrictNameByLocation", "(Landroid/location/Location;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "getLatestLocationSubdisivision", "()Lio/reactivex/Observable;", "getLatestProvinceLandmark", BridgeName.LOCATION_NAME, "getLocationFromLocationName", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/miniprogram/model/Address;", "getReverseGeocodeByLoc", "(Landroid/location/Location;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "getSubdivisionsFromGeocoder", "locationSubdisivision", "", "saveLatestLocationSubdisivision", "(Lid/dana/domain/geocode/model/LocationSubdisivision;)Lio/reactivex/Observable;", "provinceName", "saveLatestProvinceLandmark"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GeocodeEntityData {
    Observable<String> getCountryCodeByLocation(LatLng latLng);

    Observable<String> getDistrictNameByLocation(Location location, HereMixPanelTrackerData hereMixPanelTrackerData);

    Observable<LocationSubdisivision> getLatestLocationSubdisivision();

    Observable<String> getLatestProvinceLandmark();

    Observable<Location> getLocationFromLocationName(String r1);

    Observable<Address> getReverseGeocodeByLoc(Location location);

    Observable<IndoSubdivisions> getSubdivisionsFromGeocoder(Location location, HereMixPanelTrackerData hereMixPanelTrackerData);

    Observable<Boolean> saveLatestLocationSubdisivision(LocationSubdisivision locationSubdisivision);

    Observable<Boolean> saveLatestProvinceLandmark(String provinceName);
}
