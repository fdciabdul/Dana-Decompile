package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class zzcg extends zzch {
    @CheckForNull
    private volatile zzch zza;
    final zzcd zzb;
    @CheckForNull
    final Character zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzcg(com.google.android.gms.internal.fido.zzcd r4, @javax.annotation.CheckForNull java.lang.Character r5) {
        /*
            r3 = this;
            r3.<init>()
            r3.zzb = r4
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L17
            r5.charValue()
            r2 = 61
            boolean r4 = r4.zzc(r2)
            if (r4 != 0) goto L15
            goto L17
        L15:
            r4 = 0
            goto L18
        L17:
            r4 = 1
        L18:
            if (r4 == 0) goto L1d
            r3.zzc = r5
            return
        L1d:
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r0] = r5
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Padding character %s was already in alphabet"
            java.lang.String r4 = com.google.android.gms.internal.fido.zzaq.zza(r0, r4)
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzcg.<init>(com.google.android.gms.internal.fido.zzcd, java.lang.Character):void");
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzcg) {
            zzcg zzcgVar = (zzcg) obj;
            if (this.zzb.equals(zzcgVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzcgVar.zzc;
                if (ch != ch2) {
                    return ch != null && ch.equals(ch2);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode();
        Character ch = this.zzc;
        return hashCode ^ (ch == null ? 0 : ch.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    zzch zza(zzcd zzcdVar, @CheckForNull Character ch) {
        return new zzcg(zzcdVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzch
    void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzap.zze(0, i2, bArr.length);
        while (i3 < i2) {
            zze(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzch
    final int zzc(int i) {
        zzcd zzcdVar = this.zzb;
        return zzcdVar.zzc * zzcj.zza(i, zzcdVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.fido.zzch
    public final zzch zzd() {
        zzch zzchVar = this.zza;
        if (zzchVar == null) {
            zzcd zzb = this.zzb.zzb();
            zzchVar = zzb == this.zzb ? this : zza(zzb, this.zzc);
            this.zza = zzchVar;
        }
        return zzchVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzap.zze(i, i + i2, bArr.length);
        int i3 = 0;
        zzap.zzc(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | (bArr[i + i4] & 255)) << 8;
        }
        int i5 = this.zzb.zzb;
        while (i3 < i2 * 8) {
            zzcd zzcdVar = this.zzb;
            appendable.append(zzcdVar.zza(zzcdVar.zza & ((int) (j >>> ((((i2 + 1) * 8) - i5) - i3)))));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcg(String str, String str2, @CheckForNull Character ch) {
        this(new zzcd(str, str2.toCharArray()), ch);
    }
}
