package com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.ant.AUSegment;
import com.alibaba.griver.ui.ant.AUTitleBar;
import com.alibaba.griver.ui.ant.helper.ItemCategory;
import com.alibaba.griver.ui.ant.layout.AULinearLayout;
import com.alibaba.griver.ui.ant.listview.AUListView;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes2.dex */
public class MultilevelSelectActivity extends FragmentActivity {
    public static volatile MultilevelSelectCallBack multilevelSelectCallBack;

    /* renamed from: a  reason: collision with root package name */
    private String f6712a;
    private String b;
    private JSONArray c;
    private JSONArray d;
    private JSONArray e = new JSONArray();
    private int f;
    protected AULinearLayout mContainer;
    protected AUListView mListView;
    protected AUSegment mSegemnt;
    protected AUTitleBar mTitleBar;
    public static final byte[] $$a = {62, -79, -77, -78, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 219;
    public static final byte[] PlaceComponentResult = {104, -68, 0, 44, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 252;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 887959747309795938L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            byte[] r0 = com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectActivity.PlaceComponentResult
            int r8 = r8 + 16
            int r6 = r6 + 97
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r7 = r7 + 1
            r3 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r8 = r8 + r7
            int r7 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectActivity.h(byte, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = r9 + 21
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectActivity.$$a
            int r7 = 47 - r7
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
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
        L36:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectActivity.j(byte, byte, int, java.lang.Object[]):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{21069, 21036, 9782, 37330, 52576, 11809, 41488, 2253, 35850, 46061, 32824, 10953, 61042, 21919, 58922, 52383, 51271, 29787, 50319, 61266, 10910, 5743}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(TextUtils.getOffsetAfter("", 0), new char[]{39686, 39787, 46526, 589, 55552, 20540, 46657, 30411, 17738}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - MotionEvent.axisFromString(""), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{2506, 2557, 47793, 3416, 17466, 38427, 11032, 45245, 55250, 12135, 2367, 37605, 46509, 51470, 28477, 29843, 37847, 59521, 19847, 22331, 29019, 35498, 41912, 2372, 24422, 46208, 33157, 60235, 15710, 22264, 57350, 52721, 6880, 28791, 50807, 45000, 63667, 4685, 9308, 33276, 50884, 15482, 31358, 24621, 42093, 57293, 22698, 16899, 33296, 63936, 48832, 9256}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(View.MeasureSpec.getSize(0), new char[]{20523, 20554, 18383, 61552, 50342, 6703, 43908, 15573, 36453, 53828, 35242, 7889, 60447, 13430, 61435, 63732, 51767, 5628, 52507, 56077, 10425, 30679, 9076, 34080, 1671, 18860, 332, 26490, 25837, 43991, 24731, 16836, 17163, 36105, 18104, 9131, 41224, 61281, 42182, 3529, 40736, 49502, 64234, 60442, 64910, 8933, 55399, 52784, 56304, 1210, 15963, 43086, 14840, 26262, 7269, 35432, 6170, 47210, 29578, 29880, 30251, 39492, 20865, 22147, 21570, 64533, 47022, 12522}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{39025, 38979, 34168, 12995, 31971, 2833, 5010, 11757, 18016, 4349, 12781, 4067, 9241, 63130, 22463, 59854, 568, 55113, 30047, 51760, 57520, 46391, 39779, 37963, 52875, 35656, 47454, 30276, 44214, 26980, 55518, 20647, 35599, 20412, 65272, 12996, 26886, 11734, 7301, 7415, 22395, 957, 17065, 64815, 13785, 57348, 24694, 57099, 5105, 50698, 34382, 47397, 61943, 42027, 42100, 39690, 53323, 31451, 52121, 25986, 48758, 22775, 59806, 18409, 40015, 16047, 4026, 8670}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(ViewConfiguration.getScrollBarSize() >> 8, new char[]{54741, 54717, 15389, 35811, 33584, 53139, 60496, 59773, 2958, 43413, 52771, 52090, 27105, 20390, 43066, 11548, 20355, 28267, 35540, 3831, 44304, 3158, 25840, 20686, 33660, 12860, 18072, 45787, 57666, 53266, 10069, 37999, 50857, 63180, 365, 63056, 9460, 38053, 58113, 55395, 6878, 47744, 48417, 14778, 30756, 22903, 40957, 7058, 24068, 32561, 31131, 32160, 48198, 7427, 23531, 24475, 40431, 50080, 13385, 41283, 62336, 57801, 5632, 33582}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(View.getDefaultSize(0, 0), new char[]{8975, 9014, 41140, 5904, 4652, 43125, 32012, 36549, 64789, 13623}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 18 - View.MeasureSpec.getMode(0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[32];
                Object[] objArr13 = new Object[1];
                h(b, (byte) (b << 2), PlaceComponentResult[2], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                h((byte) (getAuthRequestContext & 10), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[2], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (Process.myPid() >> 22), 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) TextUtils.indexOf("", ""));
                        Object[] objArr16 = new Object[1];
                        j((byte) (-$$a[53]), (byte) (-$$a[12]), $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0), 15 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 800, 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 815, TextUtils.indexOf((CharSequence) "", '0', 0) + 30, (char) (57993 - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0'), 15 - View.getDefaultSize(0, 0), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), View.combineMeasuredStates(0, 0) + 35, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {41457130, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = PlaceComponentResult[32];
                Object[] objArr19 = new Object[1];
                h(b2, (byte) (b2 << 2), PlaceComponentResult[2], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                h((byte) (getAuthRequestContext & 10), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[2], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 61, (ViewConfiguration.getLongPressTimeout() >> 16) + 46, (char) Gravity.getAbsoluteGravity(0, 0));
                        byte b3 = $$a[20];
                        byte b4 = (byte) ($$a[47] - 1);
                        Object[] objArr22 = new Object[1];
                        j(b3, b4, b4, objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), Gravity.getAbsoluteGravity(0, 0) + 35, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {41457130, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = PlaceComponentResult[32];
                Object[] objArr25 = new Object[1];
                h(b5, (byte) (b5 << 2), PlaceComponentResult[2], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                h((byte) (getAuthRequestContext & 10), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[2], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 118, 3 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (38968 - (ViewConfiguration.getWindowTouchSlop() >> 8)));
                        byte b6 = $$a[20];
                        byte b7 = (byte) ($$a[47] - 1);
                        Object[] objArr28 = new Object[1];
                        j(b6, b7, b7, objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {41457130, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b8 = PlaceComponentResult[32];
                Object[] objArr31 = new Object[1];
                h(b8, (byte) (b8 << 2), PlaceComponentResult[2], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                h((byte) (getAuthRequestContext & 10), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[2], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 107, 3 - KeyEvent.keyCodeFromString(""), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        j((byte) ($$a[47] - 1), (byte) (-$$a[9]), (byte) (-$$a[8]), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myPid() >> 22), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {41457130, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, Color.alpha(0) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(Process.myTid() >> 22, new char[]{2974, 3071, 40308, 10896, 40418, 2876, 62098, 11728, 54745, 2223, 53434, 4052, 47023, 61150, 46838, 59900, 37287, 53013, 37914, 51779, 29512, 44343, 31266, 38011, 23810, 37710, 22604, 30271, 16143, 29034}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(getPackageName().codePointAt(4) - 97, new char[]{61529, 61498, 5150, 41953, 64368, 6603, 37910, 16167, 11796, 33218, 46648, 7500, 19577, 26548, 53368, 64332, 27202, 18045, 62088, 55476, 34966, 9306}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), 18 - View.resolveSize(0, 0), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
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
                h(PlaceComponentResult[2], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], new Object[1]);
                Object[] objArr2 = new Object[1];
                g(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{2974, 3071, 40308, 10896, 40418, 2876, 62098, 11728, 54745, 2223, 53434, 4052, 47023, 61150, 46838, 59900, 37287, 53013, 37914, 51779, 29512, 44343, 31266, 38011, 23810, 37710, 22604, 30271, 16143, 29034}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                g(Color.argb(0, 0, 0, 0), new char[]{61529, 61498, 5150, 41953, 64368, 6603, 37910, 16167, 11796, 33218, 46648, 7500, 19577, 26548, 53368, 64332, 27202, 18045, 62088, 55476, 34966, 9306}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        g(TextUtils.getOffsetBefore("", 0), new char[]{21069, 21036, 9782, 37330, 52576, 11809, 41488, 2253, 35850, 46061, 32824, 10953, 61042, 21919, 58922, 52383, 51271, 29787, 50319, 61266, 10910, 5743}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            Object[] objArr3 = new Object[1];
            h(PlaceComponentResult[2], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], new Object[1]);
            Object[] objArr4 = new Object[1];
            g(((ApplicationInfo) cls2.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{39686, 39787, 46526, 589, 55552, 20540, 46657, 30411, 17738}, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    g(getPackageName().codePointAt(2) - 46, new char[]{2974, 3071, 40308, 10896, 40418, 2876, 62098, 11728, 54745, 2223, 53434, 4052, 47023, 61150, 46838, 59900, 37287, 53013, 37914, 51779, 29512, 44343, 31266, 38011, 23810, 37710, 22604, 30271, 16143, 29034}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    g(View.resolveSizeAndState(0, 0, 0), new char[]{61529, 61498, 5150, 41953, 64368, 6603, 37910, 16167, 11796, 33218, 46648, 7500, 19577, 26548, 53368, 64332, 27202, 18045, 62088, 55476, 34966, 9306}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        g((Process.getThreadPriority(0) + 20) >> 6, new char[]{2506, 2557, 47793, 3416, 17466, 38427, 11032, 45245, 55250, 12135, 2367, 37605, 46509, 51470, 28477, 29843, 37847, 59521, 19847, 22331, 29019, 35498, 41912, 2372, 24422, 46208, 33157, 60235, 15710, 22264, 57350, 52721, 6880, 28791, 50807, 45000, 63667, 4685, 9308, 33276, 50884, 15482, 31358, 24621, 42093, 57293, 22698, 16899, 33296, 63936, 48832, 9256}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        g(super.getResources().getString(R.string.caption_promo_merchant).substring(0, 8).length() - 8, new char[]{20523, 20554, 18383, 61552, 50342, 6703, 43908, 15573, 36453, 53828, 35242, 7889, 60447, 13430, 61435, 63732, 51767, 5628, 52507, 56077, 10425, 30679, 9076, 34080, 1671, 18860, 332, 26490, 25837, 43991, 24731, 16836, 17163, 36105, 18104, 9131, 41224, 61281, 42182, 3529, 40736, 49502, 64234, 60442, 64910, 8933, 55399, 52784, 56304, 1210, 15963, 43086, 14840, 26262, 7269, 35432, 6170, 47210, 29578, 29880, 30251, 39492, 20865, 22147, 21570, 64533, 47022, 12522}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        g(super.getResources().getString(R.string.type_name_bank_or_phone_number).substring(7, 8).codePointAt(0) - 111, new char[]{39025, 38979, 34168, 12995, 31971, 2833, 5010, 11757, 18016, 4349, 12781, 4067, 9241, 63130, 22463, 59854, 568, 55113, 30047, 51760, 57520, 46391, 39779, 37963, 52875, 35656, 47454, 30276, 44214, 26980, 55518, 20647, 35599, 20412, 65272, 12996, 26886, 11734, 7301, 7415, 22395, 957, 17065, 64815, 13785, 57348, 24694, 57099, 5105, 50698, 34382, 47397, 61943, 42027, 42100, 39690, 53323, 31451, 52121, 25986, 48758, 22775, 59806, 18409, 40015, 16047, 4026, 8670}, objArr9);
                        String str3 = (String) objArr9[0];
                        try {
                            Object[] objArr10 = new Object[1];
                            h(PlaceComponentResult[2], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], new Object[1]);
                            Object[] objArr11 = new Object[1];
                            g(((ApplicationInfo) cls4.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{54741, 54717, 15389, 35811, 33584, 53139, 60496, 59773, 2958, 43413, 52771, 52090, 27105, 20390, 43066, 11548, 20355, 28267, 35540, 3831, 44304, 3158, 25840, 20686, 33660, 12860, 18072, 45787, 57666, 53266, 10069, 37999, 50857, 63180, 365, 63056, 9460, 38053, 58113, 55395, 6878, 47744, 48417, 14778, 30756, 22903, 40957, 7058, 24068, 32561, 31131, 32160, 48198, 7427, 23531, 24475, 40431, 50080, 13385, 41283, 62336, 57801, 5632, 33582}, objArr11);
                            String str4 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            g(ViewConfiguration.getScrollBarSize() >> 8, new char[]{8975, 9014, 41140, 5904, 4652, 43125, 32012, 36549, 64789, 13623}, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr13);
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
                }
            }
            try {
                byte b = PlaceComponentResult[32];
                Object[] objArr14 = new Object[1];
                h(b, (byte) (b << 2), PlaceComponentResult[2], objArr14);
                Class<?> cls5 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                h((byte) (getAuthRequestContext & 10), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[2], objArr15);
                try {
                    Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 494, 4 - View.resolveSizeAndState(0, 0, 0), (char) (Process.myPid() >> 22));
                        Object[] objArr17 = new Object[1];
                        j((byte) ($$a[47] - 1), (byte) (-$$a[9]), (byte) (-$$a[8]), objArr17);
                        obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                    int i = ((int[]) objArr18[1])[0];
                    if (((int[]) objArr18[0])[0] != i) {
                        long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr19 = {-1349476957, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0) + 19, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr19);
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
                    super.onCreate(bundle);
                    try {
                        setRequestedOrientation(1);
                    } catch (Exception unused) {
                    }
                    setContentView(com.alibaba.griver.ui.R.layout.griver_ui_activity_multilevel_select);
                    init();
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
    }

    protected void init() {
        this.mSegemnt = (AUSegment) findViewById(com.alibaba.griver.ui.R.id.segment);
        this.mTitleBar = (AUTitleBar) findViewById(com.alibaba.griver.ui.R.id.title_bar);
        this.mListView = (AUListView) findViewById(com.alibaba.griver.ui.R.id.listview);
        this.mContainer = (AULinearLayout) findViewById(com.alibaba.griver.ui.R.id.container);
        b();
        if (this.c == null || this.d == null) {
            a();
            return;
        }
        this.mTitleBar.toIOSStyle(this.f6712a);
        this.mTitleBar.setBackButtonGone();
        this.mTitleBar.getLeftButton().setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MultilevelSelectActivity.this.a();
            }
        });
        ArrayList arrayList = new ArrayList();
        if (!this.e.isEmpty()) {
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(a(i, this.e.getJSONObject(i).getString("name")));
            }
            JSONArray jSONArray = this.e;
            JSONArray jSONArray2 = jSONArray.getJSONObject(jSONArray.size() - 1).getJSONArray("subList");
            if (jSONArray2 != null && !jSONArray2.isEmpty()) {
                arrayList.add(a(this.e.size(), this.b));
            }
        } else {
            arrayList.add(a(0, this.b));
        }
        this.mSegemnt.setDivideAutoSize(false);
        this.mSegemnt.init(arrayList);
        this.mListView.setAdapter((ListAdapter) new MultilevelSelectAdapter(this.d, this));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                JSONObject jSONObject = MultilevelSelectActivity.this.d.getJSONObject(i2);
                while (MultilevelSelectActivity.this.e.size() > MultilevelSelectActivity.this.f) {
                    MultilevelSelectActivity.this.e.remove(MultilevelSelectActivity.this.e.size() - 1);
                }
                MultilevelSelectActivity.this.e.add(jSONObject);
                JSONArray jSONArray3 = jSONObject.getJSONArray("subList");
                if (jSONArray3 == null || jSONArray3.isEmpty()) {
                    if (MultilevelSelectActivity.multilevelSelectCallBack != null) {
                        MultilevelSelectActivity.multilevelSelectCallBack.onSuccess(MultilevelSelectActivity.this.e);
                    }
                    MultilevelSelectActivity.this.finish();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < MultilevelSelectActivity.this.e.size(); i3++) {
                    arrayList2.add(MultilevelSelectActivity.this.a(i3, MultilevelSelectActivity.this.e.getJSONObject(i3).getString("name")));
                }
                MultilevelSelectActivity multilevelSelectActivity = MultilevelSelectActivity.this;
                arrayList2.add(multilevelSelectActivity.a(multilevelSelectActivity.e.size(), MultilevelSelectActivity.this.b));
                MultilevelSelectActivity.this.mSegemnt.init(arrayList2);
                MultilevelSelectActivity.this.a(arrayList2.size() - 1, jSONArray3);
            }
        });
        if (this.e.isEmpty()) {
            return;
        }
        if (this.e.size() > 1) {
            JSONArray jSONArray3 = this.e.getJSONObject(r1.size() - 2).getJSONArray("subList");
            if (jSONArray3 != null && !jSONArray3.isEmpty()) {
                arrayList.add(a(this.e.size(), this.b));
            }
            a(this.e.size() - 1, jSONArray3);
            return;
        }
        a(0, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, JSONArray jSONArray) {
        this.f = i;
        this.mSegemnt.setCurrentSelTab(i);
        this.mListView.setAdapter((ListAdapter) new MultilevelSelectAdapter(jSONArray, this));
        this.d = jSONArray;
        this.mSegemnt.setTabSwitchListener(new AUSegment.TabSwitchListener() { // from class: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectActivity.3
            @Override // com.alibaba.griver.ui.ant.AUSegment.TabSwitchListener
            public void onTabClick(int i2, View view) {
                if (i2 > 0) {
                    MultilevelSelectActivity.this.a(i2, MultilevelSelectActivity.this.e.getJSONObject(i2 - 1).getJSONArray("subList"));
                    return;
                }
                MultilevelSelectActivity multilevelSelectActivity = MultilevelSelectActivity.this;
                multilevelSelectActivity.a(i2, multilevelSelectActivity.c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ItemCategory a(int i, String str) {
        ItemCategory itemCategory = new ItemCategory();
        itemCategory.categoryname = str;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(str);
        itemCategory.categoryId = sb.toString();
        return itemCategory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        finish();
        if (multilevelSelectCallBack != null) {
            multilevelSelectCallBack.onCancel();
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        a();
    }

    private void b() {
        JSONArray jSONArray;
        Intent intent = getIntent();
        this.f6712a = intent.getStringExtra("title");
        String stringExtra = intent.getStringExtra("defaultSegmentName");
        this.b = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.b = getString(com.alibaba.griver.ui.R.string.griver_please_select);
        }
        try {
            JSONArray parseArray = JSON.parseArray(intent.getStringExtra("list"));
            this.c = parseArray;
            this.d = parseArray;
        } catch (Throwable th) {
            GriverLogger.e("MultilevelSelectActivity", "error", th);
        }
        String stringExtra2 = intent.getStringExtra("result");
        if (TextUtils.isEmpty(stringExtra2) || (jSONArray = this.c) == null || jSONArray.isEmpty()) {
            return;
        }
        try {
            a(this.c, JSON.parseArray(stringExtra2), 0);
        } catch (Throwable th2) {
            GriverLogger.e("MultilevelSelectActivity", "error", th2);
        }
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2, int i) {
        if (jSONArray == null || jSONArray2 == null || i >= jSONArray2.size()) {
            return;
        }
        int size = jSONArray.size();
        JSONObject jSONObject = jSONArray2.getJSONObject(i);
        for (int i2 = 0; i2 < size; i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            if (TextUtils.equals(jSONObject2.getString("name"), jSONObject.getString("name"))) {
                this.e.add(jSONObject2);
                i++;
                a(jSONObject2.getJSONArray("subList"), jSONArray2, i);
            }
        }
    }

    private static void g(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
    }
}
