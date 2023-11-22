package id.dana.data.config;

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
import com.alipay.iap.android.common.utils.MiscUtils;
import com.alipay.iap.android.f2fpay.extension.IF2FPayDeviceIdGenerator;
import com.alipay.iap.android.lbs.LBSLocation;
import id.dana.data.R;
import id.dana.oauth.OauthConstant;
import id.dana.util.device.OSUtil;
import id.dana.util.permission.Permission;
import id.dana.utils.config.DeviceInformation;
import id.dana.utils.config.model.Bluetooth;
import id.dana.utils.config.model.Cpu;
import id.dana.utils.config.model.Device;
import id.dana.utils.config.model.DeviceInfo;
import id.dana.utils.config.model.Display;
import id.dana.utils.config.model.ExternalStorage;
import id.dana.utils.config.model.Gps;
import id.dana.utils.config.model.IP;
import id.dana.utils.config.model.Memory;
import id.dana.utils.config.model.SysFeature;
import id.dana.utils.config.model.TimeLocation;
import id.dana.utils.config.model.Wifi;
import id.dana.utils.foundation.facede.LbsFacade;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.storage.UTDidInfo;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import timber.log.Timber;

@Singleton
/* loaded from: classes.dex */
public class DeviceInformationProvider implements IF2FPayDeviceIdGenerator, DeviceInformation {
    private static final String OS_TYPE = "android";
    private final Context context;
    private final UTDidInfo utDidInfo;

    public String osType() {
        return OS_TYPE;
    }

    @Inject
    public DeviceInformationProvider(Context context, UTDidInfo uTDidInfo) {
        this.context = context;
        this.utDidInfo = uTDidInfo;
    }

    @Override // id.dana.utils.config.DeviceInformation
    public String getDeviceUtdId() {
        return this.utDidInfo.getUtdid();
    }

    public String getReferenceUtdId() {
        String md5 = MiscUtils.md5(getDeviceUtdId());
        return md5.length() >= 16 ? md5.substring(0, 16) : "";
    }

    public String getCurrentTrackerId() {
        String utdIdPref = this.utDidInfo.getUtdIdPref();
        return TextUtils.isEmpty(utdIdPref) ? getDeviceUtdId() : utdIdPref;
    }

    public String getDeviceUUID() {
        return UUID.randomUUID().toString();
    }

    @Override // id.dana.utils.config.DeviceInformation
    public String generateDeviceId() {
        return generateDeviceId(this.context);
    }

    public void updateUtdIdForMixpanel(String str) {
        this.utDidInfo.saveUtdIdForMixpanel(str);
    }

