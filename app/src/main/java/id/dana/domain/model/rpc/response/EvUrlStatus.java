package id.dana.domain.model.rpc.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"R\"\u0010\n\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010&R\"\u0010\u000b\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010#\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010&"}, d2 = {"Lid/dana/domain/model/rpc/response/EvUrlStatus;", "Landroid/os/Parcelable;", "", "component1", "()J", "", "component2", "()Z", "component3", "callTime", "called", "complete", "copy", "(JZZ)Lid/dana/domain/model/rpc/response/EvUrlStatus;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getCallTime", "setCallTime", "(J)V", "Z", "getCalled", "setCalled", "(Z)V", "getComplete", "setComplete", "<init>", "(JZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EvUrlStatus implements Parcelable {
    public static final Parcelable.Creator<EvUrlStatus> CREATOR = new Creator();
    private long callTime;
    private boolean called;
    private boolean complete;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<EvUrlStatus> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EvUrlStatus createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new EvUrlStatus(parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EvUrlStatus[] newArray(int i) {
            return new EvUrlStatus[i];
        }
    }

    public static /* synthetic */ EvUrlStatus copy$default(EvUrlStatus evUrlStatus, long j, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = evUrlStatus.callTime;
        }
        if ((i & 2) != 0) {
            z = evUrlStatus.called;
        }
        if ((i & 4) != 0) {
            z2 = evUrlStatus.complete;
        }
        return evUrlStatus.copy(j, z, z2);
    }

    /* renamed from: component1  reason: from getter */
    public final long getCallTime() {
        return this.callTime;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getCalled() {
        return this.called;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getComplete() {
        return this.complete;
    }

    public final EvUrlStatus copy(long callTime, boolean called, boolean complete) {
        return new EvUrlStatus(callTime, called, complete);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EvUrlStatus) {
            EvUrlStatus evUrlStatus = (EvUrlStatus) other;
            return this.callTime == evUrlStatus.callTime && this.called == evUrlStatus.called && this.complete == evUrlStatus.complete;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.callTime);
        boolean z = this.called;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.complete;
        return (((m * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EvUrlStatus(callTime=");
        sb.append(this.callTime);
        sb.append(", called=");
        sb.append(this.called);
        sb.append(", complete=");
        sb.append(this.complete);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeLong(this.callTime);
        parcel.writeInt(this.called ? 1 : 0);
        parcel.writeInt(this.complete ? 1 : 0);
    }

    public EvUrlStatus(long j, boolean z, boolean z2) {
        this.callTime = j;
        this.called = z;
        this.complete = z2;
    }

    @JvmName(name = "getCallTime")
    public final long getCallTime() {
        return this.callTime;
    }

    @JvmName(name = "setCallTime")
    public final void setCallTime(long j) {
        this.callTime = j;
    }

    @JvmName(name = "getCalled")
    public final boolean getCalled() {
        return this.called;
    }

    @JvmName(name = "setCalled")
    public final void setCalled(boolean z) {
        this.called = z;
    }

    @JvmName(name = "getComplete")
    public final boolean getComplete() {
        return this.complete;
    }

    @JvmName(name = "setComplete")
    public final void setComplete(boolean z) {
        this.complete = z;
    }
}
