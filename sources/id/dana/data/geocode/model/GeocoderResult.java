package id.dana.data.geocode.model;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b"}, d2 = {"Lid/dana/data/geocode/model/GeocoderResult;", "", "", "Lid/dana/data/geocode/model/GeocoderResult$Results;", "component1", "()[Lid/dana/data/geocode/model/GeocoderResult$Results;", "", "component2", "()Ljava/lang/String;", "results", "status", "copy", "([Lid/dana/data/geocode/model/GeocoderResult$Results;Ljava/lang/String;)Lid/dana/data/geocode/model/GeocoderResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "[Lid/dana/data/geocode/model/GeocoderResult$Results;", "getResults", "Ljava/lang/String;", "getStatus", "<init>", "([Lid/dana/data/geocode/model/GeocoderResult$Results;Ljava/lang/String;)V", "AddressComponent", "Results"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GeocoderResult {
    private final Results[] results;
    @SerializedName("status")
    private final String status;

    public static /* synthetic */ GeocoderResult copy$default(GeocoderResult geocoderResult, Results[] resultsArr, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            resultsArr = geocoderResult.results;
        }
        if ((i & 2) != 0) {
            str = geocoderResult.status;
        }
        return geocoderResult.copy(resultsArr, str);
    }

    /* renamed from: component1  reason: from getter */
    public final Results[] getResults() {
        return this.results;
    }

    /* renamed from: component2  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final GeocoderResult copy(Results[] results, String status) {
        Intrinsics.checkNotNullParameter(results, "");
        Intrinsics.checkNotNullParameter(status, "");
        return new GeocoderResult(results, status);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeocoderResult) {
            GeocoderResult geocoderResult = (GeocoderResult) other;
            return Intrinsics.areEqual(this.results, geocoderResult.results) && Intrinsics.areEqual(this.status, geocoderResult.status);
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.results) * 31) + this.status.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeocoderResult(results=");
        sb.append(Arrays.toString(this.results));
        sb.append(", status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    public GeocoderResult(Results[] resultsArr, String str) {
        Intrinsics.checkNotNullParameter(resultsArr, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.results = resultsArr;
        this.status = str;
    }

    @JvmName(name = "getResults")
    public final Results[] getResults() {
        return this.results;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/geocode/model/GeocoderResult$Results;", "", "", "Lid/dana/data/geocode/model/GeocoderResult$AddressComponent;", "address_components", "[Lid/dana/data/geocode/model/GeocoderResult$AddressComponent;", "getAddress_components", "()[Lid/dana/data/geocode/model/GeocoderResult$AddressComponent;", "", "formatted_address", "Ljava/lang/String;", "getFormatted_address", "()Ljava/lang/String;", "<init>", "([Lid/dana/data/geocode/model/GeocoderResult$AddressComponent;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Results {
        private final AddressComponent[] address_components;
        @SerializedName("formatted_address")
        private final String formatted_address;

        public Results(AddressComponent[] addressComponentArr, String str) {
            Intrinsics.checkNotNullParameter(addressComponentArr, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.address_components = addressComponentArr;
            this.formatted_address = str;
        }

        @JvmName(name = "getAddress_components")
        public final AddressComponent[] getAddress_components() {
            return this.address_components;
        }

        @JvmName(name = "getFormatted_address")
        public final String getFormatted_address() {
            return this.formatted_address;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/geocode/model/GeocoderResult$AddressComponent;", "", "", "long_name", "Ljava/lang/String;", "getLong_name", "()Ljava/lang/String;", "short_name", "getShort_name", "", "types", "[Ljava/lang/String;", "getTypes", "()[Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class AddressComponent {
        @SerializedName("long_name")
        private final String long_name;
        private final String short_name;
        private final String[] types;

        public AddressComponent(String str, String str2, String[] strArr) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(strArr, "");
            this.long_name = str;
            this.short_name = str2;
            this.types = strArr;
        }

        @JvmName(name = "getLong_name")
        public final String getLong_name() {
            return this.long_name;
        }

        @JvmName(name = "getShort_name")
        public final String getShort_name() {
            return this.short_name;
        }

        @JvmName(name = "getTypes")
        public final String[] getTypes() {
            return this.types;
        }
    }
}
