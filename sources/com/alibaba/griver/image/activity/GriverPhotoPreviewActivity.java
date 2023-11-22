package com.alibaba.griver.image.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.photo.meta.PhotoParam;
import com.alibaba.griver.image.photo.widget.PhotoBrowseView;
import com.alibaba.griver.ui.ant.AUTitleBar;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class GriverPhotoPreviewActivity extends GriverMediaBaseActivity {
    public static final String TAG = "GriverPhotoPreviewActivity";

    /* renamed from: a  reason: collision with root package name */
    private PhotoBrowseView f6556a;
    private boolean b;
    private AUTitleBar c;
    public static final byte[] $$a = {111, 84, 114, 59, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 139;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {99, 56, -99, 122, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int MyBillsEntityDataFactory = 97;
    private static char[] getAuthRequestContext = {13648, 19636, 50819, 22658, 54002, 21711, 61143, 24690, 64006, 31745, 63025, 2168, 33351, 1457, 40840, 4497, 44018, 11737, 3844, 30459, 64746, 25281, 59553, 62255, 35531, 252, 40701, 5261, 37552, 10408, 42509, 15479, 47741, 12304, 52857, 17419, 50114, 23008, 55266, 28040, 60348, 25020, 65350, 30022, 62305, 35086, 1846, 40231, 5337, 62253, 35536, 234, 40701, 5255, 37559, 10424, 42594, 15462, 47741, 12300, 52798, 17449, 50112, 23008, 55266, 28049, 60347, 15991, 18376, 52640, 21433, 55772, 24499, 58875, 27413, 61743, 30566, 64781, 831, 35105, 3741, 38059, 6835, 41153, 9962, 44272, 12880, 47224, 15972, 17425, 51819, 20524, 55680, 24486, 58861, 27590, 61883, 30635, 64848, 793, 35133, 3908, 38232, 6954, 41102, 9882, 44221, 13007, 47237, 16122, 17423, 51782, 20540, 54860, 23552, 48246, 50633, 20471, 53682, 23517, 56761, 26533, 59714, 29483, 62775, 32512, 33083, 2935, 36041, 5884, 39142, 8853, 42174, 12023, 45143, 14895, 48225, 50707, 18489, 53801, 23430, 56816, 26555, 59803, 29676, 62895, 32592, 33044, 2872, 36117, 5902, 39288, 8835, 42181, 12009, 45210, 14980, 48380, 50783, 18448, 53871, 21532, 56837, 24628, 59871, 29638, 62975, 32658, 33159, 2997, 36187, 5967, 39285, 9034, 42332, 12082, 45264, 15001, 48369, 11479, 21823, 57174, 16710, 52080, 19781, 63317, 31164, 58245, 26014, 61427, 4557, 39888, 7225, 34319, 2071, 45620, 13339, 48727, 8432, 43659, 11456, 22198, 55499, 17114, 52080, 19714, 63252, 31031, 58140, 25944, 61427, 4530, 39882, 7649, 34812, 2443, 45605, 13361, 48656, 8293, 43552, 11354, 22184, 55481, 17050, 50366, 20130, 61587, 31015, 58208, 25937, 61291, 4467, 39697, 7597, 34746, 2435, 46050, 13818, 49047, 8239, 43578, 11273, 42874, 56973, 21680, 51875, 16589, 50879, 31935, 62032, 26670, 60976, 25682, 39530, 4152, 38793, 3488, 33701, 14791, 49128, 13792, 43776, 8495, 42790, 56660, 21281, 51581, 16532, 50861, 31913, 62146, 26878, 61161, 25618, 39443, 4139, 38465, 3101, 33405, 14730, 49053, 13808, 43979, 8641, 42997, 56644, 21279, 51507, 20303, 50514, 31601, 62109, 26843, 61109, 25756, 39578, 4325, 38425, 3103, 33327, 14424, 48712, 62327, 35467, 172, 40609, 5328, 37608};
    private static long BuiltInFictitiousFunctionClassFactory = 3778457702613748389L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 23 - r8
            byte[] r0 = com.alibaba.griver.image.activity.GriverPhotoPreviewActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = 56 - r6
            int r7 = 106 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2e
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2e:
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.activity.GriverPhotoPreviewActivity.d(int, byte, short, java.lang.Object[]):void");
    }

    private static void f(byte b, int i, byte b2, Object[] objArr) {
        int i2 = 103 - (b2 * 2);
        byte[] bArr = $$a;
        int i3 = (b * 3) + 21;
        int i4 = 47 - i;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i2 = (i4 + i6) - 7;
            i6 = i6;
            i4++;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i4];
            int i8 = i4;
            int i9 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i2 = (i2 + b3) - 7;
            i6 = i9;
            i4 = i8 + 1;
        }
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        e(18 - Color.blue(0), (-1) - ImageFormat.getBitsPerPixel(0), (char) (50815 - TextUtils.getOffsetBefore("", 0)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        e(5 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (Gravity.getAbsoluteGravity(0, 0) + 64551), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    e(48 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 68, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 52493), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    e((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 63, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 115, (char) (20313 - (Process.myPid() >> 22)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    e(64 - View.combineMeasuredStates(0, 0), TextUtils.indexOf("", "") + 179, (char) (TextUtils.getTrimmedLength("") + 57259), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    e(60 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 243, (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 21596), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    e((ViewConfiguration.getPressedStateDuration() >> 16) + 6, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 302, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), 18 - KeyEvent.getDeadChar(0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = {this};
                Object[] objArr14 = new Object[1];
                d(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1), KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 55, 3 - TextUtils.indexOf("", ""), (char) View.resolveSizeAndState(0, 0, 0));
                        Object[] objArr17 = new Object[1];
                        f($$a[78], $$a[53], $$a[12], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 15 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 14 - MotionEvent.axisFromString(""), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 815, 29 - ExpandableListView.getPackedPositionType(0L), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.combineMeasuredStates(0, 0), 15 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {1922372943, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), 18 - Gravity.getAbsoluteGravity(0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr20 = {this};
                Object[] objArr21 = new Object[1];
                d(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1), KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getCapsMode("", 0, 0), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 45, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                        Object[] objArr24 = new Object[1];
                        f((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + PDF417Common.NUMBER_OF_CODEWORDS, View.getDefaultSize(0, 0) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {1922372943, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr27 = {this};
                Object[] objArr28 = new Object[1];
                d(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1), KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - ((byte) KeyEvent.getModifierMetaStateMask()), TextUtils.lastIndexOf("", '0', 0, 0) + 4, (char) (TextUtils.indexOf((CharSequence) "", '0') + 38969));
                        Object[] objArr31 = new Object[1];
                        f((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {1922372943, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 18 - ExpandableListView.getPackedPositionType(0L), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr34 = {this};
                Object[] objArr35 = new Object[1];
                d(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1), KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 107, 3 - Color.red(0), (char) ((-16777216) - Color.rgb(0, 0, 0)));
                        Object[] objArr38 = new Object[1];
                        f($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 35 - ExpandableListView.getPackedPositionType(0L), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {1922372943, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 911, 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            d(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], objArr3);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 15;
            try {
                Object[] objArr4 = new Object[1];
                d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                d(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], new Object[1]);
                Object[] objArr5 = new Object[1];
                e(i, ((ApplicationInfo) cls2.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.incorrect_expiry_date).substring(6, 7).length() + 50814), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                Object[] objArr6 = new Object[1];
                e(getPackageName().codePointAt(0) - 100, super.getResources().getString(R.string.saving_withdrawal_nominal_min_only).substring(3, 4).codePointAt(0) - 103, (char) (super.getResources().getString(R.string.zdoc_submit).substring(5, 6).length() + 64550), objArr6);
                int intValue = ((Integer) cls3.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        int length = super.getResources().getString(R.string.intro_tnc).substring(5, 6).length() + 25;
                        int codePointAt = super.getResources().getString(R.string.error_saving_amount_limit_non_kyc).substring(1, 2).codePointAt(0) - 88;
                        try {
                            Object[] objArr7 = new Object[1];
                            d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            d(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], new Object[1]);
                            Object[] objArr8 = new Object[1];
                            e(length, codePointAt, (char) (((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            int combineMeasuredStates = 18 - View.combineMeasuredStates(0, 0);
                            try {
                                Object[] objArr9 = new Object[1];
                                d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr9);
                                Class<?> cls6 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                d(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], objArr10);
                                Object[] objArr11 = new Object[1];
                                e(combineMeasuredStates, ((ApplicationInfo) cls6.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 16, (char) (getPackageName().length() - 7), objArr11);
                                baseContext = (Context) cls5.getMethod((String) objArr11[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Drawable.resolveOpacity(0, 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr12 = new Object[1];
                            e(getPackageName().codePointAt(0) - 57, getPackageName().length() + 60, (char) (getPackageName().length() + 52487), objArr12);
                            String str = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            e(super.getResources().getString(R.string.res_0x7f13048e_challenge_pin_dialog_button_negative).substring(4, 5).length() + 63, super.getResources().getString(R.string.deals_express_confirmation_desc).substring(13, 14).codePointAt(0) + 83, (char) (super.getResources().getString(R.string.feeds_empty_desc).substring(83, 85).length() + 20311), objArr13);
                            String str2 = (String) objArr13[0];
                            int codePointAt2 = getPackageName().codePointAt(1) - 36;
                            int codePointAt3 = super.getResources().getString(R.string.family_member_transaction_limit_success_changed_message).substring(2, 3).codePointAt(0) + 70;
                            try {
                                Object[] objArr14 = new Object[1];
                                d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr14);
                                Class<?> cls7 = Class.forName((String) objArr14[0]);
                                Object[] objArr15 = new Object[1];
                                d(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], objArr15);
                                Object[] objArr16 = new Object[1];
                                e(codePointAt2, codePointAt3, (char) (((ApplicationInfo) cls7.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 57226), objArr16);
                                String str3 = (String) objArr16[0];
                                try {
                                    Object[] objArr17 = new Object[1];
                                    d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr17);
                                    Class<?> cls8 = Class.forName((String) objArr17[0]);
                                    Object[] objArr18 = new Object[1];
                                    d(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], objArr18);
                                    Object[] objArr19 = new Object[1];
                                    e(((ApplicationInfo) cls8.getMethod((String) objArr18[0], null).invoke(this, null)).targetSdkVersion + 27, 243 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (super.getResources().getString(R.string.request_money_expiry_refresh_time).substring(7, 8).codePointAt(0) + 21564), objArr19);
                                    String str4 = (String) objArr19[0];
                                    Object[] objArr20 = new Object[1];
                                    e((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 6, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 303, (char) (super.getResources().getString(R.string.emergency_page_reminder_toast).substring(8, 9).codePointAt(0) - 97), objArr20);
                                    try {
                                        Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) Color.green(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr21);
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
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    }
                }
                try {
                    Object[] objArr22 = new Object[1];
                    d(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr22);
                    Class<?> cls9 = Class.forName((String) objArr22[0]);
                    Object[] objArr23 = new Object[1];
                    d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1), KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr23);
                    try {
                        Object[] objArr24 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 4, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1));
                            Object[] objArr25 = new Object[1];
                            f($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr25);
                            obj3 = cls10.getMethod((String) objArr25[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr26 = (Object[]) ((Method) obj3).invoke(null, objArr24);
                        int i2 = ((int[]) objArr26[1])[0];
                        if (((int[]) objArr26[0])[0] != i2) {
                            long j = ((r2 ^ i2) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 36, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr27 = {-626992012, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr27);
                                } catch (Throwable th7) {
                                    Throwable cause7 = th7.getCause();
                                    if (cause7 == null) {
                                        throw th7;
                                    }
                                    throw cause7;
                                }
                            } catch (Throwable th8) {
                                Throwable cause8 = th8.getCause();
                                if (cause8 == null) {
                                    throw th8;
                                }
                                throw cause8;
                            }
                        }
                        super.onCreate(bundle);
                        requestWindowFeature(1);
                        if (bundle == null) {
                            bundle2 = getIntent().getExtras();
                            if (bundle2 == null) {
                                finish();
                                return;
                            }
                        } else {
                            RVLogger.d(TAG, "initialize photo preview with save instance.");
                            bundle2 = bundle;
                        }
                        if (bundle2.getBoolean(PhotoParam.BROWSE_GALLERY, false)) {
                            getWindow().setFlags(1024, 1024);
                        }
                        setContentView(com.alibaba.griver.image.R.layout.griver_image_activity_photo_preview);
                        PhotoBrowseView photoBrowseView = (PhotoBrowseView) findViewById(com.alibaba.griver.image.R.id.photo_browse_view);
                        this.f6556a = photoBrowseView;
                        photoBrowseView.setActivity(this);
                        this.f6556a.setBundle(bundle2);
                        this.b = bundle2.getBoolean(PhotoParam.USING_PHONE_TITLE_BAR, false);
                        AUTitleBar aUTitleBar = (AUTitleBar) findViewById(com.alibaba.griver.image.R.id.cashier_top_bar);
                        this.c = aUTitleBar;
                        aUTitleBar.setVisibility(this.b ? 0 : 8);
                        this.c.setBackgroundDrawable(new ColorDrawable(1059465787));
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
            } catch (Throwable th11) {
                Throwable cause11 = th11.getCause();
                if (cause11 == null) {
                    throw th11;
                }
                throw cause11;
            }
        } catch (Throwable th12) {
            Throwable cause12 = th12.getCause();
            if (cause12 == null) {
                throw th12;
            }
            throw cause12;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PhotoBrowseView photoBrowseView = this.f6556a;
        if (photoBrowseView != null) {
            photoBrowseView.setActivity(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(getPackageName().length() + 19, super.getResources().getString(R.string.redirect_not_found).substring(0, 2).length() + 21, (char) (super.getResources().getString(R.string.twilio_intro_1_description).substring(27, 28).codePointAt(0) - 32), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            e(getPackageName().length() + 11, super.getResources().getString(R.string.family_account_text_month_transaction_limit_desc).substring(7, 8).codePointAt(0) + 17, (char) (super.getResources().getString(R.string.text_add_to_favorite_recipient_action).substring(6, 7).length() - 1), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), 34 - MotionEvent.axisFromString(""), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, ((byte) KeyEvent.getModifierMetaStateMask()) + 19, (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        PhotoBrowseView photoBrowseView = this.f6556a;
        if (photoBrowseView != null) {
            photoBrowseView.pause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        PhotoBrowseView photoBrowseView = this.f6556a;
        if (photoBrowseView != null) {
            photoBrowseView.backPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(25 - TextUtils.indexOf((CharSequence) "", '0'), 23 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (super.getResources().getString(R.string.title_saving_main_empty_state).substring(23, 24).codePointAt(0) - 32), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int i = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17;
            int length = super.getResources().getString(R.string.voucher_ticket_tooltip_desc).substring(0, 1).length() + 48;
            try {
                Object[] objArr2 = new Object[1];
                d((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                d(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], new Object[1]);
                Object[] objArr3 = new Object[1];
                e(i, length, (char) (((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        }
        super.onResume();
        PhotoBrowseView photoBrowseView = this.f6556a;
        if (photoBrowseView != null) {
            photoBrowseView.resume();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PhotoBrowseView photoBrowseView = this.f6556a;
        if (photoBrowseView != null) {
            photoBrowseView.newIntent(intent);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PhotoBrowseView photoBrowseView = this.f6556a;
        if (photoBrowseView != null) {
            photoBrowseView.saveInstanceState(getIntent(), bundle);
        }
    }

    private static void e(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BuiltInFictitiousFunctionClassFactory))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
