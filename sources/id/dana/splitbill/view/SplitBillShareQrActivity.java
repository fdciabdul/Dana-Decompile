package id.dana.splitbill.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSplitBillShareQRComponent;
import id.dana.di.component.SplitBillShareQRComponent;
import id.dana.di.modules.SplitBillShareQRModule;
import id.dana.model.HomeInfo;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.QRView;
import id.dana.sendmoney.model.ShareQRSplitBillModel;
import id.dana.splitbill.SplitBillShareQRContract;
import id.dana.utils.BarcodeUtil;
import id.dana.utils.BrightnessUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.TextUtil;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes5.dex */
public class SplitBillShareQrActivity extends BaseActivity implements SplitBillShareQRContract.View {
    public static final byte[] $$a = {104, -1, -63, 36, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 193;
    public static final byte[] PlaceComponentResult = {1, -107, Ascii.ESC, -41, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 91;
    private static int lookAheadTest = 269894777;
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String getErrorConfigVersion;
    @BindView(R.id.iv_dana_logo)
    ImageView ivDanaLogo;
    @Inject
    SplitBillShareQRContract.Presenter presenter;
    @BindView(R.id.qrv_qr)
    QRView qrView;
    private SplitBillShareQRComponent scheduleImpl;
    @BindView(R.id.tv_name)
    TextView tvNickname;
    @BindView(R.id.tv_phone_number)
    TextView tvPhoneNumber;
    @BindView(R.id.tv_remarks)
    TextView tvRemarks;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 97
            int r9 = 23 - r9
            byte[] r0 = id.dana.splitbill.view.SplitBillShareQrActivity.PlaceComponentResult
            int r7 = 56 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2e
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L2e:
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillShareQrActivity.b(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = r9 + 21
            byte[] r0 = id.dana.splitbill.view.SplitBillShareQrActivity.$$a
            int r8 = r8 + 4
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r9) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r8 = r8 + 1
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillShareQrActivity.c(int, short, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(false, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 191, Color.argb(0, 0, 0, 0) + 7, 17 - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(true, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 195, -ImageFormat.getBitsPerPixel(0), MotionEvent.axisFromString("") + 6, new char[]{5, 65532, 1, 65517, 17}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), 35 - Color.argb(0, 0, 0, 0), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(true, Color.blue(0) + 163, 28 - ExpandableListView.getPackedPositionGroup(0L), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 47, new char[]{29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(true, TextUtils.indexOf("", "") + 158, 31 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 64 - TextUtils.getOffsetBefore("", 0), new char[]{Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(false, 161 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), KeyEvent.getDeadChar(0, 0) + 35, 65 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(true, 188 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), Color.blue(0) + 16, 60 - View.combineMeasuredStates(0, 0), new char[]{17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(true, 143 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 4 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 6, new char[]{2, 65532, 7, 65535, 0, 65532}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), 18 - ExpandableListView.getPackedPositionType(0L), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(PlaceComponentResult[31], PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult[34] + 1);
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b & 40), (byte) (-PlaceComponentResult[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 55, 4 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0') + 1));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], (byte) ($$a[78] - 1), $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 16, (char) (Process.getGidForName("") + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 800, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 14, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 29, (char) (57994 - (ViewConfiguration.getKeyRepeatDelay() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 15, (char) ('0' - AndroidCharacter.getMirror('0'))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {993160677, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 18 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[31], PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (PlaceComponentResult[34] + 1);
                Object[] objArr20 = new Object[1];
                b(b2, (byte) (b2 & 40), (byte) (-PlaceComponentResult[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 60, 46 - View.combineMeasuredStates(0, 0), (char) TextUtils.indexOf("", "", 0));
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b3, (byte) (b3 | Ascii.ETB), (byte) ($$a[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {993160677, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[31], PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b4 = (byte) (PlaceComponentResult[34] + 1);
                Object[] objArr26 = new Object[1];
                b(b4, (byte) (b4 & 40), (byte) (-PlaceComponentResult[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 2, (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 38968));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b5, (byte) (b5 | Ascii.ETB), (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, (Process.myPid() >> 22) + 35, (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {993160677, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[31], PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b6 = (byte) (PlaceComponentResult[34] + 1);
                Object[] objArr32 = new Object[1];
                b(b6, (byte) (b6 & 40), (byte) (-PlaceComponentResult[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getLongPressTimeout() >> 16), 3 - TextUtils.indexOf("", "", 0), (char) (AndroidCharacter.getMirror('0') - '0'));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], $$a[53], $$a[8], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), TextUtils.getOffsetAfter("", 0) + 35, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {993160677, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_share_qr_split_bill;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(false, 191 - (ViewConfiguration.getJumpTapTimeout() >> 16), View.resolveSizeAndState(0, 0, 0) + 7, getPackageName().length() + 11, new char[]{65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(true, super.getResources().getString(R.string.sendmoney_remarks_edit_text_hint).substring(13, 14).codePointAt(0) + 99, 1 - View.resolveSizeAndState(0, 0, 0), 5 - TextUtils.getOffsetAfter("", 0), new char[]{5, 65532, 1, 65517, 17}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int indexOf = 191 - TextUtils.indexOf("", "", 0);
                int length = super.getResources().getString(R.string.gallery_permission_prompt_image_capture_desc).substring(15, 16).length() + 1;
                try {
                    byte b = (byte) (PlaceComponentResult[59] + 1);
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr4 = new Object[1];
                    b(b, b2, b2, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    a(false, indexOf, length, ((ApplicationInfo) cls2.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    int codePointAt = getPackageName().codePointAt(3) + 98;
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 12;
                    try {
                        byte b3 = (byte) (PlaceComponentResult[59] + 1);
                        byte b4 = PlaceComponentResult[25];
                        Object[] objArr6 = new Object[1];
                        b(b3, b4, b4, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        a(false, codePointAt, keyRepeatDelay, ((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{'\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4}, objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        byte b5 = (byte) (PlaceComponentResult[59] + 1);
                        byte b6 = PlaceComponentResult[25];
                        Object[] objArr8 = new Object[1];
                        b(b5, b6, b6, objArr8);
                        Class<?> cls5 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr9);
                        int i = ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 130;
                        try {
                            byte b7 = (byte) (PlaceComponentResult[59] + 1);
                            byte b8 = PlaceComponentResult[25];
                            Object[] objArr10 = new Object[1];
                            b(b7, b8, b8, objArr10);
                            Class<?> cls6 = Class.forName((String) objArr10[0]);
                            b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                            Object[] objArr11 = new Object[1];
                            a(true, i, ((ApplicationInfo) cls6.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 5, super.getResources().getString(R.string.my_bills_next_schedule_payment_late).substring(4, 5).codePointAt(0) - 49, new char[]{29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515}, objArr11);
                            String str = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(true, getPackageName().codePointAt(5) + 48, super.getResources().getString(R.string.zdoc_noface_msg).substring(0, 1).codePointAt(0) - 47, 63 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520}, objArr12);
                            String str2 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a(false, 161 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (ViewConfiguration.getTouchSlop() >> 8) + 35, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 63, new char[]{Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote}, objArr13);
                            String str3 = (String) objArr13[0];
                            int codePointAt2 = super.getResources().getString(R.string.msg_share_text).substring(0, 1).codePointAt(0) + 117;
                            try {
                                byte b9 = (byte) (PlaceComponentResult[59] + 1);
                                byte b10 = PlaceComponentResult[25];
                                Object[] objArr14 = new Object[1];
                                b(b9, b10, b10, objArr14);
                                Class<?> cls7 = Class.forName((String) objArr14[0]);
                                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                                Object[] objArr15 = new Object[1];
                                a(true, codePointAt2, ((ApplicationInfo) cls7.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 17, 61 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4}, objArr15);
                                String str4 = (String) objArr15[0];
                                Object[] objArr16 = new Object[1];
                                a(true, super.getResources().getString(R.string.share_feed_consent_dialog_message).substring(28, 29).length() + 141, 3 - TextUtils.getOffsetBefore("", 0), TextUtils.lastIndexOf("", '0', 0, 0) + 7, new char[]{2, 65532, 7, 65535, 0, 65532}, objArr16);
                                try {
                                    Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), Color.green(0) + 18, (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr17);
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
        }
        try {
            Object[] objArr18 = new Object[1];
            b(PlaceComponentResult[31], PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr18);
            Class<?> cls8 = Class.forName((String) objArr18[0]);
            byte b11 = (byte) (PlaceComponentResult[34] + 1);
            Object[] objArr19 = new Object[1];
            b(b11, (byte) (b11 & 40), (byte) (-PlaceComponentResult[30]), objArr19);
            try {
                Object[] objArr20 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 494, (Process.myTid() >> 22) + 4, (char) Color.argb(0, 0, 0, 0));
                    Object[] objArr21 = new Object[1];
                    c($$a[9], $$a[53], $$a[8], objArr21);
                    obj3 = cls9.getMethod((String) objArr21[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                int i2 = ((int[]) objArr22[1])[0];
                if (((int[]) objArr22[0])[0] != i2) {
                    long j = ((r2 ^ i2) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr23 = {2069397010, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr23);
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
                super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(false, 239 - AndroidCharacter.getMirror('0'), 2 - (ViewConfiguration.getDoubleTapTimeout() >> 16), super.getResources().getString(R.string.option_yes).substring(0, 1).length() + 25, new char[]{65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = (byte) (PlaceComponentResult[59] + 1);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                b(b, b2, b2, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr3);
                Object[] objArr4 = new Object[1];
                a(false, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 165, 12 - TextUtils.getOffsetBefore("", 0), super.getResources().getString(R.string.general_error_desc_failed_load).substring(10, 11).codePointAt(0) - 87, new char[]{'\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 18 - Color.red(0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            Object[] objArr = new Object[1];
            a(false, super.getResources().getString(R.string.send_money_save_rename_bank_account).substring(0, 1).codePointAt(0) + 108, getPackageName().codePointAt(6) - 95, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int normalizeMetaState = KeyEvent.normalizeMetaState(0) + 198;
            try {
                byte b = (byte) (PlaceComponentResult[59] + 1);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                b(b, b2, b2, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                try {
                    Object[] objArr3 = new Object[1];
                    a(false, normalizeMetaState, ((ApplicationInfo) cls2.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 21, super.getResources().getString(R.string.general_error_desc_failed_load).substring(10, 11).length() + 17, new char[]{'\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4}, objArr3);
                    baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    th = th;
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.lastIndexOf("", '0', 0) + 36, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
        super.onResume();
    }

    public static Intent createIntent(BaseActivity baseActivity, ShareQRSplitBillModel shareQRSplitBillModel) {
        Intent intent = new Intent(baseActivity, SplitBillShareQrActivity.class);
        intent.putExtra("data", shareQRSplitBillModel);
        return intent;
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        ShareQRSplitBillModel shareQRSplitBillModel;
        BrightnessUtil.KClassImpl$Data$declaredNonStaticMembers$2(this);
        QRView qRView = this.qrView;
        if (qRView != null && this.ivDanaLogo != null) {
            qRView.showSkeleton();
            this.ivDanaLogo.setVisibility(8);
        }
        if (this.scheduleImpl == null) {
            DaggerSplitBillShareQRComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerSplitBillShareQRComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (SplitBillShareQRModule) Preconditions.getAuthRequestContext(new SplitBillShareQRModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, SplitBillShareQRModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
            this.scheduleImpl = new DaggerSplitBillShareQRComponent.SplitBillShareQRComponentImpl(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, (byte) 0);
        }
        this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(this);
        Intent intent = getIntent();
        if (intent != null && (shareQRSplitBillModel = (ShareQRSplitBillModel) intent.getParcelableExtra("data")) != null) {
            this.getErrorConfigVersion = shareQRSplitBillModel.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = shareQRSplitBillModel.BuiltInFictitiousFunctionClassFactory;
        }
        if (TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            showWarningDialog(ErrorUtil.BuiltInFictitiousFunctionClassFactory(this), new SplitBillShareQrActivity$$ExternalSyntheticLambda0(this));
        }
        this.presenter.MyBillsEntityDataFactory();
    }

    @OnClick({R.id.ll_page_container})
    public void onClose() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayQrImageView$0$id-dana-splitbill-view-SplitBillShareQrActivity  reason: not valid java name */
    public /* synthetic */ void m2975x38c89b01(Bitmap bitmap) throws Exception {
        this.qrView.getQrImageView().setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayQrImageView$1$id-dana-splitbill-view-SplitBillShareQrActivity  reason: not valid java name */
    public /* synthetic */ void m2976x38523502(Throwable th) throws Exception {
        this.qrView.getQrImageView().setImageBitmap(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showGeneralErrorMsg$2$id-dana-splitbill-view-SplitBillShareQrActivity  reason: not valid java name */
    public /* synthetic */ void m2977xbab826b0(DialogInterface dialogInterface) {
        finish();
    }

    @Override // id.dana.splitbill.SplitBillShareQRContract.View
    public void onFinishGetHomeInfo(HomeInfo homeInfo) {
        if (homeInfo == null) {
            showWarningDialog(ErrorUtil.BuiltInFictitiousFunctionClassFactory(this), new SplitBillShareQrActivity$$ExternalSyntheticLambda0(this));
            return;
        }
        QRView qRView = this.qrView;
        if (qRView != null && this.ivDanaLogo != null) {
            qRView.hideSkeleton();
            this.ivDanaLogo.setVisibility(0);
        }
        String str = homeInfo.PlaceComponentResult;
        if (this.tvNickname != null && !TextUtils.isEmpty(str)) {
            this.tvNickname.setText(str);
        }
        String BuiltInFictitiousFunctionClassFactory = MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(homeInfo.MyBillsEntityDataFactory, false);
        if (this.tvPhoneNumber != null && !TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
            this.tvPhoneNumber.setText(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, false));
        }
        this.qrView.displayUserAvatar(homeInfo.BuiltInFictitiousFunctionClassFactory);
        this.qrView.setKycView(homeInfo.getAuthRequestContext.PlaceComponentResult);
        addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0).subscribe(new Consumer() { // from class: id.dana.splitbill.view.SplitBillShareQrActivity$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SplitBillShareQrActivity.this.m2975x38c89b01((Bitmap) obj);
            }
        }, new Consumer() { // from class: id.dana.splitbill.view.SplitBillShareQrActivity$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SplitBillShareQrActivity.this.m2976x38523502((Throwable) obj);
            }
        }));
        String str2 = this.getErrorConfigVersion;
        TextView textView = this.tvRemarks;
        if (textView != null) {
            textView.setText(TextUtil.NetworkUserEntityData$$ExternalSyntheticLambda2(str2));
        }
    }

    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (lookAheadTest ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
