package id.dana.challenge.otp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Insets;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.perf.FirebasePerformance;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.performanceduration.DanaPerformanceDurationTracker;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenario;
import id.dana.challenge.ChallengeScenarioListener;
import id.dana.challenge.OtpHeightListener;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.challenge.otp.OtpState;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.danah5.DanaH5;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.DanaUrl;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import id.dana.databinding.FragmentInputOtpBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerOtpChallengeComponent;
import id.dana.di.component.OtpChallengeComponent;
import id.dana.di.modules.ChangePhoneNumberH5EventModule;
import id.dana.di.modules.OtpChallengeModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.LoginInfoDialog;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.domain.otp.model.SendStrategy;
import id.dana.h5event.ChangePhoneNumberH5EventContract;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.VerifyMethodAnalyticTracker;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sync_engine.permission.PermissionUtil;
import id.dana.tracker.EventTracker;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.model.TrackOtpModel;
import id.dana.utils.DanaTextWatcher;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.ViewHelper;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import id.dana.utils.tracker.mixpanel.MixpanelValueUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 o2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001oB\u0007¢\u0006\u0004\bn\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0015\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ/\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u000bJ\u0019\u0010!\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b!\u0010\"J?\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\n\u0010\u001cJ\u0019\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\n\u0010\"J?\u0010$\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010$\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b$\u0010\"J'\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\u000bJ\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u000bJ\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\u000bJ\u0017\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b)\u0010,J\u000f\u0010-\u001a\u00020\u0007H\u0002¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010$\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010\u000bJ\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000fH\u0002¢\u0006\u0004\b)\u0010\"J\u0019\u0010$\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b$\u0010,J\u000f\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010\u000bJ\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u000bJ\u000f\u00100\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u0010\u000bJ\u000f\u00101\u001a\u00020\u0007H\u0002¢\u0006\u0004\b1\u0010\u000bJ\u000f\u00102\u001a\u00020\u0007H\u0002¢\u0006\u0004\b2\u0010\u000bJ\u001f\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u00103J\u001f\u0010$\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u00104J\u000f\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b5\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\r\u0010\"J\u000f\u00106\u001a\u00020\u0007H\u0016¢\u0006\u0004\b6\u0010\u000bJ\u000f\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b7\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u00108\u001a\u00020\u0007H\u0002¢\u0006\u0004\b8\u0010\u000bJ\u000f\u00109\u001a\u00020\u0007H\u0002¢\u0006\u0004\b9\u0010\u000bJ#\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\n\u00103R\u0018\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:X\u0087\"¢\u0006\u0006\n\u0004\b<\u0010=R\u0012\u0010?\u001a\u00020>X\u0087\"¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010AR\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010BR\u0018\u0010&\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010DR\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010ER\u0013\u0010\n\u001a\u00020FX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bG\u0010HR\u0012\u0010J\u001a\u00020IX\u0087\"¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010AR\u0016\u0010L\u001a\u00020M8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010NR\u0016\u0010\r\u001a\u00020M8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010NR\u0014\u0010\u0010\u001a\u00020O8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u0010PR\u0016\u0010Q\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010BR\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bQ\u0010BR\u0016\u0010\u0018\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u0010BR\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u0010BR\u0014\u0010-\u001a\u00020\u000e8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u0010BR\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u0010BR\u0018\u00100\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u0010TR\u0014\u00105\u001a\u00020U8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010VR\u0018\u0010/\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u00107\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bZ\u0010AR\u0016\u0010X\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u0010BR\u0018\u00109\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u0010AR\u0014\u0010Z\u001a\u00020[8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u00108\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b^\u0010AR\u0018\u0010`\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b_\u0010AR\u0018\u0010^\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010AR\u0012\u0010b\u001a\u00020aX\u0087\"¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010AR\u0016\u0010_\u001a\u00020e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010\\\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bh\u0010AR\u0014\u0010i\u001a\u00020\u000f8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0011R\u0018\u0010f\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bi\u0010kR\u0018\u0010h\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u0010kR\u0014\u0010l\u001a\u00020\u000f8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0011R\u0016\u0010m\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010B"}, d2 = {"Lid/dana/challenge/otp/OtpChallengeFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentInputOtpBinding;", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "Lid/dana/challenge/OtpHeightListener;", "", "p0", "", "addBottomSheetHeight", "(I)V", "BuiltInFictitiousFunctionClassFactory", "()V", "dismissProgress", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "", "lookAheadTest", "()Ljava/lang/String;", "getLayout", "()I", "scheduleImpl", IAPSyncCommand.COMMAND_INIT, "getAuthRequestContext", "(Ljava/lang/String;)Z", "GetContactSyncConfig", "p1", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "onAttach", "(Landroid/content/Context;)V", "onDestroyView", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "p4", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "(II)V", "onResume", "KClassImpl$Data$declaredNonStaticMembers$2", "DatabaseTableConfigUtil", "Landroid/view/View;", "(Landroid/view/View;)V", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda8", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Z)V", "PrepareContext", "showProgress", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Ldagger/Lazy;", "Lid/dana/challenge/botprotection/BotProtectionChallenge;", "botProtectionChallenge", "Ldagger/Lazy;", "Lid/dana/h5event/ChangePhoneNumberH5EventContract$Presenter;", "changePhoneNumberH5EventPresenter", "Lid/dana/h5event/ChangePhoneNumberH5EventContract$Presenter;", "Ljava/lang/String;", "Z", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "I", "Lid/dana/dialog/DanaLoadingDialog;", "getErrorConfigVersion", "Lkotlin/Lazy;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "moveToNextValue", "Landroidx/constraintlayout/widget/ConstraintSet;", "Landroidx/constraintlayout/widget/ConstraintSet;", "Lid/dana/utils/DanaTextWatcher;", "Lid/dana/utils/DanaTextWatcher;", "initRecordTimeStamp", "()Z", "Lid/dana/dialog/LoginInfoDialog;", "Lid/dana/dialog/LoginInfoDialog;", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "Lid/dana/di/component/OtpChallengeComponent;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/di/component/OtpChallengeComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Landroid/content/BroadcastReceiver;", "whenAvailable", "Landroid/content/BroadcastReceiver;", "getSupportButtonTintMode", "SubSequence", "readMicros", "Lid/dana/challenge/otp/AbstractOtpContract$Presenter;", "presenter", "Lid/dana/challenge/otp/AbstractOtpContract$Presenter;", "getCallingPid", "Lid/dana/challenge/ChallengeScenarioListener;", "A", "Lid/dana/challenge/ChallengeScenarioListener;", DiskFormatter.B, "VerifyPinStateManager$executeRiskChallenge$2$1", "", "Ljava/lang/Long;", "BottomSheetCardBindingView$watcherCardNumberView$1", "C", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OtpChallengeFragment extends ViewBindingFragment<FragmentInputOtpBinding> implements AbstractOtpContract.View, OtpHeightListener {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A  reason: from kotlin metadata */
    private ChallengeScenarioListener SubSequence;

    /* renamed from: B  reason: from kotlin metadata */
    private String whenAvailable;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private Long B;
    private boolean C;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private OtpChallengeComponent NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private CountDownTimer MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private boolean FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private LoginInfoDialog newProxyInstance;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private String readMicros;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private Long A;
    @Inject
    public Lazy<BotProtectionChallenge> botProtectionChallenge;
    @Inject
    public ChangePhoneNumberH5EventContract.Presenter changePhoneNumberH5EventPresenter;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    private String getCallingPid;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;
    private boolean isLayoutRequested;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    @Inject
    public AbstractOtpContract.Presenter presenter;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private String getSupportButtonTintMode;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String getErrorConfigVersion;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen PrepareContext = new MeasureLoadAndRenderingScreen();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final DanaTextWatcher lookAheadTest = new DanaTextWatcher();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final kotlin.Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.challenge.otp.OtpChallengeFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(OtpChallengeFragment.this.getActivity());
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private ConstraintSet moveToNextValue = new ConstraintSet();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private ConstraintSet NetworkUserEntityData$$ExternalSyntheticLambda0 = new ConstraintSet();

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final BroadcastReceiver NetworkUserEntityData$$ExternalSyntheticLambda4 = new BroadcastReceiver() { // from class: id.dana.challenge.otp.OtpChallengeFragment$otpReceiver$1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String errorConfigVersion;
            FragmentInputOtpBinding binding;
            PinEntryEditText pinEntryEditText;
            AbstractOtpContract.Presenter presenter = null;
            String stringExtra = intent != null ? intent.getStringExtra(WhatsAppOtpReceiver.OTP) : null;
            if (stringExtra == null) {
                stringExtra = "";
            }
            String str = stringExtra;
            if (!(str.length() > 0) || Intrinsics.areEqual(stringExtra, "null")) {
                return;
            }
            AbstractOtpContract.Presenter presenter2 = OtpChallengeFragment.this.presenter;
            if (presenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter2 = null;
            }
            presenter2.lookAheadTest();
            AbstractOtpContract.Presenter presenter3 = OtpChallengeFragment.this.presenter;
            if (presenter3 != null) {
                presenter = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            int lookAheadTest = presenter.getLookAheadTest();
            errorConfigVersion = OtpChallengeFragment.this.getErrorConfigVersion();
            VerifyMethodAnalyticTracker.getAuthRequestContext(SummaryActivity.CHECKED, String.valueOf(lookAheadTest), errorConfigVersion);
            binding = OtpChallengeFragment.this.getBinding();
            if (binding == null || (pinEntryEditText = binding.getErrorConfigVersion) == null) {
                return;
            }
            pinEntryEditText.setText(str);
        }
    };

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
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

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_input_otp;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ FragmentInputOtpBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentInputOtpBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentInputOtpBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        this.A = Long.valueOf(System.currentTimeMillis());
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.PrepareContext;
        Intrinsics.checkNotNullParameter("input_otp_dialog_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("input_otp_dialog_render");
        try {
            BaseActivity baseActivity = getBaseActivity();
            if (baseActivity != null) {
                this.SubSequence = (ChallengeScenarioListener) baseActivity;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.challenge.ChallengeScenarioListener");
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(p0);
            sb.append("must implement ChallengeScenarioListener");
            throw new ClassCastException(sb.toString());
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        final PinEntryEditText pinEntryEditText3;
        TextView textView4;
        AbstractOtpContract.Presenter presenter;
        AbstractOtpContract.Presenter presenter2;
        FragmentInputOtpBinding binding;
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(16);
        }
        Bundle arguments = getArguments();
        byte b = 0;
        if (arguments != null) {
            this.getCallingPid = arguments.getString(ChallengeControl.Key.SCENARIO);
            this.whenAvailable = arguments.getString(ChallengeControl.Key.SECURITY_ID);
            String string = arguments.getString(ChallengeControl.Key.PHONE_NUMBER);
            if (!(string != null && StringsKt.startsWith$default(string, "+62", false, 2, (Object) null))) {
                StringBuilder sb = new StringBuilder();
                sb.append("+62");
                sb.append(string);
                string = sb.toString();
            }
            this.getSupportButtonTintMode = string;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = arguments.getString(ChallengeControl.Key.OTP_PURPOSE);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = arguments.getBoolean(ChallengeControl.Key.HELP_BUTTON_CHATBOT_FEATURE, false);
            this.getErrorConfigVersion = arguments.getString(ChallengeControl.Key.HELP_BUTTON_URL);
            this.scheduleImpl = arguments.getBoolean(ChallengeControl.Key.FROZEN_ACCOUNT_CHATBOT_FEATURE, false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = arguments.getString(ChallengeControl.Key.OTP_CHANNEL, OtpChannel.SMS);
            z = arguments.getBoolean(ChallengeControl.Key.IS_FREEZE_VERIFY_OTP, false);
            this.GetContactSyncConfig = arguments.getBoolean(ChallengeControl.Key.IS_ERROR_RESEND, false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = arguments.getBoolean(ChallengeControl.Key.IS_WHATSAPP_ONLY, false);
            String str = this.getCallingPid;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                DaggerOtpChallengeComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerOtpChallengeComponent.BuiltInFictitiousFunctionClassFactory();
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
                OtpChallengeFragment otpChallengeFragment = this;
                if (str == null) {
                    str = "";
                }
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (OtpChallengeModule) Preconditions.getAuthRequestContext(new OtpChallengeModule(otpChallengeFragment, str));
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ChangePhoneNumberH5EventModule) Preconditions.getAuthRequestContext(new ChangePhoneNumberH5EventModule(new ChangePhoneNumberH5EventContract.View() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda8
                    @Override // id.dana.h5event.ChangePhoneNumberH5EventContract.View
                    public final void BuiltInFictitiousFunctionClassFactory(boolean z2) {
                        OtpChallengeFragment.PlaceComponentResult(OtpChallengeFragment.this, z2);
                    }
                }));
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, OtpChallengeModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, ChangePhoneNumberH5EventModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new DaggerOtpChallengeComponent.OtpChallengeComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, b);
            }
            OtpChallengeComponent otpChallengeComponent = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (otpChallengeComponent != null) {
                otpChallengeComponent.getAuthRequestContext(this);
            }
            AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[2];
            AbstractOtpContract.Presenter presenter3 = this.presenter;
            if (presenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter3 = null;
            }
            abstractPresenterArr[0] = presenter3;
            ChangePhoneNumberH5EventContract.Presenter presenter4 = this.changePhoneNumberH5EventPresenter;
            if (presenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter4 = null;
            }
            abstractPresenterArr[1] = presenter4;
            registerPresenter(abstractPresenterArr);
            String str2 = this.getCallingPid;
            String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (Intrinsics.areEqual(ChallengeScenario.REGISTRATION, str2)) {
                String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (str4 == null) {
                    str4 = "";
                }
                EventTracker.PlaceComponentResult(new TrackOtpModel(getContext(), "Registration").BuiltInFictitiousFunctionClassFactory(MixpanelValueUtil.getAuthRequestContext(str4), str3));
                AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda7();
                AbstractOtpContract.Presenter presenter5 = this.presenter;
                if (presenter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter5 = null;
                }
                presenter5.getAuthRequestContext();
                arguments.getInt(ChallengeControl.Key.EXPIRY_SECONDS);
                MyBillsEntityDataFactory(arguments.getInt(ChallengeControl.Key.RETRY_SEND_SECONDS), arguments.getInt(ChallengeControl.Key.OTP_CODE_LENGTH));
                if (!this.KClassImpl$Data$declaredNonStaticMembers$2 && (binding = getBinding()) != null) {
                    ViewGroup.LayoutParams layoutParams = binding.GetContactSyncConfig.getLayoutParams();
                    if (layoutParams == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                    layoutParams2.G = -1;
                    layoutParams2.I = binding.KClassImpl$Data$declaredNonStaticMembers$2.getId();
                    binding.GetContactSyncConfig.requestLayout();
                }
                AbstractOtpContract.Presenter presenter6 = this.presenter;
                if (presenter6 != null) {
                    presenter2 = presenter6;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter2 = null;
                }
                String str5 = this.getSupportButtonTintMode;
                String str6 = str5 == null ? "" : str5;
                String str7 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                presenter2.KClassImpl$Data$declaredNonStaticMembers$2(str6, str7 == null ? "" : str7, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            }
            if (getAuthRequestContext(str2)) {
                String str8 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (str8 == null) {
                    str8 = "";
                }
                EventTracker.PlaceComponentResult(new TrackOtpModel(getContext(), "Login").BuiltInFictitiousFunctionClassFactory(MixpanelValueUtil.getAuthRequestContext(str8), str3));
                AbstractOtpContract.Presenter presenter7 = this.presenter;
                if (presenter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter7 = null;
                }
                presenter7.getAuthRequestContext();
                AppReadyMixpanelTracker appReadyMixpanelTracker2 = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                AppReadyMixpanelTracker.NetworkUserEntityData$$ExternalSyntheticLambda7();
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = "AP_LOGIN";
                this.readMicros = "AP_LOGIN";
                OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("login_verify_sms_flow_loadtime");
                AbstractOtpContract.Presenter presenter8 = this.presenter;
                if (presenter8 != null) {
                    presenter = presenter8;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                String str9 = this.getSupportButtonTintMode;
                String str10 = str9 == null ? "" : str9;
                String str11 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                presenter.KClassImpl$Data$declaredNonStaticMembers$2(str10, str11 == null ? "" : str11, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            }
            if (Intrinsics.areEqual("twilio_otp", str2)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = "TWILIO_CONSULT";
                this.readMicros = "TWILIO_CONSULT";
                AbstractOtpContract.Presenter presenter9 = this.presenter;
                if (presenter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter9 = null;
                }
                presenter9.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.readMicros, str3);
            }
            if (Intrinsics.areEqual(ChallengeScenario.AUTH_AGREEMENT_OTP, str2)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = SendStrategy.AUTH_AGREEMENT;
                this.readMicros = "AP_LOGIN";
                AbstractOtpContract.Presenter presenter10 = this.presenter;
                if (presenter10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter10 = null;
                }
                presenter10.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.readMicros, str3);
            }
            String str12 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (Intrinsics.areEqual(str12, OtpChannel.SMS)) {
                if (initRecordTimeStamp()) {
                    OnboardingFirebaseTracker onboardingFirebaseTracker2 = OnboardingFirebaseTracker.INSTANCE;
                    OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("user_interaction_login_sms_otp_input");
                } else if (getAuthRequestContext(this.getCallingPid)) {
                    OnboardingFirebaseTracker onboardingFirebaseTracker3 = OnboardingFirebaseTracker.INSTANCE;
                    OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("user_interaction_registration_sms_otp_input");
                    DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.TYPING_SMS_OTP_IN_MILLIS, System.currentTimeMillis());
                }
            } else if (Intrinsics.areEqual(str12, OtpChannel.WHATSAPP)) {
                if (initRecordTimeStamp()) {
                    OnboardingFirebaseTracker onboardingFirebaseTracker4 = OnboardingFirebaseTracker.INSTANCE;
                    OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("user_interaction_registration_wa_otp_input");
                } else if (getAuthRequestContext(this.getCallingPid)) {
                    DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.TYPING_WA_OTP_IN_MILLIS, System.currentTimeMillis());
                }
            }
            if (getAuthRequestContext(this.getCallingPid)) {
                ViewHelper.getAuthRequestContext(requireView(), new Runnable() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        OtpChallengeFragment.GetContactSyncConfig(OtpChallengeFragment.this);
                    }
                });
                String str13 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (!Intrinsics.areEqual(str13, OtpChannel.SMS)) {
                    if (Intrinsics.areEqual(str13, OtpChannel.WHATSAPP)) {
                        AbstractOtpContract.Presenter presenter11 = this.presenter;
                        if (presenter11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            presenter11 = null;
                        }
                        presenter11.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    }
                } else {
                    AbstractOtpContract.Presenter presenter12 = this.presenter;
                    if (presenter12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter12 = null;
                    }
                    presenter12.MyBillsEntityDataFactory();
                }
            }
        } else {
            z = false;
        }
        this.getAuthRequestContext = Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, OtpChannel.WHATSAPP) ? ChallengeEvent.Channel.WHATSAPP : ChallengeEvent.Channel.SMS;
        String string2 = this.GetContactSyncConfig ? getString(R.string.popup_resend_error_otp_title, this.getSupportButtonTintMode) : getString(R.string.popup_otp_title, this.getSupportButtonTintMode);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        FragmentInputOtpBinding binding2 = getBinding();
        TextView textView5 = binding2 != null ? binding2.DatabaseTableConfigUtil : null;
        if (textView5 != null) {
            textView5.setText(string2);
        }
        FragmentInputOtpBinding binding3 = getBinding();
        if (binding3 != null && (textView4 = binding3.DatabaseTableConfigUtil) != null) {
            textView4.addTextChangedListener(new TextWatcher() { // from class: id.dana.challenge.otp.OtpChallengeFragment$initOtpTitle$$inlined$doOnTextChanged$1
                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    FragmentInputOtpBinding binding4;
                    boolean z2;
                    FragmentInputOtpBinding binding5;
                    TextView textView6;
                    FragmentInputOtpBinding binding6;
                    TextView textView7;
                    TextView textView8;
                    binding4 = OtpChallengeFragment.this.getBinding();
                    int lineCount = (binding4 == null || (textView8 = binding4.DatabaseTableConfigUtil) == null) ? 0 : textView8.getLineCount();
                    z2 = OtpChallengeFragment.this.DatabaseTableConfigUtil;
                    if (z2) {
                        if (lineCount <= 1) {
                            binding6 = OtpChallengeFragment.this.getBinding();
                            if (binding6 != null && (textView7 = binding6.DatabaseTableConfigUtil) != null) {
                                final OtpChallengeFragment otpChallengeFragment2 = OtpChallengeFragment.this;
                                textView7.postDelayed(new Runnable() { // from class: id.dana.challenge.otp.OtpChallengeFragment$initOtpTitle$1$1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        OtpChallengeFragment.this.addBottomSheetHeight(-ViewExtKt.getAuthRequestContext(24.0f));
                                    }
                                }, 200L);
                            }
                            OtpChallengeFragment.this.DatabaseTableConfigUtil = false;
                        }
                    } else if (z2 || lineCount <= 1) {
                    } else {
                        binding5 = OtpChallengeFragment.this.getBinding();
                        if (binding5 != null && (textView6 = binding5.DatabaseTableConfigUtil) != null) {
                            final OtpChallengeFragment otpChallengeFragment3 = OtpChallengeFragment.this;
                            textView6.postDelayed(new Runnable() { // from class: id.dana.challenge.otp.OtpChallengeFragment$initOtpTitle$1$2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    OtpChallengeFragment.this.addBottomSheetHeight(ViewExtKt.getAuthRequestContext(24.0f));
                                }
                            }, 200L);
                        }
                        OtpChallengeFragment.this.DatabaseTableConfigUtil = true;
                    }
                }
            });
        }
        FragmentInputOtpBinding binding4 = getBinding();
        if (binding4 != null && (pinEntryEditText3 = binding4.getErrorConfigVersion) != null) {
            this.lookAheadTest.PlaceComponentResult(pinEntryEditText3, new TextWatcher() { // from class: id.dana.challenge.otp.OtpChallengeFragment$observeCompleteInputAndFirstInputOtp$1
                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    String errorConfigVersion;
                    String str14;
                    String str15;
                    String str16;
                    boolean initRecordTimeStamp;
                    Intrinsics.checkNotNullParameter(p0, "");
                    AbstractOtpContract.Presenter presenter13 = OtpChallengeFragment.this.presenter;
                    AbstractOtpContract.Presenter presenter14 = null;
                    if (presenter13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter13 = null;
                    }
                    int lookAheadTest = presenter13.getLookAheadTest();
                    errorConfigVersion = OtpChallengeFragment.this.getErrorConfigVersion();
                    VerifyMethodAnalyticTracker.getAuthRequestContext(SummaryActivity.CHECKED, String.valueOf(lookAheadTest), errorConfigVersion);
                    if (p0.length() == pinEntryEditText3.getMaxLength()) {
                        OtpChallengeFragment otpChallengeFragment2 = OtpChallengeFragment.this;
                        String obj = p0.toString();
                        str15 = OtpChallengeFragment.this.getCallingPid;
                        str16 = OtpChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                        OtpChallengeFragment.getAuthRequestContext(otpChallengeFragment2, obj, str15, str16);
                        OtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(OtpChallengeFragment.this);
                        initRecordTimeStamp = OtpChallengeFragment.this.initRecordTimeStamp();
                        if (!initRecordTimeStamp) {
                            OtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda6(OtpChallengeFragment.this);
                        }
                    }
                    if (TextUtils.isEmpty(p0)) {
                        return;
                    }
                    AbstractOtpContract.Presenter presenter15 = OtpChallengeFragment.this.presenter;
                    if (presenter15 != null) {
                        presenter14 = presenter15;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    str14 = OtpChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    presenter14.BuiltInFictitiousFunctionClassFactory(str14);
                }
            });
        }
        FragmentInputOtpBinding binding5 = getBinding();
        if (binding5 != null && (pinEntryEditText2 = binding5.getErrorConfigVersion) != null) {
            pinEntryEditText2.setOnBackButtonListener(new PinEntryEditText.IOnBackButtonListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda15
                @Override // id.dana.core.ui.richview.PinEntryEditText.IOnBackButtonListener
                public final boolean PlaceComponentResult() {
                    boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
                    NetworkUserEntityData$$ExternalSyntheticLambda5 = OtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(OtpChallengeFragment.this);
                    return NetworkUserEntityData$$ExternalSyntheticLambda5;
                }
            });
        }
        FragmentInputOtpBinding binding6 = getBinding();
        if (binding6 != null && (pinEntryEditText = binding6.getErrorConfigVersion) != null) {
            pinEntryEditText.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda16
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    boolean PlaceComponentResult;
                    PlaceComponentResult = OtpChallengeFragment.PlaceComponentResult(OtpChallengeFragment.this, i);
                    return PlaceComponentResult;
                }
            });
        }
        FragmentInputOtpBinding binding7 = getBinding();
        if (binding7 != null && (textView3 = binding7.lookAheadTest) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OtpChallengeFragment.moveToNextValue(OtpChallengeFragment.this);
                }
            });
        }
        FragmentInputOtpBinding binding8 = getBinding();
        if (binding8 != null && (textView2 = binding8.NetworkUserEntityData$$ExternalSyntheticLambda2) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OtpChallengeFragment.scheduleImpl(OtpChallengeFragment.this);
                }
            });
        }
        FragmentInputOtpBinding binding9 = getBinding();
        if (binding9 != null && (textView = binding9.NetworkUserEntityData$$ExternalSyntheticLambda8) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OtpChallengeFragment.lookAheadTest(OtpChallengeFragment.this);
                }
            });
        }
        VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(moveToNextValue());
        VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion());
        NetworkUserEntityData$$ExternalSyntheticLambda7();
        ConstraintSet constraintSet = this.moveToNextValue;
        FragmentInputOtpBinding binding10 = getBinding();
        constraintSet.getAuthRequestContext(binding10 != null ? binding10.MyBillsEntityDataFactory : null);
        ConstraintSet constraintSet2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        FragmentInputOtpBinding binding11 = getBinding();
        constraintSet2.getAuthRequestContext(binding11 != null ? binding11.KClassImpl$Data$declaredNonStaticMembers$2 : null);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.PrepareContext;
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "");
        Intrinsics.checkNotNullParameter(requireView, "");
        FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
        FirstDrawListener.Companion.MyBillsEntityDataFactory(requireView, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
        ViewHelper.getAuthRequestContext(requireView(), new Runnable() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                OtpChallengeFragment.getErrorConfigVersion(OtpChallengeFragment.this);
            }
        });
        if (z) {
            MyBillsEntityDataFactory();
        }
        DatabaseTableConfigUtil();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        WindowInsets rootWindowInsets;
        Insets insets;
        if (Build.VERSION.SDK_INT < 30 || (rootWindowInsets = getBaseActivity().getWindow().getDecorView().getRootWindowInsets()) == null || (insets = rootWindowInsets.getInsets(WindowInsets.Type.systemGestures())) == null) {
            return;
        }
        int i = insets.left;
    }

    @Override // id.dana.challenge.OtpHeightListener
    public final void addBottomSheetHeight(int p0) {
        FragmentActivity activity = getActivity();
        OtpHeightListener otpHeightListener = activity instanceof OtpHeightListener ? (OtpHeightListener) activity : null;
        if (otpHeightListener != null) {
            otpHeightListener.addBottomSheetHeight(p0);
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        PinEntryEditText pinEntryEditText;
        super.onResume();
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null && (pinEntryEditText = binding.getErrorConfigVersion) != null) {
            pinEntryEditText.requestFocus();
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            return;
        }
        DatabaseTableConfigUtil();
    }

    private final void DatabaseTableConfigUtil() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.whatsapp.OTP_RETRIEVED");
        intentFilter.addAction(WhatsAppOtpReceiver.ACTION_RECEIVE_OTP);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.NetworkUserEntityData$$ExternalSyntheticLambda4, intentFilter);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
    }

    private final void GetContactSyncConfig() {
        if (getBaseActivity() == null) {
            return;
        }
        SmsRetrieverClient client = SmsRetriever.getClient((Activity) getBaseActivity());
        Intrinsics.checkNotNullExpressionValue(client, "");
        Task<Void> startSmsRetriever = client.startSmsRetriever();
        Intrinsics.checkNotNullExpressionValue(startSmsRetriever, "");
        startSmsRetriever.addOnSuccessListener(new OnSuccessListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Void r2 = (Void) obj;
                OtpChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(OtpChallengeFragment.this);
            }
        });
        startSmsRetriever.addOnFailureListener(new OnFailureListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                OtpChallengeFragment.PlaceComponentResult(OtpChallengeFragment.this, exc);
            }
        });
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        PinEntryEditText pinEntryEditText;
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null) {
            PlaceComponentResult(binding.getErrorConfigVersion);
            PlaceComponentResult(binding.moveToNextValue);
            binding.initRecordTimeStamp.setText(R.string.enter_otp);
            binding.initRecordTimeStamp.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getBaseActivity(), R.color.pick_black));
            binding.getErrorConfigVersion.setText("");
            PrepareContext();
            FragmentInputOtpBinding binding2 = getBinding();
            if (binding2 == null || (pinEntryEditText = binding2.getErrorConfigVersion) == null) {
                return;
            }
            pinEntryEditText.requestFocus();
        }
    }

    private final void getAuthRequestContext(int p0) {
        if (this.MyBillsEntityDataFactory == null) {
            final long millis = TimeUnit.SECONDS.toMillis(p0);
            final long millis2 = TimeUnit.SECONDS.toMillis(1L);
            this.MyBillsEntityDataFactory = new CountDownTimer(millis, millis2) { // from class: id.dana.challenge.otp.OtpChallengeFragment$startTimer$1
                @Override // android.os.CountDownTimer
                public final void onTick(long p02) {
                    int i;
                    int i2;
                    OtpChallengeFragment otpChallengeFragment = OtpChallengeFragment.this;
                    i = otpChallengeFragment.PlaceComponentResult;
                    otpChallengeFragment.PlaceComponentResult = i - 1;
                    OtpChallengeFragment otpChallengeFragment2 = OtpChallengeFragment.this;
                    i2 = otpChallengeFragment2.PlaceComponentResult;
                    OtpChallengeFragment.MyBillsEntityDataFactory(otpChallengeFragment2, i2);
                }

                @Override // android.os.CountDownTimer
                public final void onFinish() {
                    OtpChallengeFragment.FragmentBottomSheetPaymentSettingBinding(OtpChallengeFragment.this);
                }
            };
        }
        CountDownTimer countDownTimer = this.MyBillsEntityDataFactory;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "initRecordTimeStamp")
    public final boolean initRecordTimeStamp() {
        return Intrinsics.areEqual(ChallengeScenario.REGISTRATION, this.getCallingPid);
    }

    @JvmName(name = "moveToNextValue")
    private final String moveToNextValue() {
        if (initRecordTimeStamp()) {
            AbstractOtpContract.Presenter presenter = this.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            OtpState BuiltInFictitiousFunctionClassFactory = presenter.BuiltInFictitiousFunctionClassFactory();
            return Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA1.INSTANCE) ? true : Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA2.INSTANCE) ? true : Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA3.INSTANCE) ? TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_WA_TIME : TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_SMS_TIME;
        }
        return TrackerKey.Event.LOGIN_VERIFICATION_METHOD_SMS_TIME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getErrorConfigVersion")
    public final String getErrorConfigVersion() {
        if (initRecordTimeStamp()) {
            AbstractOtpContract.Presenter presenter = this.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            OtpState BuiltInFictitiousFunctionClassFactory = presenter.BuiltInFictitiousFunctionClassFactory();
            return Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA1.INSTANCE) ? true : Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA2.INSTANCE) ? true : Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA3.INSTANCE) ? TrackerKey.Event.WA_VERIFICATION_DURATION_REGISTRATION : TrackerKey.Event.SMS_VERIFICATION_DURATION_REGISTRATION;
        }
        return TrackerKey.Event.SMS_VERIFICATION_DURATION_LOGIN;
    }

    private final void MyBillsEntityDataFactory(String p0, final String p1) {
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null) {
            TextView textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(8);
            TextView textView2 = binding.lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            textView2.setVisibility(8);
            TextView textView3 = binding.GetContactSyncConfig;
            textView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.azure));
            textView3.setText(p0);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OtpChallengeFragment.PlaceComponentResult(OtpChallengeFragment.this, p1);
                }
            });
            isLayoutRequested();
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3;
        ConstraintSet constraintSet = new ConstraintSet();
        FragmentInputOtpBinding binding = getBinding();
        constraintSet.getAuthRequestContext(binding != null ? binding.MyBillsEntityDataFactory : null);
        FragmentInputOtpBinding binding2 = getBinding();
        constraintSet.BuiltInFictitiousFunctionClassFactory((binding2 == null || (constraintLayout3 = binding2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? 0 : constraintLayout3.getId(), 6, 0, 6);
        FragmentInputOtpBinding binding3 = getBinding();
        constraintSet.BuiltInFictitiousFunctionClassFactory((binding3 == null || (constraintLayout2 = binding3.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? 0 : constraintLayout2.getId(), 7, 0, 7);
        FragmentInputOtpBinding binding4 = getBinding();
        int id2 = (binding4 == null || (constraintLayout = binding4.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? 0 : constraintLayout.getId();
        FragmentInputOtpBinding binding5 = getBinding();
        constraintSet.BuiltInFictitiousFunctionClassFactory(id2, 3, (binding5 == null || (textView3 = binding5.lookAheadTest) == null) ? 0 : textView3.getId(), 4);
        FragmentInputOtpBinding binding6 = getBinding();
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(binding6 != null ? binding6.MyBillsEntityDataFactory : null);
        FragmentInputOtpBinding binding7 = getBinding();
        constraintSet.getAuthRequestContext(binding7 != null ? binding7.KClassImpl$Data$declaredNonStaticMembers$2 : null);
        FragmentInputOtpBinding binding8 = getBinding();
        constraintSet.BuiltInFictitiousFunctionClassFactory((binding8 == null || (textView2 = binding8.newProxyInstance) == null) ? 0 : textView2.getId(), 6, 0, 6);
        FragmentInputOtpBinding binding9 = getBinding();
        constraintSet.BuiltInFictitiousFunctionClassFactory((binding9 == null || (textView = binding9.newProxyInstance) == null) ? 0 : textView.getId(), 7, 0, 7);
        FragmentInputOtpBinding binding10 = getBinding();
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(binding10 != null ? binding10.KClassImpl$Data$declaredNonStaticMembers$2 : null);
    }

    private final void isLayoutRequested() {
        PinEntryEditText pinEntryEditText;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3;
        ConstraintSet constraintSet = new ConstraintSet();
        FragmentInputOtpBinding binding = getBinding();
        constraintSet.getAuthRequestContext(binding != null ? binding.MyBillsEntityDataFactory : null);
        FragmentInputOtpBinding binding2 = getBinding();
        int i = 0;
        constraintSet.BuiltInFictitiousFunctionClassFactory((binding2 == null || (constraintLayout3 = binding2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? 0 : constraintLayout3.getId(), 6, 0, 6);
        FragmentInputOtpBinding binding3 = getBinding();
        constraintSet.BuiltInFictitiousFunctionClassFactory((binding3 == null || (constraintLayout2 = binding3.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? 0 : constraintLayout2.getId(), 7, 0, 7);
        FragmentInputOtpBinding binding4 = getBinding();
        int id2 = (binding4 == null || (constraintLayout = binding4.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? 0 : constraintLayout.getId();
        FragmentInputOtpBinding binding5 = getBinding();
        if (binding5 != null && (pinEntryEditText = binding5.getErrorConfigVersion) != null) {
            i = pinEntryEditText.getId();
        }
        constraintSet.BuiltInFictitiousFunctionClassFactory(id2, 3, i, 4);
        FragmentInputOtpBinding binding6 = getBinding();
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(binding6 != null ? binding6.MyBillsEntityDataFactory : null);
    }

    private final void newProxyInstance() {
        TextView textView;
        FragmentInputOtpBinding binding = getBinding();
        if (!((binding == null || (textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda2) == null || textView.getVisibility() != 8) ? false : true)) {
            NetworkUserEntityData$$ExternalSyntheticLambda8();
            FragmentInputOtpBinding binding2 = getBinding();
            ConstraintLayout constraintLayout = binding2 != null ? binding2.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
                return;
            }
            return;
        }
        isLayoutRequested();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        newProxyInstance();
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null) {
            binding.PlaceComponentResult.setVisibility(0);
            InstrumentInjector.Resources_setImageResource(binding.getAuthRequestContext, R.drawable.ic_loading_bg);
            InstrumentInjector.Resources_setImageResource(binding.BuiltInFictitiousFunctionClassFactory, R.drawable.loading_spinner);
            KClassImpl$Data$declaredNonStaticMembers$2((View) binding.getErrorConfigVersion);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
        loadAnimation.setInterpolator(new LinearInterpolator());
        FragmentInputOtpBinding binding2 = getBinding();
        if (binding2 != null) {
            binding2.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
            binding2.BuiltInFictitiousFunctionClassFactory.startAnimation(loadAnimation);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        newProxyInstance();
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null) {
            binding.PlaceComponentResult.setVisibility(8);
            binding.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        BuiltInFictitiousFunctionClassFactory(null, p0, null, "");
    }

    private final void PlaceComponentResult(String p0, final boolean p1) {
        String string;
        String upperCase;
        if (p1) {
            string = getString(R.string.lbl_dialog_account_temp_freeze);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else {
            string = getString(R.string.lbl_dialog_account_freeze);
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        LoginInfoDialog.Builder builder = new LoginInfoDialog.Builder(getBaseActivity());
        builder.initRecordTimeStamp = string;
        builder.PlaceComponentResult = p0;
        LoginInfoDialog.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = false;
        MyBillsEntityDataFactory.getErrorConfigVersion = R.drawable.rounded_white_8dp;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.ACCOUNT_LOCK;
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        if (!this.scheduleImpl || p1) {
            String string2 = getString(R.string.lbl_dialog_understand);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            upperCase = string2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
        } else {
            upperCase = getString(R.string.lbl_dialog_call_customer_care);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(OtpChallengeFragment.this, p1);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = upperCase;
        MyBillsEntityDataFactory.moveToNextValue = onClickListener;
        LoginInfoDialog loginInfoDialog = new LoginInfoDialog(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory, (byte) 0);
        loginInfoDialog.MyBillsEntityDataFactory();
        this.newProxyInstance = loginInfoDialog;
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(getGetAuthRequestContext());
    }

    private final void PrepareContext() {
        if (this.PlaceComponentResult > 0) {
            FragmentInputOtpBinding binding = getBinding();
            ConstraintLayout constraintLayout = binding != null ? binding.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
        }
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null) {
            binding.getErrorConfigVersion.setVisibility(4);
            binding.scheduleImpl.setVisibility(0);
            binding.DatabaseTableConfigUtil.setVisibility(4);
            binding.moveToNextValue.setVisibility(4);
        }
        ChallengeScenarioListener challengeScenarioListener = this.SubSequence;
        AbstractOtpContract.Presenter presenter = null;
        if (challengeScenarioListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            challengeScenarioListener = null;
        }
        challengeScenarioListener.onNext(null, null);
        if (!initRecordTimeStamp()) {
            StringBuilder sb = new StringBuilder();
            sb.append("from:");
            sb.append(this.getCallingPid);
            DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(LoginTrackingConstants.OtpLogin.SUCCESS_TO_HOME, sb.toString());
            String str = this.getAuthRequestContext;
            if (Intrinsics.areEqual(str, ChallengeEvent.Channel.SMS)) {
                DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.VERIFY_SMS_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
            } else if (Intrinsics.areEqual(str, ChallengeEvent.Channel.WHATSAPP)) {
                DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.VERIFY_WHATSAPP_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
            }
        }
        NetworkUserEntityData$$ExternalSyntheticLambda3();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        String moveToNextValue = moveToNextValue();
        AbstractOtpContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        OtpState BuiltInFictitiousFunctionClassFactory = presenter.BuiltInFictitiousFunctionClassFactory();
        VerifyMethodAnalyticTracker.getAuthRequestContext(requireContext, moveToNextValue, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_SMS_SUCCESS, Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA1.INSTANCE) ? true : Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA2.INSTANCE) ? true : Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA3.INSTANCE) ? TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_WA_SUCCESS : TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_SMS_SUCCESS, null, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        AbstractOtpContract.View.CC.getAuthRequestContext(this, p0);
        if (p0 == null) {
            p0 = "";
        }
        BuiltInFictitiousFunctionClassFactory((String) null, p0);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void PlaceComponentResult(String str, String str2, String str3) {
        AbstractOtpContract.View.CC.BuiltInFictitiousFunctionClassFactory(this, str, str2, str3);
        if (str2 == null) {
            str2 = "";
        }
        BuiltInFictitiousFunctionClassFactory(str, str2);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void MyBillsEntityDataFactory(int i, int i2) {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        NetworkUserEntityData$$ExternalSyntheticLambda6();
        dismissProgress();
        NetworkUserEntityData$$ExternalSyntheticLambda7();
        BuiltInFictitiousFunctionClassFactory();
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null && (constraintLayout2 = binding.MyBillsEntityDataFactory) != null) {
            constraintLayout2.setConstraintSet(this.moveToNextValue);
        }
        FragmentInputOtpBinding binding2 = getBinding();
        if (binding2 != null && (constraintLayout = binding2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            constraintLayout.setConstraintSet(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        FragmentInputOtpBinding binding3 = getBinding();
        ConstraintLayout constraintLayout3 = binding3 != null ? binding3.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(0);
        }
        FragmentInputOtpBinding binding4 = getBinding();
        TextView textView = binding4 != null ? binding4.lookAheadTest : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentInputOtpBinding binding5 = getBinding();
        TextView textView2 = binding5 != null ? binding5.NetworkUserEntityData$$ExternalSyntheticLambda2 : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        isLayoutRequested();
        if (this.initRecordTimeStamp) {
            addBottomSheetHeight(-ViewExtKt.getAuthRequestContext(46.0f));
            this.initRecordTimeStamp = false;
        }
        if (this.isLayoutRequested) {
            FragmentInputOtpBinding binding6 = getBinding();
            if (binding6 != null) {
                binding6.DatabaseTableConfigUtil.setText(getString(R.string.popup_resend_otp_title, this.getSupportButtonTintMode));
                binding6.DatabaseTableConfigUtil.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(binding6.NetworkUserEntityData$$ExternalSyntheticLambda1.getContext(), R.color.f23982131099995));
            }
            this.isLayoutRequested = false;
        }
        GetContactSyncConfig();
        this.PlaceComponentResult = i;
        NetworkUserEntityData$$ExternalSyntheticLambda1();
        FragmentInputOtpBinding binding7 = getBinding();
        if (binding7 != null) {
            binding7.getErrorConfigVersion.setMaxLength(i2);
            binding7.getErrorConfigVersion.setFocusable(true);
            binding7.getErrorConfigVersion.setFocusableInTouchMode(true);
            binding7.getErrorConfigVersion.setEnabled(true);
            binding7.DatabaseTableConfigUtil.setVisibility(0);
            binding7.moveToNextValue.setVisibility(0);
            binding7.GetContactSyncConfig.setVisibility(0);
        }
        getAuthRequestContext(i);
        NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0229, code lost:
    
        if (r17.equals("AE15002058020037") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0241, code lost:
    
        if (r17.equals("AE15002058020031") != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0243, code lost:
    
        r1 = new android.content.Intent();
        r1.putExtra("message", r18);
        getBaseActivity().setResult(0, r1);
        getBaseActivity().finish();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r17.equals("AE15002058020037") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        if (r17.equals("AE15002058020031") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        r1 = new android.content.Intent();
        r1.putExtra("message", r18);
        getBaseActivity().setResult(0, r1);
        getBaseActivity().finish();
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f9  */
    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.challenge.otp.OtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
        String str = p0;
        if (str == null || str.length() == 0) {
            BaseActivity baseActivity = getBaseActivity();
            Context context = getContext();
            baseActivity.showWarningDialog(context != null ? context.getString(R.string.api_limit_error_message) : null);
            return;
        }
        getBaseActivity().showWarningDialog(p0);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null) {
            binding.DatabaseTableConfigUtil.setText(p0);
            binding.DatabaseTableConfigUtil.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(binding.NetworkUserEntityData$$ExternalSyntheticLambda1.getContext(), R.color.f26712131100373));
            PrepareContext();
            FragmentInputOtpBinding binding2 = getBinding();
            if (binding2 != null) {
                PlaceComponentResult(binding2.getErrorConfigVersion);
                if (this.PlaceComponentResult <= 0) {
                    binding2.lookAheadTest.setClickable(true);
                    binding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setClickable(true);
                    binding2.GetContactSyncConfig.setClickable(true);
                    int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(binding2.NetworkUserEntityData$$ExternalSyntheticLambda1.getContext(), R.color.azure);
                    binding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextColor(BuiltInFictitiousFunctionClassFactory);
                    binding2.lookAheadTest.setTextColor(BuiltInFictitiousFunctionClassFactory);
                    binding2.GetContactSyncConfig.setTextColor(BuiltInFictitiousFunctionClassFactory);
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    binding2.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                }
            }
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        String str = p0;
        if (str == null || str.length() == 0) {
            p0 = TrackerKey.DefaultValue.DEFAULT_ERROR_CODE;
        }
        String str2 = p0;
        if (getContext() != null) {
            AbstractOtpContract.Presenter presenter = this.presenter;
            AbstractOtpContract.Presenter presenter2 = null;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            if (!(presenter instanceof OtpLoginPresenter)) {
                AbstractOtpContract.Presenter presenter3 = this.presenter;
                if (presenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter3 = null;
                }
                if (!(presenter3 instanceof OtpRegistrationPresenter)) {
                    return;
                }
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            String moveToNextValue = moveToNextValue();
            AbstractOtpContract.Presenter presenter4 = this.presenter;
            if (presenter4 != null) {
                presenter2 = presenter4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            OtpState BuiltInFictitiousFunctionClassFactory = presenter2.BuiltInFictitiousFunctionClassFactory();
            VerifyMethodAnalyticTracker.getAuthRequestContext(requireContext, moveToNextValue, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_SMS_FAILED, Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA1.INSTANCE) ? true : Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA2.INSTANCE) ? true : Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA3.INSTANCE) ? TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_WA_FAILED : TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_SMS_FAILED, str2, p1);
        }
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void PlaceComponentResult() {
        this.C = true;
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void getAuthRequestContext() {
        Context context = getContext();
        if (context != null) {
            PermissionUtil permissionUtil = PermissionUtil.INSTANCE;
            PermissionUtil.PlaceComponentResult(context);
        }
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void MyBillsEntityDataFactory() {
        PinEntryEditText pinEntryEditText;
        FragmentInputOtpBinding binding = getBinding();
        PinEntryEditText pinEntryEditText2 = binding != null ? binding.getErrorConfigVersion : null;
        if (pinEntryEditText2 != null) {
            pinEntryEditText2.setFocusable(false);
        }
        FragmentInputOtpBinding binding2 = getBinding();
        PinEntryEditText pinEntryEditText3 = binding2 != null ? binding2.getErrorConfigVersion : null;
        if (pinEntryEditText3 != null) {
            pinEntryEditText3.setFocusableInTouchMode(false);
        }
        FragmentInputOtpBinding binding3 = getBinding();
        PinEntryEditText pinEntryEditText4 = binding3 != null ? binding3.getErrorConfigVersion : null;
        if (pinEntryEditText4 != null) {
            pinEntryEditText4.setEnabled(false);
        }
        FragmentInputOtpBinding binding4 = getBinding();
        if (binding4 != null && (pinEntryEditText = binding4.getErrorConfigVersion) != null) {
            pinEntryEditText.postDelayed(new Runnable() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    OtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(OtpChallengeFragment.this);
                }
            }, 200L);
        }
        String string = getString(R.string.too_many_verify_otp_title_dialog);
        Intrinsics.checkNotNullExpressionValue(string, "");
        KClassImpl$Data$declaredNonStaticMembers$2(string);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void getAuthRequestContext(String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        NetworkUserEntityData$$ExternalSyntheticLambda6();
        Lazy<BotProtectionChallenge> lazy = this.botProtectionChallenge;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().getAuthRequestContext(getBaseActivity(), p0, new Function0<Unit>() { // from class: id.dana.challenge.otp.OtpChallengeFragment$onAkamaiChallenged$1
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
                AbstractOtpContract.Presenter presenter = OtpChallengeFragment.this.presenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.PlaceComponentResult(p1, p2, p3);
            }
        });
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        final PinEntryEditText pinEntryEditText;
        FragmentInputOtpBinding binding = getBinding();
        if (binding == null || (pinEntryEditText = binding.getErrorConfigVersion) == null) {
            return;
        }
        pinEntryEditText.post(new Runnable() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                OtpChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(PinEntryEditText.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda5(OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        otpChallengeFragment.getBaseActivity().finish();
        otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaceComponentResult(OtpChallengeFragment otpChallengeFragment, int i) {
        PinEntryEditText pinEntryEditText;
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        if (67 == i && otpChallengeFragment.FragmentBottomSheetPaymentSettingBinding) {
            FragmentInputOtpBinding binding = otpChallengeFragment.getBinding();
            if (binding != null && (pinEntryEditText = binding.getErrorConfigVersion) != null) {
                pinEntryEditText.setText("");
            }
            otpChallengeFragment.FragmentBottomSheetPaymentSettingBinding = false;
        }
        return false;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null) {
            ViewGroup.LayoutParams layoutParams = binding.getAuthRequestContext.getLayoutParams();
            layoutParams.height = ViewExtKt.getAuthRequestContext(40.0f);
            layoutParams.width = ViewExtKt.getAuthRequestContext(40.0f);
            ViewGroup.LayoutParams layoutParams2 = binding.BuiltInFictitiousFunctionClassFactory.getLayoutParams();
            layoutParams2.height = ViewExtKt.getAuthRequestContext(33.0f);
            layoutParams2.width = ViewExtKt.getAuthRequestContext(33.0f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.challenge.otp.OtpChallengeFragment.MyBillsEntityDataFactory(java.lang.String):void");
    }

    private final String lookAheadTest() {
        String str = this.getSupportButtonTintMode;
        if (str == null) {
            str = "";
        }
        String replace = new Regex("^(\\+628)").replace(str, "62-8");
        Uri.Builder appendQueryParameter = Uri.parse("https://m.dana.id/i/dana-info/resolution-center/chatbot").buildUpon().appendQueryParameter(RVParams.LONG_URL_WITH_ENTRY_KEY, "pinIncorrectTemporaryFreezeModal").appendQueryParameter(SemanticAttributes.MessagingDestinationKindValues.TOPIC, "ACCOUNT_AND_SECURITY").appendQueryParameter("subtopic", "ACCOUNT_PIN_RESET").appendQueryParameter("phoneNumber", replace).appendQueryParameter("journeySlug", "incorrectPinTemporaryFreeze").appendQueryParameter("nonLogin", SummaryActivity.CHECKED);
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append('_');
        sb.append("incorrectPinTemporaryFreeze");
        sb.append('_');
        DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
        DeviceInformationProvider deviceInformationProvider2 = null;
        if (deviceInformationProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            deviceInformationProvider = null;
        }
        sb.append(deviceInformationProvider.getDeviceUtdId());
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("ymAuthenticationToken", sb.toString());
        DeviceInformationProvider deviceInformationProvider3 = this.deviceInformationProvider;
        if (deviceInformationProvider3 != null) {
            deviceInformationProvider2 = deviceInformationProvider3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        String obj = appendQueryParameter2.appendQueryParameter("utdid", deviceInformationProvider2.getDeviceUtdId()).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    private final void scheduleImpl() {
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null) {
            PlaceComponentResult(binding.DatabaseTableConfigUtil);
            PlaceComponentResult(binding.getErrorConfigVersion);
            PlaceComponentResult(binding.KClassImpl$Data$declaredNonStaticMembers$2);
            TextView textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            if (textView.getVisibility() == 0) {
                PlaceComponentResult(binding.lookAheadTest);
                PlaceComponentResult(binding.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
            ViewGroup.LayoutParams layoutParams = binding.getAuthRequestContext.getLayoutParams();
            layoutParams.height = ViewExtKt.getAuthRequestContext(64.0f);
            layoutParams.width = ViewExtKt.getAuthRequestContext(64.0f);
            ViewGroup.LayoutParams layoutParams2 = binding.BuiltInFictitiousFunctionClassFactory.getLayoutParams();
            layoutParams2.height = ViewExtKt.getAuthRequestContext(50.0f);
            layoutParams2.width = ViewExtKt.getAuthRequestContext(50.0f);
        }
    }

    private static boolean getAuthRequestContext(String p0) {
        int hashCode;
        return p0 != null && ((hashCode = p0.hashCode()) == 103149417 ? p0.equals("login") : !(hashCode == 1319662811 ? !p0.equals(ChallengeScenario.TRUST_RISK_LOGIN_V2) : !(hashCode == 1573803584 && p0.equals(ChallengeScenario.TRUST_RISK_LOGIN))));
    }

    private static void PlaceComponentResult(View p0) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha = (p0 == null || (animate = p0.animate()) == null) ? null : animate.alpha(1.0f);
        if (alpha != null) {
            alpha.setDuration(0L);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(View p0) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha = (p0 == null || (animate = p0.animate()) == null) ? null : animate.alpha(0.0f);
        if (alpha != null) {
            alpha.setDuration(0L);
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        String str = this.getAuthRequestContext;
        if (Intrinsics.areEqual(str, ChallengeEvent.Channel.SMS)) {
            DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.RESEND_SMS_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
        } else if (Intrinsics.areEqual(str, ChallengeEvent.Channel.WHATSAPP)) {
            DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.RESEND_WHATSAPP_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        if (this.isLayoutRequested) {
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (Intrinsics.areEqual(str, OtpChannel.SMS)) {
                DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.RESEND_SMS_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
                return;
            } else if (Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
                DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.RESEND_WHATSAPP_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
                return;
            } else {
                return;
            }
        }
        String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (Intrinsics.areEqual(str2, OtpChannel.SMS)) {
            DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.SEND_SMS_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
        } else if (Intrinsics.areEqual(str2, OtpChannel.WHATSAPP)) {
            DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.SEND_WA_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/challenge/otp/OtpChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/challenge/otp/OtpChallengeFragment;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/os/Bundle;)Lid/dana/challenge/otp/OtpChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static OtpChallengeFragment BuiltInFictitiousFunctionClassFactory(Bundle p0) {
            OtpChallengeFragment otpChallengeFragment = new OtpChallengeFragment();
            otpChallengeFragment.setArguments(p0);
            return otpChallengeFragment;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(final OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) otpChallengeFragment.BuiltInFictitiousFunctionClassFactory.getValue();
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        String str = otpChallengeFragment.getErrorConfigVersion;
        String str2 = DanaUrl.DANA_OTP_ARTICLE;
        if (str != null) {
            String str3 = str;
            if (str3.length() == 0) {
                str = DanaUrl.DANA_OTP_ARTICLE;
            } else if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "/i/dana-info/resolution-center/chatbot", false, 2, (Object) null)) {
                str = otpChallengeFragment.lookAheadTest();
            }
            if (str != null) {
                str2 = str;
            }
        }
        DanaH5.startContainerFullUrlWithoutTimeout(str2, new DanaH5Listener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$onHelpButtonClicked$1$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                OtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(OtpChallengeFragment.this).PlaceComponentResult();
                OtpChallengeFragment.this.getBaseActivity().setResult(0, new Intent().putExtra(ChallengeControl.Key.CANCEL_REASON, "close"));
                OtpChallengeFragment.this.getBaseActivity().finish();
                OtpChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3();
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        otpChallengeFragment.isLayoutRequested();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final OtpChallengeFragment otpChallengeFragment) {
        PinEntryEditText pinEntryEditText;
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        FragmentActivity activity = otpChallengeFragment.getActivity();
        if (activity != null) {
            KeyboardHelper.getAuthRequestContext(activity);
        }
        FragmentInputOtpBinding binding = otpChallengeFragment.getBinding();
        if (binding == null || (pinEntryEditText = binding.getErrorConfigVersion) == null) {
            return;
        }
        pinEntryEditText.postDelayed(new Runnable() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                OtpChallengeFragment.PlaceComponentResult(OtpChallengeFragment.this);
            }
        }, 200L);
    }

    public static /* synthetic */ void PlaceComponentResult(OtpChallengeFragment otpChallengeFragment, Exception exc) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        StringBuilder sb = new StringBuilder();
        sb.append(Intrinsics.areEqual(ChallengeScenario.REGISTRATION, otpChallengeFragment.getCallingPid) ? DanaLogConstants.Prefix.OTP_REGISTER_PREFIX : DanaLogConstants.Prefix.OTPLOGIN_PREFIX);
        sb.append(" :onError Retrieve Listener");
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.OTP_CHALLENGE_TAG, sb.toString(), exc);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        AbstractOtpContract.Presenter presenter = otpChallengeFragment.presenter;
        AbstractOtpContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        VerifyMethodAnalyticTracker.getAuthRequestContext(SummaryActivity.CHECKED, String.valueOf(presenter.getLookAheadTest()), otpChallengeFragment.getErrorConfigVersion());
        StringBuilder sb = new StringBuilder();
        sb.append(Intrinsics.areEqual(ChallengeScenario.REGISTRATION, otpChallengeFragment.getCallingPid) ? DanaLogConstants.Prefix.OTP_REGISTER_PREFIX : DanaLogConstants.Prefix.OTPLOGIN_PREFIX);
        sb.append(" :onSuccess Retrieve Listener");
        DanaLog.getAuthRequestContext(DanaLogConstants.TAG.OTP_CHALLENGE_TAG, sb.toString());
        AbstractOtpContract.Presenter presenter3 = otpChallengeFragment.presenter;
        if (presenter3 != null) {
            presenter2 = presenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void lookAheadTest(final OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        DanaH5.startContainerFullUrl("https://m.dana.id/m/portal/changephoneno", new DanaH5Listener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$openChangePhoneNumberPage$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                ChangePhoneNumberH5EventContract.Presenter presenter = OtpChallengeFragment.this.changePhoneNumberH5EventPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.MyBillsEntityDataFactory();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                ChangePhoneNumberH5EventContract.Presenter presenter = OtpChallengeFragment.this.changePhoneNumberH5EventPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(OtpChallengeFragment otpChallengeFragment, String str) {
        TextView textView;
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        Intrinsics.checkNotNullParameter(str, "");
        otpChallengeFragment.showProgress();
        otpChallengeFragment.MyBillsEntityDataFactory(str);
        FragmentInputOtpBinding binding = otpChallengeFragment.getBinding();
        if (binding != null && (textView = binding.GetContactSyncConfig) != null) {
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(otpChallengeFragment.requireContext(), R.color.f24032131100003));
        }
        FragmentInputOtpBinding binding2 = otpChallengeFragment.getBinding();
        TextView textView2 = binding2 != null ? binding2.GetContactSyncConfig : null;
        if (textView2 != null) {
            textView2.setClickable(false);
        }
    }

    public static /* synthetic */ void moveToNextValue(OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        otpChallengeFragment.showProgress();
        otpChallengeFragment.MyBillsEntityDataFactory(ChallengeEvent.Channel.SMS);
        FragmentInputOtpBinding binding = otpChallengeFragment.getBinding();
        if (binding != null) {
            binding.lookAheadTest.setClickable(false);
            binding.NetworkUserEntityData$$ExternalSyntheticLambda2.setClickable(false);
            int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(otpChallengeFragment.requireContext(), R.color.f24032131100003);
            binding.lookAheadTest.setTextColor(BuiltInFictitiousFunctionClassFactory);
            binding.GetContactSyncConfig.setClickable(false);
            binding.GetContactSyncConfig.setTextColor(BuiltInFictitiousFunctionClassFactory);
        }
        VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(otpChallengeFragment.getErrorConfigVersion());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PinEntryEditText pinEntryEditText) {
        Intrinsics.checkNotNullParameter(pinEntryEditText, "");
        pinEntryEditText.requestFocus();
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(pinEntryEditText);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final OtpChallengeFragment otpChallengeFragment, boolean z) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        LoginInfoDialog loginInfoDialog = otpChallengeFragment.newProxyInstance;
        if (loginInfoDialog != null) {
            loginInfoDialog.getAuthRequestContext();
        }
        if (!otpChallengeFragment.scheduleImpl || z) {
            otpChallengeFragment.getBaseActivity().setResult(0, new Intent().putExtra(ChallengeControl.Key.CANCEL_REASON, "close"));
            otpChallengeFragment.getBaseActivity().finish();
            return;
        }
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) otpChallengeFragment.BuiltInFictitiousFunctionClassFactory.getValue();
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        DanaH5.startContainerFullUrlWithoutTimeout(otpChallengeFragment.lookAheadTest(), new DanaH5Listener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$setAccountFreezeDialogButtonCallBack$1$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                OtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(OtpChallengeFragment.this).PlaceComponentResult();
                OtpChallengeFragment.this.getBaseActivity().setResult(0, new Intent().putExtra(ChallengeControl.Key.CANCEL_REASON, "close"));
                OtpChallengeFragment.this.getBaseActivity().finish();
            }
        });
    }

    public static /* synthetic */ void getErrorConfigVersion(OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        if (otpChallengeFragment.A != null) {
            if (otpChallengeFragment.B == null) {
                otpChallengeFragment.B = Long.valueOf(System.currentTimeMillis());
            }
            String str = otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (Intrinsics.areEqual(str, OtpChannel.SMS)) {
                DanaPerformanceDurationTracker danaPerformanceDurationTracker = DanaPerformanceDurationTracker.INSTANCE;
                Long l = otpChallengeFragment.A;
                Intrinsics.checkNotNull(l);
                danaPerformanceDurationTracker.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.RENDER_SMS_OTP_DIALOG_SCREEN, l.longValue());
                DanaPerformanceDurationTracker danaPerformanceDurationTracker2 = DanaPerformanceDurationTracker.INSTANCE;
                Long l2 = otpChallengeFragment.B;
                Intrinsics.checkNotNull(l2);
                danaPerformanceDurationTracker2.PlaceComponentResult(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.RENDER_SMS_OTP_DIALOG_SCREEN, l2.longValue());
            } else if (Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
                DanaPerformanceDurationTracker danaPerformanceDurationTracker3 = DanaPerformanceDurationTracker.INSTANCE;
                Long l3 = otpChallengeFragment.A;
                Intrinsics.checkNotNull(l3);
                danaPerformanceDurationTracker3.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.RENDER_WA_OTP_DIALOG_SCREEN, l3.longValue());
                DanaPerformanceDurationTracker danaPerformanceDurationTracker4 = DanaPerformanceDurationTracker.INSTANCE;
                Long l4 = otpChallengeFragment.B;
                Intrinsics.checkNotNull(l4);
                danaPerformanceDurationTracker4.PlaceComponentResult(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.RENDER_WA_OTP_DIALOG_SCREEN, l4.longValue());
            }
        }
    }

    public static /* synthetic */ void scheduleImpl(OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        otpChallengeFragment.showProgress();
        otpChallengeFragment.MyBillsEntityDataFactory(ChallengeEvent.Channel.WHATSAPP);
        FragmentInputOtpBinding binding = otpChallengeFragment.getBinding();
        if (binding != null) {
            binding.initRecordTimeStamp.setText(R.string.enter_otp);
            binding.initRecordTimeStamp.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(otpChallengeFragment.getBaseActivity(), R.color.f24002131099997));
            int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(otpChallengeFragment.requireContext(), R.color.f24032131100003);
            binding.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextColor(BuiltInFictitiousFunctionClassFactory);
            binding.lookAheadTest.setClickable(false);
            binding.NetworkUserEntityData$$ExternalSyntheticLambda2.setClickable(false);
            binding.GetContactSyncConfig.setClickable(false);
            binding.GetContactSyncConfig.setTextColor(BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        FragmentActivity activity = otpChallengeFragment.getActivity();
        OtpHeightListener otpHeightListener = activity instanceof OtpHeightListener ? (OtpHeightListener) activity : null;
        if (otpHeightListener != null) {
            otpHeightListener.addBottomSheetHeight(ViewExtKt.getAuthRequestContext(24.0f));
        }
    }

    public static /* synthetic */ void PlaceComponentResult(OtpChallengeFragment otpChallengeFragment, boolean z) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        if (z) {
            ChallengeScenarioListener challengeScenarioListener = otpChallengeFragment.SubSequence;
            if (challengeScenarioListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                challengeScenarioListener = null;
            }
            challengeScenarioListener.closeChallengeSession();
        }
    }

    public static /* synthetic */ void GetContactSyncConfig(OtpChallengeFragment otpChallengeFragment) {
        Intrinsics.checkNotNullParameter(otpChallengeFragment, "");
        String str = otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (Intrinsics.areEqual(str, OtpChannel.SMS)) {
            DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.SEND_SMS_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
        } else if (Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
            DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.SEND_WA_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
        }
    }

    public static final /* synthetic */ DanaLoadingDialog NetworkUserEntityData$$ExternalSyntheticLambda2(OtpChallengeFragment otpChallengeFragment) {
        return (DanaLoadingDialog) otpChallengeFragment.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ void FragmentBottomSheetPaymentSettingBinding(OtpChallengeFragment otpChallengeFragment) {
        AbstractOtpContract.Presenter presenter = otpChallengeFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        VerifyMethodAnalyticTracker.getAuthRequestContext("false", String.valueOf(presenter.getLookAheadTest()), otpChallengeFragment.getErrorConfigVersion());
        AbstractOtpContract.Presenter presenter2 = otpChallengeFragment.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        OtpState BuiltInFictitiousFunctionClassFactory = presenter2.BuiltInFictitiousFunctionClassFactory();
        if (Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA1.INSTANCE)) {
            String string = otpChallengeFragment.getString(R.string.resend_text);
            Intrinsics.checkNotNullExpressionValue(string, "");
            otpChallengeFragment.MyBillsEntityDataFactory(StringsKt.dropLast(string, 5), ChallengeEvent.Channel.WHATSAPP);
        } else if (!Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA2.INSTANCE)) {
            if (Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.WA3.INSTANCE)) {
                String string2 = otpChallengeFragment.getString(R.string.resend_otp_sms_timer);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                otpChallengeFragment.MyBillsEntityDataFactory(StringsKt.dropLast(string2, 5), ChallengeEvent.Channel.SMS);
            } else if (Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory, OtpState.SMS1.INSTANCE)) {
                String string3 = otpChallengeFragment.getString(R.string.resend_text);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                otpChallengeFragment.MyBillsEntityDataFactory(StringsKt.dropLast(string3, 5), ChallengeEvent.Channel.SMS);
            }
        } else {
            FragmentInputOtpBinding binding = otpChallengeFragment.getBinding();
            TextView textView = binding != null ? binding.GetContactSyncConfig : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
            FragmentInputOtpBinding binding2 = otpChallengeFragment.getBinding();
            View view = binding2 != null ? binding2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
            if (view != null) {
                view.setVisibility(8);
            }
            FragmentInputOtpBinding binding3 = otpChallengeFragment.getBinding();
            TextView textView2 = binding3 != null ? binding3.NetworkUserEntityData$$ExternalSyntheticLambda2 : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            FragmentInputOtpBinding binding4 = otpChallengeFragment.getBinding();
            TextView textView3 = binding4 != null ? binding4.lookAheadTest : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            FragmentInputOtpBinding binding5 = otpChallengeFragment.getBinding();
            View view2 = binding5 != null ? binding5.NetworkUserEntityData$$ExternalSyntheticLambda7 : null;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda8();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OtpChallengeFragment otpChallengeFragment, int i) {
        AbstractOtpContract.Presenter presenter = otpChallengeFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        String string = Intrinsics.areEqual(presenter.BuiltInFictitiousFunctionClassFactory(), OtpState.WA3.INSTANCE) ? otpChallengeFragment.getString(R.string.resend_otp_sms_timer) : otpChallengeFragment.getString(R.string.resend_text);
        Intrinsics.checkNotNullExpressionValue(string, "");
        FragmentInputOtpBinding binding = otpChallengeFragment.getBinding();
        TextView textView = binding != null ? binding.GetContactSyncConfig : null;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(OtpChallengeFragment otpChallengeFragment, String str, String str2, String str3) {
        AbstractOtpContract.Presenter presenter;
        AbstractOtpContract.Presenter presenter2;
        if (!Intrinsics.areEqual(ChallengeScenario.REGISTRATION, otpChallengeFragment.getCallingPid) && !Intrinsics.areEqual(ChallengeScenario.TRUST_RISK_LOGIN_V2, otpChallengeFragment.getCallingPid)) {
            AbstractOtpContract.Presenter presenter3 = otpChallengeFragment.presenter;
            if (presenter3 != null) {
                presenter2 = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter2 = null;
            }
            presenter2.BuiltInFictitiousFunctionClassFactory(str, str2, otpChallengeFragment.whenAvailable, str3, otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3, Intrinsics.areEqual(otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5, OtpChannel.WHATSAPP) ? "WHATSAPP_OTP" : "OTP_SMS");
        } else {
            AbstractOtpContract.Presenter presenter4 = otpChallengeFragment.presenter;
            if (presenter4 != null) {
                presenter = presenter4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            String str4 = otpChallengeFragment.whenAvailable;
            String str5 = str4 == null ? "" : str4;
            String str6 = otpChallengeFragment.getSupportButtonTintMode;
            presenter.KClassImpl$Data$declaredNonStaticMembers$2(str, str5, str6 == null ? "" : str6, otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3, Intrinsics.areEqual(otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5, OtpChannel.WHATSAPP) ? "WHATSAPP_OTP" : "OTP_SMS");
        }
        FragmentInputOtpBinding binding = otpChallengeFragment.getBinding();
        if (binding != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(binding.DatabaseTableConfigUtil);
            KClassImpl$Data$declaredNonStaticMembers$2(binding.moveToNextValue);
            KClassImpl$Data$declaredNonStaticMembers$2((View) binding.getErrorConfigVersion);
            KClassImpl$Data$declaredNonStaticMembers$2(binding.KClassImpl$Data$declaredNonStaticMembers$2);
            TextView textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            if (textView.getVisibility() == 0) {
                KClassImpl$Data$declaredNonStaticMembers$2(binding.lookAheadTest);
                KClassImpl$Data$declaredNonStaticMembers$2(binding.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda6(OtpChallengeFragment otpChallengeFragment) {
        String str = otpChallengeFragment.getAuthRequestContext;
        if (Intrinsics.areEqual(str, ChallengeEvent.Channel.SMS)) {
            DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.VERIFY_SMS_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
        } else if (Intrinsics.areEqual(str, ChallengeEvent.Channel.WHATSAPP)) {
            DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.VERIFY_WHATSAPP_OTP_LOGIC_IN_MILLIS, System.currentTimeMillis());
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda3(OtpChallengeFragment otpChallengeFragment) {
        String str = otpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (Intrinsics.areEqual(str, OtpChannel.SMS)) {
            if (otpChallengeFragment.initRecordTimeStamp()) {
                OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                Intrinsics.checkNotNullParameter("user_interaction_login_sms_otp_input", "");
                OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "user_interaction_login_sms_otp_input");
            } else if (getAuthRequestContext(otpChallengeFragment.getCallingPid)) {
                OnboardingFirebaseTracker onboardingFirebaseTracker2 = OnboardingFirebaseTracker.INSTANCE;
                Intrinsics.checkNotNullParameter("user_interaction_registration_sms_otp_input", "");
                OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "user_interaction_registration_sms_otp_input");
                DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.Property.TYPING_SMS_OTP_IN_MILLIS, System.currentTimeMillis());
            }
        } else if (Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
            if (otpChallengeFragment.initRecordTimeStamp()) {
                OnboardingFirebaseTracker onboardingFirebaseTracker3 = OnboardingFirebaseTracker.INSTANCE;
                Intrinsics.checkNotNullParameter("user_interaction_registration_wa_otp_input", "");
                OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "user_interaction_registration_wa_otp_input");
            } else if (getAuthRequestContext(otpChallengeFragment.getCallingPid)) {
                DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.Property.TYPING_WA_OTP_IN_MILLIS, System.currentTimeMillis());
            }
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        TextView textView;
        FragmentInputOtpBinding binding = getBinding();
        if (binding != null && (textView = binding.newProxyInstance) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.otp.OtpChallengeFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OtpChallengeFragment.MyBillsEntityDataFactory(OtpChallengeFragment.this);
                }
            });
        }
        FragmentInputOtpBinding binding2 = getBinding();
        TextView textView2 = binding2 != null ? binding2.newProxyInstance : null;
        if (textView2 != null) {
            textView2.setVisibility(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : 8);
        }
        if (Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, OtpChannel.WHATSAPP)) {
            FragmentInputOtpBinding binding3 = getBinding();
            if (binding3 == null || (appCompatImageView2 = binding3.moveToNextValue) == null) {
                return;
            }
            if (appCompatImageView2 instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView2, R.drawable.ic_otp_wa);
            } else {
                appCompatImageView2.setImageResource(R.drawable.ic_otp_wa);
            }
            appCompatImageView2.setContentDescription(getString(R.string.txt_wa_otp));
            return;
        }
        FragmentInputOtpBinding binding4 = getBinding();
        if (binding4 == null || (appCompatImageView = binding4.moveToNextValue) == null) {
            return;
        }
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_otp_sms);
        } else {
            appCompatImageView.setImageResource(R.drawable.ic_otp_sms);
        }
        appCompatImageView.setContentDescription(getString(R.string.txt_sms_otp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        AbstractOtpContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        if (presenter instanceof OtpRegistrationPresenter) {
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (!Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
                if (Intrinsics.areEqual(str, OtpChannel.SMS)) {
                    OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
                    Intrinsics.checkNotNullParameter("regis_verify_sms_flow_loadtime", "");
                    OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "regis_verify_sms_flow_loadtime");
                    return;
                }
                return;
            }
            OnboardingFirebaseTracker onboardingFirebaseTracker2 = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("regis_verify_whatsapp_flow_loadtime", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "regis_verify_whatsapp_flow_loadtime");
        } else if ((presenter instanceof OtpLoginPresenter) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, OtpChannel.SMS)) {
            OnboardingFirebaseTracker onboardingFirebaseTracker3 = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("login_verify_sms_flow_loadtime", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "login_verify_sms_flow_loadtime");
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        CountDownTimer countDownTimer = this.MyBillsEntityDataFactory;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.unregisterReceiver(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        } catch (Exception e) {
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            Exception exc = e;
            Intrinsics.checkNotNullParameter(exc, "");
            authRequestContext.getAuthRequestContext.recordException(exc);
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.View
    public final void PlaceComponentResult(String p0) {
        PinEntryEditText pinEntryEditText;
        AbstractOtpContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.lookAheadTest();
        FragmentInputOtpBinding binding = getBinding();
        if (binding == null || (pinEntryEditText = binding.getErrorConfigVersion) == null) {
            return;
        }
        pinEntryEditText.setText(p0);
    }
}
