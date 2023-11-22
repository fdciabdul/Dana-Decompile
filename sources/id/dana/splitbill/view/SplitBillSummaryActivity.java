package id.dana.splitbill.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.util.NumberUtils;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSplitBillSummaryComponent;
import id.dana.di.component.SplitBillSummaryComponent;
import id.dana.di.modules.SplitBillDetailModule;
import id.dana.di.modules.SplitBillModule;
import id.dana.domain.account.Account;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.requestmoney.RequestMoneyActivity;
import id.dana.richview.CurrencyTextView;
import id.dana.richview.LogoProgressView;
import id.dana.richview.socialshare.SocialShareView;
import id.dana.richview.socialshare.model.SocialShareModel;
import id.dana.sendmoney.model.ShareQRSplitBillModel;
import id.dana.splitbill.SplitBillContract;
import id.dana.splitbill.SplitBillDetailContract;
import id.dana.splitbill.model.PayerModel;
import id.dana.splitbill.model.SplitBillHistoryModel;
import id.dana.splitbill.tracker.SplitBillAnalyticTracker;
import id.dana.splitbill.view.ClosePayerDialogFragment;
import id.dana.splitbill.view.PayerListView;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.LocaleUtil;
import id.dana.utils.NumberFormatterUtil;
import id.dana.utils.TextUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

