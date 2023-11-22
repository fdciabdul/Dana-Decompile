package com.alipay.mobile.map.widget.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterLocationSource;
import com.alipay.mobile.apmap.AdapterMapView;
import com.alipay.mobile.apmap.OnAdapterMapReadyCallback;
import com.alipay.mobile.embedview.mapbiz.core.controller.LocationHelper;
import com.alipay.mobile.framework.service.OnLocateListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

/* loaded from: classes6.dex */
public class BaseMapViewImpl extends AdapterMapView implements AdapterLocationSource {

    /* renamed from: a */
    private String f7207a;
    private LocationHelper b;
    protected AdapterAMap mAMap;
    protected String mBizType;
    protected String mCity;
    protected Context mContext;
    protected boolean mIsMyLocationEnable;
    protected boolean mLocated;
    protected OnLocateListener mOnLocateListener;
    protected boolean mZoomControlEnable;

    protected void dismissProgressDialog() {
    }

    public void showProgressDialog(String str) {
    }

    public void stopLocation() {
    }

    public BaseMapViewImpl(Context context) {
        super(context);
        this.f7207a = "BaseMapViewImpl";
        this.mCity = "";
        this.mBizType = "";
        this.mLocated = false;
        this.mZoomControlEnable = false;
        this.mIsMyLocationEnable = true;
        init();
    }

    public BaseMapViewImpl(Context context, AttributeSet attributeSet) {
        super(new MapBizContextWrapper(context), attributeSet);
        this.f7207a = "BaseMapViewImpl";
        this.mCity = "";
        this.mBizType = "";
        this.mLocated = false;
        this.mZoomControlEnable = false;
        this.mIsMyLocationEnable = true;
        init();
    }

