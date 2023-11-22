package id.dana.googlebinding;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.gol.google.GolGoogleAuthActivity;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.globalnetwork.AlipayConnectInitializer;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.util.IapConnectKtx;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/googlebinding/GoogleBindingWaitingActivity;", "Lcom/iap/ac/android/gol/google/GolGoogleAuthActivity;", "Lcom/iap/ac/android/biz/common/callback/InitCallback;", "callback", "", "initSDK", "(Lcom/iap/ac/android/biz/common/callback/InitCallback;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GoogleBindingWaitingActivity extends GolGoogleAuthActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$d = {1, 78, 11, -6, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 70;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {2, -87, 98, TarHeader.LF_FIFO, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int MyBillsEntityDataFactory = 44;
    private static char scheduleImpl = 26944;
    private static long PlaceComponentResult = 4360990799332652212L;
    private static int lookAheadTest = -956812108;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(int r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 + 97
            int r5 = 56 - r5
            int r7 = r7 + 16
            byte[] r0 = id.dana.googlebinding.GoogleBindingWaitingActivity.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = 0
            r3 = r6
            r6 = r5
            goto L25
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L23:
            r3 = r0[r5]
        L25:
            int r5 = r5 + 1
            int r6 = r6 + r3
            int r6 = r6 + (-4)
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.googlebinding.GoogleBindingWaitingActivity.e(int, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = id.dana.googlebinding.GoogleBindingWaitingActivity.$$d
            int r6 = 46 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            int r6 = r6 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.googlebinding.GoogleBindingWaitingActivity.f(short, int, byte, java.lang.Object[]):void");
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

    @Override // com.iap.ac.android.gol.google.GolGoogleAuthActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 15860), TextUtils.getCapsMode("", 0, 0), new char[]{60373, 32854, 62496, 43581}, new char[]{17888, 55769, 27416, 22760, 15176, 56642, 26833, 58498, 51941, 15038, 13428, 37439, 47976, 33267, 54128, 53249, 38105, 3075}, new char[]{0, 0, 0, 0}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d((char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 22122), 882486894 - TextUtils.getOffsetBefore("", 0), new char[]{28361, 39342, 27444, 36950}, new char[]{59017, 52545, 15362, 32096, 26727}, new char[]{0, 0, 0, 0}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 35 - View.MeasureSpec.getMode(0), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d((char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), ExpandableListView.getPackedPositionType(0L), new char[]{9766, 41311, 1889, 52615}, new char[]{49756, 61194, 30731, 44798, 42996, 56539, 3871, 61352, 42131, 9388, 40836, 43426, 14909, 10336, 22741, 2252, 59388, 25836, 38324, 56776, 49517, 51095, 38883, 54472, 9576, 29964, 37012, 23704, 48359, 55848, 48325, 998, 40856, 33410, 8811, 298, 22924, 27956, 42356, 11828, 27633, 47067, 61620, 23733, 12545, 52537, 61878, 35521}, new char[]{0, 0, 0, 0}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d((char) View.combineMeasuredStates(0, 0), ViewConfiguration.getTouchSlop() >> 8, new char[]{33684, 14441, 19789, 6845}, new char[]{54109, 63681, 37631, 56817, 25445, 59673, 41537, 59243, 5479, 27281, 40725, 48641, 58603, 10822, 19561, 24090, 34830, 44050, 8336, 61369, 25263, 25466, 43100, 56937, 60130, 64704, 62681, 19549, 21170, 62589, 33360, 2127, 61690, 37279, 5895, 15143, 26673, 15515, 41631, 39030, 12989, 26554, 11010, 44329, 20189, 38887, 55975, 56732, 16365, 33236, 20400, 5544, 28658, 16897, 45965, 35896, 24031, 55308, 43218, 44075, 22426, 20170, 22784, 42197}, new char[]{0, 0, 0, 0}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d((char) KeyEvent.keyCodeFromString(""), ViewConfiguration.getScrollBarFadeDuration() >> 16, new char[]{28517, 50229, 46263, 12365}, new char[]{43044, 64114, 39814, 35591, 12792, 61675, 2894, 43856, 45581, 10084, 62630, 4854, 40513, 59477, 12564, 56235, 22073, 2782, Typography.degree, 43294, 48260, 43279, 48228, 65008, 62353, 7586, 41622, 58908, 47925, 11055, 37613, 15250, 46562, 15882, 23802, 22829, 44290, 27402, 40437, 9756, 46922, 37057, 30543, 23328, 22480, 26266, 20388, 32071, 54567, 23874, 6308, 17514, 10621, 16147, 10155, 19852, 44352, 17896, 55228, 26176, 33186, 28382, 55200, 60519}, new char[]{0, 0, 0, 0}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d((char) TextUtils.getCapsMode("", 0, 0), ViewConfiguration.getLongPressTimeout() >> 16, new char[]{8344, 21300, 1139, 35626}, new char[]{61193, 29532, 59783, 31763, 44835, 21604, 17783, 13088, 28660, 61001, 21167, 4196, 11745, 62949, 39486, 35230, 19152, 50072, 3269, 14595, 2004, 35123, 33205, 26922, 19628, 17700, 28714, 50616, 35601, 60835, 49591, 16698, 24956, 27336, 5203, 23352, 303, 34509, 39806, 27383, 51126, 26109, 40942, 18608, 60807, 28171, 10863, 3706, 53146, 31001, 614, 9900, 52110, 6159, 7513, 32065, 57698, 39380, 4257, 19121}, new char[]{0, 0, 0, 0}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d((char) (13949 - Color.blue(0)), (-1) - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{62894, 16433, 32251, 19510}, new char[]{65344, 24924, 55394, 27763, 55094, 10239}, new char[]{0, 0, 0, 0}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), Color.red(0) + 18, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                e(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1);
                Object[] objArr14 = new Object[1];
                e(b, (byte) (b & 40), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Color.argb(0, 0, 0, 0), TextUtils.indexOf("", "", 0) + 3, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        Object[] objArr16 = new Object[1];
                        f($$d[53], $$d[31], $$d[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, ExpandableListView.getPackedPositionType(0L) + 15, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 800, 15 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) TextUtils.indexOf("", ""))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 816, TextUtils.getTrimmedLength("") + 29, (char) (57994 - View.resolveSize(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 800, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 15, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), 35 - Color.blue(0), (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1706373338, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, Color.red(0) + 18, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = {this};
                Object[] objArr20 = new Object[1];
                e(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1);
                Object[] objArr21 = new Object[1];
                e(b2, (byte) (b2 & 40), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - ExpandableListView.getPackedPositionType(0L), 46 - View.getDefaultSize(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0')));
                        Object[] objArr23 = new Object[1];
                        f($$d[84], $$d[8], (byte) ($$d[0] - 1), objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {1706373338, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
                Object[] objArr26 = {this};
                Object[] objArr27 = new Object[1];
                e(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1);
                Object[] objArr28 = new Object[1];
                e(b3, (byte) (b3 & 40), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 118, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 3, (char) (38967 - TextUtils.indexOf((CharSequence) "", '0', 0)));
                        Object[] objArr30 = new Object[1];
                        f($$d[84], $$d[8], (byte) ($$d[0] - 1), objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {1706373338, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
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
                Object[] objArr33 = {this};
                Object[] objArr34 = new Object[1];
                e(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1);
                Object[] objArr35 = new Object[1];
                e(b4, (byte) (b4 & 40), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 107, 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        byte b5 = (byte) ($$d[0] - 1);
                        Object[] objArr37 = new Object[1];
                        f(b5, b5, $$d[9], objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr39 = {1706373338, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), TextUtils.lastIndexOf("", '0', 0) + 19, (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
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

    @Override // com.iap.ac.android.gol.google.GolGoogleAuthActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleAuthActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleAuthActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleAuthActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            e((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            e(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), KClassImpl$Data$declaredNonStaticMembers$2[0], objArr3);
            Object[] objArr4 = new Object[1];
            d((char) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 15827), getPackageName().length() - 7, new char[]{60373, 32854, 62496, 43581}, new char[]{17888, 55769, 27416, 22760, 15176, 56642, 26833, 58498, 51941, 15038, 13428, 37439, 47976, 33267, 54128, 53249, 38105, 3075}, new char[]{0, 0, 0, 0}, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            d((char) (getPackageName().length() + 22116), 882486893 + super.getResources().getString(R.string.lazada_title).substring(26, 27).length(), new char[]{28361, 39342, 27444, 36950}, new char[]{59017, 52545, 15362, 32096, 26727}, new char[]{0, 0, 0, 0}, objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    d((char) (super.getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 1196), getPackageName().codePointAt(3) - 100, new char[]{47417, 43770, 56687, 11268}, new char[]{5584, 23323, 20540, 34416, 61697, 8914, 9875, 64304, 4708, 20612, 42155, 5530, 37476, 9397, 21391, 37064, 60005, 29258, 21986, 43579, 64454, 57671, 28551, 35524, 10939, 31304}, new char[]{0, 0, 0, 0}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    d((char) (getPackageName().codePointAt(4) + 37832), getPackageName().codePointAt(5) - 110, new char[]{64792, 11107, 10634, 13204}, new char[]{30053, 27538, 29131, 30544, 32151, 24095, 36629, 47451, 47789, 34183, 57367, 27418, 28698, 4488, 15667, 21066, 48661, 47511}, new char[]{0, 0, 0, 0}, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), 34 - TextUtils.lastIndexOf("", '0', 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        d((char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), Drawable.resolveOpacity(0, 0), new char[]{9766, 41311, 1889, 52615}, new char[]{49756, 61194, 30731, 44798, 42996, 56539, 3871, 61352, 42131, 9388, 40836, 43426, 14909, 10336, 22741, 2252, 59388, 25836, 38324, 56776, 49517, 51095, 38883, 54472, 9576, 29964, 37012, 23704, 48359, 55848, 48325, 998, 40856, 33410, 8811, 298, 22924, 27956, 42356, 11828, 27633, 47067, 61620, 23733, 12545, 52537, 61878, 35521}, new char[]{0, 0, 0, 0}, objArr8);
                        String str = (String) objArr8[0];
                        try {
                            Object[] objArr9 = new Object[1];
                            e((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            e(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), KClassImpl$Data$declaredNonStaticMembers$2[0], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            d((char) (((ApplicationInfo) cls4.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().codePointAt(5) - 110, new char[]{33684, 14441, 19789, 6845}, new char[]{54109, 63681, 37631, 56817, 25445, 59673, 41537, 59243, 5479, 27281, 40725, 48641, 58603, 10822, 19561, 24090, 34830, 44050, 8336, 61369, 25263, 25466, 43100, 56937, 60130, 64704, 62681, 19549, 21170, 62589, 33360, 2127, 61690, 37279, 5895, 15143, 26673, 15515, 41631, 39030, 12989, 26554, 11010, 44329, 20189, 38887, 55975, 56732, 16365, 33236, 20400, 5544, 28658, 16897, 45965, 35896, 24031, 55308, 43218, 44075, 22426, 20170, 22784, 42197}, new char[]{0, 0, 0, 0}, objArr10);
                            String str2 = (String) objArr10[0];
                            char length = (char) (super.getResources().getString(R.string.email_address_title).substring(0, 5).length() - 5);
                            try {
                                Object[] objArr11 = new Object[1];
                                e((byte) (KClassImpl$Data$declaredNonStaticMembers$2[59] + 1), KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr11);
                                Class<?> cls5 = Class.forName((String) objArr11[0]);
                                e(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), KClassImpl$Data$declaredNonStaticMembers$2[0], new Object[1]);
                                Object[] objArr12 = new Object[1];
                                d(length, ((ApplicationInfo) cls5.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{28517, 50229, 46263, 12365}, new char[]{43044, 64114, 39814, 35591, 12792, 61675, 2894, 43856, 45581, 10084, 62630, 4854, 40513, 59477, 12564, 56235, 22073, 2782, Typography.degree, 43294, 48260, 43279, 48228, 65008, 62353, 7586, 41622, 58908, 47925, 11055, 37613, 15250, 46562, 15882, 23802, 22829, 44290, 27402, 40437, 9756, 46922, 37057, 30543, 23328, 22480, 26266, 20388, 32071, 54567, 23874, 6308, 17514, 10621, 16147, 10155, 19852, 44352, 17896, 55228, 26176, 33186, 28382, 55200, 60519}, new char[]{0, 0, 0, 0}, objArr12);
                                String str3 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                d((char) (super.getResources().getString(R.string.category_food_beverages).substring(5, 7).codePointAt(1) - 110), ViewConfiguration.getMaximumDrawingCacheSize() >> 24, new char[]{8344, 21300, 1139, 35626}, new char[]{61193, 29532, 59783, 31763, 44835, 21604, 17783, 13088, 28660, 61001, 21167, 4196, 11745, 62949, 39486, 35230, 19152, 50072, 3269, 14595, 2004, 35123, 33205, 26922, 19628, 17700, 28714, 50616, 35601, 60835, 49591, 16698, 24956, 27336, 5203, 23352, 303, 34509, 39806, 27383, 51126, 26109, 40942, 18608, 60807, 28171, 10863, 3706, 53146, 31001, 614, 9900, 52110, 6159, 7513, 32065, 57698, 39380, 4257, 19121}, new char[]{0, 0, 0, 0}, objArr13);
                                String str4 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                d((char) (super.getResources().getString(R.string.text_guaranteed_comfort_and_safety).substring(18, 20).codePointAt(0) + 13917), getPackageName().codePointAt(2) - 46, new char[]{62894, 16433, 32251, 19510}, new char[]{65344, 24924, 55394, 27763, 55094, 10239}, new char[]{0, 0, 0, 0}, objArr14);
                                try {
                                    Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr15);
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
            }
            try {
                Object[] objArr16 = new Object[1];
                e(KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr16);
                Class<?> cls6 = Class.forName((String) objArr16[0]);
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[34] + 1);
                Object[] objArr17 = new Object[1];
                e(b, (byte) (b & 40), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 4, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                        byte b2 = (byte) ($$d[0] - 1);
                        Object[] objArr19 = new Object[1];
                        f(b2, b2, $$d[9], objArr19);
                        obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {-1590327917, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, TextUtils.lastIndexOf("", '0', 0) + 19, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleAuthActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d((char) (1245 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), getPackageName().codePointAt(5) - 110, new char[]{47417, 43770, 56687, 11268}, new char[]{5584, 23323, 20540, 34416, 61697, 8914, 9875, 64304, 4708, 20612, 42155, 5530, 37476, 9397, 21391, 37064, 60005, 29258, 21986, 43579, 64454, 57671, 28551, 35524, 10939, 31304}, new char[]{0, 0, 0, 0}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d((char) (37929 - (ViewConfiguration.getEdgeSlop() >> 16)), super.getResources().getString(R.string.username_add).substring(8, 9).length() - 1, new char[]{64792, 11107, 10634, 13204}, new char[]{30053, 27538, 29131, 30544, 32151, 24095, 36629, 47451, 47789, 34183, 57367, 27418, 28698, 4488, 15667, 21066, 48661, 47511}, new char[]{0, 0, 0, 0}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (KeyEvent.getMaxKeyCode() >> 16), TextUtils.lastIndexOf("", '0', 0) + 36, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 17 - ImageFormat.getBitsPerPixel(0), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // com.iap.ac.android.gol.google.GolGoogleAuthActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d((char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1245), super.getResources().getString(R.string.passkey_enrollment_tnc_description_tnc_link).substring(18, 19).codePointAt(0) - 32, new char[]{47417, 43770, 56687, 11268}, new char[]{5584, 23323, 20540, 34416, 61697, 8914, 9875, 64304, 4708, 20612, 42155, 5530, 37476, 9397, 21391, 37064, 60005, 29258, 21986, 43579, 64454, 57671, 28551, 35524, 10939, 31304}, new char[]{0, 0, 0, 0}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d((char) (super.getResources().getString(R.string.error_too_many_transactions).substring(11, 12).codePointAt(0) + 37897), super.getResources().getString(R.string.res_0x7f131606_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2).substring(5, 6).codePointAt(0) - 115, new char[]{64792, 11107, 10634, 13204}, new char[]{30053, 27538, 29131, 30544, 32151, 24095, 36629, 47451, 47789, 34183, 57367, 27418, 28698, 4488, 15667, 21066, 48661, 47511}, new char[]{0, 0, 0, 0}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 35 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), TextUtils.getOffsetAfter("", 0) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleAuthActivity
    public final void initSDK(final InitCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "");
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        AlipayConnectInitializer alipayConnectInitializer = ((DanaApplication) application).getAlipayConnectInitializer();
        ACLog.e("GolGoogleAuthActivity", "initSDK");
        Intrinsics.checkNotNullExpressionValue(alipayConnectInitializer, "");
        IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(alipayConnectInitializer, new Function0<Unit>() { // from class: id.dana.googlebinding.GoogleBindingWaitingActivity$initSDK$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                InitCallback.this.onSuccess();
            }
        });
    }

    private static void d(char c, int i, char[] cArr, char[] cArr2, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr2.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (PlaceComponentResult ^ 4360990799332652212L)) ^ ((int) (lookAheadTest ^ 4360990799332652212L))) ^ ((char) (scheduleImpl ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
