package id.dana.lib.drawbitmap.invoice;

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
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.lib.drawbitmap.invoice.model.HeaderEntity;
import id.dana.lib.drawbitmap.invoice.model.OrderDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.PaymentMethodEntity;
import id.dana.lib.drawbitmap.invoice.model.PriceDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.SummaryEntity;
import id.dana.lib.drawbitmap.invoice.model.TransactionDetailEntity;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

/* loaded from: classes8.dex */
public class InvoiceActivity extends AppCompatActivity {
    private HeaderEntity header;
    private OrderDetailEntity orderDetail;
    private PaymentMethodEntity paymentMethod;
    private List<PriceDetailEntity> priceDetails;
    private SummaryEntity summary;
    private List<TransactionDetailEntity> transactionDetails;
    public static final byte[] $$a = {36, -25, -14, -85, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 84;
    public static final byte[] PlaceComponentResult = {44, -51, -23, -10, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 130;
    private static char scheduleImpl = 42066;
    private static char[] getAuthRequestContext = {37275, 37310, 37281, 37311, 37289, 37260, 37293, 37302, 37287, 37345, 37251, 37291, 37255, 37248, 37290, 37252, 37305, 37375, 37254, 37373, 37371, 37282, 37250, 37372, 37306, 37368, 37374, 37249, 37365, 37279, 37308, 37294, 37263, 37367, 37261, 37274, 37370, 37286, 37309, 37253, 37283, 37292, 37366, 37369, 37288, 37280, 37307, 37262, 37344};

    private static void b(short s, short s2, short s3, Object[] objArr) {
        byte[] bArr = PlaceComponentResult;
        int i = 106 - s;
        int i2 = s3 + 4;
        int i3 = s2 + 16;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            i = (i2 + i) - 4;
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i2;
            i = (i + bArr[i2]) - 4;
            i2 = i7 + 1;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r0 = id.dana.lib.drawbitmap.invoice.InvoiceActivity.$$a
            int r8 = 46 - r8
            int r9 = r9 * 3
            int r9 = r9 + 21
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            int r8 = r8 + 1
            r1[r3] = r5
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.drawbitmap.invoice.InvoiceActivity.c(short, short, short, java.lang.Object[]):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((byte) (45 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), new char[]{30, 3, '\n', '\'', ',', Typography.amp, '\f', '\n', ',', 31, '\b', 30, '-', 3, '#', 20, 13846, 13846}, 18 - Color.alpha(0), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((byte) (50 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), new char[]{28, 14, Typography.dollar, Typography.amp, 13872}, TextUtils.lastIndexOf("", '0', 0, 0) + 6, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((byte) ((ViewConfiguration.getScrollBarSize() >> 8) + 73), new char[]{27, '\'', '/', 29, 18, '\n', '/', 28, 21, 18, '\'', 6, 15, 20, 22, '/', 13812, 13812, '-', 29, '\r', '\'', Typography.dollar, '0', '\t', 25, InputCardNumberView.DIVIDER, '\f', 18, '\f', 28, 17, '+', ',', 14, '/', 0, '.', 31, 19, InputCardNumberView.DIVIDER, 11, 15, '0', 2, 27, '*', 15}, 48 - View.MeasureSpec.getSize(0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) (49 - KeyEvent.getDeadChar(0, 0)), new char[]{29, Typography.amp, '.', '\b', 0, '.', 19, 31, '\r', '\'', '+', '#', '\f', 25, 27, 19, 13785, 13785, 5, 25, '\f', 25, ',', 22, '0', 1, 0, 21, InputCardNumberView.DIVIDER, '\f', 13785, 13785, '\'', '\r', 19, Typography.quote, 13866, 13866, 16, 24, Typography.amp, 15, 19, 21, '\'', 27, 27, JSONLexer.EOI, 13786, 13786, 21, '.', '.', 21, 19, 24, 19, 24, '0', '\r', '!', '(', '\t', 25}, 64 - Color.alpha(0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) (Process.getGidForName("") + 42), new char[]{JSONLexer.EOI, '!', 20, 0, '.', 21, 20, 14, 13771, 13771, '(', '!', 27, 24, 18, 24, 28, 17, 18, '\r', 20, 5, 30, 24, InputCardNumberView.DIVIDER, 11, '/', 28, 13861, 13861, 27, '\'', InputCardNumberView.DIVIDER, 18, JSONLexer.EOI, '(', 4, 27, '/', 29, InputCardNumberView.DIVIDER, 5, 27, 19, 31, 19, Typography.quote, 3, 0, '.', '#', 20, JSONLexer.EOI, '!', 1, '\'', 22, '\'', '+', ',', 1, '\'', '#', '+'}, 64 - ((Process.getThreadPriority(0) + 20) >> 6), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((byte) (View.MeasureSpec.makeMeasureSpec(0, 0) + 7), new char[]{11, '+', '-', 4, 31, 29, 13756, 13756, '\n', InputCardNumberView.DIVIDER, 3, 30, 11, ',', '\n', Typography.dollar, 17, 28, '0', '\'', InputCardNumberView.DIVIDER, 31, ',', 11, '-', 23, Typography.amp, '-', '\t', InputCardNumberView.DIVIDER, 3, 22, Typography.amp, '-', 16, 7, Typography.amp, '0', 27, '*', Typography.amp, '\n', ')', ',', ',', '\t', '*', 16, InputCardNumberView.DIVIDER, ',', ',', 20, 20, '/', 15, 17, 16, 0, ',', InputCardNumberView.DIVIDER}, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 60, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((byte) (Color.red(0) + 18), new char[]{',', 7, 16, '\r', JSONLexer.EOI, '!'}, View.resolveSizeAndState(0, 0, 0) + 6, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 18 - KeyEvent.normalizeMetaState(0), (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b2 = b;
                Object[] objArr13 = new Object[1];
                b(b, b2, (byte) (b2 | 37), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(PlaceComponentResult[7], PlaceComponentResult[25], PlaceComponentResult[35], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.getOffsetBefore("", 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3, (char) TextUtils.indexOf("", "", 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], $$a[53], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 800, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 15, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 800, 15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 815, Color.green(0) + 29, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), Color.green(0) + 15, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0'), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1846906989, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), View.MeasureSpec.getMode(0) + 18, (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = b3;
                Object[] objArr19 = new Object[1];
                b(b3, b4, (byte) (b4 | 37), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(PlaceComponentResult[7], PlaceComponentResult[25], PlaceComponentResult[35], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 61, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 46, (char) View.getDefaultSize(0, 0));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.getDefaultSize(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1846906989, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = b5;
                Object[] objArr25 = new Object[1];
                b(b5, b6, (byte) (b6 | 37), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(PlaceComponentResult[7], PlaceComponentResult[25], PlaceComponentResult[35], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getEdgeSlop() >> 16), 2 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ExpandableListView.getPackedPositionType(0L) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, MotionEvent.axisFromString("") + 36, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1846906989, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b8 = b7;
                Object[] objArr31 = new Object[1];
                b(b7, b8, (byte) (b8 | 37), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(PlaceComponentResult[7], PlaceComponentResult[25], PlaceComponentResult[35], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - TextUtils.indexOf((CharSequence) "", '0', 0), 2 - TextUtils.indexOf((CharSequence) "", '0'), (char) View.MeasureSpec.getMode(0));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], (byte) ($$a[78] - 1), $$a[8], objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "", 0) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1846906989, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, 18 - TextUtils.getTrimmedLength(""), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (MotionEvent.axisFromString("") + 25), new char[]{30, 3, '\n', '\'', ',', Typography.amp, '\f', '\n', Typography.amp, '\n', 2, '\n', '0', '(', ',', '\'', 23, ',', '*', 11, 1, 7, '#', 17, InputCardNumberView.DIVIDER, '\n'}, Gravity.getAbsoluteGravity(0, 0) + 26, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (super.getResources().getString(R.string.select_service).substring(2, 3).codePointAt(0) - 10), new char[]{Typography.amp, 27, 13898, 13898, 16, 0, '/', '0', 13900, 13900, ')', Typography.amp, Typography.amp, Typography.quote, ',', '\'', ',', 3}, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (super.getResources().getString(R.string.referral_tracker_hidden_button_play).substring(4, 15).codePointAt(3) - 86), new char[]{30, 3, '\n', '\'', ',', Typography.amp, '\f', '\n', Typography.amp, '\n', 2, '\n', '0', '(', ',', '\'', 23, ',', '*', 11, 1, 7, '#', 17, InputCardNumberView.DIVIDER, '\n'}, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 26, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte codePointAt = (byte) (super.getResources().getString(R.string.bank_account_number).substring(10, 11).codePointAt(0) - 12);
            char[] cArr = {Typography.amp, 27, 13898, 13898, 16, 0, '/', '0', 13900, 13900, ')', Typography.amp, Typography.amp, Typography.quote, ',', '\'', ',', 3};
            try {
                Object[] objArr2 = new Object[1];
                b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(PlaceComponentResult[13], PlaceComponentResult[56], (byte) (PlaceComponentResult[59] + 1), new Object[1]);
                Object[] objArr3 = new Object[1];
                a(codePointAt, cArr, ((ApplicationInfo) cls2.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 15, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 35 - TextUtils.indexOf("", ""), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, Process.getGidForName("") + 19, (char) TextUtils.getOffsetAfter("", 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a((byte) (super.getResources().getString(R.string.nps_survey_slider_label_yes).substring(0, 1).codePointAt(0) - 44), new char[]{30, 3, '\n', '\'', ',', Typography.amp, '\f', '\n', ',', 31, '\b', 30, '-', 3, '#', 20, 13846, 13846}, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        byte bitsPerPixel = (byte) (ImageFormat.getBitsPerPixel(0) + 51);
        char[] cArr = {28, 14, Typography.dollar, Typography.amp, 13872};
        try {
            Object[] objArr3 = new Object[1];
            b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            b(PlaceComponentResult[13], PlaceComponentResult[56], (byte) (PlaceComponentResult[59] + 1), new Object[1]);
            Object[] objArr4 = new Object[1];
            a(bitsPerPixel, cArr, ((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 28, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a((byte) (getPackageName().length() + 17), new char[]{30, 3, '\n', '\'', ',', Typography.amp, '\f', '\n', Typography.amp, '\n', 2, '\n', '0', '(', ',', '\'', 23, ',', '*', 11, 1, 7, '#', 17, InputCardNumberView.DIVIDER, '\n'}, super.getResources().getString(R.string.social_widget_onboarding_date_1).substring(1, 2).codePointAt(0) - 75, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    try {
                        Object[] objArr6 = new Object[1];
                        b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(PlaceComponentResult[13], PlaceComponentResult[56], (byte) (PlaceComponentResult[59] + 1), objArr7);
                        byte b = (byte) (((ApplicationInfo) cls4.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 65);
                        char[] cArr2 = {Typography.amp, 27, 13898, 13898, 16, 0, '/', '0', 13900, 13900, ')', Typography.amp, Typography.amp, Typography.quote, ',', '\'', ',', 3};
                        try {
                            Object[] objArr8 = new Object[1];
                            b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            b(PlaceComponentResult[13], PlaceComponentResult[56], (byte) (PlaceComponentResult[59] + 1), new Object[1]);
                            Object[] objArr9 = new Object[1];
                            a(b, cArr2, ((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 15, objArr9);
                            baseContext = (Context) cls3.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr10 = new Object[1];
                        a((byte) (getPackageName().codePointAt(2) + 27), new char[]{27, '\'', '/', 29, 18, '\n', '/', 28, 21, 18, '\'', 6, 15, 20, 22, '/', 13812, 13812, '-', 29, '\r', '\'', Typography.dollar, '0', '\t', 25, InputCardNumberView.DIVIDER, '\f', 18, '\f', 28, 17, '+', ',', 14, '/', 0, '.', 31, 19, InputCardNumberView.DIVIDER, 11, 15, '0', 2, 27, '*', 15}, 49 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr10);
                        String str = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a((byte) (((byte) KeyEvent.getModifierMetaStateMask()) + TarHeader.LF_SYMLINK), new char[]{29, Typography.amp, '.', '\b', 0, '.', 19, 31, '\r', '\'', '+', '#', '\f', 25, 27, 19, 13785, 13785, 5, 25, '\f', 25, ',', 22, '0', 1, 0, 21, InputCardNumberView.DIVIDER, '\f', 13785, 13785, '\'', '\r', 19, Typography.quote, 13866, 13866, 16, 24, Typography.amp, 15, 19, 21, '\'', 27, 27, JSONLexer.EOI, 13786, 13786, 21, '.', '.', 21, 19, 24, 19, 24, '0', '\r', '!', '(', '\t', 25}, super.getResources().getString(R.string.btn_lbl_home_widget_explore).substring(3, 4).length() + 63, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a((byte) (TextUtils.indexOf("", "", 0, 0) + 41), new char[]{JSONLexer.EOI, '!', 20, 0, '.', 21, 20, 14, 13771, 13771, '(', '!', 27, 24, 18, 24, 28, 17, 18, '\r', 20, 5, 30, 24, InputCardNumberView.DIVIDER, 11, '/', 28, 13861, 13861, 27, '\'', InputCardNumberView.DIVIDER, 18, JSONLexer.EOI, '(', 4, 27, '/', 29, InputCardNumberView.DIVIDER, 5, 27, 19, 31, 19, Typography.quote, 3, 0, '.', '#', 20, JSONLexer.EOI, '!', 1, '\'', 22, '\'', '+', ',', 1, '\'', '#', '+'}, 65 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr12);
                        String str3 = (String) objArr12[0];
                        byte length = (byte) (super.getResources().getString(R.string.max_send_amount_error_message_idr).substring(12, 13).length() + 6);
                        char[] cArr3 = {11, '+', '-', 4, 31, 29, 13756, 13756, '\n', InputCardNumberView.DIVIDER, 3, 30, 11, ',', '\n', Typography.dollar, 17, 28, '0', '\'', InputCardNumberView.DIVIDER, 31, ',', 11, '-', 23, Typography.amp, '-', '\t', InputCardNumberView.DIVIDER, 3, 22, Typography.amp, '-', 16, 7, Typography.amp, '0', 27, '*', Typography.amp, '\n', ')', ',', ',', '\t', '*', 16, InputCardNumberView.DIVIDER, ',', ',', 20, 20, '/', 15, 17, 16, 0, ',', InputCardNumberView.DIVIDER};
                        try {
                            Object[] objArr13 = new Object[1];
                            b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr13);
                            Class<?> cls6 = Class.forName((String) objArr13[0]);
                            Object[] objArr14 = new Object[1];
                            b(PlaceComponentResult[13], PlaceComponentResult[56], (byte) (PlaceComponentResult[59] + 1), objArr14);
                            Object[] objArr15 = new Object[1];
                            a(length, cArr3, ((ApplicationInfo) cls6.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 27, objArr15);
                            String str4 = (String) objArr15[0];
                            byte blue = (byte) (18 - Color.blue(0));
                            char[] cArr4 = {',', 7, 16, '\r', JSONLexer.EOI, '!'};
                            try {
                                Object[] objArr16 = new Object[1];
                                b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr16);
                                Class<?> cls7 = Class.forName((String) objArr16[0]);
                                b(PlaceComponentResult[13], PlaceComponentResult[56], (byte) (PlaceComponentResult[59] + 1), new Object[1]);
                                Object[] objArr17 = new Object[1];
                                a(blue, cArr4, ((ApplicationInfo) cls7.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 27, objArr17);
                                try {
                                    Object[] objArr18 = {baseContext, str, str2, str3, str4, true, (String) objArr17[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr18);
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
                }
            }
            try {
                byte b2 = PlaceComponentResult[25];
                byte b3 = b2;
                Object[] objArr19 = new Object[1];
                b(b2, b3, (byte) (b3 | 37), objArr19);
                Class<?> cls8 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(PlaceComponentResult[7], PlaceComponentResult[25], PlaceComponentResult[35], objArr20);
                try {
                    Object[] objArr21 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - Process.getGidForName(""), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 3, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                        Object[] objArr22 = new Object[1];
                        c($$a[9], (byte) ($$a[78] - 1), $$a[8], objArr22);
                        obj3 = cls9.getMethod((String) objArr22[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj3).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), TextUtils.getTrimmedLength("") + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr24 = {-29041944, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr24);
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
                    super.onCreate(bundle);
                    mock();
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

    private void mock() {
        HeaderEntity headerEntity = new HeaderEntity();
        this.header = headerEntity;
        headerEntity.setAmount("Rp50.000");
        this.header.setDesc("Anda telah berhasil membeli Pulsa");
        this.header.setDate("13 Maret 2019");
        this.header.setTime("12:30");
        this.priceDetails = new ArrayList();
        PriceDetailEntity priceDetailEntity = new PriceDetailEntity();
        priceDetailEntity.setAmount("Rp1.500");
        priceDetailEntity.setTitle("Total");
        priceDetailEntity.setType("addition");
        this.priceDetails.add(priceDetailEntity);
        PriceDetailEntity priceDetailEntity2 = new PriceDetailEntity();
        priceDetailEntity2.setAmount("Rp500");
        priceDetailEntity2.setTitle("promo");
        priceDetailEntity2.setType("addition");
        this.priceDetails.add(priceDetailEntity2);
        PriceDetailEntity priceDetailEntity3 = new PriceDetailEntity();
        priceDetailEntity3.setAmount("Rp1.000");
        priceDetailEntity3.setTitle("fee");
        priceDetailEntity3.setType("deduction");
        this.priceDetails.add(priceDetailEntity3);
        SummaryEntity.OrderStatus orderStatus = new SummaryEntity.OrderStatus();
        orderStatus.setStatus("SUCCESS");
        orderStatus.setTitle("Order Berhasil");
        SummaryEntity summaryEntity = new SummaryEntity();
        this.summary = summaryEntity;
        summaryEntity.setTitle("Indosat 50.000 - 081289811245");
        this.summary.setBizType("PULSA");
        this.summary.setDesc("Rp200.000 to Ricky Contesso");
        SummaryEntity.ExtInfo extInfo = new SummaryEntity.ExtInfo();
        extInfo.setTitle("Nomor Token");
        extInfo.setValue("0041 0021 0051 8027");
        this.summary.setExtInfo(extInfo);
        this.summary.setIconUrl("");
        this.summary.setOrderStatus(orderStatus);
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        this.orderDetail = orderDetailEntity;
        orderDetailEntity.setTitle("No. Invoice");
        this.orderDetail.setNumber("INV/20170605/XVII/VI/86428176");
        ArrayList arrayList = new ArrayList();
        OrderDetailEntity.Data data = new OrderDetailEntity.Data();
        data.setTitle("Nomor HP");
        data.setValue("082145377771");
        arrayList.add(data);
        OrderDetailEntity.Data data2 = new OrderDetailEntity.Data();
        data2.setTitle("Paket Data");
        data2.setValue("50.000");
        arrayList.add(data2);
        OrderDetailEntity.Data data3 = new OrderDetailEntity.Data();
        data3.setTitle("Nomor HP");
        data3.setValue("082145377771");
        arrayList.add(data3);
        OrderDetailEntity.Data data4 = new OrderDetailEntity.Data();
        data4.setTitle("Paket Data");
        data4.setValue("50.000");
        arrayList.add(data4);
        this.orderDetail.setData(arrayList);
        this.transactionDetails = new ArrayList();
        TransactionDetailEntity transactionDetailEntity = new TransactionDetailEntity();
        transactionDetailEntity.setTitle("ID Transaksi");
        transactionDetailEntity.setValue("2019 0717 6543 2876 9176 0134");
        this.transactionDetails.add(transactionDetailEntity);
        TransactionDetailEntity transactionDetailEntity2 = new TransactionDetailEntity();
        transactionDetailEntity2.setTitle("ID Order Merchant");
        transactionDetailEntity2.setValue("GP0765432107587652820");
        this.transactionDetails.add(transactionDetailEntity2);
        TransactionDetailEntity transactionDetailEntity3 = new TransactionDetailEntity();
        transactionDetailEntity3.setTitle("ID Transaksi");
        transactionDetailEntity3.setValue("2019 0717 6543 2876 9176 0134");
        this.transactionDetails.add(transactionDetailEntity3);
        PaymentMethodEntity paymentMethodEntity = new PaymentMethodEntity();
        this.paymentMethod = paymentMethodEntity;
        paymentMethodEntity.setDesc("Debit BCA (7652)");
        this.paymentMethod.setPaymentIconUrl("");
        this.paymentMethod.setProtectionIconUrl("");
        this.paymentMethod.setTitle("Metode Pembayaran");
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = getAuthRequestContext;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ scheduleImpl);
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
