package com.alibaba.griver.core.ui.activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class GriverBaseFragmentActivity extends FragmentActivity {
    public static final byte[] $$a = {12, -73, 84, 57, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 254;
    public static final byte[] getAuthRequestContext = {59, -103, 22, 57, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 18;
    private static long PlaceComponentResult = 9093452204610508003L;

    private static void k(byte b, short s, byte b2, Object[] objArr) {
        byte[] bArr = getAuthRequestContext;
        int i = b + 4;
        int i2 = 106 - b2;
        int i3 = 23 - s;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            i2 = (i + (-i2)) - 4;
            i = i;
            i5 = i5;
        }
        while (true) {
            int i6 = i + 1;
            i4++;
            bArr2[i4] = (byte) i2;
            if (i4 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = (i2 + (-bArr[i6])) - 4;
            i = i6;
            i5 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void l(short r8, int r9, byte r10, java.lang.Object[] r11) {
        /*
            byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity.$$a
            int r8 = r8 * 4
            int r8 = 75 - r8
            int r9 = r9 * 2
            int r9 = 3 - r9
            int r10 = r10 * 2
            int r10 = 42 - r10
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r9
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L37
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            int r9 = r9 + 1
            if (r4 != r10) goto L2c
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L2c:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L37:
            int r9 = r9 + r10
            int r9 = r9 + (-7)
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity.l(short, int, byte, java.lang.Object[]):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            Object[] objArr = new Object[1];
            k(getAuthRequestContext[7], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            k((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
            Object[] objArr2 = new Object[1];
            j(((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{17313, 25821, 17344, 53863, 32184, 57365, 1473, 10210, 20114, 6531, 17473, 57841, 35734, 34253, 10279, 23995, 28503, 8509, 35998, 14674, 54114, 52501}, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            j(getPackageName().codePointAt(6) - 96, new char[]{45152, 35882, 45069, 55814, 38232, 59461, 10652, 54312, 25300}, objArr3);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        Object[] objArr4 = new Object[1];
                        k(getAuthRequestContext[7], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        k((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                        Object[] objArr5 = new Object[1];
                        j(((ApplicationInfo) cls3.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{63830, 63789, 63799, 42884, 57416, 38390, 64114, 40213, 45345, 33907, 12706, 7746, 12655, 6206, 23962, 41590, 54675, 48321, 63850, 50925, 27024, 20735, 25910, 27273, 3550, 62626, 33028, 36537, 41023, 35674}, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        j(super.getResources().getString(R.string.next_schedule_payment_today).substring(0, 1).length() + 0, new char[]{49103, 12349, 49068, 20379, 10563, 32255, 58876, 56198, 44719, 19812, 55725, 419, 30695, 53550, 46489, 48575, 37672, 30163, 4469, 55651, 12048, 39400}, objArr6);
                        baseContext = (Context) cls4.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        j(super.getResources().getString(R.string.family_account_failed_delete_family_account_message).substring(48, 49).codePointAt(0) - 109, new char[]{56725, 8553, 56738, 53448, 14337, 58088, 15453, 47497, 30532, 23610, 18099, 55345, 5626, 49263, 10949, 25691, 61812, 25812, 36451, Typography.times, 19732, 35043, 4664, 44276, 10541, 11501, 63065, 18575, 34041, 21321, 23534, 54025, 24723, 63282, 16355, 32628, 64716, 6964, 33676, 7164, 22655, 49095, 26450, 42969, 13338, 9164, 52018, 17323, 36883, 18357, 44804, 60964}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        j(-((byte) KeyEvent.getModifierMetaStateMask()), new char[]{29502, 14361, 29535, 40786, 8487, 44402, 61266, 6004, 42007, 17687, 2336, 2914, 47874, 55577, 25861, 46939, 24542, 32167, 49657, 54150, 58300, 37264, 24050, 32759, 34694, 13775, 47510, 39897, 10752, 19048, 5237, '[', 52786, 60994, 28714, 44144, 21053, 534, 52240, 51374, 63185, 42733, 10432, 29833, 39603, 15082, 34041, 37119, 16057, 24257, 57497, 15653, 49437, 62257, 31555, 22815, 25915, 5993, 55088, 50555, 2406, 43867, 13135, 25084, 44443, 53182, 36764, 36241}, objArr8);
                        String str2 = (String) objArr8[0];
                        try {
                            Object[] objArr9 = new Object[1];
                            k(getAuthRequestContext[7], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            k((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            j(((ApplicationInfo) cls5.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{18916, 31049, 18902, 10422, 24691, 6853, 42993, 11761, 60594, 1097, 48838, 17355, 33156, 38930, 53984, 65530, 25937, 15605, 30236, 39712, 55605, 53399, 59972, 14087, 48394, 29900, 3621, 54140, 4315, 2876, 41873, 18595, 62646, 44816, 51147, 58500, 26803, 17222, 31730, 32779, 52234, 59369, 40738, 15399, 41060, 31724, 13129, 55391, 1080, 8086, 22317, 30165, 64402, 45675, 52467, 4582, 24554, 22079, 24706, 36314, 13243, 59919, 34033, 10509, 38678, 36579, 14377, 50494}, objArr10);
                            String str3 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            j(1 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new char[]{24723, 144, 24827, 65045, 6639, 52343, 2057, 1228, 17240, 32157, 26744, 60474, 43183, 57746, 1045, 20544, 19513, 17771, 41191, 13455, 61510, 43338, 15527, 39146, 37934, 3332, 55443, 31883, 14844, 29430, 30058, 59139, 56771, 55004, 4398, 19320, 16786, 14985, 44294, 12279, 58748, 40552, 18906, 37850, 35146, 547, 58802, 30638, 11550, 26129, 33160, 55864, 54000, 52223, 6684, 48671, 30365, 12280, 46626, 8819, 6814, 37773, 21023, 34466}, objArr11);
                            String str4 = (String) objArr11[0];
                            try {
                                Object[] objArr12 = new Object[1];
                                k(getAuthRequestContext[7], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr12);
                                Class<?> cls6 = Class.forName((String) objArr12[0]);
                                k((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                                Object[] objArr13 = new Object[1];
                                j(((ApplicationInfo) cls6.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{17300, 43053, 17325, 32452, 45320, 19686, 13952, 10122, 32143, 54571}, objArr13);
                                try {
                                    Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr14);
                                } catch (Throwable th2) {
                                    Throwable cause2 = th2.getCause();
                                    if (cause2 == null) {
                                        throw th2;
                                    }
                                    throw cause2;
                                }
                            } catch (Throwable th3) {
                                Throwable cause3 = th3.getCause();
                                if (cause3 == null) {
                                    throw th3;
                                }
                                throw cause3;
                            }
                        } catch (Throwable th4) {
                            Throwable cause4 = th4.getCause();
                            if (cause4 == null) {
                                throw th4;
                            }
                            throw cause4;
                        }
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                }
            }
            try {
                Object[] objArr15 = new Object[1];
                k((byte) (KClassImpl$Data$declaredNonStaticMembers$2 << 1), getAuthRequestContext[30], getAuthRequestContext[25], objArr15);
                Class<?> cls7 = Class.forName((String) objArr15[0]);
                Object[] objArr16 = new Object[1];
                k((byte) (KClassImpl$Data$declaredNonStaticMembers$2 + 3), getAuthRequestContext[30], getAuthRequestContext[9], objArr16);
                try {
                    Object[] objArr17 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 494, (ViewConfiguration.getEdgeSlop() >> 16) + 4, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1));
                        byte b = (byte) ($$a[35] - 1);
                        byte b2 = b;
                        Object[] objArr18 = new Object[1];
                        l(b, b2, b2, objArr18);
                        obj3 = cls8.getMethod((String) objArr18[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                    int i = ((int[]) objArr19[1])[0];
                    if (((int[]) objArr19[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr20 = {-1817818750, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, TextUtils.indexOf("", "", 0, 0) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr20);
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 == null) {
                                    throw th6;
                                }
                                throw cause6;
                            }
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 == null) {
                                throw th7;
                            }
                            throw cause7;
                        }
                    }
                    super.onCreate(bundle);
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            j(-TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{63830, 63789, 63799, 42884, 57416, 38390, 64114, 40213, 45345, 33907, 12706, 7746, 12655, 6206, 23962, 41590, 54675, 48321, 63850, 50925, 27024, 20735, 25910, 27273, 3550, 62626, 33028, 36537, 41023, 35674}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            j((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{49103, 12349, 49068, 20379, 10563, 32255, 58876, 56198, 44719, 19812, 55725, 419, 30695, 53550, 46489, 48575, 37672, 30163, 4469, 55651, 12048, 39400}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.alpha(0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                k(getAuthRequestContext[7], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                k((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                Object[] objArr2 = new Object[1];
                j(((ApplicationInfo) cls.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{63830, 63789, 63799, 42884, 57416, 38390, 64114, 40213, 45345, 33907, 12706, 7746, 12655, 6206, 23962, 41590, 54675, 48321, 63850, 50925, 27024, 20735, 25910, 27273, 3550, 62626, 33028, 36537, 41023, 35674}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    Object[] objArr3 = new Object[1];
                    k(getAuthRequestContext[7], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    k((byte) (-getAuthRequestContext[59]), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    j(((ApplicationInfo) cls3.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{49103, 12349, 49068, 20379, 10563, 32255, 58876, 56198, 44719, 19812, 55725, 419, 30695, 53550, 46489, 48575, 37672, 30163, 4469, 55651, 12048, 39400}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0') + 36, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, (Process.myPid() >> 22) + 18, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 == null) {
                    throw th4;
                }
                throw cause4;
            }
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        ((RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class)).onRequestPermissionResult(i, strArr, iArr);
    }

    private static void j(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (PlaceComponentResult ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
    }
}