    public void init() {
        this.mContext = getContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class MapBizContextWrapper extends ContextThemeWrapper {
        Resources res = null;
        public static final byte[] $$a = {82, -89, -124, -60, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$b = 20;
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {22, 66, -65, -82, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int BuiltInFictitiousFunctionClassFactory = 164;
        private static long MyBillsEntityDataFactory = -2605968857306230238L;

        /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0028). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void b(int r5, short r6, byte r7, java.lang.Object[] r8) {
            /*
                int r7 = r7 * 15
                int r7 = r7 + 4
                int r6 = r6 + 105
                int r5 = r5 * 3
                int r5 = 16 - r5
                byte[] r0 = com.alipay.mobile.map.widget.impl.BaseMapViewImpl.MapBizContextWrapper.KClassImpl$Data$declaredNonStaticMembers$2
                byte[] r1 = new byte[r5]
                int r5 = r5 + (-1)
                r2 = 0
                if (r0 != 0) goto L16
                r4 = r7
                r3 = 0
                goto L28
            L16:
                r3 = 0
            L17:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r5) goto L24
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                r8[r2] = r5
                return
            L24:
                int r3 = r3 + 1
                r4 = r0[r7]
            L28:
                int r7 = r7 + 1
                int r6 = r6 + r4
                int r6 = r6 + 2
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.map.widget.impl.BaseMapViewImpl.MapBizContextWrapper.b(int, short, byte, java.lang.Object[]):void");
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
                int r6 = r6 * 2
                int r6 = r6 + 75
                int r8 = r8 * 3
                int r8 = r8 + 21
                int r7 = r7 + 4
                byte[] r0 = com.alipay.mobile.map.widget.impl.BaseMapViewImpl.MapBizContextWrapper.$$a
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                goto L35
            L1a:
                r3 = 0
            L1b:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r8) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L28:
                r4 = r0[r7]
                int r3 = r3 + 1
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
                int r6 = -r6
                int r7 = r7 + r6
                int r6 = r7 + (-7)
                int r7 = r8 + 1
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.map.widget.impl.BaseMapViewImpl.MapBizContextWrapper.c(byte, short, short, java.lang.Object[]):void");
        }

        @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            a(1494 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{49920, 50906, 51375, 53868, 54362, 56865, 57851, 60316, 60838, 63343, 63773, 33558, 34543, 35039, 37540, 38015, 40514, 41015}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            a(43889 - (Process.myPid() >> 22), new char[]{49932, 26729, 38358, 49499, 28353}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a(Color.red(0) + 2693, new char[]{50006, 51591, 54877, 56534, 59717, 63388, 64582, 35578, 38782, 40361, 43568, 45232, 48440, 19346, 20502, 24220, 27392, 29061, 32269, 1247, 4449, 8171, 9324, 12964, 16253, 50607, 53979, 57090, 58847, 61972, 63638, 34079, 37880, 39026, 42745, 45943, 47539, 18017, 19687, 22802, 26526, 27722, 31367, 1792, 3551, 6707, 8369, 11631}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(31121 - View.resolveSize(0, 0), new char[]{49920, 47813, 12405, 44982, 9539, 40077, 6711, 37294, 3981, 34075, 31986, 64111, 29129, 61197, 26302, 56362, 23107, 53746, 20277, 50835, 48209, 15285, 45345, 12117, 42703, 7210, 39906, 4431, 34949, 1640, 64941, 31708, 61730, 26804, 58903, 23946, 56166, 21239, 51415, 17989, 15868, 47976, 13006, 43019, 10222, 40235, 7006, 37577, 2146, 34707, 32004, 62651, 29228, 59475, 26567, 56695, 21737, 53785, 18904, 51048, 48812, 13524, 45595, 10749}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(TextUtils.indexOf((CharSequence) "", '0', 0) + 43854, new char[]{50003, 26653, 38302, 49892, 28268, 39895, 49309, 27726, 39217, 50924, 29275, 40735, 50380, 29115, 40295, 51925, 30672, 41753, 51263, 30130, 41303, 52818, 31646, 41145, 52334, 31106, 42634, 53830, 32619, 42174, 53328, 32081, 43766, 55272, 873, 43230, 54743, 375, 44601, 56290, 1873, 44114, 55794, 1722, 45669, 57304, 1238, 45088, 56695, 2789, 46600, 58195, 2295, 46497, 57657, 3807, 48014, 59249, 3114, 47592, 58635, 4621, 49138, 58539}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(35670 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{49929, 18498, 54715, 24852, 61006, 31720, 34628, 3119, 39357, 9487, 45673, 16317, 19291, 53374, 24011, 59658, 30324, 33735, 3851, 38007, 8652, 44337, 14959, 18334, 54062, 22635, 58838, 28990, 65153, 3017, 38690, 7325, 43488, 13604, 17034, 53162, 23358, 57501, 28134, 63759, 1688, 37886, 8014, 42195, 12796, 48452, 51876, 22525, 58178, 26802, 62896, 322, 36607, 6733, 42846, 11430, 47116, 50512, 21155, 56863}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 23356, new char[]{50008, 39026, 29999, 54008, 44967, 2913}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 18 - TextUtils.getCapsMode("", 0, 0), (char) Color.blue(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                    byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                    Object[] objArr13 = new Object[1];
                    b(b, b2, b2, objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                    byte b4 = b3;
                    Object[] objArr14 = new Object[1];
                    b(b3, b4, b4, objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 55, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 3, (char) View.resolveSizeAndState(0, 0, 0));
                            byte b5 = $$a[47];
                            Object[] objArr16 = new Object[1];
                            c(b5, (byte) (b5 - 1), $$a[47], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 16 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 800, TextUtils.indexOf("", "") + 15, (char) View.resolveSize(0, 0))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getScrollBarSize() >> 8), 28 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (57994 - (ViewConfiguration.getDoubleTapTimeout() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 800, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 14, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0))));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), 35 - Color.red(0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-424009656, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 17 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b6 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                    byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                    Object[] objArr19 = new Object[1];
                    b(b6, b7, b7, objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b8 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                    byte b9 = b8;
                    Object[] objArr20 = new Object[1];
                    b(b8, b9, b9, objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 61, 46 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0')));
                            Object[] objArr22 = new Object[1];
                            c((byte) (-$$a[9]), (byte) ($$b + 3), (byte) ($$a[47] - 1), objArr22);
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
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), 35 - TextUtils.indexOf("", "", 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {-424009656, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, TextUtils.lastIndexOf("", '0') + 19, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b10 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                    byte b11 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                    Object[] objArr25 = new Object[1];
                    b(b10, b11, b11, objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b12 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                    byte b13 = b12;
                    Object[] objArr26 = new Object[1];
                    b(b12, b13, b13, objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.alpha(0), 3 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 38967));
                            Object[] objArr28 = new Object[1];
                            c((byte) (-$$a[9]), (byte) ($$b + 3), (byte) ($$a[47] - 1), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-424009656, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, View.resolveSize(0, 0) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b14 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                    byte b15 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                    Object[] objArr31 = new Object[1];
                    b(b14, b15, b15, objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b16 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                    byte b17 = b16;
                    Object[] objArr32 = new Object[1];
                    b(b16, b17, b17, objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getFadingEdgeLength() >> 16), Color.alpha(0) + 3, (char) TextUtils.indexOf("", "", 0, 0));
                            Object[] objArr34 = new Object[1];
                            c((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[8]), objArr34);
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
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {-424009656, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, Process.getGidForName("") + 19, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        public MapBizContextWrapper(Context context) {
            attachBaseContext(context);
        }

        @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return this.res;
        }

        private static void a(int i, char[] cArr, Object[] objArr) {
            getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (getonboardingscenario.getAuthRequestContext < cArr.length) {
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (MyBillsEntityDataFactory ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (getonboardingscenario.getAuthRequestContext < cArr.length) {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            }
            objArr[0] = new String(cArr2);
        }
    }

    @Override // android.view.View
    public Resources getResources() {
        return getContext().getResources();
    }

    public void onCreateView(Bundle bundle, final OnAdapterMapReadyCallback onAdapterMapReadyCallback) {
        super.onCreate(bundle);
        if (this.mAMap == null) {
            initMap(new OnAdapterMapReadyCallback() { // from class: com.alipay.mobile.map.widget.impl.BaseMapViewImpl.1
                {
                    BaseMapViewImpl.this = this;
                }

                @Override // com.alipay.mobile.apmap.OnAdapterMapReadyCallback
                public void onAdapterMapReady(AdapterAMap adapterAMap) {
                    BaseMapViewImpl.this.mAMap = adapterAMap;
                    BaseMapViewImpl.this.setUpMap();
                    OnAdapterMapReadyCallback onAdapterMapReadyCallback2 = onAdapterMapReadyCallback;
                    if (onAdapterMapReadyCallback2 != null) {
                        onAdapterMapReadyCallback2.onAdapterMapReady(adapterAMap);
                    }
                }
            });
        }
    }

    public void setUpMap() {
        AdapterAMap adapterAMap = this.mAMap;
        if (adapterAMap == null) {
            return;
        }
        adapterAMap.setLocationSource(this);
        this.mAMap.setMyLocationEnabled(this.mIsMyLocationEnable);
        this.mAMap.setOnMyLocationButtonClickListener(new AdapterAMap.OnMyLocationButtonClickListener() { // from class: com.alipay.mobile.map.widget.impl.BaseMapViewImpl.2
            {
                BaseMapViewImpl.this = this;
            }

            @Override // com.alipay.mobile.apmap.AdapterAMap.OnMyLocationButtonClickListener
            public void onMyLocationButtonClick() {
                LocationServices.getFusedLocationProviderClient(BaseMapViewImpl.this.mContext).getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() { // from class: com.alipay.mobile.map.widget.impl.BaseMapViewImpl.2.1
                    {
                        AnonymousClass2.this = this;
                    }

                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public void onSuccess(Location location) {
                        if (BaseMapViewImpl.this.b == null) {
                            BaseMapViewImpl.this.b = new LocationHelper();
                        }
                        BaseMapViewImpl.this.b.moveToLocation(BaseMapViewImpl.this.mContext, BaseMapViewImpl.this.mAMap, location);
                    }
                });
            }
        });
        if (this.mAMap.getUiSettings() != null) {
            this.mAMap.getUiSettings().setMyLocationButtonEnabled(true);
            this.mAMap.getUiSettings().setZoomControlsEnabled(this.mZoomControlEnable);
        }
    }

    public void onResumeView() {
        super.onResume();
    }

    public void onPauseView() {
        super.onPause();
    }

    public void onSaveInstance(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onDestroyView() {
        this.b = null;
        super.onDestroy();
        deactivate();
        try {
            AdapterAMap adapterAMap = this.mAMap;
            if (adapterAMap != null) {
                adapterAMap.clear();
            }
        } catch (Exception e) {
            RVLogger.d(this.f7207a, e.getMessage());
        }
    }

    @Override // com.alipay.mobile.apmap.AdapterLocationSource
    public void activate(AdapterLocationSource.OnAdapterLocationChangedListener onAdapterLocationChangedListener) {
        startLocate();
    }

    public void deactivate() {
        stopLocation();
    }

    public void startLocate() {
        String str = this.f7207a;
        StringBuilder sb = new StringBuilder();
        sb.append("startLocate mIsMyLocationEnable = ");
        sb.append(this.mIsMyLocationEnable);
        RVLogger.d(str, sb.toString());
    }

    public void setOnLocateListener(OnLocateListener onLocateListener) {
        this.mOnLocateListener = onLocateListener;
    }
}
