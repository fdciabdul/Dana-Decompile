package com.google.android.gms.internal.fido;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class zzcz implements Iterable, Serializable {
    private static final Comparator zza;
    private static final zzcy zzd;
    private int zzc = 0;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {22, 66, -65, -82, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 166;
    public static final zzcz zzb = new zzcw(zzde.zzd);

    static {
        int i = zzcp.zza;
        zzd = new zzcy(null);
        zza = new zzcr();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 15
            int r8 = 18 - r8
            int r6 = r6 + 105
            byte[] r0 = com.google.android.gms.internal.fido.zzcz.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 * 4
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L19:
            r3 = 0
        L1a:
            r5 = r8
            r8 = r6
            r6 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r6 = r6 + 1
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzcz.a(byte, byte, short, java.lang.Object[]):void");
    }

    public static zzcz zzl(byte[] bArr, int i, int i2) {
        zzj(0, i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return new zzcw(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zzf(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzcq(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        try {
            Object[] objArr2 = {this};
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr3 = new Object[1];
            a(b, b2, b2, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            Object[] objArr4 = new Object[1];
            a(b3, b3, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr4);
            objArr[0] = Integer.toHexString(((Integer) cls.getMethod((String) objArr4[0], Object.class).invoke(null, objArr2)).intValue());
            objArr[1] = Integer.valueOf(zzd());
            objArr[2] = zzd() <= 50 ? zzdg.zza(this) : zzdg.zza(zzg(0, 47)).concat("...");
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

    protected abstract void zze(byte[] bArr, int i, int i2, int i3);

    protected abstract int zzf(int i, int i2, int i3);

    public abstract zzcz zzg(int i, int i2);

    public abstract InputStream zzh();

    public abstract ByteBuffer zzi();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzk() {
        return this.zzc;
    }

    public final byte[] zzm() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzde.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, int i2, int i3) {
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
