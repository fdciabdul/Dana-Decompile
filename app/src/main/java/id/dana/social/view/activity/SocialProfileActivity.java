package id.dana.social.view.activity;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customsnackbarcomponent.SnackbarPosition;
import id.dana.component.customsnackbarcomponent.SnackbarState;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.databinding.ActivitySocialDetailBinding;
import id.dana.di.modules.OauthModule;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.model.ThirdPartyService;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment;
import id.dana.social.ReciprocalBottomSheetDialog;
import id.dana.social.RelationshipBottomSheetDialog;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.adapter.SocialFeedsAdapter;
import id.dana.social.base.BaseSocialFeedsAdapter;
import id.dana.social.contract.SocialProfileContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.SocialProfileModule;
import id.dana.social.mapper.FeedTrackerModelMapperKt;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.utils.Content;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.v2.adapter.NewSocialFeedsAdapter;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog;
import id.dana.utils.ErrorUtil;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\bS\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\t\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\bJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\bJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\bJ\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\bJ\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\bJ\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\bR\"\u0010)\u001a\u00020(8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010/R\"\u00101\u001a\u0002008\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u00108R\u001b\u0010\"\u001a\u00020\u00038CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b&\u0010:\u001a\u0004\b9\u0010\u0005R\u0017\u0010\t\u001a\u0006*\u00020\u00030\u0003X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b$\u0010:R\u0016\u0010;\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010/R\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010/R\u0016\u0010\u0013\u001a\u00020<8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001f\u0010=R\u0016\u0010\u0011\u001a\u00020>8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010\u0014\u001a\u00020A8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010BR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002070C8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010&\u001a\u00020F8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bG\u0010HR\u0013\u0010\u001f\u001a\u00020IX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bJ\u0010:R\"\u0010L\u001a\u00020K8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bR\u0010/"}, d2 = {"Lid/dana/social/view/activity/SocialProfileActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivitySocialDetailBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "configToolbar", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function0;", "p0", "(Lkotlin/jvm/functions/Function0;)V", IAPSyncCommand.COMMAND_INIT, "initComponent", "initViewBinding", "()Lid/dana/databinding/ActivitySocialDetailBinding;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "Landroid/view/View;", "view", "onClickRightMenuButton", "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "initRecordTimeStamp", "GetContactSyncConfig", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Z", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/social/model/FeedViewHolderModel;", "PlaceComponentResult", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "PrepareContext", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "Lid/dana/social/view/activity/SocialProfileActivity$socialFeedListener$1;", "Lid/dana/social/view/activity/SocialProfileActivity$socialFeedListener$1;", "", "newProxyInstance", "Ljava/util/List;", "Lid/dana/social/base/BaseSocialFeedsAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/social/base/BaseSocialFeedsAdapter;", "Lid/dana/social/view/fragment/SocialModifyRelationBotttomSheetDialog;", "isLayoutRequested", "Lid/dana/social/contract/SocialProfileContract$Presenter;", "socialProfilePresenter", "Lid/dana/social/contract/SocialProfileContract$Presenter;", "getSocialProfilePresenter", "()Lid/dana/social/contract/SocialProfileContract$Presenter;", "setSocialProfilePresenter", "(Lid/dana/social/contract/SocialProfileContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialProfileActivity extends ViewBindingActivity<ActivitySocialDetailBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
    public static final String SOURCE = "Feeds User Profile";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private FeedViewHolderModel PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private BaseSocialFeedsAdapter NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private RelationshipItemModel lookAheadTest;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private LottieAnimationView getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public SocialProfileContract.Presenter socialProfilePresenter;
    public static final byte[] $$a = {Ascii.EM, 108, 7, 61, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 232;
    public static final byte[] PlaceComponentResult = {119, -93, -18, -42, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 85;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private List<FeedViewHolderModel> moveToNextValue = new ArrayList();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.social.view.activity.SocialProfileActivity$isMeRevampEnabled$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return SocialProfileActivity.this.getDanaApplication().getIsMePageRevamp();
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.social.view.activity.SocialProfileActivity$isFeedRevamp$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(SocialProfileActivity.this.getDanaApplication().isFeedRevamp());
        }
    });

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy initRecordTimeStamp = LazyKt.lazy(new Function0<SocialModifyRelationBotttomSheetDialog>() { // from class: id.dana.social.view.activity.SocialProfileActivity$socialModifyRelationBotttomSheetDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SocialModifyRelationBotttomSheetDialog invoke() {
            final SocialProfileActivity socialProfileActivity = SocialProfileActivity.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.view.activity.SocialProfileActivity$socialModifyRelationBotttomSheetDialog$2.1
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
                    RelationshipItemModel relationshipItemModel;
                    relationshipItemModel = SocialProfileActivity.this.lookAheadTest;
                    if (relationshipItemModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        relationshipItemModel = null;
                    }
                    String str = relationshipItemModel.getErrorConfigVersion;
                    if (Intrinsics.areEqual(str, "ACTIVE")) {
                        SocialProfileActivity.access$muteFriend(SocialProfileActivity.this);
                    } else if (Intrinsics.areEqual(str, "MUTE")) {
                        SocialProfileActivity.access$unMuteFriend(SocialProfileActivity.this);
                    }
                }
            };
            final SocialProfileActivity socialProfileActivity2 = SocialProfileActivity.this;
            return new SocialModifyRelationBotttomSheetDialog(function0, new Function0<Unit>() { // from class: id.dana.social.view.activity.SocialProfileActivity$socialModifyRelationBotttomSheetDialog$2.2
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
                    SocialProfileActivity.access$blockFriend(SocialProfileActivity.this);
                }
            });
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final SocialProfileActivity$socialFeedListener$1 scheduleImpl = new BaseSocialFeedInteraction() { // from class: id.dana.social.view.activity.SocialProfileActivity$socialFeedListener$1
        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void MyBillsEntityDataFactory(int p0) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter;
            BaseSocialFeedsAdapter baseSocialFeedsAdapter2;
            boolean z;
            baseSocialFeedsAdapter = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = null;
            if (baseSocialFeedsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter = null;
            }
            if (baseSocialFeedsAdapter.getPlaceComponentResult()) {
                baseSocialFeedsAdapter2 = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (baseSocialFeedsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    baseSocialFeedsAdapter3 = baseSocialFeedsAdapter2;
                }
                FeedViewHolderModel item = baseSocialFeedsAdapter3.getItem(p0);
                if (item != null) {
                    SocialProfileActivity socialProfileActivity = SocialProfileActivity.this;
                    FeedModel feedModel = item.MyBillsEntityDataFactory;
                    if (feedModel != null) {
                        SocialActivityDetail.Companion companion = SocialActivityDetail.INSTANCE;
                        SocialProfileActivity socialProfileActivity2 = socialProfileActivity;
                        z = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        SocialActivityDetail.Companion.KClassImpl$Data$declaredNonStaticMembers$2(socialProfileActivity2, feedModel, z);
                    }
                }
            }
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void MyBillsEntityDataFactory() {
            SocialProfileActivity.this.getSocialProfilePresenter().PlaceComponentResult();
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            boolean z;
            FragmentManager supportFragmentManager = SocialProfileActivity.this.getSupportFragmentManager();
            z = SocialProfileActivity.this.MyBillsEntityDataFactory;
            if (z) {
                new ReciprocalBottomSheetDialog().show(supportFragmentManager, "ReciprocalFriendListFragment");
            } else {
                new RelationshipBottomSheetDialog().show(supportFragmentManager, "RelationshipBottomSheet");
            }
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void BuiltInFictitiousFunctionClassFactory(ActivityWidgetModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            SocialProfileActivity.this.getFriendshipAnalyticTracker().getAuthRequestContext(FeedTrackerModelMapperKt.PlaceComponentResult(p0));
            SocialProfileActivity.this.getSocialProfilePresenter().PlaceComponentResult(p0.getAuthRequestContext);
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(String p0, DealsPayloadModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            SocialProfileActivity.this.getFriendshipAnalyticTracker().getAuthRequestContext(FeedTrackerModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(p1, p0));
            SocialProfileContract.Presenter socialProfilePresenter = SocialProfileActivity.this.getSocialProfilePresenter();
            String str = (String) MapsKt.getOrImplicitDefaultNullable(p1.PlaceComponentResult, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[1].getName());
            if (str == null) {
                str = "";
            }
            String str2 = (String) MapsKt.getOrImplicitDefaultNullable(p1.BuiltInFictitiousFunctionClassFactory, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[2].getName());
            socialProfilePresenter.getAuthRequestContext(str, str2 != null ? str2 : "");
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            SocialProfileActivity.this.getFriendshipAnalyticTracker().lookAheadTest(FeedsSourceType.OTHER_USER_PROFILE);
            SocialProfileActivity.this.getSocialProfilePresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0);
            SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.PROCESSING);
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            SocialProfileActivity.this.getSocialProfilePresenter().MyBillsEntityDataFactory(p0);
            SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.PROCESSING);
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(String p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            SocialProfileActivity.this.getSocialProfilePresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
            SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.PROCESSING);
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void PlaceComponentResult(String p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            SocialProfileActivity.this.getSocialProfilePresenter().BuiltInFictitiousFunctionClassFactory(p0, p1);
            SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.PROCESSING);
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ProfileCtaConfig p0, String p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            SocialProfileActivity.access$redirectCta(SocialProfileActivity.this, p0, p1, p2);
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(Content p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            String str = p0.MyBillsEntityDataFactory;
            if (str != null) {
                SocialProfileActivity socialProfileActivity = SocialProfileActivity.this;
                socialProfileActivity.getFriendshipAnalyticTracker().getAuthRequestContext(FeedTrackerModelMapperKt.getAuthRequestContext(p0));
                socialProfileActivity.getSocialProfilePresenter().PlaceComponentResult(str);
            }
        }
    };

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[ModifyRelationOperationType.values().length];
            iArr[ModifyRelationOperationType.BLOCK.ordinal()] = 1;
            iArr[ModifyRelationOperationType.UNBLOCK.ordinal()] = 2;
            iArr[ModifyRelationOperationType.MUTE.ordinal()] = 3;
            iArr[ModifyRelationOperationType.UNMUTE.ordinal()] = 4;
            getAuthRequestContext = iArr;
        }
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0026 -> B:35:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 97
            int r6 = r6 + 16
            int r8 = 55 - r8
            byte[] r0 = id.dana.social.view.activity.SocialProfileActivity.PlaceComponentResult
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L33:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.SocialProfileActivity.b(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002b -> B:35:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r8, byte r9, byte r10, java.lang.Object[] r11) {
        /*
            int r9 = r9 + 4
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r0 = id.dana.social.view.activity.SocialProfileActivity.$$a
            int r10 = r10 * 3
            int r10 = r10 + 21
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r9
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L36
        L18:
            r3 = 0
        L19:
            r6 = r9
            r9 = r8
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r10) goto L2b
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L2b:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L36:
            int r9 = r9 + 1
            int r10 = -r10
            int r8 = r8 + r10
            int r8 = r8 + (-7)
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.SocialProfileActivity.c(byte, byte, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        NetworkUserEntityData$$ExternalSyntheticLambda4 = -5701051516864315917L;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((ViewConfiguration.getWindowTouchSlop() >> 8) + 1, new char[]{18107, 46662, 18138, 47619, 33051, 17971, 23121, 20792, 34488, 1704, 6853, 4488, 50700, 50886, 56099, 53346, 1933, 34678, 39706, 37099, 18296, 18430}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(Color.blue(0) + 1, new char[]{13187, 60526, 13294, 38711, 6000, 7180, 30548, 51016, 62347}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((ViewConfiguration.getWindowTouchSlop() >> 8) + 1, new char[]{47525, 8645, 47506, 11566, 50791, 53693, 52526, 5646, 31225, 37158, 36277, 22242, 14666, 20819, 19523, 38696, 63620, 4264, 3173, 55236, 47140, 53311, 52478, 5127, 31709, 37777, 36639, 21564, 15177, 21333, 20392, 38106, 64355, 4782, 3685, 54599, 47868, 53896, 52874, 5615, 31247, 37403, 35092, 21066, 15786, 22000, 18804, 37592, 64867, 5449, 2498, 54007}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((ViewConfiguration.getDoubleTapTimeout() >> 16) + 1, new char[]{23514, 50180, 23483, 28343, 54371, 13354, 36535, 1110, 39888, 29882, 52773, 17638, 56166, 46228, 3968, 34175, 6906, 62826, 20476, 50626, 23128, 13821, 36663, 1619, 39330, 30210, 52435, 17981, 55652, 46789, 3120, 34527, 6422, 63343, 19887, 50964, 22745, 14107, 36117, 2026, 39029, 30592, 51845, 16461, 57303, 45159, 2748, 32987, 7965, 61580, 19036, 49313, 24313, 12572, 35782, 315, 40607, 29092, 52021, 16799, 56834, 45622, 2250, 33336, 7615, 62035, 18521, 49909}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((ViewConfiguration.getEdgeSlop() >> 16) + 1, new char[]{19448, 15491, 19402, 27552, 18571, 52393, 35827, 39096, 35757, 35891, 52016, 55298, 51992, 19528, 2710, 6547, 2701, 3567, 19178, 22825, 18985, 52525, 35442, 39662, 35286, 36566, 51603, 56021, 51527, 20038, 2343, 6762, 2410, 4074, 18621, 23469, 18607, 53148, 34820, 39682, 34902, 36691, 53140, 56494, 53240, 18614, 4095, 7222, 3940, 2060, 20251, 23580, 20110, 51601, 36485, 40335, 36534, 35109, 52852, 56691, 52775, 19125, 3463, 7812, 3530, 2777, 19743, 24087}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(-((byte) KeyEvent.getModifierMetaStateMask()), new char[]{39473, 28245, 39513, 59601, 16028, 40506, 2195, 61117, 23086, 57064, 18524, 44558, 6797, 7879, 35249, 28628, 56155, 24446, 51651, 12155, 39908, 40959, 2371, 60670, 22604, 56337, 19191, 44255, 6366, 7299, 35342, 27703, 55457, 23849, 52106, 11692, 39216, 40284, 2850, 60675, 22942, 56797, 19646, 43694, 7784, 6774, 36054, 27194, 57084, 23172, 52332, 10764, 40786, 39690, 3512, 60299, 24447, 56301, 19718, 43815, 8124, 6200, 36539, 26838}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{64546, 20218, 64539, 30084, 63883, 48847, 38278, 10740, 15484, 65100}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = PlaceComponentResult[25];
                byte b2 = (byte) (b | 8);
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 22), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 54, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 3, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        byte b3 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        c(b3, (byte) (b3 - 1), $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 15 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 800, 15 - TextUtils.indexOf("", ""), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 815, 29 - (ViewConfiguration.getTouchSlop() >> 8), (char) (TextUtils.getCapsMode("", 0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778016, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 15, (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1445609116, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = PlaceComponentResult[25];
                byte b5 = (byte) (b4 | 8);
                Object[] objArr20 = new Object[1];
                b(b4, b5, (byte) (b5 | 22), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 61, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 46, (char) Color.alpha(0));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[9]), (byte) 23, (byte) ($$a[47] - 1), objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), 35 - Color.alpha(0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1445609116, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), Gravity.getAbsoluteGravity(0, 0) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = PlaceComponentResult[25];
                byte b7 = (byte) (b6 | 8);
                Object[] objArr26 = new Object[1];
                b(b6, b7, (byte) (b7 | 22), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 118, 3 - TextUtils.getCapsMode("", 0, 0), (char) (AndroidCharacter.getMirror('0') + 38920));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[9]), (byte) 23, (byte) ($$a[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 930, 35 - View.MeasureSpec.getMode(0), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1445609116, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b8 = PlaceComponentResult[25];
                byte b9 = (byte) (b8 | 8);
                Object[] objArr32 = new Object[1];
                b(b8, b9, (byte) (b9 | 22), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[53]), $$a[2], objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Drawable.resolveOpacity(0, 0), 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1445609116, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, 18 - Color.alpha(0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(4) - 96, new char[]{49268, 17006, 49173, 62891, 13433, 45595, 5625, 58458, 'w', 62080, 21869, 42218, 16589, 13037, 38101, 25982, 33137, 29522, 54437, 9605, 49586, 46028, 5177, 58881, 572, 61489, 22411, 42609, 17053, 12457}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = PlaceComponentResult[30];
                byte b2 = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(PlaceComponentResult[8], PlaceComponentResult[5], PlaceComponentResult[25], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{10125, 27087, 10222, 28539, 49472, 39329, 36671, 4451, 59268, 55590, 53165, 20924, 42789, 6476, 3609, 36864, 26282, 22769, 20085, 53436, 9810, 39018}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 34 - TextUtils.lastIndexOf("", '0', 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 19, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        super.onPause();
    }

    @JvmName(name = "getSocialProfilePresenter")
    public final SocialProfileContract.Presenter getSocialProfilePresenter() {
        SocialProfileContract.Presenter presenter = this.socialProfilePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSocialProfilePresenter")
    public final void setSocialProfilePresenter(SocialProfileContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.socialProfilePresenter = presenter;
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

    @JvmName(name = "PlaceComponentResult")
    private final boolean PlaceComponentResult() {
        return ((Boolean) this.getAuthRequestContext.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v67, types: [id.dana.social.base.BaseSocialFeedsAdapter, id.dana.base.BaseRecyclerViewAdapter] */
    /* JADX WARN: Type inference failed for: r5v69 */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        SocialFeedsAdapter socialFeedsAdapter;
        Object obj;
        RelationshipItemModel relationshipItemModel;
        Object[] objArr2 = new Object[1];
        a((ViewConfiguration.getEdgeSlop() >> 16) + 1, new char[]{18107, 46662, 18138, 47619, 33051, 17971, 23121, 20792, 34488, 1704, 6853, 4488, 50700, 50886, 56099, 53346, 1933, 34678, 39706, 37099, 18296, 18430}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            byte b = PlaceComponentResult[30];
            byte b2 = PlaceComponentResult[25];
            Object[] objArr3 = new Object[1];
            b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            b(PlaceComponentResult[8], PlaceComponentResult[5], PlaceComponentResult[25], new Object[1]);
            Object[] objArr4 = new Object[1];
            a(((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{13187, 60526, 13294, 38711, 6000, 7180, 30548, 51016, 62347}, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        byte b3 = PlaceComponentResult[30];
                        byte b4 = PlaceComponentResult[25];
                        Object[] objArr5 = new Object[1];
                        b(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        b(PlaceComponentResult[8], PlaceComponentResult[5], PlaceComponentResult[25], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{49268, 17006, 49173, 62891, 13433, 45595, 5625, 58458, 'w', 62080, 21869, 42218, 16589, 13037, 38101, 25982, 33137, 29522, 54437, 9605, 49586, 46028, 5177, 58881, 572, 61489, 22411, 42609, 17053, 12457}, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        a(super.getResources().getString(R.string.sort_label).substring(3, 4).length() + 0, new char[]{10125, 27087, 10222, 28539, 49472, 39329, 36671, 4451, 59268, 55590, 53165, 20924, 42789, 6476, 3609, 36864, 26282, 22769, 20085, 53436, 9810, 39018}, objArr7);
                        baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            byte b5 = PlaceComponentResult[30];
                            byte b6 = PlaceComponentResult[25];
                            Object[] objArr8 = new Object[1];
                            b(b5, b6, (byte) (b6 | TarHeader.LF_BLK), objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            b(PlaceComponentResult[8], PlaceComponentResult[5], PlaceComponentResult[25], new Object[1]);
                            Object[] objArr9 = new Object[1];
                            a(((ApplicationInfo) cls5.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{47525, 8645, 47506, 11566, 50791, 53693, 52526, 5646, 31225, 37158, 36277, 22242, 14666, 20819, 19523, 38696, 63620, 4264, 3173, 55236, 47140, 53311, 52478, 5127, 31709, 37777, 36639, 21564, 15177, 21333, 20392, 38106, 64355, 4782, 3685, 54599, 47868, 53896, 52874, 5615, 31247, 37403, 35092, 21066, 15786, 22000, 18804, 37592, 64867, 5449, 2498, 54007}, objArr9);
                            String str = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            a(getPackageName().length() - 6, new char[]{23514, 50180, 23483, 28343, 54371, 13354, 36535, 1110, 39888, 29882, 52773, 17638, 56166, 46228, 3968, 34175, 6906, 62826, 20476, 50626, 23128, 13821, 36663, 1619, 39330, 30210, 52435, 17981, 55652, 46789, 3120, 34527, 6422, 63343, 19887, 50964, 22745, 14107, 36117, 2026, 39029, 30592, 51845, 16461, 57303, 45159, 2748, 32987, 7965, 61580, 19036, 49313, 24313, 12572, 35782, 315, 40607, 29092, 52021, 16799, 56834, 45622, 2250, 33336, 7615, 62035, 18521, 49909}, objArr10);
                            String str2 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            a(getPackageName().length() - 6, new char[]{19448, 15491, 19402, 27552, 18571, 52393, 35827, 39096, 35757, 35891, 52016, 55298, 51992, 19528, 2710, 6547, 2701, 3567, 19178, 22825, 18985, 52525, 35442, 39662, 35286, 36566, 51603, 56021, 51527, 20038, 2343, 6762, 2410, 4074, 18621, 23469, 18607, 53148, 34820, 39682, 34902, 36691, 53140, 56494, 53240, 18614, 4095, 7222, 3940, 2060, 20251, 23580, 20110, 51601, 36485, 40335, 36534, 35109, 52852, 56691, 52775, 19125, 3463, 7812, 3530, 2777, 19743, 24087}, objArr11);
                            String str3 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(super.getResources().getString(R.string.dashboard_member_status_pending).substring(7, 8).length() + 0, new char[]{39473, 28245, 39513, 59601, 16028, 40506, 2195, 61117, 23086, 57064, 18524, 44558, 6797, 7879, 35249, 28628, 56155, 24446, 51651, 12155, 39908, 40959, 2371, 60670, 22604, 56337, 19191, 44255, 6366, 7299, 35342, 27703, 55457, 23849, 52106, 11692, 39216, 40284, 2850, 60675, 22942, 56797, 19646, 43694, 7784, 6774, 36054, 27194, 57084, 23172, 52332, 10764, 40786, 39690, 3512, 60299, 24447, 56301, 19718, 43815, 8124, 6200, 36539, 26838}, objArr12);
                            String str4 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a(Color.green(0) + 1, new char[]{64546, 20218, 64539, 30084, 63883, 48847, 38278, 10740, 15484, 65100}, objArr13);
                            try {
                                Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj3 == null) {
                                    obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), TextUtils.getTrimmedLength("") + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj3);
                                }
                                ((Method) obj3).invoke(invoke, objArr14);
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
                }
            }
            try {
                Object[] objArr15 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), objArr15);
                Class<?> cls6 = Class.forName((String) objArr15[0]);
                byte b7 = PlaceComponentResult[25];
                byte b8 = (byte) (b7 | 8);
                Object[] objArr16 = new Object[1];
                b(b7, b8, (byte) (b8 | 22), objArr16);
                try {
                    Object[] objArr17 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj4 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 495, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 4, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        Object[] objArr18 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[53]), $$a[2], objArr18);
                        obj4 = cls7.getMethod((String) objArr18[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj4);
                    }
                    Object[] objArr19 = (Object[]) ((Method) obj4).invoke(null, objArr17);
                    int i = ((int[]) objArr19[1])[0];
                    if (((int[]) objArr19[0])[0] != i) {
                        long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj5 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj5);
                            }
                            Object invoke2 = ((Method) obj5).invoke(objArr, objArr);
                            try {
                                Object[] objArr20 = {1902126197, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj6 == null) {
                                    obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj6);
                                }
                                ((Method) obj6).invoke(invoke2, objArr20);
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
                    } else {
                        objArr = null;
                    }
                    super.onCreate(savedInstanceState);
                    initComponent();
                    getSocialProfilePresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                    getSocialProfilePresenter().KClassImpl$Data$declaredNonStaticMembers$2(!PlaceComponentResult());
                    getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(this, PlaceComponentResult() ? R.color.f27072131100488 : R.color.f27102131100497));
                    if (PlaceComponentResult()) {
                        socialFeedsAdapter = new NewSocialFeedsAdapter();
                    } else {
                        socialFeedsAdapter = new SocialFeedsAdapter();
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = socialFeedsAdapter;
                    RecyclerView recyclerView = getBinding().MyBillsEntityDataFactory;
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = baseSocialFeedsAdapter;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter2 = objArr;
                    }
                    baseSocialFeedsAdapter2.setItems(new ArrayList());
                    SocialProfileActivity$socialFeedListener$1 socialProfileActivity$socialFeedListener$1 = this.scheduleImpl;
                    Intrinsics.checkNotNullParameter(socialProfileActivity$socialFeedListener$1, "");
                    baseSocialFeedsAdapter2.getErrorConfigVersion = socialProfileActivity$socialFeedListener$1;
                    baseSocialFeedsAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    recyclerView.setAdapter((RecyclerView.Adapter) baseSocialFeedsAdapter2);
                    Bundle extras = getIntent().getExtras();
                    if (extras == null || (relationshipItemModel = (RelationshipItemModel) extras.getParcelable("bundle_relationship_data")) == null) {
                        obj = objArr;
                    } else {
                        this.lookAheadTest = relationshipItemModel;
                        getSocialProfilePresenter().PlaceComponentResult(relationshipItemModel.GetContactSyncConfig, PlaceComponentResult());
                        obj = Unit.INSTANCE;
                    }
                    if (obj == null) {
                        NetworkUserEntityData$$ExternalSyntheticLambda1();
                    }
                    getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2();
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = null;
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(5) - 109, new char[]{49268, 17006, 49173, 62891, 13433, 45595, 5625, 58458, 'w', 62080, 21869, 42218, 16589, 13037, 38101, 25982, 33137, 29522, 54437, 9605, 49586, 46028, 5177, 58881, 572, 61489, 22411, 42609, 17053, 12457}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(1 - View.MeasureSpec.getMode(0), new char[]{10125, 27087, 10222, 28539, 49472, 39329, 36671, 4451, 59268, 55590, 53165, 20924, 42789, 6476, 3609, 36864, 26282, 22769, 20085, 53436, 9810, 39018}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 35 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, KeyEvent.normalizeMetaState(0) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (baseSocialFeedsAdapter2 != null) {
            if (baseSocialFeedsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                baseSocialFeedsAdapter = baseSocialFeedsAdapter2;
            }
            Intrinsics.checkNotNullExpressionValue(baseSocialFeedsAdapter.getItems(), "");
            if ((!r0.isEmpty()) == true) {
                KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.social.view.activity.SocialProfileActivity$onResume$2
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
                        RelationshipItemModel relationshipItemModel;
                        SocialProfileContract.Presenter socialProfilePresenter = SocialProfileActivity.this.getSocialProfilePresenter();
                        relationshipItemModel = SocialProfileActivity.this.lookAheadTest;
                        if (relationshipItemModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            relationshipItemModel = null;
                        }
                        socialProfilePresenter.BuiltInFictitiousFunctionClassFactory(relationshipItemModel.GetContactSyncConfig);
                    }
                });
            }
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickRightMenuButton(View view) {
        RelationshipItemModel relationshipItemModel = this.lookAheadTest;
        RelationshipItemModel relationshipItemModel2 = null;
        if (relationshipItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel = null;
        }
        if (Intrinsics.areEqual(relationshipItemModel.getErrorConfigVersion, "SELF")) {
            getSocialProfilePresenter().PlaceComponentResult();
            return;
        }
        SocialModifyRelationBotttomSheetDialog socialModifyRelationBotttomSheetDialog = (SocialModifyRelationBotttomSheetDialog) this.initRecordTimeStamp.getValue();
        RelationshipItemModel relationshipItemModel3 = this.lookAheadTest;
        if (relationshipItemModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            relationshipItemModel2 = relationshipItemModel3;
        }
        String str = relationshipItemModel2.getErrorConfigVersion;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(supportFragmentManager, "");
        Intrinsics.checkNotNullParameter("", "");
        socialModifyRelationBotttomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        socialModifyRelationBotttomSheetDialog.show(supportFragmentManager, "");
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        RelationshipItemModel relationshipItemModel = null;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        if (baseSocialFeedsAdapter.getPlaceComponentResult() > 1) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter2 = null;
            }
            BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter3 = null;
            }
            baseSocialFeedsAdapter2.setItems(CollectionsKt.listOf(baseSocialFeedsAdapter3.getItems().get(0)));
        }
        RelationshipItemModel relationshipItemModel2 = this.lookAheadTest;
        if (relationshipItemModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel2 = null;
        }
        if (relationshipItemModel2.getMyBillsEntityDataFactory()) {
            NetworkUserEntityData$$ExternalSyntheticLambda8();
        } else {
            RelationshipItemModel relationshipItemModel3 = this.lookAheadTest;
            if (relationshipItemModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel3 = null;
            }
            if (!Intrinsics.areEqual(relationshipItemModel3.getErrorConfigVersion, "BLOCKING")) {
                RelationshipItemModel relationshipItemModel4 = this.lookAheadTest;
                if (relationshipItemModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    relationshipItemModel = relationshipItemModel4;
                }
                if (!Intrinsics.areEqual(relationshipItemModel.getErrorConfigVersion, "INACTIVE")) {
                    DatabaseTableConfigUtil();
                }
            }
            NetworkUserEntityData$$ExternalSyntheticLambda2();
        }
        ConstraintLayout constraintLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(0);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        ConstraintLayout constraintLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory, R.drawable.feed_no_friend_illustraation);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue.setText(constraintLayout.getContext().getString(R.string.profile_empty_title_non_reciprocal));
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.setText(constraintLayout.getContext().getString(R.string.profile_empty_desc_non_reciprocal));
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        ConstraintLayout constraintLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory, R.drawable.social_feeds_empty_state_blocked);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue.setText(constraintLayout.getContext().getString(R.string.profile_empty_title_blocked));
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.setText(constraintLayout.getContext().getString(R.string.profile_empty_desc_blocked));
    }

    private final void DatabaseTableConfigUtil() {
        ConstraintLayout constraintLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory, R.drawable.img_empty_state);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue.setText(constraintLayout.getContext().getString(R.string.profile_empty_title));
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.setText(constraintLayout.getContext().getString(R.string.profile_empty_desc));
    }

    public final void initComponent() {
        SocialCommonComponent socialCommonComponent = getDanaApplication().getSocialCommonComponent();
        byte b = 0;
        if (socialCommonComponent != null) {
            SocialProfileModule socialProfileModule = new SocialProfileModule(new SocialProfileContract.View() { // from class: id.dana.social.view.activity.SocialProfileActivity$initComponent$1
                @Override // id.dana.social.contract.SocialProfileContract.View
                public final String BuiltInFictitiousFunctionClassFactory() {
                    return SocialProfileActivity.SOURCE;
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
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void PlaceComponentResult(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.this.getAuthRequestContext(p0);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void MyBillsEntityDataFactory(SettingModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.access$goToProfileActivity(SocialProfileActivity.this, p0);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void moveToNextValue() {
                    SocialProfileActivity socialProfileActivity = SocialProfileActivity.this;
                    Toast.makeText(socialProfileActivity, ErrorUtil.BuiltInFictitiousFunctionClassFactory(socialProfileActivity), 0).show();
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void BuiltInFictitiousFunctionClassFactory(RelationshipItemModel p0) {
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    RelationshipItemModel relationshipItemModel;
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.this.lookAheadTest = p0;
                    SocialProfileActivity socialProfileActivity = SocialProfileActivity.this;
                    baseSocialFeedsAdapter = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    RelationshipItemModel relationshipItemModel2 = null;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter = null;
                    }
                    boolean builtInFictitiousFunctionClassFactory = baseSocialFeedsAdapter.getBuiltInFictitiousFunctionClassFactory();
                    relationshipItemModel = SocialProfileActivity.this.lookAheadTest;
                    if (relationshipItemModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        relationshipItemModel2 = relationshipItemModel;
                    }
                    SocialProfileActivity.access$getFriendStatusIfAddFriendIsEnabled(socialProfileActivity, builtInFictitiousFunctionClassFactory, relationshipItemModel2.GetContactSyncConfig, p0.KClassImpl$Data$declaredNonStaticMembers$2());
                    SocialProfileActivity.access$setTitleBasedOnRelationshipStatus(SocialProfileActivity.this, p0.getErrorConfigVersion, p0.scheduleImpl);
                    SocialProfileActivity.this.getAuthRequestContext(p0.getErrorConfigVersion);
                    SocialProfileActivity.access$loadUserProfileHeader(SocialProfileActivity.this);
                    if (p0.getMyBillsEntityDataFactory()) {
                        SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                        return;
                    }
                    SocialProfileActivity socialProfileActivity2 = SocialProfileActivity.this;
                    final SocialProfileActivity socialProfileActivity3 = SocialProfileActivity.this;
                    socialProfileActivity2.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.social.view.activity.SocialProfileActivity$initComponent$1$onGetUserProfileHeaderSuccess$1
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
                            RelationshipItemModel relationshipItemModel3;
                            SocialProfileContract.Presenter socialProfilePresenter = SocialProfileActivity.this.getSocialProfilePresenter();
                            relationshipItemModel3 = SocialProfileActivity.this.lookAheadTest;
                            if (relationshipItemModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                relationshipItemModel3 = null;
                            }
                            socialProfilePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0(relationshipItemModel3.GetContactSyncConfig);
                        }
                    });
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
                    RelationshipItemModel relationshipItemModel;
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    RelationshipItemModel relationshipItemModel2;
                    RelationshipItemModel relationshipItemModel3;
                    relationshipItemModel = SocialProfileActivity.this.lookAheadTest;
                    RelationshipItemModel relationshipItemModel4 = null;
                    if (relationshipItemModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        relationshipItemModel = null;
                    }
                    relationshipItemModel.MyBillsEntityDataFactory = true;
                    SocialProfileActivity.access$loadUserProfileHeader(SocialProfileActivity.this);
                    SocialProfileActivity socialProfileActivity = SocialProfileActivity.this;
                    baseSocialFeedsAdapter = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter = null;
                    }
                    boolean builtInFictitiousFunctionClassFactory = baseSocialFeedsAdapter.getBuiltInFictitiousFunctionClassFactory();
                    relationshipItemModel2 = SocialProfileActivity.this.lookAheadTest;
                    if (relationshipItemModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        relationshipItemModel2 = null;
                    }
                    String str = relationshipItemModel2.GetContactSyncConfig;
                    relationshipItemModel3 = SocialProfileActivity.this.lookAheadTest;
                    if (relationshipItemModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        relationshipItemModel4 = relationshipItemModel3;
                    }
                    SocialProfileActivity.access$getFriendStatusIfAddFriendIsEnabled(socialProfileActivity, builtInFictitiousFunctionClassFactory, str, relationshipItemModel4.KClassImpl$Data$declaredNonStaticMembers$2());
                    SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void getAuthRequestContext(List<FeedViewHolderModel> p0) {
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.access$hideEmptyState(SocialProfileActivity.this);
                    SocialProfileActivity.this.GetContactSyncConfig();
                    SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                    baseSocialFeedsAdapter = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = null;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter = null;
                    }
                    baseSocialFeedsAdapter.DatabaseTableConfigUtil();
                    if (p0.isEmpty()) {
                        SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                        return;
                    }
                    baseSocialFeedsAdapter2 = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (baseSocialFeedsAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        baseSocialFeedsAdapter3 = baseSocialFeedsAdapter2;
                    }
                    baseSocialFeedsAdapter3.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    for (FeedViewHolderModel feedViewHolderModel : p0) {
                        if (feedViewHolderModel.getErrorConfigVersion == 9 || feedViewHolderModel.getErrorConfigVersion == 5) {
                            SocialProfileActivity.access$checkProfileNameIntegrity(SocialProfileActivity.this, feedViewHolderModel);
                            return;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void PlaceComponentResult(List<FeedViewHolderModel> p0) {
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.this.GetContactSyncConfig();
                    SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                    SocialProfileActivity.access$hideEmptyState(SocialProfileActivity.this);
                    baseSocialFeedsAdapter = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter = null;
                    }
                    baseSocialFeedsAdapter.DatabaseTableConfigUtil();
                    if (p0.isEmpty()) {
                        SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                    } else {
                        SocialProfileActivity.access$addInitialFeedListWithProfileItem(SocialProfileActivity.this, p0);
                    }
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void getErrorConfigVersion() {
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    SocialProfileActivity.this.GetContactSyncConfig();
                    SocialProfileActivity.access$appendLoadMore(SocialProfileActivity.this);
                    SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                    baseSocialFeedsAdapter = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter = null;
                    }
                    baseSocialFeedsAdapter.DatabaseTableConfigUtil();
                    SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final String PlaceComponentResult() {
                    String shownErrorMessage;
                    shownErrorMessage = SocialProfileActivity.this.getShownErrorMessage();
                    return shownErrorMessage == null ? "" : shownErrorMessage;
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void PlaceComponentResult(ModifyRelationOperationType p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.access$modifyRelationshipCompleted(SocialProfileActivity.this, p0);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void DatabaseTableConfigUtil() {
                    SocialProfileActivity.access$showErrorModifyRelationship(SocialProfileActivity.this);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void MyBillsEntityDataFactory(FeedConfig p0) {
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter2;
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter3;
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0.isReplyCommentEnabled();
                    SocialProfileActivity.this.MyBillsEntityDataFactory = p0.isReciprocalFeedEnabled();
                    baseSocialFeedsAdapter = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter4 = null;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter = null;
                    }
                    baseSocialFeedsAdapter.PlaceComponentResult = p0.isFeedCommentEnabled();
                    baseSocialFeedsAdapter2 = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (baseSocialFeedsAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter2 = null;
                    }
                    baseSocialFeedsAdapter2.MyBillsEntityDataFactory = p0.getFeedVersion() > 3;
                    baseSocialFeedsAdapter3 = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (baseSocialFeedsAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        baseSocialFeedsAdapter4 = baseSocialFeedsAdapter3;
                    }
                    baseSocialFeedsAdapter4.BuiltInFictitiousFunctionClassFactory = p0.isAddFriendEnabled();
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void getAuthRequestContext() {
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    baseSocialFeedsAdapter = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter = null;
                    }
                    FeedViewHolderModel PlaceComponentResult2 = baseSocialFeedsAdapter.PlaceComponentResult();
                    RelationshipItemModel relationshipItemModel = PlaceComponentResult2 != null ? PlaceComponentResult2.getAuthRequestContext : null;
                    if (relationshipItemModel != null) {
                        relationshipItemModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    }
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.PENDING);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.NOT_AFFILIATED);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void BuiltInFictitiousFunctionClassFactory(FriendModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.access$defineIfIsRequester(SocialProfileActivity.this, p0.getGetAuthRequestContext());
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, p0.scheduleImpl);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void lookAheadTest() {
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.EMPTY);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void scheduleImpl() {
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.NOT_AFFILIATED);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void MyBillsEntityDataFactory() {
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.APPROVED);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
                    RelationshipItemModel relationshipItemModel;
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                    SocialProfileActivity.this.getFriendshipAnalyticTracker().PlaceComponentResult(FeedsSourceType.FRIEND_PROFILE_PAGE);
                    SocialProfileActivity.access$showSuccessToast(SocialProfileActivity.this, p1);
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.APPROVED);
                    relationshipItemModel = SocialProfileActivity.this.lookAheadTest;
                    if (relationshipItemModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        relationshipItemModel = null;
                    }
                    relationshipItemModel.MyBillsEntityDataFactory = false;
                    SocialProfileActivity.access$hideEmptyStateNonReciprocal(SocialProfileActivity.this);
                    r3.KClassImpl$Data$declaredNonStaticMembers$2(new SocialProfileActivity$onRefresh$1(SocialProfileActivity.this));
                    SocialProfileActivity.access$showSuccessToast(SocialProfileActivity.this, p1);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.PENDING);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void MyBillsEntityDataFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.this.getFriendshipAnalyticTracker().getAuthRequestContext(FeedsSourceType.FRIEND_PROFILE_PAGE);
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.NOT_AFFILIATED);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void getAuthRequestContext(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialProfileActivity.access$changeProfileState(SocialProfileActivity.this, FriendshipStatus.PENDING);
                }

                @Override // id.dana.social.contract.SocialProfileContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(List<ProfileCtaConfig> p0) {
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    ActivitySocialDetailBinding binding;
                    Intrinsics.checkNotNullParameter(p0, "");
                    baseSocialFeedsAdapter = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (baseSocialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        baseSocialFeedsAdapter = null;
                    }
                    binding = SocialProfileActivity.this.getBinding();
                    RecyclerView recyclerView = binding.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "");
                    baseSocialFeedsAdapter.KClassImpl$Data$declaredNonStaticMembers$2(recyclerView, p0);
                }
            });
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            SocialProfileActivity socialProfileActivity = this;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = socialProfileActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = FeedsSourceType.FRIENDSHIP_FRIENDS_FEED;
            DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b);
            Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = socialProfileActivity;
            ScanQrModule scanQrModule = new ScanQrModule(authRequestContext, b);
            Intrinsics.checkNotNullExpressionValue(scanQrModule, "");
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = socialProfileActivity;
            RestoreUrlModule restoreUrlModule = new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b);
            Intrinsics.checkNotNullExpressionValue(restoreUrlModule, "");
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = socialProfileActivity;
            FeatureModule featureModule = new FeatureModule(MyBillsEntityDataFactory, b);
            Intrinsics.checkNotNullExpressionValue(featureModule, "");
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = socialProfileActivity;
            OauthModule oauthModule = new OauthModule(BuiltInFictitiousFunctionClassFactory, b);
            Intrinsics.checkNotNullExpressionValue(oauthModule, "");
            socialCommonComponent.BuiltInFictitiousFunctionClassFactory(socialProfileModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.social.view.activity.SocialProfileActivity$initComponent$2
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
            })).PlaceComponentResult(this);
        }
        registerPresenter(getSocialProfilePresenter());
    }

    public final void GetContactSyncConfig() {
        if (!lookAheadTest()) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = null;
            if (baseSocialFeedsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter = null;
            }
            BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter3 = null;
            }
            if (baseSocialFeedsAdapter.getItem(baseSocialFeedsAdapter3.getPlaceComponentResult() - 1).getErrorConfigVersion == 6) {
                BaseSocialFeedsAdapter baseSocialFeedsAdapter4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (baseSocialFeedsAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    baseSocialFeedsAdapter4 = null;
                }
                BaseSocialFeedsAdapter baseSocialFeedsAdapter5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (baseSocialFeedsAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    baseSocialFeedsAdapter2 = baseSocialFeedsAdapter5;
                }
                baseSocialFeedsAdapter4.removeItem(baseSocialFeedsAdapter2.getPlaceComponentResult() - 1);
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final boolean scheduleImpl() {
        if (!lookAheadTest()) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = null;
            if (baseSocialFeedsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter = null;
            }
            BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                baseSocialFeedsAdapter2 = baseSocialFeedsAdapter3;
            }
            if (baseSocialFeedsAdapter.getItem(baseSocialFeedsAdapter2.getPlaceComponentResult() - 1).getErrorConfigVersion == 7) {
                return true;
            }
        }
        return false;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = Completable.KClassImpl$Data$declaredNonStaticMembers$2(new Callable() { // from class: id.dana.social.view.activity.SocialProfileActivity$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SocialProfileActivity.$r8$lambda$WzstR1VJo2PtrUt_AKwSzhc_o6s(SocialProfileActivity.this);
            }
        });
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        addDisposable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(KClassImpl$Data$declaredNonStaticMembers$22, 500L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2)).q_());
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Function0<Unit> p0) {
        RelationshipItemModel relationshipItemModel = this.lookAheadTest;
        RelationshipItemModel relationshipItemModel2 = null;
        if (relationshipItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel = null;
        }
        String str = relationshipItemModel.getErrorConfigVersion;
        int hashCode = str.hashCode();
        if (hashCode == -1134023652 ? !str.equals("SUSPEND") : !(hashCode == 118053941 ? str.equals("BLOCKING") : !(hashCode != 807292011 || !str.equals("INACTIVE")))) {
            RelationshipItemModel relationshipItemModel3 = this.lookAheadTest;
            if (relationshipItemModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                relationshipItemModel2 = relationshipItemModel3;
            }
            if (!relationshipItemModel2.getMyBillsEntityDataFactory()) {
                p0.invoke();
                return;
            }
        }
        initRecordTimeStamp();
    }

    private final void initRecordTimeStamp() {
        GetContactSyncConfig();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        baseSocialFeedsAdapter.DatabaseTableConfigUtil();
        NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivitySocialDetailBinding initViewBinding() {
        ActivitySocialDetailBinding authRequestContext = ActivitySocialDetailBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.social_profile));
        setMenuRightButton("");
        setMenuLeftButton(R.drawable.btn_arrow_left);
        setToolbarTitleContentDescription(getString(R.string.lblProfileTitle));
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        return (lookAheadTest() || this.BuiltInFictitiousFunctionClassFactory || !getErrorConfigVersion()) ? false : true;
    }

    private final boolean getErrorConfigVersion() {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = null;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (baseSocialFeedsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter3 = null;
        }
        if (baseSocialFeedsAdapter.getItem(baseSocialFeedsAdapter3.getPlaceComponentResult() - 1).getErrorConfigVersion != 5) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter4 = null;
            }
            BaseSocialFeedsAdapter baseSocialFeedsAdapter5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                baseSocialFeedsAdapter2 = baseSocialFeedsAdapter5;
            }
            return baseSocialFeedsAdapter4.getItem(baseSocialFeedsAdapter2.getPlaceComponentResult() - 1).getErrorConfigVersion == 9;
        }
        return true;
    }

    private final boolean lookAheadTest() {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        return baseSocialFeedsAdapter.getPlaceComponentResult() <= 0;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RecyclerView.LayoutManager layoutManager = getBinding().MyBillsEntityDataFactory.getLayoutManager();
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final boolean moveToNextValue() {
        return this.getErrorConfigVersion != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0010, code lost:
    
        if (r3.equals("INACTIVE") == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0019, code lost:
    
        if (r3.equals("BLOCKING") != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x001b, code lost:
    
        setMenuRightButton("");
        r3 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        r3.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x002f, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            java.lang.String r1 = ""
            switch(r0) {
                case -1134023652: goto L4f;
                case 2541388: goto L30;
                case 118053941: goto L13;
                case 807292011: goto La;
                default: goto L9;
            }
        L9:
            goto L5b
        La:
            java.lang.String r0 = "INACTIVE"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L1b
            goto L5b
        L13:
            java.lang.String r0 = "BLOCKING"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L5b
        L1b:
            r2.setMenuRightButton(r1)
            androidx.viewbinding.ViewBinding r3 = r2.getBinding()
            id.dana.databinding.ActivitySocialDetailBinding r3 = (id.dana.databinding.ActivitySocialDetailBinding) r3
            id.dana.component.buttoncomponent.DanaButtonSecondaryView r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            android.view.View r3 = (android.view.View) r3
            r0 = 0
            r3.setVisibility(r0)
            return
        L30:
            java.lang.String r0 = "SELF"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L5b
            boolean r3 = r2.PlaceComponentResult()
            if (r3 != 0) goto L8f
            r3 = 2131233682(0x7f080b92, float:1.8083508E38)
            r2.setMenuRightButton(r3)
            r3 = 2131952257(0x7f130281, float:1.9540952E38)
            java.lang.String r3 = r2.getString(r3)
            r2.setRightButtonContentDescription(r3)
            return
        L4f:
            java.lang.String r0 = "SUSPEND"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L5b
            r2.setMenuRightButton(r1)
            return
        L5b:
            id.dana.feeds.ui.model.RelationshipItemModel r3 = r2.lookAheadTest
            if (r3 != 0) goto L63
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = 0
        L63:
            boolean r3 = r3.getMyBillsEntityDataFactory()
            if (r3 == 0) goto L6d
            r2.setMenuRightButton(r1)
            goto L7d
        L6d:
            r3 = 2131233823(0x7f080c1f, float:1.8083794E38)
            r2.setMenuRightButton(r3)
            r3 = 2131952273(0x7f130291, float:1.9540984E38)
            java.lang.String r3 = r2.getString(r3)
            r2.setRightButtonContentDescription(r3)
        L7d:
            androidx.viewbinding.ViewBinding r3 = r2.getBinding()
            id.dana.databinding.ActivitySocialDetailBinding r3 = (id.dana.databinding.ActivitySocialDetailBinding) r3
            id.dana.component.buttoncomponent.DanaButtonSecondaryView r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            android.view.View r3 = (android.view.View) r3
            r0 = 8
            r3.setVisibility(r0)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.SocialProfileActivity.getAuthRequestContext(java.lang.String):void");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/view/activity/SocialProfileActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Lid/dana/feeds/ui/model/RelationshipItemModel;)V", "", "SOURCE", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, RelationshipItemModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, SocialProfileActivity.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("bundle_relationship_data", p1);
            p0.startActivity(intent);
        }
    }

    public static /* synthetic */ Unit $r8$lambda$WzstR1VJo2PtrUt_AKwSzhc_o6s(SocialProfileActivity socialProfileActivity) {
        Intrinsics.checkNotNullParameter(socialProfileActivity, "");
        socialProfileActivity.BuiltInFictitiousFunctionClassFactory = false;
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void $r8$lambda$dYiThaHRBcjLOaswPaawJI2ppX8(SocialProfileActivity socialProfileActivity, View view) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(socialProfileActivity, "");
        if (!socialProfileActivity.lookAheadTest() && (layoutManager = socialProfileActivity.getBinding().MyBillsEntityDataFactory.getLayoutManager()) != null) {
            layoutManager.smoothScrollToPosition(socialProfileActivity.getBinding().MyBillsEntityDataFactory, new RecyclerView.State(), 0);
        }
        socialProfileActivity.getBinding().getAuthRequestContext.getAuthRequestContext.setVisibility(8);
    }

    /* renamed from: $r8$lambda$uN4n8NkTzsheOnzpVujbJ6SZ5-s */
    public static /* synthetic */ void m2967$r8$lambda$uN4n8NkTzsheOnzpVujbJ6SZ5s(SocialProfileActivity socialProfileActivity, View view) {
        Intrinsics.checkNotNullParameter(socialProfileActivity, "");
        SocialProfileContract.Presenter socialProfilePresenter = socialProfileActivity.getSocialProfilePresenter();
        RelationshipItemModel relationshipItemModel = socialProfileActivity.lookAheadTest;
        if (relationshipItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel = null;
        }
        socialProfilePresenter.PlaceComponentResult(relationshipItemModel.GetContactSyncConfig, ModifyRelationOperationType.UNBLOCK);
    }

    public static final /* synthetic */ void access$addInitialFeedListWithProfileItem(SocialProfileActivity socialProfileActivity, List list) {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        List mutableListOf = CollectionsKt.mutableListOf(socialProfileActivity.PlaceComponentResult);
        mutableListOf.addAll(list);
        baseSocialFeedsAdapter.setItems(mutableListOf);
    }

    public static final /* synthetic */ void access$appendLoadMore(SocialProfileActivity socialProfileActivity) {
        if (socialProfileActivity.lookAheadTest() || !socialProfileActivity.getErrorConfigVersion() || socialProfileActivity.scheduleImpl()) {
            return;
        }
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        baseSocialFeedsAdapter.appendItem(new FeedViewHolderModel(7, null, null, null, null, false, 60, null));
    }

    public static final /* synthetic */ void access$blockFriend(SocialProfileActivity socialProfileActivity) {
        SocialProfileContract.Presenter socialProfilePresenter = socialProfileActivity.getSocialProfilePresenter();
        RelationshipItemModel relationshipItemModel = socialProfileActivity.lookAheadTest;
        if (relationshipItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel = null;
        }
        socialProfilePresenter.PlaceComponentResult(relationshipItemModel.GetContactSyncConfig, ModifyRelationOperationType.BLOCK);
    }

    public static final /* synthetic */ void access$changeProfileState(SocialProfileActivity socialProfileActivity, FriendshipStatus friendshipStatus) {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = null;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        FeedViewHolderModel PlaceComponentResult2 = baseSocialFeedsAdapter.PlaceComponentResult();
        if (PlaceComponentResult2 != null) {
            RelationshipItemModel relationshipItemModel = PlaceComponentResult2.getAuthRequestContext;
            if (relationshipItemModel != null) {
                Intrinsics.checkNotNullParameter(friendshipStatus, "");
                relationshipItemModel.KClassImpl$Data$declaredNonStaticMembers$2 = friendshipStatus;
            }
        } else {
            PlaceComponentResult2 = null;
        }
        if (PlaceComponentResult2 != null) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                baseSocialFeedsAdapter2 = baseSocialFeedsAdapter3;
            }
            baseSocialFeedsAdapter2.getAuthRequestContext(PlaceComponentResult2);
        }
    }

    public static final /* synthetic */ void access$checkProfileNameIntegrity(SocialProfileActivity socialProfileActivity, FeedViewHolderModel feedViewHolderModel) {
        RelationshipItemModel relationshipItemModel;
        if (socialProfileActivity.PlaceComponentResult != null) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter = null;
            }
            RelationshipItemModel relationshipItemModel2 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel2 = null;
            }
            boolean areEqual = Intrinsics.areEqual(relationshipItemModel2.getErrorConfigVersion, "SELF");
            Intrinsics.checkNotNullParameter(feedViewHolderModel, "");
            List<FeedViewHolderModel> items = baseSocialFeedsAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            Iterator<FeedViewHolderModel> it = items.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (it.next().getErrorConfigVersion == 8) {
                    break;
                }
                i++;
            }
            Integer valueOf = Integer.valueOf(i);
            if (!(valueOf.intValue() >= 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                FeedViewHolderModel feedViewHolderModel2 = baseSocialFeedsAdapter.getItems().get(intValue);
                RelationshipItemModel relationshipItemModel3 = feedViewHolderModel2.getAuthRequestContext;
                if (relationshipItemModel3 != null) {
                    FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
                    String NetworkUserEntityData$$ExternalSyntheticLambda0 = feedModel != null ? feedModel.NetworkUserEntityData$$ExternalSyntheticLambda0() : null;
                    if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
                    }
                    Intrinsics.checkNotNullParameter(NetworkUserEntityData$$ExternalSyntheticLambda0, "");
                    relationshipItemModel3.initRecordTimeStamp = NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
                if (!areEqual && (relationshipItemModel = feedViewHolderModel2.getAuthRequestContext) != null) {
                    FeedModel feedModel2 = feedViewHolderModel.MyBillsEntityDataFactory;
                    if (feedModel2 != null) {
                        HashMap<String, String> hashMap = feedModel2.lookAheadTest;
                        r1 = hashMap != null ? ExtendInfoUtilKt.getHeaderName(hashMap) : null;
                        if (r1 == null) {
                            r1 = "";
                        }
                    }
                    if (r1 == null) {
                        r1 = "";
                    }
                    Intrinsics.checkNotNullParameter(r1, "");
                    relationshipItemModel.scheduleImpl = r1;
                }
                baseSocialFeedsAdapter.notifyItemChanged(intValue);
            }
        }
    }

    public static final /* synthetic */ void access$defineIfIsRequester(SocialProfileActivity socialProfileActivity, boolean z) {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = null;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        FeedViewHolderModel PlaceComponentResult2 = baseSocialFeedsAdapter.PlaceComponentResult();
        if (PlaceComponentResult2 != null) {
            RelationshipItemModel relationshipItemModel = PlaceComponentResult2.getAuthRequestContext;
            if (relationshipItemModel != null) {
                relationshipItemModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
            }
        } else {
            PlaceComponentResult2 = null;
        }
        if (PlaceComponentResult2 != null) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (baseSocialFeedsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                baseSocialFeedsAdapter2 = baseSocialFeedsAdapter3;
            }
            baseSocialFeedsAdapter2.getAuthRequestContext(PlaceComponentResult2);
        }
    }

    public static final /* synthetic */ void access$getFriendStatusIfAddFriendIsEnabled(SocialProfileActivity socialProfileActivity, boolean z, String str, boolean z2) {
        if (!z || z2) {
            return;
        }
        socialProfileActivity.getSocialProfilePresenter().getAuthRequestContext(str);
    }

    public static final /* synthetic */ void access$goToProfileActivity(SocialProfileActivity socialProfileActivity, SettingModel settingModel) {
        Intent intent;
        Boolean bool = (Boolean) socialProfileActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        Intrinsics.checkNotNullExpressionValue(bool, "");
        if (bool.booleanValue()) {
            intent = new Intent(socialProfileActivity, ProfileSettingsActivity.class);
        } else {
            intent = new Intent(socialProfileActivity, SettingMoreProfileActivity.class);
        }
        intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
        socialProfileActivity.startActivity(intent);
    }

    public static final /* synthetic */ void access$hideEmptyState(SocialProfileActivity socialProfileActivity) {
        ConstraintLayout constraintLayout = socialProfileActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
    }

    public static final /* synthetic */ void access$hideEmptyStateNonReciprocal(SocialProfileActivity socialProfileActivity) {
        ConstraintLayout constraintLayout = socialProfileActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
    }

    public static final /* synthetic */ void access$loadUserProfileHeader(SocialProfileActivity socialProfileActivity) {
        RelationshipItemModel relationshipItemModel = socialProfileActivity.lookAheadTest;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = null;
        if (relationshipItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel = null;
        }
        if (!relationshipItemModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
            socialProfileActivity.getSocialProfilePresenter().BuiltInFictitiousFunctionClassFactory();
        }
        FeedModel.Companion companion = FeedModel.INSTANCE;
        RelationshipItemModel relationshipItemModel2 = socialProfileActivity.lookAheadTest;
        if (relationshipItemModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel2 = null;
        }
        FeedViewHolderModel KClassImpl$Data$declaredNonStaticMembers$2 = FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(relationshipItemModel2);
        socialProfileActivity.moveToNextValue.add(KClassImpl$Data$declaredNonStaticMembers$2);
        socialProfileActivity.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (baseSocialFeedsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            baseSocialFeedsAdapter = baseSocialFeedsAdapter2;
        }
        baseSocialFeedsAdapter.setItems(socialProfileActivity.moveToNextValue);
        baseSocialFeedsAdapter.getErrorConfigVersion();
    }

    public static final /* synthetic */ void access$modifyRelationshipCompleted(SocialProfileActivity socialProfileActivity, ModifyRelationOperationType modifyRelationOperationType) {
        int i = WhenMappings.getAuthRequestContext[modifyRelationOperationType.ordinal()];
        RelationshipItemModel relationshipItemModel = null;
        if (i == 1) {
            RelationshipItemModel relationshipItemModel2 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel2 = null;
            }
            Intrinsics.checkNotNullParameter("BLOCKING", "");
            relationshipItemModel2.getErrorConfigVersion = "BLOCKING";
            Object[] objArr = new Object[1];
            RelationshipItemModel relationshipItemModel3 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel3 = null;
            }
            objArr[0] = relationshipItemModel3.scheduleImpl;
            String string = socialProfileActivity.getString(R.string.friendship_block, objArr);
            Intrinsics.checkNotNullExpressionValue(string, "");
            CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
            CustomToast.MyBillsEntityDataFactory(socialProfileActivity, R.drawable.ic_warning_24_yellow50, R.drawable.bg_rounded_border_yellow_50, string);
            socialProfileActivity.KClassImpl$Data$declaredNonStaticMembers$2(new SocialProfileActivity$onRefresh$1(socialProfileActivity));
        } else if (i == 2) {
            RelationshipItemModel relationshipItemModel4 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel4 = null;
            }
            Intrinsics.checkNotNullParameter("ACTIVE", "");
            relationshipItemModel4.getErrorConfigVersion = "ACTIVE";
            Object[] objArr2 = new Object[1];
            RelationshipItemModel relationshipItemModel5 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel5 = null;
            }
            objArr2[0] = relationshipItemModel5.scheduleImpl;
            String string2 = socialProfileActivity.getString(R.string.friendship_unblock, objArr2);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            CustomToast customToast2 = CustomToast.MyBillsEntityDataFactory;
            CustomToast.MyBillsEntityDataFactory(socialProfileActivity, R.drawable.ic_check_24_green50_filled_circle, R.drawable.bg_rounded_border_green_50, string2);
            socialProfileActivity.KClassImpl$Data$declaredNonStaticMembers$2(new SocialProfileActivity$onRefresh$1(socialProfileActivity));
        } else if (i == 3) {
            RelationshipItemModel relationshipItemModel6 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel6 = null;
            }
            Intrinsics.checkNotNullParameter("MUTE", "");
            relationshipItemModel6.getErrorConfigVersion = "MUTE";
            Object[] objArr3 = new Object[1];
            RelationshipItemModel relationshipItemModel7 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel7 = null;
            }
            objArr3[0] = relationshipItemModel7.scheduleImpl;
            String string3 = socialProfileActivity.getString(R.string.friendship_mute, objArr3);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            CustomToast customToast3 = CustomToast.MyBillsEntityDataFactory;
            CustomToast.MyBillsEntityDataFactory(socialProfileActivity, R.drawable.ic_warning_24_yellow50, R.drawable.bg_rounded_border_yellow_50, string3);
        } else if (i == 4) {
            RelationshipItemModel relationshipItemModel8 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel8 = null;
            }
            Intrinsics.checkNotNullParameter("ACTIVE", "");
            relationshipItemModel8.getErrorConfigVersion = "ACTIVE";
            Object[] objArr4 = new Object[1];
            RelationshipItemModel relationshipItemModel9 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                relationshipItemModel9 = null;
            }
            objArr4[0] = relationshipItemModel9.scheduleImpl;
            String string4 = socialProfileActivity.getString(R.string.friendship_unmute, objArr4);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            CustomToast customToast4 = CustomToast.MyBillsEntityDataFactory;
            CustomToast.MyBillsEntityDataFactory(socialProfileActivity, R.drawable.ic_check_24_green50_filled_circle, R.drawable.bg_rounded_border_green_50, string4);
        }
        RelationshipItemModel relationshipItemModel10 = socialProfileActivity.lookAheadTest;
        if (relationshipItemModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            relationshipItemModel = relationshipItemModel10;
        }
        socialProfileActivity.getAuthRequestContext(relationshipItemModel.getErrorConfigVersion);
    }

    public static final /* synthetic */ void access$muteFriend(SocialProfileActivity socialProfileActivity) {
        SocialProfileContract.Presenter socialProfilePresenter = socialProfileActivity.getSocialProfilePresenter();
        RelationshipItemModel relationshipItemModel = socialProfileActivity.lookAheadTest;
        if (relationshipItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel = null;
        }
        socialProfilePresenter.MyBillsEntityDataFactory(relationshipItemModel.GetContactSyncConfig, ModifyRelationOperationType.MUTE);
    }

    public static final /* synthetic */ void access$onTouchBottom(SocialProfileActivity socialProfileActivity) {
        if (socialProfileActivity.BuiltInFictitiousFunctionClassFactory()) {
            socialProfileActivity.BuiltInFictitiousFunctionClassFactory = true;
            RelationshipItemModel relationshipItemModel = null;
            if (socialProfileActivity.getErrorConfigVersion()) {
                BaseSocialFeedsAdapter baseSocialFeedsAdapter = socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (baseSocialFeedsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    baseSocialFeedsAdapter = null;
                }
                baseSocialFeedsAdapter.appendItem(new FeedViewHolderModel(6, null, null, null, null, false, 60, null));
            }
            RelationshipItemModel relationshipItemModel2 = socialProfileActivity.lookAheadTest;
            if (relationshipItemModel2 != null) {
                if (relationshipItemModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    relationshipItemModel = relationshipItemModel2;
                }
                if (relationshipItemModel.GetContactSyncConfig.length() > 0) {
                    socialProfileActivity.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.social.view.activity.SocialProfileActivity$onTouchBottom$2
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
                            RelationshipItemModel relationshipItemModel3;
                            SocialProfileContract.Presenter socialProfilePresenter = SocialProfileActivity.this.getSocialProfilePresenter();
                            relationshipItemModel3 = SocialProfileActivity.this.lookAheadTest;
                            if (relationshipItemModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                relationshipItemModel3 = null;
                            }
                            socialProfilePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0(relationshipItemModel3.GetContactSyncConfig);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    public static final /* synthetic */ void access$redirectCta(SocialProfileActivity socialProfileActivity, ProfileCtaConfig profileCtaConfig, String str, String str2) {
        if (!Intrinsics.areEqual(profileCtaConfig.getKey(), "feature_sendmoneyphone")) {
            socialProfileActivity.getSocialProfilePresenter().PlaceComponentResult(profileCtaConfig.getRedirectUrl());
            return;
        }
        String redirectUrl = profileCtaConfig.getRedirectUrl();
        if (socialProfileActivity.getSocialProfilePresenter().getAuthRequestContext()) {
            FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("?params=[phone_number=");
            sb.append(PhoneNumberUtilKt.replaceIndoRegionDashWithPhonePrefix(str));
            sb.append(",user_id=");
            sb.append(str2);
            sb.append(']');
            socialProfileActivity.getSocialProfilePresenter().PlaceComponentResult(FeedsContentUtils.BuiltInFictitiousFunctionClassFactory(redirectUrl, sb.toString()));
        } else if (socialProfileActivity.isActivityAvailable()) {
            ?? r0 = 0;
            TwoActionWithIconBottomSheetFragment twoActionWithIconBottomSheetFragment = new TwoActionWithIconBottomSheetFragment(r0, new Function0<Unit>() { // from class: id.dana.social.view.activity.SocialProfileActivity$showKycDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("https://m.dana.id");
                    sb2.append(SocialProfileActivity.this.getDynamicUrlWrapper().getKycFromProfileUrl());
                    DanaH5.startContainerFullUrl(sb2.toString());
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, 1, r0);
            Context baseContext = socialProfileActivity.getBaseContext();
            if (baseContext != null) {
                Intrinsics.checkNotNullExpressionValue(baseContext, "");
                twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory = R.drawable.ic_upgrade_to_kyc_bottomsheet;
                AppCompatImageView appCompatImageView = (AppCompatImageView) twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.GetLeaderboardEntryBanner);
                if (appCompatImageView != null) {
                    TwoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView, twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory);
                }
                String string = baseContext.getString(R.string.upgrade_to_dana_premium);
                Intrinsics.checkNotNullExpressionValue(string, "");
                twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory(string);
                String string2 = baseContext.getString(R.string.sendmoney_upgrade_kyc_dialog_description);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                twoActionWithIconBottomSheetFragment.PlaceComponentResult(string2);
                String string3 = baseContext.getString(R.string.sendmoney_upgrade_kyc_dialog_button_positive);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                twoActionWithIconBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(string3);
                String string4 = baseContext.getString(R.string.sendmoney_upgrade_kyc_dialog_button_negative);
                Intrinsics.checkNotNullExpressionValue(string4, "");
                twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(string4);
            }
            FragmentManager supportFragmentManager = socialProfileActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager);
        }
    }

    public static final /* synthetic */ void access$setTitleBasedOnRelationshipStatus(SocialProfileActivity socialProfileActivity, String str, String str2) {
        if (socialProfileActivity.PlaceComponentResult()) {
            if (Intrinsics.areEqual(str, "SELF")) {
                socialProfileActivity.setCenterTitle(str2);
            } else {
                socialProfileActivity.setCenterTitle(socialProfileActivity.getString(R.string.social_profile));
            }
        }
    }

    public static final /* synthetic */ void access$showErrorModifyRelationship(SocialProfileActivity socialProfileActivity) {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        SocialProfileActivity socialProfileActivity2 = socialProfileActivity;
        String string = socialProfileActivity.getString(R.string.modify_relationship_error);
        Intrinsics.checkNotNullExpressionValue(string, "");
        CustomToast.MyBillsEntityDataFactory(socialProfileActivity2, R.drawable.ic_close_red, R.drawable.bg_rounded_border_red_50, string);
    }

    public static final /* synthetic */ void access$showSuccessToast(SocialProfileActivity socialProfileActivity, String str) {
        ConstraintLayout constraintLayout = socialProfileActivity.getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        CustomSnackbar.Builder MyBillsEntityDataFactory = new CustomSnackbar.Builder(constraintLayout).MyBillsEntityDataFactory(SnackbarState.SUCCESS);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_success;
        MyBillsEntityDataFactory.moveToNextValue = 1000;
        MyBillsEntityDataFactory.initRecordTimeStamp = socialProfileActivity.getString(R.string.approve_friend_request_success_message, str);
        SnackbarPosition snackbarPosition = SnackbarPosition.TOP;
        Intrinsics.checkNotNullParameter(snackbarPosition, "");
        MyBillsEntityDataFactory.GetContactSyncConfig = snackbarPosition;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final /* synthetic */ void access$unMuteFriend(SocialProfileActivity socialProfileActivity) {
        SocialProfileContract.Presenter socialProfilePresenter = socialProfileActivity.getSocialProfilePresenter();
        RelationshipItemModel relationshipItemModel = socialProfileActivity.lookAheadTest;
        if (relationshipItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            relationshipItemModel = null;
        }
        socialProfilePresenter.MyBillsEntityDataFactory(relationshipItemModel.GetContactSyncConfig, ModifyRelationOperationType.UNMUTE);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        getBinding().PlaceComponentResult.setPtrHandler(new PtrHandler() { // from class: id.dana.social.view.activity.SocialProfileActivity$initPullToRefreshComponent$1
            @Override // in.srain.cube.views.ptr.PtrHandler
            public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                return true;
            }

            @Override // in.srain.cube.views.ptr.PtrHandler
            public final void onRefreshBegin(PtrFrameLayout p0) {
                boolean moveToNextValue;
                LottieAnimationView lottieAnimationView;
                moveToNextValue = SocialProfileActivity.this.moveToNextValue();
                if (moveToNextValue) {
                    lottieAnimationView = SocialProfileActivity.this.getErrorConfigVersion;
                    if (lottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lottieAnimationView = null;
                    }
                    lottieAnimationView.playAnimation();
                }
                r1.KClassImpl$Data$declaredNonStaticMembers$2(new SocialProfileActivity$onRefresh$1(SocialProfileActivity.this));
            }
        });
        getBinding().PlaceComponentResult.disableWhenHorizontalMove(true);
        LottieAnimationView lottieAnimationView = null;
        getBinding().PlaceComponentResult.setHeaderView(getLayoutInflater().inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
        View findViewById = getBinding().PlaceComponentResult.getHeaderView().findViewById(R.id.lav_loading_animation);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById;
        this.getErrorConfigVersion = lottieAnimationView2;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            lottieAnimationView = lottieAnimationView2;
        }
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.social.view.activity.SocialProfileActivity$initPullToRefreshHeaderView$1
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator p0) {
                ActivitySocialDetailBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                binding = SocialProfileActivity.this.getBinding();
                PtrClassicFrameLayout ptrClassicFrameLayout = binding.PlaceComponentResult;
                SocialProfileActivity socialProfileActivity = SocialProfileActivity.this;
                ptrClassicFrameLayout.refreshComplete();
                socialProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p0) {
                boolean z;
                boolean moveToNextValue;
                LottieAnimationView lottieAnimationView3;
                Intrinsics.checkNotNullParameter(p0, "");
                z = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (z) {
                    moveToNextValue = SocialProfileActivity.this.moveToNextValue();
                    if (moveToNextValue) {
                        lottieAnimationView3 = SocialProfileActivity.this.getErrorConfigVersion;
                        if (lottieAnimationView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            lottieAnimationView3 = null;
                        }
                        lottieAnimationView3.cancelAnimation();
                    }
                }
            }
        });
        getBinding().MyBillsEntityDataFactory.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.social.view.activity.SocialProfileActivity$initScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
                ActivitySocialDetailBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                NetworkUserEntityData$$ExternalSyntheticLambda0 = SocialProfileActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                SocialProfileActivity socialProfileActivity = SocialProfileActivity.this;
                boolean z = p2 < 0 && !NetworkUserEntityData$$ExternalSyntheticLambda0;
                socialProfileActivity.getBinding().getAuthRequestContext.getAuthRequestContext.setVisibility(r1 ? 0 : 8);
                binding = SocialProfileActivity.this.getBinding();
                binding.PlaceComponentResult.setEnabled(NetworkUserEntityData$$ExternalSyntheticLambda0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrollStateChanged(p0, p1);
                if (p0.canScrollVertically(130) || !SocialProfileActivity.this.getSocialProfilePresenter().getIsLayoutRequested()) {
                    return;
                }
                SocialProfileActivity.access$onTouchBottom(SocialProfileActivity.this);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.activity.SocialProfileActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SocialProfileActivity.m2967$r8$lambda$uN4n8NkTzsheOnzpVujbJ6SZ5s(SocialProfileActivity.this, view);
            }
        });
        getBinding().getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.activity.SocialProfileActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SocialProfileActivity.$r8$lambda$dYiThaHRBcjLOaswPaawJI2ppX8(SocialProfileActivity.this, view);
            }
        });
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda4 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (NetworkUserEntityData$$ExternalSyntheticLambda4 ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
