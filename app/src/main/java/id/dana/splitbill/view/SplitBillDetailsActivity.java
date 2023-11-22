package id.dana.splitbill.view;

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
import android.text.AndroidCharacter;
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
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.BaseActivity;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSplitBillDetailsComponent;
import id.dana.di.component.SplitBillDetailsComponent;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.CurrencyTextView;
import id.dana.sendmoney.model.QrTransferModel;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import id.dana.splitbill.model.PayerModel;
import id.dana.splitbill.model.SplitBillModel;
import id.dana.splitbill.tracker.SplitBillAnalyticTracker;
import id.dana.utils.TextUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes5.dex */
public class SplitBillDetailsActivity extends BaseActivity {
    public static final String FROM_NOTIF = "fromNotif";
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda8;
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    @BindView(R.id.ctv_pay_amount)
    CurrencyTextView ctvPayAmount;
    @BindView(R.id.ctv_total_amount)
    CurrencyTextView ctvTotalAmount;
    private SplitBillDetailsComponent getErrorConfigVersion;
    private SplitBillModel initRecordTimeStamp;
    @BindView(R.id.iv_split_bill_status)
    ImageView ivBillStatus;
    @BindView(R.id.ll_split_bill_details)
    LinearLayout llSplitBillDetails;
    private PayerModel lookAheadTest;
    @BindView(R.id.view_split_bill_payer)
    PayerListView payerListView;
    private PayerModel scheduleImpl;
    @Inject
    SplitBillAnalyticTracker splitBillAnalyticTracker;
    @BindView(R.id.tv_amount_title)
    TextView tvAmountTitle;
    @BindView(R.id.tv_remarks)
    TextView tvRemarks;
    @BindView(R.id.view_pay_button)
    View viewPayButton;
    @BindView(R.id.view_split_bill_not_payer)
    View viewSplitBillNotPayer;
    public static final byte[] $$a = {109, -87, 105, -77, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 84;
    public static final byte[] PlaceComponentResult = {33, -64, 37, -91, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 114;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 1257195754;
    private static int GetContactSyncConfig = -458717623;
    private static byte[] DatabaseTableConfigUtil = {58, -12, -5, -60, -19, -29, -36, -14, -20, -60, -22, -62, -26, Ascii.NAK, -28, -71, -9, -24, 4, -83, -4, -3, -6, -23, -63, -22, 2, Ascii.US, Ascii.CAN, -23, 11, -32, -28, -31, -30, Ascii.RS, 47, -47, Ascii.CAN, Ascii.NAK, -21, Ascii.RS, -31, 12, 2, -82, -96, -84, -70, -79, -52, -52, 115, -86, -19, 100, -77, -76, -79, -96, -72, -95, 15, -99, -124, 124, -116, 36, -110, 126, TarHeader.LF_NORMAL, -107, Byte.MAX_VALUE, TarHeader.LF_CHR, -110, 122, 73, 66, 46, -108, 122, 69, 68, 45, 125, 68, -113, TarHeader.LF_CHR, -107, 124, TarHeader.LF_SYMLINK, -109, 46, 65, 66, 126, -106, 124, 65, 70, 124, 66, TarHeader.LF_BLK, 66, 126, 67, -109, 66, 66, 44, -115, 73, Byte.MAX_VALUE, 46, -107, 84, 113, -44, -71, 113, -127, -50, -65, -127, -65, -121, -126, Byte.MIN_VALUE, -66, -68, Byte.MIN_VALUE, -124, -70, -122, 108, -50, 116, -53, -123, -66, -67, 115, Byte.MIN_VALUE, -43, -68, 112, -65, -49, Byte.MIN_VALUE, 114, -44, 109, -44, 105, -44, -67, -125, -69, 115, -51, 117, -52, Byte.MIN_VALUE, -126, -67, Byte.MIN_VALUE, 115, -47, -124, 106, -127, -44, -72, -119, 109, -66, -46, -65, 108, 84, -44, -40, -119, -24, -37, -44, -38, -42, -119, -29, -39, -117, -42, -18, -123, -44, -41, -25, -96, -44, -43, -115, -22, -40, -42, -39, -125, -18, -46, -118, -21, -124, -20, -121, -40, -22, -39, -123, -23, -44, -122, -39, -24, -118, -24, -119, -44, -18, -47, -37, -42, -40, -33, -40, -40, -44, -42, -35, -38, -127, -37, -28, -39, 88, -62, -5, -8, -46, -16, 11, -60, -123, 58, -122, -64, -13, -61, -56, -4, 7, -69, -56, -14, 15, -65, -61, -11, 12, -72, -50, -16, -43, -3, -61, -14, -49, -16, -43, -13, 8, -121, -64, -17, -61, -46, -18, -59, -50, -9, -51, 59, -76, -50, -12, -60, 12, -63, -52, -70, -2, -59, -63, -11, 14, -111, -116, -106, -118, -101};
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = -259090468;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            int r5 = 23 - r5
            byte[] r0 = id.dana.splitbill.view.SplitBillDetailsActivity.PlaceComponentResult
            int r7 = 56 - r7
            int r6 = r6 + 97
            byte[] r1 = new byte[r5]
            r2 = -1
            int r5 = r5 + r2
            if (r0 != 0) goto L15
            r6 = r5
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r7
            goto L32
        L15:
            r4 = r7
            r7 = r6
            r6 = r4
        L18:
            int r2 = r2 + 1
            byte r3 = (byte) r7
            r1[r2] = r3
            if (r2 != r5) goto L28
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L28:
            r3 = r0[r6]
            r4 = r6
            r6 = r5
            r5 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r4
        L32:
            int r7 = r7 + r5
            int r7 = r7 + (-4)
            int r5 = r8 + 1
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r4 = r6
            r6 = r5
            r5 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillDetailsActivity.a(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r0 = id.dana.splitbill.view.SplitBillDetailsActivity.$$a
            int r7 = r7 + 4
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L32
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            int r7 = r8 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillDetailsActivity.c(int, byte, int, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1371025802, (-118) - View.resolveSize(0, 0), (byte) (ImageFormat.getBitsPerPixel(0) + 1), (short) ((-48) - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), KeyEvent.normalizeMetaState(0) + 1167991017, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(View.resolveSize(0, 0) + 1371025815, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 118, (byte) ((Process.getThreadPriority(0) + 20) >> 6), (short) ((-7) - (ViewConfiguration.getTouchSlop() >> 8)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1167991035, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(1371025761 - (ViewConfiguration.getWindowTouchSlop() >> 8), Color.red(0) - 118, (byte) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), (short) (34 - KeyEvent.getDeadChar(0, 0)), 1167991040 - (ViewConfiguration.getKeyRepeatDelay() >> 16), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((Process.myTid() >> 22) + 1371025803, Color.green(0) - 118, (byte) (Process.myTid() >> 22), (short) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 32), 1167991088 - (ViewConfiguration.getScrollBarSize() >> 8), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((Process.myTid() >> 22) + 1371025756, TextUtils.lastIndexOf("", '0') - 117, (byte) (ViewConfiguration.getScrollBarSize() >> 8), (short) (TextUtils.indexOf((CharSequence) "", '0') - 70), 1151213936 - Color.rgb(0, 0, 0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(1371025811 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 119, (byte) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), (short) ((ViewConfiguration.getFadingEdgeLength() >> 16) - 94), 1167991216 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(1371025763 - (ViewConfiguration.getTapTimeout() >> 16), (-117) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (byte) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (short) ((-15) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), View.resolveSize(0, 0) + 1167991276, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), TextUtils.indexOf("", "", 0) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (-PlaceComponentResult[30]), PlaceComponentResult[32], PlaceComponentResult[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-PlaceComponentResult[30]);
                byte b2 = (byte) (b + 1);
                Object[] objArr14 = new Object[1];
                a(b, b2, (byte) (b2 | 22), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getDoubleTapTimeout() >> 16), TextUtils.lastIndexOf("", '0') + 4, (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), (byte) ($$a[47] - 1), $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 15 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 800, 14 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getTrimmedLength(""), 29 - TextUtils.indexOf("", "", 0), (char) (57994 - KeyEvent.keyCodeFromString("")))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 800, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 14, (char) ((-1) - Process.getGidForName(""))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-647493441, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), Color.alpha(0) + 18, (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[30]), PlaceComponentResult[32], PlaceComponentResult[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (-PlaceComponentResult[30]);
                byte b4 = (byte) (b3 + 1);
                Object[] objArr20 = new Object[1];
                a(b3, b4, (byte) (b4 | 22), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 46 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (Process.myPid() >> 22));
                        byte b5 = (byte) ($$a[47] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b5, (byte) (b5 | Ascii.ETB), (byte) (-$$a[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-647493441, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[30]), PlaceComponentResult[32], PlaceComponentResult[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = (byte) (-PlaceComponentResult[30]);
                byte b7 = (byte) (b6 + 1);
                Object[] objArr26 = new Object[1];
                a(b6, b7, (byte) (b7 | 22), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 118, 4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (TextUtils.indexOf("", "", 0) + 38968));
                        byte b8 = (byte) ($$a[47] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b8, (byte) (b8 | Ascii.ETB), (byte) (-$$a[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-647493441, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Gravity.getAbsoluteGravity(0, 0), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[30]), PlaceComponentResult[32], PlaceComponentResult[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = (byte) (-PlaceComponentResult[30]);
                byte b10 = (byte) (b9 + 1);
                Object[] objArr32 = new Object[1];
                a(b9, b10, (byte) (b10 | 22), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 107, 2 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[53]), (byte) ($$a[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), 34 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-647493441, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, 18 - Color.red(0), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_split_bill_details;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3 = new Object[1];
        b(super.getResources().getString(R.string.transfer_account_status_subtitle_pending).substring(8, 9).length() + 1371025802, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) - 117, (byte) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), (short) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) - 49), getPackageName().length() + 1167991010, objArr3);
        Class<?> cls = Class.forName((String) objArr3[0]);
        Object[] objArr4 = new Object[1];
        b((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1371025815, getPackageName().codePointAt(2) - 164, (byte) (ViewConfiguration.getScrollBarSize() >> 8), (short) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 7), 1167991035 - KeyEvent.getDeadChar(0, 0), objArr4);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = PlaceComponentResult[25];
                    byte b2 = b;
                    Object[] objArr5 = new Object[1];
                    a(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr5);
                    Class<?> cls2 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], objArr6);
                    int i = ((ApplicationInfo) cls2.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 1371025770;
                    int argb = (-118) - Color.argb(0, 0, 0, 0);
                    try {
                        byte b3 = PlaceComponentResult[25];
                        byte b4 = b3;
                        Object[] objArr7 = new Object[1];
                        a(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], new Object[1]);
                        byte b5 = (byte) (((ApplicationInfo) cls3.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33);
                        try {
                            byte b6 = PlaceComponentResult[25];
                            byte b7 = b6;
                            Object[] objArr8 = new Object[1];
                            a(b6, b7, (byte) (b7 | TarHeader.LF_BLK), objArr8);
                            Class<?> cls4 = Class.forName((String) objArr8[0]);
                            a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], new Object[1]);
                            Object[] objArr9 = new Object[1];
                            b(i, argb, b5, (short) (((ApplicationInfo) cls4.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 137), super.getResources().getString(R.string.offline_merchant_title).substring(1, 2).length() + 1167990972, objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            try {
                                byte b8 = PlaceComponentResult[25];
                                byte b9 = b8;
                                Object[] objArr10 = new Object[1];
                                a(b8, b9, (byte) (b9 | TarHeader.LF_BLK), objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                Object[] objArr11 = new Object[1];
                                a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], objArr11);
                                int i2 = ((ApplicationInfo) cls6.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 1371025772;
                                int codePointAt = getPackageName().codePointAt(1) - 218;
                                byte codePointAt2 = (byte) (super.getResources().getString(R.string.unsafe_device_rooted_title).substring(4, 5).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN);
                                short s = (short) (127 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                                try {
                                    byte b10 = PlaceComponentResult[25];
                                    byte b11 = b10;
                                    Object[] objArr12 = new Object[1];
                                    a(b10, b11, (byte) (b11 | TarHeader.LF_BLK), objArr12);
                                    Class<?> cls7 = Class.forName((String) objArr12[0]);
                                    Object[] objArr13 = new Object[1];
                                    a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], objArr13);
                                    int i3 = ((ApplicationInfo) cls7.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 1167990966;
                                    Object[] objArr14 = new Object[1];
                                    b(i2, codePointAt, codePointAt2, s, i3, objArr14);
                                    baseContext = (Context) cls5.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
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
                } catch (Throwable th5) {
                    Throwable cause5 = th5.getCause();
                    if (cause5 == null) {
                        throw th5;
                    }
                    throw cause5;
                }
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj != null) {
                        objArr = null;
                    } else {
                        objArr = null;
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionGroup(0L), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(objArr, objArr);
                    int length = super.getResources().getString(R.string.error_saving_account_reach_monthly_limit).substring(4, 11).length() + 1371025754;
                    int length2 = getPackageName().length() - 125;
                    byte length3 = (byte) (super.getResources().getString(R.string.empty_state_identity_cards_title_v3).substring(3, 4).length() - 1);
                    short codePointAt3 = (short) (super.getResources().getString(R.string.dialog_contact_us_call).substring(1, 2).codePointAt(0) - 63);
                    try {
                        byte b12 = PlaceComponentResult[25];
                        byte b13 = b12;
                        Object[] objArr15 = new Object[1];
                        a(b12, b13, (byte) (b13 | TarHeader.LF_BLK), objArr15);
                        Class<?> cls8 = Class.forName((String) objArr15[0]);
                        Object[] objArr16 = new Object[1];
                        a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], objArr16);
                        int i4 = ((ApplicationInfo) cls8.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 1167991007;
                        Object[] objArr17 = new Object[1];
                        b(length, length2, length3, codePointAt3, i4, objArr17);
                        String str = (String) objArr17[0];
                        Object[] objArr18 = new Object[1];
                        b(1371025803 - Drawable.resolveOpacity(0, 0), super.getResources().getString(R.string.my_bills_swipe_action_history).substring(1, 2).codePointAt(0) - 223, (byte) (getPackageName().codePointAt(4) - 97), (short) ((-31) - ExpandableListView.getPackedPositionGroup(0L)), super.getResources().getString(R.string.friend_request_message).substring(1, 2).length() + 1167991087, objArr18);
                        String str2 = (String) objArr18[0];
                        int length4 = getPackageName().length() + 1371025749;
                        int length5 = super.getResources().getString(R.string.promo_applied_title).substring(0, 6).length() - 124;
                        byte offsetBefore = (byte) TextUtils.getOffsetBefore("", 0);
                        try {
                            byte b14 = PlaceComponentResult[25];
                            byte b15 = b14;
                            Object[] objArr19 = new Object[1];
                            a(b14, b15, (byte) (b15 | TarHeader.LF_BLK), objArr19);
                            Class<?> cls9 = Class.forName((String) objArr19[0]);
                            a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], new Object[1]);
                            short s2 = (short) (((ApplicationInfo) cls9.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 104);
                            try {
                                byte b16 = PlaceComponentResult[25];
                                byte b17 = b16;
                                Object[] objArr20 = new Object[1];
                                a(b16, b17, (byte) (b17 | TarHeader.LF_BLK), objArr20);
                                Class<?> cls10 = Class.forName((String) objArr20[0]);
                                Object[] objArr21 = new Object[1];
                                a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], objArr21);
                                int i5 = ((ApplicationInfo) cls10.getMethod((String) objArr21[0], null).invoke(this, null)).targetSdkVersion + 1167991119;
                                Object[] objArr22 = new Object[1];
                                b(length4, length5, offsetBefore, s2, i5, objArr22);
                                String str3 = (String) objArr22[0];
                                Object[] objArr23 = new Object[1];
                                b(Color.blue(0) + 1371025810, super.getResources().getString(R.string.bottom_on_boarding_send_money_second_body_text).substring(10, 11).codePointAt(0) - 150, (byte) (getPackageName().length() - 7), (short) ((-94) - KeyEvent.getDeadChar(0, 0)), getPackageName().codePointAt(2) + 1167991170, objArr23);
                                String str4 = (String) objArr23[0];
                                int lastIndexOf = 1371025762 - TextUtils.lastIndexOf("", '0');
                                try {
                                    byte b18 = PlaceComponentResult[25];
                                    byte b19 = b18;
                                    Object[] objArr24 = new Object[1];
                                    a(b18, b19, (byte) (b19 | TarHeader.LF_BLK), objArr24);
                                    Class<?> cls11 = Class.forName((String) objArr24[0]);
                                    a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], new Object[1]);
                                    Object[] objArr25 = new Object[1];
                                    b(lastIndexOf, ((ApplicationInfo) cls11.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 151, (byte) (super.getResources().getString(R.string.system_error_title).substring(2, 7).length() - 5), (short) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 16), Color.argb(0, 0, 0, 0) + 1167991276, objArr25);
                                    try {
                                        Object[] objArr26 = {baseContext, str, str2, str3, str4, true, (String) objArr25[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr26);
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
        }
        try {
            Object[] objArr27 = new Object[1];
            a((byte) (-PlaceComponentResult[30]), PlaceComponentResult[32], PlaceComponentResult[31], objArr27);
            Class<?> cls12 = Class.forName((String) objArr27[0]);
            byte b20 = (byte) (-PlaceComponentResult[30]);
            byte b21 = (byte) (b20 + 1);
            Object[] objArr28 = new Object[1];
            a(b20, b21, (byte) (b21 | 22), objArr28);
            try {
                Object[] objArr29 = {Integer.valueOf(((Integer) cls12.getMethod((String) objArr28[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls13 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 494, 4 - ExpandableListView.getPackedPositionGroup(0L), (char) ((-1) - MotionEvent.axisFromString("")));
                    Object[] objArr30 = new Object[1];
                    c((byte) (-$$a[9]), (byte) (-$$a[53]), (byte) ($$a[47] - 1), objArr30);
                    obj3 = cls13.getMethod((String) objArr30[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr31 = (Object[]) ((Method) obj3).invoke(null, objArr29);
                int i6 = ((int[]) objArr31[1])[0];
                if (((int[]) objArr31[0])[0] != i6) {
                    long j = ((r2 ^ i6) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr2 = null;
                        } else {
                            objArr2 = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                        try {
                            Object[] objArr32 = {1629526116, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 17 - ExpandableListView.getPackedPositionChild(0L), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr32);
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
                super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(R.string.card_binding_save_card_dialog_oneklik_desc).substring(92, 94).length() + 1371025801;
            int length2 = super.getResources().getString(R.string.risk_reject_blacklist_title).substring(2, 3).length() - 119;
            byte codePointAt = (byte) (getPackageName().codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS);
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(length, length2, codePointAt, (short) (((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 137), 1167990973 - ((Process.getThreadPriority(0) + 20) >> 6), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(1371025805 - (ViewConfiguration.getKeyRepeatDelay() >> 16), super.getResources().getString(R.string.home_shopping_tutorial_pay_step_1).substring(0, 1).length() - 119, (byte) TextUtils.getTrimmedLength(""), (short) (super.getResources().getString(R.string.mybills_tooltip_description_not_issued).substring(7, 8).length() + 126), getPackageName().codePointAt(4) + 1167990902, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1371025803;
            int length = super.getResources().getString(R.string.prompt_desc_suggest_to_logout).substring(18, 20).length() - 120;
            byte indexOf = (byte) TextUtils.indexOf("", "");
            short edgeSlop = (short) ((-104) - (ViewConfiguration.getEdgeSlop() >> 16));
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 1167990940;
                Object[] objArr3 = new Object[1];
                b(maximumDrawingCacheSize, length, indexOf, edgeSlop, i, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                int length2 = getPackageName().length() + 1371025798;
                int jumpTapTimeout = (-118) - (ViewConfiguration.getJumpTapTimeout() >> 16);
                byte b3 = (byte) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                short lastIndexOf = (short) (TextUtils.lastIndexOf("", '0') + 128);
                try {
                    byte b4 = PlaceComponentResult[25];
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    a(b4, b5, (byte) (b5 | TarHeader.LF_BLK), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a(PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], objArr5);
                    Object[] objArr6 = new Object[1];
                    b(length2, jumpTapTimeout, b3, lastIndexOf, ((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 1167990966, objArr6);
                    baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, View.MeasureSpec.getMode(0) + 18, (char) Color.alpha(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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

    public static Intent createIntent(Context context, SplitBillModel splitBillModel, String str) {
        Intent intent = new Intent(context, SplitBillDetailsActivity.class);
        intent.putExtra("data", splitBillModel);
        intent.putExtra("source", str);
        return intent;
    }

    public static Intent createNonEligibleUserIntent(Context context, String str) {
        return createIntent(context, null, str);
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setCenterTitle(getString(R.string.split_bill_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!getAuthRequestContext() || !isTaskRoot()) {
            super.onBackPressed();
            return;
        }
        Intent intent = new Intent(this, HomeTabActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private boolean getAuthRequestContext() {
        return getIntent().getExtras() != null && getIntent().getExtras().getBoolean(FROM_NOTIF);
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return (this.initRecordTimeStamp == null || this.lookAheadTest == null || this.scheduleImpl == null) ? false : true;
    }

    private void MyBillsEntityDataFactory(boolean z) {
        this.llSplitBillDetails.setVisibility(z ? 0 : 8);
        this.viewPayButton.setVisibility(z ? 0 : 8);
        this.viewSplitBillNotPayer.setVisibility(z ? 8 : 0);
    }

    @OnClick({R.id.view_pay_button})
    public void onPayButtonClick() {
        QrTransferModel.Builder builder = new QrTransferModel.Builder();
        String str = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        if (str == null) {
            str = "";
        }
        builder.BuiltInFictitiousFunctionClassFactory = str;
        String str2 = this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str2 == null) {
            str2 = "";
        }
        builder.MyBillsEntityDataFactory = str2;
        String str3 = this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory;
        if (str3 == null) {
            str3 = "";
        }
        builder.getAuthRequestContext = str3;
        String str4 = this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str4 == null) {
            str4 = "";
        }
        builder.lookAheadTest = str4;
        String str5 = this.lookAheadTest.PlaceComponentResult;
        if (str5 == null) {
            str5 = "";
        }
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        String str6 = this.lookAheadTest.MyBillsEntityDataFactory;
        builder.getErrorConfigVersion = str6 != null ? str6 : "";
        QrTransferModel KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        SendMoneyActivity.Companion companion = SendMoneyActivity.INSTANCE;
        startActivity(SendMoneyActivity.Companion.BuiltInFictitiousFunctionClassFactory(this, KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, "Split Bill"));
    }

    @OnClick({R.id.btn_ok})
    public void onOkClick() {
        onBackPressed();
    }

    private boolean PlaceComponentResult() {
        return (TextUtils.isEmpty(this.initRecordTimeStamp.moveToNextValue) || TextUtils.isEmpty(this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest)) ? false : true;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return "IN_PROGRESS".equals(this.initRecordTimeStamp.moveToNextValue) && "IN_PROGRESS".equals(this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest);
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        byte b = 0;
        if (this.getErrorConfigVersion == null) {
            DaggerSplitBillDetailsComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerSplitBillDetailsComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            this.getErrorConfigVersion = new DaggerSplitBillDetailsComponent.SplitBillDetailsComponentImpl(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, b);
        }
        this.getErrorConfigVersion.getAuthRequestContext(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            SplitBillModel splitBillModel = (SplitBillModel) extras.getParcelable("data");
            this.initRecordTimeStamp = splitBillModel;
            if (splitBillModel != null) {
                this.lookAheadTest = splitBillModel.getErrorConfigVersion;
                this.scheduleImpl = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.initRecordTimeStamp.scheduleImpl;
            }
        }
        if (BuiltInFictitiousFunctionClassFactory()) {
            this.splitBillAnalyticTracker.BuiltInFictitiousFunctionClassFactory(getSource(), this.initRecordTimeStamp.moveToNextValue, !this.initRecordTimeStamp.PlaceComponentResult());
            MyBillsEntityDataFactory(true);
            if (this.initRecordTimeStamp.PlaceComponentResult()) {
                this.viewPayButton.setVisibility(8);
            } else {
                this.ctvPayAmount.setText(this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
            }
            if (PlaceComponentResult()) {
                char c = 65535;
                if (!this.initRecordTimeStamp.PlaceComponentResult()) {
                    String str = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest;
                    switch (str.hashCode()) {
                        case -1149187101:
                            if (str.equals("SUCCESS")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -604548089:
                            if (str.equals("IN_PROGRESS")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -591252731:
                            if (str.equals("EXPIRED")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1818119806:
                            if (str.equals("REVOKED")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    if (c == 0 || c == 1) {
                        this.ivBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(this, (int) R.drawable.bg_split_bill_success));
                    } else if (c != 2) {
                        this.ivBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(this, (int) R.drawable.bg_split_bill_introduction));
                    } else {
                        this.ivBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(this, (int) R.drawable.bg_split_bill_failed));
                    }
                } else {
                    String str2 = this.initRecordTimeStamp.moveToNextValue;
                    int hashCode = str2.hashCode();
                    if (hashCode != -1149187101) {
                        if (hashCode != -604548089) {
                            if (hashCode == -591252731 && str2.equals("EXPIRED")) {
                                c = 1;
                            }
                        } else if (str2.equals("IN_PROGRESS")) {
                            c = 2;
                        }
                    } else if (str2.equals("SUCCESS")) {
                        c = 0;
                    }
                    if (c == 0) {
                        this.ivBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(this, (int) R.drawable.bg_split_bill_success));
                    } else if (c != 1) {
                        this.ivBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(this, (int) R.drawable.bg_split_bill_introduction));
                    } else {
                        this.ivBillStatus.setImageDrawable(ContextCompat.PlaceComponentResult(this, (int) R.drawable.bg_split_bill_failed));
                    }
                }
            }
            this.tvAmountTitle.setText(getString(R.string.my_bill_amount));
            this.ctvTotalAmount.setText(this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
            if (TextUtils.isEmpty(this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory)) {
                this.tvRemarks.setVisibility(8);
            } else {
                this.tvRemarks.setText(TextUtil.NetworkUserEntityData$$ExternalSyntheticLambda2(this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory));
            }
            this.payerListView.setItems(this.initRecordTimeStamp.PlaceComponentResult, this.initRecordTimeStamp.PlaceComponentResult());
            if (PlaceComponentResult()) {
                if (!this.initRecordTimeStamp.PlaceComponentResult() && KClassImpl$Data$declaredNonStaticMembers$2()) {
                    this.viewPayButton.setVisibility(0);
                    this.ctvPayAmount.setText(this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                    return;
                }
            } else if (!this.initRecordTimeStamp.PlaceComponentResult()) {
                this.viewPayButton.setVisibility(0);
                this.ctvPayAmount.setText(this.scheduleImpl.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                return;
            }
            this.viewPayButton.setVisibility(8);
            return;
        }
        MyBillsEntityDataFactory(false);
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = DatabaseTableConfigUtil;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (DatabaseTableConfigUtil[i3 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (NetworkUserEntityData$$ExternalSyntheticLambda8[i3 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (GetContactSyncConfig ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = DatabaseTableConfigUtil;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = DatabaseTableConfigUtil;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = NetworkUserEntityData$$ExternalSyntheticLambda8;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
