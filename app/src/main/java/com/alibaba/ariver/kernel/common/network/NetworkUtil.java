package com.alibaba.ariver.kernel.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class NetworkUtil {
    public static final String NETWORK_TYPE_2G = "2G";
    public static final String NETWORK_TYPE_3G = "3G";
    public static final String NETWORK_TYPE_4G = "4G";
    public static final String NETWORK_TYPE_NOTREACHABLE = "NotReachable";
    public static final String NETWORK_TYPE_UNKNOWN = "UNKNOWN";
    public static final String NETWORK_TYPE_WIFI = "WIFI";
    public static final String TAG = "NetworkUtil";

    /* renamed from: a  reason: collision with root package name */
    private static Network f6145a;
    private static final List<NetworkListener> b = new CopyOnWriteArrayList();
    private static boolean c = false;
    protected static BroadcastReceiver sBroadcastReceiver = null;

    /* loaded from: classes6.dex */
    public enum Network {
        NETWORK_WIFI,
        NETWORK_MOBILE_FAST,
        NETWORK_MOBILE_MIDDLE,
        NETWORK_MOBILE_SLOW,
        NETWORK_NO_CONNECTION,
        NETWORK_TYPE_UNKNOWN
    }

    /* loaded from: classes3.dex */
    public interface NetworkListener {
        void onNetworkChanged(Network network, Network network2);
    }

    public static Network getCurrentNetworkType(Context context, boolean z) {
        Network network = f6145a;
        if (network == null || !z) {
            d(context);
            return f6145a;
        }
        return network;
    }

    public static String getSimpleNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            RVLogger.e(TAG, "Exception", th);
            networkInfo = null;
        }
        if (networkInfo != null) {
            int type = networkInfo.getType();
            return (type == 1 || type == 9) ? "wifi" : "wwan";
        }
        return "fail";
    }

    public static String getDetailNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            RVLogger.e(TAG, "get network info exception.", th);
            networkInfo = null;
        }
        if (networkInfo != null) {
            int type = networkInfo.getType();
            if (type == 1 || type == 9) {
                return "WIFI";
            }
            int a2 = a(context);
            if (a2 != 18) {
                switch (a2) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return "UNKNOWN";
                }
            }
            return "3G";
        }
        return NETWORK_TYPE_NOTREACHABLE;
    }

    private static int a(Context context) {
        int dataNetworkType;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT < 30) {
                dataNetworkType = telephonyManager.getNetworkType();
            } else {
                dataNetworkType = telephonyManager.getDataNetworkType();
            }
            return dataNetworkType;
        } catch (Exception e) {
            RVLogger.e(TAG, "Network Utils getNetWorkType error , ", e);
            return 0;
        }
    }

    private static void b(Context context) {
        synchronized (NetworkUtil.class) {
            if (c || context == null) {
                return;
            }
            c = true;
            try {
                if (sBroadcastReceiver == null) {
                    sBroadcastReceiver = new MyBroadcastReceiver(null);
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.getApplicationContext().registerReceiver(sBroadcastReceiver, intentFilter);
            } catch (Throwable th) {
                RVLogger.e(TAG, "registerReceiver error", th);
            }
        }
    }

    private static void c(Context context) {
        synchronized (NetworkUtil.class) {
            c = false;
            if (sBroadcastReceiver == null || context == null) {
                return;
            }
            try {
                context.getApplicationContext().unregisterReceiver(sBroadcastReceiver);
                sBroadcastReceiver = null;
            } catch (Throwable th) {
                RVLogger.e(TAG, "unRegisterReceiver error", th);
            }
        }
    }

    public static void addListener(Context context, NetworkListener networkListener) {
        if (networkListener != null) {
            List<NetworkListener> list = b;
            if (list.contains(networkListener)) {
                return;
            }
            b(context);
            list.add(networkListener);
        }
    }

    public static void removeListener(Context context, NetworkListener networkListener) {
        if (networkListener == null) {
            return;
        }
        List<NetworkListener> list = b;
        list.remove(networkListener);
        if (list.size() == 0) {
            c(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.ariver.kernel.common.network.NetworkUtil$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network;

        static {
            int[] iArr = new int[Network.values().length];
            $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network = iArr;
            try {
                iArr[Network.NETWORK_NO_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[Network.NETWORK_MOBILE_SLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[Network.NETWORK_MOBILE_MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[Network.NETWORK_MOBILE_FAST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[Network.NETWORK_WIFI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String transferNetworkType(Network network) {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[network.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "wifi" : "4g" : "3g" : "2g" : "none";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) {
        NetworkInfo networkInfo;
        List<NetworkListener> list;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            RVLogger.e(TAG, "exception detail", th);
            networkInfo = null;
        }
        Network network = f6145a;
        Network a2 = a(networkInfo);
        f6145a = a2;
        if (network == null || a2 == network || (list = b) == null) {
            return;
        }
        RVLogger.d(TAG, "onNetworkChanged");
        synchronized (list) {
            for (NetworkListener networkListener : list) {
                if (networkListener != null) {
                    networkListener.onNetworkChanged(network, f6145a);
                }
            }
        }
    }

    private static Network a(NetworkInfo networkInfo) {
        try {
            if (networkInfo == null) {
                return Network.NETWORK_NO_CONNECTION;
            }
            if (!networkInfo.isConnected()) {
                return Network.NETWORK_NO_CONNECTION;
            }
            int type = networkInfo.getType();
            int subtype = networkInfo.getSubtype();
            StringBuilder sb = new StringBuilder();
            sb.append("type: ");
            sb.append(type);
            sb.append(" subType: ");
            sb.append(subtype);
            RVLogger.d(TAG, sb.toString());
            if (type == 1 || type == 9) {
                return Network.NETWORK_WIFI;
            }
            if (type == 0) {
                if (subtype != 0) {
                    if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                        return Network.NETWORK_MOBILE_SLOW;
                    }
                    if (subtype == 13) {
                        return Network.NETWORK_MOBILE_FAST;
                    }
                    return Network.NETWORK_MOBILE_MIDDLE;
                }
                return Network.NETWORK_TYPE_UNKNOWN;
            }
            return Network.NETWORK_TYPE_UNKNOWN;
        } catch (Exception e) {
            RVLogger.e(TAG, "detectNetwork error!", e);
            return Network.NETWORK_TYPE_UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class MyBroadcastReceiver extends BroadcastReceiver {
        private MyBroadcastReceiver() {
        }

        /* synthetic */ MyBroadcastReceiver(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkUtil.d(context);
        }
    }
}
