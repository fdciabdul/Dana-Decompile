package id.dana.danapoly.ui.board;

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
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.danapoly.databinding.ActivityDanapolyNoeventBinding;
import id.dana.danapoly.ui.board.DanapolyBoardTabActivity;
import id.dana.network.util.DanaH5Helper;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/ui/board/DanapolyNoEventActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/danapoly/databinding/ActivityDanapolyNoeventBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ActivityDanapolyNoeventBinding;", IAPSyncCommand.COMMAND_INIT, "", "PlaceComponentResult", "Ljava/lang/String;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyNoEventActivity extends BaseViewBindingActivity<ActivityDanapolyNoeventBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String DANAPOLY_TNC_PAGE_URL = "https://m.dana.id/n/dana-promotion/tnc/general?spaceCode=tnc_dana_poly";
    private static char lookAheadTest;
    private static char[] scheduleImpl;
    private String PlaceComponentResult;
    public static final byte[] $$a = {125, -100, 71, Ascii.FS, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 186;
    public static final byte[] getAuthRequestContext = {77, -56, -115, -110, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 48;

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0024 -> B:47:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 16
            byte[] r0 = id.dana.danapoly.ui.board.DanapolyNoEventActivity.getAuthRequestContext
            int r8 = r8 + 97
            int r9 = 56 - r9
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L32:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-4)
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.board.DanapolyNoEventActivity.b(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0025 -> B:47:0x0029). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r5, short r6, byte r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 21
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r5 = 47 - r5
            byte[] r0 = id.dana.danapoly.ui.board.DanapolyNoEventActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r7
            r3 = 0
            r7 = r5
            goto L29
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r5]
        L29:
            int r5 = r5 + 1
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.board.DanapolyNoEventActivity.c(byte, short, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        lookAheadTest = (char) 42066;
        scheduleImpl = new char[]{37370, 37349, 37311, 37305, 37281, 37289, 37292, 37274, 37344, 37357, 37308, 37294, 37351, 37345, 37286, 37291, 37372, 37374, 37293, 37373, 37280, 37350, 37347, 37302, 37287, 37310, 37368, 37359, 37367, 37348, 37375, 37353, 37283, 37369, 37371, 37346, 37306, 37275, 37290, 37262, 37358, 37282, 37365, 37279, 37356, 37307, 37309, 37366, 37288};
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((byte) (46 - (ViewConfiguration.getScrollBarSize() >> 8)), new char[]{18, 11, 18, '+', 14, 15, 20, '\b', 17, '\r', '\b', '0', '0', 18, 3, ')', 13847, 13847}, ExpandableListView.getPackedPositionType(0L) + 18, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((byte) (47 - TextUtils.getOffsetBefore("", 0)), new char[]{'%', 27, 14, 21, 13869}, View.combineMeasuredStates(0, 0) + 5, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((byte) (((byte) KeyEvent.getModifierMetaStateMask()) + 22), new char[]{27, 5, Typography.quote, 29, 29, 16, '*', '!', 24, '(', 0, 6, '(', 17, 19, 31, 13760, 13760, InputCardNumberView.DIVIDER, '\f', 20, 1, 5, Typography.quote, 16, 17, 29, 14, 20, 16, '\n', '\'', 5, '(', JSONLexer.EOI, 5, '\f', 5, 29, 31, '!', '\f', 28, Typography.quote, 19, 17, 31, '('}, 48 - Color.alpha(0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) (32 - ImageFormat.getBitsPerPixel(0)), new char[]{7, 4, 29, 19, '\f', 5, 31, 29, 20, 1, '*', 5, 16, 18, 20, 31, 13769, 13769, 3, 19, 16, 18, 30, 19, InputCardNumberView.DIVIDER, 19, '-', '(', 29, 14, 13769, 13769, 1, 20, 28, 29, 13850, 13850, '%', 23, 2, 28, '-', 24, 5, 27, 19, 24, 13770, 13770, '!', 5, 5, '!', 31, 16, 31, 16, 4, 20, 14, 31, 16, 17}, ((Process.getThreadPriority(0) + 20) >> 6) + 64, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) (115 - ExpandableListView.getPackedPositionType(0L)), new char[]{20, 18, '\'', 17, 5, '!', 20, '!', 13845, 13845, 31, 14, 18, 17, '!', 23, '\n', '\'', 29, 20, 20, 19, '\t', 18, '!', '\f', '*', '!', 13935, 13935, 27, 5, 22, 19, 14, '!', 19, 25, Typography.quote, 29, '!', 0, 20, 31, 29, 31, 18, 25, '\f', 5, 3, ')', 20, 18, 6, 1, 21, 5, 5, '(', 6, 1, 5, '*'}, 64 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((byte) (71 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), new char[]{31, 3, ',', 3, 7, '-', 13820, 13820, 18, '\b', 11, 18, '\n', '0', 25, '-', '\'', '\n', '0', 3, '\f', 11, '0', '\n', '+', ')', 18, 4, 17, '\b', 22, '\'', 18, 4, ')', '\n', '\r', 27, Typography.dollar, '\r', '\t', 4, 15, 7, 18, 0, '-', ')', 17, 3, '\n', 1, 15, '\f', '-', '\n', '\'', 3, 3, 17}, 'l' - AndroidCharacter.getMirror('0'), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((byte) (56 - TextUtils.getOffsetAfter("", 0)), new char[]{'0', '\f', ')', 20, 20, 18}, 6 - ExpandableListView.getPackedPositionGroup(0L), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = getAuthRequestContext[25];
                byte b2 = (byte) (b | 8);
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 22), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getLongPressTimeout() >> 16) + 3, (char) (TextUtils.lastIndexOf("", '0', 0) + 1));
                        byte b3 = (byte) (-$$a[53]);
                        byte b4 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        c(b3, b4, b4, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 14 - MotionEvent.axisFromString(""), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, '?' - AndroidCharacter.getMirror('0'), (char) View.getDefaultSize(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 815, 29 - TextUtils.getTrimmedLength(""), (char) (ImageFormat.getBitsPerPixel(0) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getCapsMode("", 0, 0), 15 - (ViewConfiguration.getTouchSlop() >> 8), (char) (ViewConfiguration.getTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), 35 - Color.alpha(0), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1166165698, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = getAuthRequestContext[25];
                byte b6 = (byte) (b5 | 8);
                Object[] objArr20 = new Object[1];
                b(b5, b6, (byte) (b6 | 22), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.red(0), 46 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[9]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1166165698, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = getAuthRequestContext[25];
                byte b8 = (byte) (b7 | 8);
                Object[] objArr26 = new Object[1];
                b(b7, b8, (byte) (b8 | 22), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 118, Color.argb(0, 0, 0, 0) + 3, (char) (38968 - Color.blue(0)));
                        Object[] objArr28 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[9]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, (-16777181) - Color.rgb(0, 0, 0), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1166165698, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 18 - Color.red(0), (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = getAuthRequestContext[25];
                byte b10 = (byte) (b9 | 8);
                Object[] objArr32 = new Object[1];
                b(b9, b10, (byte) (b10 | 22), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 107, 2 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1166165698, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a((byte) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 45), new char[]{18, 11, 18, '+', 14, 15, 20, '\b', 17, '\r', '\b', '0', '0', 18, 3, ')', 13847, 13847}, getPackageName().length() + 11, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a((byte) (super.getResources().getString(R.string.pocket_voucher_amount_transaction).substring(0, 11).codePointAt(4) + 15), new char[]{'%', 27, 14, 21, 13869}, 5 - KeyEvent.getDeadChar(0, 0), objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a((byte) (super.getResources().getString(R.string.disable_auto_routing_negative).substring(1, 2).length() + 21), new char[]{18, 11, 18, '+', 14, 15, 20, '\b', '\t', 4, 6, '\t', ')', 4, '*', 17, 0, 17, ',', 24, Typography.amp, 23, '-', '\'', '\b', 18}, 26 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a((byte) (super.getResources().getString(R.string.mixpay_payresult_title).substring(0, 12).codePointAt(10) + 0), new char[]{1, ')', 13916, 13916, '\'', 3, '.', Typography.amp, 13918, 13918, 28, 18, 4, '\r', '*', 17, 18, 6}, 17 - TextUtils.lastIndexOf("", '0', 0, 0), objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a((byte) (20 - TextUtils.lastIndexOf("", '0')), new char[]{27, 5, Typography.quote, 29, 29, 16, '*', '!', 24, '(', 0, 6, '(', 17, 19, 31, 13760, 13760, InputCardNumberView.DIVIDER, '\f', 20, 1, 5, Typography.quote, 16, 17, 29, 14, 20, 16, '\n', '\'', 5, '(', JSONLexer.EOI, 5, '\f', 5, 29, 31, '!', '\f', 28, Typography.quote, 19, 17, 31, '('}, TextUtils.getOffsetBefore("", 0) + 48, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a((byte) (super.getResources().getString(R.string.family_account_general_failed_to_load_title).substring(0, 5).codePointAt(1) - 71), new char[]{7, 4, 29, 19, '\f', 5, 31, 29, 20, 1, '*', 5, 16, 18, 20, 31, 13769, 13769, 3, 19, 16, 18, 30, 19, InputCardNumberView.DIVIDER, 19, '-', '(', 29, 14, 13769, 13769, 1, 20, 28, 29, 13850, 13850, '%', 23, 2, 28, '-', 24, 5, 27, 19, 24, 13770, 13770, '!', 5, 5, '!', 31, 16, 31, 16, 4, 20, 14, 31, 16, 17}, super.getResources().getString(R.string.title_promo_merchant).substring(0, 5).codePointAt(2) - 47, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) (getPackageName().length() + 108), new char[]{20, 18, '\'', 17, 5, '!', 20, '!', 13845, 13845, 31, 14, 18, 17, '!', 23, '\n', '\'', 29, 20, 20, 19, '\t', 18, '!', '\f', '*', '!', 13935, 13935, 27, 5, 22, 19, 14, '!', 19, 25, Typography.quote, 29, '!', 0, 20, 31, 29, 31, 18, 25, '\f', 5, 3, ')', 20, 18, 6, 1, 21, 5, 5, '(', 6, 1, 5, '*'}, getPackageName().length() + 57, objArr8);
                    String str3 = (String) objArr8[0];
                    byte maxKeyCode = (byte) (71 - (KeyEvent.getMaxKeyCode() >> 16));
                    char[] cArr = {31, 3, ',', 3, 7, '-', 13820, 13820, 18, '\b', 11, 18, '\n', '0', 25, '-', '\'', '\n', '0', 3, '\f', 11, '0', '\n', '+', ')', 18, 4, 17, '\b', 22, '\'', 18, 4, ')', '\n', '\r', 27, Typography.dollar, '\r', '\t', 4, 15, 7, 18, 0, '-', ')', 17, 3, '\n', 1, 15, '\f', '-', '\n', '\'', 3, 3, 17};
                    try {
                        byte b = getAuthRequestContext[30];
                        byte b2 = getAuthRequestContext[25];
                        Object[] objArr9 = new Object[1];
                        b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr9);
                        Class<?> cls3 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        b(getAuthRequestContext[8], getAuthRequestContext[5], getAuthRequestContext[25], objArr10);
                        Object[] objArr11 = new Object[1];
                        a(maxKeyCode, cArr, ((ApplicationInfo) cls3.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 27, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a((byte) (ExpandableListView.getPackedPositionType(0L) + 56), new char[]{'0', '\f', ')', 20, 20, 18}, (KeyEvent.getMaxKeyCode() >> 16) + 6, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
        }
        try {
            Object[] objArr14 = new Object[1];
            b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            byte b3 = getAuthRequestContext[25];
            byte b4 = (byte) (b3 | 8);
            Object[] objArr15 = new Object[1];
            b(b3, b4, (byte) (b4 | 22), objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 494, 4 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)));
                    Object[] objArr17 = new Object[1];
                    c((byte) ($$a[47] - 1), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.getDeadChar(0, 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {-395712837, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), 17 - ImageFormat.getBitsPerPixel(0), (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                super.onCreate(bundle);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (getPackageName().codePointAt(1) - 78), new char[]{18, 11, 18, '+', 14, 15, 20, '\b', '\t', 4, 6, '\t', ')', 4, '*', 17, 0, 17, ',', 24, Typography.amp, 23, '-', '\'', '\b', 18}, super.getResources().getString(R.string.device_limit_error_title).substring(5, 6).length() + 25, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (super.getResources().getString(R.string.merchant_label_discount).substring(0, 13).length() + 103), new char[]{1, ')', 13916, 13916, '\'', 3, '.', Typography.amp, 13918, 13918, 28, 18, 4, '\r', '*', 17, 18, 6}, getPackageName().length() + 11, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (getPackageName().length() + 15), new char[]{18, 11, 18, '+', 14, 15, 20, '\b', '\t', 4, 6, '\t', ')', 4, '*', 17, 0, 17, ',', 24, Typography.amp, 23, '-', '\'', '\b', 18}, 26 - Color.alpha(0), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (117 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), new char[]{1, ')', 13916, 13916, '\'', 3, '.', Typography.amp, 13918, 13918, 28, 18, 4, '\r', '*', 17, 18, 6}, getPackageName().length() + 11, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), KeyEvent.keyCodeFromString("") + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityDanapolyNoeventBinding inflateViewBinding() {
        ActivityDanapolyNoeventBinding MyBillsEntityDataFactory = ActivityDanapolyNoeventBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().getAuthRequestContext.DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(toolbar2.getContext(), id.dana.danapoly.R.drawable.KClassImpl$Data$declaredNonStaticMembers$2);
        toolbar2.setContentDescription(getString(id.dana.danapoly.R.string.KClassImpl$Data$declaredNonStaticMembers$2));
        toolbar2.setNavigationIcon(PlaceComponentResult);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyNoEventActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyNoEventActivity.$r8$lambda$snTp_ylQSReYR4JLPSKFVMQXsGk(DanapolyNoEventActivity.this, view);
            }
        });
        getBinding().getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(id.dana.danapoly.R.string.FragmentBottomSheetPaymentSettingBinding_res_0x7f1305a0));
        final AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, id.dana.danapoly.R.drawable.ic_info);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyNoEventActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyNoEventActivity.$r8$lambda$1cZI5MvgqbZZ9G0q7y9iZ8ZJ1cE(AppCompatImageView.this, view);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/danapoly/ui/board/DanapolyNoEventActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;)V", "DANAPOLY_TNC_PAGE_URL", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, DanapolyNoEventActivity.class);
            intent.putExtra("bundle_last_active_event_id", p1);
            p0.startActivity(intent);
        }
    }

    public static /* synthetic */ void $r8$lambda$1cZI5MvgqbZZ9G0q7y9iZ8ZJ1cE(AppCompatImageView appCompatImageView, View view) {
        Intrinsics.checkNotNullParameter(appCompatImageView, "");
        DanaH5Helper danaH5Helper = DanaH5Helper.INSTANCE;
        Context context = appCompatImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        danaH5Helper.openUrl(context, DANAPOLY_TNC_PAGE_URL);
    }

    /* renamed from: $r8$lambda$Rq5he-t0BHZylnUtFstA22ohdSk */
    public static /* synthetic */ void m729$r8$lambda$Rq5het0BHZylnUtFstA22ohdSk(DanapolyNoEventActivity danapolyNoEventActivity, View view) {
        Intrinsics.checkNotNullParameter(danapolyNoEventActivity, "");
        DanapolyBoardTabActivity.Companion companion = DanapolyBoardTabActivity.INSTANCE;
        DanapolyBoardTabActivity.Companion.MyBillsEntityDataFactory(danapolyNoEventActivity, danapolyNoEventActivity.PlaceComponentResult);
    }

    public static /* synthetic */ void $r8$lambda$snTp_ylQSReYR4JLPSKFVMQXsGk(DanapolyNoEventActivity danapolyNoEventActivity, View view) {
        Intrinsics.checkNotNullParameter(danapolyNoEventActivity, "");
        danapolyNoEventActivity.onBackPressed();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyNoEventActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyNoEventActivity.m729$r8$lambda$Rq5het0BHZylnUtFstA22ohdSk(DanapolyNoEventActivity.this, view);
            }
        });
        Bundle extras = getIntent().getExtras();
        Unit unit = null;
        String string = extras != null ? extras.getString("bundle_last_active_event_id") : null;
        this.PlaceComponentResult = string;
        String str = string;
        if ((!(str == null || str.length() == 0)) == false) {
            string = null;
        }
        if (string != null) {
            AppCompatButton appCompatButton = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatButton, "");
            appCompatButton.setVisibility(0);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            AppCompatButton appCompatButton2 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatButton2, "");
            appCompatButton2.setVisibility(8);
        }
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = scheduleImpl;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ lookAheadTest);
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
