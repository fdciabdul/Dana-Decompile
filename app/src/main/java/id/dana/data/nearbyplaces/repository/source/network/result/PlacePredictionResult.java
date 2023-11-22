package id.dana.data.nearbyplaces.repository.source.network.result;

import android.location.Location;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jb\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b-\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u0010\f"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "component4", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceStructuredFormattingResult;", "component5", "()Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceStructuredFormattingResult;", "component6", "", "component7", "()Z", "Landroid/location/Location;", "component8", "()Landroid/location/Location;", "description", "distanceInMeters", "id", "placeId", "structuredFormatting", "chainQueryUrl", "isFollowUpQuery", "location", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceStructuredFormattingResult;Ljava/lang/String;ZLandroid/location/Location;)Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getChainQueryUrl", "getDescription", "J", "getDistanceInMeters", "getId", "Z", "Landroid/location/Location;", "getLocation", "getPlaceId", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceStructuredFormattingResult;", "getStructuredFormatting", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceStructuredFormattingResult;Ljava/lang/String;ZLandroid/location/Location;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PlacePredictionResult {
    private final String chainQueryUrl;
    private final String description;
    @SerializedName("distance_meters")
    private final long distanceInMeters;
    private final String id;
    private final boolean isFollowUpQuery;
    private final Location location;
    @SerializedName("place_id")
    private final String placeId;
    @SerializedName("structured_formatting")
    private final PlaceStructuredFormattingResult structuredFormatting;

    /* renamed from: component1  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2  reason: from getter */
    public final long getDistanceInMeters() {
        return this.distanceInMeters;
    }

    /* renamed from: component3  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPlaceId() {
        return this.placeId;
    }

    /* renamed from: component5  reason: from getter */
    public final PlaceStructuredFormattingResult getStructuredFormatting() {
        return this.structuredFormatting;
    }

    /* renamed from: component6  reason: from getter */
    public final String getChainQueryUrl() {
        return this.chainQueryUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getIsFollowUpQuery() {
        return this.isFollowUpQuery;
    }

    /* renamed from: component8  reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    public final PlacePredictionResult copy(String description, long distanceInMeters, String id2, String placeId, PlaceStructuredFormattingResult structuredFormatting, String chainQueryUrl, boolean isFollowUpQuery, Location location) {
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(placeId, "");
        Intrinsics.checkNotNullParameter(structuredFormatting, "");
        Intrinsics.checkNotNullParameter(location, "");
        return new PlacePredictionResult(description, distanceInMeters, id2, placeId, structuredFormatting, chainQueryUrl, isFollowUpQuery, location);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PlacePredictionResult) {
            PlacePredictionResult placePredictionResult = (PlacePredictionResult) other;
            return Intrinsics.areEqual(this.description, placePredictionResult.description) && this.distanceInMeters == placePredictionResult.distanceInMeters && Intrinsics.areEqual(this.id, placePredictionResult.id) && Intrinsics.areEqual(this.placeId, placePredictionResult.placeId) && Intrinsics.areEqual(this.structuredFormatting, placePredictionResult.structuredFormatting) && Intrinsics.areEqual(this.chainQueryUrl, placePredictionResult.chainQueryUrl) && this.isFollowUpQuery == placePredictionResult.isFollowUpQuery && Intrinsics.areEqual(this.location, placePredictionResult.location);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.description.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.distanceInMeters);
        int hashCode2 = this.id.hashCode();
        int hashCode3 = this.placeId.hashCode();
        int hashCode4 = this.structuredFormatting.hashCode();
        String str = this.chainQueryUrl;
        int hashCode5 = str == null ? 0 : str.hashCode();
        boolean z = this.isFollowUpQuery;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((hashCode * 31) + m) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + this.location.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlacePredictionResult(description=");
        sb.append(this.description);
        sb.append(", distanceInMeters=");
        sb.append(this.distanceInMeters);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", placeId=");
        sb.append(this.placeId);
        sb.append(", structuredFormatting=");
        sb.append(this.structuredFormatting);
        sb.append(", chainQueryUrl=");
        sb.append(this.chainQueryUrl);
        sb.append(", isFollowUpQuery=");
        sb.append(this.isFollowUpQuery);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(')');
        return sb.toString();
    }

    public PlacePredictionResult(String str, long j, String str2, String str3, PlaceStructuredFormattingResult placeStructuredFormattingResult, String str4, boolean z, Location location) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(placeStructuredFormattingResult, "");
        Intrinsics.checkNotNullParameter(location, "");
        this.description = str;
        this.distanceInMeters = j;
        this.id = str2;
        this.placeId = str3;
        this.structuredFormatting = placeStructuredFormattingResult;
        this.chainQueryUrl = str4;
        this.isFollowUpQuery = z;
        this.location = location;
    }

    public /* synthetic */ PlacePredictionResult(String str, long j, String str2, String str3, PlaceStructuredFormattingResult placeStructuredFormattingResult, String str4, boolean z, Location location, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, str3, placeStructuredFormattingResult, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? false : z, location);
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getDistanceInMeters")
    public final long getDistanceInMeters() {
        return this.distanceInMeters;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getPlaceId")
    public final String getPlaceId() {
        return this.placeId;
    }

    @JvmName(name = "getStructuredFormatting")
    public final PlaceStructuredFormattingResult getStructuredFormatting() {
        return this.structuredFormatting;
    }

    @JvmName(name = "getChainQueryUrl")
    public final String getChainQueryUrl() {
        return this.chainQueryUrl;
    }

    @JvmName(name = "isFollowUpQuery")
    public final boolean isFollowUpQuery() {
        return this.isFollowUpQuery;
    }

    @JvmName(name = "getLocation")
    public final Location getLocation() {
        return this.location;
    }
}
