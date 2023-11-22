package id.dana.twilio.identityverification;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
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
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.challenge.pin.LogoutContract;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerTwilioIdentityVerificationComponent;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.TwilioIdentityVerificationModule;
import id.dana.domain.twilio.interactor.IsTwilioForceLogout;
import id.dana.notification.DanaFirebaseMessagingService;
import id.dana.notification.NotificationData;
import id.dana.oauth.OauthConstant;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.pushverify.constant.PushVerifyConstants;
import id.dana.richview.LogoProgressView;
import id.dana.twilio.identityverification.TwilioIdentityVerificationContract;
import id.dana.twilio.trusteddevice.DeviceDetailView;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\bA\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\b\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J`\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\u001b\b\u0002\u0010\u001a\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0018¢\u0006\u0002\b\u0019\u0012\u0004\u0012\u00020\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u0015\u0010\u001b\u001a\u0004\u0018\u00010 *\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010!R\u0016\u0010\b\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010\"R\u0014\u0010\u001e\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%R\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010\u001b\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010\"R\"\u0010,\u001a\u00020+8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u0010\"R\u0016\u0010(\u001a\u0002038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u0010\"R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b8\u0010\"R\"\u0010:\u001a\u0002098\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b@\u0010\""}, d2 = {"Lid/dana/twilio/identityverification/TwilioIdentityVerificationActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", "PlaceComponentResult", IAPSyncCommand.COMMAND_INIT, "", "p0", "", "(Ljava/lang/String;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "p1", "p2", "p3", "p4", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "p5", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Z)V", "getAuthRequestContext", "getErrorConfigVersion", "Ljava/util/Date;", "(Ljava/lang/String;)Ljava/util/Date;", "Ljava/lang/String;", "Ljava/text/SimpleDateFormat;", "lookAheadTest", "Ljava/text/SimpleDateFormat;", "scheduleImpl", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "logoutPresenter", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "getLogoutPresenter", "()Lid/dana/challenge/pin/LogoutContract$Presenter;", "setLogoutPresenter", "(Lid/dana/challenge/pin/LogoutContract$Presenter;)V", "GetContactSyncConfig", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "J", "DatabaseTableConfigUtil", "moveToNextValue", "isLayoutRequested", "Lid/dana/twilio/identityverification/TwilioIdentityVerificationPresenter;", "twilioIdentityVerificationPresenter", "Lid/dana/twilio/identityverification/TwilioIdentityVerificationPresenter;", "getTwilioIdentityVerificationPresenter", "()Lid/dana/twilio/identityverification/TwilioIdentityVerificationPresenter;", "setTwilioIdentityVerificationPresenter", "(Lid/dana/twilio/identityverification/TwilioIdentityVerificationPresenter;)V", "PrepareContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwilioIdentityVerificationActivity extends BaseActivity {
    public static final String CHALLENGE_INFO_DEVICE = "device";
    public static final String CHALLENGE_INFO_LOCATION = "location";
    public static final String CHALLENGE_INFO_MERCHANT_NAME = "merchantName";
    public static final String CHALLENGE_INFO_TIME = "time";
    public static final String CHALLENGE_INFO_TIMEOUT = "timeout";
    public static final String CHALLENGE_INFO_VERIFICATION_TYPE = "verificationType";
    public static final String CHALLENGE_SID = "challengeSid";
    public static final String CHALLENGE_TIMEMILLIS = "timemillis";
    public static final String DATE_FORMAT = "d MMM yyyy HH:mm";
    public static final String FACTOR_SID = "factorSid";
    private static int[] NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
    public static final String VERIFICATION_TYPE_CHANGE_PIN = "change_pin";
    public static final String VERIFICATION_TYPE_IPG_BINDING = "bindingIpg";
    public static final String VERIFICATION_TYPE_LOGIN = "login";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private long NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String lookAheadTest;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String scheduleImpl;
    @Inject
    public LogoutContract.Presenter logoutPresenter;
    @Inject
    public TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter;
    public static final byte[] $$a = {111, -54, 77, -36, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 99;
    public static final byte[] getAuthRequestContext = {116, -27, -60, 115, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 255;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final SimpleDateFormat BuiltInFictitiousFunctionClassFactory = new SimpleDateFormat(TwilioVerifySecurityProductManager.DATE_FORMAT, Locale.ENGLISH);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final SimpleDateFormat MyBillsEntityDataFactory = new SimpleDateFormat(TwilioVerifySecurityProductManager.DATE_FORMAT, LocaleUtil.getAuthRequestContext());

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final SimpleDateFormat getAuthRequestContext = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda8 = new int[]{-692532301, 1230806994, -1346460333, -2085391659, -755885264, -1797932443, -2010497885, -1132589470, 307623396, 1598228252, -282200709, 246775433, 1113792931, -1180765319, 1761379726, 469033586, -1064582434, 1053399084};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 106 - r7
            byte[] r0 = id.dana.twilio.identityverification.TwilioIdentityVerificationActivity.getAuthRequestContext
            int r6 = r6 + 4
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2e
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L2e:
            int r8 = r8 + r7
            int r6 = r6 + 1
            int r7 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity.b(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.twilio.identityverification.TwilioIdentityVerificationActivity.$$a
            int r9 = r9 * 3
            int r9 = r9 + 21
            int r8 = 46 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L17:
            r3 = 0
        L18:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity.c(short, short, byte, java.lang.Object[]):void");
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
        a(19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new int[]{-1577891059, 2138094708, -2047999194, -1170918669, 738939755, 1291943613, 734297624, 577547518, -526592911, 228559283}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a('5' - AndroidCharacter.getMirror('0'), new int[]{-1550180605, -372681889, -412256129, 566646609}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 35 - View.getDefaultSize(0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - KeyEvent.normalizeMetaState(0), new int[]{-1119241905, -1811512996, -655278936, 906539398, 1424787921, 807928350, 234491745, 596948575, -215379753, 1081748256, -211765463, 1863391729, -293654660, -1393497853, 1094299208, 1999276296, 776567354, 1976720551, -620908540, 1110600990, 1096676989, 252682854, 542416267, -1016480438}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(Color.alpha(0) + 64, new int[]{-865055083, -470965735, -1093480603, -1351021995, 44363466, -1684086160, 1769203385, -1249459068, 733823404, 463287045, -5659, 2048235865, 740823854, 1473732069, 1990396441, -2098660248, 173069249, -995350669, -1214705858, -992399028, 1229782003, -1006530628, -1138430489, -103972281, -589770011, -779019578, -364908693, -573208492, -20428630, -19763101, -293143796, 30404851}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(Color.blue(0) + 64, new int[]{-1943742886, 1297530235, 1306165375, 1151135251, 297377113, 805695702, 1504034765, 303429257, 1248980911, -1479274808, 13179348, 1507337866, 277454897, 811618270, 40812345, -1938159771, 946153784, 945243420, -64565271, -1812423157, 603273174, 335019922, -1270318478, 1854119232, -847511486, 258771043, -748271563, 182847305, 1267021774, 685724475, 582465418, -2103907667}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(View.MeasureSpec.getSize(0) + 60, new int[]{248058274, -1846832163, -323631140, -2016307644, 504517892, -1448230683, -815378404, 55809177, 457705016, 891171115, 1173064691, 212311105, -1147937147, -318406339, -2088938876, -267675230, -1851099924, 1411648988, -1715186566, -1189258884, -714010492, 1271967377, 548623668, -1066590379, -1617072404, -2028925438, -2122487625, 1623540551, -1445525948, -1450659805}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6, new int[]{2125818510, 368707625, 1912998974, 707765441}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (PlaceComponentResult & 37);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[35], getAuthRequestContext[7], getAuthRequestContext[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getFadingEdgeLength() >> 16), 3 - TextUtils.indexOf("", ""), (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[53], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 14, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 800, View.MeasureSpec.makeMeasureSpec(0, 0) + 15, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 815, View.MeasureSpec.makeMeasureSpec(0, 0) + 29, (char) (View.resolveSizeAndState(0, 0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 800, TextUtils.getOffsetAfter("", 0) + 15, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r3 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1962222820, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = (byte) (PlaceComponentResult & 37);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                b(b3, b4, b4, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[35], getAuthRequestContext[7], getAuthRequestContext[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 61, 46 - (Process.myTid() >> 22), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        c($$a[9], $$a[84], (byte) ($$a[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1962222820, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (PlaceComponentResult & 37);
                byte b6 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                b(b5, b6, b6, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(getAuthRequestContext[35], getAuthRequestContext[7], getAuthRequestContext[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 119, View.MeasureSpec.getSize(0) + 3, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 38968));
                        Object[] objArr28 = new Object[1];
                        c($$a[9], $$a[84], (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.getDefaultSize(0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1962222820, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), Color.blue(0) + 18, (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (PlaceComponentResult & 37);
                byte b8 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                b(b7, b8, b8, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(getAuthRequestContext[35], getAuthRequestContext[7], getAuthRequestContext[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 3 - TextUtils.indexOf("", "", 0), (char) TextUtils.getOffsetBefore("", 0));
                        byte b9 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b9, b9, $$a[8], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, Color.red(0) + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1962222820, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_twilio_identity_verification;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            b(getAuthRequestContext[25], getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            b((byte) (PlaceComponentResult & 52), getAuthRequestContext[13], getAuthRequestContext[56], new Object[1]);
            Object[] objArr3 = new Object[1];
            a(((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{-1577891059, 2138094708, -2047999194, -1170918669, 738939755, 1291943613, 734297624, 577547518, -526592911, 228559283}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(KeyEvent.getDeadChar(0, 0) + 5, new int[]{-1550180605, -372681889, -412256129, 566646609}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a(26 - KeyEvent.normalizeMetaState(0), new int[]{-1577891059, 2138094708, -2047999194, -1170918669, -1276606941, 1532626069, 1318411725, 1668121646, -37869728, 1003430784, 1952098772, -1757114607, 871600467, 1258379270}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, new int[]{-671101807, -280776178, -275667154, -1727142606, -1280881832, -1936104184, 1454700122, 274240394, 1743419730, -1626738537}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myTid() >> 22), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 47, new int[]{-1119241905, -1811512996, -655278936, 906539398, 1424787921, 807928350, 234491745, 596948575, -215379753, 1081748256, -211765463, 1863391729, -293654660, -1393497853, 1094299208, 1999276296, 776567354, 1976720551, -620908540, 1110600990, 1096676989, 252682854, 542416267, -1016480438}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.deals_online_category_lifestyle_and_other).substring(2, 3).length() + 63, new int[]{-865055083, -470965735, -1093480603, -1351021995, 44363466, -1684086160, 1769203385, -1249459068, 733823404, 463287045, -5659, 2048235865, 740823854, 1473732069, 1990396441, -2098660248, 173069249, -995350669, -1214705858, -992399028, 1229782003, -1006530628, -1138430489, -103972281, -589770011, -779019578, -364908693, -573208492, -20428630, -19763101, -293143796, 30404851}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(TextUtils.lastIndexOf("", '0', 0) + 65, new int[]{-1943742886, 1297530235, 1306165375, 1151135251, 297377113, 805695702, 1504034765, 303429257, 1248980911, -1479274808, 13179348, 1507337866, 277454897, 811618270, 40812345, -1938159771, 946153784, 945243420, -64565271, -1812423157, 603273174, 335019922, -1270318478, 1854119232, -847511486, 258771043, -748271563, 182847305, 1267021774, 685724475, 582465418, -2103907667}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(((byte) KeyEvent.getModifierMetaStateMask()) + 61, new int[]{248058274, -1846832163, -323631140, -2016307644, 504517892, -1448230683, -815378404, 55809177, 457705016, 891171115, 1173064691, 212311105, -1147937147, -318406339, -2088938876, -267675230, -1851099924, 1411648988, -1715186566, -1189258884, -714010492, 1271967377, 548623668, -1066590379, -1617072404, -2028925438, -2122487625, 1623540551, -1445525948, -1450659805}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.os_version).substring(0, 5).codePointAt(4) - 99, new int[]{2125818510, 368707625, 1912998974, 707765441}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (PlaceComponentResult & 37);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls4 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[35], getAuthRequestContext[7], getAuthRequestContext[25], objArr14);
                try {
                    Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - KeyEvent.getDeadChar(0, 0), TextUtils.lastIndexOf("", '0', 0) + 5, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1));
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr16 = new Object[1];
                        c(b3, b3, $$a[8], objArr16);
                        obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                    int i = ((int[]) objArr17[1])[0];
                    if (((int[]) objArr17[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myTid() >> 22), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr18 = {1577330421, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.no_updates_found).substring(25, 27).length() + 24, new int[]{-1577891059, 2138094708, -2047999194, -1170918669, -1276606941, 1532626069, 1318411725, 1668121646, -37869728, 1003430784, 1952098772, -1757114607, 871600467, 1258379270}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.my_bills_delete_bills_dialog_confirmation_title_gn).substring(18, 19).length() + 17, new int[]{-671101807, -280776178, -275667154, -1727142606, -1280881832, -1936104184, 1454700122, 274240394, 1743419730, -1626738537}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 35 - Gravity.getAbsoluteGravity(0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), Color.argb(0, 0, 0, 0) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(1) - 74, new int[]{-1577891059, 2138094708, -2047999194, -1170918669, -1276606941, 1532626069, 1318411725, 1668121646, -37869728, 1003430784, 1952098772, -1757114607, 871600467, 1258379270}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b((byte) (PlaceComponentResult & 52), getAuthRequestContext[13], getAuthRequestContext[56], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{-671101807, -280776178, -275667154, -1727142606, -1280881832, -1936104184, 1454700122, 274240394, 1743419730, -1626738537}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @JvmName(name = "getTwilioIdentityVerificationPresenter")
    public final TwilioIdentityVerificationPresenter getTwilioIdentityVerificationPresenter() {
        TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter = this.twilioIdentityVerificationPresenter;
        if (twilioIdentityVerificationPresenter != null) {
            return twilioIdentityVerificationPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTwilioIdentityVerificationPresenter")
    public final void setTwilioIdentityVerificationPresenter(TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter) {
        Intrinsics.checkNotNullParameter(twilioIdentityVerificationPresenter, "");
        this.twilioIdentityVerificationPresenter = twilioIdentityVerificationPresenter;
    }

    @JvmName(name = "getLogoutPresenter")
    public final LogoutContract.Presenter getLogoutPresenter() {
        LogoutContract.Presenter presenter = this.logoutPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setLogoutPresenter")
    public final void setLogoutPresenter(LogoutContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.logoutPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(R.string.identity_verification));
        setMenuLeftButton(R.drawable.ic_close);
        setMenuLeftButtonOnClick(new View.OnClickListener() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TwilioIdentityVerificationActivity.$r8$lambda$T9U09Ysnb84J0HJp_sp32VHwDP4(TwilioIdentityVerificationActivity.this, view);
            }
        });
    }

    @Override // id.dana.base.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        init();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        if (Intrinsics.areEqual(str, VERIFICATION_TYPE_IPG_BINDING)) {
            getAuthRequestContext();
        } else {
            getErrorConfigVersion();
        }
    }

    private final Date MyBillsEntityDataFactory(String str) {
        Date parse;
        Date date = null;
        try {
            this.BuiltInFictitiousFunctionClassFactory.setTimeZone(TimeZone.getDefault());
            date = this.BuiltInFictitiousFunctionClassFactory.parse(str);
            parse = null;
        } catch (ParseException unused) {
            this.MyBillsEntityDataFactory.setTimeZone(TimeZone.getDefault());
            parse = this.MyBillsEntityDataFactory.parse(str);
        }
        return date == null ? parse : date;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        Intent intent = new Intent(this, HomeTabActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    private final void getAuthRequestContext() {
        String string = getString(R.string.twilio_ipg_deny_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.twilio_ipg_deny_message);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        Object[] objArr = new Object[1];
        String str = this.getErrorConfigVersion;
        if (str == null) {
            str = OauthConstant.BindingType.IPG;
        }
        objArr[0] = str;
        String format = String.format(string2, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        MyBillsEntityDataFactory(string, format, Integer.valueOf((int) R.drawable.ic_twilio_ipg_reject), getString(R.string.twilio_ipg_deny_negative), getString(R.string.twilio_ipg_deny_positive), new Function1<View, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$showRejectAccountLinkingDialog$1
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
                TwilioIdentityVerificationActivity.access$answerTwilioChallenge(TwilioIdentityVerificationActivity.this, false);
            }
        });
    }

    private final void getErrorConfigVersion() {
        String string = getString(R.string.want_to_reject_login_from_other_device);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.twilio_dialog_reject_login_other_device_message);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        MyBillsEntityDataFactory$default(this, string, string2, null, getString(R.string.option_no), getString(R.string.option_yes), new Function1<View, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$showRejectLoginFromOtherDeviceDialog$1
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
                TwilioIdentityVerificationActivity.access$answerTwilioChallenge(TwilioIdentityVerificationActivity.this, false);
            }
        }, 4, null);
    }

    static /* synthetic */ void MyBillsEntityDataFactory$default(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, String str, String str2, Integer num, String str3, String str4, Function1 function1, int i, Object obj) {
        twilioIdentityVerificationActivity.MyBillsEntityDataFactory(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? new Function1<View, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$showConfirmationDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        } : function1);
    }

    private final void MyBillsEntityDataFactory(String p0, String p1, Integer p2, String p3, String p4, Function1<? super View, Unit> p5) {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.SubSequence = p0;
        builder.GetContactSyncConfig = p1;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        if (p2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = p2.intValue();
        }
        if (p3 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(p3, new Function1<View, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$showConfirmationDialog$3$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }
            });
        }
        if (p4 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(p4, p5);
        }
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.Typography);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(p0 ^ true ? 0 : 8);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvConfirmationQuestion);
        if (textView != null) {
            textView.setVisibility(p0 ^ true ? 0 : 8);
        }
        DeviceDetailView deviceDetailView = (DeviceDetailView) _$_findCachedViewById(R.id.res_0x7f0a05b9_flowlivedataconversions_aslivedata_1);
        if (deviceDetailView != null) {
            deviceDetailView.setVisibility(p0 ^ true ? 0 : 8);
        }
        DeviceDetailView deviceDetailView2 = (DeviceDetailView) _$_findCachedViewById(R.id.ddv_location);
        if (deviceDetailView2 != null) {
            deviceDetailView2.setVisibility(p0 ^ true ? 0 : 8);
        }
        DeviceDetailView deviceDetailView3 = (DeviceDetailView) _$_findCachedViewById(R.id.res_0x7f0a05bf_quickbuybillsadapter_onquickbuyitemclicklistener_1);
        if (deviceDetailView3 != null) {
            deviceDetailView3.setVisibility(p0 ^ true ? 0 : 8);
        }
        DeviceDetailView deviceDetailView4 = (DeviceDetailView) _$_findCachedViewById(R.id.ddv_request_type);
        if (deviceDetailView4 != null) {
            deviceDetailView4.setVisibility(p0 ^ true ? 0 : 8);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_auto_logout_message);
        if (textView2 != null) {
            textView2.setVisibility(p0 ^ true ? 0 : 8);
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btnNo);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setVisibility(p0 ^ true ? 0 : 8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.FillAnimation);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(p0 ^ true ? 0 : 8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a043b_daggerloyaltywalletdetailcomponent_loyaltywalletdetailcomponentimpl_accountrepositoryprovider);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(p0 ? 0 : 8);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_bottom_section);
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(p0 ^ true ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean PlaceComponentResult(String p0) {
        String str = this.moveToNextValue;
        if (str != null) {
            SimpleDateFormat simpleDateFormat = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNull(str);
            p0 = simpleDateFormat.format(DateTimeUtil.MyBillsEntityDataFactory(Long.parseLong(str)));
            Intrinsics.checkNotNullExpressionValue(p0, "");
        }
        Date MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory != null) {
            TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter = getTwilioIdentityVerificationPresenter();
            String str2 = this.scheduleImpl;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str2 = null;
            }
            return twilioIdentityVerificationPresenter.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, Integer.parseInt(str2));
        }
        return false;
    }

    public static /* synthetic */ void $r8$lambda$56v3xpt6TkqZcpvRPk2jjl_HxPM(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, View view) {
        Intrinsics.checkNotNullParameter(twilioIdentityVerificationActivity, "");
        twilioIdentityVerificationActivity.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$6H7wq5LBWlqOvXVgl1CyJ5J7FMA(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, View view) {
        Intrinsics.checkNotNullParameter(twilioIdentityVerificationActivity, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.res_0x7f0a043b_daggerloyaltywalletdetailcomponent_loyaltywalletdetailcomponentimpl_accountrepositoryprovider);
        boolean z = false;
        if (constraintLayout != null && constraintLayout.getVisibility() == 0) {
            z = true;
        }
        if (z) {
            twilioIdentityVerificationActivity.finish();
        } else {
            twilioIdentityVerificationActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void $r8$lambda$I1_4xNCiTgqi5s7fJIvLjWjSvDA(final TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, View view) {
        Intrinsics.checkNotNullParameter(twilioIdentityVerificationActivity, "");
        String str = twilioIdentityVerificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        if (Intrinsics.areEqual(str, VERIFICATION_TYPE_IPG_BINDING)) {
            String string = twilioIdentityVerificationActivity.getString(R.string.twilio_ipg_allow_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = twilioIdentityVerificationActivity.getString(R.string.twilio_ipg_allow_message);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            Object[] objArr = new Object[1];
            String str2 = twilioIdentityVerificationActivity.getErrorConfigVersion;
            if (str2 == null) {
                str2 = OauthConstant.BindingType.IPG;
            }
            objArr[0] = str2;
            String format = String.format(string2, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            twilioIdentityVerificationActivity.MyBillsEntityDataFactory(string, format, Integer.valueOf((int) R.drawable.ic_twilio_ipg_accept), twilioIdentityVerificationActivity.getString(R.string.twilio_ipg_allow_negative), twilioIdentityVerificationActivity.getString(R.string.twilio_ipg_allow_positive), new Function1<View, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$showAcceptAccountLinkingDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view2) {
                    Intrinsics.checkNotNullParameter(view2, "");
                    TwilioIdentityVerificationActivity.access$answerTwilioChallenge(TwilioIdentityVerificationActivity.this, true);
                }
            });
            return;
        }
        String string3 = twilioIdentityVerificationActivity.getString(R.string.want_to_use_in_other_device);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = twilioIdentityVerificationActivity.getString(R.string.twilio_dialog_login_from_other_device_message);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        MyBillsEntityDataFactory$default(twilioIdentityVerificationActivity, string3, string4, null, twilioIdentityVerificationActivity.getString(R.string.option_no), twilioIdentityVerificationActivity.getString(R.string.option_yes), new Function1<View, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$showAcceptLoginFromOtherDeviceDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                Intrinsics.checkNotNullParameter(view2, "");
                TwilioIdentityVerificationActivity.access$answerTwilioChallenge(TwilioIdentityVerificationActivity.this, true);
            }
        }, 4, null);
    }

    public static /* synthetic */ void $r8$lambda$R0e6VnBvAgxp6T0BnfqO2BGV8FU(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity) {
        Intrinsics.checkNotNullParameter(twilioIdentityVerificationActivity, "");
        twilioIdentityVerificationActivity.KClassImpl$Data$declaredNonStaticMembers$2(true);
    }

    public static /* synthetic */ void $r8$lambda$T9U09Ysnb84J0HJp_sp32VHwDP4(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, View view) {
        Intrinsics.checkNotNullParameter(twilioIdentityVerificationActivity, "");
        twilioIdentityVerificationActivity.getErrorConfigVersion();
    }

    public static /* synthetic */ void $r8$lambda$X3BxaSuj2GGG8bhmXVJU2ygei5o(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, View view) {
        Intrinsics.checkNotNullParameter(twilioIdentityVerificationActivity, "");
        twilioIdentityVerificationActivity.finish();
    }

    public static final /* synthetic */ void access$answerTwilioChallenge(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, final boolean z) {
        String str;
        String str2;
        String str3 = twilioIdentityVerificationActivity.lookAheadTest;
        String str4 = null;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str3 = null;
        }
        if (!twilioIdentityVerificationActivity.PlaceComponentResult(str3)) {
            String str5 = twilioIdentityVerificationActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str5 = null;
            }
            String str6 = twilioIdentityVerificationActivity.PlaceComponentResult;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str6 = null;
            }
            final TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter = twilioIdentityVerificationActivity.getTwilioIdentityVerificationPresenter();
            String str7 = twilioIdentityVerificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                str4 = str7;
            }
            final String str8 = twilioIdentityVerificationActivity.getErrorConfigVersion;
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str4, "");
            twilioIdentityVerificationPresenter.moveToNextValue.showProgress();
            final String str9 = str4;
            final String str10 = str6;
            twilioIdentityVerificationPresenter.getAuthRequestContext.execute(TwilioIdentityVerificationPresenter.getAuthRequestContext(str5, str6, z), new Function1<Boolean, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z2) {
                    TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter2 = TwilioIdentityVerificationPresenter.this;
                    boolean z3 = z;
                    String str11 = str9;
                    String str12 = str10;
                    String str13 = str8;
                    Intrinsics.checkNotNullParameter(str11, "");
                    Intrinsics.checkNotNullParameter(str12, "");
                    twilioIdentityVerificationPresenter2.PlaceComponentResult.MyBillsEntityDataFactory(Intrinsics.areEqual(str11, TwilioIdentityVerificationActivity.VERIFICATION_TYPE_IPG_BINDING) ? TrackerKey.SourceType.ACCOUNT_LINKING : "Login", str12, z3 ? HttpHeaders.ACCEPT : PushVerifyConstants.REJECT, str13);
                    r0.BuiltInFictitiousFunctionClassFactory.execute(new IsTwilioForceLogout.Param(str9), 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE 
                          (wrap: id.dana.domain.twilio.interactor.IsTwilioForceLogout : 0x0000: IGET (r0v2 id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter) A[WRAPPED] (LINE:1141) id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter.lookAheadTest id.dana.domain.twilio.interactor.IsTwilioForceLogout)
                          (wrap: id.dana.domain.twilio.interactor.IsTwilioForceLogout$Param : 0x0004: CONSTRUCTOR 
                          (wrap: java.lang.String : 0x002f: IGET 
                          (r6v0 'this' id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1 A[IMMUTABLE_TYPE, THIS])
                         A[WRAPPED] id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1.$$verificationType java.lang.String)
                         A[MD:(java.lang.String):void (m), WRAPPED] (LINE:1164) call: id.dana.domain.twilio.interactor.IsTwilioForceLogout.Param.<init>(java.lang.String):void type: CONSTRUCTOR)
                          (wrap: kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> : 0x0009: CONSTRUCTOR 
                          (r0v2 id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter)
                          (r7v0 'z2' boolean)
                          (wrap: boolean : 0x002d: IGET 
                          (r6v0 'this' id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1 A[IMMUTABLE_TYPE, THIS])
                         A[WRAPPED] id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1.$$isUserApprove boolean)
                         A[MD:(id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter, boolean, boolean):void (m), WRAPPED] (LINE:1141) call: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$checkForceLogout$1.<init>(id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter, boolean, boolean):void type: CONSTRUCTOR)
                          (wrap: kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> : 0x0010: CONSTRUCTOR 
                          (wrap: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter : 0x002b: IGET 
                          (r6v0 'this' id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1 A[IMMUTABLE_TYPE, THIS])
                         A[WRAPPED] (LINE:72) id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1.this$0 id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter)
                         A[MD:(id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter):void (m), WRAPPED] (LINE:72) call: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$checkForceLogout$2.<init>(id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter):void type: CONSTRUCTOR)
                         type: VIRTUAL call: id.dana.domain.core.usecase.BaseUseCase.execute(java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void A[MD:(Params, kotlin.jvm.functions.Function1<? super T, kotlin.Unit>, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>):void (m)] (LINE:1141) in method: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1.invoke(boolean):void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                        	at java.base/java.util.ArrayList.forEach(Unknown Source)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$checkForceLogout$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter r0 = id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter.this
                        boolean r1 = r2
                        java.lang.String r2 = r3
                        java.lang.String r3 = r4
                        java.lang.String r4 = r5
                        java.lang.String r5 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
                        id.dana.twilio.tracker.TwilioMixpanelTracker r0 = r0.PlaceComponentResult
                        java.lang.String r5 = "bindingIpg"
                        boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
                        if (r2 == 0) goto L1f
                        java.lang.String r2 = "Account Linking"
                        goto L21
                    L1f:
                        java.lang.String r2 = "Login"
                    L21:
                        if (r1 == 0) goto L26
                        java.lang.String r1 = "Accept"
                        goto L28
                    L26:
                        java.lang.String r1 = "Reject"
                    L28:
                        r0.MyBillsEntityDataFactory(r2, r3, r1, r4)
                        id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter r0 = id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter.this
                        boolean r1 = r2
                        java.lang.String r2 = r3
                        id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter.BuiltInFictitiousFunctionClassFactory(r0, r7, r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$1.invoke(boolean):void");
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$updateChallenge$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    TwilioIdentityVerificationContract.View view;
                    Context context;
                    TwilioIdentityVerificationContract.View view2;
                    Intrinsics.checkNotNullParameter(th, "");
                    TwilioIdentityVerificationPresenter.this.MyBillsEntityDataFactory(z, str9, str10, "Twilio Error", str8);
                    view = TwilioIdentityVerificationPresenter.this.moveToNextValue;
                    context = TwilioIdentityVerificationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view.onError(ErrorUtil.BuiltInFictitiousFunctionClassFactory(context));
                    view2 = TwilioIdentityVerificationPresenter.this.moveToNextValue;
                    view2.dismissProgress();
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_UPDATE_CHALLENGE, th.getMessage(), th);
                }
            });
            return;
        }
        TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter2 = twilioIdentityVerificationActivity.getTwilioIdentityVerificationPresenter();
        String str11 = twilioIdentityVerificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (str11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        } else {
            str = str11;
        }
        String str12 = twilioIdentityVerificationActivity.PlaceComponentResult;
        if (str12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str2 = null;
        } else {
            str2 = str12;
        }
        twilioIdentityVerificationPresenter2.MyBillsEntityDataFactory(z, str, str2, "Client Session Expired", twilioIdentityVerificationActivity.getErrorConfigVersion);
        twilioIdentityVerificationActivity.KClassImpl$Data$declaredNonStaticMembers$2(true);
    }

    public static final /* synthetic */ void access$handleOnUpdateChallengeGeneric(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, boolean z, boolean z2) {
        if (z && z2) {
            twilioIdentityVerificationActivity.getLogoutPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            twilioIdentityVerificationActivity.finish();
        }
    }

    public static final /* synthetic */ void access$handleOnUpdateChallengeIpgBinding(final TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, boolean z, final boolean z2) {
        if (!z) {
            if (z2) {
                twilioIdentityVerificationActivity.getLogoutPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            } else {
                twilioIdentityVerificationActivity.PlaceComponentResult();
                return;
            }
        }
        String string = twilioIdentityVerificationActivity.getString(R.string.twilio_ipg_success_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = twilioIdentityVerificationActivity.getString(R.string.twilio_ipg_success_message);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        MyBillsEntityDataFactory$default(twilioIdentityVerificationActivity, string, string2, Integer.valueOf((int) R.drawable.ic_twilio_ipg_success), null, twilioIdentityVerificationActivity.getString(R.string.twilio_ipg_success_positive), new Function1<View, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$showSuccessAccountLinkingDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (!z2) {
                    twilioIdentityVerificationActivity.PlaceComponentResult();
                } else {
                    twilioIdentityVerificationActivity.getLogoutPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }
        }, 8, null);
    }

    public static final /* synthetic */ void access$initViews(final TwilioIdentityVerificationActivity twilioIdentityVerificationActivity) {
        String string;
        String string2;
        TextView textView = (TextView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.tvConfirmationQuestion);
        String str = null;
        if (textView != null) {
            String str2 = twilioIdentityVerificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str2 = null;
            }
            if (Intrinsics.areEqual(str2, VERIFICATION_TYPE_IPG_BINDING)) {
                string2 = twilioIdentityVerificationActivity.getString(R.string.twilio_identity_verification_confirmation);
            } else {
                string2 = twilioIdentityVerificationActivity.getString(R.string.twilio_identity_verification_change_pin_confirmation);
            }
            textView.setText(string2);
        }
        DeviceDetailView deviceDetailView = (DeviceDetailView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.res_0x7f0a05b9_flowlivedataconversions_aslivedata_1);
        if (deviceDetailView != null) {
            deviceDetailView.showTopDivider(true);
            deviceDetailView.setBottomDividerShortRight(true);
            String string3 = twilioIdentityVerificationActivity.getString(R.string.device_model);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            deviceDetailView.setTitle(string3);
        }
        DeviceDetailView deviceDetailView2 = (DeviceDetailView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.ddv_location);
        if (deviceDetailView2 != null) {
            deviceDetailView2.setBottomDividerShortRight(true);
            String string4 = twilioIdentityVerificationActivity.getString(R.string.location);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            deviceDetailView2.setTitle(string4);
        }
        DeviceDetailView deviceDetailView3 = (DeviceDetailView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.res_0x7f0a05bf_quickbuybillsadapter_onquickbuyitemclicklistener_1);
        if (deviceDetailView3 != null) {
            String string5 = twilioIdentityVerificationActivity.getString(R.string.time_of_request);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            deviceDetailView3.setTitle(string5);
        }
        DeviceDetailView deviceDetailView4 = (DeviceDetailView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.ddv_request_type);
        if (deviceDetailView4 != null) {
            String string6 = twilioIdentityVerificationActivity.getString(R.string.request_type);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            deviceDetailView4.setTitle(string6);
            String str3 = twilioIdentityVerificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str3 = null;
            }
            if (Intrinsics.areEqual(str3, VERIFICATION_TYPE_CHANGE_PIN)) {
                string = twilioIdentityVerificationActivity.getString(R.string.forgot_pin_type);
                Intrinsics.checkNotNullExpressionValue(string, "");
            } else if (Intrinsics.areEqual(str3, VERIFICATION_TYPE_IPG_BINDING)) {
                string = twilioIdentityVerificationActivity.getString(R.string.account_linking_type);
                Intrinsics.checkNotNullExpressionValue(string, "");
            } else {
                string = twilioIdentityVerificationActivity.getString(R.string.login_app_type);
                Intrinsics.checkNotNullExpressionValue(string, "");
            }
            DeviceDetailView.setSubTitle$default(deviceDetailView4, string, null, 2, null);
        }
        TextView textView2 = (TextView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.tv_auto_logout_message);
        if (textView2 != null) {
            TextView textView3 = textView2;
            String str4 = twilioIdentityVerificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                str = str4;
            }
            textView3.setVisibility(Intrinsics.areEqual(str, VERIFICATION_TYPE_IPG_BINDING) ^ true ? 0 : 8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.FillAnimation);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwilioIdentityVerificationActivity.$r8$lambda$I1_4xNCiTgqi5s7fJIvLjWjSvDA(TwilioIdentityVerificationActivity.this, view);
                }
            });
            danaButtonPrimaryView.setVisibility(0);
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.btnNo);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwilioIdentityVerificationActivity.$r8$lambda$56v3xpt6TkqZcpvRPk2jjl_HxPM(TwilioIdentityVerificationActivity.this, view);
                }
            });
            danaButtonSecondaryView.setVisibility(0);
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.res_0x7f0a016d_summaryvoucherview_externalsyntheticlambda0);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwilioIdentityVerificationActivity.$r8$lambda$X3BxaSuj2GGG8bhmXVJU2ygei5o(TwilioIdentityVerificationActivity.this, view);
                }
            });
        }
        twilioIdentityVerificationActivity.setMenuLeftButtonOnClick(new View.OnClickListener() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TwilioIdentityVerificationActivity.$r8$lambda$6H7wq5LBWlqOvXVgl1CyJ5J7FMA(TwilioIdentityVerificationActivity.this, view);
            }
        });
    }

    public static final /* synthetic */ void access$showExpiredViewWhenTimeout(final TwilioIdentityVerificationActivity twilioIdentityVerificationActivity) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Completable MyBillsEntityDataFactory = Completable.MyBillsEntityDataFactory();
        long j = twilioIdentityVerificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(MyBillsEntityDataFactory, j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
        Scheduler MyBillsEntityDataFactory2 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$23 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$22, MyBillsEntityDataFactory2));
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        twilioIdentityVerificationActivity.addDisposable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$23, PlaceComponentResult2)).KClassImpl$Data$declaredNonStaticMembers$2(new Action() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                TwilioIdentityVerificationActivity.$r8$lambda$R0e6VnBvAgxp6T0BnfqO2BGV8FU(TwilioIdentityVerificationActivity.this);
            }
        }));
    }

    public static final /* synthetic */ void access$showOtherDeviceDetail(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, String str, String str2, String str3) {
        DeviceDetailView deviceDetailView = (DeviceDetailView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.res_0x7f0a05b9_flowlivedataconversions_aslivedata_1);
        if (deviceDetailView != null) {
            DeviceDetailView.setSubTitle$default(deviceDetailView, str, null, 2, null);
        }
        DeviceDetailView deviceDetailView2 = (DeviceDetailView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.ddv_location);
        if (deviceDetailView2 != null) {
            if (Intrinsics.areEqual(str2, "unknown")) {
                str2 = deviceDetailView2.getContext().getString(R.string.unknown);
            }
            Intrinsics.checkNotNullExpressionValue(str2, "");
            DeviceDetailView.setSubTitle$default(deviceDetailView2, str2, null, 2, null);
        }
        DeviceDetailView deviceDetailView3 = (DeviceDetailView) twilioIdentityVerificationActivity._$_findCachedViewById(R.id.res_0x7f0a05bf_quickbuybillsadapter_onquickbuyitemclicklistener_1);
        if (deviceDetailView3 != null) {
            DeviceDetailView.setSubTitle$default(deviceDetailView3, str3, null, 2, null);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        Unit unit;
        DaggerTwilioIdentityVerificationComponent.Builder PlaceComponentResult2 = DaggerTwilioIdentityVerificationComponent.PlaceComponentResult();
        PlaceComponentResult2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (TwilioIdentityVerificationModule) Preconditions.getAuthRequestContext(new TwilioIdentityVerificationModule(new TwilioIdentityVerificationContract.View() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$initInjector$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.twilio.identityverification.TwilioIdentityVerificationContract.View
            public final void BuiltInFictitiousFunctionClassFactory(Map<String, String> p0) {
                String str;
                String str2;
                boolean PlaceComponentResult3;
                String str3;
                SimpleDateFormat simpleDateFormat;
                String str4;
                Intrinsics.checkNotNullParameter(p0, "");
                TwilioIdentityVerificationActivity twilioIdentityVerificationActivity = TwilioIdentityVerificationActivity.this;
                twilioIdentityVerificationActivity.lookAheadTest = String.valueOf(p0.get("time"));
                twilioIdentityVerificationActivity.moveToNextValue = p0.get(TwilioIdentityVerificationActivity.CHALLENGE_TIMEMILLIS);
                twilioIdentityVerificationActivity.scheduleImpl = String.valueOf(p0.get(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT));
                twilioIdentityVerificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = String.valueOf(p0.get(TwilioIdentityVerificationActivity.CHALLENGE_INFO_VERIFICATION_TYPE));
                twilioIdentityVerificationActivity.getErrorConfigVersion = p0.get("merchantName");
                String str5 = p0.get("device");
                String str6 = str5 == null || str5.length() == 0 ? "-" : p0.get("device");
                String str7 = p0.get("location");
                String str8 = str7 == null || str7.length() == 0 ? "-" : p0.get("location");
                str = twilioIdentityVerificationActivity.moveToNextValue;
                if (str != null) {
                    simpleDateFormat = twilioIdentityVerificationActivity.BuiltInFictitiousFunctionClassFactory;
                    str4 = twilioIdentityVerificationActivity.moveToNextValue;
                    Intrinsics.checkNotNull(str4);
                    String format = simpleDateFormat.format(DateTimeUtil.MyBillsEntityDataFactory(Long.parseLong(str4)));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    twilioIdentityVerificationActivity.lookAheadTest = format;
                }
                str2 = twilioIdentityVerificationActivity.lookAheadTest;
                String str9 = null;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str2 = null;
                }
                PlaceComponentResult3 = twilioIdentityVerificationActivity.PlaceComponentResult(str2);
                if (PlaceComponentResult3) {
                    twilioIdentityVerificationActivity.KClassImpl$Data$declaredNonStaticMembers$2(true);
                } else {
                    twilioIdentityVerificationActivity.KClassImpl$Data$declaredNonStaticMembers$2(false);
                    Intrinsics.checkNotNull(str6);
                    Intrinsics.checkNotNull(str8);
                    str3 = twilioIdentityVerificationActivity.lookAheadTest;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        str9 = str3;
                    }
                    TwilioIdentityVerificationActivity.access$showOtherDeviceDetail(twilioIdentityVerificationActivity, str6, str8, str9);
                    TwilioIdentityVerificationActivity.access$showExpiredViewWhenTimeout(twilioIdentityVerificationActivity);
                }
                TwilioIdentityVerificationActivity.access$initViews(TwilioIdentityVerificationActivity.this);
            }

            @Override // id.dana.twilio.identityverification.TwilioIdentityVerificationContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, boolean p1, boolean p2) {
                String str;
                if (p0) {
                    str = TwilioIdentityVerificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, TwilioIdentityVerificationActivity.VERIFICATION_TYPE_IPG_BINDING)) {
                        TwilioIdentityVerificationActivity.access$handleOnUpdateChallengeIpgBinding(TwilioIdentityVerificationActivity.this, p2, p1);
                    } else {
                        TwilioIdentityVerificationActivity.access$handleOnUpdateChallengeGeneric(TwilioIdentityVerificationActivity.this, p2, p1);
                    }
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                FrameLayout frameLayout = (FrameLayout) TwilioIdentityVerificationActivity.this._$_findCachedViewById(R.id.res_0x7f0a0757_branch_branchuniversalreferralinitlistener);
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
                LogoProgressView logoProgressView = (LogoProgressView) TwilioIdentityVerificationActivity.this._$_findCachedViewById(R.id.lpv_activity_twillio);
                if (logoProgressView != null) {
                    logoProgressView.startRefresh();
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                FrameLayout frameLayout = (FrameLayout) TwilioIdentityVerificationActivity.this._$_findCachedViewById(R.id.res_0x7f0a0757_branch_branchuniversalreferralinitlistener);
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                LogoProgressView logoProgressView = (LogoProgressView) TwilioIdentityVerificationActivity.this._$_findCachedViewById(R.id.lpv_activity_twillio);
                if (logoProgressView != null) {
                    logoProgressView.stopRefresh();
                }
            }

            @Override // id.dana.twilio.identityverification.TwilioIdentityVerificationContract.View
            public final void BuiltInFictitiousFunctionClassFactory(long p0) {
                TwilioIdentityVerificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
            }
        }));
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (LogoutModule) Preconditions.getAuthRequestContext(new LogoutModule(new LogoutContract.View() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationActivity$initInjector$2
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                FrameLayout frameLayout = (FrameLayout) TwilioIdentityVerificationActivity.this._$_findCachedViewById(R.id.res_0x7f0a0757_branch_branchuniversalreferralinitlistener);
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
                LogoProgressView logoProgressView = (LogoProgressView) TwilioIdentityVerificationActivity.this._$_findCachedViewById(R.id.lpv_activity_twillio);
                if (logoProgressView != null) {
                    logoProgressView.startRefresh();
                }
            }

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void MyBillsEntityDataFactory() {
                FrameLayout frameLayout = (FrameLayout) TwilioIdentityVerificationActivity.this._$_findCachedViewById(R.id.res_0x7f0a0757_branch_branchuniversalreferralinitlistener);
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                LogoProgressView logoProgressView = (LogoProgressView) TwilioIdentityVerificationActivity.this._$_findCachedViewById(R.id.lpv_activity_twillio);
                if (logoProgressView != null) {
                    logoProgressView.stopRefresh();
                }
            }

            @Override // id.dana.challenge.pin.LogoutContract.View
            public final void PlaceComponentResult() {
                DeepLinkParser.getAuthRequestContext();
                OnboardingActivity.Companion companion = OnboardingActivity.INSTANCE;
                OnboardingActivity.Companion.getAuthRequestContext(TwilioIdentityVerificationActivity.this);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, TwilioIdentityVerificationModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, LogoutModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getAuthRequestContext, ApplicationComponent.class);
        new DaggerTwilioIdentityVerificationComponent.TwilioIdentityVerificationComponentImpl(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2.getAuthRequestContext, (byte) 0).MyBillsEntityDataFactory(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            NotificationData notificationData = (NotificationData) extras.getParcelable(DanaFirebaseMessagingService.MESSAGE_DATA);
            String str = null;
            if (notificationData != null) {
                String str2 = notificationData.NetworkUserEntityData$$ExternalSyntheticLambda2;
                Intrinsics.checkNotNullExpressionValue(str2, "");
                this.PlaceComponentResult = str2;
                String str3 = notificationData.GetContactSyncConfig;
                Intrinsics.checkNotNullExpressionValue(str3, "");
                this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                String string = extras.getString(CHALLENGE_SID, "");
                Intrinsics.checkNotNullExpressionValue(string, "");
                this.PlaceComponentResult = string;
                String string2 = extras.getString(FACTOR_SID, "");
                Intrinsics.checkNotNullExpressionValue(string2, "");
                this.KClassImpl$Data$declaredNonStaticMembers$2 = string2;
            }
            String str4 = this.PlaceComponentResult;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str4 = null;
            }
            String str5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                str = str5;
            }
            final TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter = getTwilioIdentityVerificationPresenter();
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str, "");
            twilioIdentityVerificationPresenter.moveToNextValue.showProgress();
            twilioIdentityVerificationPresenter.MyBillsEntityDataFactory.execute(TwilioIdentityVerificationPresenter.MyBillsEntityDataFactory(str4, str), new Function1<Map<String, ? extends String>, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$getChallengeDetails$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                    invoke2((Map<String, String>) map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, String> map) {
                    TwilioIdentityVerificationContract.View view;
                    TwilioIdentityVerificationContract.View view2;
                    Intrinsics.checkNotNullParameter(map, "");
                    view = TwilioIdentityVerificationPresenter.this.moveToNextValue;
                    view.BuiltInFictitiousFunctionClassFactory(map);
                    view2 = TwilioIdentityVerificationPresenter.this.moveToNextValue;
                    view2.dismissProgress();
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.twilio.identityverification.TwilioIdentityVerificationPresenter$getChallengeDetails$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    TwilioIdentityVerificationContract.View view;
                    Context context;
                    TwilioIdentityVerificationContract.View view2;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = TwilioIdentityVerificationPresenter.this.moveToNextValue;
                    context = TwilioIdentityVerificationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view.onError(ErrorUtil.BuiltInFictitiousFunctionClassFactory(context));
                    view2 = TwilioIdentityVerificationPresenter.this.moveToNextValue;
                    view2.dismissProgress();
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_GET_CHALLENGE, th.getMessage(), th);
                }
            });
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda8;
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
        int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda8;
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
