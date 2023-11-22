package id.dana.onboarding.splash;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.nfc.NfcAdapter;
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
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegate;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.appshortcut.DanaAppShortcut;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.pin.LogoutContract;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.contract.deeplink.DeepLinkCallback;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.dialog.WarningDialogUtil;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import id.dana.databinding.ActivitySplashBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerLocalConfigSplashComponent;
import id.dana.di.component.LocalConfigSplashComponent;
import id.dana.di.modules.LocalConfigSplashModule;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.ForceUpdateFailDialog;
import id.dana.dialog.LoadingDialog;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.googleassistant.DanaGoogleAssistant;
import id.dana.googleplay.updates.DanaUpdateManager;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import id.dana.model.DeepLinkPayloadModel;
import id.dana.model.ThirdPartyService;
import id.dana.oauth.MatchPhoneNumberDialog;
import id.dana.oauth.OauthConstant;
import id.dana.oauth.OauthLoginManager;
import id.dana.oauth.OauthTargetManager;
import id.dana.onboarding.IntroductionActivity;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.splash.LocalConfigSplashContract;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.rum.Rum;
import id.dana.scanner.handler.ScannerViewType;
import id.dana.statement.StatementActivity;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.utils.BitmapUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.NfcHelper;
import id.dana.utils.OSUtil;
import id.dana.utils.RSAUtil;
import id.dana.utils.VersionUtil;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import net.sqlcipher.database.SQLiteDatabase;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

