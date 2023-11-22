package id.dana.scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.ThrottledOnClickListener;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004"}, d2 = {"Lid/dana/scanner/QrExpiredActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QrExpiredActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static int getErrorConfigVersion;
    private static byte[] lookAheadTest;
    private static int scheduleImpl;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$a = {41, -91, 83, 107, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 38;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_DIR, 93, -14, -126, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 130;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        scheduleImpl = 1257195684;
        getErrorConfigVersion = 532368701;
        lookAheadTest = new byte[]{SignedBytes.MAX_POWER_OF_TWO, -103, 96, 105, -110, -120, 65, -105, -111, 105, -113, 103, -117, -70, -119, 94, -100, -115, -87, 82, 97, 98, -97, -114, 102, -113, 72, 74, 67, 84, 118, 75, 79, 76, 77, 73, -102, 60, 67, SignedBytes.MAX_POWER_OF_TWO, 86, 73, 76, 119, 72, 93, 79, 91, 41, 32, 123, 123, -30, 89, -100, 19, 34, 35, 32, 79, 39, 80, 85, 67, 106, 34, 114, 106, -18, -38, -116, -15, -37, -113, -18, -42, -91, -34, -118, -16, -42, -95, -96, -119, -39, -96, -21, -113, -15, -40, -114, -17, -118, -35, -34, -38, -14, -40, -35, -94, -40, -34, -112, -34, -38, -33, -17, -34, -34, -120, -23, -91, -37, -118, -15, -102, Byte.MAX_VALUE, -94, -121, Byte.MAX_VALUE, -113, -36, -115, -113, -115, -107, -112, -114, -116, -118, -114, -110, -120, -108, 122, -36, 66, -39, -109, -116, -117, 65, -114, -93, -118, 126, -115, -35, -114, SignedBytes.MAX_POWER_OF_TWO, -94, 123, -94, 119, -94, -117, -111, -119, 65, -37, 67, -38, -114, -112, -117, -114, 65, -33, -110, 120, -113, -94, -122, -105, 123, -116, -96, -115, 122, -102, -14, -10, -89, 6, -7, -14, -8, -12, -89, 1, -9, -87, -12, 12, -93, -14, -11, 5, -2, -14, -13, -85, 8, -10, -12, -9, -95, 12, -16, -88, 9, -94, 10, -91, -10, 8, -9, -93, 7, -14, -92, -9, 6, -88, 6, -89, -14, 12, -17, -7, -12, -10, -3, -10, -10, -14, -12, -5, -8, -33, -7, 2, -9, -98, 14, 7, 4, Ascii.RS, 60, 87, 16, -47, 70, -46, 12, 63, 15, Ascii.DC4, 8, 83, -57, Ascii.DC4, 62, 91, -53, 15, 1, 88, -60, Ascii.SUB, 60, -31, 9, 15, 62, Ascii.ESC, 60, -31, 63, 84, -45, 12, 59, 15, Ascii.RS, 58, 17, Ascii.SUB, 3, Ascii.EM, 71, -64, Ascii.SUB, 0, 16, 88, 13, Ascii.CAN, -58, 10, 17, 13, 1, 84, 61, 56, 2, TarHeader.LF_FIFO, 7};
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 156334519;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.scanner.QrExpiredActivity.getAuthRequestContext
            int r8 = 23 - r8
            int r7 = 55 - r7
            int r6 = 106 - r6
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
            if (r3 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r7 = r7 + 1
            int r3 = r3 + 1
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
            int r6 = r6 + r7
            int r6 = r6 + (-4)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.scanner.QrExpiredActivity.b(int, byte, byte, java.lang.Object[]):void");
    }

    private static void c(byte b, byte b2, int i, Object[] objArr) {
        int i2 = 47 - b;
        int i3 = 42 - (i * 3);
        int i4 = (b2 * 2) + 75;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i4 = (i4 + i2) - 7;
            i2++;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i2];
            byte b4 = i4;
            int i8 = i2 + 1;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i4 = (b4 + b3) - 7;
            i2 = i8;
        }
    }

    @JvmStatic
    public static final Intent createIntent(Activity activity) {
        return Companion.MyBillsEntityDataFactory(activity);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1431569730, (-60) - Color.blue(0), (byte) View.MeasureSpec.makeMeasureSpec(0, 0), (short) (KeyEvent.normalizeMetaState(0) + 62), (-1136537853) - ExpandableListView.getPackedPositionChild(0L), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(View.resolveSizeAndState(0, 0, 0) - 1431569717, (-60) - (ViewConfiguration.getTapTimeout() >> 16), (byte) TextUtils.getOffsetAfter("", 0), (short) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 31), (-1136537834) - (ViewConfiguration.getLongPressTimeout() >> 16), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((-1431569771) - (ViewConfiguration.getMinimumFlingVelocity() >> 16), TextUtils.lastIndexOf("", '0', 0) - 59, (byte) (ViewConfiguration.getDoubleTapTimeout() >> 16), (short) ((-66) - KeyEvent.getDeadChar(0, 0)), ImageFormat.getBitsPerPixel(0) - 1136537828, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((-1431569728) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (KeyEvent.getMaxKeyCode() >> 16) - 60, (byte) (ViewConfiguration.getFadingEdgeLength() >> 16), (short) ((-17) - Color.red(0)), View.resolveSize(0, 0) - 1136537781, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((-1431569777) - MotionEvent.axisFromString(""), ImageFormat.getBitsPerPixel(0) - 59, (byte) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (short) ((-105) - (KeyEvent.getMaxKeyCode() >> 16)), TextUtils.lastIndexOf("", '0', 0) - 1136537716, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((-1431569722) - ExpandableListView.getPackedPositionType(0L), (-60) - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (byte) (Color.rgb(0, 0, 0) + 16777216), (short) (110 - View.getDefaultSize(0, 0)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) - 1136537653, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((ViewConfiguration.getPressedStateDuration() >> 16) - 1431569769, (-60) - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (byte) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), (short) (MotionEvent.axisFromString("") + 94), (-1136537594) - Process.getGidForName(""), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), TextUtils.getOffsetBefore("", 0) + 18, (char) Color.alpha(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.getOffsetAfter("", 0), 2 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) Color.blue(0));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[78], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 800, 15 - TextUtils.getOffsetBefore("", 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 800, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 14, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), TextUtils.getOffsetAfter("", 0) + 29, (char) (57994 - TextUtils.indexOf("", "", 0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 800, 15 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) TextUtils.getOffsetBefore("", 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - View.combineMeasuredStates(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {871844431, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0, 0) + 47, (char) View.getDefaultSize(0, 0));
                        Object[] objArr22 = new Object[1];
                        c($$a[84], $$a[9], $$a[8], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {871844431, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, AndroidCharacter.getMirror('0') - 30, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 118, (Process.myTid() >> 22) + 3, (char) (Process.getGidForName("") + 38969));
                        Object[] objArr28 = new Object[1];
                        c($$a[84], $$a[9], $$a[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {871844431, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, 18 - Gravity.getAbsoluteGravity(0, 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 107, View.getDefaultSize(0, 0) + 3, (char) View.MeasureSpec.getSize(0));
                        byte b = (byte) ($$a[78] - 1);
                        byte b2 = b;
                        Object[] objArr34 = new Object[1];
                        c(b, b2, b2, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {871844431, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_qr_expired;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        a(getPackageName().length() - 1431569736, ImageFormat.getBitsPerPixel(0) - 59, (byte) View.resolveSizeAndState(0, 0, 0), (short) (62 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (-1136537852) + (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        int length = super.getResources().getString(R.string.referral_location_permission_dialog_description).substring(2, 3).length() - 1431569718;
        int codePointAt = getPackageName().codePointAt(4) - 157;
        byte codePointAt2 = (byte) (super.getResources().getString(R.string.mybills_payment_total).substring(0, 7).codePointAt(4) - 108);
        short codePointAt3 = (short) (super.getResources().getString(R.string.topup_button).substring(0, 2).codePointAt(0) - 12);
        try {
            Object[] objArr2 = new Object[1];
            b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr3);
            int i = ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 1136537867;
            Object[] objArr4 = new Object[1];
            a(length, codePointAt, codePointAt2, codePointAt3, i, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a(super.getResources().getString(R.string.option_save).substring(0, 1).codePointAt(0) - 1431569812, (-60) - Color.argb(0, 0, 0, 0), (byte) (super.getResources().getString(R.string.note_title).substring(2, 3).codePointAt(0) - 116), (short) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 3), (-1136537895) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    int i2 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) - 1431569727;
                    int length2 = super.getResources().getString(R.string.cancel_message).substring(14, 15).length() - 61;
                    byte codePointAt4 = (byte) (getPackageName().codePointAt(5) - 110);
                    try {
                        Object[] objArr6 = new Object[1];
                        b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr7);
                        Object[] objArr8 = new Object[1];
                        a(i2, length2, codePointAt4, (short) (((ApplicationInfo) cls4.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 9), (-1136537870) - (ViewConfiguration.getTouchSlop() >> 8), objArr8);
                        baseContext = (Context) cls3.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 36 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int makeMeasureSpec = (-1431569771) - View.MeasureSpec.makeMeasureSpec(0, 0);
                        int capsMode = (-60) - TextUtils.getCapsMode("", 0, 0);
                        byte b = (byte) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        short codePointAt5 = (short) (super.getResources().getString(R.string.header_form_bank_type).substring(4, 5).codePointAt(0) - 98);
                        try {
                            Object[] objArr9 = new Object[1];
                            b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr10);
                            int i3 = ((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion - 1136537862;
                            Object[] objArr11 = new Object[1];
                            a(makeMeasureSpec, capsMode, b, codePointAt5, i3, objArr11);
                            String str = (String) objArr11[0];
                            try {
                                Object[] objArr12 = new Object[1];
                                b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr12);
                                Class<?> cls6 = Class.forName((String) objArr12[0]);
                                b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                                Object[] objArr13 = new Object[1];
                                a(((ApplicationInfo) cls6.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 1431569762, super.getResources().getString(R.string.min_balance).substring(0, 9).length() - 69, (byte) KeyEvent.getDeadChar(0, 0), (short) (getPackageName().length() - 24), super.getResources().getString(R.string.toast_revoke_saving_goal_success).substring(24, 25).codePointAt(0) - 1136537813, objArr13);
                                String str2 = (String) objArr13[0];
                                int i4 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1431569777;
                                int codePointAt6 = super.getResources().getString(R.string.share_Feed_activities_desc).substring(15, 16).codePointAt(0) - 92;
                                byte length3 = (byte) (super.getResources().getString(R.string.topup_and_pay_input_title).substring(0, 19).length() - 19);
                                short codePointAt7 = (short) (getPackageName().codePointAt(3) - 205);
                                try {
                                    Object[] objArr14 = new Object[1];
                                    b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr14);
                                    Class<?> cls7 = Class.forName((String) objArr14[0]);
                                    Object[] objArr15 = new Object[1];
                                    b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr15);
                                    int i5 = ((ApplicationInfo) cls7.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion - 1136537750;
                                    Object[] objArr16 = new Object[1];
                                    a(i4, codePointAt6, length3, codePointAt7, i5, objArr16);
                                    String str3 = (String) objArr16[0];
                                    int codePointAt8 = getPackageName().codePointAt(1) - 1431569822;
                                    try {
                                        Object[] objArr17 = new Object[1];
                                        b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr17);
                                        Class<?> cls8 = Class.forName((String) objArr17[0]);
                                        b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                                        Object[] objArr18 = new Object[1];
                                        a(codePointAt8, ((ApplicationInfo) cls8.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 93, (byte) (super.getResources().getString(R.string.pushverify_invalid_session_message).substring(3, 4).length() - 1), (short) (View.MeasureSpec.getMode(0) + 110), (-1136537653) - TextUtils.getCapsMode("", 0, 0), objArr18);
                                        String str4 = (String) objArr18[0];
                                        int codePointAt9 = super.getResources().getString(R.string.text_tnc_privacy).substring(0, 18).codePointAt(8) - 1431569836;
                                        try {
                                            Object[] objArr19 = new Object[1];
                                            b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr19);
                                            Class<?> cls9 = Class.forName((String) objArr19[0]);
                                            b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                                            Object[] objArr20 = new Object[1];
                                            a(codePointAt9, ((ApplicationInfo) cls9.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 93, (byte) (super.getResources().getString(R.string.withdraw).substring(1, 2).length() - 1), (short) (super.getResources().getString(R.string.pushverify_verify_dialog_payment_deny_message).substring(14, 15).codePointAt(0) - 21), super.getResources().getString(R.string.wallet_v3_page_title).substring(4, 6).codePointAt(0) - 1136537694, objArr20);
                                            try {
                                                Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr21);
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
                }
            }
            try {
                Object[] objArr22 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr22);
                Class<?> cls10 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr23);
                try {
                    Object[] objArr24 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls11 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.blue(0), Color.rgb(0, 0, 0) + 16777220, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        byte b2 = (byte) ($$a[78] - 1);
                        byte b3 = b2;
                        Object[] objArr25 = new Object[1];
                        c(b2, b3, b3, objArr25);
                        obj3 = cls11.getMethod((String) objArr25[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr26 = (Object[]) ((Method) obj3).invoke(null, objArr24);
                    int i6 = ((int[]) objArr26[1])[0];
                    if (((int[]) objArr26[0])[0] != i6) {
                        long j = ((r3 ^ i6) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr27 = {678464372, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr27);
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
                    super.onCreate(bundle);
                } catch (Throwable th11) {
                    Throwable cause11 = th11.getCause();
                    if (cause11 == null) {
                        throw th11;
                    }
                    throw cause11;
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((ViewConfiguration.getWindowTouchSlop() >> 8) - 1431569729, super.getResources().getString(R.string.type_name_bank_or_phone_number).substring(7, 8).length() - 61, (byte) (super.getResources().getString(R.string.share_feed_bottomsheet_title).substring(11, 12).codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), (short) (((byte) KeyEvent.getModifierMetaStateMask()) - 2), super.getResources().getString(R.string.nps_survey_title_suggestion).substring(0, 1).codePointAt(0) - 1136537979, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int codePointAt = super.getResources().getString(R.string.nearby_search_hint).substring(0, 1).codePointAt(0) - 1431569803;
            try {
                Object[] objArr2 = new Object[1];
                b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr3);
                int i = ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 93;
                try {
                    Object[] objArr4 = new Object[1];
                    b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                    byte b = (byte) (((ApplicationInfo) cls3.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33);
                    short codePointAt2 = (short) (getPackageName().codePointAt(2) - 4);
                    try {
                        Object[] objArr5 = new Object[1];
                        b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        a(codePointAt, i, b, codePointAt2, ((ApplicationInfo) cls4.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 1136537903, objArr6);
                        baseContext = (Context) cls.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.keyCodeFromString(""), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.hint_form_first_name).substring(15, 16).codePointAt(0) - 1431569830, (-60) - View.combineMeasuredStates(0, 0), (byte) (getPackageName().length() - 7), (short) ((-3) - View.combineMeasuredStates(0, 0)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) - 1136537896, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr3);
                int i = ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 1431569760;
                int codePointAt = getPackageName().codePointAt(2) - 106;
                try {
                    Object[] objArr4 = new Object[1];
                    b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                    byte b = (byte) (((ApplicationInfo) cls3.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33);
                    short indexOf = (short) (42 - TextUtils.indexOf("", "", 0));
                    try {
                        Object[] objArr5 = new Object[1];
                        b(getAuthRequestContext[32], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[25], objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr6);
                        int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion - 1136537903;
                        Object[] objArr7 = new Object[1];
                        a(i, codePointAt, b, indexOf, i2, objArr7);
                        baseContext = (Context) cls.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr8 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr8);
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
        super.onResume();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tvEmptyStateTitle);
        if (appCompatTextView != null) {
            appCompatTextView.setText(getString(R.string.qr_expired_error_title));
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a144d_multimapbuilder_hashsetsupplier);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(getString(R.string.qr_expired_error_desc));
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.PrepareContext_res_0x7f0a011e);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setActiveButton(getString(R.string.qr_expired_error_action), null);
            danaButtonPrimaryView.setOnClickListener(new ThrottledOnClickListener(0L, new Function1<View, Unit>() { // from class: id.dana.scanner.QrExpiredActivity$init$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    QrExpiredActivity.this.backToHomepage(null);
                }
            }, 1, null));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0652_getinwholemilliseconds_impl);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setMenuLeftButton(R.drawable.arrow_left_white);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/scanner/QrExpiredActivity$Companion;", "", "Landroid/app/Activity;", "p0", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/app/Activity;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new Intent(p0, QrExpiredActivity.class);
        }
    }

    private static void a(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (scheduleImpl ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = lookAheadTest;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (lookAheadTest[i3 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (scheduleImpl ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (NetworkUserEntityData$$ExternalSyntheticLambda1[i3 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (scheduleImpl ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (getErrorConfigVersion ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = lookAheadTest;
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
                    byte[] bArr5 = lookAheadTest;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = NetworkUserEntityData$$ExternalSyntheticLambda1;
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
