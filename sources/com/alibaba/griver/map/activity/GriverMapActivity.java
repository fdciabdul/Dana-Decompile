package com.alibaba.griver.map.activity;

import android.content.Context;
import android.content.Intent;
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
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.OnAdapterMapReadyCallback;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.alipay.mobile.framework.service.impl.MapServiceImpl;
import com.alipay.mobile.map.model.LatLonPointEx;
import com.alipay.mobile.map.widget.APMapView;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.permission.ManifestPermission;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes6.dex */
public class GriverMapActivity extends FragmentActivity {
    public static final String TAG = "GriverMapActivity";

    /* renamed from: a  reason: collision with root package name */
    private APMapView f6649a;
    public static final byte[] $$a = {56, -119, 46, TarHeader.LF_CONTIG, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = WSContextConstant.HANDSHAKE_RECEIVE_SIZE;
    public static final byte[] getAuthRequestContext = {94, Ascii.EM, -44, 73, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = BlobStatic.MONITOR_IMAGE_WIDTH;
    private static int[] KClassImpl$Data$declaredNonStaticMembers$2 = {1126603165, -1794192287, -1567708916, 2000100358, -1277771489, 26032810, -1341319180, 837435265, 909278954, 1384081451, -912289415, -1566410855, 1291261326, -2008290774, -1237096788, 457335005, -1042898979, -727817896};

    private static void c(int i, byte b, byte b2, Object[] objArr) {
        byte[] bArr = getAuthRequestContext;
        int i2 = 56 - b;
        int i3 = 106 - b2;
        int i4 = 23 - i;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i3 = (i3 + (-i6)) - 4;
            i6 = i6;
            i2++;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i2];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i3 = (i3 + (-b3)) - 4;
            i6 = i6;
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r8, byte r9, short r10, java.lang.Object[] r11) {
        /*
            int r9 = r9 * 2
            int r9 = r9 + 75
            int r8 = r8 + 4
            byte[] r0 = com.alibaba.griver.map.activity.GriverMapActivity.$$a
            int r10 = r10 * 3
            int r10 = r10 + 21
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L18
            r9 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L35
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r10) goto L2a
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L35:
            int r10 = -r10
            int r8 = r8 + r10
            int r8 = r8 + (-7)
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.map.activity.GriverMapActivity.d(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(View.MeasureSpec.makeMeasureSpec(0, 0) + 18, new int[]{-67874253, -937669640, 575494659, -1093195622, -990148447, -1297095880, 913981356, -1311482529, -1355514106, -81558513}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 4, new int[]{998961131, -1714002894, -1161056714, 1139524963}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 48, new int[]{-231485290, 1797838036, -1422982800, 1855177490, -1664646205, -784355576, -175346090, -1100908112, 731725341, 538359685, -1462813958, 1226099332, -1502973928, 652149036, 695521613, 465913155, -1891643466, 1864143, -1848840171, -94351256, 807906988, 40204554, 1490235289, 2007285887}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(64 - View.getDefaultSize(0, 0), new int[]{1775049365, 321940618, -1097540919, 961261735, 1930205336, -744181929, -2004862309, 697206309, 684143294, -143001826, 1466789194, -1556813718, -1249677426, 260156783, 193834411, 770354257, -1134935446, -1558978586, 1603052328, 1596754739, 1937507619, 67795314, -1203831877, 899393095, 701811414, 605934969, 369535758, -871563103, 1183541956, 931252548, -272503715, 2019044188}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(KeyEvent.normalizeMetaState(0) + 64, new int[]{1887265532, -528051639, -1822499674, 149672036, 596266444, -1515739566, 480301001, -1316196862, -698386701, -1024570707, -1928826653, -2066313679, 1132163871, 2041043, 798160306, -1060945589, -737230830, 1365485971, 876678814, -590343486, 2037559013, -647382793, 97546597, -1010991808, 1684305795, -168709568, 1320483135, 891641367, 1283705009, 1604822619, 967497262, 1721152073}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(MotionEvent.axisFromString("") + 61, new int[]{1299968263, 2057449012, -1536021535, 457250715, 14973693, 674733418, 753284709, -439430297, 475509092, 1633085711, -1934128788, 954591079, 35021216, 1350258049, -235720026, 1356948107, -1953260590, 135476410, 875260248, 55323566, -861477268, -75084025, 935292670, -1099678586, -821788560, 637553739, 1864114209, 762837063, 1137996425, -1713073088}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(7 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new int[]{1225480231, -1077122473, 1697303441, 1110534477}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, 18 - TextUtils.indexOf("", "", 0, 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                c(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                c(getAuthRequestContext[30], Ascii.RS, getAuthRequestContext[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - KeyEvent.keyCodeFromString(""), 3 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) TextUtils.getCapsMode("", 0, 0));
                        byte b = $$a[78];
                        byte b2 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        d(b, b2, b2, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 800, 15 - Color.red(0), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 800, Color.argb(0, 0, 0, 0) + 15, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 29, (char) (57994 - (ViewConfiguration.getLongPressTimeout() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 800, MotionEvent.axisFromString("") + 16, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-681183928, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                c(getAuthRequestContext[30], Ascii.RS, getAuthRequestContext[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.green(0), Color.blue(0) + 46, (char) (Process.myPid() >> 22));
                        Object[] objArr22 = new Object[1];
                        d((byte) (-$$a[28]), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, Color.argb(0, 0, 0, 0) + 35, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-681183928, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), 17 - TextUtils.lastIndexOf("", '0', 0), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                c(getAuthRequestContext[30], Ascii.RS, getAuthRequestContext[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getEdgeSlop() >> 16), Color.rgb(0, 0, 0) + 16777219, (char) (38968 - (ViewConfiguration.getEdgeSlop() >> 16)));
                        Object[] objArr28 = new Object[1];
                        d((byte) (-$$a[28]), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-681183928, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, TextUtils.indexOf("", "") + 18, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                c(getAuthRequestContext[30], Ascii.RS, getAuthRequestContext[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Color.green(0), 3 - View.MeasureSpec.getMode(0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)));
                        Object[] objArr34 = new Object[1];
                        d($$a[40], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-681183928, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(getPackageName().length() + 11, new int[]{-67874253, -937669640, 575494659, -1093195622, -990148447, -1297095880, 913981356, -1311482529, -1355514106, -81558513}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr3 = new Object[1];
            c(b, (byte) (b | TarHeader.LF_BLK), (byte) (-getAuthRequestContext[32]), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            c(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[48], new Object[1]);
            Object[] objArr4 = new Object[1];
            b(((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 28, new int[]{998961131, -1714002894, -1161056714, 1139524963}, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    b((ViewConfiguration.getScrollBarSize() >> 8) + 26, new int[]{-67874253, -937669640, 575494659, -1093195622, 320541310, 279983123, 1039281441, -1089792185, 1947681095, 389177913, -1357517933, -512831461, -693252305, 2069622349}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(18 - (ViewConfiguration.getPressedStateDuration() >> 16), new int[]{-734993926, -1649087179, -1258078823, -765355423, -831098332, 1636500082, -421494565, -1811662390, 89433820, 33228342}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        b(super.getResources().getString(R.string.request_money_card_add_bank_title).substring(14, 15).codePointAt(0) - 62, new int[]{-231485290, 1797838036, -1422982800, 1855177490, -1664646205, -784355576, -175346090, -1100908112, 731725341, 538359685, -1462813958, 1226099332, -1502973928, 652149036, 695521613, 465913155, -1891643466, 1864143, -1848840171, -94351256, 807906988, 40204554, 1490235289, 2007285887}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        b(super.getResources().getString(R.string.merchant_address_label).substring(0, 1).length() + 63, new int[]{1775049365, 321940618, -1097540919, 961261735, 1930205336, -744181929, -2004862309, 697206309, 684143294, -143001826, 1466789194, -1556813718, -1249677426, 260156783, 193834411, 770354257, -1134935446, -1558978586, 1603052328, 1596754739, 1937507619, 67795314, -1203831877, 899393095, 701811414, 605934969, 369535758, -871563103, 1183541956, 931252548, -272503715, 2019044188}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(Color.red(0) + 64, new int[]{1887265532, -528051639, -1822499674, 149672036, 596266444, -1515739566, 480301001, -1316196862, -698386701, -1024570707, -1928826653, -2066313679, 1132163871, 2041043, 798160306, -1060945589, -737230830, 1365485971, 876678814, -590343486, 2037559013, -647382793, 97546597, -1010991808, 1684305795, -168709568, 1320483135, 891641367, 1283705009, 1604822619, 967497262, 1721152073}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(getPackageName().codePointAt(2) + 14, new int[]{1299968263, 2057449012, -1536021535, 457250715, 14973693, 674733418, 753284709, -439430297, 475509092, 1633085711, -1934128788, 954591079, 35021216, 1350258049, -235720026, 1356948107, -1953260590, 135476410, 875260248, 55323566, -861477268, -75084025, 935292670, -1099678586, -821788560, 637553739, 1864114209, 762837063, 1137996425, -1713073088}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(getPackageName().codePointAt(1) - 94, new int[]{1225480231, -1077122473, 1697303441, 1110534477}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            try {
                Object[] objArr13 = new Object[1];
                c(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr13);
                Class<?> cls4 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                c(getAuthRequestContext[30], Ascii.RS, getAuthRequestContext[9], objArr14);
                try {
                    Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 5 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr16 = new Object[1];
                        d($$a[40], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr16);
                        obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                    int i = ((int[]) objArr17[1])[0];
                    if (((int[]) objArr17[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr18 = {1783076041, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr18);
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
                    super.onCreate(bundle);
                    setContentView(com.alibaba.griver.map.R.layout.griver_map_activity_h5map);
                    findViewById(com.alibaba.griver.map.R.id.h5_nav_back).setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.map.activity.GriverMapActivity.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            GriverMapActivity.this.finish();
                        }
                    });
                    final ViewGroup viewGroup = (ViewGroup) findViewById(com.alibaba.griver.map.R.id.container);
                    MapServiceImpl mapServiceImpl = new MapServiceImpl();
                    final Intent intent = getIntent();
                    if (intent == null) {
                        RVLogger.d(TAG, "intent == null");
                        return;
                    }
                    a();
                    APMapView aPMapView = (APMapView) mapServiceImpl.getMapView(this);
                    this.f6649a = aPMapView;
                    if (aPMapView == null) {
                        RVLogger.d(TAG, "apMapView == null");
                        return;
                    }
                    aPMapView.setShowMarkerInfoWindowEnable(false);
                    this.f6649a.setOnMarkerClickListener(new AdapterAMap.OnAdapterMarkerClickListener() { // from class: com.alibaba.griver.map.activity.GriverMapActivity.2
                        @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMarkerClickListener
                        public boolean onMarkerClick(AdapterMarker adapterMarker) {
                            return true;
                        }
                    });
                    try {
                        this.f6649a.onCreateView(bundle, new OnAdapterMapReadyCallback() { // from class: com.alibaba.griver.map.activity.GriverMapActivity.3
                            @Override // com.alipay.mobile.apmap.OnAdapterMapReadyCallback
                            public void onAdapterMapReady(AdapterAMap adapterAMap) {
                                double doubleExtra = intent.getDoubleExtra("longitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                double doubleExtra2 = intent.getDoubleExtra("latitude", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                int intExtra = intent.getIntExtra(H5MapRenderOptimizer.KEY_SCALE, 16);
                                String stringExtra = intent.getStringExtra("name");
                                String stringExtra2 = intent.getStringExtra("address");
                                intent.getStringExtra("hidden");
                                GriverMapActivity.this.f6649a.setHiddenInfo("0_1");
                                LatLonPointEx latLonPointEx = new LatLonPointEx(doubleExtra2, doubleExtra);
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    latLonPointEx.setTitle(stringExtra);
                                }
                                latLonPointEx.setSnippet(stringExtra2);
                                GriverMapActivity.this.f6649a.showPointEx(latLonPointEx, intExtra);
                                StringBuilder sb = new StringBuilder();
                                sb.append("onCreate = ");
                                sb.append(intent.toUri(1));
                                RVLogger.d(GriverMapActivity.TAG, sb.toString());
                                GriverMapActivity.this.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.map.activity.GriverMapActivity.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        viewGroup.addView((View) GriverMapActivity.this.f6649a, new ViewGroup.LayoutParams(-1, -1));
                                    }
                                });
                            }
                        });
                    } catch (Throwable th5) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("open H5MapActivity fail: ");
                        sb.append(Log.getStackTraceString(th5));
                        RVLogger.e(TAG, sb.toString());
                    }
                } catch (Throwable th6) {
                    Throwable cause5 = th6.getCause();
                    if (cause5 == null) {
                        throw th6;
                    }
                    throw cause5;
                }
            } catch (Throwable th7) {
                Throwable cause6 = th7.getCause();
                if (cause6 == null) {
                    throw th7;
                }
                throw cause6;
            }
        } catch (Throwable th8) {
            Throwable cause7 = th8.getCause();
            if (cause7 == null) {
                throw th8;
            }
            throw cause7;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        APMapView aPMapView = this.f6649a;
        if (aPMapView != null) {
            aPMapView.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((KeyEvent.getMaxKeyCode() >> 16) + 26, new int[]{-67874253, -937669640, 575494659, -1093195622, 320541310, 279983123, 1039281441, -1089792185, 1947681095, 389177913, -1357517933, -512831461, -693252305, 2069622349}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                c(b, (byte) (b | TarHeader.LF_BLK), (byte) (-getAuthRequestContext[32]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                c(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[48], new Object[1]);
                Object[] objArr3 = new Object[1];
                b(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{-734993926, -1649087179, -1258078823, -765355423, -831098332, 1636500082, -421494565, -1811662390, 89433820, 33228342}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), KeyEvent.getDeadChar(0, 0) + 35, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        APMapView aPMapView = this.f6649a;
        if (aPMapView != null) {
            aPMapView.onResumeView();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(Drawable.resolveOpacity(0, 0) + 26, new int[]{-67874253, -937669640, 575494659, -1093195622, 320541310, 279983123, 1039281441, -1089792185, 1947681095, 389177913, -1357517933, -512831461, -693252305, 2069622349}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(super.getResources().getString(R.string.lbl_profile_completion_tooltip_title).substring(8, 9).codePointAt(0) - 96, new int[]{-734993926, -1649087179, -1258078823, -765355423, -831098332, 1636500082, -421494565, -1811662390, 89433820, 33228342}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), TextUtils.indexOf("", "", 0) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        APMapView aPMapView = this.f6649a;
        if (aPMapView != null) {
            aPMapView.onPauseView();
        }
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        APMapView aPMapView = this.f6649a;
        if (aPMapView != null) {
            aPMapView.onSaveInstance(bundle);
        }
    }

    private void a() {
        if (ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, ManifestPermission.ACCESS_COARSE_LOCATION) == 0) {
            return;
        }
        ActivityCompat.BuiltInFictitiousFunctionClassFactory(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 101);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 101 && iArr.length > 0 && iArr[0] == 0) {
            a();
        }
    }

    private static void b(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
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
        int[] iArr5 = KClassImpl$Data$declaredNonStaticMembers$2;
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
