package com.alipay.mobile.security.bio.service;

import android.view.KeyEvent;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.util.RaspUtils;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes7.dex */
public class BioStoreParameter {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int PlaceComponentResult = 0;
    private static int getErrorConfigVersion = 1;
    public byte[] content;
    public String publicKey;
    public byte[] random;
    private static char[] BuiltInFictitiousFunctionClassFactory = {39606, 39603, 39611, 39600, 39527, 39425};
    private static boolean MyBillsEntityDataFactory = true;
    private static boolean getAuthRequestContext = true;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 909154849;

    public static void $$a(long j, long j2) {
        long j3 = j ^ (j2 << 32);
        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(KeyEvent.getDeadChar(0, 0) + 127, new byte[]{-122, -123, -124, -125, -126, -127}, null, null, objArr);
        sb.append((String) objArr[0]);
        sb.append(j3);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj);
        RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
        Intrinsics.checkNotNullParameter(dexguardException, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(dexguardException);
        RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.HOOKED);
        UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.HOOKED);
        int i = getErrorConfigVersion + 37;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if (cArr2 != null) {
            int i2 = $11 + 95;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i4 = $10 + 67;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = $10 + 63;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                cArr3[i6] = (char) (cArr2[i6] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i9 = (int) (4571606982258105150L ^ KClassImpl$Data$declaredNonStaticMembers$2);
        if (getAuthRequestContext) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                try {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i9);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            String str = new String(cArr4);
            int i10 = $10 + 77;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            objArr[0] = str;
            return;
        }
        if (!(!MyBillsEntityDataFactory)) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    objArr[0] = new String(cArr5);
                    return;
                } else {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i9);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            }
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'Y' : '\n') == '\n') {
                    objArr[0] = new String(cArr6);
                    return;
                }
                int i12 = $11 + 11;
                $10 = i12 % 128;
                int i13 = i12 % 2;
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i9);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
        }
    }
}
