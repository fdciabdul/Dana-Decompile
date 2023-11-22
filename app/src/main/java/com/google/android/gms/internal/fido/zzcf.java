package com.google.android.gms.internal.fido;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzcf extends zzcg {
    private zzcf(zzcd zzcdVar, @CheckForNull Character ch) {
        super(zzcdVar, ch);
        char[] cArr;
        cArr = zzcdVar.zzf;
        zzap.zzc(cArr.length == 64);
    }

    @Override // com.google.android.gms.internal.fido.zzcg
    final zzch zza(zzcd zzcdVar, @CheckForNull Character ch) {
        return new zzcf(zzcdVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzcg, com.google.android.gms.internal.fido.zzch
    final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzap.zze(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = i3 + 1;
            byte b = bArr[i3];
            byte b2 = bArr[i5];
            int i6 = i5 + 1;
            int i7 = ((b & 255) << 16) | ((b2 & 255) << 8) | (bArr[i6] & 255);
            appendable.append(this.zzb.zza(i7 >>> 18));
            appendable.append(this.zzb.zza((i7 >>> 12) & 63));
            appendable.append(this.zzb.zza((i7 >>> 6) & 63));
            appendable.append(this.zzb.zza(i7 & 63));
            i3 = i6 + 1;
        }
        if (i3 < i2) {
            zze(appendable, bArr, i3, i2 - i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcf(String str, String str2, @CheckForNull Character ch) {
        this(new zzcd(str, str2.toCharArray()), ch);
    }
}
