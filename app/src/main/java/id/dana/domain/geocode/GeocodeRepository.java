package id.dana.domain.geocode;

import android.location.Location;
import id.dana.domain.geocode.model.GeocodeReverseConfig;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\u0013\u0010\fJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006H&¢\u0006\u0004\b\u0015\u0010\fJ\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0019\u001a\u00020\u0007H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u001c\u001a\u00020\u0014H&¢\u0006\u0004\b\u001d\u0010\u001eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/geocode/GeocodeRepository;", "", "Landroid/location/Location;", "location", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lio/reactivex/Observable;", "", "getDistrictNameByLocation", "(Landroid/location/Location;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/GeocodeReverseConfig;", "getGeocodeReverseConfig", "()Lio/reactivex/Observable;", "", "shouldCallHEREGeocodeAPI", "isGpsMockedForUnderLollipop", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "getIndoSubdivisionsNameByLocation", "(Landroid/location/Location;ZZLid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "getLatestProvinceLandmark", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "getLatestSubdivisions", "Lid/dana/domain/miniprogram/model/Address;", "getReverseGeocodeByLoc", "(Landroid/location/Location;)Lio/reactivex/Observable;", "provinceName", "saveLatestProvinceLandmark", "(Ljava/lang/String;)Lio/reactivex/Observable;", "locationSubdisivision", "saveLatestSubdivisions", "(Lid/dana/domain/geocode/model/LocationSubdisivision;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GeocodeRepository {
    Observable<String> getDistrictNameByLocation(Location location, HereMixPanelTrackerData hereMixPanelTrackerData);

    Observable<GeocodeReverseConfig> getGeocodeReverseConfig();

    Observable<IndoSubdivisions> getIndoSubdivisionsNameByLocation(Location location, boolean shouldCallHEREGeocodeAPI, boolean isGpsMockedForUnderLollipop, HereMixPanelTrackerData hereMixPanelTrackerData);

    Observable<String> getLatestProvinceLandmark();

    Observable<LocationSubdisivision> getLatestSubdivisions();

    Observable<Address> getReverseGeocodeByLoc(Location location);

    Observable<Boolean> saveLatestProvinceLandmark(String provinceName);

    Observable<Boolean> saveLatestSubdivisions(LocationSubdisivision locationSubdisivision);
}
