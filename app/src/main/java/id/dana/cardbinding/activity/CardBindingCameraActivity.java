package id.dana.cardbinding.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.media.Image;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.view.ComponentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import androidx.view.viewmodel.CreationExtras;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameProcessor;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.cardbinding.activity.OnboardingCardBindingActivity;
import id.dana.cardbinding.di.component.DaggerCardBindingComponent;
import id.dana.cardbinding.di.module.ViewModelFactory;
import id.dana.cardbinding.model.BankCardInfoModel;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cardbinding.model.SupportedCardsConfigModel;
import id.dana.cardbinding.tracker.AddCardExecutionProperties;
import id.dana.cardbinding.tracker.AddCardOpenProperties;
import id.dana.cardbinding.tracker.AddCardResultProperties;
import id.dana.cardbinding.tracker.CardBindingAnalyticTracker;
import id.dana.cardbinding.tracker.CardBindingTrackerUtil;
import id.dana.cardbinding.tracker.ThirdPartyRiskChallengeProperties;
import id.dana.cardbinding.view.CardBindingDialogExtKt;
import id.dana.cardbinding.view.SupportedCardsView;
import id.dana.cardbinding.viewmodel.CardBindingViewModel;
import id.dana.cardbinding.viewmodel.OtpCardBindingViewModel;
import id.dana.cashier.CashierRisk3dsActivity;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierAgreementModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenario;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.data.usereducation.repository.source.UserEducationScenarioKt;
import id.dana.databinding.ActivityCardBindingCameraBinding;
import id.dana.databinding.LayoutCardBindingCameraOverlayBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.extension.view.ActivityExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.camera.DanaCameraView;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.Showcase;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.splitbill.view.SplitBillIntroductionActivity;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.SizeUtil;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001xB\u0007¢\u0006\u0004\bw\u0010\u0010J)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u0010J\u0019\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0014¢\u0006\u0004\b#\u0010\u0010J\u000f\u0010$\u001a\u00020\fH\u0014¢\u0006\u0004\b$\u0010\u0010J\u0017\u0010%\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\u000eJ\r\u0010&\u001a\u00020\f¢\u0006\u0004\b&\u0010\u0010J\u001b\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b\u000f\u0010(J\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\u0010J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0010J'\u0010\u0016\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0)H\u0002¢\u0006\u0004\b\u0016\u0010*J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\r\u0010,J#\u0010%\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010+2\b\u0010\u0006\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b%\u0010-J\r\u0010.\u001a\u00020\f¢\u0006\u0004\b.\u0010\u0010J#\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020+2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b\u000f\u0010-J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020+H\u0002¢\u0006\u0004\b\u0016\u0010/R\u0018\u0010\u000f\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00101R\u0018\u0010%\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u000204038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020>8GX\u0087\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0018\u0010\t\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010M\u001a\u0004\u0018\u00010F8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0013\u0010\r\u001a\u00020NX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bO\u0010@R\u0016\u00105\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bR\u0010QR\u0016\u0010?\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bT\u0010QR\u0016\u00102\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bU\u0010QR\u0014\u0010Y\u001a\u00020V8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010G\u001a\u00020V8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bZ\u0010XR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001a0[8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010P\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001b\u0010d\u001a\u00020`8GX\u0087\u0084\u0002¢\u0006\f\n\u0004\ba\u0010@\u001a\u0004\bb\u0010cR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001a0[8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\be\u0010]R\u0013\u0010D\u001a\u00020fX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bg\u0010@R\u0018\u0010T\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bh\u0010ER\u0018\u0010Z\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010\\\u001a\u00020l8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bm\u0010nR\u0013\u0010W\u001a\u00020fX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bo\u0010@R\"\u0010q\u001a\u00020p8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010v"}, d2 = {"Lid/dana/cardbinding/activity/CardBindingCameraActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityCardBindingCameraBinding;", "Landroid/view/View;", "p0", "", "p1", "p2", "Lid/dana/showcase/target/Target;", "getAuthRequestContext", "(Landroid/view/View;II)Lid/dana/showcase/target/Target;", "Lid/dana/cashier/model/CashierPayModel;", "", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/CashierPayModel;)V", "PlaceComponentResult", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityCardBindingCameraBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "onResume", "BuiltInFictitiousFunctionClassFactory", "sendBankOtp", "Lid/dana/cardbinding/model/BankCardInfoModel;", "(Lid/dana/cardbinding/model/BankCardInfoModel;)V", "Lkotlin/Function0;", "(Lid/dana/showcase/target/Target;Lkotlin/jvm/functions/Function0;)V", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "trackAddCardExecution", "(Ljava/lang/String;)V", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "scheduleImpl", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getErrorConfigVersion", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;", "cardBindingAnalyticTracker", "Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;", "getCardBindingAnalyticTracker", "()Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;", "setCardBindingAnalyticTracker", "(Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;)V", "Lid/dana/cardbinding/viewmodel/CardBindingViewModel;", "lookAheadTest", "Lkotlin/Lazy;", "getCardBindingVm", "()Lid/dana/cardbinding/viewmodel/CardBindingViewModel;", "cardBindingVm", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/String;", "Lid/dana/cashier/model/CashierCheckoutModel;", "GetContactSyncConfig", "Lid/dana/cashier/model/CashierCheckoutModel;", "getCashierMainResult", "()Lid/dana/cashier/model/CashierCheckoutModel;", "setCashierMainResult", "(Lid/dana/cashier/model/CashierCheckoutModel;)V", "cashierMainResult", "Lid/dana/dialog/DanaLoadingDialog;", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "initRecordTimeStamp", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "Lkotlinx/coroutines/Job;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lkotlinx/coroutines/Job;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "newProxyInstance", "Landroidx/activity/result/ActivityResultLauncher;", "isLayoutRequested", "Landroidx/activity/result/ActivityResultLauncher;", "FragmentBottomSheetPaymentSettingBinding", "I", "Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "getOtpVm", "()Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;", "otpVm", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lcom/afollestad/materialdialogs/MaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/showcase/Showcase;", "readMicros", "Lid/dana/showcase/Showcase;", "Lid/dana/cardbinding/model/SupportedCardsConfigModel;", "whenAvailable", "Lid/dana/cardbinding/model/SupportedCardsConfigModel;", "getCallingPid", "Lid/dana/cardbinding/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/cardbinding/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/cardbinding/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/cardbinding/di/module/ViewModelFactory;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CardBindingCameraActivity extends BaseViewBindingActivity<ActivityCardBindingCameraBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long getSupportButtonTintMode;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private CashierCheckoutModel cashierMainResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy otpVm;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Job NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean scheduleImpl;
    @Inject
    public CardBindingAnalyticTracker cardBindingAnalyticTracker;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private AnimatorSet PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private BottomSheetBehavior<ConstraintLayout> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy cardBindingVm;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Job GetContactSyncConfig;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private Showcase newProxyInstance;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private AnimatorSet BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ViewModelFactory viewModelFactory;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private SupportedCardsConfigModel isLayoutRequested;
    public static final byte[] $$a = {56, 110, 47, 101, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 8;
    public static final byte[] PlaceComponentResult = {93, 18, 67, -65, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 34;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(CardBindingCameraActivity.this);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda1 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$requestCameraAccessDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MaterialDialog invoke() {
            final CardBindingCameraActivity cardBindingCameraActivity = CardBindingCameraActivity.this;
            CustomDialog.Builder builder = new CustomDialog.Builder(cardBindingCameraActivity);
            builder.SubSequence = cardBindingCameraActivity.getString(R.string.card_binding_req_camera_title);
            builder.GetContactSyncConfig = cardBindingCameraActivity.getString(R.string.card_binding_req_camera_content);
            builder.DatabaseTableConfigUtil = R.drawable.ic_camera_access;
            CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
            String string = cardBindingCameraActivity.getString(R.string.card_binding_req_camera_positive_button);
            Function1<View, Unit> function1 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$requestCameraAccessDialog$2$1$1
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
                    ActivityCardBindingCameraBinding binding;
                    Intrinsics.checkNotNullParameter(view, "");
                    binding = CardBindingCameraActivity.this.getBinding();
                    binding.getCallingPid.checkPermission();
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function1);
            PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
            PlaceComponentResult2.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
            String string2 = cardBindingCameraActivity.getString(R.string.card_binding_req_camera_negative_button);
            Function1<View, Unit> function12 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$requestCameraAccessDialog$2$1$2
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
                    CardBindingCameraActivity.this.PlaceComponentResult(null);
                    CardBindingCameraActivity.this.MyBillsEntityDataFactory();
                }
            };
            Intrinsics.checkNotNullParameter(function12, "");
            CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$02 = new CustomDialog$sam$android_view_View_OnClickListener$0(function12);
            PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda7 = string2;
            PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda8 = customDialog$sam$android_view_View_OnClickListener$02;
            return PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory();
        }
    });

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$supportedCardsDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MaterialDialog invoke() {
            final CardBindingCameraActivity cardBindingCameraActivity = CardBindingCameraActivity.this;
            CustomDialog.Builder builder = new CustomDialog.Builder(cardBindingCameraActivity);
            builder.getCallingPid = R.layout.view_container_supported_cards;
            Function1<DialogInterface, Unit> function1 = new Function1<DialogInterface, Unit>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$supportedCardsDialog$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
                    invoke2(dialogInterface);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DialogInterface dialogInterface) {
                    AnimatorSet animatorSet;
                    Intrinsics.checkNotNullParameter(dialogInterface, "");
                    CardBindingCameraActivity.access$resumeCamera(CardBindingCameraActivity.this);
                    animatorSet = CardBindingCameraActivity.this.PlaceComponentResult;
                    if (animatorSet != null) {
                        animatorSet.resume();
                    }
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            builder.getErrorConfigVersion = new CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0(function1);
            return builder.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
        }
    });

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r5, short r6, byte r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = id.dana.cardbinding.activity.CardBindingCameraActivity.PlaceComponentResult
            int r6 = 23 - r6
            int r5 = 56 - r5
            int r7 = 106 - r7
            byte[] r1 = new byte[r6]
            r2 = -1
            int r6 = r6 + r2
            if (r0 != 0) goto L15
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r6
            r6 = r5
            goto L32
        L15:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L19:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r1[r2] = r3
            if (r2 != r7) goto L29
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L29:
            r3 = r0[r6]
            r4 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r4
        L32:
            int r5 = r5 + r7
            int r5 = r5 + (-4)
            int r6 = r6 + 1
            r7 = r8
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.CardBindingCameraActivity.a(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.cardbinding.activity.CardBindingCameraActivity.$$a
            int r7 = 46 - r7
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.CardBindingCameraActivity.c(short, short, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createCardBindingCameraActivityIntent(Context context, String str) {
        return Companion.MyBillsEntityDataFactory(context, str);
    }

    static void getAuthRequestContext() {
        getSupportButtonTintMode = -2892674167827227430L;
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
        b((ViewConfiguration.getTapTimeout() >> 16) + 27479, new char[]{19960, 9888, 39763, 4078, 57514, 21827, 51703, 41686, 5966, 35813, 31953, 53620, 17919, 16029, 37688, 2021, 63642, 27949}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((ViewConfiguration.getFadingEdgeLength() >> 16) + 25349, new char[]{19956, 12005, 35782, 25855, 49641}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 35 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 11789, new char[]{19886, 25591, 4533, 51078, 62877, 43964, 23022, 4090, 15814, 54153, 33144, 46960, 25952, 6914, 51486, 65388, 44408, 17269, 28997, 9999, 54521, 35563, 47332, 28292, 7365, 13039, 57587, 38562, 17607, 31364, 10366, 56943, 35840, 41474, 20497, 1639, 13355, 59969, 38991, 20050, 32678, 11754, 50063, 61824, 42951, 21987, 3065, 14751}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((ViewConfiguration.getTapTimeout() >> 16) + 59693, new char[]{19960, 42113, 40949, 63098, 59723, 49217, 15015, 11674, 1173, 32623, 22114, 18755, 41953, 39649, 36318, 58382, 57211, 13910, 10453, 1023, 31353, 27929, 17521, 48801, 37271, 34974, 58162, 55875, 52557, 10212, 7917, 29144, 26714, 17200, 47703, 44166, 34734, 65147, 53511, 51313, 8868, 5532, 3230, 26407, 24134, 45383, 43966, 33517, 62938, 60471, 51044, 15959, 4228, 3071, 25303, 21763, 19569, 42669, 39368, 61604, 60196, 49688, 13595, 12217}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((ViewConfiguration.getLongPressTimeout() >> 16) + 29327, new char[]{19883, 16167, 43234, 6742, 34716, 29029, 58097, 27716, 55769, 19110, 13367, 41357, 4892, 40169, 3707, 64463, 25864, 54915, 17315, 52576, 48775, 10304, 38322, 1907, 61638, 25096, 61222, 22708, 51803, 47052, 8556, 37547, 7246, 35218, 31573, 58412, 20967, 49925, 19605, 15976, 44025, 5400, 34526, 29608, 64821, 28298, 55370, 17850, 14127, 41215, 4628, 40833, 2215, 64051, 26581, 53525, 17126, 52347, 47558, 11098, 38011, 447, 62222, 31889}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(63197 - ExpandableListView.getPackedPositionGroup(0L), new char[]{19953, 47920, 41047, 43390, 38558, 40946, 33944, 36285, 64277, 57405, 59733, 54919, 57323, 50388, 52711, 15128, 8236, 10581, 5735, 8093, 1212, 3531, 31507, 24684, 26950, 22137, 24458, 17572, 19921, 47843, 40974, 43311, 38488, 40854, 33958, 36224, 64238, 57351, 59706, 54813, 57200, 50316, 52658, 15017, 8204, 10542, 5704, 8047, 1178, 3488, 31388, 25576, 26959, 22135, 24418, 17556, 19876, 47810, 41983, 43269}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(4562 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{19872, 23654, 28175, 30916, 2799, 5309}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(PlaceComponentResult[31], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 - 4), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 56, AndroidCharacter.getMirror('0') - '-', (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], $$a[53], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 800, 15 - View.resolveSizeAndState(0, 0, 0), (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, View.MeasureSpec.getMode(0) + 15, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 815, 29 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (57994 - ((Process.getThreadPriority(0) + 20) >> 6)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 800, 15 - View.resolveSizeAndState(0, 0, 0), (char) TextUtils.getCapsMode("", 0, 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {73638806, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, MotionEvent.axisFromString("") + 19, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = {this};
                Object[] objArr20 = new Object[1];
                a(PlaceComponentResult[31], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 - 4), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 61, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 45, (char) ('0' - AndroidCharacter.getMirror('0')));
                        Object[] objArr23 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], $$a[8], objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {73638806, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), TextUtils.lastIndexOf("", '0', 0) + 19, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
                Object[] objArr26 = {this};
                Object[] objArr27 = new Object[1];
                a(PlaceComponentResult[31], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 - 4), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.MeasureSpec.makeMeasureSpec(0, 0), 4 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 38968));
                        Object[] objArr30 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], $$a[8], objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - View.resolveSizeAndState(0, 0, 0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {73638806, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), View.getDefaultSize(0, 0) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
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
                Object[] objArr33 = {this};
                Object[] objArr34 = new Object[1];
                a(PlaceComponentResult[31], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 - 4), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (KeyEvent.getMaxKeyCode() >> 16), 3 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) TextUtils.indexOf("", "", 0));
                        byte b = $$a[9];
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr37 = new Object[1];
                        c(b, b2, b2, objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {73638806, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
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

    public CardBindingCameraActivity() {
        Job launch$default;
        Job launch$default2;
        final CardBindingCameraActivity cardBindingCameraActivity = this;
        final Function0 function0 = null;
        this.cardBindingVm = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CardBindingViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$cardBindingVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return CardBindingCameraActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = cardBindingCameraActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
        this.otpVm = new ViewModelLazy(Reflection.getOrCreateKotlinClass(OtpCardBindingViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$otpVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return CardBindingCameraActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$special$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = cardBindingCameraActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
        CardBindingCameraActivity cardBindingCameraActivity2 = this;
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(cardBindingCameraActivity2), null, null, new CardBindingCameraActivity$observeCardBindingUiState$1(this, null), 3, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = launch$default;
        launch$default2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(cardBindingCameraActivity2), null, null, new CardBindingCameraActivity$observeOtpUiState$1(this, null), 3, null);
        this.GetContactSyncConfig = launch$default2;
    }

    @JvmName(name = "getViewModelFactory")
    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setViewModelFactory")
    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "");
        this.viewModelFactory = viewModelFactory;
    }

    @JvmName(name = "getCardBindingAnalyticTracker")
    public final CardBindingAnalyticTracker getCardBindingAnalyticTracker() {
        CardBindingAnalyticTracker cardBindingAnalyticTracker = this.cardBindingAnalyticTracker;
        if (cardBindingAnalyticTracker != null) {
            return cardBindingAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCardBindingAnalyticTracker")
    public final void setCardBindingAnalyticTracker(CardBindingAnalyticTracker cardBindingAnalyticTracker) {
        Intrinsics.checkNotNullParameter(cardBindingAnalyticTracker, "");
        this.cardBindingAnalyticTracker = cardBindingAnalyticTracker;
    }

    @JvmName(name = "getCardBindingVm")
    public final CardBindingViewModel getCardBindingVm() {
        return (CardBindingViewModel) this.cardBindingVm.getValue();
    }

    @JvmName(name = "getOtpVm")
    public final OtpCardBindingViewModel getOtpVm() {
        return (OtpCardBindingViewModel) this.otpVm.getValue();
    }

    @JvmName(name = "getCashierMainResult")
    public final CashierCheckoutModel getCashierMainResult() {
        return this.cashierMainResult;
    }

    @JvmName(name = "setCashierMainResult")
    public final void setCashierMainResult(CashierCheckoutModel cashierCheckoutModel) {
        this.cashierMainResult = cashierCheckoutModel;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityCardBindingCameraBinding inflateViewBinding() {
        ActivityCardBindingCameraBinding PlaceComponentResult2 = ActivityCardBindingCameraBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[25], PlaceComponentResult[32], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(PlaceComponentResult[25], PlaceComponentResult[27], PlaceComponentResult[13], objArr3);
            Object[] objArr4 = new Object[1];
            b(((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 27446, new char[]{19960, 9888, 39763, 4078, 57514, 21827, 51703, 41686, 5966, 35813, 31953, 53620, 17919, 16029, 37688, 2021, 63642, 27949}, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(25349 - (ViewConfiguration.getEdgeSlop() >> 16), new char[]{19956, 12005, 35782, 25855, 49641}, objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    b(super.getResources().getString(R.string.bottom_on_boarding_body_text_top_up_second).substring(8, 9).codePointAt(0) + 49548, new char[]{19960, 35898, 52839, 2188, 19138, 34033, 50995, 300, 17296, 40412, 57323, 7800, 22596, 39571, 54491, 5875, 20799, 37741, 60807, 12247, 27081, 43040, 60021, 9367, 26304, 41208}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    try {
                        Object[] objArr7 = new Object[1];
                        a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[25], PlaceComponentResult[32], objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        a(PlaceComponentResult[25], PlaceComponentResult[27], PlaceComponentResult[13], objArr8);
                        Object[] objArr9 = new Object[1];
                        b(((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 19040, new char[]{19962, 1901, 55529, 37480, 26616, 14706, 62187, 17503, 6625, 54112, 42239, 32379, 13302, 34165, 24291, 4223, 58854, 48998}, objArr9);
                        baseContext = (Context) cls3.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr10 = new Object[1];
                        b(getPackageName().length() + 11782, new char[]{19886, 25591, 4533, 51078, 62877, 43964, 23022, 4090, 15814, 54153, 33144, 46960, 25952, 6914, 51486, 65388, 44408, 17269, 28997, 9999, 54521, 35563, 47332, 28292, 7365, 13039, 57587, 38562, 17607, 31364, 10366, 56943, 35840, 41474, 20497, 1639, 13355, 59969, 38991, 20050, 32678, 11754, 50063, 61824, 42951, 21987, 3065, 14751}, objArr10);
                        String str = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(super.getResources().getString(R.string.toast_error_card_invalid).substring(30, 31).length() + 59692, new char[]{19960, 42113, 40949, 63098, 59723, 49217, 15015, 11674, 1173, 32623, 22114, 18755, 41953, 39649, 36318, 58382, 57211, 13910, 10453, 1023, 31353, 27929, 17521, 48801, 37271, 34974, 58162, 55875, 52557, 10212, 7917, 29144, 26714, 17200, 47703, 44166, 34734, 65147, 53511, 51313, 8868, 5532, 3230, 26407, 24134, 45383, 43966, 33517, 62938, 60471, 51044, 15959, 4228, 3071, 25303, 21763, 19569, 42669, 39368, 61604, 60196, 49688, 13595, 12217}, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        b(getPackageName().codePointAt(2) + 29281, new char[]{19883, 16167, 43234, 6742, 34716, 29029, 58097, 27716, 55769, 19110, 13367, 41357, 4892, 40169, 3707, 64463, 25864, 54915, 17315, 52576, 48775, 10304, 38322, 1907, 61638, 25096, 61222, 22708, 51803, 47052, 8556, 37547, 7246, 35218, 31573, 58412, 20967, 49925, 19605, 15976, 44025, 5400, 34526, 29608, 64821, 28298, 55370, 17850, 14127, 41215, 4628, 40833, 2215, 64051, 26581, 53525, 17126, 52347, 47558, 11098, 38011, 447, 62222, 31889}, objArr12);
                        String str3 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        b(ExpandableListView.getPackedPositionGroup(0L) + 63197, new char[]{19953, 47920, 41047, 43390, 38558, 40946, 33944, 36285, 64277, 57405, 59733, 54919, 57323, 50388, 52711, 15128, 8236, 10581, 5735, 8093, 1212, 3531, 31507, 24684, 26950, 22137, 24458, 17572, 19921, 47843, 40974, 43311, 38488, 40854, 33958, 36224, 64238, 57351, 59706, 54813, 57200, 50316, 52658, 15017, 8204, 10542, 5704, 8047, 1178, 3488, 31388, 25576, 26959, 22135, 24418, 17556, 19876, 47810, 41983, 43269}, objArr13);
                        String str4 = (String) objArr13[0];
                        Object[] objArr14 = new Object[1];
                        b((ViewConfiguration.getPressedStateDuration() >> 16) + 4561, new char[]{19872, 23654, 28175, 30916, 2799, 5309}, objArr14);
                        try {
                            Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, 18 - Color.green(0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr15);
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
            }
            try {
                Object[] objArr16 = new Object[1];
                a(PlaceComponentResult[31], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr16);
                Class<?> cls5 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 - 4), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.indexOf("", "", 0, 0) + 4, (char) (ViewConfiguration.getTouchSlop() >> 8));
                        byte b = $$a[9];
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr19 = new Object[1];
                        c(b, b2, b2, objArr19);
                        obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.keyCodeFromString("") + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {2096170959, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
                    CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
                    CardBindingTrackerUtil.getAuthRequestContext();
                    CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
                    CardBindingTrackerUtil.moveToNextValue();
                    super.onCreate(savedInstanceState);
                    ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda8
                        @Override // androidx.view.result.ActivityResultCallback
                        public final void onActivityResult(Object obj6) {
                            CardBindingCameraActivity.$r8$lambda$SFnBFKJl5VLO9P58L8biFqyBIjk(CardBindingCameraActivity.this, (ActivityResult) obj6);
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
                    this.initRecordTimeStamp = registerForActivityResult;
                    ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda7
                        @Override // androidx.view.result.ActivityResultCallback
                        public final void onActivityResult(Object obj6) {
                            CardBindingCameraActivity.$r8$lambda$sONlcnrJSdIUDonEA7Rv7ID9TzA(CardBindingCameraActivity.this, (ActivityResult) obj6);
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "");
                    this.DatabaseTableConfigUtil = registerForActivityResult2;
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((Process.myTid() >> 22) + 49613, new char[]{19960, 35898, 52839, 2188, 19138, 34033, 50995, 300, 17296, 40412, 57323, 7800, 22596, 39571, 54491, 5875, 20799, 37741, 60807, 12247, 27081, 43040, 60021, 9367, 26304, 41208}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[25], PlaceComponentResult[32], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[27], PlaceComponentResult[13], objArr3);
                Object[] objArr4 = new Object[1];
                b(((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 19040, new char[]{19962, 1901, 55529, 37480, 26616, 14706, 62187, 17503, 6625, 54112, 42239, 32379, 13302, 34165, 24291, 4223, 58854, 48998}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), 34 - TextUtils.lastIndexOf("", '0', 0), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 18 - View.resolveSize(0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
        AnimatorSet animatorSet = this.PlaceComponentResult;
        if (animatorSet != null) {
            animatorSet.pause();
        }
        CameraView cameraView = (CameraView) getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (cameraView != null) {
            cameraView.close();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49613, new char[]{19960, 35898, 52839, 2188, 19138, 34033, 50995, 300, 17296, 40412, 57323, 7800, 22596, 39571, 54491, 5875, 20799, 37741, 60807, 12247, 27081, 43040, 60021, 9367, 26304, 41208}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19074, new char[]{19962, 1901, 55529, 37480, 26616, 14706, 62187, 17503, 6625, 54112, 42239, 32379, 13302, 34165, 24291, 4223, 58854, 48998}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - Color.green(0), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Gravity.getAbsoluteGravity(0, 0), 18 - Drawable.resolveOpacity(0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            PlaceComponentResult();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerCardBindingComponent.Builder MyBillsEntityDataFactory = DaggerCardBindingComponent.MyBillsEntityDataFactory();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, "android.permission.CAMERA") == 0;
    }

    static /* synthetic */ void PlaceComponentResult$default(CardBindingCameraActivity cardBindingCameraActivity, BankCardInfoModel bankCardInfoModel, int i, Object obj) {
        if ((i & 1) != 0) {
            bankCardInfoModel = null;
        }
        cardBindingCameraActivity.PlaceComponentResult(bankCardInfoModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(BankCardInfoModel p0) {
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = this.KClassImpl$Data$declaredNonStaticMembers$2;
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior.getState() != 3) {
            getBinding().SubSequence.setBottomSheetModel(p0);
            BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (bottomSheetBehavior3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bottomSheetBehavior2 = bottomSheetBehavior3;
            }
            bottomSheetBehavior2.setState(3);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        float f;
        AppCompatImageView appCompatImageView;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == 0) {
            f = 700.0f;
            appCompatImageView = getBinding().isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        } else {
            f = 1200.0f;
            appCompatImageView = getBinding().PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        }
        appCompatImageView.setTranslationY(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(appCompatImageView, "translationY", f);
        ofFloat.setDuration(2000L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(appCompatImageView, "translationY", 0.0f);
        ofFloat2.setDuration(2000L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(appCompatImageView, "rotation", 0.0f, 180.0f);
        ofFloat3.setDuration(0L);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(CollectionsKt.listOf((Object[]) new ObjectAnimator[]{ofFloat, ofFloat3, ofFloat2}));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$setupScanAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (animatorSet.isPaused()) {
                    return;
                }
                animatorSet.start();
            }
        });
        this.PlaceComponentResult = animatorSet;
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r0.equals(id.dana.cashier.VerificationMethod.SEND_OTP) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
    
        if (r0 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
    
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009c, code lost:
    
        if (r0 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ba, code lost:
    
        if (r0.equals(id.dana.cashier.VerificationMethod.BANK_OTP) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bc, code lost:
    
        sendBankOtp();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(id.dana.cashier.model.CashierPayModel r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.CardBindingCameraActivity.MyBillsEntityDataFactory(id.dana.cashier.model.CashierPayModel):void");
    }

    public final void trackAddCardExecution() {
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = getCardBindingAnalyticTracker();
        CashierCheckoutModel cashierCheckoutModel = this.cashierMainResult;
        CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(cardBindingAnalyticTracker, new AddCardExecutionProperties(cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null, getBinding().SubSequence.getQueryCardPolicyInfoModel(), null, null, 12, null));
        CardBindingTrackerUtil cardBindingTrackerUtil3 = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void PlaceComponentResult$default(CardBindingCameraActivity cardBindingCameraActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        cardBindingCameraActivity.PlaceComponentResult(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(String p0, String p1) {
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.getAuthRequestContext = CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(CardBindingTrackerUtil.PlaceComponentResult);
        CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = getCardBindingAnalyticTracker();
        CashierCheckoutModel cashierCheckoutModel = this.cashierMainResult;
        CardBindingTrackerUtil.PlaceComponentResult(cardBindingAnalyticTracker, new AddCardResultProperties(false, cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null, p0, getBinding().SubSequence.getQueryCardPolicyInfoModel(), null, null, null, null, p1, 240, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.getAuthRequestContext = CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(CardBindingTrackerUtil.PlaceComponentResult);
        CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = getCardBindingAnalyticTracker();
        CashierCheckoutModel cashierCheckoutModel = this.cashierMainResult;
        CardBindingTrackerUtil.PlaceComponentResult(cardBindingAnalyticTracker, new AddCardResultProperties(true, cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null, p0, getBinding().SubSequence.getQueryCardPolicyInfoModel(), null, null, null, null, null, 496, null));
    }

    public final void sendBankOtp() {
        SendBankOtpModel sendBankOtpModel = getBinding().SubSequence.getSendBankOtpModel();
        if (sendBankOtpModel != null) {
            if (getBinding().SubSequence.getIsDirectDebit()) {
                getOtpVm().BuiltInFictitiousFunctionClassFactory(sendBankOtpModel);
            } else {
                OtpCardBindingViewModel.PlaceComponentResult(getOtpVm(), sendBankOtpModel);
            }
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(this);
        builder.scheduleImpl = "card_binding_pin";
        ChallengeControl.Builder PlaceComponentResult2 = builder.PlaceComponentResult("PASSWORD", p0, this.moveToNextValue, getBinding().SubSequence.getPayMethod(), p1);
        PlaceComponentResult2.VerifyPinStateManager$executeRiskChallenge$2$1 = "card_binding_pin";
        new ChallengeControl(PlaceComponentResult2, null).getAuthRequestContext();
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.getErrorConfigVersion();
    }

    static /* synthetic */ void MyBillsEntityDataFactory$default(CardBindingCameraActivity cardBindingCameraActivity, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        cardBindingCameraActivity.MyBillsEntityDataFactory(str, num, num2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(String p0, Integer p1, Integer p2) {
        if (p1 != null && p1.intValue() == 0) {
            CardBindingDialogExtKt.BuiltInFictitiousFunctionClassFactory(this);
            return;
        }
        ChallengeControl.Builder builder = new ChallengeControl.Builder(this);
        builder.scheduleImpl = ChallengeScenario.CARD_BINDING_OTP;
        new ChallengeControl(builder.KClassImpl$Data$declaredNonStaticMembers$2(p0, getBinding().SubSequence.getSendBankOtpModel(), this.moveToNextValue, getBinding().SubSequence.getIsDirectDebit(), getBinding().SubSequence.getPayMethod()).KClassImpl$Data$declaredNonStaticMembers$2(p2 != null ? p2.intValue() : 0, p1 != null ? p1.intValue() : 4, null, false), null).getAuthRequestContext();
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.getErrorConfigVersion();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(Target p0, final Function0<Unit> p1) {
        if (p0 == null || this.newProxyInstance != null) {
            return;
        }
        SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(this);
        simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
        this.newProxyInstance = simpleShowcaseBuilder.PlaceComponentResult(getString(R.string.card_binding_ok_button)).getAuthRequestContext(SizeUtil.getAuthRequestContext(16)).BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$showShowcase$1
            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
            public final void onFinished(int p02) {
                CardBindingCameraActivity.this.newProxyInstance = null;
                p1.invoke();
            }
        }).PlaceComponentResult();
    }

    private final Target getAuthRequestContext(View p0, int p1, int p2) {
        return new TargetBuilder(this).BuiltInFictitiousFunctionClassFactory(p0).BuiltInFictitiousFunctionClassFactory(new CircleShape(SplitBillIntroductionActivity.SPOTLIGHT_SIZE)).getAuthRequestContext(new Content(getResources().getString(p1), getResources().getString(p2))).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = this.KClassImpl$Data$declaredNonStaticMembers$2;
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior.getState() == 3) {
            BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (bottomSheetBehavior3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bottomSheetBehavior2 = bottomSheetBehavior3;
            }
            bottomSheetBehavior2.setState(4);
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        AttributeCashierPayModel attributeCashierPayModel;
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1013 || requestCode == 1014) && resultCode == -1) {
            CashierPayModel cashierPayModel = (data == null || (extras3 = data.getExtras()) == null) ? null : (CashierPayModel) extras3.getParcelable(ChallengeControl.Key.CASHIER_PAY_MODEL);
            CashierAgreementModel cashierAgreementModel = (data == null || (extras2 = data.getExtras()) == null) ? null : (CashierAgreementModel) extras2.getParcelable(ChallengeControl.Key.CASHIER_AGREEMENT_MODEL);
            boolean z = false;
            this.moveToNextValue = (data == null || (extras = data.getExtras()) == null) ? false : extras.getBoolean(ChallengeControl.Key.IS_RISK_PHASE_2);
            this.getAuthRequestContext = (cashierPayModel == null || (attributeCashierPayModel = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : attributeCashierPayModel.scheduleImpl;
            if (cashierPayModel != null) {
                AttributeCashierPayModel attributeCashierPayModel2 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
                if (attributeCashierPayModel2 != null && attributeCashierPayModel2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    z = true;
                }
                if (z) {
                    MyBillsEntityDataFactory(cashierPayModel);
                    return;
                }
                CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
                CardBindingTrackerUtil.PlaceComponentResult();
                CardBindingDialogExtKt.KClassImpl$Data$declaredNonStaticMembers$2(this, this.getAuthRequestContext);
                String str = cashierAgreementModel != null ? cashierAgreementModel.scheduleImpl : null;
                if (str == null) {
                    str = "";
                }
                KClassImpl$Data$declaredNonStaticMembers$2(str);
                getCardBindingVm().BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cardbinding/activity/CardBindingCameraActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, CardBindingCameraActivity.class);
            intent.putExtra("source", p1);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$4LtrmHm_pzTDYOan7f7Uv-_uUDU  reason: not valid java name */
    public static /* synthetic */ void m478$r8$lambda$4LtrmHm_pzTDYOan7f7Uv_uUDU(CardBindingCameraActivity cardBindingCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        ArrayList arrayList = new ArrayList();
        String string = cardBindingCameraActivity.getString(R.string.prepare_your_bank_card);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = cardBindingCameraActivity.getString(R.string.prepare_your_bank_card_description);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.on_boarding_prepare_card, string, string2));
        String string3 = cardBindingCameraActivity.getString(R.string.make_sure_your_card_number_visible);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = cardBindingCameraActivity.getString(R.string.make_sure_your_card_number_visible_description);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.on_boarding_check_card_number, string3, string4));
        String string5 = cardBindingCameraActivity.getString(R.string.prepare_a_good_lightning);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = cardBindingCameraActivity.getString(R.string.prepare_a_good_lightning_description);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.on_boarding_prepare_good_visual, string5, string6));
        String string7 = cardBindingCameraActivity.getString(R.string.scan_your_bank_card_correctly);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        String string8 = cardBindingCameraActivity.getString(R.string.scan_your_bank_card_correctly_description);
        Intrinsics.checkNotNullExpressionValue(string8, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.on_boarding_create_card, string7, string8));
        BottomSheetHelpActivity.Companion companion = BottomSheetHelpActivity.INSTANCE;
        String string9 = cardBindingCameraActivity.getString(R.string.how_to_scan_your_bank_card);
        Intrinsics.checkNotNullExpressionValue(string9, "");
        String string10 = cardBindingCameraActivity.getString(R.string.dana_will_not_save_your_bank_photo);
        Intrinsics.checkNotNullExpressionValue(string10, "");
        String string11 = cardBindingCameraActivity.getString(R.string.kyc_renewal_activity_button);
        Intrinsics.checkNotNullExpressionValue(string11, "");
        cardBindingCameraActivity.startActivity(BottomSheetHelpActivity.Companion.PlaceComponentResult(cardBindingCameraActivity, new OnBoardingModel(string9, "list", arrayList, UserEducationScenarioKt.CARD_BINDING_ONBOARDING, string10, string11, null, 64, null), true));
    }

    public static /* synthetic */ void $r8$lambda$BgigW4R0vS0fvkw_xWVgMoRVSKE(CardBindingCameraActivity cardBindingCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        cardBindingCameraActivity.onBackPressed();
    }

    /* renamed from: $r8$lambda$PngNxD-PK5mPsBAHBJoHFxBEDpc  reason: not valid java name */
    public static /* synthetic */ void m479$r8$lambda$PngNxDPK5mPsBAHBJoHFxBEDpc(CardBindingCameraActivity cardBindingCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        cardBindingCameraActivity.getBinding().readMicros.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
        AppCompatImageView appCompatImageView = cardBindingCameraActivity.getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        cardBindingCameraActivity.KClassImpl$Data$declaredNonStaticMembers$2(cardBindingCameraActivity.getAuthRequestContext(appCompatImageView, R.string.card_binding_showcase_help_title, R.string.card_binding_showcase_help_content), new CardBindingCameraActivity$showBtnHelpToolTip$1(cardBindingCameraActivity));
    }

    /* renamed from: $r8$lambda$PsYs4Gu1uR1-yrM_YyhlYLsVlyY  reason: not valid java name */
    public static /* synthetic */ void m480$r8$lambda$PsYs4Gu1uR1yrM_YyhlYLsVlyY(CardBindingCameraActivity cardBindingCameraActivity, Frame frame) {
        CameraView cameraView;
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        Intrinsics.checkNotNullParameter(frame, "");
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = cardBindingCameraActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bottomSheetBehavior != null) {
            if (bottomSheetBehavior == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bottomSheetBehavior = null;
            }
            if (bottomSheetBehavior.getState() == 3 && (cameraView = (CameraView) cardBindingCameraActivity.getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1)) != null) {
                cameraView.close();
            }
        }
        if (cardBindingCameraActivity.scheduleImpl) {
            return;
        }
        if (frame.MyBillsEntityDataFactory == byte[].class) {
            cardBindingCameraActivity.getCardBindingVm().KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (frame.MyBillsEntityDataFactory == Image.class) {
            cardBindingCameraActivity.getCardBindingVm().KClassImpl$Data$declaredNonStaticMembers$2();
        }
        cardBindingCameraActivity.scheduleImpl = true;
    }

    public static /* synthetic */ void $r8$lambda$SFnBFKJl5VLO9P58L8biFqyBIjk(CardBindingCameraActivity cardBindingCameraActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            cardBindingCameraActivity.getCardBindingVm().getAuthRequestContext(UserEducationScenarioKt.CARD_BINDING_ONBOARDING);
        }
    }

    public static /* synthetic */ void $r8$lambda$V1zFd6_LhjX078dedOqKDsNOMLI(CardBindingCameraActivity cardBindingCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        cardBindingCameraActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = cardBindingCameraActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 == 0 ? 1 : 0;
        Group group = cardBindingCameraActivity.getBinding().getSupportButtonTintMode;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(cardBindingCameraActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 == 1 ? 4 : 0);
        Group group2 = cardBindingCameraActivity.getBinding().whenAvailable;
        Intrinsics.checkNotNullExpressionValue(group2, "");
        group2.setVisibility(cardBindingCameraActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 == 0 ? 4 : 0);
        AnimatorSet animatorSet = cardBindingCameraActivity.PlaceComponentResult;
        if (animatorSet != null) {
            animatorSet.pause();
        }
        AnimatorSet animatorSet2 = cardBindingCameraActivity.PlaceComponentResult;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        cardBindingCameraActivity.PlaceComponentResult = null;
        cardBindingCameraActivity.BuiltInFictitiousFunctionClassFactory();
    }

    /* renamed from: $r8$lambda$Zx8zaLl-EtRsN6Ku2qzkuO17tRc  reason: not valid java name */
    public static /* synthetic */ void m481$r8$lambda$Zx8zaLlEtRsN6Ku2qzkuO17tRc(CardBindingCameraActivity cardBindingCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        cardBindingCameraActivity.getBinding().getCallingPid.checkPermission();
    }

    public static /* synthetic */ void $r8$lambda$_lP9eQS1_zus0JV67zilSL6hzU0(final CardBindingCameraActivity cardBindingCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        CameraView cameraView = (CameraView) cardBindingCameraActivity.getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (cameraView != null) {
            cameraView.close();
        }
        AnimatorSet animatorSet = cardBindingCameraActivity.PlaceComponentResult;
        if (animatorSet != null) {
            animatorSet.pause();
        }
        ((MaterialDialog) cardBindingCameraActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue()).show();
        SupportedCardsView supportedCardsView = (SupportedCardsView) ((MaterialDialog) cardBindingCameraActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue()).findViewById(R.id.viewSupportedCardsDialog);
        if (supportedCardsView != null) {
            SupportedCardsConfigModel supportedCardsConfigModel = cardBindingCameraActivity.isLayoutRequested;
            if (supportedCardsConfigModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                supportedCardsConfigModel = null;
            }
            supportedCardsView.setupDataFromSplit(supportedCardsConfigModel, true);
            supportedCardsView.setSupportedCardsDialogOnClickListener(new SupportedCardsView.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$showSupportedCardsDialog$1$1
                @Override // id.dana.cardbinding.view.SupportedCardsView.OnClickListener
                public final void getAuthRequestContext() {
                    CardBindingCameraActivity.access$getSupportedCardsDialog(CardBindingCameraActivity.this).dismiss();
                }
            });
        }
    }

    public static /* synthetic */ void $r8$lambda$sONlcnrJSdIUDonEA7Rv7ID9TzA(CardBindingCameraActivity cardBindingCameraActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory != -1) {
            CardBindingDialogExtKt.getAuthRequestContext(cardBindingCameraActivity);
            PlaceComponentResult$default(cardBindingCameraActivity, "3DS Failed", null, 2, null);
            return;
        }
        Intent intent = activityResult.MyBillsEntityDataFactory;
        String stringExtra = intent != null ? intent.getStringExtra(CashierRisk3dsActivity.URL_PARAMS) : null;
        CashierCheckoutModel cashierCheckoutModel = cardBindingCameraActivity.cashierMainResult;
        if (cashierCheckoutModel != null) {
            String str = cashierCheckoutModel.PlaceComponentResult;
            cardBindingCameraActivity.getCardBindingVm().KClassImpl$Data$declaredNonStaticMembers$2(new CashierPayParamModel(str == null ? "" : str, stringExtra, null, false, null, null, null, cardBindingCameraActivity.getBinding().SubSequence.getIsCardBcaOneKlik(), 124, null));
        }
    }

    public static /* synthetic */ void $r8$lambda$w0WFEPE6Ivzk2oMRt6JwvuUQhgU(CardBindingCameraActivity cardBindingCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingCameraActivity, "");
        cardBindingCameraActivity.finish();
    }

    public static final /* synthetic */ void access$checkCameraPermission(CardBindingCameraActivity cardBindingCameraActivity) {
        if (cardBindingCameraActivity.KClassImpl$Data$declaredNonStaticMembers$2()) {
            cardBindingCameraActivity.PlaceComponentResult();
            return;
        }
        cardBindingCameraActivity.getBinding().getCallingPid.checkPermission();
        cardBindingCameraActivity.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(CardBindingCameraActivity cardBindingCameraActivity) {
        return (DanaLoadingDialog) cardBindingCameraActivity.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ MaterialDialog access$getRequestCameraAccessDialog(CardBindingCameraActivity cardBindingCameraActivity) {
        return (MaterialDialog) cardBindingCameraActivity.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue();
    }

    public static final /* synthetic */ MaterialDialog access$getSupportedCardsDialog(CardBindingCameraActivity cardBindingCameraActivity) {
        return (MaterialDialog) cardBindingCameraActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
    }

    public static final /* synthetic */ void access$navigateToOnboardingActivity(CardBindingCameraActivity cardBindingCameraActivity) {
        ActivityResultLauncher<Intent> activityResultLauncher = cardBindingCameraActivity.initRecordTimeStamp;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        OnboardingCardBindingActivity.Companion companion = OnboardingCardBindingActivity.INSTANCE;
        activityResultLauncher.MyBillsEntityDataFactory(OnboardingCardBindingActivity.Companion.BuiltInFictitiousFunctionClassFactory(cardBindingCameraActivity), null);
    }

    public static final /* synthetic */ void access$onBottomSheetExpand(CardBindingCameraActivity cardBindingCameraActivity, boolean z) {
        if (z) {
            CameraView cameraView = (CameraView) cardBindingCameraActivity.getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
            if (cameraView != null) {
                cameraView.close();
            }
        } else {
            CameraView cameraView2 = (CameraView) cardBindingCameraActivity.getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
            if (cameraView2 != null) {
                cameraView2.open();
            }
        }
        LinearLayout linearLayout = cardBindingCameraActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(z ? 4 : 0);
        AppCompatImageView appCompatImageView = cardBindingCameraActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        boolean z2 = !z;
        appCompatImageView.setVisibility(z2 ? 4 : 0);
        TextView textView = cardBindingCameraActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda6;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(z2 ? 4 : 0);
    }

    public static final /* synthetic */ void access$resumeCamera(CardBindingCameraActivity cardBindingCameraActivity) {
        CameraView cameraView = (CameraView) cardBindingCameraActivity.getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (cameraView != null) {
            cameraView.open();
        }
    }

    public static final /* synthetic */ void access$showBtnAvailableCardInfoToolTip(final CardBindingCameraActivity cardBindingCameraActivity) {
        AppCompatImageView appCompatImageView = cardBindingCameraActivity.getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        cardBindingCameraActivity.KClassImpl$Data$declaredNonStaticMembers$2(cardBindingCameraActivity.getAuthRequestContext(appCompatImageView, R.string.card_binding_showcase_help_supported_card_title, R.string.card_binding_showcase_help_supported_card_content), new Function0<Unit>() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$showBtnAvailableCardInfoToolTip$1
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
                boolean KClassImpl$Data$declaredNonStaticMembers$22;
                KClassImpl$Data$declaredNonStaticMembers$22 = CardBindingCameraActivity.this.KClassImpl$Data$declaredNonStaticMembers$2();
                if (KClassImpl$Data$declaredNonStaticMembers$22) {
                    CardBindingCameraActivity.this.PlaceComponentResult();
                } else {
                    CardBindingCameraActivity.access$getRequestCameraAccessDialog(CardBindingCameraActivity.this).show();
                }
            }
        });
    }

    public static final /* synthetic */ void access$trackAddCardOpenIfNeeded(CardBindingCameraActivity cardBindingCameraActivity) {
        Bundle extras;
        if (cardBindingCameraActivity.getErrorConfigVersion) {
            return;
        }
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = cardBindingCameraActivity.getCardBindingAnalyticTracker();
        Intent intent = cardBindingCameraActivity.getIntent();
        CardBindingTrackerUtil.BuiltInFictitiousFunctionClassFactory(cardBindingAnalyticTracker, new AddCardOpenProperties((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("source"), null, null, 6, null));
        cardBindingCameraActivity.getErrorConfigVersion = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        CameraView cameraView = (CameraView) getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (cameraView != null) {
            cameraView.open();
        }
        AnimatorSet animatorSet = this.PlaceComponentResult;
        if (animatorSet != null) {
            animatorSet.resume();
        }
        TextView textView = getBinding().FragmentBottomSheetPaymentSettingBinding;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        LinearLayout linearLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda5;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(0);
        LayoutCardBindingCameraOverlayBinding layoutCardBindingCameraOverlayBinding = getBinding().isLayoutRequested;
        AppCompatImageView appCompatImageView = layoutCardBindingCameraOverlayBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        ConstraintLayout constraintLayout = layoutCardBindingCameraOverlayBinding.MyBillsEntityDataFactory.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        DanaButtonPrimaryView danaButtonPrimaryView = layoutCardBindingCameraOverlayBinding.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(8);
    }

    private final void BuiltInFictitiousFunctionClassFactory(CashierPayModel p0) {
        Bundle KClassImpl$Data$declaredNonStaticMembers$22 = new RiskParamsFactory(p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.MyBillsEntityDataFactory, null, false, null, null, null, null, null, null, null, null, null, null, null, 32764, null).KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.putBoolean(CashierRisk3dsActivity.IS_CARD_BINDING, true);
        CashierRisk3dsActivity.Companion companion = CashierRisk3dsActivity.INSTANCE;
        Intent authRequestContext = CashierRisk3dsActivity.Companion.getAuthRequestContext(this, KClassImpl$Data$declaredNonStaticMembers$22);
        ActivityResultLauncher<Intent> activityResultLauncher = this.DatabaseTableConfigUtil;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        activityResultLauncher.MyBillsEntityDataFactory(authRequestContext, null);
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = getCardBindingAnalyticTracker();
        CashierCheckoutModel cashierCheckoutModel = this.cashierMainResult;
        CardBindingTrackerUtil.getAuthRequestContext(cardBindingAnalyticTracker, new ThirdPartyRiskChallengeProperties(cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null, getBinding().SubSequence.getQueryCardPolicyInfoModel(), null, null, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        CameraView cameraView = (CameraView) getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (cameraView != null) {
            cameraView.close();
        }
        TextView textView = getBinding().FragmentBottomSheetPaymentSettingBinding;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(4);
        getBinding().PlaceComponentResult.setClickable(false);
        LayoutCardBindingCameraOverlayBinding layoutCardBindingCameraOverlayBinding = getBinding().isLayoutRequested;
        AppCompatImageView appCompatImageView = layoutCardBindingCameraOverlayBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
        ConstraintLayout constraintLayout = layoutCardBindingCameraOverlayBinding.MyBillsEntityDataFactory.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(0);
        layoutCardBindingCameraOverlayBinding.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingCameraActivity.m481$r8$lambda$Zx8zaLlEtRsN6Ku2qzkuO17tRc(CardBindingCameraActivity.this, view);
            }
        });
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        CameraView cameraView = (CameraView) getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (cameraView != null) {
            cameraView.setLifecycleOwner(this);
        }
        CameraView cameraView2 = (CameraView) getBinding().getCallingPid._$_findCachedViewById(R.id.res_0x7f0a0275_flowablekt_toiterable_1);
        if (cameraView2 != null) {
            cameraView2.addFrameProcessor(new FrameProcessor() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda9
                @Override // com.otaliastudios.cameraview.frame.FrameProcessor
                public final void getAuthRequestContext(Frame frame) {
                    CardBindingCameraActivity.m480$r8$lambda$PsYs4Gu1uR1yrM_YyhlYLsVlyY(CardBindingCameraActivity.this, frame);
                }
            });
        }
        BottomSheetBehavior<ConstraintLayout> from = BottomSheetBehavior.from(getBinding().moveToNextValue);
        from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$setupBottomSheetBehavior$1$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View p0, float p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 == 1 || p1 == 3) {
                    CardBindingCameraActivity.access$onBottomSheetExpand(CardBindingCameraActivity.this, true);
                } else if (p1 == 4) {
                    CardBindingCameraActivity.access$onBottomSheetExpand(CardBindingCameraActivity.this, false);
                    ActivityExtKt.MyBillsEntityDataFactory(r2, CardBindingCameraActivity.this.getBinding().SubSequence.getCardNumberView());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(from, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = from;
        BuiltInFictitiousFunctionClassFactory();
        LinearLayout linearLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setTranslationY(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", 13.0f);
        ofFloat.setDuration(BeaconManager.DEFAULT_FOREGROUND_SCAN_PERIOD);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout, "translationY", 0.0f);
        ofFloat2.setDuration(BeaconManager.DEFAULT_FOREGROUND_SCAN_PERIOD);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(CollectionsKt.listOf((Object[]) new ObjectAnimator[]{ofFloat, ofFloat2}));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$setUpSwipeUpTextAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (animatorSet.isPaused()) {
                    return;
                }
                animatorSet.start();
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = animatorSet;
        animatorSet.start();
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingCameraActivity.$r8$lambda$BgigW4R0vS0fvkw_xWVgMoRVSKE(CardBindingCameraActivity.this, view);
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingCameraActivity.$r8$lambda$w0WFEPE6Ivzk2oMRt6JwvuUQhgU(CardBindingCameraActivity.this, view);
            }
        });
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingCameraActivity.$r8$lambda$V1zFd6_LhjX078dedOqKDsNOMLI(CardBindingCameraActivity.this, view);
            }
        });
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingCameraActivity.m478$r8$lambda$4LtrmHm_pzTDYOan7f7Uv_uUDU(CardBindingCameraActivity.this, view);
            }
        });
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingCameraActivity.$r8$lambda$_lP9eQS1_zus0JV67zilSL6hzU0(CardBindingCameraActivity.this, view);
            }
        });
        getBinding().getCallingPid.setDanaCameraListener(new DanaCameraView.DanaCameraListener() { // from class: id.dana.cardbinding.activity.CardBindingCameraActivity$setupCameraPermissionListener$1
            @Override // id.dana.richview.camera.DanaCameraView.DanaCameraListener
            public final void getAuthRequestContext(PictureResult p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.richview.camera.DanaCameraView.DanaCameraListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                CardBindingCameraActivity.this.MyBillsEntityDataFactory();
            }
        });
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.NetworkUserEntityData$$ExternalSyntheticLambda0 = CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(CardBindingTrackerUtil.moveToNextValue);
        getCardBindingVm().MyBillsEntityDataFactory(UserEducationScenarioKt.CARD_BINDING_ONBOARDING);
        getCardBindingVm().getAuthRequestContext();
        CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.BuiltInFictitiousFunctionClassFactory();
        getCardBindingVm().MyBillsEntityDataFactory();
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getSupportButtonTintMode ^ 4796183387843776835L);
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
