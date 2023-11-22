package com.google.android.gms.common.logging;

import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

/* loaded from: classes7.dex */
public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    public Logger(String str, String... strArr) {
        String obj;
        if (strArr.length == 0) {
            obj = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            obj = sb.toString();
        }
        this.zzb = obj;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    public void d(String str, Object... objArr) {
        if (isLoggable(3)) {
            InstrumentInjector.log_d(this.zza, format(str, objArr));
        }
    }

    public void e(String str, Throwable th, Object... objArr) {
        InstrumentInjector.log_e(this.zza, format(str, objArr), th);
    }

    protected String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    public String getTag() {
        return this.zza;
    }

    public void i(String str, Object... objArr) {
        InstrumentInjector.log_i(this.zza, format(str, objArr));
    }

    public boolean isLoggable(int i) {
        return this.zzd <= i;
    }

    public void v(String str, Throwable th, Object... objArr) {
        if (isLoggable(2)) {
            InstrumentInjector.log_v(this.zza, format(str, objArr), th);
        }
    }

    public void w(String str, Object... objArr) {
        InstrumentInjector.log_w(this.zza, format(str, objArr));
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        format(str, objArr);
    }

    public void wtf(Throwable th) {
    }

    public void e(String str, Object... objArr) {
        InstrumentInjector.log_e(this.zza, format(str, objArr));
    }

    public void v(String str, Object... objArr) {
        if (isLoggable(2)) {
            InstrumentInjector.log_v(this.zza, format(str, objArr));
        }
    }
}
