package id.dana.domain.familyaccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0014J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u000e\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\tR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010\u0004R\"\u0010\u000f\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010!\u001a\u0004\b\u000f\u0010\t\"\u0004\b%\u0010&R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b'\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b(\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", "component5", "icon", "useCase", "serviceName", "defaultAvailability", "isEnable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getDefaultAvailability", "Ljava/lang/String;", "getIcon", "setEnable", "(Z)V", "getServiceName", "getUseCase", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AvailableServicesConfig implements Parcelable {
    public static final Parcelable.Creator<AvailableServicesConfig> CREATOR = new Creator();
    private final boolean defaultAvailability;
    private final String icon;
    private boolean isEnable;
    private final String serviceName;
    private final String useCase;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<AvailableServicesConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableServicesConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new AvailableServicesConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableServicesConfig[] newArray(int i) {
            return new AvailableServicesConfig[i];
        }
    }

    public static /* synthetic */ AvailableServicesConfig copy$default(AvailableServicesConfig availableServicesConfig, String str, String str2, String str3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = availableServicesConfig.icon;
        }
        if ((i & 2) != 0) {
            str2 = availableServicesConfig.useCase;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = availableServicesConfig.serviceName;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = availableServicesConfig.defaultAvailability;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = availableServicesConfig.isEnable;
        }
        return availableServicesConfig.copy(str, str4, str5, z3, z2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUseCase() {
        return this.useCase;
    }

    /* renamed from: component3  reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getDefaultAvailability() {
        return this.defaultAvailability;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    public final AvailableServicesConfig copy(String icon, String useCase, String serviceName, boolean defaultAvailability, boolean isEnable) {
        Intrinsics.checkNotNullParameter(icon, "");
        Intrinsics.checkNotNullParameter(useCase, "");
        Intrinsics.checkNotNullParameter(serviceName, "");
        return new AvailableServicesConfig(icon, useCase, serviceName, defaultAvailability, isEnable);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AvailableServicesConfig) {
            AvailableServicesConfig availableServicesConfig = (AvailableServicesConfig) other;
            return Intrinsics.areEqual(this.icon, availableServicesConfig.icon) && Intrinsics.areEqual(this.useCase, availableServicesConfig.useCase) && Intrinsics.areEqual(this.serviceName, availableServicesConfig.serviceName) && this.defaultAvailability == availableServicesConfig.defaultAvailability && this.isEnable == availableServicesConfig.isEnable;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.icon.hashCode();
        int hashCode2 = this.useCase.hashCode();
        int hashCode3 = this.serviceName.hashCode();
        boolean z = this.defaultAvailability;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.isEnable;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AvailableServicesConfig(icon=");
        sb.append(this.icon);
        sb.append(", useCase=");
        sb.append(this.useCase);
        sb.append(", serviceName=");
        sb.append(this.serviceName);
        sb.append(", defaultAvailability=");
        sb.append(this.defaultAvailability);
        sb.append(", isEnable=");
        sb.append(this.isEnable);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.icon);
        parcel.writeString(this.useCase);
        parcel.writeString(this.serviceName);
        parcel.writeInt(this.defaultAvailability ? 1 : 0);
        parcel.writeInt(this.isEnable ? 1 : 0);
    }

    public AvailableServicesConfig(String str, String str2, String str3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.icon = str;
        this.useCase = str2;
        this.serviceName = str3;
        this.defaultAvailability = z;
        this.isEnable = z2;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getUseCase")
    public final String getUseCase() {
        return this.useCase;
    }

    @JvmName(name = "getServiceName")
    public final String getServiceName() {
        return this.serviceName;
    }

    @JvmName(name = "getDefaultAvailability")
    public final boolean getDefaultAvailability() {
        return this.defaultAvailability;
    }

    @JvmName(name = "isEnable")
    public final boolean isEnable() {
        return this.isEnable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.isEnable = z;
    }
}
