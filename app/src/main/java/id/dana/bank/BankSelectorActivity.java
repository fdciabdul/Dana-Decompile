package id.dana.bank;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.bank.BankSelectorActivity;
import id.dana.bank.contract.BankSelectorContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.ThrottledOnClickListener;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.core.ui.util.NumberUtil;
import id.dana.danah5.DanaH5;
import id.dana.databinding.ActivityAddBankBinding;
import id.dana.databinding.LayoutAddBankBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerAddBankAccountComponent;
import id.dana.di.modules.BankSelectorModule;
import id.dana.di.modules.BillerX2BModule;
import id.dana.dialog.BillerX2BDialog;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.domain.user.UserInfoResponseConstant;
import id.dana.extension.view.ActivityExtKt;
import id.dana.extension.view.InputExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.requestmoney.model.BankSelectorConfigModel;
import id.dana.richview.LogoProgressView;
import id.dana.sendmoney.model.BankModel;
import id.dana.sendmoney.model.BaseRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.WithdrawNameCheckModel;
import id.dana.sendmoney.recipient.RecipientIdType;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.model.BillerX2BModel;
import id.dana.sendmoney_v2.model.BillerX2BModelKt;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.TextUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u007f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0080\u0001\u007fB\u0007¢\u0006\u0004\b~\u0010\u000eJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u000b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u000b\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0015\u001a\u00020\u00142\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0019\u0010\u0011J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u000eJ\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u001eJ\u001f\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010'J\u0019\u0010)\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\nH\u0014¢\u0006\u0004\b+\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020,H\u0002¢\u0006\u0004\b\u000b\u0010-J\u001f\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0004\u0010.J\u000f\u0010/\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u0010\u000eJ\u000f\u00100\u001a\u00020\nH\u0002¢\u0006\u0004\b0\u0010\u000eJ\u000f\u00101\u001a\u00020\nH\u0002¢\u0006\u0004\b1\u0010\u000eJ\u000f\u00102\u001a\u00020\nH\u0002¢\u0006\u0004\b2\u0010\u000eJ\u0017\u0010&\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u00103J\u0017\u0010$\u001a\u0006*\u00020,0,*\u00020\u0003H\u0002¢\u0006\u0004\b$\u00104R\u0014\u0010$\u001a\u0002058\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u0010\u00106R+\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006*\u00020\b0\b*\f\u0012\b\u0012\u0006*\u00020\b0\b0707X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u00108R+\u0010\u0010\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00060\u0006*\f\u0012\b\u0012\u0006*\u00020\u00060\u00060707X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b/\u00108R\u0014\u0010&\u001a\u0002098\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b0\u0010:R\u0013\u0010\u000b\u001a\u00020;X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b<\u00108R\u0018\u0010/\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0013\u0010\"\u001a\u00020@X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\bA\u00108R\"\u0010C\u001a\u00020B8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010#\u001a\u00020I8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b2\u0010JR\u0016\u0010\u001d\u001a\u00020K8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u0010LR\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010A\u001a\u00020\u00068\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\bO\u0010NR\u0016\u0010>\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bP\u0010NR\u0014\u0010<\u001a\u00020\u00068\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\bQ\u0010NR\u001e\u00101\u001a\f\u0012\b\u0012\u0006*\u00020\u00140\u00140R8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010U8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bY\u0010NR\u0014\u0010P\u001a\u00020\u00068CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001eR\u0018\u0010Q\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010O\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010`\u001a\u00020_8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010S\u001a\u00020f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bg\u0010hR&\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\u000f0ij\b\u0012\u0004\u0012\u00020\u000f`j8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010g\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010NR(\u0010Y\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\bn\u0010o\"\u0004\b\u0004\u0010pR\"\u0010r\u001a\u00020q8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0013\u0010]\u001a\u00020xX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\by\u00108R\u0016\u0010W\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bz\u0010NR\u0018\u0010z\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b|\u0010}"}, d2 = {"Lid/dana/bank/BankSelectorActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityAddBankBinding;", "Lid/dana/sendmoney/model/BankModel;", "PlaceComponentResult", "()Lid/dana/sendmoney/model/BankModel;", "", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(ZLjava/lang/CharSequence;)V", "configToolbar", "()V", "", "getAuthRequestContext", "()Ljava/lang/String;", "Ljava/lang/Class;", "javaClass", "Landroid/content/Intent;", "getIntentClassWithTracking", "(Ljava/lang/Class;)Landroid/content/Intent;", "source", "(Ljava/lang/Class;Ljava/lang/String;)Landroid/content/Intent;", "getSource", "Landroid/os/Bundle;", HummerConstants.BUNDLE, "(Landroid/os/Bundle;)Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Z", "inflateViewBinding", "()Lid/dana/databinding/ActivityAddBankBinding;", IAPSyncCommand.COMMAND_INIT, "lookAheadTest", "moveToNextValue", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZLjava/lang/CharSequence;)Z", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/CharSequence;)Z", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/sendmoney/model/RecipientModel;", "(Lid/dana/sendmoney/model/RecipientModel;)V", "(ZLjava/lang/String;)V", "scheduleImpl", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "(Z)V", "(Lid/dana/sendmoney/model/BankModel;)Lid/dana/sendmoney/model/RecipientModel;", "Lid/dana/bank/BankSelectorActivity$BankCheckState;", "Lid/dana/bank/BankSelectorActivity$BankCheckState;", "Lio/reactivex/Observable;", "Lkotlin/Lazy;", "Lid/dana/requestmoney/model/BankSelectorConfigModel;", "Lid/dana/requestmoney/model/BankSelectorConfigModel;", "Lid/dana/di/modules/BankSelectorModule;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "initRecordTimeStamp", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "Lid/dana/di/modules/BillerX2BModule;", "DatabaseTableConfigUtil", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "billerX2BPresenter", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "getBillerX2BPresenter", "()Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "setBillerX2BPresenter", "(Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;)V", "Lid/dana/sendmoney/model/WithdrawNameCheckModel;", "Lid/dana/sendmoney/model/WithdrawNameCheckModel;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "newProxyInstance", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Landroidx/activity/result/ActivityResultLauncher;", "PrepareContext", "Landroidx/activity/result/ActivityResultLauncher;", "", "Lid/dana/domain/sendmoney/model/BillerX2B;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/bank/NickNameDialogFragment;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/bank/NickNameDialogFragment;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Ljava/lang/String;", "Lid/dana/bank/contract/BankSelectorContract$Presenter;", "presenter", "Lid/dana/bank/contract/BankSelectorContract$Presenter;", "getPresenter", "()Lid/dana/bank/contract/BankSelectorContract$Presenter;", "setPresenter", "(Lid/dana/bank/contract/BankSelectorContract$Presenter;)V", "", "NetworkUserEntityData$$ExternalSyntheticLambda3", "I", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "readMicros", "Ljava/util/ArrayList;", "getSupportButtonTintMode", "SubSequence", "Lid/dana/sendmoney/model/BankModel;", "(Lid/dana/sendmoney/model/BankModel;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticalTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticalTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticalTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "whenAvailable", "getCallingPid", "Lcom/ethanhua/skeleton/SkeletonScreen;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lcom/ethanhua/skeleton/SkeletonScreen;", "<init>", "Companion", "BankCheckState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankSelectorActivity extends BaseViewBindingActivity<ActivityAddBankBinding> {
    public static final String BANK_NUMBER_REGEX = "^([0-9]){5,20}$";
    public static final String EXTRA_BELOW_KITKAT = "EXTRA_BELOW_KITKAT";
    public static final String EXTRA_OPENED_FROM = "EXTRA OPENED FROM";
    public static final String EXTRA_SELECTED_BANK = "EXTRA_SELECTED_BANK";
    public static final String EXTRA_SEND_MONEY_DATA = "EXTRA_SEND_MONEY_DATA";
    public static final String EXTRA_TRANSFER_SCENARIO = "EXTRA_TRANSFER_SCENARIO";
    public static final long INTERVAL_MILLISECOND_NUMBER_CHECKER = 300;
    public static final int MINIMUM_DIGIT_PREFIX_CHECK = 4;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private NickNameDialogFragment NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private WithdrawNameCheckModel moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private int PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private List<BillerX2B> GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private BankModel NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private SkeletonScreen getCallingPid;
    @Inject
    public BillerX2BContract.Presenter billerX2BPresenter;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private BillerX2BModel scheduleImpl;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;
    @Inject
    public BankSelectorContract.Presenter presenter;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticalTracker;
    public static final byte[] $$a = {71, Ascii.US, 113, 39, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 188;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {10, -99, -17, -84, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 6;
    private static long BottomSheetCardBindingView$watcherCardNumberView$1 = 5364105098156814456L;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda4 = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.bank.BankSelectorActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private CompositeDisposable NetworkUserEntityData$$ExternalSyntheticLambda0 = new CompositeDisposable();

    /* renamed from: readMicros  reason: from kotlin metadata */
    private ArrayList<String> FragmentBottomSheetPaymentSettingBinding = new ArrayList<>();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda8 = "";

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private BankCheckState KClassImpl$Data$declaredNonStaticMembers$2 = BankCheckState.INITIAL;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private BankSelectorConfigModel BuiltInFictitiousFunctionClassFactory = new BankSelectorConfigModel();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<Observable<CharSequence>>() { // from class: id.dana.bank.BankSelectorActivity$bankNumberTextChangesObservable$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Observable<CharSequence> invoke() {
            ActivityAddBankBinding binding;
            binding = BankSelectorActivity.this.getBinding();
            return RxTextView.textChanges(binding.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory).skipInitialValue().debounce(300L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult());
        }
    });

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new BankSelectorActivity$bankSelectedChangeObservable$2(this));

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<BankSelectorModule>() { // from class: id.dana.bank.BankSelectorActivity$bankSelectorModule$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BankSelectorModule invoke() {
            final BankSelectorActivity bankSelectorActivity = BankSelectorActivity.this;
            return new BankSelectorModule(new BankSelectorContract.View() { // from class: id.dana.bank.BankSelectorActivity$bankSelectorModule$2.1
                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void PlaceComponentResult(BankSelectorConfigModel p0) {
                    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Intrinsics.checkNotNullParameter(p0, "");
                    BankSelectorActivity.access$setBankSelectorConfigModel(BankSelectorActivity.this, p0);
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = BankSelectorActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    if (!NetworkUserEntityData$$ExternalSyntheticLambda0) {
                        BankSelectorActivity.this.PlaceComponentResult(p0.BuiltInFictitiousFunctionClassFactory);
                    } else {
                        BankSelectorActivity.access$initPreFilledData(BankSelectorActivity.this);
                    }
                    BankSelectorActivity.this.getPresenter().MyBillsEntityDataFactory(p0);
                    BankSelectorActivity.access$openBankListActivity(BankSelectorActivity.this);
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    BankSelectorActivity.this.BuiltInFictitiousFunctionClassFactory(true);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    ActivityAddBankBinding binding;
                    BankSelectorActivity.this.BuiltInFictitiousFunctionClassFactory(false);
                    BankSelectorActivity bankSelectorActivity2 = BankSelectorActivity.this;
                    binding = bankSelectorActivity2.getBinding();
                    ConstraintLayout constraintLayout = binding.MyBillsEntityDataFactory.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    BankSelectorActivity.access$showSkeleton(bankSelectorActivity2, constraintLayout);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                    BankSelectorActivity.access$hideSkeleton(BankSelectorActivity.this);
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void PlaceComponentResult(WithdrawNameCheckModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    BankSelectorActivity.access$onNameCheck(BankSelectorActivity.this, p0);
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                    boolean z;
                    ActivityAddBankBinding binding;
                    boolean z2;
                    boolean z3;
                    ActivityAddBankBinding binding2;
                    ActivityAddBankBinding binding3;
                    if (p0) {
                        BankSelectorActivity bankSelectorActivity2 = BankSelectorActivity.this;
                        String string = bankSelectorActivity2.getString(R.string.request_money_add_bank_name_check_limit_error);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        BankSelectorActivity.access$onNameCheckError(bankSelectorActivity2, string);
                        binding3 = BankSelectorActivity.this.getBinding();
                        binding3.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8.setVisibility(8);
                    }
                    BankSelectorActivity.access$setNameCheckFreeze(BankSelectorActivity.this, p0);
                    z = BankSelectorActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (z) {
                        z2 = BankSelectorActivity.this.initRecordTimeStamp;
                        if (z2) {
                            z3 = BankSelectorActivity.this.DatabaseTableConfigUtil;
                            if (!z3) {
                                BankSelectorActivity.this.scheduleImpl();
                                binding2 = BankSelectorActivity.this.getBinding();
                                binding2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8.setVisibility(0);
                                return;
                            }
                        }
                    }
                    binding = BankSelectorActivity.this.getBinding();
                    binding.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8.setVisibility(8);
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void BuiltInFictitiousFunctionClassFactory(WithdrawNameCheckModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    BankSelectorActivity bankSelectorActivity2 = BankSelectorActivity.this;
                    String string = bankSelectorActivity2.getString(R.string.request_money_add_bank_exist_error);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    BankSelectorActivity.access$onNameCheckError(bankSelectorActivity2, string);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    BankSelectorActivity bankSelectorActivity2 = BankSelectorActivity.this;
                    if (p0 == null) {
                        p0 = "";
                    }
                    BankSelectorActivity.access$onNameCheckError(bankSelectorActivity2, p0);
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                    BankSelectorActivity.this.PrepareContext = p0;
                    BankSelectorActivity.this.getSendMoneyAnalyticalTracker().PlaceComponentResult(p0);
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void MyBillsEntityDataFactory(Throwable p0, String p1, String p2) {
                    String str = "";
                    Intrinsics.checkNotNullParameter(p1, "");
                    Intrinsics.checkNotNullParameter(p2, "");
                    Intent intent = BankSelectorActivity.this.getIntent();
                    if (intent != null) {
                        BankSelectorActivity bankSelectorActivity2 = BankSelectorActivity.this;
                        String stringExtra = intent.getStringExtra("source");
                        if (stringExtra != null) {
                            int hashCode = stringExtra.hashCode();
                            if (hashCode != 706215855) {
                                if (hashCode == 982264360 && stringExtra.equals("Send Money")) {
                                    str = TrackerDataKey.Source.SEND_MONEY_ADD_NEW_BANK;
                                }
                            } else if (stringExtra.equals("Request Money")) {
                                str = TrackerDataKey.Source.REQUEST_MONEY_ADD_NEW_BANK;
                            }
                            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(bankSelectorActivity2, p1, p2, str, p0);
                        }
                    }
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void getAuthRequestContext() {
                    SendMoneyFeatureTime access$getSendMoneyFeatureTime = BankSelectorActivity.access$getSendMoneyFeatureTime(BankSelectorActivity.this);
                    access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void MyBillsEntityDataFactory() {
                    SendMoneyFeatureTime access$getSendMoneyFeatureTime = BankSelectorActivity.access$getSendMoneyFeatureTime(BankSelectorActivity.this);
                    access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = false;
                }

                @Override // id.dana.bank.contract.BankSelectorContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    SendMoneyFeatureTime access$getSendMoneyFeatureTime = BankSelectorActivity.access$getSendMoneyFeatureTime(BankSelectorActivity.this);
                    access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
                    long KClassImpl$Data$declaredNonStaticMembers$22 = access$getSendMoneyFeatureTime.KClassImpl$Data$declaredNonStaticMembers$2();
                    Intrinsics.checkNotNullParameter("NAMECHECK ON ADD NEW BANK", "");
                    access$getSendMoneyFeatureTime.getAuthRequestContext.put("NAMECHECK ON ADD NEW BANK", Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22));
                }
            });
        }
    });

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<BillerX2BModule>() { // from class: id.dana.bank.BankSelectorActivity$billerX2BModule$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BillerX2BModule invoke() {
            final BankSelectorActivity bankSelectorActivity = BankSelectorActivity.this;
            return new BillerX2BModule(new BillerX2BContract.View() { // from class: id.dana.bank.BankSelectorActivity$billerX2BModule$2.1
                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(BillerX2BModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void PlaceComponentResult(BaseRecipientModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void PlaceComponentResult(boolean p0) {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void getAuthRequestContext(BaseRecipientModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
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

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if ((!StringsKt.isBlank(p0)) == true) {
                        DanaH5.startContainerFullUrl(p0);
                        BankSelectorActivity.this.finish();
                    }
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void getAuthRequestContext(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    BankSelectorActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2();
                }

                @Override // id.dana.contract.sendmoney.v2.BillerX2BContract.View
                public final void BuiltInFictitiousFunctionClassFactory(List<BillerX2B> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    BankSelectorActivity.this.GetContactSyncConfig = p0;
                }
            });
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2 = {"Lid/dana/bank/BankSelectorActivity$BankCheckState;", "", "<init>", "(Ljava/lang/String;I)V", UserInfoResponseConstant.LoginStatus.INITIAL, "VALID", "CHECKING", "ERROR"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum BankCheckState {
        INITIAL,
        VALID,
        CHECKING,
        ERROR
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0027 -> B:35:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 16
            int r7 = 106 - r7
            byte[] r0 = id.dana.bank.BankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.BankSelectorActivity.b(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002b -> B:35:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = 46 - r9
            byte[] r0 = id.dana.bank.BankSelectorActivity.$$a
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L35
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1c:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L35:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.BankSelectorActivity.c(byte, int, short, java.lang.Object[]):void");
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
        a(57347 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{24922, 33110, 41305, 49472, 57688, 349, 8525, 16640, 24908, 33107, 41227, 49482, 57709, 371, 8562, 16755, 24952, 33147}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(62939 - (Process.myTid() >> 22), new char[]{24918, 38041, 35544, 32963, 46643}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 22072, new char[]{24844, 14177, 52607, 25512, 14831, 52802, 25684, 14988, 53444, 26975, 16226, 54574, 27634, 492, 54804, 27738, 666, 55491, 28943, 1889, 56619, 29685, 2494, 56850, 29703, 2713, 41161, 31068, 3893, 42282, 31732, 4537, 42530, 31828, 4763, 43209, 16729, 5951, 44405, 17316, 6628, 44668, 17493, 6814, 45205, 18701, 7987, 46377}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(48156 - Process.getGidForName(""), new char[]{24922, 56595, 6455, 21768, 37161, 52627, 2469, 17864, 33207, 64605, 14368, 29745, 45059, 60531, 10396, 25788, 41177, 7396, 23383, 38701, 54043, 3947, 19315, 34707, 50101, 16268, 31728, 46673, 61999, 11798, 27247, 42634, 58104, 24290, 39637, 55028, 5452, 20841, 36165, 51555, 1414, 16814, 48540, 63957, 13732, 28693, 44092, 59487, 9336, 24709, 56486, 6341, 21734, 37645, 53013, 2865, 18259, 33663, 65482, 15350, 30662, 46058, 61017, 10795}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(23663 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{24841, 15717, 55680, 29716, 4286, 44839, 19347, 58886, 33403, 24292, 64853, 39375, 13374, 53419, 28441, 2957, 42922, 16897, 7873, 48482, 22949, 62530, 37072, 11505, 52068, 26506, 580, 57014, 32121, 6606, 46094, 20521, 60652, 35600, 10167, 49710, 40645, 15623, 55671, 30186, 4187, 44186, 19260, 59306, 33303, 24200, 64168, 39224, 13709, 53309, 27894, 2883, 42885, 17393, 7735, 47831, 22852, 62905, 36900, 11416, 52057, 26493, 1004, 56915}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(53849 - View.resolveSize(0, 0), new char[]{24915, 45846, 50685, 5696, 10284, 31420, 36610, 41339, 62359, 1147, 22063, 26761, 48441, 53194, 57741, 12926, 17614, 38579, 43789, 64963, 4014, 8197, 29417, 34026, 55556, 60415, 15440, 20010, 24803, 46429, 50980, 6537, 10874, 31792, 36492, 41790, 62940, 1929, 22624, 27291, 48306, 53514, 58312, 13799, 17950, 39152, 43682, 65289, 4600, 8774, 29814, 34550, 56093, 60793, 16280, 20562, 25126, 46212, 51557, 7115}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(19301 - View.resolveSizeAndState(0, 0, 0), new char[]{24834, 10864, 63429, 33594, 19613, 6643}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, 18 - KeyEvent.getDeadChar(0, 0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr13 = new Object[1];
                b((byte) (PlaceComponentResult | 8), b, b, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr14 = new Object[1];
                b(b2, b3, (byte) (b3 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Color.red(0), 2 - Process.getGidForName(""), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
                        byte b4 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        c(b4, b4, (byte) (-$$a[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 800, 15 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 800, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 14, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 815, 28 - TextUtils.lastIndexOf("", '0', 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 800, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) (ViewConfiguration.getTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getTrimmedLength("") + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-2135046580, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - ExpandableListView.getPackedPositionType(0L), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (PlaceComponentResult | 8);
                byte b6 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr20 = new Object[1];
                b(b5, b6, b6, objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                byte b8 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr21 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getOffsetBefore("", 0), TextUtils.getOffsetBefore("", 0) + 46, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1));
                        Object[] objArr23 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[9]), $$a[20], objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {-2135046580, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (PlaceComponentResult | 8);
                byte b10 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr27 = new Object[1];
                b(b9, b10, b10, objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b11 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                byte b12 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr28 = new Object[1];
                b(b11, b12, (byte) (b12 - 1), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16777098) - Color.rgb(0, 0, 0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 3, (char) (Color.rgb(0, 0, 0) + 16816184));
                        Object[] objArr30 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[9]), $$a[20], objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {-2135046580, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = (byte) (PlaceComponentResult | 8);
                byte b14 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr34 = new Object[1];
                b(b13, b14, b14, objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b15 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                byte b16 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr35 = new Object[1];
                b(b15, b16, (byte) (b16 - 1), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - TextUtils.indexOf((CharSequence) "", '0'), 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        byte b17 = (byte) (-$$a[8]);
                        byte b18 = (byte) ($$a[47] - 1);
                        Object[] objArr37 = new Object[1];
                        c(b17, b18, b18, objArr37);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), ImageFormat.getBitsPerPixel(0) + 36, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {-2135046580, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), 18 - KeyEvent.keyCodeFromString(""), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().length() + 27802, new char[]{24922, 3572, 47133, 9386, 54224, 32375, 60057, 39282, 1106, 45282, 24321, 52222, 30454, 58741, 37249, 15421, 43869, 22499, 49693, 28337, 7675, 34918, 13471, 41769, 20034, 64230}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(1753 - View.resolveSize(0, 0), new char[]{24920, 26519, 27899, 30146, 31290, 17256, 18521, 20117, 22403, 23786, 9517, 10753, 13172, 14431, 16017, 2021, 3268, 5436}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, ExpandableListView.getPackedPositionGroup(0L) + 35, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.exit_confirmation_dialog_content).substring(4, 5).codePointAt(0) + 27777, new char[]{24922, 3572, 47133, 9386, 54224, 32375, 60057, 39282, 1106, 45282, 24321, 52222, 30454, 58741, 37249, 15421, 43869, 22499, 49693, 28337, 7675, 34918, 13471, 41769, 20034, 64230}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1752, new char[]{24920, 26519, 27899, 30146, 31290, 17256, 18521, 20117, 22403, 23786, 9517, 10753, 13172, 14431, 16017, 2021, 3268, 5436}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public BankSelectorActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.bank.BankSelectorActivity$$ExternalSyntheticLambda7
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BankSelectorActivity.$r8$lambda$jTpyQto7LtQi6dtOS7HqU5FYjZ0(BankSelectorActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = registerForActivityResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityAddBankBinding inflateViewBinding() {
        ActivityAddBankBinding BuiltInFictitiousFunctionClassFactory = ActivityAddBankBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "getPresenter")
    public final BankSelectorContract.Presenter getPresenter() {
        BankSelectorContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(BankSelectorContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getBillerX2BPresenter")
    public final BillerX2BContract.Presenter getBillerX2BPresenter() {
        BillerX2BContract.Presenter presenter = this.billerX2BPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBillerX2BPresenter")
    public final void setBillerX2BPresenter(BillerX2BContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.billerX2BPresenter = presenter;
    }

    @JvmName(name = "getSendMoneyAnalyticalTracker")
    public final SendMoneyAnalyticTracker getSendMoneyAnalyticalTracker() {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticalTracker;
        if (sendMoneyAnalyticTracker != null) {
            return sendMoneyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyAnalyticalTracker")
    public final void setSendMoneyAnalyticalTracker(SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(sendMoneyAnalyticTracker, "");
        this.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() && !BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(BankModel bankModel) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = bankModel;
        String str = bankModel != null ? bankModel.scheduleImpl : null;
        if (str == null) {
            str = "";
        }
        getBinding().MyBillsEntityDataFactory.GetContactSyncConfig.setText(str);
        final DanaTextBoxView danaTextBoxView = getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        danaTextBoxView.post(new Runnable() { // from class: id.dana.bank.BankSelectorActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BankSelectorActivity.$r8$lambda$Nv5utC4bMwkNPAlcqjAbBcuAZPw(DanaTextBoxView.this);
            }
        });
        danaTextBoxView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.bank.BankSelectorActivity$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean PlaceComponentResult2;
                PlaceComponentResult2 = BankSelectorActivity.PlaceComponentResult(BankSelectorActivity.this, danaTextBoxView, i);
                return PlaceComponentResult2;
            }
        });
        getErrorConfigVersion();
        Group group = getBinding().MyBillsEntityDataFactory.newProxyInstance;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(8);
    }

    public static final boolean PlaceComponentResult(BankSelectorActivity bankSelectorActivity, DanaTextBoxView danaTextBoxView, int i) {
        Intrinsics.checkNotNullParameter(bankSelectorActivity, "");
        Intrinsics.checkNotNullParameter(danaTextBoxView, "");
        if (i == 6) {
            bankSelectorActivity.getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.clearFocus();
            ActivityExtKt.MyBillsEntityDataFactory(bankSelectorActivity, danaTextBoxView);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0038 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        /*
            r4 = this;
            android.content.Intent r0 = r4.getIntent()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L39
            java.lang.String r3 = "bank_id"
            java.lang.String r3 = r0.getStringExtra(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L1a
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 != 0) goto L1a
            r3 = 0
            goto L1b
        L1a:
            r3 = 1
        L1b:
            if (r3 == 0) goto L34
            java.lang.String r3 = "bank_number"
            java.lang.String r0 = r0.getStringExtra(r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L2f
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != 0) goto L2f
            r0 = 0
            goto L30
        L2f:
            r0 = 1
        L30:
            if (r0 == 0) goto L34
            r0 = 0
            goto L35
        L34:
            r0 = 1
        L35:
            if (r0 == r2) goto L38
            goto L39
        L38:
            r1 = 1
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.BankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda0():boolean");
    }

    private final void getAuthRequestContext(boolean p0, CharSequence p1) {
        boolean KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22, p1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$22;
        getPresenter().MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
        Group group = getBinding().MyBillsEntityDataFactory.newProxyInstance;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(8);
    }

    private final void MyBillsEntityDataFactory(boolean p0, CharSequence p1) {
        this.scheduleImpl = null;
        if (p0) {
            ArrayList arrayList = new ArrayList();
            List<BillerX2B> list = this.GetContactSyncConfig;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    String instId = ((BillerX2B) obj).getInstId();
                    BankModel bankModel = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    if (StringsKt.contains$default((CharSequence) instId, (CharSequence) String.valueOf(bankModel != null ? bankModel.lookAheadTest : null), false, 2, (Object) null)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList4.add(Boolean.valueOf(arrayList.add((BillerX2B) it.next())));
                }
            }
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (StringsKt.startsWith$default(StringsKt.replace$default(p1.toString(), "-", "", false, 4, (Object) null), ((BillerX2B) obj2).getPrefix(), false, 2, (Object) null)) {
                    arrayList5.add(obj2);
                }
            }
            ArrayList arrayList6 = arrayList5;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
            Iterator it2 = arrayList6.iterator();
            while (it2.hasNext()) {
                this.scheduleImpl = BillerX2BModelKt.MyBillsEntityDataFactory((BillerX2B) it2.next(), StringsKt.replace$default(p1.toString(), "-", "", false, 4, (Object) null));
                arrayList7.add(Unit.INSTANCE);
            }
        }
    }

    private final void GetContactSyncConfig() {
        PlaceComponentResult((!this.NetworkUserEntityData$$ExternalSyntheticLambda1 || this.KClassImpl$Data$declaredNonStaticMembers$2 == BankCheckState.CHECKING || this.DatabaseTableConfigUtil) ? false : true, this.KClassImpl$Data$declaredNonStaticMembers$2 == BankCheckState.CHECKING ? "" : getAuthRequestContext());
        LogoProgressView logoProgressView = getBinding().MyBillsEntityDataFactory.getErrorConfigVersion;
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2 == BankCheckState.CHECKING;
        Intrinsics.checkNotNullExpressionValue(logoProgressView, "");
        logoProgressView.setVisibility(z ? 0 : 8);
        if (z) {
            logoProgressView.startRefresh();
        } else {
            logoProgressView.stopRefresh();
        }
    }

    private final String getAuthRequestContext() {
        String string = this.scheduleImpl == null ? getString(R.string.sendmoney_save_continue) : getString(R.string.send_money_to_biller_button);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        BankModel PlaceComponentResult2 = PlaceComponentResult();
        if (PlaceComponentResult2 != null) {
            if (!moveToNextValue()) {
                Intent intent = new Intent();
                intent.putExtra(EXTRA_SELECTED_BANK, PlaceComponentResult2);
                setResult(-1, intent);
                finish();
                return;
            }
            RecipientModel KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2);
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
                BankCheckState bankCheckState = BankCheckState.INITIAL;
                if (bankCheckState != this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = bankCheckState;
                    GetContactSyncConfig();
                }
                MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22);
            }
            getSendMoneyAnalyticalTracker().KClassImpl$Data$declaredNonStaticMembers$2(true, "", this.PrepareContext);
            this.PrepareContext = 0;
        }
    }

    public final boolean moveToNextValue() {
        return getIntent().getBundleExtra(EXTRA_SEND_MONEY_DATA) != null;
    }

    private final RecipientModel KClassImpl$Data$declaredNonStaticMembers$2(BankModel bankModel) {
        RecipientModel.Builder builder = new RecipientModel.Builder("bank");
        builder.scheduleImpl = bankModel.lookAheadTest;
        builder.PrepareContext = RecipientIdType.INSTITUTION;
        builder.initRecordTimeStamp = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = bankModel.newProxyInstance;
        builder.GetContactSyncConfig = bankModel.getAuthRequestContext;
        builder.getErrorConfigVersion = bankModel.PlaceComponentResult();
        builder.lookAheadTest = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        builder.isLayoutRequested = bankModel.newProxyInstance;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        builder.DatabaseTableConfigUtil = bankModel.initRecordTimeStamp;
        builder.PlaceComponentResult = bankModel.newProxyInstance;
        builder.moveToNextValue = bankModel.getGetErrorConfigVersion();
        builder.newProxyInstance = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        return builder.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    private final void MyBillsEntityDataFactory(RecipientModel p0) {
        Intent intent = getIntent();
        ?? r3 = 0;
        Bundle bundleExtra = intent != null ? intent.getBundleExtra(EXTRA_SEND_MONEY_DATA) : null;
        if (bundleExtra != null) {
            if (!OSUtil.getErrorConfigVersion() && bundleExtra.getBoolean(EXTRA_BELOW_KITKAT)) {
                MaterialDialog.positiveButton$default(MaterialDialog.message$default(new MaterialDialog(this, r3, 2, r3), Integer.valueOf((int) R.string.dialog_warning_below_kitkat), null, null, 6, null), null, null, null, 7, null).cancelable(false).show();
                return;
            }
            p0.B = "send_money";
            Intent intentClassWithTracking = getIntentClassWithTracking(SummaryActivity.class);
            intentClassWithTracking.putExtra("data", p0);
            intentClassWithTracking.putExtra("transferScenario", bundleExtra.getString(EXTRA_TRANSFER_SCENARIO));
            intentClassWithTracking.putExtra("isNewNumber", true);
            startActivity(intentClassWithTracking);
        }
    }

    public final void getErrorConfigVersion() {
        if (lookAheadTest() && this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() && (!StringsKt.isBlank(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0)) != true) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                NickNameDialogFragment nickNameDialogFragment = new NickNameDialogFragment(new Function1<String, Unit>() { // from class: id.dana.bank.BankSelectorActivity$showSenderNameDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        BankSelectorConfigModel bankSelectorConfigModel;
                        Intrinsics.checkNotNullParameter(str, "");
                        bankSelectorConfigModel = BankSelectorActivity.this.BuiltInFictitiousFunctionClassFactory;
                        Intrinsics.checkNotNullParameter(str, "");
                        bankSelectorConfigModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }
                });
                nickNameDialogFragment.setCancelable(false);
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = nickNameDialogFragment;
            }
            NickNameDialogFragment nickNameDialogFragment2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (nickNameDialogFragment2 != null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                AndroidComponentUtilsKt.MyBillsEntityDataFactory(nickNameDialogFragment2, supportFragmentManager, null);
            }
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, CharSequence p1) {
        return p0 && MyBillsEntityDataFactory(StringsKt.replace$default(p1.toString(), "-", "", false, 4, (Object) null)) && BuiltInFictitiousFunctionClassFactory(p1);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(CharSequence p0) {
        return TextUtil.scheduleImpl(StringsKt.replace$default(p0.toString(), "-", "", false, 4, (Object) null)).length() > 4;
    }

    private static boolean MyBillsEntityDataFactory(CharSequence p0) {
        return Pattern.compile(BANK_NUMBER_REGEX).matcher(TextUtil.scheduleImpl(StringsKt.replace$default(p0.toString(), "-", "", false, 4, (Object) null))).matches();
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(p0 ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().MyBillsEntityDataFactory.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(p0 ^ true ? 0 : 8);
    }

    private final BankModel PlaceComponentResult() {
        BankModel bankModel = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        WithdrawNameCheckModel withdrawNameCheckModel = null;
        if (bankModel != null) {
            BankModel.Builder builder = new BankModel.Builder();
            String str = bankModel.lookAheadTest;
            if (str == null) {
                str = "";
            }
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            String str2 = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str2 == null) {
                str2 = "";
            }
            builder.initRecordTimeStamp = str2;
            String str3 = bankModel.initRecordTimeStamp;
            if (str3 == null) {
                str3 = "";
            }
            builder.DatabaseTableConfigUtil = str3;
            String str4 = bankModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str4 == null) {
                str4 = "";
            }
            builder.getErrorConfigVersion = str4;
            String MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = "";
            }
            builder.PlaceComponentResult = MyBillsEntityDataFactory;
            WithdrawNameCheckModel withdrawNameCheckModel2 = this.moveToNextValue;
            if (withdrawNameCheckModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                withdrawNameCheckModel2 = null;
            }
            String str5 = withdrawNameCheckModel2.MyBillsEntityDataFactory;
            if (str5 == null) {
                str5 = "";
            }
            if (str5 == null) {
                str5 = "";
            }
            builder.BuiltInFictitiousFunctionClassFactory = str5;
            WithdrawNameCheckModel withdrawNameCheckModel3 = this.moveToNextValue;
            if (withdrawNameCheckModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                withdrawNameCheckModel3 = null;
            }
            String str6 = withdrawNameCheckModel3.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str6 == null) {
                str6 = "";
            }
            if (str6 == null) {
                str6 = "";
            }
            builder.getAuthRequestContext = str6;
            WithdrawNameCheckModel withdrawNameCheckModel4 = this.moveToNextValue;
            if (withdrawNameCheckModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                withdrawNameCheckModel = withdrawNameCheckModel4;
            }
            String str7 = withdrawNameCheckModel.getAuthRequestContext;
            if (str7 == null) {
                str7 = "";
            }
            builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = str7 != null ? str7 : "";
            builder.scheduleImpl = bankModel.getGetErrorConfigVersion();
            return builder.BuiltInFictitiousFunctionClassFactory();
        }
        return null;
    }

    private final String MyBillsEntityDataFactory() {
        Editable text = getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null) {
            obj = "";
        }
        return StringsKt.replace$default(obj, "-", "", false, 4, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    private final void PlaceComponentResult(boolean p0, String p1) {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().MyBillsEntityDataFactory.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        ?? r3 = (!p0 || this.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) ? 0 : 1;
        danaButtonPrimaryView.setClickable(r3);
        danaButtonPrimaryView.setEnabled(r3);
        danaButtonPrimaryView.setDanaButtonView(r3, p1, null, null);
    }

    public final void scheduleImpl() {
        getBinding().MyBillsEntityDataFactory.initRecordTimeStamp.setText(String.valueOf(getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getText()));
        GlideRequests PlaceComponentResult2 = GlideApp.PlaceComponentResult(this);
        BankModel bankModel = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        String PlaceComponentResult3 = bankModel != null ? bankModel.PlaceComponentResult() : null;
        if (PlaceComponentResult3 == null) {
            PlaceComponentResult3 = "";
        }
        PlaceComponentResult2.PlaceComponentResult(PlaceComponentResult3).getErrorConfigVersion((int) R.drawable.ic_bank_placeholder).PlaceComponentResult((int) R.drawable.ic_bank_placeholder).SubSequence().MyBillsEntityDataFactory((ImageView) getBinding().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        getPresenter().onDestroy();
        getBillerX2BPresenter().onDestroy();
    }

    private final boolean lookAheadTest() {
        return (isFinishing() || isDestroyed()) ? false : true;
    }

    public final Intent getIntentClassWithTracking(Class<?> javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "");
        return getIntentClassWithTracking(javaClass, getSource());
    }

    public final Intent getIntentClassWithTracking(Class<?> javaClass, String source) {
        Intrinsics.checkNotNullParameter(javaClass, "");
        Intent intent = new Intent(this, javaClass);
        intent.putExtra("source", source);
        return intent;
    }

    public final String getSource() {
        return getSource(getIntent().getExtras());
    }

    public final String getSource(Bundle r2) {
        return r2 != null ? r2.getString("source") : "";
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/bank/BankSelectorActivity$Companion;", "", "", "BANK_NUMBER_REGEX", "Ljava/lang/String;", BankSelectorActivity.EXTRA_BELOW_KITKAT, "EXTRA_OPENED_FROM", BankSelectorActivity.EXTRA_SELECTED_BANK, BankSelectorActivity.EXTRA_SEND_MONEY_DATA, BankSelectorActivity.EXTRA_TRANSFER_SCENARIO, "", "INTERVAL_MILLISECOND_NUMBER_CHECKER", "J", "", "MINIMUM_DIGIT_PREFIX_CHECK", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Intent PlaceComponentResult(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle, ArrayList arrayList, boolean z4, String str3, int i) {
            if ((i & 2) != 0) {
                str = "";
            }
            if ((i & 4) != 0) {
                str2 = "";
            }
            if ((i & 8) != 0) {
                z = false;
            }
            if ((i & 16) != 0) {
                z2 = false;
            }
            if ((i & 32) != 0) {
                z3 = false;
            }
            if ((i & 64) != 0) {
                bundle = null;
            }
            if ((i & 128) != 0) {
                arrayList = null;
            }
            if ((i & 256) != 0) {
                z4 = false;
            }
            if ((i & 512) != 0) {
                str3 = "";
            }
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intent intent = new Intent(context, BankSelectorActivity.class);
            intent.putExtra(FeatureParams.BANK_ID, str);
            intent.putExtra("bank_number", str2);
            intent.putExtra("EXTRA_SHOW_BANK_INFO", z);
            intent.putExtra("EXTRA_SAVED_BANK_QR_CHECK", z2);
            intent.putExtra("LOAD_DEFAULT_FROM_RECENT", z3);
            intent.putExtra(BankSelectorActivity.EXTRA_SEND_MONEY_DATA, bundle);
            intent.putExtra("EXTRA_NOT_RECENT_BANK_SMART_FRICTION", z4);
            intent.putExtra("source", str3);
            intent.putStringArrayListExtra("EXTRA_SAVED_BANK_NUMBER", arrayList);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$9RZhbpf5wnL3Q3c6W8rzDBm4M8o(BankSelectorActivity bankSelectorActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(bankSelectorActivity, "");
        if (-1 == i) {
            BillerX2BModel billerX2BModel = bankSelectorActivity.scheduleImpl;
            if (billerX2BModel != null) {
                BankCheckState bankCheckState = BankCheckState.CHECKING;
                if (bankCheckState != bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
                    bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2 = bankCheckState;
                    bankSelectorActivity.GetContactSyncConfig();
                }
                bankSelectorActivity.getBillerX2BPresenter().KClassImpl$Data$declaredNonStaticMembers$2(billerX2BModel);
            }
            dialogInterface.dismiss();
        }
    }

    public static /* synthetic */ void $r8$lambda$Nv5utC4bMwkNPAlcqjAbBcuAZPw(DanaTextBoxView danaTextBoxView) {
        Intrinsics.checkNotNullParameter(danaTextBoxView, "");
        InputExtKt.PlaceComponentResult(danaTextBoxView);
    }

    /* renamed from: $r8$lambda$WFsQ_6rV9re9qeruzP-0f2JIdqw */
    public static /* synthetic */ void m417$r8$lambda$WFsQ_6rV9re9qeruzP0f2JIdqw(BankSelectorActivity bankSelectorActivity, View view) {
        Intrinsics.checkNotNullParameter(bankSelectorActivity, "");
        bankSelectorActivity.finish();
    }

    /* renamed from: $r8$lambda$Z9cEch8SFvx27mtaB2E-0s1Gnjk */
    public static /* synthetic */ Pair m418$r8$lambda$Z9cEch8SFvx27mtaB2E0s1Gnjk(Boolean bool, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        return new Pair(bool, charSequence);
    }

    public static /* synthetic */ void $r8$lambda$jTpyQto7LtQi6dtOS7HqU5FYjZ0(BankSelectorActivity bankSelectorActivity, ActivityResult activityResult) {
        Intent intent;
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(bankSelectorActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory != -1 || (intent = activityResult.MyBillsEntityDataFactory) == null) {
            return;
        }
        id.dana.core.ui.util.OSUtil oSUtil = id.dana.core.ui.util.OSUtil.INSTANCE;
        if (id.dana.core.ui.util.OSUtil.PlaceComponentResult()) {
            parcelable = (Parcelable) intent.getParcelableExtra("data", BankModel.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("data");
            if (!(parcelableExtra instanceof BankModel)) {
                parcelableExtra = null;
            }
            parcelable = (BankModel) parcelableExtra;
        }
        BankModel bankModel = (BankModel) parcelable;
        if (bankModel != null) {
            bankSelectorActivity.PlaceComponentResult(bankModel);
        }
    }

    /* renamed from: $r8$lambda$k6vuVtEHjPBLYEhXPHLRqE5-SFc */
    public static /* synthetic */ void m420$r8$lambda$k6vuVtEHjPBLYEhXPHLRqE5SFc(LayoutAddBankBinding layoutAddBankBinding, BankSelectorActivity bankSelectorActivity, View view, boolean z) {
        Intrinsics.checkNotNullParameter(layoutAddBankBinding, "");
        Intrinsics.checkNotNullParameter(bankSelectorActivity, "");
        if (z) {
            layoutAddBankBinding.NetworkUserEntityData$$ExternalSyntheticLambda7.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(bankSelectorActivity, R.color.f27152131100507));
            return;
        }
        layoutAddBankBinding.NetworkUserEntityData$$ExternalSyntheticLambda7.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(bankSelectorActivity, R.color.f23982131099995));
        layoutAddBankBinding.BuiltInFictitiousFunctionClassFactory.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* renamed from: $r8$lambda$radZpc-pIDIYv1Kx10KbZarWRmM */
    public static /* synthetic */ void m421$r8$lambda$radZpcpIDIYv1Kx10KbZarWRmM(BankSelectorActivity bankSelectorActivity, Pair pair) {
        Intrinsics.checkNotNullParameter(bankSelectorActivity, "");
        bankSelectorActivity.getAuthRequestContext(((Boolean) pair.getFirst()).booleanValue(), (CharSequence) pair.getSecond());
    }

    public static final /* synthetic */ void access$doNameCheck(BankSelectorActivity bankSelectorActivity) {
        BankModel bankModel;
        BankCheckState bankCheckState = BankCheckState.CHECKING;
        if (bankCheckState != bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
            bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2 = bankCheckState;
            bankSelectorActivity.GetContactSyncConfig();
        }
        Group group = bankSelectorActivity.getBinding().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(8);
        String MyBillsEntityDataFactory = bankSelectorActivity.MyBillsEntityDataFactory();
        BankModel bankModel2 = bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (bankModel2 != null) {
            BankModel.Builder builder = new BankModel.Builder();
            String str = bankModel2.lookAheadTest;
            if (str == null) {
                str = "";
            }
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            String replace$default = StringsKt.replace$default(MyBillsEntityDataFactory.toString(), "-", "", false, 4, (Object) null);
            if (replace$default == null) {
                replace$default = "";
            }
            builder.PlaceComponentResult = replace$default;
            String str2 = bankModel2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str2 == null) {
                str2 = "";
            }
            builder.getErrorConfigVersion = str2;
            String str3 = bankModel2.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str3 == null) {
                str3 = "";
            }
            builder.initRecordTimeStamp = str3;
            String str4 = bankModel2.initRecordTimeStamp;
            if (str4 == null) {
                str4 = "";
            }
            builder.DatabaseTableConfigUtil = str4;
            String str5 = bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = str5 != null ? str5 : "";
            builder.scheduleImpl = bankModel2.getGetErrorConfigVersion();
            bankModel = builder.BuiltInFictitiousFunctionClassFactory();
        } else {
            bankModel = null;
        }
        if (bankModel != null) {
            bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.lookAheadTest = bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda3;
            ((SendMoneyFeatureTime) bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            bankSelectorActivity.getPresenter().PlaceComponentResult(bankModel, bankSelectorActivity.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static final /* synthetic */ void access$getNameCheckConfig(BankSelectorActivity bankSelectorActivity) {
        ((SendMoneyFeatureTime) bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        bankSelectorActivity.getPresenter().MyBillsEntityDataFactory(bankSelectorActivity.newProxyInstance);
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(BankSelectorActivity bankSelectorActivity) {
        return (SendMoneyFeatureTime) bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
    }

    public static final /* synthetic */ void access$hideSkeleton(BankSelectorActivity bankSelectorActivity) {
        SkeletonScreen skeletonScreen = bankSelectorActivity.getCallingPid;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$initPreFilledData(BankSelectorActivity bankSelectorActivity) {
        Object obj;
        Intent intent = bankSelectorActivity.getIntent();
        String stringExtra = intent.getStringExtra(FeatureParams.BANK_ID);
        if (stringExtra != null) {
            Iterator<T> it = bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((BankModel) obj).lookAheadTest, stringExtra)) {
                    break;
                }
            }
            BankModel bankModel = (BankModel) obj;
            if (bankModel == null) {
                bankModel = bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            }
            bankSelectorActivity.PlaceComponentResult(bankModel);
            intent.removeExtra(FeatureParams.BANK_ID);
        }
        String stringExtra2 = intent.getStringExtra("bank_number");
        if (stringExtra2 != null) {
            bankSelectorActivity.getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.setText(stringExtra2);
            intent.removeExtra("bank_number");
        }
        bankSelectorActivity.getAuthRequestContext(bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda6 != null, String.valueOf(bankSelectorActivity.getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getText()));
    }

    public static final /* synthetic */ void access$onNameCheck(BankSelectorActivity bankSelectorActivity, WithdrawNameCheckModel withdrawNameCheckModel) {
        bankSelectorActivity.moveToNextValue = withdrawNameCheckModel;
        if ((!bankSelectorActivity.FragmentBottomSheetPaymentSettingBinding.isEmpty()) != false && bankSelectorActivity.initRecordTimeStamp) {
            if (bankSelectorActivity.FragmentBottomSheetPaymentSettingBinding.contains(withdrawNameCheckModel.KClassImpl$Data$declaredNonStaticMembers$2)) {
                if (!bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda5) {
                    bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda2();
                } else {
                    if (bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory()) {
                        bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = false;
                    }
                    bankSelectorActivity.scheduleImpl();
                    ActivityExtKt.MyBillsEntityDataFactory(bankSelectorActivity, bankSelectorActivity.getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
                }
                BankCheckState bankCheckState = BankCheckState.VALID;
                if (bankCheckState != bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
                    bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2 = bankCheckState;
                    bankSelectorActivity.GetContactSyncConfig();
                    return;
                }
                return;
            }
            if (!bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda5) {
                bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda2();
            } else {
                if (bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory()) {
                    bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = false;
                }
                bankSelectorActivity.scheduleImpl();
                ActivityExtKt.MyBillsEntityDataFactory(bankSelectorActivity, bankSelectorActivity.getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
            }
            BankCheckState bankCheckState2 = BankCheckState.VALID;
            if (bankCheckState2 != bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
                bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2 = bankCheckState2;
                bankSelectorActivity.GetContactSyncConfig();
            }
            BankCheckState bankCheckState3 = BankCheckState.INITIAL;
            if (bankCheckState3 != bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
                bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2 = bankCheckState3;
                bankSelectorActivity.GetContactSyncConfig();
                return;
            }
            return;
        }
        if (!bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda5) {
            bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda2();
        } else {
            if (bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory()) {
                bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = false;
            }
            bankSelectorActivity.scheduleImpl();
            ActivityExtKt.MyBillsEntityDataFactory(bankSelectorActivity, bankSelectorActivity.getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
        }
        BankCheckState bankCheckState4 = BankCheckState.VALID;
        if (bankCheckState4 != bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
            bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2 = bankCheckState4;
            bankSelectorActivity.GetContactSyncConfig();
        }
    }

    public static final /* synthetic */ void access$onNameCheckError(BankSelectorActivity bankSelectorActivity, String str) {
        BankCheckState bankCheckState = BankCheckState.ERROR;
        if (bankCheckState != bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
            bankSelectorActivity.KClassImpl$Data$declaredNonStaticMembers$2 = bankCheckState;
            bankSelectorActivity.GetContactSyncConfig();
        }
        LayoutAddBankBinding layoutAddBankBinding = bankSelectorActivity.getBinding().MyBillsEntityDataFactory;
        layoutAddBankBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setText(str);
        Group group = layoutAddBankBinding.newProxyInstance;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(0);
        layoutAddBankBinding.NetworkUserEntityData$$ExternalSyntheticLambda8.setVisibility(8);
        BankSelectorActivity bankSelectorActivity2 = bankSelectorActivity;
        layoutAddBankBinding.NetworkUserEntityData$$ExternalSyntheticLambda7.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(bankSelectorActivity2, R.color.f26712131100373));
        layoutAddBankBinding.BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(bankSelectorActivity2, (int) R.drawable.bg_rounded_4dp_border_red50));
        bankSelectorActivity.getSendMoneyAnalyticalTracker().KClassImpl$Data$declaredNonStaticMembers$2(false, str, bankSelectorActivity.PrepareContext);
        bankSelectorActivity.PrepareContext = 0;
    }

    public static final /* synthetic */ void access$openBankListActivity(BankSelectorActivity bankSelectorActivity) {
        if (bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext()) {
            return;
        }
        Intent intent = new Intent(bankSelectorActivity, BottomSheetBankListActivity.class);
        intent.putExtra(BottomSheetBankListActivity.TRANSFER_INIT, bankSelectorActivity.BuiltInFictitiousFunctionClassFactory.moveToNextValue);
        bankSelectorActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory(intent, null);
    }

    public static final /* synthetic */ void access$setBankSelectorConfigModel(BankSelectorActivity bankSelectorActivity, BankSelectorConfigModel bankSelectorConfigModel) {
        bankSelectorActivity.BuiltInFictitiousFunctionClassFactory = bankSelectorConfigModel;
        bankSelectorActivity.BuiltInFictitiousFunctionClassFactory(false);
    }

    public static final /* synthetic */ void access$setNameCheckFreeze(BankSelectorActivity bankSelectorActivity, boolean z) {
        bankSelectorActivity.DatabaseTableConfigUtil = z;
        bankSelectorActivity.GetContactSyncConfig();
    }

    public static final /* synthetic */ void access$showSkeleton(BankSelectorActivity bankSelectorActivity, View view) {
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(view);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.layout_skeleton_add_user_bank;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        bankSelectorActivity.getCallingPid = viewSkeletonScreen;
    }

    public static final /* synthetic */ void access$updateBankNumberWithDash(BankSelectorActivity bankSelectorActivity, Editable editable) {
        String replace$default = StringsKt.replace$default(editable.toString(), "-", "", false, 4, (Object) null);
        LayoutAddBankBinding layoutAddBankBinding = bankSelectorActivity.getBinding().MyBillsEntityDataFactory;
        DanaTextBoxView danaTextBoxView = layoutAddBankBinding.BuiltInFictitiousFunctionClassFactory;
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        danaTextBoxView.setText(NumberUtil.moveToNextValue(replace$default));
        layoutAddBankBinding.BuiltInFictitiousFunctionClassFactory.setSelection(layoutAddBankBinding.BuiltInFictitiousFunctionClassFactory.length());
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().PlaceComponentResult;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.request_money_add_bank_account_title));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().PlaceComponentResult;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.arrow_left_white_new);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.bank.BankSelectorActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankSelectorActivity.m417$r8$lambda$WFsQ_6rV9re9qeruzP0f2JIdqw(BankSelectorActivity.this, view);
            }
        });
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(4);
        Toolbar toolbar = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2;
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
    public final void init() {
        CompositeDisposable compositeDisposable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Observable combineLatest = Observable.combineLatest((Observable) this.getAuthRequestContext.getValue(), (Observable) this.PlaceComponentResult.getValue(), new BiFunction() { // from class: id.dana.bank.BankSelectorActivity$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return BankSelectorActivity.m418$r8$lambda$Z9cEch8SFvx27mtaB2E0s1Gnjk((Boolean) obj, (CharSequence) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "");
        compositeDisposable.getAuthRequestContext(combineLatest.subscribe(new Consumer() { // from class: id.dana.bank.BankSelectorActivity$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BankSelectorActivity.m421$r8$lambda$radZpcpIDIYv1Kx10KbZarWRmM(BankSelectorActivity.this, (Pair) obj);
            }
        }));
        final LayoutAddBankBinding layoutAddBankBinding = getBinding().MyBillsEntityDataFactory;
        layoutAddBankBinding.BuiltInFictitiousFunctionClassFactory.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.bank.BankSelectorActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                BankSelectorActivity.m420$r8$lambda$k6vuVtEHjPBLYEhXPHLRqE5SFc(LayoutAddBankBinding.this, this, view, z);
            }
        });
        getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.addTextChangedListener(new TextWatcher() { // from class: id.dana.bank.BankSelectorActivity$setupOnTextChangeListener$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                boolean z;
                Intrinsics.checkNotNullParameter(p0, "");
                z = BankSelectorActivity.this.getErrorConfigVersion;
                if (z) {
                    return;
                }
                BankSelectorActivity.this.getErrorConfigVersion = true;
                BankSelectorActivity.access$updateBankNumberWithDash(BankSelectorActivity.this, p0);
                BankSelectorActivity.this.getErrorConfigVersion = false;
            }
        });
        long j = 0;
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        getBinding().MyBillsEntityDataFactory.GetContactSyncConfig.setOnClickListener(new ThrottledOnClickListener(j, new Function1<View, Unit>() { // from class: id.dana.bank.BankSelectorActivity$setupTvBankSelection$1
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
                BankSelectorActivity.access$openBankListActivity(BankSelectorActivity.this);
            }
        }, i, defaultConstructorMarker));
        final LayoutAddBankBinding layoutAddBankBinding2 = getBinding().MyBillsEntityDataFactory;
        layoutAddBankBinding2.getAuthRequestContext.setOnClickListener(new ThrottledOnClickListener(j, new Function1<View, Unit>() { // from class: id.dana.bank.BankSelectorActivity$setupBtnSubmit$1$1$1
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
                BillerX2BModel billerX2BModel;
                boolean BuiltInFictitiousFunctionClassFactory;
                BankSelectorActivity.BankCheckState bankCheckState;
                boolean moveToNextValue;
                Intrinsics.checkNotNullParameter(view, "");
                LayoutAddBankBinding.this.BuiltInFictitiousFunctionClassFactory.clearFocus();
                billerX2BModel = this.scheduleImpl;
                if (billerX2BModel == null) {
                    BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory();
                    if (BuiltInFictitiousFunctionClassFactory) {
                        this.getErrorConfigVersion();
                        return;
                    }
                    bankCheckState = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (bankCheckState == BankSelectorActivity.BankCheckState.VALID) {
                        moveToNextValue = this.moveToNextValue();
                        if (!moveToNextValue) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda2();
                            return;
                        }
                    }
                    BankSelectorActivity.access$doNameCheck(this);
                    return;
                }
                new BillerX2BDialog(r2, new DialogInterface.OnClickListener() { // from class: id.dana.bank.BankSelectorActivity$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        BankSelectorActivity.$r8$lambda$9RZhbpf5wnL3Q3c6W8rzDBm4M8o(BankSelectorActivity.this, dialogInterface, i2);
                    }
                }).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, i, defaultConstructorMarker));
        getBinding().getAuthRequestContext.PlaceComponentResult.setOnClickListener(new ThrottledOnClickListener(j, new Function1<View, Unit>() { // from class: id.dana.bank.BankSelectorActivity$setupRetryBtn$1
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
                BankSelectorActivity.access$getNameCheckConfig(BankSelectorActivity.this);
            }
        }, i, defaultConstructorMarker));
        Intent intent = getIntent();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = intent.getBooleanExtra("EXTRA_SHOW_BANK_INFO", false);
        intent.removeExtra("EXTRA_SHOW_BANK_INFO");
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = intent.getBooleanExtra("EXTRA_SAVED_BANK_QR_CHECK", false);
        intent.removeExtra("EXTRA_SAVED_BANK_QR_CHECK");
        this.newProxyInstance = intent.getBooleanExtra("LOAD_DEFAULT_FROM_RECENT", false);
        intent.removeExtra("LOAD_DEFAULT_FROM_RECENT");
        ArrayList<String> arrayList = this.FragmentBottomSheetPaymentSettingBinding;
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("EXTRA_SAVED_BANK_NUMBER");
        if (stringArrayListExtra == null) {
            stringArrayListExtra = CollectionsKt.emptyList();
        }
        arrayList.addAll(stringArrayListExtra);
        this.initRecordTimeStamp = getIntent().getBooleanExtra("EXTRA_NOT_RECENT_BANK_SMART_FRICTION", false);
        Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_SEND_MONEY_DATA);
        String string = bundleExtra != null ? bundleExtra.getString(EXTRA_OPENED_FROM) : null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = string != null ? string : "";
        DaggerAddBankAccountComponent.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DaggerAddBankAccountComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = (BankSelectorModule) Preconditions.getAuthRequestContext((BankSelectorModule) this.MyBillsEntityDataFactory.getValue());
        KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult = (BillerX2BModule) Preconditions.getAuthRequestContext((BillerX2BModule) this.lookAheadTest.getValue());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext, BankSelectorModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult, BillerX2BModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory == null) {
            KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerAddBankAccountComponent.AddBankAccountComponentImpl(KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        ((SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        getPresenter().MyBillsEntityDataFactory(this.newProxyInstance);
        getBillerX2BPresenter().PlaceComponentResult();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.bank.BankSelectorActivity$setOnBankListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = BankSelectorActivity.access$getSendMoneyFeatureTime(BankSelectorActivity.this);
                Intrinsics.checkNotNullParameter("OPEN ADD NEW BANK PAGE", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN ADD NEW BANK PAGE");
                Intrinsics.checkNotNullParameter("NAMECHECK ON ADD NEW BANK", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("NAMECHECK ON ADD NEW BANK");
                BankSelectorActivity.this.finish();
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(getPackageName().codePointAt(0) + 57242, new char[]{24922, 33110, 41305, 49472, 57688, 349, 8525, 16640, 24908, 33107, 41227, 49482, 57709, 371, 8562, 16755, 24952, 33147}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(getPackageName().length() + 62932, new char[]{24918, 38041, 35544, 32963, 46643}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(getPackageName().codePointAt(3) + 27709, new char[]{24922, 3572, 47133, 9386, 54224, 32375, 60057, 39282, 1106, 45282, 24321, 52222, 30454, 58741, 37249, 15421, 43869, 22499, 49693, 28337, 7675, 34918, 13471, 41769, 20034, 64230}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a((KeyEvent.getMaxKeyCode() >> 16) + 1753, new char[]{24920, 26519, 27899, 30146, 31290, 17256, 18521, 20117, 22403, 23786, 9517, 10753, 13172, 14431, 16017, 2021, 3268, 5436}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 35 - TextUtils.getOffsetBefore("", 0), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.voucher_and_ticket_expired_empty_state_desc).substring(1, 3).codePointAt(0) + 21962, new char[]{24844, 14177, 52607, 25512, 14831, 52802, 25684, 14988, 53444, 26975, 16226, 54574, 27634, 492, 54804, 27738, 666, 55491, 28943, 1889, 56619, 29685, 2494, 56850, 29703, 2713, 41161, 31068, 3893, 42282, 31732, 4537, 42530, 31828, 4763, 43209, 16729, 5951, 44405, 17316, 6628, 44668, 17493, 6814, 45205, 18701, 7987, 46377}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(R.string.split_bill_non_payer_title).substring(15, 16).length() + 48156, new char[]{24922, 56595, 6455, 21768, 37161, 52627, 2469, 17864, 33207, 64605, 14368, 29745, 45059, 60531, 10396, 25788, 41177, 7396, 23383, 38701, 54043, 3947, 19315, 34707, 50101, 16268, 31728, 46673, 61999, 11798, 27247, 42634, 58104, 24290, 39637, 55028, 5452, 20841, 36165, 51555, 1414, 16814, 48540, 63957, 13732, 28693, 44092, 59487, 9336, 24709, 56486, 6341, 21734, 37645, 53013, 2865, 18259, 33663, 65482, 15350, 30662, 46058, 61017, 10795}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(ExpandableListView.getPackedPositionChild(0L) + 23664, new char[]{24841, 15717, 55680, 29716, 4286, 44839, 19347, 58886, 33403, 24292, 64853, 39375, 13374, 53419, 28441, 2957, 42922, 16897, 7873, 48482, 22949, 62530, 37072, 11505, 52068, 26506, 580, 57014, 32121, 6606, 46094, 20521, 60652, 35600, 10167, 49710, 40645, 15623, 55671, 30186, 4187, 44186, 19260, 59306, 33303, 24200, 64168, 39224, 13709, 53309, 27894, 2883, 42885, 17393, 7735, 47831, 22852, 62905, 36900, 11416, 52057, 26493, 1004, 56915}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(53849 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{24915, 45846, 50685, 5696, 10284, 31420, 36610, 41339, 62359, 1147, 22063, 26761, 48441, 53194, 57741, 12926, 17614, 38579, 43789, 64963, 4014, 8197, 29417, 34026, 55556, 60415, 15440, 20010, 24803, 46429, 50980, 6537, 10874, 31792, 36492, 41790, 62940, 1929, 22624, 27291, 48306, 53514, 58312, 13799, 17950, 39152, 43682, 65289, 4600, 8774, 29814, 34550, 56093, 60793, 16280, 20562, 25126, 46212, 51557, 7115}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(super.getResources().getString(R.string.force_face_auth_content).substring(17, 18).codePointAt(0) + 19196, new char[]{24834, 10864, 63429, 33594, 19613, 6643}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = (byte) (PlaceComponentResult | 8);
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            Object[] objArr12 = new Object[1];
            b(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr13 = new Object[1];
            b(b3, b4, (byte) (b4 - 1), objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 494, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 4, (char) Color.alpha(0));
                    byte b5 = (byte) (-$$a[8]);
                    byte b6 = (byte) ($$a[47] - 1);
                    Object[] objArr15 = new Object[1];
                    c(b5, b6, b6, objArr15);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.argb(0, 0, 0, 0) + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-142671491, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                ((SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).getAuthRequestContext();
                ((SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                super.onCreate(savedInstanceState);
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

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (BottomSheetCardBindingView$watcherCardNumberView$1 ^ 4796183387843776835L);
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
