package id.dana.riskChallenges.ui.resetpin.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b \u0010\u0007"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "Landroid/os/Parcelable;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "priority", CashierKeyParams.VERIFICATION_METHOD, "verificationMethodCode", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "describeContents", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getPriority", "Ljava/lang/String;", "getVerificationMethod", "getVerificationMethodCode", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VerificationMethodModel implements Parcelable {
    public static final Parcelable.Creator<VerificationMethodModel> CREATOR = new Creator();
    private final int priority;
    private final String verificationMethod;
    private final String verificationMethodCode;

    public static /* synthetic */ VerificationMethodModel copy$default(VerificationMethodModel verificationMethodModel, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = verificationMethodModel.priority;
        }
        if ((i2 & 2) != 0) {
            str = verificationMethodModel.verificationMethod;
        }
        if ((i2 & 4) != 0) {
            str2 = verificationMethodModel.verificationMethodCode;
        }
        return verificationMethodModel.copy(i, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVerificationMethodCode() {
        return this.verificationMethodCode;
    }

    public final VerificationMethodModel copy(int priority, String verificationMethod, String verificationMethodCode) {
        Intrinsics.checkNotNullParameter(verificationMethod, "");
        Intrinsics.checkNotNullParameter(verificationMethodCode, "");
        return new VerificationMethodModel(priority, verificationMethod, verificationMethodCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerificationMethodModel) {
            VerificationMethodModel verificationMethodModel = (VerificationMethodModel) other;
            return this.priority == verificationMethodModel.priority && Intrinsics.areEqual(this.verificationMethod, verificationMethodModel.verificationMethod) && Intrinsics.areEqual(this.verificationMethodCode, verificationMethodModel.verificationMethodCode);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.priority * 31) + this.verificationMethod.hashCode()) * 31) + this.verificationMethodCode.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerificationMethodModel(priority=");
        sb.append(this.priority);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", verificationMethodCode=");
        sb.append(this.verificationMethodCode);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeInt(this.priority);
        parcel.writeString(this.verificationMethod);
        parcel.writeString(this.verificationMethodCode);
    }

    public VerificationMethodModel(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.priority = i;
        this.verificationMethod = str;
        this.verificationMethodCode = str2;
    }

    @JvmName(name = "getPriority")
    public final int getPriority() {
        return this.priority;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getVerificationMethodCode")
    public final String getVerificationMethodCode() {
        return this.verificationMethodCode;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<VerificationMethodModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VerificationMethodModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new VerificationMethodModel(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VerificationMethodModel[] newArray(int i) {
            return new VerificationMethodModel[i];
        }
    }
}
