package id.dana.cashier.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JX\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R$\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010&R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010*R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010'\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010*R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010'\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010*R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010'\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010*R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010'\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010*"}, d2 = {"Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Boolean;", "component6", "mid", "bizNo", "timestamp", "sign", "addOn", "selectedPayOption", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "getAddOn", "setAddOn", "(Ljava/lang/Boolean;)V", "Ljava/lang/String;", "getBizNo", "setBizNo", "(Ljava/lang/String;)V", "getMid", "setMid", "getSelectedPayOption", "setSelectedPayOption", "getSign", "setSign", "getTimestamp", "setTimestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CheckoutExternalInfo implements Parcelable {
    public static final Parcelable.Creator<CheckoutExternalInfo> CREATOR = new Creator();
    private Boolean addOn;
    private String bizNo;
    @SerializedName("mid")
    private String mid;
    private String selectedPayOption;
    private String sign;
    private String timestamp;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CheckoutExternalInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CheckoutExternalInfo createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new CheckoutExternalInfo(readString, readString2, readString3, readString4, valueOf, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CheckoutExternalInfo[] newArray(int i) {
            return new CheckoutExternalInfo[i];
        }
    }

    public CheckoutExternalInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CheckoutExternalInfo copy$default(CheckoutExternalInfo checkoutExternalInfo, String str, String str2, String str3, String str4, Boolean bool, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkoutExternalInfo.mid;
        }
        if ((i & 2) != 0) {
            str2 = checkoutExternalInfo.bizNo;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = checkoutExternalInfo.timestamp;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = checkoutExternalInfo.sign;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            bool = checkoutExternalInfo.addOn;
        }
        Boolean bool2 = bool;
        if ((i & 32) != 0) {
            str5 = checkoutExternalInfo.selectedPayOption;
        }
        return checkoutExternalInfo.copy(str, str6, str7, str8, bool2, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMid() {
        return this.mid;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBizNo() {
        return this.bizNo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4  reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    /* renamed from: component5  reason: from getter */
    public final Boolean getAddOn() {
        return this.addOn;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSelectedPayOption() {
        return this.selectedPayOption;
    }

    public final CheckoutExternalInfo copy(String mid, String bizNo, String timestamp, String sign, Boolean addOn, String selectedPayOption) {
        return new CheckoutExternalInfo(mid, bizNo, timestamp, sign, addOn, selectedPayOption);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CheckoutExternalInfo) {
            CheckoutExternalInfo checkoutExternalInfo = (CheckoutExternalInfo) other;
            return Intrinsics.areEqual(this.mid, checkoutExternalInfo.mid) && Intrinsics.areEqual(this.bizNo, checkoutExternalInfo.bizNo) && Intrinsics.areEqual(this.timestamp, checkoutExternalInfo.timestamp) && Intrinsics.areEqual(this.sign, checkoutExternalInfo.sign) && Intrinsics.areEqual(this.addOn, checkoutExternalInfo.addOn) && Intrinsics.areEqual(this.selectedPayOption, checkoutExternalInfo.selectedPayOption);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.mid;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bizNo;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.timestamp;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.sign;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.addOn;
        int hashCode5 = bool == null ? 0 : bool.hashCode();
        String str5 = this.selectedPayOption;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckoutExternalInfo(mid=");
        sb.append(this.mid);
        sb.append(", bizNo=");
        sb.append(this.bizNo);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", sign=");
        sb.append(this.sign);
        sb.append(", addOn=");
        sb.append(this.addOn);
        sb.append(", selectedPayOption=");
        sb.append(this.selectedPayOption);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        int i;
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.mid);
        parcel.writeString(this.bizNo);
        parcel.writeString(this.timestamp);
        parcel.writeString(this.sign);
        Boolean bool = this.addOn;
        if (bool == null) {
            i = 0;
        } else {
            parcel.writeInt(1);
            i = bool.booleanValue();
        }
        parcel.writeInt(i);
        parcel.writeString(this.selectedPayOption);
    }

    public CheckoutExternalInfo(String str, String str2, String str3, String str4, Boolean bool, String str5) {
        this.mid = str;
        this.bizNo = str2;
        this.timestamp = str3;
        this.sign = str4;
        this.addOn = bool;
        this.selectedPayOption = str5;
    }

    public /* synthetic */ CheckoutExternalInfo(String str, String str2, String str3, String str4, Boolean bool, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : str5);
    }

    @JvmName(name = "getMid")
    public final String getMid() {
        return this.mid;
    }

    @JvmName(name = "setMid")
    public final void setMid(String str) {
        this.mid = str;
    }

    @JvmName(name = "getBizNo")
    public final String getBizNo() {
        return this.bizNo;
    }

    @JvmName(name = "setBizNo")
    public final void setBizNo(String str) {
        this.bizNo = str;
    }

    @JvmName(name = "getTimestamp")
    public final String getTimestamp() {
        return this.timestamp;
    }

    @JvmName(name = "setTimestamp")
    public final void setTimestamp(String str) {
        this.timestamp = str;
    }

    @JvmName(name = "getSign")
    public final String getSign() {
        return this.sign;
    }

    @JvmName(name = "setSign")
    public final void setSign(String str) {
        this.sign = str;
    }

    @JvmName(name = "getAddOn")
    public final Boolean getAddOn() {
        return this.addOn;
    }

    @JvmName(name = "setAddOn")
    public final void setAddOn(Boolean bool) {
        this.addOn = bool;
    }

    @JvmName(name = "getSelectedPayOption")
    public final String getSelectedPayOption() {
        return this.selectedPayOption;
    }

    @JvmName(name = "setSelectedPayOption")
    public final void setSelectedPayOption(String str) {
        this.selectedPayOption = str;
    }
}
