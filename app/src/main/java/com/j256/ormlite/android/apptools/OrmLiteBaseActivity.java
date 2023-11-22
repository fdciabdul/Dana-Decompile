package com.j256.ormlite.android.apptools;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public abstract class OrmLiteBaseActivity<H extends OrmLiteSqliteOpenHelper> extends Activity {
    private static int BuiltInFictitiousFunctionClassFactory;
    private static char MyBillsEntityDataFactory;
    private static long getAuthRequestContext;
    private static Logger logger;
    private volatile boolean created = false;
    private volatile boolean destroyed = false;
    private volatile H helper;
    public static final byte[] $$a = {1, -107, Ascii.ESC, -41, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 93;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {121, 107, -47, -24, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 72;

    static void PlaceComponentResult() {
        MyBillsEntityDataFactory = (char) 59531;
        getAuthRequestContext = 4360990799332652212L;
        BuiltInFictitiousFunctionClassFactory = -956812108;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 97
            int r6 = 23 - r6
            byte[] r0 = com.j256.ormlite.android.apptools.OrmLiteBaseActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L30:
            int r8 = r8 + r6
            int r6 = r9 + 1
            int r8 = r8 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.apptools.OrmLiteBaseActivity.a(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r0 = com.j256.ormlite.android.apptools.OrmLiteBaseActivity.$$a
            int r6 = 46 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-7)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.apptools.OrmLiteBaseActivity.c(short, short, short, java.lang.Object[]):void");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{45005, 30737, 62271, 23477}, ViewConfiguration.getJumpTapTimeout() >> 16, (char) (TextUtils.getOffsetBefore("", 0) + 46579), new char[]{12451, 43574, 22631, 13466, 51263, 14539, 26886, 4760, 25574, 42201, 56940, 38106, 19064, 47322, 29049, 43451, 28613, 35960}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{35437, 42564, 3400, 47473}, 1218856074 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (Process.getGidForName("") + 28942), new char[]{29979, 59912, 12410, 51986, 23258}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), Color.green(0) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{39466, 23889, 31045, 19178}, TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{60619, 18038, 34305, 40159, 45377, 29665, 7968, 54863, 63950, 42696, 34449, 53188, 36245, 55339, 11871, 1975, 57470, 4592, 22691, 5403, 17588, 43887, 10116, 62446, 1116, 17897, 42057, 58476, 2569, 62710, 12921, 1658, 25234, 534, 15097, 16676, 9701, 27340, 53428, 62796, 10824, 21590, 15566, 46286, 39365, 22689, 23895, 10015}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{43345, 3998, 63457, 22895}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), new char[]{7915, 64412, 14940, 15869, 2158, 35743, 44529, 13877, 56538, 33635, 16100, 17405, 22129, 64879, 7461, 26112, 34712, 46857, 19260, 63233, 30685, 48026, 48631, 64775, 53828, 48812, 35849, 12639, 45781, 53366, 178, 26186, 18370, 54368, 23870, 35598, 39369, 3460, 29634, 36904, 17420, 30840, 29668, 11891, 1212, 35982, 13006, 46155, 15130, 40436, 41762, 5189, 44682, Typography.registered, 15324, 50522, 26040, 14776, 21561, 55018, 32201, 41234, 15378, 42994}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{42123, 19172, 17071, 40532}, KeyEvent.keyCodeFromString(""), (char) TextUtils.getOffsetBefore("", 0), new char[]{29426, 4072, 12571, 4783, 62510, 11029, 47578, 28324, 49921, 16098, 45666, 61223, 9679, 60140, 53440, 45075, 41329, 24317, 26652, 36333, 44697, 14260, 43047, 60984, 55064, 61409, 7337, 51851, 50347, 40912, 25011, 20798, 41023, 253, 5925, 1530, 16399, 10647, 7067, 63347, 45665, 27504, 53156, 55007, 63271, 46517, 40751, 28485, 20354, 22310, 20445, 55020, 44691, 38989, 61211, 64523, 36447, 37857, 44506, 29117, 51107, 63729, 19836, 5117}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{47261, 6447, 14201, 35783}, ViewConfiguration.getLongPressTimeout() >> 16, (char) (ViewConfiguration.getWindowTouchSlop() >> 8), new char[]{4567, 15207, 65136, 35941, 46286, 37932, 12074, 1999, 26706, 61464, 64620, 62928, 546, 16987, 53578, 17757, 22738, 47502, 27256, 47738, 16576, 23398, 44588, 52826, 52254, 29541, 58793, 53212, 30002, 36509, 53926, 1867, 23060, 44793, 35878, 52249, 58158, 28497, 50151, 16262, 14194, 41577, 35815, 19124, 53624, 56527, 49776, 17157, 61668, 60825, 29504, 45248, 29030, 60449, 16406, 37757, 47350, 49557, 6970, 2813}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{51880, 2496, 14569, 42212}, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 58424), new char[]{8984, 45985, 18989, 27726, 24518, 43753}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), 18 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], 37, objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr15 = new Object[1];
                a(b, (byte) (b + 1), KClassImpl$Data$declaredNonStaticMembers$2[35], objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 56, 3 - TextUtils.indexOf("", ""), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1));
                        Object[] objArr17 = new Object[1];
                        c((byte) (-$$a[53]), $$a[68], $$a[0], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getTouchSlop() >> 8) + 15, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 800, 15 - TextUtils.getOffsetBefore("", 0), (char) Color.green(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 815, 29 - Color.alpha(0), (char) (ImageFormat.getBitsPerPixel(0) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - KeyEvent.keyCodeFromString(""), 16 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-824436140, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], 37, objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr22 = new Object[1];
                a(b2, (byte) (b2 + 1), KClassImpl$Data$declaredNonStaticMembers$2[35], objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 61, ((byte) KeyEvent.getModifierMetaStateMask()) + 47, (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        Object[] objArr24 = new Object[1];
                        c($$a[20], (byte) (-$$a[8]), (byte) (-$$a[9]), objArr24);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-824436140, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], 37, objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr29 = new Object[1];
                a(b3, (byte) (b3 + 1), KClassImpl$Data$declaredNonStaticMembers$2[35], objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (Process.myPid() >> 22), TextUtils.indexOf((CharSequence) "", '0', 0) + 4, (char) ((Process.myTid() >> 22) + 38968));
                        Object[] objArr31 = new Object[1];
                        c($$a[20], (byte) (-$$a[8]), (byte) (-$$a[9]), objArr31);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), TextUtils.getOffsetAfter("", 0) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-824436140, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, 18 - KeyEvent.getDeadChar(0, 0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], 37, objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr36 = new Object[1];
                a(b4, (byte) (b4 + 1), KClassImpl$Data$declaredNonStaticMembers$2[35], objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        byte b5 = (byte) ($$a[0] - 1);
                        byte b6 = b5;
                        Object[] objArr38 = new Object[1];
                        c(b5, b6, b6, objArr38);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-824436140, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{197, 38068, 54088, 33163}, super.getResources().getString(R.string.referral_checkbox_description).substring(2, 3).codePointAt(0) - 110, (char) (super.getResources().getString(R.string.category_entertainment).substring(0, 13).codePointAt(8) + 35685), new char[]{51066, 41872, 46720, 54927, 59841, 14409, 63257, 34260, 46442, 24893, 19061, 25063, 22367, 62573, 32533, 14421, 50460, 29438, 41220, 14300, 28764, 36240, 5360, 44433, 63947, 55571}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{23024, 11499, 19017, 31661}, getPackageName().length() - 7, (char) (44362 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), new char[]{29061, 53775, 16716, 9368, 16097, 42666, 46475, 11123, 59605, 8754, 9313, 54444, 6565, 49206, 7935, 26699, 23049, 24755}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + PDF417Common.NUMBER_OF_CODEWORDS, Process.getGidForName("") + 36, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {197, 38068, 54088, 33163};
            int myPid = Process.myPid() >> 22;
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), objArr2);
                Object[] objArr3 = new Object[1];
                b(cArr, cArr2, myPid, (char) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 35762), new char[]{51066, 41872, 46720, 54927, 59841, 14409, 63257, 34260, 46442, 24893, 19061, 25063, 22367, 62573, 32533, 14421, 50460, 29438, 41220, 14300, 28764, 36240, 5360, 44433, 63947, 55571}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                char[] cArr3 = {0, 0, 0, 0};
                char[] cArr4 = {23024, 11499, 19017, 31661};
                int length = super.getResources().getString(R.string.pay_service).substring(1, 3).length() - 2;
                try {
                    byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                    byte b4 = b3;
                    Object[] objArr4 = new Object[1];
                    a(b3, b4, b4, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a(KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), objArr5);
                    Object[] objArr6 = new Object[1];
                    b(cArr3, cArr4, length, (char) (((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 44329), new char[]{29061, 53775, 16716, 9368, 16097, 42666, 46475, 11123, 59605, 8754, 9313, 54444, 6565, 49206, 7935, 26699, 23049, 24755}, objArr6);
                    baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 910, 17 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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

    static {
        PlaceComponentResult();
        logger = LoggerFactory.getLogger(OrmLiteBaseActivity.class);
    }

    public H getHelper() {
        if (this.helper == null) {
            if (!this.created) {
                throw new IllegalStateException("A call has not been made to onCreate() yet so the helper is null");
            }
            if (this.destroyed) {
                throw new IllegalStateException("A call to onDestroy has already been made and the helper cannot be used after that point");
            }
            throw new IllegalStateException("Helper is null for some unknown reason");
        }
        return this.helper;
    }

    public ConnectionSource getConnectionSource() {
        return getHelper().getConnectionSource();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object[] objArr;
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {45005, 30737, 62271, 23477};
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a(KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), new Object[1]);
            Object[] objArr3 = new Object[1];
            b(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.card_binding_oneklik_header).substring(1, 2).length() + 46578), new char[]{12451, 43574, 22631, 13466, 51263, 14539, 26886, 4760, 25574, 42201, 56940, 38106, 19064, 47322, 29049, 43451, 28613, 35960}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            char[] cArr3 = {0, 0, 0, 0};
            char[] cArr4 = {35437, 42564, 3400, 47473};
            int length = getPackageName().length() + 1218856067;
            try {
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                byte b4 = b3;
                Object[] objArr4 = new Object[1];
                a(b3, b4, b4, objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), objArr5);
                Object[] objArr6 = new Object[1];
                b(cArr3, cArr4, length, (char) (((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 28908), new char[]{29979, 59912, 12410, 51986, 23258}, objArr6);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        char[] cArr5 = {0, 0, 0, 0};
                        char[] cArr6 = {197, 38068, 54088, 33163};
                        try {
                            byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                            byte b6 = b5;
                            Object[] objArr7 = new Object[1];
                            a(b5, b6, b6, objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            a(KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), new Object[1]);
                            Object[] objArr8 = new Object[1];
                            b(cArr5, cArr6, ((ApplicationInfo) cls4.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.continue_without_promo).substring(2, 3).length() + 35794), new char[]{51066, 41872, 46720, 54927, 59841, 14409, 63257, 34260, 46442, 24893, 19061, 25063, 22367, 62573, 32533, 14421, 50460, 29438, 41220, 14300, 28764, 36240, 5360, 44433, 63947, 55571}, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            b(new char[]{0, 0, 0, 0}, new char[]{23024, 11499, 19017, 31661}, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1, (char) (44362 - ExpandableListView.getPackedPositionGroup(0L)), new char[]{29061, 53775, 16716, 9368, 16097, 42666, 46475, 11123, 59605, 8754, 9313, 54444, 6565, 49206, 7935, 26699, 23049, 24755}, objArr9);
                            baseContext = (Context) cls5.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            char[] cArr7 = {0, 0, 0, 0};
                            char[] cArr8 = {39466, 23889, 31045, 19178};
                            try {
                                byte b7 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                byte b8 = b7;
                                Object[] objArr10 = new Object[1];
                                a(b7, b8, b8, objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                a(KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), new Object[1]);
                                Object[] objArr11 = new Object[1];
                                b(cArr7, cArr8, ((ApplicationInfo) cls6.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.nearby_search_merchant_page_title).substring(0, 8).codePointAt(2) - 114), new char[]{60619, 18038, 34305, 40159, 45377, 29665, 7968, 54863, 63950, 42696, 34449, 53188, 36245, 55339, 11871, 1975, 57470, 4592, 22691, 5403, 17588, 43887, 10116, 62446, 1116, 17897, 42057, 58476, 2569, 62710, 12921, 1658, 25234, 534, 15097, 16676, 9701, 27340, 53428, 62796, 10824, 21590, 15566, 46286, 39365, 22689, 23895, 10015}, objArr11);
                                String str = (String) objArr11[0];
                                Object[] objArr12 = new Object[1];
                                b(new char[]{0, 0, 0, 0}, new char[]{43345, 3998, 63457, 22895}, ViewConfiguration.getKeyRepeatTimeout() >> 16, (char) (getPackageName().codePointAt(4) - 97), new char[]{7915, 64412, 14940, 15869, 2158, 35743, 44529, 13877, 56538, 33635, 16100, 17405, 22129, 64879, 7461, 26112, 34712, 46857, 19260, 63233, 30685, 48026, 48631, 64775, 53828, 48812, 35849, 12639, 45781, 53366, 178, 26186, 18370, 54368, 23870, 35598, 39369, 3460, 29634, 36904, 17420, 30840, 29668, 11891, 1212, 35982, 13006, 46155, 15130, 40436, 41762, 5189, 44682, Typography.registered, 15324, 50522, 26040, 14776, 21561, 55018, 32201, 41234, 15378, 42994}, objArr12);
                                String str2 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                b(new char[]{0, 0, 0, 0}, new char[]{42123, 19172, 17071, 40532}, super.getResources().getString(R.string.saving_travel).substring(0, 6).length() - 6, (char) (super.getResources().getString(R.string.zface_bad_brightness).substring(0, 1).codePointAt(0) - 84), new char[]{29426, 4072, 12571, 4783, 62510, 11029, 47578, 28324, 49921, 16098, 45666, 61223, 9679, 60140, 53440, 45075, 41329, 24317, 26652, 36333, 44697, 14260, 43047, 60984, 55064, 61409, 7337, 51851, 50347, 40912, 25011, 20798, 41023, 253, 5925, 1530, 16399, 10647, 7067, 63347, 45665, 27504, 53156, 55007, 63271, 46517, 40751, 28485, 20354, 22310, 20445, 55020, 44691, 38989, 61211, 64523, 36447, 37857, 44506, 29117, 51107, 63729, 19836, 5117}, objArr13);
                                String str3 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                b(new char[]{0, 0, 0, 0}, new char[]{47261, 6447, 14201, 35783}, (-1) - Process.getGidForName(""), (char) (getPackageName().codePointAt(2) - 46), new char[]{4567, 15207, 65136, 35941, 46286, 37932, 12074, 1999, 26706, 61464, 64620, 62928, 546, 16987, 53578, 17757, 22738, 47502, 27256, 47738, 16576, 23398, 44588, 52826, 52254, 29541, 58793, 53212, 30002, 36509, 53926, 1867, 23060, 44793, 35878, 52249, 58158, 28497, 50151, 16262, 14194, 41577, 35815, 19124, 53624, 56527, 49776, 17157, 61668, 60825, 29504, 45248, 29030, 60449, 16406, 37757, 47350, 49557, 6970, 2813}, objArr14);
                                String str4 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                b(new char[]{0, 0, 0, 0}, new char[]{51880, 2496, 14569, 42212}, Color.alpha(0), (char) (View.resolveSize(0, 0) + 58424), new char[]{8984, 45985, 18989, 27726, 24518, 43753}, objArr15);
                                try {
                                    Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr16);
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
                    }
                }
                try {
                    Object[] objArr17 = new Object[1];
                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], 37, objArr17);
                    Class<?> cls7 = Class.forName((String) objArr17[0]);
                    byte b9 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                    Object[] objArr18 = new Object[1];
                    a(b9, (byte) (b9 + 1), KClassImpl$Data$declaredNonStaticMembers$2[35], objArr18);
                    try {
                        Object[] objArr19 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 446, View.MeasureSpec.getSize(0) + 4, (char) View.MeasureSpec.getSize(0));
                            byte b10 = (byte) ($$a[0] - 1);
                            byte b11 = b10;
                            Object[] objArr20 = new Object[1];
                            c(b10, b11, b11, objArr20);
                            obj3 = cls8.getMethod((String) objArr20[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                        int i = ((int[]) objArr21[1])[0];
                        if (((int[]) objArr21[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (-16777181) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr22 = {-2033951131, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr22);
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
                        if (this.helper == null) {
                            this.helper = getHelperInternal(this);
                            this.created = true;
                        }
                        super.onCreate(bundle);
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
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        releaseHelper(this.helper);
        this.destroyed = true;
    }

    protected H getHelperInternal(Context context) {
        H h = (H) OpenHelperManager.getHelper(context);
        logger.trace("{}: got new helper {} from OpenHelperManager", this, h);
        return h;
    }

    protected void releaseHelper(H h) {
        OpenHelperManager.releaseHelper();
        logger.trace("{}: helper {} was released, set to null", this, h);
        this.helper = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(Integer.toHexString(super.hashCode()));
        return sb.toString();
    }

    private static void b(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getAuthRequestContext ^ 4360990799332652212L)) ^ ((int) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L))) ^ ((char) (MyBillsEntityDataFactory ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
