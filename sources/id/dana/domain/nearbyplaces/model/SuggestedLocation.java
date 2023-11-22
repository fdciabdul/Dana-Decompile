package id.dana.domain.nearbyplaces.model;

import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\tR\u001a\u0010\u000f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001e\u0010\tR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyplaces/model/SuggestedLocation;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()D", "component5", "title", "description", "placeId", "latitude", "longitude", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DD)Lid/dana/domain/nearbyplaces/model/SuggestedLocation;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDescription", SummaryActivity.DAYS, "getLatitude", "getLongitude", "getPlaceId", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DD)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SuggestedLocation {
    private final String description;
    private final double latitude;
    private final double longitude;
    private final String placeId;
    private final String title;

    public static /* synthetic */ SuggestedLocation copy$default(SuggestedLocation suggestedLocation, String str, String str2, String str3, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = suggestedLocation.title;
        }
        if ((i & 2) != 0) {
            str2 = suggestedLocation.description;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = suggestedLocation.placeId;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            d = suggestedLocation.latitude;
        }
        double d3 = d;
        if ((i & 16) != 0) {
            d2 = suggestedLocation.longitude;
        }
        return suggestedLocation.copy(str, str4, str5, d3, d2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
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
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component5  reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    public final SuggestedLocation copy(String title, String description, String placeId, double latitude, double longitude) {
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(placeId, "");
        return new SuggestedLocation(title, description, placeId, latitude, longitude);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SuggestedLocation) {
            SuggestedLocation suggestedLocation = (SuggestedLocation) other;
            return Intrinsics.areEqual(this.title, suggestedLocation.title) && Intrinsics.areEqual(this.description, suggestedLocation.description) && Intrinsics.areEqual(this.placeId, suggestedLocation.placeId) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(suggestedLocation.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(suggestedLocation.longitude));
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.placeId.hashCode()) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SuggestedLocation(title=");
        sb.append(this.title);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", placeId=");
        sb.append(this.placeId);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(')');
        return sb.toString();
    }

    public SuggestedLocation(String str, String str2, String str3, double d, double d2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.title = str;
        this.description = str2;
        this.placeId = str3;
        this.latitude = d;
        this.longitude = d2;
    }

    public /* synthetic */ SuggestedLocation(String str, String str2, String str3, double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, str3, d, d2);
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getPlaceId")
    public final String getPlaceId() {
        return this.placeId;
    }

    @JvmName(name = "getLatitude")
    public final double getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getLongitude")
    public final double getLongitude() {
        return this.longitude;
    }
}