    public DeviceInfo assembleDeviceInfo() {
        try {
            DeviceInfo.Builder builder = new DeviceInfo.Builder();
            IP ip = getIP();
            DeviceInfo.Builder builder2 = builder;
            if (ip != null) {
                builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = ip;
            }
            SysFeature systemFeature = getSystemFeature();
            DeviceInfo.Builder builder3 = builder;
            if (systemFeature != null) {
                builder.getErrorConfigVersion = systemFeature;
            }
            List<Bluetooth> listOfCurrentBluetooth = getListOfCurrentBluetooth();
            DeviceInfo.Builder builder4 = builder;
            if (listOfCurrentBluetooth != null) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = listOfCurrentBluetooth;
            }
            Device device = getDevice();
            DeviceInfo.Builder builder5 = builder;
            if (device != null) {
                builder.getAuthRequestContext = device;
            }
            Display display = getDisplay();
            DeviceInfo.Builder builder6 = builder;
            if (display != null) {
                builder.MyBillsEntityDataFactory = display;
            }
            Gps gps = getGps();
            DeviceInfo.Builder builder7 = builder;
            if (gps != null) {
                builder.moveToNextValue = gps;
            }
            Memory memory = getMemory();
            DeviceInfo.Builder builder8 = builder;
            if (memory != null) {
                builder.lookAheadTest = memory;
            }
            List<Wifi> listOfCurrentWifi = getListOfCurrentWifi();
            DeviceInfo.Builder builder9 = builder;
            if (listOfCurrentWifi != null) {
                builder.scheduleImpl = listOfCurrentWifi;
            }
            ExternalStorage externalStorage = getExternalStorage();
            DeviceInfo.Builder builder10 = builder;
            if (externalStorage != null) {
                builder.PlaceComponentResult = externalStorage;
            }
            Cpu cpu = getCpu();
            DeviceInfo.Builder builder11 = builder;
            if (cpu != null) {
                builder.BuiltInFictitiousFunctionClassFactory = cpu;
            }
            return new DeviceInfo(builder.NetworkUserEntityData$$ExternalSyntheticLambda0, builder.getErrorConfigVersion, builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.getAuthRequestContext, builder.MyBillsEntityDataFactory, builder.moveToNextValue, builder.lookAheadTest, builder.scheduleImpl, builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPayDeviceIdGenerator
    public String generateDeviceId(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.utDidInfo.getUtdid());
        sb.append("_");
        sb.append(context.getPackageName());
        return sb.toString();
    }

    public Gps getGps() {
        try {
            LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(this.context);
            double latitude = authRequestContext.getLatitude();
            double longitude = authRequestContext.getLongitude();
            return new Gps(String.valueOf(latitude), String.valueOf(longitude), authRequestContext.getErrorCode(), authRequestContext.getTime());
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    public Device getDevice() {
        try {
            Device.Builder builder = new Device.Builder();
            String str = Build.BOARD;
            Device.Builder builder2 = builder;
            if (str != null) {
                builder.MyBillsEntityDataFactory = str;
            }
            String str2 = Build.BRAND;
            Device.Builder builder3 = builder;
            if (str2 != null) {
                builder.getErrorConfigVersion = str2;
            }
            String str3 = Build.DEVICE;
            Device.Builder builder4 = builder;
            if (str3 != null) {
                builder.lookAheadTest = str3;
            }
            String str4 = Build.MANUFACTURER;
            Device.Builder builder5 = builder;
            if (str4 != null) {
                builder.scheduleImpl = str4;
            }
            String str5 = Build.MODEL;
            Device.Builder builder6 = builder;
            if (str5 != null) {
                builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
            }
            String str6 = Build.PRODUCT;
            Device.Builder builder7 = builder;
            if (str6 != null) {
                builder.moveToNextValue = str6;
            }
            String str7 = Build.BOOTLOADER;
            Device.Builder builder8 = builder;
            if (str7 != null) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = str7;
            }
            String string = Settings.System.getString(this.context.getContentResolver(), "android_id");
            Device.Builder builder9 = builder;
            if (string != null) {
                builder.PlaceComponentResult = string;
            }
            String str8 = Build.FINGERPRINT;
            Device.Builder builder10 = builder;
            if (str8 != null) {
                builder.GetContactSyncConfig = str8;
            }
            Device.Builder builder11 = builder;
            builder.initRecordTimeStamp = isEmulator(this.context);
            Device.Builder builder12 = builder;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = isRooted(this.context);
            try {
                BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
                if (bluetoothAdapter != null) {
                    String address = bluetoothAdapter.getAddress();
                    Device.Builder builder13 = builder;
                    if (address != null) {
                        builder.BuiltInFictitiousFunctionClassFactory = address;
                    }
                }
            } catch (SecurityException unused) {
            }
            Gps gps = getGps();
            TimeLocation timeLocation = new TimeLocation(gps.BuiltInFictitiousFunctionClassFactory, gps.getAuthRequestContext, TimeZone.getDefault().getID());
            Device.Builder builder14 = builder;
            builder.isLayoutRequested = timeLocation;
            if (getNetworkType() != null) {
                String networkType = getNetworkType();
                Device.Builder builder15 = builder;
                if (networkType != null) {
                    builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = networkType;
                }
            }
            String str9 = Build.VERSION.RELEASE;
            Device.Builder builder16 = builder;
            if (str9 != null) {
                builder.DatabaseTableConfigUtil = str9;
            }
            Device.Builder builder17 = builder;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda7 = Build.VERSION.SDK_INT;
            String str10 = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
            Device.Builder builder18 = builder;
            if (str10 != null) {
                builder.getAuthRequestContext = str10;
            }
            return new Device(builder.PlaceComponentResult, builder.getAuthRequestContext, builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.getErrorConfigVersion, builder.lookAheadTest, builder.scheduleImpl, builder.NetworkUserEntityData$$ExternalSyntheticLambda0, builder.moveToNextValue, builder.GetContactSyncConfig, builder.initRecordTimeStamp, builder.NetworkUserEntityData$$ExternalSyntheticLambda2, builder.NetworkUserEntityData$$ExternalSyntheticLambda1, builder.DatabaseTableConfigUtil, builder.NetworkUserEntityData$$ExternalSyntheticLambda7, builder.isLayoutRequested);
        } catch (Exception e) {
            Timber.getAuthRequestContext(DanaLogConstants.BizType.DEVICE_INFO).MyBillsEntityDataFactory(e);
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    private String getNetworkDataType() {
        return String.valueOf(((TelephonyManager) this.context.getSystemService("phone")).getDataNetworkType());
    }

    private String getNetworkType() {
        if (Permission.KClassImpl$Data$declaredNonStaticMembers$2(this.context, "android.permission.READ_PHONE_STATE")) {
            if (OSUtil.PlaceComponentResult()) {
                return getNetworkDataType();
            }
            return String.valueOf(((TelephonyManager) this.context.getSystemService("phone")).getNetworkType());
        }
        return null;
    }

    private static BluetoothAdapter getBluetoothAdapter() {
        return BluetoothAdapter.getDefaultAdapter();
    }

    private static boolean isEmulator(Context context) {
        return OauthConstant.OauthType.SDK_TYPE.equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    private static boolean isRooted(Context context) {
        boolean isEmulator = isEmulator(context);
        String str = Build.TAGS;
        if ((isEmulator || str == null || !str.contains("test-keys")) && !new File(context.getString(R.string.path_super_user_apk)).exists()) {
            return !isEmulator && new File(context.getString(R.string.res_0x7f1310ff_networkuserentitydata_externalsyntheticlambda0)).exists();
        }
        return true;
    }

    public SysFeature getSystemFeature() {
        try {
            PackageManager packageManager = this.context.getPackageManager();
            boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.bluetooth");
            boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.location");
            boolean hasSystemFeature3 = packageManager.hasSystemFeature("android.hardware.wifi");
            boolean hasSystemFeature4 = packageManager.hasSystemFeature("android.hardware.telephony");
            boolean hasSystemFeature5 = packageManager.hasSystemFeature("android.hardware.nfc");
            boolean hasSystemFeature6 = packageManager.hasSystemFeature("android.hardware.nfc.hce");
            boolean hasSystemFeature7 = packageManager.hasSystemFeature("android.hardware.wifi.direct");
            return new SysFeature(hasSystemFeature, hasSystemFeature2, hasSystemFeature5, hasSystemFeature6, hasSystemFeature4, packageManager.hasSystemFeature("android.hardware.usb.accessory"), packageManager.hasSystemFeature("android.hardware.usb.host"), hasSystemFeature3, hasSystemFeature7);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    public Memory getMemory() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Runtime.getRuntime().maxMemory());
            sb.append(DiskFormatter.B);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Runtime.getRuntime().totalMemory());
            sb2.append(DiskFormatter.B);
            return new Memory(obj, sb2.toString());
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    @Override // id.dana.utils.config.DeviceInformation
    public IP getIP() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        return new IP(hostAddress, hostAddress);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    public Display getDisplay() {
        try {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            return new Display((int) displayMetrics.scaledDensity, displayMetrics.densityDpi, displayMetrics.heightPixels, i);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    public List<Wifi> getListOfCurrentWifi() {
        ArrayList arrayList = new ArrayList();
        try {
            WifiManager wifiManager = (WifiManager) this.context.getApplicationContext().getSystemService("wifi");
            String bssid = wifiManager.getConnectionInfo().getBSSID();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null && !scanResults.isEmpty()) {
                int min = Math.min(scanResults.size(), 100);
                for (int i = 0; i < min; i++) {
                    arrayList.add(getWifiScanResult(bssid, scanResults.get(i)));
                }
            }
            return arrayList;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return arrayList;
        }
    }

    private static Wifi getWifiScanResult(String str, ScanResult scanResult) {
        String str2 = scanResult.BSSID;
        String str3 = scanResult.SSID;
        return new Wifi(str2, scanResult.frequency, str2 != null && str2.equals(str), scanResult.level, str3);
    }

    public List<Bluetooth> getListOfCurrentBluetooth() {
        ArrayList arrayList = new ArrayList();
        try {
            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
            if (bondedDevices != null && !bondedDevices.isEmpty()) {
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    int bondState = bluetoothDevice.getBondState();
                    arrayList.add(new Bluetooth(bluetoothDevice.getAddress(), bondState, bondState == 12, bondState == 11, bluetoothDevice.getType()));
                }
            }
            return arrayList;
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return arrayList;
        }
    }

    public String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public ExternalStorage getExternalStorage() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSizeLong = statFs.getBlockSizeLong();
            return new ExternalStorage(Formatter.formatFileSize(this.context, statFs.getBlockCountLong() * blockSizeLong), Formatter.formatFileSize(this.context, statFs.getAvailableBlocksLong() * blockSizeLong));
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    public Cpu getCpu() {
        String str;
        String str2;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                str = Build.SUPPORTED_ABIS[0];
                str2 = Build.SUPPORTED_ABIS[1];
            } else {
                str = Build.CPU_ABI;
                str2 = Build.CPU_ABI2;
            }
            String str3 = str;
            String str4 = str2;
            int cpuFrequency = setCpuFrequency();
            int cpuMaxFrequency = setCpuMaxFrequency();
            int cpuMinFrequency = setCpuMinFrequency();
            String cpuName = setCpuName();
            return new Cpu(str3, Integer.valueOf(cpuFrequency), str4, setCpuArchitecture(), Integer.valueOf(cpuMaxFrequency), cpuName, Integer.valueOf(cpuMinFrequency));
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.DEVICE_INFO, DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.toString());
            return null;
        }
    }

    private static int setCpuFrequency() {
        String readFileInfo = readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "");
        if (readFileInfo == null || TextUtils.isEmpty(readFileInfo)) {
            return 0;
        }
        return Integer.parseInt(readFileInfo);
    }

    private static int setCpuMaxFrequency() {
        String readFileInfo = readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "");
        if (readFileInfo == null || TextUtils.isEmpty(readFileInfo)) {
            return 0;
        }
        return Integer.parseInt(readFileInfo);
    }

    private static int setCpuMinFrequency() {
        String readFileInfo = readFileInfo("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq", "");
        if (readFileInfo == null || TextUtils.isEmpty(readFileInfo)) {
            return 0;
        }
        return Integer.parseInt(readFileInfo);
    }

    private static String setCpuName() {
        String readFileInfo = readFileInfo("/proc/cpuinfo", "");
        if (readFileInfo != null) {
            return !TextUtils.isEmpty(readFileInfo) ? readFileInfo.split(":")[1] : "";
        }
        return null;
    }

    private static String setCpuArchitecture() {
        String readFileInfo = readFileInfo("/proc/cpuinfo", "Hardware");
        if (readFileInfo != null) {
            return TextUtils.isEmpty(readFileInfo) ? "" : readFileInfo.split(":")[1];
        }
        return null;
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.DeviceInformationProvider.readFileInfo(java.lang.String, java.lang.String):java.lang.String");
    }
}
