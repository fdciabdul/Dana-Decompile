package id.dana.twilio.onboarding;

import android.content.Context;
import android.content.DialogInterface;
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
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.ComponentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.challenge.ChallengeControl;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.DialogWithImage;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.extension.view.ViewPagerExtKt$attachViewPager$1;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.LogoProgressView;
import id.dana.twilio.onboarding.DaggerTwilioIntroductionComponent;
import id.dana.twilio.onboarding.TwilioIntroductionContract;
import id.dana.twilio.onboarding.adapter.TwilioOnboardingAdapter;
import id.dana.twilio.trusteddevice.TrustedDeviceActivity;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.PhoneCall;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b%\u0010\fJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\fR\u0016\u0010\u0014\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0013\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$"}, d2 = {"Lid/dana/twilio/onboarding/TwilioIntroductionActivity;", "Lid/dana/base/BaseActivity;", "", "p0", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "()V", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/challenge/ChallengeControl;", "getErrorConfigVersion", "Lid/dana/challenge/ChallengeControl;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "lookAheadTest", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/twilio/onboarding/TwilioIntroductionPresenter;", "twilioIntroductionPresenter", "Lid/dana/twilio/onboarding/TwilioIntroductionPresenter;", "getTwilioIntroductionPresenter", "()Lid/dana/twilio/onboarding/TwilioIntroductionPresenter;", "setTwilioIntroductionPresenter", "(Lid/dana/twilio/onboarding/TwilioIntroductionPresenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TwilioIntroductionActivity extends BaseActivity {
    public static final String CHALLENGE_OTP = "OTP_SMS";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String HOME_PAGE = "HOME_PAGE";
    private static long NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    public static final String SETTING_PAGE = "SETTING_PAGE";
    public static final String TRUSTED_DEVICE_PAGE = "TRUSTED_DEVICE_PAGE";
    private static char[] scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final ActivityPermissionRequest PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ChallengeControl BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public TwilioIntroductionPresenter twilioIntroductionPresenter;
    public static final byte[] $$a = {116, 44, -28, -115, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 223;
    public static final byte[] PlaceComponentResult = {125, -100, 71, Ascii.FS, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 70;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        scheduleImpl = new char[]{5495, 27467, 59668, 28669, 60853, 25472, 57408, 26205, 58607, 31405, 63640, 30985, 65331, 32226, 62376, 29058, 63056, 29724, 51956, 18598, 52926, 20305, 52486, 17382, 49599, 18313, 27348, 5361, 38563, 4188, 37406, 7206, 40945, 6547, 39775, 1292, 34597, 1775, 32944, 577, 35849, 3619, 35304, 3002, 11592, 21364, 53547, 22466, 54666, 23487, 55423, 24162, 56542, 17041, 49401, 16712, 51007, 17873, 52096, 18865, 52842, 19513, 62243, 36100, 3965, 35262, 3046, 51503, 46920, 13640, 46009, 12772, 49027, 15379, 47685, 14519, 42678, 9349, 42319, 8985, 41405, 12259, 44499, 10777, 43082, 5816, 38064, 4736, 37716, 4377, 40891, 7604, 39888, 6158, 34333, 1214, 33467, 131, 33104, 3905, 36285, 3052, 35288, 30290, 62590, 29362, 61677, 32471, 65365, 32114, 64447, 31166, 59356, 25604, 57888, 62255, 36168, 3870, 35251, 3044, 34184, 1612, 32787, 690, 40166, 7817, 40778, 6478, 39912, 5557, 38791, 4172, 37407, 11454, 44726, 10454, 43344, 11034, 42472, 10160, 41431, 8793, 48202, 16098, 47341, 14982, 47953, 13645, 47033, 12732, 45967, 19457, 52850, 18668, 51896, 17539, 50517, 18293, 49646, 17385, 56718, 24149, 55332, 23277, 54462, 22159, 55134, 20779, 54262, 28092, 61322, 26710, 59940, 25763, 59117, 24715, 57681, 25456, 65008, 62332, 36172, 3917, 35253, 3003, 34182, 1614, 32799, 750, 40125, 7816, 40782, 6427, 39914, 5556, 38788, 4127, 37448, 11500, 44771, 10368, 43267, 11085, 42472, 10161, 41427, 8793, 48151, 16060, 47343, 14979, 47872, 13593, 47033, 12730, 45967, 19456, 52774, 18666, 51891, 17550, 50435, 18209, 49643, 17330, 56713, 24069, 55409, 23224, 54452, 22235, 55042, 20768, 54256, 28138, 61326, 26705, 59936, 25849, 59065, 24796, 57692, 25377, 65018, 62246, 36105, 3932, 35239, 3057, 34187, 1619, 32772, 690, 40164, 7902, 40734, 6404, 39853, 5612, 38849, 4123, 37452, 11436, 44772, 10451, 43282, 11096, 42485, 10209, 41408, 8705, 48221, 16062, 47354, 15045, 47894, 13647, 47023, 12781, 45977, 19457, 52862, 18609, 51876, 17623, 50453, 18297, 49648, 17379, 56791, 24067, 55414, 23213, 54521, 22167, 55057, 20768, 54254, 28137, 61389, 26627, 60027, 25780, 59132, 62327, 36179, 3868, 35321, 2992, 34176};
        NetworkUserEntityData$$ExternalSyntheticLambda2 = -7087627929658290819L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 56 - r7
            int r8 = 106 - r8
            int r6 = 23 - r6
            byte[] r0 = id.dana.twilio.onboarding.TwilioIntroductionActivity.PlaceComponentResult
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L2a
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2a:
            int r3 = -r3
            int r6 = r6 + r3
            int r8 = r8 + 1
            int r6 = r6 + (-4)
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.twilio.onboarding.TwilioIntroductionActivity.a(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.twilio.onboarding.TwilioIntroductionActivity.$$a
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r6 = r6 + 4
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.twilio.onboarding.TwilioIntroductionActivity.c(short, byte, int, java.lang.Object[]):void");
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
        b(18 - Color.alpha(0), TextUtils.indexOf((CharSequence) "", '0', 0) + 45, (char) (56936 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 5, 62 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (Process.myTid() >> 22), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(48 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 67, (char) (TextUtils.lastIndexOf("", '0', 0) + 14935), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(64 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0) + 116, (char) ('0' - AndroidCharacter.getMirror('0')), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 64, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 178, (char) View.combineMeasuredStates(0, 0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(Gravity.getAbsoluteGravity(0, 0) + 60, 243 - Color.argb(0, 0, 0, 0), (char) View.MeasureSpec.getSize(0), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(5 - TextUtils.lastIndexOf("", '0'), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (MotionEvent.axisFromString("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(PlaceComponentResult[30], Ascii.RS, PlaceComponentResult[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (Process.myTid() >> 22), View.resolveSize(0, 0) + 3, (char) ExpandableListView.getPackedPositionType(0L));
                        byte b = $$a[47];
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ((byte) KeyEvent.getModifierMetaStateMask()), 15 - TextUtils.getOffsetBefore("", 0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 800, 16 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 815, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 28, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getTouchSlop() >> 8) + 15, (char) TextUtils.indexOf("", "", 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-315630733, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(PlaceComponentResult[30], Ascii.RS, PlaceComponentResult[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - KeyEvent.getDeadChar(0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 45, (char) (ViewConfiguration.getTouchSlop() >> 8));
                        Object[] objArr22 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), KeyEvent.normalizeMetaState(0) + 35, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-315630733, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), TextUtils.indexOf("", "", 0) + 18, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(PlaceComponentResult[30], Ascii.RS, PlaceComponentResult[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getTouchSlop() >> 8) + 3, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 38969));
                        Object[] objArr28 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-315630733, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(PlaceComponentResult[30], Ascii.RS, PlaceComponentResult[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getFadingEdgeLength() >> 16), TextUtils.lastIndexOf("", '0', 0) + 4, (char) KeyEvent.getDeadChar(0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-315630733, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_twillio_introduction;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(getPackageName().length() + 11, 45 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 56936), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr3 = new Object[1];
            a(b, (byte) (b | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[32]), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[48], new Object[1]);
            Object[] objArr4 = new Object[1];
            b(((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 28, 62 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (super.getResources().getString(R.string.res_0x7f1306f6_flowviewutil_textchanges_1).substring(6, 7).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN), objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        byte b2 = PlaceComponentResult[25];
                        Object[] objArr5 = new Object[1];
                        a(b2, (byte) (b2 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[32]), objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[48], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        b(((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, Color.blue(0), (char) (super.getResources().getString(R.string.bottom_on_boarding_body_text_top_up_first).substring(0, 1).codePointAt(0) + 58885), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(super.getResources().getString(R.string.payment_setting_success_dialog_message).substring(4, 10).length() + 12, 26 - (ViewConfiguration.getTouchSlop() >> 8), (char) (ExpandableListView.getPackedPositionType(0L) + 39417), objArr7);
                        baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        try {
                            byte b3 = PlaceComponentResult[25];
                            Object[] objArr8 = new Object[1];
                            a(b3, (byte) (b3 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[32]), objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[48], objArr9);
                            Object[] objArr10 = new Object[1];
                            b(((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 15, getPackageName().codePointAt(1) - 33, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14933), objArr10);
                            String str = (String) objArr10[0];
                            try {
                                byte b4 = PlaceComponentResult[25];
                                Object[] objArr11 = new Object[1];
                                a(b4, (byte) (b4 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[32]), objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                Object[] objArr12 = new Object[1];
                                a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[48], objArr12);
                                int i = ((ApplicationInfo) cls6.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 31;
                                try {
                                    byte b5 = PlaceComponentResult[25];
                                    Object[] objArr13 = new Object[1];
                                    a(b5, (byte) (b5 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[32]), objArr13);
                                    Class<?> cls7 = Class.forName((String) objArr13[0]);
                                    Object[] objArr14 = new Object[1];
                                    a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[48], objArr14);
                                    Object[] objArr15 = new Object[1];
                                    b(i, ((ApplicationInfo) cls7.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 82, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr15);
                                    String str2 = (String) objArr15[0];
                                    Object[] objArr16 = new Object[1];
                                    b(getPackageName().length() + 57, 179 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (super.getResources().getString(R.string.category_voucher_code).substring(1, 2).length() - 1), objArr16);
                                    String str3 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    b(super.getResources().getString(R.string.lbl_empty_feed_notification_desc).substring(8, 9).codePointAt(0) - 41, Color.blue(0) + 243, (char) (getPackageName().codePointAt(2) - 46), objArr17);
                                    String str4 = (String) objArr17[0];
                                    int length = super.getResources().getString(R.string.desc_error_sysbusy_dialog).substring(2, 3).length() + 5;
                                    try {
                                        byte b6 = PlaceComponentResult[25];
                                        Object[] objArr18 = new Object[1];
                                        a(b6, (byte) (b6 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[32]), objArr18);
                                        Class<?> cls8 = Class.forName((String) objArr18[0]);
                                        Object[] objArr19 = new Object[1];
                                        a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[48], objArr19);
                                        Object[] objArr20 = new Object[1];
                                        b(length, ((ApplicationInfo) cls8.getMethod((String) objArr19[0], null).invoke(this, null)).targetSdkVersion + 270, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr20);
                                        try {
                                            Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, KeyEvent.getDeadChar(0, 0) + 18, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                }
            }
            try {
                Object[] objArr22 = new Object[1];
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr22);
                Class<?> cls9 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                a(PlaceComponentResult[30], Ascii.RS, PlaceComponentResult[9], objArr23);
                try {
                    Object[] objArr24 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.lastIndexOf("", '0', 0, 0), 4 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) TextUtils.indexOf("", ""));
                        Object[] objArr25 = new Object[1];
                        c((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr25);
                        obj3 = cls10.getMethod((String) objArr25[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr26 = (Object[]) ((Method) obj3).invoke(null, objArr24);
                    int i2 = ((int[]) objArr26[1])[0];
                    if (((int[]) objArr26[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr27 = {-1388467064, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), KeyEvent.normalizeMetaState(0) + 18, (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr27);
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
        } catch (Throwable th12) {
            Throwable cause12 = th12.getCause();
            if (cause12 == null) {
                throw th12;
            }
            throw cause12;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, (byte) (b | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[32]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[48], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, getPackageName().length() - 7, (char) (getPackageName().codePointAt(2) + 58922), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, 26 - View.resolveSizeAndState(0, 0, 0), (char) (super.getResources().getString(R.string.my_bills_label_pay).substring(1, 3).length() + 39415), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.green(0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, TextUtils.getCapsMode("", 0, 0) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.citcall_consult_limit_dialog_button).substring(0, 2).length() + 24, ViewConfiguration.getKeyRepeatTimeout() >> 16, (char) (super.getResources().getString(R.string.msg_check_permission).substring(4, 5).codePointAt(0) + 58861), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(ExpandableListView.getPackedPositionChild(0L) + 19, getPackageName().length() + 19, (char) (super.getResources().getString(R.string.btn_view_other_locations).substring(1, 2).codePointAt(0) + 39344), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, Color.blue(0) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), TextUtils.getOffsetBefore("", 0) + 18, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public TwilioIntroductionActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$phonePermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(TwilioIntroductionActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.PlaceComponentResult = builder.PlaceComponentResult();
    }

    @JvmName(name = "getTwilioIntroductionPresenter")
    public final TwilioIntroductionPresenter getTwilioIntroductionPresenter() {
        TwilioIntroductionPresenter twilioIntroductionPresenter = this.twilioIntroductionPresenter;
        if (twilioIntroductionPresenter != null) {
            return twilioIntroductionPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTwilioIntroductionPresenter")
    public final void setTwilioIntroductionPresenter(TwilioIntroductionPresenter twilioIntroductionPresenter) {
        Intrinsics.checkNotNullParameter(twilioIntroductionPresenter, "");
        this.twilioIntroductionPresenter = twilioIntroductionPresenter;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        ChallengeControl challengeControl = this.BuiltInFictitiousFunctionClassFactory;
        if (challengeControl != null) {
            if (challengeControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                challengeControl = null;
            }
            if (challengeControl.MyBillsEntityDataFactory(requestCode, resultCode, data)) {
                return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(String p0, String p1) {
        PlaceComponentResult();
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            TwilioIntroductionPresenter twilioIntroductionPresenter = getTwilioIntroductionPresenter();
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            twilioIntroductionPresenter.PlaceComponentResult(p0, p1, str);
            return;
        }
        getTwilioIntroductionPresenter().MyBillsEntityDataFactory("Push notification token null", p1);
        BuiltInFictitiousFunctionClassFactory();
        getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_enroll_loading);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.lpv_activity_twillio);
        if (logoProgressView != null) {
            logoProgressView.startRefresh();
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_enroll);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_enroll_loading);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.lpv_activity_twillio);
        if (logoProgressView != null) {
            logoProgressView.stopRefresh();
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_enroll);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        CustomToastUtil.PlaceComponentResult(this, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, R.drawable.bg_rounded_toast_failed, getString(R.string.twilio_enroll_failed_message), 48, 60, false, null, 384);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b"}, d2 = {"Lid/dana/twilio/onboarding/TwilioIntroductionActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "Landroid/content/Intent;", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "CHALLENGE_OTP", "Ljava/lang/String;", TwilioIntroductionActivity.HOME_PAGE, TwilioIntroductionActivity.SETTING_PAGE, TwilioIntroductionActivity.TRUSTED_DEVICE_PAGE, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent getAuthRequestContext(Context p0, String p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, TwilioIntroductionActivity.class);
            intent.putExtra("source", p1);
            intent.putExtra(BioUtilityBridge.SECURITY_ID, p2);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$DTI2qauxsYp_g6qXbrcVStOPh2U(TwilioIntroductionActivity twilioIntroductionActivity, View view) {
        Intrinsics.checkNotNullParameter(twilioIntroductionActivity, "");
        twilioIntroductionActivity.PlaceComponentResult();
        twilioIntroductionActivity.getTwilioIntroductionPresenter().BuiltInFictitiousFunctionClassFactory(SETTING_PAGE);
    }

    public static /* synthetic */ void $r8$lambda$aFSVY6Rqz27p_ODTTS96NoKrx6g(TwilioIntroductionActivity twilioIntroductionActivity, String str, View view) {
        Intrinsics.checkNotNullParameter(twilioIntroductionActivity, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        twilioIntroductionActivity.PlaceComponentResult();
        twilioIntroductionActivity.getTwilioIntroductionPresenter().BuiltInFictitiousFunctionClassFactory(str);
    }

    public static /* synthetic */ void $r8$lambda$b12C24H93OLaGui6Qou3OCZEarc(TwilioIntroductionActivity twilioIntroductionActivity, String str, String str2, View view) {
        Intrinsics.checkNotNullParameter(twilioIntroductionActivity, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        Intrinsics.checkNotNullExpressionValue(str2, "");
        twilioIntroductionActivity.getAuthRequestContext(str, str2);
    }

    public static /* synthetic */ void $r8$lambda$ekI3LlY3wQhF2zw6FUZq3yhc0_I(TwilioIntroductionActivity twilioIntroductionActivity, Task task) {
        Intrinsics.checkNotNullParameter(twilioIntroductionActivity, "");
        Intrinsics.checkNotNullParameter(task, "");
        if (task.isSuccessful()) {
            Object result = task.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "");
            twilioIntroductionActivity.KClassImpl$Data$declaredNonStaticMembers$2 = (String) result;
        }
    }

    public static /* synthetic */ void $r8$lambda$gPGVHSL1RV0eu6MKR8_qt0DybWU(TwilioIntroductionActivity twilioIntroductionActivity, String str, View view) {
        Intrinsics.checkNotNullParameter(twilioIntroductionActivity, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        twilioIntroductionActivity.PlaceComponentResult();
        twilioIntroductionActivity.getTwilioIntroductionPresenter().BuiltInFictitiousFunctionClassFactory(str);
    }

    public static /* synthetic */ void $r8$lambda$ksT1Tuw7ErhtwlHly_D5hsX4Vp0(TwilioIntroductionActivity twilioIntroductionActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(twilioIntroductionActivity, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i != -2) {
            if (i != -1) {
                return;
            }
            twilioIntroductionActivity.PlaceComponentResult.check();
        }
        dialogInterface.dismiss();
    }

    public static final /* synthetic */ void access$openTrustedDevicePage(TwilioIntroductionActivity twilioIntroductionActivity) {
        TrustedDeviceActivity.Companion companion = TrustedDeviceActivity.INSTANCE;
        twilioIntroductionActivity.startActivity(TrustedDeviceActivity.Companion.MyBillsEntityDataFactory(twilioIntroductionActivity));
        twilioIntroductionActivity.finish();
    }

    public static final /* synthetic */ void access$startOtpChallenge(final TwilioIntroductionActivity twilioIntroductionActivity, final String str, final String str2) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(twilioIntroductionActivity);
        builder.scheduleImpl = "twilio_otp";
        builder.E = str == null ? "" : str;
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "twilio_otp";
        builder.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ChallengeControl.Listener() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$startOtpChallenge$1
            @Override // id.dana.challenge.ChallengeControl.Listener
            public final void getAuthRequestContext() {
                TwilioIntroductionActivity.this.getAuthRequestContext(str, str2);
            }

            @Override // id.dana.challenge.ChallengeControl.Listener
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, Bundle p2) {
                TwilioIntroductionActivity.this.BuiltInFictitiousFunctionClassFactory();
                if ((p2 != null ? p2.getString("message") : null) != null) {
                    String string = p2.getString("message");
                    if (string == null) {
                        string = "";
                    }
                    TwilioIntroductionActivity.this.showWarningDialog(string);
                }
            }
        };
        ChallengeControl challengeControl = new ChallengeControl(builder, null);
        twilioIntroductionActivity.BuiltInFictitiousFunctionClassFactory = challengeControl;
        challengeControl.getAuthRequestContext();
    }

    public static final /* synthetic */ void access$startPinChallenge(final TwilioIntroductionActivity twilioIntroductionActivity, final String str, final String str2) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(twilioIntroductionActivity);
        builder.scheduleImpl = "twilio_pin";
        builder.E = str == null ? "" : str;
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "twilio_pin";
        builder.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ChallengeControl.Listener() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$startPinChallenge$1
            @Override // id.dana.challenge.ChallengeControl.Listener
            public final void getAuthRequestContext() {
                TwilioIntroductionActivity.this.getAuthRequestContext(str, str2);
            }

            @Override // id.dana.challenge.ChallengeControl.Listener
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, Bundle p2) {
                ActivityPermissionRequest activityPermissionRequest;
                TwilioIntroductionActivity.this.BuiltInFictitiousFunctionClassFactory();
                if (p1 != null) {
                    int hashCode = p1.hashCode();
                    if (hashCode == -305104263) {
                        if (p1.equals("forgot_pin")) {
                            activityPermissionRequest = TwilioIntroductionActivity.this.PlaceComponentResult;
                            activityPermissionRequest.check();
                        }
                    } else if (hashCode == -109866462) {
                        if (p1.equals(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED)) {
                            DialogWithImage.BuiltInFictitiousFunctionClassFactory(r1, new DialogInterface.OnClickListener() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$$ExternalSyntheticLambda0
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    TwilioIntroductionActivity.$r8$lambda$ksT1Tuw7ErhtwlHly_D5hsX4Vp0(TwilioIntroductionActivity.this, dialogInterface, i);
                                }
                            }).MyBillsEntityDataFactory();
                        }
                    } else if (hashCode == 462997423 && p1.equals(ChallengeControl.CancelReason.SESSION_EXPIRED)) {
                        TwilioIntroductionActivity twilioIntroductionActivity2 = TwilioIntroductionActivity.this;
                        twilioIntroductionActivity2.showWarningDialog(twilioIntroductionActivity2.getString(R.string.session_expired));
                    }
                }
            }
        };
        ChallengeControl challengeControl = new ChallengeControl(builder, null);
        twilioIntroductionActivity.BuiltInFictitiousFunctionClassFactory = challengeControl;
        challengeControl.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerTwilioIntroductionComponent.Builder authRequestContext = DaggerTwilioIntroductionComponent.getAuthRequestContext();
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (TwilioIntroductionModule) Preconditions.getAuthRequestContext(new TwilioIntroductionModule(new TwilioIntroductionContract.View() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$initInjector$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                TwilioIntroductionActivity.this.PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                TwilioIntroductionActivity.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.twilio.onboarding.TwilioIntroductionContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                TwilioIntroductionActivity.this.BuiltInFictitiousFunctionClassFactory();
                TwilioIntroductionActivity.access$openTrustedDevicePage(TwilioIntroductionActivity.this);
            }

            @Override // id.dana.twilio.onboarding.TwilioIntroductionContract.View
            public final void getAuthRequestContext() {
                TwilioIntroductionActivity.this.BuiltInFictitiousFunctionClassFactory();
                TwilioIntroductionActivity.this.getAuthRequestContext();
            }

            @Override // id.dana.twilio.onboarding.TwilioIntroductionContract.View
            public final void getAuthRequestContext(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                TwilioIntroductionActivity.this.getAuthRequestContext(p0, p1);
            }

            @Override // id.dana.twilio.onboarding.TwilioIntroductionContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                TwilioIntroductionActivity.this.BuiltInFictitiousFunctionClassFactory();
                if (StringsKt.equals(p2, "OTP_SMS", true)) {
                    TwilioIntroductionActivity.access$startOtpChallenge(TwilioIntroductionActivity.this, p0, p1);
                } else {
                    TwilioIntroductionActivity.access$startPinChallenge(TwilioIntroductionActivity.this, p0, p1);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                TwilioIntroductionActivity.this.BuiltInFictitiousFunctionClassFactory();
                TwilioIntroductionActivity.this.getAuthRequestContext();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, TwilioIntroductionModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerTwilioIntroductionComponent.TwilioIntroductionComponentImpl(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).MyBillsEntityDataFactory(this);
        registerPresenter(getTwilioIntroductionPresenter());
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TwilioIntroductionActivity.$r8$lambda$ekI3LlY3wQhF2zw6FUZq3yhc0_I(TwilioIntroductionActivity.this, task);
            }
        });
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String string = extras.getString("source", "");
            final String string2 = extras.getString(BioUtilityBridge.SECURITY_ID, "");
            if (Intrinsics.areEqual(string, HOME_PAGE)) {
                Intrinsics.checkNotNullExpressionValue(string2, "");
                if ((string2.length() > 0 ? (byte) 1 : (byte) 0) != 0) {
                    DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_enroll);
                    if (danaButtonPrimaryView != null) {
                        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                TwilioIntroductionActivity.$r8$lambda$b12C24H93OLaGui6Qou3OCZEarc(TwilioIntroductionActivity.this, string2, string, view);
                            }
                        });
                    }
                } else {
                    DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_enroll);
                    if (danaButtonPrimaryView2 != null) {
                        danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$$ExternalSyntheticLambda2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                TwilioIntroductionActivity.$r8$lambda$aFSVY6Rqz27p_ODTTS96NoKrx6g(TwilioIntroductionActivity.this, string, view);
                            }
                        });
                    }
                }
            } else {
                if (Intrinsics.areEqual(string, SETTING_PAGE)) {
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    if ((string2.length() == 0 ? (byte) 1 : (byte) 0) != 0) {
                        DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_enroll);
                        if (danaButtonPrimaryView3 != null) {
                            danaButtonPrimaryView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$$ExternalSyntheticLambda3
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    TwilioIntroductionActivity.$r8$lambda$gPGVHSL1RV0eu6MKR8_qt0DybWU(TwilioIntroductionActivity.this, string, view);
                                }
                            });
                        }
                    }
                }
                if (Intrinsics.areEqual(string, TRUSTED_DEVICE_PAGE)) {
                    CustomToastUtil.PlaceComponentResult(this, R.drawable.success, R.drawable.bg_rounded_toast_success, getString(R.string.twilio_remove_device_success_message), 48, 60, false, null, 384);
                    DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_enroll);
                    if (danaButtonPrimaryView4 != null) {
                        danaButtonPrimaryView4.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.onboarding.TwilioIntroductionActivity$$ExternalSyntheticLambda4
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                TwilioIntroductionActivity.$r8$lambda$DTI2qauxsYp_g6qXbrcVStOPh2U(TwilioIntroductionActivity.this, view);
                            }
                        });
                    }
                }
            }
        }
        setTitle(getString(R.string.twilio_introduction_activity_toolbar));
        setMenuLeftButton(R.drawable.arrow_left_white);
        ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(R.id.vp_content);
        if (viewPager2 != null) {
            Context context = viewPager2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            viewPager2.setAdapter(new TwilioOnboardingAdapter(context, new TwilioIntroductionActivity$setupViewPager$1$1(viewPager2)));
        }
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(R.id.tl_indicator);
        if (tabLayout != null) {
            ViewPager2 viewPager22 = (ViewPager2) _$_findCachedViewById(R.id.vp_content);
            Intrinsics.checkNotNullExpressionValue(viewPager22, "");
            ViewPagerExtKt.getAuthRequestContext(tabLayout, viewPager22, ViewPagerExtKt$attachViewPager$1.INSTANCE);
            Unit unit = Unit.INSTANCE;
        }
    }

    private static void b(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (scheduleImpl[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ NetworkUserEntityData$$ExternalSyntheticLambda2))) ^ c;
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
