package id.dana.domain.paylater.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 +2\u00020\u0001:\u0001+B3\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010("}, d2 = {"Lid/dana/domain/paylater/model/LoanInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "isUserWLRegistered", "()Z", "isUserWLUnknown", "isUserWLUnregistered", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "billDueDate", "Ljava/lang/Long;", "getBillDueDate", "()Ljava/lang/Long;", "setBillDueDate", "(Ljava/lang/Long;)V", "registered", "Ljava/lang/Boolean;", "getRegistered", "()Ljava/lang/Boolean;", "setRegistered", "(Ljava/lang/Boolean;)V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "whitelist", "Z", "getWhitelist", "setWhitelist", "(Z)V", "<init>", "(ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoanInfo implements Parcelable {
    public static final String LOAN_PERSONAL = "LOAN_PERSONAL";
    public static final String SERVICE_PAYLATER = "service_paylater";
    public static final String SETTING_PAYLATER = "setting_paylater";
    public Long billDueDate;
    public Boolean registered;
    public String type;
    public boolean whitelist;
    public static final Parcelable.Creator<LoanInfo> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<LoanInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoanInfo createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            boolean z = parcel.readInt() != 0;
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new LoanInfo(z, readString, valueOf, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoanInfo[] newArray(int i) {
            return new LoanInfo[i];
        }
    }

    public LoanInfo() {
        this(false, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeInt(this.whitelist ? 1 : 0);
        parcel.writeString(this.type);
        Boolean bool = this.registered;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Long l = this.billDueDate;
        if (l == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeLong(l.longValue());
    }

    public LoanInfo(boolean z, String str, Boolean bool, Long l) {
        Intrinsics.checkNotNullParameter(str, "");
        this.whitelist = z;
        this.type = str;
        this.registered = bool;
        this.billDueDate = l;
    }

    public /* synthetic */ LoanInfo(boolean z, String str, Boolean bool, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : l);
    }

    @JvmName(name = "getWhitelist")
    public final boolean getWhitelist() {
        return this.whitelist;
    }

    @JvmName(name = "setWhitelist")
    public final void setWhitelist(boolean z) {
        this.whitelist = z;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.type = str;
    }

    @JvmName(name = "getRegistered")
    public final Boolean getRegistered() {
        return this.registered;
    }

    @JvmName(name = "setRegistered")
    public final void setRegistered(Boolean bool) {
        this.registered = bool;
    }

    @JvmName(name = "getBillDueDate")
    public final Long getBillDueDate() {
        return this.billDueDate;
    }

    @JvmName(name = "setBillDueDate")
    public final void setBillDueDate(Long l) {
        this.billDueDate = l;
    }

    public final boolean isUserWLUnknown() {
        return this.whitelist && this.registered == null && this.billDueDate == null;
    }

    public final boolean isUserWLUnregistered() {
        return this.whitelist && Intrinsics.areEqual(this.registered, Boolean.FALSE) && this.billDueDate == null;
    }

    public final boolean isUserWLRegistered() {
        if (this.whitelist && Intrinsics.areEqual(this.registered, Boolean.TRUE)) {
            return true;
        }
        return this.whitelist && this.billDueDate != null;
    }
}
