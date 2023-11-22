package id.dana.kyb.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/kyb/domain/model/KybCompressQrConfig;", "Landroid/os/Parcelable;", "", "component1", "()Z", "", "component2", "()I", "enabled", "compressRate", "copy", "(ZI)Lid/dana/kyb/domain/model/KybCompressQrConfig;", "describeContents", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getCompressRate", "Z", "getEnabled", "<init>", "(ZI)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybCompressQrConfig implements Parcelable {
    private final int compressRate;
    private final boolean enabled;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<KybCompressQrConfig> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<KybCompressQrConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final KybCompressQrConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new KybCompressQrConfig(parcel.readInt() != 0, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final KybCompressQrConfig[] newArray(int i) {
            return new KybCompressQrConfig[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KybCompressQrConfig() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.domain.model.KybCompressQrConfig.<init>():void");
    }

    public static /* synthetic */ KybCompressQrConfig copy$default(KybCompressQrConfig kybCompressQrConfig, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = kybCompressQrConfig.enabled;
        }
        if ((i2 & 2) != 0) {
            i = kybCompressQrConfig.compressRate;
        }
        return kybCompressQrConfig.copy(z, i);
    }

    @JvmStatic
    public static final KybCompressQrConfig getDefault() {
        return INSTANCE.getDefault();
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2  reason: from getter */
    public final int getCompressRate() {
        return this.compressRate;
    }

    public final KybCompressQrConfig copy(boolean enabled, int compressRate) {
        return new KybCompressQrConfig(enabled, compressRate);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybCompressQrConfig) {
            KybCompressQrConfig kybCompressQrConfig = (KybCompressQrConfig) other;
            return this.enabled == kybCompressQrConfig.enabled && this.compressRate == kybCompressQrConfig.compressRate;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.enabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.compressRate;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybCompressQrConfig(enabled=");
        sb.append(this.enabled);
        sb.append(", compressRate=");
        sb.append(this.compressRate);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeInt(this.compressRate);
    }

    public KybCompressQrConfig(boolean z, int i) {
        this.enabled = z;
        this.compressRate = i;
    }

    public /* synthetic */ KybCompressQrConfig(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? 50 : i);
    }

    @JvmName(name = "getEnabled")
    public final boolean getEnabled() {
        return this.enabled;
    }

    @JvmName(name = "getCompressRate")
    public final int getCompressRate() {
        return this.compressRate;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/kyb/domain/model/KybCompressQrConfig$Companion;", "", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "getDefault", "()Lid/dana/kyb/domain/model/KybCompressQrConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final KybCompressQrConfig getDefault() {
            boolean z = false;
            return new KybCompressQrConfig(z, z ? 1 : 0, 3, null);
        }
    }
}
