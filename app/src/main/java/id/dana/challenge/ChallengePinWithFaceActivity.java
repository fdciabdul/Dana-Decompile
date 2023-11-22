package id.dana.challenge;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
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
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.view.ComponentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.iap.android.wallet.acl.base.Result;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.performanceduration.DanaPerformanceDurationTracker;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.ViewPagerBindingActivity;
import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.biometric.domain.model.RiskActionConstant;
import id.dana.cashier.model.CashierPayModel;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.otp.WhatsAppOtpReceiver;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pinwithface.ChallengePinWithFaceContract;
import id.dana.challenge.pinwithface.ChallengePinWithFaceModule;
import id.dana.challenge.scenario.ScenarioFacade;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import id.dana.constants.ErrorCode;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationModule;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.danah5.DanaH5;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import id.dana.data.login.source.network.model.VerifyMethod;
import id.dana.databinding.ActivityInputPinOrFaceBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerChallengePinWithFaceActivityComponent;
import id.dana.di.modules.BiometricAnalyticModule;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.PinChallengeModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.LoadingDialog;
import id.dana.dialog.LoginInfoDialog;
import id.dana.dialog.RiskRejectDialog;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.model.VerificationTreeNode;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.extension.view.InputExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.model.UserInfo;
import id.dana.network.exception.NetworkException;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.onboarding.suspiciousaccount.SuspiciousAccountVerifyActivity;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.onboarding.verify.pinincorrectlock.PinIncorrectLockFragment;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.richview.socialshare.AppPackageName;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.riskChallenges.ui.passkey.launcher.authentication.AuthenticationPasskeyLauncher;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.riskChallenges.ui.resetpin.ResetPinLauncher;
import id.dana.riskChallenges.ui.util.StringWrapperExtKt;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.BiometricAnalyticTracker;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.model.TrackPinModel;
import id.dana.tracker.rds.RDSConstant;
import id.dana.tracker.rds.RDSEvent;
import id.dana.tracker.risk.RiskEventStrategy;
import id.dana.tracker.risk.RiskPhaseConstant;
import id.dana.utils.DanaTextWatcher;
import id.dana.utils.KeyboardHeightProvider;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.PhoneCall;
import id.dana.utils.RegexUtil;
import id.dana.utils.StringWrapper;
import id.dana.utils.StringWrapperKt;
import id.dana.utils.ViewHelper;
import id.dana.utils.android.AppUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import id.dana.utils.tracker.mixpanel.MixpanelValueUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000ú\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u008e\u00022\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u008e\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\u0016\u0010\u0086\u0001\u001a\u00030\u0083\u00012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0014J6\u0010\u0089\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u008a\u0001\u001a\u0002022\n\b\u0002\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\b\u0002\u0010\u008d\u0001\u001a\u00030\u008c\u00012\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0017H\u0002J\u001c\u0010\u008f\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0090\u0001\u001a\u0002022\u0007\u0010\u0091\u0001\u001a\u000202H\u0002J\u0014\u0010\u0092\u0001\u001a\u00030\u0083\u00012\b\u0010\u0093\u0001\u001a\u00030\u0085\u0001H\u0002J\n\u0010\u0094\u0001\u001a\u00030\u0083\u0001H\u0002J\u0013\u0010\u0095\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0096\u0001\u001a\u000202H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010\u0098\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010\u0099\u0001\u001a\u00030\u0083\u0001H\u0014J\n\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\u0015\u0010\u009c\u0001\u001a\u00020\u00152\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0016J\n\u0010\u009f\u0001\u001a\u00030 \u0001H\u0002J\u0012\u0010¡\u0001\u001a\u0002022\u0007\u0010¢\u0001\u001a\u000202H\u0002J\n\u0010£\u0001\u001a\u00030¤\u0001H\u0002J\n\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J\n\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\n\u0010©\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\u0014\u0010¬\u0001\u001a\u00030\u00ad\u00012\b\u0010p\u001a\u0004\u0018\u000102H\u0002J\t\u0010®\u0001\u001a\u000202H\u0002J\u000b\u0010¯\u0001\u001a\u0004\u0018\u000102H\u0002J\u001a\u0010°\u0001\u001a\u00030\u0083\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0081\u0001H\u0002J\n\u0010²\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010³\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010´\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010µ\u0001\u001a\u00030\u0083\u0001H\u0016J\u0014\u0010¶\u0001\u001a\u00030\u0083\u00012\b\u0010p\u001a\u0004\u0018\u000102H\u0002J\n\u0010·\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010¸\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010¹\u0001\u001a\u00030\u0083\u0001H\u0002J\t\u0010º\u0001\u001a\u00020\u0002H\u0014J\n\u0010»\u0001\u001a\u00030\u0083\u0001H\u0002J)\u0010¼\u0001\u001a\u00030\u0083\u00012\b\u0010½\u0001\u001a\u00030\u0085\u00012\b\u0010\u0093\u0001\u001a\u00030\u0085\u00012\t\u0010\u001e\u001a\u0005\u0018\u00010¾\u0001H\u0014J\n\u0010¿\u0001\u001a\u00030\u0083\u0001H\u0016J\u001c\u0010À\u0001\u001a\u00030\u0083\u00012\u0007\u0010Á\u0001\u001a\u00020\u00152\u0007\u0010Â\u0001\u001a\u00020\u0015H\u0002J\n\u0010Ã\u0001\u001a\u00030\u0083\u0001H\u0014J\n\u0010Ä\u0001\u001a\u00030\u0083\u0001H\u0016J\u0016\u0010Å\u0001\u001a\u00030\u0083\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H\u0002J\u0013\u0010È\u0001\u001a\u00030\u0083\u00012\u0007\u0010É\u0001\u001a\u00020\u0015H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0083\u0001H\u0002J'\u0010Ë\u0001\u001a\u00030\u0083\u00012\u0010\u0010±\u0001\u001a\u000b\u0012\u0004\u0012\u000202\u0018\u00010\u0081\u00012\t\u0010Ì\u0001\u001a\u0004\u0018\u000102H\u0016J&\u0010Í\u0001\u001a\u00030\u0083\u00012\b\u0010Î\u0001\u001a\u00030Ï\u00012\u0010\u0010±\u0001\u001a\u000b\u0012\u0004\u0012\u000202\u0018\u00010\u0081\u0001H\u0016J\n\u0010Ð\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030\u0083\u0001H\u0014J\n\u0010Ò\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010Ó\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010Ô\u0001\u001a\u00030\u0083\u0001H\u0002J\u0018\u0010Õ\u0001\u001a\u00030\u0083\u00012\f\b\u0002\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001H\u0002J\n\u0010Ø\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010Ù\u0001\u001a\u00030\u0083\u0001H\u0002J\u0014\u0010Ú\u0001\u001a\u00030\u0083\u00012\b\u0010Û\u0001\u001a\u00030Ü\u0001H\u0002J\n\u0010Ý\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010Þ\u0001\u001a\u00030\u0083\u0001H\u0002J\u0019\u0010ß\u0001\u001a\u0002022\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0081\u0001H\u0002J\u0015\u0010à\u0001\u001a\u00030\u0083\u00012\t\u0010á\u0001\u001a\u0004\u0018\u000102H\u0002JB\u0010â\u0001\u001a\u00030\u0083\u00012\u0007\u0010ã\u0001\u001a\u0002022\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0081\u00012\t\u0010Ì\u0001\u001a\u0004\u0018\u0001022\t\u0010ä\u0001\u001a\u0004\u0018\u0001022\u0007\u0010å\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010æ\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\n\u0010ç\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010è\u0001\u001a\u00030\u0083\u0001H\u0002J\u001c\u0010é\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0090\u0001\u001a\u0002022\u0007\u0010ê\u0001\u001a\u00020\u0015H\u0002J\n\u0010ë\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010ì\u0001\u001a\u00030\u0083\u0001H\u0016JI\u0010í\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0090\u0001\u001a\u0002022\u0007\u0010\u0091\u0001\u001a\u0002022\u0007\u0010î\u0001\u001a\u00020\u00152\u0007\u0010ï\u0001\u001a\u00020\u00152\u0007\u0010ð\u0001\u001a\u00020\u00152\u0007\u0010ñ\u0001\u001a\u00020\u00152\u0007\u0010ê\u0001\u001a\u00020\u0015H\u0002J\n\u0010ò\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010ó\u0001\u001a\u00030\u0083\u0001H\u0002J%\u0010ô\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0090\u0001\u001a\u0002022\u0007\u0010î\u0001\u001a\u00020\u00152\u0007\u0010ï\u0001\u001a\u00020\u0015H\u0002J\n\u0010õ\u0001\u001a\u00030\u0083\u0001H\u0002J\u0014\u0010ö\u0001\u001a\u00030\u0083\u00012\b\u0010÷\u0001\u001a\u00030\u0085\u0001H\u0002J\n\u0010ø\u0001\u001a\u00030\u0083\u0001H\u0002J\u0014\u0010ù\u0001\u001a\u00030\u0083\u00012\b\u0010ú\u0001\u001a\u00030û\u0001H\u0002J\u0014\u0010ü\u0001\u001a\u00030\u0083\u00012\b\u0010ú\u0001\u001a\u00030û\u0001H\u0002J\u0014\u0010ý\u0001\u001a\u00030\u0083\u00012\b\u0010ú\u0001\u001a\u00030û\u0001H\u0002J\u0014\u0010þ\u0001\u001a\u00030\u0083\u00012\b\u0010ú\u0001\u001a\u00030û\u0001H\u0002J\u001c\u0010ÿ\u0001\u001a\u00030\u0083\u00012\u0007\u0010Á\u0001\u001a\u00020\u00152\u0007\u0010Â\u0001\u001a\u00020\u0015H\u0002J\n\u0010\u0080\u0002\u001a\u00030\u0083\u0001H\u0002J\n\u0010\u0081\u0002\u001a\u00030\u0083\u0001H\u0002J\n\u0010\u0082\u0002\u001a\u00030\u0083\u0001H\u0002J\n\u0010\u0083\u0002\u001a\u00030\u0083\u0001H\u0002J%\u0010\u0084\u0002\u001a\u00030\u0083\u00012\u0007\u0010\u0090\u0001\u001a\u0002022\u0007\u0010\u0085\u0002\u001a\u0002022\u0007\u0010\u0086\u0002\u001a\u000202H\u0002J\u000f\u0010\u0087\u0002\u001a\u00030\u0083\u0001*\u00030¾\u0001H\u0002J#\u0010\u0088\u0002\u001a\u00020\u0015*\u00030¾\u00012\u0007\u0010\u0089\u0002\u001a\u0002022\t\b\u0002\u0010\u008a\u0002\u001a\u00020\u0015H\u0082\u0002J!\u0010\u008b\u0002\u001a\u00030\u0083\u0001*\u00030\u008c\u00022\u0007\u0010ê\u0001\u001a\u00020\u00152\u0007\u0010\u0090\u0001\u001a\u000202H\u0002J!\u0010\u008d\u0002\u001a\u00030\u0083\u0001*\u00030\u008c\u00022\u0007\u0010î\u0001\u001a\u00020\u00152\u0007\u0010ï\u0001\u001a\u00020\u0015H\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001d\u001a\u0004\b.\u0010/R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001d\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u001d\u001a\u0004\b?\u0010@R\u000e\u0010B\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010P\u001a\u00020Q8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0010\u0010V\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010X\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u001d\u001a\u0004\bZ\u0010[R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020`X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010c\u001a\u00020d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010i\u001a\b\u0012\u0004\u0012\u00020k0j8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u000e\u0010p\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010r\u001a\u00020s8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\u001d\u001a\u0004\bt\u0010uR\u000e\u0010w\u001a\u00020xX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010zX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020~X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008f\u0002"}, d2 = {"Lid/dana/challenge/ChallengePinWithFaceActivity;", "Lid/dana/base/ViewPagerBindingActivity;", "Lid/dana/databinding/ActivityInputPinOrFaceBinding;", "Lid/dana/challenge/ChallengeScenarioListener;", "Lid/dana/challenge/OtpHeightListener;", "()V", "biometricAnalyticTracker", "Lid/dana/tracker/mixpanel/BiometricAnalyticTracker;", "getBiometricAnalyticTracker", "()Lid/dana/tracker/mixpanel/BiometricAnalyticTracker;", "setBiometricAnalyticTracker", "(Lid/dana/tracker/mixpanel/BiometricAnalyticTracker;)V", "challengePinWithFacePresenter", "Lid/dana/challenge/pinwithface/ChallengePinWithFaceContract$Presenter;", "getChallengePinWithFacePresenter", "()Lid/dana/challenge/pinwithface/ChallengePinWithFaceContract$Presenter;", "setChallengePinWithFacePresenter", "(Lid/dana/challenge/pinwithface/ChallengePinWithFaceContract$Presenter;)V", "challengeScenario", "Lid/dana/challenge/scenario/ScenarioFacade;", "chatbotFeature", "", "chatbotTimestamp", "", "danaLoadingDialog", "Lid/dana/dialog/DanaLoadingDialog;", "getDanaLoadingDialog", "()Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog$delegate", "Lkotlin/Lazy;", "data", "Landroid/os/Bundle;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "enrollPasskeyLauncher", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "getEnrollPasskeyLauncher", "()Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "enrollPasskeyLauncher$delegate", "errorCode", "", "faceLoginEnable", "faceOnlyLogin", "firebasePerformanceMonitor", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "getFirebasePerformanceMonitor", "()Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "firebasePerformanceMonitor$delegate", "frozenAccountChatbotFeature", "inputPinRenderingScreenListener", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "inputPinTextWatcher", "Lid/dana/utils/DanaTextWatcher;", "getInputPinTextWatcher", "()Lid/dana/utils/DanaTextWatcher;", "inputPinTextWatcher$delegate", "isFirstTimeKeyboardShown", "isFirstTimeTextChanged", "isLaunchEnrollPasskey", "isLaunchResetPin", "isShowFaceLoginActionVisible", "()Z", "keyboardHeightProvider", "Lid/dana/utils/KeyboardHeightProvider;", "loadingLogoutDialog", "Lid/dana/dialog/LoadingDialog;", "loginFaceDialog", "Lid/dana/dialog/TwoButtonWithImageDialog;", "loginInfoDialog", "Lid/dana/dialog/LoginInfoDialog;", "logoutPresenter", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "getLogoutPresenter", "()Lid/dana/challenge/pin/LogoutContract$Presenter;", "setLogoutPresenter", "(Lid/dana/challenge/pin/LogoutContract$Presenter;)V", "maxInputAttemptDialog", "needShowPasskeyEnrollmentFromResetPin", "passkeyAuthenticationLauncher", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/AuthenticationPasskeyLauncher;", "getPasskeyAuthenticationLauncher", "()Lid/dana/riskChallenges/ui/passkey/launcher/authentication/AuthenticationPasskeyLauncher;", "passkeyAuthenticationLauncher$delegate", "passkeyEligibility", "Ljava/util/concurrent/atomic/AtomicBoolean;", "permission", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "phoneNumber", "phonePermission", "presenter", "Lid/dana/challenge/pin/AbstractPinContract$Presenter;", "getPresenter", "()Lid/dana/challenge/pin/AbstractPinContract$Presenter;", "setPresenter", "(Lid/dana/challenge/pin/AbstractPinContract$Presenter;)V", "riskRejectDialog", "Ldagger/Lazy;", "Lid/dana/dialog/RiskRejectDialog;", "getRiskRejectDialog", "()Ldagger/Lazy;", "setRiskRejectDialog", "(Ldagger/Lazy;)V", "scenario", BioUtilityBridge.SECURITY_ID, "strategy", "Lid/dana/riskChallenges/ui/resetpin/ResetPinLauncher;", "getStrategy", "()Lid/dana/riskChallenges/ui/resetpin/ResetPinLauncher;", "strategy$delegate", "trackPinModel", "Lid/dana/tracker/model/TrackPinModel;", "trust2RiskLoginModel", "Lid/dana/model/Trust2RiskLoginModel;", "userAlreadyEnrollFaceLogin", "userAlreadyKYC", "userInfoDataAfterSuccessLogin", "Lid/dana/model/UserInfo;", "userRiskEnable", "verificationMethods", "", "addBottomSheetHeight", "", "additionalHeight", "", "attachBaseContext", "newBase", "Landroid/content/Context;", "attachRiskTracker", "action", "touchX", "", "touchY", "timestamp", "backToPhoneNumberFormAndViewPopUp", "errorMessage", ZdocRecordService.REASON, "checkActivityResultTrustRiskV2", "resultCode", "checkKnowledgeBasedAuthFeature", "chooseLoginType", "text", "closeActivity", "closeChallengeSession", "configToolbar", "createH5AppListener", "Lid/dana/utils/danah5/DanaH5Listener;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getChallengePinWithFaceModule", "Lid/dana/challenge/pinwithface/ChallengePinWithFaceModule;", "getChatBotPageUrl", SemanticAttributes.MessagingOperationValues.PROCESS, "getFaceAuthPopUpConsultationModule", "Lid/dana/contract/switchfaceauth/FaceAuthPopUpConsultationModule;", "getInputPinOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getKeyboardVisibilityListener", "Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;", "getLogSeedId", "getLogoutModule", "Lid/dana/di/modules/LogoutModule;", "getPinChallengeModule", "Lid/dana/di/modules/PinChallengeModule;", "getRiskPhase", "getRiskScheme", "goToCarrierIdentificationVerify", ChallengePinWithFaceActivity.CHALLENGE_METHOD_LIST, "gotoHome", "handleNeedFallbackFromPasskey", "hideClose", IAPSyncCommand.COMMAND_INIT, "initInjector", "initInputPinListener", "initKeyboardListener", "initPhonePermission", "initViewBinding", "navigateToPreviousPage", "onActivityResult", RequestPermission.REQUEST_CODE, "Landroid/content/Intent;", "onBackPressed", "onComplete", "shouldShowDanaVizPrompt", "danaVizPromptSkippable", "onDestroy", "onDismiss", "onErrorResetPin", "throwable", "", "onForgotPin", "knowledgeBasedAuthEnable", "onFragmentResult", "onNext", "otpPurpose", "onNextCarrierIdentificationFirst", ChallengePinWithFaceActivity.LOGIN_RESPONSE, "Lid/dana/domain/model/rpc/response/LoginResponse;", "onPadFaceClicked", "onResume", "onStart", "openKnowledgeBasedAuthPage", "openSuspiciousAccountVerifyPage", "proceedLogout", "triggeringView", "Landroid/view/View;", "registerClickListener", "saveScoringDeviceData", "sendIntentToWhatsAppForBusiness", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "sendIntentToWhatsapp", "setKeyboardVisibilityListener", "setOtpPurpose", "setTitleBasedOnRegistrationSource", "registrationSource", "setupChallengeScenario", "challengeScenarioMethod", "otpChannel", "isWhatsappAndOtp", "setupDataFromExtras", "setupInputPin", "setupViewPagerChallenge", "showAccountFrozenDialog", "isTempLock", "showCallCustomerServiceDialog", "showClose", "showErrorMessage", "isTryAgain", "isWrongPin", "isShowCallCSDialog", "isAccountFroze", "showFaceLoginUpgradePremiumPopup", "showHidePin", "showIncorrectPinDialog", "showOtpDailyLimitError", "showPinIncorrectLockPage", "lockedExpireSeconds", "showProgressDialog", "showRiskRejectBlacklistDialog", "exception", "Lid/dana/network/exception/NetworkException;", "showRiskRejectRetry1DayDialog", "showRiskRejectRetry7DayDialog", "showRiskRejectSuspiciousDialog", "showSuccessDialog", "showTooManyInputPinDialog", "startFaceAuthDurationTracker", "stopFaceAuthDurationTracker", "stopUserIdleTimerTracker", "trackDisplayedErrorLogin", "displayedMessage", "rpcTraceId", "checkChallengeScenario", "get", "key", "defaultValue", "setAccountFrozenDialogButtonCallback", "Lid/dana/dialog/LoginInfoDialog$Builder;", "setIncorrectPinDialogButtonCallback", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChallengePinWithFaceActivity extends ViewPagerBindingActivity<ActivityInputPinOrFaceBinding> implements ChallengeScenarioListener, OtpHeightListener {
    public static final String CHALLENGE_METHOD_LIST = "challengeMethod";
    private static char[] J = null;
    public static final String LOGIN_AUTHENTICATION_OPTIONS = "loginAuthenticationOptions";
    public static final String LOGIN_RESPONSE = "loginResponse";
    public static final int RESULT_CODE_INVALID_NUMBER = 1002;
    public static final int RESULT_CODE_NEED_FALLBACK = 1001;
    public static final String SUSPICIOUS_ACCOUNT = "SUSPICIOUS_ACCOUNT";
    private final Lazy A;
    private TrackPinModel AppCompatEmojiTextHelper;
    private LoginInfoDialog B;
    private AtomicBoolean BottomSheetCardBindingView$watcherCardNumberView$1;
    private boolean C;
    private String D;
    private long DatabaseTableConfigUtil;
    private ActivityPermissionRequest E;
    private boolean F;
    private boolean FragmentBottomSheetPaymentSettingBinding;
    private boolean G;
    private ScenarioFacade GetContactSyncConfig;
    private Trust2RiskLoginModel H;
    private final Lazy I;
    private List<String> K;
    private boolean M;
    private Bundle NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda4;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final MeasureLoadAndRenderingScreen NetworkUserEntityData$$ExternalSyntheticLambda6;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private String PrepareContext;
    private KeyboardHeightProvider SubSequence;
    private TwoButtonWithImageDialog VerifyPinStateManager$executeRiskChallenge$2$1;
    private final ActivityPermissionRequest VerifyPinStateManager$executeRiskChallenge$2$2;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public BiometricAnalyticTracker biometricAnalyticTracker;
    @Inject
    public ChallengePinWithFaceContract.Presenter challengePinWithFacePresenter;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    private boolean getCallingPid;
    private UserInfo getNameOrBuilderList;
    private String getOnBoardingScenario;
    private TwoButtonWithImageDialog getSupportButtonTintMode;
    private String getValueOfTouchPositionAbsolute;
    private boolean initRecordTimeStamp;
    private final Lazy isLayoutRequested;
    @Inject
    public LogoutContract.Presenter logoutPresenter;
    private final Lazy newProxyInstance;
    @Inject
    public AbstractPinContract.Presenter presenter;
    private LoadingDialog readMicros;
    @Inject
    public dagger.Lazy<RiskRejectDialog> riskRejectDialog;
    private boolean whenAvailable;
    public static final byte[] $$j = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$k = 39;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {116, 15, TarHeader.LF_BLK, -20, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int lookAheadTest = 121;

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        J = new char[]{35502, 35577, 35575, 35573, 35566, 35570, 35576, 35543, 35545, 35574, 35566, 35537, 35497, 35532, 35573, 35568, 35569, 35569, 35568, 35560, 35576, 35520, 35571, 35573, 35581, 35580, 35339, 35763, 35720, 35722, 35762, 35764, 35768, 35772, 35712, 35768, 35764, 35766, 35764, 35770, 35766, 35761, 35760, 35769, 35557, 35426, 35424, 35742, 35739, 35743, 35429, 35392, 35453, 35736, 35451, 35402, 35432, 35739, 35424, 35431, 35743, 35734, 35556, 35429, 35441, 35449, 35440, 35521, 35382, 35344, 35347, 35342, 35382, 35362, 35365, 35386, 35386, 35385, 35344, 35386, 35384, 35387, 35362, 35362, 35365, 35386, 35346, 35348, 35346, 35346, 35348, 35386, 35360, 35363, 35363, 35385, 35342, 35343, 35385, 35389, 35347, 35342, 35387, 35384, 35385, 35384, 35347, 35389, 35387, 35344, 35384, 35385, 35346, 35347, 35343, 35462, 35540, 35540, 35501, 35498, 35498, 35538, 35539, 35537, 35536, 35536, 35541, 35500, 35540, 35581, 35538, 35496, 35539, 35581, 35543, 35503, 35498, 35500, 35540, 35541, 35540, 35539, 35498, 35498, 35499, 35501, 35499, 35494, 35495, 35494, 35501, 35502, 35502, 35502, 35540, 35580, 35543, 35498, 35536, 35541, 35540, 35541, 35499, 35539, 35579, 35537, 35498, 35498, 35536, 35581, 35536, 35497, 35538, 35540, 35503, 35500, 35501, 35500, 35538, 35463, 35503, 35541, 35581, 35539, 35494, 35498, 35501, 35496, 35494, 35494, 35498, 35503, 35500, 35503, 35501, 35538, 35581, 35538, 35538, 35541, 35540, 35583, 35540, 35499, 35536, 35537, 35494, 35537, 35576, 35536, 35539, 35539, 35539, 35541, 35499, 35539, 35538, 35496, 35497, 35494, 35537, 35541, 35500, 35496, 35498, 35542, 35583, 35578, 35537, 35536, 35578, 35541, 35503, 35541, 35539, 35496, 35496, 35497, 35497, 35536, 35539, 35499, 35497, 35495, 35565, 35567, 35575, 35571, 35571, 35540, 35502, 35530, 35532, 35535, 35565, 35570, 35576, 35572, 35573, 35538, 35538, 35570, 35574, 35542, 35536, 35568, 35575, 35542, 35543, 35573, 35575, 35573, 35565, 35564, 35573, 35573, 35575, 35573, 35568, 35540, 35535, 35565, 35572, 35580, 35573, 35572, 35581, 35573, 35571, 35568, 35535, 35545, 35577, 35577, 35580, 35543, 35505, 35498, 35528, 35567, 35564, 35562, 35568, 35462, 35499, 35501, 35503, 35503, 35502};
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void l(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.challenge.ChallengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = 106 - r8
            int r7 = r7 * 15
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = 0
            r8 = r7
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r8 = r8 + 1
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + 2
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.challenge.ChallengePinWithFaceActivity.l(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 4
            int r9 = 4 - r9
            int r8 = r8 * 3
            int r8 = 75 - r8
            byte[] r0 = id.dana.challenge.ChallengePinWithFaceActivity.$$j
            int r7 = r7 * 2
            int r7 = r7 + 42
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r4 = 0
            r8 = r7
            goto L2c
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r6
        L2c:
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            int r9 = r9 + 1
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.challenge.ChallengePinWithFaceActivity.m(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity
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

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.ViewPagerBindingActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        k(false, new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, new int[]{44, 18, 149, 18}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        k(false, new byte[]{1, 0, 0, 0, 1}, new int[]{62, 5, 136, 0}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                k(false, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, new int[]{0, 26, 0, 0}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                k(false, new byte[]{0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1}, new int[]{26, 18, 188, 13}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    k(true, new byte[]{1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1}, new int[]{67, 48, 89, 37}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    k(false, new byte[]{1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0}, new int[]{115, 64, 0, 45}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    k(false, new byte[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0}, new int[]{179, 64, 0, 0}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    k(true, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, new int[]{243, 60, 0, 0}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    k(false, new byte[]{1, 0, 1, 0, 0, 0}, new int[]{303, 6, 0, 1}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] - 1);
            byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[5];
            Object[] objArr12 = new Object[1];
            l(b, b2, (byte) (b2 - 1), objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] - 1);
            Object[] objArr13 = new Object[1];
            l(b3, b3, NetworkUserEntityData$$ExternalSyntheticLambda0[5], objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 3, (char) TextUtils.indexOf("", "", 0, 0));
                    byte b4 = (byte) ($$j[35] - 1);
                    byte b5 = b4;
                    Object[] objArr15 = new Object[1];
                    m(b4, b5, b5, objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, ExpandableListView.getPackedPositionChild(0L) + 36, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-873039490, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            k(false, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, new int[]{0, 26, 0, 0}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            k(false, new byte[]{0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1}, new int[]{26, 18, 188, 13}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.indexOf("", "", 0) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    public ChallengePinWithFaceActivity() {
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = new MeasureLoadAndRenderingScreen();
        DanaPerformanceDurationTracker danaPerformanceDurationTracker = DanaPerformanceDurationTracker.INSTANCE;
        DanaPerformanceDurationTracker.MyBillsEntityDataFactory(TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN);
        DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.Property.RENDER_INPUT_PIN_SCREEN, System.currentTimeMillis());
        Intrinsics.checkNotNullParameter("input_pin_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("input_pin_screen_render");
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = measureLoadAndRenderingScreen;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = LazyKt.lazy(new Function0<DanaTextWatcher>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$inputPinTextWatcher$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaTextWatcher invoke() {
                return new DanaTextWatcher();
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$danaLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLoadingDialog invoke() {
                return new DanaLoadingDialog(ChallengePinWithFaceActivity.this);
            }
        });
        this.newProxyInstance = LazyKt.lazy(new Function0<FirebasePerformanceMonitor>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$firebasePerformanceMonitor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FirebasePerformanceMonitor invoke() {
                return FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            }
        });
        this.getNameOrBuilderList = new UserInfo(null, null, null, null, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, 524287, null);
        this.D = "";
        this.FragmentBottomSheetPaymentSettingBinding = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
        this.I = LazyKt.lazy(new Function0<ResetPinLauncher>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$strategy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ResetPinLauncher invoke() {
                String str;
                ResetPinLauncher.Builder builder = new ResetPinLauncher.Builder(ChallengePinWithFaceActivity.this, "Pre-Login");
                Intrinsics.checkNotNullParameter(TrackerKey.RiskChallenge.Source.RESET_PIN, "");
                builder.BuiltInFictitiousFunctionClassFactory = TrackerKey.RiskChallenge.Source.RESET_PIN;
                Intrinsics.checkNotNullParameter("Risk Challenge", "");
                builder.getAuthRequestContext = "Risk Challenge";
                str = ChallengePinWithFaceActivity.this.D;
                Intrinsics.checkNotNullParameter(str, "");
                builder.PlaceComponentResult = str;
                UiComponent uiComponent = new UiComponent(UIComponentType.Full, R.color.f27072131100488, R.string.forget_pin);
                Intrinsics.checkNotNullParameter(uiComponent, "");
                builder.scheduleImpl = uiComponent;
                final ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$strategy$2.1
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
                        String str2;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        ChallengePinWithFaceContract.Presenter challengePinWithFacePresenter = ChallengePinWithFaceActivity.this.getChallengePinWithFacePresenter();
                        str2 = ChallengePinWithFaceActivity.this.D;
                        challengePinWithFacePresenter.KClassImpl$Data$declaredNonStaticMembers$2(str2);
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder.getErrorConfigVersion = function1;
                final ChallengePinWithFaceActivity challengePinWithFaceActivity2 = ChallengePinWithFaceActivity.this;
                Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$strategy$2.2
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
                        Object obj;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        if (Build.VERSION.SDK_INT >= 33) {
                            obj = bundle.getSerializable("KEY_ERROR_THROWABLE", Throwable.class);
                        } else {
                            Object serializable = bundle.getSerializable("KEY_ERROR_THROWABLE");
                            if (!(serializable instanceof Throwable)) {
                                serializable = null;
                            }
                            obj = (Serializable) ((Throwable) serializable);
                        }
                        ChallengePinWithFaceActivity.access$onErrorResetPin(ChallengePinWithFaceActivity.this, (Throwable) obj);
                    }
                };
                Intrinsics.checkNotNullParameter(function12, "");
                builder.PlaceComponentResult = function12;
                final ChallengePinWithFaceActivity challengePinWithFaceActivity3 = ChallengePinWithFaceActivity.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$strategy$2.3
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
                        ChallengePinWithFaceActivity.access$getDanaLoadingDialog(ChallengePinWithFaceActivity.this).PlaceComponentResult();
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder.MyBillsEntityDataFactory = function0;
                return builder.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.K = CollectionsKt.emptyList();
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = new AtomicBoolean(false);
        this.A = LazyKt.lazy(new Function0<AuthenticationPasskeyLauncher>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$passkeyAuthenticationLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AuthenticationPasskeyLauncher invoke() {
                String str;
                String str2;
                AuthenticationPasskeyLauncher.Builder builder = new AuthenticationPasskeyLauncher.Builder(ChallengePinWithFaceActivity.this);
                Intrinsics.checkNotNullParameter("Login", "");
                builder.BuiltInFictitiousFunctionClassFactory = "Login";
                Intrinsics.checkNotNullParameter("Risk Challenge", "");
                builder.MyBillsEntityDataFactory = "Risk Challenge";
                str = ChallengePinWithFaceActivity.this.getOnBoardingScenario;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str = null;
                }
                Intrinsics.checkNotNullParameter(str, "");
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = str;
                str2 = ChallengePinWithFaceActivity.this.D;
                Intrinsics.checkNotNullParameter(str2, "");
                builder.getAuthRequestContext = str2;
                final ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$passkeyAuthenticationLauncher$2.1
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
                        AtomicBoolean atomicBoolean;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        String string = bundle.getString("KEY_PASSKEY_CREDENTIAL_ID");
                        AbstractPinContract.Presenter presenter = ChallengePinWithFaceActivity.this.getPresenter();
                        atomicBoolean = ChallengePinWithFaceActivity.this.BottomSheetCardBindingView$watcherCardNumberView$1;
                        presenter.KClassImpl$Data$declaredNonStaticMembers$2(atomicBoolean.toString(), string);
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder.getErrorConfigVersion = function1;
                final ChallengePinWithFaceActivity challengePinWithFaceActivity2 = ChallengePinWithFaceActivity.this;
                Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$passkeyAuthenticationLauncher$2.2
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
                        ChallengePinWithFaceActivity.access$handleNeedFallbackFromPasskey(ChallengePinWithFaceActivity.this);
                    }
                };
                Intrinsics.checkNotNullParameter(function12, "");
                builder.PlaceComponentResult = function12;
                final ChallengePinWithFaceActivity challengePinWithFaceActivity3 = ChallengePinWithFaceActivity.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$passkeyAuthenticationLauncher$2.3
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
                        ChallengePinWithFaceActivity.access$handleNeedFallbackFromPasskey(ChallengePinWithFaceActivity.this);
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
                return builder.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.isLayoutRequested = LazyKt.lazy(new Function0<EnrollPasskeyLauncher>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$enrollPasskeyLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EnrollPasskeyLauncher invoke() {
                EnrollPasskeyLauncher.Builder builder = new EnrollPasskeyLauncher.Builder(ChallengePinWithFaceActivity.this);
                Intrinsics.checkNotNullParameter("Home", "");
                builder.moveToNextValue = "Home";
                Intrinsics.checkNotNullParameter("Enroll", "");
                builder.PlaceComponentResult = "Enroll";
                Intrinsics.checkNotNullParameter("HOME", "");
                builder.MyBillsEntityDataFactory = "HOME";
                final ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$enrollPasskeyLauncher$2.1
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
                        ChallengePinWithFaceActivity.access$gotoHome(ChallengePinWithFaceActivity.this);
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder.getErrorConfigVersion = function1;
                final ChallengePinWithFaceActivity challengePinWithFaceActivity2 = ChallengePinWithFaceActivity.this;
                Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$enrollPasskeyLauncher$2.2
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
                        ChallengePinWithFaceActivity.access$gotoHome(ChallengePinWithFaceActivity.this);
                    }
                };
                Intrinsics.checkNotNullParameter(function12, "");
                builder.PlaceComponentResult = function12;
                final ChallengePinWithFaceActivity challengePinWithFaceActivity3 = ChallengePinWithFaceActivity.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$enrollPasskeyLauncher$2.3
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
                        ChallengePinWithFaceActivity.access$gotoHome(ChallengePinWithFaceActivity.this);
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
                return builder.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$permission$1
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
                TrackPinModel trackPinModel;
                TrackPinModel trackPinModel2;
                String str;
                String str2;
                Intrinsics.checkNotNullParameter(p0, "");
                TrackPinModel trackPinModel3 = null;
                String str3 = null;
                if (p0.MyBillsEntityDataFactory()) {
                    str = ChallengePinWithFaceActivity.this.getOnBoardingScenario;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        str = null;
                    }
                    if (str.length() > 0) {
                        AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                        AppReadyMixpanelTracker.initRecordTimeStamp();
                        ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                        DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.DANA_VIZ_SCREEN, TrackerDataKey.Property.FACE_AUTH_PROCESS_IN_MILLIS, System.currentTimeMillis());
                        ChallengePinWithFaceContract.Presenter challengePinWithFacePresenter = ChallengePinWithFaceActivity.this.getChallengePinWithFacePresenter();
                        str2 = ChallengePinWithFaceActivity.this.getOnBoardingScenario;
                        if (str2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            str3 = str2;
                        }
                        challengePinWithFacePresenter.PlaceComponentResult(str3, ChallengePinWithFaceActivity.this);
                        return;
                    }
                }
                trackPinModel = ChallengePinWithFaceActivity.this.AppCompatEmojiTextHelper;
                if (trackPinModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    trackPinModel = null;
                }
                trackPinModel.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.PinRequestPurpose.DANA_VIZ_PERMISSION_FALLBACK;
                trackPinModel2 = ChallengePinWithFaceActivity.this.AppCompatEmojiTextHelper;
                if (trackPinModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    trackPinModel3 = trackPinModel2;
                }
                EventTracker.PlaceComponentResult(trackPinModel3.MyBillsEntityDataFactory());
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = builder.PlaceComponentResult();
    }

    public static final /* synthetic */ ActivityInputPinOrFaceBinding access$getBinding(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        return (ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding();
    }

    @JvmName(name = "getChallengePinWithFacePresenter")
    public final ChallengePinWithFaceContract.Presenter getChallengePinWithFacePresenter() {
        ChallengePinWithFaceContract.Presenter presenter = this.challengePinWithFacePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setChallengePinWithFacePresenter")
    public final void setChallengePinWithFacePresenter(ChallengePinWithFaceContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.challengePinWithFacePresenter = presenter;
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
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

    @JvmName(name = "getPresenter")
    public final AbstractPinContract.Presenter getPresenter() {
        AbstractPinContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(AbstractPinContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getBiometricAnalyticTracker")
    public final BiometricAnalyticTracker getBiometricAnalyticTracker() {
        BiometricAnalyticTracker biometricAnalyticTracker = this.biometricAnalyticTracker;
        if (biometricAnalyticTracker != null) {
            return biometricAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBiometricAnalyticTracker")
    public final void setBiometricAnalyticTracker(BiometricAnalyticTracker biometricAnalyticTracker) {
        Intrinsics.checkNotNullParameter(biometricAnalyticTracker, "");
        this.biometricAnalyticTracker = biometricAnalyticTracker;
    }

    @JvmName(name = "getDeviceInformationProvider")
    public final DeviceInformationProvider getDeviceInformationProvider() {
        DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
        if (deviceInformationProvider != null) {
            return deviceInformationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
    }

    @JvmName(name = "getRiskRejectDialog")
    public final dagger.Lazy<RiskRejectDialog> getRiskRejectDialog() {
        dagger.Lazy<RiskRejectDialog> lazy = this.riskRejectDialog;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRiskRejectDialog")
    public final void setRiskRejectDialog(dagger.Lazy<RiskRejectDialog> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.riskRejectDialog = lazy;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.Property.USER_IDLE_INPUT_PIN_SCREEN, System.currentTimeMillis());
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("idle_login_input_pin_screen");
        this.FragmentBottomSheetPaymentSettingBinding = true;
        getPresenter().MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            k(false, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, new int[]{0, 26, 0, 0}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            k(false, new byte[]{0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1}, new int[]{26, 18, 188, 13}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 35 - ExpandableListView.getPackedPositionType(0L), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), Process.getGidForName("") + 19, (char) TextUtils.indexOf("", "", 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        attachRiskTracker$default(this, RiskActionConstant.ON_PAGE_TRACK, 0.0f, 0.0f, 0L, 14, null);
    }

    static /* synthetic */ void attachRiskTracker$default(ChallengePinWithFaceActivity challengePinWithFaceActivity, String str, float f, float f2, long j, int i, Object obj) {
        float f3 = (i & 2) != 0 ? 0.0f : f;
        float f4 = (i & 4) != 0 ? 0.0f : f2;
        if ((i & 8) != 0) {
            j = 0;
        }
        challengePinWithFaceActivity.BuiltInFictitiousFunctionClassFactory(str, f3, f4, j);
    }

    private final void BuiltInFictitiousFunctionClassFactory(String str, float f, float f2, long j) {
        if (BuiltInFictitiousFunctionClassFactory() == null) {
            return;
        }
        RelativeLayout relativeLayout = ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
        String str2 = relativeLayout.getVisibility() == 0 ? RiskPhaseConstant.INPUT_OTP : RiskPhaseConstant.INPUT_PIN;
        RiskEventStrategy.Builder builder = new RiskEventStrategy.Builder(this);
        Intrinsics.checkNotNullParameter(str2, "");
        builder.MyBillsEntityDataFactory = str2;
        Intrinsics.checkNotNullParameter(str, "");
        builder.getAuthRequestContext = str;
        if (Intrinsics.areEqual(str, RiskActionConstant.ON_TOUCH)) {
            builder.moveToNextValue = Float.valueOf(f);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = Float.valueOf(f2);
            builder.BuiltInFictitiousFunctionClassFactory = Long.valueOf(j);
        }
        EventTracker.BuiltInFictitiousFunctionClassFactory(builder.getAuthRequestContext());
    }

    private final String BuiltInFictitiousFunctionClassFactory() {
        String str = this.getValueOfTouchPositionAbsolute;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        int hashCode = str.hashCode();
        if (hashCode != 103149417) {
            if (hashCode != 1319662811) {
                if (hashCode != 1573803584 || !str.equals(ChallengeScenario.TRUST_RISK_LOGIN)) {
                    return null;
                }
            } else if (!str.equals(ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                return null;
            }
        } else if (!str.equals("login")) {
            return null;
        }
        return "LOGIN";
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityInputPinOrFaceBinding initViewBinding() {
        ActivityInputPinOrFaceBinding BuiltInFictitiousFunctionClassFactory = ActivityInputPinOrFaceBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setToolbarImage(R.drawable.ic_dana_logo_icon_text);
        showToolbarLeftButton(R.drawable.arrow_left_white);
        setMenuLeftContentDescription(getString(R.string.btnLogout));
    }

    @Override // id.dana.base.ViewPagerBindingActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        DanaApplication danaApplication = getDanaApplication();
        if (danaApplication != null) {
            danaApplication.chckTmprdApp();
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        String str;
        Parcelable parcelable;
        ArrayList arrayList;
        VerificationTreeNode verificationTreeNode;
        List<VerificationTreeNode> children;
        this.AppCompatEmojiTextHelper = new TrackPinModel(getApplicationContext());
        Bundle extras = getIntent().getExtras();
        TrackPinModel trackPinModel = null;
        if (extras != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = extras;
            String string = extras.getString(ChallengeControl.Key.SCENARIO, "login");
            Intrinsics.checkNotNullExpressionValue(string, "");
            this.getValueOfTouchPositionAbsolute = string;
            if (string == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                string = null;
            }
            this.GetContactSyncConfig = ChallengeScenarioFactory.PlaceComponentResult(string, extras);
            String string2 = extras.getString(ChallengeControl.Key.SECURITY_ID, "");
            Intrinsics.checkNotNullExpressionValue(string2, "");
            this.getOnBoardingScenario = string2;
            String string3 = extras.getString(ChallengeControl.Key.PHONE_NUMBER, "");
            Intrinsics.checkNotNullExpressionValue(string3, "");
            this.D = string3;
            this.initRecordTimeStamp = extras.getBoolean(ChallengeControl.Key.HELP_BUTTON_CHATBOT_FEATURE, false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = extras.getBoolean(ChallengeControl.Key.FROZEN_ACCOUNT_CHATBOT_FEATURE, false);
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable(ChallengeControl.Key.TRUST_2_RISK_LOGIN_MODEL, Trust2RiskLoginModel.class);
            } else {
                Parcelable parcelable2 = extras.getParcelable(ChallengeControl.Key.TRUST_2_RISK_LOGIN_MODEL);
                if (!(parcelable2 instanceof Trust2RiskLoginModel)) {
                    parcelable2 = null;
                }
                parcelable = (Trust2RiskLoginModel) parcelable2;
            }
            Trust2RiskLoginModel trust2RiskLoginModel = (Trust2RiskLoginModel) parcelable;
            this.H = trust2RiskLoginModel;
            if (trust2RiskLoginModel == null || (verificationTreeNode = trust2RiskLoginModel.KClassImpl$Data$declaredNonStaticMembers$2) == null || (children = verificationTreeNode.getChildren()) == null) {
                arrayList = null;
            } else {
                List<VerificationTreeNode> list = children;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((VerificationTreeNode) it.next()).getValue());
                }
                arrayList = arrayList2;
            }
            if (arrayList == null) {
                arrayList = CollectionsKt.emptyList();
            }
            this.K = arrayList;
            Intent intent = getIntent();
            if (intent != null) {
                Intrinsics.checkNotNullExpressionValue(intent, "");
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = get$default(this, intent, ChallengeControl.Key.FACE_ONLY_LOGIN, false, 2, null);
                this.G = get$default(this, intent, ChallengeControl.Key.FACE_LOGIN_ENROLLED, false, 2, null);
                this.F = get$default(this, intent, ChallengeControl.Key.KYC_FLAG, false, 2, null);
                this.M = get$default(this, intent, ChallengeControl.Key.RISK_FLAG, false, 2, null);
                TrackPinModel trackPinModel2 = this.AppCompatEmojiTextHelper;
                if (trackPinModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    trackPinModel2 = null;
                }
                String str2 = this.getValueOfTouchPositionAbsolute;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str2 = null;
                }
                trackPinModel2.PlaceComponentResult = MixpanelValueUtil.BuiltInFictitiousFunctionClassFactory(str2);
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1.set(extras.getBoolean(ChallengeControl.Key.PASSKEY_ELIGIBILITY, false));
            final String str3 = this.getValueOfTouchPositionAbsolute;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str3 = null;
            }
            DaggerChallengePinWithFaceActivityComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerChallengePinWithFaceActivityComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (PinChallengeModule) Preconditions.getAuthRequestContext(new PinChallengeModule(new AbstractPinContract.View() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$getPinChallengeModule$1
                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierPayModel cashierPayModel, boolean z) {
                    AbstractPinContract.View.CC.getAuthRequestContext();
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(String str4, String str5) {
                    AbstractPinContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str4, String str5, Integer num, String str6, Integer num2) {
                    MyBillsEntityDataFactory(str4, str5, num.intValue(), str6, num2.intValue());
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(String str4, String str5, Integer num, String str6) {
                    int intValue = num.intValue();
                    Intrinsics.checkNotNullParameter(str5, "");
                    Intrinsics.checkNotNullParameter(str6, "");
                    MyBillsEntityDataFactory(str4, str5, intValue, str6, 0);
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    ChallengePinWithFaceActivity.access$showProgressDialog(ChallengePinWithFaceActivity.this);
                }

                /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.FACE_LOGIN_CACHE_EXPIRED) == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.ERROR_CODE_DANA_PIN_TEMPORARY_LOCK_1) == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.ERROR_CODE_DANA_PIN_TEMPORARY_LOCK_3) == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.ERROR_CODE_DANA_PIN_OR_OTP_TEMPORARY_LOCK) != false) goto L34;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
                
                    r14 = id.dana.challenge.ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED;
                    r13 = r22;
                    r15 = false;
                    r16 = false;
                    r17 = false;
                    r18 = true;
                    r19 = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x00b0, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.SESSION_EXPIRED) == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.VERIFY_PASSWORD_TRUST_RISK_EXPIRED) != false) goto L40;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:40:0x00bb, code lost:
                
                    id.dana.challenge.ChallengePinWithFaceActivity.proceedLogout$default(r20.BuiltInFictitiousFunctionClassFactory, null, 1, null);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:41:0x00c0, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.WAITING_LOCK_INPUT_PIN_TRUST_2_RISK) == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:49:0x00e0, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.ACCESS_TOKEN_NOT_ACTIVE) == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:52:0x00e9, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.ACCESS_TOKEN_NOT_EXIST) == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:55:0x00f2, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.USER_NOT_EXIST) == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:58:0x00fb, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.ERROR_RISK_REJECT) != false) goto L59;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:59:0x00fd, code lost:
                
                    r1 = r22;
                    r2 = false;
                    r3 = true;
                    r10 = false;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:61:0x0108, code lost:
                
                    if (r21.equals(id.dana.constants.ErrorCode.WAITING_LOCK_INPUT_PIN_TRUST_TO_RISK) != false) goto L62;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:62:0x010a, code lost:
                
                    id.dana.challenge.ChallengePinWithFaceActivity.access$showPinIncorrectLockPage(r20.BuiltInFictitiousFunctionClassFactory, r25);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:63:0x0111, code lost:
                
                    return;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private void MyBillsEntityDataFactory(java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24, int r25) {
                    /*
                        Method dump skipped, instructions count: 358
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.challenge.ChallengePinWithFaceActivity$getPinChallengeModule$1.MyBillsEntityDataFactory(java.lang.String, java.lang.String, int, java.lang.String, int):void");
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                    Intrinsics.checkNotNullParameter("input_pin_flow_loadtime", "");
                    OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "input_pin_flow_loadtime");
                    if (p0 != null) {
                        MyBillsEntityDataFactory(null, p0, 0, "", 0);
                    }
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final void PlaceComponentResult(int p0) {
                    MyBillsEntityDataFactory(null, String.valueOf(p0), 0, "", 0);
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    MyBillsEntityDataFactory(null, Result.ERROR_CODE_TIMEOUT, 0, "", 0);
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(long p0) {
                    ChallengePinWithFaceActivity.this.DatabaseTableConfigUtil = p0;
                    ChallengePinWithFaceActivity.access$openSuspiciousAccountVerifyPage(ChallengePinWithFaceActivity.this);
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final void getAuthRequestContext() {
                    int hashCode;
                    OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                    Intrinsics.checkNotNullParameter("input_pin_flow_loadtime", "");
                    OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "input_pin_flow_loadtime");
                    EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_lost_focus", RDSConstant.INPUT_PIN_LOST_FOCUS, false));
                    String str4 = str3;
                    if (str4 != null && ((hashCode = str4.hashCode()) == 103149417 ? str4.equals("login") : !(hashCode == 1319662811 ? !str4.equals(ChallengeScenario.TRUST_RISK_LOGIN_V2) : !(hashCode == 1573803584 && str4.equals(ChallengeScenario.TRUST_RISK_LOGIN))))) {
                        DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(LoginTrackingConstants.NormalLogin.SUCCESS_TO_HOME, "");
                    }
                    ChallengePinWithFaceActivity.this.onNext(null, null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("[ChallengePinWithFaceActivity] onSuccess ");
                    sb.append(str3);
                    DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final void BuiltInFictitiousFunctionClassFactory(List<String> p0) {
                    int hashCode;
                    Intrinsics.checkNotNullParameter(p0, "");
                    String str4 = str3;
                    if (str4 != null && ((hashCode = str4.hashCode()) == 103149417 ? str4.equals("login") : !(hashCode == 1319662811 ? !str4.equals(ChallengeScenario.TRUST_RISK_LOGIN_V2) : !(hashCode == 1573803584 && str4.equals(ChallengeScenario.TRUST_RISK_LOGIN))))) {
                        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                        Intrinsics.checkNotNullParameter("input_pin_flow_loadtime", "");
                        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "input_pin_flow_loadtime");
                        DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(LoginTrackingConstants.NormalLogin.SUCCESS_TO_OTPLOGIN, "");
                    }
                    ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                    challengePinWithFaceActivity.onNext(p0, ChallengePinWithFaceActivity.access$setOtpPurpose(challengePinWithFaceActivity, p0));
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                    ChallengePinWithFaceActivity.access$onForgotPin(ChallengePinWithFaceActivity.this, p0);
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                    ChallengePinWithFaceActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = p0;
                }

                @Override // id.dana.challenge.pin.AbstractPinContract.View
                public final void PlaceComponentResult() {
                    String str4;
                    DanaLog.MyBillsEntityDataFactory("PASSKEY", "[onSuccessTrust2RiskLogin] enteronSuccessTrust2RiskLogin");
                    ChallengePinWithFaceContract.Presenter challengePinWithFacePresenter = ChallengePinWithFaceActivity.this.getChallengePinWithFacePresenter();
                    str4 = ChallengePinWithFaceActivity.this.D;
                    challengePinWithFacePresenter.getAuthRequestContext(str4);
                }
            }, str3));
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (LogoutModule) Preconditions.getAuthRequestContext(new LogoutModule(new LogoutContract.View() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$getLogoutModule$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str4) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                    LoadingDialog loadingDialog = new LoadingDialog(challengePinWithFaceActivity);
                    if (!loadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing()) {
                        try {
                            loadingDialog.BuiltInFictitiousFunctionClassFactory.show();
                        } catch (Exception unused) {
                        }
                    }
                    challengePinWithFaceActivity.readMicros = loadingDialog;
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void MyBillsEntityDataFactory() {
                    LoadingDialog loadingDialog;
                    loadingDialog = ChallengePinWithFaceActivity.this.readMicros;
                    if (loadingDialog != null) {
                        loadingDialog.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void PlaceComponentResult() {
                    DeepLinkParser.getAuthRequestContext();
                    ChallengePinWithFaceActivity.access$navigateToPreviousPage(ChallengePinWithFaceActivity.this);
                }
            }));
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ChallengePinWithFaceModule) Preconditions.getAuthRequestContext(new ChallengePinWithFaceModule(new ChallengePinWithFaceContract.View() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$getChallengePinWithFaceModule$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str4) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    String str4;
                    Intrinsics.checkNotNullParameter(p0, "");
                    ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                    DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.DANA_VIZ_SCREEN, TrackerDataKey.Property.FACE_AUTH_PROCESS_IN_MILLIS, System.currentTimeMillis());
                    str4 = ChallengePinWithFaceActivity.this.getValueOfTouchPositionAbsolute;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        str4 = null;
                    }
                    if (Intrinsics.areEqual(str4, ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                        LottieAnimationView lottieAnimationView = ChallengePinWithFaceActivity.access$getBinding(ChallengePinWithFaceActivity.this).MyBillsEntityDataFactory;
                        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
                        lottieAnimationView.setVisibility(8);
                        ChallengePinWithFaceActivity.this.getPresenter().MyBillsEntityDataFactory("MIC_FACE", "");
                    } else if (Intrinsics.areEqual(str4, ChallengeScenario.TRUST_RISK_LOGIN)) {
                        ChallengePinWithFaceActivity.this.getPresenter().getAuthRequestContext("", p0, AppUtil.MyBillsEntityDataFactory(ChallengePinWithFaceActivity.this.getBaseContext()), true);
                    }
                }

                @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.View
                public final void MyBillsEntityDataFactory() {
                    TrackPinModel trackPinModel3;
                    TrackPinModel trackPinModel4;
                    boolean z;
                    ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                    DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.DANA_VIZ_SCREEN, TrackerDataKey.Property.FACE_AUTH_PROCESS_IN_MILLIS, System.currentTimeMillis());
                    trackPinModel3 = ChallengePinWithFaceActivity.this.AppCompatEmojiTextHelper;
                    TrackPinModel trackPinModel5 = null;
                    if (trackPinModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        trackPinModel3 = null;
                    }
                    trackPinModel3.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.PinRequestPurpose.DANA_VIZ_OPEN_FALLBACK;
                    trackPinModel4 = ChallengePinWithFaceActivity.this.AppCompatEmojiTextHelper;
                    if (trackPinModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        trackPinModel5 = trackPinModel4;
                    }
                    EventTracker.PlaceComponentResult(trackPinModel5.MyBillsEntityDataFactory());
                    z = ChallengePinWithFaceActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    if (z) {
                        ChallengePinWithFaceActivity.this.getPresenter().getAuthRequestContext("accountSuspiciousUser");
                    }
                }

                @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    TrackPinModel trackPinModel3;
                    TrackPinModel trackPinModel4;
                    boolean z;
                    ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                    DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.DANA_VIZ_SCREEN, TrackerDataKey.Property.FACE_AUTH_PROCESS_IN_MILLIS, System.currentTimeMillis());
                    trackPinModel3 = ChallengePinWithFaceActivity.this.AppCompatEmojiTextHelper;
                    if (trackPinModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        trackPinModel3 = null;
                    }
                    trackPinModel3.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.PinRequestPurpose.DANA_VIZ_OPEN_FALLBACK;
                    trackPinModel4 = ChallengePinWithFaceActivity.this.AppCompatEmojiTextHelper;
                    if (trackPinModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        trackPinModel4 = null;
                    }
                    EventTracker.PlaceComponentResult(trackPinModel4.MyBillsEntityDataFactory());
                    z = ChallengePinWithFaceActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    if (z) {
                        ChallengePinWithFaceActivity.proceedLogout$default(ChallengePinWithFaceActivity.this, null, 1, null);
                    }
                }

                @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    ChallengePinWithFaceActivity.this.getCallingPid = true;
                    ChallengePinWithFaceActivity.this.C = true;
                    ChallengePinWithFaceActivity.access$getStrategy(ChallengePinWithFaceActivity.this).BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.View
                public final void getAuthRequestContext() {
                    ChallengePinWithFaceActivity.this.getPresenter().PlaceComponentResult();
                }

                @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.View
                public final void PlaceComponentResult(final boolean p0, final boolean p1) {
                    DanaLog.MyBillsEntityDataFactory("PASSKEY", "[ChallengePinWithFaceActivity] showDanaVizPrompt");
                    EnrollPasskeyLauncher access$getEnrollPasskeyLauncher = ChallengePinWithFaceActivity.access$getEnrollPasskeyLauncher(ChallengePinWithFaceActivity.this);
                    final ChallengePinWithFaceActivity challengePinWithFaceActivity = ChallengePinWithFaceActivity.this;
                    EnrollPasskeyLauncher.KClassImpl$Data$declaredNonStaticMembers$2(access$getEnrollPasskeyLauncher, false, false, null, new Function1<Boolean, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$getChallengePinWithFaceModule$1$showDanaVizPrompt$1
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

                        public final void invoke(boolean z) {
                            boolean z2;
                            LoginInfoDialog loginInfoDialog;
                            ChallengePinWithFaceActivity challengePinWithFaceActivity2 = ChallengePinWithFaceActivity.this;
                            z2 = challengePinWithFaceActivity2.C;
                            challengePinWithFaceActivity2.C = z2 && z;
                            loginInfoDialog = ChallengePinWithFaceActivity.this.B;
                            if (loginInfoDialog != null) {
                                loginInfoDialog.getAuthRequestContext();
                            }
                            ChallengePinWithFaceActivity.this.MyBillsEntityDataFactory(p0, p1);
                        }
                    }, 7);
                }
            }));
            Preconditions.getAuthRequestContext(new FaceAuthPopUpConsultationModule(new FaceAuthPopUpConsultationContract.View() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$getFaceAuthPopUpConsultationModule$1
                @Override // id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory() {
                    FaceAuthPopUpConsultationContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str4) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            }));
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (BiometricAnalyticModule) Preconditions.getAuthRequestContext(new BiometricAnalyticModule());
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (FaceAuthenticationModule) Preconditions.getAuthRequestContext(new FaceAuthenticationModule());
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, PinChallengeModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ChallengePinWithFaceModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, LogoutModule.class);
            if (KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new BiometricAnalyticModule();
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory == null) {
                KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = new FaceAuthenticationModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, ApplicationComponent.class);
            new DaggerChallengePinWithFaceActivityComponent.ChallengePinWithFaceActivityComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
            registerPresenter(getPresenter());
            lookAheadTest();
            str = extras.getString(ChallengeControl.Key.REGISTRATION_SOURCE);
        } else {
            str = null;
        }
        if (str != null && StringsKt.equals("TIX ID, Bukalapak, or Ramayana App", str, true)) {
            ((ActivityInputPinOrFaceBinding) getBinding()).PlaceComponentResult.setText(getString(R.string.registration_source_merchant_app));
        }
        KeyboardHelper.PlaceComponentResult(getWindow().getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$getKeyboardVisibilityListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.Property.TYPING_PIN_IN_MILLIS, System.currentTimeMillis());
                ChallengePinWithFaceActivity.access$getFirebasePerformanceMonitor(ChallengePinWithFaceActivity.this).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.USER_INTERACTION_LOGIN_PIN_INPUT);
                ChallengePinWithFaceActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
            }
        });
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            ((ActivityInputPinOrFaceBinding) getBinding()).BuiltInFictitiousFunctionClassFactory.setEnabled(false);
        } else {
            getAuthRequestContext();
        }
        KeyboardHeightProvider keyboardHeightProvider = new KeyboardHeightProvider(this);
        keyboardHeightProvider.BuiltInFictitiousFunctionClassFactory();
        this.SubSequence = keyboardHeightProvider;
        ((ActivityInputPinOrFaceBinding) getBinding()).NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChallengePinWithFaceActivity.m601$r8$lambda$JYGjwE_DN78EBzjJdmUyWgiDPc(ChallengePinWithFaceActivity.this, view);
            }
        });
        TextView textView = this.leftButton;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChallengePinWithFaceActivity.$r8$lambda$n1f0vKCnO9i6sEW0lQZ4nqYedyY(ChallengePinWithFaceActivity.this, view);
                }
            });
        }
        AppCompatImageView appCompatImageView = this.toolbarLeftImage;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChallengePinWithFaceActivity.$r8$lambda$ehxnClhebsO239fKMkTDO9O4WwE(ChallengePinWithFaceActivity.this, view);
                }
            });
        }
        ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChallengePinWithFaceActivity.m599$r8$lambda$6kDBeAQeZBDS4fM3y_sIGrS6o(ChallengePinWithFaceActivity.this, view);
            }
        });
        LottieAnimationView lottieAnimationView = ((ActivityInputPinOrFaceBinding) getBinding()).MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2() ? 0 : 8);
        LottieAnimationView lottieAnimationView2 = ((ActivityInputPinOrFaceBinding) getBinding()).MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "");
        if (lottieAnimationView2.getVisibility() == 0) {
            ((ActivityInputPinOrFaceBinding) getBinding()).MyBillsEntityDataFactory.playAnimation();
        } else {
            ((ActivityInputPinOrFaceBinding) getBinding()).MyBillsEntityDataFactory.pauseAnimation();
        }
        ((ActivityInputPinOrFaceBinding) getBinding()).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChallengePinWithFaceActivity.m603$r8$lambda$dlbaHiyfHmP1JjscRdjKEWK9yw(ChallengePinWithFaceActivity.this, view);
            }
        });
        ((ActivityInputPinOrFaceBinding) getBinding()).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChallengePinWithFaceActivity.$r8$lambda$5b83GN4G2GKKCff6_SEFno1pgnE(ChallengePinWithFaceActivity.this, view);
            }
        });
        if (this.initRecordTimeStamp) {
            ((ActivityInputPinOrFaceBinding) getBinding()).moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChallengePinWithFaceActivity.$r8$lambda$jgZWVW68w0P0W0LU7V9z6llOWdI(ChallengePinWithFaceActivity.this, view);
                }
            });
        } else {
            ((ActivityInputPinOrFaceBinding) getBinding()).moveToNextValue.setVisibility(8);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.getAuthRequestContext(((ActivityInputPinOrFaceBinding) getBinding()).getAuthRequestContext);
            constraintSet.BuiltInFictitiousFunctionClassFactory(((ActivityInputPinOrFaceBinding) getBinding()).NetworkUserEntityData$$ExternalSyntheticLambda0.getId(), 7, 0, 7);
            constraintSet.BuiltInFictitiousFunctionClassFactory(((ActivityInputPinOrFaceBinding) getBinding()).NetworkUserEntityData$$ExternalSyntheticLambda0.getId(), 6, 0, 6);
            constraintSet.BuiltInFictitiousFunctionClassFactory(((ActivityInputPinOrFaceBinding) getBinding()).NetworkUserEntityData$$ExternalSyntheticLambda0.getId(), 3, 0, 3);
            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(((ActivityInputPinOrFaceBinding) getBinding()).getAuthRequestContext);
            AppCompatTextView appCompatTextView = ((ActivityInputPinOrFaceBinding) getBinding()).NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            ViewExtKt.PlaceComponentResult(appCompatTextView, 0, 0, 0, 0);
        }
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$initPhonePermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list2) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list2);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(ChallengePinWithFaceActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.E = builder.PlaceComponentResult();
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory != null) {
            getChallengePinWithFacePresenter().getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, new Function0<Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$init$2
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppReadyMixpanelTracker.moveToNextValue();
                }
            }, new Function0<Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$init$3
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppReadyMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }, new Function1<Boolean, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$init$4
                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                    AppReadyMixpanelTracker.getAuthRequestContext(z);
                }
            });
        }
        getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(this.H);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        Intrinsics.checkNotNullParameter(findViewById, "");
        FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
        FirstDrawListener.Companion.MyBillsEntityDataFactory(findViewById, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
        ViewHelper.getAuthRequestContext(findViewById(16908290), new Runnable() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.Property.RENDER_INPUT_PIN_SCREEN, System.currentTimeMillis());
            }
        });
        getLifecycle().BuiltInFictitiousFunctionClassFactory((ResetPinLauncher) this.I.getValue());
        getLifecycle().BuiltInFictitiousFunctionClassFactory((AuthenticationPasskeyLauncher) this.A.getValue());
        getLifecycle().BuiltInFictitiousFunctionClassFactory((EnrollPasskeyLauncher) this.isLayoutRequested.getValue());
        getSupportFragmentManager().setFragmentResultListener("KEY_RISK_CHALLENGE_FRAGMENT", this, new FragmentResultListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda12
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str4, Bundle bundle) {
                ChallengePinWithFaceActivity.$r8$lambda$tinaxjFaCB91YPqMYjpj7ltUHKU(ChallengePinWithFaceActivity.this, str4, bundle);
            }
        });
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1.get()) {
            onNext(this.K, null);
        } else if (!KClassImpl$Data$declaredNonStaticMembers$2() || this.BottomSheetCardBindingView$watcherCardNumberView$1.get()) {
            TrackPinModel trackPinModel3 = this.AppCompatEmojiTextHelper;
            if (trackPinModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                trackPinModel = trackPinModel3;
            }
            EventTracker.PlaceComponentResult(trackPinModel.MyBillsEntityDataFactory());
        } else if (this.G) {
            this.VerifyPinStateManager$executeRiskChallenge$2$2.check();
        } else if (this.F) {
        } else {
            getErrorConfigVersion();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r7, int resultCode, Intent data) {
        List<String> emptyList;
        StringBuilder sb = new StringBuilder();
        sb.append("[ChallengePinWithFaceActivity][onActivityResult] requestCode: ");
        sb.append(r7);
        sb.append(", resultCode: ");
        sb.append(resultCode);
        DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
        String str = this.getValueOfTouchPositionAbsolute;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        if (!Intrinsics.areEqual(str, ChallengeScenario.TRUST_RISK_LOGIN_V2) || this.getCallingPid || this.BottomSheetCardBindingView$watcherCardNumberView$1.get() || this.whenAvailable) {
            if (-1 == resultCode) {
                CarrierIdentificationVerifyActivity.Companion companion = CarrierIdentificationVerifyActivity.INSTANCE;
                if (CarrierIdentificationVerifyActivity.Companion.MyBillsEntityDataFactory() == r7) {
                    MyBillsEntityDataFactory(false, true);
                }
            }
            if (1001 == resultCode) {
                CarrierIdentificationVerifyActivity.Companion companion2 = CarrierIdentificationVerifyActivity.INSTANCE;
                if (CarrierIdentificationVerifyActivity.Companion.MyBillsEntityDataFactory() == r7) {
                    if (data != null) {
                        ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra(CHALLENGE_METHOD_LIST);
                        if (stringArrayListExtra == null || (emptyList = CollectionsKt.toMutableList((Collection) stringArrayListExtra)) == null) {
                            emptyList = CollectionsKt.emptyList();
                        }
                        onNext(emptyList, ChallengeEvent.OTPPurpose.PNV_FAILOVER);
                    }
                }
            }
            if (1002 == resultCode) {
                Intent putExtra = new Intent().putExtra(ChallengeControl.Key.CANCEL_REASON, "error");
                Intrinsics.checkNotNullExpressionValue(putExtra, "");
                setResult(0, putExtra);
                finish();
            }
        } else if (-1 == resultCode) {
            getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(this.BottomSheetCardBindingView$watcherCardNumberView$1.toString(), null);
        } else if (resultCode == 0) {
            proceedLogout$default(this, null, 1, null);
        }
        if (this.getCallingPid) {
            this.getCallingPid = false;
        }
        if (this.whenAvailable) {
            this.whenAvailable = false;
        }
        super.onActivityResult(r7, resultCode, data);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        KeyboardHeightProvider keyboardHeightProvider = this.SubSequence;
        if (keyboardHeightProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            keyboardHeightProvider = null;
        }
        keyboardHeightProvider.dismiss();
        super.onDestroy();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((AuthenticationPasskeyLauncher) this.A.getValue());
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((EnrollPasskeyLauncher) this.isLayoutRequested.getValue());
    }

    @Override // id.dana.challenge.ChallengeScenarioListener
    public final void showClose() {
        ImageButton imageButton = ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(imageButton, "");
        imageButton.setVisibility(0);
    }

    @Override // id.dana.challenge.ChallengeScenarioListener
    public final void hideClose() {
        ImageButton imageButton = ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(imageButton, "");
        imageButton.setVisibility(4);
    }

    public final void onDismiss() {
        getPresenter().BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.String] */
    @Override // id.dana.challenge.ChallengeScenarioListener
    public final void onNext(List<String> r14, String otpPurpose) {
        StringBuilder sb = new StringBuilder();
        sb.append("challengeMethod ");
        sb.append(r14);
        sb.append(", otpPurpose: ");
        sb.append(otpPurpose);
        DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onNext ");
        String str = this.getValueOfTouchPositionAbsolute;
        Bundle bundle = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        sb2.append(str);
        DanaLog.MyBillsEntityDataFactory("PASSKEY", sb2.toString());
        if (r14 == null || r14.isEmpty() || TextUtils.isEmpty(r14.get(0))) {
            ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
            String str2 = this.getValueOfTouchPositionAbsolute;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str2 = null;
            }
            if (Intrinsics.areEqual(str2, ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(this.BottomSheetCardBindingView$watcherCardNumberView$1.toString(), null);
            } else {
                getChallengePinWithFacePresenter().getAuthRequestContext(this.D);
            }
        } else if (Intrinsics.areEqual("PASSWORD", r14.get(0))) {
            ((ActivityInputPinOrFaceBinding) getBinding()).BuiltInFictitiousFunctionClassFactory.setEnabled(true);
            ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
            getAuthRequestContext();
            ((ActivityInputPinOrFaceBinding) getBinding()).BuiltInFictitiousFunctionClassFactory.post(new Runnable() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    ChallengePinWithFaceActivity.m606$r8$lambda$wIvgZeVBoqbePHQioiP4jBm0nc(ChallengePinWithFaceActivity.this);
                }
            });
        } else if (Intrinsics.areEqual("PASSKEYS", r14.get(0))) {
            ((AuthenticationPasskeyLauncher) this.A.getValue()).BuiltInFictitiousFunctionClassFactory();
        } else if (!Intrinsics.areEqual("MIC_FACE", r14.get(0))) {
            if (Intrinsics.areEqual(VerifyMethod.CARRIER_IDENTIFICATION, r14.get(0))) {
                LoginInfoDialog loginInfoDialog = this.B;
                if (loginInfoDialog != null) {
                    loginInfoDialog.getAuthRequestContext();
                }
                Intent intent = new Intent(this, CarrierIdentificationVerifyActivity.class);
                Bundle bundle2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (bundle2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bundle2 = null;
                }
                bundle2.putStringArrayList(CHALLENGE_METHOD_LIST, (ArrayList) r14);
                Bundle bundle3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (bundle3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bundle3 = null;
                }
                String str3 = this.getValueOfTouchPositionAbsolute;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str3 = null;
                }
                bundle3.putString(ChallengeControl.Key.SCENARIO, str3);
                Bundle bundle4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (bundle4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bundle = bundle4;
                }
                intent.putExtras(bundle);
                CarrierIdentificationVerifyActivity.Companion companion = CarrierIdentificationVerifyActivity.INSTANCE;
                startActivityForResult(intent, CarrierIdentificationVerifyActivity.Companion.MyBillsEntityDataFactory());
            } else if (Intrinsics.areEqual(VerifyMethod.PUSH_VERIFY, r14.get(0))) {
                LoginInfoDialog loginInfoDialog2 = this.B;
                if (loginInfoDialog2 != null) {
                    loginInfoDialog2.getAuthRequestContext();
                }
                getAuthRequestContext(ChallengeScenario.TRUST_RISK_LOGIN_TWILIO, r14, otpPurpose, null, false);
                ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
            } else if (Intrinsics.areEqual(VerifyMethod.DISMISS_PUSH_VERIFY, r14.get(0))) {
                LoginInfoDialog loginInfoDialog3 = this.B;
                if (loginInfoDialog3 != null) {
                    loginInfoDialog3.getAuthRequestContext();
                }
                ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.getAuthRequestContext.setVisibility(8);
            } else if (Intrinsics.areEqual("OTP_SMS", r14.get(0))) {
                LoginInfoDialog loginInfoDialog4 = this.B;
                if (loginInfoDialog4 != null) {
                    loginInfoDialog4.getAuthRequestContext();
                }
                ?? r1 = this.getValueOfTouchPositionAbsolute;
                if (r1 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bundle = r1;
                }
                if (Intrinsics.areEqual(bundle, ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                    getAuthRequestContext(ChallengeScenario.TRUST_RISK_LOGIN_V2, r14, otpPurpose, OtpChannel.SMS, false);
                } else if (Intrinsics.areEqual(bundle, ChallengeScenario.TRUST_RISK_LOGIN)) {
                    getAuthRequestContext(ChallengeScenario.TRUST_RISK_LOGIN, r14, otpPurpose, OtpChannel.SMS, false);
                }
                ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                attachRiskTracker$default(this, RiskActionConstant.ON_PAGE_TRACK, 0.0f, 0.0f, 0L, 14, null);
            } else if (Intrinsics.areEqual("WHATSAPP_OTP", r14.get(0))) {
                LoginInfoDialog loginInfoDialog5 = this.B;
                if (loginInfoDialog5 != null) {
                    loginInfoDialog5.getAuthRequestContext();
                }
                PendingIntent activity = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(), Build.VERSION.SDK_INT >= 31 ? 67108864 : 0);
                Intent intent2 = new Intent();
                intent2.setPackage("com.whatsapp");
                intent2.setAction("com.whatsapp.otp.OTP_REQUESTED");
                Bundle extras = intent2.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                PendingIntent pendingIntent = activity;
                extras.putParcelable(WhatsAppOtpReceiver.CI, pendingIntent);
                intent2.putExtras(extras);
                Context applicationContext = getApplicationContext();
                if (applicationContext != null) {
                    applicationContext.sendBroadcast(intent2);
                }
                Intrinsics.checkNotNullExpressionValue(activity, "");
                Intent intent3 = new Intent();
                intent3.setPackage(AppPackageName.WHATSAPP_FOR_BUSINESS);
                intent3.setAction("com.whatsapp.otp.OTP_REQUESTED");
                Bundle extras2 = intent3.getExtras();
                if (extras2 == null) {
                    extras2 = new Bundle();
                }
                extras2.putParcelable(WhatsAppOtpReceiver.CI, pendingIntent);
                intent3.putExtras(extras2);
                Context applicationContext2 = getApplicationContext();
                if (applicationContext2 != null) {
                    applicationContext2.sendBroadcast(intent3);
                }
                ?? r12 = this.getValueOfTouchPositionAbsolute;
                if (r12 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bundle = r12;
                }
                if (Intrinsics.areEqual(bundle, ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                    getAuthRequestContext(ChallengeScenario.TRUST_RISK_LOGIN_V2, r14, otpPurpose, OtpChannel.WHATSAPP, r14.size() == 1);
                } else if (Intrinsics.areEqual(bundle, ChallengeScenario.TRUST_RISK_LOGIN)) {
                    getAuthRequestContext(ChallengeScenario.TRUST_RISK_LOGIN, r14, otpPurpose, OtpChannel.WHATSAPP, r14.size() == 1);
                }
                ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                attachRiskTracker$default(this, RiskActionConstant.ON_PAGE_TRACK, 0.0f, 0.0f, 0L, 14, null);
            } else {
                LoginInfoDialog loginInfoDialog6 = this.B;
                if (loginInfoDialog6 != null) {
                    loginInfoDialog6.getAuthRequestContext();
                }
                ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
            }
        } else if (this.G) {
            this.VerifyPinStateManager$executeRiskChallenge$2$2.check();
        } else if (this.F) {
        } else {
            getErrorConfigVersion();
        }
    }

    public final void onNextCarrierIdentificationFirst(LoginResponse r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "");
        Intent intent = new Intent(this, CarrierIdentificationVerifyActivity.class);
        Bundle bundle = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Bundle bundle2 = null;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bundle = null;
        }
        bundle.putParcelable(LOGIN_RESPONSE, r6);
        Bundle bundle3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bundle3 = null;
        }
        if (r7 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
        }
        bundle3.putStringArrayList(CHALLENGE_METHOD_LIST, (ArrayList) r7);
        Bundle bundle4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bundle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bundle2 = bundle4;
        }
        intent.putExtras(bundle2);
        CarrierIdentificationVerifyActivity.Companion companion = CarrierIdentificationVerifyActivity.INSTANCE;
        startActivityForResult(intent, CarrierIdentificationVerifyActivity.Companion.MyBillsEntityDataFactory());
    }

    @Override // id.dana.challenge.ChallengeScenarioListener
    public final void closeChallengeSession() {
        KeyboardHelper.MyBillsEntityDataFactory(this);
        finish();
    }

    static /* synthetic */ boolean get$default(ChallengePinWithFaceActivity challengePinWithFaceActivity, Intent intent, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getAuthRequestContext(intent, str, z);
    }

    private static boolean getAuthRequestContext(Intent intent, String str, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "");
        return intent.getBooleanExtra(str, z);
    }

    private final void lookAheadTest() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        ScenarioFacade scenarioFacade = this.GetContactSyncConfig;
        if (scenarioFacade == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            scenarioFacade = null;
        }
        registerViewPager(((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.MyBillsEntityDataFactory, new ChallengeFragmentStateAdapter(supportFragmentManager, scenarioFacade.getAuthRequestContext()));
        ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.MyBillsEntityDataFactory.setSwipeable(false);
    }

    private final void getAuthRequestContext() {
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2((Activity) this);
        ((ActivityInputPinOrFaceBinding) getBinding()).BuiltInFictitiousFunctionClassFactory.requestFocus();
        AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
        AppReadyMixpanelTracker.newProxyInstance();
        final PinEntryEditText pinEntryEditText = ((ActivityInputPinOrFaceBinding) getBinding()).BuiltInFictitiousFunctionClassFactory;
        pinEntryEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ChallengePinWithFaceActivity.$r8$lambda$YoMvOqP0uJK0_gLUA0GYVhB4VRQ(view, z);
            }
        });
        DanaTextWatcher danaTextWatcher = (DanaTextWatcher) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
        Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
        danaTextWatcher.PlaceComponentResult(pinEntryEditText, new TextWatcher() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$initInputPinListener$1$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                ChallengePinWithFaceActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (String.valueOf(p0).length() == pinEntryEditText.getMaxLength()) {
                    OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                    OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("input_pin_flow_loadtime");
                    FirebasePerformanceMonitor access$getFirebasePerformanceMonitor = ChallengePinWithFaceActivity.access$getFirebasePerformanceMonitor(ChallengePinWithFaceActivity.this);
                    Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_LOGIN_PIN_INPUT, "");
                    Trace trace = access$getFirebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2.get(TrackerKey.Event.USER_INTERACTION_LOGIN_PIN_INPUT);
                    if (trace != null) {
                        trace.stop();
                    }
                    DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.Property.TYPING_PIN_IN_MILLIS, System.currentTimeMillis());
                    DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.Property.VERIFY_PIN_LOGIC_IN_MILLIS, System.currentTimeMillis());
                    DanaLog.MyBillsEntityDataFactory("PASSKEY", "enter onTextChanged");
                    ChallengePinWithFaceActivity.access$chooseLoginType(ChallengePinWithFaceActivity.this, String.valueOf(p0));
                    ChallengePinWithFaceActivity.access$getLogSeedId(ChallengePinWithFaceActivity.this);
                }
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                String obj = p0 != null ? p0.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_key_down", RDSConstant.INPUT_PIN, RegexUtil.getAuthRequestContext(obj)));
            }
        });
        pinEntryEditText.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2 = ChallengePinWithFaceActivity.KClassImpl$Data$declaredNonStaticMembers$2(PinEntryEditText.this, i);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(PinEntryEditText pinEntryEditText, int i) {
        Intrinsics.checkNotNullParameter(pinEntryEditText, "");
        if (67 == i) {
            pinEntryEditText.maskLastPinCharacter();
            return false;
        }
        return false;
    }

    @JvmName(name = "isShowFaceLoginActionVisible")
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.G && this.M;
    }

    private final void getAuthRequestContext(String str, List<String> list, String str2, String str3, boolean z) {
        this.getValueOfTouchPositionAbsolute = str;
        Bundle bundle = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Bundle bundle2 = null;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bundle = null;
        }
        bundle.putStringArrayList(CHALLENGE_METHOD_LIST, (ArrayList) list);
        Bundle bundle3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bundle3 = null;
        }
        bundle3.putString(ChallengeControl.Key.OTP_PURPOSE, str2);
        if (str3 != null) {
            Bundle bundle4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (bundle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bundle4 = null;
            }
            bundle4.putString(ChallengeControl.Key.OTP_CHANNEL, str3);
        }
        Bundle bundle5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bundle5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bundle5 = null;
        }
        bundle5.putBoolean(ChallengeControl.Key.IS_WHATSAPP_ONLY, z);
        String str4 = this.getValueOfTouchPositionAbsolute;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str4 = null;
        }
        Bundle bundle6 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bundle6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bundle2 = bundle6;
        }
        this.GetContactSyncConfig = ChallengeScenarioFactory.PlaceComponentResult(str4, bundle2);
        lookAheadTest();
        ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
    }

    private final void getErrorConfigVersion() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(this);
        builder.FragmentBottomSheetPaymentSettingBinding = getString(R.string.lets_update_to_dana_premium);
        builder.getErrorConfigVersion = getString(R.string.update_premium_face_login_desc);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_premium_feature;
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string = getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChallengePinWithFaceActivity.$r8$lambda$DNdh_Vz4wrjzGbb5taUJ87sHdXo(ChallengePinWithFaceActivity.this, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5 = 1;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        this.getSupportButtonTintMode = KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void MyBillsEntityDataFactory(final boolean z, final boolean z2) {
        LoginInfoDialog.Builder builder = new LoginInfoDialog.Builder(this);
        builder.PlaceComponentResult = getString(R.string.verification_success);
        builder.MyBillsEntityDataFactory = true;
        LoginInfoDialog.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.SUCCESS;
        Integer num = 1000;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = num.intValue();
        MyBillsEntityDataFactory.getAuthRequestContext = new DialogInterface.OnDismissListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ChallengePinWithFaceActivity.$r8$lambda$bMmfo1CtGRpmxY46XI9Gw9o_UNc(ChallengePinWithFaceActivity.this, z, z2, dialogInterface);
            }
        };
        LoginInfoDialog loginInfoDialog = new LoginInfoDialog(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory, (byte) 0);
        loginInfoDialog.MyBillsEntityDataFactory();
        this.B = loginInfoDialog;
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.MyBillsEntityDataFactory);
    }

    private final void scheduleImpl() {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.GetContactSyncConfig = getString(R.string.res_0x7f13137c_summaryvoucherview_externalsyntheticlambda2);
        builder.DatabaseTableConfigUtil = R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3;
        CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        String string = getString(R.string.risk_reject_positive_button_msg);
        ChallengePinWithFaceActivity$showCallCustomerServiceDialog$1 challengePinWithFaceActivity$showCallCustomerServiceDialog$1 = new Function1<View, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$showCallCustomerServiceDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity$showCallCustomerServiceDialog$1, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(challengePinWithFaceActivity$showCallCustomerServiceDialog$1);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        PlaceComponentResult.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().show();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        boolean z = false;
        if (ev != null && ev.getActionMasked() == 0) {
            z = true;
        }
        if (z) {
            BuiltInFictitiousFunctionClassFactory(RiskActionConstant.ON_TOUCH, ev.getX(), ev.getY(), System.currentTimeMillis());
        }
        return super.dispatchTouchEvent(ev);
    }

    private final String MyBillsEntityDataFactory(String str) {
        String replace = new Regex("^(\\+628)").replace(this.D, "62-8");
        Uri parse = Uri.parse("https://m.dana.id/i/dana-info/resolution-center/chatbot");
        int hashCode = str.hashCode();
        if (hashCode != 180941401) {
            if (hashCode != 1393882923) {
                if (hashCode == 1453990766 && str.equals("FROZEN_ACCOUNT")) {
                    Uri.Builder appendQueryParameter = parse.buildUpon().appendQueryParameter(RVParams.LONG_URL_WITH_ENTRY_KEY, "pinIncorrectTemporaryFreezeModal").appendQueryParameter(SemanticAttributes.MessagingDestinationKindValues.TOPIC, "ACCOUNT_AND_SECURITY").appendQueryParameter("subtopic", "ACCOUNT_PIN_RESET").appendQueryParameter("phoneNumber", replace).appendQueryParameter("journeySlug", "incorrectPinTemporaryFreeze").appendQueryParameter("nonLogin", SummaryActivity.CHECKED);
                    StringBuilder sb = new StringBuilder();
                    sb.append(replace);
                    sb.append("_incorrectPinTemporaryFreeze_");
                    sb.append(getDeviceInformationProvider().getDeviceUtdId());
                    parse = appendQueryParameter.appendQueryParameter("ymAuthenticationToken", sb.toString()).appendQueryParameter("utdid", getDeviceInformationProvider().getDeviceUtdId()).build();
                }
            } else if (str.equals(SUSPICIOUS_ACCOUNT)) {
                long j = this.DatabaseTableConfigUtil / 1000;
                Uri.Builder appendQueryParameter2 = parse.buildUpon().appendQueryParameter(RVParams.LONG_URL_WITH_ENTRY_KEY, "accountSuspiciousUser").appendQueryParameter(SemanticAttributes.MessagingDestinationKindValues.TOPIC, "ACCOUNT_SECURITY").appendQueryParameter("subtopic", "ACCOUNT_SUSPICIOUS_USER").appendQueryParameter("phoneNumber", replace).appendQueryParameter("journeySlug", "accountSuspiciousUser").appendQueryParameter("nonLogin", SummaryActivity.CHECKED);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(replace);
                sb2.append('_');
                sb2.append(String.valueOf(j));
                sb2.append('_');
                sb2.append(getDeviceInformationProvider().getDeviceUtdId());
                sb2.append("_SUSPICIOUS_USER}");
                parse = appendQueryParameter2.appendQueryParameter("ymAuthenticationToken", sb2.toString()).build();
            }
        } else if (str.equals("FORGOT_PIN")) {
            Uri.Builder appendQueryParameter3 = parse.buildUpon().appendQueryParameter(RVParams.LONG_URL_WITH_ENTRY_KEY, "pinInputLogin").appendQueryParameter(SemanticAttributes.MessagingDestinationKindValues.TOPIC, "ACCOUNT_AND_SECURITY").appendQueryParameter("subtopic", "ACCOUNT_PIN_RESET").appendQueryParameter("phoneNumber", replace).appendQueryParameter("journeySlug", "forgotPinLogin").appendQueryParameter("nonLogin", SummaryActivity.CHECKED);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(replace);
            sb3.append("_forgotPinLogin_");
            sb3.append(getDeviceInformationProvider().getDeviceUtdId());
            parse = appendQueryParameter3.appendQueryParameter("ymAuthenticationToken", sb3.toString()).appendQueryParameter("utdid", getDeviceInformationProvider().getDeviceUtdId()).build();
        }
        String obj = parse.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    @Override // id.dana.challenge.OtpHeightListener
    public final void addBottomSheetHeight(int additionalHeight) {
        ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.MyBillsEntityDataFactory.getLayoutParams().height = ((ActivityInputPinOrFaceBinding) getBinding()).lookAheadTest.MyBillsEntityDataFactory.getHeight() + additionalHeight;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (this.FragmentBottomSheetPaymentSettingBinding) {
            DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.Property.USER_IDLE_INPUT_PIN_SCREEN, System.currentTimeMillis());
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("idle_login_input_pin_screen", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "idle_login_input_pin_screen");
            this.FragmentBottomSheetPaymentSettingBinding = false;
        }
    }

    public static /* synthetic */ void $r8$lambda$5b83GN4G2GKKCff6_SEFno1pgnE(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        if (Intrinsics.areEqual(((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).KClassImpl$Data$declaredNonStaticMembers$2.getText().toString(), challengePinWithFaceActivity.getString(R.string.show_pin))) {
            ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).BuiltInFictitiousFunctionClassFactory.showCharacters();
            ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).KClassImpl$Data$declaredNonStaticMembers$2.setText(challengePinWithFaceActivity.getString(R.string.hide_pin));
            return;
        }
        ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).BuiltInFictitiousFunctionClassFactory.hideCharacters();
        ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).KClassImpl$Data$declaredNonStaticMembers$2.setText(challengePinWithFaceActivity.getString(R.string.show_pin));
    }

    /* renamed from: $r8$lambda$6kDBeAQeZ-BDS4fM3y_sIG-rS6o */
    public static /* synthetic */ void m599$r8$lambda$6kDBeAQeZBDS4fM3y_sIGrS6o(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(view);
        challengePinWithFaceActivity.onDismiss();
        challengePinWithFaceActivity.finish();
    }

    /* renamed from: $r8$lambda$Bn-3GDIwmvMogviHlmbLrYHRH_s */
    public static /* synthetic */ void m600$r8$lambda$Bn3GDIwmvMogviHlmbLrYHRH_s(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        LoginInfoDialog loginInfoDialog = challengePinWithFaceActivity.B;
        if (loginInfoDialog != null) {
            loginInfoDialog.getAuthRequestContext();
        }
        challengePinWithFaceActivity.setResult(0, new Intent().putExtra(ChallengeControl.Key.CANCEL_REASON, "close"));
        challengePinWithFaceActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$DNdh_Vz4wrjzGbb5taUJ87sHdXo(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        LoginInfoDialog loginInfoDialog = challengePinWithFaceActivity.B;
        if (loginInfoDialog != null) {
            loginInfoDialog.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void $r8$lambda$Dd095lfjuJc1ohQusa8i1jVFARo(final ChallengePinWithFaceActivity challengePinWithFaceActivity, String str, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        LoginInfoDialog loginInfoDialog = challengePinWithFaceActivity.B;
        if (loginInfoDialog != null) {
            loginInfoDialog.getAuthRequestContext();
        }
        if (!challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            Intent putExtra = new Intent().putExtra("message", str);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            putExtra.putExtra(ChallengeControl.Key.CANCEL_REASON, ChallengeControl.CancelReason.ACCOUNT_FROZEN);
            challengePinWithFaceActivity.setResult(0, putExtra);
            challengePinWithFaceActivity.finish();
            return;
        }
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        DanaH5.startContainerFullUrlWithoutTimeout(challengePinWithFaceActivity.MyBillsEntityDataFactory("FROZEN_ACCOUNT"), new DanaH5Listener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$setAccountFrozenDialogButtonCallback$2$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                ChallengePinWithFaceActivity.access$getDanaLoadingDialog(ChallengePinWithFaceActivity.this).PlaceComponentResult();
                ChallengePinWithFaceActivity.this.finish();
            }
        });
    }

    /* renamed from: $r8$lambda$JYGj-wE_DN78EBzjJdmUyWgiDPc */
    public static /* synthetic */ void m601$r8$lambda$JYGjwE_DN78EBzjJdmUyWgiDPc(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        TrackPinModel trackPinModel = challengePinWithFaceActivity.AppCompatEmojiTextHelper;
        if (trackPinModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            trackPinModel = null;
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(trackPinModel.BuiltInFictitiousFunctionClassFactory);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PIN_FORGOT_BUTTON;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TextUtils.isEmpty(trackPinModel.PlaceComponentResult) ? "" : trackPinModel.PlaceComponentResult);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
        challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        challengePinWithFaceActivity.getChallengePinWithFacePresenter().getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$YoMvOqP0uJK0_gLUA0GYVhB4VRQ(View view, boolean z) {
        if (z) {
            EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_lost_focus", RDSConstant.INPUT_PIN_GET_FOCUS, true));
        }
    }

    /* renamed from: $r8$lambda$ZwwxJKlSlXyqObNHA2j_D-_HMFE */
    public static /* synthetic */ void m602$r8$lambda$ZwwxJKlSlXyqObNHA2j_D_HMFE(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = challengePinWithFaceActivity.VerifyPinStateManager$executeRiskChallenge$2$1;
        if (twoButtonWithImageDialog != null) {
            twoButtonWithImageDialog.getAuthRequestContext();
        }
        challengePinWithFaceActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$b0WkbLy4JcsRhNPDgdfTdd_fw28(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        challengePinWithFaceActivity.setResult(0, new Intent().putExtra(ChallengeControl.Key.CANCEL_REASON, "close"));
        challengePinWithFaceActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$bMmfo1CtGRpmxY46XI9Gw9o_UNc(final ChallengePinWithFaceActivity challengePinWithFaceActivity, boolean z, boolean z2, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).lookAheadTest.MyBillsEntityDataFactory.requestFocus();
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).lookAheadTest.MyBillsEntityDataFactory);
        if (challengePinWithFaceActivity.GetContactSyncConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (challengePinWithFaceActivity.BuiltInFictitiousFunctionClassFactory() != null) {
            challengePinWithFaceActivity.getChallengePinWithFacePresenter().MyBillsEntityDataFactory(new Function1<BiometricDataSize, Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$saveScoringDeviceData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(BiometricDataSize biometricDataSize) {
                    invoke2(biometricDataSize);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(BiometricDataSize biometricDataSize) {
                    Intrinsics.checkNotNullParameter(biometricDataSize, "");
                    ChallengePinWithFaceActivity.this.getBiometricAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(biometricDataSize);
                }
            });
        }
        if (challengePinWithFaceActivity.C) {
            DanaLog.MyBillsEntityDataFactory("PASSKEY", "enrollPasskeyLauncher execute");
            challengePinWithFaceActivity.whenAvailable = true;
            ((EnrollPasskeyLauncher) challengePinWithFaceActivity.isLayoutRequested.getValue()).BuiltInFictitiousFunctionClassFactory();
            return;
        }
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("show_dana_viz_prompt", true);
            intent.putExtra("dana_viz_prompt_skippable", z2);
            challengePinWithFaceActivity.setResult(-1, intent);
        } else {
            challengePinWithFaceActivity.setResult(-1);
        }
        challengePinWithFaceActivity.finish();
    }

    /* renamed from: $r8$lambda$dlbaHiyfHmP1JjscRdjKEWK9y-w */
    public static /* synthetic */ void m603$r8$lambda$dlbaHiyfHmP1JjscRdjKEWK9yw(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        if (challengePinWithFaceActivity.G) {
            challengePinWithFaceActivity.VerifyPinStateManager$executeRiskChallenge$2$2.check();
        } else if (challengePinWithFaceActivity.F) {
        } else {
            challengePinWithFaceActivity.getErrorConfigVersion();
        }
    }

    public static /* synthetic */ void $r8$lambda$ehxnClhebsO239fKMkTDO9O4WwE(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        proceedLogout$default(challengePinWithFaceActivity, null, 1, null);
    }

    /* renamed from: $r8$lambda$fzsxprc4SJd-8toMjv-qgzEJCZw */
    public static /* synthetic */ void m604$r8$lambda$fzsxprc4SJd8toMjvqgzEJCZw(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        PinEntryEditText pinEntryEditText = ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
        InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        challengePinWithFaceActivity.getChallengePinWithFacePresenter().getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$jcp0oN5xZ_Cb1ExJbnZtE57qrMQ(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        PinEntryEditText pinEntryEditText = ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
        InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
        LoginInfoDialog loginInfoDialog = challengePinWithFaceActivity.B;
        if (loginInfoDialog != null) {
            loginInfoDialog.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void $r8$lambda$jgZWVW68w0P0W0LU7V9z6llOWdI(final ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        DanaH5.startContainerFullUrlWithoutTimeout(challengePinWithFaceActivity.MyBillsEntityDataFactory("FORGOT_PIN"), new DanaH5Listener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$registerClickListener$7$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                ChallengePinWithFaceActivity.access$getDanaLoadingDialog(ChallengePinWithFaceActivity.this).PlaceComponentResult();
                ChallengePinWithFaceActivity.this.finish();
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$n1f0vKCnO9i6sEW0lQZ4nqYedyY(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        proceedLogout$default(challengePinWithFaceActivity, null, 1, null);
    }

    public static /* synthetic */ void $r8$lambda$tinaxjFaCB91YPqMYjpj7ltUHKU(final ChallengePinWithFaceActivity challengePinWithFaceActivity, String str, Bundle bundle) {
        String string;
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        if (bundle.getInt("KEY_RESULT") == 0 && (string = bundle.getString("errorCode")) != null && string.hashCode() == -1790125876 && string.equals("AE15112158100410")) {
            ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).lookAheadTest.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
            Context baseContext = challengePinWithFaceActivity.getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "");
            DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(baseContext);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.otp_daily_limit_title);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
            builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.otp_daily_limit_desc);
            String string2 = challengePinWithFaceActivity.getString(R.string.otp_daily_limit_got_it);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String upperCase = string2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            String str2 = upperCase;
            Intrinsics.checkNotNullParameter(str2, "");
            builder.PrepareContext = str2;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$showOtpDailyLimitError$dialog$1$1
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
                    ChallengePinWithFaceActivity.this.finish();
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.newProxyInstance = function0;
            builder.lookAheadTest = Boolean.FALSE;
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            FragmentManager supportFragmentManager = challengePinWithFaceActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            Intrinsics.checkNotNullParameter(supportFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(supportFragmentManager, "DanaAlertDialog");
        }
    }

    /* renamed from: $r8$lambda$wIvgZ-eVBoqbePHQioiP4jBm0nc */
    public static /* synthetic */ void m606$r8$lambda$wIvgZeVBoqbePHQioiP4jBm0nc(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        Intrinsics.checkNotNullParameter(challengePinWithFaceActivity, "");
        ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).BuiltInFictitiousFunctionClassFactory.requestFocus();
        KeyboardHelper.getAuthRequestContext(challengePinWithFaceActivity);
    }

    public static final /* synthetic */ void access$chooseLoginType(ChallengePinWithFaceActivity challengePinWithFaceActivity, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("enter chooseLoginType ");
        String str2 = challengePinWithFaceActivity.getValueOfTouchPositionAbsolute;
        String str3 = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str2 = null;
        }
        sb.append(str2);
        DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
        boolean MyBillsEntityDataFactory = AppUtil.MyBillsEntityDataFactory(challengePinWithFaceActivity.getBaseContext());
        String str4 = challengePinWithFaceActivity.getValueOfTouchPositionAbsolute;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str4 = null;
        }
        if (Intrinsics.areEqual(str4, ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
            challengePinWithFaceActivity.getPresenter().MyBillsEntityDataFactory("PASSWORD", str);
        } else if (Intrinsics.areEqual(str4, ChallengeScenario.TRUST_RISK_LOGIN)) {
            AbstractPinContract.Presenter presenter = challengePinWithFaceActivity.getPresenter();
            String str5 = challengePinWithFaceActivity.getOnBoardingScenario;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                str3 = str5;
            }
            presenter.getAuthRequestContext(str, str3, MyBillsEntityDataFactory, false);
        } else {
            challengePinWithFaceActivity.getPresenter().getAuthRequestContext(str, MyBillsEntityDataFactory);
        }
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        return (DanaLoadingDialog) challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
    }

    public static final /* synthetic */ EnrollPasskeyLauncher access$getEnrollPasskeyLauncher(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        return (EnrollPasskeyLauncher) challengePinWithFaceActivity.isLayoutRequested.getValue();
    }

    public static final /* synthetic */ FirebasePerformanceMonitor access$getFirebasePerformanceMonitor(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        return (FirebasePerformanceMonitor) challengePinWithFaceActivity.newProxyInstance.getValue();
    }

    public static final /* synthetic */ void access$getLogSeedId(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        String str = challengePinWithFaceActivity.getValueOfTouchPositionAbsolute;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        int hashCode = str.hashCode();
        if (hashCode != 103149417) {
            if (hashCode != 1319662811) {
                if (hashCode != 1573803584 || !str.equals(ChallengeScenario.TRUST_RISK_LOGIN)) {
                    return;
                }
            } else if (!str.equals(ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                return;
            }
        } else if (!str.equals("login")) {
            return;
        }
        DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(LoginTrackingConstants.NormalLogin.BEGIN, "");
    }

    public static final /* synthetic */ ResetPinLauncher access$getStrategy(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        return (ResetPinLauncher) challengePinWithFaceActivity.I.getValue();
    }

    public static final /* synthetic */ void access$gotoHome(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        Intent intent = new Intent(challengePinWithFaceActivity, HomeTabActivity.class);
        intent.setData(challengePinWithFaceActivity.getIntent().getData());
        intent.setFlags(268468224);
        challengePinWithFaceActivity.overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter(TrackerKey.Event.APP_TOTAL_LOGIN_TIME, "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.APP_TOTAL_LOGIN_TIME);
        challengePinWithFaceActivity.startActivity(intent);
        challengePinWithFaceActivity.finish();
    }

    public static final /* synthetic */ void access$handleNeedFallbackFromPasskey(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        if ((challengePinWithFaceActivity.K.isEmpty() ^ true) && challengePinWithFaceActivity.K.size() > 1 && Intrinsics.areEqual(CollectionsKt.first((List) challengePinWithFaceActivity.K), "PASSKEYS")) {
            List<String> mutableList = CollectionsKt.toMutableList((Collection) challengePinWithFaceActivity.K);
            CollectionsKt.removeFirst(mutableList);
            challengePinWithFaceActivity.K = mutableList;
            challengePinWithFaceActivity.onNext(mutableList, null);
        }
    }

    public static final /* synthetic */ void access$navigateToPreviousPage(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        if (Intrinsics.areEqual(challengePinWithFaceActivity.PrepareContext, ErrorCode.SESSION_EXPIRED)) {
            challengePinWithFaceActivity.setResult(0, new Intent().putExtra(ChallengeControl.Key.CANCEL_REASON, ChallengeControl.CancelReason.SESSION_EXPIRED));
            challengePinWithFaceActivity.finish();
        } else if (Intrinsics.areEqual(challengePinWithFaceActivity.PrepareContext, ErrorCode.VERIFY_PASSWORD_TRUST_RISK_EXPIRED)) {
            challengePinWithFaceActivity.setResult(0, new Intent().putExtra(ChallengeControl.Key.CANCEL_REASON, ChallengeControl.CancelReason.VERIFY_PASSWORD_TRUST_RISK_EXPIRED));
            challengePinWithFaceActivity.finish();
        } else {
            OnboardingActivity.Companion companion = OnboardingActivity.INSTANCE;
            ChallengePinWithFaceActivity challengePinWithFaceActivity2 = challengePinWithFaceActivity;
            Intrinsics.checkNotNullParameter(challengePinWithFaceActivity2, "");
            challengePinWithFaceActivity2.startActivity(OnboardingActivity.Companion.MyBillsEntityDataFactory((Context) challengePinWithFaceActivity2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    public static final /* synthetic */ void access$onErrorResetPin(ChallengePinWithFaceActivity challengePinWithFaceActivity, Throwable th) {
        Object m3179constructorimpl;
        Object m3179constructorimpl2;
        Object m3179constructorimpl3;
        Object m3179constructorimpl4;
        boolean z = th instanceof NetworkException;
        int i = R.string.general_error_message;
        if (!z) {
            if (th instanceof NoInternetConnectionException) {
                challengePinWithFaceActivity.showWarningDialog(challengePinWithFaceActivity.getBaseContext().getString(R.string.general_no_connection_error_message));
                return;
            } else {
                challengePinWithFaceActivity.showWarningDialog(challengePinWithFaceActivity.getBaseContext().getString(R.string.general_error_message));
                return;
            }
        }
        NetworkException networkException = (NetworkException) th;
        String errorCode = networkException.getErrorCode();
        if (errorCode != null) {
            switch (errorCode.hashCode()) {
                case -1814080562:
                    if (errorCode.equals(ErrorCode.RISK_REJECT_BLACKLIST)) {
                        try {
                            Result.Companion companion = kotlin.Result.INSTANCE;
                            ChallengePinWithFaceActivity challengePinWithFaceActivity2 = challengePinWithFaceActivity;
                            challengePinWithFaceActivity.getRiskRejectDialog().get();
                            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = RiskRejectDialog.getAuthRequestContext(challengePinWithFaceActivity).BuiltInFictitiousFunctionClassFactory();
                            FragmentManager supportFragmentManager = challengePinWithFaceActivity.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                            Intrinsics.checkNotNullParameter(supportFragmentManager, "");
                            BuiltInFictitiousFunctionClassFactory.show(supportFragmentManager, "DanaAlertDialog");
                            m3179constructorimpl = kotlin.Result.m3179constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = kotlin.Result.INSTANCE;
                            m3179constructorimpl = kotlin.Result.m3179constructorimpl(ResultKt.createFailure(th2));
                        }
                        if (kotlin.Result.m3186isSuccessimpl(m3179constructorimpl)) {
                            Unit unit = (Unit) m3179constructorimpl;
                            Context baseContext = challengePinWithFaceActivity.getBaseContext();
                            String message = networkException.getMessage();
                            Context baseContext2 = challengePinWithFaceActivity.getBaseContext();
                            MixPanelTracker.BuiltInFictitiousFunctionClassFactory(baseContext, TrackerDataKey.NetworkErrorOperationTypeProperty.FORGET_PASSWORD_CONSULT, message, baseContext2 != null ? baseContext2.getString(R.string.risk_reject_blacklist_message) : 0, TrackerDataKey.Source.VERIFY_PHONE_NUMBER, networkException.getTraceId());
                            return;
                        }
                        return;
                    }
                    break;
                case -1814080561:
                    if (errorCode.equals(ErrorCode.RISK_REJECT_SUSPICIOUS)) {
                        try {
                            Result.Companion companion3 = kotlin.Result.INSTANCE;
                            ChallengePinWithFaceActivity challengePinWithFaceActivity3 = challengePinWithFaceActivity;
                            challengePinWithFaceActivity.getRiskRejectDialog().get();
                            DanaAlertDialog BuiltInFictitiousFunctionClassFactory2 = RiskRejectDialog.MyBillsEntityDataFactory(challengePinWithFaceActivity).BuiltInFictitiousFunctionClassFactory();
                            FragmentManager supportFragmentManager2 = challengePinWithFaceActivity.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "");
                            Intrinsics.checkNotNullParameter(supportFragmentManager2, "");
                            BuiltInFictitiousFunctionClassFactory2.show(supportFragmentManager2, "DanaAlertDialog");
                            m3179constructorimpl2 = kotlin.Result.m3179constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th3) {
                            Result.Companion companion4 = kotlin.Result.INSTANCE;
                            m3179constructorimpl2 = kotlin.Result.m3179constructorimpl(ResultKt.createFailure(th3));
                        }
                        if (kotlin.Result.m3186isSuccessimpl(m3179constructorimpl2)) {
                            Unit unit2 = (Unit) m3179constructorimpl2;
                            Context baseContext3 = challengePinWithFaceActivity.getBaseContext();
                            String message2 = networkException.getMessage();
                            Context baseContext4 = challengePinWithFaceActivity.getBaseContext();
                            MixPanelTracker.BuiltInFictitiousFunctionClassFactory(baseContext3, TrackerDataKey.NetworkErrorOperationTypeProperty.FORGET_PASSWORD_CONSULT, message2, baseContext4 != null ? baseContext4.getString(R.string.risk_reject_suspicious_message) : null, TrackerDataKey.Source.VERIFY_PHONE_NUMBER, networkException.getTraceId());
                            return;
                        }
                        return;
                    }
                    break;
                case -1814080560:
                    if (errorCode.equals(ErrorCode.RISK_REJECT_RETRY_1_DAY)) {
                        try {
                            Result.Companion companion5 = kotlin.Result.INSTANCE;
                            ChallengePinWithFaceActivity challengePinWithFaceActivity4 = challengePinWithFaceActivity;
                            challengePinWithFaceActivity.getRiskRejectDialog().get();
                            DanaAlertDialog BuiltInFictitiousFunctionClassFactory3 = RiskRejectDialog.KClassImpl$Data$declaredNonStaticMembers$2(challengePinWithFaceActivity).BuiltInFictitiousFunctionClassFactory();
                            FragmentManager supportFragmentManager3 = challengePinWithFaceActivity.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "");
                            Intrinsics.checkNotNullParameter(supportFragmentManager3, "");
                            BuiltInFictitiousFunctionClassFactory3.show(supportFragmentManager3, "DanaAlertDialog");
                            m3179constructorimpl3 = kotlin.Result.m3179constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th4) {
                            Result.Companion companion6 = kotlin.Result.INSTANCE;
                            m3179constructorimpl3 = kotlin.Result.m3179constructorimpl(ResultKt.createFailure(th4));
                        }
                        if (kotlin.Result.m3186isSuccessimpl(m3179constructorimpl3)) {
                            Unit unit3 = (Unit) m3179constructorimpl3;
                            Context baseContext5 = challengePinWithFaceActivity.getBaseContext();
                            String message3 = networkException.getMessage();
                            Context baseContext6 = challengePinWithFaceActivity.getBaseContext();
                            MixPanelTracker.BuiltInFictitiousFunctionClassFactory(baseContext5, TrackerDataKey.NetworkErrorOperationTypeProperty.FORGET_PASSWORD_CONSULT, message3, baseContext6 != null ? baseContext6.getString(R.string.risk_reject_retry_1_day_message) : null, TrackerDataKey.Source.VERIFY_PHONE_NUMBER, networkException.getTraceId());
                            return;
                        }
                        return;
                    }
                    break;
                case -1814080559:
                    if (errorCode.equals(ErrorCode.RISK_REJECT_RETRY_7_DAY)) {
                        try {
                            Result.Companion companion7 = kotlin.Result.INSTANCE;
                            ChallengePinWithFaceActivity challengePinWithFaceActivity5 = challengePinWithFaceActivity;
                            challengePinWithFaceActivity.getRiskRejectDialog().get();
                            DanaAlertDialog BuiltInFictitiousFunctionClassFactory4 = RiskRejectDialog.BuiltInFictitiousFunctionClassFactory(challengePinWithFaceActivity).BuiltInFictitiousFunctionClassFactory();
                            FragmentManager supportFragmentManager4 = challengePinWithFaceActivity.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager4, "");
                            Intrinsics.checkNotNullParameter(supportFragmentManager4, "");
                            BuiltInFictitiousFunctionClassFactory4.show(supportFragmentManager4, "DanaAlertDialog");
                            m3179constructorimpl4 = kotlin.Result.m3179constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th5) {
                            Result.Companion companion8 = kotlin.Result.INSTANCE;
                            m3179constructorimpl4 = kotlin.Result.m3179constructorimpl(ResultKt.createFailure(th5));
                        }
                        if (kotlin.Result.m3186isSuccessimpl(m3179constructorimpl4)) {
                            Unit unit4 = (Unit) m3179constructorimpl4;
                            Context baseContext7 = challengePinWithFaceActivity.getBaseContext();
                            String message4 = networkException.getMessage();
                            Context baseContext8 = challengePinWithFaceActivity.getBaseContext();
                            MixPanelTracker.BuiltInFictitiousFunctionClassFactory(baseContext7, TrackerDataKey.NetworkErrorOperationTypeProperty.FORGET_PASSWORD_CONSULT, message4, baseContext8 != null ? baseContext8.getString(R.string.risk_reject_retry_7_day_message) : null, TrackerDataKey.Source.VERIFY_PHONE_NUMBER, networkException.getTraceId());
                            return;
                        }
                        return;
                    }
                    break;
            }
        }
        StringWrapper authRequestContext = StringWrapperExtKt.getAuthRequestContext(networkException, new StringWrapper.ResValue(i, r2, 2, r2));
        Context baseContext9 = challengePinWithFaceActivity.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext9, "");
        challengePinWithFaceActivity.showWarningDialog(StringWrapperKt.getAuthRequestContext(baseContext9, authRequestContext));
    }

    public static final /* synthetic */ void access$onForgotPin(final ChallengePinWithFaceActivity challengePinWithFaceActivity, boolean z) {
        LoginInfoDialog loginInfoDialog = challengePinWithFaceActivity.B;
        if (loginInfoDialog != null) {
            loginInfoDialog.getAuthRequestContext();
        }
        if (!z) {
            ((DanaLoadingDialog) challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue()).PlaceComponentResult();
            challengePinWithFaceActivity.scheduleImpl();
            return;
        }
        DanaH5.startContainerFullUrlWithSendCredentialsWithoutTimeOut$default(challengePinWithFaceActivity.getDynamicUrlWrapper().getForgotPinUrl(), new DanaH5Listener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                ChallengePinWithFaceActivity.access$getDanaLoadingDialog(ChallengePinWithFaceActivity.this).PlaceComponentResult();
                KeyboardHelper.MyBillsEntityDataFactory(ChallengePinWithFaceActivity.this);
            }
        }, null, null, 8, null);
    }

    public static final /* synthetic */ void access$openSuspiciousAccountVerifyPage(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        Intent intent = new Intent(challengePinWithFaceActivity, SuspiciousAccountVerifyActivity.class);
        Bundle bundle = challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Bundle bundle2 = null;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bundle = null;
        }
        bundle.putString(SUSPICIOUS_ACCOUNT, challengePinWithFaceActivity.MyBillsEntityDataFactory(SUSPICIOUS_ACCOUNT));
        Bundle bundle3 = challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bundle2 = bundle3;
        }
        intent.putExtras(bundle2);
        challengePinWithFaceActivity.startActivity(intent);
        challengePinWithFaceActivity.finish();
    }

    public static final /* synthetic */ String access$setOtpPurpose(ChallengePinWithFaceActivity challengePinWithFaceActivity, List list) {
        return (list.size() <= 1 || !Intrinsics.areEqual(list.get(0), VerifyMethod.CARRIER_IDENTIFICATION)) ? (list.size() <= 1 || !Intrinsics.areEqual(list.get(0), VerifyMethod.PUSH_VERIFY)) ? "Direct Challenge" : ChallengeEvent.OTPPurpose.PV_FAILOVER : ChallengeEvent.OTPPurpose.PNV_FAILOVER;
    }

    public static final /* synthetic */ void access$showErrorMessage(final ChallengePinWithFaceActivity challengePinWithFaceActivity, final String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        String string;
        if (z3) {
            challengePinWithFaceActivity.scheduleImpl();
        } else if (z4) {
            if (z5) {
                string = challengePinWithFaceActivity.getString(R.string.lbl_dialog_account_temp_freeze);
                Intrinsics.checkNotNullExpressionValue(string, "");
            } else {
                string = challengePinWithFaceActivity.getString(R.string.lbl_dialog_account_freeze);
                Intrinsics.checkNotNullExpressionValue(string, "");
            }
            ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).BuiltInFictitiousFunctionClassFactory.clearFocus();
            LoginInfoDialog.Builder builder = new LoginInfoDialog.Builder(challengePinWithFaceActivity);
            builder.initRecordTimeStamp = string;
            builder.PlaceComponentResult = str;
            LoginInfoDialog.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.MyBillsEntityDataFactory = false;
            MyBillsEntityDataFactory.getErrorConfigVersion = R.drawable.rounded_white_8dp;
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.ACCOUNT_LOCK;
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            if (z5) {
                String string2 = challengePinWithFaceActivity.getString(R.string.lbl_dialog_understand);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                String upperCase = string2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "");
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda19
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChallengePinWithFaceActivity.m600$r8$lambda$Bn3GDIwmvMogviHlmbLrYHRH_s(ChallengePinWithFaceActivity.this, view);
                    }
                };
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = upperCase;
                MyBillsEntityDataFactory.moveToNextValue = onClickListener;
            } else {
                String string3 = challengePinWithFaceActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 ? challengePinWithFaceActivity.getString(R.string.lbl_dialog_call_customer_care) : challengePinWithFaceActivity.getString(R.string.lbl_dialog_understand);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                String upperCase2 = string3.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "");
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChallengePinWithFaceActivity.$r8$lambda$Dd095lfjuJc1ohQusa8i1jVFARo(ChallengePinWithFaceActivity.this, str, view);
                    }
                };
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = upperCase2;
                MyBillsEntityDataFactory.moveToNextValue = onClickListener2;
            }
            LoginInfoDialog loginInfoDialog = new LoginInfoDialog(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory, (byte) 0);
            loginInfoDialog.MyBillsEntityDataFactory();
            challengePinWithFaceActivity.B = loginInfoDialog;
        } else if (z2) {
            ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).BuiltInFictitiousFunctionClassFactory.clearFocus();
            LoginInfoDialog.Builder builder2 = new LoginInfoDialog.Builder(challengePinWithFaceActivity);
            builder2.initRecordTimeStamp = challengePinWithFaceActivity.getString(R.string.lbl_dialog_incorrect_pin_title);
            builder2.PlaceComponentResult = str;
            LoginInfoDialog.Builder MyBillsEntityDataFactory2 = builder2.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
            MyBillsEntityDataFactory2.MyBillsEntityDataFactory = false;
            MyBillsEntityDataFactory2.getErrorConfigVersion = R.drawable.rounded_white_8dp;
            MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.WARNING;
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
            if (z) {
                if (z2) {
                    String string4 = challengePinWithFaceActivity.getString(R.string.forget_pin);
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "");
                    String upperCase3 = string4.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase3, "");
                    View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda16
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ChallengePinWithFaceActivity.m604$r8$lambda$fzsxprc4SJd8toMjvqgzEJCZw(ChallengePinWithFaceActivity.this, view);
                        }
                    };
                    MyBillsEntityDataFactory2.scheduleImpl = upperCase3;
                    MyBillsEntityDataFactory2.lookAheadTest = onClickListener3;
                }
                String string5 = challengePinWithFaceActivity.getString(R.string.try_again);
                Intrinsics.checkNotNullExpressionValue(string5, "");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "");
                String upperCase4 = string5.toUpperCase(locale2);
                Intrinsics.checkNotNullExpressionValue(upperCase4, "");
                View.OnClickListener onClickListener4 = new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda17
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChallengePinWithFaceActivity.$r8$lambda$jcp0oN5xZ_Cb1ExJbnZtE57qrMQ(ChallengePinWithFaceActivity.this, view);
                    }
                };
                MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0 = upperCase4;
                MyBillsEntityDataFactory2.moveToNextValue = onClickListener4;
            } else {
                String string6 = challengePinWithFaceActivity.getString(17039370);
                View.OnClickListener onClickListener5 = new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda18
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChallengePinWithFaceActivity.$r8$lambda$b0WkbLy4JcsRhNPDgdfTdd_fw28(ChallengePinWithFaceActivity.this, view);
                    }
                };
                MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0 = string6;
                MyBillsEntityDataFactory2.moveToNextValue = onClickListener5;
            }
            LoginInfoDialog loginInfoDialog2 = new LoginInfoDialog(MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory2.getAuthRequestContext, MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory2, (byte) 0);
            loginInfoDialog2.MyBillsEntityDataFactory();
            challengePinWithFaceActivity.B = loginInfoDialog2;
        } else {
            Intent putExtra = new Intent().putExtra("message", str);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            if (str2.length() > 0) {
                putExtra.putExtra(ChallengeControl.Key.CANCEL_REASON, str2);
            }
            challengePinWithFaceActivity.setResult(0, putExtra);
            challengePinWithFaceActivity.finish();
        }
    }

    public static final /* synthetic */ void access$showPinIncorrectLockPage(ChallengePinWithFaceActivity challengePinWithFaceActivity, int i) {
        PinIncorrectLockFragment.Companion companion = PinIncorrectLockFragment.INSTANCE;
        PinIncorrectLockFragment PlaceComponentResult = PinIncorrectLockFragment.Companion.PlaceComponentResult(i);
        PinEntryEditText pinEntryEditText = ((ActivityInputPinOrFaceBinding) challengePinWithFaceActivity.getBinding()).BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
        InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
        PlaceComponentResult.show(challengePinWithFaceActivity.getSupportFragmentManager(), "PinIncorrectLockFragment");
    }

    public static final /* synthetic */ void access$showProgressDialog(ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        LoginInfoDialog loginInfoDialog = challengePinWithFaceActivity.B;
        if (loginInfoDialog != null) {
            if (!((loginInfoDialog == null || loginInfoDialog.PlaceComponentResult()) ? false : true)) {
                return;
            }
        }
        LoginInfoDialog.Builder builder = new LoginInfoDialog.Builder(challengePinWithFaceActivity);
        builder.PlaceComponentResult = challengePinWithFaceActivity.getString(R.string.verifying_your_account);
        builder.MyBillsEntityDataFactory = false;
        LoginInfoDialog.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.WAITING;
        LoginInfoDialog loginInfoDialog2 = new LoginInfoDialog(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory, (byte) 0);
        loginInfoDialog2.MyBillsEntityDataFactory();
        challengePinWithFaceActivity.B = loginInfoDialog2;
    }

    public static final /* synthetic */ void access$showTooManyInputPinDialog(final ChallengePinWithFaceActivity challengePinWithFaceActivity) {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(challengePinWithFaceActivity);
        builder.FragmentBottomSheetPaymentSettingBinding = challengePinWithFaceActivity.getString(R.string.too_many_wrong_pin_title);
        builder.getErrorConfigVersion = challengePinWithFaceActivity.getString(R.string.too_many_wrong_pin_description);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = R.color.f23982131099995;
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string = challengePinWithFaceActivity.getString(R.string.limit_otp_button);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.challenge.ChallengePinWithFaceActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChallengePinWithFaceActivity.m602$r8$lambda$ZwwxJKlSlXyqObNHA2j_D_HMFE(ChallengePinWithFaceActivity.this, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        challengePinWithFaceActivity.VerifyPinStateManager$executeRiskChallenge$2$1 = KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static /* synthetic */ void proceedLogout$default(ChallengePinWithFaceActivity challengePinWithFaceActivity, View view, int i, Object obj) {
        String str = null;
        if ((i & 1) != 0) {
            view = null;
        }
        String str2 = challengePinWithFaceActivity.getValueOfTouchPositionAbsolute;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str = str2;
        }
        if (Intrinsics.areEqual(str, ChallengeScenario.TRUST_RISK_LOGIN) ? true : Intrinsics.areEqual(str, ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
            challengePinWithFaceActivity.getLogoutPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            return;
        }
        if (view != null) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(view);
        }
        challengePinWithFaceActivity.finish();
    }

    private static void k(boolean z, byte[] bArr, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = J;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i6 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i6, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i6);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
