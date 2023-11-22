package id.dana.domain.familyaccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "maxAllMemberLimit", "maxSetMemberLimit", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMaxAllMemberLimit", "getMaxSetMemberLimit", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MaxMemberLimitConfig implements Parcelable {
    public static final Parcelable.Creator<MaxMemberLimitConfig> CREATOR = new Creator();
    private final String maxAllMemberLimit;
    private final String maxSetMemberLimit;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<MaxMemberLimitConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MaxMemberLimitConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MaxMemberLimitConfig(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MaxMemberLimitConfig[] newArray(int i) {
            return new MaxMemberLimitConfig[i];
        }
    }

    public static /* synthetic */ MaxMemberLimitConfig copy$default(MaxMemberLimitConfig maxMemberLimitConfig, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = maxMemberLimitConfig.maxAllMemberLimit;
        }
        if ((i & 2) != 0) {
            str2 = maxMemberLimitConfig.maxSetMemberLimit;
        }
        return maxMemberLimitConfig.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMaxAllMemberLimit() {
        return this.maxAllMemberLimit;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaxSetMemberLimit() {
        return this.maxSetMemberLimit;
    }

    public final MaxMemberLimitConfig copy(String maxAllMemberLimit, String maxSetMemberLimit) {
        Intrinsics.checkNotNullParameter(maxAllMemberLimit, "");
        Intrinsics.checkNotNullParameter(maxSetMemberLimit, "");
        return new MaxMemberLimitConfig(maxAllMemberLimit, maxSetMemberLimit);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MaxMemberLimitConfig) {
            MaxMemberLimitConfig maxMemberLimitConfig = (MaxMemberLimitConfig) other;
            return Intrinsics.areEqual(this.maxAllMemberLimit, maxMemberLimitConfig.maxAllMemberLimit) && Intrinsics.areEqual(this.maxSetMemberLimit, maxMemberLimitConfig.maxSetMemberLimit);
        }
        return false;
    }

    public final int hashCode() {
        return (this.maxAllMemberLimit.hashCode() * 31) + this.maxSetMemberLimit.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxMemberLimitConfig(maxAllMemberLimit=");
        sb.append(this.maxAllMemberLimit);
        sb.append(", maxSetMemberLimit=");
        sb.append(this.maxSetMemberLimit);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.maxAllMemberLimit);
        parcel.writeString(this.maxSetMemberLimit);
    }

    public MaxMemberLimitConfig(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.maxAllMemberLimit = str;
        this.maxSetMemberLimit = str2;
    }

    @JvmName(name = "getMaxAllMemberLimit")
    public final String getMaxAllMemberLimit() {
        return this.maxAllMemberLimit;
    }

    @JvmName(name = "getMaxSetMemberLimit")
    public final String getMaxSetMemberLimit() {
        return this.maxSetMemberLimit;
    }
}
