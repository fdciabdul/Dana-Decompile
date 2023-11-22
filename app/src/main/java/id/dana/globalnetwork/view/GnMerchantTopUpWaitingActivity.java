package id.dana.globalnetwork.view;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.gol.google.GolGoogleTopUpActivity;
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
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/globalnetwork/view/GnMerchantTopUpWaitingActivity;", "Lcom/iap/ac/android/gol/google/GolGoogleTopUpActivity;", "Lcom/iap/ac/android/biz/common/callback/InitCallback;", "callback", "", "initSDK", "(Lcom/iap/ac/android/biz/common/callback/InitCallback;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GnMerchantTopUpWaitingActivity extends GolGoogleTopUpActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$d = {36, -25, -14, -85, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 141;
    public static final byte[] MyBillsEntityDataFactory = {72, -11, 97, 122, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 144;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {39612, 39601, 39611, 39597, 39598, 39604, 39537, 39599, 39516, 39610, 39595, 39593, 39588, 39499, 39607, 39608, 39592, 39603, 39594, 39503, 39600, 39496, 39526, 39529, 39527, 39535, 39524, 39609, 39533, 39532, 39530, 39531, 39613, 39528, 39525, 39534, 39606, 39596};
    private static boolean getErrorConfigVersion = true;
    private static boolean lookAheadTest = true;
    private static int moveToNextValue = 909154847;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = r7 + 16
            byte[] r0 = id.dana.globalnetwork.view.GnMerchantTopUpWaitingActivity.MyBillsEntityDataFactory
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L33
        L17:
            r3 = 0
        L18:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L33:
            int r9 = r9 + r6
            int r6 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.globalnetwork.view.GnMerchantTopUpWaitingActivity.f(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 21
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r7 = 46 - r7
            byte[] r0 = id.dana.globalnetwork.view.GnMerchantTopUpWaitingActivity.$$d
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r7
            r7 = r6
            goto L37
        L18:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L1d:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L2e
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2e:
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L37:
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.globalnetwork.view.GnMerchantTopUpWaitingActivity.g(short, int, short, java.lang.Object[]):void");
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

    @Override // com.iap.ac.android.gol.google.GolGoogleTopUpActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        e(null, 127 - Gravity.getAbsoluteGravity(0, 0), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        e(null, 128 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getTrimmedLength(""), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    e(null, 127 - (Process.myPid() >> 22), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    e(null, 127 - (ViewConfiguration.getTouchSlop() >> 8), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    e(null, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 127, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    e(null, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 126, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    e(null, MotionEvent.axisFromString("") + 128, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                f((byte) (PlaceComponentResult >>> 2), MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (MyBillsEntityDataFactory[35] - 1);
                byte b2 = MyBillsEntityDataFactory[25];
                Object[] objArr14 = new Object[1];
                f(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getTouchSlop() >> 8), 4 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                        Object[] objArr16 = new Object[1];
                        g($$d[78], $$d[53], $$d[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 15, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), TextUtils.indexOf("", "", 0, 0) + 15, (char) Color.green(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 816, 30 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (57994 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), KeyEvent.normalizeMetaState(0) + 15, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, Color.red(0) + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {555373802, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, 17 - ExpandableListView.getPackedPositionChild(0L), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                f((byte) (PlaceComponentResult >>> 2), MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (MyBillsEntityDataFactory[35] - 1);
                byte b4 = MyBillsEntityDataFactory[25];
                Object[] objArr20 = new Object[1];
                f(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - ExpandableListView.getPackedPositionGroup(0L), 46 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr22 = new Object[1];
                        g((byte) ($$d[78] - 1), $$d[84], $$d[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), Drawable.resolveOpacity(0, 0) + 35, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {555373802, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                f((byte) (PlaceComponentResult >>> 2), MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (MyBillsEntityDataFactory[35] - 1);
                byte b6 = MyBillsEntityDataFactory[25];
                Object[] objArr26 = new Object[1];
                f(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 119, 3 - View.MeasureSpec.getSize(0), (char) (TextUtils.getCapsMode("", 0, 0) + 38968));
                        Object[] objArr28 = new Object[1];
                        g((byte) ($$d[78] - 1), $$d[84], $$d[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {555373802, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                f((byte) (PlaceComponentResult >>> 2), MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (MyBillsEntityDataFactory[35] - 1);
                byte b8 = MyBillsEntityDataFactory[25];
                Object[] objArr32 = new Object[1];
                f(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 2 - TextUtils.lastIndexOf("", '0', 0), (char) (TextUtils.lastIndexOf("", '0') + 1));
                        byte b9 = $$d[8];
                        byte b10 = (byte) ($$d[78] - 1);
                        Object[] objArr34 = new Object[1];
                        g(b9, b10, b10, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myTid() >> 22), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {555373802, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.iap.ac.android.gol.google.GolGoogleTopUpActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleTopUpActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleTopUpActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleTopUpActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        e(null, getPackageName().length() + 120, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        e(null, getPackageName().length() + 120, new byte[]{-125, -122, -106, -115, -107}, null, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                e(null, super.getResources().getString(R.string.caption_promo_merchant).substring(0, 8).codePointAt(3) + 28, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                e(null, getPackageName().length() + 120, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    e(null, getPackageName().codePointAt(4) + 30, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr6);
                    String str = (String) objArr6[0];
                    try {
                        Object[] objArr7 = new Object[1];
                        f(MyBillsEntityDataFactory[9], (byte) (-MyBillsEntityDataFactory[30]), MyBillsEntityDataFactory[25], objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        f(MyBillsEntityDataFactory[59], MyBillsEntityDataFactory[56], (byte) (-MyBillsEntityDataFactory[5]), objArr8);
                        Object[] objArr9 = new Object[1];
                        e(null, ((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        e(null, super.getResources().getString(R.string.account_take_over_desc).substring(2, 3).codePointAt(0) + 10, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr10);
                        String str3 = (String) objArr10[0];
                        try {
                            Object[] objArr11 = new Object[1];
                            f(MyBillsEntityDataFactory[9], (byte) (-MyBillsEntityDataFactory[30]), MyBillsEntityDataFactory[25], objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            f(MyBillsEntityDataFactory[59], MyBillsEntityDataFactory[56], (byte) (-MyBillsEntityDataFactory[5]), objArr12);
                            Object[] objArr13 = new Object[1];
                            e(null, ((ApplicationInfo) cls4.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            e(null, View.resolveSize(0, 0) + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), 18 - KeyEvent.keyCodeFromString(""), (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            f((byte) (PlaceComponentResult >>> 2), MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            byte b = (byte) (MyBillsEntityDataFactory[35] - 1);
            byte b2 = MyBillsEntityDataFactory[25];
            Object[] objArr17 = new Object[1];
            f(b, b2, (byte) (b2 | 8), objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776722) - Color.rgb(0, 0, 0), 3 - ImageFormat.getBitsPerPixel(0), (char) TextUtils.indexOf("", "", 0));
                    byte b3 = $$d[8];
                    byte b4 = (byte) ($$d[78] - 1);
                    Object[] objArr19 = new Object[1];
                    g(b3, b4, b4, objArr19);
                    obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {-1287976285, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, Color.red(0) + 18, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    @Override // com.iap.ac.android.gol.google.GolGoogleTopUpActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(null, super.getResources().getString(R.string.sendmoney_summary_x2c_toolbar_title).substring(14, 15).length() + 126, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            e(null, 127 - Drawable.resolveOpacity(0, 0), new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // com.iap.ac.android.gol.google.GolGoogleTopUpActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(null, super.getResources().getString(R.string.bottom_on_boarding_subtitle_my_bills_third).substring(6, 7).length() + 126, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            e(null, getPackageName().length() + 120, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionGroup(0L), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // com.iap.ac.android.gol.google.GolGoogleTopUpActivity
    public final void initSDK(final InitCallback callback) {
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        AlipayConnectInitializer alipayConnectInitializer = ((DanaApplication) application).getAlipayConnectInitializer();
        Intrinsics.checkNotNullExpressionValue(alipayConnectInitializer, "");
        IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(alipayConnectInitializer, new Function0<Unit>() { // from class: id.dana.globalnetwork.view.GnMerchantTopUpWaitingActivity$initSDK$1
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
                InitCallback initCallback = InitCallback.this;
                if (initCallback != null) {
                    initCallback.onSuccess();
                }
            }
        });
    }

    private static void e(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ moveToNextValue);
        if (lookAheadTest) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (getErrorConfigVersion) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
