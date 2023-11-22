package id.dana.social.v2;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.work.WorkInfo;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.contact.DanaContactPresenter;
import id.dana.contract.contact.DanaContactPresenter$$ExternalSyntheticLambda2;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.OauthModule;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.eventbus.base.BaseActivityWithPageLoadTracker;
import id.dana.eventbus.models.TimerEvent;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.extension.view.ViewExtKt;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.share.model.ShareFeedActivity;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.CreateFeedActivityRequestModel;
import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.model.ThirdPartyService;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity;
import id.dana.network.exception.NetworkException;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.ContentGroupingDetailActivity;
import id.dana.social.FeedsIntroduction;
import id.dana.social.ReciprocalBottomSheetDialog;
import id.dana.social.RelationshipBottomSheetDialog;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.adapter.UsernameBannerAdapter;
import id.dana.social.common.FeedOnboardingListener;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.FriendsFeedsModule;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.mapper.FeedTrackerModelMapperKt;
import id.dana.social.mapper.FeedViewModelMapperKt;
import id.dana.social.mapper.FriendModelMapperKt;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.model.ReactionCountModel;
import id.dana.social.utils.Content;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.SocialSyncManagerKt;
import id.dana.social.v2.adapter.FeedShareActivityBannerAdapter;
import id.dana.social.v2.adapter.NewSocialFeedsAdapter;
import id.dana.social.v2.adapter.TopFriendsAdapter;
import id.dana.social.v2.fragment.ShareActivityBottomSheetDialog;
import id.dana.social.v2.model.FeedDeeplinkActivityDetailModel;
import id.dana.social.v2.view.FeedOnboardingView;
import id.dana.social.v2.view.FeedPullToRefreshView;
import id.dana.social.view.activity.SocialProfileActivity;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import id.dana.social.view.activity.notification.FeedNotificationActivity;
import id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.util.AndroidComponentUtilsKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u007f2\u00020\u0001:\u0001\u007fB\u0007¢\u0006\u0004\b~\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0005\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001b\u0010\u0004J\u001f\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\n\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0005\u0010\"J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010\u0004R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010'R\u0016\u0010\u0005\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010*R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0013\u0010\n\u001a\u00020/X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010\u0006\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010%\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020>8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0013\u0010\r\u001a\u00020BX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bC\u00101R\"\u0010E\u001a\u00020D8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bM\u0010LR\u0016\u00102\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bN\u0010LR\u001b\u0010,\u001a\u00020\f8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bO\u00101\u001a\u0004\bA\u0010\u000eR\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bP\u0010LR\u0016\u0010<\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bQ\u0010LR\u0018\u00100\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010O\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010M\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b_\u0010LR\"\u0010a\u001a\u00020`8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0013\u0010N\u001a\u00020gX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bh\u00101R\u0013\u0010C\u001a\u00020iX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bj\u00101R\"\u0010p\u001a\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010\u0012R\u0016\u0010K\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bq\u0010LR\u0016\u0010S\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\br\u0010LR\u0014\u0010_\u001a\u00020s8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010V\u001a\u00020v8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010Q\u001a\u00020y8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0013\u0010P\u001a\u00020|X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b}\u00101"}, d2 = {"Lid/dana/social/v2/FeedsActivity;", "Lid/dana/eventbus/base/BaseActivityWithPageLoadTracker;", "", "configToolbar", "()V", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "", "getLayout", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", IAPSyncCommand.COMMAND_INIT, "", "scheduleImpl", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "p0", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "onClickRightMenuButton", "(Landroid/view/View;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "Lid/dana/eventbus/models/TimerEvent;", "timerEvent", "", "millisecond", "onTimerEnd", "(Lid/dana/eventbus/models/TimerEvent;J)V", "(Z)V", "(I)V", "moveToNextValue", "getErrorConfigVersion", "Lcom/google/android/material/badge/BadgeDrawable;", "Lcom/google/android/material/badge/BadgeDrawable;", "PlaceComponentResult", "Landroidx/recyclerview/widget/ConcatAdapter;", "Landroidx/recyclerview/widget/ConcatAdapter;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "GetContactSyncConfig", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "MyBillsEntityDataFactory", "Lid/dana/social/view/fragment/ContactPermissionBottomSheetDialogFragment;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/Lazy;", "DatabaseTableConfigUtil", "I", "Lid/dana/contract/contact/DanaContactPresenter;", "danaContactPresenter", "Lid/dana/contract/contact/DanaContactPresenter;", "getDanaContactPresenter", "()Lid/dana/contract/contact/DanaContactPresenter;", "setDanaContactPresenter", "(Lid/dana/contract/contact/DanaContactPresenter;)V", "Lid/dana/domain/social/model/FeedConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/social/model/FeedConfig;", "Lid/dana/social/v2/adapter/FeedShareActivityBannerAdapter;", "initRecordTimeStamp", "Lid/dana/social/v2/adapter/FeedShareActivityBannerAdapter;", "lookAheadTest", "Lid/dana/social/FeedsIntroduction;", "isLayoutRequested", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda4", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$Presenter;", "presenter", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$Presenter;", "getPresenter", "()Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$Presenter;", "setPresenter", "(Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "settingPresenter", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "getSettingPresenter", "()Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "setSettingPresenter", "(Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;)V", "Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog;", "getCallingPid", "Lcom/afollestad/materialdialogs/MaterialDialog;", "SubSequence", "readMicros", "Ljava/lang/String;", "getShareFeedRequestId", "()Ljava/lang/String;", "setShareFeedRequestId", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, "getSupportButtonTintMode", "whenAvailable", "Lid/dana/social/v2/FeedsActivity$getSocialAdapterListener$1;", "C", "Lid/dana/social/v2/FeedsActivity$getSocialAdapterListener$1;", "Lid/dana/social/v2/adapter/NewSocialFeedsAdapter;", DiskFormatter.B, "Lid/dana/social/v2/adapter/NewSocialFeedsAdapter;", "Lid/dana/social/v2/adapter/TopFriendsAdapter;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/social/v2/adapter/TopFriendsAdapter;", "Lid/dana/social/adapter/UsernameBannerAdapter;", "VerifyPinStateManager$executeRiskChallenge$2$1", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsActivity extends BaseActivityWithPageLoadTracker {
    private static int A = 0;
    public static final String ACTIVITY_DETAIL_DEEPLINK_BUNDLE = "activityDetailDeeplinkBundle";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static short[] D = null;
    public static final String SOURCE = "Timeline";
    private static int VerifyPinStateManager$executeRiskChallenge$2$2;
    private static int getOnBoardingScenario;
    private static byte[] getValueOfTouchPositionAbsolute;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final ActivityPermissionRequest MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private BadgeDrawable PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private FeedConfig getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private PreviewActivityData NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private MyFeedHeaderModel PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public DanaContactPresenter danaContactPresenter;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    @Inject
    public FriendFeedsContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ConcatAdapter getAuthRequestContext;
    @Inject
    public RelationshipBottomSheetContract.Presenter settingPresenter;
    public static final byte[] $$g = {84, -107, -124, 66, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 62;
    public static final byte[] lookAheadTest = {Ascii.EM, -104, -116, 103, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getErrorConfigVersion = 65;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy scheduleImpl = LazyKt.lazy(new Function0<FeedsIntroduction>() { // from class: id.dana.social.v2.FeedsActivity$feedsIntroduction$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FeedsIntroduction invoke() {
            return new FeedsIntroduction(FeedsActivity.this);
        }
    });

    /* renamed from: B */
    private final NewSocialFeedsAdapter NetworkUserEntityData$$ExternalSyntheticLambda6 = new NewSocialFeedsAdapter();

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private final TopFriendsAdapter FragmentBottomSheetPaymentSettingBinding = new TopFriendsAdapter();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final FeedShareActivityBannerAdapter lookAheadTest = new FeedShareActivityBannerAdapter(new Function1<Integer, Unit>() { // from class: id.dana.social.v2.FeedsActivity$feedShareActivityBannerAdapter$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i) {
            FeedsActivity.access$setupShareActivityBottomSheet(FeedsActivity.this, i);
        }
    });

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda4 = LazyKt.lazy(new Function0<UsernameBannerAdapter>() { // from class: id.dana.social.v2.FeedsActivity$usernameBannerAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UsernameBannerAdapter invoke() {
            final FeedsActivity feedsActivity = FeedsActivity.this;
            return new UsernameBannerAdapter(new Function0<Unit>() { // from class: id.dana.social.v2.FeedsActivity$usernameBannerAdapter$2.1
                private static int $10 = 0;
                private static int $11 = 1;
                private static int $MyBillsEntityDataFactory = 1;
                private static int $PlaceComponentResult = 0;
                private static char BuiltInFictitiousFunctionClassFactory = 42065;
                private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {37290, 37461, 37309, 37306, 37281, 37463, 37286, 37264, 37460, 37308, 37307, 37292, 37287, 37294, 37282, 37288};

                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Unit invoke() {
                    Unit unit;
                    int i = $PlaceComponentResult + 45;
                    $MyBillsEntityDataFactory = i % 128;
                    Object obj = null;
                    if ((i % 2 == 0 ? '9' : (char) 25) != '9') {
                        try {
                            invoke2();
                            unit = Unit.INSTANCE;
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        try {
                            invoke2();
                            unit = Unit.INSTANCE;
                            obj.hashCode();
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    int i2 = $MyBillsEntityDataFactory + 113;
                    $PlaceComponentResult = i2 % 128;
                    if (!(i2 % 2 != 0)) {
                        return unit;
                    }
                    obj.hashCode();
                    return unit;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    int i = $MyBillsEntityDataFactory + 67;
                    $PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    ((UsernameBannerAdapter) FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).setItems(CollectionsKt.emptyList());
                    RelationshipBottomSheetContract.Presenter settingPresenter = FeedsActivity.this.getSettingPresenter();
                    Object[] objArr = new Object[1];
                    a(new char[]{'\b', 1, 13886, 13886, 7, 5, 3, 11, 1, 11, 1, 3, 5, '\f', '\f', 2, 11, 15, '\r', 14, 7, '\f', 13903}, (byte) (80 - (ViewConfiguration.getPressedStateDuration() >> 16)), 22 - ImageFormat.getBitsPerPixel(0), objArr);
                    settingPresenter.KClassImpl$Data$declaredNonStaticMembers$2(((String) objArr[0]).intern());
                    int i3 = $PlaceComponentResult + 55;
                    $MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
                
                    if ((r0.MyBillsEntityDataFactory != r0.PlaceComponentResult) != false) goto L46;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:44:0x00a4, code lost:
                
                    if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L45;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:
                
                    r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r12);
                    r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r12);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x00b9, code lost:
                
                    r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
                    r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
                    r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
                    r0.lookAheadTest = r0.PlaceComponentResult % r2;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:47:0x00d1, code lost:
                
                    if (r0.scheduleImpl != r0.lookAheadTest) goto L49;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:
                
                    r7 = id.dana.social.v2.FeedsActivity$usernameBannerAdapter$2.AnonymousClass1.$11 + 117;
                    id.dana.social.v2.FeedsActivity$usernameBannerAdapter$2.AnonymousClass1.$10 = r7 % 128;
                    r7 = r7 % 2;
                    r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
                    r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
                    r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
                    r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
                    r3[r0.getAuthRequestContext] = r1[r7];
                    r3[r0.getAuthRequestContext + 1] = r1[r8];
                 */
                /* JADX WARN: Code restructure failed: missing block: B:50:0x010b, code lost:
                
                    if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L61;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x010d, code lost:
                
                    r7 = id.dana.social.v2.FeedsActivity$usernameBannerAdapter$2.AnonymousClass1.$10 + 59;
                    id.dana.social.v2.FeedsActivity$usernameBannerAdapter$2.AnonymousClass1.$11 = r7 % 128;
                    r7 = r7 % 2;
                    r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
                    r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
                    r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
                    r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
                    r3[r0.getAuthRequestContext] = r1[r7];
                    r3[r0.getAuthRequestContext + 1] = r1[r8];
                 */
                /* JADX WARN: Code restructure failed: missing block: B:52:0x0141, code lost:
                
                    r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
                    r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
                    r3[r0.getAuthRequestContext] = r1[r7];
                    r3[r0.getAuthRequestContext + 1] = r1[r8];
                 */
                /* JADX WARN: Code restructure failed: missing block: B:54:0x0164, code lost:
                
                    r11 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:55:0x0165, code lost:
                
                    throw r11;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private static void a(char[] r11, byte r12, int r13, java.lang.Object[] r14) {
                    /*
                        Method dump skipped, instructions count: 379
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.FeedsActivity$usernameBannerAdapter$2.AnonymousClass1.a(char[], byte, int, java.lang.Object[]):void");
                }
            });
        }
    });

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final Lazy newProxyInstance = LazyKt.lazy(new Function0<ShareActivityBottomSheetDialog>() { // from class: id.dana.social.v2.FeedsActivity$shareActivityBottomSheetDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ShareActivityBottomSheetDialog invoke() {
            ShareActivityBottomSheetDialog.Builder builder = new ShareActivityBottomSheetDialog.Builder(null, null, FeedsActivity.this, false, 11, null);
            final FeedsActivity feedsActivity = FeedsActivity.this;
            Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: id.dana.social.v2.FeedsActivity$shareActivityBottomSheetDialog$2.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str, String str2) {
                    PreviewActivityData previewActivityData;
                    PreviewActivityData previewActivityData2;
                    PreviewActivityData previewActivityData3;
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    FriendshipAnalyticTracker friendshipAnalyticTracker = FeedsActivity.this.getFriendshipAnalyticTracker();
                    previewActivityData = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    String contentType = previewActivityData != null ? previewActivityData.getContentType() : null;
                    friendshipAnalyticTracker.scheduleImpl(contentType != null ? contentType : "");
                    FriendFeedsContract.Presenter presenter = FeedsActivity.this.getPresenter();
                    String str3 = FeedsActivity.this.getId.dana.domain.social.ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID java.lang.String();
                    previewActivityData2 = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    HashMap<String, String> extendInfo = previewActivityData2 != null ? previewActivityData2.getExtendInfo() : null;
                    previewActivityData3 = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    presenter.MyBillsEntityDataFactory(new CreateFeedActivityRequestModel(str3, str, str2, null, null, extendInfo, false, previewActivityData3 != null ? previewActivityData3.getWidget() : null, 88, null));
                    FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
                }
            };
            Intrinsics.checkNotNullParameter(function2, "");
            builder.BuiltInFictitiousFunctionClassFactory = function2;
            final FeedsActivity feedsActivity2 = FeedsActivity.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.v2.FeedsActivity$shareActivityBottomSheetDialog$2.2
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
                    FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
                    FeedsActivity.this.getPresenter().MyBillsEntityDataFactory(FeedsActivity.this.getId.dana.domain.social.ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID java.lang.String());
                    FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.PlaceComponentResult = function0;
            builder.MyBillsEntityDataFactory = true;
            return builder.PlaceComponentResult();
        }
    });

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private final Lazy isLayoutRequested = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.social.v2.FeedsActivity$shareFeedConsentDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MaterialDialog invoke() {
            CustomDialog.Builder builder = new CustomDialog.Builder(FeedsActivity.this);
            final FeedsActivity feedsActivity = FeedsActivity.this;
            builder.SubSequence = feedsActivity.getString(R.string.share_activity_consent_dialog_title);
            builder.GetContactSyncConfig = feedsActivity.getString(R.string.share_activity_consent_dialog_description);
            builder.KClassImpl$Data$declaredNonStaticMembers$2(false);
            builder.PlaceComponentResult(false);
            builder.BuiltInFictitiousFunctionClassFactory(feedsActivity.getString(R.string.share_activity_consent_dialog_positive_button), new Function1<View, Unit>() { // from class: id.dana.social.v2.FeedsActivity$shareFeedConsentDialog$2$1$1
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
                    FeedsActivity.this.getPresenter().getAuthRequestContext();
                }
            });
            builder.KClassImpl$Data$declaredNonStaticMembers$2(feedsActivity.getString(R.string.cancel_action), new Function1<View, Unit>() { // from class: id.dana.social.v2.FeedsActivity$shareFeedConsentDialog$2$1$2
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
                    FeedsActivity.access$getShareFeedConsentDialog(FeedsActivity.this).dismiss();
                }
            });
            return builder.BuiltInFictitiousFunctionClassFactory();
        }
    });

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy GetContactSyncConfig = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.social.v2.FeedsActivity$isMeRevampEnabled$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Boolean isMePageRevamp = FeedsActivity.this.getDanaApplication().getIsMePageRevamp();
            return Boolean.valueOf(isMePageRevamp == null ? false : isMePageRevamp.booleanValue());
        }
    });

    /* renamed from: C  reason: from kotlin metadata */
    private final FeedsActivity$getSocialAdapterListener$1 NetworkUserEntityData$$ExternalSyntheticLambda3 = new SocialFeedClickListener() { // from class: id.dana.social.v2.FeedsActivity$getSocialAdapterListener$1
        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ReactionCountModel reactionCountModel) {
            SocialFeedClickListener.CC.BuiltInFictitiousFunctionClassFactory(reactionCountModel);
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
            SocialFeedClickListener.CC.PlaceComponentResult();
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ProfileCtaConfig profileCtaConfig, String str, String str2) {
            SocialFeedClickListener.CC.getAuthRequestContext(profileCtaConfig, str, str2);
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            SocialFeedClickListener.CC.PlaceComponentResult(str);
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final /* synthetic */ void MyBillsEntityDataFactory() {
            SocialFeedClickListener.CC.MyBillsEntityDataFactory();
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final /* synthetic */ void PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final /* synthetic */ void PlaceComponentResult(String str, String str2) {
            SocialFeedClickListener.CC.MyBillsEntityDataFactory(str, str2);
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(Content p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final /* synthetic */ void getAuthRequestContext(String str, String str2) {
            SocialFeedClickListener.CC.getAuthRequestContext(str, str2);
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void MyBillsEntityDataFactory(int p0) {
            NewSocialFeedsAdapter newSocialFeedsAdapter;
            NewSocialFeedsAdapter newSocialFeedsAdapter2;
            newSocialFeedsAdapter = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (newSocialFeedsAdapter.getPlaceComponentResult()) {
                newSocialFeedsAdapter2 = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                FeedViewHolderModel item = newSocialFeedsAdapter2.getItem(p0);
                if (item != null) {
                    FeedsActivity.access$handleBubbleClick(FeedsActivity.this, item);
                }
            }
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(int p0) {
            NewSocialFeedsAdapter newSocialFeedsAdapter;
            GroupedFeedModel groupedFeedModel;
            newSocialFeedsAdapter = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            FeedViewHolderModel item = newSocialFeedsAdapter.getItem(p0);
            if (item == null || (groupedFeedModel = item.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            FeedsActivity.access$openContentGroupingActivity(FeedsActivity.this, groupedFeedModel.BuiltInFictitiousFunctionClassFactory, groupedFeedModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
            NewSocialFeedsAdapter newSocialFeedsAdapter;
            newSocialFeedsAdapter = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            FeedViewHolderModel item = newSocialFeedsAdapter.getItem(p0);
            if (item != null) {
                FeedsActivity feedsActivity = FeedsActivity.this;
                FeedModel feedModel = item.MyBillsEntityDataFactory;
                if (feedModel == null || !feedModel.moveToNextValue()) {
                    return;
                }
                FeedsActivity.access$handleOpenProfile(feedsActivity, FeedViewModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(feedModel));
            }
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void BuiltInFictitiousFunctionClassFactory(FriendModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            FeedsActivity.access$handleOpenProfile(FeedsActivity.this, FriendModelMapperKt.PlaceComponentResult(p0));
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void PlaceComponentResult() {
            NewSocialFeedsAdapter newSocialFeedsAdapter;
            newSocialFeedsAdapter = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            newSocialFeedsAdapter.PlaceComponentResult(7, 6);
            FeedsActivity.this.moveToNextValue = true;
            FeedsActivity.this.getPresenter().NetworkUserEntityData$$ExternalSyntheticLambda1();
            FeedsActivity.this.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void BuiltInFictitiousFunctionClassFactory(int p0) {
            NewSocialFeedsAdapter newSocialFeedsAdapter;
            NewSocialFeedsAdapter newSocialFeedsAdapter2;
            newSocialFeedsAdapter = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            FeedModel feedModel = newSocialFeedsAdapter.getItem(p0).MyBillsEntityDataFactory;
            if (feedModel != null) {
                FeedsActivity feedsActivity = FeedsActivity.this;
                newSocialFeedsAdapter2 = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
                newSocialFeedsAdapter2.BuiltInFictitiousFunctionClassFactory(p0, FeedActivityState.INIT);
                FriendFeedsContract.Presenter presenter = feedsActivity.getPresenter();
                HashMap<String, String> hashMap = feedModel.lookAheadTest;
                ActivityWidget activityWidget = null;
                String shareFeedRequestId = hashMap != null ? ExtendInfoUtilKt.getShareFeedRequestId(hashMap) : null;
                String str = shareFeedRequestId == null ? "" : shareFeedRequestId;
                String str2 = feedModel.scheduleImpl;
                String str3 = str2 == null ? "" : str2;
                String str4 = feedModel.MyBillsEntityDataFactory;
                String str5 = str4 == null ? "" : str4;
                HashMap<String, String> hashMap2 = feedModel.lookAheadTest;
                ActivityWidgetModel activityWidgetModel = feedModel.KClassImpl$Data$declaredNonStaticMembers$2;
                if (activityWidgetModel != null) {
                    ActivityWidgetModel.Companion companion = ActivityWidgetModel.INSTANCE;
                    activityWidget = ActivityWidgetModel.Companion.MyBillsEntityDataFactory(activityWidgetModel);
                }
                presenter.MyBillsEntityDataFactory(new CreateFeedActivityRequestModel(str, str3, str5, null, null, hashMap2, true, activityWidget, 24, null));
            }
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void PlaceComponentResult(int p0) {
            NewSocialFeedsAdapter newSocialFeedsAdapter;
            NewSocialFeedsAdapter newSocialFeedsAdapter2;
            newSocialFeedsAdapter = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            FeedModel feedModel = newSocialFeedsAdapter.getItem(p0).MyBillsEntityDataFactory;
            if (feedModel != null) {
                FeedsActivity feedsActivity = FeedsActivity.this;
                newSocialFeedsAdapter2 = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
                HashMap<String, String> hashMap = feedModel.lookAheadTest;
                String shareFeedRequestId = hashMap != null ? ExtendInfoUtilKt.getShareFeedRequestId(hashMap) : null;
                if (shareFeedRequestId == null) {
                    shareFeedRequestId = "";
                }
                String string = feedsActivity.getString(R.string.feed_section_today);
                Intrinsics.checkNotNullExpressionValue(string, "");
                newSocialFeedsAdapter2.MyBillsEntityDataFactory(shareFeedRequestId, string);
                FriendFeedsContract.Presenter presenter = feedsActivity.getPresenter();
                HashMap<String, String> hashMap2 = feedModel.lookAheadTest;
                String shareFeedRequestId2 = hashMap2 != null ? ExtendInfoUtilKt.getShareFeedRequestId(hashMap2) : null;
                presenter.BuiltInFictitiousFunctionClassFactory(shareFeedRequestId2 != null ? shareFeedRequestId2 : "");
            }
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext() {
            SocialFeedClickListener.CC.getAuthRequestContext();
            FeedsActivity.access$setEmptyListSeeAllFriendBtnClick(FeedsActivity.this);
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void BuiltInFictitiousFunctionClassFactory(ActivityWidgetModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            FeedsActivity.this.getFriendshipAnalyticTracker().getAuthRequestContext(FeedTrackerModelMapperKt.PlaceComponentResult(p0));
            FeedsActivity.this.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0.getAuthRequestContext);
        }

        @Override // id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(String p0, DealsPayloadModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            FeedsActivity.this.getFriendshipAnalyticTracker().getAuthRequestContext(FeedTrackerModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(p1, p0));
            FriendFeedsContract.Presenter presenter = FeedsActivity.this.getPresenter();
            String str = (String) MapsKt.getOrImplicitDefaultNullable(p1.PlaceComponentResult, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[1].getName());
            if (str == null) {
                str = "";
            }
            String str2 = (String) MapsKt.getOrImplicitDefaultNullable(p1.BuiltInFictitiousFunctionClassFactory, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[2].getName());
            presenter.MyBillsEntityDataFactory(str, str2 != null ? str2 : "");
        }
    };

    /* renamed from: readMicros  reason: from kotlin metadata */
    private String id.dana.domain.social.ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID java.lang.String = "";

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5 = true;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil = true;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ContactPermissionBottomSheetDialogFragment>() { // from class: id.dana.social.v2.FeedsActivity$contactPermissionBottomSheetDialogFragment$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ContactPermissionBottomSheetDialogFragment invoke() {
            return new ContactPermissionBottomSheetDialogFragment();
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        VerifyPinStateManager$executeRiskChallenge$2$2 = 1257195691;
        getOnBoardingScenario = 398943056;
        getValueOfTouchPositionAbsolute = new byte[]{121, 34, 41, TarHeader.LF_SYMLINK, 91, 81, 10, 32, 90, TarHeader.LF_SYMLINK, 88, TarHeader.LF_NORMAL, 84, 67, 82, -25, 37, 86, 114, Ascii.ESC, 42, 43, 40, 87, 47, 88, 65, 95, 88, 41, 75, 32, 36, 33, 34, 94, 111, 17, 88, 85, 43, 94, 33, 76, 65, 98, -108, 96, 110, 101, Byte.MIN_VALUE, Byte.MIN_VALUE, 39, -98, -95, 88, 103, 104, 101, -108, 108, -107, 78, 86, 125, TarHeader.LF_DIR, 69, 99, 3, -17, -95, 6, -16, -92, 3, -21, -6, -13, -33, 5, -21, -10, -11, -34, -18, -11, 0, -92, 6, -19, -93, 4, -33, -14, -13, -17, 7, -19, -14, -9, -19, -13, -91, -13, -17, -12, 4, -13, -13, -35, 62, -6, -16, -33, 6, -109, 118, -39, -66, 118, -122, -45, -124, -122, -124, -116, -121, -123, -125, -127, -123, -119, -65, -117, 113, -45, 121, -48, -118, -125, -126, 120, -123, -38, -127, 117, -124, -44, -123, 119, -39, 114, -39, 110, -39, -126, -120, Byte.MIN_VALUE, 120, -46, 122, -47, -123, -121, -126, -123, 120, -42, -119, 111, -122, -39, -67, -114, 114, -125, -41, -124, 113, -109, Ascii.GS, -31, -46, TarHeader.LF_LINK, -28, Ascii.GS, -29, Ascii.US, -46, 44, -30, -44, Ascii.US, TarHeader.LF_CONTIG, -50, Ascii.GS, -32, TarHeader.LF_NORMAL, -23, Ascii.GS, Ascii.RS, -42, TarHeader.LF_CHR, -31, Ascii.US, -30, -52, TarHeader.LF_CONTIG, Ascii.ESC, -45, TarHeader.LF_BLK, -51, TarHeader.LF_DIR, -48, -31, TarHeader.LF_CHR, -30, -50, TarHeader.LF_SYMLINK, Ascii.GS, -49, -30, TarHeader.LF_LINK, -45, TarHeader.LF_LINK, -46, Ascii.GS, TarHeader.LF_CONTIG, Ascii.SUB, -28, Ascii.US, -31, -24, -31, -31, Ascii.GS, Ascii.US, -26, -29, -54, -28, 45, -30, -105, 105, 98, -97, 121, -105, -78, 107, 44, -95, 45, 103, -102, 106, 111, 99, -82, 34, 111, -103, -74, 38, 106, -100, -77, 95, 117, -105, 124, 100, 106, -103, 118, -105, 124, -102, -81, 46, 103, -106, 106, 121, -107, 108, 117, -98, 116, -94, 91, 117, -101, 107, -77, 104, 115, 33, 101, 108, 104, -100, 77, 72, 67, 77, 65, 82};
        A = -1757692427;
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    private static void h(byte b, byte b2, byte b3, Object[] objArr) {
        byte[] bArr = lookAheadTest;
        int i = b + 16;
        int i2 = b2 + 4;
        int i3 = 106 - b3;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            i3 = (i5 + i3) - 4;
            i5 = i5;
            i2 = i2;
        }
        while (true) {
            i4++;
            int i6 = i2 + 1;
            bArr2[i4] = (byte) i3;
            if (i4 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + bArr[i6]) - 4;
            i5 = i5;
            i2 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r0 = id.dana.social.v2.FeedsActivity.$$g
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r9 = r9 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.FeedsActivity.j(int, byte, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void openActivity(Context context, FeedDeeplinkActivityDetailModel feedDeeplinkActivityDetailModel) {
        Companion.BuiltInFictitiousFunctionClassFactory(context, feedDeeplinkActivityDetailModel);
    }

    @JvmStatic
    public static final void openActivity(Context context, String str) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, str);
    }

    @JvmStatic
    public static final void openActivity(Context context, String str, String str2) {
        Companion.getAuthRequestContext(context, str, str2);
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
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

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g((-1562913646) - View.MeasureSpec.getSize(0), 573246145 - ImageFormat.getBitsPerPixel(0), (short) (3 - (ViewConfiguration.getTapTimeout() >> 16)), (byte) (ViewConfiguration.getFadingEdgeLength() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 53, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g((-1562913635) - ImageFormat.getBitsPerPixel(0), 573246164 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (short) ((ViewConfiguration.getEdgeSlop() >> 16) + 50), (byte) (ViewConfiguration.getLongPressTimeout() >> 16), (-54) - TextUtils.lastIndexOf("", '0', 0, 0), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myTid() >> 22), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1562913689, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 573246169, (short) ((ViewConfiguration.getEdgeSlop() >> 16) - 109), (byte) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (-53) - View.resolveSize(0, 0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g((-1562913646) - (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 573246217, (short) ((-26) - Drawable.resolveOpacity(0, 0)), (byte) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (-52) - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g((-1562913692) - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 573246281 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (short) (ExpandableListView.getPackedPositionChild(0L) - 125), (byte) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (-53) - (ViewConfiguration.getKeyRepeatDelay() >> 16), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g((-1562913639) - Color.blue(0), ExpandableListView.getPackedPositionType(0L) + 573246345, (short) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 9), (byte) Color.red(0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) - 53, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g((-1562913687) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 573246405 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (short) (TextUtils.indexOf((CharSequence) "", '0', 0) + 41), (byte) View.MeasureSpec.getMode(0), (ViewConfiguration.getPressedStateDuration() >> 16) - 53, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), 'B' - AndroidCharacter.getMirror('0'), (char) TextUtils.getOffsetBefore("", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = lookAheadTest[25];
                Object[] objArr13 = new Object[1];
                h(b, (byte) (b | 36), lookAheadTest[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = lookAheadTest[25];
                Object[] objArr14 = new Object[1];
                h(b2, (byte) (b2 | Ascii.NAK), lookAheadTest[7], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 55, 3 - Gravity.getAbsoluteGravity(0, 0), (char) Color.red(0));
                        byte b3 = $$g[47];
                        Object[] objArr16 = new Object[1];
                        j(b3, b3, $$g[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15, (char) KeyEvent.normalizeMetaState(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0), 15 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 28, (char) (57994 - KeyEvent.keyCodeFromString("")))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 15, (char) (Process.myTid() >> 22)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), 35 - ExpandableListView.getPackedPositionGroup(0L), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-888733974, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = lookAheadTest[25];
                Object[] objArr19 = new Object[1];
                h(b4, (byte) (b4 | 36), lookAheadTest[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = lookAheadTest[25];
                Object[] objArr20 = new Object[1];
                h(b5, (byte) (b5 | Ascii.NAK), lookAheadTest[7], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 60, View.MeasureSpec.makeMeasureSpec(0, 0) + 46, (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr22 = new Object[1];
                        j((byte) (-$$g[9]), (byte) ($$g[47] - 1), (byte) (-$$g[28]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-888733974, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, TextUtils.indexOf("", "", 0, 0) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = lookAheadTest[25];
                Object[] objArr25 = new Object[1];
                h(b6, (byte) (b6 | 36), lookAheadTest[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = lookAheadTest[25];
                Object[] objArr26 = new Object[1];
                h(b7, (byte) (b7 | Ascii.NAK), lookAheadTest[7], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 118, 3 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (38968 - (Process.myPid() >> 22)));
                        Object[] objArr28 = new Object[1];
                        j((byte) (-$$g[9]), (byte) ($$g[47] - 1), (byte) (-$$g[28]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-888733974, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b8 = lookAheadTest[25];
                Object[] objArr31 = new Object[1];
                h(b8, (byte) (b8 | 36), lookAheadTest[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = lookAheadTest[25];
                Object[] objArr32 = new Object[1];
                h(b9, (byte) (b9 | Ascii.NAK), lookAheadTest[7], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 107, Process.getGidForName("") + 4, (char) ((Process.getThreadPriority(0) + 20) >> 6));
                        Object[] objArr34 = new Object[1];
                        j((byte) ($$g[47] - 1), (byte) (-$$g[8]), $$g[40], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-888733974, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, MotionEvent.axisFromString("") + 19, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_feeds;
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr3);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 1562913679;
            int myTid = 573246146 - (Process.myTid() >> 22);
            short codePointAt = (short) (getPackageName().codePointAt(6) - 94);
            try {
                Object[] objArr4 = new Object[1];
                h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], new Object[1]);
                Object[] objArr5 = new Object[1];
                g(i, myTid, codePointAt, (byte) (((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.you_can_send_money_via_agent).substring(41, 49).codePointAt(6) - 169, objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                int codePointAt2 = getPackageName().codePointAt(2) - 1562913680;
                int indexOf = 573246164 - TextUtils.indexOf("", "", 0, 0);
                short length = (short) (super.getResources().getString(R.string.approve_friend_request_success_message).substring(0, 3).length() + 47);
                try {
                    Object[] objArr6 = new Object[1];
                    h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr6);
                    Class<?> cls4 = Class.forName((String) objArr6[0]);
                    h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], new Object[1]);
                    Object[] objArr7 = new Object[1];
                    g(codePointAt2, indexOf, length, (byte) (((ApplicationInfo) cls4.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33), KeyEvent.normalizeMetaState(0) - 53, objArr7);
                    int intValue = ((Integer) cls3.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            Object[] objArr8 = new Object[1];
                            g(super.getResources().getString(R.string.total_price_idr).substring(0, 6).length() - 1562913652, View.resolveSizeAndState(0, 0, 0) + 573246102, (short) (super.getResources().getString(R.string.input_phone_number_warning_text).substring(18, 19).codePointAt(0) - 40), (byte) TextUtils.indexOf("", ""), super.getResources().getString(R.string.pushverify_list_empty_title).substring(5, 6).length() - 54, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            int axisFromString = MotionEvent.axisFromString("") - 1562913643;
                            int codePointAt3 = super.getResources().getString(R.string.loyalty_asset_number_label).substring(0, 6).codePointAt(2) + 573246019;
                            try {
                                Object[] objArr9 = new Object[1];
                                h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr9);
                                Class<?> cls6 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr10);
                                Object[] objArr11 = new Object[1];
                                g(axisFromString, codePointAt3, (short) (((ApplicationInfo) cls6.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 30), (byte) (super.getResources().getString(R.string.lbl_dialog_call_customer_care).substring(7, 21).length() - 14), (-53) - (Process.myTid() >> 22), objArr11);
                                baseContext = (Context) cls5.getMethod((String) objArr11[0], new Class[0]).invoke(null, null);
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
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), View.MeasureSpec.getSize(0) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) - 1562913688;
                                int codePointAt4 = super.getResources().getString(R.string.bottom_on_boarding_body_text_request_money_fourth).substring(14, 15).codePointAt(0) + 573246059;
                                short codePointAt5 = (short) (super.getResources().getString(R.string.paylater_limit_not_enough).substring(14, 15).codePointAt(0) - 141);
                                byte makeMeasureSpec = (byte) View.MeasureSpec.makeMeasureSpec(0, 0);
                                try {
                                    Object[] objArr12 = new Object[1];
                                    h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr12);
                                    Class<?> cls7 = Class.forName((String) objArr12[0]);
                                    Object[] objArr13 = new Object[1];
                                    h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr13);
                                    int i2 = ((ApplicationInfo) cls7.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion - 86;
                                    Object[] objArr14 = new Object[1];
                                    g(fadingEdgeLength, codePointAt4, codePointAt5, makeMeasureSpec, i2, objArr14);
                                    String str = (String) objArr14[0];
                                    Object[] objArr15 = new Object[1];
                                    g(getPackageName().codePointAt(2) - 1562913692, 573246217 - TextUtils.getOffsetBefore("", 0), (short) (getPackageName().length() - 33), (byte) (super.getResources().getString(R.string.nearby_search_result_see_on_map).substring(0, 19).length() - 19), getPackageName().codePointAt(0) - 158, objArr15);
                                    String str2 = (String) objArr15[0];
                                    try {
                                        Object[] objArr16 = new Object[1];
                                        h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr16);
                                        Class<?> cls8 = Class.forName((String) objArr16[0]);
                                        h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], new Object[1]);
                                        Object[] objArr17 = new Object[1];
                                        g(((ApplicationInfo) cls8.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 1562913726, 573246281 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (short) (View.MeasureSpec.getSize(0) - 126), (byte) TextUtils.indexOf("", "", 0, 0), getPackageName().codePointAt(1) - 153, objArr17);
                                        String str3 = (String) objArr17[0];
                                        Object[] objArr18 = new Object[1];
                                        g(super.getResources().getString(R.string.pop_up_description_saving_limit_about_info_non_kyc).substring(91, 93).codePointAt(1) - 1562913755, super.getResources().getString(R.string.passkey_enrollment_failed_description).substring(0, 1).length() + 573246344, (short) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 8), (byte) Drawable.resolveOpacity(0, 0), super.getResources().getString(R.string.error_saving_amount_limit_non_kyc).substring(1, 2).codePointAt(0) - 164, objArr18);
                                        String str4 = (String) objArr18[0];
                                        int codePointAt6 = super.getResources().getString(R.string.ask_the_recipient_to_tap_on).substring(42, 44).codePointAt(0) - 1562913720;
                                        int length2 = super.getResources().getString(R.string.profile_completion_task_description_trusted_device).substring(1, 2).length() + 573246404;
                                        try {
                                            Object[] objArr19 = new Object[1];
                                            h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr19);
                                            Class<?> cls9 = Class.forName((String) objArr19[0]);
                                            Object[] objArr20 = new Object[1];
                                            h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr20);
                                            short s = (short) (((ApplicationInfo) cls9.getMethod((String) objArr20[0], null).invoke(this, null)).targetSdkVersion + 7);
                                            try {
                                                Object[] objArr21 = new Object[1];
                                                h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr21);
                                                Class<?> cls10 = Class.forName((String) objArr21[0]);
                                                h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], new Object[1]);
                                                Object[] objArr22 = new Object[1];
                                                g(codePointAt6, length2, s, (byte) (((ApplicationInfo) cls10.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), (-53) - KeyEvent.keyCodeFromString(""), objArr22);
                                                try {
                                                    Object[] objArr23 = {baseContext, str, str2, str3, str4, true, (String) objArr22[0], 995651014};
                                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                    if (obj2 == null) {
                                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                    }
                                                    ((Method) obj2).invoke(invoke, objArr23);
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
                        byte b = lookAheadTest[25];
                        Object[] objArr24 = new Object[1];
                        h(b, (byte) (b | 36), lookAheadTest[25], objArr24);
                        Class<?> cls11 = Class.forName((String) objArr24[0]);
                        byte b2 = lookAheadTest[25];
                        Object[] objArr25 = new Object[1];
                        h(b2, (byte) (b2 | Ascii.NAK), lookAheadTest[7], objArr25);
                        try {
                            Object[] objArr26 = {Integer.valueOf(((Integer) cls11.getMethod((String) objArr25[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls12 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getEdgeSlop() >> 16), 5 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                                Object[] objArr27 = new Object[1];
                                j((byte) ($$g[47] - 1), (byte) (-$$g[8]), $$g[40], objArr27);
                                obj3 = cls12.getMethod((String) objArr27[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr28 = (Object[]) ((Method) obj3).invoke(null, objArr26);
                            int i3 = ((int[]) objArr28[1])[0];
                            if (((int[]) objArr28[0])[0] != i3) {
                                long j = ((r2 ^ i3) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr29 = {243738787, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, 18 - TextUtils.getOffsetAfter("", 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr29);
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
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        } catch (Throwable th14) {
            Throwable cause14 = th14.getCause();
            if (cause14 == null) {
                throw th14;
            }
            throw cause14;
        }
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 1562913679;
                int capsMode = 573246102 - TextUtils.getCapsMode("", 0, 0);
                try {
                    Object[] objArr3 = new Object[1];
                    h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr4);
                    Object[] objArr5 = new Object[1];
                    g(i, capsMode, (short) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 37), (byte) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (-53) - KeyEvent.keyCodeFromString(""), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    int codePointAt = super.getResources().getString(R.string.tix_button_title).substring(0, 1).codePointAt(0) - 1562913710;
                    int length = super.getResources().getString(R.string.com_mixpanel_android_notification_image).substring(0, 5).length() + 573246123;
                    try {
                        Object[] objArr6 = new Object[1];
                        h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr7);
                        Object[] objArr8 = new Object[1];
                        g(codePointAt, length, (short) (((ApplicationInfo) cls4.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 30), (byte) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), super.getResources().getString(R.string.auto_routing_success_deactivation).substring(23, 25).codePointAt(1) - 153, objArr8);
                        baseContext = (Context) cls3.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr9 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr9);
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
        super.onPause();
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [id.dana.social.v2.FeedsActivity$getSocialAdapterListener$1] */
    public FeedsActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.social.v2.FeedsActivity$contactPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    FeedsActivity.access$checkFeedStatus(FeedsActivity.this);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(final PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FeedsActivity.access$getContactPermissionBottomSheetDialogFragment(FeedsActivity.this).show(FeedsActivity.this.getSupportFragmentManager(), "");
                ContactPermissionBottomSheetDialogFragment access$getContactPermissionBottomSheetDialogFragment = FeedsActivity.access$getContactPermissionBottomSheetDialogFragment(FeedsActivity.this);
                final FeedsActivity feedsActivity = FeedsActivity.this;
                access$getContactPermissionBottomSheetDialogFragment.MyBillsEntityDataFactory = new ContactPermissionBottomSheetDialogFragment.BottomSheetListener() { // from class: id.dana.social.v2.FeedsActivity$contactPermission$1$onDisplayConsentDialog$1
                    @Override // id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.BottomSheetListener
                    public final void MyBillsEntityDataFactory() {
                        FeedsActivity.access$getContactPermissionBottomSheetDialogFragment(FeedsActivity.this).dismiss();
                        p0.continueToPermissionRequest();
                    }

                    @Override // id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.BottomSheetListener
                    public final void PlaceComponentResult() {
                        FeedsActivity.access$getContactPermissionBottomSheetDialogFragment(FeedsActivity.this).dismiss();
                        FeedOnboardingView feedOnboardingView = (FeedOnboardingView) FeedsActivity.this._$_findCachedViewById(R.id.feedOnboardingView);
                        if (feedOnboardingView != null) {
                            feedOnboardingView.renderButtonEnabled();
                        }
                    }

                    @Override // id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.BottomSheetListener
                    public final void getAuthRequestContext() {
                        FeedOnboardingView feedOnboardingView = (FeedOnboardingView) FeedsActivity.this._$_findCachedViewById(R.id.feedOnboardingView);
                        if (feedOnboardingView != null) {
                            feedOnboardingView.renderButtonEnabled();
                        }
                    }
                };
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult();
    }

    @JvmName(name = "getSettingPresenter")
    public final RelationshipBottomSheetContract.Presenter getSettingPresenter() {
        RelationshipBottomSheetContract.Presenter presenter = this.settingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSettingPresenter")
    public final void setSettingPresenter(RelationshipBottomSheetContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.settingPresenter = presenter;
    }

    @JvmName(name = "getPresenter")
    public final FriendFeedsContract.Presenter getPresenter() {
        FriendFeedsContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(FriendFeedsContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getFriendshipAnalyticTracker")
    public final FriendshipAnalyticTracker getFriendshipAnalyticTracker() {
        FriendshipAnalyticTracker friendshipAnalyticTracker = this.friendshipAnalyticTracker;
        if (friendshipAnalyticTracker != null) {
            return friendshipAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFriendshipAnalyticTracker")
    public final void setFriendshipAnalyticTracker(FriendshipAnalyticTracker friendshipAnalyticTracker) {
        Intrinsics.checkNotNullParameter(friendshipAnalyticTracker, "");
        this.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }

    @JvmName(name = "getDanaContactPresenter")
    public final DanaContactPresenter getDanaContactPresenter() {
        DanaContactPresenter danaContactPresenter = this.danaContactPresenter;
        if (danaContactPresenter != null) {
            return danaContactPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDanaContactPresenter")
    public final void setDanaContactPresenter(DanaContactPresenter danaContactPresenter) {
        Intrinsics.checkNotNullParameter(danaContactPresenter, "");
        this.danaContactPresenter = danaContactPresenter;
    }

    @JvmName(name = "lookAheadTest")
    private final boolean lookAheadTest() {
        return ((Boolean) this.GetContactSyncConfig.getValue()).booleanValue();
    }

    @JvmName(name = "getShareFeedRequestId")
    /* renamed from: getShareFeedRequestId  reason: from getter */
    public final String getId.dana.domain.social.ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID java.lang.String() {
        return this.id.dana.domain.social.ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID java.lang.String;
    }

    @JvmName(name = "setShareFeedRequestId")
    public final void setShareFeedRequestId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.id.dana.domain.social.ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID java.lang.String = str;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        ((DanaApplication) application).setFeedRevamp(true);
        SocialCommonComponent socialCommonComponent = getDanaApplication().getSocialCommonComponent();
        FriendsFeedsModule friendsFeedsModule = new FriendsFeedsModule(new FriendFeedsContract.View() { // from class: id.dana.social.v2.FeedsActivity$getFeedsView$1
            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final String getAuthRequestContext() {
                return FeedsActivity.SOURCE;
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(MyFeedHeaderModel p0) {
                TopFriendsAdapter topFriendsAdapter;
                FeedShareActivityBannerAdapter feedShareActivityBannerAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                FeedsActivity.this.PrepareContext = p0;
                topFriendsAdapter = FeedsActivity.this.FragmentBottomSheetPaymentSettingBinding;
                Intrinsics.checkNotNullParameter(p0, "");
                topFriendsAdapter.MyBillsEntityDataFactory = p0;
                FeedModel.Companion companion = FeedModel.INSTANCE;
                topFriendsAdapter.setItems(CollectionsKt.mutableListOf(FeedModel.Companion.MyBillsEntityDataFactory(topFriendsAdapter.MyBillsEntityDataFactory, topFriendsAdapter.BuiltInFictitiousFunctionClassFactory)));
                feedShareActivityBannerAdapter = FeedsActivity.this.lookAheadTest;
                feedShareActivityBannerAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
                feedShareActivityBannerAdapter.notifyItemChanged(0);
                FeedsActivity.access$handleUsernameBanner(FeedsActivity.this, p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0 instanceof FriendFeedsContract.State.TimelineSuccess) {
                    FeedsActivity.access$renderTimelineSuccess(FeedsActivity.this, ((FriendFeedsContract.State.TimelineSuccess) p0).PlaceComponentResult);
                } else if (p0 instanceof FriendFeedsContract.State.TimelineError) {
                    FeedsActivity.access$renderTimelineError(FeedsActivity.this);
                } else if (p0 instanceof FriendFeedsContract.State.TopFriendSuccess) {
                    FeedsActivity.access$renderTopFriendSuccess(FeedsActivity.this, ((FriendFeedsContract.State.TopFriendSuccess) p0).MyBillsEntityDataFactory);
                } else if (p0 instanceof FriendFeedsContract.State.TopFriendError) {
                    FeedsActivity.access$renderEmptyState(FeedsActivity.this, ((FriendFeedsContract.State.TopFriendError) p0).getBuiltInFictitiousFunctionClassFactory());
                } else if (p0 instanceof FriendFeedsContract.State.FeedEmpty) {
                    FeedsActivity.access$renderEmptyState(FeedsActivity.this, ((FriendFeedsContract.State.FeedEmpty) p0).getPlaceComponentResult());
                } else if (p0 instanceof FriendFeedsContract.State.UsernameBannerDisplayed) {
                    FeedsActivity.access$renderUsernameBanner(FeedsActivity.this);
                } else if (!(p0 instanceof FriendFeedsContract.State.UsernameBannerHidden)) {
                    if (p0 instanceof FriendFeedsContract.State.LoadingFetchUserConfig) {
                        FeedsActivity.access$showLoadingFetchUserConfig(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.ErrorFetchUserConfig) {
                        FeedsActivity.access$showErrorFetchUserConfig(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.FinishFetchUserConfig) {
                        FeedsActivity.access$showFinishFetchUserConfigState(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.InitFeedLoading) {
                        FeedsActivity.access$showInitFeedLoadingState(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.InitFeedNotActivated) {
                        FeedsActivity.access$showOnboardingState(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.InitFeedFinished) {
                        FeedsActivity.access$showActiveState(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.InitFeedError) {
                        FeedsActivity.access$showInitFeedErrorState(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.ObserveSyncContact) {
                        FeedsActivity.access$observeSyncContactState(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.FeedSyncing) {
                        FeedsActivity.access$showSyncingState(FeedsActivity.this);
                    } else if (p0 instanceof FriendFeedsContract.State.FeedSynced) {
                        FeedsActivity.access$hideSyncingState(FeedsActivity.this);
                    }
                } else {
                    ((UsernameBannerAdapter) FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).setItems(CollectionsKt.emptyList());
                }
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void MyBillsEntityDataFactory(int p0) {
                FeedsActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void PlaceComponentResult(CreateFeedActivityRequestModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FeedsActivity.access$getShareActivityBottomSheetDialog(FeedsActivity.this).dismiss();
                FeedsActivity.access$showShareFeedLoadingState(FeedsActivity.this, p0.getAuthRequestContext, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.moveToNextValue);
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FeedsActivity.this.setShareFeedRequestId("");
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(FeedModel p0) {
                NewSocialFeedsAdapter newSocialFeedsAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                newSocialFeedsAdapter = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                newSocialFeedsAdapter.PlaceComponentResult(p0, FeedActivityState.ERROR);
                FeedsActivity.this.setShareFeedRequestId("");
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                FeedsActivity.access$getShareFeedConsentDialog(FeedsActivity.this).show();
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FeedsActivity feedsActivity = FeedsActivity.this;
                String string = feedsActivity.getString(R.string.share_feed_deleted_toast_msg);
                Intrinsics.checkNotNullExpressionValue(string, "");
                FeedsActivity.access$showTopToastPositive(feedsActivity, string);
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void PlaceComponentResult(ShareFeedActivity p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (FeedsActivity.access$getShareActivityBottomSheetDialog(FeedsActivity.this).isVisible()) {
                    return;
                }
                FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0.getPreviewActivityData();
                FeedsActivity.this.setShareFeedRequestId(p0.getShareFeedRequestId());
                FeedsActivity.this.getErrorConfigVersion();
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void PlaceComponentResult(FeedConfig p0) {
                NewSocialFeedsAdapter newSocialFeedsAdapter;
                NewSocialFeedsAdapter newSocialFeedsAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                FeedsActivity.this.getErrorConfigVersion = p0;
                newSocialFeedsAdapter = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                newSocialFeedsAdapter.MyBillsEntityDataFactory = true;
                newSocialFeedsAdapter2 = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                newSocialFeedsAdapter2.PlaceComponentResult = p0.isFeedCommentEnabled();
                FeedsActivity.this.initRecordTimeStamp = p0.isReplyCommentEnabled();
                FeedsActivity.access$fetchShareableActivities(FeedsActivity.this);
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void scheduleImpl() {
                FeedsActivity.this.getFriendshipAnalyticTracker().PlaceComponentResult(FeedsActivity.this.getPresenter().getReadMicros());
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void getAuthRequestContext(List<PreviewActivityData> p0) {
                FeedShareActivityBannerAdapter feedShareActivityBannerAdapter;
                FeedShareActivityBannerAdapter feedShareActivityBannerAdapter2;
                FeedShareActivityBannerAdapter feedShareActivityBannerAdapter3;
                List<PreviewActivityData> list = p0;
                if (list == null || list.isEmpty()) {
                    feedShareActivityBannerAdapter3 = FeedsActivity.this.lookAheadTest;
                    feedShareActivityBannerAdapter3.setItems(CollectionsKt.emptyList());
                    FeedsActivity.this.getPresenter().initRecordTimeStamp();
                    return;
                }
                feedShareActivityBannerAdapter = FeedsActivity.this.lookAheadTest;
                Intrinsics.checkNotNullParameter(p0, "");
                feedShareActivityBannerAdapter.BuiltInFictitiousFunctionClassFactory.addAll(list);
                FeedsActivity.access$getUsernameBannerAdapter(FeedsActivity.this).setItems(CollectionsKt.emptyList());
                feedShareActivityBannerAdapter2 = FeedsActivity.this.lookAheadTest;
                feedShareActivityBannerAdapter2.setItems(CollectionsKt.listOf(1));
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void PlaceComponentResult() {
                FeedShareActivityBannerAdapter feedShareActivityBannerAdapter;
                feedShareActivityBannerAdapter = FeedsActivity.this.lookAheadTest;
                feedShareActivityBannerAdapter.setItems(CollectionsKt.emptyList());
                FeedsActivity.this.getPresenter().initRecordTimeStamp();
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void MyBillsEntityDataFactory() {
                FeedShareActivityBannerAdapter feedShareActivityBannerAdapter;
                PreviewActivityData previewActivityData;
                int i;
                feedShareActivityBannerAdapter = FeedsActivity.this.lookAheadTest;
                FeedsActivity feedsActivity = FeedsActivity.this;
                List<PreviewActivityData> list = feedShareActivityBannerAdapter.BuiltInFictitiousFunctionClassFactory;
                boolean z = false;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String shareFeedRequestId = ((PreviewActivityData) it.next()).getShareFeedRequestId();
                        previewActivityData = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (Intrinsics.areEqual(shareFeedRequestId, previewActivityData != null ? previewActivityData.getShareFeedRequestId() : null)) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    i = feedsActivity.BuiltInFictitiousFunctionClassFactory;
                    feedShareActivityBannerAdapter.BuiltInFictitiousFunctionClassFactory.remove(i);
                    feedShareActivityBannerAdapter.notifyDataSetChanged();
                    if (feedShareActivityBannerAdapter.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                        feedShareActivityBannerAdapter.setItems(CollectionsKt.emptyList());
                    }
                }
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                String shownErrorMessage;
                shownErrorMessage = FeedsActivity.this.getShownErrorMessage();
                return shownErrorMessage == null ? "" : shownErrorMessage;
            }

            @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, String p2, String p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Intrinsics.checkNotNullParameter(p3, "");
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(FeedsActivity.this);
                builder.MyBillsEntityDataFactory = "Displayed Error";
                EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", p3).MyBillsEntityDataFactory("Displayed Message", p2).MyBillsEntityDataFactory("Operation Type", p1);
                String message = p0.getMessage();
                EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message != null ? message : "");
                if (p0 instanceof NetworkException) {
                    NetworkException networkException = (NetworkException) p0;
                    MyBillsEntityDataFactory2.MyBillsEntityDataFactory("Error Code", networkException.getErrorCode());
                    MyBillsEntityDataFactory2.MyBillsEntityDataFactory("Trace ID", networkException.getTraceId());
                }
                MyBillsEntityDataFactory2.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
            }
        });
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        FeedsActivity feedsActivity = this;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = feedsActivity;
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = FeedsSourceType.FRIENDSHIP_FRIENDS_FEED;
        byte b = 0;
        DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b);
        Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
        RelationshipBottomSheetModule relationshipBottomSheetModule = new RelationshipBottomSheetModule(new RelationshipBottomSheetContract.View(this) { // from class: id.dana.social.v2.FeedsActivity$initComponent$1
            private static int $10 = 0;
            private static int $11 = 1;
            private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            private static int MyBillsEntityDataFactory = 1;
            private static char[] getAuthRequestContext = {35561, 35438, 35434, 35439, 35440, 35441, 35445, 35442, 35437, 35439, 35439, 35428, 35435, 35432, 35424, 35434, 35443, 35434, 35435, 35430, 35424, 35432, 35432};
            final /* synthetic */ FeedsActivity PlaceComponentResult;

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ String BuiltInFictitiousFunctionClassFactory() {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                String PlaceComponentResult = RelationshipBottomSheetContract.View.CC.PlaceComponentResult();
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return PlaceComponentResult;
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                int i = MyBillsEntityDataFactory + 97;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory();
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 == 0 ? '6' : (char) 20) != '6') {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(FeedConfig feedConfig) {
                int i = MyBillsEntityDataFactory + 47;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(feedConfig, "");
                int i3 = MyBillsEntityDataFactory + 95;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 5 : 'A') != 'A') {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
                int i = MyBillsEntityDataFactory + 5;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                RelationshipBottomSheetContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                try {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
                    try {
                        MyBillsEntityDataFactory = i3 % 128;
                        if (i3 % 2 == 0) {
                            Object[] objArr = null;
                            int length = objArr.length;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                try {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
                    try {
                        MyBillsEntityDataFactory = i % 128;
                        if (i % 2 != 0) {
                            RelationshipBottomSheetContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                            return;
                        }
                        RelationshipBottomSheetContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                        Object[] objArr = null;
                        int length = objArr.length;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void PlaceComponentResult(List list) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
                MyBillsEntityDataFactory = i % 128;
                char c = i % 2 == 0 ? 'D' : (char) 14;
                RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory(list);
                if (c != 14) {
                    int i2 = 48 / 0;
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                int i = MyBillsEntityDataFactory + 71;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                boolean z = i % 2 == 0;
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                if (z) {
                    return;
                }
                int i2 = 43 / 0;
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void getAuthRequestContext(ModifyRelationOperationType modifyRelationOperationType) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
                MyBillsEntityDataFactory = i % 128;
                if (i % 2 != 0) {
                    Intrinsics.checkNotNullParameter(modifyRelationOperationType, "");
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(modifyRelationOperationType, "");
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            public final /* synthetic */ void getAuthRequestContext(List list) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
                MyBillsEntityDataFactory = i % 128;
                Object[] objArr = null;
                if ((i % 2 == 0 ? Typography.amp : (char) 31) != '&') {
                    RelationshipBottomSheetContract.View.CC.getAuthRequestContext(list);
                } else {
                    try {
                        RelationshipBottomSheetContract.View.CC.getAuthRequestContext(list);
                        int length = objArr.length;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
                MyBillsEntityDataFactory = i2 % 128;
                if ((i2 % 2 == 0 ? (char) 19 : ':') != ':') {
                    int length2 = objArr.length;
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                int i = MyBillsEntityDataFactory + 53;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 != 0) {
                    String authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                    Object obj = null;
                    obj.hashCode();
                    return authRequestContext;
                }
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                int i = MyBillsEntityDataFactory + 81;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 == 0) {
                    try {
                        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
                MyBillsEntityDataFactory = i % 128;
                if ((i % 2 == 0 ? (char) 29 : 'G') != 'G') {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                try {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                } catch (Exception e) {
                    throw e;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                try {
                    this.PlaceComponentResult = this;
                } catch (Exception e) {
                    throw e;
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x005f, code lost:
            
                if ((kotlin.jvm.internal.Intrinsics.areEqual(r0, ((java.lang.String) r4[0]).intern()) ? false : true) != false) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0061, code lost:
            
                id.dana.social.v2.FeedsActivity.access$openProfileSettingsActivity(r7.PlaceComponentResult, r8);
                r8 = id.dana.social.v2.FeedsActivity$initComponent$1.MyBillsEntityDataFactory + 37;
                id.dana.social.v2.FeedsActivity$initComponent$1.KClassImpl$Data$declaredNonStaticMembers$2 = r8 % 128;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0070, code lost:
            
                if ((r8 % 2) == 0) goto L18;
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0072, code lost:
            
                r1.hashCode();
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0075, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0078, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
            
                r8 = id.dana.social.v2.FeedsActivity$initComponent$1.KClassImpl$Data$declaredNonStaticMembers$2 + 91;
                id.dana.social.v2.FeedsActivity$initComponent$1.MyBillsEntityDataFactory = r8 % 128;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0085, code lost:
            
                if ((r8 % 2) != 0) goto L22;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
            
                r8 = 'Y';
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
            
                r8 = '9';
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
            
                if (r8 == 'Y') goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
            
                r8.startActivity(new android.content.Intent(r7.PlaceComponentResult, id.dana.social.view.activity.ChangeUsernameActivity.class));
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
            
                r8.startActivity(new android.content.Intent(r7.PlaceComponentResult, id.dana.social.view.activity.ChangeUsernameActivity.class));
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0099, code lost:
            
                r1.hashCode();
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x009c, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:5:0x0036, code lost:
            
                if (kotlin.jvm.internal.Intrinsics.areEqual(r0, ((java.lang.String) r4[0]).intern()) != false) goto L19;
             */
            @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void BuiltInFictitiousFunctionClassFactory(id.dana.domain.profilemenu.model.SettingModel r8) {
                /*
                    r7 = this;
                    int r0 = id.dana.social.v2.FeedsActivity$initComponent$1.MyBillsEntityDataFactory
                    int r0 = r0 + 9
                    int r1 = r0 % 128
                    id.dana.social.v2.FeedsActivity$initComponent$1.KClassImpl$Data$declaredNonStaticMembers$2 = r1
                    int r0 = r0 % 2
                    r1 = 0
                    r2 = 23
                    r3 = 4
                    java.lang.String r4 = ""
                    r5 = 0
                    r6 = 1
                    if (r0 == 0) goto L39
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r4)
                    java.lang.String r0 = r8.getAction()
                    int[] r3 = new int[r3]
                    r3 = {x00a0: FILL_ARRAY_DATA , data: [0, 23, 138, 0} // fill-array
                    byte[] r2 = new byte[r2]
                    r2 = {x00ac: FILL_ARRAY_DATA , data: [1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0} // fill-array
                    java.lang.Object[] r4 = new java.lang.Object[r6]
                    a(r3, r5, r2, r4)
                    r2 = r4[r5]
                    java.lang.String r2 = (java.lang.String) r2
                    java.lang.String r2 = r2.intern()
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                    if (r0 == 0) goto L61
                    goto L79
                L39:
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r4)
                    java.lang.String r0 = r8.getAction()
                    int[] r3 = new int[r3]
                    r3 = {x00bc: FILL_ARRAY_DATA , data: [0, 23, 138, 0} // fill-array
                    byte[] r2 = new byte[r2]
                    r2 = {x00c8: FILL_ARRAY_DATA , data: [1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0} // fill-array
                    java.lang.Object[] r4 = new java.lang.Object[r6]
                    a(r3, r6, r2, r4)
                    r2 = r4[r5]
                    java.lang.String r2 = (java.lang.String) r2
                    java.lang.String r2 = r2.intern()
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                    if (r0 == 0) goto L5e
                    goto L5f
                L5e:
                    r5 = 1
                L5f:
                    if (r5 == 0) goto L79
                L61:
                    id.dana.social.v2.FeedsActivity r0 = r7.PlaceComponentResult
                    id.dana.social.v2.FeedsActivity.access$openProfileSettingsActivity(r0, r8)
                    int r8 = id.dana.social.v2.FeedsActivity$initComponent$1.MyBillsEntityDataFactory
                    int r8 = r8 + 37
                    int r0 = r8 % 128
                    id.dana.social.v2.FeedsActivity$initComponent$1.KClassImpl$Data$declaredNonStaticMembers$2 = r0
                    int r8 = r8 % 2
                    if (r8 == 0) goto L78
                    r1.hashCode()     // Catch: java.lang.Throwable -> L76
                    return
                L76:
                    r8 = move-exception
                    throw r8
                L78:
                    return
                L79:
                    int r8 = id.dana.social.v2.FeedsActivity$initComponent$1.KClassImpl$Data$declaredNonStaticMembers$2
                    int r8 = r8 + 91
                    int r0 = r8 % 128
                    id.dana.social.v2.FeedsActivity$initComponent$1.MyBillsEntityDataFactory = r0
                    int r8 = r8 % 2
                    r0 = 89
                    if (r8 != 0) goto L8a
                    r8 = 89
                    goto L8c
                L8a:
                    r8 = 57
                L8c:
                    if (r8 == r0) goto L94
                    id.dana.social.v2.FeedsActivity r8 = r7.PlaceComponentResult
                    id.dana.social.v2.FeedsActivity.access$openChangeUsernameActivity(r8)
                    goto L9c
                L94:
                    id.dana.social.v2.FeedsActivity r8 = r7.PlaceComponentResult
                    id.dana.social.v2.FeedsActivity.access$openChangeUsernameActivity(r8)
                    r1.hashCode()     // Catch: java.lang.Throwable -> L9d
                L9c:
                    return
                L9d:
                    r8 = move-exception
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.FeedsActivity$initComponent$1.BuiltInFictitiousFunctionClassFactory(id.dana.domain.profilemenu.model.SettingModel):void");
            }

            private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
                VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = iArr[2];
                int i4 = iArr[3];
                char[] cArr = getAuthRequestContext;
                if (cArr != null) {
                    int length = cArr.length;
                    char[] cArr2 = new char[length];
                    int i5 = 0;
                    while (true) {
                        if ((i5 < length ? 'Z' : 'C') == 'C') {
                            break;
                        }
                        int i6 = $11 + 79;
                        $10 = i6 % 128;
                        if ((i6 % 2 != 0 ? 'R' : '\r') != 'R') {
                            cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                            i5++;
                        } else {
                            cArr2[i5] = (char) (cArr[i5] % 5097613533456403102L);
                            i5 %= 0;
                        }
                    }
                    cArr = cArr2;
                }
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr, i, cArr3, 0, i2);
                if (bArr != null) {
                    char[] cArr4 = new char[i2];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                    char c = 0;
                    while (true) {
                        if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2 ? '(' : '!') != '(') {
                            break;
                        }
                        if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                            int i7 = $11 + 29;
                            $10 = i7 % 128;
                            if (i7 % 2 != 0) {
                                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 5) * 0) >>> c);
                            } else {
                                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                            }
                        } else {
                            try {
                                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    }
                    cArr3 = cArr4;
                }
                if ((i4 <= 0 ? 'c' : 'C') != 'c') {
                    char[] cArr5 = new char[i2];
                    System.arraycopy(cArr3, 0, cArr5, 0, i2);
                    int i8 = i2 - i4;
                    System.arraycopy(cArr5, 0, cArr3, i8, i4);
                    System.arraycopy(cArr5, i4, cArr3, 0, i8);
                }
                if (z) {
                    int i9 = $10 + 93;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    char[] cArr6 = new char[i2];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                    while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                        try {
                            cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                            int i11 = $11 + 109;
                            $10 = i11 % 128;
                            int i12 = i11 % 2;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    cArr3 = cArr6;
                }
                if (i3 > 0) {
                    int i13 = $10 + 79;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                    while (true) {
                        if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i2) {
                            break;
                        }
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    }
                }
                objArr[0] = new String(cArr3);
            }
        });
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = feedsActivity;
        ScanQrModule scanQrModule = new ScanQrModule(authRequestContext, b);
        Intrinsics.checkNotNullExpressionValue(scanQrModule, "");
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = feedsActivity;
        RestoreUrlModule restoreUrlModule = new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b);
        Intrinsics.checkNotNullExpressionValue(restoreUrlModule, "");
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = feedsActivity;
        FeatureModule featureModule = new FeatureModule(MyBillsEntityDataFactory, b);
        Intrinsics.checkNotNullExpressionValue(featureModule, "");
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = feedsActivity;
        OauthModule oauthModule = new OauthModule(BuiltInFictitiousFunctionClassFactory, b);
        Intrinsics.checkNotNullExpressionValue(oauthModule, "");
        socialCommonComponent.PlaceComponentResult(friendsFeedsModule, deepLinkModule, relationshipBottomSheetModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.social.v2.FeedsActivity$initComponent$2
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionFailed(String str) {
                ServicesContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetThirdPartyServices(List list) {
                ServicesContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        }), new DanaContactModule(new DanaContactContract.View() { // from class: id.dana.social.v2.FeedsActivity$initComponent$3
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onEnableContactSyncFeature() {
                DanaContactContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetContactSyncState(boolean z) {
                DanaContactContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetDanaUserContactSuccess(List list) {
                DanaContactContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetRecipientSyncContacts(List list) {
                DanaContactContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.contact.DanaContactContract.View
            public final /* synthetic */ void onGetSyncContacts(List list) {
                DanaContactContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        })).MyBillsEntityDataFactory(this);
        if (Intrinsics.areEqual(getSource(), FeedsSourceType.FEED_DEEPLINK)) {
            startTimer(TimerEventKey.FEED_OPEN);
        }
        NewSocialFeedsAdapter newSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        FeedsActivity$getSocialAdapterListener$1 feedsActivity$getSocialAdapterListener$1 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullParameter(feedsActivity$getSocialAdapterListener$1, "");
        newSocialFeedsAdapter.getErrorConfigVersion = feedsActivity$getSocialAdapterListener$1;
        this.FragmentBottomSheetPaymentSettingBinding.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        this.getAuthRequestContext = new ConcatAdapter(this.FragmentBottomSheetPaymentSettingBinding, (UsernameBannerAdapter) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue(), this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a10f3_descriptorvisibilities_6);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            ConcatAdapter concatAdapter = this.getAuthRequestContext;
            if (concatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                concatAdapter = null;
            }
            recyclerView.setAdapter(concatAdapter);
            recyclerView.setAnimation(null);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.social.v2.FeedsActivity$initAdapter$1$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
                    boolean z;
                    boolean z2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrolled(p0, p1, p2);
                    if (p1 == 0 && p2 == 0) {
                        return;
                    }
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    FeedPullToRefreshView feedPullToRefreshView = (FeedPullToRefreshView) FeedsActivity.this._$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider);
                    if (feedPullToRefreshView != null) {
                        if (NetworkUserEntityData$$ExternalSyntheticLambda0) {
                            z2 = FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                            if (z2) {
                                z = true;
                                feedPullToRefreshView.setEnabled(z);
                            }
                        }
                        z = false;
                        feedPullToRefreshView.setEnabled(z);
                    }
                    FeedsActivity.access$setCvBackToTopVisibility(FeedsActivity.this, p2 < 0 && !NetworkUserEntityData$$ExternalSyntheticLambda0);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    boolean scheduleImpl;
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p0.canScrollVertically(130) || !FeedsActivity.this.getPresenter().getNetworkUserEntityData$$ExternalSyntheticLambda4()) {
                        return;
                    }
                    scheduleImpl = FeedsActivity.this.scheduleImpl();
                    if (scheduleImpl) {
                        FeedsActivity.access$doLoadMoreFeed(FeedsActivity.this);
                    }
                }
            });
        }
        FeedOnboardingView feedOnboardingView = (FeedOnboardingView) _$_findCachedViewById(R.id.feedOnboardingView);
        if (feedOnboardingView != null) {
            feedOnboardingView.setListener(new FeedOnboardingListener() { // from class: id.dana.social.v2.FeedsActivity$setupOnboardingComponent$1
                @Override // id.dana.social.common.FeedOnboardingListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    ActivityPermissionRequest activityPermissionRequest;
                    activityPermissionRequest = FeedsActivity.this.MyBillsEntityDataFactory;
                    activityPermissionRequest.check();
                    FeedsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
                }
            });
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.impressionsCount);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.FeedsActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsActivity.m2954$r8$lambda$GSRVicpQuJcNA56ty453Sf7h2g(FeedsActivity.this, view);
                }
            });
        }
        BadgeDrawable create = BadgeDrawable.create(this);
        Intrinsics.checkNotNullExpressionValue(create, "");
        create.setMaxCharacterCount(2);
        create.setHorizontalOffset(18);
        create.setVerticalOffset(21);
        this.PlaceComponentResult = create;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.res_0x7f0a023f_apistatus_availablesince);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.FeedsActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsActivity.$r8$lambda$A6DZ_CqKR1eijm5LNe4ST8rXW_s(FeedsActivity.this, view);
                }
            });
        }
        getPresenter().PlaceComponentResult(false);
        getPresenter().BuiltInFictitiousFunctionClassFactory(false);
        getPresenter().initRecordTimeStamp();
        FeedPullToRefreshView feedPullToRefreshView = (FeedPullToRefreshView) _$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider);
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "");
        feedPullToRefreshView.initPullToRefreshView(layoutInflater, new FeedsActivity$init$1(this));
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(R.string.feeds_page_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
    }

    private final void moveToNextValue() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.getMinSeparation);
        if (textView != null) {
            textView.setVisibility(0);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.LTOMLengthOf);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(0);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        BadgeDrawable badgeDrawable = this.PlaceComponentResult;
        BadgeDrawable badgeDrawable2 = null;
        if (badgeDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            badgeDrawable = null;
        }
        if (badgeDrawable.getNumber() > 0) {
            BadgeDrawable badgeDrawable3 = this.PlaceComponentResult;
            if (badgeDrawable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                badgeDrawable2 = badgeDrawable3;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(badgeDrawable2.getNumber());
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            getAuthRequestContext();
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.getMinSeparation);
        if (textView != null) {
            textView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.LTOMLengthOf);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickRightMenuButton(View view) {
        PopupMenu popupMenu = new PopupMenu(this, (TextView) _$_findCachedViewById(R.id.getMinSeparation), 8388613, 0, R.style.f53992132017893);
        popupMenu.PlaceComponentResult.setOptionalIconsVisible(true);
        new SupportMenuInflater(popupMenu.BuiltInFictitiousFunctionClassFactory).inflate(R.menu.f46532131623937, popupMenu.PlaceComponentResult);
        popupMenu.KClassImpl$Data$declaredNonStaticMembers$2 = new PopupMenu.OnMenuItemClickListener() { // from class: id.dana.social.v2.FeedsActivity$$ExternalSyntheticLambda2
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean getAuthRequestContext(MenuItem menuItem) {
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2 = FeedsActivity.KClassImpl$Data$declaredNonStaticMembers$2(FeedsActivity.this, menuItem);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        };
        if (!popupMenu.mPopup.MyBillsEntityDataFactory()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(FeedsActivity feedsActivity, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(feedsActivity, "");
        Intrinsics.checkNotNullParameter(menuItem, "");
        switch (menuItem.getItemId()) {
            case R.id.option_feed_about /* 2131365734 */:
                ((FeedsIntroduction) feedsActivity.scheduleImpl.getValue()).MyBillsEntityDataFactory();
                return true;
            case R.id.option_feed_settings /* 2131365735 */:
                feedsActivity.getSettingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("setting_more");
                return true;
            default:
                return true;
        }
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a10f3_descriptorvisibilities_6);
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        addDisposable(Observable.timer(500L, TimeUnit.MILLISECONDS).doOnComplete(new Action() { // from class: id.dana.social.v2.FeedsActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                FeedsActivity.$r8$lambda$Ua2uZHzx0So0Oef6FZJV8sQNq7Q(FeedsActivity.this);
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).subscribe());
    }

    public final boolean scheduleImpl() {
        List<FeedViewHolderModel> items = this.NetworkUserEntityData$$ExternalSyntheticLambda6.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        return (items.isEmpty() ^ true) && !this.moveToNextValue && this.NetworkUserEntityData$$ExternalSyntheticLambda6.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        BadgeDrawable badgeDrawable = this.PlaceComponentResult;
        BadgeDrawable badgeDrawable2 = null;
        if (badgeDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            badgeDrawable = null;
        }
        badgeDrawable.setNumber(p0);
        if (p0 > 0 && getPresenter().getWhenAvailable().getStatus() == InitStatus.FINISH) {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.BaseRpcFacadeInvoker$1);
            if (frameLayout != null) {
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(frameLayout, Float.valueOf(0.0f), Float.valueOf(8.0f), Float.valueOf(0.0f), Float.valueOf(8.0f));
            }
            BadgeDrawable badgeDrawable3 = this.PlaceComponentResult;
            if (badgeDrawable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                badgeDrawable2 = badgeDrawable3;
            }
            BadgeUtils.attachBadgeDrawable(badgeDrawable2, (AppCompatImageView) _$_findCachedViewById(R.id.LTOMLengthOf), (FrameLayout) _$_findCachedViewById(R.id.BaseRpcFacadeInvoker$1));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            return;
        }
        getAuthRequestContext();
    }

    private final void getAuthRequestContext() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.LTOMLengthOf);
        if (appCompatImageView != null) {
            BadgeDrawable badgeDrawable = this.PlaceComponentResult;
            if (badgeDrawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                badgeDrawable = null;
            }
            BadgeUtils.detachBadgeDrawable(badgeDrawable, appCompatImageView);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        }
    }

    private final void getAuthRequestContext(boolean p0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.ServiceStarter);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(p0 ? 0 : 8);
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_try_again);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(p0 ? 0 : 8);
        }
    }

    public final void getErrorConfigVersion() {
        PreviewActivityData previewActivityData = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (previewActivityData != null) {
            ShareActivityBottomSheetDialog shareActivityBottomSheetDialog = (ShareActivityBottomSheetDialog) this.newProxyInstance.getValue();
            FeedViewHolderModel.Companion companion = FeedViewHolderModel.INSTANCE;
            shareActivityBottomSheetDialog.PlaceComponentResult = FeedViewHolderModel.Companion.getAuthRequestContext(previewActivityData, this.PrepareContext);
            ShareActivityBottomSheetDialog shareActivityBottomSheetDialog2 = (ShareActivityBottomSheetDialog) this.newProxyInstance.getValue();
            String content = previewActivityData.getContent();
            HashMap<String, String> extendInfo = previewActivityData.getExtendInfo();
            if (extendInfo == null) {
                extendInfo = new HashMap<>();
            }
            String str = "";
            shareActivityBottomSheetDialog2.MyBillsEntityDataFactory = new FeedRegexData(str, content, extendInfo, null, this, previewActivityData.getContentType(), 8, null);
            ShareActivityBottomSheetDialog shareActivityBottomSheetDialog3 = (ShareActivityBottomSheetDialog) this.newProxyInstance.getValue();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            AndroidComponentUtilsKt.MyBillsEntityDataFactory(shareActivityBottomSheetDialog3, supportFragmentManager, "shareFeedActivity");
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        super.onNewIntent(intent);
        Intent intent2 = getIntent();
        String stringExtra = intent.getStringExtra("source");
        intent2.putExtra("source", stringExtra != null ? stringExtra : "");
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Intent MyBillsEntityDataFactory;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(super.getResources().getString(R.string.km_away_with_dot).substring(0, 10).codePointAt(5) - 1562913748, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 573246101, (short) (69 - ImageFormat.getBitsPerPixel(0)), (byte) (super.getResources().getString(R.string.merchant_review_main_hint).substring(24, 26).length() - 2), KeyEvent.normalizeMetaState(0) - 53, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int codePointAt = super.getResources().getString(R.string.deals_express_snackbar_fail_without_retry).substring(65, 67).codePointAt(0) - 1562913741;
            try {
                Object[] objArr2 = new Object[1];
                h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr3);
                int i = ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 573246095;
                short resolveOpacity = (short) (Drawable.resolveOpacity(0, 0) + 63);
                byte codePointAt2 = (byte) (super.getResources().getString(R.string.limit).substring(0, 5).codePointAt(3) - 73);
                try {
                    Object[] objArr4 = new Object[1];
                    h((byte) (-lookAheadTest[30]), lookAheadTest[9], lookAheadTest[32], objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    h(lookAheadTest[56], lookAheadTest[59], lookAheadTest[13], objArr5);
                    int i2 = ((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion - 86;
                    Object[] objArr6 = new Object[1];
                    g(codePointAt, i, resolveOpacity, codePointAt2, i2, objArr6);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), ExpandableListView.getPackedPositionType(0L) + 35, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) Drawable.resolveOpacity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        Intent intent = getIntent();
        if (intent != null) {
            FeedDeeplinkActivityDetailModel feedDeeplinkActivityDetailModel = (FeedDeeplinkActivityDetailModel) intent.getParcelableExtra(ACTIVITY_DETAIL_DEEPLINK_BUNDLE);
            intent.removeExtra(ACTIVITY_DETAIL_DEEPLINK_BUNDLE);
            String stringExtra = intent.getStringExtra("bizOrderId");
            intent.removeExtra("bizOrderId");
            String str = stringExtra;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = !(str == null || StringsKt.isBlank(str));
            if (feedDeeplinkActivityDetailModel != null) {
                SocialActivityDetail.Companion companion = SocialActivityDetail.INSTANCE;
                MyBillsEntityDataFactory = SocialActivityDetail.Companion.MyBillsEntityDataFactory(this, feedDeeplinkActivityDetailModel.getAuthRequestContext, feedDeeplinkActivityDetailModel.MyBillsEntityDataFactory, feedDeeplinkActivityDetailModel.PlaceComponentResult, feedDeeplinkActivityDetailModel.getKClassImpl$Data$declaredNonStaticMembers$2(), feedDeeplinkActivityDetailModel.getBuiltInFictitiousFunctionClassFactory(), false);
                startActivity(MyBillsEntityDataFactory);
            }
        }
        getPresenter().PrepareContext();
        getPresenter().moveToNextValue();
        if (!this.DatabaseTableConfigUtil && getPresenter().newProxyInstance()) {
            getPresenter().scheduleImpl();
        } else if (getPresenter().NetworkUserEntityData$$ExternalSyntheticLambda2() && Intrinsics.areEqual(getSource(), FeedsSourceType.FEED_SETTINGS) && getPresenter().getWhenAvailable().getStatus() == InitStatus.NOT_ACTIVATED) {
            getAuthRequestContext("Onboarding");
        }
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
    public final void onTimerEnd(TimerEvent timerEvent, long millisecond) {
        Intrinsics.checkNotNullParameter(timerEvent, "");
        track(this, timerEvent, millisecond);
    }

    private final void getAuthRequestContext(String p0) {
        endTimer(new TimerEvent(TimerEventKey.FEED_OPEN, MapsKt.hashMapOf(new Pair("Feed State", p0), new Pair("Source", getSource())), this.DatabaseTableConfigUtil));
        this.DatabaseTableConfigUtil = false;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/social/v2/FeedsActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/social/v2/model/FeedDeeplinkActivityDetailModel;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/social/v2/model/FeedDeeplinkActivityDetailModel;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;)V", "p2", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "ACTIVITY_DETAIL_DEEPLINK_BUNDLE", "Ljava/lang/String;", "SOURCE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, FeedsActivity.class);
            intent.putExtra("source", p1);
            p0.startActivity(intent);
        }

        @JvmStatic
        public static void getAuthRequestContext(Context p0, String p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(p0, FeedsActivity.class);
            intent.putExtra("bizOrderId", p1);
            intent.putExtra("source", p2);
            p0.startActivity(intent);
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context p0, FeedDeeplinkActivityDetailModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, FeedsActivity.class);
            intent.putExtra(FeedsActivity.ACTIVITY_DETAIL_DEEPLINK_BUNDLE, p1);
            p0.startActivity(intent);
        }
    }

    /* renamed from: $r8$lambda$91HuVouw-ZNJVy3-2BO2-051PDc */
    public static /* synthetic */ void m2953$r8$lambda$91HuVouwZNJVy32BO2051PDc(FeedsActivity feedsActivity, AppCompatImageView appCompatImageView, View view) {
        Intrinsics.checkNotNullParameter(feedsActivity, "");
        Intrinsics.checkNotNullParameter(appCompatImageView, "");
        feedsActivity.getFriendshipAnalyticTracker().MyBillsEntityDataFactory();
        FeedNotificationActivity.Companion companion = FeedNotificationActivity.INSTANCE;
        Context context = appCompatImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        FeedConfig feedConfig = feedsActivity.getErrorConfigVersion;
        boolean isAddFriendEnabled = feedConfig != null ? feedConfig.isAddFriendEnabled() : false;
        FeedConfig feedConfig2 = feedsActivity.getErrorConfigVersion;
        FeedNotificationActivity.Companion.PlaceComponentResult(context, false, isAddFriendEnabled, feedConfig2 != null ? feedConfig2.isReplyCommentEnabled() : false);
    }

    public static /* synthetic */ void $r8$lambda$A6DZ_CqKR1eijm5LNe4ST8rXW_s(FeedsActivity feedsActivity, View view) {
        Intrinsics.checkNotNullParameter(feedsActivity, "");
        feedsActivity.getPresenter().PlaceComponentResult(true);
    }

    /* renamed from: $r8$lambda$GSRVicpQu-JcNA56ty453Sf7h2g */
    public static /* synthetic */ void m2954$r8$lambda$GSRVicpQuJcNA56ty453Sf7h2g(FeedsActivity feedsActivity, View view) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(feedsActivity, "");
        Intrinsics.checkNotNullExpressionValue(feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.getItems(), "");
        if ((!r0.isEmpty()) != false && (recyclerView = (RecyclerView) feedsActivity._$_findCachedViewById(R.id.res_0x7f0a10f3_descriptorvisibilities_6)) != null) {
            recyclerView.smoothScrollToPosition(0);
        }
        View _$_findCachedViewById = feedsActivity._$_findCachedViewById(R.id.impressionsCount);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(8);
        }
    }

    public static /* synthetic */ void $r8$lambda$Ua2uZHzx0So0Oef6FZJV8sQNq7Q(FeedsActivity feedsActivity) {
        Intrinsics.checkNotNullParameter(feedsActivity, "");
        feedsActivity.moveToNextValue = false;
    }

    public static final /* synthetic */ void access$checkFeedStatus(final FeedsActivity feedsActivity) {
        FeedOnboardingView feedOnboardingView = (FeedOnboardingView) feedsActivity._$_findCachedViewById(R.id.feedOnboardingView);
        if (feedOnboardingView != null) {
            feedOnboardingView.renderButtonDisabled();
        }
        feedsActivity.getPresenter().PlaceComponentResult();
        feedsActivity.getPresenter().DatabaseTableConfigUtil();
        feedsActivity.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.social.v2.FeedsActivity$checkFeedStatus$1
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
                SocialSyncManagerKt.BuiltInFictitiousFunctionClassFactory(FeedsActivity.this);
                FeedsActivity.this.getDanaContactPresenter().KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new DanaContactPresenter$$ExternalSyntheticLambda2());
            }
        });
    }

    public static final /* synthetic */ void access$doLoadMoreFeed(FeedsActivity feedsActivity) {
        feedsActivity.moveToNextValue = true;
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.appendItem(new FeedViewHolderModel(6, null, null, null, null, false, 60, null));
        feedsActivity.getPresenter().NetworkUserEntityData$$ExternalSyntheticLambda1();
        feedsActivity.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void access$fetchShareableActivities(FeedsActivity feedsActivity) {
        FeedConfig feedConfig = feedsActivity.getErrorConfigVersion;
        if ((feedConfig != null && feedConfig.isFeedActivityBannerEnable()) && feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda5) {
            feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
            feedsActivity.getPresenter().getErrorConfigVersion();
            return;
        }
        feedsActivity.getPresenter().initRecordTimeStamp();
    }

    public static final /* synthetic */ ContactPermissionBottomSheetDialogFragment access$getContactPermissionBottomSheetDialogFragment(FeedsActivity feedsActivity) {
        return (ContactPermissionBottomSheetDialogFragment) feedsActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ ShareActivityBottomSheetDialog access$getShareActivityBottomSheetDialog(FeedsActivity feedsActivity) {
        return (ShareActivityBottomSheetDialog) feedsActivity.newProxyInstance.getValue();
    }

    public static final /* synthetic */ MaterialDialog access$getShareFeedConsentDialog(FeedsActivity feedsActivity) {
        return (MaterialDialog) feedsActivity.isLayoutRequested.getValue();
    }

    public static final /* synthetic */ UsernameBannerAdapter access$getUsernameBannerAdapter(FeedsActivity feedsActivity) {
        return (UsernameBannerAdapter) feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
    }

    public static final /* synthetic */ void access$handleBubbleClick(FeedsActivity feedsActivity, FeedViewHolderModel feedViewHolderModel) {
        FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
        if (feedModel == null || !feedModel.moveToNextValue()) {
            return;
        }
        SocialActivityDetail.Companion companion = SocialActivityDetail.INSTANCE;
        SocialActivityDetail.Companion.KClassImpl$Data$declaredNonStaticMembers$2(feedsActivity, feedModel, feedsActivity.initRecordTimeStamp);
    }

    public static final /* synthetic */ void access$handleOpenProfile(FeedsActivity feedsActivity, RelationshipItemModel relationshipItemModel) {
        if (Intrinsics.areEqual(relationshipItemModel.GetContactSyncConfig, feedsActivity.getPresenter().getGetAuthRequestContext())) {
            Intrinsics.checkNotNullParameter("SELF", "");
            relationshipItemModel.getErrorConfigVersion = "SELF";
        }
        SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
        SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(feedsActivity, relationshipItemModel);
    }

    public static final /* synthetic */ void access$handleUsernameBanner(FeedsActivity feedsActivity, String str) {
        if ((str.length() == 0) && !feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 && feedsActivity.lookAheadTest.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            ((UsernameBannerAdapter) feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).setItems(CollectionsKt.listOf(2));
        } else {
            ((UsernameBannerAdapter) feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).setItems(CollectionsKt.emptyList());
        }
    }

    public static final /* synthetic */ void access$hideSyncingState(FeedsActivity feedsActivity) {
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.GetContactSyncConfig();
        feedsActivity.moveToNextValue();
    }

    public static final /* synthetic */ void access$observeSyncContactState(FeedsActivity feedsActivity) {
        Context applicationContext = feedsActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        final LiveData<List<WorkInfo>> authRequestContext = SocialSyncManagerKt.getAuthRequestContext(applicationContext);
        authRequestContext.PlaceComponentResult(feedsActivity, feedsActivity.getPresenter().PlaceComponentResult(new Function1<Observer<List<? extends WorkInfo>>, Unit>() { // from class: id.dana.social.v2.FeedsActivity$observeSyncContactState$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Observer<List<? extends WorkInfo>> observer) {
                invoke2((Observer<List<WorkInfo>>) observer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Observer<List<WorkInfo>> observer) {
                Intrinsics.checkNotNullParameter(observer, "");
                authRequestContext.BuiltInFictitiousFunctionClassFactory(observer);
            }
        }));
    }

    public static final /* synthetic */ void access$openContentGroupingActivity(FeedsActivity feedsActivity, List list, int i) {
        boolean z;
        ContentGroupingDetailActivity.Companion companion = ContentGroupingDetailActivity.INSTANCE;
        FeedsActivity feedsActivity2 = feedsActivity;
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((FeedModel) it.next()).NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        boolean placeComponentResult = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.getPlaceComponentResult();
        boolean myBillsEntityDataFactory = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.getMyBillsEntityDataFactory();
        if (i == 1) {
            FeedModel feedModel = (FeedModel) CollectionsKt.firstOrNull(list);
            if (feedModel != null) {
                HashMap<String, String> hashMap = feedModel.lookAheadTest;
                r5 = hashMap != null ? ExtendInfoUtilKt.getUserId(hashMap) : null;
                if (r5 == null) {
                    r5 = "";
                }
            }
            if (Intrinsics.areEqual(r5, feedsActivity.getPresenter().getGetAuthRequestContext())) {
                z = true;
                ContentGroupingDetailActivity.Companion.getAuthRequestContext(feedsActivity2, arrayList2, placeComponentResult, myBillsEntityDataFactory, i, z, feedsActivity.initRecordTimeStamp);
            }
        }
        z = false;
        ContentGroupingDetailActivity.Companion.getAuthRequestContext(feedsActivity2, arrayList2, placeComponentResult, myBillsEntityDataFactory, i, z, feedsActivity.initRecordTimeStamp);
    }

    public static final /* synthetic */ void access$openProfileSettingsActivity(FeedsActivity feedsActivity, SettingModel settingModel) {
        Intent intent;
        if (feedsActivity.lookAheadTest()) {
            intent = new Intent(feedsActivity, ProfileSettingsActivity.class);
        } else {
            intent = new Intent(feedsActivity, SettingMoreProfileActivity.class);
        }
        intent.putExtra(MyProfileBundleKey.FROM_FEEDS_SETTING_ICON, true);
        intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
        feedsActivity.startActivity(intent);
    }

    public static final /* synthetic */ void access$refreshFeeds(FeedsActivity feedsActivity) {
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        feedsActivity.getPresenter().initRecordTimeStamp();
        feedsActivity.getPresenter().MyBillsEntityDataFactory(false, true);
        feedsActivity.FragmentBottomSheetPaymentSettingBinding.MyBillsEntityDataFactory();
        NewSocialFeedsAdapter newSocialFeedsAdapter = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
        newSocialFeedsAdapter.setItems(newSocialFeedsAdapter.getAuthRequestContext());
    }

    public static final /* synthetic */ void access$renderEmptyState(FeedsActivity feedsActivity, boolean z) {
        feedsActivity.getAuthRequestContext("Feed Empty");
        if (feedsActivity.lookAheadTest.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
            ((FeedPullToRefreshView) feedsActivity._$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider)).setDoneRefreshing(true);
            if (z || !feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2()) {
                TopFriendsAdapter topFriendsAdapter = feedsActivity.FragmentBottomSheetPaymentSettingBinding;
                List<FriendModel> emptyList = CollectionsKt.emptyList();
                Intrinsics.checkNotNullParameter(emptyList, "");
                topFriendsAdapter.BuiltInFictitiousFunctionClassFactory = emptyList;
                FeedModel.Companion companion = FeedModel.INSTANCE;
                topFriendsAdapter.setItems(CollectionsKt.mutableListOf(FeedModel.Companion.MyBillsEntityDataFactory(topFriendsAdapter.MyBillsEntityDataFactory, topFriendsAdapter.BuiltInFictitiousFunctionClassFactory)));
                NewSocialFeedsAdapter newSocialFeedsAdapter = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
                newSocialFeedsAdapter.DatabaseTableConfigUtil();
                newSocialFeedsAdapter.setItems(CollectionsKt.mutableListOf(new FeedViewHolderModel(4, null, null, null, null, false, 62, null)));
            }
            if (feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                feedsActivity.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            return;
        }
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        ((FeedPullToRefreshView) feedsActivity._$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider)).setDoneRefreshing(true);
        if (z || !feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.KClassImpl$Data$declaredNonStaticMembers$2()) {
            TopFriendsAdapter topFriendsAdapter2 = feedsActivity.FragmentBottomSheetPaymentSettingBinding;
            List<FriendModel> emptyList2 = CollectionsKt.emptyList();
            Intrinsics.checkNotNullParameter(emptyList2, "");
            topFriendsAdapter2.BuiltInFictitiousFunctionClassFactory = emptyList2;
            FeedModel.Companion companion2 = FeedModel.INSTANCE;
            topFriendsAdapter2.setItems(CollectionsKt.mutableListOf(FeedModel.Companion.MyBillsEntityDataFactory(topFriendsAdapter2.MyBillsEntityDataFactory, topFriendsAdapter2.BuiltInFictitiousFunctionClassFactory)));
            feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.DatabaseTableConfigUtil();
        }
        if (feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            feedsActivity.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static final /* synthetic */ void access$renderTimelineError(FeedsActivity feedsActivity) {
        feedsActivity.getAuthRequestContext("Fetch Feed Error");
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        feedsActivity.moveToNextValue = false;
        ((FeedPullToRefreshView) feedsActivity._$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider)).setDoneRefreshing(true);
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult(6, 7);
        feedsActivity.moveToNextValue();
    }

    public static final /* synthetic */ void access$renderTimelineSuccess(FeedsActivity feedsActivity, List list) {
        feedsActivity.getAuthRequestContext("Feed Success");
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        ((FeedPullToRefreshView) feedsActivity._$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider)).setDoneRefreshing(true);
        feedsActivity.moveToNextValue = false;
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.DatabaseTableConfigUtil();
        NewSocialFeedsAdapter newSocialFeedsAdapter = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (!newSocialFeedsAdapter.BuiltInFictitiousFunctionClassFactory() && newSocialFeedsAdapter.getItem(newSocialFeedsAdapter.getPlaceComponentResult() - 1).getErrorConfigVersion == 6) {
            newSocialFeedsAdapter.removeItem(newSocialFeedsAdapter.getPlaceComponentResult() - 1);
        }
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.appendItems(list);
        feedsActivity.moveToNextValue();
        if (feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            feedsActivity.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static final /* synthetic */ void access$renderTopFriendSuccess(FeedsActivity feedsActivity, List list) {
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        TopFriendsAdapter topFriendsAdapter = feedsActivity.FragmentBottomSheetPaymentSettingBinding;
        Intrinsics.checkNotNullParameter(list, "");
        topFriendsAdapter.BuiltInFictitiousFunctionClassFactory = list;
        FeedModel.Companion companion = FeedModel.INSTANCE;
        topFriendsAdapter.setItems(CollectionsKt.mutableListOf(FeedModel.Companion.MyBillsEntityDataFactory(topFriendsAdapter.MyBillsEntityDataFactory, topFriendsAdapter.BuiltInFictitiousFunctionClassFactory)));
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.removeAllItems();
    }

    public static final /* synthetic */ void access$renderUsernameBanner(FeedsActivity feedsActivity) {
        if (feedsActivity.lookAheadTest.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            ((UsernameBannerAdapter) feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).setItems(CollectionsKt.listOf(2));
        }
    }

    public static final /* synthetic */ void access$setCvBackToTopVisibility(FeedsActivity feedsActivity, boolean z) {
        View _$_findCachedViewById = feedsActivity._$_findCachedViewById(R.id.impressionsCount);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(z ? 0 : 8);
        }
    }

    public static final /* synthetic */ void access$setEmptyListSeeAllFriendBtnClick(FeedsActivity feedsActivity) {
        FeedConfig feedConfig = feedsActivity.getErrorConfigVersion;
        if (feedConfig != null && feedConfig.isReciprocalFeedEnabled()) {
            new ReciprocalBottomSheetDialog().show(feedsActivity.getSupportFragmentManager(), "ReciprocalBottomSheetDialog");
        } else {
            new RelationshipBottomSheetDialog().show(feedsActivity.getSupportFragmentManager(), "RelationshipBottomSheet");
        }
    }

    public static final /* synthetic */ void access$setupShareActivityBottomSheet(FeedsActivity feedsActivity, int i) {
        String str;
        feedsActivity.BuiltInFictitiousFunctionClassFactory = i;
        PreviewActivityData previewActivityData = feedsActivity.lookAheadTest.BuiltInFictitiousFunctionClassFactory.get(i);
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = previewActivityData;
        if (previewActivityData == null || (str = previewActivityData.getShareFeedRequestId()) == null) {
            str = "";
        }
        feedsActivity.id.dana.domain.social.ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID java.lang.String = str;
        feedsActivity.getErrorConfigVersion();
    }

    public static final /* synthetic */ void access$showActiveState(final FeedsActivity feedsActivity) {
        FeedOnboardingView feedOnboardingView = (FeedOnboardingView) feedsActivity._$_findCachedViewById(R.id.feedOnboardingView);
        if (feedOnboardingView != null) {
            feedOnboardingView.setVisibility(8);
        }
        FeedPullToRefreshView feedPullToRefreshView = (FeedPullToRefreshView) feedsActivity._$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider);
        if (feedPullToRefreshView != null) {
            feedPullToRefreshView.setVisibility(0);
        }
        feedsActivity.setMenuRightButton(R.drawable.ic_ellipsis_vertical, 16);
        final AppCompatImageView appCompatImageView = (AppCompatImageView) feedsActivity._$_findCachedViewById(R.id.LTOMLengthOf);
        if (appCompatImageView != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.ic_notification);
            appCompatImageView.setVisibility(0);
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.FeedsActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsActivity.m2953$r8$lambda$91HuVouwZNJVy32BO2051PDc(FeedsActivity.this, appCompatImageView, view);
                }
            });
        }
        feedsActivity.FragmentBottomSheetPaymentSettingBinding.MyBillsEntityDataFactory();
        NewSocialFeedsAdapter newSocialFeedsAdapter = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
        newSocialFeedsAdapter.setItems(newSocialFeedsAdapter.getAuthRequestContext());
        feedsActivity.getPresenter().MyBillsEntityDataFactory(true, false);
    }

    public static final /* synthetic */ void access$showErrorFetchUserConfig(FeedsActivity feedsActivity) {
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.DatabaseTableConfigUtil();
        feedsActivity.KClassImpl$Data$declaredNonStaticMembers$2(true);
        feedsActivity.getAuthRequestContext(false);
    }

    public static final /* synthetic */ void access$showFinishFetchUserConfigState(FeedsActivity feedsActivity) {
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.DatabaseTableConfigUtil();
        feedsActivity.KClassImpl$Data$declaredNonStaticMembers$2(false);
        feedsActivity.getAuthRequestContext(false);
        if (feedsActivity.getPresenter().newProxyInstance()) {
            FeedOnboardingView feedOnboardingView = (FeedOnboardingView) feedsActivity._$_findCachedViewById(R.id.feedOnboardingView);
            if (feedOnboardingView != null) {
                feedOnboardingView.setVisibility(8);
            }
            FeedPullToRefreshView feedPullToRefreshView = (FeedPullToRefreshView) feedsActivity._$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider);
            if (feedPullToRefreshView != null) {
                feedPullToRefreshView.setVisibility(0);
            }
            feedsActivity.getPresenter().MyBillsEntityDataFactory(false, false);
            return;
        }
        feedsActivity.getPresenter().NetworkUserEntityData$$ExternalSyntheticLambda8();
    }

    public static final /* synthetic */ void access$showInitFeedErrorState(FeedsActivity feedsActivity) {
        feedsActivity.getAuthRequestContext("Init Feed Error");
        FeedOnboardingView feedOnboardingView = (FeedOnboardingView) feedsActivity._$_findCachedViewById(R.id.feedOnboardingView);
        if (feedOnboardingView != null) {
            feedOnboardingView.setVisibility(0);
        }
        FeedOnboardingView feedOnboardingView2 = (FeedOnboardingView) feedsActivity._$_findCachedViewById(R.id.feedOnboardingView);
        if (feedOnboardingView2 != null) {
            feedOnboardingView2.renderButtonError();
        }
    }

    public static final /* synthetic */ void access$showInitFeedLoadingState(FeedsActivity feedsActivity) {
        FeedOnboardingView feedOnboardingView = (FeedOnboardingView) feedsActivity._$_findCachedViewById(R.id.feedOnboardingView);
        if (feedOnboardingView != null) {
            feedOnboardingView.renderButtonDisabled();
        }
    }

    public static final /* synthetic */ void access$showLoadingFetchUserConfig(FeedsActivity feedsActivity) {
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.DatabaseTableConfigUtil();
        feedsActivity.KClassImpl$Data$declaredNonStaticMembers$2(false);
        feedsActivity.getAuthRequestContext(true);
    }

    public static final /* synthetic */ void access$showOnboardingState(FeedsActivity feedsActivity) {
        if (feedsActivity.getPresenter().getGetCallingPid()) {
            return;
        }
        feedsActivity.getAuthRequestContext("Onboarding");
        FeedOnboardingView feedOnboardingView = (FeedOnboardingView) feedsActivity._$_findCachedViewById(R.id.feedOnboardingView);
        if (feedOnboardingView != null) {
            feedOnboardingView.setVisibility(0);
        }
        FeedOnboardingView feedOnboardingView2 = (FeedOnboardingView) feedsActivity._$_findCachedViewById(R.id.feedOnboardingView);
        if (feedOnboardingView2 != null) {
            feedOnboardingView2.renderButtonEnabled();
        }
        FeedPullToRefreshView feedPullToRefreshView = (FeedPullToRefreshView) feedsActivity._$_findCachedViewById(R.id.res_0x7f0a06d7_daggersavingtopuphistorycomponent_savingtopuphistorycomponentimpl_contextprovider);
        if (feedPullToRefreshView != null) {
            feedPullToRefreshView.setVisibility(8);
        }
        feedsActivity.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void access$showShareFeedLoadingState(FeedsActivity feedsActivity, String str, String str2, ActivityWidget activityWidget) {
        FeedModel.Companion companion = FeedModel.INSTANCE;
        String str3 = feedsActivity.id.dana.domain.social.ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID java.lang.String;
        MyFeedHeaderModel myFeedHeaderModel = feedsActivity.PrepareContext;
        PreviewActivityData previewActivityData = feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.prependItem(new FeedViewHolderModel(9, FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(str3, str, str2, myFeedHeaderModel, previewActivityData != null ? previewActivityData.getExtendInfo() : null, activityWidget, null, 64), null, null, null, true, 28, null));
    }

    public static final /* synthetic */ void access$showSyncingState(FeedsActivity feedsActivity) {
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        feedsActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        ((UsernameBannerAdapter) feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).setItems(CollectionsKt.emptyList());
        feedsActivity.FragmentBottomSheetPaymentSettingBinding.setItems(new ArrayList());
        feedsActivity.NetworkUserEntityData$$ExternalSyntheticLambda6.setItems(CollectionsKt.mutableListOf(new FeedViewHolderModel(12, null, null, null, null, false, 62, null)));
    }

    public static final /* synthetic */ void access$showTopToastPositive(FeedsActivity feedsActivity, String str) {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.MyBillsEntityDataFactory(feedsActivity, R.drawable.ic_check_24_green50_filled_circle, R.drawable.bg_rounded_border_green_50, str);
    }

    private static void g(int i, int i2, short s, byte b, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i3 + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = getValueOfTouchPositionAbsolute;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (getValueOfTouchPositionAbsolute[i2 + ((int) (A ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (D[i2 + ((int) (A ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i2 + i4) - 2) + ((int) (A ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (getOnBoardingScenario ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = getValueOfTouchPositionAbsolute;
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
                    byte[] bArr5 = getValueOfTouchPositionAbsolute;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = D;
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
