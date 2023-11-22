package id.dana.domain.nearbyme.interactor;

import android.location.Location;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetDistrictNameByLocation;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/nearbyme/interactor/GetDistrictNameByLocation$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/GetDistrictNameByLocation$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/GeocodeRepository;", "geocodeRepository", "Lid/dana/domain/geocode/GeocodeRepository;", "<init>", "(Lid/dana/domain/geocode/GeocodeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetDistrictNameByLocation extends BaseUseCase<String, Params> {
    private final GeocodeRepository geocodeRepository;

    @Inject
    public GetDistrictNameByLocation(GeocodeRepository geocodeRepository) {
        Intrinsics.checkNotNullParameter(geocodeRepository, "");
        this.geocodeRepository = geocodeRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<String> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.geocodeRepository.getDistrictNameByLocation(params.getLocation(), params.getHereMixPanelTrackerData());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetDistrictNameByLocation$Params;", "", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "getHereMixPanelTrackerData", "()Lid/dana/domain/tracker/HereMixPanelTrackerData;", "Landroid/location/Location;", "location", "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "<init>", "(Landroid/location/Location;Lid/dana/domain/tracker/HereMixPanelTrackerData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final HereMixPanelTrackerData hereMixPanelTrackerData;
        private final Location location;

        public Params(Location location, HereMixPanelTrackerData hereMixPanelTrackerData) {
            Intrinsics.checkNotNullParameter(location, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            this.location = location;
            this.hereMixPanelTrackerData = hereMixPanelTrackerData;
        }

        @JvmName(name = "getHereMixPanelTrackerData")
        public final HereMixPanelTrackerData getHereMixPanelTrackerData() {
            return this.hereMixPanelTrackerData;
        }

        @JvmName(name = "getLocation")
        public final Location getLocation() {
            return this.location;
        }
    }
}
