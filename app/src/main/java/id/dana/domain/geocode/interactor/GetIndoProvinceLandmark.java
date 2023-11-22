package id.dana.domain.geocode.interactor;

import android.location.Location;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.interactor.GetIndoProvinceLandmark;
import id.dana.domain.geocode.mapper.ProvinceNameMapper;
import id.dana.domain.geocode.model.GeocodeReverseConfig;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/domain/geocode/interactor/GetIndoProvinceLandmark;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/geocode/interactor/GetIndoProvinceLandmark$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/geocode/interactor/GetIndoProvinceLandmark$Params;)Lio/reactivex/Observable;", "Landroid/location/Location;", "location", "", "shouldCallHEREGeocodeAPI", "isGpsMockedForUnderLollipop", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "getIndoProvince", "(Landroid/location/Location;ZZLid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "getLatestProvinceLandmark", "()Lio/reactivex/Observable;", "Lid/dana/domain/geocode/GeocodeRepository;", "geocodeRepository", "Lid/dana/domain/geocode/GeocodeRepository;", "<init>", "(Lid/dana/domain/geocode/GeocodeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetIndoProvinceLandmark extends BaseUseCase<String, Params> {
    private final GeocodeRepository geocodeRepository;

    @Inject
    public GetIndoProvinceLandmark(GeocodeRepository geocodeRepository) {
        Intrinsics.checkNotNullParameter(geocodeRepository, "");
        this.geocodeRepository = geocodeRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<String> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable switchMap = this.geocodeRepository.getGeocodeReverseConfig().switchMap(new Function() { // from class: id.dana.domain.geocode.interactor.GetIndoProvinceLandmark$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2339buildUseCase$lambda0;
                m2339buildUseCase$lambda0 = GetIndoProvinceLandmark.m2339buildUseCase$lambda0(GetIndoProvinceLandmark.Params.this, this, (GeocodeReverseConfig) obj);
                return m2339buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        return switchMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2339buildUseCase$lambda0(Params params, GetIndoProvinceLandmark getIndoProvinceLandmark, GeocodeReverseConfig geocodeReverseConfig) {
        Observable<String> indoProvince;
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(getIndoProvinceLandmark, "");
        Intrinsics.checkNotNullParameter(geocodeReverseConfig, "");
        if (params.getLocation() == null) {
            indoProvince = getIndoProvinceLandmark.getLatestProvinceLandmark();
        } else {
            indoProvince = getIndoProvinceLandmark.getIndoProvince(params.getLocation(), geocodeReverseConfig.getShouldCallHEREGeocodeAPI(), params.isGpsMockedForUnderLollipop(), params.getHereMixPanelTrackerData());
        }
        return indoProvince;
    }

    private final Observable<String> getIndoProvince(Location location, boolean shouldCallHEREGeocodeAPI, boolean isGpsMockedForUnderLollipop, HereMixPanelTrackerData hereMixPanelTrackerData) {
        Observable flatMap = this.geocodeRepository.getIndoSubdivisionsNameByLocation(location, shouldCallHEREGeocodeAPI, isGpsMockedForUnderLollipop, hereMixPanelTrackerData).flatMap(new Function() { // from class: id.dana.domain.geocode.interactor.GetIndoProvinceLandmark$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2340getIndoProvince$lambda1;
                m2340getIndoProvince$lambda1 = GetIndoProvinceLandmark.m2340getIndoProvince$lambda1(GetIndoProvinceLandmark.this, (IndoSubdivisions) obj);
                return m2340getIndoProvince$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getIndoProvince$lambda-1  reason: not valid java name */
    public static final ObservableSource m2340getIndoProvince$lambda1(GetIndoProvinceLandmark getIndoProvinceLandmark, IndoSubdivisions indoSubdivisions) {
        Observable<String> latestProvinceLandmark;
        Intrinsics.checkNotNullParameter(getIndoProvinceLandmark, "");
        Intrinsics.checkNotNullParameter(indoSubdivisions, "");
        String proviceName = indoSubdivisions.getProviceName();
        if (ProvinceNameMapper.INSTANCE.isLandmark(proviceName)) {
            getIndoProvinceLandmark.geocodeRepository.saveLatestProvinceLandmark(proviceName).blockingFirst();
            latestProvinceLandmark = Observable.just(proviceName);
            Intrinsics.checkNotNullExpressionValue(latestProvinceLandmark, "");
        } else {
            latestProvinceLandmark = getIndoProvinceLandmark.getLatestProvinceLandmark();
        }
        return latestProvinceLandmark;
    }

    private final Observable<String> getLatestProvinceLandmark() {
        Observable flatMap = this.geocodeRepository.getLatestProvinceLandmark().flatMap(new Function() { // from class: id.dana.domain.geocode.interactor.GetIndoProvinceLandmark$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2341getLatestProvinceLandmark$lambda2;
                m2341getLatestProvinceLandmark$lambda2 = GetIndoProvinceLandmark.m2341getLatestProvinceLandmark$lambda2((String) obj);
                return m2341getLatestProvinceLandmark$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLatestProvinceLandmark$lambda-2  reason: not valid java name */
    public static final ObservableSource m2341getLatestProvinceLandmark$lambda2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(new Regex("[^A-Za-z0-9\\s]").replace(str, ""));
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\r\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/domain/geocode/interactor/GetIndoProvinceLandmark$Params;", "", "Landroid/location/Location;", "component1", "()Landroid/location/Location;", "", "component2", "()Z", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "component3", "()Lid/dana/domain/tracker/HereMixPanelTrackerData;", "location", "isGpsMockedForUnderLollipop", "hereMixPanelTrackerData", "copy", "(Landroid/location/Location;ZLid/dana/domain/tracker/HereMixPanelTrackerData;)Lid/dana/domain/geocode/interactor/GetIndoProvinceLandmark$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "getHereMixPanelTrackerData", "Z", "Landroid/location/Location;", "getLocation", "<init>", "(Landroid/location/Location;ZLid/dana/domain/tracker/HereMixPanelTrackerData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final HereMixPanelTrackerData hereMixPanelTrackerData;
        private final boolean isGpsMockedForUnderLollipop;
        private final Location location;

        public static /* synthetic */ Params copy$default(Params params, Location location, boolean z, HereMixPanelTrackerData hereMixPanelTrackerData, int i, Object obj) {
            if ((i & 1) != 0) {
                location = params.location;
            }
            if ((i & 2) != 0) {
                z = params.isGpsMockedForUnderLollipop;
            }
            if ((i & 4) != 0) {
                hereMixPanelTrackerData = params.hereMixPanelTrackerData;
            }
            return params.copy(location, z, hereMixPanelTrackerData);
        }

        /* renamed from: component1  reason: from getter */
        public final Location getLocation() {
            return this.location;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getIsGpsMockedForUnderLollipop() {
            return this.isGpsMockedForUnderLollipop;
        }

        /* renamed from: component3  reason: from getter */
        public final HereMixPanelTrackerData getHereMixPanelTrackerData() {
            return this.hereMixPanelTrackerData;
        }

        public final Params copy(Location location, boolean isGpsMockedForUnderLollipop, HereMixPanelTrackerData hereMixPanelTrackerData) {
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            return new Params(location, isGpsMockedForUnderLollipop, hereMixPanelTrackerData);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.location, params.location) && this.isGpsMockedForUnderLollipop == params.isGpsMockedForUnderLollipop && Intrinsics.areEqual(this.hereMixPanelTrackerData, params.hereMixPanelTrackerData);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            Location location = this.location;
            int hashCode = location == null ? 0 : location.hashCode();
            boolean z = this.isGpsMockedForUnderLollipop;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((hashCode * 31) + i) * 31) + this.hereMixPanelTrackerData.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(location=");
            sb.append(this.location);
            sb.append(", isGpsMockedForUnderLollipop=");
            sb.append(this.isGpsMockedForUnderLollipop);
            sb.append(", hereMixPanelTrackerData=");
            sb.append(this.hereMixPanelTrackerData);
            sb.append(')');
            return sb.toString();
        }

        public Params(Location location, boolean z, HereMixPanelTrackerData hereMixPanelTrackerData) {
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            this.location = location;
            this.isGpsMockedForUnderLollipop = z;
            this.hereMixPanelTrackerData = hereMixPanelTrackerData;
        }

        public /* synthetic */ Params(Location location, boolean z, HereMixPanelTrackerData hereMixPanelTrackerData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(location, (i & 2) != 0 ? false : z, hereMixPanelTrackerData);
        }

        @JvmName(name = "getLocation")
        public final Location getLocation() {
            return this.location;
        }

        @JvmName(name = "isGpsMockedForUnderLollipop")
        public final boolean isGpsMockedForUnderLollipop() {
            return this.isGpsMockedForUnderLollipop;
        }

        @JvmName(name = "getHereMixPanelTrackerData")
        public final HereMixPanelTrackerData getHereMixPanelTrackerData() {
            return this.hereMixPanelTrackerData;
        }
    }
}
