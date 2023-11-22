package id.dana.onboarding.verify;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.IPEnvironment;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.BuildConfig;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.performanceduration.DanaPerformanceDurationTracker;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.KeyBaseFragment;
import id.dana.base.MenuItemButtonListener;
import id.dana.base.ThrottledOnClickListener;
import id.dana.biometric.domain.model.RiskActionConstant;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengePinWithFaceActivity;
import id.dana.challenge.ChallengeScenario;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.otp.WhatsAppOtpReceiver;
import id.dana.challenge.pin.LogoutContract;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.permission.PermissionStateContract;
import id.dana.contract.permission.PermissionStateModule;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.dialog.DanaLoadingDialogFragment;
import id.dana.core.ui.richview.InputPhoneView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.DanaH5;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.FragmentVerifyNumberBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerVerifyNumberComponent;
import id.dana.di.component.VerifyNumberComponent;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.VerifyNumberModule;
import id.dana.dialog.DialogWithImage;
import id.dana.dialog.LoginInfoDialog;
import id.dana.dialog.RiskRejectDialog;
import id.dana.domain.featureconfig.model.LinkInfo;
import id.dana.domain.featureconfig.model.OnboardingWarningTextConfig;
import id.dana.domain.model.VerificationTreeNode;
import id.dana.domain.model.rpc.response.LoginAuthenticationOptionResponse;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.domain.registration.CheckUserAction;
import id.dana.domain.registration.model.CheckRegistrationRequest;
import id.dana.extension.view.InputExtKt;
import id.dana.model.FaceAuthenticationModel;
import id.dana.model.LoginAuthenticationMethod;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.oauth.OauthLoginManager;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.bottomsheet.DanaConfirmationBottomSheetDialog;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity;
import id.dana.onboarding.createpin.CreatePinKey;
import id.dana.onboarding.referral.VerifyReferralCodeKey;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.onboarding.verify.VerifyNumberContract;
import id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment;
import id.dana.onboarding.verify.locationpermission.OnboardingLocationPermissionFragment;
import id.dana.onboarding.verify.locationpermission.OnboardingLocationPermissionListener;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.richview.socialshare.AppPackageName;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.textbehavior.InvalidReason;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.rds.RDSConstant;
import id.dana.tracker.rds.RDSEvent;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.NoUnderlineClickableSpan;
import id.dana.utils.OSUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.StringWrapper;
import id.dana.utils.UrlUtil;
import id.dana.utils.ViewHelper;
import id.dana.utils.android.AppUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import id.dana.utils.permission.PermissionHelper;
import id.dana.utils.showcase.Utils;
import id.dana.webview.WebViewActivity;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ~2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0002\u007f~B\u0007¢\u0006\u0004\b}\u0010\u000fJ!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u000fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\r\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u000fJ\u000f\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010\u000fJ\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\u000fJ\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\u000fJ\u001f\u0010'\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020%2\u0006\u0010\t\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010\u000fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\r\u0010+J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010,R\u0018\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-X\u0087\"¢\u0006\u0006\n\u0004\b/\u00100R\u0013\u0010\r\u001a\u000201X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b*\u00102R\u0016\u0010\u0015\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u00103R\u0013\u0010\u0016\u001a\u000204X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b5\u00102R\u0016\u0010\u000b\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u00103R\u0018\u00108\u001a\b\u0012\u0004\u0012\u0002070-X\u0087\"¢\u0006\u0006\n\u0004\b8\u00100R\u0018\u0010:\u001a\b\u0012\u0004\u0012\u0002090-X\u0087\"¢\u0006\u0006\n\u0004\b:\u00100R\u0013\u0010\u0019\u001a\u00020;X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b<\u00102R\u0018\u0010\"\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u00106\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b@\u00103R\u0013\u0010*\u001a\u00020AX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bB\u00102R\u0016\u0010D\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u00103R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bG\u00103R\u0016\u0010B\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u00103R\u0016\u0010@\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u00103R\u0016\u0010>\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u00103R\u0016\u0010<\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u00103R\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020L0-X\u0087\"¢\u0006\u0006\n\u0004\bM\u00100R\u0018\u0010I\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0-X\u0087\"¢\u0006\u0006\n\u0004\bR\u00100R\u0016\u0010E\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u00103R\u0016\u0010G\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bT\u00103R\u0016\u0010J\u001a\u00020U8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010H\u001a\u00020X8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010T\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b[\u0010FR\u0014\u0010S\u001a\u0004\u0018\u00010\\X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010]R\u0018\u0010_\u001a\b\u0012\u0004\u0012\u00020^0-X\u0087\"¢\u0006\u0006\n\u0004\b_\u00100R\u0016\u0010V\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010FR\u0014\u0010K\u001a\u00020a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010O\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010[\u001a\u00020g8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010Y\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bj\u0010FR\u0016\u0010b\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bk\u00103R\u0016\u0010e\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u00103R\u0016\u0010`\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010FR\u0018\u0010o\u001a\b\u0012\u0004\u0012\u00020n0-X\u0087\"¢\u0006\u0006\n\u0004\bo\u00100R\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bp\u0010FR\u0018\u0010j\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010h\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bt\u00103R\u0016\u0010k\u001a\u00020u8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010y\u001a\b\u0012\u0004\u0012\u00020x0-X\u0087\"¢\u0006\u0006\n\u0004\by\u00100R\u0018\u0010l\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b{\u0010|"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/verify/VerifyNumberKey;", "Lid/dana/databinding/FragmentVerifyNumberBinding;", "Landroid/view/View$OnTouchListener;", "", "p0", "Landroid/os/Bundle;", "p1", "", "PlaceComponentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "MyBillsEntityDataFactory", "(Landroid/os/Bundle;)V", "()V", "Landroid/content/Intent;", "(Landroid/content/Intent;)Ljava/lang/String;", "", "getLayout", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", IAPSyncCommand.COMMAND_INIT, "", "BuiltInFictitiousFunctionClassFactory", "()Z", "p2", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/Context;", "onAttach", "(Landroid/content/Context;)V", "onDestroy", "NetworkUserEntityData$$ExternalSyntheticLambda0", "onResume", "onStart", "Landroid/view/View;", "Landroid/view/MotionEvent;", RiskActionConstant.ON_TOUCH, "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "onUnSelected", "getErrorConfigVersion", "(I)V", "(Ljava/lang/String;)V", "Ldagger/Lazy;", "Lid/dana/challenge/botprotection/BotProtectionChallenge;", "botProtectionChallenge", "Ldagger/Lazy;", "Lid/dana/onboarding/bottomsheet/DanaConfirmationBottomSheetDialog;", "Lkotlin/Lazy;", "Z", "Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "lookAheadTest", "scheduleImpl", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "initRecordTimeStamp", "Lid/dana/model/FaceAuthenticationModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/model/FaceAuthenticationModel;", "DatabaseTableConfigUtil", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/lang/String;", "newProxyInstance", "PrepareContext", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/toggle/locationpermission/LocationPermissionSubject;", "locationPermissionSubject", "Lid/dana/dialog/LoginInfoDialog;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/dialog/LoginInfoDialog;", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "logoutPresenter", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionListener;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionListener;", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "getCallingPid", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "whenAvailable", "Lid/dana/onboarding/verify/VerifyNumberFragment$ChallengeListener;", "Lid/dana/onboarding/verify/VerifyNumberFragment$ChallengeListener;", "Lid/dana/contract/permission/PermissionStateContract$Presenter;", "permissionStatePresenter", "SubSequence", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "readMicros", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "Lid/dana/onboarding/verify/VerifyNumberTextWatcher;", "getSupportButtonTintMode", "Lid/dana/onboarding/verify/VerifyNumberTextWatcher;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", DiskFormatter.B, "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "A", "BottomSheetCardBindingView$watcherCardNumberView$1", "C", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/dialog/RiskRejectDialog;", "riskRejectDialog", SummaryActivity.DAYS, "Lid/dana/model/Trust2RiskLoginModel;", "E", "Lid/dana/model/Trust2RiskLoginModel;", "getValueOfTouchPositionAbsolute", "Lid/dana/di/component/VerifyNumberComponent;", "getOnBoardingScenario", "Lid/dana/di/component/VerifyNumberComponent;", "Lid/dana/onboarding/verify/VerifyNumberContract$Presenter;", "verifyPresenter", "Lid/dana/domain/featureconfig/model/OnboardingWarningTextConfig;", "VerifyPinStateManager$executeRiskChallenge$2$2", "Lid/dana/domain/featureconfig/model/OnboardingWarningTextConfig;", "<init>", "Companion", "ChallengeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyNumberFragment extends KeyBaseFragment<OnboardingActivity, VerifyNumberKey, FragmentVerifyNumberBinding> implements View.OnTouchListener {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String moveToNextValue = Reflection.getOrCreateKotlinClass(VerifyNumberFragment.class).getSimpleName();

    /* renamed from: B */
    private FragmentPermissionRequest whenAvailable;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private boolean readMicros;

    /* renamed from: C  reason: from kotlin metadata */
    private boolean getSupportButtonTintMode;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: E  reason: from kotlin metadata */
    private Trust2RiskLoginModel A;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private LoginInfoDialog isLayoutRequested;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private FaceAuthenticationModel NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private OnboardingLocationPermissionListener NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public ChallengeListener NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private OnboardingWarningTextConfig C;
    @Inject
    public Lazy<BotProtectionChallenge> botProtectionChallenge;
    @Inject
    public Lazy<DeviceInformationProvider> deviceInformationProvider;
    @Inject
    public Lazy<DynamicUrlWrapper> dynamicUrlWrapper;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private OnboardingNavigationManagerWithMenu PrepareContext;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private VerifyNumberComponent BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private VerifyNumberTextWatcher FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private boolean com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;
    @Inject
    public Lazy<LocationPermissionSubject> locationPermissionSubject;
    @Inject
    public Lazy<LogoutContract.Presenter> logoutPresenter;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;
    @Inject
    public Lazy<PermissionStateContract.Presenter> permissionStatePresenter;
    @Inject
    public Lazy<RiskRejectDialog> riskRejectDialog;
    @Inject
    public Lazy<VerifyNumberContract.Presenter> verifyPresenter;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda4;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen NetworkUserEntityData$$ExternalSyntheticLambda5 = new MeasureLoadAndRenderingScreen();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final kotlin.Lazy getAuthRequestContext = LazyKt.lazy(new Function0<DanaLoadingDialogFragment>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$danaLoadingDialog$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialogFragment invoke() {
            DanaLoadingDialogFragment.Companion companion = DanaLoadingDialogFragment.INSTANCE;
            return DanaLoadingDialogFragment.Companion.BuiltInFictitiousFunctionClassFactory();
        }
    });

    /* renamed from: A  reason: from kotlin metadata */
    private String getCallingPid = "";

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda6 = "";

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private String SubSequence = "";

    /* renamed from: D */
    private String VerifyPinStateManager$executeRiskChallenge$2$1 = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final kotlin.Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<FirebasePerformanceMonitor>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$firebasePerformanceMonitor$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FirebasePerformanceMonitor invoke() {
            return FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final kotlin.Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaConfirmationBottomSheetDialog>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$bottomSheetRegisterConfirmation$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
        @Override // kotlin.jvm.functions.Function0
        public final DanaConfirmationBottomSheetDialog invoke() {
            int i = 2;
            ?? r2 = 0;
            StringWrapper.ResValue resValue = new StringWrapper.ResValue(R.string.register_confirmation_dialog_title, r2, i, r2);
            StringWrapper.ResValue resValue2 = new StringWrapper.ResValue(R.string.register_confirmation_dialog_desc, r2, i, r2);
            StringWrapper.ResValue resValue3 = new StringWrapper.ResValue(R.string.btn_continue_lanjutkan, r2, i, r2);
            StringWrapper.ResValue resValue4 = new StringWrapper.ResValue(R.string.cancel_text, r2, i, r2);
            final VerifyNumberFragment verifyNumberFragment = VerifyNumberFragment.this;
            return new DanaConfirmationBottomSheetDialog(resValue, resValue2, resValue3, resValue4, R.drawable.welcome_circle_illustration, new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$bottomSheetRegisterConfirmation$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean z;
                    Lazy<VerifyNumberContract.Presenter> lazy = VerifyNumberFragment.this.verifyPresenter;
                    if (lazy == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lazy = null;
                    }
                    VerifyNumberContract.Presenter presenter = lazy.get();
                    z = VerifyNumberFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(z);
                }
            }, null, false, 192, null);
        }
    });

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final kotlin.Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<EnrollPasskeyLauncher>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$enrollPasskeyLauncher$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EnrollPasskeyLauncher invoke() {
            EnrollPasskeyLauncher.Builder builder = new EnrollPasskeyLauncher.Builder(VerifyNumberFragment.this);
            Intrinsics.checkNotNullParameter("Home", "");
            builder.moveToNextValue = "Home";
            Intrinsics.checkNotNullParameter("Enroll", "");
            builder.PlaceComponentResult = "Enroll";
            Intrinsics.checkNotNullParameter("HOME", "");
            builder.MyBillsEntityDataFactory = "HOME";
            final VerifyNumberFragment verifyNumberFragment = VerifyNumberFragment.this;
            Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$enrollPasskeyLauncher$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
                    Intrinsics.checkNotNullParameter(bundle, "");
                    onboardingNavigationManagerWithMenu = VerifyNumberFragment.this.PrepareContext;
                    if (onboardingNavigationManagerWithMenu == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        onboardingNavigationManagerWithMenu = null;
                    }
                    onboardingNavigationManagerWithMenu.BuiltInFictitiousFunctionClassFactory();
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            builder.getErrorConfigVersion = function1;
            final VerifyNumberFragment verifyNumberFragment2 = VerifyNumberFragment.this;
            Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$enrollPasskeyLauncher$2.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    Intrinsics.checkNotNullParameter(bundle, "");
                    VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(VerifyNumberFragment.this);
                }
            };
            Intrinsics.checkNotNullParameter(function12, "");
            builder.PlaceComponentResult = function12;
            final VerifyNumberFragment verifyNumberFragment3 = VerifyNumberFragment.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$enrollPasskeyLauncher$2.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(VerifyNumberFragment.this);
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
            return builder.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    });

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult = true;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberFragment$ChallengeListener;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ChallengeListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_verify_number;
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ FragmentVerifyNumberBinding scheduleImpl(VerifyNumberFragment verifyNumberFragment) {
        return (FragmentVerifyNumberBinding) verifyNumberFragment.getBinding();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentVerifyNumberBinding authRequestContext = FragmentVerifyNumberBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        Intrinsics.checkNotNullParameter("phone_number_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("phone_number_screen_render");
        DanaPerformanceDurationTracker danaPerformanceDurationTracker = DanaPerformanceDurationTracker.INSTANCE;
        DanaPerformanceDurationTracker.MyBillsEntityDataFactory(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN);
        DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.Property.RENDER_PHONE_NUMBER_SCREEN, System.currentTimeMillis());
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("input_phone_number_flow_loadtime");
    }

    @Override // id.dana.base.BaseFragment
    public final void onUnSelected() {
        super.onUnSelected();
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("input_phone_number_flow_loadtime", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "input_phone_number_flow_loadtime");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((FirebasePerformanceMonitor) this.getErrorConfigVersion.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.IDLE_INPUT_PHONE_NUMBER_SCREEN);
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        Uri parse;
        VerifyNumberTextWatcher verifyNumberTextWatcher;
        boolean z;
        InputPhoneView inputPhoneView;
        EditText input;
        InputPhoneView inputPhoneView2;
        EditText input2;
        InputPhoneView inputPhoneView3;
        EditText input3;
        InputPhoneView inputPhoneView4;
        EditText input4;
        InputPhoneView inputPhoneView5;
        EditText input5;
        InputPhoneView inputPhoneView6;
        InputPhoneView inputPhoneView7;
        EditText input6;
        Button button;
        InputPhoneView inputPhoneView8;
        InputPhoneView inputPhoneView9;
        ConstraintLayout constraintLayout;
        Bundle arguments = getArguments();
        byte b = 0;
        if (arguments != null && arguments.containsKey("phoneNumber")) {
            String string = arguments.getString("phoneNumber", "");
            Intrinsics.checkNotNullExpressionValue(string, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
            this.GetContactSyncConfig = arguments.getBoolean("isEditablePhoneNumber");
            this.initRecordTimeStamp = Intrinsics.areEqual(OnboardingActivity.DEEPLINK_RESET_PIN, arguments.getString("source", ""));
            boolean z2 = arguments.getBoolean("fromCitcall", false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = z2;
            if (z2) {
                String string2 = arguments.getString(ChallengeControl.Key.SECURITY_ID, "");
                Intrinsics.checkNotNullExpressionValue(string2, "");
                this.VerifyPinStateManager$executeRiskChallenge$2$1 = string2;
            }
        }
        boolean z3 = arguments != null && arguments.getBoolean("FROM_LOGOUT", false);
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
            DaggerVerifyNumberComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerVerifyNumberComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (PermissionStateModule) Preconditions.getAuthRequestContext(new PermissionStateModule(new PermissionStateContract.View() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$getPermissionStateModule$1
                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }

                @Override // id.dana.contract.permission.PermissionStateContract.View
                public final void PlaceComponentResult(boolean p0) {
                    if (p0) {
                        VerifyNumberFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    } else {
                        VerifyNumberFragment.VerifyPinStateManager$executeRiskChallenge$2$1(VerifyNumberFragment.this);
                    }
                }
            }));
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (VerifyNumberModule) Preconditions.getAuthRequestContext(new VerifyNumberModule(new VerifyNumberFragment$getVerifyNumberModule$1(this), this.initRecordTimeStamp));
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (LogoutModule) Preconditions.getAuthRequestContext(new LogoutModule(new LogoutContract.View() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$getLogoutModule$1
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
                    VerifyNumberFragment.whenAvailable(VerifyNumberFragment.this);
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void MyBillsEntityDataFactory() {
                    VerifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2(VerifyNumberFragment.this);
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void PlaceComponentResult() {
                    DeepLinkParser.getAuthRequestContext();
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, VerifyNumberModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, PermissionStateModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, LogoutModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            DaggerVerifyNumberComponent.VerifyNumberComponentImpl verifyNumberComponentImpl = new DaggerVerifyNumberComponent.VerifyNumberComponentImpl(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0);
            Intrinsics.checkNotNullExpressionValue(verifyNumberComponentImpl, "");
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = verifyNumberComponentImpl;
        }
        VerifyNumberComponent verifyNumberComponent = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (verifyNumberComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            verifyNumberComponent = null;
        }
        verifyNumberComponent.BuiltInFictitiousFunctionClassFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        Lazy<VerifyNumberContract.Presenter> lazy = this.verifyPresenter;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        abstractPresenterArr[0] = lazy.get();
        registerPresenter(abstractPresenterArr);
        VerifyNumberFragment verifyNumberFragment = this;
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(verifyNumberFragment);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$initPermission$1
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
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(VerifyNumberFragment.this.getBaseActivity(), "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.whenAvailable = builder.PlaceComponentResult();
        this.DatabaseTableConfigUtil = false;
        VerifyNumberTextWatcher verifyNumberTextWatcher2 = this.FragmentBottomSheetPaymentSettingBinding;
        if (verifyNumberTextWatcher2 != null && verifyNumberTextWatcher2 != null) {
            verifyNumberTextWatcher2.scheduleImpl = false;
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            OnboardingNavigationManagerWithMenu navigationManager = ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            this.PrepareContext = navigationManager;
            if (z3) {
                if (navigationManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    navigationManager = null;
                }
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftButton((String) null);
            } else {
                if (navigationManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    navigationManager = null;
                }
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftButton(R.drawable.btn_arrow_left);
            }
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.PrepareContext;
            if (onboardingNavigationManagerWithMenu == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                onboardingNavigationManagerWithMenu = null;
            }
            onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButton((String) null);
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu2 = this.PrepareContext;
            if (onboardingNavigationManagerWithMenu2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                onboardingNavigationManagerWithMenu2 = null;
            }
            onboardingNavigationManagerWithMenu2.PlaceComponentResult = new MenuItemButtonListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$$ExternalSyntheticLambda3
                @Override // id.dana.base.MenuItemButtonListener
                public final void PlaceComponentResult() {
                    VerifyNumberFragment.PlaceComponentResult(VerifyNumberFragment.this);
                }
            };
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu3 = this.PrepareContext;
            if (onboardingNavigationManagerWithMenu3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                onboardingNavigationManagerWithMenu3 = null;
            }
            onboardingNavigationManagerWithMenu3.KClassImpl$Data$declaredNonStaticMembers$2.setToolbarImage(R.drawable.ic_dana_logo_icon_text);
            Lazy<VerifyNumberContract.Presenter> lazy2 = this.verifyPresenter;
            if (lazy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy2 = null;
            }
            lazy2.get().KClassImpl$Data$declaredNonStaticMembers$2();
            Lazy<VerifyNumberContract.Presenter> lazy3 = this.verifyPresenter;
            if (lazy3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy3 = null;
            }
            lazy3.get().getAuthRequestContext();
            Lazy<VerifyNumberContract.Presenter> lazy4 = this.verifyPresenter;
            if (lazy4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy4 = null;
            }
            lazy4.get().BuiltInFictitiousFunctionClassFactory();
            Lazy<VerifyNumberContract.Presenter> lazy5 = this.verifyPresenter;
            if (lazy5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy5 = null;
            }
            lazy5.get().NetworkUserEntityData$$ExternalSyntheticLambda0();
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding = (FragmentVerifyNumberBinding) getBinding();
            if (fragmentVerifyNumberBinding != null && (constraintLayout = fragmentVerifyNumberBinding.BuiltInFictitiousFunctionClassFactory) != null) {
                constraintLayout.setOnTouchListener(this);
            }
            IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
            IPConfiguration MyBillsEntityDataFactory = IPConfiguration.Companion.MyBillsEntityDataFactory();
            IPEnvironment iPEnvironment = StringsKt.contains$default((CharSequence) "production", (CharSequence) "prod", false, 2, (Object) null) ? IPEnvironment.PRODUCTION : IPEnvironment.SANDBOX;
            Intrinsics.checkParameterIsNotNull(iPEnvironment, "");
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = iPEnvironment;
            IPConfiguration.Companion companion2 = IPConfiguration.INSTANCE;
            IPConfiguration MyBillsEntityDataFactory2 = IPConfiguration.Companion.MyBillsEntityDataFactory();
            Intrinsics.checkParameterIsNotNull(BuildConfig.IPIFICATION_CLIENT_ID, "");
            MyBillsEntityDataFactory2.moveToNextValue = BuildConfig.IPIFICATION_CLIENT_ID;
            IPConfiguration.Companion companion3 = IPConfiguration.INSTANCE;
            IPConfiguration MyBillsEntityDataFactory3 = IPConfiguration.Companion.MyBillsEntityDataFactory();
            if (!StringsKt.contains$default((CharSequence) "production", (CharSequence) "prod", false, 2, (Object) null)) {
                parse = Uri.parse("https://mgs-gw.m.dana.id/mgw.htm");
            } else {
                parse = Uri.parse(CarrierIdentificationVerifyActivity.IPIFICATION_REDIRECT_URI);
                Intrinsics.checkNotNullExpressionValue(parse, "");
            }
            MyBillsEntityDataFactory3.NetworkUserEntityData$$ExternalSyntheticLambda5 = parse;
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding2 = (FragmentVerifyNumberBinding) getBinding();
            if (fragmentVerifyNumberBinding2 != null) {
                EditText input7 = fragmentVerifyNumberBinding2.PlaceComponentResult.getInput();
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                verifyNumberTextWatcher = new VerifyNumberTextWatcher(input7, requireContext, this.DatabaseTableConfigUtil, verifyNumberFragment);
            } else {
                verifyNumberTextWatcher = null;
            }
            this.FragmentBottomSheetPaymentSettingBinding = verifyNumberTextWatcher;
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding3 = (FragmentVerifyNumberBinding) getBinding();
            if (fragmentVerifyNumberBinding3 != null && (inputPhoneView9 = fragmentVerifyNumberBinding3.PlaceComponentResult) != null) {
                inputPhoneView9.requestFocus();
                inputPhoneView9.setPrefix(getString(R.string.id_prefix));
                inputPhoneView9.setOnValidatedListener(new OnValidatedListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$onValidatedListener$1
                    @Override // id.dana.textbehavior.OnValidatedListener
                    public final void getAuthRequestContext(String p0) {
                        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu4;
                        Intrinsics.checkNotNullParameter(p0, "");
                        VerifyNumberFragment.this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = true;
                        onboardingNavigationManagerWithMenu4 = VerifyNumberFragment.this.PrepareContext;
                        if (onboardingNavigationManagerWithMenu4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            onboardingNavigationManagerWithMenu4 = null;
                        }
                        onboardingNavigationManagerWithMenu4.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(true);
                        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        Button button2 = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
                        if (button2 != null) {
                            button2.setEnabled(true);
                        }
                        FragmentVerifyNumberBinding scheduleImpl2 = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        Button button3 = scheduleImpl2 != null ? scheduleImpl2.getAuthRequestContext : null;
                        if (button3 != null) {
                            button3.setAlpha(1.0f);
                        }
                    }

                    @Override // id.dana.textbehavior.OnValidatedListener
                    public final void MyBillsEntityDataFactory(String p0, List<? extends InvalidReason> p1) {
                        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu4;
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                        VerifyNumberFragment.this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = false;
                        onboardingNavigationManagerWithMenu4 = VerifyNumberFragment.this.PrepareContext;
                        if (onboardingNavigationManagerWithMenu4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            onboardingNavigationManagerWithMenu4 = null;
                        }
                        onboardingNavigationManagerWithMenu4.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(false);
                        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        Button button2 = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
                        if (button2 != null) {
                            button2.setEnabled(false);
                        }
                        FragmentVerifyNumberBinding scheduleImpl2 = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        Button button3 = scheduleImpl2 != null ? scheduleImpl2.getAuthRequestContext : null;
                        if (button3 != null) {
                            button3.setAlpha(0.48f);
                        }
                    }
                });
                inputPhoneView9.getInput().setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnKeyListener
                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        boolean MyBillsEntityDataFactory4;
                        MyBillsEntityDataFactory4 = VerifyNumberFragment.MyBillsEntityDataFactory(VerifyNumberFragment.this, i, keyEvent);
                        return MyBillsEntityDataFactory4;
                    }
                });
                inputPhoneView9.getInput().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z4) {
                        VerifyNumberFragment.getAuthRequestContext(z4);
                    }
                });
                inputPhoneView9.getInput().addTextChangedListener(this.FragmentBottomSheetPaymentSettingBinding);
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda6.length() > 0) {
                String str = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                String substring = str.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                if (Intrinsics.areEqual(substring, "0")) {
                    str = new Regex("0").replaceFirst(str, "");
                }
                FragmentVerifyNumberBinding fragmentVerifyNumberBinding4 = (FragmentVerifyNumberBinding) getBinding();
                if (fragmentVerifyNumberBinding4 != null && (inputPhoneView8 = fragmentVerifyNumberBinding4.PlaceComponentResult) != null) {
                    inputPhoneView8.setInput(str);
                    inputPhoneView8.setEditable(this.GetContactSyncConfig);
                }
            }
            String string3 = getString(R.string.lbl_enter_phone_number_intro);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            String string4 = getString(R.string.lbl_intro_phone_number_highlight);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            String str2 = string3;
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, string4, 0, false, 6, (Object) null);
            int length = string4.length();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.setSpan(new StyleSpan(1), indexOf$default, length + indexOf$default, 33);
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding5 = (FragmentVerifyNumberBinding) getBinding();
            TextView textView = fragmentVerifyNumberBinding5 != null ? fragmentVerifyNumberBinding5.getErrorConfigVersion : null;
            if (textView != null) {
                textView.setText(spannableStringBuilder);
            }
            String string5 = getString(R.string.intro_tnc);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            String string6 = getString(R.string.tnc);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            String string7 = getString(R.string.privacy_policy_highlighted);
            Intrinsics.checkNotNullExpressionValue(string7, "");
            String str3 = string5;
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str3, string6, 0, false, 6, (Object) null);
            int length2 = string6.length() + indexOf$default2;
            int indexOf$default3 = StringsKt.indexOf$default((CharSequence) str3, string7, 0, false, 6, (Object) null);
            int length3 = string7.length() + indexOf$default3;
            NoUnderlineClickableSpan noUnderlineClickableSpan = new NoUnderlineClickableSpan(getContext(), WebViewActivity.ContentBuilder(getContext(), string6, UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION)));
            NoUnderlineClickableSpan noUnderlineClickableSpan2 = new NoUnderlineClickableSpan(getContext(), WebViewActivity.ContentBuilder(getContext(), string7, UrlUtil.getAuthRequestContext(DanaUrl.PRIVACY_POLICY)));
            SpannableString spannableString = new SpannableString(str3);
            spannableString.setSpan(noUnderlineClickableSpan, indexOf$default2, length2, 33);
            spannableString.setSpan(noUnderlineClickableSpan2, indexOf$default3, length3, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf$default2, length2, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf$default3, length3, 33);
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding6 = (FragmentVerifyNumberBinding) getBinding();
            TextView textView2 = fragmentVerifyNumberBinding6 != null ? fragmentVerifyNumberBinding6.lookAheadTest : null;
            if (textView2 != null) {
                textView2.setText(spannableString);
            }
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding7 = (FragmentVerifyNumberBinding) getBinding();
            TextView textView3 = fragmentVerifyNumberBinding7 != null ? fragmentVerifyNumberBinding7.lookAheadTest : null;
            if (textView3 != null) {
                textView3.setMovementMethod(LinkMovementMethod.getInstance());
            }
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding8 = (FragmentVerifyNumberBinding) getBinding();
            if (fragmentVerifyNumberBinding8 != null && (button = fragmentVerifyNumberBinding8.getAuthRequestContext) != null) {
                button.setOnClickListener(new ThrottledOnClickListener(0L, new Function1<View, Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$initContinueButtonListener$1
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
                        FirebasePerformanceMonitor initRecordTimeStamp = VerifyNumberFragment.initRecordTimeStamp(VerifyNumberFragment.this);
                        Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PHONE_NUMBER_INPUT, "");
                        Trace trace = initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.get(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PHONE_NUMBER_INPUT);
                        if (trace != null) {
                            trace.stop();
                        }
                        DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.Property.TYPING_PHONE_NUMBER_IN_MILLIS, System.currentTimeMillis());
                        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        Button button2 = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
                        if (button2 != null) {
                            button2.setEnabled(false);
                        }
                        FragmentActivity activity = VerifyNumberFragment.this.getActivity();
                        OnboardingActivity onboardingActivity = activity instanceof OnboardingActivity ? (OnboardingActivity) activity : null;
                        if (onboardingActivity != null) {
                            onboardingActivity.setOtpPurpose("Direct Challenge");
                        }
                        VerifyNumberFragment.this.PlaceComponentResult();
                    }
                }, 1, null));
            }
            BaseActivity baseActivity2 = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2((Activity) baseActivity2);
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            z = OauthLoginManager.MyBillsEntityDataFactory;
            if (z) {
                OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
                String clearPhoneNumber = NumberUtils.getClearPhoneNumber(OauthLoginManager.getErrorConfigVersion());
                Intrinsics.checkNotNullExpressionValue(clearPhoneNumber, "");
                String replaceFirst = new Regex("62-").replaceFirst(clearPhoneNumber, "");
                FragmentVerifyNumberBinding fragmentVerifyNumberBinding9 = (FragmentVerifyNumberBinding) getBinding();
                if (fragmentVerifyNumberBinding9 != null && (inputPhoneView7 = fragmentVerifyNumberBinding9.PlaceComponentResult) != null && (input6 = inputPhoneView7.getInput()) != null) {
                    input6.setText(replaceFirst);
                }
                FragmentVerifyNumberBinding fragmentVerifyNumberBinding10 = (FragmentVerifyNumberBinding) getBinding();
                EditText input8 = (fragmentVerifyNumberBinding10 == null || (inputPhoneView6 = fragmentVerifyNumberBinding10.PlaceComponentResult) == null) ? null : inputPhoneView6.getInput();
                if (input8 != null) {
                    input8.setFocusable(false);
                }
                try {
                    FragmentVerifyNumberBinding fragmentVerifyNumberBinding11 = (FragmentVerifyNumberBinding) getBinding();
                    if (fragmentVerifyNumberBinding11 != null && (inputPhoneView5 = fragmentVerifyNumberBinding11.PlaceComponentResult) != null && (input5 = inputPhoneView5.getInput()) != null) {
                        input5.setSelection(replaceFirst.length() + 2);
                    }
                } catch (IndexOutOfBoundsException unused) {
                    FragmentVerifyNumberBinding fragmentVerifyNumberBinding12 = (FragmentVerifyNumberBinding) getBinding();
                    if (fragmentVerifyNumberBinding12 != null && (inputPhoneView4 = fragmentVerifyNumberBinding12.PlaceComponentResult) != null && (input4 = inputPhoneView4.getInput()) != null) {
                        input4.setSelection(replaceFirst.length());
                    }
                }
                PlaceComponentResult();
            }
            DeeplinkSaveDataManager PlaceComponentResult = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult();
            String str4 = PlaceComponentResult.lookAheadTest;
            if (str4 == null) {
                str4 = "";
            }
            if (str4.length() > 0) {
                this.DatabaseTableConfigUtil = true;
                VerifyNumberTextWatcher verifyNumberTextWatcher3 = this.FragmentBottomSheetPaymentSettingBinding;
                if (verifyNumberTextWatcher3 != null && verifyNumberTextWatcher3 != null) {
                    verifyNumberTextWatcher3.scheduleImpl = true;
                }
                String str5 = PlaceComponentResult.lookAheadTest;
                if (str5 == null) {
                    str5 = "";
                }
                String PlaceComponentResult2 = MaskedTextUtil.PlaceComponentResult(str5, "••••");
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
                String replaceFirst2 = new Regex("62-").replaceFirst(PlaceComponentResult2, "");
                OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu4 = this.PrepareContext;
                if (onboardingNavigationManagerWithMenu4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    onboardingNavigationManagerWithMenu4 = null;
                }
                onboardingNavigationManagerWithMenu4.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftButton(R.drawable.btn_arrow_left);
                FragmentVerifyNumberBinding fragmentVerifyNumberBinding13 = (FragmentVerifyNumberBinding) getBinding();
                if (fragmentVerifyNumberBinding13 != null && (inputPhoneView3 = fragmentVerifyNumberBinding13.PlaceComponentResult) != null && (input3 = inputPhoneView3.getInput()) != null) {
                    input3.setText(replaceFirst2);
                }
                FragmentVerifyNumberBinding fragmentVerifyNumberBinding14 = (FragmentVerifyNumberBinding) getBinding();
                InputPhoneView inputPhoneView10 = fragmentVerifyNumberBinding14 != null ? fragmentVerifyNumberBinding14.PlaceComponentResult : null;
                if (inputPhoneView10 != null) {
                    inputPhoneView10.setFocusable(false);
                }
                try {
                    FragmentVerifyNumberBinding fragmentVerifyNumberBinding15 = (FragmentVerifyNumberBinding) getBinding();
                    if (fragmentVerifyNumberBinding15 != null && (inputPhoneView2 = fragmentVerifyNumberBinding15.PlaceComponentResult) != null && (input2 = inputPhoneView2.getInput()) != null) {
                        input2.setSelection(replaceFirst2.length() + 2);
                    }
                } catch (IndexOutOfBoundsException unused2) {
                    FragmentVerifyNumberBinding fragmentVerifyNumberBinding16 = (FragmentVerifyNumberBinding) getBinding();
                    if (fragmentVerifyNumberBinding16 != null && (inputPhoneView = fragmentVerifyNumberBinding16.PlaceComponentResult) != null && (input = inputPhoneView.getInput()) != null) {
                        input.setSelection(replaceFirst2.length());
                    }
                }
                PlaceComponentResult();
            }
            AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
            AppReadyMixpanelTracker.isLayoutRequested();
            if (BuiltInFictitiousFunctionClassFactory()) {
                EventTrackerModel.Builder builder2 = new EventTrackerModel.Builder(getContext());
                builder2.MyBillsEntityDataFactory = TrackerKey.Event.ONBOARDING_PHONE_NUMBER_OPEN;
                OauthLoginManager oauthLoginManager3 = OauthLoginManager.INSTANCE;
                if (!TextUtils.isEmpty(OauthLoginManager.scheduleImpl())) {
                    OauthLoginManager oauthLoginManager4 = OauthLoginManager.INSTANCE;
                    builder2.MyBillsEntityDataFactory("Merchant Name", OauthLoginManager.scheduleImpl());
                } else {
                    builder2.MyBillsEntityDataFactory("Merchant Name", getString(R.string.dana_string));
                }
                builder2.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(builder2, b));
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                Lazy<VerifyNumberContract.Presenter> lazy6 = this.verifyPresenter;
                if (lazy6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy6 = null;
                }
                lazy6.get().MyBillsEntityDataFactory();
            }
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                Intrinsics.checkNotNullParameter(getAuthRequestContext, "");
                FirstDrawListener.Companion companion4 = FirstDrawListener.INSTANCE;
                FirstDrawListener.Companion.MyBillsEntityDataFactory(getAuthRequestContext, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
            }
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding17 = (FragmentVerifyNumberBinding) getBinding();
            ViewHelper.getAuthRequestContext(fragmentVerifyNumberBinding17 != null ? fragmentVerifyNumberBinding17.DatabaseTableConfigUtil : null, new Runnable() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    VerifyNumberFragment.MyBillsEntityDataFactory();
                }
            });
            getLifecycle().BuiltInFictitiousFunctionClassFactory((EnrollPasskeyLauncher) this.BuiltInFictitiousFunctionClassFactory.getValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        InputPhoneView inputPhoneView;
        EditText input;
        FragmentVerifyNumberBinding fragmentVerifyNumberBinding = (FragmentVerifyNumberBinding) getBinding();
        Lazy<VerifyNumberContract.Presenter> lazy = null;
        InputPhoneView inputPhoneView2 = fragmentVerifyNumberBinding != null ? fragmentVerifyNumberBinding.PlaceComponentResult : null;
        if (inputPhoneView2 != null) {
            inputPhoneView2.setEnabled(true);
        }
        FragmentVerifyNumberBinding fragmentVerifyNumberBinding2 = (FragmentVerifyNumberBinding) getBinding();
        Button button = fragmentVerifyNumberBinding2 != null ? fragmentVerifyNumberBinding2.getAuthRequestContext : null;
        if (button != null) {
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding3 = (FragmentVerifyNumberBinding) getBinding();
            Editable text = (fragmentVerifyNumberBinding3 == null || (inputPhoneView = fragmentVerifyNumberBinding3.PlaceComponentResult) == null || (input = inputPhoneView.getInput()) == null) ? null : input.getText();
            button.setEnabled(true ^ (text == null || text.length() == 0));
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.onboarding.OnboardingActivity");
        }
        if (((OnboardingActivity) activity).getIsFromCitCall()) {
            Lazy<VerifyNumberContract.Presenter> lazy2 = this.verifyPresenter;
            if (lazy2 != null) {
                lazy = lazy2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            lazy.get().MyBillsEntityDataFactory();
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.onboarding.OnboardingActivity");
            }
            ((OnboardingActivity) activity2).setFromCitCall(false);
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int p0, int p1, Intent p2) {
        List<? extends LoginAuthenticationOptionResponse> emptyList;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
        CarrierIdentificationVerifyActivity.Companion companion = CarrierIdentificationVerifyActivity.INSTANCE;
        boolean z = true;
        Lazy<VerifyNumberContract.Presenter> lazy = null;
        Lazy<VerifyNumberContract.Presenter> lazy2 = null;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu2 = null;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu3 = null;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu4 = null;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu5 = null;
        if (CarrierIdentificationVerifyActivity.Companion.MyBillsEntityDataFactory() == p0 && 1000 == p1) {
            FragmentActivity activity = getActivity();
            OnboardingActivity onboardingActivity = activity instanceof OnboardingActivity ? (OnboardingActivity) activity : null;
            if (onboardingActivity != null) {
                onboardingActivity.setOtpPurpose("Direct Challenge");
            }
            Lazy<VerifyNumberContract.Presenter> lazy3 = this.verifyPresenter;
            if (lazy3 != null) {
                lazy = lazy3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            lazy.get().PlaceComponentResult(true);
        } else {
            CarrierIdentificationVerifyActivity.Companion companion2 = CarrierIdentificationVerifyActivity.INSTANCE;
            if (CarrierIdentificationVerifyActivity.Companion.MyBillsEntityDataFactory() != p0 || 1001 != p1) {
                CarrierIdentificationVerifyActivity.Companion companion3 = CarrierIdentificationVerifyActivity.INSTANCE;
                if (CarrierIdentificationVerifyActivity.Companion.MyBillsEntityDataFactory() == p0 && 1002 == p1) {
                    if (p2 != null) {
                        String stringExtra = p2.getStringExtra("errorMessage");
                        String str = stringExtra;
                        if (!(str == null || StringsKt.isBlank(str))) {
                            getBaseActivity().showWarningDialog(stringExtra);
                        }
                        FragmentVerifyNumberBinding fragmentVerifyNumberBinding = (FragmentVerifyNumberBinding) getBinding();
                        Button button = fragmentVerifyNumberBinding != null ? fragmentVerifyNumberBinding.getAuthRequestContext : null;
                        if (button != null) {
                            button.setEnabled(true);
                        }
                    }
                } else if (998 == p0) {
                    if (p1 == -1) {
                        if (p2 != null && p2.getBooleanExtra("show_dana_viz_prompt", false)) {
                            boolean booleanExtra = p2.getBooleanExtra("dana_viz_prompt_skippable", true);
                            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu6 = this.PrepareContext;
                            if (onboardingNavigationManagerWithMenu6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                onboardingNavigationManagerWithMenu2 = onboardingNavigationManagerWithMenu6;
                            }
                            onboardingNavigationManagerWithMenu2.BuiltInFictitiousFunctionClassFactory(booleanExtra);
                        } else {
                            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu7 = this.PrepareContext;
                            if (onboardingNavigationManagerWithMenu7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                onboardingNavigationManagerWithMenu3 = onboardingNavigationManagerWithMenu7;
                            }
                            onboardingNavigationManagerWithMenu3.BuiltInFictitiousFunctionClassFactory();
                        }
                    } else {
                        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(p2);
                        if (!TextUtils.isEmpty(MyBillsEntityDataFactory)) {
                            PlaceComponentResult(MyBillsEntityDataFactory, p2 != null ? p2.getExtras() : null);
                        } else {
                            MyBillsEntityDataFactory(p2 != null ? p2.getExtras() : null);
                        }
                    }
                } else if (999 == p0) {
                    if (p1 == -1) {
                        this.newProxyInstance = p2 != null && p2.getBooleanExtra("KEY_NEED_SHOW_PASSKEY_ENROLLMENT", false);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = p2 != null && p2.getBooleanExtra("show_dana_viz_prompt", false);
                        this.PlaceComponentResult = p2 != null && p2.getBooleanExtra("dana_viz_prompt_skippable", true);
                        if (this.newProxyInstance) {
                            EnrollPasskeyLauncher.Companion companion4 = EnrollPasskeyLauncher.INSTANCE;
                            boolean PlaceComponentResult = EnrollPasskeyLauncher.Companion.PlaceComponentResult();
                            StringBuilder sb = new StringBuilder();
                            sb.append("isPasskeySupported: ");
                            sb.append(PlaceComponentResult);
                            DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
                            if (PlaceComponentResult && this.newProxyInstance) {
                                ((EnrollPasskeyLauncher) this.BuiltInFictitiousFunctionClassFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
                                this.newProxyInstance = false;
                            }
                        } else if (p2 != null && p2.getBooleanExtra("show_dana_viz_prompt", false)) {
                            boolean booleanExtra2 = p2.getBooleanExtra("dana_viz_prompt_skippable", true);
                            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu8 = this.PrepareContext;
                            if (onboardingNavigationManagerWithMenu8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                onboardingNavigationManagerWithMenu4 = onboardingNavigationManagerWithMenu8;
                            }
                            onboardingNavigationManagerWithMenu4.BuiltInFictitiousFunctionClassFactory(booleanExtra2);
                        } else {
                            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu9 = this.PrepareContext;
                            if (onboardingNavigationManagerWithMenu9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                onboardingNavigationManagerWithMenu5 = onboardingNavigationManagerWithMenu9;
                            }
                            onboardingNavigationManagerWithMenu5.BuiltInFictitiousFunctionClassFactory();
                        }
                    } else {
                        PlaceComponentResult(MyBillsEntityDataFactory(p2), p2 != null ? p2.getExtras() : null);
                    }
                } else if (1000 == p0) {
                    if (p1 == -1) {
                        ChallengeListener challengeListener = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                        if (challengeListener != null) {
                            challengeListener.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    } else {
                        try {
                            if (!getParentFragmentManager().isStateSaved()) {
                                ((DanaLoadingDialogFragment) this.getAuthRequestContext.getValue()).dismissNow();
                            }
                        } catch (IllegalStateException e) {
                            Crashlytics.Companion companion5 = Crashlytics.INSTANCE;
                            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                            Intrinsics.checkNotNullParameter("class: VerifyNumberFragment", "");
                            authRequestContext.getAuthRequestContext.log("class: VerifyNumberFragment");
                            Intrinsics.checkNotNullParameter("method: onChallengeControlOtpRegisterActivityResult", "");
                            authRequestContext.getAuthRequestContext.log("method: onChallengeControlOtpRegisterActivityResult");
                            IllegalStateException illegalStateException = e;
                            Intrinsics.checkNotNullParameter(illegalStateException, "");
                            authRequestContext.getAuthRequestContext.recordException(illegalStateException);
                        }
                        String stringExtra2 = p2 != null ? p2.getStringExtra("otpPurpose") : null;
                        if (stringExtra2 == null) {
                            stringExtra2 = "";
                        }
                        String stringExtra3 = p2 != null ? p2.getStringExtra("errorCode") : null;
                        if (stringExtra3 == null) {
                            stringExtra3 = "";
                        }
                        if (Intrinsics.areEqual(stringExtra3, "AE15112158100310")) {
                            getErrorConfigVersion();
                        } else if (!Intrinsics.areEqual(stringExtra3, "AE15112158100410")) {
                            if (!Intrinsics.areEqual(stringExtra2, ChallengeEvent.OTPPurpose.WHATSAPP_FAILOVER)) {
                                MyBillsEntityDataFactory(p2 != null ? p2.getExtras() : null);
                            } else {
                                Lazy<VerifyNumberContract.Presenter> lazy4 = this.verifyPresenter;
                                if (lazy4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    lazy4 = null;
                                }
                                lazy4.get().PlaceComponentResult();
                                FragmentActivity activity2 = getActivity();
                                OnboardingActivity onboardingActivity2 = activity2 instanceof OnboardingActivity ? (OnboardingActivity) activity2 : null;
                                if (onboardingActivity2 != null) {
                                    onboardingActivity2.setOtpPurpose(stringExtra2);
                                }
                            }
                        } else if (getContext() != null) {
                            Context requireContext = requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "");
                            DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
                            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.otp_daily_limit_title);
                            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
                            builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.otp_daily_limit_desc);
                            String string = getString(R.string.otp_daily_limit_got_it);
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            String upperCase = string.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "");
                            String str2 = upperCase;
                            Intrinsics.checkNotNullParameter(str2, "");
                            builder.PrepareContext = str2;
                            builder.lookAheadTest = Boolean.FALSE;
                            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
                            FragmentManager parentFragmentManager = getParentFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                            Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                            BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
                        }
                    }
                }
            } else if (p2 != null) {
                ArrayList parcelableArrayListExtra = p2.getParcelableArrayListExtra(ChallengePinWithFaceActivity.LOGIN_AUTHENTICATION_OPTIONS);
                if (parcelableArrayListExtra == null || (emptyList = CollectionsKt.toMutableList((Collection) parcelableArrayListExtra)) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                String stringExtra4 = p2.getStringExtra(ChallengeControl.Key.PHONE_NUMBER);
                String str3 = stringExtra4 == null ? "" : stringExtra4;
                String stringExtra5 = p2.getStringExtra(ChallengeControl.Key.SECURITY_ID);
                String str4 = stringExtra5 == null ? "" : stringExtra5;
                List<? extends LoginAuthenticationOptionResponse> list = emptyList;
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (z || !Intrinsics.areEqual("MISSED_CALL_OTP", ((LoginAuthenticationOptionResponse) emptyList.get(0)).getAuthenticationMethod())) {
                    String str5 = Intrinsics.areEqual(((LoginAuthenticationOptionResponse) emptyList.get(0)).getAuthenticationMethod(), "WHATSAPP_OTP") ? OtpChannel.WHATSAPP : "OTP_SMS";
                    FragmentActivity activity3 = getActivity();
                    OnboardingActivity onboardingActivity3 = activity3 instanceof OnboardingActivity ? (OnboardingActivity) activity3 : null;
                    if (onboardingActivity3 != null) {
                        onboardingActivity3.setOtpPurpose(ChallengeEvent.OTPPurpose.PNV_FAILOVER);
                    }
                    Lazy<VerifyNumberContract.Presenter> lazy5 = this.verifyPresenter;
                    if (lazy5 != null) {
                        lazy2 = lazy5;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    lazy2.get().PlaceComponentResult(str5);
                } else {
                    Lazy<VerifyNumberContract.Presenter> lazy6 = this.verifyPresenter;
                    if (lazy6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lazy6 = null;
                    }
                    lazy6.get().getAuthRequestContext(emptyList);
                    OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu10 = this.PrepareContext;
                    if (onboardingNavigationManagerWithMenu10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        onboardingNavigationManagerWithMenu = null;
                    } else {
                        onboardingNavigationManagerWithMenu = onboardingNavigationManagerWithMenu10;
                    }
                    onboardingNavigationManagerWithMenu.MyBillsEntityDataFactory(str3, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getSupportButtonTintMode, this.getCallingPid, str4);
                }
            }
        }
        super.onActivityResult(p0, p1, p2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        if (this.initRecordTimeStamp) {
            Lazy<VerifyNumberContract.Presenter> lazy = this.verifyPresenter;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            lazy.get().lookAheadTest();
        }
        super.onDestroy();
    }

    public final void getErrorConfigVersion() {
        if (getContext() == null) {
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.too_many_request_otp_title_dialog);
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.too_many_request_otp_message_dialog);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_too_many_request_otp_account_freeze;
        builder.lookAheadTest = Boolean.FALSE;
        builder.PrepareContext = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.too_many_request_otp_understood);
        DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        Intrinsics.checkNotNullParameter(parentFragmentManager, "");
        BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
    }

    public final void PlaceComponentResult() {
        if (OSUtil.GetContactSyncConfig()) {
            BaseActivity baseActivity = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            if (!PermissionHelper.MyBillsEntityDataFactory(baseActivity, "android.permission.ACCESS_FINE_LOCATION")) {
                Lazy<PermissionStateContract.Presenter> lazy = this.permissionStatePresenter;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get().PlaceComponentResult();
                return;
            }
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.APP_TOTAL_LOGIN_TIME);
        OnboardingFirebaseTracker onboardingFirebaseTracker2 = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.APP_TOTAL_REGISTRATION_TIME);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            CookieUtil.MyBillsEntityDataFactory(((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getApplicationContext(), new ValueCallback() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$$ExternalSyntheticLambda7
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    Boolean bool = (Boolean) obj;
                    VerifyNumberFragment.BuiltInFictitiousFunctionClassFactory(VerifyNumberFragment.this);
                }
            });
            DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.Property.TYPING_PHONE_NUMBER_IN_MILLIS, System.currentTimeMillis());
            DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.Property.CHECK_PHONE_NUMBER_LOGIC_IN_MILLIS, System.currentTimeMillis());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }

    public static final boolean MyBillsEntityDataFactory(VerifyNumberFragment verifyNumberFragment, int i, KeyEvent keyEvent) {
        FragmentVerifyNumberBinding fragmentVerifyNumberBinding;
        InputPhoneView inputPhoneView;
        EditText input;
        Editable text;
        Intrinsics.checkNotNullParameter(verifyNumberFragment, "");
        Intrinsics.checkNotNullParameter(keyEvent, "");
        if (keyEvent.getAction() == 0 && i == 66 && verifyNumberFragment.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String) {
            verifyNumberFragment.PlaceComponentResult();
            return false;
        } else if (keyEvent.getAction() != 0 || !verifyNumberFragment.DatabaseTableConfigUtil || (fragmentVerifyNumberBinding = (FragmentVerifyNumberBinding) verifyNumberFragment.getBinding()) == null || (inputPhoneView = fragmentVerifyNumberBinding.PlaceComponentResult) == null || (input = inputPhoneView.getInput()) == null || (text = input.getText()) == null) {
            return false;
        } else {
            text.clear();
            return false;
        }
    }

    private final void MyBillsEntityDataFactory(final int p0) {
        FaceLoginConfirmationFragment.Companion companion = FaceLoginConfirmationFragment.INSTANCE;
        FaceLoginConfirmationFragment.Companion.getAuthRequestContext(new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showFaceLoginConfirmation$dialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
                if (button != null) {
                    button.setEnabled(true);
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showFaceLoginConfirmation$dialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
                if (button != null) {
                    button.setEnabled(false);
                }
                if (p0 == 2) {
                    VerifyNumberFragment.this.getAuthRequestContext();
                } else {
                    VerifyNumberFragment.this.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showFaceLoginConfirmation$dialog$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
                if (button != null) {
                    button.setEnabled(false);
                }
                VerifyNumberFragment.getCallingPid(VerifyNumberFragment.this);
            }
        }).show(getParentFragmentManager(), "TAG_FACE_LOGIN_CONFIRMATION_DIALOG");
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(this);
        builder.scheduleImpl = ChallengeScenario.TRUST_RISK_LOGIN;
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (str == null) {
            str = "";
        }
        builder.getSupportButtonTintMode = str;
        String str2 = this.SubSequence;
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = str2 != null ? str2 : "";
        boolean z = this.scheduleImpl;
        FaceAuthenticationModel faceAuthenticationModel = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str3 = faceAuthenticationModel != null ? faceAuthenticationModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        FaceAuthenticationModel faceAuthenticationModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        ChallengeControl.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(z, str3, faceAuthenticationModel2 != null ? faceAuthenticationModel2.PlaceComponentResult : null);
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        BuiltInFictitiousFunctionClassFactory.newProxyInstance = this.moveToNextValue;
        BuiltInFictitiousFunctionClassFactory.isLayoutRequested = this.lookAheadTest;
        new ChallengeControl(BuiltInFictitiousFunctionClassFactory, defaultConstructorMarker).getAuthRequestContext();
    }

    public final void getAuthRequestContext() {
        String str;
        VerificationTreeNode verificationTreeNode;
        List<VerificationTreeNode> children;
        Object obj;
        ChallengeControl.Builder builder = new ChallengeControl.Builder(this);
        builder.scheduleImpl = ChallengeScenario.TRUST_RISK_LOGIN_V2;
        String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (str2 == null) {
            str2 = "";
        }
        builder.getSupportButtonTintMode = str2;
        String str3 = this.SubSequence;
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = str3 != null ? str3 : "";
        boolean z = this.scheduleImpl;
        Trust2RiskLoginModel trust2RiskLoginModel = this.A;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str4 = trust2RiskLoginModel != null ? trust2RiskLoginModel.moveToNextValue : null;
        LoginAuthenticationMethod loginAuthenticationMethod = new LoginAuthenticationMethod();
        Trust2RiskLoginModel trust2RiskLoginModel2 = this.A;
        if (trust2RiskLoginModel2 != null && (verificationTreeNode = trust2RiskLoginModel2.KClassImpl$Data$declaredNonStaticMembers$2) != null && (children = verificationTreeNode.getChildren()) != null) {
            Iterator<T> it = children.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual("MIC_FACE", ((VerificationTreeNode) obj).getValue())) {
                    break;
                }
            }
            VerificationTreeNode verificationTreeNode2 = (VerificationTreeNode) obj;
            if (verificationTreeNode2 != null) {
                str = verificationTreeNode2.getValue();
                loginAuthenticationMethod.getAuthRequestContext = str;
                loginAuthenticationMethod.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                loginAuthenticationMethod.BuiltInFictitiousFunctionClassFactory = Intrinsics.areEqual(str, "MIC_FACE");
                Unit unit = Unit.INSTANCE;
                ChallengeControl.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(z, str4, loginAuthenticationMethod);
                BuiltInFictitiousFunctionClassFactory.getValueOfTouchPositionAbsolute = this.A;
                BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                BuiltInFictitiousFunctionClassFactory.isLayoutRequested = this.lookAheadTest;
                new ChallengeControl(BuiltInFictitiousFunctionClassFactory, defaultConstructorMarker).getAuthRequestContext();
            }
        }
        str = null;
        loginAuthenticationMethod.getAuthRequestContext = str;
        loginAuthenticationMethod.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        loginAuthenticationMethod.BuiltInFictitiousFunctionClassFactory = Intrinsics.areEqual(str, "MIC_FACE");
        Unit unit2 = Unit.INSTANCE;
        ChallengeControl.Builder BuiltInFictitiousFunctionClassFactory2 = builder.BuiltInFictitiousFunctionClassFactory(z, str4, loginAuthenticationMethod);
        BuiltInFictitiousFunctionClassFactory2.getValueOfTouchPositionAbsolute = this.A;
        BuiltInFictitiousFunctionClassFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        BuiltInFictitiousFunctionClassFactory2.isLayoutRequested = this.lookAheadTest;
        new ChallengeControl(BuiltInFictitiousFunctionClassFactory2, defaultConstructorMarker).getAuthRequestContext();
    }

    private static String MyBillsEntityDataFactory(Intent p0) {
        Bundle extras;
        String string = (p0 == null || (extras = p0.getExtras()) == null) ? null : extras.getString(ChallengeControl.Key.CANCEL_REASON);
        return string == null ? "" : string;
    }

    private final void PlaceComponentResult(String p0, Bundle p1) {
        FragmentPermissionRequest fragmentPermissionRequest = null;
        switch (p0.hashCode()) {
            case -1916202598:
                if (p0.equals(ChallengeControl.CancelReason.VERIFY_PASSWORD_TRUST_RISK_EXPIRED)) {
                    if (getContext() != null) {
                        Context requireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "");
                        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
                        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.verify_password_expired_dialog_description);
                        builder.lookAheadTest = Boolean.FALSE;
                        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.verify_password_expired_dialog_title);
                        builder.PrepareContext = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.verify_password_expired_dialog_button);
                        builder.getErrorConfigVersion = true;
                        DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
                        FragmentManager parentFragmentManager = getParentFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                        Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                        BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
                        return;
                    }
                    return;
                }
                break;
            case -305104263:
                if (p0.equals("forgot_pin")) {
                    FragmentPermissionRequest fragmentPermissionRequest2 = this.whenAvailable;
                    if (fragmentPermissionRequest2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        fragmentPermissionRequest = fragmentPermissionRequest2;
                    }
                    fragmentPermissionRequest.check();
                    return;
                }
                break;
            case -109866462:
                if (p0.equals(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED)) {
                    DialogWithImage.BuiltInFictitiousFunctionClassFactory(getBaseActivity(), new DialogInterface.OnClickListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            VerifyNumberFragment.getAuthRequestContext(VerifyNumberFragment.this, dialogInterface, i);
                        }
                    }).MyBillsEntityDataFactory();
                    return;
                }
                break;
            case 462997423:
                if (p0.equals(ChallengeControl.CancelReason.SESSION_EXPIRED)) {
                    if (getContext() != null) {
                        Context requireContext2 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext2, "");
                        DanaAlertDialog.Builder builder2 = new DanaAlertDialog.Builder(requireContext2);
                        builder2.moveToNextValue = builder2.BuiltInFictitiousFunctionClassFactory.getString(R.string.session_expired_dialog_description);
                        builder2.lookAheadTest = Boolean.FALSE;
                        builder2.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder2.BuiltInFictitiousFunctionClassFactory.getString(R.string.session_expired_dialog_title);
                        builder2.PrepareContext = builder2.BuiltInFictitiousFunctionClassFactory.getString(R.string.session_expired_dialog_button);
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showSessionExpiredDialog$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Context context = VerifyNumberFragment.this.getContext();
                                Object systemService = context != null ? context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY) : null;
                                ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
                                if (activityManager != null) {
                                    activityManager.clearApplicationUserData();
                                }
                            }
                        };
                        Intrinsics.checkNotNullParameter(function0, "");
                        builder2.newProxyInstance = function0;
                        DanaAlertDialog BuiltInFictitiousFunctionClassFactory2 = builder2.BuiltInFictitiousFunctionClassFactory();
                        FragmentManager parentFragmentManager2 = getParentFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(parentFragmentManager2, "");
                        Intrinsics.checkNotNullParameter(parentFragmentManager2, "");
                        BuiltInFictitiousFunctionClassFactory2.show(parentFragmentManager2, "DanaAlertDialog");
                        return;
                    }
                    return;
                }
                break;
            case 495659250:
                if (p0.equals(ChallengeControl.CancelReason.ACCOUNT_FROZEN)) {
                    String string = p1 != null ? p1.getString("message") : null;
                    LoginInfoDialog.Builder builder3 = new LoginInfoDialog.Builder(getBaseActivity());
                    builder3.initRecordTimeStamp = getString(R.string.lbl_dialog_account_freeze);
                    builder3.PlaceComponentResult = string;
                    LoginInfoDialog.Builder MyBillsEntityDataFactory = builder3.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory = false;
                    MyBillsEntityDataFactory.getErrorConfigVersion = R.drawable.rounded_white_8dp;
                    MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.ACCOUNT_LOCK;
                    Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                    String string2 = getString(R.string.lbl_dialog_call_customer_care);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            VerifyNumberFragment.MyBillsEntityDataFactory(VerifyNumberFragment.this);
                        }
                    };
                    MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = string2;
                    MyBillsEntityDataFactory.moveToNextValue = onClickListener;
                    LoginInfoDialog loginInfoDialog = new LoginInfoDialog(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory, (byte) 0);
                    loginInfoDialog.MyBillsEntityDataFactory();
                    this.isLayoutRequested = loginInfoDialog;
                    return;
                }
                break;
        }
        MyBillsEntityDataFactory(p1);
    }

    private final void MyBillsEntityDataFactory(Bundle p0) {
        String string = p0 != null ? p0.getString("message") : null;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        getBaseActivity().showWarningDialog(string);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getBaseActivity().getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.ACCOUNT_LOCK_HELP;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Action", p0);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    private static boolean BuiltInFictitiousFunctionClassFactory() {
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        return OauthLoginManager.moveToNextValue() != null;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_touch_screen", RDSConstant.PHONE_NUMBER_TOUCH, motionEvent.getX(), motionEvent.getY()));
        return true;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberFragment$Companion;", "", "Lid/dana/onboarding/verify/VerifyNumberFragment;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/onboarding/verify/VerifyNumberFragment;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)Lid/dana/onboarding/verify/VerifyNumberFragment;", "", "p1", "p2", "p3", "p4", "(Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;)Lid/dana/onboarding/verify/VerifyNumberFragment;", "moveToNextValue", "Ljava/lang/String;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static VerifyNumberFragment BuiltInFictitiousFunctionClassFactory() {
            return new VerifyNumberFragment();
        }

        @JvmStatic
        public static VerifyNumberFragment KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
            VerifyNumberFragment verifyNumberFragment = new VerifyNumberFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("FROM_LOGOUT", p0);
            verifyNumberFragment.setArguments(bundle);
            return verifyNumberFragment;
        }

        @JvmStatic
        public static VerifyNumberFragment KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1, String p2, boolean p3, String p4) {
            VerifyNumberFragment verifyNumberFragment = new VerifyNumberFragment();
            Bundle bundle = new Bundle();
            bundle.putString("phoneNumber", p0);
            bundle.putBoolean("isEditablePhoneNumber", p1);
            bundle.putString("source", p2);
            bundle.putBoolean("fromCitcall", p3);
            bundle.putString(ChallengeControl.Key.SECURITY_ID, p4);
            verifyNumberFragment.setArguments(bundle);
            return verifyNumberFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyNumberFragment verifyNumberFragment) {
        InputPhoneView inputPhoneView;
        Intrinsics.checkNotNullParameter(verifyNumberFragment, "");
        EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_lost_focus", RDSConstant.PHONE_NUMBER_LOST_FOCUS, false), new RDSEvent("Onboarding", "rds_on_control_click", RDSConstant.PHONE_NUMBER_CONTINUE_BUTTON));
        BaseActivity baseActivity = verifyNumberFragment.getBaseActivity();
        if (baseActivity != null) {
            KeyboardHelper.MyBillsEntityDataFactory((KeyBaseActivity) baseActivity);
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding = (FragmentVerifyNumberBinding) verifyNumberFragment.getBinding();
            Lazy<VerifyNumberContract.Presenter> lazy = null;
            String completePhoneNumber = (fragmentVerifyNumberBinding == null || (inputPhoneView = fragmentVerifyNumberBinding.PlaceComponentResult) == null) ? null : inputPhoneView.getCompletePhoneNumber();
            String replace$default = StringsKt.replace$default(completePhoneNumber == null ? "" : completePhoneNumber, "+", "", false, 4, (Object) null);
            Lazy<VerifyNumberContract.Presenter> lazy2 = verifyNumberFragment.verifyPresenter;
            if (lazy2 != null) {
                lazy = lazy2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            lazy.get().KClassImpl$Data$declaredNonStaticMembers$2(replace$default);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }

    public static /* synthetic */ void getAuthRequestContext(VerifyNumberFragment verifyNumberFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(verifyNumberFragment, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i == -2) {
            dialogInterface.dismiss();
            verifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.AccountLockProperty.WAIT);
        } else if (i == -1) {
            FragmentPermissionRequest fragmentPermissionRequest = verifyNumberFragment.whenAvailable;
            if (fragmentPermissionRequest == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                fragmentPermissionRequest = null;
            }
            fragmentPermissionRequest.check();
            dialogInterface.dismiss();
            verifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.AccountLockProperty.CALL_HELP);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(VerifyNumberFragment verifyNumberFragment) {
        Intrinsics.checkNotNullParameter(verifyNumberFragment, "");
        LoginInfoDialog loginInfoDialog = verifyNumberFragment.isLayoutRequested;
        if (loginInfoDialog != null) {
            loginInfoDialog.getAuthRequestContext();
        }
        FragmentPermissionRequest fragmentPermissionRequest = null;
        Lazy<VerifyNumberContract.Presenter> lazy = null;
        if (!verifyNumberFragment.moveToNextValue) {
            FragmentPermissionRequest fragmentPermissionRequest2 = verifyNumberFragment.whenAvailable;
            if (fragmentPermissionRequest2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                fragmentPermissionRequest = fragmentPermissionRequest2;
            }
            fragmentPermissionRequest.check();
            return;
        }
        Lazy<VerifyNumberContract.Presenter> lazy2 = verifyNumberFragment.verifyPresenter;
        if (lazy2 != null) {
            lazy = lazy2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        lazy.get().MyBillsEntityDataFactory("pinIncorrectTemporaryFreezeModal");
    }

    public static /* synthetic */ void getAuthRequestContext(boolean z) {
        if (z) {
            EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_lost_focus", RDSConstant.PHONE_NUMBER_GET_FOCUS, true));
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory() {
        DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.Property.RENDER_PHONE_NUMBER_SCREEN, System.currentTimeMillis());
        DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.Property.USER_IDLE_PHONE_NUMBER_SCREEN, System.currentTimeMillis());
    }

    public static /* synthetic */ void PlaceComponentResult(VerifyNumberFragment verifyNumberFragment, boolean z, String str) {
        Intrinsics.checkNotNullParameter(verifyNumberFragment, "");
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = null;
        if (verifyNumberFragment.readMicros && z) {
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu2 = verifyNumberFragment.PrepareContext;
            if (onboardingNavigationManagerWithMenu2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                onboardingNavigationManagerWithMenu = onboardingNavigationManagerWithMenu2;
            }
            if (str == null) {
                str = "";
            }
            String str2 = verifyNumberFragment.getCallingPid;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            VerifyReferralCodeKey verifyReferralCodeKey = new VerifyReferralCodeKey(str, str2);
            Intrinsics.checkNotNullParameter(verifyReferralCodeKey, "");
            onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(verifyReferralCodeKey);
            return;
        }
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu3 = verifyNumberFragment.PrepareContext;
        if (onboardingNavigationManagerWithMenu3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu3 = null;
        }
        String str3 = str != null ? str : "";
        String prependZeroToPhoneNumber = NumberUtils.prependZeroToPhoneNumber(str);
        Intrinsics.checkNotNullExpressionValue(prependZeroToPhoneNumber, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(prependZeroToPhoneNumber, "");
        CreatePinKey.Companion companion = CreatePinKey.INSTANCE;
        CreatePinKey BuiltInFictitiousFunctionClassFactory = CreatePinKey.Companion.BuiltInFictitiousFunctionClassFactory(str3, prependZeroToPhoneNumber, null, null);
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        onboardingNavigationManagerWithMenu3.getAuthRequestContext.goTo(BuiltInFictitiousFunctionClassFactory);
    }

    public static /* synthetic */ void PlaceComponentResult(VerifyNumberFragment verifyNumberFragment) {
        Intrinsics.checkNotNullParameter(verifyNumberFragment, "");
        verifyNumberFragment.onBackPressed();
    }

    public static final /* synthetic */ void PlaceComponentResult(VerifyNumberFragment verifyNumberFragment, boolean z) {
        String str;
        InputPhoneView inputPhoneView;
        InputPhoneView inputPhoneView2;
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        String scheduleImpl = OauthLoginManager.scheduleImpl();
        boolean MyBillsEntityDataFactory = AppUtil.MyBillsEntityDataFactory(verifyNumberFragment.getContext());
        EnrollPasskeyLauncher.Companion companion = EnrollPasskeyLauncher.INSTANCE;
        boolean PlaceComponentResult = EnrollPasskeyLauncher.Companion.PlaceComponentResult();
        OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
        String str2 = null;
        if (OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda8()) {
            Lazy<VerifyNumberContract.Presenter> lazy = verifyNumberFragment.verifyPresenter;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            VerifyNumberContract.Presenter presenter = lazy.get();
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding = (FragmentVerifyNumberBinding) verifyNumberFragment.getBinding();
            if (fragmentVerifyNumberBinding != null && (inputPhoneView2 = fragmentVerifyNumberBinding.PlaceComponentResult) != null) {
                str2 = inputPhoneView2.getCompletePhoneNumber();
            }
            String str3 = str2 != null ? str2 : "";
            OauthLoginManager oauthLoginManager3 = OauthLoginManager.INSTANCE;
            String BuiltInFictitiousFunctionClassFactory = OauthLoginManager.BuiltInFictitiousFunctionClassFactory();
            OauthLoginManager oauthLoginManager4 = OauthLoginManager.INSTANCE;
            presenter.PlaceComponentResult(new CheckRegistrationRequest(str3, null, BuiltInFictitiousFunctionClassFactory, OauthLoginManager.MyBillsEntityDataFactory(), scheduleImpl, MyBillsEntityDataFactory, Boolean.valueOf(z), PlaceComponentResult, 2, null), verifyNumberFragment.moveToNextValue);
            return;
        }
        Lazy<VerifyNumberContract.Presenter> lazy2 = verifyNumberFragment.verifyPresenter;
        if (lazy2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy2 = null;
        }
        VerifyNumberContract.Presenter presenter2 = lazy2.get();
        if (!verifyNumberFragment.DatabaseTableConfigUtil) {
            FragmentVerifyNumberBinding fragmentVerifyNumberBinding2 = (FragmentVerifyNumberBinding) verifyNumberFragment.getBinding();
            if (fragmentVerifyNumberBinding2 != null && (inputPhoneView = fragmentVerifyNumberBinding2.PlaceComponentResult) != null) {
                str2 = inputPhoneView.getCompletePhoneNumber();
            }
            str = str2 == null ? "" : str2;
        } else {
            String str4 = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().lookAheadTest;
            if (str4 == null) {
                str4 = "";
            }
            Regex regex = new Regex("62-");
            String string = verifyNumberFragment.getString(R.string.id_prefix);
            Intrinsics.checkNotNullExpressionValue(string, "");
            str = regex.replaceFirst(str4, string);
        }
        presenter2.getAuthRequestContext(str, verifyNumberFragment.moveToNextValue, MyBillsEntityDataFactory, z, PlaceComponentResult);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getParentFragmentManager().isStateSaved()) {
            return;
        }
        ((DanaLoadingDialogFragment) verifyNumberFragment.getAuthRequestContext.getValue()).dismissNow();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(VerifyNumberFragment verifyNumberFragment) {
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = null;
        if (verifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu2 = verifyNumberFragment.PrepareContext;
            if (onboardingNavigationManagerWithMenu2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                onboardingNavigationManagerWithMenu = onboardingNavigationManagerWithMenu2;
            }
            onboardingNavigationManagerWithMenu.BuiltInFictitiousFunctionClassFactory(verifyNumberFragment.PlaceComponentResult);
            return;
        }
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu3 = verifyNumberFragment.PrepareContext;
        if (onboardingNavigationManagerWithMenu3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            onboardingNavigationManagerWithMenu = onboardingNavigationManagerWithMenu3;
        }
        onboardingNavigationManagerWithMenu.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ DanaConfirmationBottomSheetDialog lookAheadTest(VerifyNumberFragment verifyNumberFragment) {
        return (DanaConfirmationBottomSheetDialog) verifyNumberFragment.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory(VerifyNumberFragment verifyNumberFragment, long j) {
        String replace = new Regex("^(\\+628)").replace(verifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda6, "62-8");
        Uri.Builder appendQueryParameter = Uri.parse("https://m.dana.id/i/dana-info/resolution-center/chatbot").buildUpon().appendQueryParameter(RVParams.LONG_URL_WITH_ENTRY_KEY, "pinIncorrectTemporaryFreezeModal").appendQueryParameter(SemanticAttributes.MessagingDestinationKindValues.TOPIC, "ACCOUNT_AND_SECURITY").appendQueryParameter("subtopic", "ACCOUNT_PIN_RESET").appendQueryParameter("phoneNumber", replace).appendQueryParameter(NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "RESOCENTER_FREEZE_ACCOUNT").appendQueryParameter("journeySlug", "incorrectPinTemporaryFreeze").appendQueryParameter("nonLogin", SummaryActivity.CHECKED);
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append('_');
        sb.append(String.valueOf(j / 1000));
        sb.append('_');
        Lazy<DeviceInformationProvider> lazy = verifyNumberFragment.deviceInformationProvider;
        Lazy<DeviceInformationProvider> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        sb.append(lazy.get().getDeviceUtdId());
        sb.append("_account_freeze_account");
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("ymAuthenticationToken", sb.toString());
        Lazy<DeviceInformationProvider> lazy3 = verifyNumberFragment.deviceInformationProvider;
        if (lazy3 != null) {
            lazy2 = lazy3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        String obj = appendQueryParameter2.appendQueryParameter("utdid", lazy2.get().getDeviceUtdId()).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final /* synthetic */ String PlaceComponentResult(VerifyNumberFragment verifyNumberFragment, long j, String str, NetworkException networkException) {
        String replace = new Regex("^(\\+628)").replace(str, "62-8");
        Uri.Builder appendQueryParameter = Uri.parse("https://m.dana.id/i/dana-info/resolution-center/chatbot").buildUpon().appendQueryParameter(RVParams.LONG_URL_WITH_ENTRY_KEY, "nonLoginRecoveryAccount").appendQueryParameter(SemanticAttributes.MessagingDestinationKindValues.TOPIC, "ACCOUNT_AND_SECURITY").appendQueryParameter("subtopic", "ACCOUNT_TAKE_OVER_RECOVERY_ACCOUNT").appendQueryParameter("phoneNumber", replace).appendQueryParameter("errorCode", networkException.getErrorCode()).appendQueryParameter("errorMessage", networkException.getMessage()).appendQueryParameter(NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "NONLOGIN_NO_RISK_CONSULT_SCENE").appendQueryParameter("journeySlug", "nonLoginRecoveryAccount");
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append('_');
        sb.append(String.valueOf(j / 1000));
        sb.append('_');
        Lazy<DeviceInformationProvider> lazy = verifyNumberFragment.deviceInformationProvider;
        Lazy<DeviceInformationProvider> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        sb.append(lazy.get().getDeviceUtdId());
        sb.append("_ACCOUNT_TAKE_OVER_RECOVERY_ACCOUNT");
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("ymAuthenticationToken", sb.toString());
        Lazy<DeviceInformationProvider> lazy3 = verifyNumberFragment.deviceInformationProvider;
        if (lazy3 != null) {
            lazy2 = lazy3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        String obj = appendQueryParameter2.appendQueryParameter("utdid", lazy2.get().getDeviceUtdId()).appendQueryParameter("nonLogin", SummaryActivity.CHECKED).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final /* synthetic */ String getAuthRequestContext(VerifyNumberFragment verifyNumberFragment, long j, String str) {
        String replace = new Regex("^(\\+628)").replace(str, "62-8");
        Uri.Builder appendQueryParameter = Uri.parse("https://m.dana.id/i/dana-info/resolution-center/chatbot").buildUpon().appendQueryParameter(RVParams.LONG_URL_WITH_ENTRY_KEY, "nativeLogin").appendQueryParameter(SemanticAttributes.MessagingDestinationKindValues.TOPIC, "ACCOUNT_AND_SECURITY").appendQueryParameter("subtopic", "ACCOUNT_FROZEN").appendQueryParameter("phoneNumber", replace).appendQueryParameter(NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "RESOCENTER_FREEZE_ACCOUNT").appendQueryParameter("journeySlug", "accountFrozen");
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append('_');
        sb.append(String.valueOf(j / 1000));
        sb.append('_');
        Lazy<DeviceInformationProvider> lazy = verifyNumberFragment.deviceInformationProvider;
        Lazy<DeviceInformationProvider> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        sb.append(lazy.get().getDeviceUtdId());
        sb.append("_account_freeze_login}");
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("ymAuthenticationToken", sb.toString());
        Lazy<DeviceInformationProvider> lazy3 = verifyNumberFragment.deviceInformationProvider;
        if (lazy3 != null) {
            lazy2 = lazy3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        String obj = appendQueryParameter2.appendQueryParameter("utdid", lazy2.get().getDeviceUtdId()).appendQueryParameter("nonLogin", SummaryActivity.CHECKED).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final /* synthetic */ FirebasePerformanceMonitor initRecordTimeStamp(VerifyNumberFragment verifyNumberFragment) {
        return (FirebasePerformanceMonitor) verifyNumberFragment.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void PlaceComponentResult(VerifyNumberFragment verifyNumberFragment, String str, int i, int i2, String str2, boolean z, boolean z2) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(verifyNumberFragment);
        builder.scheduleImpl = ChallengeScenario.REGISTRATION;
        if (str == null) {
            str = "";
        }
        builder.getSupportButtonTintMode = str;
        if (str2 == null) {
            str2 = "";
        }
        builder.E = str2;
        ChallengeControl.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(i2, i, verifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda4, z2);
        FragmentActivity activity = verifyNumberFragment.getActivity();
        DefaultConstructorMarker defaultConstructorMarker = null;
        OnboardingActivity onboardingActivity = activity instanceof OnboardingActivity ? (OnboardingActivity) activity : null;
        String otpPurpose = onboardingActivity != null ? onboardingActivity.getOtpPurpose() : null;
        KClassImpl$Data$declaredNonStaticMembers$2.SubSequence = otpPurpose != null ? otpPurpose : "";
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = verifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = verifyNumberFragment.moveToNextValue;
        KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested = verifyNumberFragment.lookAheadTest;
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4 = z;
        new ChallengeControl(KClassImpl$Data$declaredNonStaticMembers$2, defaultConstructorMarker).getAuthRequestContext();
    }

    public static final /* synthetic */ void PlaceComponentResult(VerifyNumberFragment verifyNumberFragment, String str, String str2, String str3, List list) {
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -1874218814:
                    if (str2.equals(CheckUserAction.TRUST_RISK_LOGIN)) {
                        if (verifyNumberFragment.scheduleImpl) {
                            verifyNumberFragment.MyBillsEntityDataFactory(1);
                            return;
                        } else {
                            verifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2();
                            return;
                        }
                    }
                    return;
                case -1473941087:
                    if (str2.equals(CheckUserAction.LOGIN)) {
                        ChallengeControl.Builder builder = new ChallengeControl.Builder(verifyNumberFragment);
                        builder.scheduleImpl = "login";
                        String str4 = verifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda6;
                        if (str4 == null) {
                            str4 = "";
                        }
                        builder.getSupportButtonTintMode = str4;
                        String str5 = verifyNumberFragment.SubSequence;
                        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = str5 != null ? str5 : "";
                        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = verifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                        builder.newProxyInstance = verifyNumberFragment.moveToNextValue;
                        builder.isLayoutRequested = verifyNumberFragment.lookAheadTest;
                        new ChallengeControl(builder, null).getAuthRequestContext();
                        return;
                    }
                    return;
                case -277745863:
                    if (str2.equals(CheckUserAction.TRUST_RISK_LOGIN_V2)) {
                        if (verifyNumberFragment.scheduleImpl) {
                            verifyNumberFragment.MyBillsEntityDataFactory(2);
                            return;
                        } else {
                            verifyNumberFragment.getAuthRequestContext();
                            return;
                        }
                    }
                    return;
                case 520970604:
                    if (str2.equals(CheckUserAction.REGISTER)) {
                        Bundle bundle = new Bundle();
                        Intent intent = new Intent(verifyNumberFragment.getContext(), CarrierIdentificationVerifyActivity.class);
                        bundle.putString(ChallengeControl.Key.SCENARIO, ChallengeScenario.REGISTRATION);
                        bundle.putString(ChallengeControl.Key.SECURITY_ID, str3);
                        bundle.putString(ChallengeControl.Key.PHONE_NUMBER, str);
                        bundle.putParcelableArrayList(ChallengePinWithFaceActivity.LOGIN_AUTHENTICATION_OPTIONS, (ArrayList) list);
                        intent.putExtras(bundle);
                        CarrierIdentificationVerifyActivity.Companion companion = CarrierIdentificationVerifyActivity.INSTANCE;
                        verifyNumberFragment.startActivityForResult(intent, CarrierIdentificationVerifyActivity.Companion.MyBillsEntityDataFactory());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(VerifyNumberFragment verifyNumberFragment, PermissionResult permissionResult) {
        Lazy<PermissionStateContract.Presenter> lazy = null;
        r2 = null;
        Object obj = null;
        if (permissionResult.MyBillsEntityDataFactory()) {
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(verifyNumberFragment.getBaseActivity().getApplicationContext(), true);
            Lazy<LocationPermissionSubject> lazy2 = verifyNumberFragment.locationPermissionSubject;
            if (lazy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy2 = null;
            }
            LocationPermissionSubject locationPermissionSubject = lazy2.get();
            Object obj2 = locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.get();
            if (!NotificationLite.isComplete(obj2) && !NotificationLite.isError(obj2)) {
                obj = NotificationLite.getValue(obj2);
            }
            if (!Intrinsics.areEqual(obj, Boolean.TRUE)) {
                locationPermissionSubject.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.TRUE);
            }
        } else {
            Lazy<LocationPermissionSubject> lazy3 = verifyNumberFragment.locationPermissionSubject;
            if (lazy3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy3 = null;
            }
            LocationPermissionSubject locationPermissionSubject2 = lazy3.get();
            Object obj3 = locationPermissionSubject2.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.get();
            if (!Intrinsics.areEqual((NotificationLite.isComplete(obj3) || NotificationLite.isError(obj3)) ? null : NotificationLite.getValue(obj3), Boolean.FALSE)) {
                locationPermissionSubject2.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.FALSE);
            }
            Lazy<PermissionStateContract.Presenter> lazy4 = verifyNumberFragment.permissionStatePresenter;
            if (lazy4 != null) {
                lazy = lazy4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            lazy.get().MyBillsEntityDataFactory(true);
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(verifyNumberFragment.getBaseActivity().getApplicationContext(), false);
        }
        verifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyNumberFragment verifyNumberFragment, String str) {
        DanaLoadingDialogFragment danaLoadingDialogFragment = (DanaLoadingDialogFragment) verifyNumberFragment.getAuthRequestContext.getValue();
        FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        danaLoadingDialogFragment.showNow(parentFragmentManager, "FullDanaLoading");
        DanaH5.startContainerFullUrlWithoutTimeout(str, new DanaH5Listener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$openContainerWithoutTimeout$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                DanaH5.dispose();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                VerifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2(VerifyNumberFragment.this);
            }
        });
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda3(VerifyNumberFragment verifyNumberFragment) {
        Context applicationContext;
        Context applicationContext2;
        int i = Build.VERSION.SDK_INT >= 31 ? 67108864 : 0;
        FragmentActivity activity = verifyNumberFragment.getActivity();
        PendingIntent activity2 = PendingIntent.getActivity(activity != null ? activity.getApplicationContext() : null, 0, new Intent(), i);
        Intent intent = new Intent();
        intent.setPackage("com.whatsapp");
        intent.setAction("com.whatsapp.otp.OTP_REQUESTED");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        PendingIntent pendingIntent = activity2;
        extras.putParcelable(WhatsAppOtpReceiver.CI, pendingIntent);
        intent.putExtras(extras);
        FragmentActivity activity3 = verifyNumberFragment.getActivity();
        if (activity3 != null && (applicationContext2 = activity3.getApplicationContext()) != null) {
            applicationContext2.sendBroadcast(intent);
        }
        Intrinsics.checkNotNullExpressionValue(activity2, "");
        Intent intent2 = new Intent();
        intent2.setPackage(AppPackageName.WHATSAPP_FOR_BUSINESS);
        intent2.setAction("com.whatsapp.otp.OTP_REQUESTED");
        Bundle extras2 = intent2.getExtras();
        if (extras2 == null) {
            extras2 = new Bundle();
        }
        extras2.putParcelable(WhatsAppOtpReceiver.CI, pendingIntent);
        intent2.putExtras(extras2);
        FragmentActivity activity4 = verifyNumberFragment.getActivity();
        if (activity4 == null || (applicationContext = activity4.getApplicationContext()) == null) {
            return;
        }
        applicationContext.sendBroadcast(intent2);
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda6(VerifyNumberFragment verifyNumberFragment) {
        String enTitle;
        List<LinkInfo> linkInfo;
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        boolean PlaceComponentResult = LocaleUtil.PlaceComponentResult();
        LocaleUtil localeUtil2 = LocaleUtil.INSTANCE;
        if (LocaleUtil.PlaceComponentResult()) {
            OnboardingWarningTextConfig onboardingWarningTextConfig = verifyNumberFragment.C;
            if (onboardingWarningTextConfig != null) {
                enTitle = onboardingWarningTextConfig.getIdTitle();
            }
            enTitle = null;
        } else {
            OnboardingWarningTextConfig onboardingWarningTextConfig2 = verifyNumberFragment.C;
            if (onboardingWarningTextConfig2 != null) {
                enTitle = onboardingWarningTextConfig2.getEnTitle();
            }
            enTitle = null;
        }
        if (enTitle == null) {
            enTitle = verifyNumberFragment.getString(R.string.input_phone_number_warning_text);
            Intrinsics.checkNotNullExpressionValue(enTitle, "");
        }
        Spanned PlaceComponentResult2 = HtmlCompat.PlaceComponentResult(enTitle, 0);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        SpannableString spannableString = new SpannableString(PlaceComponentResult2);
        OnboardingWarningTextConfig onboardingWarningTextConfig3 = verifyNumberFragment.C;
        if (onboardingWarningTextConfig3 != null && (linkInfo = onboardingWarningTextConfig3.getLinkInfo()) != null) {
            for (LinkInfo linkInfo2 : linkInfo) {
                String idHyperlink = PlaceComponentResult ? linkInfo2.getIdHyperlink() : linkInfo2.getEnHyperlink();
                if (idHyperlink == null) {
                    idHyperlink = "";
                }
                final String link = linkInfo2.getLink();
                int indexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, idHyperlink, 0, false, 6, (Object) null);
                spannableString.setSpan(new ClickableSpan() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$addClickableSpan$clickableSpan$1
                    @Override // android.text.style.ClickableSpan
                    public final void onClick(View p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        VerifyNumberFragment verifyNumberFragment2 = VerifyNumberFragment.this;
                        String authRequestContext = UrlUtil.getAuthRequestContext(link);
                        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                        VerifyNumberFragment.BuiltInFictitiousFunctionClassFactory(verifyNumberFragment2, authRequestContext);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public final void updateDrawState(TextPaint p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        p0.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(VerifyNumberFragment.this.requireContext(), R.color.f27072131100488));
                    }
                }, indexOf$default, idHyperlink.length() + indexOf$default, 33);
            }
        }
        FragmentVerifyNumberBinding fragmentVerifyNumberBinding = (FragmentVerifyNumberBinding) verifyNumberFragment.getBinding();
        AppCompatTextView appCompatTextView = fragmentVerifyNumberBinding != null ? fragmentVerifyNumberBinding.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(spannableString);
        }
        FragmentVerifyNumberBinding fragmentVerifyNumberBinding2 = (FragmentVerifyNumberBinding) verifyNumberFragment.getBinding();
        AppCompatTextView appCompatTextView2 = fragmentVerifyNumberBinding2 != null ? fragmentVerifyNumberBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerifyNumberFragment verifyNumberFragment, final String str, final NetworkException networkException, final long j) {
        if (verifyNumberFragment.getContext() != null) {
            Context requireContext = verifyNumberFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.account_take_over_title);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.res_0x7f0808da_kclassimpl_data_declarednonstaticmembers_2;
            builder.PlaceComponentResult = 128;
            builder.MyBillsEntityDataFactory = 128;
            String message = networkException.getMessage();
            if (message == null) {
                message = verifyNumberFragment.getString(R.string.account_take_over_desc);
            }
            builder.moveToNextValue = message;
            String string = verifyNumberFragment.getString(R.string.close);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            String str2 = upperCase;
            Intrinsics.checkNotNullParameter(str2, "");
            builder.initRecordTimeStamp = str2;
            String string2 = verifyNumberFragment.getString(R.string.account_take_over_chat_diana);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String upperCase2 = string2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "");
            String str3 = upperCase2;
            Intrinsics.checkNotNullParameter(str3, "");
            builder.PrepareContext = str3;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showAccountTakeOverDialog$dialog$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VerifyNumberFragment verifyNumberFragment2 = VerifyNumberFragment.this;
                    VerifyNumberFragment.BuiltInFictitiousFunctionClassFactory(verifyNumberFragment2, VerifyNumberFragment.PlaceComponentResult(verifyNumberFragment2, j, str, networkException));
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.newProxyInstance = function0;
            builder.lookAheadTest = Boolean.FALSE;
            builder.getErrorConfigVersion = false;
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            Intrinsics.checkNotNullParameter(parentFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda5(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            Lazy<RiskRejectDialog> lazy = verifyNumberFragment.riskRejectDialog;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            lazy.get();
            Context requireContext = verifyNumberFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            DanaAlertDialog.Builder PlaceComponentResult = RiskRejectDialog.PlaceComponentResult(requireContext);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showAppForceUpdateDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Utils.getAuthRequestContext((Activity) VerifyNumberFragment.this.requireActivity());
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            PlaceComponentResult.newProxyInstance = function0;
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
            FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            Intrinsics.checkNotNullParameter(parentFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
        }
    }

    public static final /* synthetic */ void SubSequence(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            Context requireContext = verifyNumberFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.otp_daily_limit_title);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
            builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.otp_daily_limit_desc);
            String string = verifyNumberFragment.getString(R.string.otp_daily_limit_got_it);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            String str = upperCase;
            Intrinsics.checkNotNullParameter(str, "");
            builder.PrepareContext = str;
            builder.lookAheadTest = Boolean.FALSE;
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            Intrinsics.checkNotNullParameter(parentFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
        }
    }

    public static final /* synthetic */ void getCallingPid(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            Context requireContext = verifyNumberFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.error_camera_denied_title);
            builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.error_camera_denied_subtitle);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_camera_denied;
            builder.lookAheadTest = Boolean.FALSE;
            builder.PrepareContext = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.error_camera_denied_ok_btn);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showErrorCameraPermission$dialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Lazy<LogoutContract.Presenter> lazy = VerifyNumberFragment.this.logoutPresenter;
                    if (lazy == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lazy = null;
                    }
                    lazy.get().KClassImpl$Data$declaredNonStaticMembers$2();
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.newProxyInstance = function0;
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            Intrinsics.checkNotNullParameter(parentFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
        }
    }

    public static final /* synthetic */ void readMicros(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            Context requireContext = verifyNumberFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_phone_number_incorrect_format;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.incorrect_phone_number_format_title);
            builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.incorrect_phone_number_format_desc);
            builder.PrepareContext = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.too_many_request_otp_understood);
            builder.lookAheadTest = Boolean.FALSE;
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            Intrinsics.checkNotNullParameter(parentFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
        }
    }

    public static final /* synthetic */ void whenAvailable(VerifyNumberFragment verifyNumberFragment) {
        DanaLoadingDialogFragment danaLoadingDialogFragment = (DanaLoadingDialogFragment) verifyNumberFragment.getAuthRequestContext.getValue();
        FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        danaLoadingDialogFragment.showNow(parentFragmentManager, "FullDanaLoading");
    }

    public static final /* synthetic */ void VerifyPinStateManager$executeRiskChallenge$2$1(VerifyNumberFragment verifyNumberFragment) {
        FragmentManager supportFragmentManager;
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PERMISSION_INFO_APPROVAL);
        verifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda8 = new OnboardingLocationPermissionListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$initOnboardingLocationPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Lazy<VerifyNumberContract.Presenter> lazy = VerifyNumberFragment.this.verifyPresenter;
                Lazy<VerifyNumberContract.Presenter> lazy2 = null;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get().MyBillsEntityDataFactory(true);
                Lazy<VerifyNumberContract.Presenter> lazy3 = VerifyNumberFragment.this.verifyPresenter;
                if (lazy3 != null) {
                    lazy2 = lazy3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                lazy2.get().KClassImpl$Data$declaredNonStaticMembers$2(p0.MyBillsEntityDataFactory(), TrackerDataKey.Source.ONBOARING_PAGE_LOCATION_PERMISSION);
                VerifyNumberFragment.getAuthRequestContext(VerifyNumberFragment.this, p0);
                FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PERMISSION_INFO_APPROVAL, "");
                Trace trace = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PERMISSION_INFO_APPROVAL);
                if (trace != null) {
                    trace.stop();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                VerifyNumberFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PERMISSION_INFO_APPROVAL, "");
                Trace trace = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PERMISSION_INFO_APPROVAL);
                if (trace != null) {
                    trace.stop();
                }
            }

            @Override // id.dana.onboarding.verify.locationpermission.OnboardingLocationPermissionListener
            public final void getAuthRequestContext() {
                Lazy<VerifyNumberContract.Presenter> lazy = VerifyNumberFragment.this.verifyPresenter;
                Lazy<PermissionStateContract.Presenter> lazy2 = null;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get().MyBillsEntityDataFactory(false);
                Lazy<PermissionStateContract.Presenter> lazy3 = VerifyNumberFragment.this.permissionStatePresenter;
                if (lazy3 != null) {
                    lazy2 = lazy3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                lazy2.get().MyBillsEntityDataFactory(true);
                VerifyNumberFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PERMISSION_INFO_APPROVAL, "");
                Trace trace = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PERMISSION_INFO_APPROVAL);
                if (trace != null) {
                    trace.stop();
                }
            }
        };
        OnboardingLocationPermissionFragment.Companion companion = OnboardingLocationPermissionFragment.INSTANCE;
        OnboardingLocationPermissionListener onboardingLocationPermissionListener = verifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (onboardingLocationPermissionListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingLocationPermissionListener = null;
        }
        OnboardingLocationPermissionFragment KClassImpl$Data$declaredNonStaticMembers$2 = OnboardingLocationPermissionFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(onboardingLocationPermissionListener);
        BaseActivity baseActivity = verifyNumberFragment.getBaseActivity();
        if (baseActivity == null || (supportFragmentManager = baseActivity.getSupportFragmentManager()) == null) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.show(supportFragmentManager, "OnboardingLocationPermissionFragment");
    }

    public static final /* synthetic */ void A(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                VerifyNumberFragment verifyNumberFragment2 = verifyNumberFragment;
                Lazy<RiskRejectDialog> lazy = verifyNumberFragment.riskRejectDialog;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get();
                Context requireContext = verifyNumberFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                DanaAlertDialog.Builder authRequestContext = RiskRejectDialog.getAuthRequestContext(requireContext);
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showRiskRejectBlacklistDialog$1$dialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        InputPhoneView inputPhoneView;
                        EditText input;
                        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        if (scheduleImpl == null || (inputPhoneView = scheduleImpl.PlaceComponentResult) == null || (input = inputPhoneView.getInput()) == null) {
                            return;
                        }
                        InputExtKt.MyBillsEntityDataFactory(input);
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                authRequestContext.newProxyInstance = function0;
                DanaAlertDialog BuiltInFictitiousFunctionClassFactory = authRequestContext.BuiltInFictitiousFunctionClassFactory();
                FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
                Result.m3179constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public static final /* synthetic */ void BottomSheetCardBindingView$watcherCardNumberView$1(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                VerifyNumberFragment verifyNumberFragment2 = verifyNumberFragment;
                Lazy<RiskRejectDialog> lazy = verifyNumberFragment.riskRejectDialog;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get();
                Context requireContext = verifyNumberFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                DanaAlertDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = RiskRejectDialog.KClassImpl$Data$declaredNonStaticMembers$2(requireContext);
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showRiskRejectRetry1DayDialog$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        InputPhoneView inputPhoneView;
                        EditText input;
                        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        if (scheduleImpl == null || (inputPhoneView = scheduleImpl.PlaceComponentResult) == null || (input = inputPhoneView.getInput()) == null) {
                            return;
                        }
                        InputExtKt.MyBillsEntityDataFactory(input);
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = function0;
                DanaAlertDialog BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
                Result.m3179constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public static final /* synthetic */ void C(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Lazy<RiskRejectDialog> lazy = verifyNumberFragment.riskRejectDialog;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get();
                Context requireContext = verifyNumberFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                DanaAlertDialog.Builder BuiltInFictitiousFunctionClassFactory = RiskRejectDialog.BuiltInFictitiousFunctionClassFactory(requireContext);
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showRiskRejectRetry7DayDialog$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        InputPhoneView inputPhoneView;
                        EditText input;
                        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        if (scheduleImpl == null || (inputPhoneView = scheduleImpl.PlaceComponentResult) == null || (input = inputPhoneView.getInput()) == null) {
                            return;
                        }
                        InputExtKt.MyBillsEntityDataFactory(input);
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                BuiltInFictitiousFunctionClassFactory.newProxyInstance = function0;
                DanaAlertDialog BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
                FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                BuiltInFictitiousFunctionClassFactory2.show(parentFragmentManager, "DanaAlertDialog");
                Result.m3179constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public static final /* synthetic */ void B(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                VerifyNumberFragment verifyNumberFragment2 = verifyNumberFragment;
                Lazy<RiskRejectDialog> lazy = verifyNumberFragment.riskRejectDialog;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get();
                Context requireContext = verifyNumberFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                DanaAlertDialog.Builder MyBillsEntityDataFactory = RiskRejectDialog.MyBillsEntityDataFactory(requireContext);
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$showRiskRejectSuspiciousDialog$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        InputPhoneView inputPhoneView;
                        EditText input;
                        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(VerifyNumberFragment.this);
                        if (scheduleImpl == null || (inputPhoneView = scheduleImpl.PlaceComponentResult) == null || (input = inputPhoneView.getInput()) == null) {
                            return;
                        }
                        InputExtKt.MyBillsEntityDataFactory(input);
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                MyBillsEntityDataFactory.newProxyInstance = function0;
                DanaAlertDialog BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
                Result.m3179constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(VerifyNumberFragment verifyNumberFragment, final boolean z, final String str) {
        LoginInfoDialog.Builder builder = new LoginInfoDialog.Builder(verifyNumberFragment.getBaseActivity());
        builder.PlaceComponentResult = verifyNumberFragment.getString(R.string.verification_success);
        builder.MyBillsEntityDataFactory = true;
        LoginInfoDialog.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.SUCCESS;
        Integer num = 1000;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = num.intValue();
        MyBillsEntityDataFactory.getAuthRequestContext = new DialogInterface.OnDismissListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VerifyNumberFragment.PlaceComponentResult(VerifyNumberFragment.this, z, str);
            }
        };
        LoginInfoDialog loginInfoDialog = new LoginInfoDialog(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory, (byte) 0);
        loginInfoDialog.MyBillsEntityDataFactory();
        verifyNumberFragment.isLayoutRequested = loginInfoDialog;
    }

    public static final /* synthetic */ void getOnBoardingScenario(VerifyNumberFragment verifyNumberFragment) {
        if (verifyNumberFragment.getContext() != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                VerifyNumberFragment verifyNumberFragment2 = verifyNumberFragment;
                Lazy<RiskRejectDialog> lazy = verifyNumberFragment.riskRejectDialog;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get();
                Context requireContext = verifyNumberFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                DanaAlertDialog BuiltInFictitiousFunctionClassFactory = RiskRejectDialog.moveToNextValue(requireContext).BuiltInFictitiousFunctionClassFactory();
                FragmentManager parentFragmentManager = verifyNumberFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                Intrinsics.checkNotNullParameter(parentFragmentManager, "");
                BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
                Result.m3179constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}
