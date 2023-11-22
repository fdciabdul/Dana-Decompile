package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes7.dex */
public final class zzib implements zzhj {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzib zza(Context context, String str, Runnable runnable) {
        zzib zzibVar;
        if (!zzha.zzb()) {
            synchronized (zzib.class) {
                zzibVar = (zzib) zza.get(null);
                if (zzibVar == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzibVar;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc() {
        synchronized (zzib.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (it.hasNext()) {
                zzib zzibVar = (zzib) it.next();
                SharedPreferences sharedPreferences = zzibVar.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = zzibVar.zzc;
                throw null;
            }
            map.clear();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhj
    public final Object zzb(String str) {
        throw null;
    }
}
