package com.google.android.play.core.review;

import android.os.Bundle;
import id.dana.danah5.scanqr.ScanQrBridge;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public final class zzj {
    private static final Set zza = new HashSet(Arrays.asList(ScanQrBridge.CODE_CONSUMER_NATIVE, "unity"));
    private static final Map zzb = new HashMap();
    private static final com.google.android.play.core.review.internal.zzi zzc = new com.google.android.play.core.review.internal.zzi("PlayCoreVersion");

    public static Bundle zza() {
        Bundle bundle = new Bundle();
        Map zzb2 = zzb();
        bundle.putInt("playcore_version_code", ((Integer) zzb2.get("java")).intValue());
        if (zzb2.containsKey(ScanQrBridge.CODE_CONSUMER_NATIVE)) {
            bundle.putInt("playcore_native_version", ((Integer) zzb2.get(ScanQrBridge.CODE_CONSUMER_NATIVE)).intValue());
        }
        if (zzb2.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", ((Integer) zzb2.get("unity")).intValue());
        }
        return bundle;
    }

    public static Map zzb() {
        Map map;
        synchronized (zzj.class) {
            map = zzb;
            map.put("java", 11004);
        }
        return map;
    }
}
