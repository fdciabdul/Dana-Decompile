package id.dana.domain.paylater.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\r\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u000bJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001aJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b$\u0010%R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010)R$\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010-R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010.\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u00101R\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010.\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u00101"}, d2 = {"Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "", "component4", "()Ljava/lang/Boolean;", "type", "status", "dueDays", "alwaysConsult", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "isDueOrOverdue", "()Z", "isRegisteredUser", "isStatusRegistered", "isUnregisteredUser", "isWhitelistedUser", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "getAlwaysConsult", "setAlwaysConsult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Integer;", "getDueDays", "setDueDays", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "getStatus", "setStatus", "(Ljava/lang/String;)V", "getType", "setType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoanStatusWhitelist implements Parcelable {
    public static final Parcelable.Creator<LoanStatusWhitelist> CREATOR = new Creator();
    public Boolean alwaysConsult;
    public Integer dueDays;
    public String status;
    public String type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<LoanStatusWhitelist> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoanStatusWhitelist createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Boolean bool = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new LoanStatusWhitelist(readString, readString2, valueOf, bool);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoanStatusWhitelist[] newArray(int i) {
            return new LoanStatusWhitelist[i];
        }
    }

    public LoanStatusWhitelist() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ LoanStatusWhitelist copy$default(LoanStatusWhitelist loanStatusWhitelist, String str, String str2, Integer num, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loanStatusWhitelist.type;
        }
        if ((i & 2) != 0) {
            str2 = loanStatusWhitelist.status;
        }
        if ((i & 4) != 0) {
            num = loanStatusWhitelist.dueDays;
        }
        if ((i & 8) != 0) {
            bool = loanStatusWhitelist.alwaysConsult;
        }
        return loanStatusWhitelist.copy(str, str2, num, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getDueDays() {
        return this.dueDays;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getAlwaysConsult() {
        return this.alwaysConsult;
    }

    public final LoanStatusWhitelist copy(String type, String status, Integer dueDays, Boolean alwaysConsult) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(status, "");
        return new LoanStatusWhitelist(type, status, dueDays, alwaysConsult);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LoanStatusWhitelist) {
            LoanStatusWhitelist loanStatusWhitelist = (LoanStatusWhitelist) other;
            return Intrinsics.areEqual(this.type, loanStatusWhitelist.type) && Intrinsics.areEqual(this.status, loanStatusWhitelist.status) && Intrinsics.areEqual(this.dueDays, loanStatusWhitelist.dueDays) && Intrinsics.areEqual(this.alwaysConsult, loanStatusWhitelist.alwaysConsult);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.type.hashCode();
        int hashCode2 = this.status.hashCode();
        Integer num = this.dueDays;
        int hashCode3 = num == null ? 0 : num.hashCode();
        Boolean bool = this.alwaysConsult;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoanStatusWhitelist(type=");
        sb.append(this.type);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", dueDays=");
        sb.append(this.dueDays);
        sb.append(", alwaysConsult=");
        sb.append(this.alwaysConsult);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.type);
        parcel.writeString(this.status);
        Integer num = this.dueDays;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Boolean bool = this.alwaysConsult;
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public LoanStatusWhitelist(String str, String str2, Integer num, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.type = str;
        this.status = str2;
        this.dueDays = num;
        this.alwaysConsult = bool;
    }

    public /* synthetic */ LoanStatusWhitelist(String str, String str2, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : bool);
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

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.status = str;
    }

    @JvmName(name = "getDueDays")
    public final Integer getDueDays() {
        return this.dueDays;
    }

    @JvmName(name = "setDueDays")
    public final void setDueDays(Integer num) {
        this.dueDays = num;
    }

    @JvmName(name = "getAlwaysConsult")
    public final Boolean getAlwaysConsult() {
        return this.alwaysConsult;
    }

    @JvmName(name = "setAlwaysConsult")
    public final void setAlwaysConsult(Boolean bool) {
        this.alwaysConsult = bool;
    }

    public final Boolean isStatusRegistered() {
        if (isRegisteredUser()) {
            return Boolean.TRUE;
        }
        if (isUnregisteredUser()) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final boolean isWhitelistedUser() {
        return !StringsKt.contains((CharSequence) this.status, (CharSequence) "off", true);
    }

    public final boolean isUnregisteredUser() {
        return isWhitelistedUser() && StringsKt.contains((CharSequence) this.status, (CharSequence) "unregistered", true);
    }

    private final boolean isRegisteredUser() {
        return isWhitelistedUser() && (StringsKt.contains((CharSequence) this.status, (CharSequence) "active", true) || StringsKt.contains((CharSequence) this.status, (CharSequence) "due", true) || StringsKt.contains((CharSequence) this.status, (CharSequence) "overdue", true));
    }

    public final boolean isDueOrOverdue() {
        return isWhitelistedUser() && (StringsKt.contains((CharSequence) this.status, (CharSequence) "due", true) || StringsKt.contains((CharSequence) this.status, (CharSequence) "overdue", true));
    }
}
