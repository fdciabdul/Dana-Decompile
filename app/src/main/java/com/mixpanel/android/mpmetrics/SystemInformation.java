package com.mixpanel.android.mpmetrics;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.util.DisplayMetrics;
import com.google.common.base.Ascii;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SystemInformation {
    private static SystemInformation NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Context BuiltInFictitiousFunctionClassFactory;
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    final DisplayMetrics MyBillsEntityDataFactory;
    private final Boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    final String PlaceComponentResult;
    final Integer getAuthRequestContext;
    private final Boolean lookAheadTest;
    public static final byte[] getErrorConfigVersion = {8, 17, -121, -18, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int scheduleImpl = 221;
    private static final Object moveToNextValue = new Object();

    private static void a(byte b, int i, int i2, Object[] objArr) {
        int i3 = (b * 5) + 18;
        byte[] bArr = getErrorConfigVersion;
        int i4 = (i2 * 6) + 97;
        int i5 = i + 4;
        byte[] bArr2 = new byte[i3];
        int i6 = -1;
        int i7 = i3 - 1;
        if (bArr == null) {
            i4 = (i7 + (-i4)) - 8;
            i7 = i7;
            i5 = i5;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i4;
            if (i6 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i5 + 1;
            i4 = (i4 + (-bArr[i8])) - 8;
            i7 = i7;
            i5 = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SystemInformation KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        synchronized (moveToNextValue) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = new SystemInformation(context.getApplicationContext());
            }
        }
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private SystemInformation(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.SystemInformation.<init>(android.content.Context):void");
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest.booleanValue();
    }

    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1.booleanValue();
    }

    public final Boolean getAuthRequestContext() {
        BluetoothAdapter defaultAdapter;
        try {
            if (this.BuiltInFictitiousFunctionClassFactory.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.BuiltInFictitiousFunctionClassFactory.getPackageName()) != 0 || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
                return null;
            }
            return Boolean.valueOf(defaultAdapter.isEnabled());
        } catch (NoClassDefFoundError | SecurityException unused) {
            return null;
        }
    }
}
