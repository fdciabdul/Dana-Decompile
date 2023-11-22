package id.dana.domain.miniprogram.model;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/miniprogram/model/Address;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", Constants.ScionAnalytics.PARAM_LABEL, "latitude", "longitude", "addressLine", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/miniprogram/model/Address;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAddressLine", "getLabel", "getLatitude", "getLongitude", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Address {
    private final String addressLine;
    private final String label;
    private final String latitude;
    private final String longitude;

    public static /* synthetic */ Address copy$default(Address address, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = address.label;
        }
        if ((i & 2) != 0) {
            str2 = address.latitude;
        }
        if ((i & 4) != 0) {
            str3 = address.longitude;
        }
        if ((i & 8) != 0) {
            str4 = address.addressLine;
        }
        return address.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLatitude() {
        return this.latitude;
    }

    /* renamed from: component3  reason: from getter */
    public final String getLongitude() {
        return this.longitude;
    }

    /* renamed from: component4  reason: from getter */
    public final String getAddressLine() {
        return this.addressLine;
    }

    public final Address copy(String label, String latitude, String longitude, String addressLine) {
        Intrinsics.checkNotNullParameter(label, "");
        Intrinsics.checkNotNullParameter(latitude, "");
        Intrinsics.checkNotNullParameter(longitude, "");
        Intrinsics.checkNotNullParameter(addressLine, "");
        return new Address(label, latitude, longitude, addressLine);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Address) {
            Address address = (Address) other;
            return Intrinsics.areEqual(this.label, address.label) && Intrinsics.areEqual(this.latitude, address.latitude) && Intrinsics.areEqual(this.longitude, address.longitude) && Intrinsics.areEqual(this.addressLine, address.addressLine);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.label.hashCode() * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31) + this.addressLine.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address(label=");
        sb.append(this.label);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", addressLine=");
        sb.append(this.addressLine);
        sb.append(')');
        return sb.toString();
    }

    public Address(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.label = str;
        this.latitude = str2;
        this.longitude = str3;
        this.addressLine = str4;
    }

    @JvmName(name = "getLabel")
    public final String getLabel() {
        return this.label;
    }

    @JvmName(name = "getLatitude")
    public final String getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getLongitude")
    public final String getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "getAddressLine")
    public final String getAddressLine() {
        return this.addressLine;
    }
}
