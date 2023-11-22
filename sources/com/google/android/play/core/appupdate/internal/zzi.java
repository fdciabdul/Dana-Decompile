package com.google.android.play.core.appupdate.internal;

import android.os.Bundle;
import id.dana.danah5.scanqr.ScanQrBridge;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class zzi {
    private static final Set zza = new HashSet(Arrays.asList("app_update", "review"));
    private static final Set zzb = new HashSet(Arrays.asList(ScanQrBridge.CODE_CONSUMER_NATIVE, "unity"));
    private static final Map zzc = new HashMap();
    private static final zzm zzd = new zzm("PlayCoreVersion");

    public static Bundle zza(String str) {
        Bundle bundle = new Bundle();
        Map zzb2 = zzb("app_update");
        bundle.putInt("playcore_version_code", ((Integer) zzb2.get("java")).intValue());
        if (zzb2.containsKey(ScanQrBridge.CODE_CONSUMER_NATIVE)) {
            bundle.putInt("playcore_native_version", ((Integer) zzb2.get(ScanQrBridge.CODE_CONSUMER_NATIVE)).intValue());
        }
        if (zzb2.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", ((Integer) zzb2.get("unity")).intValue());
        }
        return bundle;
    }

    public static Map zzb(String str) {
        Map map;
        synchronized (zzi.class) {
            Map map2 = zzc;
            if (!map2.containsKey("app_update")) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 11004);
                map2.put("app_update", hashMap);
            }
            map = (Map) map2.get("app_update");
        }
        return map;
    }
}
