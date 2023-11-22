package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzir {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zziq zziqVar) throws zzko {
        int zzj = zzj(bArr, i, zziqVar);
        int i2 = zziqVar.zza;
        if (i2 < 0) {
            throw zzko.zzd();
        }
        if (i2 <= bArr.length - zzj) {
            if (i2 == 0) {
                zziqVar.zzc = zzjd.zzb;
                return zzj;
            }
            zziqVar.zzc = zzjd.zzl(bArr, zzj, i2);
            return zzj + i2;
        }
        throw zzko.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzlw zzlwVar, byte[] bArr, int i, int i2, int i3, zziq zziqVar) throws IOException {
        zzlo zzloVar = (zzlo) zzlwVar;
        Object zze = zzloVar.zze();
        int zzc = zzloVar.zzc(zze, bArr, i, i2, i3, zziqVar);
        zzloVar.zzf(zze);
        zziqVar.zzc = zze;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzlw zzlwVar, byte[] bArr, int i, int i2, zziq zziqVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzk(i4, bArr, i3, zziqVar);
            i4 = zziqVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzko.zzf();
        }
        Object zze = zzlwVar.zze();
        int i6 = i4 + i5;
        zzlwVar.zzh(zze, bArr, i5, i6, zziqVar);
        zzlwVar.zzf(zze);
        zziqVar.zzc = zze;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzlw zzlwVar, int i, byte[] bArr, int i2, int i3, zzkl zzklVar, zziq zziqVar) throws IOException {
        int zzd = zzd(zzlwVar, bArr, i2, i3, zziqVar);
        zzklVar.add(zziqVar.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zziqVar);
            if (i != zziqVar.zza) {
                break;
            }
            zzd = zzd(zzlwVar, bArr, zzj, i3, zziqVar);
            zzklVar.add(zziqVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzkl zzklVar, zziq zziqVar) throws IOException {
        zzkf zzkfVar = (zzkf) zzklVar;
        int zzj = zzj(bArr, i, zziqVar);
        int i2 = zziqVar.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zziqVar);
            zzkfVar.zzh(zziqVar.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzko.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zziq zziqVar) throws zzko {
        int zzj = zzj(bArr, i, zziqVar);
        int i2 = zziqVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zziqVar.zzc = "";
                return zzj;
            }
            zziqVar.zzc = new String(bArr, zzj, i2, zzkm.zzb);
            return zzj + i2;
        }
        throw zzko.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zziq zziqVar) throws zzko {
        int zzj = zzj(bArr, i, zziqVar);
        int i2 = zziqVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zziqVar.zzc = "";
                return zzj;
            }
            zziqVar.zzc = zznc.zzd(bArr, zzj, i2);
            return zzj + i2;
        }
        throw zzko.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, byte[] bArr, int i2, int i3, zzmo zzmoVar, zziq zziqVar) throws zzko {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zziqVar);
                zzmoVar.zzh(i, Long.valueOf(zziqVar.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzmoVar.zzh(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zziqVar);
                int i5 = zziqVar.zza;
                if (i5 < 0) {
                    throw zzko.zzd();
                }
                if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzmoVar.zzh(i, zzjd.zzb);
                    } else {
                        zzmoVar.zzh(i, zzjd.zzl(bArr, zzj, i5));
                    }
                    return zzj + i5;
                }
                throw zzko.zzf();
            } else if (i4 != 3) {
                if (i4 == 5) {
                    zzmoVar.zzh(i, Integer.valueOf(zzb(bArr, i2)));
                    return i2 + 4;
                }
                throw zzko.zzb();
            } else {
                int i6 = (i & (-8)) | 4;
                zzmo zze = zzmo.zze();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zziqVar);
                    int i8 = zziqVar.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zzj2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzi(i8, bArr, zzj2, i3, zze, zziqVar);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzko.zze();
                }
                zzmoVar.zzh(i, zze);
                return i2;
            }
        }
        throw zzko.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i, zziq zziqVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zziqVar.zza = b;
            return i2;
        }
        return zzk(b, bArr, i2, zziqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, byte[] bArr, int i2, zziq zziqVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zziqVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zziqVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zziqVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zziqVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        while (true) {
            int i11 = i10 + 1;
            if (bArr[i10] >= 0) {
                zziqVar.zza = i9 | ((b4 & Byte.MAX_VALUE) << 28);
                return i11;
            }
            i10 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i, byte[] bArr, int i2, int i3, zzkl zzklVar, zziq zziqVar) {
        zzkf zzkfVar = (zzkf) zzklVar;
        int zzj = zzj(bArr, i2, zziqVar);
        zzkfVar.zzh(zziqVar.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zziqVar);
            if (i != zziqVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zziqVar);
            zzkfVar.zzh(zziqVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i, zziq zziqVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zziqVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            b = bArr[i3];
            i4 += 7;
            j2 |= (b & Byte.MAX_VALUE) << i4;
            i3++;
        }
        zziqVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
