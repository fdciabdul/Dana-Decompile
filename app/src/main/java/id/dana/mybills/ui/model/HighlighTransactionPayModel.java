package id.dana.mybills.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.danah5.transactionstatus.TransactionStatusBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJV\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b&\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b*\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Z", "subscriptionId", TransactionStatusBridge.Companion.TransactionStatusParamKey.TRANSACTION_ID, "checkoutUrl", "location", "errorMessage", "success", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCheckoutUrl", "getErrorMessage", "getLocation", "getSubscriptionId", "Z", "getSuccess", "getTransactionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class HighlighTransactionPayModel implements Parcelable {
    public static final Parcelable.Creator<HighlighTransactionPayModel> CREATOR = new Creator();
    private final String checkoutUrl;
    private final String errorMessage;
    private final String location;
    private final String subscriptionId;
    private final boolean success;
    private final String transactionId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<HighlighTransactionPayModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HighlighTransactionPayModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new HighlighTransactionPayModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HighlighTransactionPayModel[] newArray(int i) {
            return new HighlighTransactionPayModel[i];
        }
    }

    public static /* synthetic */ HighlighTransactionPayModel copy$default(HighlighTransactionPayModel highlighTransactionPayModel, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = highlighTransactionPayModel.subscriptionId;
        }
        if ((i & 2) != 0) {
            str2 = highlighTransactionPayModel.transactionId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = highlighTransactionPayModel.checkoutUrl;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = highlighTransactionPayModel.location;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = highlighTransactionPayModel.errorMessage;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            z = highlighTransactionPayModel.success;
        }
        return highlighTransactionPayModel.copy(str, str6, str7, str8, str9, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component5  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final HighlighTransactionPayModel copy(String subscriptionId, String transactionId, String checkoutUrl, String location, String errorMessage, boolean success) {
        return new HighlighTransactionPayModel(subscriptionId, transactionId, checkoutUrl, location, errorMessage, success);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HighlighTransactionPayModel) {
            HighlighTransactionPayModel highlighTransactionPayModel = (HighlighTransactionPayModel) other;
            return Intrinsics.areEqual(this.subscriptionId, highlighTransactionPayModel.subscriptionId) && Intrinsics.areEqual(this.transactionId, highlighTransactionPayModel.transactionId) && Intrinsics.areEqual(this.checkoutUrl, highlighTransactionPayModel.checkoutUrl) && Intrinsics.areEqual(this.location, highlighTransactionPayModel.location) && Intrinsics.areEqual(this.errorMessage, highlighTransactionPayModel.errorMessage) && this.success == highlighTransactionPayModel.success;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.subscriptionId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.transactionId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.checkoutUrl;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.location;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.errorMessage;
        int hashCode5 = str5 != null ? str5.hashCode() : 0;
        boolean z = this.success;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HighlighTransactionPayModel(subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(", transactionId=");
        sb.append(this.transactionId);
        sb.append(", checkoutUrl=");
        sb.append(this.checkoutUrl);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.subscriptionId);
        parcel.writeString(this.transactionId);
        parcel.writeString(this.checkoutUrl);
        parcel.writeString(this.location);
        parcel.writeString(this.errorMessage);
        parcel.writeInt(this.success ? 1 : 0);
    }

    public HighlighTransactionPayModel(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.subscriptionId = str;
        this.transactionId = str2;
        this.checkoutUrl = str3;
        this.location = str4;
        this.errorMessage = str5;
        this.success = z;
    }

    public /* synthetic */ HighlighTransactionPayModel(String str, String str2, String str3, String str4, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? false : z);
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getTransactionId")
    public final String getTransactionId() {
        return this.transactionId;
    }

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }
}
