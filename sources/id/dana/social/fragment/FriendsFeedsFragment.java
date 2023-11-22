package id.dana.social.fragment;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import androidx.work.WorkInfo;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.richview.LoadingLottieAnimationView;
import id.dana.databinding.FragmentFriendFeedBinding;
import id.dana.databinding.ViewSocialFriendsFeedBinding;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.eventbus.models.TimerEvent;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.share.model.ShareFeedActivity;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.ui.model.CreateFeedActivityRequestModel;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.model.ThirdPartyService;
import id.dana.network.exception.NetworkException;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.social.ContentGroupingDetailActivity;
import id.dana.social.ReciprocalBottomSheetDialog;
import id.dana.social.RelationshipBottomSheetDialog;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.adapter.FeedActivityBannerViewAdapter;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.adapter.SocialFeedsAdapter;
import id.dana.social.adapter.TopFriendsAdapter;
import id.dana.social.adapter.UsernameBannerAdapter;
import id.dana.social.adapter.viewholder.FeedActivityBannerViewHolder;
import id.dana.social.common.FeedOnboardingListener;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.FriendsFeedsModule;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.fragment.FriendsFeedsFragment;
import id.dana.social.mapper.FeedTrackerModelMapperKt;
import id.dana.social.mapper.FeedViewModelMapperKt;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.onboarding.FeedOnboardingView;
import id.dana.social.utils.Content;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.SocialSyncManagerKt;
import id.dana.social.v2.fragment.ShareActivityBottomSheetDialog;
import id.dana.social.view.FeedsMeHeaderView;
import id.dana.social.view.activity.SocialProfileActivity;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import id.dana.social.view.activity.notification.FeedNotificationActivity;
import id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.utils.permission.PermissionHelper;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002_`B\t\b\u0016¢\u0006\u0004\b]\u0010\u000eB\u000f\u0012\u0006\u0010\u0016\u001a\u00020B¢\u0006\u0004\b]\u0010^J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u0011J\u000f\u0010\u001b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u000eJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u000eJ\u001f\u0010\"\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010\u000eJ\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u000eJ\u000f\u0010(\u001a\u00020\fH\u0016¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010\u000eJ\r\u0010*\u001a\u00020\f¢\u0006\u0004\b*\u0010\u000eJ\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0013\u0010\"\u001a\u000205X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001c\u00106R\u0016\u00109\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0012\u0010;\u001a\u00020:X\u0087\"¢\u0006\u0006\n\u0004\b;\u0010<R\u0013\u0010\u0017\u001a\u00020=X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b>\u00106R\u0012\u0010@\u001a\u00020?X\u0087\"¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020B8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010CR\u0016\u0010G\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0012\u0010J\u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\bI\u0010FR\u0016\u0010\n\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010FR\u001a\u00102\u001a\u00020\u000f8\u0007X\u0087\u0006¢\u0006\f\n\u0004\bK\u0010F\u001a\u0004\bH\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010FR\u0016\u0010\u001a\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010FR\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010K\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010OR\u0012\u0010Q\u001a\u00020PX\u0087\"¢\u0006\u0006\n\u0004\bQ\u0010RR\u0013\u0010>\u001a\u00020SX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u00106R\u0016\u0010\u001c\u001a\u00020T8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0010\u0010UR\u0012\u0010E\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010VR\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010FR\u0016\u00107\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010FR\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010FR\u0016\u0010\u0007\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010FR\u0014\u0010H\u001a\u00020W8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0012\u0010(\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010VR\u0013\u0010L\u001a\u00020ZX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b%\u00106R\u0013\u0010\u0013\u001a\u00020[X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b'\u00106R\u0014\u0010\u0010\u001a\u0002018\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\\\u00103"}, d2 = {"Lid/dana/social/fragment/FriendsFeedsFragment;", "Lid/dana/social/fragment/BaseFeedTimelineFragment;", "Lid/dana/databinding/FragmentFriendFeedBinding;", "", "getLayout", "()I", "", "NetworkUserEntityData$$ExternalSyntheticLambda6", "()Ljava/lang/String;", "Lid/dana/social/adapter/SocialFeedClickListener;", "lookAheadTest", "()Lid/dana/social/adapter/SocialFeedClickListener;", "", "whenAvailable", "()V", "", "getSupportButtonTintMode", "()Z", "SubSequence", "readMicros", IAPSyncCommand.COMMAND_INIT, "Lid/dana/social/model/FeedModel;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/model/FeedModel;)Z", "GetContactSyncConfig", "initRecordTimeStamp", "getCallingPid", "newProxyInstance", "onResume", "onSelected", "Lid/dana/eventbus/models/TimerEvent;", "", "p1", "PlaceComponentResult", "(Lid/dana/eventbus/models/TimerEvent;J)V", "isLayoutRequested", "A", "C", DiskFormatter.B, "FragmentBottomSheetPaymentSettingBinding", "BottomSheetCardBindingView$watcherCardNumberView$1", "NetworkUserEntityData$$ExternalSyntheticLambda5", "(Ljava/lang/String;)V", "", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/util/List;", "getAuthRequestContext", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "DatabaseTableConfigUtil", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "MyBillsEntityDataFactory", "Lid/dana/social/view/fragment/ContactPermissionBottomSheetDialogFragment;", "Lkotlin/Lazy;", "PrepareContext", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/contract/contact/DanaContactContract$Presenter;", "danaContactpresenter", "Lid/dana/contract/contact/DanaContactContract$Presenter;", "Lid/dana/social/adapter/FeedActivityBannerViewAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "Lid/dana/social/fragment/FriendsFeedsFragment$Interaction;", "Lid/dana/social/fragment/FriendsFeedsFragment$Interaction;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Z", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda3", "getErrorConfigVersion", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$Presenter;", "presenter", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$Presenter;", "Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "Ljava/lang/String;", "Lid/dana/social/fragment/FriendsFeedsFragment$socialFeedListener$1;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/social/fragment/FriendsFeedsFragment$socialFeedListener$1;", "Lid/dana/social/adapter/TopFriendsAdapter;", "Lid/dana/social/adapter/UsernameBannerAdapter;", SummaryActivity.DAYS, "<init>", "(Lid/dana/social/fragment/FriendsFeedsFragment$Interaction;)V", "Companion", "Interaction"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendsFeedsFragment extends BaseFeedTimelineFragment<FragmentFriendFeedBinding> {

    /* renamed from: A  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: B */
    private final Lazy readMicros;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: C  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: D */
    private final FragmentPermissionRequest getSupportButtonTintMode;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final FragmentPermissionRequest MyBillsEntityDataFactory;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private List<PreviewActivityData> getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    boolean DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private PreviewActivityData NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private boolean PrepareContext;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private final FriendsFeedsFragment$socialFeedListener$1 NetworkUserEntityData$$ExternalSyntheticLambda3;
    @Inject
    public DanaContactContract.Presenter danaContactpresenter;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean isLayoutRequested;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public boolean moveToNextValue;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private TwoButtonWithImageDialog newProxyInstance;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Interaction NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Map<Integer, View> moveToNextValue;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;
    @Inject
    public FriendFeedsContract.Presenter presenter;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private MyFeedHeaderModel NetworkUserEntityData$$ExternalSyntheticLambda2;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/fragment/FriendsFeedsFragment$Interaction;", "", "", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Interaction {
        void getAuthRequestContext();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[InitStatus.values().length];
            iArr[InitStatus.NOT_ACTIVATED.ordinal()] = 1;
            iArr[InitStatus.ERROR.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final boolean GetContactSyncConfig() {
        return false;
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.moveToNextValue.clear();
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.moveToNextValue;
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

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_friend_feed;
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX WARN: Type inference failed for: r5v20, types: [id.dana.social.fragment.FriendsFeedsFragment$socialFeedListener$1] */
    public FriendsFeedsFragment(Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "");
        this.moveToNextValue = new LinkedHashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = interaction;
        this.GetContactSyncConfig = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = LazyKt.lazy(new Function0<TopFriendsAdapter>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$topFriendsAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TopFriendsAdapter invoke() {
                return new TopFriendsAdapter();
            }
        });
        this.readMicros = LazyKt.lazy(new Function0<UsernameBannerAdapter>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$usernameBannerAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.social.fragment.FriendsFeedsFragment$usernameBannerAdapter$2$1  reason: invalid class name */
            /* loaded from: classes5.dex */
            public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass1(Object obj) {
                    super(0, obj, FriendsFeedsFragment.Interaction.class, "getAuthRequestContext", "getAuthRequestContext()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((FriendsFeedsFragment.Interaction) this.receiver).getAuthRequestContext();
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UsernameBannerAdapter invoke() {
                FriendsFeedsFragment.Interaction interaction2;
                interaction2 = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                return new UsernameBannerAdapter(new AnonymousClass1(interaction2));
            }
        });
        this.isLayoutRequested = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = "";
        this.FragmentBottomSheetPaymentSettingBinding = "";
        FriendsFeedsFragment friendsFeedsFragment = this;
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(friendsFeedsFragment);
        String[] strArr = {"android.permission.READ_CONTACTS"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.social.fragment.FriendsFeedsFragment$contactPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                FeedOnboardingView feedOnboardingView;
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    FriendsFeedsFragment.D(FriendsFeedsFragment.this);
                    return;
                }
                FragmentFriendFeedBinding lookAheadTest = FriendsFeedsFragment.lookAheadTest(FriendsFeedsFragment.this);
                if (lookAheadTest == null || (feedOnboardingView = lookAheadTest.getErrorConfigVersion) == null) {
                    return;
                }
                feedOnboardingView.renderButtonEnabled();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FriendsFeedsFragment.SubSequence(FriendsFeedsFragment.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder2 = new FragmentPermissionRequest.Builder(friendsFeedsFragment);
        String[] strArr2 = {"android.permission.WRITE_CONTACTS"};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.getAuthRequestContext = ArraysKt.toSet(strArr2);
        PermissionCallback permissionCallback2 = new PermissionCallback() { // from class: id.dana.social.fragment.FriendsFeedsFragment$writeContactPermission$1
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
                    FriendsFeedsFragment.getCallingPid(FriendsFeedsFragment.this);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback2, "");
        builder2.BuiltInFictitiousFunctionClassFactory = permissionCallback2;
        this.getSupportButtonTintMode = builder2.PlaceComponentResult();
        this.PlaceComponentResult = LazyKt.lazy(new Function0<ContactPermissionBottomSheetDialogFragment>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$contactPermissionBottomSheetDialogFragment$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ContactPermissionBottomSheetDialogFragment invoke() {
                return new ContactPermissionBottomSheetDialogFragment();
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<ShareActivityBottomSheetDialog>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$shareFeedBottomSheetDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShareActivityBottomSheetDialog invoke() {
                BaseActivity baseActivity = FriendsFeedsFragment.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                ShareActivityBottomSheetDialog.Builder builder3 = new ShareActivityBottomSheetDialog.Builder(null, null, baseActivity, false, 11, null);
                final FriendsFeedsFragment friendsFeedsFragment2 = FriendsFeedsFragment.this;
                Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$shareFeedBottomSheetDialog$2.1
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
                        String str3;
                        FriendFeedsContract.Presenter presenter;
                        PreviewActivityData previewActivityData2;
                        Intrinsics.checkNotNullParameter(str, "");
                        Intrinsics.checkNotNullParameter(str2, "");
                        FriendshipAnalyticTracker friendshipAnalyticTracker = FriendsFeedsFragment.this.friendshipAnalyticTracker;
                        if (friendshipAnalyticTracker == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            friendshipAnalyticTracker = null;
                        }
                        previewActivityData = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (previewActivityData == null || (str3 = previewActivityData.getContentType()) == null) {
                            str3 = "";
                        }
                        friendshipAnalyticTracker.scheduleImpl(str3);
                        FriendFeedsContract.Presenter presenter2 = FriendsFeedsFragment.this.presenter;
                        if (presenter2 != null) {
                            presenter = presenter2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            presenter = null;
                        }
                        String str4 = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        previewActivityData2 = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        presenter.MyBillsEntityDataFactory(new CreateFeedActivityRequestModel(str4, str, str2, null, null, previewActivityData2 != null ? previewActivityData2.getExtendInfo() : null, false, null, 216, null));
                        FriendsFeedsFragment.MyBillsEntityDataFactory(FriendsFeedsFragment.this, false);
                    }
                };
                Intrinsics.checkNotNullParameter(function2, "");
                builder3.BuiltInFictitiousFunctionClassFactory = function2;
                final FriendsFeedsFragment friendsFeedsFragment3 = FriendsFeedsFragment.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$shareFeedBottomSheetDialog$2.2
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
                        FriendFeedsContract.Presenter presenter = null;
                        FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
                        FriendFeedsContract.Presenter presenter2 = FriendsFeedsFragment.this.presenter;
                        if (presenter2 != null) {
                            presenter = presenter2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        presenter.MyBillsEntityDataFactory(FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                        FriendsFeedsFragment.MyBillsEntityDataFactory(FriendsFeedsFragment.this, false);
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder3.PlaceComponentResult = function0;
                builder3.MyBillsEntityDataFactory = false;
                return builder3.PlaceComponentResult();
            }
        });
        this.getAuthRequestContext = CollectionsKt.emptyList();
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<FeedActivityBannerViewAdapter>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$feedActivityBannerViewAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedActivityBannerViewAdapter invoke() {
                FriendsFeedsFragment$socialFeedListener$1 friendsFeedsFragment$socialFeedListener$1;
                final FriendsFeedsFragment friendsFeedsFragment2 = FriendsFeedsFragment.this;
                Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$feedActivityBannerViewAdapter$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        List list;
                        List list2;
                        FriendFeedsContract.Presenter presenter = FriendsFeedsFragment.this.presenter;
                        if (presenter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            presenter = null;
                        }
                        list = FriendsFeedsFragment.this.getAuthRequestContext;
                        presenter.MyBillsEntityDataFactory((PreviewActivityData) list.get(i));
                        list2 = FriendsFeedsFragment.this.getAuthRequestContext;
                        ((PreviewActivityData) list2.get(i)).setSkip(true);
                    }
                };
                final FriendsFeedsFragment friendsFeedsFragment3 = FriendsFeedsFragment.this;
                Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$feedActivityBannerViewAdapter$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        List list;
                        PreviewActivityData previewActivityData;
                        String str;
                        FriendsFeedsFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                        FriendsFeedsFragment friendsFeedsFragment4 = FriendsFeedsFragment.this;
                        list = friendsFeedsFragment4.getAuthRequestContext;
                        friendsFeedsFragment4.NetworkUserEntityData$$ExternalSyntheticLambda1 = (PreviewActivityData) list.get(i);
                        FriendsFeedsFragment friendsFeedsFragment5 = FriendsFeedsFragment.this;
                        previewActivityData = friendsFeedsFragment5.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (previewActivityData == null || (str = previewActivityData.getShareFeedRequestId()) == null) {
                            str = "";
                        }
                        Intrinsics.checkNotNullParameter(str, "");
                        friendsFeedsFragment5.NetworkUserEntityData$$ExternalSyntheticLambda8 = str;
                        FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5();
                    }
                };
                friendsFeedsFragment$socialFeedListener$1 = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                return new FeedActivityBannerViewAdapter(function1, function12, friendsFeedsFragment$socialFeedListener$1);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new BaseSocialFeedInteraction() { // from class: id.dana.social.fragment.FriendsFeedsFragment$socialFeedListener$1
            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void getAuthRequestContext(int p0) {
                GroupedFeedModel groupedFeedModel;
                List<FeedModel> list;
                FriendsFeedsFragment friendsFeedsFragment2;
                Context context;
                boolean z;
                boolean z2;
                boolean z3;
                FeedViewHolderModel item = ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.getItem(p0);
                if (item == null || (groupedFeedModel = item.BuiltInFictitiousFunctionClassFactory) == null || (list = groupedFeedModel.BuiltInFictitiousFunctionClassFactory) == null || (context = (friendsFeedsFragment2 = FriendsFeedsFragment.this).getContext()) == null) {
                    return;
                }
                ContentGroupingDetailActivity.Companion companion = ContentGroupingDetailActivity.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(context, "");
                ArrayList MyBillsEntityDataFactory = FriendsFeedsFragment.MyBillsEntityDataFactory(list);
                z = friendsFeedsFragment2.NetworkUserEntityData$$ExternalSyntheticLambda5;
                z2 = friendsFeedsFragment2.PrepareContext;
                z3 = friendsFeedsFragment2.initRecordTimeStamp;
                ContentGroupingDetailActivity.Companion.getAuthRequestContext(context, MyBillsEntityDataFactory, z, z2, 0, false, z3);
            }

            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void getAuthRequestContext(Content p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FriendshipAnalyticTracker friendshipAnalyticTracker = FriendsFeedsFragment.this.friendshipAnalyticTracker;
                FriendFeedsContract.Presenter presenter = null;
                if (friendshipAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendshipAnalyticTracker = null;
                }
                friendshipAnalyticTracker.getAuthRequestContext(FeedTrackerModelMapperKt.getAuthRequestContext(p0));
                FriendFeedsContract.Presenter presenter2 = FriendsFeedsFragment.this.presenter;
                if (presenter2 != null) {
                    presenter = presenter2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                String str = p0.MyBillsEntityDataFactory;
                presenter.KClassImpl$Data$declaredNonStaticMembers$2(str != null ? str : "");
            }

            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                FeedViewHolderModel item = ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.getItem(p0);
                if (item != null) {
                    FriendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(FriendsFeedsFragment.this, item);
                }
            }

            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void getAuthRequestContext() {
                boolean z;
                z = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (z) {
                    new ReciprocalBottomSheetDialog().show(FriendsFeedsFragment.this.getBaseActivity().getSupportFragmentManager(), "");
                } else {
                    new RelationshipBottomSheetDialog().show(FriendsFeedsFragment.this.getBaseActivity().getSupportFragmentManager(), "");
                }
            }

            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void MyBillsEntityDataFactory(int p0) {
                boolean z;
                FeedViewHolderModel item;
                z = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (z && (item = ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.getItem(p0)) != null) {
                    FriendsFeedsFragment.KClassImpl$Data$declaredNonStaticMembers$2(FriendsFeedsFragment.this, item);
                }
            }

            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void BuiltInFictitiousFunctionClassFactory(int p0) {
                FeedModel feedModel = ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.getItem(p0).MyBillsEntityDataFactory;
                if (feedModel != null) {
                    FriendsFeedsFragment friendsFeedsFragment2 = FriendsFeedsFragment.this;
                    ((BaseFeedTimelineFragment) friendsFeedsFragment2).lookAheadTest.BuiltInFictitiousFunctionClassFactory(p0, FeedActivityState.INIT);
                    FriendFeedsContract.Presenter presenter = friendsFeedsFragment2.presenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    HashMap<String, String> hashMap = feedModel.lookAheadTest;
                    String shareFeedRequestId = hashMap != null ? ExtendInfoUtilKt.getShareFeedRequestId(hashMap) : null;
                    String str = shareFeedRequestId == null ? "" : shareFeedRequestId;
                    String str2 = feedModel.scheduleImpl;
                    String str3 = str2 == null ? "" : str2;
                    String str4 = feedModel.MyBillsEntityDataFactory;
                    presenter.MyBillsEntityDataFactory(new CreateFeedActivityRequestModel(str, str3, str4 == null ? "" : str4, null, null, null, true, null, 184, null));
                }
            }

            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void PlaceComponentResult(int p0) {
                FeedModel feedModel = ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.getItem(p0).MyBillsEntityDataFactory;
                if (feedModel != null) {
                    FriendsFeedsFragment friendsFeedsFragment2 = FriendsFeedsFragment.this;
                    SocialFeedsAdapter socialFeedsAdapter = ((BaseFeedTimelineFragment) friendsFeedsFragment2).lookAheadTest;
                    HashMap<String, String> hashMap = feedModel.lookAheadTest;
                    String shareFeedRequestId = hashMap != null ? ExtendInfoUtilKt.getShareFeedRequestId(hashMap) : null;
                    if (shareFeedRequestId == null) {
                        shareFeedRequestId = "";
                    }
                    String string = friendsFeedsFragment2.getString(R.string.feed_section_today);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    socialFeedsAdapter.MyBillsEntityDataFactory(shareFeedRequestId, string);
                    FriendFeedsContract.Presenter presenter = friendsFeedsFragment2.presenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    HashMap<String, String> hashMap2 = feedModel.lookAheadTest;
                    String shareFeedRequestId2 = hashMap2 != null ? ExtendInfoUtilKt.getShareFeedRequestId(hashMap2) : null;
                    presenter.BuiltInFictitiousFunctionClassFactory(shareFeedRequestId2 != null ? shareFeedRequestId2 : "");
                }
            }
        };
    }

    public static final /* synthetic */ FragmentFriendFeedBinding lookAheadTest(FriendsFeedsFragment friendsFeedsFragment) {
        return (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentFriendFeedBinding authRequestContext = FragmentFriendFeedBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public FriendsFeedsFragment() {
        this(new Interaction() { // from class: id.dana.social.fragment.FriendsFeedsFragment.1
            @Override // id.dana.social.fragment.FriendsFeedsFragment.Interaction
            public final void getAuthRequestContext() {
            }
        });
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda3")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from getter */
    public final boolean getDatabaseTableConfigUtil() {
        return this.DatabaseTableConfigUtil;
    }

    public final boolean getSupportButtonTintMode() {
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBaseActivity(), "android.permission.READ_CONTACTS") == 0;
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.base.BaseFragment
    public final void init() {
        DanaButtonPrimaryView danaButtonPrimaryView;
        super.init();
        SocialCommonComponent socialCommonComponent = getBaseActivity().getDanaApplication().getSocialCommonComponent();
        byte b = 0;
        if (socialCommonComponent != null) {
            FriendsFeedsModule friendsFeedsModule = new FriendsFeedsModule(new FriendFeedsContract.View() { // from class: id.dana.social.fragment.FriendsFeedsFragment$inject$1
                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State p0) {
                    boolean isSafe;
                    Intrinsics.checkNotNullParameter(p0, "");
                    isSafe = FriendsFeedsFragment.this.isSafe();
                    if (isSafe) {
                        if (p0 instanceof FriendFeedsContract.State.TopFriendSuccess) {
                            FriendsFeedsFragment.getAuthRequestContext(FriendsFeedsFragment.this, ((FriendFeedsContract.State.TopFriendSuccess) p0).MyBillsEntityDataFactory);
                        } else if (p0 instanceof FriendFeedsContract.State.TopFriendError) {
                            FriendsFeedsFragment.getOnBoardingScenario(FriendsFeedsFragment.this);
                        } else if (p0 instanceof FriendFeedsContract.State.UsernameBannerDisplayed) {
                            FriendsFeedsFragment.VerifyPinStateManager$executeRiskChallenge$2$2(FriendsFeedsFragment.this);
                        } else if (p0 instanceof FriendFeedsContract.State.UsernameBannerHidden) {
                            FriendsFeedsFragment.this.lookAheadTest = true;
                            FriendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(FriendsFeedsFragment.this).setItems(CollectionsKt.emptyList());
                        } else if (p0 instanceof FriendFeedsContract.State.TimelineError) {
                            FriendsFeedsFragment.getAuthRequestContext(FriendsFeedsFragment.this, ((FriendFeedsContract.State.TimelineError) p0).getGetAuthRequestContext());
                        } else if (p0 instanceof FriendFeedsContract.State.TimelineSuccess) {
                            FriendsFeedsFragment.KClassImpl$Data$declaredNonStaticMembers$2(FriendsFeedsFragment.this, ((FriendFeedsContract.State.TimelineSuccess) p0).PlaceComponentResult);
                        } else if (p0 instanceof FriendFeedsContract.State.InitFeedLoading) {
                            FriendsFeedsFragment.this.C();
                            if (FriendsFeedsFragment.this.getDatabaseTableConfigUtil()) {
                                return;
                            }
                            FriendsFeedsFragment.this.DatabaseTableConfigUtil = true;
                            FriendFeedsContract.Presenter presenter = FriendsFeedsFragment.this.presenter;
                            if (presenter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                presenter = null;
                            }
                            presenter.DatabaseTableConfigUtil();
                        } else if (p0 instanceof FriendFeedsContract.State.InitFeedFinished) {
                            FriendsFeedsFragment.VerifyPinStateManager$executeRiskChallenge$2$1(FriendsFeedsFragment.this);
                        } else if (p0 instanceof FriendFeedsContract.State.InitFeedError) {
                            FriendsFeedsFragment.A(FriendsFeedsFragment.this);
                        } else if (p0 instanceof FriendFeedsContract.State.InitFeedNotActivated) {
                            FriendsFeedsFragment.this.B();
                        } else if (p0 instanceof FriendFeedsContract.State.FeedEmpty) {
                            FriendsFeedsFragment.this.FragmentBottomSheetPaymentSettingBinding();
                        } else if (p0 instanceof FriendFeedsContract.State.FeedSyncing) {
                            FriendsFeedsFragment.F(FriendsFeedsFragment.this);
                        } else if (!(p0 instanceof FriendFeedsContract.State.FeedSynced)) {
                            if (p0 instanceof FriendFeedsContract.State.ObserveSyncContact) {
                                FriendsFeedsFragment.getSupportButtonTintMode(FriendsFeedsFragment.this);
                            } else if (p0 instanceof FriendFeedsContract.State.LoadingFetchUserConfig) {
                                FriendsFeedsFragment.AppCompatEmojiTextHelper(FriendsFeedsFragment.this);
                            } else if (p0 instanceof FriendFeedsContract.State.ErrorFetchUserConfig) {
                                FriendsFeedsFragment.G(FriendsFeedsFragment.this);
                            } else if (p0 instanceof FriendFeedsContract.State.FinishFetchUserConfig) {
                                FriendsFeedsFragment.B(FriendsFeedsFragment.this);
                            }
                        } else {
                            ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.GetContactSyncConfig();
                        }
                    }
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void MyBillsEntityDataFactory(int p0) {
                    ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
                    FragmentFriendFeedBinding lookAheadTest = FriendsFeedsFragment.lookAheadTest(FriendsFeedsFragment.this);
                    FeedsMeHeaderView feedsMeHeaderView = (lookAheadTest == null || (viewSocialFriendsFeedBinding = lookAheadTest.lookAheadTest) == null) ? null : viewSocialFriendsFeedBinding.lookAheadTest;
                    if (feedsMeHeaderView != null) {
                        feedsMeHeaderView.setFeedNotificationCount(p0);
                    }
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void BuiltInFictitiousFunctionClassFactory(MyFeedHeaderModel p0) {
                    PreviewActivityData previewActivityData;
                    String NetworkUserEntityData$$ExternalSyntheticLambda6;
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
                    previewActivityData = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (previewActivityData != null) {
                        NetworkUserEntityData$$ExternalSyntheticLambda6 = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
                        String str = NetworkUserEntityData$$ExternalSyntheticLambda6;
                        if (str == null || str.length() == 0) {
                            FriendsFeedsFragment.newProxyInstance(FriendsFeedsFragment.this).getAuthRequestContext = p0.MyBillsEntityDataFactory;
                        }
                    }
                    LoadingLottieAnimationView loadingLottieAnimationView = FriendsFeedsFragment.this.getAuthRequestContext;
                    if (loadingLottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        loadingLottieAnimationView = null;
                    }
                    loadingLottieAnimationView.cancelAnimation();
                    FriendsFeedsFragment.PlaceComponentResult(FriendsFeedsFragment.this, p0);
                    FriendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(FriendsFeedsFragment.this, p0);
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendsFeedsFragment friendsFeedsFragment = FriendsFeedsFragment.this;
                    Intrinsics.checkNotNullParameter("", "");
                    friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda8 = "";
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void BuiltInFictitiousFunctionClassFactory(FeedModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.PlaceComponentResult(p0, FeedActivityState.ERROR);
                    FriendsFeedsFragment friendsFeedsFragment = FriendsFeedsFragment.this;
                    Intrinsics.checkNotNullParameter("", "");
                    friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda8 = "";
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    FriendsFeedsFragment.H(FriendsFeedsFragment.this);
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void PlaceComponentResult(CreateFeedActivityRequestModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendsFeedsFragment.newProxyInstance(FriendsFeedsFragment.this).dismiss();
                    FriendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(FriendsFeedsFragment.this, p0.getAuthRequestContext, p0.KClassImpl$Data$declaredNonStaticMembers$2);
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void MyBillsEntityDataFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendsFeedsFragment friendsFeedsFragment = FriendsFeedsFragment.this;
                    String string = friendsFeedsFragment.getString(R.string.share_feed_deleted_toast_msg);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    FriendsFeedsFragment.MyBillsEntityDataFactory(friendsFeedsFragment, string);
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void PlaceComponentResult(ShareFeedActivity p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (FriendsFeedsFragment.newProxyInstance(FriendsFeedsFragment.this).isVisible()) {
                        return;
                    }
                    FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0.getPreviewActivityData();
                    FriendsFeedsFragment friendsFeedsFragment = FriendsFeedsFragment.this;
                    String shareFeedRequestId = p0.getShareFeedRequestId();
                    Intrinsics.checkNotNullParameter(shareFeedRequestId, "");
                    friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda8 = shareFeedRequestId;
                    FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5();
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void PlaceComponentResult(FeedConfig p0) {
                    ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
                    FeedsMeHeaderView feedsMeHeaderView;
                    Intrinsics.checkNotNullParameter(p0, "");
                    boolean z = p0.getFeedVersion() > 3;
                    FriendsFeedsFragment.this.initRecordTimeStamp = p0.isReplyCommentEnabled();
                    FriendsFeedsFragment.this.PrepareContext = z;
                    FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5 = p0.isFeedCommentEnabled();
                    FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6 = p0.isReciprocalFeedEnabled();
                    FriendsFeedsFragment.this.getErrorConfigVersion = p0.isFeedNotificationEnabled();
                    FriendsFeedsFragment.this.scheduleImpl = p0.isCreateActivityEnabled() && p0.getShareActivity().getFeedOnlineMerchantBanner();
                    FriendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda4(FriendsFeedsFragment.this).KClassImpl$Data$declaredNonStaticMembers$2 = p0.isReciprocalFeedEnabled();
                    ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.MyBillsEntityDataFactory = z;
                    ((BaseFeedTimelineFragment) FriendsFeedsFragment.this).lookAheadTest.PlaceComponentResult = p0.isFeedCommentEnabled() && !FriendsFeedsFragment.this.GetContactSyncConfig();
                    FragmentFriendFeedBinding lookAheadTest = FriendsFeedsFragment.lookAheadTest(FriendsFeedsFragment.this);
                    if (lookAheadTest != null && (viewSocialFriendsFeedBinding = lookAheadTest.lookAheadTest) != null && (feedsMeHeaderView = viewSocialFriendsFeedBinding.lookAheadTest) != null) {
                        feedsMeHeaderView.renderNotificationIcon(p0.isFeedNotificationEnabled());
                    }
                    FriendsFeedsFragment.KClassImpl$Data$declaredNonStaticMembers$2(FriendsFeedsFragment.this);
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void scheduleImpl() {
                    FriendshipAnalyticTracker friendshipAnalyticTracker = FriendsFeedsFragment.this.friendshipAnalyticTracker;
                    FriendFeedsContract.Presenter presenter = null;
                    if (friendshipAnalyticTracker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendshipAnalyticTracker = null;
                    }
                    FriendFeedsContract.Presenter presenter2 = FriendsFeedsFragment.this.presenter;
                    if (presenter2 != null) {
                        presenter = presenter2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    friendshipAnalyticTracker.PlaceComponentResult(presenter.getReadMicros());
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void getAuthRequestContext(List<PreviewActivityData> p0) {
                    List list;
                    MyFeedHeaderModel myFeedHeaderModel;
                    List<PreviewActivityData> list2 = p0;
                    if (!(list2 == null || list2.isEmpty())) {
                        FriendsFeedsFragment.this.getAuthRequestContext = p0;
                        FeedViewHolderModel.Companion companion = FeedViewHolderModel.INSTANCE;
                        list = FriendsFeedsFragment.this.getAuthRequestContext;
                        myFeedHeaderModel = FriendsFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        List<FeedViewHolderModel> authRequestContext = FeedViewHolderModel.Companion.getAuthRequestContext(list, myFeedHeaderModel);
                        FeedActivityBannerViewAdapter DatabaseTableConfigUtil = FriendsFeedsFragment.DatabaseTableConfigUtil(FriendsFeedsFragment.this);
                        Intrinsics.checkNotNullParameter(authRequestContext, "");
                        DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
                        if (authRequestContext.isEmpty()) {
                            DatabaseTableConfigUtil.setItems(CollectionsKt.emptyList());
                            return;
                        } else {
                            DatabaseTableConfigUtil.setItems(CollectionsKt.listOf(1));
                            return;
                        }
                    }
                    FriendsFeedsFragment.DatabaseTableConfigUtil(FriendsFeedsFragment.this).setItems(CollectionsKt.emptyList());
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void PlaceComponentResult() {
                    FriendsFeedsFragment.DatabaseTableConfigUtil(FriendsFeedsFragment.this).setItems(CollectionsKt.emptyList());
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void MyBillsEntityDataFactory() {
                    List list;
                    PreviewActivityData previewActivityData;
                    boolean z;
                    List list2;
                    int i;
                    List list3;
                    list = FriendsFeedsFragment.this.getAuthRequestContext;
                    List list4 = list;
                    FriendsFeedsFragment friendsFeedsFragment = FriendsFeedsFragment.this;
                    boolean z2 = false;
                    if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                        Iterator it = list4.iterator();
                        while (it.hasNext()) {
                            String shareFeedRequestId = ((PreviewActivityData) it.next()).getShareFeedRequestId();
                            previewActivityData = friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            if (Intrinsics.areEqual(shareFeedRequestId, previewActivityData != null ? previewActivityData.getShareFeedRequestId() : null)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        list2 = FriendsFeedsFragment.this.getAuthRequestContext;
                        i = FriendsFeedsFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        ((PreviewActivityData) list2.get(i)).setSkip(true);
                        list3 = FriendsFeedsFragment.this.getAuthRequestContext;
                        List list5 = list3;
                        if (!(list5 instanceof Collection) || !list5.isEmpty()) {
                            Iterator it2 = list5.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ((!((PreviewActivityData) it2.next()).isSkip()) != false) {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        if (z2) {
                            FriendsFeedsFragment.I(FriendsFeedsFragment.this);
                        } else {
                            FriendsFeedsFragment.DatabaseTableConfigUtil(FriendsFeedsFragment.this).setItems(CollectionsKt.emptyList());
                        }
                    }
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                    String shownErrorMessage;
                    shownErrorMessage = FriendsFeedsFragment.this.getShownErrorMessage();
                    return shownErrorMessage == null ? "" : shownErrorMessage;
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final String getAuthRequestContext() {
                    return FriendsFeedsFragment.this.FragmentBottomSheetPaymentSettingBinding;
                }

                @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, String p2, String p3) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                    Intrinsics.checkNotNullParameter(p2, "");
                    Intrinsics.checkNotNullParameter(p3, "");
                    Context context = FriendsFeedsFragment.this.getContext();
                    if (context != null) {
                        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
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
                }
            });
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getBaseActivity();
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = FeedsSourceType.FRIENDSHIP_FRIENDS_FEED;
            DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b);
            Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
            RelationshipBottomSheetModule relationshipBottomSheetModule = new RelationshipBottomSheetModule(new RelationshipBottomSheetContract.View() { // from class: id.dana.social.fragment.FriendsFeedsFragment$inject$2
                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ String BuiltInFictitiousFunctionClassFactory() {
                    return RelationshipBottomSheetContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SettingModel settingModel) {
                    RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory(settingModel);
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory() {
                    RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(FeedConfig feedConfig) {
                    Intrinsics.checkNotNullParameter(feedConfig, "");
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
                    RelationshipBottomSheetContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void PlaceComponentResult() {
                    RelationshipBottomSheetContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void PlaceComponentResult(List list) {
                    RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void getAuthRequestContext(ModifyRelationOperationType modifyRelationOperationType) {
                    Intrinsics.checkNotNullParameter(modifyRelationOperationType, "");
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void getAuthRequestContext(List list) {
                    RelationshipBottomSheetContract.View.CC.getAuthRequestContext(list);
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
            });
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
            ScanQrModule scanQrModule = new ScanQrModule(authRequestContext, b);
            Intrinsics.checkNotNullExpressionValue(scanQrModule, "");
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getBaseActivity();
            RestoreUrlModule restoreUrlModule = new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b);
            Intrinsics.checkNotNullExpressionValue(restoreUrlModule, "");
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            FeatureModule featureModule = new FeatureModule(MyBillsEntityDataFactory, b);
            Intrinsics.checkNotNullExpressionValue(featureModule, "");
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            OauthModule oauthModule = new OauthModule(BuiltInFictitiousFunctionClassFactory, b);
            Intrinsics.checkNotNullExpressionValue(oauthModule, "");
            socialCommonComponent.PlaceComponentResult(friendsFeedsModule, deepLinkModule, relationshipBottomSheetModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.social.fragment.FriendsFeedsFragment$inject$3
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
            }), new DanaContactModule(new DanaContactContract.View() { // from class: id.dana.social.fragment.FriendsFeedsFragment$inject$4
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
            })).getAuthRequestContext(this);
        }
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        FriendFeedsContract.Presenter presenter = this.presenter;
        FriendFeedsContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        registerPresenter(abstractPresenterArr);
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) getBinding();
        FeedOnboardingView feedOnboardingView = fragmentFriendFeedBinding != null ? fragmentFriendFeedBinding.getErrorConfigVersion : null;
        if (feedOnboardingView != null) {
            feedOnboardingView.setListener(new FeedOnboardingListener() { // from class: id.dana.social.fragment.FriendsFeedsFragment$setupFeedOnboardingView$1
                @Override // id.dana.social.common.FeedOnboardingListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    boolean supportButtonTintMode;
                    FriendsFeedsFragment.MyBillsEntityDataFactory(FriendsFeedsFragment.this, true);
                    FriendFeedsContract.Presenter presenter3 = FriendsFeedsFragment.this.presenter;
                    if (presenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter3 = null;
                    }
                    presenter3.moveToNextValue();
                    supportButtonTintMode = FriendsFeedsFragment.this.getSupportButtonTintMode();
                    if (supportButtonTintMode) {
                        FriendsFeedsFragment.D(FriendsFeedsFragment.this);
                        return;
                    }
                    FriendsFeedsFragment friendsFeedsFragment = FriendsFeedsFragment.this;
                    FriendsFeedsFragment.KClassImpl$Data$declaredNonStaticMembers$2(friendsFeedsFragment, FriendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(friendsFeedsFragment));
                }
            });
        }
        FriendFeedsContract.Presenter presenter3 = this.presenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        presenter3.PlaceComponentResult(false);
        FriendFeedsContract.Presenter presenter4 = this.presenter;
        if (presenter4 != null) {
            presenter2 = presenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter2.BuiltInFictitiousFunctionClassFactory(true);
        whenAvailable();
        ((BaseFeedTimelineFragment) this).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        TopFriendsAdapter topFriendsAdapter = (TopFriendsAdapter) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
        Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$disableRefreshWhenTopFriendsHorizontalScrollActive$1
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
                ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
                FragmentFriendFeedBinding lookAheadTest = FriendsFeedsFragment.lookAheadTest(FriendsFeedsFragment.this);
                PtrClassicFrameLayout ptrClassicFrameLayout = (lookAheadTest == null || (viewSocialFriendsFeedBinding = lookAheadTest.lookAheadTest) == null) ? null : viewSocialFriendsFeedBinding.BuiltInFictitiousFunctionClassFactory;
                if (ptrClassicFrameLayout != null) {
                    ptrClassicFrameLayout.setEnabled(z);
                }
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        topFriendsAdapter.BuiltInFictitiousFunctionClassFactory = function1;
        FragmentFriendFeedBinding fragmentFriendFeedBinding2 = (FragmentFriendFeedBinding) getBinding();
        if (fragmentFriendFeedBinding2 == null || (danaButtonPrimaryView = fragmentFriendFeedBinding2.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.fragment.FriendsFeedsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(FriendsFeedsFragment.this);
            }
        });
    }

    public final void C() {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FeedOnboardingView feedOnboardingView;
        BuiltInFictitiousFunctionClassFactory(false);
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) getBinding();
        ConstraintLayout constraintLayout = null;
        FeedOnboardingView feedOnboardingView2 = fragmentFriendFeedBinding != null ? fragmentFriendFeedBinding.getErrorConfigVersion : null;
        if (feedOnboardingView2 != null) {
            feedOnboardingView2.setVisibility(0);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding2 = (FragmentFriendFeedBinding) getBinding();
        if (fragmentFriendFeedBinding2 != null && (feedOnboardingView = fragmentFriendFeedBinding2.getErrorConfigVersion) != null) {
            feedOnboardingView.renderButtonDisabled();
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding3 = (FragmentFriendFeedBinding) getBinding();
        if (fragmentFriendFeedBinding3 != null && (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding3.lookAheadTest) != null) {
            constraintLayout = viewSocialFriendsFeedBinding.PlaceComponentResult;
        }
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        SubSequence();
        readMicros();
    }

    public final void B() {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FeedOnboardingView feedOnboardingView;
        PlaceComponentResult("Onboarding");
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) getBinding();
        ConstraintLayout constraintLayout = null;
        FeedOnboardingView feedOnboardingView2 = fragmentFriendFeedBinding != null ? fragmentFriendFeedBinding.getErrorConfigVersion : null;
        if (feedOnboardingView2 != null) {
            feedOnboardingView2.setVisibility(0);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding2 = (FragmentFriendFeedBinding) getBinding();
        if (fragmentFriendFeedBinding2 != null && (feedOnboardingView = fragmentFriendFeedBinding2.getErrorConfigVersion) != null) {
            feedOnboardingView.renderButtonEnabled();
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding3 = (FragmentFriendFeedBinding) getBinding();
        if (fragmentFriendFeedBinding3 != null && (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding3.lookAheadTest) != null) {
            constraintLayout = viewSocialFriendsFeedBinding.PlaceComponentResult;
        }
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        SubSequence();
        readMicros();
    }

    private final void A() {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) getBinding();
        ConstraintLayout constraintLayout = (fragmentFriendFeedBinding == null || (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding.lookAheadTest) == null) ? null : viewSocialFriendsFeedBinding.PlaceComponentResult;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding2 = (FragmentFriendFeedBinding) getBinding();
        FeedOnboardingView feedOnboardingView = fragmentFriendFeedBinding2 != null ? fragmentFriendFeedBinding2.getErrorConfigVersion : null;
        if (feedOnboardingView != null) {
            feedOnboardingView.setVisibility(8);
        }
        SubSequence();
        readMicros();
    }

    private final void PlaceComponentResult(String p0) {
        TimerEvent timerEvent = new TimerEvent(TimerEventKey.FEED_OPEN, MapsKt.hashMapOf(new Pair("Feed State", p0), new Pair("Source", this.FragmentBottomSheetPaymentSettingBinding)), this.GetContactSyncConfig);
        Intrinsics.checkNotNullParameter(timerEvent, "");
        EventBus.getDefault().post(timerEvent);
        this.GetContactSyncConfig = false;
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        BuiltInFictitiousFunctionClassFactory(true);
        KClassImpl$Data$declaredNonStaticMembers$2(new FeedViewHolderModel(4, null, null, null, null, false, 60, null));
        if (((BaseFeedTimelineFragment) this).lookAheadTest.getItems().isEmpty()) {
            NetworkUserEntityData$$ExternalSyntheticLambda2().add(new FeedViewHolderModel(4, null, null, null, null, false, 62, null));
        }
        PlaceComponentResult("Feed Empty");
        PrepareContext();
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof HomeTabActivity) && ((HomeTabActivity) activity).getShowShareFeedBottomSheet()) {
            FriendFeedsContract.Presenter presenter = this.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private final void BottomSheetCardBindingView$watcherCardNumberView$1() {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) getBinding();
        RecyclerView recyclerView = (fragmentFriendFeedBinding == null || (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding.lookAheadTest) == null) ? null : viewSocialFriendsFeedBinding.getAuthRequestContext;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final void isLayoutRequested() {
        if (!MyBillsEntityDataFactory() || getKClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda4();
        if (this.presenter != null && getSupportButtonTintMode() && getCallingPid()) {
            getAuthRequestContext();
            FriendFeedsContract.Presenter presenter = this.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        PlaceComponentResult();
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final void newProxyInstance() {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FeedsMeHeaderView feedsMeHeaderView;
        if (getSupportButtonTintMode() && getCallingPid()) {
            FriendFeedsContract.Presenter presenter = this.presenter;
            FriendFeedsContract.Presenter presenter2 = null;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.moveToNextValue();
            FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) getBinding();
            if (fragmentFriendFeedBinding != null && (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding.lookAheadTest) != null && (feedsMeHeaderView = viewSocialFriendsFeedBinding.lookAheadTest) != null) {
                feedsMeHeaderView.setProfileName("%fetching%");
                feedsMeHeaderView.setProfileAvatar("");
                feedsMeHeaderView.setPrivacy(false);
                feedsMeHeaderView.showKycVerified(false);
            }
            ((TopFriendsAdapter) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).setItems(CollectionsKt.emptyList());
            ((UsernameBannerAdapter) this.readMicros.getValue()).setItems(CollectionsKt.emptyList());
            NetworkUserEntityData$$ExternalSyntheticLambda8();
            KClassImpl$Data$declaredNonStaticMembers$2();
            Context context = getContext();
            if (context != null) {
                SocialSyncManagerKt.BuiltInFictitiousFunctionClassFactory(context);
            }
            FriendFeedsContract.Presenter presenter3 = this.presenter;
            if (presenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter3 = null;
            }
            presenter3.initRecordTimeStamp();
            FriendFeedsContract.Presenter presenter4 = this.presenter;
            if (presenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter4 = null;
            }
            presenter4.MyBillsEntityDataFactory(false, false);
            FriendFeedsContract.Presenter presenter5 = this.presenter;
            if (presenter5 != null) {
                presenter2 = presenter5;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter2.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final SocialFeedClickListener lookAheadTest() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker
    public final void PlaceComponentResult(TimerEvent p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = p0.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory("Ready in Milliseconds", p1).BuiltInFictitiousFunctionClassFactory(p0.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.INITIAL_LOAD, p0.getBuiltInFictitiousFunctionClassFactory());
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.moveToNextValue && getSupportButtonTintMode()) {
            FriendFeedsContract.Presenter presenter = null;
            if (getCallingPid()) {
                whenAvailable();
                FriendFeedsContract.Presenter presenter2 = this.presenter;
                if (presenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter2 = null;
                }
                presenter2.MyBillsEntityDataFactory();
                FriendFeedsContract.Presenter presenter3 = this.presenter;
                if (presenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter3 = null;
                }
                presenter3.scheduleImpl();
            } else {
                BuiltInFictitiousFunctionClassFactory(false);
                FriendFeedsContract.Presenter presenter4 = this.presenter;
                if (presenter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter4 = null;
                }
                presenter4.NetworkUserEntityData$$ExternalSyntheticLambda8();
                if (!this.GetContactSyncConfig) {
                    FriendFeedsContract.Presenter presenter5 = this.presenter;
                    if (presenter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter5 = null;
                    }
                    if (presenter5.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
                        FriendFeedsContract.Presenter presenter6 = this.presenter;
                        if (presenter6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            presenter6 = null;
                        }
                        int i = WhenMappings.getAuthRequestContext[presenter6.getWhenAvailable().getStatus().ordinal()];
                        if (i == 1) {
                            PlaceComponentResult("Onboarding");
                        } else if (i == 2) {
                            PlaceComponentResult("Init Feed Error");
                        }
                    }
                }
            }
            if (this.getErrorConfigVersion) {
                FriendFeedsContract.Presenter presenter7 = this.presenter;
                if (presenter7 != null) {
                    presenter = presenter7;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                presenter.PrepareContext();
            }
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void onSelected() {
        super.onSelected();
        if (this.presenter != null && getSupportButtonTintMode() && this.getErrorConfigVersion) {
            FriendFeedsContract.Presenter presenter = this.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.PrepareContext();
        }
    }

    private final void whenAvailable() {
        FriendFeedsContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.initRecordTimeStamp();
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        PreviewActivityData previewActivityData = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (previewActivityData != null) {
            ShareActivityBottomSheetDialog shareActivityBottomSheetDialog = (ShareActivityBottomSheetDialog) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
            String content = previewActivityData.getContent();
            HashMap<String, String> extendInfo = previewActivityData.getExtendInfo();
            if (extendInfo == null) {
                extendInfo = new HashMap<>();
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            shareActivityBottomSheetDialog.MyBillsEntityDataFactory = new FeedRegexData("", content, extendInfo, null, requireContext, previewActivityData.getContentType(), 8, null);
            ShareActivityBottomSheetDialog shareActivityBottomSheetDialog2 = (ShareActivityBottomSheetDialog) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
            String NetworkUserEntityData$$ExternalSyntheticLambda6 = NetworkUserEntityData$$ExternalSyntheticLambda6();
            if (NetworkUserEntityData$$ExternalSyntheticLambda6 == null) {
                MyFeedHeaderModel myFeedHeaderModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                NetworkUserEntityData$$ExternalSyntheticLambda6 = myFeedHeaderModel != null ? myFeedHeaderModel.MyBillsEntityDataFactory : null;
            }
            shareActivityBottomSheetDialog2.getAuthRequestContext = NetworkUserEntityData$$ExternalSyntheticLambda6;
            ShareActivityBottomSheetDialog shareActivityBottomSheetDialog3 = (ShareActivityBottomSheetDialog) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
            FragmentManager supportFragmentManager = getBaseActivity().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            AndroidComponentUtilsKt.MyBillsEntityDataFactory(shareActivityBottomSheetDialog3, supportFragmentManager, "shareFeedActivity");
        }
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda6() {
        HashMap<String, String> extendInfo;
        HashMap<String, String> actorMap;
        PreviewActivityData previewActivityData = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (previewActivityData == null || (extendInfo = previewActivityData.getExtendInfo()) == null || (actorMap = ExtendInfoUtilKt.getActorMap(extendInfo)) == null) {
            return null;
        }
        return actorMap.get(ExtendInfoUtilKt.PROFILE_AVATAR_KEY);
    }

    private final void SubSequence() {
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) getBinding();
        ConstraintLayout constraintLayout = fragmentFriendFeedBinding != null ? fragmentFriendFeedBinding.BuiltInFictitiousFunctionClassFactory : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    private final void readMicros() {
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) getBinding();
        ConstraintLayout constraintLayout = fragmentFriendFeedBinding != null ? fragmentFriendFeedBinding.PlaceComponentResult : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeedsMeHeaderView feedsMeHeaderView, MyFeedHeaderModel myFeedHeaderModel) {
        Intrinsics.checkNotNullParameter(feedsMeHeaderView, "");
        Intrinsics.checkNotNullParameter(myFeedHeaderModel, "");
        Context context = feedsMeHeaderView.getContext();
        if (context != null) {
            SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
            SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, new RelationshipItemModel(myFeedHeaderModel.PlaceComponentResult, "", myFeedHeaderModel.getAuthRequestContext, "SELF", myFeedHeaderModel.MyBillsEntityDataFactory, myFeedHeaderModel.NetworkUserEntityData$$ExternalSyntheticLambda0, false, 0, null, false, 0, false, false, 8128, null));
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FriendsFeedsFragment friendsFeedsFragment) {
        Intrinsics.checkNotNullParameter(friendsFeedsFragment, "");
        FriendFeedsContract.Presenter presenter = friendsFeedsFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult(true);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FriendsFeedsFragment friendsFeedsFragment) {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(friendsFeedsFragment, "");
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        FeedActivityBannerViewHolder feedActivityBannerViewHolder = (FeedActivityBannerViewHolder) ((fragmentFriendFeedBinding == null || (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding.lookAheadTest) == null || (recyclerView = viewSocialFriendsFeedBinding.getAuthRequestContext) == null) ? null : recyclerView.findViewHolderForAdapterPosition(1));
        if (feedActivityBannerViewHolder != null) {
            feedActivityBannerViewHolder.MyBillsEntityDataFactory();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(FriendsFeedsFragment friendsFeedsFragment) {
        Intrinsics.checkNotNullParameter(friendsFeedsFragment, "");
        FriendFeedsContract.Presenter presenter = friendsFeedsFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.getAuthRequestContext();
    }

    public static /* synthetic */ void PlaceComponentResult(FriendsFeedsFragment friendsFeedsFragment) {
        Intrinsics.checkNotNullParameter(friendsFeedsFragment, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = friendsFeedsFragment.newProxyInstance;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
    }

    public static final /* synthetic */ void PlaceComponentResult(FriendsFeedsFragment friendsFeedsFragment, MyFeedHeaderModel myFeedHeaderModel) {
        FragmentFriendFeedBinding fragmentFriendFeedBinding;
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FeedsMeHeaderView feedsMeHeaderView;
        if (myFeedHeaderModel == null || (fragmentFriendFeedBinding = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding()) == null || (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding.lookAheadTest) == null || (feedsMeHeaderView = viewSocialFriendsFeedBinding.lookAheadTest) == null) {
            return;
        }
        feedsMeHeaderView.setProfileName(myFeedHeaderModel.getAuthRequestContext);
        feedsMeHeaderView.setProfileAvatar(myFeedHeaderModel.MyBillsEntityDataFactory);
        feedsMeHeaderView.setPrivacy(myFeedHeaderModel.getKClassImpl$Data$declaredNonStaticMembers$2());
        feedsMeHeaderView.showKycVerified(myFeedHeaderModel.getBuiltInFictitiousFunctionClassFactory());
        feedsMeHeaderView.setUsername(myFeedHeaderModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FriendsFeedsFragment friendsFeedsFragment) {
        if (friendsFeedsFragment.scheduleImpl && friendsFeedsFragment.isLayoutRequested) {
            friendsFeedsFragment.isLayoutRequested = false;
            ((FeedActivityBannerViewAdapter) friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory.getValue()).setItems(CollectionsKt.listOf(0));
            FriendFeedsContract.Presenter presenter = friendsFeedsFragment.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.getErrorConfigVersion();
        }
    }

    public static final /* synthetic */ ArrayList MyBillsEntityDataFactory(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((FeedModel) it.next()).NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        return new ArrayList(arrayList);
    }

    public static final /* synthetic */ ContactPermissionBottomSheetDialogFragment NetworkUserEntityData$$ExternalSyntheticLambda0(FriendsFeedsFragment friendsFeedsFragment) {
        return (ContactPermissionBottomSheetDialogFragment) friendsFeedsFragment.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ FeedActivityBannerViewAdapter DatabaseTableConfigUtil(FriendsFeedsFragment friendsFeedsFragment) {
        return (FeedActivityBannerViewAdapter) friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ ShareActivityBottomSheetDialog newProxyInstance(FriendsFeedsFragment friendsFeedsFragment) {
        return (ShareActivityBottomSheetDialog) friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
    }

    public static final /* synthetic */ TopFriendsAdapter NetworkUserEntityData$$ExternalSyntheticLambda4(FriendsFeedsFragment friendsFeedsFragment) {
        return (TopFriendsAdapter) friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
    }

    public static final /* synthetic */ UsernameBannerAdapter NetworkUserEntityData$$ExternalSyntheticLambda5(FriendsFeedsFragment friendsFeedsFragment) {
        return (UsernameBannerAdapter) friendsFeedsFragment.readMicros.getValue();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FriendsFeedsFragment friendsFeedsFragment, FeedViewHolderModel feedViewHolderModel) {
        FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
        if (feedModel == null || feedModel.NetworkUserEntityData$$ExternalSyntheticLambda6 == FeedActivityState.ERROR || feedModel.NetworkUserEntityData$$ExternalSyntheticLambda6 == FeedActivityState.INIT) {
            return;
        }
        if (!friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(feedModel)) {
            RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$2 = FeedViewModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(feedModel);
            Context context = friendsFeedsFragment.getContext();
            if (context != null) {
                SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
                SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            return;
        }
        RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$22 = FeedViewModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(feedModel);
        Intrinsics.checkNotNullParameter("SELF", "");
        KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion = "SELF";
        Context context2 = friendsFeedsFragment.getContext();
        if (context2 != null) {
            SocialProfileActivity.Companion companion2 = SocialProfileActivity.INSTANCE;
            SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context2, KClassImpl$Data$declaredNonStaticMembers$22);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FriendsFeedsFragment friendsFeedsFragment, FeedViewHolderModel feedViewHolderModel) {
        Context context;
        FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
        if (feedModel == null || feedModel.NetworkUserEntityData$$ExternalSyntheticLambda6 != FeedActivityState.SUCCESS || (context = friendsFeedsFragment.getContext()) == null) {
            return;
        }
        SocialActivityDetail.Companion companion = SocialActivityDetail.INSTANCE;
        SocialActivityDetail.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, feedModel, friendsFeedsFragment.initRecordTimeStamp);
    }

    public static final /* synthetic */ void getCallingPid(FriendsFeedsFragment friendsFeedsFragment) {
        DanaContactContract.Presenter presenter = friendsFeedsFragment.danaContactpresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FriendsFeedsFragment friendsFeedsFragment, final MyFeedHeaderModel myFeedHeaderModel) {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        final FeedsMeHeaderView feedsMeHeaderView;
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        if (fragmentFriendFeedBinding == null || (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding.lookAheadTest) == null || (feedsMeHeaderView = viewSocialFriendsFeedBinding.lookAheadTest) == null) {
            return;
        }
        feedsMeHeaderView.setOnProfileNameSectionClicked(new View.OnClickListener() { // from class: id.dana.social.fragment.FriendsFeedsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendsFeedsFragment.KClassImpl$Data$declaredNonStaticMembers$2(FeedsMeHeaderView.this, myFeedHeaderModel);
            }
        });
        feedsMeHeaderView.setOnFeedNotificationClicked(new Function0<Unit>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$myFeedsHeaderOnClick$1$2
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
                boolean z;
                FriendshipAnalyticTracker friendshipAnalyticTracker = FriendsFeedsFragment.this.friendshipAnalyticTracker;
                if (friendshipAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendshipAnalyticTracker = null;
                }
                friendshipAnalyticTracker.MyBillsEntityDataFactory();
                Context context = feedsMeHeaderView.getContext();
                if (context != null) {
                    FriendsFeedsFragment friendsFeedsFragment2 = FriendsFeedsFragment.this;
                    FeedNotificationActivity.Companion companion = FeedNotificationActivity.INSTANCE;
                    z = friendsFeedsFragment2.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    FeedNotificationActivity.Companion.PlaceComponentResult(context, z, false, false);
                }
            }
        });
    }

    public static final /* synthetic */ void getSupportButtonTintMode(FriendsFeedsFragment friendsFeedsFragment) {
        Context context = friendsFeedsFragment.getContext();
        if (context != null) {
            final LiveData<List<WorkInfo>> authRequestContext = SocialSyncManagerKt.getAuthRequestContext(context);
            FriendsFeedsFragment friendsFeedsFragment2 = friendsFeedsFragment;
            FriendFeedsContract.Presenter presenter = friendsFeedsFragment.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            authRequestContext.PlaceComponentResult(friendsFeedsFragment2, presenter.PlaceComponentResult(new Function1<Observer<List<? extends WorkInfo>>, Unit>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$observerSynchingState$1$1$1
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
    }

    public static final /* synthetic */ void SubSequence(FriendsFeedsFragment friendsFeedsFragment) {
        BaseActivity baseActivity = friendsFeedsFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        PermissionHelper.MyBillsEntityDataFactory(baseActivity);
    }

    public static final /* synthetic */ void A(FriendsFeedsFragment friendsFeedsFragment) {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FeedOnboardingView feedOnboardingView;
        friendsFeedsFragment.PlaceComponentResult("Init Feed Error");
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        ConstraintLayout constraintLayout = null;
        FeedOnboardingView feedOnboardingView2 = fragmentFriendFeedBinding != null ? fragmentFriendFeedBinding.getErrorConfigVersion : null;
        if (feedOnboardingView2 != null) {
            feedOnboardingView2.setVisibility(0);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding2 = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        if (fragmentFriendFeedBinding2 != null && (feedOnboardingView = fragmentFriendFeedBinding2.getErrorConfigVersion) != null) {
            feedOnboardingView.renderButtonError();
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding3 = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        if (fragmentFriendFeedBinding3 != null && (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding3.lookAheadTest) != null) {
            constraintLayout = viewSocialFriendsFeedBinding.PlaceComponentResult;
        }
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        friendsFeedsFragment.SubSequence();
        friendsFeedsFragment.readMicros();
    }

    public static final /* synthetic */ void B(FriendsFeedsFragment friendsFeedsFragment) {
        friendsFeedsFragment.moveToNextValue = true;
        friendsFeedsFragment.SubSequence();
        if (!friendsFeedsFragment.getSupportButtonTintMode()) {
            friendsFeedsFragment.B();
            return;
        }
        FriendFeedsContract.Presenter presenter = friendsFeedsFragment.presenter;
        FriendFeedsContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.moveToNextValue();
        friendsFeedsFragment.A();
        friendsFeedsFragment.KClassImpl$Data$declaredNonStaticMembers$2();
        if (!friendsFeedsFragment.getCallingPid()) {
            friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(false);
            FriendFeedsContract.Presenter presenter3 = friendsFeedsFragment.presenter;
            if (presenter3 != null) {
                presenter2 = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter2.NetworkUserEntityData$$ExternalSyntheticLambda8();
            return;
        }
        FriendFeedsContract.Presenter presenter4 = friendsFeedsFragment.presenter;
        if (presenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter4 = null;
        }
        presenter4.MyBillsEntityDataFactory(false, false);
        FriendFeedsContract.Presenter presenter5 = friendsFeedsFragment.presenter;
        if (presenter5 != null) {
            presenter2 = presenter5;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter2.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void VerifyPinStateManager$executeRiskChallenge$2$1(FriendsFeedsFragment friendsFeedsFragment) {
        friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(true);
        FriendFeedsContract.Presenter presenter = friendsFeedsFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.NetworkUserEntityData$$ExternalSyntheticLambda7();
        friendsFeedsFragment.A();
    }

    public static final /* synthetic */ void BottomSheetCardBindingView$watcherCardNumberView$1(FriendsFeedsFragment friendsFeedsFragment) {
        FeedOnboardingView feedOnboardingView;
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        if (fragmentFriendFeedBinding == null || (feedOnboardingView = fragmentFriendFeedBinding.getErrorConfigVersion) == null) {
            return;
        }
        feedOnboardingView.renderButtonEnabled();
    }

    public static final /* synthetic */ void D(FriendsFeedsFragment friendsFeedsFragment) {
        FriendFeedsContract.Presenter presenter = friendsFeedsFragment.presenter;
        FriendFeedsContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult();
        friendsFeedsFragment.C();
        FriendFeedsContract.Presenter presenter3 = friendsFeedsFragment.presenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        presenter3.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.social.fragment.FriendsFeedsFragment$initFeed$1$1
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
                Context context = FriendsFeedsFragment.this.getContext();
                if (context != null) {
                    SocialSyncManagerKt.BuiltInFictitiousFunctionClassFactory(context);
                }
            }
        });
        if (!presenter3.newProxyInstance()) {
            friendsFeedsFragment.DatabaseTableConfigUtil = false;
            FriendFeedsContract.Presenter presenter4 = friendsFeedsFragment.presenter;
            if (presenter4 != null) {
                presenter2 = presenter4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter2.NetworkUserEntityData$$ExternalSyntheticLambda8();
            if (!friendsFeedsFragment.DatabaseTableConfigUtil) {
                presenter2.DatabaseTableConfigUtil();
            }
            friendsFeedsFragment.DatabaseTableConfigUtil = true;
        }
        friendsFeedsFragment.getSupportButtonTintMode.check();
    }

    public static final /* synthetic */ void getAuthRequestContext(FriendsFeedsFragment friendsFeedsFragment, boolean z) {
        friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(true);
        friendsFeedsFragment.PlaceComponentResult("Fetch Feed Error");
        LoadingLottieAnimationView loadingLottieAnimationView = friendsFeedsFragment.getAuthRequestContext;
        if (loadingLottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loadingLottieAnimationView = null;
        }
        loadingLottieAnimationView.cancelAnimation();
        friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda7();
        if (z) {
            return;
        }
        friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FriendsFeedsFragment friendsFeedsFragment, List list) {
        friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(true);
        LoadingLottieAnimationView loadingLottieAnimationView = friendsFeedsFragment.getAuthRequestContext;
        FriendFeedsContract.Presenter presenter = null;
        if (loadingLottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loadingLottieAnimationView = null;
        }
        loadingLottieAnimationView.cancelAnimation();
        friendsFeedsFragment.PlaceComponentResult("Feed Success");
        friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda7();
        friendsFeedsFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
        friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2().addAll(list);
        ((BaseFeedTimelineFragment) friendsFeedsFragment).lookAheadTest.appendItems(list);
        FragmentActivity activity = friendsFeedsFragment.getActivity();
        if (activity != null && (activity instanceof HomeTabActivity) && ((HomeTabActivity) activity).getShowShareFeedBottomSheet()) {
            FriendFeedsContract.Presenter presenter2 = friendsFeedsFragment.presenter;
            if (presenter2 != null) {
                presenter = presenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static final /* synthetic */ void getOnBoardingScenario(FriendsFeedsFragment friendsFeedsFragment) {
        friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(true);
        friendsFeedsFragment.FragmentBottomSheetPaymentSettingBinding();
        LoadingLottieAnimationView loadingLottieAnimationView = friendsFeedsFragment.getAuthRequestContext;
        if (loadingLottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loadingLottieAnimationView = null;
        }
        loadingLottieAnimationView.cancelAnimation();
    }

    public static final /* synthetic */ void getAuthRequestContext(FriendsFeedsFragment friendsFeedsFragment, List list) {
        friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(true);
        LoadingLottieAnimationView loadingLottieAnimationView = friendsFeedsFragment.getAuthRequestContext;
        if (loadingLottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loadingLottieAnimationView = null;
        }
        loadingLottieAnimationView.cancelAnimation();
        friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda7();
        friendsFeedsFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
        TopFriendsAdapter topFriendsAdapter = (TopFriendsAdapter) friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
        FeedModel.Companion companion = FeedModel.INSTANCE;
        topFriendsAdapter.setItems(CollectionsKt.listOf(FeedModel.Companion.BuiltInFictitiousFunctionClassFactory(list)));
        friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2().clear();
        friendsFeedsFragment.PrepareContext();
    }

    public static final /* synthetic */ void VerifyPinStateManager$executeRiskChallenge$2$2(FriendsFeedsFragment friendsFeedsFragment) {
        if (friendsFeedsFragment.lookAheadTest) {
            return;
        }
        ((UsernameBannerAdapter) friendsFeedsFragment.readMicros.getValue()).setItems(CollectionsKt.listOf(1));
        ((FeedActivityBannerViewAdapter) friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory.getValue()).setItems(CollectionsKt.emptyList());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(FriendsFeedsFragment friendsFeedsFragment, boolean z) {
        FragmentActivity activity = friendsFeedsFragment.getActivity();
        if (activity == null || !(activity instanceof HomeTabActivity)) {
            return;
        }
        ((HomeTabActivity) activity).setShowShareFeedBottomSheet(z);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final FriendsFeedsFragment friendsFeedsFragment, final ContactPermissionBottomSheetDialogFragment contactPermissionBottomSheetDialogFragment) {
        if (contactPermissionBottomSheetDialogFragment != null) {
            contactPermissionBottomSheetDialogFragment.show(friendsFeedsFragment.getBaseActivity().getSupportFragmentManager(), "");
        }
        if (contactPermissionBottomSheetDialogFragment != null) {
            contactPermissionBottomSheetDialogFragment.MyBillsEntityDataFactory = new ContactPermissionBottomSheetDialogFragment.BottomSheetListener() { // from class: id.dana.social.fragment.FriendsFeedsFragment$showContactPermissionBottomSheet$1$1
                @Override // id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.BottomSheetListener
                public final void MyBillsEntityDataFactory() {
                    FragmentPermissionRequest fragmentPermissionRequest;
                    ContactPermissionBottomSheetDialogFragment.this.dismiss();
                    fragmentPermissionRequest = friendsFeedsFragment.MyBillsEntityDataFactory;
                    fragmentPermissionRequest.check();
                }

                @Override // id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.BottomSheetListener
                public final void PlaceComponentResult() {
                    ContactPermissionBottomSheetDialogFragment.this.dismiss();
                    FriendsFeedsFragment.BottomSheetCardBindingView$watcherCardNumberView$1(friendsFeedsFragment);
                }

                @Override // id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.BottomSheetListener
                public final void getAuthRequestContext() {
                    FriendsFeedsFragment.BottomSheetCardBindingView$watcherCardNumberView$1(friendsFeedsFragment);
                }
            };
        }
    }

    public static final /* synthetic */ void H(FriendsFeedsFragment friendsFeedsFragment) {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(friendsFeedsFragment.getBaseActivity());
        builder.FragmentBottomSheetPaymentSettingBinding = friendsFeedsFragment.getString(R.string.share_feed_consent_dialog_title);
        builder.getErrorConfigVersion = friendsFeedsFragment.getString(R.string.share_feed_consent_dialog_message);
        builder.PlaceComponentResult(false);
        builder.MyBillsEntityDataFactory(false);
        String string = friendsFeedsFragment.getString(R.string.share_feed_consent_dialog_positive_button);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.social.fragment.FriendsFeedsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendsFeedsFragment.getAuthRequestContext(FriendsFeedsFragment.this);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = friendsFeedsFragment.getString(R.string.cancel_action);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.social.fragment.FriendsFeedsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendsFeedsFragment.PlaceComponentResult(FriendsFeedsFragment.this);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        builder.DatabaseTableConfigUtil = onClickListener2;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        friendsFeedsFragment.newProxyInstance = KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void AppCompatEmojiTextHelper(FriendsFeedsFragment friendsFeedsFragment) {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        ConstraintLayout constraintLayout = fragmentFriendFeedBinding != null ? fragmentFriendFeedBinding.BuiltInFictitiousFunctionClassFactory : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding2 = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        ConstraintLayout constraintLayout2 = (fragmentFriendFeedBinding2 == null || (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding2.lookAheadTest) == null) ? null : viewSocialFriendsFeedBinding.PlaceComponentResult;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding3 = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        FeedOnboardingView feedOnboardingView = fragmentFriendFeedBinding3 != null ? fragmentFriendFeedBinding3.getErrorConfigVersion : null;
        if (feedOnboardingView != null) {
            feedOnboardingView.setVisibility(8);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding4 = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        ConstraintLayout constraintLayout3 = fragmentFriendFeedBinding4 != null ? fragmentFriendFeedBinding4.PlaceComponentResult : null;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(8);
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FriendsFeedsFragment friendsFeedsFragment, String str, String str2) {
        Object obj;
        FeedModel feedModel;
        FeedModel.Companion companion = FeedModel.INSTANCE;
        String str3 = friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
        MyFeedHeaderModel myFeedHeaderModel = friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        PreviewActivityData previewActivityData = friendsFeedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str4 = null;
        FeedViewHolderModel feedViewHolderModel = new FeedViewHolderModel(9, FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(str3, str, str2, myFeedHeaderModel, previewActivityData != null ? previewActivityData.getExtendInfo() : null, null, null, 96), null, null, null, true, 28, null);
        SocialFeedsAdapter socialFeedsAdapter = ((BaseFeedTimelineFragment) friendsFeedsFragment).lookAheadTest;
        String string = friendsFeedsFragment.getString(R.string.feed_section_today);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        Intrinsics.checkNotNullParameter(feedViewHolderModel, "");
        List<FeedViewHolderModel> items = socialFeedsAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((FeedViewHolderModel) obj).getErrorConfigVersion == 1) {
                break;
            }
        }
        FeedViewHolderModel feedViewHolderModel2 = (FeedViewHolderModel) obj;
        if (feedViewHolderModel2 != null && (feedModel = feedViewHolderModel2.MyBillsEntityDataFactory) != null) {
            str4 = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }
        if (Intrinsics.areEqual(str4, string)) {
            socialFeedsAdapter.getItems().add(1, feedViewHolderModel);
            socialFeedsAdapter.notifyItemInserted(1);
            return;
        }
        FeedModel.Companion companion2 = FeedModel.INSTANCE;
        socialFeedsAdapter.addItemsAt(0, CollectionsKt.listOf((Object[]) new FeedViewHolderModel[]{new FeedViewHolderModel(1, FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(string), null, null, null, true, 28, null), feedViewHolderModel}));
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(FriendsFeedsFragment friendsFeedsFragment, String str) {
        BaseActivity baseActivity = friendsFeedsFragment.getBaseActivity();
        if (baseActivity != null) {
            CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
            CustomToast.MyBillsEntityDataFactory(baseActivity, R.drawable.ic_check_24_green50_filled_circle, R.drawable.bg_rounded_border_green_50, str);
        }
    }

    public static final /* synthetic */ void F(FriendsFeedsFragment friendsFeedsFragment) {
        friendsFeedsFragment.PlaceComponentResult("Feed Sync");
        friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(false);
        ((BaseFeedTimelineFragment) friendsFeedsFragment).lookAheadTest.setItems(CollectionsKt.mutableListOf(new FeedViewHolderModel(12, null, null, null, null, false, 62, null)));
    }

    public static final /* synthetic */ void G(FriendsFeedsFragment friendsFeedsFragment) {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        FeedOnboardingView feedOnboardingView = fragmentFriendFeedBinding != null ? fragmentFriendFeedBinding.getErrorConfigVersion : null;
        if (feedOnboardingView != null) {
            feedOnboardingView.setVisibility(8);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding2 = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        ConstraintLayout constraintLayout = (fragmentFriendFeedBinding2 == null || (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding2.lookAheadTest) == null) ? null : viewSocialFriendsFeedBinding.PlaceComponentResult;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding3 = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        ConstraintLayout constraintLayout2 = fragmentFriendFeedBinding3 != null ? fragmentFriendFeedBinding3.PlaceComponentResult : null;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
        FragmentFriendFeedBinding fragmentFriendFeedBinding4 = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        ConstraintLayout constraintLayout3 = fragmentFriendFeedBinding4 != null ? fragmentFriendFeedBinding4.BuiltInFictitiousFunctionClassFactory : null;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(8);
        }
    }

    public static final /* synthetic */ void I(FriendsFeedsFragment friendsFeedsFragment) {
        ViewSocialFriendsFeedBinding viewSocialFriendsFeedBinding;
        RecyclerView recyclerView;
        FragmentFriendFeedBinding fragmentFriendFeedBinding = (FragmentFriendFeedBinding) friendsFeedsFragment.getBinding();
        if (fragmentFriendFeedBinding == null || (viewSocialFriendsFeedBinding = fragmentFriendFeedBinding.lookAheadTest) == null || (recyclerView = viewSocialFriendsFeedBinding.getAuthRequestContext) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: id.dana.social.fragment.FriendsFeedsFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FriendsFeedsFragment.MyBillsEntityDataFactory(FriendsFeedsFragment.this);
            }
        });
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(FeedModel p0) {
        HashMap<String, String> hashMap = p0.lookAheadTest;
        FriendFeedsContract.Presenter presenter = null;
        String userId = hashMap != null ? ExtendInfoUtilKt.getUserId(hashMap) : null;
        FriendFeedsContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return Intrinsics.areEqual(userId, presenter.getGetAuthRequestContext());
    }

    private final boolean getCallingPid() {
        FriendFeedsContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        return presenter.getWhenAvailable().getStatus() == InitStatus.FINISH;
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final /* synthetic */ RecyclerView.Adapter scheduleImpl() {
        super.scheduleImpl();
        return new ConcatAdapter((TopFriendsAdapter) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue(), (UsernameBannerAdapter) this.readMicros.getValue(), (FeedActivityBannerViewAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue(), ((BaseFeedTimelineFragment) this).lookAheadTest);
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final boolean initRecordTimeStamp() {
        FriendFeedsContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        return presenter.getLookAheadTest();
    }
}
