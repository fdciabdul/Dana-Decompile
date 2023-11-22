package com.google.android.play.core.review.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class zzi {
    private final String zza;

    public zzi(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        this.zza = sb.toString().concat(str);
    }

    private static String zzf(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                InstrumentInjector.log_e("PlayCore", "Unable to format ".concat(str2), e);
                String join = TextUtils.join(", ", objArr);
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(" [");
                sb.append(join);
                sb.append("]");
                str2 = sb.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" : ");
        sb2.append(str2);
        return sb2.toString();
    }

    public final int zza(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            return InstrumentInjector.log_d("PlayCore", zzf(this.zza, "Already connected to the service.", objArr));
        }
        return 0;
    }

    public final int zzb(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return InstrumentInjector.log_e("PlayCore", zzf(this.zza, "Play Store app is either not installed or not the official version", objArr));
        }
        return 0;
    }

    public final int zzc(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return InstrumentInjector.log_e("PlayCore", zzf(this.zza, str, objArr), th);
        }
        return 0;
    }

    public final int zzd(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            return InstrumentInjector.log_i("PlayCore", zzf(this.zza, str, objArr));
        }
        return 0;
    }

    public final int zze(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            return InstrumentInjector.log_w("PlayCore", zzf(this.zza, "Phonesky package is not signed -- possibly self-built package. Could not verify.", objArr));
        }
        return 0;
    }
}
