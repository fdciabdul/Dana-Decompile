package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzdt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzds zzdsVar) throws zzfa {
        int zzj = zzj(bArr, i, zzdsVar);
        int i2 = zzdsVar.zza;
        if (i2 < 0) {
            throw zzfa.zzc();
        }
        if (i2 <= bArr.length - zzj) {
            if (i2 == 0) {
                zzdsVar.zzc = zzee.zzb;
                return zzj;
            }
            zzdsVar.zzc = zzee.zzk(bArr, zzj, i2);
            return zzj + i2;
        }
        throw zzfa.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzgh zzghVar, byte[] bArr, int i, int i2, int i3, zzds zzdsVar) throws IOException {
        zzfz zzfzVar = (zzfz) zzghVar;
        Object zzd = zzfzVar.zzd();
        int zzb = zzfzVar.zzb(zzd, bArr, i, i2, i3, zzdsVar);
        zzfzVar.zze(zzd);
        zzdsVar.zzc = zzd;
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzgh zzghVar, byte[] bArr, int i, int i2, zzds zzdsVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzk(i4, bArr, i3, zzdsVar);
            i4 = zzdsVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzfa.zzf();
        }
        Object zzd = zzghVar.zzd();
        int i6 = i4 + i5;
        zzghVar.zzg(zzd, bArr, i5, i6, zzdsVar);
        zzghVar.zze(zzd);
        zzdsVar.zzc = zzd;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzgh zzghVar, int i, byte[] bArr, int i2, int i3, zzey zzeyVar, zzds zzdsVar) throws IOException {
        int zzd = zzd(zzghVar, bArr, i2, i3, zzdsVar);
        zzeyVar.add(zzdsVar.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzdsVar);
            if (i != zzdsVar.zza) {
                break;
            }
            zzd = zzd(zzghVar, bArr, zzj, i3, zzdsVar);
            zzeyVar.add(zzdsVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzey zzeyVar, zzds zzdsVar) throws IOException {
        zzev zzevVar = (zzev) zzeyVar;
        int zzj = zzj(bArr, i, zzdsVar);
        int i2 = zzdsVar.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzdsVar);
            zzevVar.zze(zzdsVar.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzfa.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzds zzdsVar) throws zzfa {
        int zzj = zzj(bArr, i, zzdsVar);
        int i2 = zzdsVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzdsVar.zzc = "";
                return zzj;
            }
            zzdsVar.zzc = new String(bArr, zzj, i2, zzez.zzb);
            return zzj + i2;
        }
        throw zzfa.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zzds zzdsVar) throws zzfa {
        int zzj = zzj(bArr, i, zzdsVar);
        int i2 = zzdsVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzdsVar.zzc = "";
                return zzj;
            }
            zzdsVar.zzc = zzhm.zzb(bArr, zzj, i2);
            return zzj + i2;
        }
        throw zzfa.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, byte[] bArr, int i2, int i3, zzgz zzgzVar, zzds zzdsVar) throws zzfa {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzdsVar);
                zzgzVar.zzf(i, Long.valueOf(zzdsVar.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzgzVar.zzf(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzdsVar);
                int i5 = zzdsVar.zza;
                if (i5 < 0) {
                    throw zzfa.zzc();
                }
                if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzgzVar.zzf(i, zzee.zzb);
                    } else {
                        zzgzVar.zzf(i, zzee.zzk(bArr, zzj, i5));
                    }
                    return zzj + i5;
                }
                throw zzfa.zzf();
            } else if (i4 != 3) {
                if (i4 == 5) {
                    zzgzVar.zzf(i, Integer.valueOf(zzb(bArr, i2)));
                    return i2 + 4;
                }
                throw zzfa.zza();
            } else {
                int i6 = (i & (-8)) | 4;
                zzgz zzc = zzgz.zzc();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzdsVar);
                    int i8 = zzdsVar.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zzj2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzi(i8, bArr, zzj2, i3, zzc, zzdsVar);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzfa.zzd();
                }
                zzgzVar.zzf(i, zzc);
                return i2;
            }
        }
        throw zzfa.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i, zzds zzdsVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzdsVar.zza = b;
            return i2;
        }
        return zzk(b, bArr, i2, zzdsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, byte[] bArr, int i2, zzds zzdsVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdsVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzdsVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdsVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdsVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        while (true) {
            int i11 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdsVar.zza = i9 | ((b4 & Byte.MAX_VALUE) << 28);
                return i11;
            }
            i10 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i, byte[] bArr, int i2, int i3, zzey zzeyVar, zzds zzdsVar) {
        zzev zzevVar = (zzev) zzeyVar;
        int zzj = zzj(bArr, i2, zzdsVar);
        zzevVar.zze(zzdsVar.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzdsVar);
            if (i != zzdsVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzdsVar);
            zzevVar.zze(zzdsVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i, zzds zzdsVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzdsVar.zzb = j;
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
        zzdsVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
