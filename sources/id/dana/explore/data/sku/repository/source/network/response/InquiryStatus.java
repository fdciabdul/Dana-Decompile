package id.dana.explore.data.sku.repository.source.network.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/response/InquiryStatus;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "code", "status", "message", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/explore/data/sku/repository/source/network/response/InquiryStatus;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCode", "getMessage", "getStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InquiryStatus implements Parcelable {
    public static final Parcelable.Creator<InquiryStatus> CREATOR = new Creator();
    @SerializedName("code")
    private final String code;
    private final String message;
    private final String status;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<InquiryStatus> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final InquiryStatus createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new InquiryStatus(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final InquiryStatus[] newArray(int i) {
            return new InquiryStatus[i];
        }
    }

    public InquiryStatus() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ InquiryStatus copy$default(InquiryStatus inquiryStatus, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inquiryStatus.code;
        }
        if ((i & 2) != 0) {
            str2 = inquiryStatus.status;
        }
        if ((i & 4) != 0) {
            str3 = inquiryStatus.message;
        }
        return inquiryStatus.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final InquiryStatus copy(String code, String status, String message) {
        Intrinsics.checkNotNullParameter(code, "");
        Intrinsics.checkNotNullParameter(status, "");
        return new InquiryStatus(code, status, message);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InquiryStatus) {
            InquiryStatus inquiryStatus = (InquiryStatus) other;
            return Intrinsics.areEqual(this.code, inquiryStatus.code) && Intrinsics.areEqual(this.status, inquiryStatus.status) && Intrinsics.areEqual(this.message, inquiryStatus.message);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.code.hashCode();
        int hashCode2 = this.status.hashCode();
        String str = this.message;
        return (((hashCode * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InquiryStatus(code=");
        sb.append(this.code);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.code);
        parcel.writeString(this.status);
        parcel.writeString(this.message);
    }

    public InquiryStatus(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.code = str;
        this.status = str2;
        this.message = str3;
    }

    public /* synthetic */ InquiryStatus(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3);
    }

    @JvmName(name = "getCode")
    public final String getCode() {
        return this.code;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }
}
