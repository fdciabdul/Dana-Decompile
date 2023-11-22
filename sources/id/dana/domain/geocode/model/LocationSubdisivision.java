package id.dana.domain.geocode.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.notification.DanaFirebaseMessagingService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0017\u0010\u000e\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0011\u0010\u001c\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001a\u0010\u000f\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u000b"}, d2 = {"Lid/dana/domain/geocode/model/LocationSubdisivision;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "component3", "()Lid/dana/domain/geocode/model/IndoSubdivisions;", "", "component4", "()J", "latitude", "longitude", "indoSubdivisions", "timestamp", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/geocode/model/IndoSubdivisions;J)Lid/dana/domain/geocode/model/LocationSubdisivision;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "getIndoSubdivisions", "isEmpty", "()Z", "Ljava/lang/String;", "getLatitude", "getLongitude", "J", "getTimestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/geocode/model/IndoSubdivisions;J)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LocationSubdisivision {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IndoSubdivisions indoSubdivisions;
    private final String latitude;
    private final String longitude;
    private final long timestamp;

    public static /* synthetic */ LocationSubdisivision copy$default(LocationSubdisivision locationSubdisivision, String str, String str2, IndoSubdivisions indoSubdivisions, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = locationSubdisivision.latitude;
        }
        if ((i & 2) != 0) {
            str2 = locationSubdisivision.longitude;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            indoSubdivisions = locationSubdisivision.indoSubdivisions;
        }
        IndoSubdivisions indoSubdivisions2 = indoSubdivisions;
        if ((i & 8) != 0) {
            j = locationSubdisivision.timestamp;
        }
        return locationSubdisivision.copy(str, str3, indoSubdivisions2, j);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLatitude() {
        return this.latitude;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLongitude() {
        return this.longitude;
    }

    /* renamed from: component3  reason: from getter */
    public final IndoSubdivisions getIndoSubdivisions() {
        return this.indoSubdivisions;
    }

    /* renamed from: component4  reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final LocationSubdisivision copy(String latitude, String longitude, IndoSubdivisions indoSubdivisions, long timestamp) {
        Intrinsics.checkNotNullParameter(latitude, "");
        Intrinsics.checkNotNullParameter(longitude, "");
        Intrinsics.checkNotNullParameter(indoSubdivisions, "");
        return new LocationSubdisivision(latitude, longitude, indoSubdivisions, timestamp);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LocationSubdisivision) {
            LocationSubdisivision locationSubdisivision = (LocationSubdisivision) other;
            return Intrinsics.areEqual(this.latitude, locationSubdisivision.latitude) && Intrinsics.areEqual(this.longitude, locationSubdisivision.longitude) && Intrinsics.areEqual(this.indoSubdivisions, locationSubdisivision.indoSubdivisions) && this.timestamp == locationSubdisivision.timestamp;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.latitude.hashCode() * 31) + this.longitude.hashCode()) * 31) + this.indoSubdivisions.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.timestamp);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocationSubdisivision(latitude=");
        sb.append(this.latitude);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", indoSubdivisions=");
        sb.append(this.indoSubdivisions);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(')');
        return sb.toString();
    }

    public LocationSubdisivision(String str, String str2, IndoSubdivisions indoSubdivisions, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(indoSubdivisions, "");
        this.latitude = str;
        this.longitude = str2;
        this.indoSubdivisions = indoSubdivisions;
        this.timestamp = j;
    }

    @JvmName(name = "getLatitude")
    public final String getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getLongitude")
    public final String getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "getIndoSubdivisions")
    public final IndoSubdivisions getIndoSubdivisions() {
        return this.indoSubdivisions;
    }

    @JvmName(name = "getTimestamp")
    public final long getTimestamp() {
        return this.timestamp;
    }

    @JvmName(name = "isEmpty")
    public final boolean isEmpty() {
        if (!(this.latitude.length() == 0)) {
            if (!(this.longitude.length() == 0) && !this.indoSubdivisions.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/geocode/model/LocationSubdisivision$Companion;", "", "Lid/dana/domain/geocode/model/LocationSubdisivision;", DanaFirebaseMessagingService.EMPTY, "()Lid/dana/domain/geocode/model/LocationSubdisivision;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocationSubdisivision empty() {
            return new LocationSubdisivision("", "", new IndoSubdivisions.Builder().create(), 0L);
        }
    }
}
