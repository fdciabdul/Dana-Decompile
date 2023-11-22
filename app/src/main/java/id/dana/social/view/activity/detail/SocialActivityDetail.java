package id.dana.social.view.activity.detail;

import android.animation.Animator;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customsnackbarcomponent.SnackbarPosition;
import id.dana.component.customsnackbarcomponent.SnackbarState;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.databinding.ActivityCommentDetailBinding;
import id.dana.di.modules.OauthModule;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.social.model.FeedConfig;
import id.dana.extension.view.ActivityExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import id.dana.feeds.ui.model.AddActivityCommentModel;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.state.FeedCommentModelState;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog;
import id.dana.social.common.FeedInputCommentListener;
import id.dana.social.contract.FeedCommentContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.FeedCommentModule;
import id.dana.social.mapper.FeedViewModelMapperKt;
import id.dana.social.model.FeedCommentResultModel;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.utils.FeedsContentAction;
import id.dana.social.v2.view.ActivityFeedView;
import id.dana.social.view.AppBarStateChangeListener;
import id.dana.social.view.BubbleFeedView;
import id.dana.social.view.CommentListInteraction;
import id.dana.social.view.CommentListView;
import id.dana.social.view.FeedCommentView;
import id.dana.social.view.FeedsView;
import id.dana.social.view.ReactionSectionView;
import id.dana.social.view.activity.SocialProfileActivity;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import id.dana.utils.RandomInteger;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002TSB\u0007¢\u0006\u0004\bR\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\r\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0018\u0010\u0005J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010\u0015\u001a\u00020\b8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b)\u0010\u0017R\u0016\u0010\u000b\u001a\u00020<8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b=\u0010>R\u0013\u0010A\u001a\u00020?X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b@\u0010;R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bP\u00109R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bQ\u0010G"}, d2 = {"Lid/dana/social/view/activity/detail/SocialActivityDetail;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityCommentDetailBinding;", "", "configToolbar", "()V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "BuiltInFictitiousFunctionClassFactory", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "initComponent", "initViewBinding", "()Lid/dana/databinding/ActivityCommentDetailBinding;", "Lid/dana/social/model/FeedModel;", "p0", "PlaceComponentResult", "(Lid/dana/social/model/FeedModel;)Z", "()Z", "onDestroy", "getAuthRequestContext", "(Lid/dana/social/model/FeedModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(I)Z", "MyBillsEntityDataFactory", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "Lid/dana/social/contract/FeedCommentContract$Presenter;", "feedCommentPresenter", "Lid/dana/social/contract/FeedCommentContract$Presenter;", "getFeedCommentPresenter", "()Lid/dana/social/contract/FeedCommentContract$Presenter;", "setFeedCommentPresenter", "(Lid/dana/social/contract/FeedCommentContract$Presenter;)V", "GetContactSyncConfig", "Lid/dana/social/model/FeedModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/utils/FeedsContentAction;", "feedsContentAction", "Lid/dana/social/utils/FeedsContentAction;", "getFeedsContentAction", "()Lid/dana/social/utils/FeedsContentAction;", "setFeedsContentAction", "(Lid/dana/social/utils/FeedsContentAction;)V", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "initRecordTimeStamp", "Lkotlin/Lazy;", "Lcom/airbnb/lottie/LottieAnimationView;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lcom/airbnb/lottie/LottieAnimationView;", "Lid/dana/social/bottomsheet/ReportFeedCommentsBottomSheetDialog;", "DatabaseTableConfigUtil", "getErrorConfigVersion", "Lid/dana/feeds/ui/model/FeedCommentModel;", "isLayoutRequested", "Lid/dana/feeds/ui/model/FeedCommentModel;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda8", "I", "", "PrepareContext", "Ljava/lang/String;", "moveToNextValue", "Lid/dana/social/view/activity/detail/SocialActivityDetail$socialFeedClickListener$1;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/social/view/activity/detail/SocialActivityDetail$socialFeedClickListener$1;", "scheduleImpl", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda4", "<init>", "Companion", "ActivityDetailErrorType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SocialActivityDetail extends ViewBindingActivity<ActivityCommentDetailBinding> {
    public static final String BUNDLE_FEED_DATA = "bundle_feed_data";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String FEED_REVAMP = "feed_revamp";
    private static boolean FragmentBottomSheetPaymentSettingBinding = false;
    public static final String IS_REPLY_COMMENT_ENABLED = "is_reply_comment_enabled";
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
    public static final String SOURCE = "Activity Detail";
    private static final int lookAheadTest;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private FeedModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private LottieAnimationView BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private int DatabaseTableConfigUtil;
    @Inject
    public FeedCommentContract.Presenter feedCommentPresenter;
    @Inject
    public FeedsContentAction feedsContentAction;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private FeedCommentModel lookAheadTest;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;
    public static final byte[] $$a = {94, Ascii.EM, -44, 73, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 191;
    public static final byte[] PlaceComponentResult = {4, -41, 37, 5, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 206;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<ReportFeedCommentsBottomSheetDialog>() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$reportFeedCommentsBottomSheetDialog$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReportFeedCommentsBottomSheetDialog invoke() {
            return new ReportFeedCommentsBottomSheetDialog();
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private ActivityReactionsUserModel MyBillsEntityDataFactory = new ActivityReactionsUserModel(null, null, null, null, null, null, null, 127, null);

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private String moveToNextValue = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final SocialActivityDetail$socialFeedClickListener$1 scheduleImpl = new SocialActivityDetail$socialFeedClickListener$1(this);

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$isFeedRevamp$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(SocialActivityDetail.this.getDanaApplication().isFeedRevamp());
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/social/view/activity/detail/SocialActivityDetail$ActivityDetailErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "FETCH_COMMENT", "REPORT_COMMENT", "DELETE_COMMENT"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum ActivityDetailErrorType {
        FETCH_COMMENT,
        REPORT_COMMENT,
        DELETE_COMMENT
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[SnackbarState.values().length];
            iArr[SnackbarState.SUCCESS.ordinal()] = 1;
            iArr[SnackbarState.FAIL.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0028 -> B:35:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.social.view.activity.detail.SocialActivityDetail.PlaceComponentResult
            int r6 = 55 - r6
            int r7 = r7 + 16
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r8 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r7
            goto L36
        L16:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r6 = r6 + r7
            int r6 = r6 + (-4)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.detail.SocialActivityDetail.a(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0027 -> B:35:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 46 - r7
            byte[] r0 = id.dana.social.view.activity.detail.SocialActivityDetail.$$a
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r1 = new byte[r8]
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
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.detail.SocialActivityDetail.c(int, byte, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        NetworkUserEntityData$$ExternalSyntheticLambda3 = new char[]{39817, 39930, 39812, 39926, 39931, 39809, 39866, 39928, 39849, 39815, 39924, 39922, 39921, 39828, 39808, 39813, 39925, 39932, 39927, 39832, 39933, 39829, 39859, 39858, 39856, 39864, 39857, 39810, 39862, 39865, 39863, 39860, 39814, 39861, 39854, 39867, 39811, 39929};
        NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        FragmentBottomSheetPaymentSettingBinding = true;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = 909155176;
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
        b(null, 127 - View.resolveSize(0, 0), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(null, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 127, new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(null, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 127, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(null, 127 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(null, KeyEvent.normalizeMetaState(0) + 127, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(null, 127 - (ViewConfiguration.getLongPressTimeout() >> 16), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(null, TextUtils.indexOf((CharSequence) "", '0', 0) + 128, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, View.MeasureSpec.getSize(0) + 18, (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(PlaceComponentResult[31], PlaceComponentResult[25], PlaceComponentResult[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult[34] + 1);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                a(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 56, 3 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[53], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionGroup(0L), 15 - KeyEvent.normalizeMetaState(0), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 800, (ViewConfiguration.getJumpTapTimeout() >> 16) + 15, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 815, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 28, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 800, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 14, (char) Color.red(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {120646692, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, View.MeasureSpec.getMode(0) + 18, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[31], PlaceComponentResult[25], PlaceComponentResult[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (PlaceComponentResult[34] + 1);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                a(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(62 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 46 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) TextUtils.getOffsetBefore("", 0));
                        Object[] objArr22 = new Object[1];
                        c($$a[9], $$a[84], $$a[8], objArr22);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {120646692, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, MotionEvent.axisFromString("") + 19, (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[31], PlaceComponentResult[25], PlaceComponentResult[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (PlaceComponentResult[34] + 1);
                byte b6 = PlaceComponentResult[25];
                Object[] objArr26 = new Object[1];
                a(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 3, (char) (38968 - Color.green(0)));
                        Object[] objArr28 = new Object[1];
                        c($$a[9], $$a[84], $$a[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {120646692, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, 18 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[31], PlaceComponentResult[25], PlaceComponentResult[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (PlaceComponentResult[34] + 1);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr32 = new Object[1];
                a(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 106, Gravity.getAbsoluteGravity(0, 0) + 3, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        byte b9 = (byte) ($$a[78] - 1);
                        byte b10 = b9;
                        Object[] objArr34 = new Object[1];
                        c(b9, b10, b10, objArr34);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {120646692, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, TextUtils.indexOf("", "", 0) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_comment_detail;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        b(null, super.getResources().getString(R.string.smartpay_toolbar_title).substring(0, 8).length() + 119, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        b(null, 127 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new byte[]{-125, -122, -106, -115, -107}, null, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                b(null, 127 - (ViewConfiguration.getScrollBarSize() >> 8), new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(null, View.resolveSizeAndState(0, 0, 0) + 127, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = new Object[1];
                        a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        a(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), objArr6);
                        Object[] objArr7 = new Object[1];
                        b(null, ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        b(null, getPackageName().length() + 120, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(null, super.getResources().getString(R.string.information_failed_inquiry_balance).substring(45, 47).length() + 125, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(null, getPackageName().length() + 120, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(null, 127 - (ViewConfiguration.getKeyRepeatDelay() >> 16), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, Gravity.getAbsoluteGravity(0, 0) + 18, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            Object[] objArr13 = new Object[1];
            a(PlaceComponentResult[31], PlaceComponentResult[25], PlaceComponentResult[32], objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            byte b = (byte) (PlaceComponentResult[34] + 1);
            byte b2 = PlaceComponentResult[25];
            Object[] objArr14 = new Object[1];
            a(b, b2, (byte) (b2 | 8), objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 494, (ViewConfiguration.getScrollBarSize() >> 8) + 4, (char) (Process.myPid() >> 22));
                    byte b3 = (byte) ($$a[78] - 1);
                    byte b4 = b3;
                    Object[] objArr16 = new Object[1];
                    c(b3, b4, b4, objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr18 = {1176669493, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                super.onCreate(bundle);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), objArr2);
                Object[] objArr3 = new Object[1];
                b(null, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(null, super.getResources().getString(R.string.selection_split_bill_payer_title).substring(2, 3).length() + 126, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(null, getPackageName().length() + 120, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), objArr3);
                Object[] objArr4 = new Object[1];
                b(null, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), 18 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @JvmName(name = "getFeedCommentPresenter")
    public final FeedCommentContract.Presenter getFeedCommentPresenter() {
        FeedCommentContract.Presenter presenter = this.feedCommentPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFeedCommentPresenter")
    public final void setFeedCommentPresenter(FeedCommentContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.feedCommentPresenter = presenter;
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

    @JvmName(name = "getFeedsContentAction")
    public final FeedsContentAction getFeedsContentAction() {
        FeedsContentAction feedsContentAction = this.feedsContentAction;
        if (feedsContentAction != null) {
            return feedsContentAction;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFeedsContentAction")
    public final void setFeedsContentAction(FeedsContentAction feedsContentAction) {
        Intrinsics.checkNotNullParameter(feedsContentAction, "");
        this.feedsContentAction = feedsContentAction;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return ((Boolean) this.PlaceComponentResult.getValue()).booleanValue();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityCommentDetailBinding initViewBinding() {
        ActivityCommentDetailBinding BuiltInFictitiousFunctionClassFactory = ActivityCommentDetailBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.feed_detail_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        CommentListView commentListView = getBinding().MyBillsEntityDataFactory;
        commentListView.setCommentListInteraction(new CommentListInteraction() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$setupCommentList$1$1
            @Override // id.dana.social.view.CommentListInteraction
            public final boolean PlaceComponentResult() {
                FeedModel feedModel;
                feedModel = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (feedModel != null) {
                    return feedModel.getInitRecordTimeStamp();
                }
                return false;
            }

            @Override // id.dana.social.view.CommentListInteraction
            public final void PlaceComponentResult(RelationshipItemModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SocialActivityDetail.access$openProfileActivity(SocialActivityDetail.this, p0);
            }

            @Override // id.dana.social.view.CommentListInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedCommentModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SocialActivityDetail.this.getFeedCommentPresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0.BuiltInFictitiousFunctionClassFactory);
            }

            @Override // id.dana.social.view.CommentListInteraction
            public final boolean MyBillsEntityDataFactory() {
                return SocialActivityDetail.this.getFeedCommentPresenter().PlaceComponentResult();
            }

            @Override // id.dana.social.view.CommentListInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                FeedModel feedModel;
                FeedCommentContract.Presenter feedCommentPresenter = SocialActivityDetail.this.getFeedCommentPresenter();
                feedModel = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String str = feedModel != null ? feedModel.BuiltInFictitiousFunctionClassFactory : null;
                if (str == null) {
                    str = "";
                }
                feedCommentPresenter.MyBillsEntityDataFactory(str);
            }

            @Override // id.dana.social.view.CommentListInteraction
            public final void MyBillsEntityDataFactory(FeedCommentModel p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                SocialActivityDetail.this.lookAheadTest = p0;
                SocialActivityDetail.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p1;
                SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                SocialActivityDetail.access$openReportCommentBottomSheet(socialActivityDetail, SocialActivityDetail.access$getReportFeedCommentsBottomSheetDialog(socialActivityDetail));
            }

            @Override // id.dana.social.view.CommentListInteraction
            public final void PlaceComponentResult(FeedCommentModel p0) {
                FeedModel feedModel;
                Intrinsics.checkNotNullParameter(p0, "");
                FeedCommentContract.Presenter feedCommentPresenter = SocialActivityDetail.this.getFeedCommentPresenter();
                feedModel = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String str = feedModel != null ? feedModel.BuiltInFictitiousFunctionClassFactory : null;
                feedCommentPresenter.BuiltInFictitiousFunctionClassFactory(p0, str != null ? str : "");
            }

            @Override // id.dana.social.view.CommentListInteraction
            public final void getAuthRequestContext(FeedCommentModel p0) {
                ActivityCommentDetailBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                binding = SocialActivityDetail.this.getBinding();
                binding.PlaceComponentResult.setReplyComment(p0);
            }

            @Override // id.dana.social.view.CommentListInteraction
            public final void getAuthRequestContext(String p0) {
                FeedModel feedModel;
                Intrinsics.checkNotNullParameter(p0, "");
                FeedCommentContract.Presenter feedCommentPresenter = SocialActivityDetail.this.getFeedCommentPresenter();
                feedModel = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String str = feedModel != null ? feedModel.BuiltInFictitiousFunctionClassFactory : null;
                feedCommentPresenter.getAuthRequestContext(str != null ? str : "", p0);
            }
        });
        commentListView.setFeedRevamp(KClassImpl$Data$declaredNonStaticMembers$2());
        Intent intent = getIntent();
        commentListView.setReplyCommentEnabled(intent != null ? intent.getBooleanExtra(IS_REPLY_COMMENT_ENABLED, false) : false);
        commentListView.setupFeedCommentList();
        commentListView.showShimmer();
        FeedCommentContract.Presenter feedCommentPresenter = getFeedCommentPresenter();
        FeedModel feedModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = feedModel != null ? feedModel.BuiltInFictitiousFunctionClassFactory : null;
        if (str == null) {
            str = "";
        }
        feedCommentPresenter.MyBillsEntityDataFactory(str);
    }

    public final boolean PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory != null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent event) {
        boolean z = false;
        if (event != null && event.getAction() == 0) {
            z = true;
        }
        if (z) {
            View currentFocus = getCurrentFocus();
            if (currentFocus instanceof EditText) {
                Rect rect = new Rect();
                getBinding().PlaceComponentResult.getGlobalVisibleRect(rect);
                if (!rect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    ActivityExtKt.MyBillsEntityDataFactory(this, currentFocus);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public final void initComponent() {
        SocialCommonComponent socialCommonComponent = getDanaApplication().getSocialCommonComponent();
        byte b = 0;
        if (socialCommonComponent != null) {
            FeedCommentModule feedCommentModule = new FeedCommentModule(new FeedCommentContract.View() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$initComponent$1$1

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                /* loaded from: classes5.dex */
                public final /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

                    static {
                        int[] iArr = new int[SocialActivityDetail.ActivityDetailErrorType.values().length];
                        iArr[SocialActivityDetail.ActivityDetailErrorType.REPORT_COMMENT.ordinal()] = 1;
                        iArr[SocialActivityDetail.ActivityDetailErrorType.DELETE_COMMENT.ordinal()] = 2;
                        iArr[SocialActivityDetail.ActivityDetailErrorType.FETCH_COMMENT.ordinal()] = 3;
                        KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
                    }
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final String MyBillsEntityDataFactory() {
                    return SocialActivityDetail.SOURCE;
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

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void PlaceComponentResult(FeedCommentModel p0, AddActivityCommentModel p1) {
                    ActivityCommentDetailBinding binding;
                    FeedModel feedModel;
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                    binding = SocialActivityDetail.this.getBinding();
                    CommentListView commentListView = binding.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(commentListView, "");
                    CommentListView.updateCommentState$default(commentListView, p0, p1, false, 4, null);
                    feedModel = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (feedModel != null) {
                        SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                        feedModel.getAuthRequestContext++;
                        ActivityFeedView activityFeedView = (ActivityFeedView) socialActivityDetail._$_findCachedViewById(R.id.newFeedViewDetail);
                        if (activityFeedView != null) {
                            activityFeedView.updateCommentCount(feedModel);
                        }
                    }
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void BuiltInFictitiousFunctionClassFactory(FeedCommentModel p0) {
                    ActivityCommentDetailBinding binding;
                    Intrinsics.checkNotNullParameter(p0, "");
                    binding = SocialActivityDetail.this.getBinding();
                    CommentListView commentListView = binding.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(commentListView, "");
                    CommentListView.updateCommentState$default(commentListView, p0, null, false, 6, null);
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void PlaceComponentResult() {
                    FeedModel feedModel;
                    SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                    String string = socialActivityDetail.getString(R.string.feed_comment_delete_success);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    SocialActivityDetail.access$showToast(socialActivityDetail, string, SnackbarState.SUCCESS);
                    feedModel = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (feedModel != null) {
                        feedModel.getAuthRequestContext--;
                        ActivityFeedView activityFeedView = (ActivityFeedView) SocialActivityDetail.this._$_findCachedViewById(R.id.newFeedViewDetail);
                        if (activityFeedView != null) {
                            activityFeedView.updateCommentCount(feedModel);
                        }
                    }
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                    String string = socialActivityDetail.getString(R.string.feed_comment_report_failed_toast_message);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    SocialActivityDetail.access$showToast(socialActivityDetail, string, SnackbarState.FAIL);
                    SocialActivityDetail socialActivityDetail2 = SocialActivityDetail.this;
                    String string2 = socialActivityDetail2.getString(R.string.feed_comment_report_failed_toast_message);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    socialActivityDetail2.moveToNextValue = string2;
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    FeedModel feedModel;
                    feedModel = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (feedModel != null) {
                        SocialActivityDetail.this.MyBillsEntityDataFactory(feedModel);
                    }
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void MyBillsEntityDataFactory(FeedCommentResultModel p0) {
                    ActivityCommentDetailBinding binding;
                    Bundle extras;
                    ActivityCommentDetailBinding binding2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    binding = SocialActivityDetail.this.getBinding();
                    binding.MyBillsEntityDataFactory.onGetFeedComment(p0);
                    SocialActivityDetail.this.GetContactSyncConfig = true;
                    Intent intent = SocialActivityDetail.this.getIntent();
                    if (intent == null || (extras = intent.getExtras()) == null) {
                        return;
                    }
                    binding2 = SocialActivityDetail.this.getBinding();
                    CommentListView commentListView = binding2.MyBillsEntityDataFactory;
                    String string = extras.getString("commentID");
                    commentListView.showDim(string != null ? string : "");
                    extras.remove("commentID");
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0) {
                    ActivityCommentDetailBinding binding;
                    Intrinsics.checkNotNullParameter(p0, "");
                    binding = SocialActivityDetail.this.getBinding();
                    binding.MyBillsEntityDataFactory.onErrorGetFeedComment();
                    SocialActivityDetail.this.GetContactSyncConfig = true;
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
                    FeedCommentModel feedCommentModel;
                    ActivityCommentDetailBinding binding;
                    int i;
                    FeedModel feedModel;
                    FeedCommentModel feedCommentModel2;
                    ActivityCommentDetailBinding binding2;
                    int i2;
                    feedCommentModel = SocialActivityDetail.this.lookAheadTest;
                    boolean z = false;
                    if (feedCommentModel != null && feedCommentModel.MyBillsEntityDataFactory()) {
                        z = true;
                    }
                    if (z) {
                        feedCommentModel2 = SocialActivityDetail.this.lookAheadTest;
                        if (feedCommentModel2 != null) {
                            SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                            binding2 = socialActivityDetail.getBinding();
                            CommentListView commentListView = binding2.MyBillsEntityDataFactory;
                            i2 = socialActivityDetail.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            commentListView.deleteReply(feedCommentModel2, i2);
                        }
                    } else {
                        binding = SocialActivityDetail.this.getBinding();
                        CommentListView commentListView2 = binding.MyBillsEntityDataFactory;
                        i = SocialActivityDetail.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        commentListView2.deleteComment(i);
                    }
                    SocialActivityDetail.access$getReportFeedCommentsBottomSheetDialog(SocialActivityDetail.this).dismiss();
                    SocialActivityDetail socialActivityDetail2 = SocialActivityDetail.this;
                    String string = socialActivityDetail2.getString(R.string.feed_comment_report_success_toast_message);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    SocialActivityDetail.access$showToast(socialActivityDetail2, string, SnackbarState.SUCCESS);
                    feedModel = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (feedModel != null) {
                        SocialActivityDetail socialActivityDetail3 = SocialActivityDetail.this;
                        feedModel.getAuthRequestContext++;
                        ActivityFeedView activityFeedView = (ActivityFeedView) socialActivityDetail3._$_findCachedViewById(R.id.newFeedViewDetail);
                        if (activityFeedView != null) {
                            activityFeedView.updateCommentCount(feedModel);
                        }
                    }
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void getAuthRequestContext() {
                    SocialActivityDetail.this.lookAheadTest = null;
                    SocialActivityDetail.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
                    SocialActivityDetail.access$getReportFeedCommentsBottomSheetDialog(SocialActivityDetail.this).dismiss();
                    SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                    String string = socialActivityDetail.getString(R.string.feed_comment_report_failed_toast_message);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    SocialActivityDetail.access$showToast(socialActivityDetail, string, SnackbarState.FAIL);
                    SocialActivityDetail socialActivityDetail2 = SocialActivityDetail.this;
                    String string2 = socialActivityDetail2.getString(R.string.feed_comment_report_failed_toast_message);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    socialActivityDetail2.moveToNextValue = string2;
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void MyBillsEntityDataFactory(ActivityReactionsUserModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialActivityDetail.this.MyBillsEntityDataFactory = p0;
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void PlaceComponentResult(FeedConfig p0) {
                    ActivityCommentDetailBinding binding;
                    boolean authRequestContext;
                    Intrinsics.checkNotNullParameter(p0, "");
                    binding = SocialActivityDetail.this.getBinding();
                    FeedsView feedsView = binding.lookAheadTest;
                    authRequestContext = SocialActivityDetail.this.getAuthRequestContext(p0.getFeedVersion());
                    feedsView.setShowCaptionSection(authRequestContext);
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final String KClassImpl$Data$declaredNonStaticMembers$2(SocialActivityDetail.ActivityDetailErrorType p0) {
                    String str;
                    ActivityCommentDetailBinding binding;
                    Intrinsics.checkNotNullParameter(p0, "");
                    int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
                    if (i != 1 && i != 2) {
                        if (i == 3) {
                            binding = SocialActivityDetail.this.getBinding();
                            return binding.MyBillsEntityDataFactory.getErrorMessageWhenEmpty();
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str = SocialActivityDetail.this.moveToNextValue;
                    if (!(str.length() > 0)) {
                        str = null;
                    }
                    SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                    if (str == null) {
                        str = "";
                    }
                    socialActivityDetail.moveToNextValue = "";
                    return str;
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final String BuiltInFictitiousFunctionClassFactory(boolean p0) {
                    SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                    FeedCommentView.Companion companion = FeedCommentView.INSTANCE;
                    String string = socialActivityDetail.getString(FeedCommentView.Companion.BuiltInFictitiousFunctionClassFactory(p0));
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    return string;
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void BuiltInFictitiousFunctionClassFactory(List<FeedCommentModel> p0, int p1) {
                    ActivityCommentDetailBinding binding;
                    Intrinsics.checkNotNullParameter(p0, "");
                    binding = SocialActivityDetail.this.getBinding();
                    binding.MyBillsEntityDataFactory.onGetFeedSubComment(p0, p1);
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void PlaceComponentResult(Throwable p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                    String string = socialActivityDetail.getString(R.string.feed_comment_fetch_subcomment_error_message);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    SocialActivityDetail.access$showToast(socialActivityDetail, string, SnackbarState.FAIL);
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void MyBillsEntityDataFactory(String p0, int p1) {
                    ActivityCommentDetailBinding binding;
                    Intrinsics.checkNotNullParameter(p0, "");
                    binding = SocialActivityDetail.this.getBinding();
                    binding.MyBillsEntityDataFactory.adjustReplyCount(p0, p1);
                }

                @Override // id.dana.social.contract.FeedCommentContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedViewHolderModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FeedModel feedModel = p0.MyBillsEntityDataFactory;
                    if (feedModel != null) {
                        SocialActivityDetail.this.MyBillsEntityDataFactory(feedModel);
                    }
                    SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2 = p0.MyBillsEntityDataFactory;
                }
            });
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            SocialActivityDetail socialActivityDetail = this;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = socialActivityDetail;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = FeedsSourceType.FRIENDSHIP_FRIENDS_FEED;
            DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b);
            Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = socialActivityDetail;
            ScanQrModule scanQrModule = new ScanQrModule(authRequestContext, b);
            Intrinsics.checkNotNullExpressionValue(scanQrModule, "");
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = socialActivityDetail;
            RestoreUrlModule restoreUrlModule = new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b);
            Intrinsics.checkNotNullExpressionValue(restoreUrlModule, "");
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = socialActivityDetail;
            FeatureModule featureModule = new FeatureModule(MyBillsEntityDataFactory, b);
            Intrinsics.checkNotNullExpressionValue(featureModule, "");
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = socialActivityDetail;
            OauthModule oauthModule = new OauthModule(BuiltInFictitiousFunctionClassFactory, b);
            Intrinsics.checkNotNullExpressionValue(oauthModule, "");
            socialCommonComponent.PlaceComponentResult(feedCommentModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$initComponent$1$2
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
        registerPresenter(getFeedCommentPresenter());
    }

    public final boolean getAuthRequestContext(int p0) {
        if (p0 > 3) {
            FeedModel feedModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return feedModel != null ? feedModel.getErrorConfigVersion() : false;
        }
        return false;
    }

    public final void MyBillsEntityDataFactory(FeedModel p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            getAuthRequestContext(p0);
            return;
        }
        FeedsView feedsView = getBinding().lookAheadTest;
        feedsView.setProfileAvatar(ExtendInfoUtilKt.getAvatar(p0.NetworkUserEntityData$$ExternalSyntheticLambda2, 9, p0.lookAheadTest));
        FeedModel.Companion companion = FeedModel.INSTANCE;
        Context context = feedsView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        feedsView.setDesc(FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, p0, this.scheduleImpl));
        feedsView.setCaption(p0.MyBillsEntityDataFactory);
        feedsView.setDate(p0.moveToNextValue);
        feedsView.setReactionVisibility(false);
        feedsView.setShowCommentButton(false);
        BubbleFeedView bubbleFeedView = (BubbleFeedView) feedsView._$_findCachedViewById(R.id.view_bubble_feed);
        if (bubbleFeedView != null) {
            bubbleFeedView.setDescriptionConstraint(false);
        }
        ReactionSectionView reactionSectionView = getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(reactionSectionView, "");
        ReactionSectionView.setReactionsContentView$default(reactionSectionView, p0, 0, 2, null);
        reactionSectionView.setupDetailActivityView(p0);
        CircleImageView circleImageView = (CircleImageView) getBinding().lookAheadTest._$_findCachedViewById(R.id.civ_profile_avatar);
        if (circleImageView != null) {
            circleImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SocialActivityDetail.$r8$lambda$dxqPJjBc0iil2ibOWNHapah5o3A(SocialActivityDetail.this, view);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0051, code lost:
    
        if (r3 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0053, code lost:
    
        r3 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x005f, code lost:
    
        if (r3 == null) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(id.dana.social.model.FeedModel r8) {
        /*
            r7 = this;
            androidx.viewbinding.ViewBinding r0 = r7.getBinding()
            id.dana.databinding.ActivityCommentDetailBinding r0 = (id.dana.databinding.ActivityCommentDetailBinding) r0
            id.dana.social.v2.view.ActivityFeedView r0 = r0.NetworkUserEntityData$$ExternalSyntheticLambda0
            r1 = 1
            r0.setShowAddSaymojiIcon(r1)
            r2 = 0
            r0.setShowAddCommentIcon(r2)
            r0.setShowLatestComment(r2)
            java.lang.String r3 = r8.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r8.lookAheadTest
            r5 = 9
            java.lang.String r3 = id.dana.domain.social.ExtendInfoUtilKt.getAvatar(r3, r5, r4)
            r0.setAvatar(r3)
            id.dana.social.utils.FeedsContentUtils r3 = id.dana.social.utils.FeedsContentUtils.MyBillsEntityDataFactory
            android.content.Context r3 = r0.getContext()
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            id.dana.social.view.activity.detail.SocialActivityDetail$socialFeedClickListener$1 r5 = r7.scheduleImpl
            id.dana.social.adapter.SocialFeedClickListener r5 = (id.dana.social.adapter.SocialFeedClickListener) r5
            id.dana.social.utils.FeedRegexData r3 = id.dana.social.utils.FeedsContentUtils.PlaceComponentResult(r8, r3, r5)
            r0.setContent(r3)
            boolean r3 = r8.getInitRecordTimeStamp()
            r5 = 0
            if (r3 != 0) goto L55
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r8.lookAheadTest
            if (r3 == 0) goto L47
            java.lang.String r3 = id.dana.domain.social.ExtendInfoUtilKt.getHeaderName(r3)
            if (r3 != 0) goto L62
        L47:
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r8.lookAheadTest
            if (r3 == 0) goto L50
            java.lang.String r3 = id.dana.domain.social.ExtendInfoUtilKt.getNickName(r3)
            goto L51
        L50:
            r3 = r5
        L51:
            if (r3 != 0) goto L62
        L53:
            r3 = r4
            goto L62
        L55:
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r8.lookAheadTest
            if (r3 == 0) goto L5e
            java.lang.String r3 = id.dana.domain.social.ExtendInfoUtilKt.getNickName(r3)
            goto L5f
        L5e:
            r3 = r5
        L5f:
            if (r3 != 0) goto L62
            goto L53
        L62:
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r8.lookAheadTest
            if (r6 == 0) goto L6a
            java.lang.String r5 = id.dana.domain.social.ExtendInfoUtilKt.getUsername(r6)
        L6a:
            if (r5 != 0) goto L6d
            r5 = r4
        L6d:
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 > 0) goto L77
            r1 = 0
        L77:
            if (r1 == 0) goto L8a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 64
            r1.append(r2)
            r1.append(r5)
            java.lang.String r4 = r1.toString()
        L8a:
            r0.setName(r3, r4)
            r0.setContent(r8)
            id.dana.social.view.activity.detail.SocialActivityDetail$setFeedDataOnNewActivityView$1$2 r8 = new id.dana.social.view.activity.detail.SocialActivityDetail$setFeedDataOnNewActivityView$1$2
            r8.<init>()
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r0.setAvatarClickAction(r8)
            id.dana.social.view.activity.detail.SocialActivityDetail$setFeedDataOnNewActivityView$1$3 r8 = new id.dana.social.view.activity.detail.SocialActivityDetail$setFeedDataOnNewActivityView$1$3
            id.dana.social.view.activity.detail.SocialActivityDetail$socialFeedClickListener$1 r1 = r7.scheduleImpl
            r8.<init>(r1)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r0.setOnActivityWidgetClicked(r8)
            id.dana.social.view.activity.detail.SocialActivityDetail$setFeedDataOnNewActivityView$1$4 r8 = new id.dana.social.view.activity.detail.SocialActivityDetail$setFeedDataOnNewActivityView$1$4
            id.dana.social.view.activity.detail.SocialActivityDetail$socialFeedClickListener$1 r1 = r7.scheduleImpl
            r8.<init>(r1)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0.setOnUniqueDealsWidgetClicked(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.detail.SocialActivityDetail.getAuthRequestContext(id.dana.social.model.FeedModel):void");
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        String str;
        FeedModel feedModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (feedModel == null || (str = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
            str = "";
        }
        getFeedCommentPresenter().getAuthRequestContext(CollectionsKt.listOf(str));
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        FeedsContentAction feedsContentAction = getFeedsContentAction();
        feedsContentAction.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        feedsContentAction.scheduleImpl.get().dispose();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015JH\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lid/dana/social/view/activity/detail/SocialActivityDetail$Companion;", "", "()V", "ACTIVITY_DETAIL_REQUEST_CODE", "", "getACTIVITY_DETAIL_REQUEST_CODE", "()I", "BUNDLE_FEED_DATA", "", "BUNDLE_FROM_DEEPLINK_OR_NOTIF", "FEED_REVAMP", "FEED_VERSION", "IS_REPLY_COMMENT_ENABLED", "SOURCE", "openSocialFeedDetailActivity", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "data", "Lid/dana/social/model/FeedModel;", "isReplyCommentEnabled", "", "Landroid/content/Intent;", "source", "commentId", "fromDeeplinkOrNotif", "feedRevampEnabled", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, FeedModel feedModel, boolean z) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(feedModel, "");
            Intent intent = new Intent(context, SocialActivityDetail.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra(SocialActivityDetail.BUNDLE_FEED_DATA, feedModel);
            intent.putExtra(SocialActivityDetail.IS_REPLY_COMMENT_ENABLED, z);
            context.startActivity(intent);
        }

        public static Intent MyBillsEntityDataFactory(Context context, FeedModel feedModel, String str, String str2, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(feedModel, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intent intent = new Intent(context, SocialActivityDetail.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra(SocialActivityDetail.BUNDLE_FEED_DATA, feedModel);
            intent.putExtra("commentID", str2);
            intent.putExtra("Source", str);
            intent.putExtra("from_deeplink_or_notif", z);
            intent.putExtra(SocialActivityDetail.IS_REPLY_COMMENT_ENABLED, z2);
            intent.putExtra("feed_revamp", z3);
            return intent;
        }
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        lookAheadTest = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void $r8$lambda$dxqPJjBc0iil2ibOWNHapah5o3A(SocialActivityDetail socialActivityDetail, View view) {
        Intrinsics.checkNotNullParameter(socialActivityDetail, "");
        socialActivityDetail.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(0);
    }

    public static final /* synthetic */ ReportFeedCommentsBottomSheetDialog access$getReportFeedCommentsBottomSheetDialog(SocialActivityDetail socialActivityDetail) {
        return (ReportFeedCommentsBottomSheetDialog) socialActivityDetail.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void access$openProfileActivity(SocialActivityDetail socialActivityDetail, RelationshipItemModel relationshipItemModel) {
        Context baseContext = socialActivityDetail.getBaseContext();
        if (baseContext != null) {
            SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
            SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseContext, relationshipItemModel);
        }
    }

    public static final /* synthetic */ void access$openReportCommentBottomSheet(final SocialActivityDetail socialActivityDetail, final ReportFeedCommentsBottomSheetDialog reportFeedCommentsBottomSheetDialog) {
        reportFeedCommentsBottomSheetDialog.show(socialActivityDetail.getSupportFragmentManager(), "");
        reportFeedCommentsBottomSheetDialog.PlaceComponentResult = new ReportFeedCommentsBottomSheetDialog.BottomSheetListener() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$openReportCommentBottomSheet$1$1
            @Override // id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog.BottomSheetListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                ReportFeedCommentsBottomSheetDialog.this.dismiss();
            }

            @Override // id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog.BottomSheetListener
            public final void getAuthRequestContext(String p0) {
                FeedCommentModel feedCommentModel;
                FeedModel feedModel;
                Intrinsics.checkNotNullParameter(p0, "");
                feedCommentModel = socialActivityDetail.lookAheadTest;
                if (feedCommentModel != null) {
                    SocialActivityDetail socialActivityDetail2 = socialActivityDetail;
                    FeedCommentContract.Presenter feedCommentPresenter = socialActivityDetail2.getFeedCommentPresenter();
                    String str = feedCommentModel.BuiltInFictitiousFunctionClassFactory;
                    feedModel = socialActivityDetail2.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str2 = feedModel != null ? feedModel.BuiltInFictitiousFunctionClassFactory : null;
                    feedCommentPresenter.PlaceComponentResult(str, p0, str2 != null ? str2 : "");
                }
            }
        };
    }

    public static final /* synthetic */ void access$openSelfProfileActivity(SocialActivityDetail socialActivityDetail, FeedModel feedModel) {
        RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$2 = FeedViewModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(feedModel);
        Intrinsics.checkNotNullParameter("SELF", "");
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = "SELF";
        Context baseContext = socialActivityDetail.getBaseContext();
        if (baseContext != null) {
            SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
            SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseContext, KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public static final /* synthetic */ void access$refreshActivitydetail(SocialActivityDetail socialActivityDetail) {
        socialActivityDetail.getBinding().MyBillsEntityDataFactory.resetItems();
        socialActivityDetail.getBinding().MyBillsEntityDataFactory.showShimmer();
        socialActivityDetail.getFeedCommentPresenter().getAuthRequestContext();
        socialActivityDetail.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void access$showToast(SocialActivityDetail socialActivityDetail, String str, SnackbarState snackbarState) {
        ConstraintLayout constraintLayout = socialActivityDetail.getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder(constraintLayout);
        builder.initRecordTimeStamp = str;
        CustomSnackbar.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(snackbarState);
        SnackbarPosition snackbarPosition = SnackbarPosition.TOP;
        Intrinsics.checkNotNullParameter(snackbarPosition, "");
        MyBillsEntityDataFactory.GetContactSyncConfig = snackbarPosition;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = ViewExtKt.PlaceComponentResult(64.0f);
        MyBillsEntityDataFactory.moveToNextValue = -1;
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[snackbarState.ordinal()];
        if (i == 1) {
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_check_24_green50_filled_circle;
        } else if (i != 2) {
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_yellow;
        } else {
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_close_red;
        }
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final /* synthetic */ void access$trackCommentPost(SocialActivityDetail socialActivityDetail, String str, FeedModel feedModel) {
        String str2;
        if (str.length() > 0) {
            FriendshipAnalyticTracker friendshipAnalyticTracker = socialActivityDetail.getFriendshipAnalyticTracker();
            str2 = feedModel != null ? feedModel.PlaceComponentResult : null;
            friendshipAnalyticTracker.BuiltInFictitiousFunctionClassFactory(str2 != null ? str2 : "");
            return;
        }
        FriendshipAnalyticTracker friendshipAnalyticTracker2 = socialActivityDetail.getFriendshipAnalyticTracker();
        str2 = feedModel != null ? feedModel.PlaceComponentResult : null;
        friendshipAnalyticTracker2.MyBillsEntityDataFactory(str2 != null ? str2 : "");
    }

    public final boolean PlaceComponentResult(FeedModel p0) {
        HashMap<String, String> hashMap = p0.lookAheadTest;
        return Intrinsics.areEqual(hashMap != null ? ExtendInfoUtilKt.getUserId(hashMap) : null, getFeedCommentPresenter().KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        String str;
        Bundle extras;
        FeedModel feedModel;
        Drawable PlaceComponentResult2;
        Bundle extras2 = getIntent().getExtras();
        this.getAuthRequestContext = extras2 != null ? extras2.getBoolean("from_deeplink_or_notif", false) : false;
        Bundle extras3 = getIntent().getExtras();
        boolean z = extras3 != null ? extras3.getBoolean("feed_revamp", false) : false;
        if (this.getAuthRequestContext && z) {
            Application application = getApplication();
            if (application == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
            }
            ((DanaApplication) application).setFeedRevamp(true);
        }
        FeedsView feedsView = (FeedsView) _$_findCachedViewById(R.id.feed_view_detail);
        if (feedsView != null) {
            feedsView.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2() ^ true ? 0 : 8);
        }
        ActivityFeedView activityFeedView = (ActivityFeedView) _$_findCachedViewById(R.id.newFeedViewDetail);
        if (activityFeedView != null) {
            activityFeedView.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2() ? 0 : 8);
        }
        ReactionSectionView reactionSectionView = (ReactionSectionView) _$_findCachedViewById(R.id.reaction_section_view_detail);
        if (reactionSectionView != null) {
            reactionSectionView.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2() ^ true ? 0 : 8);
        }
        AppBarLayout appBarLayout = (AppBarLayout) _$_findCachedViewById(R.id.app_bar_activity_detail_layout);
        if (appBarLayout != null) {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                PlaceComponentResult2 = ContextCompat.PlaceComponentResult(this, (int) R.color.f27072131100488);
            } else {
                PlaceComponentResult2 = ContextCompat.PlaceComponentResult(this, (int) R.color.f27122131100500);
            }
            appBarLayout.setBackground(PlaceComponentResult2);
        }
        initComponent();
        getFeedCommentPresenter().MyBillsEntityDataFactory();
        Bundle extras4 = getIntent().getExtras();
        if (extras4 != null && (feedModel = (FeedModel) extras4.getParcelable(BUNDLE_FEED_DATA)) != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = feedModel;
            if (feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1.length() > 0) {
                getFeedCommentPresenter().BuiltInFictitiousFunctionClassFactory(feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
            if (!this.getAuthRequestContext) {
                String str2 = feedModel.scheduleImpl;
                if (!(str2 == null || str2.length() == 0)) {
                    Intrinsics.checkNotNullExpressionValue(feedModel, "");
                    MyBillsEntityDataFactory(feedModel);
                }
            }
            BuiltInFictitiousFunctionClassFactory();
        }
        getBinding().PlaceComponentResult.setListener(new FeedInputCommentListener() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$setupFeedInputCommentView$1
            @Override // id.dana.social.common.FeedInputCommentListener
            public final void MyBillsEntityDataFactory(String p0, String p1) {
                int i;
                FeedModel feedModel2;
                ActivityReactionsUserModel activityReactionsUserModel;
                FeedCommentModel feedCommentModel;
                ActivityCommentDetailBinding binding;
                FeedModel feedModel3;
                int i2;
                FeedModel feedModel4;
                ActivityCommentDetailBinding binding2;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                i = SocialActivityDetail.this.DatabaseTableConfigUtil;
                feedModel2 = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String str3 = feedModel2 != null ? feedModel2.BuiltInFictitiousFunctionClassFactory : null;
                String str4 = str3 == null ? "" : str3;
                activityReactionsUserModel = SocialActivityDetail.this.MyBillsEntityDataFactory;
                FeedCommentModel feedCommentModel2 = new FeedCommentModel(String.valueOf(i), str4, 0, activityReactionsUserModel, p0, true, "", FeedCommentModelState.SENDING, p1, 0, null, 1540, null);
                if (p1.length() > 0) {
                    binding2 = SocialActivityDetail.this.getBinding();
                    feedCommentModel = feedCommentModel2;
                    binding2.MyBillsEntityDataFactory.insertReply(feedCommentModel);
                } else {
                    feedCommentModel = feedCommentModel2;
                    binding = SocialActivityDetail.this.getBinding();
                    binding.MyBillsEntityDataFactory.insertComment(feedCommentModel);
                }
                FeedCommentContract.Presenter feedCommentPresenter = SocialActivityDetail.this.getFeedCommentPresenter();
                feedModel3 = SocialActivityDetail.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String str5 = feedModel3 != null ? feedModel3.BuiltInFictitiousFunctionClassFactory : null;
                if (str5 == null) {
                    str5 = "";
                }
                feedCommentPresenter.BuiltInFictitiousFunctionClassFactory(feedCommentModel, str5);
                SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                i2 = socialActivityDetail.DatabaseTableConfigUtil;
                socialActivityDetail.DatabaseTableConfigUtil = i2 + 1;
                SocialActivityDetail socialActivityDetail2 = SocialActivityDetail.this;
                feedModel4 = socialActivityDetail2.KClassImpl$Data$declaredNonStaticMembers$2;
                SocialActivityDetail.access$trackCommentPost(socialActivityDetail2, p1, feedModel4);
            }
        });
        if (this.feedCommentPresenter != null) {
            getFeedCommentPresenter().BuiltInFictitiousFunctionClassFactory();
        }
        getBinding().scheduleImpl.setPtrHandler(new PtrHandler() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$initPullToRefreshComponent$1
            @Override // in.srain.cube.views.ptr.PtrHandler
            public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                return true;
            }

            @Override // in.srain.cube.views.ptr.PtrHandler
            public final void onRefreshBegin(PtrFrameLayout p0) {
                boolean PlaceComponentResult3;
                LottieAnimationView lottieAnimationView;
                PlaceComponentResult3 = SocialActivityDetail.this.PlaceComponentResult();
                if (PlaceComponentResult3) {
                    lottieAnimationView = SocialActivityDetail.this.BuiltInFictitiousFunctionClassFactory;
                    if (lottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lottieAnimationView = null;
                    }
                    lottieAnimationView.playAnimation();
                }
                SocialActivityDetail.access$refreshActivitydetail(SocialActivityDetail.this);
            }
        });
        getBinding().scheduleImpl.disableWhenHorizontalMove(true);
        LottieAnimationView lottieAnimationView = null;
        getBinding().scheduleImpl.setHeaderView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
        PtrClassicFrameLayout ptrClassicFrameLayout = getBinding().scheduleImpl;
        ptrClassicFrameLayout.setHeaderView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
        View findViewById = ptrClassicFrameLayout.getHeaderView().findViewById(R.id.lav_loading_animation);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById;
        this.BuiltInFictitiousFunctionClassFactory = lottieAnimationView2;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            lottieAnimationView = lottieAnimationView2;
        }
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$initPullToRefreshHeaderView$1$1
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
                ActivityCommentDetailBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                binding = SocialActivityDetail.this.getBinding();
                PtrClassicFrameLayout ptrClassicFrameLayout2 = binding.scheduleImpl;
                SocialActivityDetail socialActivityDetail = SocialActivityDetail.this;
                ptrClassicFrameLayout2.refreshComplete();
                socialActivityDetail.GetContactSyncConfig = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p0) {
                boolean z2;
                boolean PlaceComponentResult3;
                LottieAnimationView lottieAnimationView3;
                Intrinsics.checkNotNullParameter(p0, "");
                z2 = SocialActivityDetail.this.GetContactSyncConfig;
                if (z2) {
                    PlaceComponentResult3 = SocialActivityDetail.this.PlaceComponentResult();
                    if (PlaceComponentResult3) {
                        lottieAnimationView3 = SocialActivityDetail.this.BuiltInFictitiousFunctionClassFactory;
                        if (lottieAnimationView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            lottieAnimationView3 = null;
                        }
                        lottieAnimationView3.cancelAnimation();
                    }
                }
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarStateChangeListener() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$initAppBarLayout$1
            @Override // id.dana.social.view.AppBarStateChangeListener
            public final void BuiltInFictitiousFunctionClassFactory(AppBarLayout p0, AppBarStateChangeListener.State p1) {
                ActivityCommentDetailBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                binding = SocialActivityDetail.this.getBinding();
                binding.scheduleImpl.setEnabled(p1 == AppBarStateChangeListener.State.EXPANDED);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.social.view.activity.detail.SocialActivityDetail$setOnBackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                if (SocialActivityDetail.this.isTaskRoot()) {
                    Intent intent = new Intent(SocialActivityDetail.this, HomeTabActivity.class);
                    intent.setFlags(268468224);
                    SocialActivityDetail.this.startActivity(intent);
                }
                SocialActivityDetail.this.finish();
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
        FriendshipAnalyticTracker friendshipAnalyticTracker = getFriendshipAnalyticTracker();
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || (str = extras.getString("Source")) == null) {
            str = "Friends Feed";
        }
        friendshipAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(str);
    }

    private static void b(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda5);
        if (FragmentBottomSheetPaymentSettingBinding) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda6) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
