package id.dana.domain.nearbyplaces.interactor;

import android.location.Location;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyplaces/interactor/GetListNearbyLocation;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "Lid/dana/domain/nearbyplaces/interactor/GetListNearbyLocation$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/nearbyplaces/interactor/GetListNearbyLocation$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;", "nearbyPlaceRepository", "Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;", "<init>", "(Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetListNearbyLocation extends BaseUseCase<List<? extends NearbyLocation>, Params> {
    private final NearbyPlaceRepository nearbyPlaceRepository;

    @Inject
    public GetListNearbyLocation(NearbyPlaceRepository nearbyPlaceRepository) {
        Intrinsics.checkNotNullParameter(nearbyPlaceRepository, "");
        this.nearbyPlaceRepository = nearbyPlaceRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<NearbyLocation>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return NearbyPlaceRepository.CC.getListNearbyLocations$default(this.nearbyPlaceRepository, params.getKeyword(), params.getLocation(), params.getUuid(), null, params.getHereMixPanelTrackerData(), 8, null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyplaces/interactor/GetListNearbyLocation$Params;", "", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "getHereMixPanelTrackerData", "()Lid/dana/domain/tracker/HereMixPanelTrackerData;", "", "keyword", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "Landroid/location/Location;", "location", "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "uuid", "getUuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/location/Location;Lid/dana/domain/tracker/HereMixPanelTrackerData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final HereMixPanelTrackerData hereMixPanelTrackerData;
        private final String keyword;
        private final Location location;
        private final String uuid;

        public Params(String str, String str2, Location location, HereMixPanelTrackerData hereMixPanelTrackerData) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(location, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            this.uuid = str;
            this.keyword = str2;
            this.location = location;
            this.hereMixPanelTrackerData = hereMixPanelTrackerData;
        }

        @JvmName(name = "getHereMixPanelTrackerData")
        public final HereMixPanelTrackerData getHereMixPanelTrackerData() {
            return this.hereMixPanelTrackerData;
        }

        @JvmName(name = "getKeyword")
        public final String getKeyword() {
            return this.keyword;
        }

        @JvmName(name = "getLocation")
        public final Location getLocation() {
            return this.location;
        }

        @JvmName(name = "getUuid")
        public final String getUuid() {
            return this.uuid;
        }
    }
}
