package com.bumptech.glide.disklrucache;

import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import o.B;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Util {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    static final Charset MyBillsEntityDataFactory;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult;
    static final Charset getAuthRequestContext;
    private static byte[] getErrorConfigVersion;
    private static int lookAheadTest;
    private static short[] moveToNextValue;

    static void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory = 1257195719;
        PlaceComponentResult = 1556398811;
        getErrorConfigVersion = new byte[]{5, -23, -4, -15, -97};
        KClassImpl$Data$declaredNonStaticMembers$2 = -895714344;
    }

    static {
        MyBillsEntityDataFactory();
        MyBillsEntityDataFactory = Charset.forName("US-ASCII");
        Object[] objArr = new Object[1];
        a(2139933881 - KeyEvent.getDeadChar(0, 0), (-83) - Color.green(0), (short) View.combineMeasuredStates(0, 0), (-371952111) - Color.alpha(0), (byte) ((-112) - ((byte) KeyEvent.getModifierMetaStateMask())), objArr);
        getAuthRequestContext = Charset.forName(((String) objArr[0]).intern());
        int i = lookAheadTest + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (i % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private Util() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(File file) throws IOException {
        try {
            File[] listFiles = file.listFiles();
            if ((listFiles != null ? 'O' : (char) 25) == 25) {
                StringBuilder sb = new StringBuilder();
                sb.append("not a readable directory: ");
                sb.append(file);
                throw new IOException(sb.toString());
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
                    lookAheadTest = i % 128;
                    int i2 = i % 2;
                    getAuthRequestContext(file2);
                    int i3 = lookAheadTest + 83;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                    int i4 = i3 % 2;
                }
                try {
                    if ((file2.delete() ? 'M' : '1') == '1') {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("failed to delete file: ");
                        sb2.append(file2);
                        throw new IOException(sb2.toString());
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 21;
            lookAheadTest = i5 % 128;
            if (i5 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(Closeable closeable) {
        int i = lookAheadTest + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        try {
            if ((i % 2 == 0 ? 'M' : '2') != '2') {
                closeable.close();
                Object obj = null;
                obj.hashCode();
            } else {
                closeable.close();
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
        if (i4 == -1) {
            int i5 = $10 + 33;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            z = true;
        } else {
            int i7 = $10 + 111;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            z = false;
        }
        if ((z ? '@' : '_') == '@') {
            byte[] bArr = getErrorConfigVersion;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i9 = 0; i9 < length; i9++) {
                    int i10 = $10 + 63;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    bArr2[i9] = (byte) (bArr[i9] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            i4 = (bArr != null ? '5' : 'b') != '5' ? (short) (((short) (moveToNextValue[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))) : (byte) (((byte) (getErrorConfigVersion[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
        }
        if ((i4 > 0 ? (char) 18 : (char) 21) == 18) {
            b2.getAuthRequestContext = ((i + i4) - 2) + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)) + ((z ? 0 : 1) ^ 1);
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = getErrorConfigVersion;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i12 = 0; i12 < length2; i12++) {
                    try {
                        bArr4[i12] = (byte) (bArr3[i12] ^ 3097486228508854431L);
                    } catch (Exception e) {
                        throw e;
                    }
                }
                bArr3 = bArr4;
            }
            boolean z2 = (bArr3 != null ? 'O' : (char) 28) != 28;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (!(!z2)) {
                    byte[] bArr5 = getErrorConfigVersion;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = moveToNextValue;
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
