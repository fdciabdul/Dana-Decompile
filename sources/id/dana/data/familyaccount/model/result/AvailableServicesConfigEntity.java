package id.dana.data.familyaccount.model.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0017\u0010\u000e\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/data/familyaccount/model/result/AvailableServicesConfigEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", "component5", "icon", "useCase", "serviceName", "defaultAvailability", "isEnable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lid/dana/data/familyaccount/model/result/AvailableServicesConfigEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getDefaultAvailability", "Ljava/lang/String;", "getIcon", "getServiceName", "getUseCase", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AvailableServicesConfigEntity {
    private final boolean defaultAvailability;
    private final String icon;
    private final boolean isEnable;
    private final String serviceName;
    private final String useCase;

    public static /* synthetic */ AvailableServicesConfigEntity copy$default(AvailableServicesConfigEntity availableServicesConfigEntity, String str, String str2, String str3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = availableServicesConfigEntity.icon;
        }
        if ((i & 2) != 0) {
            str2 = availableServicesConfigEntity.useCase;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = availableServicesConfigEntity.serviceName;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = availableServicesConfigEntity.defaultAvailability;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = availableServicesConfigEntity.isEnable;
        }
        return availableServicesConfigEntity.copy(str, str4, str5, z3, z2);
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

    public final AvailableServicesConfigEntity copy(String icon, String useCase, String serviceName, boolean defaultAvailability, boolean isEnable) {
        Intrinsics.checkNotNullParameter(icon, "");
        Intrinsics.checkNotNullParameter(useCase, "");
        Intrinsics.checkNotNullParameter(serviceName, "");
        return new AvailableServicesConfigEntity(icon, useCase, serviceName, defaultAvailability, isEnable);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AvailableServicesConfigEntity) {
            AvailableServicesConfigEntity availableServicesConfigEntity = (AvailableServicesConfigEntity) other;
            return Intrinsics.areEqual(this.icon, availableServicesConfigEntity.icon) && Intrinsics.areEqual(this.useCase, availableServicesConfigEntity.useCase) && Intrinsics.areEqual(this.serviceName, availableServicesConfigEntity.serviceName) && this.defaultAvailability == availableServicesConfigEntity.defaultAvailability && this.isEnable == availableServicesConfigEntity.isEnable;
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
        sb.append("AvailableServicesConfigEntity(icon=");
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

    public AvailableServicesConfigEntity(String str, String str2, String str3, boolean z, boolean z2) {
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
}
