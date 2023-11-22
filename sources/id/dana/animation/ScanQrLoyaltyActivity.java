package id.dana.animation;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.view.ComponentActivity;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherKt;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.Size;
import com.journeyapps.barcodescanner.ViewfinderView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.animation.ScanQrLoyaltyContract;
import id.dana.animation.enums.ScanQrLoyaltyErrorCodeEnum;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.PermissionHelper;
import id.dana.databinding.ActivityScanQrLoyaltyBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerScanQrLoyaltyComponent;
import id.dana.di.modules.ScanQrLoyaltyModule;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.CustomDecoratedBarcodeView;
import id.dana.scanner.ScannerMaterialDialog;
import id.dana.scanner.handler.ScannerActionState;
import id.dana.utils.ImagePicker;
import id.dana.utils.TimerUtil;
import io.reactivex.disposables.Disposable;
import j$.util.Map;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b4\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u001f\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0017\u0010*\u001a\u0006*\u00020'0'X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010\u0016\u001a\u00020+X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b,\u0010)R\"\u0010.\u001a\u00020-8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103"}, d2 = {"Lid/dana/loyalty/ScanQrLoyaltyActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityScanQrLoyaltyBinding;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initViewBinding", "()Lid/dana/databinding/ActivityScanQrLoyaltyBinding;", "onResume", "Lid/dana/loyalty/enums/ScanQrLoyaltyErrorCodeEnum;", "getAuthRequestContext", "(Lid/dana/loyalty/enums/ScanQrLoyaltyErrorCodeEnum;)V", "", "PlaceComponentResult", "(Z)V", "p1", "(Ljava/lang/String;Z)V", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "MyBillsEntityDataFactory", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "lookAheadTest", "Landroidx/activity/result/ActivityResultLauncher;", "DatabaseTableConfigUtil", "Z", "initRecordTimeStamp", "Lid/dana/loyalty/ScanQrLoyaltyContract$Presenter;", "presenter", "Lid/dana/loyalty/ScanQrLoyaltyContract$Presenter;", "getPresenter", "()Lid/dana/loyalty/ScanQrLoyaltyContract$Presenter;", "setPresenter", "(Lid/dana/loyalty/ScanQrLoyaltyContract$Presenter;)V", "Landroid/view/animation/Animation;", "GetContactSyncConfig", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/scanner/ScannerMaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/utils/TimerUtil;", "timerUtil", "Lid/dana/utils/TimerUtil;", "getTimerUtil", "()Lid/dana/utils/TimerUtil;", "setTimerUtil", "(Lid/dana/utils/TimerUtil;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScanQrLoyaltyActivity extends ViewBindingActivity<ActivityScanQrLoyaltyBinding> {
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_NMID = "nmid";
    public static final String KEY_SUCCESS = "success";
    private static int[] NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
    public static final int QR_CODE_NOT_VALID_MIN_LENGTH = 8;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final ActivityPermissionRequest MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> getAuthRequestContext;
    @Inject
    public ScanQrLoyaltyContract.Presenter presenter;
    @Inject
    public TimerUtil timerUtil;
    public static final byte[] $$a = {112, 91, -28, 61, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 64;
    public static final byte[] PlaceComponentResult = {Ascii.EM, -104, -116, 103, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 183;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = new int[]{1589898584, 1327002236, -229113409, 484674858, 421354348, 1681469471, -1746326380, 1850880742, -1803708002, -1453541817, -829406556, -366305466, 1578783661, 742025799, 1953760232, -332194327, -1849865440, 1720355634};
    }

    private static void b(byte b, int i, int i2, Object[] objArr) {
        int i3 = b + 4;
        int i4 = 23 - i2;
        int i5 = 106 - i;
        byte[] bArr = PlaceComponentResult;
        byte[] bArr2 = new byte[i4];
        int i6 = -1;
        int i7 = i4 - 1;
        if (bArr == null) {
            i3++;
            i5 = (i3 + (-i7)) - 4;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
        }
        while (true) {
            int i8 = i5;
            int i9 = i3;
            int i10 = i6 + 1;
            bArr2[i10] = (byte) i8;
            if (i10 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            Object[] objArr2 = objArr;
            int i11 = i7;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i3 = i9 + 1;
            i5 = (i8 + (-bArr[i9])) - 4;
            i7 = i11;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i6 = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0027 -> B:35:0x0029). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = id.dana.animation.ScanQrLoyaltyActivity.$$a
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r5 = 47 - r5
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = 0
            r3 = r6
            r6 = r5
            goto L29
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L27:
            r3 = r0[r5]
        L29:
            int r5 = r5 + 1
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.ScanQrLoyaltyActivity.c(byte, int, int, java.lang.Object[]):void");
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
        a(18 - View.MeasureSpec.getMode(0), new int[]{919681098, 1023307011, 407262152, -833024605, -1717429719, 474804656, -1021739945, 952498155, -1083721041, 1132742655}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((Process.myTid() >> 22) + 5, new int[]{1756728976, -1819280947, 792532969, -2073077356}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 35 - Color.blue(0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 48, new int[]{206066048, -395768037, 1688199321, -2024149517, -1268057622, -179204816, -1881120561, -479158993, -2003656743, 1464364799, 808552699, 1022391924, 1317069345, -1180642680, -1183797775, -1835827490, 751100153, 1441479774, -925923910, -1964302541, -736368614, -310439906, 1525647304, -1427835078}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(63 - TextUtils.lastIndexOf("", '0'), new int[]{-1280954868, -330522723, -2137573493, 1232771426, -175035919, -557796509, -1435584737, -2073271949, 244871770, -402370188, 792124205, -523653800, -1680117015, 1782593574, -607413637, 61899310, -912161927, 1620699261, 1819875521, -1257505471, 34169011, 1327442385, -1882312448, -1575450581, -1350004632, -525852843, -499502221, -580492902, 1663869036, 126910953, 1369924274, 931102588}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - (ViewConfiguration.getTouchSlop() >> 8), new int[]{314925010, -1178387469, 1557842545, 1204825849, 354853009, -905837768, 822947730, -122539382, -1932243138, 1124247641, -2104975975, -1271211534, 1858054141, 887960160, 2082419473, 1398495619, 660201515, -1820449910, 107692335, -1248850198, -858669282, -923072517, -93952492, 712713834, -1360079449, -1921045976, -1094252016, 1873145230, 1352073338, -1255002662, -1472149075, -623001783}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(Color.argb(0, 0, 0, 0) + 60, new int[]{-328470006, 1034250327, 110180010, -1249503272, -501292948, -1773350873, 2051282215, -2113997239, -535435819, -249941471, 1555067767, -1828025788, -78200538, -1449315950, 1955299827, 462806094, 250051269, 1510312810, 1696537467, 1543370327, -1953787849, 249875784, -1252805339, -1564156528, -119393931, 2016801897, -552256020, 2007681035, -1232630706, -1559261320}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(TextUtils.indexOf("", "", 0) + 6, new int[]{15403542, 1855785364, -1995797354, -1565680932}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (getAuthRequestContext & 109), PlaceComponentResult[25], PlaceComponentResult[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 55, TextUtils.lastIndexOf("", '0', 0, 0) + 4, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[78], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 14, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), KeyEvent.normalizeMetaState(0) + 15, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 815, 29 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getCapsMode("", 0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, 35 - View.resolveSizeAndState(0, 0, 0), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1299000615, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (getAuthRequestContext & 109), PlaceComponentResult[25], PlaceComponentResult[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - ExpandableListView.getPackedPositionType(0L), TextUtils.getCapsMode("", 0, 0) + 46, (char) Color.red(0));
                        Object[] objArr22 = new Object[1];
                        c($$a[84], $$a[9], $$a[8], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 35 - TextUtils.indexOf("", "", 0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1299000615, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, View.getDefaultSize(0, 0) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (getAuthRequestContext & 109), PlaceComponentResult[25], PlaceComponentResult[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 118, 4 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 38968));
                        Object[] objArr28 = new Object[1];
                        c($$a[84], $$a[9], $$a[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), View.MeasureSpec.getSize(0) + 35, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1299000615, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (getAuthRequestContext & 109), PlaceComponentResult[25], PlaceComponentResult[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Color.red(0), ExpandableListView.getPackedPositionGroup(0L) + 3, (char) KeyEvent.normalizeMetaState(0));
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
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1299000615, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        Object[] objArr2 = new Object[1];
        a(getPackageName().codePointAt(3) - 82, new int[]{919681098, 1023307011, 407262152, -833024605, -1717429719, 474804656, -1021739945, 952498155, -1083721041, 1132742655}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(5 - (ViewConfiguration.getJumpTapTimeout() >> 16), new int[]{1756728976, -1819280947, 792532969, -2073077356}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr4 = new Object[1];
                    b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    b((byte) (getAuthRequestContext & 124), PlaceComponentResult[48], PlaceComponentResult[41], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{919681098, 1023307011, 407262152, -833024605, -1970743419, -508644124, 852955383, 748554847, 1795690615, -737553736, -986436453, -311194747, 1031488304, -729272446}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.activate).substring(2, 6).codePointAt(0) - 98, new int[]{1365652625, -1807088852, -2115317159, -478004630, -635335599, -2007670541, 1418112881, 1357531215, 1355369505, 157941578}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), TextUtils.indexOf("", "") + 35, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr7 = new Object[1];
                        b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b((byte) (getAuthRequestContext & 124), PlaceComponentResult[48], PlaceComponentResult[41], objArr8);
                        Object[] objArr9 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 15, new int[]{206066048, -395768037, 1688199321, -2024149517, -1268057622, -179204816, -1881120561, -479158993, -2003656743, 1464364799, 808552699, 1022391924, 1317069345, -1180642680, -1183797775, -1835827490, 751100153, 1441479774, -925923910, -1964302541, -736368614, -310439906, 1525647304, -1427835078}, objArr9);
                        String str = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(getPackageName().length() + 57, new int[]{-1280954868, -330522723, -2137573493, 1232771426, -175035919, -557796509, -1435584737, -2073271949, 244871770, -402370188, 792124205, -523653800, -1680117015, 1782593574, -607413637, 61899310, -912161927, 1620699261, 1819875521, -1257505471, 34169011, 1327442385, -1882312448, -1575450581, -1350004632, -525852843, -499502221, -580492902, 1663869036, 126910953, 1369924274, 931102588}, objArr10);
                        String str2 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.mybills_failed_risk_reject).substring(0, 11).codePointAt(3) - 43, new int[]{314925010, -1178387469, 1557842545, 1204825849, 354853009, -905837768, 822947730, -122539382, -1932243138, 1124247641, -2104975975, -1271211534, 1858054141, 887960160, 2082419473, 1398495619, 660201515, -1820449910, 107692335, -1248850198, -858669282, -923072517, -93952492, 712713834, -1360079449, -1921045976, -1094252016, 1873145230, 1352073338, -1255002662, -1472149075, -623001783}, objArr11);
                        String str3 = (String) objArr11[0];
                        try {
                            Object[] objArr12 = new Object[1];
                            b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], objArr12);
                            Class<?> cls5 = Class.forName((String) objArr12[0]);
                            Object[] objArr13 = new Object[1];
                            b((byte) (getAuthRequestContext & 124), PlaceComponentResult[48], PlaceComponentResult[41], objArr13);
                            Object[] objArr14 = new Object[1];
                            a(((ApplicationInfo) cls5.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 27, new int[]{-328470006, 1034250327, 110180010, -1249503272, -501292948, -1773350873, 2051282215, -2113997239, -535435819, -249941471, 1555067767, -1828025788, -78200538, -1449315950, 1955299827, 462806094, 250051269, 1510312810, 1696537467, 1543370327, -1953787849, 249875784, -1252805339, -1564156528, -119393931, 2016801897, -552256020, 2007681035, -1232630706, -1559261320}, objArr14);
                            String str4 = (String) objArr14[0];
                            Object[] objArr15 = new Object[1];
                            a(Process.getGidForName("") + 7, new int[]{15403542, 1855785364, -1995797354, -1565680932}, objArr15);
                            try {
                                Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, 17 - TextUtils.lastIndexOf("", '0'), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr16);
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
            Object[] objArr17 = new Object[1];
            b((byte) (getAuthRequestContext & 109), PlaceComponentResult[25], PlaceComponentResult[30], objArr17);
            Class<?> cls6 = Class.forName((String) objArr17[0]);
            Object[] objArr18 = new Object[1];
            b((byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], PlaceComponentResult[30], objArr18);
            try {
                Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 493, 4 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) TextUtils.indexOf("", "", 0, 0));
                    byte b = (byte) ($$a[78] - 1);
                    byte b2 = b;
                    Object[] objArr20 = new Object[1];
                    c(b, b2, b2, objArr20);
                    obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                int i = ((int[]) objArr21[1])[0];
                if (((int[]) objArr21[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr22 = {1612645132, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr22);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(AndroidCharacter.getMirror('0') - 22, new int[]{919681098, 1023307011, 407262152, -833024605, -1970743419, -508644124, 852955383, 748554847, 1795690615, -737553736, -986436453, -311194747, 1031488304, -729272446}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.detail_referral).substring(0, 7).codePointAt(5) - 90, new int[]{1365652625, -1807088852, -2115317159, -478004630, -635335599, -2007670541, 1418112881, 1357531215, 1355369505, 157941578}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, TextUtils.indexOf("", "", 0) + 35, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    public ScanQrLoyaltyActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$getPermissionCallback$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    ScanQrLoyaltyActivity.this.getBinding().BuiltInFictitiousFunctionClassFactory.resume();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PermissionHelper.BuiltInFictitiousFunctionClassFactory(ScanQrLoyaltyActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Animation>() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$refreshAnimation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final android.view.animation.Animation invoke() {
                android.view.animation.Animation loadAnimation = AnimationUtils.loadAnimation(ScanQrLoyaltyActivity.this, R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
                loadAnimation.setInterpolator(new LinearInterpolator());
                return loadAnimation;
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new ScanQrLoyaltyActivity$scanFailedDialog$2(this));
    }

    @JvmName(name = "getPresenter")
    public final ScanQrLoyaltyContract.Presenter getPresenter() {
        ScanQrLoyaltyContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(ScanQrLoyaltyContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getTimerUtil")
    public final TimerUtil getTimerUtil() {
        TimerUtil timerUtil = this.timerUtil;
        if (timerUtil != null) {
            return timerUtil;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTimerUtil")
    public final void setTimerUtil(TimerUtil timerUtil) {
        Intrinsics.checkNotNullParameter(timerUtil, "");
        this.timerUtil = timerUtil;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityScanQrLoyaltyBinding initViewBinding() {
        ActivityScanQrLoyaltyBinding authRequestContext = ActivityScanQrLoyaltyBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
        DaggerScanQrLoyaltyComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerScanQrLoyaltyComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ScanQrLoyaltyModule) Preconditions.getAuthRequestContext(new ScanQrLoyaltyModule(new ScanQrLoyaltyContract.View() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.loyalty.ScanQrLoyaltyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ScanQrLoyaltyActivity.access$showHideProgressGallery(ScanQrLoyaltyActivity.this, true);
            }

            @Override // id.dana.loyalty.ScanQrLoyaltyContract.View
            public final void MyBillsEntityDataFactory() {
                ActivityScanQrLoyaltyBinding binding;
                ScanQrLoyaltyActivity.this.BuiltInFictitiousFunctionClassFactory = true;
                binding = ScanQrLoyaltyActivity.this.getBinding();
                binding.BuiltInFictitiousFunctionClassFactory.pause();
                ScanQrLoyaltyActivity.access$showDanaLoading(ScanQrLoyaltyActivity.this, true);
            }

            @Override // id.dana.loyalty.ScanQrLoyaltyContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ScanQrLoyaltyActivity.this.getPresenter().BuiltInFictitiousFunctionClassFactory(p0);
            }

            @Override // id.dana.loyalty.ScanQrLoyaltyContract.View
            public final void getAuthRequestContext() {
                ScanQrLoyaltyActivity.access$showHideProgressGallery(ScanQrLoyaltyActivity.this, false);
                ScanQrLoyaltyActivity.this.PlaceComponentResult(false);
                ScannerMaterialDialog access$getScanFailedDialog = ScanQrLoyaltyActivity.access$getScanFailedDialog(ScanQrLoyaltyActivity.this);
                if (access$getScanFailedDialog.getAuthRequestContext.isShowing()) {
                    return;
                }
                access$getScanFailedDialog.getAuthRequestContext.show();
            }

            @Override // id.dana.loyalty.ScanQrLoyaltyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ScanQrLoyaltyActivity.this.BuiltInFictitiousFunctionClassFactory = false;
                ScanQrLoyaltyActivity.this.PlaceComponentResult(false);
                ScanQrLoyaltyActivity.access$initBarcode(ScanQrLoyaltyActivity.this);
                ScanQrLoyaltyActivity.access$handleDecodeResult(ScanQrLoyaltyActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                ScanQrLoyaltyActivity.access$showDanaLoading(ScanQrLoyaltyActivity.this, false);
                ScanQrLoyaltyActivity.access$showHideProgressGallery(ScanQrLoyaltyActivity.this, false);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                ScanQrLoyaltyActivity.this.getAuthRequestContext(ScanQrLoyaltyErrorCodeEnum.GENERAL_ERROR);
                ScanQrLoyaltyActivity.onBack$default(ScanQrLoyaltyActivity.this, false, 1, null);
            }

            @Override // id.dana.loyalty.ScanQrLoyaltyContract.View
            public final void PlaceComponentResult() {
                ScanQrLoyaltyActivity.this.getAuthRequestContext(ScanQrLoyaltyErrorCodeEnum.NO_NMID_FOUND);
                ScanQrLoyaltyActivity.onBack$default(ScanQrLoyaltyActivity.this, false, 1, null);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ScanQrLoyaltyModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ApplicationComponent.class);
        new DaggerScanQrLoyaltyComponent.ScanQrLoyaltyComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, (byte) 0).PlaceComponentResult(this);
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ScanQrLoyaltyActivity.m2663$r8$lambda$WNSxuTqJ7RJi67QOp2HRSlIdL8(ScanQrLoyaltyActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.getAuthRequestContext = registerForActivityResult;
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanQrLoyaltyActivity.$r8$lambda$gEHH8pgLhjXRdXQI0v7s7047ORg(ScanQrLoyaltyActivity.this, view);
            }
        });
        getBinding().initRecordTimeStamp.setOnClickListener(new View.OnClickListener() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanQrLoyaltyActivity.$r8$lambda$ZNF1MARBs6wEv6WoJ40CCmYQzck(ScanQrLoyaltyActivity.this, view);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "");
        OnBackPressedDispatcherKt.PlaceComponentResult(onBackPressedDispatcher, new Function1<OnBackPressedCallback, Unit>() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$setupBackNavigation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback onBackPressedCallback) {
                Intrinsics.checkNotNullParameter(onBackPressedCallback, "");
                ScanQrLoyaltyActivity.access$onBack(ScanQrLoyaltyActivity.this, true);
            }
        });
        getBinding().GetContactSyncConfig.setOnClickListener(new View.OnClickListener() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanQrLoyaltyActivity.$r8$lambda$9SjueUie34a0av7yQ3f5nav7F_8(ScanQrLoyaltyActivity.this, view);
            }
        });
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((ViewConfiguration.getPressedStateDuration() >> 16) + 26, new int[]{919681098, 1023307011, 407262152, -833024605, -1970743419, -508644124, 852955383, 748554847, 1795690615, -737553736, -986436453, -311194747, 1031488304, -729272446}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().length() + 11, new int[]{1365652625, -1807088852, -2115317159, -478004630, -635335599, -2007670541, 1418112881, 1357531215, 1355369505, 157941578}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), 18 - KeyEvent.keyCodeFromString(""), (char) Drawable.resolveOpacity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        getBinding().BuiltInFictitiousFunctionClassFactory.setStatusText("");
        getAuthRequestContext();
        getBinding().BuiltInFictitiousFunctionClassFactory.decodeSingle(new ScanQrLoyaltyActivity$$ExternalSyntheticLambda2(this));
        this.MyBillsEntityDataFactory.check();
    }

    private final String BuiltInFictitiousFunctionClassFactory(String p0) {
        String string;
        if (Intrinsics.areEqual(p0, ScannerActionState.PROCESSING)) {
            string = getString(R.string.processing);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else if (!Intrinsics.areEqual(p0, ScannerActionState.INVALID_QR_CODE)) {
            return "";
        } else {
            string = getString(R.string.invalid_qr_code);
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        return string;
    }

    public final void getAuthRequestContext(ScanQrLoyaltyErrorCodeEnum p0) {
        Intent intent = new Intent();
        intent.putExtra("success", false);
        intent.putExtra("errorCode", p0.getErrorCode());
        setResult(-1, intent);
    }

    private final void PlaceComponentResult(String p0, boolean p1) {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = getBinding().BuiltInFictitiousFunctionClassFactory;
        customDecoratedBarcodeView.clearBubbleView();
        customDecoratedBarcodeView.setBubbleStatusText(p0);
        customDecoratedBarcodeView.setPlaceholderShow(p1);
        if ((p0.length() > 0) && !p1) {
            customDecoratedBarcodeView.showBubbleText();
        }
        getBinding().BuiltInFictitiousFunctionClassFactory.setVisibilityToastText(false);
        getBinding().BuiltInFictitiousFunctionClassFactory.setVisibilityQrisStampWithPlaceholder(false, false);
    }

    public final void PlaceComponentResult(boolean p0) {
        ImageView imageView = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(p0 ? 0 : 8);
        CustomDecoratedBarcodeView customDecoratedBarcodeView = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(customDecoratedBarcodeView, "");
        customDecoratedBarcodeView.setVisibility(p0 ^ true ? 0 : 8);
    }

    private final void getAuthRequestContext() {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = getBinding().BuiltInFictitiousFunctionClassFactory;
        ViewfinderView viewFinderView = customDecoratedBarcodeView.getViewFinderView();
        if (viewFinderView != null) {
            viewFinderView.setMaskColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(customDecoratedBarcodeView.getContext(), R.color.res_0x7f060353_networkuserentitydata_externalsyntheticlambda0));
        }
        customDecoratedBarcodeView.setFramingRect(new Size(customDecoratedBarcodeView.getResources().getDisplayMetrics().widthPixels, customDecoratedBarcodeView.getResources().getDisplayMetrics().heightPixels));
    }

    public static /* synthetic */ void $r8$lambda$9SjueUie34a0av7yQ3f5nav7F_8(ScanQrLoyaltyActivity scanQrLoyaltyActivity, View view) {
        Intrinsics.checkNotNullParameter(scanQrLoyaltyActivity, "");
        scanQrLoyaltyActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: $r8$lambda$FdXIWf-2z_oskfI9DM_Wccnhd5c */
    public static /* synthetic */ void m2662$r8$lambda$FdXIWf2z_oskfI9DM_Wccnhd5c(ScanQrLoyaltyActivity scanQrLoyaltyActivity, BarcodeResult barcodeResult) {
        Intrinsics.checkNotNullParameter(scanQrLoyaltyActivity, "");
        if (barcodeResult.getAuthRequestContext().length() > 8) {
            String authRequestContext = barcodeResult.getAuthRequestContext();
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            if (scanQrLoyaltyActivity.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            scanQrLoyaltyActivity.getPresenter().BuiltInFictitiousFunctionClassFactory(authRequestContext);
            return;
        }
        Group group = scanQrLoyaltyActivity.getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(8);
    }

    public static /* synthetic */ void $r8$lambda$McVtEjxSM1TF6JruZcdkDeJPLiQ(ScanQrLoyaltyActivity scanQrLoyaltyActivity) {
        Intrinsics.checkNotNullParameter(scanQrLoyaltyActivity, "");
        scanQrLoyaltyActivity.PlaceComponentResult(false);
        scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setVisibilityToastText(false);
        scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setVisibilityQrisStampWithPlaceholder(false, false);
        if (!scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.isBubbleQrisSupportedVisible()) {
            scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setVisibilityQrisSupportedStamp(true, false);
        }
        TimerUtil timerUtil = scanQrLoyaltyActivity.getTimerUtil();
        Disposable disposable = timerUtil.BuiltInFictitiousFunctionClassFactory;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        timerUtil.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    /* renamed from: $r8$lambda$WNSxuTqJ7RJi67QOp2HRSl-IdL8 */
    public static /* synthetic */ void m2663$r8$lambda$WNSxuTqJ7RJi67QOp2HRSlIdL8(ScanQrLoyaltyActivity scanQrLoyaltyActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(scanQrLoyaltyActivity, "");
        Intent intent = activityResult.MyBillsEntityDataFactory;
        if (intent != null) {
            final Uri data = intent.getData();
            scanQrLoyaltyActivity.PlaceComponentResult(true);
            if (data == null) {
                scanQrLoyaltyActivity.getAuthRequestContext(ScanQrLoyaltyErrorCodeEnum.GENERAL_ERROR);
            } else {
                GlideApp.PlaceComponentResult(scanQrLoyaltyActivity).MyBillsEntityDataFactory(data).PlaceComponentResult((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).PlaceComponentResult(new RequestListener<Drawable>() { // from class: id.dana.loyalty.ScanQrLoyaltyActivity$loadImageFromUri$1
                    @Override // com.bumptech.glide.request.RequestListener
                    public final boolean onLoadFailed(GlideException p0, Object p1, Target<Drawable> p2, boolean p3) {
                        Intrinsics.checkNotNullParameter(p1, "");
                        Intrinsics.checkNotNullParameter(p2, "");
                        return false;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public final /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                        return getAuthRequestContext(obj, target, dataSource);
                    }

                    private boolean getAuthRequestContext(Object obj, Target<Drawable> target, DataSource dataSource) {
                        ActivityScanQrLoyaltyBinding binding;
                        ActivityScanQrLoyaltyBinding binding2;
                        Intrinsics.checkNotNullParameter(obj, "");
                        Intrinsics.checkNotNullParameter(target, "");
                        Intrinsics.checkNotNullParameter(dataSource, "");
                        ScanQrLoyaltyActivity.access$showHideProgressGallery(ScanQrLoyaltyActivity.this, true);
                        ScanQrLoyaltyContract.Presenter presenter = ScanQrLoyaltyActivity.this.getPresenter();
                        Uri uri = data;
                        binding = ScanQrLoyaltyActivity.this.getBinding();
                        int measuredWidth = binding.BuiltInFictitiousFunctionClassFactory.getMeasuredWidth();
                        binding2 = ScanQrLoyaltyActivity.this.getBinding();
                        presenter.MyBillsEntityDataFactory(uri, measuredWidth, binding2.BuiltInFictitiousFunctionClassFactory.getMeasuredHeight());
                        return false;
                    }
                }).MyBillsEntityDataFactory(scanQrLoyaltyActivity.getBinding().moveToNextValue);
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$ZNF1MARBs6wEv6WoJ40CCmYQzck(ScanQrLoyaltyActivity scanQrLoyaltyActivity, View view) {
        Intrinsics.checkNotNullParameter(scanQrLoyaltyActivity, "");
        ActivityResultLauncher<Intent> activityResultLauncher = scanQrLoyaltyActivity.getAuthRequestContext;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        activityResultLauncher.MyBillsEntityDataFactory(ImagePicker.getAuthRequestContext(), null);
    }

    public static /* synthetic */ void $r8$lambda$gEHH8pgLhjXRdXQI0v7s7047ORg(ScanQrLoyaltyActivity scanQrLoyaltyActivity, View view) {
        Intrinsics.checkNotNullParameter(scanQrLoyaltyActivity, "");
        if (scanQrLoyaltyActivity.PlaceComponentResult) {
            scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setTorchOff();
        } else {
            scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setTorchOn();
        }
        scanQrLoyaltyActivity.PlaceComponentResult = !scanQrLoyaltyActivity.PlaceComponentResult;
    }

    public static final /* synthetic */ ScannerMaterialDialog access$getScanFailedDialog(ScanQrLoyaltyActivity scanQrLoyaltyActivity) {
        return (ScannerMaterialDialog) scanQrLoyaltyActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
    }

    public static final /* synthetic */ void access$handleDecodeResult(ScanQrLoyaltyActivity scanQrLoyaltyActivity, Map map) {
        String str = (String) Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, "5102", "");
        if (!(str.length() > 0)) {
            scanQrLoyaltyActivity.getAuthRequestContext(ScanQrLoyaltyErrorCodeEnum.NO_NMID_FOUND);
        } else {
            Intent intent = new Intent();
            intent.putExtra("success", true);
            intent.putExtra(KEY_NMID, str);
            scanQrLoyaltyActivity.setResult(-1, intent);
        }
        onBack$default(scanQrLoyaltyActivity, false, 1, null);
    }

    public static final /* synthetic */ void access$initBarcode(ScanQrLoyaltyActivity scanQrLoyaltyActivity) {
        scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setStatusText("");
        scanQrLoyaltyActivity.getAuthRequestContext();
        scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.decodeSingle(new ScanQrLoyaltyActivity$$ExternalSyntheticLambda2(scanQrLoyaltyActivity));
        scanQrLoyaltyActivity.MyBillsEntityDataFactory.check();
    }

    public static final /* synthetic */ void access$onBack(ScanQrLoyaltyActivity scanQrLoyaltyActivity, boolean z) {
        if (scanQrLoyaltyActivity.PlaceComponentResult) {
            scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setTorchOff();
            scanQrLoyaltyActivity.PlaceComponentResult = false;
        }
        scanQrLoyaltyActivity.BuiltInFictitiousFunctionClassFactory = false;
        if (z) {
            scanQrLoyaltyActivity.getAuthRequestContext(ScanQrLoyaltyErrorCodeEnum.CANCEL_TO_SCAN_ERROR);
        }
        scanQrLoyaltyActivity.finish();
    }

    public static final /* synthetic */ void access$showDanaLoading(ScanQrLoyaltyActivity scanQrLoyaltyActivity, boolean z) {
        if (z) {
            scanQrLoyaltyActivity.getBinding().MyBillsEntityDataFactory.startAnimation((Animation) scanQrLoyaltyActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
        }
        Group group = scanQrLoyaltyActivity.getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(z ? 0 : 8);
    }

    public static final /* synthetic */ void access$showHideProgressGallery(ScanQrLoyaltyActivity scanQrLoyaltyActivity, boolean z) {
        if (z) {
            scanQrLoyaltyActivity.PlaceComponentResult(scanQrLoyaltyActivity.BuiltInFictitiousFunctionClassFactory(ScannerActionState.PROCESSING), true);
            TimerUtil timerUtil = scanQrLoyaltyActivity.getTimerUtil();
            Disposable disposable = timerUtil.BuiltInFictitiousFunctionClassFactory;
            if (disposable != null && !disposable.isDisposed()) {
                timerUtil.BuiltInFictitiousFunctionClassFactory.dispose();
            }
            scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setVisibilityToastText(true);
            return;
        }
        scanQrLoyaltyActivity.PlaceComponentResult(scanQrLoyaltyActivity.BuiltInFictitiousFunctionClassFactory(ScannerActionState.IDLE), false);
        TimerUtil timerUtil2 = scanQrLoyaltyActivity.getTimerUtil();
        Disposable disposable2 = timerUtil2.BuiltInFictitiousFunctionClassFactory;
        if (disposable2 != null && !disposable2.isDisposed()) {
            timerUtil2.BuiltInFictitiousFunctionClassFactory.dispose();
        }
        scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setVisibilityToastText(true);
    }

    public static /* synthetic */ void onBack$default(ScanQrLoyaltyActivity scanQrLoyaltyActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (scanQrLoyaltyActivity.PlaceComponentResult) {
            scanQrLoyaltyActivity.getBinding().BuiltInFictitiousFunctionClassFactory.setTorchOff();
            scanQrLoyaltyActivity.PlaceComponentResult = false;
        }
        scanQrLoyaltyActivity.BuiltInFictitiousFunctionClassFactory = false;
        if (z) {
            scanQrLoyaltyActivity.getAuthRequestContext(ScanQrLoyaltyErrorCodeEnum.CANCEL_TO_SCAN_ERROR);
        }
        scanQrLoyaltyActivity.finish();
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
