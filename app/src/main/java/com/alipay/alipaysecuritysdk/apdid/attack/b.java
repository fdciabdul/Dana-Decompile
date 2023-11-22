package com.alipay.alipaysecuritysdk.apdid.attack;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Debug;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.google.common.base.Ascii;
import id.dana.analytics.tracker.TrackerKey;
import java.io.File;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public final class b {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {94, Ascii.EM, -44, 73, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12};
    public static final int MyBillsEntityDataFactory = 70;

    /* renamed from: a  reason: collision with root package name */
    public static List<a> f6848a;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:11:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 7
            int r6 = r6 + 16
            int r7 = r7 + 4
            int r8 = r8 * 9
            int r8 = r8 + 97
            byte[] r0 = com.alipay.alipaysecuritysdk.apdid.attack.b.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L3a
        L1b:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1f:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            int r4 = r3 + 1
            if (r3 != r6) goto L30
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L30:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L3a:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.apdid.attack.b.b(int, short, byte, java.lang.Object[]):void");
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f6849a;
        public String b;
        public String c;
        public Class[] d;

        public a(int i, String str, String str2, Class[] clsArr) {
            this.f6849a = i;
            this.b = str;
            this.c = str2;
            this.d = clsArr;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f6848a = arrayList;
        arrayList.add(new a(0, Settings.System.class.getName(), "getString", new Class[]{ContentResolver.class, String.class}));
        f6848a.add(new a(1, SharedPreferences.Editor.class.getName(), "putString", new Class[]{String.class, String.class}));
        f6848a.add(new a(2, "android.os.SystemProperties", "get", new Class[]{String.class, String.class}));
        f6848a.add(new a(3, TelephonyManager.class.getName(), "getSubscriberId", new Class[0]));
        f6848a.add(new a(5, TelephonyManager.class.getName(), "getDeviceId", new Class[0]));
        f6848a.add(new a(6, TelephonyManager.class.getName(), "getVoiceMailNumber", new Class[0]));
        f6848a.add(new a(7, TelephonyManager.class.getName(), "getSimSerialNumber", new Class[0]));
        f6848a.add(new a(8, TelephonyManager.class.getName(), "getNetworkCountryIso", new Class[0]));
        f6848a.add(new a(9, TelephonyManager.class.getName(), "getNetworkOperatorName", new Class[0]));
        f6848a.add(new a(10, TelephonyManager.class.getName(), "getSimOperatorName", new Class[0]));
        f6848a.add(new a(11, TelephonyManager.class.getName(), "getPhoneType", new Class[0]));
        f6848a.add(new a(12, TelephonyManager.class.getName(), "getNetworkType", new Class[0]));
        f6848a.add(new a(13, TelephonyManager.class.getName(), "getCellLocation", new Class[0]));
        f6848a.add(new a(14, TelephonyManager.class.getName(), "getDeviceSoftwareVersion", new Class[0]));
        f6848a.add(new a(15, WifiInfo.class.getName(), "getMacAddress", new Class[0]));
        f6848a.add(new a(16, WifiInfo.class.getName(), "getIpAddress", new Class[0]));
        f6848a.add(new a(17, WifiInfo.class.getName(), "getSSID", new Class[0]));
        f6848a.add(new a(18, WifiInfo.class.getName(), "getBSSID", new Class[0]));
        f6848a.add(new a(19, WifiManager.class.getName(), "getConnectionInfo", new Class[0]));
        f6848a.add(new a(20, WifiManager.class.getName(), "getDhcpInfo", new Class[0]));
        f6848a.add(new a(21, WifiManager.class.getName(), "getScanResults", new Class[0]));
        f6848a.add(new a(22, NetworkInterface.class.getName(), "getNetworkInterfaces", new Class[0]));
        List<a> list = f6848a;
        String name = Proxy.class.getName();
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        Object[] objArr = new Object[1];
        b(bArr[9], bArr[7], bArr[25], objArr);
        list.add(new a(23, name, "getHost", new Class[]{Class.forName((String) objArr[0])}));
        List<a> list2 = f6848a;
        String name2 = Proxy.class.getName();
        byte[] bArr2 = BuiltInFictitiousFunctionClassFactory;
        Object[] objArr2 = new Object[1];
        b(bArr2[9], bArr2[7], bArr2[25], objArr2);
        list2.add(new a(24, name2, "getPort", new Class[]{Class.forName((String) objArr2[0])}));
        List<a> list3 = f6848a;
        byte b = BuiltInFictitiousFunctionClassFactory[25];
        Object[] objArr3 = new Object[1];
        b(b, (byte) (b | Ascii.NAK), r1[9], objArr3);
        list3.add(new a(25, Class.forName((String) objArr3[0]).getName(), "getProperty", new Class[]{String.class}));
        f6848a.add(new a(26, PackageManager.class.getName(), "getInstallerPackageName", new Class[]{String.class}));
        f6848a.add(new a(27, PackageManager.class.getName(), "getPackageInfo", new Class[]{String.class, Integer.TYPE}));
        f6848a.add(new a(28, PackageManager.class.getName(), "getInstalledPackages", new Class[]{Integer.TYPE}));
        f6848a.add(new a(29, File.class.getName(), "getAbsolutePath", new Class[0]));
        f6848a.add(new a(30, ActivityManager.class.getName(), "getRunningTasks", new Class[]{Integer.TYPE}));
        f6848a.add(new a(31, ComponentName.class.getName(), "getPackageName", new Class[0]));
        f6848a.add(new a(32, Modifier.class.getName(), TrackerKey.ScanQRProperties.IS_NATIVE, new Class[]{Integer.TYPE}));
        f6848a.add(new a(33, Debug.class.getName(), "isDebuggerConnected", new Class[0]));
        f6848a.add(new a(34, Process.class.getName(), "myPid", new Class[0]));
        f6848a.add(new a(35, TimeZone.class.getName(), "getRawOffset", new Class[0]));
        f6848a.add(new a(36, TimeZone.class.getName(), "getDSTSavings", new Class[0]));
        f6848a.add(new a(37, Locale.class.getName(), ZolozEkycH5Handler.HUMMER_FOUNDATION_GET_LANGUAGE, new Class[0]));
        f6848a.add(new a(38, Intent.class.getName(), "getIntent", new Class[]{String.class}));
        f6848a.add(new a(39, Intent.class.getName(), "getExtra", new Class[]{String.class}));
        f6848a.add(new a(40, Intent.class.getName(), "getBooleanExtra", new Class[]{String.class, Boolean.TYPE}));
        f6848a.add(new a(41, Intent.class.getName(), "getByteExtra", new Class[]{String.class, Byte.TYPE}));
        f6848a.add(new a(42, Intent.class.getName(), "getShortExtra", new Class[]{String.class, Short.TYPE}));
        f6848a.add(new a(43, Intent.class.getName(), "getCharExtra", new Class[]{String.class, Character.TYPE}));
        f6848a.add(new a(44, Intent.class.getName(), "getIntExtra", new Class[]{String.class, Integer.TYPE}));
        f6848a.add(new a(45, Intent.class.getName(), "getLongExtra", new Class[]{String.class, Long.TYPE}));
        f6848a.add(new a(46, Intent.class.getName(), "getFloatExtra", new Class[]{String.class, Float.TYPE}));
        f6848a.add(new a(47, Intent.class.getName(), "getDoubleExtra", new Class[]{String.class, Double.TYPE}));
        f6848a.add(new a(48, Intent.class.getName(), "getStringExtra", new Class[]{String.class}));
        f6848a.add(new a(49, Display.class.getName(), "getWidth", new Class[0]));
        f6848a.add(new a(50, Display.class.getName(), "getHeight", new Class[0]));
        f6848a.add(new a(51, BluetoothAdapter.class.getName(), "getAddress", new Class[0]));
        f6848a.add(new a(52, Settings.Secure.class.getName(), "getString", new Class[]{ContentResolver.class, String.class}));
        f6848a.add(new a(53, ActivityManager.class.getName(), "getMemoryInfo", new Class[]{ActivityManager.MemoryInfo.class}));
        f6848a.add(new a(54, StatFs.class.getName(), "getBlockSize", new Class[0]));
        f6848a.add(new a(55, StatFs.class.getName(), "getBlockSizeLong", new Class[0]));
        f6848a.add(new a(56, StatFs.class.getName(), "getBlockCount", new Class[0]));
        f6848a.add(new a(57, StatFs.class.getName(), "getBlockCountLong", new Class[0]));
        f6848a.add(new a(58, StatFs.class.getName(), "getAvailableBlocks", new Class[0]));
        f6848a.add(new a(59, StatFs.class.getName(), "getAvailableBlocksLong", new Class[0]));
        f6848a.add(new a(60, Location.class.getName(), "getLatitude", new Class[0]));
        f6848a.add(new a(61, Location.class.getName(), "getLongitude", new Class[0]));
        f6848a.add(new a(62, InetAddress.class.getName(), "isLoopbackAddress", new Class[0]));
        f6848a.add(new a(63, "android.os.SystemProperties", "get", new Class[]{String.class}));
    }

    public static String a(String str) {
        for (a aVar : f6848a) {
            if (str.contains(aVar.b) && str.contains(aVar.c)) {
                Class[] clsArr = aVar.d;
                StringBuilder sb = new StringBuilder();
                for (Class cls : clsArr) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(cls.getName());
                }
                if (str.contains(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aVar.b);
                    sb2.append("#");
                    sb2.append(aVar.c);
                    return sb2.toString();
                }
            }
        }
        return "";
    }
}
