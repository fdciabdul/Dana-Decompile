package id.dana.domain.nearbyplaces.model;

import android.location.Location;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JX\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\rJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\tR\u001a\u0010\u0017\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010\r"}, d2 = {"Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()J", "component5", "", "component6", "()I", "Landroid/location/Location;", "component7", "()Landroid/location/Location;", "name", "description", "placeId", "distanceInMeters", "chainQueryUrl", "viewHolderType", "location", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILandroid/location/Location;)Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getChainQueryUrl", "getDescription", "J", "getDistanceInMeters", "Landroid/location/Location;", "getLocation", "getName", "getPlaceId", "I", "getViewHolderType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILandroid/location/Location;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NearbyLocation {
    private final String chainQueryUrl;
    private final String description;
    private final long distanceInMeters;
    private final Location location;
    private final String name;
    private final String placeId;
    private final int viewHolderType;

    /* renamed from: component1  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPlaceId() {
        return this.placeId;
    }

    /* renamed from: component4  reason: from getter */
    public final long getDistanceInMeters() {
        return this.distanceInMeters;
    }

    /* renamed from: component5  reason: from getter */
    public final String getChainQueryUrl() {
        return this.chainQueryUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final int getViewHolderType() {
        return this.viewHolderType;
    }

    /* renamed from: component7  reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    public final NearbyLocation copy(String name, String description, String placeId, long distanceInMeters, String chainQueryUrl, int viewHolderType, Location location) {
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(placeId, "");
        Intrinsics.checkNotNullParameter(location, "");
        return new NearbyLocation(name, description, placeId, distanceInMeters, chainQueryUrl, viewHolderType, location);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyLocation) {
            NearbyLocation nearbyLocation = (NearbyLocation) other;
            return Intrinsics.areEqual(this.name, nearbyLocation.name) && Intrinsics.areEqual(this.description, nearbyLocation.description) && Intrinsics.areEqual(this.placeId, nearbyLocation.placeId) && this.distanceInMeters == nearbyLocation.distanceInMeters && Intrinsics.areEqual(this.chainQueryUrl, nearbyLocation.chainQueryUrl) && this.viewHolderType == nearbyLocation.viewHolderType && Intrinsics.areEqual(this.location, nearbyLocation.location);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.name.hashCode();
        int hashCode2 = this.description.hashCode();
        int hashCode3 = this.placeId.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.distanceInMeters);
        String str = this.chainQueryUrl;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + m) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.viewHolderType) * 31) + this.location.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyLocation(name=");
        sb.append(this.name);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", placeId=");
        sb.append(this.placeId);
        sb.append(", distanceInMeters=");
        sb.append(this.distanceInMeters);
        sb.append(", chainQueryUrl=");
        sb.append(this.chainQueryUrl);
        sb.append(", viewHolderType=");
        sb.append(this.viewHolderType);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(')');
        return sb.toString();
    }

    public NearbyLocation(String str, String str2, String str3, long j, String str4, int i, Location location) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(location, "");
        this.name = str;
        this.description = str2;
        this.placeId = str3;
        this.distanceInMeters = j;
        this.chainQueryUrl = str4;
        this.viewHolderType = i;
        this.location = location;
    }

    public /* synthetic */ NearbyLocation(String str, String str2, String str3, long j, String str4, int i, Location location, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? "" : str2, str3, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? 0 : i, location);
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getPlaceId")
    public final String getPlaceId() {
        return this.placeId;
    }

    @JvmName(name = "getDistanceInMeters")
    public final long getDistanceInMeters() {
        return this.distanceInMeters;
    }

    @JvmName(name = "getChainQueryUrl")
    public final String getChainQueryUrl() {
        return this.chainQueryUrl;
    }

    @JvmName(name = "getViewHolderType")
    public final int getViewHolderType() {
        return this.viewHolderType;
    }

    @JvmName(name = "getLocation")
    public final Location getLocation() {
        return this.location;
    }
}
