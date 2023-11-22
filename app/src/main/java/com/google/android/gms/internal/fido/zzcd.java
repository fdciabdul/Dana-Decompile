package com.google.android.gms.internal.fido;

import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzcd {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzcd(java.lang.String r10, char[] r11) {
        /*
            r9 = this;
            r0 = 128(0x80, float:1.794E-43)
            byte[] r1 = new byte[r0]
            r2 = -1
            java.util.Arrays.fill(r1, r2)
            r3 = 0
            r4 = 0
        La:
            int r5 = r11.length
            if (r4 >= r5) goto L2b
            char r5 = r11[r4]
            r6 = 1
            if (r5 >= r0) goto L14
            r7 = 1
            goto L15
        L14:
            r7 = 0
        L15:
            java.lang.String r8 = "Non-ASCII character: %s"
            com.google.android.gms.internal.fido.zzap.zzd(r7, r8, r5)
            r7 = r1[r5]
            if (r7 != r2) goto L1f
            goto L20
        L1f:
            r6 = 0
        L20:
            java.lang.String r7 = "Duplicate character: %s"
            com.google.android.gms.internal.fido.zzap.zzd(r6, r7, r5)
            byte r6 = (byte) r4
            r1[r5] = r6
            int r4 = r4 + 1
            goto La
        L2b:
            r9.<init>(r10, r11, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzcd.<init>(java.lang.String, char[]):void");
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzcd) {
            zzcd zzcdVar = (zzcd) obj;
            return this.zzh == zzcdVar.zzh && Arrays.equals(this.zzf, zzcdVar.zzf);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + (true != this.zzh ? 1237 : 1231);
    }

    public final String toString() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char zza(int i) {
        return this.zzf[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    public final zzcd zzb() {
        int i;
        boolean z;
        for (char c : this.zzf) {
            if (zzad.zza(c)) {
                char[] cArr = this.zzf;
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char c2 = cArr[i2];
                    if (c2 >= 'A' && c2 <= 'Z') {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if ((!z) != false) {
                    char[] cArr2 = new char[this.zzf.length];
                    int i3 = 0;
                    while (true) {
                        char[] cArr3 = this.zzf;
                        if (i3 >= cArr3.length) {
                            break;
                        }
                        char c3 = cArr3[i3];
                        if (zzad.zza(c3)) {
                            c3 ^= 32;
                        }
                        cArr2[i3] = (char) c3;
                        i3++;
                    }
                    zzcd zzcdVar = new zzcd(this.zze.concat(".upperCase()"), cArr2);
                    if (!this.zzh || zzcdVar.zzh) {
                        return zzcdVar;
                    }
                    byte[] bArr = zzcdVar.zzg;
                    byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                    for (i = 65; i <= 90; i++) {
                        int i4 = i | 32;
                        byte[] bArr2 = zzcdVar.zzg;
                        byte b = bArr2[i];
                        byte b2 = bArr2[i4];
                        if (b == -1) {
                            copyOf[i] = b2;
                        } else {
                            char c4 = (char) i;
                            char c5 = (char) i4;
                            if (b2 != -1) {
                                throw new IllegalStateException(zzaq.zza("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c4), Character.valueOf(c5)));
                            }
                            copyOf[i4] = b;
                        }
                    }
                    return new zzcd(zzcdVar.zze.concat(".ignoreCase()"), zzcdVar.zzf, copyOf, true);
                }
                throw new IllegalStateException("Cannot call upperCase() on a mixed-case alphabet");
            }
        }
        return this;
    }

    public final boolean zzc(char c) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    private zzcd(String str, char[] cArr, byte[] bArr, boolean z) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int zzb = zzcj.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = zzb;
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(zzb);
            int i = 1 << (3 - numberOfTrailingZeros);
            this.zzc = i;
            this.zzd = zzb >> numberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i];
            for (int i2 = 0; i2 < this.zzd; i2++) {
                zArr[zzcj.zza(i2 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = z;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
        }
    }
}
