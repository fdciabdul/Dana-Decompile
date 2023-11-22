package com.google.android.gms.internal.auth;

/* loaded from: classes7.dex */
final class zzhm {
    private static final zzhk zza;

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i = zzdr.zza;
        }
        zza = new zzhl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == 1) {
                byte b2 = bArr[i];
                if (b <= -12 && b2 <= -65) {
                    return b ^ (b2 << 8);
                }
            } else if (i3 == 2) {
                byte b3 = bArr[i];
                byte b4 = bArr[i + 1];
                if (b <= -12 && b3 <= -65 && b4 <= -65) {
                    return ((b3 << 8) ^ b) ^ (b4 << 16);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b <= -12) {
            return b;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(byte[] bArr, int i, int i2) throws zzfa {
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!zzhj.zzd(b)) {
                    break;
                }
                i++;
                cArr[i4] = (char) b;
                i4++;
            }
            while (i < i3) {
                int i5 = i + 1;
                byte b2 = bArr[i];
                if (zzhj.zzd(b2)) {
                    int i6 = i4 + 1;
                    cArr[i4] = (char) b2;
                    i = i5;
                    while (true) {
                        i4 = i6;
                        if (i < i3) {
                            byte b3 = bArr[i];
                            if (!zzhj.zzd(b3)) {
                                break;
                            }
                            i++;
                            i6 = i4 + 1;
                            cArr[i4] = (char) b3;
                        }
                    }
                } else {
                    if (b2 < -32) {
                        if (i5 < i3) {
                            zzhj.zzc(b2, bArr[i5], cArr, i4);
                            i = i5 + 1;
                        } else {
                            throw zzfa.zzb();
                        }
                    } else if (b2 < -16) {
                        if (i5 < i3 - 1) {
                            int i7 = i5 + 1;
                            zzhj.zzb(b2, bArr[i5], bArr[i7], cArr, i4);
                            i = i7 + 1;
                        } else {
                            throw zzfa.zzb();
                        }
                    } else if (i5 < i3 - 2) {
                        int i8 = i5 + 1;
                        int i9 = i8 + 1;
                        zzhj.zza(b2, bArr[i5], bArr[i8], bArr[i9], cArr, i4);
                        i4 += 2;
                        i = i9 + 1;
                    } else {
                        throw zzfa.zzb();
                    }
                    i4++;
                }
            }
            return new String(cArr, 0, i4);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd(byte[] bArr, int i, int i2) {
        return zza.zzb(bArr, i, i2);
    }
}
