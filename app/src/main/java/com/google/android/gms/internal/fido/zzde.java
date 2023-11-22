package com.google.android.gms.internal.fido;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import id.dana.cashier.view.InputCardNumberView;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.B;

/* loaded from: classes3.dex */
public final class zzde {
    private static int $10 = 0;
    private static int $11 = 1;
    private static byte[] BuiltInFictitiousFunctionClassFactory = null;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static short[] MyBillsEntityDataFactory = null;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult;
    private static int getAuthRequestContext;
    private static int moveToNextValue;
    static final Charset zza;
    static final Charset zzb;
    static final Charset zzc;
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzdd zzf;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult = 1257195661;
        getAuthRequestContext = -1499289763;
        BuiltInFictitiousFunctionClassFactory = new byte[]{-40, -68, -79, -92, -97};
        KClassImpl$Data$declaredNonStaticMembers$2 = -283505316;
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        zza = Charset.forName("US-ASCII");
        Object[] objArr = new Object[1];
        a(1510652476 - TextUtils.indexOf((CharSequence) "", '0', 0), (-13) - (ViewConfiguration.getPressedStateDuration() >> 16), (short) ((-59) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 330436754, (byte) (MotionEvent.axisFromString("") + 1), objArr);
        zzb = Charset.forName(((String) objArr[0]).intern());
        zzc = Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzdd.zza;
        zzdb zzdbVar = new zzdb(bArr, 0, 0, false, null);
        try {
            zzdbVar.zza(0);
            zzf = zzdbVar;
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 97;
            moveToNextValue = i2 % 128;
            if (i2 % 2 == 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (zzdf e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        int length;
        byte[] bArr;
        int i4;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i5 = i2 + ((int) (PlaceComponentResult ^ 3097486228508854431L));
        boolean z2 = i5 == -1;
        if (z2) {
            byte[] bArr2 = BuiltInFictitiousFunctionClassFactory;
            if ((bArr2 != null ? (char) 27 : Typography.quote) != '\"') {
                int i6 = $10 + 107;
                $11 = i6 % 128;
                if (i6 % 2 == 0) {
                    length = bArr2.length;
                    bArr = new byte[length];
                    i4 = 1;
                } else {
                    length = bArr2.length;
                    bArr = new byte[length];
                    i4 = 0;
                }
                while (true) {
                    if ((i4 < length ? 'b' : Typography.greater) != 'b') {
                        break;
                    }
                    bArr[i4] = (byte) (bArr2[i4] ^ 3097486228508854431L);
                    i4++;
                }
                bArr2 = bArr;
            }
            if (!(bArr2 != null)) {
                try {
                    i5 = (short) (((short) (MyBillsEntityDataFactory[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
                    int i7 = $10 + 119;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                int i9 = $10 + 113;
                $11 = i9 % 128;
                i5 = (byte) (i9 % 2 == 0 ? ((byte) (BuiltInFictitiousFunctionClassFactory[i % ((int) (KClassImpl$Data$declaredNonStaticMembers$2 - 3097486228508854431L))] ^ 3097486228508854431L)) - ((int) (PlaceComponentResult - 3097486228508854431L)) : ((byte) (BuiltInFictitiousFunctionClassFactory[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            }
        }
        if (i5 > 0) {
            b2.getAuthRequestContext = ((i + i5) - 2) + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)) + ((z2 ? (char) 0 : 'K') != 'K' ? 1 : 0);
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = BuiltInFictitiousFunctionClassFactory;
            if ((bArr3 != null ? 'H' : InputCardNumberView.DIVIDER) == 'H') {
                try {
                    int i10 = $10 + 35;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    int length2 = bArr3.length;
                    byte[] bArr4 = new byte[length2];
                    for (int i12 = 0; i12 < length2; i12++) {
                        int i13 = $11 + 15;
                        $10 = i13 % 128;
                        int i14 = i13 % 2;
                        bArr4[i12] = (byte) (bArr3[i12] ^ 3097486228508854431L);
                    }
                    bArr3 = bArr4;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            if (!(bArr3 != null)) {
                z = false;
            } else {
                int i15 = $10 + 51;
                $11 = i15 % 128;
                int i16 = i15 % 2;
                z = true;
            }
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i5) {
                if (z) {
                    byte[] bArr5 = BuiltInFictitiousFunctionClassFactory;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = MyBillsEntityDataFactory;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
