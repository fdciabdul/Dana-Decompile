package com.huawei.hms.framework.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.HwTelephonyManager;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class NetworkUtil {
    public static final int UNAVAILABLE = Integer.MAX_VALUE;
    private static final String getAuthRequestContext = "NetworkUtil";

    /* loaded from: classes7.dex */
    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_4G_NSA = 7;
        public static final int TYPE_5G = 5;
        public static final int TYPE_5G_SA = 8;
        public static final int TYPE_MOBILE = 6;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    /* loaded from: classes7.dex */
    public static final class SignalType {
        public static final String LTE_CQI = "lteCqi";
        public static final String LTE_DBM = "lteDbm";
        public static final String LTE_RSRP = "lteRsrp";
        public static final String LTE_RSRQ = "lteRsrq";
        public static final String LTE_RSSI = "lteRssi";
        public static final String LTE_RSSNR = "lteRssnr";
        public static final String NR_CSIRSRP = "nrCSIRsrp";
        public static final String NR_CSIRSRQ = "nrCSIRsrq";
        public static final String NR_CSISINR = "nrCSISinr";
        public static final String NR_DBM = "nrDbm";
        public static final String NR_SSRSRP = "nrSSRsrp";
        public static final String NR_SSRSRQ = "nrSSRsrq";
        public static final String NR_SSSINR = "nrSSSinr";
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (i != -1) {
            if (i != 1) {
                return (i == 2 || i == 3 || i == 4 || i == 5) ? 6 : 0;
            }
            return 1;
        }
        return -1;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (RuntimeException e) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getActiveNetworkInfo failed, exception:");
            sb.append(e.getClass().getSimpleName());
            sb.append(e.getMessage());
            Logger.i(str, sb.toString());
            return null;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo networkInfo = getNetworkInfo(context);
            return networkInfo != null && networkInfo.isConnected();
        }
        return true;
    }

    public static int netWork(Context context) {
        int networkType = getNetworkType(context);
        String str = getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append("newWorkType ");
        sb.append(networkType);
        Logger.v(str, sb.toString());
        if (networkType == 4) {
            if (TextUtils.equals("5G_NSA", getNetWorkNSAorSA())) {
                return 7;
            }
            return networkType;
        } else if (networkType == 5 && TextUtils.equals("5G_SA", getNetWorkNSAorSA())) {
            return 8;
        } else {
            return networkType;
        }
    }

    public static String getNetWorkNSAorSA() {
        try {
            HwTelephonyManager hwTelephonyManager = HwTelephonyManager.getDefault();
            int default4GSlotId = hwTelephonyManager.getDefault4GSlotId();
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("phoneId ");
            sb.append(default4GSlotId);
            Logger.v(str, sb.toString());
            boolean isNsaState = hwTelephonyManager.isNsaState(default4GSlotId);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isNsa ");
            sb2.append(isNsaState);
            Logger.v(str, sb2.toString());
            return isNsaState ? "5G_NSA" : "5G_SA";
        } catch (Throwable unused) {
            Logger.v(getAuthRequestContext, "isNsaState error");
            return null;
        }
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context), context);
        }
        return 0;
    }

    private static int BuiltInFictitiousFunctionClassFactory(Context context) {
        TelephonyManager telephonyManager;
        ServiceState serviceState;
        if (!ReflectionUtils.checkCompatible(EmuiUtil.BUILDEX_VERSION) || context == null || (telephonyManager = (TelephonyManager) ContextCompat.getSystemService(context, "phone")) == null) {
            return 0;
        }
        try {
            if (BuildEx.VERSION.EMUI_SDK_INT < 21 || (serviceState = telephonyManager.getServiceState()) == null) {
                return 0;
            }
            return ServiceStateEx.getConfigRadioTechnology(serviceState);
        } catch (NoClassDefFoundError unused) {
            Logger.w(getAuthRequestContext, "NoClassDefFoundError occur in method getHwNetworkType.");
            return 0;
        } catch (NoSuchMethodError unused2) {
            Logger.w(getAuthRequestContext, "NoSuchMethodError occur in method getHwNetworkType.");
            return 0;
        } catch (SecurityException unused3) {
            Logger.w(getAuthRequestContext, "requires permission maybe missing.");
            return 0;
        }
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        int i;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type == 0) {
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(context);
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getHwNetworkType return is: ");
            sb.append(BuiltInFictitiousFunctionClassFactory);
            Logger.v(str, sb.toString());
            if (BuiltInFictitiousFunctionClassFactory == 0) {
                BuiltInFictitiousFunctionClassFactory = networkInfo.getSubtype();
            }
            if (BuiltInFictitiousFunctionClassFactory != 20) {
                switch (BuiltInFictitiousFunctionClassFactory) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        i = 2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        i = 3;
                        break;
                    case 13:
                        i = 4;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 5;
            }
            if (i != 0 || Build.VERSION.SDK_INT < 25) {
                return i;
            }
            if (BuiltInFictitiousFunctionClassFactory == 16) {
                return 2;
            }
            if (BuiltInFictitiousFunctionClassFactory == 17) {
                return 3;
            }
        }
        return 0;
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        return getNetworkType(networkInfo, null);
    }

    private static String[] getAuthRequestContext(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        LinkProperties linkProperties;
        LinkedList linkedList = new LinkedList();
        if (Build.VERSION.SDK_INT >= 21 && context != null && (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (network != null && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.getType() == activeNetworkInfo.getType() && (linkProperties = connectivityManager.getLinkProperties(network)) != null) {
                            Iterator<InetAddress> it = linkProperties.getDnsServers().iterator();
                            while (it.hasNext()) {
                                linkedList.add(it.next().getHostAddress());
                            }
                        }
                    }
                }
            } catch (SecurityException e) {
                String str = getAuthRequestContext;
                StringBuilder sb = new StringBuilder();
                sb.append("getActiveNetworkInfo failed, exception:");
                sb.append(e.getClass().getSimpleName());
                Logger.i(str, sb.toString());
            } catch (RuntimeException e2) {
                String str2 = getAuthRequestContext;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getActiveNetworkInfo failed, exception:");
                sb2.append(e2.getClass().getSimpleName());
                Logger.i(str2, sb2.toString());
            }
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(getAuthRequestContext(context));
    }

    public static int getMobileRsrp(Context context) {
        SignalStrength PlaceComponentResult = PlaceComponentResult(context);
        if (PlaceComponentResult == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return MyBillsEntityDataFactory(context);
            }
            return getInfoWithReflect(PlaceComponentResult, "getDbm");
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getDbm: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
            return Integer.MAX_VALUE;
        }
    }

    public static int getLteRsrq(Context context) {
        SignalStrength PlaceComponentResult = PlaceComponentResult(context);
        if (PlaceComponentResult == null) {
            return Integer.MAX_VALUE;
        }
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getLteRsrq: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT > 28) {
            List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq();
            }
            return Integer.MAX_VALUE;
        }
        return getInfoWithReflect(PlaceComponentResult, "getLteRsrq");
    }

    public static int getLteRssnr(Context context) {
        SignalStrength PlaceComponentResult = PlaceComponentResult(context);
        if (PlaceComponentResult == null) {
            return Integer.MAX_VALUE;
        }
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getLteRssnr: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT > 28) {
            List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr();
            }
            return Integer.MAX_VALUE;
        }
        return getInfoWithReflect(PlaceComponentResult, "getLteRssnr");
    }

    public static int getLteRsrp(Context context) {
        SignalStrength PlaceComponentResult = PlaceComponentResult(context);
        if (PlaceComponentResult == null) {
            return Integer.MAX_VALUE;
        }
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getLteRsrp: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT > 28) {
            List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp();
            }
            return Integer.MAX_VALUE;
        }
        return getInfoWithReflect(PlaceComponentResult, "getLteRsrp");
    }

    public static int getLteCqi(Context context) {
        SignalStrength PlaceComponentResult = PlaceComponentResult(context);
        if (PlaceComponentResult == null) {
            return Integer.MAX_VALUE;
        }
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getLteCqi: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT > 28) {
            List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi();
            }
            return Integer.MAX_VALUE;
        }
        return getInfoWithReflect(PlaceComponentResult, "getLteCqi");
    }

    public static int getLteRssi(Context context) {
        SignalStrength PlaceComponentResult = PlaceComponentResult(context);
        if (PlaceComponentResult == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi();
                }
            }
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getLteRssi: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        return Integer.MAX_VALUE;
    }

    public static int getInfoWithReflect(SignalStrength signalStrength, String str) {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                final Method declaredMethod = SignalStrength.class.getDeclaredMethod(str, new Class[0]);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.NetworkUtil.1
                    @Override // java.security.PrivilegedAction
                    public final Object run() {
                        declaredMethod.setAccessible(true);
                        return null;
                    }
                });
                return ((Integer) declaredMethod.invoke(signalStrength, new Object[0])).intValue();
            }
            return Integer.MAX_VALUE;
        } catch (IllegalAccessException unused) {
            String str2 = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" : cannot access");
            Logger.i(str2, sb.toString());
            return Integer.MAX_VALUE;
        } catch (NoSuchMethodException unused2) {
            String str3 = getAuthRequestContext;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" : function not found");
            Logger.i(str3, sb2.toString());
            return Integer.MAX_VALUE;
        } catch (InvocationTargetException unused3) {
            String str4 = getAuthRequestContext;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(" : InvocationTargetException");
            Logger.i(str4, sb3.toString());
            return Integer.MAX_VALUE;
        } catch (Throwable th) {
            String str5 = getAuthRequestContext;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(" : throwable:");
            sb4.append(th.getClass());
            Logger.i(str5, sb4.toString());
            return Integer.MAX_VALUE;
        }
    }

    public static Map<String, Integer> getLteSignalInfo(Context context) {
        HashMap hashMap = new HashMap();
        SignalStrength PlaceComponentResult = PlaceComponentResult(context);
        if (PlaceComponentResult == null) {
            return hashMap;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    hashMap.put(SignalType.LTE_DBM, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getDbm()));
                    hashMap.put(SignalType.LTE_RSRP, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp()));
                    hashMap.put(SignalType.LTE_RSRQ, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq()));
                    hashMap.put(SignalType.LTE_RSSNR, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr()));
                    hashMap.put(SignalType.LTE_CQI, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi()));
                    hashMap.put(SignalType.LTE_RSSI, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi()));
                }
            } else {
                hashMap.put(SignalType.LTE_DBM, Integer.valueOf(getInfoWithReflect(PlaceComponentResult, "getDbm")));
                hashMap.put(SignalType.LTE_RSRP, Integer.valueOf(getInfoWithReflect(PlaceComponentResult, "getLteRsrp")));
                hashMap.put(SignalType.LTE_RSRQ, Integer.valueOf(getInfoWithReflect(PlaceComponentResult, "getLteRsrq")));
                hashMap.put(SignalType.LTE_RSSNR, Integer.valueOf(getInfoWithReflect(PlaceComponentResult, "getLteRssnr")));
                hashMap.put(SignalType.LTE_CQI, Integer.valueOf(getInfoWithReflect(PlaceComponentResult, "getLteCqi")));
            }
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getLteRssi: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        return hashMap;
    }

    public static Map<String, Integer> getNrSignalInfo(Context context) {
        HashMap hashMap = new HashMap();
        SignalStrength PlaceComponentResult = PlaceComponentResult(context);
        if (PlaceComponentResult == null) {
            return hashMap;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthNr.class);
                if (cellSignalStrengths.size() > 0) {
                    hashMap.put(SignalType.NR_DBM, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getDbm()));
                    hashMap.put(SignalType.NR_CSIRSRP, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrp()));
                    hashMap.put(SignalType.NR_CSIRSRQ, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrq()));
                    hashMap.put(SignalType.NR_CSISINR, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiSinr()));
                    hashMap.put(SignalType.NR_SSRSRP, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrp()));
                    hashMap.put(SignalType.NR_SSRSRQ, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrq()));
                    hashMap.put(SignalType.NR_SSSINR, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsSinr()));
                }
            }
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getLteRssi: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        return hashMap;
    }

    public static int getNrSsRsrp(Context context) {
        SignalStrength PlaceComponentResult;
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getNrSsRsrp: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT <= 28 || (PlaceComponentResult = PlaceComponentResult(context)) == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrp();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrCsiRsrp(Context context) {
        SignalStrength PlaceComponentResult;
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getNrCsiRsrp: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT <= 28 || (PlaceComponentResult = PlaceComponentResult(context)) == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrp();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrSsRsrq(Context context) {
        SignalStrength PlaceComponentResult;
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getNrSsRsrq: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT <= 28 || (PlaceComponentResult = PlaceComponentResult(context)) == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrq();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrCsiRsrq(Context context) {
        SignalStrength PlaceComponentResult;
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getNrCsiRsrq: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT <= 28 || (PlaceComponentResult = PlaceComponentResult(context)) == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrq();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrSsSinr(Context context) {
        SignalStrength PlaceComponentResult;
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getNrSsSinr: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT <= 28 || (PlaceComponentResult = PlaceComponentResult(context)) == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsSinr();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrCsiSinr(Context context) {
        SignalStrength PlaceComponentResult;
        try {
        } catch (Throwable th) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("getNrCsiSinr: throwable:");
            sb.append(th.getClass());
            Logger.i(str, sb.toString());
        }
        if (Build.VERSION.SDK_INT <= 28 || (PlaceComponentResult = PlaceComponentResult(context)) == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiSinr();
        }
        return Integer.MAX_VALUE;
    }

    private static SignalStrength PlaceComponentResult(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 28) {
            return null;
        }
        Object systemService = ContextCompat.getSystemService(context, "phone");
        if (systemService instanceof TelephonyManager) {
            return ((TelephonyManager) systemService).createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSignalStrength();
        }
        return null;
    }

    public static int getWifiRssi(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
            if (systemService instanceof WifiManager) {
                try {
                    WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getBSSID() == null) {
                        return -127;
                    }
                    return connectionInfo.getRssi();
                } catch (RuntimeException e) {
                    String str = getAuthRequestContext;
                    StringBuilder sb = new StringBuilder();
                    sb.append("getWifiRssiLevel did not has permission!");
                    sb.append(e.getClass().getSimpleName());
                    sb.append(e.getMessage());
                    Logger.i(str, sb.toString());
                    return -127;
                }
            }
            return -127;
        }
        return -127;
    }

    public static int getWifiRssiLevel(Context context) {
        return WifiManager.calculateSignalLevel(getWifiRssi(context), 5);
    }

    public static String getWifiGatewayIp(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
            if (systemService instanceof WifiManager) {
                try {
                    int i = ((WifiManager) systemService).getDhcpInfo().gateway;
                    return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)}).getHostAddress();
                } catch (RuntimeException | UnknownHostException e) {
                    String str = getAuthRequestContext;
                    StringBuilder sb = new StringBuilder();
                    sb.append("getWifiGatewayIp error!");
                    sb.append(e.getClass().getSimpleName());
                    sb.append(e.getMessage());
                    Logger.i(str, sb.toString());
                }
            }
        }
        return " ";
    }

    public static NetworkInfo.DetailedState getNetworkStatus(Context context) {
        NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof ConnectivityManager) {
                try {
                    if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                        return detailedState;
                    }
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        detailedState = activeNetworkInfo.getDetailedState();
                    } else {
                        Logger.i(getAuthRequestContext, "getNetworkStatus networkIsConnected netInfo is null!");
                    }
                } catch (RuntimeException e) {
                    String str = getAuthRequestContext;
                    StringBuilder sb = new StringBuilder();
                    sb.append("getNetworkStatus exception");
                    sb.append(e.getClass().getSimpleName());
                    sb.append(e.getMessage());
                    Logger.i(str, sb.toString());
                }
            } else {
                Logger.i(getAuthRequestContext, "getNetworkStatus ConnectivityManager is null!");
            }
        }
        return detailedState;
    }

    public static int readDataSaverMode(Context context) {
        int i = 0;
        if (context != null && Build.VERSION.SDK_INT >= 24 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            Object systemService = ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof ConnectivityManager) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                try {
                    if (connectivityManager.isActiveNetworkMetered()) {
                        i = connectivityManager.getRestrictBackgroundStatus();
                    } else {
                        Logger.v(getAuthRequestContext, "ConnectType is not Mobile Network!");
                    }
                } catch (RuntimeException e) {
                    Logger.e(getAuthRequestContext, "SystemServer error:", e);
                }
            }
        }
        return i;
    }

    public static boolean isSimReady(Context context) {
        Object systemService = ContextCompat.getSystemService(context, "phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }

    public static String getMNC(Context context) {
        if (context != null && isSimReady(context)) {
            Object systemService = ContextCompat.getSystemService(context, "phone");
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            if (telephonyManager == null) {
                Logger.e(getAuthRequestContext, "getSubscriptionOperatorType: other error!");
                return "unknown";
            }
            String networkOperator = telephonyManager.getNetworkOperator();
            return ("46001".equals(networkOperator) || "46006".equals(networkOperator) || "46009".equals(networkOperator)) ? "China_Unicom" : ("46000".equals(networkOperator) || "46002".equals(networkOperator) || "46004".equals(networkOperator) || "46007".equals(networkOperator)) ? "China_Mobile" : ("46003".equals(networkOperator) || "46005".equals(networkOperator) || "46011".equals(networkOperator)) ? "China_Telecom" : "other";
        }
        return "unknown";
    }

    public static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URI(str).getHost();
        } catch (URISyntaxException e) {
            Logger.w(getAuthRequestContext, e.getClass().getSimpleName());
            return "";
        }
    }

    public static boolean isUserUnlocked(Context context) {
        UserManager userManager;
        if (Build.VERSION.SDK_INT < 24 || (userManager = (UserManager) ContextCompat.getSystemService(context, "user")) == null) {
            return true;
        }
        try {
            return userManager.isUserUnlocked();
        } catch (RuntimeException e) {
            Logger.e(getAuthRequestContext, "dealType rethrowFromSystemServer:", e);
            return true;
        }
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return ActivityUtil.isForeground(context);
    }

    @Deprecated
    public static NetworkInfo.DetailedState networkStatus(Context context) {
        return getNetworkStatus(context);
    }

    public static boolean isConnectTypeChange(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo2.isConnected() || getPrimaryNetworkType(networkInfo) == getPrimaryNetworkType(networkInfo2)) {
            return false;
        }
        Logger.v(getAuthRequestContext, "Find activity network changed");
        return true;
    }

    public static boolean isChangeToConnected(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if ((networkInfo == null || !networkInfo.isConnected()) && networkInfo2.isConnected()) {
            Logger.v(getAuthRequestContext, "Find network state changed to connected");
            return true;
        }
        return false;
    }

    public static int getPrimaryNetworkType(Context context) {
        return KClassImpl$Data$declaredNonStaticMembers$2(getNetworkType(getNetworkInfo(context), context));
    }

    public static int getPrimaryNetworkType(NetworkInfo networkInfo) {
        return KClassImpl$Data$declaredNonStaticMembers$2(getNetworkType(networkInfo));
    }

    private static int MyBillsEntityDataFactory(Context context) {
        SignalStrength PlaceComponentResult;
        int i = Integer.MAX_VALUE;
        if (Build.VERSION.SDK_INT > 28 && (PlaceComponentResult = PlaceComponentResult(context)) != null) {
            int networkType = getNetworkType(context);
            try {
            } catch (Throwable th) {
                String str = getAuthRequestContext;
                StringBuilder sb = new StringBuilder();
                sb.append("getMobileSingalStrength: throwable:");
                sb.append(th.getClass());
                Logger.i(str, sb.toString());
            }
            if (networkType == 3) {
                List cellSignalStrengths = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthCdma.class);
                if (cellSignalStrengths.size() > 0) {
                    i = ((CellSignalStrengthCdma) cellSignalStrengths.get(0)).getDbm();
                } else {
                    List cellSignalStrengths2 = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthTdscdma.class);
                    if (cellSignalStrengths2.size() > 0) {
                        i = ((CellSignalStrengthTdscdma) cellSignalStrengths2.get(0)).getDbm();
                    } else {
                        List cellSignalStrengths3 = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthWcdma.class);
                        if (cellSignalStrengths3.size() > 0) {
                            i = ((CellSignalStrengthWcdma) cellSignalStrengths3.get(0)).getDbm();
                        }
                    }
                }
            } else if (networkType != 4) {
                if (networkType == 5) {
                    List cellSignalStrengths4 = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthNr.class);
                    if (cellSignalStrengths4.size() > 0) {
                        i = ((CellSignalStrengthNr) cellSignalStrengths4.get(0)).getDbm();
                    }
                }
                return i;
            } else {
                List cellSignalStrengths5 = PlaceComponentResult.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (cellSignalStrengths5.size() > 0) {
                    i = ((CellSignalStrengthLte) cellSignalStrengths5.get(0)).getDbm();
                }
            }
            return i;
        }
        return Integer.MAX_VALUE;
    }
}
