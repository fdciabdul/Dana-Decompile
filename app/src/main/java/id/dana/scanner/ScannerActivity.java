package id.dana.scanner;

import android.content.Context;
import android.content.Intent;
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
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

/* loaded from: classes3.dex */
public class ScannerActivity extends BaseActivity {
    public static final String APP_ID = "APP_ID";
    public static final String CLOSE_AFTER_SCAN = "CLOSE_AFTER_SCAN";
    public static final String CODE_CONSUMER = "CODE_CONSUMER";
    public static final String FROM_VIEW_TYPE = "from_view_type";
    public static final String KYB_CPM = "kyb_cpm";
    public static final String RESPONSE_CODE = "code";
    public static final String RESPONSE_SUCCESS = "success";
    public static final String SCENE = "scene";
    public static final String SERVICE_KEY = "SERVICE_KEY";
    ScannerFragment scannerFragment;
    public static final byte[] $$a = {8, -125, -40, -38, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 138;
    public static final byte[] getAuthRequestContext = {108, 11, -123, -39, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 165;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {63976, 45863, 27757, 6587, 53990, 35872, 14701, 62183, 45032, 22841, 4729, 53223, 30920, 12842, 61309, 39072, 22015, 3872, 47229, 30128, 11997, 55329, 38267, 20140, 64488, 46381, 52057, 33167, 24264, 11016, 57439, 48788, 3022, 49211, 40266, 27530, 8406, 64787, 19033, 155, 56782, 43539, 26453, 15764, 16338, 29981, 43607, 57217, 5340, 18970, 65367, 13533, 27100, 40704, 54301, 2467, 48833, 62492, 10576, 24214, 37824, 51456, 7718, 21746, 35742, 65122, 13615, 62329, 47597, 26360, 4918, 55422, 34538, 13303, 63542, 42361, 21483, 6317, 50536, 29227, 14524, 58879, 37432, 24447, 1471, 45816, 32623, 9258, 53997, 40877, 17464, 61738, 49085, 25846, 4458, 56956, 34026, 12719, 65131, 43895, 20920, 7932, 52023, 28712, 16055, 60406, 36926, 23929, 3048, 45306, 32056, 10796, 53437, 40440, 19051, 47642, 61582, 12237, 23135, 37149, 53122, 31435, 45315, 60447, 6872, 20930, 35854, 15135, 29066, 44234, 56079, 5705, 19593, 64413, 13834, 27935, 39818, 54989, 3336, 47181, 63193, 11714, 22622, 38723, 52703, 30921, 46857, 57880, 6367, 22479, 33283, 14616, 30680, 41675, 55560, 5198, 17035, 63902, 13322, 25368, 39308, 54474, 780, 48712, 62600, 9164, 24066, 38210, 50060, 32459, 46346, 57419, 7818, 21912, 32857, 16202, 30083, 41119, 57096, 62332, 47551, 26283, 4972, 55415, 34489, 13308, 63546, 42358, 21430, 6390, 50495, 29311, 14525, 58878, 37433, 24367, 1515, 45818, 32618, 9340, 53996, 40879, 17469, 61817, 49128, 25847, 4406, 56872, 34024, 12793, 65133, 43897, 20970, 7932, 52022, 28716, 16057, 60408, 36918, 23926, 3048, 45311, 32058, 10870, 53438, 40367, 19052, 63272, 48567, 27309, 5995, 56444, 35519, 14248, 64571, 43385, 22459, 7415, 51512, 30248, 15547, 59899, 38455, 63473, 48429, 25197, 6057, 56554, 33379, 14134, 64758, 41469, 22328, 7287, 49592, 30391, 15405, 57713, 38571, 23548, 312, 46701, 31674, 8440, 54826, 39789, 16631, 62974, 47916, 24696, 5547, 56061, 32810, 13672, 64172, 45048, 21803, 6780, 53239, 29946, 14902, 61300, 38134, 23032, 3881, 46192, 31222, 12016, 54327, 39294, 20156, 62442, 47405, 28214, 5039, 55467, 36470, 13180, 63663, 44540, 21303, 6253, 52650, 62327, 47520, 26362, 4896, 55420, 34495};
    private static long lookAheadTest = 6595940271827499406L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 55 - r7
            int r8 = 106 - r8
            byte[] r0 = id.dana.scanner.ScannerActivity.getAuthRequestContext
            int r6 = r6 + 16
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L17:
            r3 = 0
        L18:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r8 = r8 + r6
            int r8 = r8 + (-4)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.scanner.ScannerActivity.b(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r0 = id.dana.scanner.ScannerActivity.$$a
            int r6 = 46 - r6
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            int r3 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.scanner.ScannerActivity.c(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((-16777198) - Color.rgb(0, 0, 0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 44, (char) (View.combineMeasuredStates(0, 0) + 52477), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(6 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), KeyEvent.keyCodeFromString("") + 62, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 60677), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.argb(0, 0, 0, 0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 67 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 115, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 18740), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(MotionEvent.axisFromString("") + 65, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 178, (char) Color.alpha(0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((-16777156) - Color.rgb(0, 0, 0), 243 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (View.getDefaultSize(0, 0) + 1239), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - View.MeasureSpec.getSize(0), Color.blue(0) + 303, (char) Color.green(0), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | Ascii.RS), getAuthRequestContext[7], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getTouchSlop() >> 8), TextUtils.indexOf("", "") + 3, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        byte b2 = $$a[53];
                        byte b3 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b2, b3, b3, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.blue(0), 15 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getOffsetBefore("", 0), 15 - View.MeasureSpec.getSize(0), (char) Color.red(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778031, TextUtils.lastIndexOf("", '0', 0, 0) + 30, (char) (TextUtils.indexOf((CharSequence) "", '0') + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 800, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) ExpandableListView.getPackedPositionGroup(0L)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 35, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1204676835, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                b(b4, (byte) (b4 | Ascii.RS), getAuthRequestContext[7], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 61, View.getDefaultSize(0, 0) + 46, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1));
                        Object[] objArr22 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), $$a[9], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), 35 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1204676835, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), View.MeasureSpec.getMode(0) + 18, (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                b(b5, (byte) (b5 | Ascii.RS), getAuthRequestContext[7], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (Process.myTid() >> 22), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 3, (char) (38968 - View.MeasureSpec.getSize(0)));
                        Object[] objArr28 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), $$a[9], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), 35 - Color.red(0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1204676835, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), TextUtils.lastIndexOf("", '0') + 19, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b6 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                b(b6, (byte) (b6 | Ascii.RS), getAuthRequestContext[7], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 108, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 3, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], (byte) ($$a[78] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1204676835, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - KeyEvent.keyCodeFromString(""), (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
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
        return R.layout.activity_scanner;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        int codePointAt = super.getResources().getString(R.string.feed_comment_report_success_toast_message).substring(0, 1).codePointAt(0) - 66;
        int codePointAt2 = getPackageName().codePointAt(2) - 2;
        try {
            Object[] objArr2 = new Object[1];
            b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(getAuthRequestContext[56], getAuthRequestContext[25], getAuthRequestContext[13], objArr3);
            Object[] objArr4 = new Object[1];
            a(codePointAt, codePointAt2, (char) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 52444), objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            a(super.getResources().getString(R.string.mybills_detail_family_member_count).substring(0, 3).length() + 2, (ViewConfiguration.getLongPressTimeout() >> 16) + 62, (char) (super.getResources().getString(R.string.allbiller_x2b_desc).substring(32, 38).length() + 60671), objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    int blue = Color.blue(0) + 26;
                    int i = 1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    try {
                        Object[] objArr6 = new Object[1];
                        b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(getAuthRequestContext[56], getAuthRequestContext[25], getAuthRequestContext[13], objArr7);
                        Object[] objArr8 = new Object[1];
                        a(blue, i, (char) (((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 2726), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 25, (char) (super.getResources().getString(R.string.updated).substring(0, 7).length() + 14445), objArr9);
                        baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int indexOf = TextUtils.indexOf("", "", 0) + 48;
                        try {
                            Object[] objArr10 = new Object[1];
                            b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], objArr10);
                            Class<?> cls5 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            b(getAuthRequestContext[56], getAuthRequestContext[25], getAuthRequestContext[13], objArr11);
                            Object[] objArr12 = new Object[1];
                            a(indexOf, ((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 34, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)), objArr12);
                            String str = (String) objArr12[0];
                            try {
                                Object[] objArr13 = new Object[1];
                                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], objArr13);
                                Class<?> cls6 = Class.forName((String) objArr13[0]);
                                Object[] objArr14 = new Object[1];
                                b(getAuthRequestContext[56], getAuthRequestContext[25], getAuthRequestContext[13], objArr14);
                                int i2 = ((ApplicationInfo) cls6.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 31;
                                try {
                                    Object[] objArr15 = new Object[1];
                                    b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], objArr15);
                                    Class<?> cls7 = Class.forName((String) objArr15[0]);
                                    Object[] objArr16 = new Object[1];
                                    b(getAuthRequestContext[56], getAuthRequestContext[25], getAuthRequestContext[13], objArr16);
                                    Object[] objArr17 = new Object[1];
                                    a(i2, ((ApplicationInfo) cls7.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 82, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 18740), objArr17);
                                    String str2 = (String) objArr17[0];
                                    Object[] objArr18 = new Object[1];
                                    a(getPackageName().length() + 57, super.getResources().getString(R.string.financial_header_total_assets).substring(0, 9).length() + 170, (char) (getPackageName().codePointAt(2) - 46), objArr18);
                                    String str3 = (String) objArr18[0];
                                    Object[] objArr19 = new Object[1];
                                    a(super.getResources().getString(R.string.block_friendship_profile).substring(0, 3).length() + 57, super.getResources().getString(R.string.mybills_edit_period_bill_total).substring(0, 3).codePointAt(0) + 206, (char) (super.getResources().getString(R.string.onboarding_permission_location_first).substring(5, 6).codePointAt(0) + 1129), objArr19);
                                    String str4 = (String) objArr19[0];
                                    Object[] objArr20 = new Object[1];
                                    a(getPackageName().codePointAt(3) - 94, 303 - Color.alpha(0), (char) (super.getResources().getString(R.string.passkey_faq_three_title).substring(14, 15).codePointAt(0) - 32), objArr20);
                                    try {
                                        Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), Color.argb(0, 0, 0, 0) + 18, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                }
            }
            try {
                Object[] objArr22 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[31], getAuthRequestContext[25], objArr22);
                Class<?> cls8 = Class.forName((String) objArr22[0]);
                byte b = getAuthRequestContext[25];
                Object[] objArr23 = new Object[1];
                b(b, (byte) (b | Ascii.RS), getAuthRequestContext[7], objArr23);
                try {
                    Object[] objArr24 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.lastIndexOf("", '0'), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 4, (char) ExpandableListView.getPackedPositionGroup(0L));
                        Object[] objArr25 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], (byte) ($$a[78] - 1), objArr25);
                        obj3 = cls9.getMethod((String) objArr25[0], Integer.TYPE);
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
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr27 = {-1089108246, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (Process.myPid() >> 22) + 18, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(3) - 74, getPackageName().codePointAt(3) - 100, (char) (super.getResources().getString(R.string.otp_sent_to_your_bank_number).substring(1, 5).length() + 2755), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int packedPositionType = 18 - ExpandableListView.getPackedPositionType(0L);
            int maxKeyCode = 26 - (KeyEvent.getMaxKeyCode() >> 16);
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[56], getAuthRequestContext[25], getAuthRequestContext[13], objArr3);
                Object[] objArr4 = new Object[1];
                a(packedPositionType, maxKeyCode, (char) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 14419), objArr4);
                baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, TextUtils.getOffsetAfter("", 0) + 18, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int i = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
            try {
                Object[] objArr = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(getAuthRequestContext[56], getAuthRequestContext[25], getAuthRequestContext[13], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(i, ((ApplicationInfo) cls.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.family_member_transaction_limit_slider_max).substring(0, 2).codePointAt(1) + 2662), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length = super.getResources().getString(R.string.bottom_on_boarding_subtitle_split_bill_third).substring(4, 5).length() + 17;
                try {
                    Object[] objArr3 = new Object[1];
                    b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b(getAuthRequestContext[56], getAuthRequestContext[25], getAuthRequestContext[13], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(length, ((ApplicationInfo) cls3.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 7, (char) (getPackageName().length() + 14445), objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.getDefaultSize(0, 0) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) Color.blue(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.base.BaseActivity
    public void init() {
        CameraReadyTimeHelper.BuiltInFictitiousFunctionClassFactory();
        getWindow().setBackgroundDrawable(null);
        this.scannerFragment = (ScannerFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentScanner);
        this.scannerFragment.getErrorConfigVersion = getIntent().getStringExtra("scene");
        DanaApplication danaApplication = getDanaApplication();
        if (danaApplication != null) {
            danaApplication.chckTmprdApp();
        }
    }

    public static Intent createIntentScannerActivityForKybCpm(Context context, String str) {
        Intent intent = new Intent(context, ScannerActivity.class);
        intent.putExtra("kyb_cpm", true);
        intent.putExtra(KybCpmConstants.KEY_INPUT_AMOUNT, str);
        return intent;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (NetworkUserEntityData$$ExternalSyntheticLambda0[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ lookAheadTest))) ^ c;
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
