package id.dana.domain.nearbyplaces.interactor;

import android.location.Location;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.domain.tracker.GeocodeTrackerData;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyplaces/interactor/GetChainQueryResult;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "Lid/dana/domain/nearbyplaces/interactor/GetChainQueryResult$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/nearbyplaces/interactor/GetChainQueryResult$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;", "nearbyPlaceRepository", "Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;", "<init>", "(Lid/dana/domain/nearbyplaces/NearbyPlaceRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetChainQueryResult extends BaseUseCase<List<? extends NearbyLocation>, Params> {
    private final NearbyPlaceRepository nearbyPlaceRepository;

    @Inject
    public GetChainQueryResult(NearbyPlaceRepository nearbyPlaceRepository) {
        Intrinsics.checkNotNullParameter(nearbyPlaceRepository, "");
        this.nearbyPlaceRepository = nearbyPlaceRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<NearbyLocation>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        params.getGeocodeTrackerData().setDomainLayerCaller("GetAutoSuggestChainQuery");
        return this.nearbyPlaceRepository.getChainQueryResult(params.getKeyword(), params.getLocation(), params.getOntology(), params.getUuid(), params.getGeocodeTrackerData(), params.getHereMixPanelTrackerData());
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJL\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\fR\u001a\u0010\u0015\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b)\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyplaces/interactor/GetChainQueryResult$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "Landroid/location/Location;", "component3", "()Landroid/location/Location;", "component4", "Lid/dana/domain/tracker/GeocodeTrackerData;", "component5", "()Lid/dana/domain/tracker/GeocodeTrackerData;", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "component6", "()Lid/dana/domain/tracker/HereMixPanelTrackerData;", "uuid", "keyword", "location", "ontology", "geocodeTrackerData", "hereMixPanelTrackerData", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/location/Location;Ljava/lang/String;Lid/dana/domain/tracker/GeocodeTrackerData;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lid/dana/domain/nearbyplaces/interactor/GetChainQueryResult$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/tracker/GeocodeTrackerData;", "getGeocodeTrackerData", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "getHereMixPanelTrackerData", "Ljava/lang/String;", "getKeyword", "Landroid/location/Location;", "getLocation", "getOntology", "getUuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/location/Location;Ljava/lang/String;Lid/dana/domain/tracker/GeocodeTrackerData;Lid/dana/domain/tracker/HereMixPanelTrackerData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final GeocodeTrackerData geocodeTrackerData;
        private final HereMixPanelTrackerData hereMixPanelTrackerData;
        private final String keyword;
        private final Location location;
        private final String ontology;
        private final String uuid;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, Location location, String str3, GeocodeTrackerData geocodeTrackerData, HereMixPanelTrackerData hereMixPanelTrackerData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.uuid;
            }
            if ((i & 2) != 0) {
                str2 = params.keyword;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                location = params.location;
            }
            Location location2 = location;
            if ((i & 8) != 0) {
                str3 = params.ontology;
            }
            String str5 = str3;
            if ((i & 16) != 0) {
                geocodeTrackerData = params.geocodeTrackerData;
            }
            GeocodeTrackerData geocodeTrackerData2 = geocodeTrackerData;
            if ((i & 32) != 0) {
                hereMixPanelTrackerData = params.hereMixPanelTrackerData;
            }
            return params.copy(str, str4, location2, str5, geocodeTrackerData2, hereMixPanelTrackerData);
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
        public final Location getLocation() {
            return this.location;
        }

        /* renamed from: component4  reason: from getter */
        public final String getOntology() {
            return this.ontology;
        }

        /* renamed from: component5  reason: from getter */
        public final GeocodeTrackerData getGeocodeTrackerData() {
            return this.geocodeTrackerData;
        }

        /* renamed from: component6  reason: from getter */
        public final HereMixPanelTrackerData getHereMixPanelTrackerData() {
            return this.hereMixPanelTrackerData;
        }

        public final Params copy(String uuid, String keyword, Location location, String ontology, GeocodeTrackerData geocodeTrackerData, HereMixPanelTrackerData hereMixPanelTrackerData) {
            Intrinsics.checkNotNullParameter(uuid, "");
            Intrinsics.checkNotNullParameter(keyword, "");
            Intrinsics.checkNotNullParameter(location, "");
            Intrinsics.checkNotNullParameter(ontology, "");
            Intrinsics.checkNotNullParameter(geocodeTrackerData, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            return new Params(uuid, keyword, location, ontology, geocodeTrackerData, hereMixPanelTrackerData);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.uuid, params.uuid) && Intrinsics.areEqual(this.keyword, params.keyword) && Intrinsics.areEqual(this.location, params.location) && Intrinsics.areEqual(this.ontology, params.ontology) && Intrinsics.areEqual(this.geocodeTrackerData, params.geocodeTrackerData) && Intrinsics.areEqual(this.hereMixPanelTrackerData, params.hereMixPanelTrackerData);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((this.uuid.hashCode() * 31) + this.keyword.hashCode()) * 31) + this.location.hashCode()) * 31) + this.ontology.hashCode()) * 31) + this.geocodeTrackerData.hashCode()) * 31) + this.hereMixPanelTrackerData.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(uuid=");
            sb.append(this.uuid);
            sb.append(", keyword=");
            sb.append(this.keyword);
            sb.append(", location=");
            sb.append(this.location);
            sb.append(", ontology=");
            sb.append(this.ontology);
            sb.append(", geocodeTrackerData=");
            sb.append(this.geocodeTrackerData);
            sb.append(", hereMixPanelTrackerData=");
            sb.append(this.hereMixPanelTrackerData);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, Location location, String str3, GeocodeTrackerData geocodeTrackerData, HereMixPanelTrackerData hereMixPanelTrackerData) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(location, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(geocodeTrackerData, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            this.uuid = str;
            this.keyword = str2;
            this.location = location;
            this.ontology = str3;
            this.geocodeTrackerData = geocodeTrackerData;
            this.hereMixPanelTrackerData = hereMixPanelTrackerData;
        }

        @JvmName(name = "getUuid")
        public final String getUuid() {
            return this.uuid;
        }

        @JvmName(name = "getKeyword")
        public final String getKeyword() {
            return this.keyword;
        }

        @JvmName(name = "getLocation")
        public final Location getLocation() {
            return this.location;
        }

        @JvmName(name = "getOntology")
        public final String getOntology() {
            return this.ontology;
        }

        @JvmName(name = "getGeocodeTrackerData")
        public final GeocodeTrackerData getGeocodeTrackerData() {
            return this.geocodeTrackerData;
        }

        @JvmName(name = "getHereMixPanelTrackerData")
        public final HereMixPanelTrackerData getHereMixPanelTrackerData() {
            return this.hereMixPanelTrackerData;
        }
    }
}
