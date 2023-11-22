package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class WakeLocks {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = Logger.MyBillsEntityDataFactory("WakeLocks");
    private static final WeakHashMap<PowerManager.WakeLock, String> getAuthRequestContext = new WeakHashMap<>();

    public static PowerManager.WakeLock getAuthRequestContext(Context context, String str) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        StringBuilder sb = new StringBuilder();
        sb.append("WorkManager: ");
        sb.append(str);
        String obj = sb.toString();
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, obj);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = getAuthRequestContext;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, obj);
        }
        return newWakeLock;
    }

    public static void PlaceComponentResult() {
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = getAuthRequestContext;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.getAuthRequestContext().getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
    }

    private WakeLocks() {
    }
}
