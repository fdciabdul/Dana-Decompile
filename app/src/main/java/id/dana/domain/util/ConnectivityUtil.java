package id.dana.domain.util;

import android.util.SparseArray;
import id.dana.domain.notificationcenter.interactor.ConnectionType;

/* loaded from: classes2.dex */
public class ConnectivityUtil {
    public static final int TYPE_OFFLINE = 10;
    private static SparseArray<String> connectionTypes;

    private ConnectivityUtil() {
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        connectionTypes = sparseArray;
        sparseArray.put(0, ConnectionType.TYPE_MOBILE);
        connectionTypes.put(1, ConnectionType.TYPE_WIFI);
        connectionTypes.put(6, ConnectionType.TYPE_WIMAX);
        connectionTypes.put(9, ConnectionType.TYPE_ETHERNET);
        connectionTypes.put(7, ConnectionType.BLUETOOTH);
        connectionTypes.put(10, ConnectionType.OFFLINE);
    }

    public static String formatConnectionType(int i) {
        String str = connectionTypes.get(i);
        return str == null ? ConnectionType.OTHERS : str;
    }
}
