package id.dana.lib.gcontainer.app.bridge.deviceinfo;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import androidx.core.app.ActivityCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.lib.gcontainer.util.DeviceUtil;
import id.dana.lib.logger.DANALog;
import id.dana.util.device.OSUtil;
import id.dana.util.permission.Permission;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b7\u00108J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u001f\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u001fJ\u001f\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\rJ\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010\rJ\u001f\u0010%\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010\u001fJ\u001f\u0010&\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010\u001fR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010'R\u0014\u0010)\u001a\u00020\u00068CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\bR\u0014\u0010-\u001a\u00020*8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020*8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0014\u00101\u001a\u00020*8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010,R\u0014\u00103\u001a\u00020\u00068CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\bR\u0016\u00105\u001a\u0004\u0018\u0001048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b5\u00106"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInformationManager;", "", "Lcom/alibaba/fastjson/JSONObject;", "assembleAllDeviceInfo", "()Lcom/alibaba/fastjson/JSONObject;", "assembleLocationDeviceInfo", "", "getBluetoothAdapter", "()Ljava/lang/String;", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo;", "info", "", "getCpuABI", "(Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo;)V", "getNetworkDataType", "getNetworkType", "currentBssid", "Landroid/net/wifi/ScanResult;", ZdocRecordService.SCAN_RESULT, "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Wifi;", "getWifiScanResult", "(Ljava/lang/String;Landroid/net/wifi/ScanResult;)Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo$Wifi;", "fileName", "keyword", "readFileInfo", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "setBEInfo", "setCpuInfo", "Landroid/content/Context;", HummerConstants.CONTEXT, "setDeviceInfo", "(Landroid/content/Context;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/DeviceInfo;)V", "setDisplayInfo", "setExternalStorageInfo", "setGpsInfo", "setIpInfo", "setMemoryInfo", "setSystemFeatureInfo", "setWifiInfo", "Landroid/content/Context;", "getCpuArchitecture", "cpuArchitecture", "", "getCpuFrequency", "()I", "cpuFrequency", "getCpuMaxFrequency", "cpuMaxFrequency", "getCpuMinFrequency", "cpuMinFrequency", "getCpuName", "cpuName", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/ILocationListener;", "iLocationListener", "Lid/dana/lib/gcontainer/app/bridge/deviceinfo/ILocationListener;", "<init>", "(Landroid/content/Context;Lid/dana/lib/gcontainer/app/bridge/deviceinfo/ILocationListener;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DeviceInformationManager {
    private static final String TAG = "DeviceInformationManager";
    private final Context context;
    private final ILocationListener iLocationListener;

    public DeviceInformationManager(Context context, ILocationListener iLocationListener) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
        this.iLocationListener = iLocationListener;
    }

    public final JSONObject assembleLocationDeviceInfo() {
        DeviceInfo deviceInfo = new DeviceInfo(null, null, null, null, null, null, null, null, null, null, 1023, null);
        setGpsInfo(this.context, deviceInfo);
        Object json = JSON.toJSON(deviceInfo);
        if (json != null) {
            return (JSONObject) json;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
    }

    public final JSONObject assembleAllDeviceInfo() {
        DeviceInfo deviceInfo = new DeviceInfo(null, null, null, null, null, null, null, null, null, null, 1023, null);
        setGpsInfo(this.context, deviceInfo);
        setDeviceInfo(this.context, deviceInfo);
        setCpuInfo(deviceInfo);
        setSystemFeatureInfo(this.context, deviceInfo);
        setMemoryInfo(deviceInfo);
        setExternalStorageInfo(this.context, deviceInfo);
        setIpInfo(deviceInfo);
        setDisplayInfo(this.context, deviceInfo);
        setWifiInfo(this.context, deviceInfo);
        setBEInfo(deviceInfo);
        Object json = JSON.toJSON(deviceInfo);
        if (json != null) {
            return (JSONObject) json;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
    }

    private final void setGpsInfo(Context context, DeviceInfo info) {
        ILocationListener iLocationListener = this.iLocationListener;
        DeviceInfo.Gps latestLocation = iLocationListener == null ? null : iLocationListener.getLatestLocation(context);
        if (latestLocation == null) {
            return;
        }
        info.setGps(latestLocation);
    }

    private final String getNetworkDataType() {
        if (ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.context, "android.permission.READ_PHONE_STATE") != 0) {
            Object systemService = this.context.getSystemService("phone");
            if (systemService != null) {
                return String.valueOf(((TelephonyManager) systemService).getDataNetworkType());
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return "";
    }

    private final String getNetworkType() {
        if (Permission.KClassImpl$Data$declaredNonStaticMembers$2(this.context, "android.permission.READ_PHONE_STATE")) {
            if (OSUtil.PlaceComponentResult()) {
                return getNetworkDataType();
            }
            Object systemService = this.context.getSystemService("phone");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            }
            return String.valueOf(((TelephonyManager) systemService).getNetworkType());
        }
        return "";
    }

    private final String getBluetoothAdapter() {
        Object systemService;
        try {
            systemService = this.context.getSystemService(TinyAppActionState.ACTION_BLUE_TOOTH);
        } catch (Exception unused) {
        }
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        }
        String address = ((BluetoothManager) systemService).getAdapter().getAddress();
        if (address != null) {
            return address;
        }
        return "";
    }

    private final void setDeviceInfo(Context context, DeviceInfo info) {
        DeviceInfo.Device.TimeLocation timeLocation;
        try {
            DeviceInfo.Device.TimeLocation timeLocation2 = new DeviceInfo.Device.TimeLocation(null, null, null, 7, null);
            String str = Build.BOARD;
            String str2 = Build.BRAND;
            String str3 = Build.DEVICE;
            String str4 = Build.MANUFACTURER;
            String str5 = Build.MODEL;
            String str6 = Build.PRODUCT;
            info.setDevice(new DeviceInfo.Device(Settings.System.getString(context.getContentResolver(), "android_id"), context.getPackageName(), getBluetoothAdapter(), str, Build.BOOTLOADER, str2, str3, str4, str5, str6, "", null, Build.FINGERPRINT, "", DeviceUtil.isEmulator(context), DeviceUtil.isRooted(context), getNetworkType(), Build.VERSION.RELEASE, Build.VERSION.SDK_INT, timeLocation2, DeviceUtil.getUtdidAdvertisingId(context), 2048, null));
            DeviceInfo.Device device = info.getDevice();
            if (device == null || (timeLocation = device.getTimeLocation()) == null) {
                return;
            }
            DeviceInfo.Gps gps = info.getGps();
            String str7 = null;
            timeLocation.setLatitude(gps == null ? null : gps.getLatitude());
            DeviceInfo.Gps gps2 = info.getGps();
            if (gps2 != null) {
                str7 = gps2.getLongitude();
            }
            timeLocation.setLongitude(str7);
            timeLocation.setTimeZone(TimeZone.getDefault().getID());
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "setDeviceInfo", e);
        }
    }

    private final void setCpuInfo(DeviceInfo info) {
        try {
            info.setCpu(new DeviceInfo.Cpu(null, null, null, 0, 0, 0, null, null, 255, null));
            getCpuABI(info);
            DeviceInfo.Cpu cpu = info.getCpu();
            if (cpu != null) {
                cpu.setCpuCurFreq(getCpuFrequency());
                cpu.setCpuMaxFreq(getCpuMaxFrequency());
                cpu.setCpuMinFreq(getCpuMinFrequency());
                cpu.setCpuName(getCpuName());
                cpu.setCpuArchitecture(getCpuArchitecture());
            }
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "setCpuInfo", e);
        }
    }

    private final void setSystemFeatureInfo(Context context, DeviceInfo info) {
        try {
            PackageManager packageManager = context.getPackageManager();
            boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.bluetooth");
            boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.location");
            boolean hasSystemFeature3 = packageManager.hasSystemFeature("android.hardware.wifi");
            boolean hasSystemFeature4 = packageManager.hasSystemFeature("android.hardware.telephony");
            boolean hasSystemFeature5 = packageManager.hasSystemFeature("android.hardware.nfc");
            boolean hasSystemFeature6 = packageManager.hasSystemFeature("android.hardware.nfc.hce");
            boolean hasSystemFeature7 = packageManager.hasSystemFeature("android.hardware.wifi.direct");
            info.setSysFeature(new DeviceInfo.SysFeature(hasSystemFeature, hasSystemFeature2, hasSystemFeature5, hasSystemFeature6, hasSystemFeature4, packageManager.hasSystemFeature("android.hardware.usb.accessory"), packageManager.hasSystemFeature("android.hardware.usb.host"), hasSystemFeature3, hasSystemFeature7));
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "setSystemFeatureInfo", e);
        }
    }

    private final void setMemoryInfo(DeviceInfo info) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Runtime.getRuntime().maxMemory());
            sb.append('B');
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Runtime.getRuntime().totalMemory());
            sb2.append('B');
            info.setMemory(new DeviceInfo.Memory(obj, sb2.toString()));
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "setMemoryInfo", e);
        }
    }

    private final void setExternalStorageInfo(Context context, DeviceInfo info) {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSizeLong = statFs.getBlockSizeLong();
            long blockCountLong = statFs.getBlockCountLong();
            long availableBlocksLong = statFs.getAvailableBlocksLong();
            info.setExternalStorage(new DeviceInfo.ExternalStorage(Formatter.formatFileSize(context, availableBlocksLong * blockSizeLong), Formatter.formatFileSize(context, blockCountLong * blockSizeLong)));
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "setExternalStorageInfo", e);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    private final void setIpInfo(DeviceInfo info) {
        try {
            ?? r2 = 0;
            info.setIpAddress(new DeviceInfo.IPAddress(r2, r2, 3, r2));
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        DeviceInfo.IPAddress ipAddress = info.getIpAddress();
                        if (ipAddress != null) {
                            ipAddress.setEthIp(nextElement.getHostAddress());
                        }
                        DeviceInfo.IPAddress ipAddress2 = info.getIpAddress();
                        if (ipAddress2 != null) {
                            DeviceInfo.IPAddress ipAddress3 = info.getIpAddress();
                            ipAddress2.setTrueIp(ipAddress3 == null ? null : ipAddress3.getEthIp());
                        }
                    }
                }
            }
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "setIpInfo", e);
        }
    }

    private final void setDisplayInfo(Context context, DeviceInfo info) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            info.setDisplay(new DeviceInfo.Display((int) displayMetrics.scaledDensity, displayMetrics.heightPixels, i));
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "setDisplayInfo", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[Catch: Exception -> 0x006d, TryCatch #0 {Exception -> 0x006d, blocks: (B:3:0x0002, B:5:0x000e, B:7:0x002c, B:13:0x0038, B:15:0x0040, B:17:0x0046, B:19:0x004e, B:22:0x0065, B:23:0x006c), top: B:27:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setWifiInfo(android.content.Context r7, id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo r8) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            android.content.Context r7 = r7.getApplicationContext()     // Catch: java.lang.Exception -> L6d
            java.lang.String r1 = "wifi"
            java.lang.Object r7 = r7.getSystemService(r1)     // Catch: java.lang.Exception -> L6d
            if (r7 == 0) goto L65
            android.net.wifi.WifiManager r7 = (android.net.wifi.WifiManager) r7     // Catch: java.lang.Exception -> L6d
            android.net.wifi.WifiInfo r1 = r7.getConnectionInfo()     // Catch: java.lang.Exception -> L6d
            java.lang.String r1 = r1.getBSSID()     // Catch: java.lang.Exception -> L6d
            java.util.List r7 = r7.getScanResults()     // Catch: java.lang.Exception -> L6d
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Exception -> L6d
            r2.<init>()     // Catch: java.lang.Exception -> L6d
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L6d
            r8.setWifi(r2)     // Catch: java.lang.Exception -> L6d
            r2 = r7
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Exception -> L6d
            r3 = 0
            if (r2 == 0) goto L35
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Exception -> L6d
            if (r2 == 0) goto L33
            goto L35
        L33:
            r2 = 0
            goto L36
        L35:
            r2 = 1
        L36:
            if (r2 != 0) goto L77
            int r2 = r7.size()     // Catch: java.lang.Exception -> L6d
            r4 = 100
            if (r2 > r4) goto L44
            int r4 = r7.size()     // Catch: java.lang.Exception -> L6d
        L44:
            if (r4 <= 0) goto L77
        L46:
            int r2 = r3 + 1
            java.util.List r5 = r8.getWifi()     // Catch: java.lang.Exception -> L6d
            if (r5 == 0) goto L61
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch: java.lang.Exception -> L6d
            java.lang.Object r3 = r7.get(r3)     // Catch: java.lang.Exception -> L6d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch: java.lang.Exception -> L6d
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3     // Catch: java.lang.Exception -> L6d
            id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo$Wifi r3 = r6.getWifiScanResult(r1, r3)     // Catch: java.lang.Exception -> L6d
            r5.add(r3)     // Catch: java.lang.Exception -> L6d
        L61:
            if (r2 >= r4) goto L77
            r3 = r2
            goto L46
        L65:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch: java.lang.Exception -> L6d
            java.lang.String r8 = "null cannot be cast to non-null type android.net.wifi.WifiManager"
            r7.<init>(r8)     // Catch: java.lang.Exception -> L6d
            throw r7     // Catch: java.lang.Exception -> L6d
        L6d:
            r7 = move-exception
            java.lang.String r8 = id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInformationManager.TAG
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.String r0 = "setWifiInfo"
            id.dana.lib.logger.DANALog.PlaceComponentResult(r8, r0, r7)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInformationManager.setWifiInfo(android.content.Context, id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo):void");
    }

    private final void setBEInfo(DeviceInfo info) {
        try {
            info.setBluetooth(new ArrayList());
            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
            if (bondedDevices != null) {
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    int bondState = bluetoothDevice.getBondState();
                    DeviceInfo.Bluetooth bluetooth = new DeviceInfo.Bluetooth(bluetoothDevice.getAddress(), bondState, bondState == 12, bondState == 11, bluetoothDevice.getType());
                    List<DeviceInfo.Bluetooth> bluetooth2 = info.getBluetooth();
                    if (bluetooth2 != null) {
                        bluetooth2.add(bluetooth);
                    }
                }
            }
        } catch (Exception e) {
            DANALog.PlaceComponentResult(TAG, "setBEInfo", e);
        }
    }

    private final void getCpuABI(DeviceInfo info) {
        DeviceInfo.Cpu cpu = info.getCpu();
        if (cpu != null) {
            cpu.setCpuABI(Build.CPU_ABI);
        }
        DeviceInfo.Cpu cpu2 = info.getCpu();
        if (cpu2 != null) {
            cpu2.setCpuABI2(Build.CPU_ABI2);
        }
    }

    @JvmName(name = "getCpuFrequency")
    private final int getCpuFrequency() {
        return NumberExtKt.toSafeInt$default(readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", ""), 0, 1, (Object) null);
    }

    @JvmName(name = "getCpuMaxFrequency")
    private final int getCpuMaxFrequency() {
        return NumberExtKt.toSafeInt$default(readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", ""), 0, 1, (Object) null);
    }

    @JvmName(name = "getCpuMinFrequency")
    private final int getCpuMinFrequency() {
        return NumberExtKt.toSafeInt$default(readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq", ""), 0, 1, (Object) null);
    }

    @JvmName(name = "getCpuName")
    private final String getCpuName() {
        String readFileInfo = readFileInfo("/proc/cpuinfo", "");
        if (readFileInfo == null || readFileInfo.length() == 0) {
            return "";
        }
        Object[] array = StringsKt.split$default((CharSequence) readFileInfo, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (array != null) {
            return ((String[]) array)[1];
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @JvmName(name = "getCpuArchitecture")
    private final String getCpuArchitecture() {
        String readFileInfo = readFileInfo("/proc/cpuinfo", "Hardware");
        if (readFileInfo == null || readFileInfo.length() == 0) {
            return "";
        }
        Object[] array = StringsKt.split$default((CharSequence) readFileInfo, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (array != null) {
            return ((String[]) array)[1];
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final DeviceInfo.Wifi getWifiScanResult(String currentBssid, ScanResult scanResult) {
        String str = scanResult.BSSID;
        String str2 = scanResult.SSID;
        return new DeviceInfo.Wifi(str, scanResult.frequency, Intrinsics.areEqual(scanResult.BSSID, currentBssid), scanResult.level, str2);
    }

    private final String readFileInfo(String fileName, String keyword) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            try {
                bufferedReader2 = bufferedReader;
            } finally {
            }
        } catch (IOException e) {
            DANALog.MyBillsEntityDataFactory(TAG, "readFileInfo", e);
        }
        if (keyword.length() == 0) {
            String readLine = bufferedReader2.readLine();
            CloseableKt.closeFinally(bufferedReader, null);
            return readLine;
        }
        for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
            if (StringsKt.contains$default((CharSequence) readLine2, (CharSequence) keyword, false, 2, (Object) null)) {
                CloseableKt.closeFinally(bufferedReader, null);
                return readLine2;
            }
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(bufferedReader, null);
        return null;
    }
}
