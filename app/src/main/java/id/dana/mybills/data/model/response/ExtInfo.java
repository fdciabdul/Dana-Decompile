package id.dana.mybills.data.model.response;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.mybills.danah5.BillerPortalBridge;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JJ\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b\"\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b#\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b$\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b%\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/ExtInfo;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", UpdateSubscriptionRequest.KEY_EXTEND_INFO_TIMEZONE, "type", "GOODS_NAME", BillerPortalBridge.Event.Info.KEY_QUERY_URL_PROVIDER, BillerPortalBridge.Event.Info.KEY_BILLER_DENOM_TEXT, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/data/model/response/ExtInfo;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getGOODS_NAME", "getTIMEZONE", "getBillerDenomText", "getQueryUrlProvider", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ExtInfo implements Parcelable {
    public static final Parcelable.Creator<ExtInfo> CREATOR = new Creator();
    private final String GOODS_NAME;
    private final String TIMEZONE;
    private final String billerDenomText;
    private final String queryUrlProvider;
    private final String type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<ExtInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ExtInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExtInfo[] newArray(int i) {
            return new ExtInfo[i];
        }
    }

    public ExtInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ExtInfo copy$default(ExtInfo extInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extInfo.TIMEZONE;
        }
        if ((i & 2) != 0) {
            str2 = extInfo.type;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = extInfo.GOODS_NAME;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = extInfo.queryUrlProvider;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = extInfo.billerDenomText;
        }
        return extInfo.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTIMEZONE() {
        return this.TIMEZONE;
    }

    /* renamed from: component2  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3  reason: from getter */
    public final String getGOODS_NAME() {
        return this.GOODS_NAME;
    }

    /* renamed from: component4  reason: from getter */
    public final String getQueryUrlProvider() {
        return this.queryUrlProvider;
    }

    /* renamed from: component5  reason: from getter */
    public final String getBillerDenomText() {
        return this.billerDenomText;
    }

    public final ExtInfo copy(String TIMEZONE, String type, String GOODS_NAME, String queryUrlProvider, String billerDenomText) {
        Intrinsics.checkNotNullParameter(TIMEZONE, "");
        return new ExtInfo(TIMEZONE, type, GOODS_NAME, queryUrlProvider, billerDenomText);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExtInfo) {
            ExtInfo extInfo = (ExtInfo) other;
            return Intrinsics.areEqual(this.TIMEZONE, extInfo.TIMEZONE) && Intrinsics.areEqual(this.type, extInfo.type) && Intrinsics.areEqual(this.GOODS_NAME, extInfo.GOODS_NAME) && Intrinsics.areEqual(this.queryUrlProvider, extInfo.queryUrlProvider) && Intrinsics.areEqual(this.billerDenomText, extInfo.billerDenomText);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.TIMEZONE.hashCode();
        String str = this.type;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.GOODS_NAME;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.queryUrlProvider;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.billerDenomText;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtInfo(TIMEZONE=");
        sb.append(this.TIMEZONE);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", GOODS_NAME=");
        sb.append(this.GOODS_NAME);
        sb.append(", queryUrlProvider=");
        sb.append(this.queryUrlProvider);
        sb.append(", billerDenomText=");
        sb.append(this.billerDenomText);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.TIMEZONE);
        parcel.writeString(this.type);
        parcel.writeString(this.GOODS_NAME);
        parcel.writeString(this.queryUrlProvider);
        parcel.writeString(this.billerDenomText);
    }

    public ExtInfo(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        this.TIMEZONE = str;
        this.type = str2;
        this.GOODS_NAME = str3;
        this.queryUrlProvider = str4;
        this.billerDenomText = str5;
    }

    public /* synthetic */ ExtInfo(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }

    @JvmName(name = "getTIMEZONE")
    public final String getTIMEZONE() {
        return this.TIMEZONE;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getGOODS_NAME")
    public final String getGOODS_NAME() {
        return this.GOODS_NAME;
    }

    @JvmName(name = "getQueryUrlProvider")
    public final String getQueryUrlProvider() {
        return this.queryUrlProvider;
    }

    @JvmName(name = "getBillerDenomText")
    public final String getBillerDenomText() {
        return this.billerDenomText;
    }
}
