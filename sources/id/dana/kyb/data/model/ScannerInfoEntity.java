package id.dana.kyb.data.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J@\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/model/ScannerInfoEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "deviceId", "deviceIp", "deviceModel", "deviceVersion", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/data/model/ScannerInfoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDeviceId", "getDeviceIp", "getDeviceModel", "getDeviceVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ScannerInfoEntity {
    private final String deviceId;
    private final String deviceIp;
    private final String deviceModel;
    private final String deviceVersion;

    public ScannerInfoEntity() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ScannerInfoEntity copy$default(ScannerInfoEntity scannerInfoEntity, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scannerInfoEntity.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = scannerInfoEntity.deviceIp;
        }
        if ((i & 4) != 0) {
            str3 = scannerInfoEntity.deviceModel;
        }
        if ((i & 8) != 0) {
            str4 = scannerInfoEntity.deviceVersion;
        }
        return scannerInfoEntity.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDeviceIp() {
        return this.deviceIp;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* renamed from: component4  reason: from getter */
    public final String getDeviceVersion() {
        return this.deviceVersion;
    }

    public final ScannerInfoEntity copy(String deviceId, String deviceIp, String deviceModel, String deviceVersion) {
        return new ScannerInfoEntity(deviceId, deviceIp, deviceModel, deviceVersion);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ScannerInfoEntity) {
            ScannerInfoEntity scannerInfoEntity = (ScannerInfoEntity) other;
            return Intrinsics.areEqual(this.deviceId, scannerInfoEntity.deviceId) && Intrinsics.areEqual(this.deviceIp, scannerInfoEntity.deviceIp) && Intrinsics.areEqual(this.deviceModel, scannerInfoEntity.deviceModel) && Intrinsics.areEqual(this.deviceVersion, scannerInfoEntity.deviceVersion);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.deviceId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.deviceIp;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.deviceModel;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.deviceVersion;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScannerInfoEntity(deviceId=");
        sb.append(this.deviceId);
        sb.append(", deviceIp=");
        sb.append(this.deviceIp);
        sb.append(", deviceModel=");
        sb.append(this.deviceModel);
        sb.append(", deviceVersion=");
        sb.append(this.deviceVersion);
        sb.append(')');
        return sb.toString();
    }

    public ScannerInfoEntity(String str, String str2, String str3, String str4) {
        this.deviceId = str;
        this.deviceIp = str2;
        this.deviceModel = str3;
        this.deviceVersion = str4;
    }

    public /* synthetic */ ScannerInfoEntity(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @JvmName(name = "getDeviceId")
    public final String getDeviceId() {
        return this.deviceId;
    }

    @JvmName(name = "getDeviceIp")
    public final String getDeviceIp() {
        return this.deviceIp;
    }

    @JvmName(name = "getDeviceModel")
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    @JvmName(name = "getDeviceVersion")
    public final String getDeviceVersion() {
        return this.deviceVersion;
    }
}
