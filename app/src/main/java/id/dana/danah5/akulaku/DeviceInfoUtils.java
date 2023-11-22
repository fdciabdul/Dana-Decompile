package id.dana.danah5.akulaku;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.lbs.LBSLocation;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.danah5.akulaku.model.DeviceInfo;
import id.dana.utils.AdvertisingIdUtil;
import id.dana.utils.foundation.facede.LbsFacade;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class DeviceInfoUtils {
    private DeviceInfoUtils() {
    }

    public static DeviceInfo assembleDeviceInfo(Context context) {
        DeviceInfo deviceInfo = new DeviceInfo();
        try {
            setGpsInfo(context, deviceInfo);
            setDeviceInfo(context, deviceInfo);
            setCpuInfo(deviceInfo);
            setSystemFeatureInfo(context, deviceInfo);
            setMemoryInfo(deviceInfo);
            setExternalStorageInfo(context, deviceInfo);
            setIpInfo(deviceInfo);
            setDisplayInfo(context, deviceInfo);
            setWifiInfo(context, deviceInfo);
            setBEInfo(deviceInfo);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
        return deviceInfo;
    }

    private static void setGpsInfo(Context context, DeviceInfo deviceInfo) {
        try {
            deviceInfo.gps = new DeviceInfo.Gps();
            LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(context);
            deviceInfo.gps.latitude = String.valueOf(authRequestContext.getLatitude());
            deviceInfo.gps.longitude = String.valueOf(authRequestContext.getLongitude());
            deviceInfo.gps.time = authRequestContext.getTime();
            deviceInfo.gps.error = authRequestContext.getErrorCode();
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setDeviceInfo(Context context, DeviceInfo deviceInfo) {
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            deviceInfo.device = new DeviceInfo.Device();
            deviceInfo.device.timeLocation = new DeviceInfo.Device.TimeLocation();
            deviceInfo.device.buildBoard = Build.BOARD;
            deviceInfo.device.buildBrand = Build.BRAND;
            deviceInfo.device.buildDevice = Build.DEVICE;
            deviceInfo.device.buildManufacturer = Build.MANUFACTURER;
            deviceInfo.device.buildModel = Build.MODEL;
            deviceInfo.device.buildProduct = Build.PRODUCT;
            deviceInfo.device.buildBootloader = Build.BOOTLOADER;
            deviceInfo.device.buildSerial = "";
            deviceInfo.device.androidId = Settings.System.getString(context.getContentResolver(), "android_id");
            deviceInfo.device.fingerPrint = Build.FINGERPRINT;
            deviceInfo.device.isEmulator = Crashlytics.getAuthRequestContext();
            DeviceInfo.Device device = deviceInfo.device;
            KClassImpl$Data$declaredNonStaticMembers$2 = Crashlytics.Companion.KClassImpl$Data$declaredNonStaticMembers$2();
            device.isRooted = KClassImpl$Data$declaredNonStaticMembers$2;
            deviceInfo.device.blueMac = BluetoothAdapter.getDefaultAdapter().getAddress();
            deviceInfo.device.timeLocation.latitude = deviceInfo.gps != null ? deviceInfo.gps.latitude : null;
            deviceInfo.device.timeLocation.longitude = deviceInfo.gps != null ? deviceInfo.gps.longitude : null;
            deviceInfo.device.timeLocation.timeZone = TimeZone.getDefault().getID();
            deviceInfo.device.networkType = String.valueOf(((TelephonyManager) context.getSystemService("phone")).getNetworkType());
            deviceInfo.device.osVersion = Build.VERSION.RELEASE;
            deviceInfo.device.osVersionInt = Build.VERSION.SDK_INT;
            deviceInfo.device.imei = "";
            deviceInfo.device.appVersion = context.getPackageName();
            deviceInfo.device.utdidAdvertisementId = AdvertisingIdUtil.BuiltInFictitiousFunctionClassFactory(context);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setCpuInfo(DeviceInfo deviceInfo) {
        try {
            deviceInfo.cpu = new DeviceInfo.Cpu();
            getCpuABI(deviceInfo);
            setCpuFrequency(deviceInfo);
            setCpuMaxFrequency(deviceInfo);
            setCpuMinFrequency(deviceInfo);
            setCpuName(deviceInfo);
            setCpuArchitecture(deviceInfo);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setSystemFeatureInfo(Context context, DeviceInfo deviceInfo) {
        try {
            deviceInfo.sysFeature = new DeviceInfo.SysFeature();
            PackageManager packageManager = context.getPackageManager();
            deviceInfo.sysFeature.bluetooth = packageManager.hasSystemFeature("android.hardware.bluetooth");
            deviceInfo.sysFeature.locationGPS = packageManager.hasSystemFeature("android.hardware.location");
            deviceInfo.sysFeature.wifi = packageManager.hasSystemFeature("android.hardware.wifi");
            deviceInfo.sysFeature.telephony = packageManager.hasSystemFeature("android.hardware.telephony");
            deviceInfo.sysFeature.nfc = packageManager.hasSystemFeature("android.hardware.nfc");
            deviceInfo.sysFeature.nfcHostCardEmulation = packageManager.hasSystemFeature("android.hardware.nfc.hce");
            deviceInfo.sysFeature.wifiDirect = packageManager.hasSystemFeature("android.hardware.wifi.direct");
            deviceInfo.sysFeature.usbHost = packageManager.hasSystemFeature("android.hardware.usb.host");
            deviceInfo.sysFeature.usbAccessory = packageManager.hasSystemFeature("android.hardware.usb.accessory");
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setMemoryInfo(DeviceInfo deviceInfo) {
        try {
            deviceInfo.memory = new DeviceInfo.Memory();
            DeviceInfo.Memory memory = deviceInfo.memory;
            StringBuilder sb = new StringBuilder();
            sb.append(Runtime.getRuntime().maxMemory());
            sb.append(DiskFormatter.B);
            memory.maxMemory = sb.toString();
            DeviceInfo.Memory memory2 = deviceInfo.memory;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Runtime.getRuntime().totalMemory());
            sb2.append(DiskFormatter.B);
            memory2.totalMemory = sb2.toString();
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setExternalStorageInfo(Context context, DeviceInfo deviceInfo) {
        try {
            deviceInfo.externalStorage = new DeviceInfo.ExternalStorage();
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            deviceInfo.externalStorage.diskTotal = Formatter.formatFileSize(context, blockCount * blockSize);
            deviceInfo.externalStorage.diskFree = Formatter.formatFileSize(context, availableBlocks * blockSize);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setIpInfo(DeviceInfo deviceInfo) {
        try {
            deviceInfo.ip = new DeviceInfo.IP();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        deviceInfo.ip.ethIp = nextElement.getHostAddress();
                        deviceInfo.ip.trueIp = deviceInfo.ip.ethIp;
                    }
                }
            }
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setDisplayInfo(Context context, DeviceInfo deviceInfo) {
        try {
            deviceInfo.display = new DeviceInfo.Display();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            deviceInfo.display.width = displayMetrics.widthPixels;
            deviceInfo.display.height = displayMetrics.heightPixels;
            deviceInfo.display.density = (int) displayMetrics.scaledDensity;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setWifiInfo(Context context, DeviceInfo deviceInfo) {
        try {
            deviceInfo.wifi = new ArrayList();
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            String bssid = wifiManager.getConnectionInfo().getBSSID();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults == null || scanResults.isEmpty()) {
                return;
            }
            int min = Math.min(scanResults.size(), 100);
            for (int i = 0; i < min; i++) {
                deviceInfo.wifi.add(getWifiScanResult(bssid, scanResults.get(i)));
            }
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void setBEInfo(DeviceInfo deviceInfo) {
        try {
            deviceInfo.bluetooth = new ArrayList();
            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
            if (bondedDevices == null || bondedDevices.isEmpty()) {
                return;
            }
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                DeviceInfo.Bluetooth bluetooth = new DeviceInfo.Bluetooth();
                bluetooth.bondState = bluetoothDevice.getBondState();
                boolean z = true;
                bluetooth.isBounded = bluetooth.bondState == 12;
                if (bluetooth.bondState != 11) {
                    z = false;
                }
                bluetooth.isBounding = z;
                bluetooth.address = bluetoothDevice.getAddress();
                if (Build.VERSION.SDK_INT >= 18) {
                    bluetooth.type = bluetoothDevice.getType();
                }
                deviceInfo.bluetooth.add(bluetooth);
            }
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.AKULAKU, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
        }
    }

    private static void getCpuABI(DeviceInfo deviceInfo) {
        deviceInfo.cpu.cpuABI = Build.CPU_ABI;
        deviceInfo.cpu.cpuABI2 = Build.CPU_ABI2;
    }

    private static void setCpuFrequency(DeviceInfo deviceInfo) {
        String readFileInfo = readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "");
        if (readFileInfo != null) {
            deviceInfo.cpu.cpuCurFreq = TextUtils.isEmpty(readFileInfo) ? 0 : Integer.parseInt(readFileInfo);
        }
    }

    private static void setCpuMaxFrequency(DeviceInfo deviceInfo) {
        String readFileInfo = readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "");
        if (readFileInfo != null) {
            deviceInfo.cpu.cpuMaxFreq = TextUtils.isEmpty(readFileInfo) ? 0 : Integer.parseInt(readFileInfo);
        }
    }

    private static void setCpuMinFrequency(DeviceInfo deviceInfo) {
        String readFileInfo = readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq", "");
        if (readFileInfo != null) {
            deviceInfo.cpu.cpuMinFreq = TextUtils.isEmpty(readFileInfo) ? 0 : Integer.parseInt(readFileInfo);
        }
    }

    private static void setCpuName(DeviceInfo deviceInfo) {
        String readFileInfo = readFileInfo("/proc/cpuinfo", "");
        if (readFileInfo != null) {
            deviceInfo.cpu.cpuName = TextUtils.isEmpty(readFileInfo) ? "" : readFileInfo.split(":")[1];
        }
    }

    private static void setCpuArchitecture(DeviceInfo deviceInfo) {
        String readFileInfo = readFileInfo("/proc/cpuinfo", "Hardware");
        if (readFileInfo != null) {
            deviceInfo.cpu.cpuArchitecture = TextUtils.isEmpty(readFileInfo) ? "" : readFileInfo.split(":")[1];
        }
    }

    private static DeviceInfo.Wifi getWifiScanResult(String str, ScanResult scanResult) {
        DeviceInfo.Wifi wifi = new DeviceInfo.Wifi();
        wifi.bssid = scanResult.BSSID;
        wifi.ssid = scanResult.SSID;
        wifi.frequency = scanResult.frequency;
        wifi.level = scanResult.level;
        if (wifi.bssid != null && wifi.bssid.equals(str)) {
            wifi.isCurrent = true;
        }
        return wifi;
    }

    /*  JADX ERROR: Type inference failed with exception
        java.lang.NullPointerException
        */
    /* JADX WARN: Failed to calculate best type for var: r2v0 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v2 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v3 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v6 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v9 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x008f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:54:0x008d */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0094: MOVE (r5 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:55:0x0091 */
    private static java.lang.String readFileInfo(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.akulaku.DeviceInfoUtils.readFileInfo(java.lang.String, java.lang.String):java.lang.String");
    }
}
