package com.google.android.gms.internal.fido;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzce extends zzcg {
    final char[] zza;

    private zzce(zzcd zzcdVar) {
        super(zzcdVar, null);
        char[] cArr;
        this.zza = new char[512];
        cArr = zzcdVar.zzf;
        zzap.zzc(cArr.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzcdVar.zza(i >>> 4);
            this.zza[i | 256] = zzcdVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.fido.zzcg
    final zzch zza(zzcd zzcdVar, @CheckForNull Character ch) {
        return new zzce(zzcdVar);
    }

    @Override // com.google.android.gms.internal.fido.zzcg, com.google.android.gms.internal.fido.zzch
    final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzap.zze(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            appendable.append(this.zza[i4]);
            appendable.append(this.zza[i4 | 256]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzce(String str, String str2) {
        this(new zzcd("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
