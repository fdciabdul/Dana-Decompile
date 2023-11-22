package id.dana.domain.paylater.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013"}, d2 = {"Lid/dana/domain/paylater/model/UserLoanInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "getLoanStatus", "()Ljava/lang/String;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isRegistered", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setRegistered", "(Ljava/lang/Boolean;)V", "isWhitelisted", "setWhitelisted", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserLoanInfo implements Parcelable {
    private static final String EMPTY_STRING = "";
    private static final String REGISTERED = "Registered";
    private static final String UNREGISTER = "Unregister";
    private Boolean isRegistered;
    private Boolean isWhitelisted;
    public static final Parcelable.Creator<UserLoanInfo> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<UserLoanInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserLoanInfo createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            Boolean bool = null;
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new UserLoanInfo(valueOf, bool);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserLoanInfo[] newArray(int i) {
            return new UserLoanInfo[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UserLoanInfo() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.paylater.model.UserLoanInfo.<init>():void");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        Boolean bool = this.isWhitelisted;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.isRegistered;
        if (bool2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool2.booleanValue() ? 1 : 0);
    }

    public UserLoanInfo(Boolean bool, Boolean bool2) {
        this.isWhitelisted = bool;
        this.isRegistered = bool2;
    }

    public /* synthetic */ UserLoanInfo(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2);
    }

    @JvmName(name = "isWhitelisted")
    /* renamed from: isWhitelisted  reason: from getter */
    public final Boolean getIsWhitelisted() {
        return this.isWhitelisted;
    }

    @JvmName(name = "setWhitelisted")
    public final void setWhitelisted(Boolean bool) {
        this.isWhitelisted = bool;
    }

    @JvmName(name = "isRegistered")
    /* renamed from: isRegistered  reason: from getter */
    public final Boolean getIsRegistered() {
        return this.isRegistered;
    }

    @JvmName(name = "setRegistered")
    public final void setRegistered(Boolean bool) {
        this.isRegistered = bool;
    }

    public final String getLoanStatus() {
        Boolean bool = this.isRegistered;
        if (bool == null || !Intrinsics.areEqual(bool, Boolean.TRUE)) {
            Boolean bool2 = this.isRegistered;
            return (bool2 == null || !Intrinsics.areEqual(bool2, Boolean.FALSE)) ? "" : UNREGISTER;
        }
        return REGISTERED;
    }
}
