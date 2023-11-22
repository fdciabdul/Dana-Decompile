package com.google.android.gms.internal.fido;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzam {
    private final String zza;
    private final zzak zzb;
    private zzak zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzam(String str, zzal zzalVar) {
        zzak zzakVar = new zzak(null);
        this.zzb = zzakVar;
        this.zzc = zzakVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzak zzakVar = this.zzb.zzc;
        String str = "";
        while (zzakVar != null) {
            Object obj = zzakVar.zzb;
            sb.append(str);
            String str2 = zzakVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            }
            zzakVar = zzakVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzam zza(String str, int i) {
        zzai zzaiVar = new zzai(null);
        this.zzc.zzc = zzaiVar;
        this.zzc = zzaiVar;
        zzaiVar.zzb = String.valueOf(i);
        zzaiVar.zza = "errorCode";
        return this;
    }

    public final zzam zzb(String str, @CheckForNull Object obj) {
        zzak zzakVar = new zzak(null);
        this.zzc.zzc = zzakVar;
        this.zzc = zzakVar;
        zzakVar.zzb = obj;
        zzakVar.zza = str;
        return this;
    }
}
