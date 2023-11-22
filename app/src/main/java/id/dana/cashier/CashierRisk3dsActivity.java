package id.dana.cashier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.cashier.threeDS.CashierRisk3dsFragment;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.databinding.ActivityCashierRisk3dsBinding;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/cashier/CashierRisk3dsActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityCashierRisk3dsBinding;", "Landroidx/fragment/app/FragmentResultListener;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityCashierRisk3dsBinding;", IAPSyncCommand.COMMAND_INIT, "", "requestKey", "Landroid/os/Bundle;", "result", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CashierRisk3dsActivity extends BaseViewBindingActivity<ActivityCashierRisk3dsBinding> implements FragmentResultListener {
    public static final String IS_CARD_BINDING = "isCardBinding";
    public static final String URL_PARAMS = "urlParams";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$a = {2, -87, 98, TarHeader.LF_FIFO, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 122;
    public static final byte[] PlaceComponentResult = {68, -4, -93, 76, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 67;
    private static long getAuthRequestContext = -8676309555021890996L;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.cashier.CashierRisk3dsActivity.PlaceComponentResult
            int r7 = r7 + 4
            int r9 = r9 + 16
            int r8 = 106 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2f
        L14:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2f:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-4)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.CashierRisk3dsActivity.b(byte, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = 46 - r7
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r0 = id.dana.cashier.CashierRisk3dsActivity.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
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
        L38:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.CashierRisk3dsActivity.c(short, short, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createIntent(Context context, Bundle bundle) {
        return Companion.getAuthRequestContext(context, bundle);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(Process.myPid() >> 22, new char[]{40225, 8171, 40256, 50082, 45493, 59425, 11406, 22315, 17374, 51638, 3614, 29927, 8302, 43868, 28644, 5609, 1763, 36048, 18745, 13132, 59154, 28284}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((-1) - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{50428, 9920, 50321, 65342, 50259, 53533, 4131, 8918, 6664}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{48954, 347, 48909, 35412, 63003, 63132, 25898, 4303, 24986, 55051, 18357, 13151, 557, 46586, 9823, 21105, 9455, 37437, 157, 29873, 50507, 28814, 58346, 38742, 59278, 20812, 49711, 51601, 34878, 11884, 44228, 59443, 43768, 3243, 36621, 2722, 19331, 60745, 27054, 11598, 27724, 52182, 18484, 20439, 3757, 43129, 10888, 28321, 12136, 34492, 62746, 33122}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{18176, 36859, 18273, 10812, 39140, 30826, 50498, 32364, 39414, 23030, 59348, 23968, 64068, 15196, 34413, 15581, 56532, 7326, 41205, 6732, 15730, 65069, 17362, 63993, 8116, 57278, 25106, 42859, 28758, 41117, 3245, 34509, 21192, 33291, 12086, 25610, 46051, 25531, 51648, 17328, 38003, 17708, 59476, 8491, 63125, 9871, 35505, 'Y', 55123, 2072, 21877, 61391, 10739, 59820, 29699, 52593, 2665, 52024, 5780, 44265, 27856, 44110, 12663, 35402, 19777, 36311, 54240, 27019}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{54159, 20683, 54205, 45841, 52947, 42846, 23612, 10333, 3366, 34504, 32507, 2971, 28311, 58423, 8001, 27374, 18446, 50092, 14809, 19576, 43438, 8522, 55981, 44955, 35693, 221, 64360, 61788, 58584, 32681, 38272, 53415, 50713, 23865, 46622, 12908, 10040, 48267, 20715, 5511, 253, 39496, 29055, 30487, 25111, 63977, 5064, 22123, 17287, 55087, 52232, 47533, 48425, 13974, 60794, 39706, 40685, 5134, 36847, 64218, 63576, 29562, 43008, 56361, 55705, 21226, 19100, 16310}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(ViewConfiguration.getKeyRepeatDelay() >> 16, new char[]{9954, 59251, 9866, 11158, 460, 4259, 50346, 59216, 63489, 12669, 58977, 50335, 39846, 21462, 34704, 42401, 48508, 29779, 41222, 33570, 23751, 38646, 17002, 24707, 32339, 46964, 25594, 15966, 4581, 51202, 3423, 8178, 13174, 60052, 11999, 64869, 53763, 2853, 51259, 55950, 62865, 11688, 59811, 47135, 38691, 20039, 35607, 39279, 46779, 24777, 21641, 30389, 18513, 33123, 30129, 21526, 27520, 41896, 5995, 13702, 3431, 50329, 12490, 4979}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((-1) - Process.getGidForName(""), new char[]{19879, 51151, 19870, 28924, 35839, 12357, 40832, 27965, 37637, 4554}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, Color.argb(0, 0, 0, 0) + 18, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) 37, b, b, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 3 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[53]), (byte) (-$$a[12]), $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 800, Gravity.getAbsoluteGravity(0, 0) + 15, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 800, 15 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) TextUtils.indexOf("", "", 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.indexOf("", "", 0), 29 - KeyEvent.getDeadChar(0, 0), (char) (View.resolveSizeAndState(0, 0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - Color.argb(0, 0, 0, 0), (char) View.resolveSize(0, 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1784139700, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = PlaceComponentResult[25];
                Object[] objArr19 = new Object[1];
                b((byte) 37, b2, b2, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 46, (char) View.combineMeasuredStates(0, 0));
                        Object[] objArr22 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), Gravity.getAbsoluteGravity(0, 0) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1784139700, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = PlaceComponentResult[25];
                Object[] objArr25 = new Object[1];
                b((byte) 37, b3, b3, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 3 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 38967));
                        Object[] objArr28 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1784139700, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = PlaceComponentResult[25];
                Object[] objArr31 = new Object[1];
                b((byte) 37, b4, b4, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 107, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3, (char) Color.red(0));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1784139700, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        Object[] objArr = new Object[1];
        a(super.getResources().getString(id.dana.R.string.mybills_edit_contract_no_label).substring(1, 2).codePointAt(0) - 111, new char[]{40225, 8171, 40256, 50082, 45493, 59425, 11406, 22315, 17374, 51638, 3614, 29927, 8302, 43868, 28644, 5609, 1763, 36048, 18745, 13132, 59154, 28284}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1, new char[]{50428, 9920, 50321, 65342, 50259, 53533, 4131, 8918, 6664}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr3 = new Object[1];
                    b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], PlaceComponentResult[8], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{8345, 50746, 8440, 51964, 55461, 12784, 9680, 15931, 65126, 4199, 1856, 7671, 40408, 29326, 26340, 31879, 47976, 21773, 16496, 23120, 23215, 47031, 41728, 47600, 30749, 38438, 33430, 59260, 6040, 59738}, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a(super.getResources().getString(id.dana.R.string.res_0x7f1302fa_networkuserentitydata_externalsyntheticlambda5).substring(0, 1).codePointAt(0) - 83, new char[]{21214, 13230, 21181, 43190, 60756, 50303, 18316, 3018, 35883, 58868, 25882, 10345, 61326, 34586, 1202, 18737, 51469, 41115, 8762, 28577, 10481, 16932}, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr6 = new Object[1];
                        b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], PlaceComponentResult[8], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{48954, 347, 48909, 35412, 63003, 63132, 25898, 4303, 24986, 55051, 18357, 13151, 557, 46586, 9823, 21105, 9455, 37437, 157, 29873, 50507, 28814, 58346, 38742, 59278, 20812, 49711, 51601, 34878, 11884, 44228, 59443, 43768, 3243, 36621, 2722, 19331, 60745, 27054, 11598, 27724, 52182, 18484, 20439, 3757, 43129, 10888, 28321, 12136, 34492, 62746, 33122}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(ExpandableListView.getPackedPositionGroup(0L), new char[]{18176, 36859, 18273, 10812, 39140, 30826, 50498, 32364, 39414, 23030, 59348, 23968, 64068, 15196, 34413, 15581, 56532, 7326, 41205, 6732, 15730, 65069, 17362, 63993, 8116, 57278, 25106, 42859, 28758, 41117, 3245, 34509, 21192, 33291, 12086, 25610, 46051, 25531, 51648, 17328, 38003, 17708, 59476, 8491, 63125, 9871, 35505, 'Y', 55123, 2072, 21877, 61391, 10739, 59820, 29699, 52593, 2665, 52024, 5780, 44265, 27856, 44110, 12663, 35402, 19777, 36311, 54240, 27019}, objArr8);
                        String str2 = (String) objArr8[0];
                        try {
                            Object[] objArr9 = new Object[1];
                            b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], PlaceComponentResult[8], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            a(((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{54159, 20683, 54205, 45841, 52947, 42846, 23612, 10333, 3366, 34504, 32507, 2971, 28311, 58423, 8001, 27374, 18446, 50092, 14809, 19576, 43438, 8522, 55981, 44955, 35693, 221, 64360, 61788, 58584, 32681, 38272, 53415, 50713, 23865, 46622, 12908, 10040, 48267, 20715, 5511, 253, 39496, 29055, 30487, 25111, 63977, 5064, 22123, 17287, 55087, 52232, 47533, 48425, 13974, 60794, 39706, 40685, 5134, 36847, 64218, 63576, 29562, 43008, 56361, 55705, 21226, 19100, 16310}, objArr10);
                            String str3 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            a(super.getResources().getString(id.dana.R.string.bpjs_button_title).substring(1, 3).length() - 2, new char[]{9954, 59251, 9866, 11158, 460, 4259, 50346, 59216, 63489, 12669, 58977, 50335, 39846, 21462, 34704, 42401, 48508, 29779, 41222, 33570, 23751, 38646, 17002, 24707, 32339, 46964, 25594, 15966, 4581, 51202, 3423, 8178, 13174, 60052, 11999, 64869, 53763, 2853, 51259, 55950, 62865, 11688, 59811, 47135, 38691, 20039, 35607, 39279, 46779, 24777, 21641, 30389, 18513, 33123, 30129, 21526, 27520, 41896, 5995, 13702, 3431, 50329, 12490, 4979}, objArr11);
                            String str4 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(super.getResources().getString(id.dana.R.string.smartpay_intro_2_description).substring(11, 12).length() - 1, new char[]{19879, 51151, 19870, 28924, 35839, 12357, 40832, 27965, 37637, 4554}, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, 18 - View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr13);
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
            byte b = PlaceComponentResult[25];
            Object[] objArr14 = new Object[1];
            b((byte) 37, b, b, objArr14);
            Class<?> cls6 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[25], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 4, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                    Object[] objArr17 = new Object[1];
                    c((byte) ($$a[47] - 1), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr17);
                    obj3 = cls7.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr19 = {384786821, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, 18 - View.resolveSize(0, 0), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(id.dana.R.string.merchant_review_negative_subtitle).substring(1, 2).length() - 1, new char[]{8345, 50746, 8440, 51964, 55461, 12784, 9680, 15931, 65126, 4199, 1856, 7671, 40408, 29326, 26340, 31879, 47976, 21773, 16496, 23120, 23215, 47031, 41728, 47600, 30749, 38438, 33430, 59260, 6040, 59738}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(TextUtils.getTrimmedLength(""), new char[]{21214, 13230, 21181, 43190, 60756, 50303, 18316, 3018, 35883, 58868, 25882, 10345, 61326, 34586, 1202, 18737, 51469, 41115, 8762, 28577, 10481, 16932}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 911, View.combineMeasuredStates(0, 0) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(getPackageName().codePointAt(2) - 46, new char[]{8345, 50746, 8440, 51964, 55461, 12784, 9680, 15931, 65126, 4199, 1856, 7671, 40408, 29326, 26340, 31879, 47976, 21773, 16496, 23120, 23215, 47031, 41728, 47600, 30749, 38438, 33430, 59260, 6040, 59738}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(Color.green(0), new char[]{21214, 13230, 21181, 43190, 60756, 50303, 18316, 3018, 35883, 58868, 25882, 10345, 61326, 34586, 1202, 18737, 51469, 41115, 8762, 28577, 10481, 16932}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), 'S' - AndroidCharacter.getMirror('0'), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, 17 - TextUtils.lastIndexOf("", '0', 0), (char) TextUtils.getTrimmedLength(""))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    public final ActivityCashierRisk3dsBinding inflateViewBinding() {
        ActivityCashierRisk3dsBinding authRequestContext = ActivityCashierRisk3dsBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        Bundle bundleExtra = getIntent().getBundleExtra("extra_bundle");
        if (bundleExtra != null) {
            CashierRisk3dsFragment.Companion companion = CashierRisk3dsFragment.INSTANCE;
            CashierRisk3dsFragment authRequestContext = CashierRisk3dsFragment.Companion.getAuthRequestContext(bundleExtra);
            getSupportFragmentManager().setFragmentResultListener("3ds_request_key", this, this);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = id.dana.R.anim.MyBillsEntityDataFactory_res_0x7f010057;
            beginTransaction.GetContactSyncConfig = id.dana.R.anim.f4712130772012;
            beginTransaction.newProxyInstance = id.dana.R.anim.f4702130772011;
            beginTransaction.PrepareContext = id.dana.R.anim.lookAheadTest;
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().MyBillsEntityDataFactory.getId(), authRequestContext, null, 1);
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        toolbar2.setNavigationIcon(ContextCompat.PlaceComponentResult(toolbar2.getContext(), (int) id.dana.R.drawable.arrow_left_white));
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.CashierRisk3dsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CashierRisk3dsActivity.m484$r8$lambda$0JuU8aVSp4Dizf7szltRIb_93M(CashierRisk3dsActivity.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.setText(getString(id.dana.R.string.card_verification));
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String requestKey, Bundle result) {
        Intrinsics.checkNotNullParameter(requestKey, "");
        Intrinsics.checkNotNullParameter(result, "");
        if (Intrinsics.areEqual(requestKey, "3ds_request_key")) {
            int i = result.getInt("3ds_result_key");
            if (i != -1) {
                if (i == 0) {
                    setResult(0, getIntent());
                    finish();
                    return;
                }
                return;
            }
            String string = result.getString(URL_PARAMS);
            Intent intent = new Intent();
            intent.putExtra(URL_PARAMS, string);
            setResult(-1, intent);
            finish();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/cashier/CashierRisk3dsActivity$Companion;", "", "Landroid/content/Context;", "p0", "Landroid/os/Bundle;", "p1", "Landroid/content/Intent;", "getAuthRequestContext", "(Landroid/content/Context;Landroid/os/Bundle;)Landroid/content/Intent;", "", "IS_CARD_BINDING", "Ljava/lang/String;", "URL_PARAMS", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent getAuthRequestContext(Context p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, CashierRisk3dsActivity.class);
            intent.putExtra("extra_bundle", p1);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$0J-uU8aVSp4Dizf7szltRIb_93M */
    public static /* synthetic */ void m484$r8$lambda$0JuU8aVSp4Dizf7szltRIb_93M(CashierRisk3dsActivity cashierRisk3dsActivity, View view) {
        Intrinsics.checkNotNullParameter(cashierRisk3dsActivity, "");
        cashierRisk3dsActivity.setResult(0, cashierRisk3dsActivity.getIntent());
        cashierRisk3dsActivity.finish();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getAuthRequestContext ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
    }
}
