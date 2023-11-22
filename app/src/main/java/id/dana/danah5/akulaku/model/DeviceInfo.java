package id.dana.danah5.akulaku.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.alipay.mobile.zebra.data.ZebraData;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceInfo {
    @JSONField(name = TinyAppActionState.ACTION_BLUE_TOOTH)
    public List<Bluetooth> bluetooth;
    @JSONField(name = "cpu")
    public Cpu cpu;
    @JSONField(name = "device")
    public Device device;
    @JSONField(name = Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)
    public Display display;
    @JSONField(name = "externalStorage")
    public ExternalStorage externalStorage;
    @JSONField(name = "gps")
    public Gps gps;
    @JSONField(name = "IP")
    public IP ip;
    @JSONField(name = "memory")
    public Memory memory;
    @JSONField(name = "SysFeature")
    public SysFeature sysFeature;
    @JSONField(name = "wifi")
    public List<Wifi> wifi;

    /* loaded from: classes2.dex */
    public static class Bluetooth {
        @JSONField(name = "address")
        public String address;
        @JSONField(name = "bondState")
        public int bondState;
        @JSONField(name = "isBounded")
        public boolean isBounded;
        @JSONField(name = "isBounding")
        public boolean isBounding;
        @JSONField(name = "type")
        public int type;
    }

    /* loaded from: classes2.dex */
    public static class Cpu {
        @JSONField(name = "cpuABI")
        public String cpuABI;
        @JSONField(name = "cpuABI2")
        public String cpuABI2;
        @JSONField(name = "cpuArchitecture")
        public String cpuArchitecture;
        @JSONField(name = "cpuCurFreq")
        public int cpuCurFreq;
        @JSONField(name = "cpuMaxFreq")
        public int cpuMaxFreq;
        @JSONField(name = "cpuMinFreq")
        public int cpuMinFreq;
        @JSONField(name = "cpuName")
        public String cpuName;
        @JSONField(name = "cpuSerial")
        public String cpuSerial;
    }

    /* loaded from: classes2.dex */
    public static class Device {
        @JSONField(name = "androidId")
        public String androidId;
        @JSONField(name = "appVersion")
        public String appVersion;
        @JSONField(name = "blueMac")
        public String blueMac;
        @JSONField(name = "buildBoard")
        public String buildBoard;
        @JSONField(name = "buildBootloader")
        public String buildBootloader;
        @JSONField(name = "buildBrand")
        public String buildBrand;
        @JSONField(name = "buildDevice")
        public String buildDevice;
        @JSONField(name = "buildManufacturer")
        public String buildManufacturer;
        @JSONField(name = "buildModel")
        public String buildModel;
        @JSONField(name = "buildProduct")
        public String buildProduct;
        @JSONField(name = "buildSerial")
        public String buildSerial;
        @JSONField(name = "device_id")
        public String deviceId;
        @JSONField(name = "fingerPrint")
        public String fingerPrint;
        @JSONField(name = "imei")
        public String imei;
        @JSONField(name = "isEmulator")
        public boolean isEmulator;
        @JSONField(name = "isRooted")
        public boolean isRooted;
        @JSONField(name = "networkType")
        public String networkType;
        @JSONField(name = "osVersion")
        public String osVersion;
        @JSONField(name = "osVersionInt")
        public int osVersionInt;
        @JSONField(name = "timeLocation")
        public TimeLocation timeLocation;
        @JSONField(name = "utdidAdvertisementId")
        public String utdidAdvertisementId;

        /* loaded from: classes2.dex */
        public static class TimeLocation {
            @JSONField(name = "latitude")
            public String latitude;
            @JSONField(name = "longitude")
            public String longitude;
            @JSONField(name = RemoteConfigConstants.RequestFieldKey.TIME_ZONE)
            public String timeZone;
        }
    }

    /* loaded from: classes2.dex */
    public static class Display {
        @JSONField(name = "density")
        public int density;
        @JSONField(name = ZebraData.ATTR_HEIGHT)
        public int height;
        @JSONField(name = ZebraData.ATTR_WIDTH)
        public int width;
    }

    /* loaded from: classes2.dex */
    public static class ExternalStorage {
        @JSONField(name = "diskFree")
        public String diskFree;
        @JSONField(name = "diskTotal")
        public String diskTotal;
    }

    /* loaded from: classes2.dex */
    public static class Gps {
        @JSONField(name = "error")
        public int error;
        @JSONField(name = "latitude")
        public String latitude;
        @JSONField(name = "longitude")
        public String longitude;
        @JSONField(name = "time")
        public long time;
    }

    /* loaded from: classes2.dex */
    public static class IP {
        @JSONField(name = "ethIp")
        public String ethIp;
        @JSONField(name = "trueIp")
        public String trueIp;
    }

    /* loaded from: classes2.dex */
    public static class Memory {
        @JSONField(name = "maxMemory")
        public String maxMemory;
        @JSONField(name = "totalMemory")
        public String totalMemory;
    }

    /* loaded from: classes2.dex */
    public static class SysFeature {
        @JSONField(name = TinyAppActionState.ACTION_BLUE_TOOTH)
        public boolean bluetooth;
        @JSONField(name = "locationGPS")
        public boolean locationGPS;
        @JSONField(name = "nfc")
        public boolean nfc;
        @JSONField(name = "nfcHostCardEmulation")
        public boolean nfcHostCardEmulation;
        @JSONField(name = "telephony")
        public boolean telephony;
        @JSONField(name = "usbAccessory")
        public boolean usbAccessory;
        @JSONField(name = "usbHost")
        public boolean usbHost;
        @JSONField(name = "wifi")
        public boolean wifi;
        @JSONField(name = "wifiDirect")
        public boolean wifiDirect;
    }

    /* loaded from: classes2.dex */
    public static class Wifi {
        @JSONField(name = "bssid")
        public String bssid;
        @JSONField(name = "frequency")
        public int frequency;
        @JSONField(name = "isCurrent")
        public boolean isCurrent;
        @JSONField(name = "level")
        public int level;
        @JSONField(name = "ssid")
        public String ssid;
    }
}
