package id.dana.myprofile;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.UtdIdUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

/* loaded from: classes5.dex */
public class EasterEggActivity extends BaseActivity {
    public static final String EGG_MESSAGE = "egg_message";
    public static final String INFO_COPY = "info_copy";
    @BindView(R.id.activity_egg_text)
    TextView contentDisplay;
    public static final byte[] $$a = {18, 119, 36, -59, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 45;
    public static final byte[] getAuthRequestContext = {15, -40, -114, -21, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 172;
    private static char[] getErrorConfigVersion = {32326, 49142, 64829, 15208, 30900, 46837, 62521, 12848, 29630, 45536, 61217, 11580, 27282, 43255, 58913, 9343, 26017, 41953, 57661, 8051, 23711, 39652, 55359, 5739, 22446, 38372, 42598, 26575, 9481, 58186, 41116, 28368, 11275, 60029, 43917, 27074, 14111, 62809, 45714, 28887, 15875, 64605, 48538, 31684, 34104, 17544, 1603, 49174, 33738, 19851, 3911, 51534, 35022, 19101, 5121, 54844, 37343, 21381, 7496, 57101, 40666, 22661, 7561, 56354, 40655, 22704, 7036, 62329, 12946, 28678, 46667, 62850, 15249, 30989, 48975, 65153, 15516, 25179, 40989, 59359, 9679, 27405, 43337, 59535, 11984, 27670, 37378, 53702, 6022, 21831, 39761, 56002, 6362, 24080, 39951, 50072, 393, 18253, 34058, 50327, 2791, 18466, 36458, 52724, 62444, 12588, 30567, 46753, 62655, 14892, 30829, 49144, 65006, 9002, 24890, 21979, 37936, 55026, 4323, 21280, 40248, 57328, 6587, 22566, 39534, 50421, 1722, 16682, 33592, 52729, 4031, 20088, 34855, 51890, 13478, 30514, 45344, 62438, 15776, 31844, 48767, 63717, 15098, 25958, 42877, 57834, 9129, 25145, 44097, 61136, 10399, 27397, 21826, 38864, 53648, 4183, 21021, 40073, 56990, 6413, 23326, 34265, 51100, 1625, 16390, 33475, 52366, 3919, 18694, 35776, 62850, 13378, 30220, 45215, 62173, 15695, 32513, 47516, 64392, 3300, 52568, 36813, 18825, 2579, 50266, 34462, 16603, 278, 50009, 40344, 24530, 6163, 55894, 38036, 22224, 5959, 53532, 37772, 28063, 11784, 59423, 43741, 25804, 9481, 59159, 41353, 25547, 15444, 65043, 47235, 31380, 15105, 62765, 47034, 29171, 12904, 3194, 52922, 35063, 18742, 2855, 50609, 34807, 16442, 629, 56549, 40613, 24416, 6496, 56315, 38334, 22056, 4204, 54010, 44266, 27945, 12132, 59817, 44005, 25716, 9824, 57505, 41710, 62246, 12933, 28740, 46595, 62913, 15311, 31003, 48984, 65234, 15512, 25174, 40986, 59284, 9609, 27476, 43277, 59611, 11904, 27732, 37376, 53699, 6038, 21840, 39753, 56001, 6300, 24137, 39961, 50126, 414, 18269, 34074, 50383, 2723, 18549, 36477, 52721, 62394, 12665, 30584, 46839, 62633, 14961, 30836, 49139, 64947, 9083, 24890, 41197, 59061, 9263, 27189, 43440, 61418, 11617, 21297, 37603, 53415, 5756, 21560, 6767, 56263, 39196, 24389, 7320, 53980};
    private static long lookAheadTest = 1279088294519976689L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 55 - r7
            byte[] r0 = id.dana.myprofile.EasterEggActivity.getAuthRequestContext
            int r8 = 23 - r8
            int r6 = r6 + 97
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L14:
            r3 = 0
        L15:
            r5 = r7
            r7 = r6
            r6 = r5
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r6 = r6 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.EasterEggActivity.b(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = r9 + 21
            int r8 = r8 + 4
            byte[] r0 = id.dana.myprofile.EasterEggActivity.$$a
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L39
        L1a:
            r3 = 0
        L1b:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L39:
            int r8 = r8 + 1
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.EasterEggActivity.c(short, short, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((-16777198) - Color.rgb(0, 0, 0), 44 - TextUtils.getCapsMode("", 0, 0), (char) (30231 - Color.alpha(0)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((Process.myPid() >> 22) + 5, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 62, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 61099), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(MotionEvent.axisFromString("") + 49, (ViewConfiguration.getEdgeSlop() >> 16) + 67, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(KeyEvent.getDeadChar(0, 0) + 64, TextUtils.getTrimmedLength("") + 115, (char) (42739 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 63, 179 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (65432 - (Process.myPid() >> 22)), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(View.resolveSize(0, 0) + 60, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 243, (char) (ExpandableListView.getPackedPositionChild(0L) + 1), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(TextUtils.lastIndexOf("", '0', 0) + 7, KeyEvent.getDeadChar(0, 0) + 303, (char) (Process.getGidForName("") + 59673), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = new Object[1];
                b(getAuthRequestContext[32], getAuthRequestContext[0], (byte) (-getAuthRequestContext[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult & 26);
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 22), (byte) (-getAuthRequestContext[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - KeyEvent.getDeadChar(0, 0), 3 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], (byte) ($$a[78] - 1), $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), Gravity.getAbsoluteGravity(0, 0) + 15, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 800, TextUtils.getOffsetBefore("", 0) + 15, (char) TextUtils.indexOf("", ""))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - KeyEvent.keyCodeFromString(""), 29 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (Gravity.getAbsoluteGravity(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), 35 - Gravity.getAbsoluteGravity(0, 0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1207093697, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                Object[] objArr19 = new Object[1];
                b(getAuthRequestContext[32], getAuthRequestContext[0], (byte) (-getAuthRequestContext[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (PlaceComponentResult & 26);
                Object[] objArr20 = new Object[1];
                b(b2, (byte) (b2 | 22), (byte) (-getAuthRequestContext[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.combineMeasuredStates(0, 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 46, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b3, (byte) (b3 | Ascii.ETB), (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1207093697, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
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
                Object[] objArr25 = new Object[1];
                b(getAuthRequestContext[32], getAuthRequestContext[0], (byte) (-getAuthRequestContext[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b4 = (byte) (PlaceComponentResult & 26);
                Object[] objArr26 = new Object[1];
                b(b4, (byte) (b4 | 22), (byte) (-getAuthRequestContext[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - ((Process.getThreadPriority(0) + 20) >> 6), 3 - Gravity.getAbsoluteGravity(0, 0), (char) (38969 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b5, (byte) (b5 | Ascii.ETB), (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), TextUtils.indexOf((CharSequence) "", '0') + 36, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1207093697, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), MotionEvent.axisFromString("") + 19, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
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
                Object[] objArr31 = new Object[1];
                b(getAuthRequestContext[32], getAuthRequestContext[0], (byte) (-getAuthRequestContext[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b6 = (byte) (PlaceComponentResult & 26);
                Object[] objArr32 = new Object[1];
                b(b6, (byte) (b6 | 22), (byte) (-getAuthRequestContext[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 3, (char) ExpandableListView.getPackedPositionType(0L));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], $$a[53], $$a[8], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1207093697, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, 18 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        return R.layout.activity_easter_egg;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(getPackageName().length() + 11, 43 - TextUtils.lastIndexOf("", '0', 0), (char) (30231 - (KeyEvent.getMaxKeyCode() >> 16)), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        int threadPriority = 5 - ((Process.getThreadPriority(0) + 20) >> 6);
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr3 = new Object[1];
            b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr4);
            Object[] objArr5 = new Object[1];
            a(threadPriority, ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 29, (char) (super.getResources().getString(R.string.mixpay_paymethod_combination).substring(12, 13).codePointAt(0) + 61066), objArr5);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        byte b2 = getAuthRequestContext[25];
                        Object[] objArr6 = new Object[1];
                        b(b2, (byte) (b2 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 7, getPackageName().length() - 7, (char) (36201 - Color.red(0)), objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.username_guidelines).substring(10, 12).length() + 16, getPackageName().length() + 19, (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 21835), objArr8);
                        baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 35 - KeyEvent.normalizeMetaState(0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int maximumFlingVelocity = 48 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        int indexOf = 66 - TextUtils.indexOf((CharSequence) "", '0', 0);
                        try {
                            byte b3 = getAuthRequestContext[25];
                            Object[] objArr9 = new Object[1];
                            b(b3, (byte) (b3 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            a(maximumFlingVelocity, indexOf, (char) (((ApplicationInfo) cls5.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), objArr10);
                            String str = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            a(super.getResources().getString(R.string.passkey_faq_two_title).substring(2, 3).length() + 63, 115 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (42740 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), objArr11);
                            String str2 = (String) objArr11[0];
                            int packedPositionChild = 63 - ExpandableListView.getPackedPositionChild(0L);
                            int codePointAt = super.getResources().getString(R.string.balance_title).substring(1, 3).codePointAt(0) + 82;
                            try {
                                byte b4 = getAuthRequestContext[25];
                                Object[] objArr12 = new Object[1];
                                b(b4, (byte) (b4 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr12);
                                Class<?> cls6 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr13);
                                Object[] objArr14 = new Object[1];
                                a(packedPositionChild, codePointAt, (char) (((ApplicationInfo) cls6.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 65399), objArr14);
                                String str3 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                a(super.getResources().getString(R.string.lbl_account_deactivation_description).substring(14, 16).codePointAt(0) - 49, super.getResources().getString(R.string.twilio_success_dialog_title).substring(5, 6).codePointAt(0) + 128, (char) (getPackageName().codePointAt(1) - 100), objArr15);
                                String str4 = (String) objArr15[0];
                                int i = 7 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                try {
                                    byte b5 = getAuthRequestContext[25];
                                    Object[] objArr16 = new Object[1];
                                    b(b5, (byte) (b5 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr16);
                                    Class<?> cls7 = Class.forName((String) objArr16[0]);
                                    Object[] objArr17 = new Object[1];
                                    b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr17);
                                    int i2 = ((ApplicationInfo) cls7.getMethod((String) objArr17[0], null).invoke(this, null)).targetSdkVersion + 270;
                                    try {
                                        byte b6 = getAuthRequestContext[25];
                                        Object[] objArr18 = new Object[1];
                                        b(b6, (byte) (b6 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr18);
                                        Class<?> cls8 = Class.forName((String) objArr18[0]);
                                        Object[] objArr19 = new Object[1];
                                        b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr19);
                                        Object[] objArr20 = new Object[1];
                                        a(i, i2, (char) (((ApplicationInfo) cls8.getMethod((String) objArr19[0], null).invoke(this, null)).targetSdkVersion + 59639), objArr20);
                                        try {
                                            Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) TextUtils.indexOf("", ""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr21);
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
            }
            try {
                Object[] objArr22 = new Object[1];
                b(getAuthRequestContext[32], getAuthRequestContext[0], (byte) (-getAuthRequestContext[30]), objArr22);
                Class<?> cls9 = Class.forName((String) objArr22[0]);
                byte b7 = (byte) (PlaceComponentResult & 26);
                Object[] objArr23 = new Object[1];
                b(b7, (byte) (b7 | 22), (byte) (-getAuthRequestContext[30]), objArr23);
                try {
                    Object[] objArr24 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 495, 3 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) TextUtils.indexOf("", "", 0));
                        Object[] objArr25 = new Object[1];
                        c($$a[9], $$a[53], $$a[8], objArr25);
                        obj3 = cls10.getMethod((String) objArr25[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr26 = (Object[]) ((Method) obj3).invoke(null, objArr24);
                    int i3 = ((int[]) objArr26[1])[0];
                    if (((int[]) objArr26[0])[0] != i3) {
                        long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr27 = {-849460882, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), (-16777198) - Color.rgb(0, 0, 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr27);
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
                    super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.popup_otp_title).substring(1, 5).length() + 22, super.getResources().getString(R.string.card_detail_empty_desc).substring(21, 22).length() - 1, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 36201), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(18 - (ViewConfiguration.getLongPressTimeout() >> 16), getPackageName().length() + 19, (char) (super.getResources().getString(R.string.api_limit_error_message).substring(0, 1).length() + 21834), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int scrollBarSize = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 33;
                try {
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr3 = new Object[1];
                    b(b2, (byte) (b2 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr4);
                    char c = (char) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 36168);
                    Object[] objArr5 = new Object[1];
                    a(scrollBarSize, i, c, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    int length = super.getResources().getString(R.string.allow_contact_access).substring(13, 14).length() + 17;
                    try {
                        byte b3 = getAuthRequestContext[25];
                        Object[] objArr6 = new Object[1];
                        b(b3, (byte) (b3 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr7);
                        int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion - 7;
                        try {
                            byte b4 = getAuthRequestContext[25];
                            Object[] objArr8 = new Object[1];
                            b(b4, (byte) (b4 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr9);
                            Object[] objArr10 = new Object[1];
                            a(length, i2, (char) (((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 21802), objArr10);
                            baseContext = (Context) cls3.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr11 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr11);
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
        super.onResume();
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setToolbarImage(R.drawable.logo_dana_white);
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        try {
            this.contentDisplay.setText(getIntent().getStringExtra("egg_message"));
            getAuthRequestContext("reference", BuiltInFictitiousFunctionClassFactory() ? getIntent().getStringExtra(INFO_COPY) : UtdIdUtil.MyBillsEntityDataFactory(), 0);
        } catch (Exception unused) {
        }
    }

    @OnClick({R.id.activity_egg_confirm})
    public void onConfirmButtonClick() {
        finish();
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return (getIntent() == null || !getIntent().hasExtra(INFO_COPY) || TextUtils.isEmpty(getIntent().getStringExtra(INFO_COPY))) ? false : true;
    }

    @OnClick({R.id.activity_egg_text})
    public void onTextLongClick() {
        getAuthRequestContext("dana_app_info", this.contentDisplay.getText().toString(), R.string.easter_egg_copyclipboard);
    }

    private void getAuthRequestContext(String str, String str2, int i) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(str, str2));
                if (i != 0) {
                    Toast.makeText(this, i, 0).show();
                }
            }
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.UTDID_UTIL_TAG, DanaLogConstants.Prefix.COPY_CLIPBOARD, e);
        }
    }

    @OnClick({R.id.activity_egg_copy})
    public void onCopyButtonClick() {
        getAuthRequestContext("reference", BuiltInFictitiousFunctionClassFactory() ? getIntent().getStringExtra(INFO_COPY) : UtdIdUtil.MyBillsEntityDataFactory(), R.string.easter_egg_reference_copy);
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getErrorConfigVersion[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ lookAheadTest))) ^ c;
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
