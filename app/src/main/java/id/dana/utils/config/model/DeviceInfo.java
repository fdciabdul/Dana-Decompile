package id.dana.utils.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u00015B\u008b\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010'\u0012\u0010\b\u0001\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u0010/\u001a\u0004\u0018\u00010#\u0012\u0010\b\u0001\u00100\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\f\u0012\n\b\u0001\u00101\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b3\u00104J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010\"\u001a\u0004\u0018\u00010\u001fX\u0006¢\u0006\u0006\n\u0004\b \u0010!R\u0013\u0010&\u001a\u0004\u0018\u00010#X\u0006¢\u0006\u0006\n\u0004\b$\u0010%R\u0013\u0010 \u001a\u0004\u0018\u00010'X\u0006¢\u0006\u0006\n\u0004\b&\u0010(R\u0019\u0010$\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u000f"}, d2 = {"Lid/dana/utils/config/model/DeviceInfo;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/utils/config/model/Bluetooth;", "getAuthRequestContext", "Ljava/util/List;", "PlaceComponentResult", "Lid/dana/utils/config/model/Cpu;", "MyBillsEntityDataFactory", "Lid/dana/utils/config/model/Cpu;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/config/model/Device;", "Lid/dana/utils/config/model/Device;", "Lid/dana/utils/config/model/Display;", "Lid/dana/utils/config/model/Display;", "Lid/dana/utils/config/model/ExternalStorage;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/config/model/ExternalStorage;", "Lid/dana/utils/config/model/Gps;", "scheduleImpl", "Lid/dana/utils/config/model/Gps;", "Lid/dana/utils/config/model/IP;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/utils/config/model/IP;", "getErrorConfigVersion", "Lid/dana/utils/config/model/Memory;", "moveToNextValue", "Lid/dana/utils/config/model/Memory;", "lookAheadTest", "Lid/dana/utils/config/model/SysFeature;", "Lid/dana/utils/config/model/SysFeature;", "Lid/dana/utils/config/model/Wifi;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Lid/dana/utils/config/model/IP;Lid/dana/utils/config/model/SysFeature;Ljava/util/List;Lid/dana/utils/config/model/Device;Lid/dana/utils/config/model/Display;Lid/dana/utils/config/model/Gps;Lid/dana/utils/config/model/Memory;Ljava/util/List;Lid/dana/utils/config/model/ExternalStorage;Lid/dana/utils/config/model/Cpu;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DeviceInfo {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Device getAuthRequestContext;
    public ExternalStorage KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Cpu BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public IP getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Display MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<Bluetooth> PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public List<Wifi> moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public SysFeature NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public Memory lookAheadTest;
    public Gps scheduleImpl;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001dR\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0005"}, d2 = {"Lid/dana/utils/config/model/DeviceInfo$Builder;", "", "", "Lid/dana/utils/config/model/Bluetooth;", "PlaceComponentResult", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/config/model/Cpu;", "MyBillsEntityDataFactory", "Lid/dana/utils/config/model/Cpu;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/config/model/Device;", "Lid/dana/utils/config/model/Device;", "getAuthRequestContext", "Lid/dana/utils/config/model/Display;", "Lid/dana/utils/config/model/Display;", "Lid/dana/utils/config/model/ExternalStorage;", "Lid/dana/utils/config/model/ExternalStorage;", "Lid/dana/utils/config/model/Gps;", "moveToNextValue", "Lid/dana/utils/config/model/Gps;", "Lid/dana/utils/config/model/IP;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/utils/config/model/IP;", "Lid/dana/utils/config/model/Memory;", "scheduleImpl", "Lid/dana/utils/config/model/Memory;", "lookAheadTest", "Lid/dana/utils/config/model/SysFeature;", "Lid/dana/utils/config/model/SysFeature;", "getErrorConfigVersion", "Lid/dana/utils/config/model/Wifi;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public Display MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public Device getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public Cpu BuiltInFictitiousFunctionClassFactory;
        public IP NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public ExternalStorage PlaceComponentResult;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public SysFeature getErrorConfigVersion;
        public Gps moveToNextValue;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public Memory lookAheadTest;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public List<Bluetooth> KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public List<Wifi> scheduleImpl = CollectionsKt.emptyList();
    }

    public /* synthetic */ DeviceInfo() {
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof DeviceInfo) {
            DeviceInfo deviceInfo = (DeviceInfo) p0;
            return Intrinsics.areEqual(this.getErrorConfigVersion, deviceInfo.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, deviceInfo.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.PlaceComponentResult, deviceInfo.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, deviceInfo.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, deviceInfo.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, deviceInfo.scheduleImpl) && Intrinsics.areEqual(this.lookAheadTest, deviceInfo.lookAheadTest) && Intrinsics.areEqual(this.moveToNextValue, deviceInfo.moveToNextValue) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, deviceInfo.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        IP ip = this.getErrorConfigVersion;
        int hashCode = ip == null ? 0 : ip.hashCode();
        SysFeature sysFeature = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode2 = sysFeature == null ? 0 : sysFeature.hashCode();
        List<Bluetooth> list = this.PlaceComponentResult;
        int hashCode3 = list == null ? 0 : list.hashCode();
        Device device = this.getAuthRequestContext;
        int hashCode4 = device == null ? 0 : device.hashCode();
        Display display = this.MyBillsEntityDataFactory;
        int hashCode5 = display == null ? 0 : display.hashCode();
        Gps gps = this.scheduleImpl;
        int hashCode6 = gps == null ? 0 : gps.hashCode();
        Memory memory = this.lookAheadTest;
        int hashCode7 = memory == null ? 0 : memory.hashCode();
        List<Wifi> list2 = this.moveToNextValue;
        int hashCode8 = list2 == null ? 0 : list2.hashCode();
        ExternalStorage externalStorage = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode9 = externalStorage == null ? 0 : externalStorage.hashCode();
        Cpu cpu = this.BuiltInFictitiousFunctionClassFactory;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (cpu != null ? cpu.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceInfo(getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public DeviceInfo(@JSONField(name = "IP") IP ip, @JSONField(name = "sysFeature") SysFeature sysFeature, @JSONField(name = "bluetooth") List<Bluetooth> list, @JSONField(name = "device") Device device, @JSONField(name = "display") Display display, @JSONField(name = "gps") Gps gps, @JSONField(name = "memory") Memory memory, @JSONField(name = "wifi") List<Wifi> list2, @JSONField(name = "externalStorage") ExternalStorage externalStorage, @JSONField(name = "cpu") Cpu cpu) {
        this.getErrorConfigVersion = ip;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = sysFeature;
        this.PlaceComponentResult = list;
        this.getAuthRequestContext = device;
        this.MyBillsEntityDataFactory = display;
        this.scheduleImpl = gps;
        this.lookAheadTest = memory;
        this.moveToNextValue = list2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = externalStorage;
        this.BuiltInFictitiousFunctionClassFactory = cpu;
    }
}
