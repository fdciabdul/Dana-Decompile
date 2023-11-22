package id.dana.splitbill.view;

import android.app.Activity;
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
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSplitBillComponent;
import id.dana.di.component.SplitBillComponent;
import id.dana.di.modules.SplitBillModule;
import id.dana.domain.account.Account;
import id.dana.domain.splitbill.model.SplitBill;
import id.dana.model.CurrencyAmountModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.requestmoney.AmountCalculatorActivity;
import id.dana.requestmoney.BundleKey;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import id.dana.richview.LogoProgressView;
import id.dana.richview.splitbill.AmountDisplayView;
import id.dana.richview.splitbill.BillPayerView;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.remarks.NoteView;
import id.dana.splitbill.SplitBillContract;
import id.dana.splitbill.mapper.RecipientModelMapper;
import id.dana.splitbill.mapper.SplitBillPayerListMapper;
import id.dana.splitbill.mapper.SplitBillPayerToPayerModelMapper;
import id.dana.splitbill.mapper.SplitBillPayerToRecipientModelMapper;
import id.dana.splitbill.model.SplitBillPayerModel;
import id.dana.splitbill.tracker.SplitBillAnalyticTracker;
import id.dana.splitbill.view.SplitBillPayersView;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.OSUtil;
import id.dana.utils.RandomInteger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

