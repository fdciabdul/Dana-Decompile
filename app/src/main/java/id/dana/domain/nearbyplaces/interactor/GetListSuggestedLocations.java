package id.dana.domain.nearbyplaces.interactor;

import android.location.Location;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import id.dana.domain.nearbyplaces.model.SuggestedLocation;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.domain.util.LocationUtil;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u000e\u000fB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/nearbyplaces/model/SuggestedLocation;", "Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;", "nearbyPlaceRepository", "Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;", "<init>", "(Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetListSuggestedLocations extends BaseUseCase<List<? extends SuggestedLocation>, Params> {
    private static final double DEFAULT_LAT_LONG = 0.0d;
    private final NearbyPlaceRepository nearbyPlaceRepository;

    @Inject
    public GetListSuggestedLocations(NearbyPlaceRepository nearbyPlaceRepository) {
        Intrinsics.checkNotNullParameter(nearbyPlaceRepository, "");
        this.nearbyPlaceRepository = nearbyPlaceRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<SuggestedLocation>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Double latitude = params.getLatitude();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double doubleValue = latitude != null ? latitude.doubleValue() : 0.0d;
        Double longitude = params.getLongitude();
        if (longitude != null) {
            d = longitude.doubleValue();
        }
        Location latLonToLocation = LocationUtil.latLonToLocation(doubleValue, d);
        HereMixPanelTrackerData hereMixPanelTrackerData = new HereMixPanelTrackerData(null, null, false, null, null, 31, null);
        String source = params.getSource();
        if (source == null) {
            source = "JSAPI";
        }
        hereMixPanelTrackerData.setSource(source);
        return this.nearbyPlaceRepository.getListSuggestedLocations(params.getKeyword(), latLonToLocation, params.getUuid(), Integer.valueOf(params.getLimit()), hereMixPanelTrackerData);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JR\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001a\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\"\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "", "component4", "()Ljava/lang/Double;", "component5", "component6", "uuid", "keyword", HereUrlConstant.LIMIT, "latitude", "longitude", "source", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getKeyword", "Ljava/lang/Double;", "getLatitude", "I", "getLimit", "getLongitude", "getSource", "getUuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Params {
        private final String keyword;
        private final Double latitude;
        private final int limit;
        private final Double longitude;
        private final String source;
        private final String uuid;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, int i, Double d, Double d2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = params.uuid;
            }
            if ((i2 & 2) != 0) {
                str2 = params.keyword;
            }
            String str4 = str2;
            if ((i2 & 4) != 0) {
                i = params.limit;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                d = params.latitude;
            }
            Double d3 = d;
            if ((i2 & 16) != 0) {
                d2 = params.longitude;
            }
            Double d4 = d2;
            if ((i2 & 32) != 0) {
                str3 = params.source;
            }
            return params.copy(str, str4, i3, d3, d4, str3);
        }

        /* renamed from: component1  reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        /* renamed from: component2  reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }

        /* renamed from: component3  reason: from getter */
        public final int getLimit() {
            return this.limit;
        }

        /* renamed from: component4  reason: from getter */
        public final Double getLatitude() {
            return this.latitude;
        }

        /* renamed from: component5  reason: from getter */
        public final Double getLongitude() {
            return this.longitude;
        }

        /* renamed from: component6  reason: from getter */
        public final String getSource() {
            return this.source;
        }

        public final Params copy(String uuid, String keyword, int limit, Double latitude, Double longitude, String source) {
            Intrinsics.checkNotNullParameter(uuid, "");
            Intrinsics.checkNotNullParameter(keyword, "");
            return new Params(uuid, keyword, limit, latitude, longitude, source);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.uuid, params.uuid) && Intrinsics.areEqual(this.keyword, params.keyword) && this.limit == params.limit && Intrinsics.areEqual((Object) this.latitude, (Object) params.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) params.longitude) && Intrinsics.areEqual(this.source, params.source);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.uuid.hashCode();
            int hashCode2 = this.keyword.hashCode();
            int i = this.limit;
            Double d = this.latitude;
            int hashCode3 = d == null ? 0 : d.hashCode();
            Double d2 = this.longitude;
            int hashCode4 = d2 == null ? 0 : d2.hashCode();
            String str = this.source;
            return (((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str != null ? str.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(uuid=");
            sb.append(this.uuid);
            sb.append(", keyword=");
            sb.append(this.keyword);
            sb.append(", limit=");
            sb.append(this.limit);
            sb.append(", latitude=");
            sb.append(this.latitude);
            sb.append(", longitude=");
            sb.append(this.longitude);
            sb.append(", source=");
            sb.append(this.source);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, int i, Double d, Double d2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.uuid = str;
            this.keyword = str2;
            this.limit = i;
            this.latitude = d;
            this.longitude = d2;
            this.source = str3;
        }

        public /* synthetic */ Params(String str, String str2, int i, Double d, Double d2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i, (i2 & 8) != 0 ? null : d, (i2 & 16) != 0 ? null : d2, (i2 & 32) != 0 ? null : str3);
        }

        @JvmName(name = "getUuid")
        public final String getUuid() {
            return this.uuid;
        }

        @JvmName(name = "getKeyword")
        public final String getKeyword() {
            return this.keyword;
        }

        @JvmName(name = "getLimit")
        public final int getLimit() {
            return this.limit;
        }

        @JvmName(name = "getLatitude")
        public final Double getLatitude() {
            return this.latitude;
        }

        @JvmName(name = "getLongitude")
        public final Double getLongitude() {
            return this.longitude;
        }

        @JvmName(name = "getSource")
        public final String getSource() {
            return this.source;
        }
    }
}
