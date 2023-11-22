package id.dana.miniprogram.tnc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.core.ui.constant.DialogType;
import id.dana.danah5.showagreement.ShowAgreementBridge;
import id.dana.dialog.CommonDialog;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/miniprogram/tnc/EmailNotVerifiedDialogActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EmailNotVerifiedDialogActivity extends BaseActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$a = {16, -72, -107, 15, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 3;
    public static final byte[] getAuthRequestContext = {84, -107, -124, 66, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 156;
    private static int[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {872267069, -905159619, 1039659294, -1208964904, -792309174, 1273802226, -1106701083, -249612424, -1416085384, 394178831, 1168586583, 1875845708, 1775201076, -1640923982, -66951332, -2116184925, 787350435, 769720575};

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = 23 - r9
            byte[] r0 = id.dana.miniprogram.tnc.EmailNotVerifiedDialogActivity.getAuthRequestContext
            int r8 = 55 - r8
            int r7 = 106 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L13:
            r3 = 0
        L14:
            r6 = r9
            r9 = r7
            r7 = r6
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L31:
            int r7 = -r7
            int r10 = r10 + r7
            int r7 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.tnc.EmailNotVerifiedDialogActivity.b(byte, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r0 = id.dana.miniprogram.tnc.EmailNotVerifiedDialogActivity.$$a
            int r6 = 47 - r6
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
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
        L35:
            int r8 = r8 + r6
            int r6 = r7 + 1
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.tnc.EmailNotVerifiedDialogActivity.c(byte, short, short, java.lang.Object[]):void");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((ViewConfiguration.getWindowTouchSlop() >> 8) + 18, new int[]{1633011215, -163821894, -29112849, -1492223524, 1601332810, 646906687, -1062966208, 2050546318, 1285035863, -1838263930}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(((Process.getThreadPriority(0) + 20) >> 6) + 5, new int[]{-1545542071, 1069595011, 1394912160, 438983372}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 48, new int[]{900019467, 373350394, 643713542, 39976695, -316920569, -1471556667, -2096268729, -571911728, -548054855, -1163591930, 1536012986, -1549652820, -619853319, 724490070, 633243014, 804929874, -904807114, 2136605, -957827286, 2135483609, 9662884, -225710842, 1500133477, 180358922}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(63 - ExpandableListView.getPackedPositionChild(0L), new int[]{1525983418, -68541914, 1786197904, -877398271, -1367214130, 1772602912, 995541734, -950119116, -916838120, -1006703017, 1762460152, 1481810500, 1142534342, 800730267, 1646580232, 1169574329, -1896439047, -462376214, 459597546, -1100772041, -99012109, -729124892, -1134973837, 169060178, 1408304489, -1034552062, -175531267, 1859595909, -1227737193, -1884419697, 1419568408, -1933327887}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 63, new int[]{-801113651, 603042312, 1262993595, 850184398, 1853792078, -500136469, 1961984882, 605495746, -382142334, -1896053984, 849861403, -445989224, -900521496, 1411981170, 1913546243, 1269224833, -1120805195, -1604269462, -167204621, -1225844451, 986442905, -805163256, 266514839, 2089952351, -1462244083, 1242072625, 1450103595, 648039068, -1908661857, -1653446861, -883823181, -1370781781}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - KeyEvent.normalizeMetaState(0), new int[]{-707729878, 1051307018, 505718251, 297639242, -173201327, -1386958007, 1767790338, -521736863, -1971466637, -712044209, -1028065005, 198889169, -1308213008, 358680681, -1164580954, 330976402, -1726120689, 1135513048, 150345983, 1821727854, 51933418, -1941269347, 1372380168, 1925021122, -541593083, 854885416, -4078267, -847954395, 1910003436, 437657741}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(MotionEvent.axisFromString("") + 7, new int[]{-1766434722, -556828299, 1640062399, 1519207599}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[9], 30, getAuthRequestContext[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.getOffsetBefore("", 0), 2 - TextUtils.lastIndexOf("", '0', 0), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[78], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 800, ExpandableListView.getPackedPositionType(0L) + 15, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778016, 15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 30, (char) (57993 - TextUtils.lastIndexOf("", '0')))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 15 - (Process.myPid() >> 22), (char) View.MeasureSpec.getSize(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1366038929, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[9], 30, getAuthRequestContext[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 61, 46 - TextUtils.indexOf("", ""), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1));
                        Object[] objArr22 = new Object[1];
                        c($$a[84], $$a[9], $$a[8], objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0') + 36, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1366038929, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(getAuthRequestContext[9], 30, getAuthRequestContext[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 2, (char) (TextUtils.getTrimmedLength("") + 38968));
                        Object[] objArr28 = new Object[1];
                        c($$a[84], $$a[9], $$a[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1366038929, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(getAuthRequestContext[9], 30, getAuthRequestContext[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 107, Process.getGidForName("") + 4, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        byte b = (byte) ($$b - 3);
                        byte b2 = b;
                        Object[] objArr34 = new Object[1];
                        c(b, b2, b2, objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), View.resolveSize(0, 0) + 35, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1366038929, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), View.resolveSizeAndState(0, 0, 0) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.dialog_email_not_verified;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(26 - (ViewConfiguration.getScrollBarSize() >> 8), new int[]{1633011215, -163821894, -29112849, -1492223524, -1582636157, 1780529670, -1365723243, -2087195122, 1959885208, 273760448, -172214926, 573640525, -1162515414, -388314123}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[48], getAuthRequestContext[25], getAuthRequestContext[41], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{-853359853, -308986184, -1345561333, 1156363173, -181286454, 1391394802, -1581519074, 2095407328, 897026962, 636578229}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (Process.myPid() >> 22) + 35, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                b((byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(getAuthRequestContext[48], getAuthRequestContext[25], getAuthRequestContext[41], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{1633011215, -163821894, -29112849, -1492223524, -1582636157, 1780529670, -1365723243, -2087195122, 1959885208, 273760448, -172214926, 573640525, -1162515414, -388314123}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(18 - (ViewConfiguration.getTouchSlop() >> 8), new int[]{-853359853, -308986184, -1345561333, 1156363173, -181286454, 1391394802, -1581519074, 2095407328, 897026962, 636578229}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, TextUtils.getOffsetBefore("", 0) + 35, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr = new Object[1];
        a(super.getResources().getString(R.string.share_feed_consent_dialog_message).substring(28, 29).length() + 17, new int[]{1633011215, -163821894, -29112849, -1492223524, 1601332810, 646906687, -1062966208, 2050546318, 1285035863, -1838263930}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(5 - ExpandableListView.getPackedPositionGroup(0L), new int[]{-1545542071, 1069595011, 1394912160, 438983372}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr3 = new Object[1];
                    b((byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[25], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    b(getAuthRequestContext[48], getAuthRequestContext[25], getAuthRequestContext[41], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{1633011215, -163821894, -29112849, -1492223524, -1582636157, 1780529670, -1365723243, -2087195122, 1959885208, 273760448, -172214926, 573640525, -1162515414, -388314123}, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, new int[]{-853359853, -308986184, -1345561333, 1156363173, -181286454, 1391394802, -1581519074, 2095407328, 897026962, 636578229}, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 48, new int[]{900019467, 373350394, 643713542, 39976695, -316920569, -1471556667, -2096268729, -571911728, -548054855, -1163591930, 1536012986, -1549652820, -619853319, 724490070, 633243014, 804929874, -904807114, 2136605, -957827286, 2135483609, 9662884, -225710842, 1500133477, 180358922}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(64 - View.resolveSize(0, 0), new int[]{1525983418, -68541914, 1786197904, -877398271, -1367214130, 1772602912, 995541734, -950119116, -916838120, -1006703017, 1762460152, 1481810500, 1142534342, 800730267, 1646580232, 1169574329, -1896439047, -462376214, 459597546, -1100772041, -99012109, -729124892, -1134973837, 169060178, 1408304489, -1034552062, -175531267, 1859595909, -1227737193, -1884419697, 1419568408, -1933327887}, objArr7);
                    String str2 = (String) objArr7[0];
                    try {
                        Object[] objArr8 = new Object[1];
                        b((byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[25], objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(getAuthRequestContext[48], getAuthRequestContext[25], getAuthRequestContext[41], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 31, new int[]{-801113651, 603042312, 1262993595, 850184398, 1853792078, -500136469, 1961984882, 605495746, -382142334, -1896053984, 849861403, -445989224, -900521496, 1411981170, 1913546243, 1269224833, -1120805195, -1604269462, -167204621, -1225844451, 986442905, -805163256, 266514839, 2089952351, -1462244083, 1242072625, 1450103595, 648039068, -1908661857, -1653446861, -883823181, -1370781781}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(getPackageName().length() + 53, new int[]{-707729878, 1051307018, 505718251, 297639242, -173201327, -1386958007, 1767790338, -521736863, -1971466637, -712044209, -1028065005, 198889169, -1308213008, 358680681, -1164580954, 330976402, -1726120689, 1135513048, 150345983, 1821727854, 51933418, -1941269347, 1372380168, 1925021122, -541593083, 854885416, -4078267, -847954395, 1910003436, 437657741}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(super.getResources().getString(R.string.transfer_account_status_button_failed).substring(7, 21).codePointAt(1) - 61, new int[]{-1766434722, -556828299, 1640062399, 1519207599}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, (-16777198) - Color.rgb(0, 0, 0), (char) (Process.getGidForName("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            Object[] objArr14 = new Object[1];
            b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr14);
            Class<?> cls5 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(getAuthRequestContext[9], 30, getAuthRequestContext[30], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 494, 4 - (ViewConfiguration.getTouchSlop() >> 8), (char) View.resolveSizeAndState(0, 0, 0));
                    byte b = (byte) ($$b - 3);
                    byte b2 = b;
                    Object[] objArr17 = new Object[1];
                    c(b, b2, b2, objArr17);
                    obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr19 = {958113278, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                overridePendingTransition(17432576, 17432577);
                setRequestedOrientation(Build.VERSION.SDK_INT == 26 ? -1 : 1);
                super.onCreate(savedInstanceState);
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

    @Override // id.dana.base.BaseActivity
    public final void init() {
        CommonDialog.Builder builder = new CommonDialog.Builder(this);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = getString(R.string.email_unverify);
        builder.DatabaseTableConfigUtil = DialogType.WARNING;
        String string = getString(17039370);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.miniprogram.tnc.EmailNotVerifiedDialogActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailNotVerifiedDialogActivity.m2670$r8$lambda$e_H9xpILnI_rCLLP6B0z666i58(EmailNotVerifiedDialogActivity.this, view);
            }
        };
        builder.lookAheadTest = string;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = onClickListener;
        builder.PlaceComponentResult = false;
        CommonDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(false);
        new CommonDialog(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2.MyBillsEntityDataFactory, PlaceComponentResult2.scheduleImpl, PlaceComponentResult2).MyBillsEntityDataFactory();
    }

    /* renamed from: $r8$lambda$e_H9x-pILnI_rCLLP6B0z666i58 */
    public static /* synthetic */ void m2670$r8$lambda$e_H9xpILnI_rCLLP6B0z666i58(EmailNotVerifiedDialogActivity emailNotVerifiedDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(emailNotVerifiedDialogActivity, "");
        emailNotVerifiedDialogActivity.finish();
        EventBus.getDefault().post(new ShowAgreementBridge.AgreementMessageEvent(false, "004"));
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