/* loaded from: classes.dex */
public class LocalConfigSplashActivity extends BaseViewBindingActivity<ActivitySplashBinding> implements LocalConfigSplashContract.View {
    private static char[] A = null;
    private static char[] B = null;
    private static int BottomSheetCardBindingView$watcherCardNumberView$1 = 0;
    private static boolean C = false;
    private static char D = 0;
    public static final String IS_FROM_WIDGET = "IS_FROM_WIDGET";
    public static final String MARKET_DETAILS_DANA_URI = "market://details?id=id.dana";
    private static boolean VerifyPinStateManager$executeRiskChallenge$2$1;
    private boolean DatabaseTableConfigUtil;
    private TwoButtonWithImageDialog FragmentBottomSheetPaymentSettingBinding;
    private MatchPhoneNumberDialog NetworkUserEntityData$$ExternalSyntheticLambda3;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda4;
    private LoadingDialog NetworkUserEntityData$$ExternalSyntheticLambda8;
    private LocalConfigSplashComponent SubSequence;
    private boolean getCallingPid;
    private boolean getSupportButtonTintMode;
    @Inject
    LocationPermissionSubject locationPermissionSubject;
    @Inject
    Lazy<LogoutContract.Presenter> logoutPresenter;
    private boolean lookAheadTest;
    private String readMicros;
    @Inject
    Lazy<DeepLinkContract.Presenter> sessionDeepLinkPresenter;
    @Inject
    Lazy<LocalConfigSplashContract.Presenter> splashPresenter;
    private DanaUpdateManager whenAvailable;
    public static final byte[] $$g = {Ascii.EM, 60, 112, -12, -54, 9, -6, -11, 40, -40, 37, -38, 3, -20, 8, -14, 8, -9, -9, -1, 42, -50, 4, 8, -20, 8, -9, -2, 40, -44, 8, -21, -3, 42, -30, -5, -20, 2, -6, -10, 2, TarHeader.LF_CHR, -57, 0, -16, 10, TarHeader.LF_NORMAL, -66, -15, Ascii.DC4, -10, -6, -3, -10, 66, -74, 9, 56, -56, -21, -1, -4, 2, -1, -12, 10, 1, -21, 70, -24, -53, -1, -4, 2, -1, 40, -42, -6, -3, 37, -36, -18, 16, -11, -6, Ascii.NAK, -20, -22, 1, Ascii.ESC, -22, 1, -21, -3, -64, 2, TarHeader.LF_CHR, -57, 0, -16, 10, TarHeader.LF_NORMAL, -66, -15, 6, -5, 0, 6, -6, -6, 4, TarHeader.LF_BLK, -35, -26, -21, 39, -47, 38, -37, 0, 6, -6, -6, 4, Ascii.FS, -47, 14, -9, -9, 5, -12, -9, 77, -3, -36, -54, 1, 12, -16, 1, 10, -14, 22, -41, 8, -9, 9, 0, -18, 8, 3, Ascii.DC4, -24, -15, 8, -5, 0, 42, 2, TarHeader.LF_CHR, -57, 0, -16, 10, TarHeader.LF_NORMAL, -61, -10, -1, 5, TarHeader.LF_BLK, -29, -42, -1, 5, 14, -16, -4, Ascii.RS, -37, -20, 8, -16, 10, -14, -8, 82, -82, -7, 11, -10, 8, Ascii.RS, -36, -10, 4, -5, 3, -22, 12, 22, -32, -13, -4, 12, -12, 6, -16, 75, -17, 2, TarHeader.LF_CHR, -57, 0, -16, 10, TarHeader.LF_NORMAL, -57, -8, 56, -56, -15, -1, -6, -2, -2, 6, -12, -9, 67, -25, -32, -9, -3, -1, -16, Ascii.ESC, -38, 11, -6, 0, -9, 35, -30, -4, -12, -9, 8, -14, -8, 32, -18, -16, 6, 0, -6, 3, -1, -22, 8, -9, -2, 40, -47, -1, -6, -2, -2, 6, -12, -9, 77, -51, -38, 11, -6, 0, -9, 35, -30, -4, -12, -9, 8, -14, -8, 32, -18, -16, 6, 0, -6, 3, -1, -22, 8, -9, -2, 40, -47, -1, -6, -2, -2, 6, -12, -9, 40, -39, -6, 1, 69, -43, -38, 5, -5, -8, Ascii.EM, -22, -14, -2, -7, 7, -14, 2, -6, -10, 38, -37, 0, -10, 10, 2, -4, -16, 2, TarHeader.LF_CHR, -57, 0, -16, 10, TarHeader.LF_NORMAL, -57, 0, -22, 16, TarHeader.LF_NORMAL, -56, -15, -2, 5, -6, -1, TarHeader.LF_FIFO, -72, 1, -9, 0, 12, -5, TarHeader.LF_BLK, -72, 0, 1, 0, -14, 67, -40, -32, 1, 0, -14, 46, -47, -2, 5, -6, -1, Ascii.US, -44, -9, 8, -14, -8, TarHeader.LF_SYMLINK, -32, -22, 16, 58, -70, -1, -18, Ascii.EM, 35, -29, 7, -34, -16, -3, 6, -16, 44, -47, -2, 5, -6, -1, SignedBytes.MAX_POWER_OF_TWO, -75, 8, -15, 8, -5, 0, TarHeader.LF_LINK, -9, -8, 17, -3, -72, -8, -1, 0, -8, 6, -2, 61, -70, -1, -18, 46, -47, -2, 5, -6, -1, Ascii.NAK, -34, 8, -5, 16, -22, 1, -6, -24, 82, -67, -4, -4, 2, -23, 6, -11, 77, -16, 10, -16};
    public static final int $$h = 249;
    public static final byte[] $$a = {112, -20, -94, -81, -58, 5, -10, -15, 36, -44, 33, -42, -1, -24, 4, -18, 4, -13, -13, -5, 38, -54, 0, 4, -24, 4, -13, -6, 36, -48, 4, -25, -7, 38, -34, -9, -24, -2, -10, -14, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, -35, 4, -9, -9, Ascii.ESC, -51, -5, -10, -6, -6, 2, -16, -13, Ascii.ESC, -26, -21, -9, 2, -15, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 8;
    public static final byte[] getAuthRequestContext = {22, 66, -65, -82, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 90;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private boolean scheduleImpl = false;
    private boolean initRecordTimeStamp = false;
    private boolean getErrorConfigVersion = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
    private boolean GetContactSyncConfig = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
    private boolean newProxyInstance = false;
    private boolean isLayoutRequested = false;
    private final CompositeDisposable NetworkUserEntityData$$ExternalSyntheticLambda1 = new CompositeDisposable();
    private final NfcHelper NetworkUserEntityData$$ExternalSyntheticLambda5 = new NfcHelper();
    private boolean PrepareContext = false;

    static void PlaceComponentResult() {
        A = new char[]{39860, 39849, 39859, 39845, 39846, 39852, 39785, 39842, 39751, 39858, 39856, 39848, 39836, 39744, 39847, 39764, 39843, 39841, 39747, 39855, 39776, 39777, 39857, 39772, 39783, 39775, 39780, 39779, 39781, 39778, 39861, 39774, 39851, 39749};
        C = true;
        VerifyPinStateManager$executeRiskChallenge$2$1 = true;
        BottomSheetCardBindingView$watcherCardNumberView$1 = 909155095;
        D = (char) 42066;
        B = new char[]{37345, 37347, 37354, 37357, 37308, 37293, 37344, 37372, 37288, 37355, 37260, 37365, 37310, 37375, 37367, 37283, 37369, 37294, 37280, 37302, 37281, 37292, 37309, 37366, 37306, 37356, 37359, 37346, 37276, 37268, 37284, 37353, 37358, 37287, 37305, 37262, 37291, 37352, 37371, 37290, 37373, 37368, 37289, 37307, 37374, 37286, 37311, 37269, 37282};
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0021 -> B:23:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.onboarding.splash.LocalConfigSplashActivity.getAuthRequestContext
            int r8 = 106 - r8
            int r6 = r6 + 16
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r8
            r3 = 0
            r8 = r7
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            int r8 = r8 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashActivity.c(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.onboarding.splash.LocalConfigSplashActivity.$$a
            int r6 = 103 - r6
            int r8 = r8 + 20
            int r7 = r7 + 4
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
            goto L2f
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L2f:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            int r7 = r8 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashActivity.g(int, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 126 - r6
            int r8 = r8 * 3
            int r8 = r8 + 36
            int r7 = 333 - r7
            byte[] r0 = id.dana.onboarding.splash.LocalConfigSplashActivity.$$g
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2e
        L16:
            r3 = 0
        L17:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-3)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashActivity.h(int, short, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(null, 127 - (KeyEvent.getMaxKeyCode() >> 16), new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(null, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 127, new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(new char[]{'#', 27, 17, 15, '\b', ')', 21, 16, '#', '(', 28, 0, '(', ')', 2, 23, 13795, 13795, 17, 18, '#', 22, 23, 14, '#', '\b', 15, '#', ')', '%', 18, Typography.amp, 30, 23, '%', JSONLexer.EOI, ',', 21, 20, 7, '#', '0', '%', 17, 0, '\f', 18, '%'}, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 48, (byte) (56 - Drawable.resolveOpacity(0, 0)), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(null, TextUtils.lastIndexOf("", '0') + 128, new byte[]{-98, -125, -102, -101, -97, -118, -101, -103, -101, -103, -96, -104, -104, -96, -98, -98, -96, -101, -96, -118, -101, -117, -103, -107, -98, -103, -118, -118, -102, -100, -125, -118, -99, -99, -125, -102, -117, -104, -97, -106, -98, -106, -101, -125, -101, -105, -99, -99, -100, -101, -101, -125, -107, -104, -118, -125, -102, -103, -104, -105, -125, -106, -107, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(null, 127 - KeyEvent.getDeadChar(0, 0), new byte[]{-104, -107, -107, -105, -106, -104, -107, -96, -107, -105, -101, -99, -117, -118, -104, -105, -97, -127, -103, -102, -100, -101, -105, -102, -102, -106, -96, -97, -102, -99, -125, -96, -118, -96, -105, -105, -102, -104, -105, -96, -98, -127, -97, -99, -125, -100, -117, -127, -96, -103, -98, -101, -101, -102, -102, -102, -100, -99, -96, -104, -97, -117, -101, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(new char[]{29, '/', ',', '/', 11, 18, 13821, 13821, Typography.amp, 15, 14, 18, 1, '*', 29, JSONLexer.EOI, Typography.amp, 18, '*', 22, 18, 3, '*', 1, '\n', 22, 15, 24, '\'', 1, '\n', JSONLexer.EOI, 15, 24, '#', 4, 25, 14, 6, '\r', 18, '-', '0', 3, '0', 17, 11, Typography.dollar, 1, '.', '\r', ')', ')', 5, ')', InputCardNumberView.DIVIDER, ')', 18, '.', 1}, 60 - (ViewConfiguration.getLongPressTimeout() >> 16), (byte) (73 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(new char[]{21, 2, '#', 3, '%', '/'}, Gravity.getAbsoluteGravity(0, 0) + 6, (byte) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 110), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                c(b, (byte) (b | 37), getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                c(getAuthRequestContext[25], getAuthRequestContext[0], getAuthRequestContext[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 54, 4 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        g((byte) (-$$a[54]), $$a[8], $$a[14], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 800, 15 - Color.red(0), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.argb(0, 0, 0, 0), 15 - (Process.myPid() >> 22), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 816, 29 - Drawable.resolveOpacity(0, 0), (char) (57993 - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Drawable.resolveOpacity(0, 0), Color.alpha(0) + 15, (char) (ViewConfiguration.getScrollBarSize() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1718963104, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                c(b2, (byte) (b2 | 37), getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                c(getAuthRequestContext[25], getAuthRequestContext[0], getAuthRequestContext[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 61, 46 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr22 = new Object[1];
                        g($$a[22], (byte) (-$$a[66]), $$a[102], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1718963104, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), 18 - (Process.myPid() >> 22), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                c(b3, (byte) (b3 | 37), getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                c(getAuthRequestContext[25], getAuthRequestContext[0], getAuthRequestContext[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 118, 3 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 38967));
                        Object[] objArr28 = new Object[1];
                        g($$a[22], (byte) (-$$a[66]), $$a[102], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1718963104, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                c(b4, (byte) (b4 | 37), getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                c(getAuthRequestContext[25], getAuthRequestContext[0], getAuthRequestContext[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 107, 3 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr34 = new Object[1];
                        g((byte) ($$b | 20), (byte) 98, (byte) (-$$a[64]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, ExpandableListView.getPackedPositionGroup(0L) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1718963104, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    static /* synthetic */ String access$800(LocalConfigSplashActivity localConfigSplashActivity, Map map) {
        return BuiltInFictitiousFunctionClassFactory(map);
    }

    static {
        PlaceComponentResult();
        AppCompatDelegate.BuiltInFictitiousFunctionClassFactory(true);
    }

    public static Intent createIntentFromDeeplink(Context context, Uri uri) {
        Intent intent = new Intent(context, LocalConfigSplashActivity.class);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268468224);
        return intent;
    }

    public DanaUpdateManager getUpdateManager() {
        DanaUpdateManager danaUpdateManager;
        synchronized (this) {
            if (this.whenAvailable == null) {
                this.whenAvailable = new DanaUpdateManager(this);
            }
            danaUpdateManager = this.whenAvailable;
        }
        return danaUpdateManager;
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onCertificatePinned() {
        this.getSupportButtonTintMode = true;
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onAccountChecking(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
        boolean z2 = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            if (!this.GetContactSyncConfig) {
                this.GetContactSyncConfig = true;
                this.splashPresenter.get().MyBillsEntityDataFactory();
            }
        } else {
            this.getErrorConfigVersion = true;
            if (!this.PrepareContext && !DeepLinkParser.scheduleImpl()) {
                z2 = false;
            }
            BuiltInFictitiousFunctionClassFactory(z2);
            if (MyBillsEntityDataFactory()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        String str;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            if (!this.lookAheadTest || !this.getCallingPid) {
                DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(LoginTrackingConstants.HoldLogin.SUCCESS_TO_HOME, "");
                scheduleImpl();
                return;
            }
            this.sessionDeepLinkPresenter.get().PlaceComponentResult(true);
        } else if (this.newProxyInstance) {
        } else {
            this.newProxyInstance = true;
            if (this.lookAheadTest && (str = this.readMicros) != null) {
                OnboardingActivity.openToResetPin(this, str);
                this.readMicros = null;
                return;
            }
            Intent intent = new Intent(this, IntroductionActivity.class);
            intent.setData(getIntent().getData());
            intent.setFlags(67108864);
            AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding();
            startActivity(intent);
            finish();
        }
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onOptionalAppUpdate() {
        AppReadyMixpanelTracker.getAuthRequestContext();
        DanaUpdateManager updateManager = getUpdateManager();
        DanaUpdateManager.SilentUpdateCallback silentUpdateCallback = new DanaUpdateManager.SilentUpdateCallback() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity.1
            {
                LocalConfigSplashActivity.this = this;
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void MyBillsEntityDataFactory() {
                LocalConfigSplashActivity.this.onNonUpdate();
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void getAuthRequestContext() {
                LocalConfigSplashActivity.access$000(LocalConfigSplashActivity.this);
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                LocalConfigSplashActivity.access$100(LocalConfigSplashActivity.this);
                LocalConfigSplashActivity.access$200(LocalConfigSplashActivity.this);
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void PlaceComponentResult() {
                LocalConfigSplashActivity.access$200(LocalConfigSplashActivity.this);
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void BuiltInFictitiousFunctionClassFactory() {
                LocalConfigSplashActivity.this.onNonUpdate();
            }
        };
        Intrinsics.checkNotNullParameter(silentUpdateCallback, "");
        updateManager.KClassImpl$Data$declaredNonStaticMembers$2(false, silentUpdateCallback);
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onForcedAppUpdate() {
        getUpdateManager().KClassImpl$Data$declaredNonStaticMembers$2(true, new DanaUpdateManager.SilentUpdateCallback() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity.2
            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                DanaUpdateManager.SilentUpdateCallback.CC.PlaceComponentResult();
            }

            {
                LocalConfigSplashActivity.this = this;
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void getAuthRequestContext() {
                LocalConfigSplashActivity.this.splashPresenter.get().getAuthRequestContext("Force", TrackerKey.AppUpdateAction.APP_UPDATE_INSTALL);
                LocalConfigSplashActivity.this.finishAffinity();
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                LocalConfigSplashActivity.access$300(LocalConfigSplashActivity.this);
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void PlaceComponentResult() {
                LocalConfigSplashActivity.this.finishAffinity();
            }

            @Override // id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback
            public final void BuiltInFictitiousFunctionClassFactory() {
                LocalConfigSplashActivity.this.onNonUpdate();
            }
        });
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onNonUpdate() {
        this.scheduleImpl = true;
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onCheckAppFirstLaunch(boolean z) {
        this.PrepareContext = z;
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onNonBlockingSplash(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = z;
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private boolean MyBillsEntityDataFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            return getErrorConfigVersion();
        }
        return getAuthRequestContext();
    }

    private boolean getAuthRequestContext() {
        return this.scheduleImpl && this.getSupportButtonTintMode && this.NetworkUserEntityData$$ExternalSyntheticLambda6 && this.KClassImpl$Data$declaredNonStaticMembers$2 && this.initRecordTimeStamp && this.getErrorConfigVersion;
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onFinishLogout() {
        DeepLinkParser.getAuthRequestContext();
        Intent intent = new Intent(this, OnboardingActivity.class);
        intent.setFlags(268468224);
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding();
        startActivity(intent);
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onCheckSessionDone() {
        BuiltInFictitiousFunctionClassFactory(this.PrepareContext || DeepLinkParser.scheduleImpl());
        this.GetContactSyncConfig = false;
        this.getErrorConfigVersion = true;
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4();
    }

    private boolean getErrorConfigVersion() {
        return this.scheduleImpl && this.KClassImpl$Data$declaredNonStaticMembers$2 && this.initRecordTimeStamp && this.getErrorConfigVersion;
    }

    /* renamed from: lambda$showPhoneDialog$1$id-dana-onboarding-splash-LocalConfigSplashActivity */
    public /* synthetic */ void m2763x119e59a9(DialogInterface dialogInterface) {
        finishAffinity();
    }

    /* renamed from: lambda$showPhoneDialog$2$id-dana-onboarding-splash-LocalConfigSplashActivity */
    public /* synthetic */ void m2764x9ed90b2a(View view) {
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        if (OauthLoginManager.moveToNextValue() != null) {
            OauthTargetManager oauthTargetManager = new OauthTargetManager(BuiltInFictitiousFunctionClassFactory());
            OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
            String MyBillsEntityDataFactory = oauthTargetManager.MyBillsEntityDataFactory(OauthLoginManager.moveToNextValue(), OauthConstant.LocalErrorCode.ACCESS_CANCEL, getString(R.string.cancel_message));
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(MyBillsEntityDataFactory));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                finishAffinity();
                return;
            }
            WarningDialogUtil.MyBillsEntityDataFactory(this, getString(R.string.redirect_not_found));
        }
    }

    /* renamed from: lambda$showPhoneDialog$3$id-dana-onboarding-splash-LocalConfigSplashActivity */
    public /* synthetic */ void m2765x2c13bcab(View view) {
        this.splashPresenter.get().moveToNextValue();
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (this.isLayoutRequested) {
            return;
        }
        this.isLayoutRequested = true;
        boolean z2 = getIntent().getData() != null || z;
        boolean z3 = (getIntent().getFlags() & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) == 1048576;
        if (z2 && !z3) {
            this.lookAheadTest = true;
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            OauthLoginManager.getAuthRequestContext();
            this.sessionDeepLinkPresenter.get().getAuthRequestContext(this);
            return;
        }
        this.initRecordTimeStamp = true;
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private void scheduleImpl() {
        Intent intent = new Intent(this, HomeTabActivity.class);
        intent.setData(getIntent().getData());
        intent.addFlags(1);
        intent.addFlags(67108864);
        if (DeepLinkParser.scheduleImpl()) {
            intent.putExtra("android.nfc.extra.TAG", getIntent());
        }
        if (getIntent().hasExtra("pushNotificationType")) {
            DanaLog.MyBillsEntityDataFactory("LocalConfigSplashActivity", "hasExtra(NotificationData.KEY_PUSH_NOTIFICATION_TYPE)");
            intent.putExtras(getIntent());
        }
        Bundle extras = getIntent().getExtras();
        if (DanaAppShortcut.getAuthRequestContext(extras)) {
            DanaAppShortcut.getAuthRequestContext(intent, extras);
        }
        DanaGoogleAssistant danaGoogleAssistant = DanaGoogleAssistant.INSTANCE;
        if (DanaGoogleAssistant.KClassImpl$Data$declaredNonStaticMembers$2(getIntent())) {
            DanaGoogleAssistant danaGoogleAssistant2 = DanaGoogleAssistant.INSTANCE;
            DanaGoogleAssistant.MyBillsEntityDataFactory(intent, getIntent().getData(), this);
        }
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding();
        startActivity(intent);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getUpdateManager().PlaceComponentResult(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:598:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x031e A[Catch: all -> 0x194c, TryCatch #29 {all -> 0x194c, blocks: (B:596:0x0305, B:600:0x036b, B:599:0x031e), top: B:1082:0x0305 }] */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x04ac A[Catch: Exception -> 0x1945, TRY_LEAVE, TryCatch #42 {Exception -> 0x1945, blocks: (B:627:0x0464, B:629:0x04ac), top: B:1108:0x0464 }] */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:639:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x058d A[Catch: all -> 0x192f, TryCatch #8 {all -> 0x192f, blocks: (B:637:0x056d, B:641:0x05e0, B:640:0x058d), top: B:1040:0x056d }] */
    /* JADX WARN: Removed duplicated region for block: B:647:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0875 A[Catch: Exception -> 0x1921, TRY_LEAVE, TryCatch #23 {Exception -> 0x1921, blocks: (B:678:0x0828, B:680:0x0875), top: B:1070:0x0828 }] */
    /* JADX WARN: Removed duplicated region for block: B:686:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:687:0x08f8  */
    /* JADX WARN: Removed duplicated region for block: B:689:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:691:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:710:0x0b20  */
    /* JADX WARN: Removed duplicated region for block: B:760:0x0cd2 A[Catch: Exception -> 0x191a, TRY_LEAVE, TryCatch #15 {Exception -> 0x191a, blocks: (B:758:0x0c90, B:760:0x0cd2), top: B:1054:0x0c90 }] */
    /* JADX WARN: Removed duplicated region for block: B:766:0x0d43  */
    /* JADX WARN: Removed duplicated region for block: B:768:0x0d57  */
    /* JADX WARN: Removed duplicated region for block: B:770:0x0d5d  */
    /* JADX WARN: Removed duplicated region for block: B:779:0x0eeb  */
    /* JADX WARN: Removed duplicated region for block: B:846:0x1192 A[Catch: Exception -> 0x1912, TRY_LEAVE, TryCatch #32 {Exception -> 0x1912, blocks: (B:844:0x1144, B:846:0x1192), top: B:1088:0x1144 }] */
    /* JADX WARN: Removed duplicated region for block: B:852:0x1202  */
    /* JADX WARN: Removed duplicated region for block: B:853:0x1217  */
    /* JADX WARN: Removed duplicated region for block: B:855:0x121b  */
    /* JADX WARN: Removed duplicated region for block: B:857:0x1221  */
    /* JADX WARN: Removed duplicated region for block: B:872:0x13a1  */
    /* JADX WARN: Removed duplicated region for block: B:918:0x150a  */
    /* JADX WARN: Removed duplicated region for block: B:922:0x1553 A[Catch: Exception -> 0x190c, TRY_LEAVE, TryCatch #24 {Exception -> 0x190c, blocks: (B:920:0x150d, B:922:0x1553), top: B:1072:0x150d }] */
    /* JADX WARN: Removed duplicated region for block: B:928:0x15bc  */
    /* JADX WARN: Removed duplicated region for block: B:930:0x15d0  */
    /* JADX WARN: Removed duplicated region for block: B:932:0x15d6  */
    /* JADX WARN: Removed duplicated region for block: B:947:0x17fd  */
    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r32) {
        /*
            Method dump skipped, instructions count: 6870
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.splash.LocalConfigSplashActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public ActivitySplashBinding inflateViewBinding() {
        return ActivitySplashBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(null, getPackageName().codePointAt(5) + 17, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            char[] cArr = {22, 25, 13922, 13922, ')', 18, '*', Typography.dollar, 13924, 13924, 17, '+', 24, 14, ',', '.', 19, 14};
            try {
                Object[] objArr2 = new Object[1];
                c(getAuthRequestContext[30], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                c(getAuthRequestContext[8], (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[48], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(cArr, ((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, (byte) (super.getResources().getString(R.string.popular_places_desc).substring(32, 34).length() + 120), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, View.resolveSizeAndState(0, 0, 0) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        NfcAdapter nfcAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda5.MyBillsEntityDataFactory;
        if (nfcAdapter != null && nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
        super.onPause();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.MyBillsEntityDataFactory(intent.getAction(), this.NetworkUserEntityData$$ExternalSyntheticLambda1, intent);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        PendingIntent pendingIntent;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(null, 127 - KeyEvent.keyCodeFromString(""), new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            char[] cArr = {22, 25, 13922, 13922, ')', 18, '*', Typography.dollar, 13924, 13924, 17, '+', 24, 14, ',', '.', 19, 14};
            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 18;
            try {
                Object[] objArr2 = new Object[1];
                c(getAuthRequestContext[30], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                c(getAuthRequestContext[8], (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[48], objArr3);
                Object[] objArr4 = new Object[1];
                a(cArr, offsetBefore, (byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 89), objArr4);
                baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 35 - TextUtils.indexOf("", ""), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, 18 - TextUtils.getOffsetAfter("", 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        Rum.CC.getAuthRequestContext().PlaceComponentResult("SplashActivity.onResume");
        NfcHelper nfcHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        NfcAdapter nfcAdapter = nfcHelper.MyBillsEntityDataFactory;
        if (nfcAdapter != null && (pendingIntent = nfcHelper.BuiltInFictitiousFunctionClassFactory) != null && nfcAdapter != null) {
            nfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
        }
        Rum.CC.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory("SplashActivity.onResume");
    }

    /* renamed from: lambda$observerSecurityProviderUpdate$4$id-dana-onboarding-splash-LocalConfigSplashActivity */
    public /* synthetic */ void m2761xce8cc99d(Integer num) throws Exception {
        if (num.intValue() != 0) {
            GoogleApiAvailability.getInstance().showErrorNotification(getApplicationContext(), num.intValue());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private static String BuiltInFictitiousFunctionClassFactory(Map<String, String> map) {
        String str = map.get(BranchLinkConstant.Params.LOGIN_ID);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return RSAUtil.BuiltInFictitiousFunctionClassFactory(str);
        } catch (IllegalArgumentException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("LocalConfigSplashActivity", "Bad Base64 format, possibly the format isn't safe for url", e);
            return null;
        }
    }

    public boolean getIsTaskRoot() {
        if (OSUtil.scheduleImpl()) {
            return isTaskRoot();
        }
        return true;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        MatchPhoneNumberDialog matchPhoneNumberDialog = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (matchPhoneNumberDialog != null) {
            matchPhoneNumberDialog.lpvLoading.setVisibility(0);
            matchPhoneNumberDialog.lpvLoading.startRefresh();
            matchPhoneNumberDialog.btnLogin.setVisibility(8);
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        MatchPhoneNumberDialog matchPhoneNumberDialog = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (matchPhoneNumberDialog != null) {
            matchPhoneNumberDialog.lpvLoading.setVisibility(8);
            matchPhoneNumberDialog.lpvLoading.stopRefresh();
            matchPhoneNumberDialog.btnLogin.setVisibility(0);
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        if (TextUtils.isEmpty(str)) {
            str = ErrorUtil.BuiltInFictitiousFunctionClassFactory(this);
        }
        Toast.makeText(this, str, 0).show();
    }

    /* renamed from: lambda$showPhoneNumberNotEqualsDialog$5$id-dana-onboarding-splash-LocalConfigSplashActivity */
    public /* synthetic */ void m2766x81b9a90e(View view) {
        this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext();
        this.splashPresenter.get().lookAheadTest();
        scheduleImpl();
    }

    /* renamed from: lambda$showPhoneNumberNotEqualsDialog$6$id-dana-onboarding-splash-LocalConfigSplashActivity */
    public /* synthetic */ void m2767xef45a8f(View view) {
        this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext();
        this.logoutPresenter.get().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private String BuiltInFictitiousFunctionClassFactory() {
        try {
            return (String) getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.get("deeplink_scheme");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    static /* synthetic */ void access$000(LocalConfigSplashActivity localConfigSplashActivity) {
        localConfigSplashActivity.scheduleImpl = true;
        if (localConfigSplashActivity.MyBillsEntityDataFactory()) {
            localConfigSplashActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        localConfigSplashActivity.splashPresenter.get().getAuthRequestContext(TrackerKey.AppUpdateType.APP_UPDATE_OPTIONAL, TrackerKey.AppUpdateAction.APP_UPDATE_INSTALL);
    }

    static /* synthetic */ void access$100(LocalConfigSplashActivity localConfigSplashActivity) {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.BuiltInFictitiousFunctionClassFactory(localConfigSplashActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_payment_auth, localConfigSplashActivity.getString(R.string.error_updating_app_toast), "");
    }

    static /* synthetic */ void access$1100(final LocalConfigSplashActivity localConfigSplashActivity) {
        if (localConfigSplashActivity.FragmentBottomSheetPaymentSettingBinding == null) {
            TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = new TwoButtonWithImageDialog.Builder(localConfigSplashActivity).PlaceComponentResult(false).MyBillsEntityDataFactory(false);
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_phone_number_already_registered;
            MyBillsEntityDataFactory.FragmentBottomSheetPaymentSettingBinding = localConfigSplashActivity.getString(R.string.prompt_title_dana_id_is_different);
            MyBillsEntityDataFactory.getErrorConfigVersion = localConfigSplashActivity.getString(R.string.prompt_desc_suggest_to_logout);
            String string = localConfigSplashActivity.getString(R.string.option_cancel);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalConfigSplashActivity.this.m2766x81b9a90e(view);
                }
            };
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string;
            MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener;
            String string2 = localConfigSplashActivity.getString(R.string.logout);
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalConfigSplashActivity.this.m2767xef45a8f(view);
                }
            };
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string2;
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener2;
            localConfigSplashActivity.FragmentBottomSheetPaymentSettingBinding = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        localConfigSplashActivity.FragmentBottomSheetPaymentSettingBinding.MyBillsEntityDataFactory();
    }

    static /* synthetic */ void access$1200(LocalConfigSplashActivity localConfigSplashActivity, String str) {
        try {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter("case", "");
            Intrinsics.checkNotNullParameter("Deeplink Init", "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("case", "Deeplink Init");
            Exception exc = new Exception(str);
            Intrinsics.checkNotNullParameter(exc, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(exc);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void access$200(LocalConfigSplashActivity localConfigSplashActivity) {
        localConfigSplashActivity.scheduleImpl = true;
        if (localConfigSplashActivity.MyBillsEntityDataFactory()) {
            localConfigSplashActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        localConfigSplashActivity.splashPresenter.get().getAuthRequestContext(TrackerKey.AppUpdateType.APP_UPDATE_OPTIONAL, TrackerKey.AppUpdateAction.APP_UPDATE_LATER);
    }

    static /* synthetic */ void access$300(final LocalConfigSplashActivity localConfigSplashActivity) {
        ForceUpdateFailDialog.BuiltInFictitiousFunctionClassFactory(localConfigSplashActivity, new Function1() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalConfigSplashActivity.this.m2762x7cd68a0c((View) obj);
            }
        });
    }

    static /* synthetic */ void access$400(LocalConfigSplashActivity localConfigSplashActivity) {
        LoadingDialog loadingDialog = new LoadingDialog(localConfigSplashActivity);
        localConfigSplashActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = loadingDialog;
        if (loadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing()) {
            return;
        }
        try {
            loadingDialog.BuiltInFictitiousFunctionClassFactory.show();
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void access$500(LocalConfigSplashActivity localConfigSplashActivity) {
        LoadingDialog loadingDialog = localConfigSplashActivity.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (loadingDialog != null && loadingDialog.MyBillsEntityDataFactory()) {
            localConfigSplashActivity.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        localConfigSplashActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
    }

    static /* synthetic */ void access$600(LocalConfigSplashActivity localConfigSplashActivity) {
        OnboardingActivity.open(localConfigSplashActivity);
        localConfigSplashActivity.readMicros = null;
    }

    static /* synthetic */ void access$900(LocalConfigSplashActivity localConfigSplashActivity) {
        localConfigSplashActivity.initRecordTimeStamp = true;
        if (localConfigSplashActivity.MyBillsEntityDataFactory()) {
            localConfigSplashActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        }
        super.finish();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public void init() {
        byte b = 0;
        if (this.SubSequence == null) {
            DaggerLocalConfigSplashComponent.Builder MyBillsEntityDataFactory = DaggerLocalConfigSplashComponent.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) getApplicationContext()).getApplicationComponent());
            MyBillsEntityDataFactory.getAuthRequestContext = (LocalConfigSplashModule) Preconditions.getAuthRequestContext(new LocalConfigSplashModule(this));
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity.4
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionFailed(String str) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                    ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                    ServicesContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onEmptySearchService() {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onFeatureServices(List list) {
                    ServicesContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetInitThirdPartyServices(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetThirdPartyServices(List list) {
                    ServicesContract.View.CC.getAuthRequestContext(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onShowTooltip(boolean z) {
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                {
                    LocalConfigSplashActivity.this = this;
                }
            }));
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new DeepLinkCallback() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity.5
                {
                    LocalConfigSplashActivity.this = this;
                }

                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void getAuthRequestContext() {
                    LocalConfigSplashActivity.this.finishAffinity();
                }

                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void PlaceComponentResult(String str) {
                    if (BranchLinkConstant.DeepLinkErrorCodeView.PHONE_NUMBER_NOT_EQUALS.equals(str)) {
                        LocalConfigSplashActivity.access$1100(LocalConfigSplashActivity.this);
                        return;
                    }
                    LocalConfigSplashActivity.access$1200(LocalConfigSplashActivity.this, str);
                    LocalConfigSplashActivity.this.lookAheadTest = false;
                    LocalConfigSplashActivity.access$900(LocalConfigSplashActivity.this);
                }

                @Override // id.dana.contract.deeplink.DeepLinkCallback
                public final void KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkPayloadModel deepLinkPayloadModel) {
                    boolean z;
                    if (!TextUtils.isEmpty(deepLinkPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2)) {
                        DeeplinkSaveDataManager.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory = deepLinkPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                    LocalConfigSplashActivity localConfigSplashActivity = LocalConfigSplashActivity.this;
                    localConfigSplashActivity.readMicros = LocalConfigSplashActivity.access$800(localConfigSplashActivity, deepLinkPayloadModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
                    OauthLoginManager.KClassImpl$Data$declaredNonStaticMembers$2(deepLinkPayloadModel.moveToNextValue);
                    OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
                    z = OauthLoginManager.MyBillsEntityDataFactory;
                    if (z) {
                        LocalConfigSplashContract.Presenter presenter = LocalConfigSplashActivity.this.splashPresenter.get();
                        OauthLoginManager oauthLoginManager3 = OauthLoginManager.INSTANCE;
                        presenter.getAuthRequestContext(OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda0());
                    } else {
                        LocalConfigSplashActivity.access$900(LocalConfigSplashActivity.this);
                    }
                    LocalConfigSplashActivity.this.getCallingPid = deepLinkPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            };
            MyBillsEntityDataFactory.PlaceComponentResult = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = this;
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = ScannerViewType.FRAGMENT;
            MyBillsEntityDataFactory.getErrorConfigVersion = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
            MyBillsEntityDataFactory.moveToNextValue = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2(), b));
            FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = this;
            MyBillsEntityDataFactory.MyBillsEntityDataFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, b));
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (LogoutModule) Preconditions.getAuthRequestContext(new LogoutModule(new LogoutContract.View() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity.3
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                {
                    LocalConfigSplashActivity.this = this;
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    LocalConfigSplashActivity.access$400(LocalConfigSplashActivity.this);
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void MyBillsEntityDataFactory() {
                    LocalConfigSplashActivity.access$500(LocalConfigSplashActivity.this);
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void PlaceComponentResult() {
                    LocalConfigSplashActivity.this.splashPresenter.get().lookAheadTest();
                    LocalConfigSplashActivity.access$600(LocalConfigSplashActivity.this);
                }
            }));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = this;
            MyBillsEntityDataFactory.scheduleImpl = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, LocalConfigSplashModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getErrorConfigVersion, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.moveToNextValue, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.scheduleImpl, OauthModule.class);
            if (MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, LogoutModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            this.SubSequence = new DaggerLocalConfigSplashComponent.LocalConfigSplashComponentImpl(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.getErrorConfigVersion, MyBillsEntityDataFactory.moveToNextValue, MyBillsEntityDataFactory.MyBillsEntityDataFactory, MyBillsEntityDataFactory.scheduleImpl, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
        this.SubSequence.KClassImpl$Data$declaredNonStaticMembers$2(this);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.KClassImpl$Data$declaredNonStaticMembers$2(this, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (OSUtil.KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.splashPresenter.get().getErrorConfigVersion();
        } else {
            onCertificatePinned();
        }
        this.splashPresenter.get().PlaceComponentResult();
        this.splashPresenter.get().KClassImpl$Data$declaredNonStaticMembers$2();
        ((DanaApplication) getApplicationContext()).chckTmprdApp();
        this.splashPresenter.get().BuiltInFictitiousFunctionClassFactory();
        this.splashPresenter.get().getAuthRequestContext();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(((DanaApplication) getApplicationContext()).getSecurityProviderSubject().subscribe(new Consumer() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LocalConfigSplashActivity.this.m2761xce8cc99d((Integer) obj);
            }
        }));
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if ("android.intent.action.SEND".equals(action) && type != null && type.startsWith("image/")) {
            Bitmap PlaceComponentResult2 = BitmapUtil.PlaceComponentResult((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"), this);
            if (PlaceComponentResult2 != null) {
                if (PlaceComponentResult2.getByteCount() > 11000000) {
                    PlaceComponentResult2 = BitmapUtil.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2, 320000L);
                }
                FileUtil.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2, this);
            }
            this.DatabaseTableConfigUtil = true;
        }
        boolean z = getIntent().getData() != null;
        if (UserInfoManager.instance().getUserInfo() == null) {
            this.splashPresenter.get().scheduleImpl();
        }
        Intent intent2 = getIntent();
        if (!((intent2 == null || !"com.google.android.payments.standard.AUTHENTICATE_V1".equals(intent2.getAction())) ? z : true) && !getIsTaskRoot() && !this.DatabaseTableConfigUtil) {
            finish();
        }
        if (getIntent().getBooleanExtra(IS_FROM_WIDGET, false)) {
            getIntent().getStringExtra(StatementActivity.TAB_MENU_SELECTED);
        }
        if (!OSUtil.GetContactSyncConfig() || LocationUtil.BuiltInFictitiousFunctionClassFactory(this)) {
            LocationPermissionSubject locationPermissionSubject = this.locationPermissionSubject;
            Object obj = locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.get();
            if (!Intrinsics.areEqual((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj), Boolean.TRUE)) {
                locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.TRUE);
            }
        }
        DeepLinkParser.KClassImpl$Data$declaredNonStaticMembers$2(this);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(VersionUtil.BuiltInFictitiousFunctionClassFactory(this));
        this.splashPresenter.get().NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    /* renamed from: lambda$showForceUpdateFailDialog$0$id-dana-onboarding-splash-LocalConfigSplashActivity */
    public /* synthetic */ Unit m2762x7cd68a0c(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(MARKET_DETAILS_DANA_URI));
        if (ContentExtKt.hasActivityHandler(intent, this)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding();
            startActivity(intent);
        }
        finishAffinity();
        return Unit.INSTANCE;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LoadingDialog loadingDialog = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (loadingDialog != null && loadingDialog.MyBillsEntityDataFactory()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        TwoButtonWithImageDialog twoButtonWithImageDialog = this.FragmentBottomSheetPaymentSettingBinding;
        if (twoButtonWithImageDialog != null && twoButtonWithImageDialog.PlaceComponentResult()) {
            this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext();
        }
        this.FragmentBottomSheetPaymentSettingBinding = null;
        Lazy<LocalConfigSplashContract.Presenter> lazy = this.splashPresenter;
        if (lazy != null && lazy.get() != null) {
            this.splashPresenter.get().onDestroy();
        }
        Lazy<DeepLinkContract.Presenter> lazy2 = this.sessionDeepLinkPresenter;
        if (lazy2 != null && lazy2.get() != null) {
            this.sessionDeepLinkPresenter.get().onDestroy();
        }
        Lazy<LogoutContract.Presenter> lazy3 = this.logoutPresenter;
        if (lazy3 != null && lazy3.get() != null) {
            this.logoutPresenter.get().onDestroy();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory();
        super.onDestroy();
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onMatchPhoneNumberFailed() {
        this.initRecordTimeStamp = true;
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.onboarding.splash.LocalConfigSplashContract.View
    public void onMatchPhoneNumberSuccess(boolean z) {
        if (!z) {
            MatchPhoneNumberDialog.Builder builder = new MatchPhoneNumberDialog.Builder(this, new DialogInterface.OnDismissListener() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LocalConfigSplashActivity.this.m2763x119e59a9(dialogInterface);
                }
            });
            builder.MyBillsEntityDataFactory = new View.OnClickListener() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalConfigSplashActivity.this.m2764x9ed90b2a(view);
                }
            };
            builder.getAuthRequestContext = new View.OnClickListener() { // from class: id.dana.onboarding.splash.LocalConfigSplashActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalConfigSplashActivity.this.m2765x2c13bcab(view);
                }
            };
            MatchPhoneNumberDialog matchPhoneNumberDialog = new MatchPhoneNumberDialog(builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.PlaceComponentResult, builder, (byte) 0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = matchPhoneNumberDialog;
            matchPhoneNumberDialog.MyBillsEntityDataFactory();
            return;
        }
        this.initRecordTimeStamp = true;
        if (MyBillsEntityDataFactory()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private static void b(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = A;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ BottomSheetCardBindingView$watcherCardNumberView$1);
        if (VerifyPinStateManager$executeRiskChallenge$2$1) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (C) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }

    private static void a(char[] cArr, int i, byte b, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = B;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ D);
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
