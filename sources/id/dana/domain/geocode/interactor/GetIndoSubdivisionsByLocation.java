package id.dana.domain.geocode.interactor;

import android.location.Location;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.LocationOutOfBoundsException;
import id.dana.domain.geocode.model.GeocodeReverseConfig;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.domain.util.LocationUtil;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Calendar;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002/0B!\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b-\u0010.J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u0010*\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010("}, d2 = {"Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/geocode/model/GeocodeReverseConfig;", "config", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "localLocationSubdisivision", "compareWithLocal", "(Lid/dana/domain/geocode/model/GeocodeReverseConfig;Lid/dana/domain/geocode/model/LocationSubdisivision;Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;)Lio/reactivex/Observable;", "Landroid/location/Location;", "location", "", "shouldCallHEREGeocodeAPI", "isGpsMockedForUnderLollipop", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "getIndoSubdivision", "(Landroid/location/Location;ZZLid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "getSubdivisionByDistanceDiffer", "(Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;Lid/dana/domain/geocode/model/LocationSubdisivision;Lid/dana/domain/geocode/model/GeocodeReverseConfig;)Lio/reactivex/Observable;", "getSubdivisionByTimeDiffer", "(Lid/dana/domain/geocode/model/LocationSubdisivision;Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;Lid/dana/domain/geocode/model/GeocodeReverseConfig;)Lio/reactivex/Observable;", "", "cachedTimeStamp", "isNewMonth", "(J)Z", "time", "maxHours", "(J)J", "validateLocation", "(Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;)Z", "isAlreadyPast", "(JJ)Z", "Lid/dana/domain/geocode/GeocodeRepository;", "geocodeRepository", "Lid/dana/domain/geocode/GeocodeRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/geocode/GeocodeRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetIndoSubdivisionsByLocation extends UseCase<IndoSubdivisions, Params> {
    public static final long HOUR_IN_MILLIS = 3600000;
    public static final long MAX_HOURS = 720;
    private final GeocodeRepository geocodeRepository;

    private final long maxHours(long time) {
        if (time > 720) {
            return 720L;
        }
        return time;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetIndoSubdivisionsByLocation(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeocodeRepository geocodeRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(geocodeRepository, "");
        this.geocodeRepository = geocodeRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<IndoSubdivisions> buildUseCaseObservable(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (validateLocation(params)) {
            Observable<IndoSubdivisions> error = Observable.error(new LocationOutOfBoundsException());
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        Observable switchMap = this.geocodeRepository.getGeocodeReverseConfig().switchMap(new Function() { // from class: id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2342buildUseCaseObservable$lambda1;
                m2342buildUseCaseObservable$lambda1 = GetIndoSubdivisionsByLocation.m2342buildUseCaseObservable$lambda1(GetIndoSubdivisionsByLocation.this, params, (GeocodeReverseConfig) obj);
                return m2342buildUseCaseObservable$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        return switchMap;
    }

    /* renamed from: buildUseCaseObservable$lambda-1 */
    public static final ObservableSource m2342buildUseCaseObservable$lambda1(GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation, final Params params, final GeocodeReverseConfig geocodeReverseConfig) {
        Intrinsics.checkNotNullParameter(getIndoSubdivisionsByLocation, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(geocodeReverseConfig, "");
        return getIndoSubdivisionsByLocation.geocodeRepository.getLatestSubdivisions().switchMap(new Function() { // from class: id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2343buildUseCaseObservable$lambda1$lambda0;
                m2343buildUseCaseObservable$lambda1$lambda0 = GetIndoSubdivisionsByLocation.m2343buildUseCaseObservable$lambda1$lambda0(GetIndoSubdivisionsByLocation.this, params, geocodeReverseConfig, (LocationSubdisivision) obj);
                return m2343buildUseCaseObservable$lambda1$lambda0;
            }
        });
    }

    /* renamed from: buildUseCaseObservable$lambda-1$lambda-0 */
    public static final ObservableSource m2343buildUseCaseObservable$lambda1$lambda0(GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation, Params params, GeocodeReverseConfig geocodeReverseConfig, LocationSubdisivision locationSubdisivision) {
        Observable<IndoSubdivisions> compareWithLocal;
        Intrinsics.checkNotNullParameter(getIndoSubdivisionsByLocation, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(geocodeReverseConfig, "");
        Intrinsics.checkNotNullParameter(locationSubdisivision, "");
        if (locationSubdisivision.isEmpty()) {
            compareWithLocal = getIndoSubdivisionsByLocation.getIndoSubdivision(params.getLocation(), geocodeReverseConfig.getShouldCallHEREGeocodeAPI(), params.getIsGpsMockedForUnderLollipop(), params.getHereMixPanelTrackerData());
        } else {
            compareWithLocal = getIndoSubdivisionsByLocation.compareWithLocal(geocodeReverseConfig, locationSubdisivision, params);
        }
        return compareWithLocal;
    }

    private final boolean validateLocation(Params params) {
        double longitude = params.getLocation().getLongitude();
        if (-180.0d <= longitude && longitude <= 180.0d) {
            double latitude = params.getLocation().getLatitude();
            if (-90.0d <= latitude && latitude <= 90.0d) {
                return false;
            }
        }
        return true;
    }

    private final Observable<IndoSubdivisions> compareWithLocal(GeocodeReverseConfig config, LocationSubdisivision localLocationSubdisivision, Params params) {
        if (!params.getUseTimeDiffer()) {
            return getSubdivisionByDistanceDiffer(params, localLocationSubdisivision, config);
        }
        return getSubdivisionByTimeDiffer(localLocationSubdisivision, params, config);
    }

    private final Observable<IndoSubdivisions> getSubdivisionByTimeDiffer(LocationSubdisivision localLocationSubdisivision, Params params, GeocodeReverseConfig config) {
        if (config.getIntervalInHours() <= 0) {
            return getSubdivisionByDistanceDiffer(params, localLocationSubdisivision, config);
        }
        if (isAlreadyPast(localLocationSubdisivision.getTimestamp(), config.getIntervalInHours())) {
            return getIndoSubdivision(params.getLocation(), config.getShouldCallHEREGeocodeAPI(), params.getIsGpsMockedForUnderLollipop(), params.getHereMixPanelTrackerData());
        }
        Observable<IndoSubdivisions> just = Observable.just(localLocationSubdisivision.getIndoSubdivisions());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final Observable<IndoSubdivisions> getSubdivisionByDistanceDiffer(Params params, LocationSubdisivision localLocationSubdisivision, GeocodeReverseConfig config) {
        if (Float.parseFloat(config.getDistanceInMeters()) < params.getLocation().distanceTo(LocationUtil.latLonToLocation(Double.parseDouble(localLocationSubdisivision.getLatitude()), Double.parseDouble(localLocationSubdisivision.getLongitude()))) || isNewMonth(localLocationSubdisivision.getTimestamp()) || params.getSkipDistanceChecking()) {
            return getIndoSubdivision(params.getLocation(), config.getShouldCallHEREGeocodeAPI(), params.getIsGpsMockedForUnderLollipop(), params.getHereMixPanelTrackerData());
        }
        Observable<IndoSubdivisions> just = Observable.just(localLocationSubdisivision.getIndoSubdivisions());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final boolean isNewMonth(long cachedTimeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(cachedTimeStamp);
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(1) < calendar2.get(1) || calendar.get(2) < calendar2.get(2);
    }

    private final boolean isAlreadyPast(long j, long j2) {
        return (System.currentTimeMillis() - j) / 3600000 > maxHours(j2);
    }

    private final Observable<IndoSubdivisions> getIndoSubdivision(final Location location, boolean shouldCallHEREGeocodeAPI, boolean isGpsMockedForUnderLollipop, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Observable flatMap = this.geocodeRepository.getIndoSubdivisionsNameByLocation(location, shouldCallHEREGeocodeAPI, isGpsMockedForUnderLollipop, hereMixPanelTrackerData).flatMap(new Function() { // from class: id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2344getIndoSubdivision$lambda2;
                m2344getIndoSubdivision$lambda2 = GetIndoSubdivisionsByLocation.m2344getIndoSubdivision$lambda2(GetIndoSubdivisionsByLocation.this, location, (IndoSubdivisions) obj);
                return m2344getIndoSubdivision$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getIndoSubdivision$lambda-2 */
    public static final ObservableSource m2344getIndoSubdivision$lambda2(GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation, Location location, IndoSubdivisions indoSubdivisions) {
        Intrinsics.checkNotNullParameter(getIndoSubdivisionsByLocation, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(indoSubdivisions, "");
        GeocodeRepository geocodeRepository = getIndoSubdivisionsByLocation.geocodeRepository;
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        geocodeRepository.saveLatestSubdivisions(new LocationSubdisivision(String.valueOf(latitude), String.valueOf(longitude), indoSubdivisions, System.currentTimeMillis())).blockingFirst();
        return Observable.just(indoSubdivisions);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B5\b\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b"}, d2 = {"Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;", "", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "getHereMixPanelTrackerData$domain_productionRelease", "()Lid/dana/domain/tracker/HereMixPanelTrackerData;", "", "isGpsMockedForUnderLollipop", "Z", "isGpsMockedForUnderLollipop$domain_productionRelease", "()Z", "Landroid/location/Location;", "location", "Landroid/location/Location;", "getLocation$domain_productionRelease", "()Landroid/location/Location;", "skipDistanceChecking", "getSkipDistanceChecking$domain_productionRelease", "useTimeDiffer", "getUseTimeDiffer$domain_productionRelease", "<init>", "(Landroid/location/Location;ZZZLid/dana/domain/tracker/HereMixPanelTrackerData;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final HereMixPanelTrackerData hereMixPanelTrackerData;
        private final boolean isGpsMockedForUnderLollipop;
        private final Location location;
        private final boolean skipDistanceChecking;
        private final boolean useTimeDiffer;

        public /* synthetic */ Params(Location location, boolean z, boolean z2, boolean z3, HereMixPanelTrackerData hereMixPanelTrackerData, DefaultConstructorMarker defaultConstructorMarker) {
            this(location, z, z2, z3, hereMixPanelTrackerData);
        }

        @JvmStatic
        public static final Params forLocation(Location location, boolean z, boolean z2, HereMixPanelTrackerData hereMixPanelTrackerData, boolean z3) {
            return INSTANCE.forLocation(location, z, z2, hereMixPanelTrackerData, z3);
        }

        private Params(Location location, boolean z, boolean z2, boolean z3, HereMixPanelTrackerData hereMixPanelTrackerData) {
            this.location = location;
            this.useTimeDiffer = z;
            this.isGpsMockedForUnderLollipop = z2;
            this.skipDistanceChecking = z3;
            this.hereMixPanelTrackerData = hereMixPanelTrackerData;
        }

        /* synthetic */ Params(Location location, boolean z, boolean z2, boolean z3, HereMixPanelTrackerData hereMixPanelTrackerData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(location, z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, hereMixPanelTrackerData);
        }

        @JvmName(name = "getLocation$domain_productionRelease")
        /* renamed from: getLocation$domain_productionRelease  reason: from getter */
        public final Location getLocation() {
            return this.location;
        }

        @JvmName(name = "getUseTimeDiffer$domain_productionRelease")
        /* renamed from: getUseTimeDiffer$domain_productionRelease  reason: from getter */
        public final boolean getUseTimeDiffer() {
            return this.useTimeDiffer;
        }

        @JvmName(name = "isGpsMockedForUnderLollipop$domain_productionRelease")
        /* renamed from: isGpsMockedForUnderLollipop$domain_productionRelease  reason: from getter */
        public final boolean getIsGpsMockedForUnderLollipop() {
            return this.isGpsMockedForUnderLollipop;
        }

        @JvmName(name = "getSkipDistanceChecking$domain_productionRelease")
        /* renamed from: getSkipDistanceChecking$domain_productionRelease  reason: from getter */
        public final boolean getSkipDistanceChecking() {
            return this.skipDistanceChecking;
        }

        @JvmName(name = "getHereMixPanelTrackerData$domain_productionRelease")
        /* renamed from: getHereMixPanelTrackerData$domain_productionRelease  reason: from getter */
        public final HereMixPanelTrackerData getHereMixPanelTrackerData() {
            return this.hereMixPanelTrackerData;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params$Companion;", "", "Landroid/location/Location;", "location", "", "useTimeDiffer", "isGpsMockedForUnderLollipop", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "skipDistanceChecking", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;", "forLocation", "(Landroid/location/Location;ZZLid/dana/domain/tracker/HereMixPanelTrackerData;Z)Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forLocation(Location location, boolean useTimeDiffer, boolean isGpsMockedForUnderLollipop, HereMixPanelTrackerData hereMixPanelTrackerData, boolean skipDistanceChecking) {
                Intrinsics.checkNotNullParameter(location, "");
                Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
                return new Params(location, useTimeDiffer, isGpsMockedForUnderLollipop, skipDistanceChecking, hereMixPanelTrackerData, null);
            }
        }
    }
}
