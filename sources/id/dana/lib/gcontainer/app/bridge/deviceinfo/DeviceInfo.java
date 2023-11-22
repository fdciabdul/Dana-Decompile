package id.dana.lib.gcontainer.app.bridge.deviceinfo;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.alipay.mobile.zebra.data.ZebraData;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.data.toggle.traffictype.TrafficType;
import id.dana.domain.notificationcenter.interactor.ConnectionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001:\n^_`abcdefgB\u0091\u0001\b\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0003\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u001d\u0012\u0012\b\u0003\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\\\u0010]J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0098\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\t2\u0012\b\u0003\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00052\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00172\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u001a2\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u001d2\u0012\b\u0003\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010.\u001a\u00020-2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00101\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00104\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105R,\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00106\u001a\u0004\b7\u0010\b\"\u0004\b8\u00109R$\u0010#\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010:\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010=R$\u0010$\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010>\u001a\u0004\b?\u0010\u0013\"\u0004\b@\u0010AR$\u0010%\u001a\u0004\u0018\u00010\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010B\u001a\u0004\bC\u0010\u0016\"\u0004\bD\u0010ER$\u0010&\u001a\u0004\u0018\u00010\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010F\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010IR$\u0010'\u001a\u0004\u0018\u00010\u001a8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010J\u001a\u0004\bK\u0010\u001c\"\u0004\bL\u0010MR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010N\u001a\u0004\bO\u0010\u0004\"\u0004\bP\u0010QR$\u0010(\u001a\u0004\u0018\u00010\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010R\u001a\u0004\bS\u0010\u001f\"\u0004\bT\u0010UR$\u0010!\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010V\u001a\u0004\bW\u0010\u000b\"\u0004\bX\u0010YR,\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u00106\u001a\u0004\bZ\u0010\b\"\u0004\b[\u00109"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo;", "", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$IPAddress;", "component1", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$IPAddress;", "", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Wifi;", "component10", "()Ljava/util/List;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$SysFeature;", "component2", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$SysFeature;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Bluetooth;", "component3", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Cpu;", "component4", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Cpu;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device;", "component5", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Display;", "component6", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Display;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$ExternalStorage;", "component7", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$ExternalStorage;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Gps;", "component8", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Gps;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Memory;", "component9", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Memory;", "ipAddress", "sysFeature", TinyAppActionState.ACTION_BLUE_TOOTH, "cpu", "device", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "externalStorage", "gps", "memory", "wifi", "copy", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$IPAddress;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$SysFeature;Ljava/util/List;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Cpu;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Display;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$ExternalStorage;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Gps;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Memory;Ljava/util/List;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getBluetooth", "setBluetooth", "(Ljava/util/List;)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Cpu;", "getCpu", "setCpu", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Cpu;)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device;", "getDevice", "setDevice", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device;)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Display;", "getDisplay", "setDisplay", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Display;)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$ExternalStorage;", "getExternalStorage", "setExternalStorage", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$ExternalStorage;)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Gps;", "getGps", "setGps", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Gps;)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$IPAddress;", "getIpAddress", "setIpAddress", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$IPAddress;)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Memory;", "getMemory", "setMemory", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Memory;)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$SysFeature;", "getSysFeature", "setSysFeature", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$SysFeature;)V", "getWifi", "setWifi", "<init>", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$IPAddress;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$SysFeature;Ljava/util/List;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Cpu;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Display;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$ExternalStorage;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Gps;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Memory;Ljava/util/List;)V", ConnectionType.BLUETOOTH, "Cpu", TrafficType.DEVICE, "Display", "ExternalStorage", "Gps", "IPAddress", "Memory", "SysFeature", ConnectionType.TYPE_WIFI}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DeviceInfo {
    private List<Bluetooth> bluetooth;
    private Cpu cpu;
    private Device device;
    private Display display;
    private ExternalStorage externalStorage;
    private Gps gps;
    @JSONField(name = "IP")
    private IPAddress ipAddress;
    private Memory memory;
    private SysFeature sysFeature;
    private List<Wifi> wifi;

    @JSONCreator
    public DeviceInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1  reason: from getter */
    public final IPAddress getIpAddress() {
        return this.ipAddress;
    }

    public final List<Wifi> component10() {
        return this.wifi;
    }

    /* renamed from: component2  reason: from getter */
    public final SysFeature getSysFeature() {
        return this.sysFeature;
    }

    public final List<Bluetooth> component3() {
        return this.bluetooth;
    }

    /* renamed from: component4  reason: from getter */
    public final Cpu getCpu() {
        return this.cpu;
    }

    /* renamed from: component5  reason: from getter */
    public final Device getDevice() {
        return this.device;
    }

    /* renamed from: component6  reason: from getter */
    public final Display getDisplay() {
        return this.display;
    }

    /* renamed from: component7  reason: from getter */
    public final ExternalStorage getExternalStorage() {
        return this.externalStorage;
    }

    /* renamed from: component8  reason: from getter */
    public final Gps getGps() {
        return this.gps;
    }

    /* renamed from: component9  reason: from getter */
    public final Memory getMemory() {
        return this.memory;
    }

    public final DeviceInfo copy(IPAddress ipAddress, @JSONField(name = "SysFeature") SysFeature sysFeature, @JSONField(name = "bluetooth") List<Bluetooth> bluetooth, @JSONField(name = "cpu") Cpu cpu, @JSONField(name = "device") Device device, @JSONField(name = "display") Display display, @JSONField(name = "externalStorage") ExternalStorage externalStorage, @JSONField(name = "gps") Gps gps, @JSONField(name = "memory") Memory memory, @JSONField(name = "wifi") List<Wifi> wifi) {
        return new DeviceInfo(ipAddress, sysFeature, bluetooth, cpu, device, display, externalStorage, gps, memory, wifi);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DeviceInfo) {
            DeviceInfo deviceInfo = (DeviceInfo) other;
            return Intrinsics.areEqual(this.ipAddress, deviceInfo.ipAddress) && Intrinsics.areEqual(this.sysFeature, deviceInfo.sysFeature) && Intrinsics.areEqual(this.bluetooth, deviceInfo.bluetooth) && Intrinsics.areEqual(this.cpu, deviceInfo.cpu) && Intrinsics.areEqual(this.device, deviceInfo.device) && Intrinsics.areEqual(this.display, deviceInfo.display) && Intrinsics.areEqual(this.externalStorage, deviceInfo.externalStorage) && Intrinsics.areEqual(this.gps, deviceInfo.gps) && Intrinsics.areEqual(this.memory, deviceInfo.memory) && Intrinsics.areEqual(this.wifi, deviceInfo.wifi);
        }
        return false;
    }

    public final int hashCode() {
        IPAddress iPAddress = this.ipAddress;
        int hashCode = iPAddress == null ? 0 : iPAddress.hashCode();
        SysFeature sysFeature = this.sysFeature;
        int hashCode2 = sysFeature == null ? 0 : sysFeature.hashCode();
        List<Bluetooth> list = this.bluetooth;
        int hashCode3 = list == null ? 0 : list.hashCode();
        Cpu cpu = this.cpu;
        int hashCode4 = cpu == null ? 0 : cpu.hashCode();
        Device device = this.device;
        int hashCode5 = device == null ? 0 : device.hashCode();
        Display display = this.display;
        int hashCode6 = display == null ? 0 : display.hashCode();
        ExternalStorage externalStorage = this.externalStorage;
        int hashCode7 = externalStorage == null ? 0 : externalStorage.hashCode();
        Gps gps = this.gps;
        int hashCode8 = gps == null ? 0 : gps.hashCode();
        Memory memory = this.memory;
        int hashCode9 = memory == null ? 0 : memory.hashCode();
        List<Wifi> list2 = this.wifi;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceInfo(ipAddress=");
        sb.append(this.ipAddress);
        sb.append(", sysFeature=");
        sb.append(this.sysFeature);
        sb.append(", bluetooth=");
        sb.append(this.bluetooth);
        sb.append(", cpu=");
        sb.append(this.cpu);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", display=");
        sb.append(this.display);
        sb.append(", externalStorage=");
        sb.append(this.externalStorage);
        sb.append(", gps=");
        sb.append(this.gps);
        sb.append(", memory=");
        sb.append(this.memory);
        sb.append(", wifi=");
        sb.append(this.wifi);
        sb.append(')');
        return sb.toString();
    }

    @JSONCreator
    public DeviceInfo(IPAddress iPAddress, @JSONField(name = "SysFeature") SysFeature sysFeature, @JSONField(name = "bluetooth") List<Bluetooth> list, @JSONField(name = "cpu") Cpu cpu, @JSONField(name = "device") Device device, @JSONField(name = "display") Display display, @JSONField(name = "externalStorage") ExternalStorage externalStorage, @JSONField(name = "gps") Gps gps, @JSONField(name = "memory") Memory memory, @JSONField(name = "wifi") List<Wifi> list2) {
        this.ipAddress = iPAddress;
        this.sysFeature = sysFeature;
        this.bluetooth = list;
        this.cpu = cpu;
        this.device = device;
        this.display = display;
        this.externalStorage = externalStorage;
        this.gps = gps;
        this.memory = memory;
        this.wifi = list2;
    }

    public /* synthetic */ DeviceInfo(IPAddress iPAddress, SysFeature sysFeature, List list, Cpu cpu, Device device, Display display, ExternalStorage externalStorage, Gps gps, Memory memory, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iPAddress, (i & 2) != 0 ? null : sysFeature, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : cpu, (i & 16) != 0 ? null : device, (i & 32) != 0 ? null : display, (i & 64) != 0 ? null : externalStorage, (i & 128) != 0 ? null : gps, (i & 256) != 0 ? null : memory, (i & 512) == 0 ? list2 : null);
    }

    @JvmName(name = "getIpAddress")
    public final IPAddress getIpAddress() {
        return this.ipAddress;
    }

    @JvmName(name = "setIpAddress")
    public final void setIpAddress(IPAddress iPAddress) {
        this.ipAddress = iPAddress;
    }

    @JvmName(name = "getSysFeature")
    public final SysFeature getSysFeature() {
        return this.sysFeature;
    }

    @JvmName(name = "setSysFeature")
    public final void setSysFeature(SysFeature sysFeature) {
        this.sysFeature = sysFeature;
    }

    @JvmName(name = "getBluetooth")
    public final List<Bluetooth> getBluetooth() {
        return this.bluetooth;
    }

    @JvmName(name = "setBluetooth")
    public final void setBluetooth(List<Bluetooth> list) {
        this.bluetooth = list;
    }

    @JvmName(name = "getCpu")
    public final Cpu getCpu() {
        return this.cpu;
    }

    @JvmName(name = "setCpu")
    public final void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    @JvmName(name = "getDevice")
    public final Device getDevice() {
        return this.device;
    }

    @JvmName(name = "setDevice")
    public final void setDevice(Device device) {
        this.device = device;
    }

    @JvmName(name = "getDisplay")
    public final Display getDisplay() {
        return this.display;
    }

    @JvmName(name = "setDisplay")
    public final void setDisplay(Display display) {
        this.display = display;
    }

    @JvmName(name = "getExternalStorage")
    public final ExternalStorage getExternalStorage() {
        return this.externalStorage;
    }

    @JvmName(name = "setExternalStorage")
    public final void setExternalStorage(ExternalStorage externalStorage) {
        this.externalStorage = externalStorage;
    }

    @JvmName(name = "getGps")
    public final Gps getGps() {
        return this.gps;
    }

    @JvmName(name = "setGps")
    public final void setGps(Gps gps) {
        this.gps = gps;
    }

    @JvmName(name = "getMemory")
    public final Memory getMemory() {
        return this.memory;
    }

    @JvmName(name = "setMemory")
    public final void setMemory(Memory memory) {
        this.memory = memory;
    }

    @JvmName(name = "getWifi")
    public final List<Wifi> getWifi() {
        return this.wifi;
    }

    @JvmName(name = "setWifi")
    public final void setWifi(List<Wifi> list) {
        this.wifi = list;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0010\u001a\u00020\t\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JF\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000f\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\t2\b\b\u0003\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR\"\u0010\u000f\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010!R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010\u001dR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010\u001dR\"\u0010\u0010\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010)"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Gps;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "", "component4", "()J", "component5", "latitude", "longitude", "error", "time", "cityName", "copy", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Gps;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getCityName", "setCityName", "(Ljava/lang/String;)V", "I", "getError", "setError", "(I)V", "getLatitude", "setLatitude", "getLongitude", "setLongitude", "J", "getTime", "setTime", "(J)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Gps {
        private String cityName;
        private int error;
        private String latitude;
        private String longitude;
        private long time;

        @JSONCreator
        public Gps() {
            this(null, null, 0, 0L, null, 31, null);
        }

        public static /* synthetic */ Gps copy$default(Gps gps, String str, String str2, int i, long j, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = gps.latitude;
            }
            if ((i2 & 2) != 0) {
                str2 = gps.longitude;
            }
            String str4 = str2;
            if ((i2 & 4) != 0) {
                i = gps.error;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                j = gps.time;
            }
            long j2 = j;
            if ((i2 & 16) != 0) {
                str3 = gps.cityName;
            }
            return gps.copy(str, str4, i3, j2, str3);
        }

        /* renamed from: component1  reason: from getter */
        public final String getLatitude() {
            return this.latitude;
        }

        /* renamed from: component2  reason: from getter */
        public final String getLongitude() {
            return this.longitude;
        }

        /* renamed from: component3  reason: from getter */
        public final int getError() {
            return this.error;
        }

        /* renamed from: component4  reason: from getter */
        public final long getTime() {
            return this.time;
        }

        /* renamed from: component5  reason: from getter */
        public final String getCityName() {
            return this.cityName;
        }

        public final Gps copy(@JSONField(name = "latitude") String latitude, @JSONField(name = "longitude") String longitude, @JSONField(name = "error") int error, @JSONField(name = "time") long time, @JSONField(name = "cityName") String cityName) {
            Intrinsics.checkNotNullParameter(cityName, "");
            return new Gps(latitude, longitude, error, time, cityName);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Gps) {
                Gps gps = (Gps) other;
                return Intrinsics.areEqual(this.latitude, gps.latitude) && Intrinsics.areEqual(this.longitude, gps.longitude) && this.error == gps.error && this.time == gps.time && Intrinsics.areEqual(this.cityName, gps.cityName);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.latitude;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.longitude;
            return (((((((hashCode * 31) + (str2 != null ? str2.hashCode() : 0)) * 31) + this.error) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.time)) * 31) + this.cityName.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Gps(latitude=");
            sb.append((Object) this.latitude);
            sb.append(", longitude=");
            sb.append((Object) this.longitude);
            sb.append(", error=");
            sb.append(this.error);
            sb.append(", time=");
            sb.append(this.time);
            sb.append(", cityName=");
            sb.append(this.cityName);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public Gps(@JSONField(name = "latitude") String str, @JSONField(name = "longitude") String str2, @JSONField(name = "error") int i, @JSONField(name = "time") long j, @JSONField(name = "cityName") String str3) {
            Intrinsics.checkNotNullParameter(str3, "");
            this.latitude = str;
            this.longitude = str2;
            this.error = i;
            this.time = j;
            this.cityName = str3;
        }

        public /* synthetic */ Gps(String str, String str2, int i, long j, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) == 0 ? str2 : null, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? "" : str3);
        }

        @JvmName(name = "getLatitude")
        public final String getLatitude() {
            return this.latitude;
        }

        @JvmName(name = "setLatitude")
        public final void setLatitude(String str) {
            this.latitude = str;
        }

        @JvmName(name = "getLongitude")
        public final String getLongitude() {
            return this.longitude;
        }

        @JvmName(name = "setLongitude")
        public final void setLongitude(String str) {
            this.longitude = str;
        }

        @JvmName(name = "getError")
        public final int getError() {
            return this.error;
        }

        @JvmName(name = "setError")
        public final void setError(int i) {
            this.error = i;
        }

        @JvmName(name = "getTime")
        public final long getTime() {
            return this.time;
        }

        @JvmName(name = "setTime")
        public final void setTime(long j) {
            this.time = j;
        }

        @JvmName(name = "getCityName")
        public final String getCityName() {
            return this.cityName;
        }

        @JvmName(name = "setCityName")
        public final void setCityName(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.cityName = str;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bY\b\u0086\b\u0018\u00002\u00020\u0001:\u0001mBÿ\u0001\b\u0007\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\n\u0012\b\b\u0002\u0010.\u001a\u00020\n\u0012\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u00101\u001a\u00020\u0010\u0012\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0003\u00103\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bk\u0010lJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0086\u0002\u00104\u001a\u00020\u00002\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010-\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\n2\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u00101\u001a\u00020\u00102\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b9\u0010\u0012J\u0010\u0010:\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b:\u0010\u0004R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010;\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010>R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010;\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u0010>R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010;\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u0010>R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010;\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u0010>R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010;\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u0010>R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010;\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u0010>R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010;\u001a\u0004\bI\u0010\u0004\"\u0004\bJ\u0010>R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010;\u001a\u0004\bK\u0010\u0004\"\u0004\bL\u0010>R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010;\u001a\u0004\bM\u0010\u0004\"\u0004\bN\u0010>R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010;\u001a\u0004\bO\u0010\u0004\"\u0004\bP\u0010>R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010;\u001a\u0004\bQ\u0010\u0004\"\u0004\bR\u0010>R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010;\u001a\u0004\bS\u0010\u0004\"\u0004\bT\u0010>R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010;\u001a\u0004\bU\u0010\u0004\"\u0004\bV\u0010>R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010;\u001a\u0004\bW\u0010\u0004\"\u0004\bX\u0010>R\"\u0010-\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010Y\u001a\u0004\b-\u0010\f\"\u0004\bZ\u0010[R\"\u0010.\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010Y\u001a\u0004\b.\u0010\f\"\u0004\b\\\u0010[R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010;\u001a\u0004\b]\u0010\u0004\"\u0004\b^\u0010>R$\u00100\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010;\u001a\u0004\b_\u0010\u0004\"\u0004\b`\u0010>R\"\u00101\u001a\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010a\u001a\u0004\bb\u0010\u0012\"\u0004\bc\u0010dR$\u00102\u001a\u0004\u0018\u00010\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010e\u001a\u0004\bf\u0010\u0016\"\u0004\bg\u0010hR$\u00103\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010;\u001a\u0004\bi\u0010\u0004\"\u0004\bj\u0010>"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "", "component15", "()Z", "component16", "component17", "component18", "", "component19", "()I", "component2", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device$TimeLocation;", "component20", "()Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device$TimeLocation;", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "androidId", "appVersion", "blueMac", "buildBoard", "buildBootloader", "buildBrand", "buildDevice", "buildManufacturer", "buildModel", "buildProduct", "buildSerial", "deviceId", "fingerPrint", "imei", "isEmulator", "isRooted", "networkType", "osVersion", "osVersionInt", "timeLocation", "utdidAdvertisementId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device$TimeLocation;Ljava/lang/String;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getAndroidId", "setAndroidId", "(Ljava/lang/String;)V", "getAppVersion", "setAppVersion", "getBlueMac", "setBlueMac", "getBuildBoard", "setBuildBoard", "getBuildBootloader", "setBuildBootloader", "getBuildBrand", "setBuildBrand", "getBuildDevice", "setBuildDevice", "getBuildManufacturer", "setBuildManufacturer", "getBuildModel", "setBuildModel", "getBuildProduct", "setBuildProduct", "getBuildSerial", "setBuildSerial", "getDeviceId", "setDeviceId", "getFingerPrint", "setFingerPrint", "getImei", "setImei", "Z", "setEmulator", "(Z)V", "setRooted", "getNetworkType", "setNetworkType", "getOsVersion", "setOsVersion", "I", "getOsVersionInt", "setOsVersionInt", "(I)V", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device$TimeLocation;", "getTimeLocation", "setTimeLocation", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device$TimeLocation;)V", "getUtdidAdvertisementId", "setUtdidAdvertisementId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device$TimeLocation;Ljava/lang/String;)V", "TimeLocation"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Device {
        private String androidId;
        private String appVersion;
        private String blueMac;
        private String buildBoard;
        private String buildBootloader;
        private String buildBrand;
        private String buildDevice;
        private String buildManufacturer;
        private String buildModel;
        private String buildProduct;
        private String buildSerial;
        private String deviceId;
        private String fingerPrint;
        private String imei;
        @JSONField(name = "isEmulator")
        private boolean isEmulator;
        @JSONField(name = "isRooted")
        private boolean isRooted;
        private String networkType;
        private String osVersion;
        private int osVersionInt;
        private TimeLocation timeLocation;
        private String utdidAdvertisementId;

        @JSONCreator
        public Device() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, 0, null, null, 2097151, null);
        }

        /* renamed from: component1  reason: from getter */
        public final String getAndroidId() {
            return this.androidId;
        }

        /* renamed from: component10  reason: from getter */
        public final String getBuildProduct() {
            return this.buildProduct;
        }

        /* renamed from: component11  reason: from getter */
        public final String getBuildSerial() {
            return this.buildSerial;
        }

        /* renamed from: component12  reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* renamed from: component13  reason: from getter */
        public final String getFingerPrint() {
            return this.fingerPrint;
        }

        /* renamed from: component14  reason: from getter */
        public final String getImei() {
            return this.imei;
        }

        /* renamed from: component15  reason: from getter */
        public final boolean getIsEmulator() {
            return this.isEmulator;
        }

        /* renamed from: component16  reason: from getter */
        public final boolean getIsRooted() {
            return this.isRooted;
        }

        /* renamed from: component17  reason: from getter */
        public final String getNetworkType() {
            return this.networkType;
        }

        /* renamed from: component18  reason: from getter */
        public final String getOsVersion() {
            return this.osVersion;
        }

        /* renamed from: component19  reason: from getter */
        public final int getOsVersionInt() {
            return this.osVersionInt;
        }

        /* renamed from: component2  reason: from getter */
        public final String getAppVersion() {
            return this.appVersion;
        }

        /* renamed from: component20  reason: from getter */
        public final TimeLocation getTimeLocation() {
            return this.timeLocation;
        }

        /* renamed from: component21  reason: from getter */
        public final String getUtdidAdvertisementId() {
            return this.utdidAdvertisementId;
        }

        /* renamed from: component3  reason: from getter */
        public final String getBlueMac() {
            return this.blueMac;
        }

        /* renamed from: component4  reason: from getter */
        public final String getBuildBoard() {
            return this.buildBoard;
        }

        /* renamed from: component5  reason: from getter */
        public final String getBuildBootloader() {
            return this.buildBootloader;
        }

        /* renamed from: component6  reason: from getter */
        public final String getBuildBrand() {
            return this.buildBrand;
        }

        /* renamed from: component7  reason: from getter */
        public final String getBuildDevice() {
            return this.buildDevice;
        }

        /* renamed from: component8  reason: from getter */
        public final String getBuildManufacturer() {
            return this.buildManufacturer;
        }

        /* renamed from: component9  reason: from getter */
        public final String getBuildModel() {
            return this.buildModel;
        }

        public final Device copy(@JSONField(name = "androidId") String androidId, @JSONField(name = "appVersion") String appVersion, @JSONField(name = "blueMac") String blueMac, @JSONField(name = "buildBoard") String buildBoard, @JSONField(name = "buildBootloader") String buildBootloader, @JSONField(name = "buildBrand") String buildBrand, @JSONField(name = "buildDevice") String buildDevice, @JSONField(name = "buildManufacturer") String buildManufacturer, @JSONField(name = "buildModel") String buildModel, @JSONField(name = "buildProduct") String buildProduct, @JSONField(name = "buildSerial") String buildSerial, @JSONField(name = "device_id") String deviceId, @JSONField(name = "fingerPrint") String fingerPrint, @JSONField(name = "imei") String imei, boolean isEmulator, boolean isRooted, @JSONField(name = "networkType") String networkType, @JSONField(name = "osVersion") String osVersion, @JSONField(name = "osVersionInt") int osVersionInt, @JSONField(name = "timeLocation") TimeLocation timeLocation, @JSONField(name = "utdidAdvertisementId") String utdidAdvertisementId) {
            return new Device(androidId, appVersion, blueMac, buildBoard, buildBootloader, buildBrand, buildDevice, buildManufacturer, buildModel, buildProduct, buildSerial, deviceId, fingerPrint, imei, isEmulator, isRooted, networkType, osVersion, osVersionInt, timeLocation, utdidAdvertisementId);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Device) {
                Device device = (Device) other;
                return Intrinsics.areEqual(this.androidId, device.androidId) && Intrinsics.areEqual(this.appVersion, device.appVersion) && Intrinsics.areEqual(this.blueMac, device.blueMac) && Intrinsics.areEqual(this.buildBoard, device.buildBoard) && Intrinsics.areEqual(this.buildBootloader, device.buildBootloader) && Intrinsics.areEqual(this.buildBrand, device.buildBrand) && Intrinsics.areEqual(this.buildDevice, device.buildDevice) && Intrinsics.areEqual(this.buildManufacturer, device.buildManufacturer) && Intrinsics.areEqual(this.buildModel, device.buildModel) && Intrinsics.areEqual(this.buildProduct, device.buildProduct) && Intrinsics.areEqual(this.buildSerial, device.buildSerial) && Intrinsics.areEqual(this.deviceId, device.deviceId) && Intrinsics.areEqual(this.fingerPrint, device.fingerPrint) && Intrinsics.areEqual(this.imei, device.imei) && this.isEmulator == device.isEmulator && this.isRooted == device.isRooted && Intrinsics.areEqual(this.networkType, device.networkType) && Intrinsics.areEqual(this.osVersion, device.osVersion) && this.osVersionInt == device.osVersionInt && Intrinsics.areEqual(this.timeLocation, device.timeLocation) && Intrinsics.areEqual(this.utdidAdvertisementId, device.utdidAdvertisementId);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.androidId;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.appVersion;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.blueMac;
            int hashCode3 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.buildBoard;
            int hashCode4 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.buildBootloader;
            int hashCode5 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.buildBrand;
            int hashCode6 = str6 == null ? 0 : str6.hashCode();
            String str7 = this.buildDevice;
            int hashCode7 = str7 == null ? 0 : str7.hashCode();
            String str8 = this.buildManufacturer;
            int hashCode8 = str8 == null ? 0 : str8.hashCode();
            String str9 = this.buildModel;
            int hashCode9 = str9 == null ? 0 : str9.hashCode();
            String str10 = this.buildProduct;
            int hashCode10 = str10 == null ? 0 : str10.hashCode();
            String str11 = this.buildSerial;
            int hashCode11 = str11 == null ? 0 : str11.hashCode();
            String str12 = this.deviceId;
            int hashCode12 = str12 == null ? 0 : str12.hashCode();
            String str13 = this.fingerPrint;
            int hashCode13 = str13 == null ? 0 : str13.hashCode();
            String str14 = this.imei;
            int hashCode14 = str14 == null ? 0 : str14.hashCode();
            boolean z = this.isEmulator;
            int i = z ? 1 : z ? 1 : 0;
            boolean z2 = this.isRooted;
            int i2 = z2 ? 1 : z2 ? 1 : 0;
            String str15 = this.networkType;
            int hashCode15 = str15 == null ? 0 : str15.hashCode();
            String str16 = this.osVersion;
            int hashCode16 = str16 == null ? 0 : str16.hashCode();
            int i3 = this.osVersionInt;
            TimeLocation timeLocation = this.timeLocation;
            int hashCode17 = timeLocation == null ? 0 : timeLocation.hashCode();
            String str17 = this.utdidAdvertisementId;
            return (((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + i) * 31) + i2) * 31) + hashCode15) * 31) + hashCode16) * 31) + i3) * 31) + hashCode17) * 31) + (str17 != null ? str17.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Device(androidId=");
            sb.append((Object) this.androidId);
            sb.append(", appVersion=");
            sb.append((Object) this.appVersion);
            sb.append(", blueMac=");
            sb.append((Object) this.blueMac);
            sb.append(", buildBoard=");
            sb.append((Object) this.buildBoard);
            sb.append(", buildBootloader=");
            sb.append((Object) this.buildBootloader);
            sb.append(", buildBrand=");
            sb.append((Object) this.buildBrand);
            sb.append(", buildDevice=");
            sb.append((Object) this.buildDevice);
            sb.append(", buildManufacturer=");
            sb.append((Object) this.buildManufacturer);
            sb.append(", buildModel=");
            sb.append((Object) this.buildModel);
            sb.append(", buildProduct=");
            sb.append((Object) this.buildProduct);
            sb.append(", buildSerial=");
            sb.append((Object) this.buildSerial);
            sb.append(", deviceId=");
            sb.append((Object) this.deviceId);
            sb.append(", fingerPrint=");
            sb.append((Object) this.fingerPrint);
            sb.append(", imei=");
            sb.append((Object) this.imei);
            sb.append(", isEmulator=");
            sb.append(this.isEmulator);
            sb.append(", isRooted=");
            sb.append(this.isRooted);
            sb.append(", networkType=");
            sb.append((Object) this.networkType);
            sb.append(", osVersion=");
            sb.append((Object) this.osVersion);
            sb.append(", osVersionInt=");
            sb.append(this.osVersionInt);
            sb.append(", timeLocation=");
            sb.append(this.timeLocation);
            sb.append(", utdidAdvertisementId=");
            sb.append((Object) this.utdidAdvertisementId);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public Device(@JSONField(name = "androidId") String str, @JSONField(name = "appVersion") String str2, @JSONField(name = "blueMac") String str3, @JSONField(name = "buildBoard") String str4, @JSONField(name = "buildBootloader") String str5, @JSONField(name = "buildBrand") String str6, @JSONField(name = "buildDevice") String str7, @JSONField(name = "buildManufacturer") String str8, @JSONField(name = "buildModel") String str9, @JSONField(name = "buildProduct") String str10, @JSONField(name = "buildSerial") String str11, @JSONField(name = "device_id") String str12, @JSONField(name = "fingerPrint") String str13, @JSONField(name = "imei") String str14, boolean z, boolean z2, @JSONField(name = "networkType") String str15, @JSONField(name = "osVersion") String str16, @JSONField(name = "osVersionInt") int i, @JSONField(name = "timeLocation") TimeLocation timeLocation, @JSONField(name = "utdidAdvertisementId") String str17) {
            this.androidId = str;
            this.appVersion = str2;
            this.blueMac = str3;
            this.buildBoard = str4;
            this.buildBootloader = str5;
            this.buildBrand = str6;
            this.buildDevice = str7;
            this.buildManufacturer = str8;
            this.buildModel = str9;
            this.buildProduct = str10;
            this.buildSerial = str11;
            this.deviceId = str12;
            this.fingerPrint = str13;
            this.imei = str14;
            this.isEmulator = z;
            this.isRooted = z2;
            this.networkType = str15;
            this.osVersion = str16;
            this.osVersionInt = i;
            this.timeLocation = timeLocation;
            this.utdidAdvertisementId = str17;
        }

        public /* synthetic */ Device(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, boolean z, boolean z2, String str15, String str16, int i, TimeLocation timeLocation, String str17, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : str8, (i2 & 256) != 0 ? null : str9, (i2 & 512) != 0 ? null : str10, (i2 & 1024) != 0 ? null : str11, (i2 & 2048) != 0 ? null : str12, (i2 & 4096) != 0 ? null : str13, (i2 & 8192) != 0 ? null : str14, (i2 & 16384) != 0 ? false : z, (i2 & 32768) != 0 ? false : z2, (i2 & 65536) != 0 ? null : str15, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str16, (i2 & 262144) == 0 ? i : 0, (i2 & 524288) != 0 ? null : timeLocation, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str17);
        }

        @JvmName(name = "getAndroidId")
        public final String getAndroidId() {
            return this.androidId;
        }

        @JvmName(name = "setAndroidId")
        public final void setAndroidId(String str) {
            this.androidId = str;
        }

        @JvmName(name = "getAppVersion")
        public final String getAppVersion() {
            return this.appVersion;
        }

        @JvmName(name = "setAppVersion")
        public final void setAppVersion(String str) {
            this.appVersion = str;
        }

        @JvmName(name = "getBlueMac")
        public final String getBlueMac() {
            return this.blueMac;
        }

        @JvmName(name = "setBlueMac")
        public final void setBlueMac(String str) {
            this.blueMac = str;
        }

        @JvmName(name = "getBuildBoard")
        public final String getBuildBoard() {
            return this.buildBoard;
        }

        @JvmName(name = "setBuildBoard")
        public final void setBuildBoard(String str) {
            this.buildBoard = str;
        }

        @JvmName(name = "getBuildBootloader")
        public final String getBuildBootloader() {
            return this.buildBootloader;
        }

        @JvmName(name = "setBuildBootloader")
        public final void setBuildBootloader(String str) {
            this.buildBootloader = str;
        }

        @JvmName(name = "getBuildBrand")
        public final String getBuildBrand() {
            return this.buildBrand;
        }

        @JvmName(name = "setBuildBrand")
        public final void setBuildBrand(String str) {
            this.buildBrand = str;
        }

        @JvmName(name = "getBuildDevice")
        public final String getBuildDevice() {
            return this.buildDevice;
        }

        @JvmName(name = "setBuildDevice")
        public final void setBuildDevice(String str) {
            this.buildDevice = str;
        }

        @JvmName(name = "getBuildManufacturer")
        public final String getBuildManufacturer() {
            return this.buildManufacturer;
        }

        @JvmName(name = "setBuildManufacturer")
        public final void setBuildManufacturer(String str) {
            this.buildManufacturer = str;
        }

        @JvmName(name = "getBuildModel")
        public final String getBuildModel() {
            return this.buildModel;
        }

        @JvmName(name = "setBuildModel")
        public final void setBuildModel(String str) {
            this.buildModel = str;
        }

        @JvmName(name = "getBuildProduct")
        public final String getBuildProduct() {
            return this.buildProduct;
        }

        @JvmName(name = "setBuildProduct")
        public final void setBuildProduct(String str) {
            this.buildProduct = str;
        }

        @JvmName(name = "getBuildSerial")
        public final String getBuildSerial() {
            return this.buildSerial;
        }

        @JvmName(name = "setBuildSerial")
        public final void setBuildSerial(String str) {
            this.buildSerial = str;
        }

        @JvmName(name = "getDeviceId")
        public final String getDeviceId() {
            return this.deviceId;
        }

        @JvmName(name = "setDeviceId")
        public final void setDeviceId(String str) {
            this.deviceId = str;
        }

        @JvmName(name = "getFingerPrint")
        public final String getFingerPrint() {
            return this.fingerPrint;
        }

        @JvmName(name = "setFingerPrint")
        public final void setFingerPrint(String str) {
            this.fingerPrint = str;
        }

        @JvmName(name = "getImei")
        public final String getImei() {
            return this.imei;
        }

        @JvmName(name = "setImei")
        public final void setImei(String str) {
            this.imei = str;
        }

        @JvmName(name = "isEmulator")
        public final boolean isEmulator() {
            return this.isEmulator;
        }

        @JvmName(name = "setEmulator")
        public final void setEmulator(boolean z) {
            this.isEmulator = z;
        }

        @JvmName(name = "isRooted")
        public final boolean isRooted() {
            return this.isRooted;
        }

        @JvmName(name = "setRooted")
        public final void setRooted(boolean z) {
            this.isRooted = z;
        }

        @JvmName(name = "getNetworkType")
        public final String getNetworkType() {
            return this.networkType;
        }

        @JvmName(name = "setNetworkType")
        public final void setNetworkType(String str) {
            this.networkType = str;
        }

        @JvmName(name = "getOsVersion")
        public final String getOsVersion() {
            return this.osVersion;
        }

        @JvmName(name = "setOsVersion")
        public final void setOsVersion(String str) {
            this.osVersion = str;
        }

        @JvmName(name = "getOsVersionInt")
        public final int getOsVersionInt() {
            return this.osVersionInt;
        }

        @JvmName(name = "setOsVersionInt")
        public final void setOsVersionInt(int i) {
            this.osVersionInt = i;
        }

        @JvmName(name = "getTimeLocation")
        public final TimeLocation getTimeLocation() {
            return this.timeLocation;
        }

        @JvmName(name = "setTimeLocation")
        public final void setTimeLocation(TimeLocation timeLocation) {
            this.timeLocation = timeLocation;
        }

        @JvmName(name = "getUtdidAdvertisementId")
        public final String getUtdidAdvertisementId() {
            return this.utdidAdvertisementId;
        }

        @JvmName(name = "setUtdidAdvertisementId")
        public final void setUtdidAdvertisementId(String str) {
            this.utdidAdvertisementId = str;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B-\b\u0007\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0017"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device$TimeLocation;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "latitude", "longitude", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Device$TimeLocation;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getLatitude", "setLatitude", "(Ljava/lang/String;)V", "getLongitude", "setLongitude", "getTimeZone", "setTimeZone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class TimeLocation {
            private String latitude;
            private String longitude;
            private String timeZone;

            @JSONCreator
            public TimeLocation() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ TimeLocation copy$default(TimeLocation timeLocation, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = timeLocation.latitude;
                }
                if ((i & 2) != 0) {
                    str2 = timeLocation.longitude;
                }
                if ((i & 4) != 0) {
                    str3 = timeLocation.timeZone;
                }
                return timeLocation.copy(str, str2, str3);
            }

            /* renamed from: component1  reason: from getter */
            public final String getLatitude() {
                return this.latitude;
            }

            /* renamed from: component2  reason: from getter */
            public final String getLongitude() {
                return this.longitude;
            }

            /* renamed from: component3  reason: from getter */
            public final String getTimeZone() {
                return this.timeZone;
            }

            public final TimeLocation copy(@JSONField(name = "latitude") String latitude, @JSONField(name = "longitude") String longitude, @JSONField(name = "timeZone") String timeZone) {
                return new TimeLocation(latitude, longitude, timeZone);
            }

            public final boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (other instanceof TimeLocation) {
                    TimeLocation timeLocation = (TimeLocation) other;
                    return Intrinsics.areEqual(this.latitude, timeLocation.latitude) && Intrinsics.areEqual(this.longitude, timeLocation.longitude) && Intrinsics.areEqual(this.timeZone, timeLocation.timeZone);
                }
                return false;
            }

            public final int hashCode() {
                String str = this.latitude;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.longitude;
                int hashCode2 = str2 == null ? 0 : str2.hashCode();
                String str3 = this.timeZone;
                return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("TimeLocation(latitude=");
                sb.append((Object) this.latitude);
                sb.append(", longitude=");
                sb.append((Object) this.longitude);
                sb.append(", timeZone=");
                sb.append((Object) this.timeZone);
                sb.append(')');
                return sb.toString();
            }

            @JSONCreator
            public TimeLocation(@JSONField(name = "latitude") String str, @JSONField(name = "longitude") String str2, @JSONField(name = "timeZone") String str3) {
                this.latitude = str;
                this.longitude = str2;
                this.timeZone = str3;
            }

            public /* synthetic */ TimeLocation(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            @JvmName(name = "getLatitude")
            public final String getLatitude() {
                return this.latitude;
            }

            @JvmName(name = "setLatitude")
            public final void setLatitude(String str) {
                this.latitude = str;
            }

            @JvmName(name = "getLongitude")
            public final String getLongitude() {
                return this.longitude;
            }

            @JvmName(name = "setLongitude")
            public final void setLongitude(String str) {
                this.longitude = str;
            }

            @JvmName(name = "getTimeZone")
            public final String getTimeZone() {
                return this.timeZone;
            }

            @JvmName(name = "setTimeZone")
            public final void setTimeZone(String str) {
                this.timeZone = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0007\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b2\u00103J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jj\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u00072\b\b\u0003\u0010\u0012\u001a\u00020\u00072\b\b\u0003\u0010\u0013\u001a\u00020\u00072\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001c\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010!R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010!R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010!R\"\u0010\u0011\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010)R\"\u0010\u0012\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010&\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010)R\"\u0010\u0013\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010&\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010)R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010!R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b0\u0010\u0004\"\u0004\b1\u0010!"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Cpu;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "component5", "component6", "component7", "component8", "cpuABI", "cpuABI2", "cpuArchitecture", "cpuCurFreq", "cpuMaxFreq", "cpuMinFreq", "cpuName", "cpuSerial", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Cpu;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getCpuABI", "setCpuABI", "(Ljava/lang/String;)V", "getCpuABI2", "setCpuABI2", "getCpuArchitecture", "setCpuArchitecture", "I", "getCpuCurFreq", "setCpuCurFreq", "(I)V", "getCpuMaxFreq", "setCpuMaxFreq", "getCpuMinFreq", "setCpuMinFreq", "getCpuName", "setCpuName", "getCpuSerial", "setCpuSerial", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Cpu {
        private String cpuABI;
        private String cpuABI2;
        private String cpuArchitecture;
        private int cpuCurFreq;
        private int cpuMaxFreq;
        private int cpuMinFreq;
        private String cpuName;
        private String cpuSerial;

        @JSONCreator
        public Cpu() {
            this(null, null, null, 0, 0, 0, null, null, 255, null);
        }

        /* renamed from: component1  reason: from getter */
        public final String getCpuABI() {
            return this.cpuABI;
        }

        /* renamed from: component2  reason: from getter */
        public final String getCpuABI2() {
            return this.cpuABI2;
        }

        /* renamed from: component3  reason: from getter */
        public final String getCpuArchitecture() {
            return this.cpuArchitecture;
        }

        /* renamed from: component4  reason: from getter */
        public final int getCpuCurFreq() {
            return this.cpuCurFreq;
        }

        /* renamed from: component5  reason: from getter */
        public final int getCpuMaxFreq() {
            return this.cpuMaxFreq;
        }

        /* renamed from: component6  reason: from getter */
        public final int getCpuMinFreq() {
            return this.cpuMinFreq;
        }

        /* renamed from: component7  reason: from getter */
        public final String getCpuName() {
            return this.cpuName;
        }

        /* renamed from: component8  reason: from getter */
        public final String getCpuSerial() {
            return this.cpuSerial;
        }

        public final Cpu copy(@JSONField(name = "cpuABI") String cpuABI, @JSONField(name = "cpuABI2") String cpuABI2, @JSONField(name = "cpuArchitecture") String cpuArchitecture, @JSONField(name = "cpuCurFreq") int cpuCurFreq, @JSONField(name = "cpuMaxFreq") int cpuMaxFreq, @JSONField(name = "cpuMinFreq") int cpuMinFreq, @JSONField(name = "cpuName") String cpuName, @JSONField(name = "cpuSerial") String cpuSerial) {
            return new Cpu(cpuABI, cpuABI2, cpuArchitecture, cpuCurFreq, cpuMaxFreq, cpuMinFreq, cpuName, cpuSerial);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Cpu) {
                Cpu cpu = (Cpu) other;
                return Intrinsics.areEqual(this.cpuABI, cpu.cpuABI) && Intrinsics.areEqual(this.cpuABI2, cpu.cpuABI2) && Intrinsics.areEqual(this.cpuArchitecture, cpu.cpuArchitecture) && this.cpuCurFreq == cpu.cpuCurFreq && this.cpuMaxFreq == cpu.cpuMaxFreq && this.cpuMinFreq == cpu.cpuMinFreq && Intrinsics.areEqual(this.cpuName, cpu.cpuName) && Intrinsics.areEqual(this.cpuSerial, cpu.cpuSerial);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.cpuABI;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.cpuABI2;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.cpuArchitecture;
            int hashCode3 = str3 == null ? 0 : str3.hashCode();
            int i = this.cpuCurFreq;
            int i2 = this.cpuMaxFreq;
            int i3 = this.cpuMinFreq;
            String str4 = this.cpuName;
            int hashCode4 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.cpuSerial;
            return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + i2) * 31) + i3) * 31) + hashCode4) * 31) + (str5 != null ? str5.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Cpu(cpuABI=");
            sb.append((Object) this.cpuABI);
            sb.append(", cpuABI2=");
            sb.append((Object) this.cpuABI2);
            sb.append(", cpuArchitecture=");
            sb.append((Object) this.cpuArchitecture);
            sb.append(", cpuCurFreq=");
            sb.append(this.cpuCurFreq);
            sb.append(", cpuMaxFreq=");
            sb.append(this.cpuMaxFreq);
            sb.append(", cpuMinFreq=");
            sb.append(this.cpuMinFreq);
            sb.append(", cpuName=");
            sb.append((Object) this.cpuName);
            sb.append(", cpuSerial=");
            sb.append((Object) this.cpuSerial);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public Cpu(@JSONField(name = "cpuABI") String str, @JSONField(name = "cpuABI2") String str2, @JSONField(name = "cpuArchitecture") String str3, @JSONField(name = "cpuCurFreq") int i, @JSONField(name = "cpuMaxFreq") int i2, @JSONField(name = "cpuMinFreq") int i3, @JSONField(name = "cpuName") String str4, @JSONField(name = "cpuSerial") String str5) {
            this.cpuABI = str;
            this.cpuABI2 = str2;
            this.cpuArchitecture = str3;
            this.cpuCurFreq = i;
            this.cpuMaxFreq = i2;
            this.cpuMinFreq = i3;
            this.cpuName = str4;
            this.cpuSerial = str5;
        }

        public /* synthetic */ Cpu(String str, String str2, String str3, int i, int i2, int i3, String str4, String str5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) == 0 ? i3 : 0, (i4 & 64) != 0 ? null : str4, (i4 & 128) == 0 ? str5 : null);
        }

        @JvmName(name = "getCpuABI")
        public final String getCpuABI() {
            return this.cpuABI;
        }

        @JvmName(name = "setCpuABI")
        public final void setCpuABI(String str) {
            this.cpuABI = str;
        }

        @JvmName(name = "getCpuABI2")
        public final String getCpuABI2() {
            return this.cpuABI2;
        }

        @JvmName(name = "setCpuABI2")
        public final void setCpuABI2(String str) {
            this.cpuABI2 = str;
        }

        @JvmName(name = "getCpuArchitecture")
        public final String getCpuArchitecture() {
            return this.cpuArchitecture;
        }

        @JvmName(name = "setCpuArchitecture")
        public final void setCpuArchitecture(String str) {
            this.cpuArchitecture = str;
        }

        @JvmName(name = "getCpuCurFreq")
        public final int getCpuCurFreq() {
            return this.cpuCurFreq;
        }

        @JvmName(name = "setCpuCurFreq")
        public final void setCpuCurFreq(int i) {
            this.cpuCurFreq = i;
        }

        @JvmName(name = "getCpuMaxFreq")
        public final int getCpuMaxFreq() {
            return this.cpuMaxFreq;
        }

        @JvmName(name = "setCpuMaxFreq")
        public final void setCpuMaxFreq(int i) {
            this.cpuMaxFreq = i;
        }

        @JvmName(name = "getCpuMinFreq")
        public final int getCpuMinFreq() {
            return this.cpuMinFreq;
        }

        @JvmName(name = "setCpuMinFreq")
        public final void setCpuMinFreq(int i) {
            this.cpuMinFreq = i;
        }

        @JvmName(name = "getCpuName")
        public final String getCpuName() {
            return this.cpuName;
        }

        @JvmName(name = "setCpuName")
        public final void setCpuName(String str) {
            this.cpuName = str;
        }

        @JvmName(name = "getCpuSerial")
        public final String getCpuSerial() {
            return this.cpuSerial;
        }

        @JvmName(name = "setCpuSerial")
        public final void setCpuSerial(String str) {
            this.cpuSerial = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\b\b\u0003\u0010\r\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jj\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\r\u001a\u00020\u00022\b\b\u0003\u0010\u000e\u001a\u00020\u00022\b\b\u0003\u0010\u000f\u001a\u00020\u00022\b\b\u0003\u0010\u0010\u001a\u00020\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\u00022\b\b\u0003\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u0014\u001a\u00020\u00022\b\b\u0003\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010$R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010$R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010!\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010$R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010$R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010!\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010$R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010$R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010$R\"\u0010\u0014\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010$R\"\u0010\u0015\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010!\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010$"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$SysFeature;", "", "", "component1", "()Z", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", TinyAppActionState.ACTION_BLUE_TOOTH, "locationGPS", "nfc", "nfcHostCardEmulation", "telephony", "usbAccessory", "usbHost", "wifi", "wifiDirect", "copy", "(ZZZZZZZZZ)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$SysFeature;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getBluetooth", "setBluetooth", "(Z)V", "getLocationGPS", "setLocationGPS", "getNfc", "setNfc", "getNfcHostCardEmulation", "setNfcHostCardEmulation", "getTelephony", "setTelephony", "getUsbAccessory", "setUsbAccessory", "getUsbHost", "setUsbHost", "getWifi", "setWifi", "getWifiDirect", "setWifiDirect", "<init>", "(ZZZZZZZZZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SysFeature {
        private boolean bluetooth;
        private boolean locationGPS;
        private boolean nfc;
        private boolean nfcHostCardEmulation;
        private boolean telephony;
        private boolean usbAccessory;
        private boolean usbHost;
        private boolean wifi;
        private boolean wifiDirect;

        @JSONCreator
        public SysFeature() {
            this(false, false, false, false, false, false, false, false, false, 511, null);
        }

        /* renamed from: component1  reason: from getter */
        public final boolean getBluetooth() {
            return this.bluetooth;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getLocationGPS() {
            return this.locationGPS;
        }

        /* renamed from: component3  reason: from getter */
        public final boolean getNfc() {
            return this.nfc;
        }

        /* renamed from: component4  reason: from getter */
        public final boolean getNfcHostCardEmulation() {
            return this.nfcHostCardEmulation;
        }

        /* renamed from: component5  reason: from getter */
        public final boolean getTelephony() {
            return this.telephony;
        }

        /* renamed from: component6  reason: from getter */
        public final boolean getUsbAccessory() {
            return this.usbAccessory;
        }

        /* renamed from: component7  reason: from getter */
        public final boolean getUsbHost() {
            return this.usbHost;
        }

        /* renamed from: component8  reason: from getter */
        public final boolean getWifi() {
            return this.wifi;
        }

        /* renamed from: component9  reason: from getter */
        public final boolean getWifiDirect() {
            return this.wifiDirect;
        }

        public final SysFeature copy(@JSONField(name = "bluetooth") boolean bluetooth, @JSONField(name = "locationGPS") boolean locationGPS, @JSONField(name = "nfc") boolean nfc, @JSONField(name = "nfcHostCardEmulation") boolean nfcHostCardEmulation, @JSONField(name = "telephony") boolean telephony, @JSONField(name = "usbAccessory") boolean usbAccessory, @JSONField(name = "usbHost") boolean usbHost, @JSONField(name = "wifi") boolean wifi, @JSONField(name = "wifiDirect") boolean wifiDirect) {
            return new SysFeature(bluetooth, locationGPS, nfc, nfcHostCardEmulation, telephony, usbAccessory, usbHost, wifi, wifiDirect);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof SysFeature) {
                SysFeature sysFeature = (SysFeature) other;
                return this.bluetooth == sysFeature.bluetooth && this.locationGPS == sysFeature.locationGPS && this.nfc == sysFeature.nfc && this.nfcHostCardEmulation == sysFeature.nfcHostCardEmulation && this.telephony == sysFeature.telephony && this.usbAccessory == sysFeature.usbAccessory && this.usbHost == sysFeature.usbHost && this.wifi == sysFeature.wifi && this.wifiDirect == sysFeature.wifiDirect;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r5v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r6v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r7v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
        public final int hashCode() {
            boolean z = this.bluetooth;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            ?? r2 = this.locationGPS;
            int i = r2;
            if (r2 != 0) {
                i = 1;
            }
            ?? r3 = this.nfc;
            int i2 = r3;
            if (r3 != 0) {
                i2 = 1;
            }
            ?? r4 = this.nfcHostCardEmulation;
            int i3 = r4;
            if (r4 != 0) {
                i3 = 1;
            }
            ?? r5 = this.telephony;
            int i4 = r5;
            if (r5 != 0) {
                i4 = 1;
            }
            ?? r6 = this.usbAccessory;
            int i5 = r6;
            if (r6 != 0) {
                i5 = 1;
            }
            ?? r7 = this.usbHost;
            int i6 = r7;
            if (r7 != 0) {
                i6 = 1;
            }
            ?? r8 = this.wifi;
            int i7 = r8;
            if (r8 != 0) {
                i7 = 1;
            }
            boolean z2 = this.wifiDirect;
            return (((((((((((((((r0 * 31) + i) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + i7) * 31) + (z2 ? 1 : z2 ? 1 : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SysFeature(bluetooth=");
            sb.append(this.bluetooth);
            sb.append(", locationGPS=");
            sb.append(this.locationGPS);
            sb.append(", nfc=");
            sb.append(this.nfc);
            sb.append(", nfcHostCardEmulation=");
            sb.append(this.nfcHostCardEmulation);
            sb.append(", telephony=");
            sb.append(this.telephony);
            sb.append(", usbAccessory=");
            sb.append(this.usbAccessory);
            sb.append(", usbHost=");
            sb.append(this.usbHost);
            sb.append(", wifi=");
            sb.append(this.wifi);
            sb.append(", wifiDirect=");
            sb.append(this.wifiDirect);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public SysFeature(@JSONField(name = "bluetooth") boolean z, @JSONField(name = "locationGPS") boolean z2, @JSONField(name = "nfc") boolean z3, @JSONField(name = "nfcHostCardEmulation") boolean z4, @JSONField(name = "telephony") boolean z5, @JSONField(name = "usbAccessory") boolean z6, @JSONField(name = "usbHost") boolean z7, @JSONField(name = "wifi") boolean z8, @JSONField(name = "wifiDirect") boolean z9) {
            this.bluetooth = z;
            this.locationGPS = z2;
            this.nfc = z3;
            this.nfcHostCardEmulation = z4;
            this.telephony = z5;
            this.usbAccessory = z6;
            this.usbHost = z7;
            this.wifi = z8;
            this.wifiDirect = z9;
        }

        public /* synthetic */ SysFeature(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6, (i & 64) != 0 ? false : z7, (i & 128) != 0 ? false : z8, (i & 256) == 0 ? z9 : false);
        }

        @JvmName(name = "getBluetooth")
        public final boolean getBluetooth() {
            return this.bluetooth;
        }

        @JvmName(name = "setBluetooth")
        public final void setBluetooth(boolean z) {
            this.bluetooth = z;
        }

        @JvmName(name = "getLocationGPS")
        public final boolean getLocationGPS() {
            return this.locationGPS;
        }

        @JvmName(name = "setLocationGPS")
        public final void setLocationGPS(boolean z) {
            this.locationGPS = z;
        }

        @JvmName(name = "getNfc")
        public final boolean getNfc() {
            return this.nfc;
        }

        @JvmName(name = "setNfc")
        public final void setNfc(boolean z) {
            this.nfc = z;
        }

        @JvmName(name = "getNfcHostCardEmulation")
        public final boolean getNfcHostCardEmulation() {
            return this.nfcHostCardEmulation;
        }

        @JvmName(name = "setNfcHostCardEmulation")
        public final void setNfcHostCardEmulation(boolean z) {
            this.nfcHostCardEmulation = z;
        }

        @JvmName(name = "getTelephony")
        public final boolean getTelephony() {
            return this.telephony;
        }

        @JvmName(name = "setTelephony")
        public final void setTelephony(boolean z) {
            this.telephony = z;
        }

        @JvmName(name = "getUsbAccessory")
        public final boolean getUsbAccessory() {
            return this.usbAccessory;
        }

        @JvmName(name = "setUsbAccessory")
        public final void setUsbAccessory(boolean z) {
            this.usbAccessory = z;
        }

        @JvmName(name = "getUsbHost")
        public final boolean getUsbHost() {
            return this.usbHost;
        }

        @JvmName(name = "setUsbHost")
        public final void setUsbHost(boolean z) {
            this.usbHost = z;
        }

        @JvmName(name = "getWifi")
        public final boolean getWifi() {
            return this.wifi;
        }

        @JvmName(name = "setWifi")
        public final void setWifi(boolean z) {
            this.wifi = z;
        }

        @JvmName(name = "getWifiDirect")
        public final boolean getWifiDirect() {
            return this.wifiDirect;
        }

        @JvmName(name = "setWifiDirect")
        public final void setWifiDirect(boolean z) {
            this.wifiDirect = z;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0015"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Memory;", "", "", "component1", "()Ljava/lang/String;", "component2", "maxMemory", "totalMemory", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Memory;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMaxMemory", "setMaxMemory", "(Ljava/lang/String;)V", "getTotalMemory", "setTotalMemory", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Memory {
        private String maxMemory;
        private String totalMemory;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        @com.alibaba.fastjson.annotation.JSONCreator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Memory() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo.Memory.<init>():void");
        }

        public static /* synthetic */ Memory copy$default(Memory memory, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = memory.maxMemory;
            }
            if ((i & 2) != 0) {
                str2 = memory.totalMemory;
            }
            return memory.copy(str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getMaxMemory() {
            return this.maxMemory;
        }

        /* renamed from: component2  reason: from getter */
        public final String getTotalMemory() {
            return this.totalMemory;
        }

        public final Memory copy(@JSONField(name = "maxMemory") String maxMemory, @JSONField(name = "totalMemory") String totalMemory) {
            return new Memory(maxMemory, totalMemory);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Memory) {
                Memory memory = (Memory) other;
                return Intrinsics.areEqual(this.maxMemory, memory.maxMemory) && Intrinsics.areEqual(this.totalMemory, memory.totalMemory);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.maxMemory;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.totalMemory;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Memory(maxMemory=");
            sb.append((Object) this.maxMemory);
            sb.append(", totalMemory=");
            sb.append((Object) this.totalMemory);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public Memory(@JSONField(name = "maxMemory") String str, @JSONField(name = "totalMemory") String str2) {
            this.maxMemory = str;
            this.totalMemory = str2;
        }

        public /* synthetic */ Memory(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @JvmName(name = "getMaxMemory")
        public final String getMaxMemory() {
            return this.maxMemory;
        }

        @JvmName(name = "setMaxMemory")
        public final void setMaxMemory(String str) {
            this.maxMemory = str;
        }

        @JvmName(name = "getTotalMemory")
        public final String getTotalMemory() {
            return this.totalMemory;
        }

        @JvmName(name = "setTotalMemory")
        public final void setTotalMemory(String str) {
            this.totalMemory = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0015"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$ExternalStorage;", "", "", "component1", "()Ljava/lang/String;", "component2", "diskFree", "diskTotal", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$ExternalStorage;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDiskFree", "setDiskFree", "(Ljava/lang/String;)V", "getDiskTotal", "setDiskTotal", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ExternalStorage {
        private String diskFree;
        private String diskTotal;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        @com.alibaba.fastjson.annotation.JSONCreator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ExternalStorage() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo.ExternalStorage.<init>():void");
        }

        public static /* synthetic */ ExternalStorage copy$default(ExternalStorage externalStorage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = externalStorage.diskFree;
            }
            if ((i & 2) != 0) {
                str2 = externalStorage.diskTotal;
            }
            return externalStorage.copy(str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getDiskFree() {
            return this.diskFree;
        }

        /* renamed from: component2  reason: from getter */
        public final String getDiskTotal() {
            return this.diskTotal;
        }

        public final ExternalStorage copy(@JSONField(name = "diskFree") String diskFree, @JSONField(name = "diskTotal") String diskTotal) {
            return new ExternalStorage(diskFree, diskTotal);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof ExternalStorage) {
                ExternalStorage externalStorage = (ExternalStorage) other;
                return Intrinsics.areEqual(this.diskFree, externalStorage.diskFree) && Intrinsics.areEqual(this.diskTotal, externalStorage.diskTotal);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.diskFree;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.diskTotal;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ExternalStorage(diskFree=");
            sb.append((Object) this.diskFree);
            sb.append(", diskTotal=");
            sb.append((Object) this.diskTotal);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public ExternalStorage(@JSONField(name = "diskFree") String str, @JSONField(name = "diskTotal") String str2) {
            this.diskFree = str;
            this.diskTotal = str2;
        }

        public /* synthetic */ ExternalStorage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @JvmName(name = "getDiskFree")
        public final String getDiskFree() {
            return this.diskFree;
        }

        @JvmName(name = "setDiskFree")
        public final void setDiskFree(String str) {
            this.diskFree = str;
        }

        @JvmName(name = "getDiskTotal")
        public final String getDiskTotal() {
            return this.diskTotal;
        }

        @JvmName(name = "setDiskTotal")
        public final void setDiskTotal(String str) {
            this.diskTotal = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0015"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$IPAddress;", "", "", "component1", "()Ljava/lang/String;", "component2", "ethIp", "trueIp", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$IPAddress;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getEthIp", "setEthIp", "(Ljava/lang/String;)V", "getTrueIp", "setTrueIp", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class IPAddress {
        private String ethIp;
        private String trueIp;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        @com.alibaba.fastjson.annotation.JSONCreator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public IPAddress() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo.IPAddress.<init>():void");
        }

        public static /* synthetic */ IPAddress copy$default(IPAddress iPAddress, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = iPAddress.ethIp;
            }
            if ((i & 2) != 0) {
                str2 = iPAddress.trueIp;
            }
            return iPAddress.copy(str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getEthIp() {
            return this.ethIp;
        }

        /* renamed from: component2  reason: from getter */
        public final String getTrueIp() {
            return this.trueIp;
        }

        public final IPAddress copy(@JSONField(name = "ethIp") String ethIp, @JSONField(name = "trueIp") String trueIp) {
            return new IPAddress(ethIp, trueIp);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof IPAddress) {
                IPAddress iPAddress = (IPAddress) other;
                return Intrinsics.areEqual(this.ethIp, iPAddress.ethIp) && Intrinsics.areEqual(this.trueIp, iPAddress.trueIp);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.ethIp;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.trueIp;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("IPAddress(ethIp=");
            sb.append((Object) this.ethIp);
            sb.append(", trueIp=");
            sb.append((Object) this.trueIp);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public IPAddress(@JSONField(name = "ethIp") String str, @JSONField(name = "trueIp") String str2) {
            this.ethIp = str;
            this.trueIp = str2;
        }

        public /* synthetic */ IPAddress(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @JvmName(name = "getEthIp")
        public final String getEthIp() {
            return this.ethIp;
        }

        @JvmName(name = "setEthIp")
        public final void setEthIp(String str) {
            this.ethIp = str;
        }

        @JvmName(name = "getTrueIp")
        public final String getTrueIp() {
            return this.trueIp;
        }

        @JvmName(name = "setTrueIp")
        public final void setTrueIp(String str) {
            this.trueIp = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0003\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\u0007\u001a\u00020\u00022\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0017"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Display;", "", "", "component1", "()I", "component2", "component3", "density", ZebraData.ATTR_HEIGHT, ZebraData.ATTR_WIDTH, "copy", "(III)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Display;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getDensity", "setDensity", "(I)V", "getHeight", "setHeight", "getWidth", "setWidth", "<init>", "(III)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Display {
        private int density;
        private int height;
        private int width;

        @JSONCreator
        public Display() {
            this(0, 0, 0, 7, null);
        }

        public static /* synthetic */ Display copy$default(Display display, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = display.density;
            }
            if ((i4 & 2) != 0) {
                i2 = display.height;
            }
            if ((i4 & 4) != 0) {
                i3 = display.width;
            }
            return display.copy(i, i2, i3);
        }

        /* renamed from: component1  reason: from getter */
        public final int getDensity() {
            return this.density;
        }

        /* renamed from: component2  reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: component3  reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public final Display copy(@JSONField(name = "density") int density, @JSONField(name = "height") int height, @JSONField(name = "width") int width) {
            return new Display(density, height, width);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Display) {
                Display display = (Display) other;
                return this.density == display.density && this.height == display.height && this.width == display.width;
            }
            return false;
        }

        public final int hashCode() {
            return (((this.density * 31) + this.height) * 31) + this.width;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Display(density=");
            sb.append(this.density);
            sb.append(", height=");
            sb.append(this.height);
            sb.append(", width=");
            sb.append(this.width);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public Display(@JSONField(name = "density") int i, @JSONField(name = "height") int i2, @JSONField(name = "width") int i3) {
            this.density = i;
            this.height = i2;
            this.width = i3;
        }

        public /* synthetic */ Display(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
        }

        @JvmName(name = "getDensity")
        public final int getDensity() {
            return this.density;
        }

        @JvmName(name = "setDensity")
        public final void setDensity(int i) {
            this.density = i;
        }

        @JvmName(name = "getHeight")
        public final int getHeight() {
            return this.height;
        }

        @JvmName(name = "setHeight")
        public final void setHeight(int i) {
            this.height = i;
        }

        @JvmName(name = "getWidth")
        public final int getWidth() {
            return this.width;
        }

        @JvmName(name = "setWidth")
        public final void setWidth(int i) {
            this.width = i;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JF\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0003\u0010\u0010\u001a\u00020\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001cR\"\u0010\u000e\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010 R\"\u0010\u000f\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010!\u001a\u0004\b\u000f\u0010\n\"\u0004\b\"\u0010#R\"\u0010\u0010\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010 R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010\u001c"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Wifi;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()Z", "component4", "component5", "bssid", "frequency", "isCurrent", "level", "ssid", "copy", "(Ljava/lang/String;IZILjava/lang/String;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Wifi;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getBssid", "setBssid", "(Ljava/lang/String;)V", "I", "getFrequency", "setFrequency", "(I)V", "Z", "setCurrent", "(Z)V", "getLevel", "setLevel", "getSsid", "setSsid", "<init>", "(Ljava/lang/String;IZILjava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Wifi {
        private String bssid;
        private int frequency;
        @JSONField(name = "isCurrent")
        private boolean isCurrent;
        private int level;
        private String ssid;

        @JSONCreator
        public Wifi() {
            this(null, 0, false, 0, null, 31, null);
        }

        public static /* synthetic */ Wifi copy$default(Wifi wifi, String str, int i, boolean z, int i2, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = wifi.bssid;
            }
            if ((i3 & 2) != 0) {
                i = wifi.frequency;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                z = wifi.isCurrent;
            }
            boolean z2 = z;
            if ((i3 & 8) != 0) {
                i2 = wifi.level;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                str2 = wifi.ssid;
            }
            return wifi.copy(str, i4, z2, i5, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getBssid() {
            return this.bssid;
        }

        /* renamed from: component2  reason: from getter */
        public final int getFrequency() {
            return this.frequency;
        }

        /* renamed from: component3  reason: from getter */
        public final boolean getIsCurrent() {
            return this.isCurrent;
        }

        /* renamed from: component4  reason: from getter */
        public final int getLevel() {
            return this.level;
        }

        /* renamed from: component5  reason: from getter */
        public final String getSsid() {
            return this.ssid;
        }

        public final Wifi copy(@JSONField(name = "bssid") String bssid, @JSONField(name = "frequency") int frequency, boolean isCurrent, @JSONField(name = "level") int level, @JSONField(name = "ssid") String ssid) {
            return new Wifi(bssid, frequency, isCurrent, level, ssid);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Wifi) {
                Wifi wifi = (Wifi) other;
                return Intrinsics.areEqual(this.bssid, wifi.bssid) && this.frequency == wifi.frequency && this.isCurrent == wifi.isCurrent && this.level == wifi.level && Intrinsics.areEqual(this.ssid, wifi.ssid);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            String str = this.bssid;
            int hashCode = str == null ? 0 : str.hashCode();
            int i = this.frequency;
            boolean z = this.isCurrent;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            int i3 = this.level;
            String str2 = this.ssid;
            return (((((((hashCode * 31) + i) * 31) + i2) * 31) + i3) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Wifi(bssid=");
            sb.append((Object) this.bssid);
            sb.append(", frequency=");
            sb.append(this.frequency);
            sb.append(", isCurrent=");
            sb.append(this.isCurrent);
            sb.append(", level=");
            sb.append(this.level);
            sb.append(", ssid=");
            sb.append((Object) this.ssid);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public Wifi(@JSONField(name = "bssid") String str, @JSONField(name = "frequency") int i, boolean z, @JSONField(name = "level") int i2, @JSONField(name = "ssid") String str2) {
            this.bssid = str;
            this.frequency = i;
            this.isCurrent = z;
            this.level = i2;
            this.ssid = str2;
        }

        public /* synthetic */ Wifi(String str, int i, boolean z, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? false : z, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? null : str2);
        }

        @JvmName(name = "getBssid")
        public final String getBssid() {
            return this.bssid;
        }

        @JvmName(name = "setBssid")
        public final void setBssid(String str) {
            this.bssid = str;
        }

        @JvmName(name = "getFrequency")
        public final int getFrequency() {
            return this.frequency;
        }

        @JvmName(name = "setFrequency")
        public final void setFrequency(int i) {
            this.frequency = i;
        }

        @JvmName(name = "isCurrent")
        public final boolean isCurrent() {
            return this.isCurrent;
        }

        @JvmName(name = "setCurrent")
        public final void setCurrent(boolean z) {
            this.isCurrent = z;
        }

        @JvmName(name = "getLevel")
        public final int getLevel() {
            return this.level;
        }

        @JvmName(name = "setLevel")
        public final void setLevel(int i) {
            this.level = i;
        }

        @JvmName(name = "getSsid")
        public final String getSsid() {
            return this.ssid;
        }

        @JvmName(name = "setSsid")
        public final void setSsid(String str) {
            this.ssid = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B=\b\u0007\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JD\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0003\u0010\u0011\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001cR\"\u0010\u000e\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010 R\"\u0010\u000f\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010!\u001a\u0004\b\u000f\u0010\n\"\u0004\b\"\u0010#R\"\u0010\u0010\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\u0010\u0010\n\"\u0004\b$\u0010#R\"\u0010\u0011\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010 "}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Bluetooth;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()Z", "component4", "component5", "address", "bondState", "isBounded", "isBounding", "type", "copy", "(Ljava/lang/String;IZZI)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Bluetooth;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getAddress", "setAddress", "(Ljava/lang/String;)V", "I", "getBondState", "setBondState", "(I)V", "Z", "setBounded", "(Z)V", "setBounding", "getType", "setType", "<init>", "(Ljava/lang/String;IZZI)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Bluetooth {
        private String address;
        private int bondState;
        @JSONField(name = "isBounded")
        private boolean isBounded;
        @JSONField(name = "isBounding")
        private boolean isBounding;
        private int type;

        @JSONCreator
        public Bluetooth() {
            this(null, 0, false, false, 0, 31, null);
        }

        public static /* synthetic */ Bluetooth copy$default(Bluetooth bluetooth, String str, int i, boolean z, boolean z2, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = bluetooth.address;
            }
            if ((i3 & 2) != 0) {
                i = bluetooth.bondState;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                z = bluetooth.isBounded;
            }
            boolean z3 = z;
            if ((i3 & 8) != 0) {
                z2 = bluetooth.isBounding;
            }
            boolean z4 = z2;
            if ((i3 & 16) != 0) {
                i2 = bluetooth.type;
            }
            return bluetooth.copy(str, i4, z3, z4, i2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        /* renamed from: component2  reason: from getter */
        public final int getBondState() {
            return this.bondState;
        }

        /* renamed from: component3  reason: from getter */
        public final boolean getIsBounded() {
            return this.isBounded;
        }

        /* renamed from: component4  reason: from getter */
        public final boolean getIsBounding() {
            return this.isBounding;
        }

        /* renamed from: component5  reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final Bluetooth copy(@JSONField(name = "address") String address, @JSONField(name = "bondState") int bondState, boolean isBounded, boolean isBounding, @JSONField(name = "type") int type) {
            return new Bluetooth(address, bondState, isBounded, isBounding, type);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Bluetooth) {
                Bluetooth bluetooth = (Bluetooth) other;
                return Intrinsics.areEqual(this.address, bluetooth.address) && this.bondState == bluetooth.bondState && this.isBounded == bluetooth.isBounded && this.isBounding == bluetooth.isBounding && this.type == bluetooth.type;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            String str = this.address;
            int hashCode = str == null ? 0 : str.hashCode();
            int i = this.bondState;
            boolean z = this.isBounded;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            boolean z2 = this.isBounding;
            return (((((((hashCode * 31) + i) * 31) + i2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.type;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Bluetooth(address=");
            sb.append((Object) this.address);
            sb.append(", bondState=");
            sb.append(this.bondState);
            sb.append(", isBounded=");
            sb.append(this.isBounded);
            sb.append(", isBounding=");
            sb.append(this.isBounding);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(')');
            return sb.toString();
        }

        @JSONCreator
        public Bluetooth(@JSONField(name = "address") String str, @JSONField(name = "bondState") int i, boolean z, boolean z2, @JSONField(name = "type") int i2) {
            this.address = str;
            this.bondState = i;
            this.isBounded = z;
            this.isBounding = z2;
            this.type = i2;
        }

        public /* synthetic */ Bluetooth(String str, int i, boolean z, boolean z2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) == 0 ? i2 : 0);
        }

        @JvmName(name = "getAddress")
        public final String getAddress() {
            return this.address;
        }

        @JvmName(name = "setAddress")
        public final void setAddress(String str) {
            this.address = str;
        }

        @JvmName(name = "getBondState")
        public final int getBondState() {
            return this.bondState;
        }

        @JvmName(name = "setBondState")
        public final void setBondState(int i) {
            this.bondState = i;
        }

        @JvmName(name = "isBounded")
        public final boolean isBounded() {
            return this.isBounded;
        }

        @JvmName(name = "setBounded")
        public final void setBounded(boolean z) {
            this.isBounded = z;
        }

        @JvmName(name = "isBounding")
        public final boolean isBounding() {
            return this.isBounding;
        }

        @JvmName(name = "setBounding")
        public final void setBounding(boolean z) {
            this.isBounding = z;
        }

        @JvmName(name = "getType")
        public final int getType() {
            return this.type;
        }

        @JvmName(name = "setType")
        public final void setType(int i) {
            this.type = i;
        }
    }
}
