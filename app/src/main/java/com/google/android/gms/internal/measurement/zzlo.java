package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* loaded from: classes7.dex */
public final class zzlo<T> implements zzlw<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmx.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzll zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkz zzm;
    private final zzmn zzn;
    private final zzjr zzo;
    private final zzlq zzp;
    private final zzlg zzq;

    private zzlo(int[] iArr, Object[] objArr, int i, int i2, zzll zzllVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzlq zzlqVar, zzkz zzkzVar, zzmn zzmnVar, zzjr zzjrVar, zzlg zzlgVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        this.zzh = zzjrVar != null && zzjrVar.zzc(zzllVar);
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzlqVar;
        this.zzm = zzkzVar;
        this.zzn = zzmnVar;
        this.zzo = zzjrVar;
        this.zzg = zzllVar;
        this.zzq = zzlgVar;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzmx.zzf(obj, j)).longValue();
    }

    private final zzki zzD(int i) {
        int i2 = i / 3;
        return (zzki) this.zzd[i2 + i2 + 1];
    }

    private final zzlw zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzlw zzlwVar = (zzlw) this.zzd[i3];
        if (zzlwVar != null) {
            return zzlwVar;
        }
        zzlw zzb2 = zzlt.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        long zzB = zzB(i) & 1048575;
        if (zzO(obj2, i)) {
            Object zzf = zzmx.zzf(obj, zzB);
            Object zzf2 = zzmx.zzf(obj2, zzB);
            if (zzf != null && zzf2 != null) {
                zzmx.zzs(obj, zzB, zzkm.zzg(zzf, zzf2));
                zzJ(obj, i);
            } else if (zzf2 != null) {
                zzmx.zzs(obj, zzB, zzf2);
                zzJ(obj, i);
            }
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int zzB = zzB(i);
        int i2 = this.zzc[i];
        long j = zzB & 1048575;
        if (zzR(obj2, i2, i)) {
            Object zzf = zzR(obj, i2, i) ? zzmx.zzf(obj, j) : null;
            Object zzf2 = zzmx.zzf(obj2, j);
            if (zzf != null && zzf2 != null) {
                zzmx.zzs(obj, j, zzkm.zzg(zzf, zzf2));
                zzK(obj, i2, i);
            } else if (zzf2 != null) {
                zzmx.zzs(obj, j, zzf2);
                zzK(obj, i2, i);
            }
        }
    }

    private final void zzJ(Object obj, int i) {
        int zzy = zzy(i);
        long j = 1048575 & zzy;
        if (j == 1048575) {
            return;
        }
        zzmx.zzq(obj, j, (1 << (zzy >>> 20)) | zzmx.zzc(obj, j));
    }

    private final void zzK(Object obj, int i, int i2) {
        zzmx.zzq(obj, zzy(i2) & 1048575, i);
    }

    private final void zzL(Object obj, zznf zznfVar) throws IOException {
        int i;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < length) {
            int zzB = zzB(i3);
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int zzA = zzA(zzB);
            if (zzA <= 17) {
                int i7 = iArr[i3 + 2];
                int i8 = i7 & i2;
                if (i8 != i5) {
                    i4 = unsafe.getInt(obj, i8);
                    i5 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = zzB & i2;
            switch (zzA) {
                case 0:
                    if ((i4 & i) != 0) {
                        zznfVar.zzf(i6, zzmx.zza(obj, j));
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 1:
                    if ((i4 & i) != 0) {
                        zznfVar.zzo(i6, zzmx.zzb(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 2:
                    if ((i4 & i) != 0) {
                        zznfVar.zzt(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 3:
                    if ((i4 & i) != 0) {
                        zznfVar.zzJ(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 4:
                    if ((i4 & i) != 0) {
                        zznfVar.zzr(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 5:
                    if ((i4 & i) != 0) {
                        zznfVar.zzm(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 6:
                    if ((i4 & i) != 0) {
                        zznfVar.zzk(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 7:
                    if ((i4 & i) != 0) {
                        zznfVar.zzb(i6, zzmx.zzw(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 8:
                    if ((i4 & i) != 0) {
                        zzT(i6, unsafe.getObject(obj, j), zznfVar);
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 9:
                    if ((i4 & i) != 0) {
                        zznfVar.zzv(i6, unsafe.getObject(obj, j), zzE(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 10:
                    if ((i4 & i) != 0) {
                        zznfVar.zzd(i6, (zzjd) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 11:
                    if ((i4 & i) != 0) {
                        zznfVar.zzH(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 12:
                    if ((i4 & i) != 0) {
                        zznfVar.zzi(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 13:
                    if ((i4 & i) != 0) {
                        zznfVar.zzw(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 14:
                    if ((i4 & i) != 0) {
                        zznfVar.zzy(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 15:
                    if ((i4 & i) != 0) {
                        zznfVar.zzA(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 16:
                    if ((i4 & i) != 0) {
                        zznfVar.zzC(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 17:
                    if ((i4 & i) != 0) {
                        zznfVar.zzq(i6, unsafe.getObject(obj, j), zzE(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 18:
                    zzly.zzJ(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 19:
                    zzly.zzN(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 20:
                    zzly.zzQ(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 21:
                    zzly.zzY(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 22:
                    zzly.zzP(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 23:
                    zzly.zzM(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 24:
                    zzly.zzL(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 25:
                    zzly.zzH(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 26:
                    zzly.zzW(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar);
                    break;
                case 27:
                    zzly.zzR(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, zzE(i3));
                    break;
                case 28:
                    zzly.zzI(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar);
                    break;
                case 29:
                    zzly.zzX(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 30:
                    zzly.zzK(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 31:
                    zzly.zzS(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 32:
                    zzly.zzT(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 33:
                    zzly.zzU(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 34:
                    zzly.zzV(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 35:
                    zzly.zzJ(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 36:
                    zzly.zzN(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 37:
                    zzly.zzQ(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 38:
                    zzly.zzY(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 39:
                    zzly.zzP(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 40:
                    zzly.zzM(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 41:
                    zzly.zzL(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 42:
                    zzly.zzH(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 43:
                    zzly.zzX(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 44:
                    zzly.zzK(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 45:
                    zzly.zzS(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 46:
                    zzly.zzT(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 47:
                    zzly.zzU(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 48:
                    zzly.zzV(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 49:
                    zzly.zzO(this.zzc[i3], (List) unsafe.getObject(obj, j), zznfVar, zzE(i3));
                    break;
                case 50:
                    zzM(zznfVar, i6, unsafe.getObject(obj, j), i3);
                    break;
                case 51:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzf(i6, zzn(obj, j));
                        break;
                    }
                    break;
                case 52:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzo(i6, zzo(obj, j));
                        break;
                    }
                    break;
                case 53:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzt(i6, zzC(obj, j));
                        break;
                    }
                    break;
                case 54:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzJ(i6, zzC(obj, j));
                        break;
                    }
                    break;
                case 55:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzr(i6, zzr(obj, j));
                        break;
                    }
                    break;
                case 56:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzm(i6, zzC(obj, j));
                        break;
                    }
                    break;
                case 57:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzk(i6, zzr(obj, j));
                        break;
                    }
                    break;
                case 58:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzb(i6, zzS(obj, j));
                        break;
                    }
                    break;
                case 59:
                    if (zzR(obj, i6, i3)) {
                        zzT(i6, unsafe.getObject(obj, j), zznfVar);
                        break;
                    }
                    break;
                case 60:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzv(i6, unsafe.getObject(obj, j), zzE(i3));
                        break;
                    }
                    break;
                case 61:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzd(i6, (zzjd) unsafe.getObject(obj, j));
                        break;
                    }
                    break;
                case 62:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzH(i6, zzr(obj, j));
                        break;
                    }
                    break;
                case 63:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzi(i6, zzr(obj, j));
                        break;
                    }
                    break;
                case 64:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzw(i6, zzr(obj, j));
                        break;
                    }
                    break;
                case 65:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzy(i6, zzC(obj, j));
                        break;
                    }
                    break;
                case 66:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzA(i6, zzr(obj, j));
                        break;
                    }
                    break;
                case 67:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzC(i6, zzC(obj, j));
                        break;
                    }
                    break;
                case 68:
                    if (zzR(obj, i6, i3)) {
                        zznfVar.zzq(i6, unsafe.getObject(obj, j), zzE(i3));
                        break;
                    }
                    break;
            }
            i3 += 3;
            i2 = 1048575;
        }
        zzmn zzmnVar = this.zzn;
        zzmnVar.zzi(zzmnVar.zzc(obj), zznfVar);
    }

    private final void zzM(zznf zznfVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        zzle zzleVar = (zzle) zzF(i2);
        throw null;
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        return zzO(obj, i) == zzO(obj2, i);
    }

    private final boolean zzO(Object obj, int i) {
        int zzy = zzy(i);
        long j = zzy & 1048575;
        if (j != 1048575) {
            return (zzmx.zzc(obj, j) & (1 << (zzy >>> 20))) != 0;
        }
        int zzB = zzB(i);
        long j2 = zzB & 1048575;
        switch (zzA(zzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzmx.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmx.zzb(obj, j2)) != 0;
            case 2:
                return zzmx.zzd(obj, j2) != 0;
            case 3:
                return zzmx.zzd(obj, j2) != 0;
            case 4:
                return zzmx.zzc(obj, j2) != 0;
            case 5:
                return zzmx.zzd(obj, j2) != 0;
            case 6:
                return zzmx.zzc(obj, j2) != 0;
            case 7:
                return zzmx.zzw(obj, j2);
            case 8:
                Object zzf = zzmx.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                } else if (zzf instanceof zzjd) {
                    return !zzjd.zzb.equals(zzf);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzmx.zzf(obj, j2) != null;
            case 10:
                return !zzjd.zzb.equals(zzmx.zzf(obj, j2));
            case 11:
                return zzmx.zzc(obj, j2) != 0;
            case 12:
                return zzmx.zzc(obj, j2) != 0;
            case 13:
                return zzmx.zzc(obj, j2) != 0;
            case 14:
                return zzmx.zzd(obj, j2) != 0;
            case 15:
                return zzmx.zzc(obj, j2) != 0;
            case 16:
                return zzmx.zzd(obj, j2) != 0;
            case 17:
                return zzmx.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzP(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzQ(Object obj, int i, zzlw zzlwVar) {
        return zzlwVar.zzk(zzmx.zzf(obj, i & 1048575));
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzmx.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzmx.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zznf zznfVar) throws IOException {
        if (obj instanceof String) {
            zznfVar.zzF(i, (String) obj);
        } else {
            zznfVar.zzd(i, (zzjd) obj);
        }
    }

    static zzmo zzd(Object obj) {
        zzke zzkeVar = (zzke) obj;
        zzmo zzmoVar = zzkeVar.zzc;
        if (zzmoVar == zzmo.zzc()) {
            zzmo zze = zzmo.zze();
            zzkeVar.zzc = zze;
            return zze;
        }
        return zzmoVar;
    }

    public static zzlo zzl(Class cls, zzli zzliVar, zzlq zzlqVar, zzkz zzkzVar, zzmn zzmnVar, zzjr zzjrVar, zzlg zzlgVar) {
        if (zzliVar instanceof zzlv) {
            return zzm((zzlv) zzliVar, zzlqVar, zzkzVar, zzmnVar, zzjrVar, zzlgVar);
        }
        zzmk zzmkVar = (zzmk) zzliVar;
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:333:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.measurement.zzlo zzm(com.google.android.gms.internal.measurement.zzlv r35, com.google.android.gms.internal.measurement.zzlq r36, com.google.android.gms.internal.measurement.zzkz r37, com.google.android.gms.internal.measurement.zzmn r38, com.google.android.gms.internal.measurement.zzjr r39, com.google.android.gms.internal.measurement.zzlg r40) {
        /*
            Method dump skipped, instructions count: 992
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzm(com.google.android.gms.internal.measurement.zzlv, com.google.android.gms.internal.measurement.zzlq, com.google.android.gms.internal.measurement.zzkz, com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzjr, com.google.android.gms.internal.measurement.zzlg):com.google.android.gms.internal.measurement.zzlo");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzmx.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzmx.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i;
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int i2;
        int zzu;
        int zzi;
        int zzz;
        int zzA8;
        int i3;
        int zzA9;
        int zzA10;
        int zzA11;
        int zzB2;
        int zzA12;
        int zzd2;
        int zzA13;
        int i4;
        Unsafe unsafe = zzb;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1048575;
        int i9 = 0;
        while (i6 < this.zzc.length) {
            int zzB3 = zzB(i6);
            int[] iArr = this.zzc;
            int i10 = iArr[i6];
            int zzA14 = zzA(zzB3);
            if (zzA14 <= 17) {
                int i11 = iArr[i6 + 2];
                int i12 = i11 & i5;
                i = 1 << (i11 >>> 20);
                if (i12 != i8) {
                    i9 = unsafe.getInt(obj, i12);
                    i8 = i12;
                }
            } else {
                i = 0;
            }
            long j = zzB3 & i5;
            switch (zzA14) {
                case 0:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA = zzjl.zzA(i10 << 3);
                        zzA5 = zzA + 8;
                        i7 += zzA5;
                        break;
                    }
                case 1:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA2 = zzjl.zzA(i10 << 3);
                        zzA5 = zzA2 + 4;
                        i7 += zzA5;
                        break;
                    }
                case 2:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        long j2 = unsafe.getLong(obj, j);
                        zzA3 = zzjl.zzA(i10 << 3);
                        zzB = zzjl.zzB(j2);
                        i7 += zzA3 + zzB;
                        break;
                    }
                case 3:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        long j3 = unsafe.getLong(obj, j);
                        zzA3 = zzjl.zzA(i10 << 3);
                        zzB = zzjl.zzB(j3);
                        i7 += zzA3 + zzB;
                        break;
                    }
                case 4:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        int i13 = unsafe.getInt(obj, j);
                        zzA4 = zzjl.zzA(i10 << 3);
                        zzv = zzjl.zzv(i13);
                        i2 = zzA4 + zzv;
                        i7 += i2;
                        break;
                    }
                case 5:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA = zzjl.zzA(i10 << 3);
                        zzA5 = zzA + 8;
                        i7 += zzA5;
                        break;
                    }
                case 6:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA2 = zzjl.zzA(i10 << 3);
                        zzA5 = zzA2 + 4;
                        i7 += zzA5;
                        break;
                    }
                case 7:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA5 = zzjl.zzA(i10 << 3) + 1;
                        i7 += zzA5;
                        break;
                    }
                case 8:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzjd) {
                            zzA6 = zzjl.zzA(i10 << 3);
                            zzd = ((zzjd) object).zzd();
                            zzA7 = zzjl.zzA(zzd);
                            i2 = zzA6 + zzA7 + zzd;
                            i7 += i2;
                            break;
                        } else {
                            zzA4 = zzjl.zzA(i10 << 3);
                            zzv = zzjl.zzy((String) object);
                            i2 = zzA4 + zzv;
                            i7 += i2;
                        }
                    }
                case 9:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA5 = zzly.zzo(i10, unsafe.getObject(obj, j), zzE(i6));
                        i7 += zzA5;
                        break;
                    }
                case 10:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzjd zzjdVar = (zzjd) unsafe.getObject(obj, j);
                        zzA6 = zzjl.zzA(i10 << 3);
                        zzd = zzjdVar.zzd();
                        zzA7 = zzjl.zzA(zzd);
                        i2 = zzA6 + zzA7 + zzd;
                        i7 += i2;
                        break;
                    }
                case 11:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        int i14 = unsafe.getInt(obj, j);
                        zzA4 = zzjl.zzA(i10 << 3);
                        zzv = zzjl.zzA(i14);
                        i2 = zzA4 + zzv;
                        i7 += i2;
                        break;
                    }
                case 12:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        int i15 = unsafe.getInt(obj, j);
                        zzA4 = zzjl.zzA(i10 << 3);
                        zzv = zzjl.zzv(i15);
                        i2 = zzA4 + zzv;
                        i7 += i2;
                        break;
                    }
                case 13:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA2 = zzjl.zzA(i10 << 3);
                        zzA5 = zzA2 + 4;
                        i7 += zzA5;
                        break;
                    }
                case 14:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA = zzjl.zzA(i10 << 3);
                        zzA5 = zzA + 8;
                        i7 += zzA5;
                        break;
                    }
                case 15:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        int i16 = unsafe.getInt(obj, j);
                        zzA4 = zzjl.zzA(i10 << 3);
                        zzv = zzjl.zzA((i16 + i16) ^ (i16 >> 31));
                        i2 = zzA4 + zzv;
                        i7 += i2;
                        break;
                    }
                case 16:
                    if ((i & i9) == 0) {
                        break;
                    } else {
                        long j4 = unsafe.getLong(obj, j);
                        i7 += zzjl.zzA(i10 << 3) + zzjl.zzB((j4 + j4) ^ (j4 >> 63));
                        break;
                    }
                case 17:
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        zzA5 = zzjl.zzu(i10, (zzll) unsafe.getObject(obj, j), zzE(i6));
                        i7 += zzA5;
                        break;
                    }
                case 18:
                    zzA5 = zzly.zzh(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzA5;
                    break;
                case 19:
                    zzA5 = zzly.zzf(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzA5;
                    break;
                case 20:
                    zzA5 = zzly.zzm(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzA5;
                    break;
                case 21:
                    zzA5 = zzly.zzx(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzA5;
                    break;
                case 22:
                    zzA5 = zzly.zzk(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzA5;
                    break;
                case 23:
                    zzA5 = zzly.zzh(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzA5;
                    break;
                case 24:
                    zzA5 = zzly.zzf(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzA5;
                    break;
                case 25:
                    zzA5 = zzly.zza(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzA5;
                    break;
                case 26:
                    zzu = zzly.zzu(i10, (List) unsafe.getObject(obj, j));
                    i7 += zzu;
                    break;
                case 27:
                    zzu = zzly.zzp(i10, (List) unsafe.getObject(obj, j), zzE(i6));
                    i7 += zzu;
                    break;
                case 28:
                    zzu = zzly.zzc(i10, (List) unsafe.getObject(obj, j));
                    i7 += zzu;
                    break;
                case 29:
                    zzu = zzly.zzv(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzu;
                    break;
                case 30:
                    zzu = zzly.zzd(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzu;
                    break;
                case 31:
                    zzu = zzly.zzf(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzu;
                    break;
                case 32:
                    zzu = zzly.zzh(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzu;
                    break;
                case 33:
                    zzu = zzly.zzq(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzu;
                    break;
                case 34:
                    zzu = zzly.zzs(i10, (List) unsafe.getObject(obj, j), false);
                    i7 += zzu;
                    break;
                case 35:
                    zzi = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 36:
                    zzi = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 37:
                    zzi = zzly.zzn((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 38:
                    zzi = zzly.zzy((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 39:
                    zzi = zzly.zzl((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 40:
                    zzi = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 41:
                    zzi = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 42:
                    zzi = zzly.zzb((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 43:
                    zzi = zzly.zzw((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 44:
                    zzi = zzly.zze((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 45:
                    zzi = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 46:
                    zzi = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 47:
                    zzi = zzly.zzr((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 48:
                    zzi = zzly.zzt((List) unsafe.getObject(obj, j));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i10);
                        zzA8 = zzjl.zzA(zzi);
                        i3 = zzz + zzA8;
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 49:
                    zzu = zzly.zzj(i10, (List) unsafe.getObject(obj, j), zzE(i6));
                    i7 += zzu;
                    break;
                case 50:
                    zzlg.zza(i10, unsafe.getObject(obj, j), zzF(i6));
                    break;
                case 51:
                    if (zzR(obj, i10, i6)) {
                        zzA9 = zzjl.zzA(i10 << 3);
                        zzu = zzA9 + 8;
                        i7 += zzu;
                    }
                    break;
                case 52:
                    if (zzR(obj, i10, i6)) {
                        zzA10 = zzjl.zzA(i10 << 3);
                        zzu = zzA10 + 4;
                        i7 += zzu;
                    }
                    break;
                case 53:
                    if (zzR(obj, i10, i6)) {
                        long zzC = zzC(obj, j);
                        zzA11 = zzjl.zzA(i10 << 3);
                        zzB2 = zzjl.zzB(zzC);
                        i7 += zzA11 + zzB2;
                    }
                    break;
                case 54:
                    if (zzR(obj, i10, i6)) {
                        long zzC2 = zzC(obj, j);
                        zzA11 = zzjl.zzA(i10 << 3);
                        zzB2 = zzjl.zzB(zzC2);
                        i7 += zzA11 + zzB2;
                    }
                    break;
                case 55:
                    if (zzR(obj, i10, i6)) {
                        int zzr = zzr(obj, j);
                        i3 = zzjl.zzA(i10 << 3);
                        zzi = zzjl.zzv(zzr);
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 56:
                    if (zzR(obj, i10, i6)) {
                        zzA9 = zzjl.zzA(i10 << 3);
                        zzu = zzA9 + 8;
                        i7 += zzu;
                    }
                    break;
                case 57:
                    if (zzR(obj, i10, i6)) {
                        zzA10 = zzjl.zzA(i10 << 3);
                        zzu = zzA10 + 4;
                        i7 += zzu;
                    }
                    break;
                case 58:
                    if (zzR(obj, i10, i6)) {
                        zzu = zzjl.zzA(i10 << 3) + 1;
                        i7 += zzu;
                    }
                    break;
                case 59:
                    if (zzR(obj, i10, i6)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzjd) {
                            zzA12 = zzjl.zzA(i10 << 3);
                            zzd2 = ((zzjd) object2).zzd();
                            zzA13 = zzjl.zzA(zzd2);
                            i4 = zzA12 + zzA13 + zzd2;
                            i7 += i4;
                        } else {
                            i3 = zzjl.zzA(i10 << 3);
                            zzi = zzjl.zzy((String) object2);
                            i4 = i3 + zzi;
                            i7 += i4;
                        }
                    }
                    break;
                case 60:
                    if (zzR(obj, i10, i6)) {
                        zzu = zzly.zzo(i10, unsafe.getObject(obj, j), zzE(i6));
                        i7 += zzu;
                    }
                    break;
                case 61:
                    if (zzR(obj, i10, i6)) {
                        zzjd zzjdVar2 = (zzjd) unsafe.getObject(obj, j);
                        zzA12 = zzjl.zzA(i10 << 3);
                        zzd2 = zzjdVar2.zzd();
                        zzA13 = zzjl.zzA(zzd2);
                        i4 = zzA12 + zzA13 + zzd2;
                        i7 += i4;
                    }
                    break;
                case 62:
                    if (zzR(obj, i10, i6)) {
                        int zzr2 = zzr(obj, j);
                        i3 = zzjl.zzA(i10 << 3);
                        zzi = zzjl.zzA(zzr2);
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 63:
                    if (zzR(obj, i10, i6)) {
                        int zzr3 = zzr(obj, j);
                        i3 = zzjl.zzA(i10 << 3);
                        zzi = zzjl.zzv(zzr3);
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 64:
                    if (zzR(obj, i10, i6)) {
                        zzA10 = zzjl.zzA(i10 << 3);
                        zzu = zzA10 + 4;
                        i7 += zzu;
                    }
                    break;
                case 65:
                    if (zzR(obj, i10, i6)) {
                        zzA9 = zzjl.zzA(i10 << 3);
                        zzu = zzA9 + 8;
                        i7 += zzu;
                    }
                    break;
                case 66:
                    if (zzR(obj, i10, i6)) {
                        int zzr4 = zzr(obj, j);
                        i3 = zzjl.zzA(i10 << 3);
                        zzi = zzjl.zzA((zzr4 + zzr4) ^ (zzr4 >> 31));
                        i4 = i3 + zzi;
                        i7 += i4;
                    }
                    break;
                case 67:
                    if (zzR(obj, i10, i6)) {
                        long zzC3 = zzC(obj, j);
                        i7 += zzjl.zzA(i10 << 3) + zzjl.zzB((zzC3 + zzC3) ^ (zzC3 >> 63));
                    }
                    break;
                case 68:
                    if (zzR(obj, i10, i6)) {
                        zzu = zzjl.zzu(i10, (zzll) unsafe.getObject(obj, j), zzE(i6));
                        i7 += zzu;
                    }
                    break;
            }
            i6 += 3;
            i5 = 1048575;
        }
        zzmn zzmnVar = this.zzn;
        int zza2 = zzmnVar.zza(zzmnVar.zzc(obj));
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        return i7 + zza2;
    }

    private final int zzq(Object obj) {
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int zzo;
        int zzz;
        int zzA8;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int zzB2 = zzB(i3);
            int zzA9 = zzA(zzB2);
            int i4 = this.zzc[i3];
            long j = zzB2 & 1048575;
            if (zzA9 >= zzjw.DOUBLE_LIST_PACKED.zza() && zzA9 <= zzjw.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (zzA9) {
                case 0:
                    if (zzO(obj, i3)) {
                        zzA = zzjl.zzA(i4 << 3);
                        zzo = zzA + 8;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj, i3)) {
                        zzA2 = zzjl.zzA(i4 << 3);
                        zzo = zzA2 + 4;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj, i3)) {
                        long zzd2 = zzmx.zzd(obj, j);
                        zzA3 = zzjl.zzA(i4 << 3);
                        zzB = zzjl.zzB(zzd2);
                        i2 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj, i3)) {
                        long zzd3 = zzmx.zzd(obj, j);
                        zzA3 = zzjl.zzA(i4 << 3);
                        zzB = zzjl.zzB(zzd3);
                        i2 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj, i3)) {
                        int zzc = zzmx.zzc(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzv(zzc);
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj, i3)) {
                        zzA = zzjl.zzA(i4 << 3);
                        zzo = zzA + 8;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj, i3)) {
                        zzA2 = zzjl.zzA(i4 << 3);
                        zzo = zzA2 + 4;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj, i3)) {
                        zzA5 = zzjl.zzA(i4 << 3);
                        zzo = zzA5 + 1;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzO(obj, i3)) {
                        break;
                    } else {
                        Object zzf = zzmx.zzf(obj, j);
                        if (zzf instanceof zzjd) {
                            zzA6 = zzjl.zzA(i4 << 3);
                            zzd = ((zzjd) zzf).zzd();
                            zzA7 = zzjl.zzA(zzd);
                            i = zzA6 + zzA7 + zzd;
                            i2 += i;
                            break;
                        } else {
                            zzA4 = zzjl.zzA(i4 << 3);
                            zzv = zzjl.zzy((String) zzf);
                            i = zzA4 + zzv;
                            i2 += i;
                        }
                    }
                case 9:
                    if (zzO(obj, i3)) {
                        zzo = zzly.zzo(i4, zzmx.zzf(obj, j), zzE(i3));
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzO(obj, i3)) {
                        zzjd zzjdVar = (zzjd) zzmx.zzf(obj, j);
                        zzA6 = zzjl.zzA(i4 << 3);
                        zzd = zzjdVar.zzd();
                        zzA7 = zzjl.zzA(zzd);
                        i = zzA6 + zzA7 + zzd;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj, i3)) {
                        int zzc2 = zzmx.zzc(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzA(zzc2);
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj, i3)) {
                        int zzc3 = zzmx.zzc(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzv(zzc3);
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj, i3)) {
                        zzA2 = zzjl.zzA(i4 << 3);
                        zzo = zzA2 + 4;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj, i3)) {
                        zzA = zzjl.zzA(i4 << 3);
                        zzo = zzA + 8;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj, i3)) {
                        int zzc4 = zzmx.zzc(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzA((zzc4 + zzc4) ^ (zzc4 >> 31));
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj, i3)) {
                        long zzd4 = zzmx.zzd(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzB((zzd4 + zzd4) ^ (zzd4 >> 63));
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzO(obj, i3)) {
                        zzo = zzjl.zzu(i4, (zzll) zzmx.zzf(obj, j), zzE(i3));
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzo = zzly.zzh(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 19:
                    zzo = zzly.zzf(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 20:
                    zzo = zzly.zzm(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 21:
                    zzo = zzly.zzx(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 22:
                    zzo = zzly.zzk(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 23:
                    zzo = zzly.zzh(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 24:
                    zzo = zzly.zzf(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 25:
                    zzo = zzly.zza(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 26:
                    zzo = zzly.zzu(i4, (List) zzmx.zzf(obj, j));
                    i2 += zzo;
                    break;
                case 27:
                    zzo = zzly.zzp(i4, (List) zzmx.zzf(obj, j), zzE(i3));
                    i2 += zzo;
                    break;
                case 28:
                    zzo = zzly.zzc(i4, (List) zzmx.zzf(obj, j));
                    i2 += zzo;
                    break;
                case 29:
                    zzo = zzly.zzv(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 30:
                    zzo = zzly.zzd(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 31:
                    zzo = zzly.zzf(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 32:
                    zzo = zzly.zzh(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 33:
                    zzo = zzly.zzq(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 34:
                    zzo = zzly.zzs(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += zzo;
                    break;
                case 35:
                    zzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzly.zzn((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzly.zzy((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzly.zzl((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzly.zzb((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzly.zzw((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzly.zze((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzly.zzr((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzly.zzt((List) unsafe.getObject(obj, j));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i4);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzo = zzly.zzj(i4, (List) zzmx.zzf(obj, j), zzE(i3));
                    i2 += zzo;
                    break;
                case 50:
                    zzlg.zza(i4, zzmx.zzf(obj, j), zzF(i3));
                    break;
                case 51:
                    if (zzR(obj, i4, i3)) {
                        zzA = zzjl.zzA(i4 << 3);
                        zzo = zzA + 8;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i4, i3)) {
                        zzA2 = zzjl.zzA(i4 << 3);
                        zzo = zzA2 + 4;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i4, i3)) {
                        long zzC = zzC(obj, j);
                        zzA3 = zzjl.zzA(i4 << 3);
                        zzB = zzjl.zzB(zzC);
                        i2 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i4, i3)) {
                        long zzC2 = zzC(obj, j);
                        zzA3 = zzjl.zzA(i4 << 3);
                        zzB = zzjl.zzB(zzC2);
                        i2 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i4, i3)) {
                        int zzr = zzr(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzv(zzr);
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i4, i3)) {
                        zzA = zzjl.zzA(i4 << 3);
                        zzo = zzA + 8;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i4, i3)) {
                        zzA2 = zzjl.zzA(i4 << 3);
                        zzo = zzA2 + 4;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i4, i3)) {
                        zzA5 = zzjl.zzA(i4 << 3);
                        zzo = zzA5 + 1;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzR(obj, i4, i3)) {
                        break;
                    } else {
                        Object zzf2 = zzmx.zzf(obj, j);
                        if (zzf2 instanceof zzjd) {
                            zzA6 = zzjl.zzA(i4 << 3);
                            zzd = ((zzjd) zzf2).zzd();
                            zzA7 = zzjl.zzA(zzd);
                            i = zzA6 + zzA7 + zzd;
                            i2 += i;
                            break;
                        } else {
                            zzA4 = zzjl.zzA(i4 << 3);
                            zzv = zzjl.zzy((String) zzf2);
                            i = zzA4 + zzv;
                            i2 += i;
                        }
                    }
                case 60:
                    if (zzR(obj, i4, i3)) {
                        zzo = zzly.zzo(i4, zzmx.zzf(obj, j), zzE(i3));
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i4, i3)) {
                        zzjd zzjdVar2 = (zzjd) zzmx.zzf(obj, j);
                        zzA6 = zzjl.zzA(i4 << 3);
                        zzd = zzjdVar2.zzd();
                        zzA7 = zzjl.zzA(zzd);
                        i = zzA6 + zzA7 + zzd;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i4, i3)) {
                        int zzr2 = zzr(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzA(zzr2);
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i4, i3)) {
                        int zzr3 = zzr(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzv(zzr3);
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i4, i3)) {
                        zzA2 = zzjl.zzA(i4 << 3);
                        zzo = zzA2 + 4;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i4, i3)) {
                        zzA = zzjl.zzA(i4 << 3);
                        zzo = zzA + 8;
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i4, i3)) {
                        int zzr4 = zzr(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzA((zzr4 + zzr4) ^ (zzr4 >> 31));
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i4, i3)) {
                        long zzC3 = zzC(obj, j);
                        zzA4 = zzjl.zzA(i4 << 3);
                        zzv = zzjl.zzB((zzC3 + zzC3) ^ (zzC3 >> 63));
                        i = zzA4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i4, i3)) {
                        zzo = zzjl.zzu(i4, (zzll) zzmx.zzf(obj, j), zzE(i3));
                        i2 += zzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzmn zzmnVar = this.zzn;
        return i2 + zzmnVar.zza(zzmnVar.zzc(obj));
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzmx.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zziq zziqVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzlf) object).zze()) {
            zzlf zzb2 = zzlf.zza().zzb();
            zzlg.zzb(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        zzle zzleVar = (zzle) zzF;
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zziq zziqVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzir.zzn(bArr, i))));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzir.zzb(bArr, i))));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int zzm = zzir.zzm(bArr, i, zziqVar);
                    unsafe.putObject(obj, j, Long.valueOf(zziqVar.zzb));
                    unsafe.putInt(obj, j2, i4);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int zzj = zzir.zzj(bArr, i, zziqVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zziqVar.zza));
                    unsafe.putInt(obj, j2, i4);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(zzir.zzn(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(zzir.zzb(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int zzm2 = zzir.zzm(bArr, i, zziqVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(zziqVar.zzb != 0));
                    unsafe.putInt(obj, j2, i4);
                    return zzm2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int zzj2 = zzir.zzj(bArr, i, zziqVar);
                    int i9 = zziqVar.zza;
                    if (i9 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else if ((i6 & 536870912) == 0 || zznc.zzf(bArr, zzj2, zzj2 + i9)) {
                        unsafe.putObject(obj, j, new String(bArr, zzj2, i9, zzkm.zzb));
                        zzj2 += i9;
                    } else {
                        throw zzko.zzc();
                    }
                    unsafe.putInt(obj, j2, i4);
                    return zzj2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int zzd = zzir.zzd(zzE(i8), bArr, i, i2, zziqVar);
                    Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j, zziqVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzkm.zzg(object, zziqVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return zzd;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int zza2 = zzir.zza(bArr, i, zziqVar);
                    unsafe.putObject(obj, j, zziqVar.zzc);
                    unsafe.putInt(obj, j2, i4);
                    return zza2;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int zzj3 = zzir.zzj(bArr, i, zziqVar);
                    int i10 = zziqVar.zza;
                    zzki zzD = zzD(i8);
                    if (zzD == null || zzD.zza(i10)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i10));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        zzd(obj).zzh(i3, Long.valueOf(i10));
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int zzj4 = zzir.zzj(bArr, i, zziqVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzjh.zzb(zziqVar.zza)));
                    unsafe.putInt(obj, j2, i4);
                    return zzj4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int zzm3 = zzir.zzm(bArr, i, zziqVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzjh.zzc(zziqVar.zzb)));
                    unsafe.putInt(obj, j2, i4);
                    return zzm3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int zzc = zzir.zzc(zzE(i8), bArr, i, i2, (i3 & (-8)) | 4, zziqVar);
                    Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj, j, zziqVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzkm.zzg(object2, zziqVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return zzc;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:234:0x0238, code lost:
    
        if (r0 != r7) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x023c, code lost:
    
        r15 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x025b, code lost:
    
        if (r0 != r7) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x027e, code lost:
    
        if (r0 != r7) goto L250;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzu(java.lang.Object r33, byte[] r34, int r35, int r36, com.google.android.gms.internal.measurement.zziq r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zziq):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:388:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x021d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:386:0x014f -> B:387:0x0150). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:419:0x01cc -> B:420:0x01cd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:439:0x021a -> B:440:0x021b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzv(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zziq r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1176
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zziq):int");
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzb(Object obj) {
        int i;
        int zzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzB = zzB(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & zzB;
            int i5 = 37;
            switch (zzA(zzB)) {
                case 0:
                    i = i2 * 53;
                    zzc = zzkm.zzc(Double.doubleToLongBits(zzmx.zza(obj, j)));
                    i2 = i + zzc;
                    break;
                case 1:
                    i = i2 * 53;
                    zzc = Float.floatToIntBits(zzmx.zzb(obj, j));
                    i2 = i + zzc;
                    break;
                case 2:
                    i = i2 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + zzc;
                    break;
                case 3:
                    i = i2 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + zzc;
                    break;
                case 4:
                    i = i2 * 53;
                    zzc = zzmx.zzc(obj, j);
                    i2 = i + zzc;
                    break;
                case 5:
                    i = i2 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + zzc;
                    break;
                case 6:
                    i = i2 * 53;
                    zzc = zzmx.zzc(obj, j);
                    i2 = i + zzc;
                    break;
                case 7:
                    i = i2 * 53;
                    zzc = zzkm.zza(zzmx.zzw(obj, j));
                    i2 = i + zzc;
                    break;
                case 8:
                    i = i2 * 53;
                    zzc = ((String) zzmx.zzf(obj, j)).hashCode();
                    i2 = i + zzc;
                    break;
                case 9:
                    Object zzf = zzmx.zzf(obj, j);
                    if (zzf != null) {
                        i5 = zzf.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zzc = zzmx.zzf(obj, j).hashCode();
                    i2 = i + zzc;
                    break;
                case 11:
                    i = i2 * 53;
                    zzc = zzmx.zzc(obj, j);
                    i2 = i + zzc;
                    break;
                case 12:
                    i = i2 * 53;
                    zzc = zzmx.zzc(obj, j);
                    i2 = i + zzc;
                    break;
                case 13:
                    i = i2 * 53;
                    zzc = zzmx.zzc(obj, j);
                    i2 = i + zzc;
                    break;
                case 14:
                    i = i2 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + zzc;
                    break;
                case 15:
                    i = i2 * 53;
                    zzc = zzmx.zzc(obj, j);
                    i2 = i + zzc;
                    break;
                case 16:
                    i = i2 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + zzc;
                    break;
                case 17:
                    Object zzf2 = zzmx.zzf(obj, j);
                    if (zzf2 != null) {
                        i5 = zzf2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    zzc = zzmx.zzf(obj, j).hashCode();
                    i2 = i + zzc;
                    break;
                case 50:
                    i = i2 * 53;
                    zzc = zzmx.zzf(obj, j).hashCode();
                    i2 = i + zzc;
                    break;
                case 51:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzkm.zzc(Double.doubleToLongBits(zzn(obj, j)));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = Float.floatToIntBits(zzo(obj, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzr(obj, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzr(obj, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzkm.zza(zzS(obj, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = ((String) zzmx.zzf(obj, j)).hashCode();
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzmx.zzf(obj, j).hashCode();
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzmx.zzf(obj, j).hashCode();
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzr(obj, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzr(obj, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzr(obj, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzr(obj, j);
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        zzc = zzmx.zzf(obj, j).hashCode();
                        i2 = i + zzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.zzn.zzc(obj).hashCode();
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        return (i2 * 53) + hashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:356:0x039f, code lost:
    
        if (r0 != r21) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x03a3, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x03d7, code lost:
    
        if (r0 != r15) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x03f6, code lost:
    
        if (r0 != r15) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x03f8, code lost:
    
        r15 = r33;
        r14 = r34;
        r6 = r35;
        r12 = r37;
        r1 = r38;
        r13 = r39;
        r7 = r19;
        r2 = r26;
        r3 = r27;
        r8 = r28;
        r4 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0489, code lost:
    
        if (r7 == 1048575) goto L392;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x048b, code lost:
    
        r30.putInt(r13, r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0491, code lost:
    
        r3 = r10.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0495, code lost:
    
        if (r3 >= r10.zzl) goto L471;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0497, code lost:
    
        r5 = r10.zzj[r3];
        r6 = r10.zzc[r5];
        r6 = com.google.android.gms.internal.measurement.zzmx.zzf(r13, r10.zzB(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x04a9, code lost:
    
        if (r6 != null) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x04b0, code lost:
    
        if (r10.zzD(r5) != null) goto L470;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x04b2, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x04b5, code lost:
    
        r6 = (com.google.android.gms.internal.measurement.zzlf) r6;
        r0 = (com.google.android.gms.internal.measurement.zzle) r10.zzF(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x04bd, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x04be, code lost:
    
        if (r1 != 0) goto L409;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x04c2, code lost:
    
        if (r0 != r37) goto L407;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x04c9, code lost:
    
        throw com.google.android.gms.internal.measurement.zzko.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x04cc, code lost:
    
        if (r0 > r37) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x04ce, code lost:
    
        if (r4 != r1) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x04d0, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x04d6, code lost:
    
        throw com.google.android.gms.internal.measurement.zzko.zze();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.measurement.zziq r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zziq):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final Object zze() {
        return ((zzke) this.zzg).zzl(4, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long zzB = zzB(this.zzj[i2]) & 1048575;
            Object zzf = zzmx.zzf(obj, zzB);
            if (zzf != null) {
                ((zzlf) zzf).zzc();
                zzmx.zzs(obj, zzB, zzf);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(obj, this.zzj[i]);
            i++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zziq zziqVar) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zziqVar);
        } else {
            zzc(obj, bArr, i, i2, 0, zziqVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzi(Object obj, zznf zznfVar) throws IOException {
        if (!this.zzi) {
            zzL(obj, zznfVar);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzB = zzB(i);
                int i2 = this.zzc[i];
                switch (zzA(zzB)) {
                    case 0:
                        if (zzO(obj, i)) {
                            zznfVar.zzf(i2, zzmx.zza(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzO(obj, i)) {
                            zznfVar.zzo(i2, zzmx.zzb(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzO(obj, i)) {
                            zznfVar.zzt(i2, zzmx.zzd(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzO(obj, i)) {
                            zznfVar.zzJ(i2, zzmx.zzd(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzO(obj, i)) {
                            zznfVar.zzr(i2, zzmx.zzc(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzO(obj, i)) {
                            zznfVar.zzm(i2, zzmx.zzd(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzO(obj, i)) {
                            zznfVar.zzk(i2, zzmx.zzc(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzO(obj, i)) {
                            zznfVar.zzb(i2, zzmx.zzw(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzO(obj, i)) {
                            zzT(i2, zzmx.zzf(obj, zzB & 1048575), zznfVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zzO(obj, i)) {
                            zznfVar.zzv(i2, zzmx.zzf(obj, zzB & 1048575), zzE(i));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzO(obj, i)) {
                            zznfVar.zzd(i2, (zzjd) zzmx.zzf(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzO(obj, i)) {
                            zznfVar.zzH(i2, zzmx.zzc(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzO(obj, i)) {
                            zznfVar.zzi(i2, zzmx.zzc(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzO(obj, i)) {
                            zznfVar.zzw(i2, zzmx.zzc(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzO(obj, i)) {
                            zznfVar.zzy(i2, zzmx.zzd(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzO(obj, i)) {
                            zznfVar.zzA(i2, zzmx.zzc(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzO(obj, i)) {
                            zznfVar.zzC(i2, zzmx.zzd(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzO(obj, i)) {
                            zznfVar.zzq(i2, zzmx.zzf(obj, zzB & 1048575), zzE(i));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzly.zzJ(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 19:
                        zzly.zzN(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 20:
                        zzly.zzQ(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 21:
                        zzly.zzY(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 22:
                        zzly.zzP(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 23:
                        zzly.zzM(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 24:
                        zzly.zzL(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 25:
                        zzly.zzH(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 26:
                        zzly.zzW(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar);
                        break;
                    case 27:
                        zzly.zzR(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, zzE(i));
                        break;
                    case 28:
                        zzly.zzI(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar);
                        break;
                    case 29:
                        zzly.zzX(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 30:
                        zzly.zzK(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 31:
                        zzly.zzS(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 32:
                        zzly.zzT(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 33:
                        zzly.zzU(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 34:
                        zzly.zzV(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                        break;
                    case 35:
                        zzly.zzJ(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 36:
                        zzly.zzN(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 37:
                        zzly.zzQ(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 38:
                        zzly.zzY(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 39:
                        zzly.zzP(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 40:
                        zzly.zzM(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 41:
                        zzly.zzL(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 42:
                        zzly.zzH(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 43:
                        zzly.zzX(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 44:
                        zzly.zzK(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 45:
                        zzly.zzS(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 46:
                        zzly.zzT(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 47:
                        zzly.zzU(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 48:
                        zzly.zzV(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                        break;
                    case 49:
                        zzly.zzO(i2, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, zzE(i));
                        break;
                    case 50:
                        zzM(zznfVar, i2, zzmx.zzf(obj, zzB & 1048575), i);
                        break;
                    case 51:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzf(i2, zzn(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzo(i2, zzo(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzt(i2, zzC(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzJ(i2, zzC(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzr(i2, zzr(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzm(i2, zzC(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzk(i2, zzr(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzb(i2, zzS(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzR(obj, i2, i)) {
                            zzT(i2, zzmx.zzf(obj, zzB & 1048575), zznfVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzv(i2, zzmx.zzf(obj, zzB & 1048575), zzE(i));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzd(i2, (zzjd) zzmx.zzf(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzH(i2, zzr(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzi(i2, zzr(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzw(i2, zzr(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzy(i2, zzC(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzA(i2, zzr(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzC(i2, zzC(obj, zzB & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzR(obj, i2, i)) {
                            zznfVar.zzq(i2, zzmx.zzf(obj, zzB & 1048575), zzE(i));
                            break;
                        } else {
                            break;
                        }
                }
            }
            zzmn zzmnVar = this.zzn;
            zzmnVar.zzi(zzmnVar.zzc(obj), zznfVar);
        } else {
            this.zzo.zza(obj);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzZ;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzB = zzB(i);
            long j = zzB & 1048575;
            switch (zzA(zzB)) {
                case 0:
                    if (zzN(obj, obj2, i) && Double.doubleToLongBits(zzmx.zza(obj, j)) == Double.doubleToLongBits(zzmx.zza(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzN(obj, obj2, i) && Float.floatToIntBits(zzmx.zzb(obj, j)) == Float.floatToIntBits(zzmx.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzN(obj, obj2, i) && zzmx.zzw(obj, j) == zzmx.zzw(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzN(obj, obj2, i) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzN(obj, obj2, i) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzN(obj, obj2, i) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzN(obj, obj2, i) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzZ = zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j));
                    break;
                case 50:
                    zzZ = zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzy = zzy(i) & 1048575;
                    if (zzmx.zzc(obj, zzy) == zzmx.zzc(obj2, zzy) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzZ) {
                return false;
            }
        }
        if (this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            if (this.zzh) {
                this.zzo.zza(obj);
                this.zzo.zza(obj2);
                throw null;
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzB = zzB(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if ((268435456 & zzB) != 0 && !zzP(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA == 60 || zzA == 68) {
                        if (zzR(obj, i7, i6) && !zzQ(obj, zzB, zzE(i6))) {
                            return false;
                        }
                    } else if (zzA != 49) {
                        if (zzA == 50 && !((zzlf) zzmx.zzf(obj, zzB & 1048575)).isEmpty()) {
                            zzle zzleVar = (zzle) zzF(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzmx.zzf(obj, zzB & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzlw zzE = zzE(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzE.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzP(obj, i6, i, i2, i10) && !zzQ(obj, zzB, zzE(i6))) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzB = zzB(i);
            long j = 1048575 & zzB;
            int i2 = this.zzc[i];
            switch (zzA(zzB)) {
                case 0:
                    if (zzO(obj2, i)) {
                        zzmx.zzo(obj, j, zzmx.zza(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj2, i)) {
                        zzmx.zzp(obj, j, zzmx.zzb(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj2, i)) {
                        zzmx.zzm(obj, j, zzmx.zzw(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzO(obj2, i)) {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (zzO(obj2, i)) {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzly.zzaa(this.zzq, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzR(obj2, i2, i)) {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i2, i)) {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzly.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzly.zzE(this.zzo, obj, obj2);
        }
    }
}
