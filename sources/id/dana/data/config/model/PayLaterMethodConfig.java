package id.dana.data.config.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J4\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0005J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010 R$\u0010\t\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010 R$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001d\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010 "}, d2 = {"Lid/dana/data/config/model/PayLaterMethodConfig;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "paymethodDescription", "additionalInfoPayConfirmation", "additionalInfoInstallmentSelection", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/config/model/PayLaterMethodConfig;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAdditionalInfoInstallmentSelection", "setAdditionalInfoInstallmentSelection", "(Ljava/lang/String;)V", "getAdditionalInfoPayConfirmation", "setAdditionalInfoPayConfirmation", "getPaymethodDescription", "setPaymethodDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PayLaterMethodConfig implements Parcelable, Serializable {
    public static final Parcelable.Creator<PayLaterMethodConfig> CREATOR = new Creator();
    @SerializedName("additional_info_installment_selection")
    private String additionalInfoInstallmentSelection;
    @SerializedName("additional_info_payconfirmation")
    private String additionalInfoPayConfirmation;
    @SerializedName("paymethod_description_payconfirmation")
    private String paymethodDescription;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<PayLaterMethodConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PayLaterMethodConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new PayLaterMethodConfig(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PayLaterMethodConfig[] newArray(int i) {
            return new PayLaterMethodConfig[i];
        }
    }

    public PayLaterMethodConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PayLaterMethodConfig copy$default(PayLaterMethodConfig payLaterMethodConfig, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payLaterMethodConfig.paymethodDescription;
        }
        if ((i & 2) != 0) {
            str2 = payLaterMethodConfig.additionalInfoPayConfirmation;
        }
        if ((i & 4) != 0) {
            str3 = payLaterMethodConfig.additionalInfoInstallmentSelection;
        }
        return payLaterMethodConfig.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPaymethodDescription() {
        return this.paymethodDescription;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAdditionalInfoPayConfirmation() {
        return this.additionalInfoPayConfirmation;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAdditionalInfoInstallmentSelection() {
        return this.additionalInfoInstallmentSelection;
    }

    public final PayLaterMethodConfig copy(@JSONField(name = "paymethod_description_payconfirmation") String paymethodDescription, @JSONField(name = "additional_info_payconfirmation") String additionalInfoPayConfirmation, @JSONField(name = "additional_info_installment_selection") String additionalInfoInstallmentSelection) {
        return new PayLaterMethodConfig(paymethodDescription, additionalInfoPayConfirmation, additionalInfoInstallmentSelection);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayLaterMethodConfig) {
            PayLaterMethodConfig payLaterMethodConfig = (PayLaterMethodConfig) other;
            return Intrinsics.areEqual(this.paymethodDescription, payLaterMethodConfig.paymethodDescription) && Intrinsics.areEqual(this.additionalInfoPayConfirmation, payLaterMethodConfig.additionalInfoPayConfirmation) && Intrinsics.areEqual(this.additionalInfoInstallmentSelection, payLaterMethodConfig.additionalInfoInstallmentSelection);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.paymethodDescription;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.additionalInfoPayConfirmation;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.additionalInfoInstallmentSelection;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayLaterMethodConfig(paymethodDescription=");
        sb.append(this.paymethodDescription);
        sb.append(", additionalInfoPayConfirmation=");
        sb.append(this.additionalInfoPayConfirmation);
        sb.append(", additionalInfoInstallmentSelection=");
        sb.append(this.additionalInfoInstallmentSelection);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.paymethodDescription);
        parcel.writeString(this.additionalInfoPayConfirmation);
        parcel.writeString(this.additionalInfoInstallmentSelection);
    }

    public PayLaterMethodConfig(@JSONField(name = "paymethod_description_payconfirmation") String str, @JSONField(name = "additional_info_payconfirmation") String str2, @JSONField(name = "additional_info_installment_selection") String str3) {
        this.paymethodDescription = str;
        this.additionalInfoPayConfirmation = str2;
        this.additionalInfoInstallmentSelection = str3;
    }

    public /* synthetic */ PayLaterMethodConfig(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getPaymethodDescription")
    public final String getPaymethodDescription() {
        return this.paymethodDescription;
    }

    @JvmName(name = "setPaymethodDescription")
    public final void setPaymethodDescription(String str) {
        this.paymethodDescription = str;
    }

    @JvmName(name = "getAdditionalInfoPayConfirmation")
    public final String getAdditionalInfoPayConfirmation() {
        return this.additionalInfoPayConfirmation;
    }

    @JvmName(name = "setAdditionalInfoPayConfirmation")
    public final void setAdditionalInfoPayConfirmation(String str) {
        this.additionalInfoPayConfirmation = str;
    }

    @JvmName(name = "getAdditionalInfoInstallmentSelection")
    public final String getAdditionalInfoInstallmentSelection() {
        return this.additionalInfoInstallmentSelection;
    }

    @JvmName(name = "setAdditionalInfoInstallmentSelection")
    public final void setAdditionalInfoInstallmentSelection(String str) {
        this.additionalInfoInstallmentSelection = str;
    }
}
