package id.dana.expresspurchase.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseWebViewActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.WebProgressView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseTncActivity;", "Lid/dana/base/BaseWebViewActivity;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ExpressPurchaseTncActivity extends BaseWebViewActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long getErrorConfigVersion;
    private static char initRecordTimeStamp;
    private static int lookAheadTest;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$g = {1, 78, 11, -6, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = TarHeader.USTAR_FILENAME_PREFIX;
    public static final byte[] scheduleImpl = {59, -54, -26, -72, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 239;

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    static void getAuthRequestContext() {
        initRecordTimeStamp = (char) 2819;
        getErrorConfigVersion = 4360990799332652212L;
        lookAheadTest = -956812108;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 97
            int r7 = r7 + 16
            int r8 = 55 - r8
            byte[] r0 = id.dana.expresspurchase.view.ExpressPurchaseTncActivity.scheduleImpl
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
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
            int r4 = r3 + 1
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2f:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.expresspurchase.view.ExpressPurchaseTncActivity.h(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(int r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.expresspurchase.view.ExpressPurchaseTncActivity.$$g
            int r9 = r9 * 2
            int r9 = r9 + 75
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = 46 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L33
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            int r7 = r7 + 1
            r1[r3] = r5
            if (r4 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.expresspurchase.view.ExpressPurchaseTncActivity.j(int, short, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void open(Context context, String str) {
        Companion.BuiltInFictitiousFunctionClassFactory(context, str);
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

    /* JADX WARN: Removed duplicated region for block: B:111:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0752  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0924  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0929  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0ae1 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0587 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x092d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0756 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0291  */
    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r33) {
        /*
            Method dump skipped, instructions count: 3192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.expresspurchase.view.ExpressPurchaseTncActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        g(new char[]{0, 0, 0, 0}, new char[]{36443, 1514, 4391, 3243, 42203, 31667, 5356, 41383, 24916, 20328, 46740, 62101, 47725, 4302, 16729, 21380, 29699, 30106}, (char) (super.getResources().getString(R.string.upgrade_express_pay_positive_btn).substring(3, 4).length() + 4279), getPackageName().length() - 7, new char[]{33500, 4270, 47135, 59408}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {56399, 48813, 21748, 62497, 57373};
        char codePointAt = (char) (super.getResources().getString(R.string.global_search_error_message_dialog).substring(29, 31).codePointAt(0) + 49238);
        try {
            Object[] objArr2 = new Object[1];
            h(scheduleImpl[25], scheduleImpl[30], (byte) (scheduleImpl[49] - 1), objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h(scheduleImpl[5], scheduleImpl[8], scheduleImpl[25], objArr3);
            Object[] objArr4 = new Object[1];
            g(cArr, cArr2, codePointAt, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 1721447256, new char[]{31228, 39731, 51558, 1984}, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    g(new char[]{0, 0, 0, 0}, new char[]{42285, 41277, 41312, 55733, 17035, 8826, 65453, 44047, 34841, 14792, 47849, 27382, 41520, 42129, 49725, 65355, 39792, 3624, 44876, 6587, 35049, 57769, 5775, 56394, 12513, 24665}, (char) (super.getResources().getString(R.string.ipg_agree).substring(0, 1).codePointAt(0) + 34580), 1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{64766, 48248, 27963, 8327}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    g(new char[]{0, 0, 0, 0}, new char[]{54000, 4461, 19230, 48210, 53278, 25132, 6721, 58307, 43271, 2250, 9637, 54181, 30517, 5175, 56902, 19063, 17885, 14118}, (char) (super.getResources().getString(R.string.zface_device_unsupport_msg).substring(35, 37).length() + 43243), super.getResources().getString(R.string.otp_sent_to_your_bank_number).substring(1, 5).codePointAt(0) - 111, new char[]{32748, 48319, 60852, 23464}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        g(new char[]{0, 0, 0, 0}, new char[]{60990, 672, 53794, 60825, 44254, 51792, 16586, 18270, 20574, 37379, 41413, 41431, 8084, 6388, 63481, 11994, 4357, 62689, 1813, 55916, 3019, 6491, 50748, 13840, 16849, 63729, 34363, 8347, 52229, 27045, 26868, 30869, 26674, 40941, 56676, 2843, 8517, 62097, 39602, 47143, 53017, 41993, 4958, 29499, 7809, 29918, 18505, 39795}, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{48563, 49475, 60162, 14387}, objArr7);
                        String str = (String) objArr7[0];
                        char[] cArr3 = {0, 0, 0, 0};
                        char[] cArr4 = {18965, 6061, 35823, 4436, 52318, 26860, 43884, 65073, 3685, 4575, 35507, 37407, 50780, 45796, 15225, 42663, 16282, 15053, 38355, 17401, 30932, 7949, 20602, 10108, 19649, 50050, 968, 53538, 65276, 44583, 30177, 2480, 427, 49660, 29207, 45063, 19228, 8402, 33401, 44668, 30843, 16908, 59966, 52128, 48563, 63778, 13987, 35912, 12015, 50164, 41051, 6611, 46694, 41018, 44163, 39646, 3862, 59632, 26830, 23175, 38551, 32552, 60401, 50453};
                        try {
                            Object[] objArr8 = new Object[1];
                            h(scheduleImpl[25], scheduleImpl[30], (byte) (scheduleImpl[49] - 1), objArr8);
                            Class<?> cls4 = Class.forName((String) objArr8[0]);
                            h(scheduleImpl[5], scheduleImpl[8], scheduleImpl[25], new Object[1]);
                            Object[] objArr9 = new Object[1];
                            g(cArr3, cArr4, (char) (((ApplicationInfo) cls4.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.qr_expired_scanner_error_message).substring(4, 8).codePointAt(0) - 32, new char[]{20574, 59390, 29063, 2038}, objArr9);
                            String str2 = (String) objArr9[0];
                            char[] cArr5 = {0, 0, 0, 0};
                            char[] cArr6 = {10027, 61042, 8122, 37805, 45767, 63407, 12537, 502, 8018, 30595, 61386, 4991, 3912, 30060, 52814, 51099, 42335, 59394, 38015, 10441, 65406, 13337, 52196, 47787, 64531, 6063, 64189, 5976, 20936, 65521, 37148, 42844, 53645, 19576, 56836, 61685, 20906, 25531, 9217, 44414, 11668, 55861, 31699, 13053, 59926, 27914, 59699, 27403, 44985, 25276, 65516, 16579, 6823, 8857, 9076, 3679, 8812, 14111, 54733, 31396, 53591, 32076, 6677, 27219};
                            try {
                                Object[] objArr10 = new Object[1];
                                h(scheduleImpl[25], scheduleImpl[30], (byte) (scheduleImpl[49] - 1), objArr10);
                                Class<?> cls5 = Class.forName((String) objArr10[0]);
                                h(scheduleImpl[5], scheduleImpl[8], scheduleImpl[25], new Object[1]);
                                char c = (char) (((ApplicationInfo) cls5.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 33);
                                try {
                                    Object[] objArr11 = new Object[1];
                                    h(scheduleImpl[25], scheduleImpl[30], (byte) (scheduleImpl[49] - 1), objArr11);
                                    Class<?> cls6 = Class.forName((String) objArr11[0]);
                                    h(scheduleImpl[5], scheduleImpl[8], scheduleImpl[25], new Object[1]);
                                    Object[] objArr12 = new Object[1];
                                    g(cArr5, cArr6, c, ((ApplicationInfo) cls6.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{51506, 58524, 19549, 3228}, objArr12);
                                    String str3 = (String) objArr12[0];
                                    Object[] objArr13 = new Object[1];
                                    g(new char[]{0, 0, 0, 0}, new char[]{19470, 57473, 9146, 28149, 30808, 2026, 46371, 2791, 65216, 61354, 31702, 20518, 62731, 34995, 64711, 51538, 32836, 37902, 4849, 27156, 32609, 40374, 65241, 11448, 65140, 63072, 8674, 53454, 13120, 46684, 37917, 8039, 58254, 29832, 19217, 34052, 16142, 26094, 44994, 12220, 54385, 7274, 12750, 2400, 40394, 33363, 20225, 36821, 19161, 16296, 60091, 11488, 64693, 48018, 62109, 37819, 48726, 4445, 55281, 25765}, (char) Gravity.getAbsoluteGravity(0, 0), Process.myTid() >> 22, new char[]{21908, 28304, 58989, 32914}, objArr13);
                                    String str4 = (String) objArr13[0];
                                    Object[] objArr14 = new Object[1];
                                    g(new char[]{0, 0, 0, 0}, new char[]{3256, 15716, 35865, 43084, 8862, 24737}, (char) (super.getResources().getString(R.string.bottom_on_boarding_body_text_scan_fourth).substring(16, 17).codePointAt(0) + 15598), super.getResources().getString(R.string.tnc_dialog_button_ok_text).substring(17, 18).codePointAt(0) - 116, new char[]{23640, 65026, 25139, 16701}, objArr14);
                                    try {
                                        Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr15);
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
            }
            try {
                Object[] objArr16 = new Object[1];
                h((byte) (-scheduleImpl[32]), scheduleImpl[25], (byte) (-scheduleImpl[31]), objArr16);
                Class<?> cls7 = Class.forName((String) objArr16[0]);
                byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 24);
                byte b2 = scheduleImpl[25];
                Object[] objArr17 = new Object[1];
                h(b, b2, (byte) (b2 | Ascii.RS), objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 494, 4 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0') + 1));
                        byte b3 = (byte) ($$g[0] - 1);
                        byte b4 = b3;
                        Object[] objArr19 = new Object[1];
                        j(b3, b4, b4, objArr19);
                        obj3 = cls8.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr21 = {-808320095, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(new char[]{0, 0, 0, 0}, new char[]{42285, 41277, 41312, 55733, 17035, 8826, 65453, 44047, 34841, 14792, 47849, 27382, 41520, 42129, 49725, 65355, 39792, 3624, 44876, 6587, 35049, 57769, 5775, 56394, 12513, 24665}, (char) (super.getResources().getString(R.string.twilio_button_check).substring(0, 1).codePointAt(0) + 34602), ViewConfiguration.getKeyRepeatDelay() >> 16, new char[]{64766, 48248, 27963, 8327}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(new char[]{0, 0, 0, 0}, new char[]{54000, 4461, 19230, 48210, 53278, 25132, 6721, 58307, 43271, 2250, 9637, 54181, 30517, 5175, 56902, 19063, 17885, 14118}, (char) (getPackageName().codePointAt(5) + 43135), super.getResources().getString(R.string.error_msg_dexguard_fresh_install).substring(2, 3).length() - 1, new char[]{32748, 48319, 60852, 23464}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(new char[]{0, 0, 0, 0}, new char[]{42285, 41277, 41312, 55733, 17035, 8826, 65453, 44047, 34841, 14792, 47849, 27382, 41520, 42129, 49725, 65355, 39792, 3624, 44876, 6587, 35049, 57769, 5775, 56394, 12513, 24665}, (char) (super.getResources().getString(R.string.res_0x7f130fa4_daggeruserbankcardcomponent_userbankcardcomponentimpl_postexecutionthreadprovider).substring(3, 4).length() + 34668), getPackageName().length() - 7, new char[]{64766, 48248, 27963, 8327}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(new char[]{0, 0, 0, 0}, new char[]{54000, 4461, 19230, 48210, 53278, 25132, 6721, 58307, 43271, 2250, 9637, 54181, 30517, 5175, 56902, 19063, 17885, 14118}, (char) (43245 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), Drawable.resolveOpacity(0, 0), new char[]{32748, 48319, 60852, 23464}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, KeyEvent.normalizeMetaState(0) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(R.string.terms_and_conditions));
        setMenuLeftButton(R.drawable.arrow_left_white_new);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseTncActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, ExpressPurchaseTncActivity.class);
            intent.putExtra("CONTENT_PAYLOAD", p1);
            p0.startActivity(intent);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        WebProgressView webView;
        WebView webView2;
        WebProgressView webView3 = getWebView();
        if (webView3 != null && (webView2 = webView3.getWebView()) != null) {
            webView2.setInitialScale(0);
            webView2.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(webView2.getContext(), R.color.f27122131100500));
            webView2.setScrollbarFadingEnabled(false);
            WebSettings settings = webView2.getSettings();
            settings.setBuiltInZoomControls(false);
            settings.setLoadWithOverviewMode(false);
            settings.setUseWideViewPort(false);
        }
        String stringExtra = getIntent().getStringExtra("CONTENT_PAYLOAD");
        if (stringExtra == null || (webView = getWebView()) == null) {
            return;
        }
        webView.loadDataWithBaseUrl("", stringExtra);
    }

    private static void g(char[] cArr, char[] cArr2, char c, int i, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr3.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr3, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr2.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getErrorConfigVersion ^ 4360990799332652212L)) ^ ((int) (lookAheadTest ^ 4360990799332652212L))) ^ ((char) (initRecordTimeStamp ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
