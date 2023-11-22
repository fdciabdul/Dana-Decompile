package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes7.dex */
public abstract class zzee implements Iterable, Serializable {
    private static final Comparator zza;
    private static final zzed zzd;
    private int zzc = 0;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {123, 85, -72, 69, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 203;
    public static final zzee zzb = new zzeb(zzez.zzd);

    static {
        int i = zzdr.zza;
        zzd = new zzed(null);
        zza = new zzdw();
    }

    private static void a(short s, int i, byte b, Object[] objArr) {
        int i2 = 18 - (b * 15);
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = 16 - (i * 3);
        int i4 = 106 - s;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i4 = i6 + i4 + 2;
            i6 = i6;
            i2 = i2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            int i8 = i2 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i6;
            i4 = i4 + bArr[i8] + 2;
            i6 = i9;
            i2 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    public static zzee zzk(byte[] bArr, int i, int i2) {
        zzi(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzeb(bArr2);
    }

    public static zzee zzl(String str) {
        return new zzeb(str.getBytes(zzez.zzb));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zze(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdv(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        try {
            Object[] objArr2 = {this};
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b2 = b;
            Object[] objArr3 = new Object[1];
            a(b, b2, b2, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            Object[] objArr4 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr4);
            objArr[0] = Integer.toHexString(((Integer) cls.getMethod((String) objArr4[0], Object.class).invoke(null, objArr2)).intValue());
            objArr[1] = Integer.valueOf(zzd());
            objArr[2] = zzd() <= 50 ? zzgw.zza(this) : zzgw.zza(zzf(0, 47)).concat("...");
            return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public abstract byte zza(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzd();

    protected abstract int zze(int i, int i2, int i3);

    public abstract zzee zzf(int i, int i2);

    protected abstract String zzg(Charset charset);

    public abstract boolean zzh();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzj() {
        return this.zzc;
    }

    public final String zzm(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) < 0) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
            } else if (i2 < i) {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
            } else {
                throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
            }
        }
        return i4;
    }
}
