package id.dana.kybcpm.view;

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
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.view.C0207ViewKt;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.core.ui.richview.NumpadView;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ActivityKybCpmInputAmountBinding;
import id.dana.databinding.LayoutAmountViewBinding;
import id.dana.databinding.ViewBottomsheetCustomKeyboardX2xBinding;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.scanner.ScannerActivity;
import id.dana.sendmoney.Amount;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocaleUtil;
import id.dana.utils.NumberFormatterUtil;
import id.dana.utils.ViewUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/kybcpm/view/KybCpmInputAmountActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityKybCpmInputAmountBinding;", "", "configToolbar", "()V", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "MyBillsEntityDataFactory", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityKybCpmInputAmountBinding;", "onBackPressed", "getAuthRequestContext", "", "p1", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)V", "lookAheadTest", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybCpmInputAmountActivity extends ViewBindingActivity<ActivityKybCpmInputAmountBinding> {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private BottomSheetBehavior<View> getAuthRequestContext;
    public static final byte[] $$a = {44, 104, -53, -66, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 4;
    public static final byte[] getAuthRequestContext = {Ascii.US, -80, -88, -103, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 141;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda1 = -6851435024221249690L;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2 = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory = true;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.kybcpm.view.KybCpmInputAmountActivity.getAuthRequestContext
            int r8 = 23 - r8
            int r7 = 56 - r7
            int r6 = 106 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2f
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L2f:
            int r6 = -r6
            int r8 = r8 + r6
            int r7 = r7 + 1
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kybcpm.view.KybCpmInputAmountActivity.b(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 + 4
            byte[] r0 = id.dana.kybcpm.view.KybCpmInputAmountActivity.$$a
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r6 = r7
            r4 = r8
            r3 = 0
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r8 = r8 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kybcpm.view.KybCpmInputAmountActivity.c(short, int, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createIntentKybCpmInputAmountActivity(Context context) {
        return Companion.getAuthRequestContext(context);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(ViewConfiguration.getScrollDefaultDelay() >> 16, new char[]{36859, 36762, 32872, 65437, 37512, 56037, 40431, 43575, 50604, 52775, 46549, 7203, 7140, 13317, 25415, 20901, 20769, 25553, 55618, 35800, 42856, 43413}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{14283, 14246, 17058, 48526, 20565, 39111, 44274, 39729, 32151}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{48758, 48705, 25084, 9589, 29457, '_', 58311, 54357, 62590, 12211, 28466, 25117, 10801, 54666, 47536, 12219, 24763, 33301, 938, 62883, 38567, 18510, 19861, 33580, 52490, 63188, 38920, 18739, 834, 48380, 57867, 5977, 47564, 26979, 11418, 56464, 61327, 5993, 30385, 27284, 9704, 56750, 49523, 12373, 22641, 35785, 2855, 65067, 36476, 12756, 21997, 35760}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(KeyEvent.getMaxKeyCode() >> 16, new char[]{12842, 12875, 52908, 22784, 56343, 31786, 42639, 37185, 30836, 33000, 4942, 10069, 42558, 31370, 50591, 27296, 60646, 11536, 32735, 45289, 6904, 59211, 12720, 50740, 16726, 22912, 58408, 3198, 36684, 5035, 40575, 21008, 13722, 50789, 20668, 39311, 25481, 47165, 2754, 12253, 43441, 29426, 48398, 29982, 54319, 9369, 30467, 47972, 545, 40662, 10655, 52906, 18617, 20746, 58273, 5372, 63179, 2886, 38382, 23100, 15626, 64952, 18533, 57431, 27475, 47097, 554, 13902}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(TextUtils.getCapsMode("", 0, 0), new char[]{2784, 2770, 46246, 56066, 42521, 65147, 64255, 52535, 16609, 64232, 37149, 31529, 40616, 223, 18383, 14036, 54393, 22300, 64911, 60570, 8801, 40210, 46003, 39441, 31178, 9181, 26158, 20494, 46983, 27041, 7214, 3645, 3342, 48233, 53992, 50606, 23319, 49715, 34965, 29613, 37242, 2216, 16217, 10597, 60648, 24257, 62726, 59153, 15024, 58591, 43934, 37519, 28710, 11022, 24996, 18640, 52746, 29006, 6121, 1608, 1479, 34738, 51822, 48243, 21454, 52730, 32810, 27188}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(ViewConfiguration.getKeyRepeatDelay() >> 16, new char[]{17609, 17569, 25623, 62472, 30445, 53600, 45109, 34799, 3714, 10769, 48667, 12792, 53469, 53362, 26754, 31822, 39503, 34735, 53964, 42517, 27724, 19938, 40168, 53468, 14256, 62264, 18720, 6873, 63998, 47430, 13165, 17597, 17189, 27784, 64949, 36722, 5480, 4817, 42969, 14705, 57170, 55300, 4121, 25528, 41624, 36387, 55877, 44480, 29896, 13429, 33923, 55362, 15898, 64439, 20211, 521, 32803, 41380, 14577, 19649, 19388, 22301, 58680, 63228}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(Color.blue(0), new char[]{15218, 15179, 17610, 51006, 22122, 57878, 19930, 31326, 29048, 2717}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[9], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 55, View.resolveSizeAndState(0, 0, 0) + 3, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        byte b = $$a[78];
                        byte b2 = b;
                        Object[] objArr16 = new Object[1];
                        c(b, b2, (byte) (b2 - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getFadingEdgeLength() >> 16) + 15, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, ((byte) KeyEvent.getModifierMetaStateMask()) + 16, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 815, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 29, (char) (KeyEvent.getDeadChar(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Gravity.getAbsoluteGravity(0, 0), 16 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), TextUtils.indexOf("", "", 0) + 35, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1462835047, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[9], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - ExpandableListView.getPackedPositionType(0L), 46 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16));
                        byte b3 = $$a[9];
                        byte b4 = (byte) ($$b - 4);
                        Object[] objArr22 = new Object[1];
                        c(b3, b4, (byte) (b4 | Ascii.ETB), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1462835047, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), KeyEvent.normalizeMetaState(0) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(getAuthRequestContext[9], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 119, ExpandableListView.getPackedPositionGroup(0L) + 3, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 38968));
                        byte b5 = $$a[9];
                        byte b6 = (byte) ($$b - 4);
                        Object[] objArr28 = new Object[1];
                        c(b5, b6, (byte) (b6 | Ascii.ETB), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionType(0L), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1462835047, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 18 - View.MeasureSpec.getSize(0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(getAuthRequestContext[9], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.resolveSize(0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$b - 4), $$a[8], $$a[53], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, 35 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1462835047, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, 18 - KeyEvent.normalizeMetaState(0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            b((byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            b(getAuthRequestContext[48], getAuthRequestContext[25], getAuthRequestContext[41], new Object[1]);
            Object[] objArr3 = new Object[1];
            a(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{36859, 36762, 32872, 65437, 37512, 56037, 40431, 43575, 50604, 52775, 46549, 7203, 7140, 13317, 25415, 20901, 20769, 25553, 55618, 35800, 42856, 43413}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{14283, 14246, 17058, 48526, 20565, 39111, 44274, 39729, 32151}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a(super.getResources().getString(R.string.res_0x7f130e71_networkuserentitydata_externalsyntheticlambda5).substring(25, 26).length() - 1, new char[]{35081, 35176, 49143, 53064, 44311, 59952, 44774, 39230, 50014, 61880, 34048, 12074, 7448, 2969, 21452, 25298, 22496, 23618, 59776, 47325, 41375, 38416, 42936, 52757, 64069, 10457, 29302, 1089, 13368, 25261}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(TextUtils.getTrimmedLength(""), new char[]{9917, 9950, 60510, 29518, 65189, 22048, 45495, 34415, 27872, 41485, 14592, 12308, 45757, 22571, 61376, 32196, 63606, 4082, 21904, 42892, 3634, 50597}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.alpha(0) + 35, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{48758, 48705, 25084, 9589, 29457, '_', 58311, 54357, 62590, 12211, 28466, 25117, 10801, 54666, 47536, 12219, 24763, 33301, 938, 62883, 38567, 18510, 19861, 33580, 52490, 63188, 38920, 18739, 834, 48380, 57867, 5977, 47564, 26979, 11418, 56464, 61327, 5993, 30385, 27284, 9704, 56750, 49523, 12373, 22641, 35785, 2855, 65067, 36476, 12756, 21997, 35760}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.goal_title_hint_focused).substring(4, 5).codePointAt(0) - 32, new char[]{12842, 12875, 52908, 22784, 56343, 31786, 42639, 37185, 30836, 33000, 4942, 10069, 42558, 31370, 50591, 27296, 60646, 11536, 32735, 45289, 6904, 59211, 12720, 50740, 16726, 22912, 58408, 3198, 36684, 5035, 40575, 21008, 13722, 50789, 20668, 39311, 25481, 47165, 2754, 12253, 43441, 29426, 48398, 29982, 54319, 9369, 30467, 47972, 545, 40662, 10655, 52906, 18617, 20746, 58273, 5372, 63179, 2886, 38382, 23100, 15626, 64952, 18533, 57431, 27475, 47097, 554, 13902}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(ViewConfiguration.getTouchSlop() >> 8, new char[]{2784, 2770, 46246, 56066, 42521, 65147, 64255, 52535, 16609, 64232, 37149, 31529, 40616, 223, 18383, 14036, 54393, 22300, 64911, 60570, 8801, 40210, 46003, 39441, 31178, 9181, 26158, 20494, 46983, 27041, 7214, 3645, 3342, 48233, 53992, 50606, 23319, 49715, 34965, 29613, 37242, 2216, 16217, 10597, 60648, 24257, 62726, 59153, 15024, 58591, 43934, 37519, 28710, 11022, 24996, 18640, 52746, 29006, 6121, 1608, 1479, 34738, 51822, 48243, 21454, 52730, 32810, 27188}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(ViewConfiguration.getLongPressTimeout() >> 16, new char[]{17609, 17569, 25623, 62472, 30445, 53600, 45109, 34799, 3714, 10769, 48667, 12792, 53469, 53362, 26754, 31822, 39503, 34735, 53964, 42517, 27724, 19938, 40168, 53468, 14256, 62264, 18720, 6873, 63998, 47430, 13165, 17597, 17189, 27784, 64949, 36722, 5480, 4817, 42969, 14705, 57170, 55300, 4121, 25528, 41624, 36387, 55877, 44480, 29896, 13429, 33923, 55362, 15898, 64439, 20211, 521, 32803, 41380, 14577, 19649, 19388, 22301, 58680, 63228}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(Color.argb(0, 0, 0, 0), new char[]{15218, 15179, 17610, 51006, 22122, 57878, 19930, 31326, 29048, 2717}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), Process.getGidForName("") + 19, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            try {
                Object[] objArr13 = new Object[1];
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr13);
                Class<?> cls4 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[9], (byte) (getAuthRequestContext[0] - 1), getAuthRequestContext[30], objArr14);
                try {
                    Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 493, 5 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) View.MeasureSpec.getSize(0));
                        Object[] objArr16 = new Object[1];
                        c((byte) ($$b - 4), $$a[8], $$a[53], objArr16);
                        obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                    int i = ((int[]) objArr17[1])[0];
                    if (((int[]) objArr17[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr18 = {-380383962, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), Color.blue(0) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr18);
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
        } catch (Throwable th7) {
            Throwable cause7 = th7.getCause();
            if (cause7 == null) {
                throw th7;
            }
            throw cause7;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.receiver_name_as_on_id_card).substring(0, 3).length() - 3, new char[]{35081, 35176, 49143, 53064, 44311, 59952, 44774, 39230, 50014, 61880, 34048, 12074, 7448, 2969, 21452, 25298, 22496, 23618, 59776, 47325, 41375, 38416, 42936, 52757, 64069, 10457, 29302, 1089, 13368, 25261}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[48], getAuthRequestContext[25], getAuthRequestContext[41], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{9917, 9950, 60510, 29518, 65189, 22048, 45495, 34415, 27872, 41485, 14592, 12308, 45757, 22571, 61376, 32196, 63606, 4082, 21904, 42892, 3634, 50597}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - ExpandableListView.getPackedPositionType(0L), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(3) - 100, new char[]{35081, 35176, 49143, 53064, 44311, 59952, 44774, 39230, 50014, 61880, 34048, 12074, 7448, 2969, 21452, 25298, 22496, 23618, 59776, 47325, 41375, 38416, 42936, 52757, 64069, 10457, 29302, 1089, 13368, 25261}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.gn_title_sg).substring(0, 19).length() - 19, new char[]{9917, 9950, 60510, 29518, 65189, 22048, 45495, 34415, 27872, 41485, 14592, 12308, 45757, 22571, 61376, 32196, 63606, 4082, 21904, 42892, 3634, 50597}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) TextUtils.getOffsetBefore("", 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityKybCpmInputAmountBinding initViewBinding() {
        ActivityKybCpmInputAmountBinding PlaceComponentResult2 = ActivityKybCpmInputAmountBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.title_toolbar_kyb_cpm));
        setMenuLeftButton(R.drawable.arrow_left_white_new);
        setMenuLeftButtonOnClick(new View.OnClickListener() { // from class: id.dana.kybcpm.view.KybCpmInputAmountActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KybCpmInputAmountActivity.$r8$lambda$eacmPqyv75JrR47oudQluxqKWmE(KybCpmInputAmountActivity.this, view);
            }
        });
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this);
        getBinding().lookAheadTest.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.setText(getString(R.string.total_amount_kyb_cpm));
        final CurrencyEditText currencyEditText = getBinding().lookAheadTest.getAuthRequestContext.MyBillsEntityDataFactory;
        currencyEditText.requestFocus();
        currencyEditText.setFocusableInTouchMode(true);
        currencyEditText.disableSoftKeyboard();
        currencyEditText.setTextHint(currencyEditText.getContext().getString(R.string.amount_default));
        currencyEditText.setTextHintColor(R.color.f23962131099992);
        currencyEditText.removeUnderline();
        currencyEditText.setAllowEmpty(true);
        Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
        final CurrencyEditText currencyEditText2 = currencyEditText;
        if (ViewCompat.C(currencyEditText2)) {
            LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(currencyEditText2);
            if (PlaceComponentResult2 != null) {
                FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1(this, currencyEditText, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2));
            }
        } else {
            currencyEditText2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: id.dana.kybcpm.view.KybCpmInputAmountActivity$initCustomAmountEditText$lambda-10$lambda-9$$inlined$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    currencyEditText2.removeOnAttachStateChangeListener(this);
                    Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
                    LifecycleOwner PlaceComponentResult3 = C0207ViewKt.PlaceComponentResult(currencyEditText);
                    if (PlaceComponentResult3 != null) {
                        FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1(this, currencyEditText, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult3));
                    }
                }
            });
        }
        ActivityKybCpmInputAmountBinding binding = getBinding();
        binding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kybcpm.view.KybCpmInputAmountActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KybCpmInputAmountActivity.$r8$lambda$dy_IunR9_EHvxz3bFq5FoVaC8Xs(KybCpmInputAmountActivity.this, view);
            }
        });
        binding.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kybcpm.view.KybCpmInputAmountActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KybCpmInputAmountActivity.$r8$lambda$z1pVGc1olaeX7ZeARRHiBlVX0S4(KybCpmInputAmountActivity.this, view);
            }
        });
        LayoutAmountViewBinding layoutAmountViewBinding = binding.lookAheadTest.getAuthRequestContext;
        layoutAmountViewBinding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kybcpm.view.KybCpmInputAmountActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KybCpmInputAmountActivity.m2640$r8$lambda$9BamYH4IvoLlSCkRu1Ggflag2o(KybCpmInputAmountActivity.this, view);
            }
        });
        layoutAmountViewBinding.MyBillsEntityDataFactory.addTextChangedListener(new TextWatcher() { // from class: id.dana.kybcpm.view.KybCpmInputAmountActivity$getInputAmountTextWatcherListener$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                ActivityKybCpmInputAmountBinding binding2;
                String cleanAll = NumberUtils.getCleanAll(String.valueOf(p0));
                Intrinsics.checkNotNullExpressionValue(cleanAll, "");
                String replace$default = StringsKt.replace$default(cleanAll, "Rp", "", false, 4, (Object) null);
                binding2 = KybCpmInputAmountActivity.this.getBinding();
                binding2.PlaceComponentResult.PlaceComponentResult.setAmount(replace$default);
            }
        });
        binding.PlaceComponentResult.PlaceComponentResult.setListener(new NumpadView.NumpadClickListener() { // from class: id.dana.kybcpm.view.KybCpmInputAmountActivity$getNumpadClickListener$1
            @Override // id.dana.core.ui.richview.NumpadView.NumpadClickListener
            public final void MyBillsEntityDataFactory(String p0) {
                ActivityKybCpmInputAmountBinding binding2;
                Intrinsics.checkNotNullParameter(p0, "");
                binding2 = KybCpmInputAmountActivity.this.getBinding();
                KybCpmInputAmountActivity kybCpmInputAmountActivity = KybCpmInputAmountActivity.this;
                if (p0.length() == 0) {
                    binding2.lookAheadTest.getAuthRequestContext.MyBillsEntityDataFactory.clearAmount();
                    kybCpmInputAmountActivity.MyBillsEntityDataFactory(false);
                } else if (Integer.parseInt(p0) == Integer.parseInt("0")) {
                    binding2.lookAheadTest.getAuthRequestContext.MyBillsEntityDataFactory.setPrefixedAmount(Integer.parseInt(p0));
                    kybCpmInputAmountActivity.MyBillsEntityDataFactory(false);
                } else {
                    binding2.lookAheadTest.getAuthRequestContext.MyBillsEntityDataFactory.setPrefixedAmount(Integer.parseInt(p0));
                    KybCpmInputAmountActivity.MyBillsEntityDataFactory$default(kybCpmInputAmountActivity, false, 1, null);
                }
            }
        });
        ViewBottomsheetCustomKeyboardX2xBinding viewBottomsheetCustomKeyboardX2xBinding = getBinding().PlaceComponentResult;
        this.getAuthRequestContext = BottomSheetBehavior.from(viewBottomsheetCustomKeyboardX2xBinding.BuiltInFictitiousFunctionClassFactory);
        viewBottomsheetCustomKeyboardX2xBinding.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getString(R.string.btn_done));
        getAuthRequestContext(true);
        MyBillsEntityDataFactory(false);
    }

    private final void PlaceComponentResult(String p0, String p1) {
        LayoutAmountViewBinding layoutAmountViewBinding = getBinding().lookAheadTest.getAuthRequestContext;
        if (p0.length() > 0) {
            String BuiltInFictitiousFunctionClassFactory = NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.getAuthRequestContext(), new Amount(p0).getAuthRequestContext, "Rp");
            AppCompatTextView appCompatTextView = layoutAmountViewBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            ViewUtil.PlaceComponentResult(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView.getContext(), R.color.f26712131100373), appCompatTextView);
            getBinding().lookAheadTest.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_warning_16, 0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(p1, Arrays.copyOf(new Object[]{BuiltInFictitiousFunctionClassFactory}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            appCompatTextView.setText(format);
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            appCompatTextView.setVisibility(0);
            return;
        }
        AppCompatTextView appCompatTextView2 = layoutAmountViewBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        appCompatTextView2.setVisibility(4);
        TextView textView = layoutAmountViewBinding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(4);
    }

    private final void getAuthRequestContext(boolean p0) {
        BottomSheetBehavior<View> bottomSheetBehavior = this.getAuthRequestContext;
        if (bottomSheetBehavior != null) {
            boolean z = !p0;
            bottomSheetBehavior.setDraggable(z);
            bottomSheetBehavior.setHideable(z);
            bottomSheetBehavior.setState(p0 ? 3 : 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void MyBillsEntityDataFactory$default(KybCpmInputAmountActivity kybCpmInputAmountActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        kybCpmInputAmountActivity.MyBillsEntityDataFactory(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(boolean p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        danaButtonPrimaryView.setEnabled(p0);
        if (p0) {
            danaButtonPrimaryView.setActiveButton(getString(R.string.kyb_cpm_button_keyboard_done), null);
        } else {
            danaButtonPrimaryView.setDisabled(getString(R.string.kyb_cpm_button_keyboard_done));
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory$default(KybCpmInputAmountActivity kybCpmInputAmountActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        kybCpmInputAmountActivity.BuiltInFictitiousFunctionClassFactory(z);
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        danaButtonPrimaryView.setEnabled(p0);
        if (p0) {
            danaButtonPrimaryView.setActiveButton(getString(R.string.kyb_cpm_button_scan_qr), null);
        } else {
            danaButtonPrimaryView.setDisabled(getString(R.string.kyb_cpm_button_scan_qr));
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.getAuthRequestContext;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 3) {
            getAuthRequestContext(false);
        } else {
            finish();
        }
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kybcpm/view/KybCpmInputAmountActivity$Companion;", "", "Landroid/content/Context;", "p0", "Landroid/content/Intent;", "getAuthRequestContext", "(Landroid/content/Context;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent getAuthRequestContext(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new Intent(p0, KybCpmInputAmountActivity.class);
        }
    }

    /* renamed from: $r8$lambda$9BamYH4Iv-oLlSCkRu1Ggflag2o  reason: not valid java name */
    public static /* synthetic */ void m2640$r8$lambda$9BamYH4IvoLlSCkRu1Ggflag2o(KybCpmInputAmountActivity kybCpmInputAmountActivity, View view) {
        Intrinsics.checkNotNullParameter(kybCpmInputAmountActivity, "");
        kybCpmInputAmountActivity.getAuthRequestContext(true);
    }

    public static /* synthetic */ void $r8$lambda$dy_IunR9_EHvxz3bFq5FoVaC8Xs(KybCpmInputAmountActivity kybCpmInputAmountActivity, View view) {
        Intrinsics.checkNotNullParameter(kybCpmInputAmountActivity, "");
        kybCpmInputAmountActivity.startActivity(ScannerActivity.createIntentScannerActivityForKybCpm(kybCpmInputAmountActivity, kybCpmInputAmountActivity.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    public static /* synthetic */ void $r8$lambda$eacmPqyv75JrR47oudQluxqKWmE(KybCpmInputAmountActivity kybCpmInputAmountActivity, View view) {
        Intrinsics.checkNotNullParameter(kybCpmInputAmountActivity, "");
        kybCpmInputAmountActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$z1pVGc1olaeX7ZeARRHiBlVX0S4(KybCpmInputAmountActivity kybCpmInputAmountActivity, View view) {
        Intrinsics.checkNotNullParameter(kybCpmInputAmountActivity, "");
        kybCpmInputAmountActivity.getAuthRequestContext(false);
    }

    public static final /* synthetic */ void access$checkAmountValidation(KybCpmInputAmountActivity kybCpmInputAmountActivity) {
        if ((!StringsKt.isBlank(kybCpmInputAmountActivity.KClassImpl$Data$declaredNonStaticMembers$2)) == true) {
            if (Integer.parseInt(kybCpmInputAmountActivity.KClassImpl$Data$declaredNonStaticMembers$2) > 2000000) {
                kybCpmInputAmountActivity.BuiltInFictitiousFunctionClassFactory(false);
                String string = kybCpmInputAmountActivity.getResources().getString(R.string.max_amount_kyb_cpm_error_info);
                Intrinsics.checkNotNullExpressionValue(string, "");
                kybCpmInputAmountActivity.PlaceComponentResult("2000000", string);
            } else if (Integer.parseInt(kybCpmInputAmountActivity.KClassImpl$Data$declaredNonStaticMembers$2) <= 0) {
                kybCpmInputAmountActivity.BuiltInFictitiousFunctionClassFactory(false);
                String string2 = kybCpmInputAmountActivity.getResources().getString(R.string.min_amount_kyb_cpm_error_info);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                kybCpmInputAmountActivity.PlaceComponentResult("1", string2);
            } else {
                BuiltInFictitiousFunctionClassFactory$default(kybCpmInputAmountActivity, false, 1, null);
                kybCpmInputAmountActivity.PlaceComponentResult("", "");
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
