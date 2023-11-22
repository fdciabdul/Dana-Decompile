package id.dana.domain.miniprogram.interactor;

import android.location.Location;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.miniprogram.model.Address;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/miniprogram/model/Address;", "Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/GeocodeRepository;", "geocodeRepository", "Lid/dana/domain/geocode/GeocodeRepository;", "<init>", "(Lid/dana/domain/geocode/GeocodeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetReverseGeocodeByLocation extends BaseUseCase<Address, Params> {
    private final GeocodeRepository geocodeRepository;

    @Inject
    public GetReverseGeocodeByLocation(GeocodeRepository geocodeRepository) {
        Intrinsics.checkNotNullParameter(geocodeRepository, "");
        this.geocodeRepository = geocodeRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation$Params;", "", "Landroid/location/Location;", "location", "Landroid/location/Location;", "getLocation$domain_productionRelease", "()Landroid/location/Location;", "<init>", "(Landroid/location/Location;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Location location;

        public /* synthetic */ Params(Location location, DefaultConstructorMarker defaultConstructorMarker) {
            this(location);
        }

        @JvmStatic
        public static final Params create(Location location) {
            return INSTANCE.create(location);
        }

        private Params(Location location) {
            this.location = location;
        }

        @JvmName(name = "getLocation$domain_productionRelease")
        /* renamed from: getLocation$domain_productionRelease  reason: from getter */
        public final Location getLocation() {
            return this.location;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation$Params$Companion;", "", "Landroid/location/Location;", "location", "Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Landroid/location/Location;)Lid/dana/domain/miniprogram/interactor/GetReverseGeocodeByLocation$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params create(Location location) {
                Intrinsics.checkNotNullParameter(location, "");
                return new Params(location, null);
            }
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Address> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.geocodeRepository.getReverseGeocodeByLoc(params.getLocation());
    }
}
