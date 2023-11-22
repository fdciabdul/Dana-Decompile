package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes7.dex */
public final class zzmo {
    private static final zzmo zza = new zzmo(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmo() {
        this(0, new int[8], new Object[8], true);
    }

    private zzmo(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzmo zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmo zzd(zzmo zzmoVar, zzmo zzmoVar2) {
        int i = zzmoVar.zzb + zzmoVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzmoVar.zzc, i);
        System.arraycopy(zzmoVar2.zzc, 0, copyOf, zzmoVar.zzb, zzmoVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmoVar.zzd, i);
        System.arraycopy(zzmoVar2.zzd, 0, copyOf2, zzmoVar.zzb, zzmoVar2.zzb);
        return new zzmo(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmo zze() {
        return new zzmo(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzmo)) {
            zzmo zzmoVar = (zzmo) obj;
            int i = this.zzb;
            if (i == zzmoVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzmoVar.zzc;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        Object[] objArr = this.zzd;
                        Object[] objArr2 = zzmoVar.zzd;
                        int i3 = this.zzb;
                        for (int i4 = 0; i4 < i3; i4++) {
                            if (objArr[i4].equals(objArr2[i4])) {
                            }
                        }
                        return true;
                    } else if (iArr[i2] != iArr2[i2]) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int[] iArr = this.zzc;
        int i2 = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        Object[] objArr = this.zzd;
        int i5 = this.zzb;
        for (int i6 = 0; i6 < i5; i6++) {
            i2 = (i2 * 31) + objArr[i6].hashCode();
        }
        return ((((i + 527) * 31) + i3) * 31) + i2;
    }

    public final int zza() {
        int zzA;
        int zzB;
        int i;
        int i2 = this.zze;
        if (i2 == -1) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4];
                int i6 = i5 >>> 3;
                int i7 = i5 & 7;
                if (i7 != 0) {
                    if (i7 == 1) {
                        ((Long) this.zzd[i4]).longValue();
                        i = zzjl.zzA(i6 << 3) + 8;
                    } else if (i7 == 2) {
                        zzjd zzjdVar = (zzjd) this.zzd[i4];
                        int zzA2 = zzjl.zzA(i6 << 3);
                        int zzd = zzjdVar.zzd();
                        i3 += zzA2 + zzjl.zzA(zzd) + zzd;
                    } else if (i7 == 3) {
                        int zzz = zzjl.zzz(i6);
                        zzA = zzz + zzz;
                        zzB = ((zzmo) this.zzd[i4]).zza();
                    } else if (i7 == 5) {
                        ((Integer) this.zzd[i4]).intValue();
                        i = zzjl.zzA(i6 << 3) + 4;
                    } else {
                        throw new IllegalStateException(zzko.zza());
                    }
                    i3 += i;
                } else {
                    long longValue = ((Long) this.zzd[i4]).longValue();
                    zzA = zzjl.zzA(i6 << 3);
                    zzB = zzjl.zzB(longValue);
                }
                i = zzA + zzB;
                i3 += i;
            }
            this.zze = i3;
            return i3;
        }
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int i4 = this.zzc[i3];
                zzjd zzjdVar = (zzjd) this.zzd[i3];
                int zzA = zzjl.zzA(8);
                int zzd = zzjdVar.zzd();
                i2 += zzA + zzA + zzjl.zzA(16) + zzjl.zzA(i4 >>> 3) + zzjl.zzA(24) + zzjl.zzA(zzd) + zzd;
            }
            this.zze = i2;
            return i2;
        }
        return i;
    }

    public final void zzf() {
        this.zzf = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzln.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            int[] iArr = this.zzc;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(iArr, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr2 = this.zzc;
            int i4 = this.zzb;
            iArr2[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zznf zznfVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zznfVar.zzt(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zznfVar.zzm(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zznfVar.zzd(i3, (zzjd) obj);
                } else if (i4 == 3) {
                    zznfVar.zzE(i3);
                    ((zzmo) obj).zzi(zznfVar);
                    zznfVar.zzh(i3);
                } else if (i4 == 5) {
                    zznfVar.zzk(i3, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzko.zza());
                }
            }
        }
    }
}
