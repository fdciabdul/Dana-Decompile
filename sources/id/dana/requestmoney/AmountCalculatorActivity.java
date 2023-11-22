package id.dana.requestmoney;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
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
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.databinding.ActivityAmountBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.model.CurrencyAmountModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.calculator.CalculatorResultListener;
import id.dana.richview.calculator.CalculatorView;
import id.dana.sendmoney.Amount;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b/\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0015\u0010\u0005J!\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\u001b8\u0005@\u0005X\u0084\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u001b8\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/requestmoney/AmountCalculatorActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityAmountBinding;", "", "configToolbar", "()V", "finishCalculatorActivity", "", "getActionButtonText", "()Ljava/lang/String;", "Landroid/content/Intent;", "getIntentData", "()Landroid/content/Intent;", "getMaximumAmountErrorMessage", "getMinimumAmountErrorMessage", "inflateViewBinding", "()Lid/dana/databinding/ActivityAmountBinding;", IAPSyncCommand.COMMAND_INIT, "initButton", "onActionClicked", "onBackPressed", "onDestroy", "p0", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Z)V", "Lid/dana/model/CurrencyAmountModel;", "Lid/dana/model/CurrencyAmountModel;", "MyBillsEntityDataFactory", "Lio/reactivex/disposables/CompositeDisposable;", "lookAheadTest", "Lio/reactivex/disposables/CompositeDisposable;", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "getMaxAmount", "()Lid/dana/model/CurrencyAmountModel;", "setMaxAmount", "(Lid/dana/model/CurrencyAmountModel;)V", BundleKey.MAXIMUM_AMOUNT, "getErrorConfigVersion", "getMinAmount", "setMinAmount", BundleKey.MINIMUM_AMOUNT, "initRecordTimeStamp", "Z", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class AmountCalculatorActivity extends BaseViewBindingActivity<ActivityAmountBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long GetContactSyncConfig;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean getAuthRequestContext;
    public static final byte[] $$a = {65, TarHeader.LF_CHR, -100, -34, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 37;
    public static final byte[] PlaceComponentResult = {94, Ascii.EM, -44, 73, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 244;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private CurrencyAmountModel minAmount = new CurrencyAmountModel("0");

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private CurrencyAmountModel maxAmount = new CurrencyAmountModel("0");

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private CurrencyAmountModel MyBillsEntityDataFactory = new CurrencyAmountModel("0");

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private CompositeDisposable BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            byte[] r0 = id.dana.requestmoney.AmountCalculatorActivity.PlaceComponentResult
            int r7 = r7 * 15
            int r7 = 18 - r7
            int r6 = r6 * 3
            int r6 = 16 - r6
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
            int r7 = r7 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
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
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.requestmoney.AmountCalculatorActivity.b(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r0 = id.dana.requestmoney.AmountCalculatorActivity.$$a
            int r6 = 47 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            int r6 = r6 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.requestmoney.AmountCalculatorActivity.c(int, short, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createIntent(BaseActivity baseActivity, String str, String str2, String str3, boolean z, CurrencyAmountModel currencyAmountModel) {
        return Companion.MyBillsEntityDataFactory(baseActivity, str, str2, str3, z, currencyAmountModel);
    }

    static void getAuthRequestContext() {
        GetContactSyncConfig = 3204343450001221027L;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public View _$_findCachedViewById(int i) {
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
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(TextUtils.lastIndexOf("", '0') + 29064, new char[]{62593, 34057, 6026, 40967, 12947, 49962, 23982, 61055, 30903, 2348, 39816, 5245, 42694, 14164, 49633, 21100, 60643, 32100}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(431 - TextUtils.getTrimmedLength(""), new char[]{62605, 62774, 63467, 61828, 62008}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(54780 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{62679, 8568, 24352, 29993, 41788, 55651, 63291, 11525, 23311, 29014, 44877, 50511, 62273, 10605, 18283, 32099, 43873, 49530, 65392, 5408, 17176, 30996, 38673, 52571, 64268, 4432, 20390, 26109, 37798, 51691, 59371, 7648, 19385, 24973, 40836, 46472, 58314, 6558, 14234, 28141, 39919, 45493, 61434, 1535, 13222, 27084, 34764, 48528}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(TextUtils.getOffsetAfter("", 0) + 787, new char[]{62593, 63430, 62192, 64957, 63690, 64390, 59042, 57693, 60444, 61224, 60007, 54532, 53344, 54054, 57307, 56009, 50658, 49297, 50128, 52920, 51704, 46174, 46964, 45670, 48414, 47193, 47927, 42884, 41676, 44451, 43240, 43935, 38627, 37367, 40018, 40769, 39471, 34108, 32770, 33590, 36397, 35547, 30107, 28896, 29639, 32384, 31163, 25770, 26435, 25200, 28001, 26640, 27397, 22072, 21202, 24004, 22776, 23530, 18125, 16867, 19621, 20319, 18974, 13694}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(59264 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new char[]{62674, 5038, 14971, 17151, 26917, 29100, 38952, 41133, 53024, 55215, 65070, 1700, 11557, 13728, 23586, 25766, 33649, 44010, 45626, 56041, 57662, 2537, 4203, 14522, 18239, 28641, 30271, 40637, 42338, 52709, 54325, 64738, 6967, 9179, 18956, 21125, 31070, 33164, 43020, 45185, 57088, 59345, 3591, 5761, 15628, 17795, 27731, 29907, 37718, 48022, 49741, 60104, 61726, 6554, 8268, 18588, 22303, 32658, 34335, 44691, 46402, 56726, 58391, 3224}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(MotionEvent.axisFromString("") + 40064, new char[]{62600, 26859, 52330, 8685, 34159, 64161, 24117, 46006, 6012, 29942, 59512, 19956, 41274, 1767, 31354, 57315, 13173, 37102, 62586, 27118, 52589, 8952, 34430, 64423, 24431, 48370, 4199, 30199, 59744, 20208, 41587, 2036, 31585, 55501, 15451, 37267, 62815, 27348, 52823, 9110, 34649, 58567, 22623, 48538, 4445, 30429, 59989, 20436, 41795, 219, 25601, 55771, 15646, 37508, 63055, 27615, 53069, 11465, 32850, 58838}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(Color.alpha(0) + 25523, new char[]{62681, 38781, 13234, 57303, 31262, 1710}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 18 - View.resolveSizeAndState(0, 0, 0), (char) TextUtils.indexOf("", ""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (PlaceComponentResult[5] - 1);
                byte b2 = b;
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (PlaceComponentResult[5] - 1);
                byte b4 = PlaceComponentResult[5];
                Object[] objArr14 = new Object[1];
                b(b3, b4, b4, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - TextUtils.lastIndexOf("", '0', 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 2, (char) KeyEvent.getDeadChar(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[78], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 800, 15 - Drawable.resolveOpacity(0, 0), (char) View.MeasureSpec.getSize(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 15, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - Gravity.getAbsoluteGravity(0, 0), 30 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.argb(0, 0, 0, 0), 14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1284469916, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), (Process.myPid() >> 22) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (PlaceComponentResult[5] - 1);
                byte b6 = b5;
                Object[] objArr19 = new Object[1];
                b(b5, b6, b6, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = (byte) (PlaceComponentResult[5] - 1);
                byte b8 = PlaceComponentResult[5];
                Object[] objArr20 = new Object[1];
                b(b7, b8, b8, objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getJumpTapTimeout() >> 16), 46 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) TextUtils.indexOf("", "", 0, 0));
                        byte b9 = $$a[84];
                        byte b10 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b9, b10, b10, objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1284469916, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b11 = (byte) (PlaceComponentResult[5] - 1);
                byte b12 = b11;
                Object[] objArr25 = new Object[1];
                b(b11, b12, b12, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b13 = (byte) (PlaceComponentResult[5] - 1);
                byte b14 = PlaceComponentResult[5];
                Object[] objArr26 = new Object[1];
                b(b13, b14, b14, objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getPressedStateDuration() >> 16), 4 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionType(0L) + 38968));
                        byte b15 = $$a[84];
                        byte b16 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b15, b16, b16, objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1284469916, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b17 = (byte) (PlaceComponentResult[5] - 1);
                byte b18 = b17;
                Object[] objArr31 = new Object[1];
                b(b17, b18, b18, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b19 = (byte) (PlaceComponentResult[5] - 1);
                byte b20 = PlaceComponentResult[5];
                Object[] objArr32 = new Object[1];
                b(b19, b20, b20, objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 107, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 2, (char) (TextUtils.lastIndexOf("", '0', 0) + 1));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], $$a[9], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1284469916, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 18 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(getPackageName().length() + 29056, new char[]{62593, 34057, 6026, 40967, 12947, 49962, 23982, 61055, 30903, 2348, 39816, 5245, 42694, 14164, 49633, 21100, 60643, 32100}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(R.string.hint_form_address).substring(6, 7).codePointAt(0) + 334, new char[]{62605, 62774, 63467, 61828, 62008}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(View.MeasureSpec.makeMeasureSpec(0, 0) + 31963, new char[]{62593, 34901, 3378, 33283, 2019, 33998, 6566, 40243, 4697, 38691, 5150, 43431, 12005, 41884, 10094, 42076, 14630, 48642, 13298, 45272, 13736, 51583, 20032, 49960, 16393, 50663}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(5779 - Gravity.getAbsoluteGravity(0, 0), new char[]{62595, 57862, 55732, 46891, 44745, 33873, 29670, 27300, 16392, 16315, 5426, 3288, 64103, 53750, 51358, 42516, 40383, 35661}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), Color.argb(0, 0, 0, 0) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 54778, new char[]{62679, 8568, 24352, 29993, 41788, 55651, 63291, 11525, 23311, 29014, 44877, 50511, 62273, 10605, 18283, 32099, 43873, 49530, 65392, 5408, 17176, 30996, 38673, 52571, 64268, 4432, 20390, 26109, 37798, 51691, 59371, 7648, 19385, 24973, 40836, 46472, 58314, 6558, 14234, 28141, 39919, 45493, 61434, 1535, 13222, 27084, 34764, 48528}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(787 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{62593, 63430, 62192, 64957, 63690, 64390, 59042, 57693, 60444, 61224, 60007, 54532, 53344, 54054, 57307, 56009, 50658, 49297, 50128, 52920, 51704, 46174, 46964, 45670, 48414, 47193, 47927, 42884, 41676, 44451, 43240, 43935, 38627, 37367, 40018, 40769, 39471, 34108, 32770, 33590, 36397, 35547, 30107, 28896, 29639, 32384, 31163, 25770, 26435, 25200, 28001, 26640, 27397, 22072, 21202, 24004, 22776, 23530, 18125, 16867, 19621, 20319, 18974, 13694}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(super.getResources().getString(R.string.security_enter_answer).substring(10, 11).codePointAt(0) + 59166, new char[]{62674, 5038, 14971, 17151, 26917, 29100, 38952, 41133, 53024, 55215, 65070, 1700, 11557, 13728, 23586, 25766, 33649, 44010, 45626, 56041, 57662, 2537, 4203, 14522, 18239, 28641, 30271, 40637, 42338, 52709, 54325, 64738, 6967, 9179, 18956, 21125, 31070, 33164, 43020, 45185, 57088, 59345, 3591, 5761, 15628, 17795, 27731, 29907, 37718, 48022, 49741, 60104, 61726, 6554, 8268, 18588, 22303, 32658, 34335, 44691, 46402, 56726, 58391, 3224}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(super.getResources().getString(R.string.topup_and_pay_via_other_agent_description).substring(0, 17).length() + 40046, new char[]{62600, 26859, 52330, 8685, 34159, 64161, 24117, 46006, 6012, 29942, 59512, 19956, 41274, 1767, 31354, 57315, 13173, 37102, 62586, 27118, 52589, 8952, 34430, 64423, 24431, 48370, 4199, 30199, 59744, 20208, 41587, 2036, 31585, 55501, 15451, 37267, 62815, 27348, 52823, 9110, 34649, 58567, 22623, 48538, 4445, 30429, 59989, 20436, 41795, 219, 25601, 55771, 15646, 37508, 63055, 27615, 53069, 11465, 32850, 58838}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((ViewConfiguration.getKeyRepeatDelay() >> 16) + 25523, new char[]{62681, 38781, 13234, 57303, 31262, 1710}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
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
            byte b = (byte) (PlaceComponentResult[5] - 1);
            byte b2 = b;
            Object[] objArr12 = new Object[1];
            b(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = (byte) (PlaceComponentResult[5] - 1);
            byte b4 = PlaceComponentResult[5];
            Object[] objArr13 = new Object[1];
            b(b3, b4, b4, objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), Color.argb(0, 0, 0, 0) + 4, (char) KeyEvent.normalizeMetaState(0));
                    Object[] objArr15 = new Object[1];
                    c((byte) ($$a[78] - 1), $$a[8], $$a[9], objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {1106289269, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, 18 - Color.green(0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().length() + 31956, new char[]{62593, 34901, 3378, 33283, 2019, 33998, 6566, 40243, 4697, 38691, 5150, 43431, 12005, 41884, 10094, 42076, 14630, 48642, 13298, 45272, 13736, 51583, 20032, 49960, 16393, 50663}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().codePointAt(4) + 5682, new char[]{62595, 57862, 55732, 46891, 44745, 33873, 29670, 27300, 16392, 16315, 5426, 3288, 64103, 53750, 51358, 42516, 40383, 35661}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSize(0, 0), 35 - View.resolveSize(0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 911, AndroidCharacter.getMirror('0') - 30, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.keyword_empty_nearby_search_title).substring(0, 7).codePointAt(1) + 31926, new char[]{62593, 34901, 3378, 33283, 2019, 33998, 6566, 40243, 4697, 38691, 5150, 43431, 12005, 41884, 10094, 42076, 14630, 48642, 13298, 45272, 13736, 51583, 20032, 49960, 16393, 50663}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.empty_state_bank_cards_title_v3).substring(0, 1).length() + 5778, new char[]{62595, 57862, 55732, 46891, 44745, 33873, 29670, 27300, 16392, 16315, 5426, 3288, 64103, 53750, 51358, 42516, 40383, 35661}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    @JvmName(name = "getMinAmount")
    public final CurrencyAmountModel getMinAmount() {
        return this.minAmount;
    }

    @JvmName(name = "setMinAmount")
    protected final void setMinAmount(CurrencyAmountModel currencyAmountModel) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        this.minAmount = currencyAmountModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getMaxAmount")
    public final CurrencyAmountModel getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "setMaxAmount")
    protected final void setMaxAmount(CurrencyAmountModel currencyAmountModel) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        this.maxAmount = currencyAmountModel;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public ActivityAmountBinding inflateViewBinding() {
        ActivityAmountBinding BuiltInFictitiousFunctionClassFactory = ActivityAmountBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public void initButton() {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().getAuthRequestContext;
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.AmountCalculatorActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmountCalculatorActivity.m2795$r8$lambda$oAutu6VMomX1F_nxCZohqjZQCs(AmountCalculatorActivity.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setDisabled(getActionButtonText());
        danaButtonPrimaryView.setEnabled(false);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0, null);
        super.onBackPressed();
    }

    public void onActionClicked() {
        finishCalculatorActivity();
    }

    public final void finishCalculatorActivity() {
        setResult(-1, getIntentData());
        finish();
    }

    public Intent getIntentData() {
        Intent intent = new Intent();
        String amount = getBinding().BuiltInFictitiousFunctionClassFactory.getAmount();
        if (amount == null) {
            amount = "";
        }
        intent.putExtra("amount", amount);
        return intent;
    }

    protected String getMaximumAmountErrorMessage() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.sm_maximum_amount);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.maxAmount.MyBillsEntityDataFactory}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    protected String getMinimumAmountErrorMessage() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.sm_minimum_amount);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.minAmount.MyBillsEntityDataFactory}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(AmountCalculatorActivity amountCalculatorActivity, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        amountCalculatorActivity.KClassImpl$Data$declaredNonStaticMembers$2(str, z);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1) {
        ActivityAmountBinding binding = getBinding();
        DanaButtonPrimaryView danaButtonPrimaryView = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        boolean z = !p1;
        if (z) {
            danaButtonPrimaryView.setActiveButton(getActionButtonText(), null);
        } else {
            danaButtonPrimaryView.setDisabled(getActionButtonText());
        }
        danaButtonPrimaryView.setEnabled(z);
        TextView textView = binding.moveToNextValue;
        textView.setVisibility(p1 ? 0 : 8);
        textView.setText(p0);
    }

    public String getActionButtonText() {
        String string = getString(R.string.set_amount);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JA\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/requestmoney/AmountCalculatorActivity$Companion;", "", "Lid/dana/base/BaseActivity;", "p0", "", "p1", "p2", "p3", "", "p4", "Lid/dana/model/CurrencyAmountModel;", "p5", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Lid/dana/base/BaseActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLid/dana/model/CurrencyAmountModel;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(BaseActivity p0, String p1, String p2, String p3, boolean p4, CurrencyAmountModel p5) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intent intent = new Intent(p0, AmountCalculatorActivity.class);
            intent.putExtra(BundleKey.SEPARATOR_VISIBILITY, p4);
            intent.putExtra(BundleKey.MINIMUM_AMOUNT, p1);
            intent.putExtra(BundleKey.MAXIMUM_AMOUNT, p2);
            intent.putExtra("title", p3);
            intent.putExtra("amount", p5);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$-oAutu6VMomX1F_nxCZohqjZQCs  reason: not valid java name */
    public static /* synthetic */ void m2795$r8$lambda$oAutu6VMomX1F_nxCZohqjZQCs(AmountCalculatorActivity amountCalculatorActivity, View view) {
        Intrinsics.checkNotNullParameter(amountCalculatorActivity, "");
        amountCalculatorActivity.onActionClicked();
    }

    public static /* synthetic */ void $r8$lambda$KiQUH9t_IFsK8p_FDUDWPgMBR9Q(AmountCalculatorActivity amountCalculatorActivity, String str) {
        Intrinsics.checkNotNullParameter(amountCalculatorActivity, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(str);
        if (currencyAmountModel.KClassImpl$Data$declaredNonStaticMembers$2(amountCalculatorActivity.minAmount)) {
            KClassImpl$Data$declaredNonStaticMembers$2$default(amountCalculatorActivity, amountCalculatorActivity.getMinimumAmountErrorMessage(), false, 2, null);
        } else if (currencyAmountModel.getAuthRequestContext(amountCalculatorActivity.maxAmount)) {
            KClassImpl$Data$declaredNonStaticMembers$2$default(amountCalculatorActivity, amountCalculatorActivity.getMaximumAmountErrorMessage(), false, 2, null);
        } else {
            amountCalculatorActivity.KClassImpl$Data$declaredNonStaticMembers$2("", false);
        }
    }

    public static /* synthetic */ void $r8$lambda$aApa3BAR9x0hIn_8aP13cUYodBs(AmountCalculatorActivity amountCalculatorActivity, String str) {
        Intrinsics.checkNotNullParameter(amountCalculatorActivity, "");
        if (new Amount(str).getAuthRequestContext()) {
            amountCalculatorActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setText(str);
        }
    }

    public static /* synthetic */ void $r8$lambda$dAzfGXRwDX4Yak7PvvfFHExEH4s(AmountCalculatorActivity amountCalculatorActivity, View view) {
        Intrinsics.checkNotNullParameter(amountCalculatorActivity, "");
        amountCalculatorActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().MyBillsEntityDataFactory;
        layoutToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.AmountCalculatorActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmountCalculatorActivity.$r8$lambda$dAzfGXRwDX4Yak7PvvfFHExEH4s(AmountCalculatorActivity.this, view);
            }
        });
        layoutToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(4);
        Toolbar toolbar = layoutToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        int childCount = toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = toolbar.getChildAt(i);
            ImageButton imageButton = childAt instanceof ImageButton ? (ImageButton) childAt : null;
            if (imageButton != null) {
                imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public void init() {
        Disposable subscribe;
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            String string = extras.getString("title", "");
            Intrinsics.checkNotNullExpressionValue(string, "");
            LayoutToolbarBinding layoutToolbarBinding = getBinding().MyBillsEntityDataFactory;
            TextView textView = layoutToolbarBinding.initRecordTimeStamp;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            ImageView imageView = layoutToolbarBinding.moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            imageView.setVisibility(8);
            layoutToolbarBinding.initRecordTimeStamp.setText(string);
            this.minAmount = new CurrencyAmountModel(extras.getString(BundleKey.MINIMUM_AMOUNT, "0"));
            this.maxAmount = new CurrencyAmountModel(extras.getString(BundleKey.MAXIMUM_AMOUNT, "0"));
            this.getAuthRequestContext = extras.getBoolean(BundleKey.SEPARATOR_VISIBILITY, false);
            CurrencyAmountModel currencyAmountModel = (CurrencyAmountModel) extras.getParcelable("amount");
            if (currencyAmountModel == null) {
                currencyAmountModel = new CurrencyAmountModel("0");
            } else {
                Intrinsics.checkNotNullExpressionValue(currencyAmountModel, "");
            }
            this.MyBillsEntityDataFactory = currencyAmountModel;
        }
        initButton();
        CalculatorView calculatorView = getBinding().PlaceComponentResult;
        calculatorView.setSeparatorVisibility(this.getAuthRequestContext);
        calculatorView.setCalculatorResultListener(new CalculatorResultListener() { // from class: id.dana.requestmoney.AmountCalculatorActivity$$ExternalSyntheticLambda1
            @Override // id.dana.richview.calculator.CalculatorResultListener
            public final void BuiltInFictitiousFunctionClassFactory(String str) {
                AmountCalculatorActivity.$r8$lambda$aApa3BAR9x0hIn_8aP13cUYodBs(AmountCalculatorActivity.this, str);
            }
        });
        Observable<String> listenOriginalValue = getBinding().BuiltInFictitiousFunctionClassFactory.listenOriginalValue();
        if (listenOriginalValue != null && (subscribe = listenOriginalValue.subscribe(new Consumer() { // from class: id.dana.requestmoney.AmountCalculatorActivity$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AmountCalculatorActivity.$r8$lambda$KiQUH9t_IFsK8p_FDUDWPgMBR9Q(AmountCalculatorActivity.this, (String) obj);
            }
        })) != null) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(subscribe);
        }
        CalculatorView calculatorView2 = getBinding().PlaceComponentResult;
        String str = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
        calculatorView2.onPadClicked(str != null ? str : "");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (GetContactSyncConfig ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}
