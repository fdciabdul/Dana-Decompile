package id.dana.cashier;

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
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.base.BaseActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.WebProgressView;
import id.dana.utils.TextUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004"}, d2 = {"Lid/dana/cashier/CashierPaylaterTnCActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "onBackPressed", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPaylaterTnCActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static char[] scheduleImpl;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$a = {8, 17, -121, -18, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 14;
    public static final byte[] PlaceComponentResult = {4, -87, 42, 65, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 232;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        scheduleImpl = new char[]{62255, 38408, 14714, 56388, 26497, 2799, 44506, 14200, 55919, 32086, Typography.registered, 43992, 20207, 53285, 31498, 7807, 41400, 17551, 61418, 29391, 5178, 49006, 16972, 58803, 35055, 5058, 62253, 38419, 14700, 56388, 26507, 2792, 44490, 14103, 55934, 32086, 178, 43935, 20173, 53287, 31498, 7807, 41377, 17544, 4022, 27281, 50659, 8413, 39704, 63094, 20803, 52193, 9976, 33228, 64617, 22335, 45637, 11440, 34692, 58090, 23844, 47116, 25780, 392, 44764, 19400, 61469, 27276, 4080, 41181, 17915, 65067, 37655, 13426, 44699, 17356, 58550, 39240, 12901, 55102, 18817, 58042, 34773, 14346, 56610, 30301, 60194, 36351, 9872, 56232, 31765, 4383, 35424, 11411, 49639, 31465, 8023, 45162, 21766, 53122, 24741, 1497, 48890, 21373, 62538, 26995, 915, 42188, 22965, 61983, 38709, 2105, 41600, 18365, 63622, 62255, 38483, 14632, 56402, 26504, 2751, 44430, 14190, 55914, 32069, 231, 43971, 20170, 53367, 31567, 7714, 41468, 17620, 61432, 29319, 5130, 48951, 16904, 58853, 35000, 5060, 46439, 22547, 58134, 34466, 10700, 52388, 22061, 63746, 39978, 9998, 51853, 28133, 61582, 39525, 15675, 49174, 27579, 3783, 37325, 15217, 56911, 24865, 1277, 45013, 12969, 54671, 32599, 561, 42254, 18663, 54206, 30359, 6205, 41748, 17951, 59902, 35994, 6053, 62332, 38487, 14715, 56404, 26583, 2737, 44428, 14178, 55862, 32030, 230, 43975, 20127, 53365, 31566, 7713, 41391, 17539, 61354, 29394, 5212, 48996, 16991, 58853, 35001, 5056, 46439, 22606, 58184, 34464, 10697, 52469, 22137, 63746, 39980, 9998, 51852, 28081, 61576, 39534, 15670, 49216, 27631, 3778, 37270, 15222, 56863, 24948, 1192, 45023, 13053, 54739, 32604, 567, 42328, 18659, 54201, 30355, 6247, 41792, 17992, 59891, 36043, 6063, 62246, 38418, 14698, 56390, 26525, 2748, 44433, 14201, 55914, 32071, Typography.degree, 43927, 20096, 53298, 31510, 7780, 41387, 17543, 61418, 29397, 5135, 49013, 16970, 58872, 35049, 5075, 46399, 22532, 58186, 34485, 10639, 52451, 22063, 63764, 40059, 10008, 51853, 28137, 61651, 39545, 15727, 49238, 27575, 3801, 37319, 15144, 56857, 24947, 1213, 44946, 12977, 54720, 32604, 553, 42331, 18592, 54251, 30408, 6186, 41733, 62327, 38472, 14634, 56344, 26588, 2743};
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 1687850821490153062L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 97
            int r9 = 23 - r9
            int r8 = r8 + 4
            byte[] r0 = id.dana.cashier.CashierPaylaterTnCActivity.PlaceComponentResult
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r9) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r8]
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
            int r8 = r8 + r9
            int r8 = r8 + (-4)
            int r7 = r7 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.CashierPaylaterTnCActivity.a(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.cashier.CashierPaylaterTnCActivity.$$a
            int r6 = 46 - r6
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.CashierPaylaterTnCActivity.c(byte, int, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createIntent(Context context, String str) {
        return Companion.PlaceComponentResult(context, str);
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
        b((ViewConfiguration.getEdgeSlop() >> 16) + 18, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 44, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 64666), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 5, 62 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (38807 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, View.resolveSizeAndState(0, 0, 0) + 35, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49, 67 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 39413), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 65, 115 - Color.green(0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(64 - (ViewConfiguration.getWindowTouchSlop() >> 8), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 179, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(60 - TextUtils.getOffsetBefore("", 0), 243 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(7 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 303 - KeyEvent.getDeadChar(0, 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, TextUtils.indexOf("", "") + 18, (char) View.MeasureSpec.getSize(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (-PlaceComponentResult[32]), (byte) 37, PlaceComponentResult[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[35]), PlaceComponentResult[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (KeyEvent.getMaxKeyCode() >> 16), Color.argb(0, 0, 0, 0) + 3, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        byte b = $$a[53];
                        byte b2 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b, b2, b2, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 800, 14 - TextUtils.lastIndexOf("", '0', 0), (char) Color.red(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 800, (ViewConfiguration.getWindowTouchSlop() >> 8) + 15, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getPressedStateDuration() >> 16), ExpandableListView.getPackedPositionGroup(0L) + 29, (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0', 0, 0), 16 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) Color.blue(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, 35 - View.resolveSize(0, 0), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-2110543482, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), KeyEvent.getDeadChar(0, 0) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = {this};
                Object[] objArr20 = new Object[1];
                a((byte) (-PlaceComponentResult[32]), (byte) 37, PlaceComponentResult[30], objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                a((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[35]), PlaceComponentResult[30], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.MeasureSpec.makeMeasureSpec(0, 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 46, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr23 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), (byte) $$b, objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, ImageFormat.getBitsPerPixel(0) + 36, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {-2110543482, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
                Object[] objArr26 = {this};
                Object[] objArr27 = new Object[1];
                a((byte) (-PlaceComponentResult[32]), (byte) 37, PlaceComponentResult[30], objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                a((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[35]), PlaceComponentResult[30], objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 118, 4 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 38968));
                        Object[] objArr30 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), (byte) $$b, objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), (-16777181) - Color.rgb(0, 0, 0), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {-2110543482, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
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
                Object[] objArr33 = {this};
                Object[] objArr34 = new Object[1];
                a((byte) (-PlaceComponentResult[32]), (byte) 37, PlaceComponentResult[30], objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                a((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[35]), PlaceComponentResult[30], objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 106, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 3, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr37 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], (byte) ($$a[78] - 1), objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {-2110543482, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), MotionEvent.axisFromString("") + 19, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
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
        return id.dana.R.layout.activity_cashier_paylater_tnc;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 45 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (super.getResources().getString(id.dana.R.string.promo_back_to_home_button).substring(7, 8).codePointAt(0) + 64633), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(Drawable.resolveOpacity(0, 0) + 5, Color.red(0) + 62, (char) (Color.argb(0, 0, 0, 0) + 38807), objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b(getPackageName().codePointAt(5) - 84, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1, (char) (super.getResources().getString(id.dana.R.string.bottom_help_family_account_dashboard_first_subtitle).substring(9, 10).codePointAt(0) - 110), objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                int trimmedLength = 18 - TextUtils.getTrimmedLength("");
                try {
                    byte b = PlaceComponentResult[25];
                    byte b2 = b;
                    Object[] objArr5 = new Object[1];
                    a(b, b2, b2, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], objArr6);
                    int i = ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion - 7;
                    try {
                        byte b3 = PlaceComponentResult[25];
                        byte b4 = b3;
                        Object[] objArr7 = new Object[1];
                        a(b3, b4, b4, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], new Object[1]);
                        Object[] objArr8 = new Object[1];
                        b(trimmedLength, i, (char) (((ApplicationInfo) cls4.getMethod((String) r6[0], null).invoke(this, null)).targetSdkVersion - 33), objArr8);
                        baseContext = (Context) cls2.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    int i2 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 47;
                    int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 67;
                    try {
                        byte b5 = PlaceComponentResult[25];
                        byte b6 = b5;
                        Object[] objArr9 = new Object[1];
                        a(b5, b6, b6, objArr9);
                        Class<?> cls5 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], objArr10);
                        Object[] objArr11 = new Object[1];
                        b(i2, touchSlop, (char) (((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 39380), objArr11);
                        String str = (String) objArr11[0];
                        int length = super.getResources().getString(id.dana.R.string.passkey_try_again).substring(6, 7).length() + 63;
                        try {
                            byte b7 = PlaceComponentResult[25];
                            byte b8 = b7;
                            Object[] objArr12 = new Object[1];
                            a(b7, b8, b8, objArr12);
                            Class<?> cls6 = Class.forName((String) objArr12[0]);
                            Object[] objArr13 = new Object[1];
                            a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], objArr13);
                            Object[] objArr14 = new Object[1];
                            b(length, ((ApplicationInfo) cls6.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 82, (char) (super.getResources().getString(id.dana.R.string.general_error_desc).substring(3, 4).codePointAt(0) - 97), objArr14);
                            String str2 = (String) objArr14[0];
                            Object[] objArr15 = new Object[1];
                            b(getPackageName().length() + 57, 179 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (Process.myTid() >> 22), objArr15);
                            String str3 = (String) objArr15[0];
                            Object[] objArr16 = new Object[1];
                            b(getPackageName().length() + 53, getPackageName().codePointAt(4) + 146, (char) (super.getResources().getString(id.dana.R.string.ep_confirmation_desc).substring(27, 28).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN), objArr16);
                            String str4 = (String) objArr16[0];
                            int trimmedLength2 = 6 - TextUtils.getTrimmedLength("");
                            try {
                                byte b9 = PlaceComponentResult[25];
                                byte b10 = b9;
                                Object[] objArr17 = new Object[1];
                                a(b9, b10, b10, objArr17);
                                Class<?> cls7 = Class.forName((String) objArr17[0]);
                                Object[] objArr18 = new Object[1];
                                a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], objArr18);
                                Object[] objArr19 = new Object[1];
                                b(trimmedLength2, ((ApplicationInfo) cls7.getMethod((String) objArr18[0], null).invoke(this, null)).targetSdkVersion + 270, (char) (getPackageName().codePointAt(5) - 110), objArr19);
                                try {
                                    Object[] objArr20 = {baseContext, str, str2, str3, str4, true, (String) objArr19[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, 18 - Gravity.getAbsoluteGravity(0, 0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr20);
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
            Object[] objArr21 = new Object[1];
            a((byte) (-PlaceComponentResult[32]), (byte) 37, PlaceComponentResult[30], objArr21);
            Class<?> cls8 = Class.forName((String) objArr21[0]);
            Object[] objArr22 = new Object[1];
            a((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[35]), PlaceComponentResult[30], objArr22);
            try {
                Object[] objArr23 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr22[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 4 - View.resolveSize(0, 0), (char) (Color.rgb(0, 0, 0) + 16777216));
                    Object[] objArr24 = new Object[1];
                    c((byte) ($$a[78] - 1), $$a[8], (byte) ($$a[78] - 1), objArr24);
                    obj3 = cls9.getMethod((String) objArr24[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr25 = (Object[]) ((Method) obj3).invoke(null, objArr23);
                int i3 = ((int[]) objArr25[1])[0];
                if (((int[]) objArr25[0])[0] != i3) {
                    long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr26 = {-1810500481, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr26);
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
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int jumpTapTimeout = 26 - (ViewConfiguration.getJumpTapTimeout() >> 16);
            int length = super.getResources().getString(id.dana.R.string.feeds_page_title).substring(0, 4).length() - 4;
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(jumpTapTimeout, length, (char) (((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    byte b3 = PlaceComponentResult[25];
                    byte b4 = b3;
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(((ApplicationInfo) cls3.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, getPackageName().length() + 19, (char) (getPackageName().length() - 7), objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 35 - TextUtils.indexOf("", "", 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 18 - View.MeasureSpec.getSize(0), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(id.dana.R.string.toast_account_deactivation_success).substring(2, 3).length() + 25;
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 33;
                try {
                    byte b3 = PlaceComponentResult[25];
                    byte b4 = b3;
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(length, i, (char) (((ApplicationInfo) cls2.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    int codePointAt = super.getResources().getString(id.dana.R.string.transfer_account_status_title_success).substring(0, 6).codePointAt(3) - 103;
                    try {
                        byte b5 = PlaceComponentResult[25];
                        byte b6 = b5;
                        Object[] objArr5 = new Object[1];
                        a(b5, b6, b6, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        a(PlaceComponentResult[5], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[41], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        b(codePointAt, ((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 7, (char) (super.getResources().getString(id.dana.R.string.feed_onboarding_third_page_description).substring(0, 1).codePointAt(0) - 69), objArr6);
                        baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", "", 0, 0), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) Color.alpha(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        WebView webView;
        WebView webView2;
        WebView webView3;
        WebView webView4;
        WebView webView5;
        WebView webView6;
        Intent intent = getIntent();
        WebSettings webSettings = null;
        String authRequestContext = TextUtil.getAuthRequestContext(intent != null ? intent.getStringExtra("tnc_url") : null);
        WebProgressView webProgressView = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        if (webProgressView != null) {
            webProgressView.loadDataWithBaseUrl(null, authRequestContext);
        }
        WebProgressView webProgressView2 = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        if (webProgressView2 != null && (webView6 = webProgressView2.getWebView()) != null) {
            webView6.setInitialScale(0);
        }
        WebProgressView webProgressView3 = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        WebSettings settings = (webProgressView3 == null || (webView5 = webProgressView3.getWebView()) == null) ? null : webView5.getSettings();
        if (settings != null) {
            settings.setDefaultFontSize(16);
        }
        WebProgressView webProgressView4 = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        WebSettings settings2 = (webProgressView4 == null || (webView4 = webProgressView4.getWebView()) == null) ? null : webView4.getSettings();
        if (settings2 != null) {
            settings2.setBuiltInZoomControls(false);
        }
        WebProgressView webProgressView5 = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        WebSettings settings3 = (webProgressView5 == null || (webView3 = webProgressView5.getWebView()) == null) ? null : webView3.getSettings();
        if (settings3 != null) {
            settings3.setLoadWithOverviewMode(false);
        }
        WebProgressView webProgressView6 = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        if (webProgressView6 != null && (webView2 = webProgressView6.getWebView()) != null) {
            webSettings = webView2.getSettings();
        }
        if (webSettings != null) {
            webSettings.setUseWideViewPort(false);
        }
        WebProgressView webProgressView7 = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        if (webProgressView7 != null && (webView = webProgressView7.getWebView()) != null) {
            webView.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, id.dana.R.color.f27122131100500));
        }
        WebProgressView webProgressView8 = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        if (webProgressView8 != null) {
            webProgressView8.setScrollbarFadingEnabled(false);
        }
        WebProgressView webProgressView9 = (WebProgressView) _$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2);
        if (webProgressView9 != null) {
            webProgressView9.setWebProgressViewListener(new WebProgressView.WebProgressViewListener() { // from class: id.dana.cashier.CashierPaylaterTnCActivity$init$1
                @Override // id.dana.richview.WebProgressView.WebProgressViewListener
                public final void PlaceComponentResult(WebView p0, String p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                }

                @Override // id.dana.richview.WebProgressView.WebProgressViewListener
                public final void PlaceComponentResult(WebView p0, WebResourceRequest p1, WebResourceError p2) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                    Intrinsics.checkNotNullParameter(p2, "");
                    CashierPaylaterTnCActivity.access$swapWebViewToErrorTextView(CashierPaylaterTnCActivity.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(id.dana.R.string.tnc));
        setMenuLeftButton(ContextCompat.PlaceComponentResult(this, (int) id.dana.R.drawable.arrow_left_white), new View.OnClickListener() { // from class: id.dana.cashier.CashierPaylaterTnCActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CashierPaylaterTnCActivity.$r8$lambda$RZXYv1XsmSWsbtm6APoZ3FiJ3_M(CashierPaylaterTnCActivity.this, view);
            }
        });
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        setResult(0, getIntent());
        finish();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/CashierPaylaterTnCActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent PlaceComponentResult(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, CashierPaylaterTnCActivity.class);
            intent.putExtra("tnc_url", p1);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$RZXYv1XsmSWsbtm6APoZ3FiJ3_M(CashierPaylaterTnCActivity cashierPaylaterTnCActivity, View view) {
        Intrinsics.checkNotNullParameter(cashierPaylaterTnCActivity, "");
        cashierPaylaterTnCActivity.setResult(0, cashierPaylaterTnCActivity.getIntent());
        cashierPaylaterTnCActivity.finish();
    }

    public static final /* synthetic */ void access$swapWebViewToErrorTextView(CashierPaylaterTnCActivity cashierPaylaterTnCActivity) {
        if (((WebProgressView) cashierPaylaterTnCActivity._$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2)) == null || ((AppCompatTextView) cashierPaylaterTnCActivity._$_findCachedViewById(id.dana.R.id.getSINGLETON_CLASSIFIERS_MASK)) == null) {
            return;
        }
        ((WebProgressView) cashierPaylaterTnCActivity._$_findCachedViewById(id.dana.R.id.res_0x7f0a1bea_cashieruserrelatedpresenter_consultagreementtnccardpayment_2)).setVisibility(8);
        ((AppCompatTextView) cashierPaylaterTnCActivity._$_findCachedViewById(id.dana.R.id.getSINGLETON_CLASSIFIERS_MASK)).setVisibility(0);
    }

    private static void b(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (scheduleImpl[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ NetworkUserEntityData$$ExternalSyntheticLambda0))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