/* loaded from: classes5.dex */
public class SplitBillActivity extends BaseActivity implements BillPayerView.Listener, SplitBillPayersView.Listener {
    private boolean DatabaseTableConfigUtil;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    @BindView(R.id.adv_split_bill)
    AmountDisplayView advSplitBill;
    @BindView(R.id.bpv_selection)
    BillPayerView bpvSelection;
    @BindView(R.id.btn_split_bill)
    Button btnSplitBill;
    @Inject
    GenerateDeepLinkContract.SplitBillPresenter deepLinkPresenter;
    private CurrencyAmountModel getErrorConfigVersion;
    @BindView(R.id.f4081progress_view)
    LogoProgressView logoProgressView;
    private SplitBillComponent lookAheadTest;
    @Inject
    GenerateDeepLinkContract.SplitBillPresenter presenter;
    @Inject
    RecipientModelMapper recipientModelMapper;
    @BindView(R.id.rv_remarks)
    NoteView rvRemarks;
    @BindView(R.id.sbpv_payers)
    SplitBillPayersView sbpvPayers;
    @Inject
    SplitBillAnalyticTracker splitBillAnalyticTracker;
    @Inject
    SplitBillPayerListMapper splitBillPayerMapper;
    @Inject
    SplitBillPayerToPayerModelMapper splitBillPayerToPayerModelMapper;
    @Inject
    SplitBillPayerToRecipientModelMapper splitBillPayerToRecipientModelMapper;
    @Inject
    SplitBillContract.Presenter splitBillPresenter;
    @BindView(R.id.v_touch_blocker)
    View touchBlockerView;
    @BindView(R.id.v_dim_body)
    View vDimBody;
    @BindView(R.id.v_dim_header)
    View vDimHeader;
    public static final byte[] $$a = {62, -79, -77, -78, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 162;
    public static final byte[] PlaceComponentResult = {16, -117, -56, -112, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 210;
    private static long GetContactSyncConfig = -5926696205423051504L;
    private static final int scheduleImpl = RandomInteger.BuiltInFictitiousFunctionClassFactory();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 97
            int r6 = r6 + 4
            int r8 = 23 - r8
            byte[] r0 = id.dana.splitbill.view.SplitBillActivity.PlaceComponentResult
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L17:
            r3 = 0
        L18:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
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
        L34:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillActivity.b(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r0 = id.dana.splitbill.view.SplitBillActivity.$$a
            int r8 = 46 - r8
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            int r8 = r8 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillActivity.c(byte, int, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(TextUtils.lastIndexOf("", '0', 0) + 30, new char[]{44082, 44064, 44045, 44150, 44104, 44203, 44185, 44214, 44244, 44325, 44383, 44348, 44413, 44357, 44454, 44421, 44528, 44493}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(TextUtils.indexOf("", "") + 42379, new char[]{44094, 2465, 59152, 23707, 14875}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(MotionEvent.axisFromString("") + 55764, new char[]{44132, 30179, 8131, 8466, 52015, 60712, 46744, 22702, 25340, 1117, 11790, 61476, 39378, 41942, 17896, 28472, 12626, 56161, 64691, 34459, 43083, 29311, 5138, 15760, 51199, 59899, 45829, 21878, 32629, 208, 10888, 52411, 38410, 47190, 16999, 27571, 3481, 55061, 63801, 33606, 42140, 20222, 4345, 14868, 56437, 58999, 36751, 20875}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(Gravity.getAbsoluteGravity(0, 0) + 35951, new char[]{44082, 8201, 46267, 2426, 40329, 4673, 59129, 31586, 53071, 17367, 53308, 42147, 14595, 36289, 624, 38630, 27281, 65342, 29691, 49247, 21659, 10617, 48623, 12697, 34317, 6886, 61228, 25475, 61519, 17572, 55651, 44304, 8656, 46712, 2777, 40774, 5036, 57403, 29721, 51337, 23870, 53668, 42496, 15047, 36644, 999, 38800, 25605, 63664, 19807, 49610, 22135, 10982, 48799, 13065, 34747, 5163, 59605, 32022, 61860, 18022, 55832, 44757, 9009}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(9186 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{44129, 36737, 60400, 51096, 9190, 7947, 31539, 22354, 45939, 61072, 51893, 9891, 710, 32487, 23049, 46633, 37378, 52773, 10641, 1518, 25053, 23982, 47536, 38149, 61740, 11550, 2404, 25754, 16609, 48258, 39166, 62541, 53252, 3188, 26695, 17506, 42973, 33707, 65495, 56318, 14099, 4974, 20316, 43846, 34671, 57988, 57080, 15004, 5797, 29209, 44646, 35343, 59005, 49565, 15831, 6563, 30156, 20973, 36100, 59700, 50433, 8561, 7324, 30903}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(62922 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{44091, 23022, 18357, 19832, 31492, 24708, 28362, 5123, 639, 2083, 13799, 9105, 10513, 55058, 56517, 51942, 61606, 65131, 58373, 37339, 40838, 34141, 45921, 47474, 42732, 44167, 23128, 16402, 19915, 31717, 25004, 28529, 5394, 712, 2180, 13830, 15476, 10801, 55272, 56803, 52058, 61714, 65216, 58559, 37558, 39016, 34346, 46033, 47504, 42846, 44350, 23342, 16565, 20193, 29776, 25098, 28622, 5628, 941, 2419}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((ViewConfiguration.getEdgeSlop() >> 16) + 45943, new char[]{44138, 7946, 51849, 46616, 25021, 11569}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((short) 36, (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((short) 21, (byte) (PlaceComponentResult[30] + 1), PlaceComponentResult[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), $$a[47], (byte) (-$$a[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getLongPressTimeout() >> 16), 15 - View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTouchSlop() >> 8), 15 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 815, (ViewConfiguration.getJumpTapTimeout() >> 16) + 29, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1742272519, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((short) 36, (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((short) 21, (byte) (PlaceComponentResult[30] + 1), PlaceComponentResult[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (Process.myTid() >> 22), 45 - TextUtils.lastIndexOf("", '0'), (char) TextUtils.indexOf("", ""));
                        byte b = (byte) ($$a[47] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b, b, $$a[20], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - TextUtils.getOffsetBefore("", 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1742272519, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 910, TextUtils.lastIndexOf("", '0') + 19, (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((short) 36, (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((short) 21, (byte) (PlaceComponentResult[30] + 1), PlaceComponentResult[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.getOffsetAfter("", 0), 3 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (38968 - Drawable.resolveOpacity(0, 0)));
                        byte b2 = (byte) ($$a[47] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b2, b2, $$a[20], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSize(0, 0), 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1742272519, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((short) 36, (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((short) 21, (byte) (PlaceComponentResult[30] + 1), PlaceComponentResult[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 107, TextUtils.lastIndexOf("", '0', 0) + 4, (char) TextUtils.getOffsetBefore("", 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1742272519, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), TextUtils.getOffsetBefore("", 0) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_split_bill;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.card_binding_permission_dialog_title).substring(0, 18).codePointAt(2) - 85, new char[]{44082, 44064, 44045, 44150, 44104, 44203, 44185, 44214, 44244, 44325, 44383, 44348, 44413, 44357, 44454, 44421, 44528, 44493}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(R.string.card_binding_onboarding_content_trusted_security).substring(9, 10).length() + 42378, new char[]{44094, 2465, 59152, 23707, 14875}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = PlaceComponentResult[7];
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr4 = new Object[1];
                    b(b, b2, b2, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b((byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], PlaceComponentResult[41], objArr5);
                    Object[] objArr6 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 31624, new char[]{44082, 55188, 23397, 57050, 17048, 50807, 18881, 52706, 29050, 62674, 30905, 64574, 26622, 60325, 28441, 37597, 5813, 39427, 7621, 33185, 1331, 35046, 3239, 45081, 15338, 49078}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 5923, new char[]{44080, 47877, 33383, 59720, 61626, 57234, 9973, 3559, 5435, 31768, 19297, 21179, 47508, 33013, 61389, 63287, 56844, 9582}, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 35 - ExpandableListView.getPackedPositionType(0L), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        byte b3 = PlaceComponentResult[7];
                        byte b4 = PlaceComponentResult[25];
                        Object[] objArr8 = new Object[1];
                        b(b3, b4, b4, objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b((byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], PlaceComponentResult[41], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 55730, new char[]{44132, 30179, 8131, 8466, 52015, 60712, 46744, 22702, 25340, 1117, 11790, 61476, 39378, 41942, 17896, 28472, 12626, 56161, 64691, 34459, 43083, 29311, 5138, 15760, 51199, 59899, 45829, 21878, 32629, 208, 10888, 52411, 38410, 47190, 16999, 27571, 3481, 55061, 63801, 33606, 42140, 20222, 4345, 14868, 56437, 58999, 36751, 20875}, objArr10);
                        String str = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(getPackageName().codePointAt(2) + 35905, new char[]{44082, 8201, 46267, 2426, 40329, 4673, 59129, 31586, 53071, 17367, 53308, 42147, 14595, 36289, 624, 38630, 27281, 65342, 29691, 49247, 21659, 10617, 48623, 12697, 34317, 6886, 61228, 25475, 61519, 17572, 55651, 44304, 8656, 46712, 2777, 40774, 5036, 57403, 29721, 51337, 23870, 53668, 42496, 15047, 36644, 999, 38800, 25605, 63664, 19807, 49610, 22135, 10982, 48799, 13065, 34747, 5163, 59605, 32022, 61860, 18022, 55832, 44757, 9009}, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(super.getResources().getString(R.string.total_price_idr).substring(0, 6).codePointAt(2) + 9071, new char[]{44129, 36737, 60400, 51096, 9190, 7947, 31539, 22354, 45939, 61072, 51893, 9891, 710, 32487, 23049, 46633, 37378, 52773, 10641, 1518, 25053, 23982, 47536, 38149, 61740, 11550, 2404, 25754, 16609, 48258, 39166, 62541, 53252, 3188, 26695, 17506, 42973, 33707, 65495, 56318, 14099, 4974, 20316, 43846, 34671, 57988, 57080, 15004, 5797, 29209, 44646, 35343, 59005, 49565, 15831, 6563, 30156, 20973, 36100, 59700, 50433, 8561, 7324, 30903}, objArr12);
                        String str3 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        a(super.getResources().getString(R.string.pay_top_up).substring(0, 8).codePointAt(4) + 62841, new char[]{44091, 23022, 18357, 19832, 31492, 24708, 28362, 5123, 639, 2083, 13799, 9105, 10513, 55058, 56517, 51942, 61606, 65131, 58373, 37339, 40838, 34141, 45921, 47474, 42732, 44167, 23128, 16402, 19915, 31717, 25004, 28529, 5394, 712, 2180, 13830, 15476, 10801, 55272, 56803, 52058, 61714, 65216, 58559, 37558, 39016, 34346, 46033, 47504, 42846, 44350, 23342, 16565, 20193, 29776, 25098, 28622, 5628, 941, 2419}, objArr13);
                        String str4 = (String) objArr13[0];
                        Object[] objArr14 = new Object[1];
                        a(super.getResources().getString(R.string.card_binding_save_card_dialog_desc).substring(27, 29).length() + 45941, new char[]{44138, 7946, 51849, 46616, 25021, 11569}, objArr14);
                        try {
                            Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr15);
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
            b((short) 36, (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            b((short) 21, (byte) (PlaceComponentResult[30] + 1), PlaceComponentResult[30], objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.alpha(0), (ViewConfiguration.getEdgeSlop() >> 16) + 4, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                    Object[] objArr19 = new Object[1];
                    c((byte) (-$$a[9]), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr19);
                    obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {616460460, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.account_succes_linked).substring(7, 8).length() + 31656, new char[]{44082, 55188, 23397, 57050, 17048, 50807, 18881, 52706, 29050, 62674, 30905, 64574, 26622, 60325, 28441, 37597, 5813, 39427, 7621, 33185, 1331, 35046, 3239, 45081, 15338, 49078}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.additional_info_form_debit_card).substring(15, 25).codePointAt(6) + 5877, new char[]{44080, 47877, 33383, 59720, 61626, 57234, 9973, 3559, 5435, 31768, 19297, 21179, 47508, 33013, 61389, 63287, 56844, 9582}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), 35 - ExpandableListView.getPackedPositionType(0L), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, TextUtils.indexOf("", "") + 18, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    public static Intent createSplitBillIntent(Context context, RecipientModel recipientModel, String str) {
        Intent intent = new Intent(context, SplitBillActivity.class);
        intent.putExtra("data", recipientModel);
        intent.putExtra("source", str);
        return intent;
    }

    public static Intent createSplitBillIntent(Activity activity, RequestMoneyInfoModel requestMoneyInfoModel, long j, String str, int i, String str2) {
        Intent intent = new Intent(activity, SplitBillActivity.class);
        intent.putExtra(BundleKey.MINIMUM_AMOUNT, String.valueOf(requestMoneyInfoModel.BuiltInFictitiousFunctionClassFactory));
        intent.putExtra(BundleKey.MAXIMUM_AMOUNT, String.valueOf(requestMoneyInfoModel.MyBillsEntityDataFactory));
        intent.putExtra("amount", j);
        intent.putExtra("remarks", str);
        intent.putExtra("max_recipient", i);
        intent.putExtra("source", str2);
        return intent;
    }

    public static Intent createSplitBillIntentBridge(Activity activity, RequestMoneyInfoModel requestMoneyInfoModel, long j, String str, int i, Boolean bool, String str2) {
        Intent intent = new Intent(activity, SplitBillActivity.class);
        intent.putExtra(BundleKey.MAXIMUM_AMOUNT, String.valueOf(requestMoneyInfoModel.MyBillsEntityDataFactory));
        intent.putExtra("amount", j);
        intent.putExtra("remarks", str);
        intent.putExtra("max_recipient", i);
        intent.putExtra("source", str2);
        intent.putExtra(BundleKey.IS_FROM_JSAPI_BRIDGE, bool);
        return intent;
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setCenterTitle(getString(R.string.split_bill_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.create_username_desc).substring(34, 39).length() + 31652, new char[]{44082, 55188, 23397, 57050, 17048, 50807, 18881, 52706, 29050, 62674, 30905, 64574, 26622, 60325, 28441, 37597, 5813, 39427, 7621, 33185, 1331, 35046, 3239, 45081, 15338, 49078}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = PlaceComponentResult[7];
                byte b2 = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                b(b, b2, b2, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b((byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], PlaceComponentResult[41], objArr3);
                Object[] objArr4 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 5890, new char[]{44080, 47877, 33383, 59720, 61626, 57234, 9973, 3559, 5435, 31768, 19297, 21179, 47508, 33013, 61389, 63287, 56844, 9582}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), 35 - TextUtils.getOffsetAfter("", 0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
        onModifyingAmount(false);
    }

    @OnClick({R.id.btn_split_bill})
    public void onSplitBillClicked() {
        this.splitBillAnalyticTracker.getAuthRequestContext(this.sbpvPayers.getPayersCountOnly(), this.sbpvPayers.isIncludeSelf(), this.rvRemarks.getRemarks(), this.sbpvPayers.getTotalPayersAmount());
        if (this.sbpvPayers.isSameWithTotal()) {
            BuiltInFictitiousFunctionClassFactory();
        } else {
            new MaterialDialog(this, MaterialDialog.getDEFAULT_BEHAVIOR()).message(Integer.valueOf((int) R.string.split_bill_dialog_message), null, null).positiveButton(Integer.valueOf((int) R.string.option_continue), null, new Function1() { // from class: id.dana.splitbill.view.SplitBillActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SplitBillActivity.this.m2973x914c37e0((MaterialDialog) obj);
                }
            }).show();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        GenerateDeepLinkContract.SplitBillPresenter splitBillPresenter = this.deepLinkPresenter;
        SplitBill splitBill = new SplitBill();
        splitBill.setComment(this.rvRemarks.getRemarks());
        splitBill.setPayers(this.splitBillPayerMapper.apply(this.sbpvPayers.getPayerModels()));
        splitBillPresenter.MyBillsEntityDataFactory(splitBill, getString(R.string.deeplink_title_split_bill), getString(R.string.deeplink_description_split_bill));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showConfirmationDialog$0$id-dana-splitbill-view-SplitBillActivity  reason: not valid java name */
    public /* synthetic */ Unit m2973x914c37e0(MaterialDialog materialDialog) {
        BuiltInFictitiousFunctionClassFactory();
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2 && intent != null) {
            if (scheduleImpl == i) {
                this.getErrorConfigVersion.MyBillsEntityDataFactory = intent.getStringExtra("amount");
                this.advSplitBill.setAmountText(this.getErrorConfigVersion.MyBillsEntityDataFactory);
                this.sbpvPayers.updateAmount(Long.valueOf(this.getErrorConfigVersion.MyBillsEntityDataFactory).longValue());
            } else if (ScannerActionFactory.BuiltInFictitiousFunctionClassFactory == i) {
                this.bpvSelection.addPayerFromScanner((RecipientModel) intent.getParcelableExtra("data"));
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.bpvSelection.isShow()) {
            this.bpvSelection.hide();
        } else {
            super.onBackPressed();
        }
    }

    public void showBillPayerView() {
        this.vDimHeader.setVisibility(0);
        this.vDimBody.setVisibility(0);
        if (OSUtil.GetContactSyncConfig()) {
            getWindow().setStatusBarColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.f22932131099760));
        }
        this.sbpvPayers.saveLockedPayer();
        this.bpvSelection.show();
    }

    @Override // id.dana.richview.splitbill.BillPayerView.Listener
    public void onViewHidden() {
        this.vDimHeader.setVisibility(8);
        this.vDimBody.setVisibility(8);
        if (OSUtil.GetContactSyncConfig()) {
            getWindow().setStatusBarColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.colorPrimaryDark));
        }
    }

    @Override // id.dana.richview.splitbill.BillPayerView.Listener
    public void onUpdatedSelectedPayers(List<RecipientModel> list) {
        this.sbpvPayers.addPayers(this.recipientModelMapper.apply(list));
    }

    @Override // id.dana.splitbill.view.SplitBillPayersView.Listener
    public void onClickAddNewPayer() {
        showBillPayerView();
    }

    @Override // id.dana.splitbill.view.SplitBillPayersView.Listener
    public void onRemainingUpdated(boolean z, String str) {
        this.advSplitBill.setAmountRemain(z, str);
    }

    @Override // id.dana.splitbill.view.SplitBillPayersView.Listener
    public void onRemovePayer(SplitBillPayerModel splitBillPayerModel) {
        this.bpvSelection.removeSelectedPayer(this.splitBillPayerToRecipientModelMapper.apply(splitBillPayerModel));
    }

    @Override // id.dana.splitbill.view.SplitBillPayersView.Listener
    public void onModifyingAmount(boolean z) {
        this.btnSplitBill.setVisibility(!z ? 0 : 8);
    }

    public static /* synthetic */ void $r8$lambda$JFHNiDkbxIhgefZJ9c9_2U2DsYM(SplitBillActivity splitBillActivity) {
        String str;
        String str2;
        splitBillActivity.sbpvPayers.clearCurrentFocus();
        Bundle extras = splitBillActivity.getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(BundleKey.MINIMUM_AMOUNT, "0");
            str2 = extras.getString(BundleKey.MAXIMUM_AMOUNT, "0");
            str = string;
        } else {
            str = "0";
            str2 = str;
        }
        splitBillActivity.startActivityForResult(AmountCalculatorActivity.createIntent(splitBillActivity, str, str2, splitBillActivity.getString(R.string.split_bill_title), true, splitBillActivity.getErrorConfigVersion), scheduleImpl);
    }

    static /* synthetic */ void access$100(SplitBillActivity splitBillActivity, String str) {
        if (splitBillActivity.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            splitBillActivity.startActivity(SplitBillSummaryActivity.createIntentFromRequestMoney(splitBillActivity, str, TrackerKey.SourceType.SPLIT_BILL_CREATED));
        } else {
            splitBillActivity.startActivity(SplitBillSummaryActivity.createIntent(splitBillActivity, str, TrackerKey.SourceType.SPLIT_BILL_CREATED));
        }
        splitBillActivity.finish();
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        byte b = 0;
        if (this.lookAheadTest == null) {
            DaggerSplitBillComponent.Builder MyBillsEntityDataFactory = DaggerSplitBillComponent.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            MyBillsEntityDataFactory.PlaceComponentResult = (GenerateDeepLinkModule) Preconditions.getAuthRequestContext(new GenerateDeepLinkModule(new GenerateDeepLinkContract.SplitBillView() { // from class: id.dana.splitbill.view.SplitBillActivity.2
                @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.SplitBillView
                public final void MyBillsEntityDataFactory(String str, String str2) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    SplitBillActivity.access$100(SplitBillActivity.this, str2);
                }

                @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.SplitBillView
                public final void PlaceComponentResult(String str, String str2, String str3, String str4) {
                    MixPanelTracker.BuiltInFictitiousFunctionClassFactory(SplitBillActivity.this.getBaseContext(), str, str3, str2, TrackerDataKey.Source.SPLIT_BILL_SUMMARY, str4);
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                    SplitBillActivity.this.touchBlockerView.setVisibility(0);
                    SplitBillActivity.this.btnSplitBill.setVisibility(8);
                    SplitBillActivity.this.logoProgressView.setVisibility(0);
                    SplitBillActivity.this.logoProgressView.startRefresh();
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                    SplitBillActivity.this.touchBlockerView.setVisibility(8);
                    SplitBillActivity.this.btnSplitBill.setVisibility(0);
                    SplitBillActivity.this.logoProgressView.setVisibility(8);
                    SplitBillActivity.this.logoProgressView.stopRefresh();
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                    SplitBillActivity.this.showWarningDialog(str);
                }
            }));
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (SplitBillModule) Preconditions.getAuthRequestContext(new SplitBillModule(new SplitBillContract.View() { // from class: id.dana.splitbill.view.SplitBillActivity.1
                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                @Override // id.dana.splitbill.SplitBillContract.View
                public final void getAuthRequestContext(Account account) {
                    SplitBillActivity.this.sbpvPayers.setInitialData(account, SplitBillActivity.this.DatabaseTableConfigUtil);
                    SplitBillActivity.this.bpvSelection.setOwnPhoneNumber(account.getPhoneNumber());
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, GenerateDeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, SplitBillModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, ApplicationComponent.class);
            this.lookAheadTest = new DaggerSplitBillComponent.SplitBillComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, b);
        }
        this.lookAheadTest.PlaceComponentResult(this);
        registerPresenter(this.deepLinkPresenter, this.splitBillPresenter);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = extras.getBoolean("fromRequestMoney", false);
            this.rvRemarks.setRemarks(extras.getString("remarks", ""));
            CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(String.valueOf(extras.getLong("amount", 0L)));
            this.getErrorConfigVersion = currencyAmountModel;
            this.advSplitBill.setAmountText(currencyAmountModel.MyBillsEntityDataFactory);
            this.bpvSelection.setMaxBillPayer(extras.getInt("max_recipient", 0));
            this.sbpvPayers.setAmount(Long.parseLong(this.getErrorConfigVersion.MyBillsEntityDataFactory));
            this.sbpvPayers.setMaxSplitBillAmount(Long.parseLong(extras.getString(BundleKey.MAXIMUM_AMOUNT, "0")));
            this.DatabaseTableConfigUtil = extras.getBoolean(BundleKey.IS_FROM_JSAPI_BRIDGE, false);
        }
        this.bpvSelection.configPeekHeight(this);
        this.bpvSelection.setListener(this);
        this.sbpvPayers.initAdapter();
        this.sbpvPayers.setListener(this);
        this.splitBillPresenter.KClassImpl$Data$declaredNonStaticMembers$2();
        NoteView noteView = this.rvRemarks;
        final SplitBillPayersView splitBillPayersView = this.sbpvPayers;
        Objects.requireNonNull(splitBillPayersView);
        noteView.setListener(new NoteView.Listener() { // from class: id.dana.splitbill.view.SplitBillActivity$$ExternalSyntheticLambda1
            @Override // id.dana.sendmoney.remarks.NoteView.Listener
            public final void getAuthRequestContext() {
                SplitBillPayersView.this.clearCurrentFocus();
            }
        });
        this.advSplitBill.setOnAmountClickListener(new AmountDisplayView.SetOnAmountClickListener() { // from class: id.dana.splitbill.view.SplitBillActivity$$ExternalSyntheticLambda2
            @Override // id.dana.richview.splitbill.AmountDisplayView.SetOnAmountClickListener
            public final void PlaceComponentResult() {
                SplitBillActivity.$r8$lambda$JFHNiDkbxIhgefZJ9c9_2U2DsYM(SplitBillActivity.this);
            }
        });
        this.splitBillAnalyticTracker.getAuthRequestContext(getSource());
    }

    @Override // id.dana.splitbill.view.SplitBillPayersView.Listener
    public void onSplitBillButtonEnabled(boolean z) {
        if (z && this.advSplitBill.isAnyAmountRemain()) {
            this.advSplitBill.setAmountRemain(false);
        }
        this.btnSplitBill.setEnabled(z);
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (GetContactSyncConfig ^ 4796183387843776835L);
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
