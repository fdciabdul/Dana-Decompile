package id.dana.sendmoney.ui.groupsend.recipient.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.util.DANAToast;
import id.dana.core.ui.util.NumberUtil;
import id.dana.core.ui.util.PermissionHelper;
import id.dana.core.ui.util.ShimmeringUtil;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.model.ContactInjectionConfig;
import id.dana.domain.user.UserInfoResponse;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.databinding.ActivityGroupRecipientBinding;
import id.dana.sendmoney.di.component.GroupSendComponent;
import id.dana.sendmoney.di.provider.GroupSendComponentProvider;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.InitSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.model.init.SendMoneyGroupInit;
import id.dana.sendmoney.domain.groupsend.model.modify.ParticipantInfoModify;
import id.dana.sendmoney.domain.groupsend.model.modify.ParticipantModify;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity;
import id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity;
import id.dana.sendmoney.ui.groupsend.recipient.adapter.RecipientAdapter;
import id.dana.sendmoney.ui.groupsend.recipient.adapter.SelectedRecipientAdapter;
import id.dana.sendmoney.ui.groupsend.recipient.datasource.ContactDataSourceFactoryV3;
import id.dana.sendmoney.ui.groupsend.recipient.datasource.RecipientDataSourceFactoryV3;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.util.GroupRecipientKeyboardHelper;
import id.dana.sendmoney.ui.groupsend.recipient.util.GroupRecipientSearchHelper;
import id.dana.sendmoney.ui.groupsend.recipient.view.ContactPermissionDialogFragment;
import id.dana.sendmoney.ui.groupsend.recipient.view.RecipientSourceType;
import id.dana.sendmoney.ui.groupsend.recipient.view.RecipientViewState;
import id.dana.sendmoney.ui.groupsend.recipient.view.RecyclerViewSectionDecorator;
import id.dana.sendmoney.ui.groupsend.recipient.view.SearchView;
import id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientUiState;
import id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel;
import id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity;
import id.dana.sendmoney.ui.groupsend.summary.mapper.GroupSendSummaryModelMapperKt;
import id.dana.sendmoney.ui.groupsend.summary.model.GroupSendIntentModel;
import id.dana.sendmoney.ui.groupsend.summary.model.PayeeUserInfoModel;
import id.dana.sendmoney.util.GroupSendTrackerExtKt;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.SourceTypeProperty;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.sync_engine.domain.model.ContactResult;
import id.dana.sync_engine.domain.model.SyncForFeature;
import id.dana.sync_engine.domain.model.SyncType;
import id.dana.sync_engine.domain.model.UserType;
import id.dana.sync_engine.exception.SyncEngineException;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 p2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001pB\u0007¢\u0006\u0004\bo\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0012\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J#\u0010\u0018\u001a\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010!J!\u0010\u0012\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020 0\"2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010#R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010%R\u0013\u0010\u0012\u001a\u00020&X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020 0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010)R\u0013\u0010\f\u001a\u00020*X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010(R\u0016\u0010\u0018\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b8\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b.\u0010/\"\u0004\b\u0012\u0010\u001cR\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u0016\u0010\u0019\u001a\u0002038\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0013\u0010\u001e\u001a\u00020=X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b>\u0010(R\u0014\u0010,\u001a\u00020\b8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b?\u0010/R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b@\u0010/R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010/R\u0016\u00100\u001a\u00020B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u00104\u001a\u00020E8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010>\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u00101R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020 0\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u0010)R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00140\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010)R\u0016\u0010@\u001a\u00020K8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010C\u001a\u00020N8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010I\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bQ\u00101R\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020 0$8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bR\u0010%R\u0016\u0010H\u001a\u00020S8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020 0\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bV\u0010)R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00140\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bW\u0010)R\u0016\u0010T\u001a\u00020X8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010O\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010V\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b^\u00101R\u001e\u0010R\u001a\f\u0012\b\u0012\u0006*\u00020`0`0_8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\"\u0010d\u001a\u00020c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0016\u0010Q\u001a\u00020j8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bk\u0010lR\u0013\u0010W\u001a\u00020mX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bn\u0010("}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/activity/GroupRecipientActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;", "", "configToolbar", "()V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lid/dana/sendmoney/ui/groupsend/recipient/view/RecyclerViewSectionDecorator;", "getAuthRequestContext", "()Lid/dana/sendmoney/ui/groupsend/recipient/view/RecyclerViewSectionDecorator;", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "PlaceComponentResult", "()Z", "", "p0", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "moveToNextValue", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "", "(Ljava/util/List;Z)V", "", "Ljava/util/Set;", "Lid/dana/sendmoney/ui/groupsend/recipient/view/ContactPermissionDialogFragment;", "scheduleImpl", "Lkotlin/Lazy;", "Ljava/util/List;", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "GetContactSyncConfig", "Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "initRecordTimeStamp", "Z", "DatabaseTableConfigUtil", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "groupSendTrackerHelper", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "getGroupSendTrackerHelper", "()Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "setGroupSendTrackerHelper", "(Lid/dana/sendmoney/util/GroupSendTrackerHelper;)V", "Landroid/os/Handler;", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "", "PrepareContext", "I", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/sendmoney/ui/groupsend/recipient/adapter/RecipientAdapter;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/sendmoney/ui/groupsend/recipient/adapter/RecipientAdapter;", "Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;", "readMicros", "Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;", "getSupportButtonTintMode", "SubSequence", "Lid/dana/sendmoney/ui/groupsend/recipient/util/GroupRecipientSearchHelper;", "getCallingPid", "Lid/dana/sendmoney/ui/groupsend/recipient/util/GroupRecipientSearchHelper;", "whenAvailable", DiskFormatter.B, "Lid/dana/sendmoney/ui/groupsend/recipient/adapter/SelectedRecipientAdapter;", "A", "Lid/dana/sendmoney/ui/groupsend/recipient/adapter/SelectedRecipientAdapter;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lcom/ethanhua/skeleton/SkeletonScreen;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "C", "Landroidx/activity/result/ActivityResultLauncher;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientViewState;", "getOnBoardingScenario", "Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientViewState;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientViewModel;", SummaryActivity.DAYS, "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupRecipientActivity extends BaseViewBindingActivity<ActivityGroupRecipientBinding> {
    public static final String ACTIVITY_NAME = "GroupRecipientActivity";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int E = 0;
    private static byte[] G = null;
    private static short[] H = null;
    public static final int MAX_PHONE_NUMBER_LENGTH = 13;
    private static int VerifyPinStateManager$executeRiskChallenge$2$2;
    private static int getValueOfTouchPositionAbsolute;

    /* renamed from: A  reason: from kotlin metadata */
    private SelectedRecipientAdapter getCallingPid;

    /* renamed from: B */
    private List<String> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: C  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> SubSequence;

    /* renamed from: D */
    private final Lazy B;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private RecipientAdapter isLayoutRequested;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private RecipientDataSourceFactoryV3 BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private GroupSendComponent getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private List<RecipientViewModel> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private List<String> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private int DatabaseTableConfigUtil;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private Set<RecipientViewModel> FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private SkeletonScreen readMicros;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Set<String> MyBillsEntityDataFactory;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private GroupRecipientSearchHelper NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private RecipientViewState getSupportButtonTintMode;
    @Inject
    public GroupSendTrackerHelper groupSendTrackerHelper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private GroupSendIntentModel PrepareContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;
    @Inject
    public ViewModelFactory viewModelFactory;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private List<RecipientViewModel> NetworkUserEntityData$$ExternalSyntheticLambda5;
    public static final byte[] $$a = {33, -64, 37, -91, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 53;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {83, -75, 7, 97, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 218;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$danaLogoLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLogoLoadingDialog invoke() {
            return new DanaLogoLoadingDialog(GroupRecipientActivity.this);
        }
    });

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<Handler>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$handler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private String newProxyInstance = "";

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda3 = "";

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private String whenAvailable = "";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String moveToNextValue = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String scheduleImpl = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean initRecordTimeStamp = true;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        VerifyPinStateManager$executeRiskChallenge$2$2 = 1257195662;
        getValueOfTouchPositionAbsolute = -198182382;
        G = new byte[]{-106, 82, 89, 34, 75, 65, 58, 80, 74, 34, 72, 32, 68, 115, 66, Ascii.ETB, 85, 70, 98, 11, 90, 91, 88, 71, 95, 72, -98, TarHeader.LF_CONTIG, TarHeader.LF_NORMAL, 1, 35, 56, 60, 57, 58, TarHeader.LF_FIFO, 71, -23, TarHeader.LF_NORMAL, 45, 3, TarHeader.LF_FIFO, 57, 36, -98, -33, -47, -35, -85, -94, -3, -3, 100, -37, Ascii.RS, -107, -92, -91, -94, -47, -87, -46, 107, 118, -99, 85, 101, Byte.MIN_VALUE, -19, -39, -117, -16, -38, -114, -19, -43, -92, -35, -119, -17, -43, -96, -33, -120, -40, -33, -22, -114, -16, -41, -115, -18, -119, -36, -35, -39, -15, -41, -36, -95, -41, -35, -113, -35, -39, -34, -18, -35, -35, -121, -24, -92, -38, -119, -16, -80, -103, -4, -95, -103, -87, -10, -89, -87, -89, -81, -86, -88, -90, -92, -88, -84, -94, -82, -108, -10, -100, -13, -83, -90, -91, -101, -88, -3, -92, -104, -89, -9, -88, -102, -4, -107, -4, -111, -4, -91, -85, -93, -101, -11, -99, -12, -88, -86, -91, -88, -101, -7, -84, -110, -87, -4, -96, -79, -107, -90, -6, -89, -108, -80, TarHeader.LF_CONTIG, 59, -20, 75, 62, TarHeader.LF_CONTIG, 61, 57, -20, 70, 60, -18, 57, 81, -24, TarHeader.LF_CONTIG, 58, 74, 3, TarHeader.LF_CONTIG, 56, -16, 77, 59, 57, 60, -26, 81, TarHeader.LF_DIR, -19, 78, -25, 79, -22, 59, 77, 60, -24, 76, TarHeader.LF_CONTIG, -23, 60, 75, -19, 75, -20, TarHeader.LF_CONTIG, 81, TarHeader.LF_BLK, 62, 57, 59, 2, 59, 59, TarHeader.LF_CONTIG, 57, 0, 61, -28, 62, 71, 60, -76, 120, 113, 110, 72, 102, -127, 122, 59, -80, 60, 118, 105, 121, 126, 114, -67, TarHeader.LF_LINK, 126, 104, -123, TarHeader.LF_DIR, 121, 107, -126, 46, 68, 102, 75, 115, 121, 104, 69, 102, 75, 105, -66, 61, 118, 101, 121, 72, 100, 123, 68, 109, 67, -79, 42, 68, 106, 122, -126, 119, 66, TarHeader.LF_NORMAL, 116, 123, 119, 107, 106, Ascii.SUB, Ascii.NAK, Ascii.US, 19, -28};
        E = 410503932;
    }

    private static void a(short s, int i, int i2, Object[] objArr) {
        int i3 = 106 - i2;
        int i4 = 23 - s;
        int i5 = i + 4;
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        byte[] bArr2 = new byte[i4];
        int i6 = -1;
        int i7 = i4 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i3 = (i3 + (-i5)) - 4;
            i5 = i5;
        }
        while (true) {
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i3;
            int i9 = i5 + 1;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i9];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
            i3 = (i3 + (-b)) - 4;
            i5 = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0029 -> B:35:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r0 = id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity.$$a
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L19:
            r3 = 0
        L1a:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity.c(byte, short, int, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(1094667733 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (-19) - TextUtils.indexOf((CharSequence) "", '0', 0), (byte) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (short) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) - 64), (ViewConfiguration.getDoubleTapTimeout() >> 16) - 1385726519, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1094667744, (Process.myPid() >> 22) - 18, (byte) ExpandableListView.getPackedPositionType(0L), (short) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18), TextUtils.lastIndexOf("", '0', 0, 0) - 1385726500, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ExpandableListView.getPackedPositionChild(0L), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(Gravity.getAbsoluteGravity(0, 0) + 1094667690, (-18) - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (byte) TextUtils.indexOf("", "", 0, 0), (short) (TextUtils.getOffsetAfter("", 0) - 67), TextUtils.lastIndexOf("", '0') - 1385726495, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(1094667732 - Color.green(0), (-17) - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (byte) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (short) ((-55) - View.MeasureSpec.makeMeasureSpec(0, 0)), (ViewConfiguration.getScrollDefaultDelay() >> 16) - 1385726448, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(1094667685 - Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) - 18, (byte) Color.red(0), (short) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 91), ExpandableListView.getPackedPositionChild(0L) - 1385726383, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(1094667738 - ImageFormat.getBitsPerPixel(0), (-17) - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (byte) View.combineMeasuredStates(0, 0), (short) (24 - (KeyEvent.getMaxKeyCode() >> 16)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 1385726320, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((ViewConfiguration.getKeyRepeatDelay() >> 16) + 1094667692, (-18) - (ViewConfiguration.getTapTimeout() >> 16), (byte) TextUtils.indexOf("", ""), (short) (121 - TextUtils.lastIndexOf("", '0', 0)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 1385726260, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, TextUtils.lastIndexOf("", '0', 0) + 19, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 36, KClassImpl$Data$declaredNonStaticMembers$2[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 21, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 55, Color.green(0) + 3, (char) Color.alpha(0));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], (byte) (-$$a[12]), $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 800, 15 - View.resolveSize(0, 0), (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, View.MeasureSpec.getMode(0) + 15, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getOffsetBefore("", 0), 28 - TextUtils.lastIndexOf("", '0', 0), (char) (57994 - KeyEvent.normalizeMetaState(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 800, 15 - TextUtils.getCapsMode("", 0, 0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1261487040, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getDoubleTapTimeout() >> 16), View.MeasureSpec.getSize(0) + 18, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 36, KClassImpl$Data$declaredNonStaticMembers$2[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 21, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 47 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "", 0));
                        byte b = (byte) ($$a[47] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b, b, (byte) (-$$a[28]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1261487040, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 36, KClassImpl$Data$declaredNonStaticMembers$2[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 21, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 3, (char) (KeyEvent.keyCodeFromString("") + 38968));
                        byte b2 = (byte) ($$a[47] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b2, b2, (byte) (-$$a[28]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, View.combineMeasuredStates(0, 0) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1261487040, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 36, KClassImpl$Data$declaredNonStaticMembers$2[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 21, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 107, 3 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[9]), $$a[40], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, AndroidCharacter.getMirror('0') - '\r', (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1261487040, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(getPackageName().codePointAt(1) + 1094667632, super.getResources().getString(R.string.tutorial).substring(0, 8).length() - 26, (byte) (super.getResources().getString(R.string.category_trending).substring(6, 7).codePointAt(0) - 110), (short) ((-65) - TextUtils.indexOf((CharSequence) "", '0', 0)), KeyEvent.keyCodeFromString("") - 1385726519, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        int length = getPackageName().length() + 1094667737;
        try {
            Object[] objArr3 = new Object[1];
            a(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            a(KClassImpl$Data$declaredNonStaticMembers$2[41], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[48], new Object[1]);
            Object[] objArr4 = new Object[1];
            b(length, ((ApplicationInfo) cls2.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 51, (byte) (getPackageName().codePointAt(1) - 100), (short) (super.getResources().getString(R.string.text_reference).substring(0, 7).length() + 11), getPackageName().codePointAt(4) - 1385726598, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    int codePointAt = super.getResources().getString(R.string.pocket_voucher_expired_in_date).substring(10, 15).codePointAt(2) + 1094667683;
                    try {
                        Object[] objArr5 = new Object[1];
                        a(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        a(KClassImpl$Data$declaredNonStaticMembers$2[41], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[48], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        b(codePointAt, ((ApplicationInfo) cls3.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 51, (byte) (ViewConfiguration.getFadingEdgeLength() >> 16), (short) (54 - TextUtils.getOffsetAfter("", 0)), super.getResources().getString(R.string.leaderboard_laps).substring(0, 5).length() - 1385726568, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 1094667734;
                        try {
                            Object[] objArr7 = new Object[1];
                            a(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr7);
                            Class<?> cls5 = Class.forName((String) objArr7[0]);
                            a(KClassImpl$Data$declaredNonStaticMembers$2[41], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[48], new Object[1]);
                            Object[] objArr8 = new Object[1];
                            b(maxKeyCode, ((ApplicationInfo) cls5.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 51, (byte) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (short) (super.getResources().getString(R.string.gn_subtitle_jp).substring(0, 86).length() + 1), (-1385726537) - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr8);
                            baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr9 = new Object[1];
                        b(1094667690 - Color.alpha(0), KeyEvent.normalizeMetaState(0) - 18, (byte) View.MeasureSpec.makeMeasureSpec(0, 0), (short) ((-66) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), super.getResources().getString(R.string.family_account_text_desc_activation_success).substring(32, 33).length() - 1385726497, objArr9);
                        String str = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(1094667732 - (ViewConfiguration.getScrollBarSize() >> 8), super.getResources().getString(R.string.kyc_renewal_activity_button).substring(5, 6).length() - 19, (byte) (super.getResources().getString(R.string.feed_onboarding_second_page_description).substring(4, 5).codePointAt(0) - 116), (short) (super.getResources().getString(R.string.getNameOrBuilderList).substring(1, 5).length() - 59), super.getResources().getString(R.string.btn_adding_my_bills).substring(5, 6).codePointAt(0) - 1385726480, objArr10);
                        String str2 = (String) objArr10[0];
                        int codePointAt2 = getPackageName().codePointAt(2) + 1094667639;
                        int length2 = getPackageName().length() - 25;
                        byte length3 = (byte) (super.getResources().getString(R.string.google_play).substring(1, 2).length() - 1);
                        try {
                            Object[] objArr11 = new Object[1];
                            a(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr11);
                            Class<?> cls6 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            a(KClassImpl$Data$declaredNonStaticMembers$2[41], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[48], objArr12);
                            Object[] objArr13 = new Object[1];
                            b(codePointAt2, length2, length3, (short) (((ApplicationInfo) cls6.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 59), (ViewConfiguration.getWindowTouchSlop() >> 8) - 1385726384, objArr13);
                            String str3 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            b(getPackageName().length() + 1094667732, getPackageName().codePointAt(1) - 118, (byte) (ViewConfiguration.getWindowTouchSlop() >> 8), (short) (getPackageName().length() + 17), getPackageName().codePointAt(0) - 1385726425, objArr14);
                            String str4 = (String) objArr14[0];
                            int rgb = Color.rgb(0, 0, 0) + 1111444908;
                            int length4 = getPackageName().length() - 25;
                            byte length5 = (byte) (super.getResources().getString(R.string.verify_number_description).substring(0, 5).length() - 5);
                            try {
                                Object[] objArr15 = new Object[1];
                                a(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr15);
                                Class<?> cls7 = Class.forName((String) objArr15[0]);
                                Object[] objArr16 = new Object[1];
                                a(KClassImpl$Data$declaredNonStaticMembers$2[41], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[48], objArr16);
                                Object[] objArr17 = new Object[1];
                                b(rgb, length4, length5, (short) (((ApplicationInfo) cls7.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 89), super.getResources().getString(R.string.account_succes_linked_desc).substring(0, 6).length() - 1385726266, objArr17);
                                try {
                                    Object[] objArr18 = {baseContext, str, str2, str3, str4, true, (String) objArr17[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) View.combineMeasuredStates(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr18);
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
                }
            }
            try {
                Object[] objArr19 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 36, KClassImpl$Data$declaredNonStaticMembers$2[25], objArr19);
                Class<?> cls8 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[2], 21, KClassImpl$Data$declaredNonStaticMembers$2[9], objArr20);
                try {
                    Object[] objArr21 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - Process.getGidForName(""), 4 - Color.green(0), (char) TextUtils.getOffsetAfter("", 0));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[9]), $$a[40], objArr22);
                        obj3 = cls9.getMethod((String) objArr22[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj3).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr24 = {-402061023, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), 18 - TextUtils.getOffsetAfter("", 0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr24);
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
                    super.onCreate(bundle);
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 == null) {
                        throw th9;
                    }
                    throw cause9;
                }
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int codePointAt = super.getResources().getString(R.string.tooltip_home_topup_desc).substring(0, 1).codePointAt(0) + 1094667648;
            int length = getPackageName().length() - 25;
            try {
                Object[] objArr = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(KClassImpl$Data$declaredNonStaticMembers$2[41], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[48], new Object[1]);
                try {
                    Object[] objArr2 = new Object[1];
                    b(codePointAt, length, (byte) (((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), (short) ((-16777162) - Color.rgb(0, 0, 0)), (-1385726572) + super.getResources().getString(R.string.zero_response).substring(0, 9).length(), objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    b(1094667734 - (ViewConfiguration.getWindowTouchSlop() >> 8), super.getResources().getString(R.string.smartpay_info_title_2).substring(0, 6).length() - 24, (byte) (ViewConfiguration.getPressedStateDuration() >> 16), (short) (super.getResources().getString(R.string.zface_title).substring(6, 7).codePointAt(0) + 55), (ViewConfiguration.getJumpTapTimeout() >> 16) - 1385726537, objArr3);
                    baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    th = th;
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
        super.onPause();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(1094667732 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (-18) - View.resolveSizeAndState(0, 0, 0), (byte) KeyEvent.keyCodeFromString(""), (short) (super.getResources().getString(R.string.card_binding_disclaimer_gpn).substring(38, 39).codePointAt(0) + 22), getPackageName().length() - 1385726570, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int i = 1094667735 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            int codePointAt = super.getResources().getString(R.string.desc_empty_search_country).substring(18, 20).codePointAt(1) - 132;
            byte codePointAt2 = (byte) (super.getResources().getString(R.string.otp_limited_dialog_title).substring(6, 7).codePointAt(0) - 97);
            try {
                Object[] objArr2 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[41], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[48], objArr3);
                short s = (short) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 54);
                try {
                    Object[] objArr4 = new Object[1];
                    a(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a(KClassImpl$Data$declaredNonStaticMembers$2[41], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[48], objArr5);
                    int i2 = ((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion - 1385726570;
                    Object[] objArr6 = new Object[1];
                    b(i, codePointAt, codePointAt2, s, i2, objArr6);
                    baseContext = (Context) cls.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), ImageFormat.getBitsPerPixel(0) + 19, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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
        super.onResume();
    }

    public GroupRecipientActivity() {
        final GroupRecipientActivity groupRecipientActivity = this;
        final Function0 function0 = null;
        this.B = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GroupRecipientViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GroupRecipientActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$special$$inlined$viewModels$default$3
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
                    CreationExtras defaultViewModelCreationExtras = groupRecipientActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GroupRecipientActivity.$r8$lambda$OJNTSXfo1lQbiisbcVnxAbMx7l4(GroupRecipientActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.SubSequence = registerForActivityResult;
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) groupRecipientActivity);
        String[] strArr = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$permission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                boolean z;
                Intrinsics.checkNotNullParameter(p0, "");
                GroupRecipientActivity.access$setHasPermission(GroupRecipientActivity.this, p0.MyBillsEntityDataFactory());
                z = GroupRecipientActivity.this.GetContactSyncConfig;
                if (z) {
                    final GroupRecipientViewModel access$getVm = GroupRecipientActivity.access$getVm(GroupRecipientActivity.this);
                    final LinkedHashSet linkedHashSet = new LinkedHashSet();
                    final LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    booleanRef.element = true;
                    MutableStateFlow<GroupRecipientUiState> mutableStateFlow = access$getVm.getAuthRequestContext;
                    do {
                    } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new GroupRecipientUiState.Loading(true)));
                    access$getVm.PlaceComponentResult.execute(new GetContactsUseCase.Params(SyncForFeature.SendMoney, UserType.All, SyncType.Server, false, false), new Function1<ContactResult, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getRecipientSyncContacts$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ContactResult contactResult) {
                            invoke2(contactResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(ContactResult contactResult) {
                            MutableStateFlow mutableStateFlow2;
                            Object value;
                            Intrinsics.checkNotNullParameter(contactResult, "");
                            if (contactResult instanceof ContactResult.Initial) {
                                linkedHashSet.clear();
                                linkedHashSet.addAll(((ContactResult.Initial) contactResult).KClassImpl$Data$declaredNonStaticMembers$2);
                            } else if (contactResult instanceof ContactResult.Next) {
                                ContactResult.Next next = (ContactResult.Next) contactResult;
                                linkedHashSet.addAll(next.getAuthRequestContext);
                                if ((next.getAuthRequestContext.isEmpty() && booleanRef.element) || next.getAuthRequestContext.isEmpty()) {
                                    GroupRecipientViewModel.getAuthRequestContext(access$getVm, linkedHashSet);
                                    mutableStateFlow2 = access$getVm.getAuthRequestContext;
                                    do {
                                        value = mutableStateFlow2.getValue();
                                        GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                                    } while (!mutableStateFlow2.compareAndSet(value, new GroupRecipientUiState.Loading(false)));
                                }
                                if (booleanRef.element) {
                                    booleanRef.element = false;
                                }
                            } else if (contactResult instanceof ContactResult.Update) {
                                linkedHashSet2.addAll(((ContactResult.Update) contactResult).MyBillsEntityDataFactory);
                            } else if (contactResult instanceof ContactResult.Finished) {
                                access$getVm.MyBillsEntityDataFactory(linkedHashSet2);
                            } else if (((ContactResult.Error) contactResult).getAuthRequestContext instanceof SyncEngineException.ContactNotFound) {
                                access$getVm.MyBillsEntityDataFactory(new LinkedHashSet());
                            }
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getRecipientSyncContacts$3
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
                            MutableStateFlow mutableStateFlow2;
                            Object value;
                            Intrinsics.checkNotNullParameter(th, "");
                            mutableStateFlow2 = GroupRecipientViewModel.this.getAuthRequestContext;
                            do {
                                value = mutableStateFlow2.getValue();
                                GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                            } while (!mutableStateFlow2.compareAndSet(value, new GroupRecipientUiState.Error(0, th, GroupSendOperationType.GROUP_GET_CONTACT_USE_CASE, 1, null)));
                        }
                    });
                    final GroupRecipientViewModel access$getVm2 = GroupRecipientActivity.access$getVm(GroupRecipientActivity.this);
                    BaseFlowUseCase.execute$default(access$getVm2.KClassImpl$Data$declaredNonStaticMembers$2, NoParams.INSTANCE, null, new Function1<ContactInjectionConfig, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getSplitContactInjection$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ContactInjectionConfig contactInjectionConfig) {
                            invoke2(contactInjectionConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(ContactInjectionConfig contactInjectionConfig) {
                            Intrinsics.checkNotNullParameter(contactInjectionConfig, "");
                            if (contactInjectionConfig.getContactInjection()) {
                                BaseFlowUseCase.execute$default(r0.lookAheadTest, contactInjectionConfig, null, null, null, null, ViewModelKt.PlaceComponentResult(GroupRecipientViewModel.this), 30, null);
                            }
                        }
                    }, null, null, ViewModelKt.PlaceComponentResult(access$getVm2), 26, null);
                    return;
                }
                GroupRecipientActivity.access$turnOffLoadingAndReObserve(GroupRecipientActivity.this);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PermissionHelper.BuiltInFictitiousFunctionClassFactory(GroupRecipientActivity.this);
                GroupRecipientActivity.access$turnOffLoadingAndReObserve(GroupRecipientActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = builder.PlaceComponentResult();
        this.PlaceComponentResult = LazyKt.lazy(new Function0<ContactPermissionDialogFragment>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$bottomSheetPermissionRequest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ContactPermissionDialogFragment invoke() {
                final GroupRecipientActivity groupRecipientActivity2 = GroupRecipientActivity.this;
                Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$bottomSheetPermissionRequest$2.1
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
                        ActivityPermissionRequest activityPermissionRequest;
                        activityPermissionRequest = GroupRecipientActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        activityPermissionRequest.check();
                    }
                };
                final GroupRecipientActivity groupRecipientActivity3 = GroupRecipientActivity.this;
                Function0<Unit> function03 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$bottomSheetPermissionRequest$2.2
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
                        GroupRecipientActivity.access$turnOffLoadingAndReObserve(GroupRecipientActivity.this);
                    }
                };
                final GroupRecipientActivity groupRecipientActivity4 = GroupRecipientActivity.this;
                return new ContactPermissionDialogFragment(function02, function03, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$bottomSheetPermissionRequest$2.3
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
                        ((GroupRecipientViewModel) GroupRecipientActivity.this.B.getValue()).PlaceComponentResult("group_send_contact_permission");
                        GroupRecipientActivity.access$turnOffLoadingAndReObserve(GroupRecipientActivity.this);
                    }
                });
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ArrayList();
        this.MyBillsEntityDataFactory = new LinkedHashSet();
        this.FragmentBottomSheetPaymentSettingBinding = new LinkedHashSet();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
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

    @JvmName(name = "getGroupSendTrackerHelper")
    public final GroupSendTrackerHelper getGroupSendTrackerHelper() {
        GroupSendTrackerHelper groupSendTrackerHelper = this.groupSendTrackerHelper;
        if (groupSendTrackerHelper != null) {
            return groupSendTrackerHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGroupSendTrackerHelper")
    public final void setGroupSendTrackerHelper(GroupSendTrackerHelper groupSendTrackerHelper) {
        Intrinsics.checkNotNullParameter(groupSendTrackerHelper, "");
        this.groupSendTrackerHelper = groupSendTrackerHelper;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityGroupRecipientBinding inflateViewBinding() {
        ActivityGroupRecipientBinding MyBillsEntityDataFactory = ActivityGroupRecipientBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            GroupSendComponent authRequestContext = ((GroupSendComponentProvider) applicationContext).provideGroupSendComponent().getAuthRequestContext();
            this.getErrorConfigVersion = authRequestContext;
            authRequestContext.MyBillsEntityDataFactory(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GroupSendComponentProvider");
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        int i;
        if (this.whenAvailable.length() > 0) {
            i = id.dana.sendmoney.R.string.res_0x7f1302fa_networkuserentitydata_externalsyntheticlambda5;
        } else {
            i = id.dana.sendmoney.R.string.btn_next_group_recipient;
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "");
        boolean isEmpty = true ^ this.NetworkUserEntityData$$ExternalSyntheticLambda5.isEmpty();
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().MyBillsEntityDataFactory;
        danaButtonPrimaryView.setContentDescription(getString(id.dana.sendmoney.R.string.btn_continue));
        if (this.initRecordTimeStamp && PlaceComponentResult()) {
            danaButtonPrimaryView.setEnabled(isEmpty);
            if (isEmpty) {
                danaButtonPrimaryView.setActiveButton(string, null);
                danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GroupRecipientActivity.$r8$lambda$OymPoinMIblCUvaZ9G2XzisiRqY(GroupRecipientActivity.this, view);
                    }
                });
            } else {
                danaButtonPrimaryView.setDisabled(string);
            }
        } else {
            danaButtonPrimaryView.setEnabled(false);
            danaButtonPrimaryView.setDisabled(string);
        }
        getErrorConfigVersion();
    }

    private final boolean PlaceComponentResult() {
        List<RecipientViewModel> list = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (RecipientViewModel recipientViewModel : list) {
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            String str = recipientViewModel.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(str, "");
            arrayList.add(NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str));
        }
        return !Intrinsics.areEqual(CollectionsKt.sorted(arrayList), CollectionsKt.sorted(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        if (p0) {
            if (this.readMicros == null) {
                ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                this.readMicros = ShimmeringUtil.getAuthRequestContext(getBinding().PlaceComponentResult, id.dana.sendmoney.R.layout.view_group_recipient_skeleton);
            }
            SkeletonScreen skeletonScreen = this.readMicros;
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        SkeletonScreen skeletonScreen2 = this.readMicros;
        if (skeletonScreen2 != null) {
            skeletonScreen2.PlaceComponentResult();
        }
    }

    public final void getErrorConfigVersion() {
        if (this.DatabaseTableConfigUtil != 0 && this.NetworkUserEntityData$$ExternalSyntheticLambda5.size() >= this.DatabaseTableConfigUtil) {
            TextView textView = getBinding().DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            String string = getString(id.dana.sendmoney.R.string.SplitReferralConfigEntityData_Factory);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.DatabaseTableConfigUtil)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
            return;
        }
        TextView textView2 = getBinding().DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(8);
    }

    public final void PlaceComponentResult(List<RecipientViewModel> list, boolean z) {
        List<RecipientViewModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (RecipientViewModel recipientViewModel : list2) {
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            String str = recipientViewModel.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String NetworkUserEntityData$$ExternalSyntheticLambda1 = NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str);
            List<String> list3 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (String str2 : list3) {
                NumberUtil numberUtil2 = NumberUtil.INSTANCE;
                arrayList2.add(NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str2));
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.contains(NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                recipientViewModel.lookAheadTest = z;
            }
            arrayList.add(Unit.INSTANCE);
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RecipientDataSourceFactoryV3 recipientDataSourceFactoryV3 = this.BuiltInFictitiousFunctionClassFactory;
        GroupRecipientSearchHelper groupRecipientSearchHelper = null;
        if (recipientDataSourceFactoryV3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientDataSourceFactoryV3 = null;
        }
        if (recipientDataSourceFactoryV3 instanceof ContactDataSourceFactoryV3) {
            ContactDataSourceFactoryV3 contactDataSourceFactoryV3 = (ContactDataSourceFactoryV3) recipientDataSourceFactoryV3;
            GroupRecipientSearchHelper groupRecipientSearchHelper2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (groupRecipientSearchHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                groupRecipientSearchHelper2 = null;
            }
            boolean builtInFictitiousFunctionClassFactory = groupRecipientSearchHelper2.getBuiltInFictitiousFunctionClassFactory();
            GroupRecipientSearchHelper groupRecipientSearchHelper3 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (groupRecipientSearchHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                groupRecipientSearchHelper3 = null;
            }
            String str = groupRecipientSearchHelper3.MyBillsEntityDataFactory;
            boolean z = this.GetContactSyncConfig;
            GroupRecipientSearchHelper groupRecipientSearchHelper4 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (groupRecipientSearchHelper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                groupRecipientSearchHelper = groupRecipientSearchHelper4;
            }
            contactDataSourceFactoryV3.getAuthRequestContext(builtInFictitiousFunctionClassFactory, str, z, groupRecipientSearchHelper.getKClassImpl$Data$declaredNonStaticMembers$2(), this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @JvmName(name = "PlaceComponentResult")
    private final void PlaceComponentResult(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        if (z && getBinding().scheduleImpl.getItemDecorationCount() == 0) {
            getBinding().scheduleImpl.addItemDecoration(getAuthRequestContext());
        } else {
            getBinding().scheduleImpl.removeItemDecoration(getAuthRequestContext());
        }
    }

    private final RecyclerViewSectionDecorator getAuthRequestContext() {
        RecyclerView recyclerView = getBinding().scheduleImpl;
        int dimensionPixelSize = getResources().getDimensionPixelSize(id.dana.sendmoney.R.dimen.res_0x7f07034d_kclassimpl_data_declarednonstaticmembers_2);
        final RecipientAdapter recipientAdapter = this.isLayoutRequested;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        return new RecyclerViewSectionDecorator(recyclerView, dimensionPixelSize, new RecyclerViewSectionDecorator.SectionCallback() { // from class: id.dana.sendmoney.ui.groupsend.recipient.adapter.RecipientAdapter$getSectionCallback$1
            @Override // id.dana.sendmoney.ui.groupsend.recipient.view.RecyclerViewSectionDecorator.SectionCallback
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                boolean authRequestContext;
                boolean PlaceComponentResult2;
                authRequestContext = RecipientAdapter.this.getAuthRequestContext(p0);
                if (authRequestContext) {
                    PlaceComponentResult2 = RecipientAdapter.this.PlaceComponentResult(p0);
                    if (PlaceComponentResult2) {
                        return true;
                    }
                }
                return false;
            }

            @Override // id.dana.sendmoney.ui.groupsend.recipient.view.RecyclerViewSectionDecorator.SectionCallback
            public final /* synthetic */ CharSequence PlaceComponentResult(int i) {
                boolean authRequestContext;
                String str;
                String KClassImpl$Data$declaredNonStaticMembers$22;
                char BuiltInFictitiousFunctionClassFactory;
                authRequestContext = RecipientAdapter.this.getAuthRequestContext(i);
                if (authRequestContext) {
                    KClassImpl$Data$declaredNonStaticMembers$22 = RecipientAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
                    BuiltInFictitiousFunctionClassFactory = RecipientAdapter.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$22);
                    str = String.valueOf(BuiltInFictitiousFunctionClassFactory);
                } else {
                    str = null;
                }
                return str;
            }
        });
    }

    private static RecipientViewModel BuiltInFictitiousFunctionClassFactory(List<? extends RecipientViewModel> list, String str) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            String str2 = ((RecipientViewModel) obj).DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            if (Intrinsics.areEqual(NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str2), str)) {
                break;
            }
        }
        return (RecipientViewModel) obj;
    }

    public final void MyBillsEntityDataFactory() {
        ConstraintLayout constraintLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(this.NetworkUserEntityData$$ExternalSyntheticLambda5.isEmpty() ^ true ? 0 : 8);
        TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(id.dana.sendmoney.R.string.selected_count);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda5.size()), Integer.valueOf(this.DatabaseTableConfigUtil)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
    }

    public final void lookAheadTest() {
        SelectedRecipientAdapter selectedRecipientAdapter = this.getCallingPid;
        SelectedRecipientAdapter selectedRecipientAdapter2 = null;
        if (selectedRecipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            selectedRecipientAdapter = null;
        }
        selectedRecipientAdapter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda5, null);
        SelectedRecipientAdapter selectedRecipientAdapter3 = this.getCallingPid;
        if (selectedRecipientAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            selectedRecipientAdapter2 = selectedRecipientAdapter3;
        }
        selectedRecipientAdapter2.notifyDataSetChanged();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        int i;
        Toolbar toolbar = getBinding().isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        toolbar2.setNavigationIcon(ContextCompat.PlaceComponentResult(toolbar2.getContext(), id.dana.sendmoney.R.drawable.PlaceComponentResult));
        toolbar2.setNavigationContentDescription(id.dana.sendmoney.R.string.NetworkUserEntityData$$ExternalSyntheticLambda1);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupRecipientActivity.m2921$r8$lambda$mN150QBWqrElP2o8pbgGJk7CEI(GroupRecipientActivity.this, view);
            }
        });
        TextView textView = getBinding().isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (this.whenAvailable.length() > 0) {
            i = id.dana.sendmoney.R.string.header_edit_recipient;
        } else {
            i = id.dana.sendmoney.R.string.send_to_group_toolbar;
        }
        textView.setText(getString(i));
    }

    private final void PlaceComponentResult(String p0) {
        RecipientViewState recipientViewState = new RecipientViewState(p0);
        this.getSupportButtonTintMode = recipientViewState;
        this.BuiltInFictitiousFunctionClassFactory = recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        SearchView searchView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        String string = getString(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(string, "");
        searchView.setEditTextHint(string);
        if (Intrinsics.areEqual(p0, GroupSendRecipientType.CONTACT)) {
            PlaceComponentResult(true);
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2.setContentDescription(getString(id.dana.sendmoney.R.string.txt_search_phone_number));
        } else if (Intrinsics.areEqual(p0, GroupSendRecipientType.BANK)) {
            PlaceComponentResult(false);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        GroupRecipientKeyboardHelper groupRecipientKeyboardHelper = GroupRecipientKeyboardHelper.INSTANCE;
        GroupRecipientActivity groupRecipientActivity = this;
        ActivityGroupRecipientBinding binding = getBinding();
        Intrinsics.checkNotNullParameter(groupRecipientActivity, "");
        Intrinsics.checkNotNullParameter(binding, "");
        Intrinsics.checkNotNullParameter(event, "");
        if (GroupRecipientKeyboardHelper.MyBillsEntityDataFactory(binding, event)) {
            GroupRecipientKeyboardHelper.BuiltInFictitiousFunctionClassFactory(binding, groupRecipientActivity, event);
        }
        return super.dispatchTouchEvent(event);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/activity/GroupRecipientActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;", "p1", "Landroid/content/Intent;", "PlaceComponentResult", "(Landroid/content/Context;Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;)Landroid/content/Intent;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "ACTIVITY_NAME", "Ljava/lang/String;", "", "MAX_PHONE_NUMBER_LENGTH", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, GroupRecipientActivity.class);
            intent.putExtra("RECIPIENT_TYPE", p1);
            return intent;
        }

        public static Intent PlaceComponentResult(Context p0, GroupSendIntentModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, GroupRecipientActivity.class);
            intent.putExtra("RECIPIENT_INTENT_MODEL", p1);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$L3UmXgTyHJVT3SQK4FtUdX2uaFI(GroupRecipientActivity groupRecipientActivity, View view) {
        Intrinsics.checkNotNullParameter(groupRecipientActivity, "");
        groupRecipientActivity.initRecordTimeStamp = true;
        groupRecipientActivity.PlaceComponentResult(groupRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2, false);
        groupRecipientActivity.FragmentBottomSheetPaymentSettingBinding.addAll(groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda5);
        groupRecipientActivity.MyBillsEntityDataFactory.clear();
        groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda5.clear();
        groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.clear();
        groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
        groupRecipientActivity.moveToNextValue();
        RecipientAdapter recipientAdapter = null;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(groupRecipientActivity), null, null, new GroupRecipientActivity$initFlowRecipientAdapter$1(groupRecipientActivity, null), 3, null);
        RecipientAdapter recipientAdapter2 = groupRecipientActivity.isLayoutRequested;
        if (recipientAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientAdapter = recipientAdapter2;
        }
        recipientAdapter.notifyDataSetChanged();
    }

    public static /* synthetic */ void $r8$lambda$OJNTSXfo1lQbiisbcVnxAbMx7l4(GroupRecipientActivity groupRecipientActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(groupRecipientActivity, "");
        Intrinsics.checkNotNullParameter(activityResult, "");
        Intent intent = activityResult.MyBillsEntityDataFactory;
        boolean booleanExtra = intent != null ? intent.getBooleanExtra(GroupSendLandingActivity.IS_GROUP_MODIFIED, false) : false;
        Intent intent2 = new Intent();
        intent2.putExtra(GroupSendLandingActivity.IS_GROUP_MODIFIED, booleanExtra);
        groupRecipientActivity.setResult(-1, intent2);
        groupRecipientActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$OymPoinMIblCUvaZ9G2XzisiRqY(GroupRecipientActivity groupRecipientActivity, View view) {
        Intent authRequestContext;
        Intrinsics.checkNotNullParameter(groupRecipientActivity, "");
        SelectedRecipientAdapter selectedRecipientAdapter = null;
        if (groupRecipientActivity.whenAvailable.length() > 0) {
            String str = groupRecipientActivity.whenAvailable;
            if (Intrinsics.areEqual(str, GroupSendSummaryActivity.ACTIVITY_NAME)) {
                GroupSendIntentModel groupSendIntentModel = groupRecipientActivity.PrepareContext;
                if (groupSendIntentModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    groupSendIntentModel = null;
                }
                Intrinsics.checkNotNullParameter(ACTIVITY_NAME, "");
                groupSendIntentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = ACTIVITY_NAME;
                SelectedRecipientAdapter selectedRecipientAdapter2 = groupRecipientActivity.getCallingPid;
                if (selectedRecipientAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    selectedRecipientAdapter = selectedRecipientAdapter2;
                }
                List<RecipientViewModel> authRequestContext2 = selectedRecipientAdapter.getAuthRequestContext();
                Intrinsics.checkNotNullParameter(authRequestContext2, "");
                groupSendIntentModel.scheduleImpl = authRequestContext2;
                String str2 = groupRecipientActivity.moveToNextValue;
                Intrinsics.checkNotNullParameter(str2, "");
                groupSendIntentModel.BuiltInFictitiousFunctionClassFactory = str2;
                String str3 = true ^ StringsKt.isBlank(groupRecipientActivity.moveToNextValue) ? groupRecipientActivity.scheduleImpl : "";
                Intrinsics.checkNotNullParameter(str3, "");
                groupSendIntentModel.getAuthRequestContext = str3;
                GroupSendSummaryActivity.Companion companion = GroupSendSummaryActivity.INSTANCE;
                authRequestContext = GroupSendSummaryActivity.Companion.getAuthRequestContext(groupSendIntentModel, "", null);
                groupRecipientActivity.setResult(-1, authRequestContext);
                groupRecipientActivity.finish();
            } else if (Intrinsics.areEqual(str, GroupDetailActivity.ACTIVITY_NAME)) {
                final GroupRecipientViewModel groupRecipientViewModel = (GroupRecipientViewModel) groupRecipientActivity.B.getValue();
                String str4 = Intrinsics.areEqual(groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda3, GroupSendRecipientType.CONTACT) ? "BALANCE" : "BANK_TRANSFER";
                List<String> list = groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda4;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str5 : list) {
                    NumberUtil numberUtil = NumberUtil.INSTANCE;
                    String PlaceComponentResult2 = NumberUtil.PlaceComponentResult(str5, "62-");
                    if (PlaceComponentResult2 == null) {
                        PlaceComponentResult2 = "";
                    }
                    arrayList.add(PlaceComponentResult2);
                }
                ArrayList arrayList2 = arrayList;
                Intrinsics.checkNotNullParameter(str4, "");
                Intrinsics.checkNotNullParameter(arrayList2, "");
                groupRecipientViewModel.scheduleImpl.execute(new InitSendMoneyGroup.Param(null, str4, arrayList2, 1, null), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$initSendMoneyGroup$1
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.DanaLoadingDialog(true)));
                    }
                }, new Function1<SendMoneyGroupInit, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$initSendMoneyGroup$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(SendMoneyGroupInit sendMoneyGroupInit) {
                        invoke2(sendMoneyGroupInit);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SendMoneyGroupInit sendMoneyGroupInit) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(sendMoneyGroupInit, "");
                        mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.OnGetSendMoneyGroupInit(GroupSendSummaryModelMapperKt.BuiltInFictitiousFunctionClassFactory(sendMoneyGroupInit))));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$initSendMoneyGroup$3
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GROUP_SEND_EXCEPTION, th.getMessage(), th);
                        mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.OnErrorModifyGroup(th, GroupSendOperationType.GROUP_INIT)));
                    }
                }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$initSendMoneyGroup$4
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.DanaLoadingDialog(false)));
                    }
                }, ViewModelKt.PlaceComponentResult(groupRecipientViewModel));
            }
        } else {
            String str6 = groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda3;
            SelectedRecipientAdapter selectedRecipientAdapter3 = groupRecipientActivity.getCallingPid;
            if (selectedRecipientAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                selectedRecipientAdapter3 = null;
            }
            List<RecipientViewModel> authRequestContext3 = selectedRecipientAdapter3.getAuthRequestContext();
            String str7 = groupRecipientActivity.moveToNextValue;
            GroupSendIntentModel groupSendIntentModel2 = new GroupSendIntentModel(ACTIVITY_NAME, str6, authRequestContext3, str7, true ^ StringsKt.isBlank(str7) ? groupRecipientActivity.scheduleImpl : "", null, null, false, 224, null);
            ActivityResultLauncher<Intent> activityResultLauncher = groupRecipientActivity.SubSequence;
            GroupSendSummaryActivity.Companion companion2 = GroupSendSummaryActivity.INSTANCE;
            activityResultLauncher.MyBillsEntityDataFactory(GroupSendSummaryActivity.Companion.getAuthRequestContext(groupSendIntentModel2, SourceTypeProperty.CONTACT_LIST, groupRecipientActivity), null);
        }
        groupRecipientActivity.getGroupSendTrackerHelper().KClassImpl$Data$declaredNonStaticMembers$2(GroupSendTrackerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda3));
    }

    /* renamed from: $r8$lambda$mN150QBW-qrElP2o8pbgGJk7CEI */
    public static /* synthetic */ void m2921$r8$lambda$mN150QBWqrElP2o8pbgGJk7CEI(GroupRecipientActivity groupRecipientActivity, View view) {
        Intrinsics.checkNotNullParameter(groupRecipientActivity, "");
        groupRecipientActivity.onBackPressed();
    }

    public static /* synthetic */ void $r8$lambda$rg3X463sfyzTmAoMoye2kKHpKco(GroupRecipientActivity groupRecipientActivity, View view) {
        Intrinsics.checkNotNullParameter(groupRecipientActivity, "");
        RecipientViewState recipientViewState = groupRecipientActivity.getSupportButtonTintMode;
        GroupRecipientSearchHelper groupRecipientSearchHelper = null;
        if (recipientViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState = null;
        }
        if (Intrinsics.areEqual(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.Contact.INSTANCE)) {
            GroupRecipientSearchHelper groupRecipientSearchHelper2 = groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (groupRecipientSearchHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                groupRecipientSearchHelper = groupRecipientSearchHelper2;
            }
            groupRecipientSearchHelper.MyBillsEntityDataFactory();
        }
    }

    public static /* synthetic */ void $r8$lambda$vs68DGBQOLP5IVt2dtDd753RoD0(GroupRecipientActivity groupRecipientActivity, View view) {
        Intrinsics.checkNotNullParameter(groupRecipientActivity, "");
        RecipientViewState recipientViewState = groupRecipientActivity.getSupportButtonTintMode;
        GroupRecipientSearchHelper groupRecipientSearchHelper = null;
        if (recipientViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState = null;
        }
        if (Intrinsics.areEqual(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.Contact.INSTANCE)) {
            GroupRecipientSearchHelper groupRecipientSearchHelper2 = groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (groupRecipientSearchHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                groupRecipientSearchHelper = groupRecipientSearchHelper2;
            }
            groupRecipientSearchHelper.MyBillsEntityDataFactory(true);
            groupRecipientSearchHelper.lookAheadTest = true;
            groupRecipientSearchHelper.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2.focusOnEditText();
        }
    }

    public static final /* synthetic */ List access$generateModifiedList(GroupRecipientActivity groupRecipientActivity) {
        ArrayList arrayList = new ArrayList();
        groupRecipientActivity.MyBillsEntityDataFactory.removeAll(CollectionsKt.toSet(groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda7));
        Iterator<T> it = groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda5.iterator();
        while (true) {
            String str = "";
            if (!it.hasNext()) {
                break;
            }
            RecipientViewModel recipientViewModel = (RecipientViewModel) it.next();
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            String str2 = recipientViewModel.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            String NetworkUserEntityData$$ExternalSyntheticLambda1 = NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str2);
            if (groupRecipientActivity.MyBillsEntityDataFactory.contains(NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                ParticipantModify.Companion companion = ParticipantModify.INSTANCE;
                NumberUtil numberUtil2 = NumberUtil.INSTANCE;
                String PlaceComponentResult2 = NumberUtil.PlaceComponentResult(NetworkUserEntityData$$ExternalSyntheticLambda1, "62-");
                if (PlaceComponentResult2 == null) {
                    PlaceComponentResult2 = "";
                }
                String str3 = recipientViewModel.initRecordTimeStamp;
                Intrinsics.checkNotNullExpressionValue(str3, "");
                if (!Intrinsics.areEqual(str3, groupRecipientActivity.getString(id.dana.sendmoney.R.string.res_0x7f1312c9_securitysettingsactivity_createpinlauncher_2_1)) && !Intrinsics.areEqual(str3, "-")) {
                    str = str3;
                }
                arrayList.add(ParticipantModify.Companion.getAuthRequestContext(PlaceComponentResult2, str));
            }
        }
        for (RecipientViewModel recipientViewModel2 : groupRecipientActivity.FragmentBottomSheetPaymentSettingBinding) {
            List<String> list = groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda4;
            NumberUtil numberUtil3 = NumberUtil.INSTANCE;
            String str4 = recipientViewModel2.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(str4, "");
            if (!list.contains(NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str4))) {
                ParticipantModify.Companion companion2 = ParticipantModify.INSTANCE;
                String str5 = recipientViewModel2.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(str5, "");
                arrayList.add(ParticipantModify.Companion.MyBillsEntityDataFactory(str5));
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ DanaLogoLoadingDialog access$getDanaLogoLoadingDialog(GroupRecipientActivity groupRecipientActivity) {
        return (DanaLogoLoadingDialog) groupRecipientActivity.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ Handler access$getHandler(GroupRecipientActivity groupRecipientActivity) {
        return (Handler) groupRecipientActivity.lookAheadTest.getValue();
    }

    public static final /* synthetic */ GroupRecipientViewModel access$getVm(GroupRecipientActivity groupRecipientActivity) {
        return (GroupRecipientViewModel) groupRecipientActivity.B.getValue();
    }

    public static final /* synthetic */ void access$observePagedContactList(GroupRecipientActivity groupRecipientActivity) {
        groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
        groupRecipientActivity.moveToNextValue();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(groupRecipientActivity), null, null, new GroupRecipientActivity$initFlowRecipientAdapter$1(groupRecipientActivity, null), 3, null);
    }

    public static final /* synthetic */ void access$setHasPermission(GroupRecipientActivity groupRecipientActivity, boolean z) {
        groupRecipientActivity.GetContactSyncConfig = z;
        ConstraintLayout constraintLayout = groupRecipientActivity.getBinding().lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(groupRecipientActivity.GetContactSyncConfig ? 0 : 8);
    }

    public static final /* synthetic */ void access$setResultAndNavigateBackToDetailActivity(GroupRecipientActivity groupRecipientActivity, String str) {
        GroupDetailActivity.Companion companion = GroupDetailActivity.INSTANCE;
        groupRecipientActivity.setResult(-1, GroupDetailActivity.Companion.getAuthRequestContext(str));
        groupRecipientActivity.finish();
    }

    public static final /* synthetic */ void access$showBottomSheetPermissionDialog(GroupRecipientActivity groupRecipientActivity) {
        ContactPermissionDialogFragment contactPermissionDialogFragment = (ContactPermissionDialogFragment) groupRecipientActivity.PlaceComponentResult.getValue();
        FragmentManager supportFragmentManager = groupRecipientActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        contactPermissionDialogFragment.getAuthRequestContext(supportFragmentManager);
        ((GroupRecipientViewModel) groupRecipientActivity.B.getValue()).PlaceComponentResult("group_send_contact_permission");
    }

    public static final /* synthetic */ void access$slideUpBottomViewButton(GroupRecipientActivity groupRecipientActivity) {
        ViewGroup.LayoutParams layoutParams = groupRecipientActivity.getBinding().lookAheadTest.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).lookAheadTest;
        if (behavior == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.behavior.HideBottomViewOnScrollBehavior<@[FlexibleNullability] android.view.View?>");
        }
        ((HideBottomViewOnScrollBehavior) behavior).slideUp(groupRecipientActivity.getBinding().lookAheadTest);
    }

    public static final /* synthetic */ List access$syncContactNameWithResultFromInit(GroupRecipientActivity groupRecipientActivity, List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ParticipantModify participantModify = (ParticipantModify) it.next();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                PayeeUserInfoModel payeeUserInfoModel = (PayeeUserInfoModel) it2.next();
                ParticipantInfoModify participantInfoModify = participantModify.getAuthRequestContext;
                if (participantInfoModify != null) {
                    NumberUtil numberUtil = NumberUtil.INSTANCE;
                    if (Intrinsics.areEqual(NumberUtil.PlaceComponentResult(participantInfoModify.KClassImpl$Data$declaredNonStaticMembers$2, "62-"), payeeUserInfoModel.MyBillsEntityDataFactory)) {
                        String str = payeeUserInfoModel.scheduleImpl;
                        if (Intrinsics.areEqual(str, groupRecipientActivity.getString(id.dana.sendmoney.R.string.res_0x7f1312c9_securitysettingsactivity_createpinlauncher_2_1)) || Intrinsics.areEqual(str, "-")) {
                            str = "";
                        }
                        Intrinsics.checkNotNullParameter(str, "");
                        participantInfoModify.getAuthRequestContext = str;
                    }
                }
            }
            arrayList.add(participantModify);
        }
        return arrayList;
    }

    public static final /* synthetic */ void access$toggleCancelSearchButtonVisibility(GroupRecipientActivity groupRecipientActivity, boolean z) {
        AppCompatImageView appCompatImageView = groupRecipientActivity.getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(z ^ true ? 0 : 8);
        TextView textView = groupRecipientActivity.getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(z ? 0 : 8);
    }

    public static final /* synthetic */ void access$toggleSelectedContact(GroupRecipientActivity groupRecipientActivity, RecipientViewModel recipientViewModel, boolean z) {
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String str = recipientViewModel.DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(str, "");
        String NetworkUserEntityData$$ExternalSyntheticLambda1 = NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str);
        boolean z2 = true;
        if (z) {
            groupRecipientActivity.MyBillsEntityDataFactory.add(NetworkUserEntityData$$ExternalSyntheticLambda1);
            recipientViewModel.lookAheadTest = true;
            groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda5.add(recipientViewModel);
            groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.add(NetworkUserEntityData$$ExternalSyntheticLambda1);
        } else {
            RecipientViewModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda8, NetworkUserEntityData$$ExternalSyntheticLambda1);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                groupRecipientActivity.FragmentBottomSheetPaymentSettingBinding.add(BuiltInFictitiousFunctionClassFactory);
            }
            groupRecipientActivity.MyBillsEntityDataFactory.remove(NetworkUserEntityData$$ExternalSyntheticLambda1);
            RecipientViewModel BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda5, NetworkUserEntityData$$ExternalSyntheticLambda1);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda5.remove(BuiltInFictitiousFunctionClassFactory2);
            }
            groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.remove(NetworkUserEntityData$$ExternalSyntheticLambda1);
            String str2 = recipientViewModel.PlaceComponentResult;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            }
            if (!z2 || (recipientViewModel = BuiltInFictitiousFunctionClassFactory(groupRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2, NetworkUserEntityData$$ExternalSyntheticLambda1)) != null) {
                recipientViewModel.lookAheadTest = false;
            }
        }
        groupRecipientActivity.MyBillsEntityDataFactory();
        groupRecipientActivity.lookAheadTest();
        RecipientAdapter recipientAdapter = groupRecipientActivity.isLayoutRequested;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        recipientAdapter.notifyDataSetChanged();
        groupRecipientActivity.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void access$turnOffLoadingAndReObserve(GroupRecipientActivity groupRecipientActivity) {
        groupRecipientActivity.KClassImpl$Data$declaredNonStaticMembers$2(false);
        groupRecipientActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
        groupRecipientActivity.moveToNextValue();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(groupRecipientActivity), null, null, new GroupRecipientActivity$initFlowRecipientAdapter$1(groupRecipientActivity, null), 3, null);
    }

    private final void moveToNextValue() {
        GroupRecipientViewModel groupRecipientViewModel = (GroupRecipientViewModel) this.B.getValue();
        RecipientDataSourceFactoryV3 recipientDataSourceFactoryV3 = this.BuiltInFictitiousFunctionClassFactory;
        if (recipientDataSourceFactoryV3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientDataSourceFactoryV3 = null;
        }
        groupRecipientViewModel.MyBillsEntityDataFactory(recipientDataSourceFactoryV3.PlaceComponentResult());
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        RecyclerView recyclerView = getBinding().moveToNextValue;
        SelectedRecipientAdapter selectedRecipientAdapter = new SelectedRecipientAdapter();
        Function1<RecipientViewModel, Unit> function1 = new Function1<RecipientViewModel, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initSelectedRecipientRecyclerView$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RecipientViewModel recipientViewModel) {
                invoke2(recipientViewModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RecipientViewModel recipientViewModel) {
                Set set;
                Intrinsics.checkNotNullParameter(recipientViewModel, "");
                GroupRecipientActivity.this.initRecordTimeStamp = true;
                set = GroupRecipientActivity.this.FragmentBottomSheetPaymentSettingBinding;
                set.add(recipientViewModel);
                GroupRecipientActivity.access$toggleSelectedContact(GroupRecipientActivity.this, recipientViewModel, false);
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        selectedRecipientAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        this.getCallingPid = selectedRecipientAdapter;
        recyclerView.setAdapter(selectedRecipientAdapter);
        DiffUtil.ItemCallback<RecipientViewModel> itemCallback = RecipientViewModel.getCallingPid;
        Intrinsics.checkNotNullExpressionValue(itemCallback, "");
        RecipientAdapter recipientAdapter = new RecipientAdapter(itemCallback);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initRecipientRecyclerView$1$1
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
                PermissionHelper.BuiltInFictitiousFunctionClassFactory(GroupRecipientActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        recipientAdapter.BuiltInFictitiousFunctionClassFactory = function0;
        Function3<RecipientViewModel, Boolean, Integer, Unit> function3 = new Function3<RecipientViewModel, Boolean, Integer, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initRecipientRecyclerView$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final /* synthetic */ Unit invoke(RecipientViewModel recipientViewModel, Boolean bool, Integer num) {
                invoke(recipientViewModel, bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RecipientViewModel recipientViewModel, boolean z, int i) {
                SelectedRecipientAdapter selectedRecipientAdapter2;
                RecipientAdapter recipientAdapter2;
                String str;
                SelectedRecipientAdapter selectedRecipientAdapter3;
                int i2;
                RecipientAdapter recipientAdapter3;
                Intrinsics.checkNotNullParameter(recipientViewModel, "");
                GroupRecipientActivity.this.initRecordTimeStamp = true;
                selectedRecipientAdapter2 = GroupRecipientActivity.this.getCallingPid;
                RecipientAdapter recipientAdapter4 = null;
                if (selectedRecipientAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    selectedRecipientAdapter2 = null;
                }
                Iterable iterable = selectedRecipientAdapter2.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
                Intrinsics.checkNotNullExpressionValue(iterable, "");
                Iterable<RecipientViewModel> iterable2 = iterable;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (RecipientViewModel recipientViewModel2 : iterable2) {
                    NumberUtil numberUtil = NumberUtil.INSTANCE;
                    String str2 = recipientViewModel2.DatabaseTableConfigUtil;
                    Intrinsics.checkNotNullExpressionValue(str2, "");
                    arrayList.add(NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str2));
                }
                ArrayList arrayList2 = arrayList;
                NumberUtil numberUtil2 = NumberUtil.INSTANCE;
                String str3 = recipientViewModel.DatabaseTableConfigUtil;
                Intrinsics.checkNotNullExpressionValue(str3, "");
                String NetworkUserEntityData$$ExternalSyntheticLambda1 = NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str3);
                NumberUtil numberUtil3 = NumberUtil.INSTANCE;
                String str4 = recipientViewModel.DatabaseTableConfigUtil;
                Intrinsics.checkNotNullExpressionValue(str4, "");
                if (NumberUtil.scheduleImpl(str4)) {
                    NumberUtil numberUtil4 = NumberUtil.INSTANCE;
                    String str5 = recipientViewModel.DatabaseTableConfigUtil;
                    Intrinsics.checkNotNullExpressionValue(str5, "");
                    if (NumberUtil.lookAheadTest(str5) && NetworkUserEntityData$$ExternalSyntheticLambda1.length() <= 13) {
                        NumberUtil numberUtil5 = NumberUtil.INSTANCE;
                        str = GroupRecipientActivity.this.newProxyInstance;
                        if (!Intrinsics.areEqual(NetworkUserEntityData$$ExternalSyntheticLambda1, NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str)) && (!arrayList2.contains(NetworkUserEntityData$$ExternalSyntheticLambda1) || !z)) {
                            if (z) {
                                selectedRecipientAdapter3 = GroupRecipientActivity.this.getCallingPid;
                                if (selectedRecipientAdapter3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    selectedRecipientAdapter3 = null;
                                }
                                int placeComponentResult = selectedRecipientAdapter3.getPlaceComponentResult();
                                i2 = GroupRecipientActivity.this.DatabaseTableConfigUtil;
                                if (placeComponentResult >= i2) {
                                    recipientViewModel.lookAheadTest = false;
                                    recipientAdapter3 = GroupRecipientActivity.this.isLayoutRequested;
                                    if (recipientAdapter3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                    } else {
                                        recipientAdapter4 = recipientAdapter3;
                                    }
                                    recipientAdapter4.notifyDataSetChanged();
                                    DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                                    GroupRecipientActivity groupRecipientActivity = GroupRecipientActivity.this;
                                    GroupRecipientActivity groupRecipientActivity2 = groupRecipientActivity;
                                    String string = groupRecipientActivity.getString(id.dana.sendmoney.R.string.max_participant_error_message);
                                    Intrinsics.checkNotNullExpressionValue(string, "");
                                    DANAToast.KClassImpl$Data$declaredNonStaticMembers$2(groupRecipientActivity2, string, GroupRecipientActivity.this.getApplicationContext().getString(id.dana.sendmoney.R.string.toast_warning_max_member));
                                    return;
                                }
                            }
                            GroupRecipientActivity.access$toggleSelectedContact(GroupRecipientActivity.this, recipientViewModel, z);
                            return;
                        }
                    }
                }
                recipientViewModel.lookAheadTest = false;
                recipientAdapter2 = GroupRecipientActivity.this.isLayoutRequested;
                if (recipientAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recipientAdapter4 = recipientAdapter2;
                }
                recipientAdapter4.notifyDataSetChanged();
                DANAToast dANAToast2 = DANAToast.BuiltInFictitiousFunctionClassFactory;
                GroupRecipientActivity groupRecipientActivity3 = GroupRecipientActivity.this;
                GroupRecipientActivity groupRecipientActivity4 = groupRecipientActivity3;
                String string2 = groupRecipientActivity3.getString(id.dana.sendmoney.R.string.invalid_number_error_message);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                String string3 = GroupRecipientActivity.this.getApplicationContext().getString(id.dana.sendmoney.R.string.toast_error_invalid_number);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                DANAToast.MyBillsEntityDataFactory(groupRecipientActivity4, string2, string3);
            }
        };
        Intrinsics.checkNotNullParameter(function3, "");
        recipientAdapter.PlaceComponentResult = function3;
        this.isLayoutRequested = recipientAdapter;
        RecyclerView recyclerView2 = getBinding().scheduleImpl;
        RecipientAdapter recipientAdapter2 = this.isLayoutRequested;
        if (recipientAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter2 = null;
        }
        recyclerView2.setAdapter(recipientAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 && recyclerView2.getItemDecorationCount() == 0) {
            recyclerView2.addItemDecoration(getAuthRequestContext());
        }
        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) recyclerView2, true);
        recyclerView2.addOnScrollListener(new GroupRecipientActivity$provideOnScrollListener$1(this));
        Intent intent = getIntent();
        GroupSendIntentModel groupSendIntentModel = (GroupSendIntentModel) intent.getParcelableExtra("RECIPIENT_INTENT_MODEL");
        if (groupSendIntentModel != null) {
            this.initRecordTimeStamp = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = groupSendIntentModel.moveToNextValue;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.addAll(groupSendIntentModel.scheduleImpl);
            List<String> list = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            List<? extends RecipientViewModel> list2 = groupSendIntentModel.scheduleImpl;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (RecipientViewModel recipientViewModel : list2) {
                NumberUtil numberUtil = NumberUtil.INSTANCE;
                String str = recipientViewModel.DatabaseTableConfigUtil;
                Intrinsics.checkNotNullExpressionValue(str, "");
                arrayList.add(NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str));
            }
            list.addAll(CollectionsKt.sorted(arrayList));
            this.moveToNextValue = groupSendIntentModel.BuiltInFictitiousFunctionClassFactory;
            this.scheduleImpl = groupSendIntentModel.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(groupSendIntentModel, "");
            PlaceComponentResult(groupSendIntentModel.moveToNextValue);
            this.whenAvailable = groupSendIntentModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.moveToNextValue = groupSendIntentModel.BuiltInFictitiousFunctionClassFactory;
            List<? extends RecipientViewModel> list3 = groupSendIntentModel.scheduleImpl;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (RecipientViewModel recipientViewModel2 : list3) {
                NumberUtil numberUtil2 = NumberUtil.INSTANCE;
                String str2 = recipientViewModel2.DatabaseTableConfigUtil;
                Intrinsics.checkNotNullExpressionValue(str2, "");
                recipientViewModel2.DatabaseTableConfigUtil = NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str2);
                arrayList2.add(recipientViewModel2);
            }
            ArrayList arrayList3 = arrayList2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.addAll(arrayList3);
            List<String> list4 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                arrayList5.add(((RecipientViewModel) it.next()).DatabaseTableConfigUtil);
            }
            list4.addAll(arrayList5);
            MyBillsEntityDataFactory();
            lookAheadTest();
            BuiltInFictitiousFunctionClassFactory();
            this.PrepareContext = groupSendIntentModel;
        } else {
            String stringExtra = intent.getStringExtra("RECIPIENT_TYPE");
            if (stringExtra != null) {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "");
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = stringExtra;
                PlaceComponentResult(stringExtra);
            }
        }
        RecipientViewState recipientViewState = this.getSupportButtonTintMode;
        if (recipientViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState = null;
        }
        if (Intrinsics.areEqual(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.Contact.INSTANCE)) {
            final GroupRecipientViewModel groupRecipientViewModel = (GroupRecipientViewModel) this.B.getValue();
            Intrinsics.checkNotNullParameter("group_send_contact_permission", "");
            BaseFlowUseCase.execute$default(groupRecipientViewModel.BuiltInFictitiousFunctionClassFactory, "group_send_contact_permission", null, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$checkIsNeedToShowBottomSheetRequestPermission$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.OnSuccessGetIsNeedToShowBottomSheet(z)));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$checkIsNeedToShowBottomSheetRequestPermission$2
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
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    Intrinsics.checkNotNullParameter(th, "");
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.GET_ON_BOARDING_PREFIX);
                    sb.append(GroupRecipientViewModel.this.getClass().getName());
                    sb.append("on Error");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
                    mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.Error(0, th, GroupSendOperationType.GROUP_GET_BOTTOM_SHEET_ONBOARDING, 1, null)));
                }
            }, null, ViewModelKt.PlaceComponentResult(groupRecipientViewModel), 18, null);
        }
        GroupRecipientActivity groupRecipientActivity = this;
        ActivityGroupRecipientBinding binding = getBinding();
        RecipientViewState recipientViewState2 = this.getSupportButtonTintMode;
        if (recipientViewState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState2 = null;
        }
        final GroupRecipientSearchHelper groupRecipientSearchHelper = new GroupRecipientSearchHelper(groupRecipientActivity, binding, recipientViewState2);
        Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initSearchViewHelper$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                GroupRecipientActivity.access$toggleCancelSearchButtonVisibility(GroupRecipientActivity.this, z);
            }
        };
        Intrinsics.checkNotNullParameter(function12, "");
        groupRecipientSearchHelper.moveToNextValue = function12;
        Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initSearchViewHelper$1$2
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
                GroupRecipientActivity.access$observePagedContactList(GroupRecipientActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(function02, "");
        groupRecipientSearchHelper.getErrorConfigVersion = function02;
        GroupRecipientActivity groupRecipientActivity2 = this;
        LifecycleCoroutineScope PlaceComponentResult2 = LifecycleOwnerKt.PlaceComponentResult(groupRecipientActivity2);
        Intrinsics.checkNotNullParameter(PlaceComponentResult2, "");
        SearchView searchView = groupRecipientSearchHelper.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2;
        searchView.setOnSearchListener(PlaceComponentResult2, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.util.GroupRecipientSearchHelper$initSearchView$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str3) {
                invoke2(str3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                GroupRecipientSearchHelper.this.PlaceComponentResult(str3);
            }
        });
        searchView.setOnFocusSearchListener(PlaceComponentResult2, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.util.GroupRecipientSearchHelper$initSearchView$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    GroupRecipientSearchHelper.this.MyBillsEntityDataFactory(true);
                    GroupRecipientSearchHelper.KClassImpl$Data$declaredNonStaticMembers$2(GroupRecipientSearchHelper.this);
                }
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = groupRecipientSearchHelper;
        ActivityGroupRecipientBinding binding2 = getBinding();
        binding2.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupRecipientActivity.$r8$lambda$vs68DGBQOLP5IVt2dtDd753RoD0(GroupRecipientActivity.this, view);
            }
        });
        binding2.GetContactSyncConfig.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupRecipientActivity.$r8$lambda$rg3X463sfyzTmAoMoye2kKHpKco(GroupRecipientActivity.this, view);
            }
        });
        binding2.initRecordTimeStamp.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupRecipientActivity.$r8$lambda$L3UmXgTyHJVT3SQK4FtUdX2uaFI(GroupRecipientActivity.this, view);
            }
        });
        GroupRecipientKeyboardHelper groupRecipientKeyboardHelper = GroupRecipientKeyboardHelper.INSTANCE;
        GroupRecipientKeyboardHelper.getAuthRequestContext(getBinding());
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(groupRecipientActivity2), null, null, new GroupRecipientActivity$initLifecycleActivity$1(this, null), 3, null);
        BuiltInFictitiousFunctionClassFactory();
        final GroupRecipientViewModel groupRecipientViewModel2 = (GroupRecipientViewModel) this.B.getValue();
        BaseFlowUseCase.execute$default(groupRecipientViewModel2.MyBillsEntityDataFactory, NoParams.INSTANCE, null, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getConfigMaxParticipant$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.OnSuccessGetMaxGroupParticipant(i)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getConfigMaxParticipant$2
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GROUP_SEND_EXCEPTION, th.getMessage(), th);
                mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.Error(0, th, GroupSendOperationType.GROUP_SEND_MAX_PARTICIPANT, 1, null)));
            }
        }, null, ViewModelKt.PlaceComponentResult(groupRecipientViewModel2), 18, null);
        final GroupRecipientViewModel groupRecipientViewModel3 = (GroupRecipientViewModel) this.B.getValue();
        BaseFlowUseCase.execute$default(groupRecipientViewModel3.NetworkUserEntityData$$ExternalSyntheticLambda0, NoParams.INSTANCE, null, new Function1<UserInfoResponse, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getUserInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                final GroupRecipientViewModel groupRecipientViewModel4 = GroupRecipientViewModel.this;
                BaseFlowUseCase.execute$default(groupRecipientViewModel4.moveToNextValue, NoParams.INSTANCE, null, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getPhoneNumber$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(String str3) {
                        invoke2(str3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str3) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(str3, "");
                        mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.OnSuccessGetPhoneNumber(str3)));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getPhoneNumber$2
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GET_USER_INFO_EXCEPTION, th.toString());
                        mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.Error(0, th, "getPhoneNumber", 1, null)));
                    }
                }, null, ViewModelKt.PlaceComponentResult(groupRecipientViewModel4), 18, null);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$getUserInfo$2
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GET_USER_INFO_EXCEPTION, th.getMessage());
                mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.Error(0, th, "getUserInfo", 1, null)));
            }
        }, null, ViewModelKt.PlaceComponentResult(groupRecipientViewModel3), 18, null);
        getGroupSendTrackerHelper().PlaceComponentResult(GroupSendTrackerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = G;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (G[i3 + ((int) (E ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (H[i3 + ((int) (E ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (E ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (getValueOfTouchPositionAbsolute ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = G;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = G;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = H;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