/* loaded from: classes5.dex */
public class SplitBillSummaryActivity extends BaseActivity {
    private SplitBillSummaryComponent GetContactSyncConfig;
    private Account NetworkUserEntityData$$ExternalSyntheticLambda0;
    private SplitBillHistoryModel NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    @BindView(R.id.ctv_total_amount)
    CurrencyTextView ctvTotalAmount;
    private SkeletonScreen getErrorConfigVersion;
    @BindView(R.id.iv_split_bill_status)
    ImageView ivSplitBillStatus;
    @BindView(R.id.ll_split_bill_empty_state)
    LinearLayout llBillDetailEmptyState;
    @BindView(R.id.ll_split_bill_details)
    LinearLayout llSplitBillDetails;
    private boolean lookAheadTest;
    @BindView(R.id.nsv_split_bill_summary)
    NestedScrollView nsvSplitBillSummary;
    @BindView(R.id.view_split_bill_payer)
    PayerListView payerListView;
    private ClosePayerDialogFragment scheduleImpl;
    @Inject
    SplitBillAnalyticTracker splitBillAnalyticTracker;
    @Inject
    SplitBillDetailContract.Presenter splitBillDetailPresenter;
    @Inject
    SplitBillContract.Presenter splitBillPresenter;
    @BindView(R.id.ssv_split_bill_summary)
    SocialShareView ssvSplitBill;
    @BindView(R.id.tv_remarks)
    TextView tvRemarks;
    @BindView(R.id.v_dim_body)
    View vDimBody;
    public static final byte[] $$a = {117, -10, 119, -11, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 16;
    public static final byte[] PlaceComponentResult = {61, 16, -46, 32, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 86;
    private static char DatabaseTableConfigUtil = 42066;
    private static char[] initRecordTimeStamp = {37283, 37288, 37294, 37295, 37274, 37281, 37370, 37345, 37287, 37282, 37305, 37292, 37286, 37293, 37463, 37468, 37462, 37308, 37306, 37368, 37371, 37275, 37367, 37469, 37291, 37302, 37374, 37457, 37344, 37460, 37307, 37280, 37279, 37310, 37369, 37375, 37366, 37458, 37456, 37373, 37311, 37262, 37365, 37459, 37290, 37289, 37461, 37372, 37309};

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 23 - r8
            byte[] r0 = id.dana.splitbill.view.SplitBillSummaryActivity.PlaceComponentResult
            int r6 = 106 - r6
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
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
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L32:
            int r7 = r7 + r6
            int r6 = r7 + (-4)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillSummaryActivity.b(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 46 - r7
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = id.dana.splitbill.view.SplitBillSummaryActivity.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r6]
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
            int r3 = r3 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r7 = r7 + 1
            r4 = r0[r7]
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillSummaryActivity.c(byte, short, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((byte) (33 - Drawable.resolveOpacity(0, 0)), new char[]{3, 6, 27, '-', '!', '\n', 21, '\n', Typography.amp, 24, 11, 28, '-', Typography.quote, '\t', '.', 13834, 13834}, 18 - Color.blue(0), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((byte) (31 - (ViewConfiguration.getWindowTouchSlop() >> 8)), new char[]{11, 23, 5, 11, 13853}, 5 - TextUtils.getOffsetBefore("", 0), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), Color.rgb(0, 0, 0) + 16777251, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((byte) (ImageFormat.getBitsPerPixel(0) + 52), new char[]{18, '\f', 29, 27, Typography.amp, 21, '+', 29, 16, '/', '\n', '.', '.', '%', 27, '!', 13790, 13790, 30, 6, 25, '\n', '\r', InputCardNumberView.DIVIDER, JSONLexer.EOI, '-', 23, 25, Typography.amp, 25, '\t', 2, ')', 29, '(', '%', '+', Typography.amp, 21, Typography.dollar, 17, '/', 27, ')', '\f', '0', 30, '0'}, 47 - TextUtils.indexOf((CharSequence) "", '0'), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 14), new char[]{3, 0, 31, 27, '+', Typography.amp, Typography.dollar, 21, 25, '\n', ')', 1, 25, 27, 27, 19, 13751, 13751, '/', 24, 25, 27, '!', '0', ')', 20, '%', '+', 23, 25, 13751, 13751, '\n', 25, 15, 27, 13832, 13832, '(', '*', 0, ')', '/', 23, '\f', 18, '!', JSONLexer.EOI, 13752, 13752, 15, '(', '(', 15, '(', 21, '(', 21, '\f', 7, 27, 23, JSONLexer.EOI, '-'}, 64 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) (Color.rgb(0, 0, 0) + 16777325), new char[]{'(', 25, '0', '\t', '(', 15, ')', 18, 13839, 13839, 23, 27, '!', 5, '(', 14, '\t', 2, 17, 27, ')', 11, 5, ',', 17, '/', '+', 29, 13929, 13929, 18, '\f', 17, JSONLexer.EOI, Typography.dollar, 25, '\f', 20, 29, 27, 24, '+', 27, 19, 21, Typography.dollar, 6, '\t', '+', Typography.amp, '\t', '.', '(', 25, '0', 3, 20, 5, ')', 29, '0', 3, 1, ')'}, TextUtils.getOffsetBefore("", 0) + 64, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((byte) (Process.getGidForName("") + 92), new char[]{'\t', 29, '!', '%', 14, '-', 13840, 13840, 23, 3, 6, 3, '\t', 28, '\r', '+', 2, '\t', InputCardNumberView.DIVIDER, '\t', 3, 16, 28, '\t', 4, 15, 6, ',', 31, 24, InputCardNumberView.DIVIDER, 19, 6, ',', '*', '\t', '\n', InputCardNumberView.DIVIDER, 7, 30, 5, '%', 7, '!', 19, '\f', 2, '+', 16, 31, 31, 7, '#', InputCardNumberView.DIVIDER, '-', '\t', '/', 2, 31, 16}, 61 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((byte) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 96), new char[]{'#', '\b', 14, '\r', '(', 25}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 7, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, 18 - Color.alpha(0), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                b(b, (byte) (b | 36), (byte) (-PlaceComponentResult[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = PlaceComponentResult[7];
                Object[] objArr14 = new Object[1];
                b(b2, (byte) (b2 | Ascii.DC4), (byte) (-PlaceComponentResult[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 54, 3 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[53], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 800, Gravity.getAbsoluteGravity(0, 0) + 15, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getTapTimeout() >> 16), 29 - (Process.myTid() >> 22), (char) (57994 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15, (char) View.combineMeasuredStates(0, 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 35 - View.resolveSizeAndState(0, 0, 0), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {888953469, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, (-16777198) - Color.rgb(0, 0, 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = PlaceComponentResult[25];
                Object[] objArr19 = new Object[1];
                b(b3, (byte) (b3 | 36), (byte) (-PlaceComponentResult[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = PlaceComponentResult[7];
                Object[] objArr20 = new Object[1];
                b(b4, (byte) (b4 | Ascii.DC4), (byte) (-PlaceComponentResult[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 61, 47 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {888953469, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 18 - View.getDefaultSize(0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = PlaceComponentResult[25];
                Object[] objArr25 = new Object[1];
                b(b5, (byte) (b5 | 36), (byte) (-PlaceComponentResult[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = PlaceComponentResult[7];
                Object[] objArr26 = new Object[1];
                b(b6, (byte) (b6 | Ascii.DC4), (byte) (-PlaceComponentResult[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.MeasureSpec.getSize(0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 4, (char) (38969 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {888953469, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, Gravity.getAbsoluteGravity(0, 0) + 18, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = PlaceComponentResult[25];
                Object[] objArr31 = new Object[1];
                b(b7, (byte) (b7 | 36), (byte) (-PlaceComponentResult[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b8 = PlaceComponentResult[7];
                Object[] objArr32 = new Object[1];
                b(b8, (byte) (b8 | Ascii.DC4), (byte) (-PlaceComponentResult[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 107, (ViewConfiguration.getEdgeSlop() >> 16) + 3, (char) ((-16777216) - Color.rgb(0, 0, 0)));
                        Object[] objArr34 = new Object[1];
                        c($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {888953469, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), KeyEvent.keyCodeFromString("") + 18, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_split_bill_summary;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a((byte) (super.getResources().getString(R.string.remarks_message).substring(1, 2).length() + 32), new char[]{3, 6, 27, '-', '!', '\n', 21, '\n', Typography.amp, 24, 11, 28, '-', Typography.quote, '\t', '.', 13834, 13834}, 18 - Drawable.resolveOpacity(0, 0), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        byte length = (byte) (super.getResources().getString(R.string.otp_daily_limit_desc).substring(3, 4).length() + 30);
        char[] cArr = {11, 23, 5, 11, 13853};
        try {
            Object[] objArr3 = new Object[1];
            b(PlaceComponentResult[32], PlaceComponentResult[9], PlaceComponentResult[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            b(PlaceComponentResult[13], PlaceComponentResult[59], PlaceComponentResult[27], new Object[1]);
            Object[] objArr4 = new Object[1];
            a(length, cArr, ((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 28, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a((byte) (67 - TextUtils.lastIndexOf("", '0')), new char[]{3, 6, 27, '-', '!', '\n', 21, '\n', 5, '%', '#', '\f', '\'', '\r', '!', '\t', 11, '\r', InputCardNumberView.DIVIDER, 23, 22, 7, '*', '-', 3, 23}, super.getResources().getString(R.string.more_for_you_description).substring(1, 2).codePointAt(0) - 71, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    byte length2 = (byte) (super.getResources().getString(R.string.saving_empty_state_title).substring(10, 11).length() + 56);
                    char[] cArr2 = {18, 25, 13857, 13857, '/', 2, Typography.quote, '%', 13859, 13859, 5, 7, '\t', 4, '!', '\t', '!', 3};
                    try {
                        Object[] objArr6 = new Object[1];
                        b(PlaceComponentResult[32], PlaceComponentResult[9], PlaceComponentResult[25], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        b(PlaceComponentResult[13], PlaceComponentResult[59], PlaceComponentResult[27], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        a(length2, cArr2, ((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, objArr7);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        a((byte) (getPackageName().codePointAt(1) - 49), new char[]{18, '\f', 29, 27, Typography.amp, 21, '+', 29, 16, '/', '\n', '.', '.', '%', 27, '!', 13790, 13790, 30, 6, 25, '\n', '\r', InputCardNumberView.DIVIDER, JSONLexer.EOI, '-', 23, 25, Typography.amp, 25, '\t', 2, ')', 29, '(', '%', '+', Typography.amp, 21, Typography.dollar, 17, '/', 27, ')', '\f', '0', 30, '0'}, super.getResources().getString(R.string.save_bills_reminder_message).substring(41, 43).codePointAt(0) - 60, objArr8);
                        String str = (String) objArr8[0];
                        byte b = (byte) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 14);
                        char[] cArr3 = {3, 0, 31, 27, '+', Typography.amp, Typography.dollar, 21, 25, '\n', ')', 1, 25, 27, 27, 19, 13751, 13751, '/', 24, 25, 27, '!', '0', ')', 20, '%', '+', 23, 25, 13751, 13751, '\n', 25, 15, 27, 13832, 13832, '(', '*', 0, ')', '/', 23, '\f', 18, '!', JSONLexer.EOI, 13752, 13752, 15, '(', '(', 15, '(', 21, '(', 21, '\f', 7, 27, 23, JSONLexer.EOI, '-'};
                        try {
                            Object[] objArr9 = new Object[1];
                            b(PlaceComponentResult[32], PlaceComponentResult[9], PlaceComponentResult[25], objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            b(PlaceComponentResult[13], PlaceComponentResult[59], PlaceComponentResult[27], objArr10);
                            Object[] objArr11 = new Object[1];
                            a(b, cArr3, ((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 31, objArr11);
                            String str2 = (String) objArr11[0];
                            try {
                                Object[] objArr12 = new Object[1];
                                b(PlaceComponentResult[32], PlaceComponentResult[9], PlaceComponentResult[25], objArr12);
                                Class<?> cls6 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                b(PlaceComponentResult[13], PlaceComponentResult[59], PlaceComponentResult[27], objArr13);
                                Object[] objArr14 = new Object[1];
                                a((byte) (((ApplicationInfo) cls6.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 76), new char[]{'(', 25, '0', '\t', '(', 15, ')', 18, 13839, 13839, 23, 27, '!', 5, '(', 14, '\t', 2, 17, 27, ')', 11, 5, ',', 17, '/', '+', 29, 13929, 13929, 18, '\f', 17, JSONLexer.EOI, Typography.dollar, 25, '\f', 20, 29, 27, 24, '+', 27, 19, 21, Typography.dollar, 6, '\t', '+', Typography.amp, '\t', '.', '(', 25, '0', 3, 20, 5, ')', 29, '0', 3, 1, ')'}, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 64, objArr14);
                                String str3 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                a((byte) (super.getResources().getString(R.string.unsafe_device_tamper_title).substring(15, 16).length() + 90), new char[]{'\t', 29, '!', '%', 14, '-', 13840, 13840, 23, 3, 6, 3, '\t', 28, '\r', '+', 2, '\t', InputCardNumberView.DIVIDER, '\t', 3, 16, 28, '\t', 4, 15, 6, ',', 31, 24, InputCardNumberView.DIVIDER, 19, 6, ',', '*', '\t', '\n', InputCardNumberView.DIVIDER, 7, 30, 5, '%', 7, '!', 19, '\f', 2, '+', 16, 31, 31, 7, '#', InputCardNumberView.DIVIDER, '-', '\t', '/', 2, 31, 16}, 60 - TextUtils.indexOf("", "", 0), objArr15);
                                String str4 = (String) objArr15[0];
                                Object[] objArr16 = new Object[1];
                                a((byte) (getPackageName().codePointAt(6) - 1), new char[]{'#', '\b', 14, '\r', '(', 25}, super.getResources().getString(R.string.twilio_bottomsheet_description).substring(17, 18).length() + 5, objArr16);
                                try {
                                    Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr17);
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
                }
            }
            try {
                byte b2 = PlaceComponentResult[25];
                Object[] objArr18 = new Object[1];
                b(b2, (byte) (b2 | 36), (byte) (-PlaceComponentResult[30]), objArr18);
                Class<?> cls7 = Class.forName((String) objArr18[0]);
                byte b3 = PlaceComponentResult[7];
                Object[] objArr19 = new Object[1];
                b(b3, (byte) (b3 | Ascii.DC4), (byte) (-PlaceComponentResult[30]), objArr19);
                try {
                    Object[] objArr20 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.red(0), (ViewConfiguration.getTouchSlop() >> 8) + 4, (char) KeyEvent.normalizeMetaState(0));
                        Object[] objArr21 = new Object[1];
                        c($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr21);
                        obj3 = cls8.getMethod((String) objArr21[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                    int i = ((int[]) objArr22[1])[0];
                    if (((int[]) objArr22[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr23 = {-1066967542, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr23);
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
                    super.onCreate(bundle);
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
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (ExpandableListView.getPackedPositionType(0L) + 68), new char[]{3, 6, 27, '-', '!', '\n', 21, '\n', 5, '%', '#', '\f', '\'', '\r', '!', '\t', 11, '\r', InputCardNumberView.DIVIDER, 23, 22, 7, '*', '-', 3, 23}, super.getResources().getString(R.string.automation_passkey_cbx_agree_passkey).substring(0, 17).codePointAt(6) - 88, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(PlaceComponentResult[32], PlaceComponentResult[9], PlaceComponentResult[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(PlaceComponentResult[13], PlaceComponentResult[59], PlaceComponentResult[27], objArr3);
                Object[] objArr4 = new Object[1];
                a((byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 24), new char[]{18, 25, 13857, 13857, '/', 2, Typography.quote, '%', 13859, 13859, 5, 7, '\t', 4, '!', '\t', '!', 3}, getPackageName().length() + 11, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), 18 - (Process.myTid() >> 22), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            try {
                Object[] objArr = new Object[1];
                b(PlaceComponentResult[32], PlaceComponentResult[9], PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                b(PlaceComponentResult[13], PlaceComponentResult[59], PlaceComponentResult[27], objArr2);
                Object[] objArr3 = new Object[1];
                a((byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 35), new char[]{3, 6, 27, '-', '!', '\n', 21, '\n', 5, '%', '#', '\f', '\'', '\r', '!', '\t', 11, '\r', InputCardNumberView.DIVIDER, 23, 22, 7, '*', '-', 3, 23}, 27 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a((byte) (super.getResources().getString(R.string.card_binding_disclaimer_express_pay).substring(4, 5).codePointAt(0) - 40), new char[]{18, 25, 13857, 13857, '/', 2, Typography.quote, '%', 13859, 13859, 5, 7, '\t', 4, '!', '\t', '!', 3}, super.getResources().getString(R.string.ep_general_error_desc).substring(2, 3).codePointAt(0) - 92, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), View.resolveSize(0, 0) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) View.resolveSize(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    }

    public static Intent createIntent(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, SplitBillSummaryActivity.class);
        intent.putExtra(DecodedScanBizInfoKey.SPLIT_BILL_ID, str);
        intent.putExtra("source", str2);
        return intent;
    }

    public static Intent createIntentFromRequestMoney(BaseActivity baseActivity, String str, String str2) {
        Intent createIntent = createIntent(baseActivity, str, str2);
        createIntent.putExtra("fromRequestMoney", true);
        return createIntent;
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setCenterTitle(getString(R.string.split_bill_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
    }

    public void enableDimView() {
        this.vDimBody.setVisibility(0);
    }

    public void disableDimView() {
        this.vDimBody.setVisibility(8);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.lookAheadTest) {
            super.onBackPressed();
            return;
        }
        Intent intent = new Intent(this, RequestMoneyActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupClosePayers$0$id-dana-splitbill-view-SplitBillSummaryActivity  reason: not valid java name */
    public /* synthetic */ void m2980xa4d9fc43() {
        String str;
        enableDimView();
        SplitBillHistoryModel splitBillHistoryModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        ClosePayerDialogFragment closePayerDialogFragment = new ClosePayerDialogFragment(new ClosePayerDialogFragment.OnSubmitButtonClickListener() { // from class: id.dana.splitbill.view.SplitBillSummaryActivity$$ExternalSyntheticLambda1
            @Override // id.dana.splitbill.view.ClosePayerDialogFragment.OnSubmitButtonClickListener
            public final void PlaceComponentResult(List list) {
                SplitBillSummaryActivity.this.m2981x95110fb3(list);
            }
        });
        this.scheduleImpl = closePayerDialogFragment;
        closePayerDialogFragment.moveToNextValue = splitBillHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2();
        ClosePayerDialogFragment closePayerDialogFragment2 = this.scheduleImpl;
        if (splitBillHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            str = "0";
        } else {
            int i = 0;
            String str2 = splitBillHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2.get(0).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            for (PayerModel payerModel : splitBillHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2) {
                if ("IN_PROGRESS".equals(payerModel.lookAheadTest)) {
                    i += Integer.valueOf(payerModel.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory).intValue();
                }
            }
            str = NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.getAuthRequestContext(), i, str2);
        }
        closePayerDialogFragment2.getErrorConfigVersion = str;
        this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2().size();
        this.scheduleImpl.show(getSupportFragmentManager(), "show close payer dialog");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showClosePayerBottomSheetDialog$1$id-dana-splitbill-view-SplitBillSummaryActivity  reason: not valid java name */
    public /* synthetic */ void m2981x95110fb3(List list) {
        this.splitBillAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(list.size());
        ClosePayerDialogFragment closePayerDialogFragment = this.scheduleImpl;
        LogoProgressView logoProgressView = closePayerDialogFragment.lpvClosePayer;
        if (logoProgressView != null) {
            logoProgressView.startRefresh();
            closePayerDialogFragment.lpvClosePayer.setVisibility(0);
            closePayerDialogFragment.btnSubmitClosePayer.setVisibility(8);
        }
        this.splitBillDetailPresenter.getAuthRequestContext(list, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initSocialShareView$2$id-dana-splitbill-view-SplitBillSummaryActivity  reason: not valid java name */
    public /* synthetic */ void m2978x6e713d99(SocialShareModel socialShareModel) {
        this.splitBillAnalyticTracker.MyBillsEntityDataFactory(socialShareModel.getAuthRequestContext);
    }

    private boolean getAuthRequestContext() {
        return "IN_PROGRESS".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initSocialShareViewConfig$3$id-dana-splitbill-view-SplitBillSummaryActivity  reason: not valid java name */
    public /* synthetic */ void m2979x805ba2fc(ShareQRSplitBillModel shareQRSplitBillModel, View view) {
        startActivity(SplitBillShareQrActivity.createIntent(this, shareQRSplitBillModel));
    }

    static /* synthetic */ void access$100(final SplitBillSummaryActivity splitBillSummaryActivity) {
        if (!TextUtils.isEmpty(splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            String str = splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1149187101) {
                if (hashCode != -604548089) {
                    if (hashCode == -591252731 && str.equals("EXPIRED")) {
                        c = 1;
                    }
                } else if (str.equals("IN_PROGRESS")) {
                    c = 2;
                }
            } else if (str.equals("SUCCESS")) {
                c = 0;
            }
            if (c == 0) {
                splitBillSummaryActivity.ivSplitBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(splitBillSummaryActivity, (int) R.drawable.bg_split_bill_success));
            } else if (c != 1) {
                splitBillSummaryActivity.ivSplitBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(splitBillSummaryActivity, (int) R.drawable.bg_split_bill_introduction));
            } else {
                splitBillSummaryActivity.ivSplitBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(splitBillSummaryActivity, (int) R.drawable.bg_split_bill_failed));
            }
        }
        splitBillSummaryActivity.ctvTotalAmount.setText(splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.lookAheadTest);
        if (TextUtils.isEmpty(splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory)) {
            splitBillSummaryActivity.tvRemarks.setVisibility(8);
        } else {
            splitBillSummaryActivity.tvRemarks.setText(TextUtil.NetworkUserEntityData$$ExternalSyntheticLambda2(splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory));
        }
        splitBillSummaryActivity.payerListView.setItems(splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2, true);
        splitBillSummaryActivity.payerListView.setClosePayerEnabled(splitBillSummaryActivity.getAuthRequestContext());
        if (splitBillSummaryActivity.getAuthRequestContext()) {
            splitBillSummaryActivity.payerListView.setOnClickListener(new PayerListView.OnItemClickListener() { // from class: id.dana.splitbill.view.SplitBillSummaryActivity$$ExternalSyntheticLambda2
                @Override // id.dana.splitbill.view.PayerListView.OnItemClickListener
                public final void PlaceComponentResult() {
                    SplitBillSummaryActivity.this.m2980xa4d9fc43();
                }
            });
        }
        for (PayerModel payerModel : splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (NumberUtils.getNormalizePrefixPhoneNumber(payerModel.PlaceComponentResult).equals(splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getPhoneNumber())) {
                payerModel.MyBillsEntityDataFactory = String.format(splitBillSummaryActivity.getString(R.string.split_bill_requester_name), splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getNickname());
                return;
            }
        }
    }

    static /* synthetic */ void access$200(final SplitBillSummaryActivity splitBillSummaryActivity) {
        if (!splitBillSummaryActivity.getAuthRequestContext() || TextUtils.isEmpty(splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult)) {
            splitBillSummaryActivity.ssvSplitBill.setVisibility(8);
            return;
        }
        ShareQRSplitBillModel.Builder builder = new ShareQRSplitBillModel.Builder();
        builder.PlaceComponentResult = splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory;
        builder.BuiltInFictitiousFunctionClassFactory = splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult;
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getNickname();
        builder.MyBillsEntityDataFactory = splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getPhoneNumber();
        final ShareQRSplitBillModel shareQRSplitBillModel = new ShareQRSplitBillModel(builder, (byte) 0);
        splitBillSummaryActivity.ssvSplitBill.setEnableShareButton(true);
        splitBillSummaryActivity.ssvSplitBill.setShareQrOnClickListener(new View.OnClickListener() { // from class: id.dana.splitbill.view.SplitBillSummaryActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplitBillSummaryActivity.this.m2979x805ba2fc(shareQRSplitBillModel, view);
            }
        });
        splitBillSummaryActivity.ssvSplitBill.setSocialShareViewTitle(TextUtil.getAuthRequestContext(splitBillSummaryActivity.getString(R.string.split_bill_share_title), splitBillSummaryActivity.getString(R.string.split_bill_share_title)));
        splitBillSummaryActivity.ssvSplitBill.setSocialButtonText(splitBillSummaryActivity.getString(R.string.split_bill_via));
        splitBillSummaryActivity.ssvSplitBill.setOthersButtonText(splitBillSummaryActivity.getString(R.string.split_bill_via_others));
        splitBillSummaryActivity.ssvSplitBill.setSharingMessage(splitBillSummaryActivity.getString(R.string.split_bill_link_message), splitBillSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult);
        splitBillSummaryActivity.ssvSplitBill.setListener(new SocialShareView.Listener() { // from class: id.dana.splitbill.view.SplitBillSummaryActivity$$ExternalSyntheticLambda3
            @Override // id.dana.richview.socialshare.SocialShareView.Listener
            public final void MyBillsEntityDataFactory(SocialShareModel socialShareModel) {
                SplitBillSummaryActivity.this.m2978x6e713d99(socialShareModel);
            }
        });
        splitBillSummaryActivity.ssvSplitBill.setVisibility(0);
    }

    static /* synthetic */ void access$300(SplitBillSummaryActivity splitBillSummaryActivity) {
        splitBillSummaryActivity.scheduleImpl.dismiss();
    }

    static /* synthetic */ void access$500(SplitBillSummaryActivity splitBillSummaryActivity) {
        splitBillSummaryActivity.llSplitBillDetails.setVisibility(8);
        splitBillSummaryActivity.nsvSplitBillSummary.setVisibility(8);
        splitBillSummaryActivity.ssvSplitBill.setVisibility(8);
        splitBillSummaryActivity.llBillDetailEmptyState.setVisibility(0);
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        byte b = 0;
        if (this.GetContactSyncConfig == null) {
            DaggerSplitBillSummaryComponent.Builder MyBillsEntityDataFactory = DaggerSplitBillSummaryComponent.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            MyBillsEntityDataFactory.getAuthRequestContext = (SplitBillModule) Preconditions.getAuthRequestContext(new SplitBillModule(new SplitBillContract.View() { // from class: id.dana.splitbill.view.SplitBillSummaryActivity.2
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
                    SplitBillSummaryActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = account;
                    SplitBillSummaryActivity.this.splitBillDetailPresenter.KClassImpl$Data$declaredNonStaticMembers$2(SplitBillSummaryActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
            }));
            MyBillsEntityDataFactory.MyBillsEntityDataFactory = (SplitBillDetailModule) Preconditions.getAuthRequestContext(new SplitBillDetailModule(new SplitBillDetailContract.View() { // from class: id.dana.splitbill.view.SplitBillSummaryActivity.1
                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.splitbill.SplitBillDetailContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillHistoryModel splitBillHistoryModel) {
                    SplitBillSummaryActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = splitBillHistoryModel;
                    SplitBillSummaryActivity.this.splitBillAnalyticTracker.BuiltInFictitiousFunctionClassFactory(SplitBillSummaryActivity.this.getSource(), splitBillHistoryModel.NetworkUserEntityData$$ExternalSyntheticLambda0, !splitBillHistoryModel.getAuthRequestContext());
                    SplitBillSummaryActivity.access$100(SplitBillSummaryActivity.this);
                    SplitBillSummaryActivity.access$200(SplitBillSummaryActivity.this);
                }

                @Override // id.dana.splitbill.SplitBillDetailContract.View
                public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
                    if (z) {
                        SplitBillSummaryActivity.access$300(SplitBillSummaryActivity.this);
                        SplitBillSummaryActivity.this.splitBillDetailPresenter.KClassImpl$Data$declaredNonStaticMembers$2(SplitBillSummaryActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    }
                }

                @Override // id.dana.splitbill.SplitBillDetailContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    SplitBillSummaryActivity.access$500(SplitBillSummaryActivity.this);
                }

                @Override // id.dana.splitbill.SplitBillDetailContract.View
                public final void MyBillsEntityDataFactory(String str, String str2, String str3, String str4) {
                    MixPanelTracker.BuiltInFictitiousFunctionClassFactory(SplitBillSummaryActivity.this.getBaseContext(), str, str3, str2, TrackerDataKey.Source.SPLIT_BILL_SUMMARY, str4);
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                    if (SplitBillSummaryActivity.this.getErrorConfigVersion != null) {
                        SplitBillSummaryActivity.this.getErrorConfigVersion.MyBillsEntityDataFactory();
                    } else {
                        SplitBillSummaryActivity splitBillSummaryActivity = SplitBillSummaryActivity.this;
                        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(splitBillSummaryActivity.llSplitBillDetails);
                        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_split_bill_detail_skeleton;
                        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
                        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
                        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
                        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                        viewSkeletonScreen.MyBillsEntityDataFactory();
                        splitBillSummaryActivity.getErrorConfigVersion = viewSkeletonScreen;
                    }
                    if (SplitBillSummaryActivity.this.ssvSplitBill != null) {
                        SplitBillSummaryActivity.this.ssvSplitBill.setVisibility(8);
                    }
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                    if (SplitBillSummaryActivity.this.getErrorConfigVersion != null) {
                        SplitBillSummaryActivity.this.getErrorConfigVersion.PlaceComponentResult();
                        SplitBillSummaryActivity.this.getErrorConfigVersion = null;
                    }
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, SplitBillModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, SplitBillDetailModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            this.GetContactSyncConfig = new DaggerSplitBillSummaryComponent.SplitBillSummaryComponentImpl(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, b);
        }
        this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(this.splitBillPresenter, this.splitBillDetailPresenter);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = extras.getString(DecodedScanBizInfoKey.SPLIT_BILL_ID);
            this.lookAheadTest = extras.getBoolean("fromRequestMoney", false);
        }
        this.splitBillPresenter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = initRecordTimeStamp;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ DatabaseTableConfigUtil);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i4 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i5 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i4];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i5];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                    } else {
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i10 = 0; i10 < i; i10++) {
            cArr4[i10] = (char) (cArr4[i10] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
