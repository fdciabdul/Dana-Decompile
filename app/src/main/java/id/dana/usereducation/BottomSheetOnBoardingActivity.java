package id.dana.usereducation;

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
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.extension.UnbinderKtx;
import id.dana.base.extension.UnbinderKtx$$ExternalSyntheticLambda0;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.BottomSheetOnBoardingComponent;
import id.dana.di.component.DaggerBottomSheetOnBoardingComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.extension.ContextExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.onboarding.view.SimplePagerAdapter;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.constant.BottomSheetType;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes2.dex */
public class BottomSheetOnBoardingActivity extends BaseActivity implements BottomSheetOnBoardingContract.View {
    public static final int ON_BOARDING_REQUEST_CODE = 201;
    private List<BaseSimpleView> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String PlaceComponentResult;
    @BindView(R.id.btn_next_on_boarding)
    DanaButtonPrimaryView btnNext;
    @BindView(R.id.btn_previous_on_boarding)
    DanaButtonSecondaryView btnPrevious;
    private String getAuthRequestContext;
    private BottomSheetOnBoardingComponent getErrorConfigVersion;
    @Inject
    BottomSheetOnBoardingContract.Presenter presenter;
    private SimplePagerAdapter scheduleImpl;
    @BindView(R.id.tv_title_on_boarding)
    TextView tvTitleOnBoarding;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    public static final byte[] $$g = {Ascii.EM, 60, 112, -12, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$h = 246;
    public static final byte[] lookAheadTest = {45, -61, Ascii.ETB, 105, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 105;
    private static int[] DatabaseTableConfigUtil = {1104106303, -21811343, -714852511, 1737680980, -388940784, -1062664798, -9522450, 1451440820, -1232743200, 1726594998, -1443473789, 1831287663, 1385931319, 1309562321, 687580244, 721166151, 140873254, 883160868};

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            byte[] r0 = id.dana.usereducation.BottomSheetOnBoardingActivity.lookAheadTest
            int r6 = r6 + 4
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r4 = 0
            r8 = r7
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r7 = r7 + r3
            int r7 = r7 + (-4)
            int r6 = r6 + 1
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.usereducation.BottomSheetOnBoardingActivity.h(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(short r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.usereducation.BottomSheetOnBoardingActivity.$$g
            int r7 = 46 - r7
            int r9 = r9 * 3
            int r9 = 42 - r9
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L19:
            r3 = 0
        L1a:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.usereducation.BottomSheetOnBoardingActivity.j(short, byte, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(Color.argb(0, 0, 0, 0) + 18, new int[]{-244863060, -54311871, -378990514, -1506900174, -65178232, -1298690096, 1007851078, 227540357, 1602853571, 898958874}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(5 - TextUtils.getOffsetBefore("", 0), new int[]{497584727, 189220382, -739203685, 699959720}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(48 - Color.green(0), new int[]{-743098025, 1679026299, -382794891, 1890187598, 416660817, 1377724915, -1795377416, 1340622932, 325581327, -970983670, -1554395725, -2141806487, 1763689959, -560297370, -892049313, -78166069, 190351045, -979568807, 1076554209, -1452254935, -608900428, 1337462233, -1345687807, -2058450850}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(Process.getGidForName("") + 65, new int[]{-204701464, -1265160107, -750900374, -272391425, -658266184, -427430428, 1590700333, 229962299, -107547389, -422650038, 1443292708, 386011587, 1062687039, -1632521676, -1345826919, -1980186332, 1004779334, -143694674, -555952501, 2020667726, 433238363, 128881754, 1954269637, -1147089578, 1398106786, 621695727, 40738424, 854278402, -461645176, 66411967, -1204594310, 1453511116}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g((ViewConfiguration.getEdgeSlop() >> 16) + 64, new int[]{544290626, -2028378768, 2109867510, -1615470232, -117514078, -1523667607, -545396771, 1710742294, 970312276, -628614378, -357042295, 579163879, -1632844125, -1275652254, 1356124345, -1972963487, -137124481, -986765371, 173283987, -577719088, 212797335, 1517950873, -140739312, 246656488, -1000136359, 426439634, -195457890, 2014183508, -305625045, -1929542391, 1499555248, -2101578027}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(60 - ((Process.getThreadPriority(0) + 20) >> 6), new int[]{-2133592375, -1945134592, 1668511838, 1556945296, 969446400, 257682253, 1583606142, 824597679, 999206180, -1877950145, -1737628437, 616172094, 1819027546, -1206164207, 2052926220, -764487842, -1362557744, -1409238494, -1339426886, 924844127, -2060909351, 1071576104, 3902417, 1238180820, 940856275, -1449751006, -1732832755, -2018172679, 366043601, 1418327733}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(Color.rgb(0, 0, 0) + 16777222, new int[]{1336101184, -1688437722, -886837568, 750681261}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = lookAheadTest[25];
                Object[] objArr13 = new Object[1];
                h(37, b, b, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                h(lookAheadTest[35], lookAheadTest[25], lookAheadTest[7], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 3, (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                        Object[] objArr16 = new Object[1];
                        j($$g[53], $$g[12], $$g[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 14, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 15 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 29, (char) (ExpandableListView.getPackedPositionGroup(0L) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 15 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), (-16777181) - Color.rgb(0, 0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {87709521, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = lookAheadTest[25];
                Object[] objArr19 = new Object[1];
                h(37, b2, b2, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                h(lookAheadTest[35], lookAheadTest[25], lookAheadTest[7], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 61, KeyEvent.keyCodeFromString("") + 46, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
                        Object[] objArr22 = new Object[1];
                        j($$g[84], (byte) ($$g[78] - 1), $$g[8], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, AndroidCharacter.getMirror('0') - '\r', (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {87709521, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = lookAheadTest[25];
                Object[] objArr25 = new Object[1];
                h(37, b3, b3, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                h(lookAheadTest[35], lookAheadTest[25], lookAheadTest[7], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 118, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 2, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 38967));
                        Object[] objArr28 = new Object[1];
                        j($$g[84], (byte) ($$g[78] - 1), $$g[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {87709521, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), 18 - TextUtils.getCapsMode("", 0, 0), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = lookAheadTest[25];
                Object[] objArr31 = new Object[1];
                h(37, b4, b4, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                h(lookAheadTest[35], lookAheadTest[25], lookAheadTest[7], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.MeasureSpec.getMode(0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3, (char) (ExpandableListView.getPackedPositionChild(0L) + 1));
                        Object[] objArr34 = new Object[1];
                        j((byte) ($$g[78] - 1), $$g[9], (byte) ($$g[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {87709521, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        return R.layout.activity_on_boarding_bottom_sheet;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Method method;
        Object[] objArr2 = new Object[1];
        g(TextUtils.getOffsetBefore("", 0) + 18, new int[]{-244863060, -54311871, -378990514, -1506900174, -65178232, -1298690096, 1007851078, 227540357, 1602853571, 898958874}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        g(super.getResources().getString(R.string.verification_success).substring(0, 6).codePointAt(3) - 100, new int[]{497584727, 189220382, -739203685, 699959720}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                g(26 - TextUtils.indexOf("", ""), new int[]{-244863060, -54311871, -378990514, -1506900174, 302433910, 130286795, 1157908300, 1075747732, 1311023974, -576765357, 1270012079, -866148941, -325086989, -1171870785}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                g(18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new int[]{1661972993, 77835595, 554106537, 386185616, -1936430628, -417764681, 734586198, -68258399, -1791992611, -284208957}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    g(getPackageName().codePointAt(2) + 2, new int[]{-743098025, 1679026299, -382794891, 1890187598, 416660817, 1377724915, -1795377416, 1340622932, 325581327, -970983670, -1554395725, -2141806487, 1763689959, -560297370, -892049313, -78166069, 190351045, -979568807, 1076554209, -1452254935, -608900428, 1337462233, -1345687807, -2058450850}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    g(super.getResources().getString(R.string.send_money_wording_toast_after_rename_recent_saved_bank).substring(19, 20).codePointAt(0) - 51, new int[]{-204701464, -1265160107, -750900374, -272391425, -658266184, -427430428, 1590700333, 229962299, -107547389, -422650038, 1443292708, 386011587, 1062687039, -1632521676, -1345826919, -1980186332, 1004779334, -143694674, -555952501, 2020667726, 433238363, 128881754, 1954269637, -1147089578, 1398106786, 621695727, 40738424, 854278402, -461645176, 66411967, -1204594310, 1453511116}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(TextUtils.indexOf("", "") + 64, new int[]{544290626, -2028378768, 2109867510, -1615470232, -117514078, -1523667607, -545396771, 1710742294, 970312276, -628614378, -357042295, 579163879, -1632844125, -1275652254, 1356124345, -1972963487, -137124481, -986765371, 173283987, -577719088, 212797335, 1517950873, -140739312, 246656488, -1000136359, 426439634, -195457890, 2014183508, -305625045, -1929542391, 1499555248, -2101578027}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 60, new int[]{-2133592375, -1945134592, 1668511838, 1556945296, 969446400, 257682253, 1583606142, 824597679, 999206180, -1877950145, -1737628437, 616172094, 1819027546, -1206164207, 2052926220, -764487842, -1362557744, -1409238494, -1339426886, 924844127, -2060909351, 1071576104, 3902417, 1238180820, 940856275, -1449751006, -1732832755, -2018172679, 366043601, 1418327733}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(getPackageName().codePointAt(3) - 94, new int[]{1336101184, -1688437722, -886837568, 750681261}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
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
            byte b = lookAheadTest[25];
            Object[] objArr12 = new Object[1];
            h(37, b, b, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            Object[] objArr13 = new Object[1];
            h(lookAheadTest[35], lookAheadTest[25], lookAheadTest[7], objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 494, 4 - View.combineMeasuredStates(0, 0), (char) TextUtils.getOffsetAfter("", 0));
                    Object[] objArr15 = new Object[1];
                    j((byte) ($$g[78] - 1), $$g[9], (byte) ($$g[78] - 1), objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            method = obj4;
                            objArr = null;
                        } else {
                            objArr = null;
                            method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                        }
                        Object invoke2 = ((Method) method).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1489153602, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), View.combineMeasuredStates(0, 0) + 18, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
    public void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
    }

    @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
    public /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
        BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(super.getResources().getString(R.string.how_are_you).substring(3, 4).codePointAt(0) - 6, new int[]{-244863060, -54311871, -378990514, -1506900174, 302433910, 130286795, 1157908300, 1075747732, 1311023974, -576765357, 1270012079, -866148941, -325086989, -1171870785}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                h(lookAheadTest[25], (byte) (-lookAheadTest[30]), lookAheadTest[32], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                h((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 >>> 1), lookAheadTest[56], lookAheadTest[13], new Object[1]);
                Object[] objArr3 = new Object[1];
                g(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{1661972993, 77835595, 554106537, 386185616, -1936430628, -417764681, 734586198, -68258399, -1791992611, -284208957}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    public static Intent createOnBoardingIntent(Context context, OnBoardingModel onBoardingModel) {
        Intent intent = new Intent(context, BottomSheetOnBoardingActivity.class);
        intent.putExtra("data", onBoardingModel);
        return intent;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(super.getResources().getString(R.string.btn_check_code).substring(0, 1).length() + 25, new int[]{-244863060, -54311871, -378990514, -1506900174, 302433910, 130286795, 1157908300, 1075747732, 1311023974, -576765357, 1270012079, -866148941, -325086989, -1171870785}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new int[]{1661972993, 77835595, 554106537, 386185616, -1936430628, -417764681, 734586198, -68258399, -1791992611, -284208957}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.getSize(0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        if (isFinishing()) {
            overridePendingTransition(R.anim.f5032130772052, R.anim.f5082130772059);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.btn_next_on_boarding})
    public void onButtonNextClicked() {
        if (BuiltInFictitiousFunctionClassFactory()) {
            setResult(-1);
            finish();
            this.presenter.MyBillsEntityDataFactory(this.PlaceComponentResult);
            return;
        }
        ViewPager viewPager = this.viewPager;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.btn_previous_on_boarding})
    public void onButtonPreviousClicked() {
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            setResult(-1);
            finish();
            this.presenter.MyBillsEntityDataFactory(this.PlaceComponentResult);
            return;
        }
        ViewPager viewPager = this.viewPager;
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BuiltInFictitiousFunctionClassFactory() {
        return this.viewPager.getCurrentItem() == this.NetworkUserEntityData$$ExternalSyntheticLambda1.size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.viewPager.getCurrentItem() == 0;
    }

    static /* synthetic */ void access$300(BottomSheetOnBoardingActivity bottomSheetOnBoardingActivity, boolean z) {
        String string;
        DanaButtonPrimaryView danaButtonPrimaryView = bottomSheetOnBoardingActivity.btnNext;
        if (z) {
            string = bottomSheetOnBoardingActivity.getString(R.string.btnFinishOnboarding);
        } else {
            string = bottomSheetOnBoardingActivity.getString(R.string.btnNextOnboarding);
        }
        danaButtonPrimaryView.setContentDescription(string);
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        OnBoardingModel onBoardingModel;
        byte b = 0;
        if (this.getErrorConfigVersion == null) {
            DaggerBottomSheetOnBoardingComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerBottomSheetOnBoardingComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, BottomSheetOnBoardingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ApplicationComponent.class);
            this.getErrorConfigVersion = new DaggerBottomSheetOnBoardingComponent.BottomSheetOnBoardingComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, b);
        }
        this.getErrorConfigVersion.getAuthRequestContext(this);
        registerPresenter(this.presenter);
        Bundle extras = getIntent().getExtras();
        if (extras != null && (onBoardingModel = (OnBoardingModel) extras.getParcelable("data")) != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ArrayList();
            Iterator<ContentOnBoardingModel> it = onBoardingModel.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(new SimpleBottomSheetOnBoardingView(i, it.next()));
            }
            this.tvTitleOnBoarding.setText(onBoardingModel.lookAheadTest);
            this.PlaceComponentResult = onBoardingModel.getAuthRequestContext;
            String str = onBoardingModel.getErrorConfigVersion;
            this.getAuthRequestContext = str;
            if (BottomSheetType.SLIDESHOW.equals(str)) {
                this.btnPrevious.setVisibility(0);
            }
        }
        ContextExtKt.PlaceComponentResult(this);
        SimplePagerAdapter simplePagerAdapter = new SimplePagerAdapter(this);
        this.scheduleImpl = simplePagerAdapter;
        simplePagerAdapter.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.viewPager.setAdapter(this.scheduleImpl);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: id.dana.usereducation.BottomSheetOnBoardingActivity.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (BottomSheetType.SLIDESHOW.equals(BottomSheetOnBoardingActivity.this.getAuthRequestContext)) {
                    BottomSheetOnBoardingActivity.this.btnNext.setActiveButton(BottomSheetOnBoardingActivity.this.BuiltInFictitiousFunctionClassFactory() ? BottomSheetOnBoardingActivity.this.getString(R.string.bottom_on_boarding_button_next_last_item_close) : BottomSheetOnBoardingActivity.this.getString(R.string.bottom_on_boarding_button_next_default), null);
                    BottomSheetOnBoardingActivity.this.btnPrevious.setActiveButton(BottomSheetOnBoardingActivity.this.KClassImpl$Data$declaredNonStaticMembers$2() ? BottomSheetOnBoardingActivity.this.getString(R.string.bottom_on_boarding_button_previous_first_item) : BottomSheetOnBoardingActivity.this.getString(R.string.bottom_on_boarding_button_previous_default), null);
                } else {
                    BottomSheetOnBoardingActivity.this.btnNext.setActiveButton(BottomSheetOnBoardingActivity.this.BuiltInFictitiousFunctionClassFactory() ? BottomSheetOnBoardingActivity.this.getString(R.string.bottom_on_boarding_button_next_last_item) : BottomSheetOnBoardingActivity.this.getString(R.string.bottom_on_boarding_button_next_default), null);
                }
                BottomSheetOnBoardingActivity bottomSheetOnBoardingActivity = BottomSheetOnBoardingActivity.this;
                BottomSheetOnBoardingActivity.access$300(bottomSheetOnBoardingActivity, bottomSheetOnBoardingActivity.BuiltInFictitiousFunctionClassFactory());
            }
        });
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        List<BaseSimpleView> list = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (list != null && !list.isEmpty()) {
            Iterator<BaseSimpleView> it = this.NetworkUserEntityData$$ExternalSyntheticLambda1.iterator();
            while (it.hasNext()) {
                Unbinder unbinder = it.next().getAuthRequestContext;
                if (unbinder != null) {
                    UnbinderKtx.getAuthRequestContext(unbinder, new UnbinderKtx$$ExternalSyntheticLambda0());
                }
            }
        }
        super.onDestroy();
    }

    private static void g(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = DatabaseTableConfigUtil;
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
        int[] iArr5 = DatabaseTableConfigUtil;
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
