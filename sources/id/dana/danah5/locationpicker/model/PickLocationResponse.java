package id.dana.danah5.locationpicker.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\nR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/danah5/locationpicker/model/PickLocationResponse;", "", "", "component1", "()Z", "Lid/dana/danah5/locationpicker/model/PickLocationResponse$LocationResult;", "component2", "()Lid/dana/danah5/locationpicker/model/PickLocationResponse$LocationResult;", "", "component3", "()Ljava/lang/String;", "success", "data", "errorCode", "copy", "(ZLid/dana/danah5/locationpicker/model/PickLocationResponse$LocationResult;Ljava/lang/String;)Lid/dana/danah5/locationpicker/model/PickLocationResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/danah5/locationpicker/model/PickLocationResponse$LocationResult;", "getData", "Ljava/lang/String;", "getErrorCode", "Z", "getSuccess", "<init>", "(ZLid/dana/danah5/locationpicker/model/PickLocationResponse$LocationResult;Ljava/lang/String;)V", "LocationResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PickLocationResponse {
    private final LocationResult data;
    private final String errorCode;
    private final boolean success;

    public static /* synthetic */ PickLocationResponse copy$default(PickLocationResponse pickLocationResponse, boolean z, LocationResult locationResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pickLocationResponse.success;
        }
        if ((i & 2) != 0) {
            locationResult = pickLocationResponse.data;
        }
        if ((i & 4) != 0) {
            str = pickLocationResponse.errorCode;
        }
        return pickLocationResponse.copy(z, locationResult, str);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2  reason: from getter */
    public final LocationResult getData() {
        return this.data;
    }

    /* renamed from: component3  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    public final PickLocationResponse copy(boolean success, LocationResult data, String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "");
        return new PickLocationResponse(success, data, errorCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PickLocationResponse) {
            PickLocationResponse pickLocationResponse = (PickLocationResponse) other;
            return this.success == pickLocationResponse.success && Intrinsics.areEqual(this.data, pickLocationResponse.data) && Intrinsics.areEqual(this.errorCode, pickLocationResponse.errorCode);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        LocationResult locationResult = this.data;
        return (((r0 * 31) + (locationResult == null ? 0 : locationResult.hashCode())) * 31) + this.errorCode.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PickLocationResponse(success=");
        sb.append(this.success);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(')');
        return sb.toString();
    }

    public PickLocationResponse(boolean z, LocationResult locationResult, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.success = z;
        this.data = locationResult;
        this.errorCode = str;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getData")
    public final LocationResult getData() {
        return this.data;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/danah5/locationpicker/model/PickLocationResponse$LocationResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "lat", "long", "name", "details", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/danah5/locationpicker/model/PickLocationResponse$LocationResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDetails", "getLat", "getLong", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class LocationResult {
        private final String details;
        private final String lat;
        private final String long;
        private final String name;

        public static /* synthetic */ LocationResult copy$default(LocationResult locationResult, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = locationResult.lat;
            }
            if ((i & 2) != 0) {
                str2 = locationResult.long;
            }
            if ((i & 4) != 0) {
                str3 = locationResult.name;
            }
            if ((i & 8) != 0) {
                str4 = locationResult.details;
            }
            return locationResult.copy(str, str2, str3, str4);
        }

        /* renamed from: component1  reason: from getter */
        public final String getLat() {
            return this.lat;
        }

        /* renamed from: component2  reason: from getter */
        public final String getLong() {
            return this.long;
        }

        /* renamed from: component3  reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component4  reason: from getter */
        public final String getDetails() {
            return this.details;
        }

        public final LocationResult copy(String lat, String r3, String name, String details) {
            Intrinsics.checkNotNullParameter(lat, "");
            Intrinsics.checkNotNullParameter(r3, "");
            Intrinsics.checkNotNullParameter(name, "");
            Intrinsics.checkNotNullParameter(details, "");
            return new LocationResult(lat, r3, name, details);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof LocationResult) {
                LocationResult locationResult = (LocationResult) other;
                return Intrinsics.areEqual(this.lat, locationResult.lat) && Intrinsics.areEqual(this.long, locationResult.long) && Intrinsics.areEqual(this.name, locationResult.name) && Intrinsics.areEqual(this.details, locationResult.details);
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.lat.hashCode() * 31) + this.long.hashCode()) * 31) + this.name.hashCode()) * 31) + this.details.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationResult(lat=");
            sb.append(this.lat);
            sb.append(", long=");
            sb.append(this.long);
            sb.append(", name=");
            sb.append(this.name);
            sb.append(", details=");
            sb.append(this.details);
            sb.append(')');
            return sb.toString();
        }

        public LocationResult(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.lat = str;
            this.long = str2;
            this.name = str3;
            this.details = str4;
        }

        @JvmName(name = "getLat")
        public final String getLat() {
            return this.lat;
        }

        @JvmName(name = "getLong")
        public final String getLong() {
            return this.long;
        }

        @JvmName(name = "getName")
        public final String getName() {
            return this.name;
        }

        @JvmName(name = "getDetails")
        public final String getDetails() {
            return this.details;
        }
    }
}
