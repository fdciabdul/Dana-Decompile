package id.dana.danah5.bottomsheet;

import android.app.Application;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.alibaba.griver.base.common.env.GriverEnv;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.feeds.domain.share.interactor.CreateFeedActivity;
import id.dana.feeds.domain.share.interactor.GetPreviewActivity;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.ui.model.CreateFeedActivityRequestModel;
import id.dana.feeds.ui.model.CreateFeedActivityRequestModelKt;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.network.exception.NetworkException;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.RegexUtils;
import id.dana.social.v2.fragment.ShareActivityBottomSheetDialog;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.utils.CustomToastUtil;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\bc\u0010\fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012JT\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u000223\u0010\u0018\u001a/\u0012\u000b\u0012\t\u0018\u00010\u0010¢\u0006\u0002\b\u0016\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0016\u0012\u000b\u0012\t\u0018\u00010\u0017¢\u0006\u0002\b\u0016\u0012\u0004\u0012\u00020\b0\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJb\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001c23\u0010\u0018\u001a/\u0012\u000b\u0012\t\u0018\u00010\u0010¢\u0006\u0002\b\u0016\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0016\u0012\u000b\u0012\t\u0018\u00010\u0017¢\u0006\u0002\b\u0016\u0012\u0004\u0012\u00020\b0\u0015H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJb\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001c23\u0010\u0018\u001a/\u0012\u000b\u0012\t\u0018\u00010\u0010¢\u0006\u0002\b\u0016\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0016\u0012\u000b\u0012\t\u0018\u00010\u0017¢\u0006\u0002\b\u0016\u0012\u0004\u0012\u00020\b0\u0015H\u0002¢\u0006\u0004\b \u0010!J%\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b \u0010\nJ/\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b \u0010%J+\u0010(\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)Jb\u0010*\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001c23\u0010\u0018\u001a/\u0012\u000b\u0012\t\u0018\u00010\u0010¢\u0006\u0002\b\u0016\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0016\u0012\u000b\u0012\t\u0018\u00010\u0017¢\u0006\u0002\b\u0016\u0012\u0004\u0012\u00020\b0\u0015H\u0002¢\u0006\u0004\b*\u0010\u001fJ/\u0010-\u001a\u00020\b*\u00020\u00062\u0006\u0010+\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u00020\b*\u00020\u0006H\u0002¢\u0006\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u0010,\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u00108R\"\u0010:\u001a\u0002098\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010\u0019\u001a\u00020N8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001b\u0010W\u001a\u00020T8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\ba\u0010b"}, d2 = {"Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;", "", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "Lid/dana/feeds/domain/share/interactor/GetPreviewActivity$Params;", "params", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "autoSubmitFeed", "(Landroidx/fragment/app/FragmentActivity;Lid/dana/feeds/domain/share/interactor/GetPreviewActivity$Params;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "dismissBottomSheetDialog", "()V", "dispose", "", "throwable", "", "getPreviewActivityErrorCode", "(Ljava/lang/Throwable;)I", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "previewActivity", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "", "onFeedsError", "getUserInfo", "(Lid/dana/feeds/domain/share/model/PreviewActivityData;Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function3;)V", "Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;", "Lkotlin/Function0;", "onFeedsSuccess", "showEnableShareFeedConsentDialog", "(Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "showServicesBottomSheetDialog", "(Landroidx/fragment/app/FragmentActivity;Lid/dana/feeds/domain/share/interactor/GetPreviewActivity$Params;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "channelName", "Lcom/alibaba/griver/api/ui/share/ShareResultListener;", "callback", "(Landroidx/fragment/app/FragmentActivity;Lid/dana/feeds/domain/share/interactor/GetPreviewActivity$Params;Ljava/lang/String;Lcom/alibaba/griver/api/ui/share/ShareResultListener;)V", "Lid/dana/domain/user/UserInfoResponse;", "userInfoResponse", "showShareActivityDialog", "(Lid/dana/feeds/domain/share/model/PreviewActivityData;Landroidx/fragment/app/FragmentActivity;Lid/dana/domain/user/UserInfoResponse;)V", "submitFeed", "errorCode", "feedsContent", "failedResponse", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;ILandroidx/fragment/app/FragmentActivity;Ljava/lang/String;)V", "succeedResponse", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lid/dana/feeds/domain/share/interactor/CreateFeedActivity;", "createFeedActivity", "Lid/dana/feeds/domain/share/interactor/CreateFeedActivity;", "getCreateFeedActivity", "()Lid/dana/feeds/domain/share/interactor/CreateFeedActivity;", "setCreateFeedActivity", "(Lid/dana/feeds/domain/share/interactor/CreateFeedActivity;)V", "Ljava/lang/String;", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "Lid/dana/feeds/domain/share/interactor/GetPreviewActivity;", "getFeedPreviewActivity", "Lid/dana/feeds/domain/share/interactor/GetPreviewActivity;", "getGetFeedPreviewActivity", "()Lid/dana/feeds/domain/share/interactor/GetPreviewActivity;", "setGetFeedPreviewActivity", "(Lid/dana/feeds/domain/share/interactor/GetPreviewActivity;)V", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "getShareFeedConsent", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "getGetShareFeedConsent", "()Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "setGetShareFeedConsent", "(Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;)V", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/domain/user/interactor/GetUserInfo;", "getGetUserInfo", "()Lid/dana/domain/user/interactor/GetUserInfo;", "setGetUserInfo", "(Lid/dana/domain/user/interactor/GetUserInfo;)V", "", "isFeedRevamp$delegate", "Lkotlin/Lazy;", "isFeedRevamp", "()Z", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "saveShareFeedConsent", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "getSaveShareFeedConsent", "()Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "setSaveShareFeedConsent", "(Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;)V", "Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog;", "shareFeedBottomSheetDialog", "Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShareFeedBottomSheetManager {
    private static final int CANCELED_BY_USER = 2;
    private static final int INVALID_CONTENT_CODE_OR_TYPE = 6;
    public static final int JSAPI_DISABLED = 3;
    public static final int JSAPI_NOT_WHITELISTED = 4;
    public static final int MISSING_REQUIRED_INFO = 5;
    private static final int UNKNOWN_ERROR = 1;
    @Inject
    public CreateFeedActivity createFeedActivity;
    private String feedsContent;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;
    @Inject
    public GetPreviewActivity getFeedPreviewActivity;
    @Inject
    public GetShareFeedConsent getShareFeedConsent;
    @Inject
    public GetUserInfo getUserInfo;

    /* renamed from: isFeedRevamp$delegate  reason: from kotlin metadata */
    private final Lazy isFeedRevamp = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$isFeedRevamp$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Application applicationContext = GriverEnv.getApplicationContext();
            if (applicationContext != null) {
                return Boolean.valueOf(((DanaApplication) applicationContext).isFeedRevamp());
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
    });
    @Inject
    public SaveShareFeedConsent saveShareFeedConsent;
    private ShareActivityBottomSheetDialog shareFeedBottomSheetDialog;

    public ShareFeedBottomSheetManager() {
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        SocialCommonComponent socialCommonComponent = ((DanaApplication) applicationContext).getSocialCommonComponent();
        if (socialCommonComponent != null) {
            socialCommonComponent.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
    }

    @JvmName(name = "getGetShareFeedConsent")
    public final GetShareFeedConsent getGetShareFeedConsent() {
        GetShareFeedConsent getShareFeedConsent = this.getShareFeedConsent;
        if (getShareFeedConsent != null) {
            return getShareFeedConsent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetShareFeedConsent")
    public final void setGetShareFeedConsent(GetShareFeedConsent getShareFeedConsent) {
        Intrinsics.checkNotNullParameter(getShareFeedConsent, "");
        this.getShareFeedConsent = getShareFeedConsent;
    }

    @JvmName(name = "getSaveShareFeedConsent")
    public final SaveShareFeedConsent getSaveShareFeedConsent() {
        SaveShareFeedConsent saveShareFeedConsent = this.saveShareFeedConsent;
        if (saveShareFeedConsent != null) {
            return saveShareFeedConsent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSaveShareFeedConsent")
    public final void setSaveShareFeedConsent(SaveShareFeedConsent saveShareFeedConsent) {
        Intrinsics.checkNotNullParameter(saveShareFeedConsent, "");
        this.saveShareFeedConsent = saveShareFeedConsent;
    }

    @JvmName(name = "getGetFeedPreviewActivity")
    public final GetPreviewActivity getGetFeedPreviewActivity() {
        GetPreviewActivity getPreviewActivity = this.getFeedPreviewActivity;
        if (getPreviewActivity != null) {
            return getPreviewActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetFeedPreviewActivity")
    public final void setGetFeedPreviewActivity(GetPreviewActivity getPreviewActivity) {
        Intrinsics.checkNotNullParameter(getPreviewActivity, "");
        this.getFeedPreviewActivity = getPreviewActivity;
    }

    @JvmName(name = "getCreateFeedActivity")
    public final CreateFeedActivity getCreateFeedActivity() {
        CreateFeedActivity createFeedActivity = this.createFeedActivity;
        if (createFeedActivity != null) {
            return createFeedActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCreateFeedActivity")
    public final void setCreateFeedActivity(CreateFeedActivity createFeedActivity) {
        Intrinsics.checkNotNullParameter(createFeedActivity, "");
        this.createFeedActivity = createFeedActivity;
    }

    @JvmName(name = "getGetUserInfo")
    public final GetUserInfo getGetUserInfo() {
        GetUserInfo getUserInfo = this.getUserInfo;
        if (getUserInfo != null) {
            return getUserInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetUserInfo")
    public final void setGetUserInfo(GetUserInfo getUserInfo) {
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        this.getUserInfo = getUserInfo;
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

    @JvmName(name = "isFeedRevamp")
    public final boolean isFeedRevamp() {
        return ((Boolean) this.isFeedRevamp.getValue()).booleanValue();
    }

    private final void showServicesBottomSheetDialog(final FragmentActivity fragmentActivity, GetPreviewActivity.Params params, final Function0<Unit> onFeedsSuccess, final Function3<? super Integer, ? super FragmentActivity, ? super String, Unit> onFeedsError) {
        ShareActivityBottomSheetDialog shareActivityBottomSheetDialog = this.shareFeedBottomSheetDialog;
        if (shareActivityBottomSheetDialog != null) {
            if (!shareActivityBottomSheetDialog.isAdded()) {
                shareActivityBottomSheetDialog = null;
            }
            if (shareActivityBottomSheetDialog != null) {
                return;
            }
        }
        getGetFeedPreviewActivity().execute(params, new Function1<PreviewActivityData, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showServicesBottomSheetDialog$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PreviewActivityData previewActivityData) {
                invoke2(previewActivityData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final PreviewActivityData previewActivityData) {
                boolean isFeedRevamp;
                boolean isFeedRevamp2;
                Intrinsics.checkNotNullParameter(previewActivityData, "");
                ShareFeedBottomSheetManager shareFeedBottomSheetManager = ShareFeedBottomSheetManager.this;
                ShareActivityBottomSheetDialog.Builder builder = new ShareActivityBottomSheetDialog.Builder(null, null, fragmentActivity, false, 11, null);
                final ShareFeedBottomSheetManager shareFeedBottomSheetManager2 = ShareFeedBottomSheetManager.this;
                final FragmentActivity fragmentActivity2 = fragmentActivity;
                final Function0<Unit> function0 = onFeedsSuccess;
                final Function3<Integer, FragmentActivity, String, Unit> function3 = onFeedsError;
                Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showServicesBottomSheetDialog$2$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        Intrinsics.checkNotNullParameter(str, "");
                        Intrinsics.checkNotNullParameter(str2, "");
                        ShareFeedBottomSheetManager.this.getFriendshipAnalyticTracker().scheduleImpl(previewActivityData.getContentType());
                        ShareFeedBottomSheetManager.this.submitFeed(new CreateFeedActivityRequestModel(previewActivityData.getShareFeedRequestId(), str, str2, null, null, previewActivityData.getExtendInfo(), false, previewActivityData.getWidget(), 88, null), fragmentActivity2, function0, function3);
                    }
                };
                Intrinsics.checkNotNullParameter(function2, "");
                builder.BuiltInFictitiousFunctionClassFactory = function2;
                final Function3<Integer, FragmentActivity, String, Unit> function32 = onFeedsError;
                final FragmentActivity fragmentActivity3 = fragmentActivity;
                final ShareFeedBottomSheetManager shareFeedBottomSheetManager3 = ShareFeedBottomSheetManager.this;
                Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showServicesBottomSheetDialog$2$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        String str;
                        Function3<Integer, FragmentActivity, String, Unit> function33 = function32;
                        FragmentActivity fragmentActivity4 = fragmentActivity3;
                        str = shareFeedBottomSheetManager3.feedsContent;
                        function33.invoke(2, fragmentActivity4, str);
                    }
                };
                Intrinsics.checkNotNullParameter(function02, "");
                builder.PlaceComponentResult = function02;
                isFeedRevamp = ShareFeedBottomSheetManager.this.isFeedRevamp();
                builder.MyBillsEntityDataFactory = isFeedRevamp;
                shareFeedBottomSheetManager.shareFeedBottomSheetDialog = builder.PlaceComponentResult();
                isFeedRevamp2 = ShareFeedBottomSheetManager.this.isFeedRevamp();
                if (isFeedRevamp2) {
                    ShareFeedBottomSheetManager.this.getUserInfo(previewActivityData, fragmentActivity, onFeedsError);
                } else {
                    ShareFeedBottomSheetManager.showShareActivityDialog$default(ShareFeedBottomSheetManager.this, previewActivityData, fragmentActivity, null, 4, null);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showServicesBottomSheetDialog$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                int previewActivityErrorCode;
                Intrinsics.checkNotNullParameter(th, "");
                previewActivityErrorCode = ShareFeedBottomSheetManager.this.getPreviewActivityErrorCode(th);
                onFeedsError.invoke(Integer.valueOf(previewActivityErrorCode), fragmentActivity, null);
            }
        });
        Unit unit = Unit.INSTANCE;
    }

    public final void showServicesBottomSheetDialog(FragmentActivity fragmentActivity, GetPreviewActivity.Params params, final BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        showServicesBottomSheetDialog(fragmentActivity, params, new Function0<Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showServicesBottomSheetDialog$3
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
                ShareFeedBottomSheetManager.this.succeedResponse(bridgeCallback);
            }
        }, new Function3<Integer, FragmentActivity, String, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showServicesBottomSheetDialog$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final /* synthetic */ Unit invoke(Integer num, FragmentActivity fragmentActivity2, String str) {
                invoke(num.intValue(), fragmentActivity2, str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, FragmentActivity fragmentActivity2, String str) {
                Intrinsics.checkNotNullParameter(fragmentActivity2, "");
                ShareFeedBottomSheetManager.this.failedResponse(bridgeCallback, i, fragmentActivity2, str);
            }
        });
    }

    public final void showServicesBottomSheetDialog(FragmentActivity fragmentActivity, GetPreviewActivity.Params params, final String channelName, final ShareResultListener callback) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(channelName, "");
        showServicesBottomSheetDialog(fragmentActivity, params, new Function0<Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showServicesBottomSheetDialog$5
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
                String str;
                ShareResultListener shareResultListener = ShareResultListener.this;
                if (shareResultListener != null) {
                    str = this.feedsContent;
                    shareResultListener.success(str);
                }
            }
        }, new Function3<Integer, FragmentActivity, String, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showServicesBottomSheetDialog$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final /* synthetic */ Unit invoke(Integer num, FragmentActivity fragmentActivity2, String str) {
                invoke(num.intValue(), fragmentActivity2, str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, FragmentActivity fragmentActivity2, String str) {
                Intrinsics.checkNotNullParameter(fragmentActivity2, "");
                ShareResultListener shareResultListener = ShareResultListener.this;
                if (shareResultListener != null) {
                    shareResultListener.fail(channelName, "", "");
                }
            }
        });
    }

    public final void autoSubmitFeed(final FragmentActivity fragmentActivity, GetPreviewActivity.Params params, final BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        getGetFeedPreviewActivity().execute(params, new Function1<PreviewActivityData, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$autoSubmitFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PreviewActivityData previewActivityData) {
                invoke2(previewActivityData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PreviewActivityData previewActivityData) {
                Intrinsics.checkNotNullParameter(previewActivityData, "");
                ShareFeedBottomSheetManager shareFeedBottomSheetManager = ShareFeedBottomSheetManager.this;
                CreateFeedActivityRequestModel createFeedActivityRequestModel = new CreateFeedActivityRequestModel(previewActivityData.getShareFeedRequestId(), "", "", null, null, previewActivityData.getExtendInfo(), false, null, 216, null);
                FragmentActivity fragmentActivity2 = fragmentActivity;
                final ShareFeedBottomSheetManager shareFeedBottomSheetManager2 = ShareFeedBottomSheetManager.this;
                final BridgeCallback bridgeCallback2 = bridgeCallback;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$autoSubmitFeed$1.1
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
                        ShareFeedBottomSheetManager.this.succeedResponse(bridgeCallback2);
                    }
                };
                final ShareFeedBottomSheetManager shareFeedBottomSheetManager3 = ShareFeedBottomSheetManager.this;
                final BridgeCallback bridgeCallback3 = bridgeCallback;
                shareFeedBottomSheetManager.submitFeed(createFeedActivityRequestModel, fragmentActivity2, function0, new Function3<Integer, FragmentActivity, String, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$autoSubmitFeed$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final /* synthetic */ Unit invoke(Integer num, FragmentActivity fragmentActivity3, String str) {
                        invoke(num.intValue(), fragmentActivity3, str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i, FragmentActivity fragmentActivity3, String str) {
                        Intrinsics.checkNotNullParameter(fragmentActivity3, "");
                        ShareFeedBottomSheetManager.this.failedResponse(bridgeCallback3, i, fragmentActivity3, str);
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$autoSubmitFeed$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                int previewActivityErrorCode;
                Intrinsics.checkNotNullParameter(th, "");
                previewActivityErrorCode = ShareFeedBottomSheetManager.this.getPreviewActivityErrorCode(th);
                ShareFeedBottomSheetManager.this.failedResponse(bridgeCallback, previewActivityErrorCode, fragmentActivity, null);
            }
        });
    }

    public final void dismissBottomSheetDialog() {
        ShareActivityBottomSheetDialog shareActivityBottomSheetDialog = this.shareFeedBottomSheetDialog;
        if (shareActivityBottomSheetDialog == null || !shareActivityBottomSheetDialog.isVisible()) {
            return;
        }
        shareActivityBottomSheetDialog.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void showShareActivityDialog$default(ShareFeedBottomSheetManager shareFeedBottomSheetManager, PreviewActivityData previewActivityData, FragmentActivity fragmentActivity, UserInfoResponse userInfoResponse, int i, Object obj) {
        if ((i & 4) != 0) {
            userInfoResponse = null;
        }
        shareFeedBottomSheetManager.showShareActivityDialog(previewActivityData, fragmentActivity, userInfoResponse);
    }

    public final void showShareActivityDialog(PreviewActivityData previewActivity, FragmentActivity fragmentActivity, UserInfoResponse userInfoResponse) {
        getGetUserInfo().dispose();
        ShareActivityBottomSheetDialog shareActivityBottomSheetDialog = this.shareFeedBottomSheetDialog;
        if (shareActivityBottomSheetDialog == null || shareActivityBottomSheetDialog.isVisible()) {
            return;
        }
        String content = previewActivity.getContent();
        HashMap<String, String> extendInfo = previewActivity.getExtendInfo();
        if (extendInfo == null) {
            extendInfo = new HashMap<>();
        }
        shareActivityBottomSheetDialog.MyBillsEntityDataFactory = new FeedRegexData("", content, extendInfo, null, fragmentActivity, previewActivity.getContentType(), 8, null);
        HashMap<String, String> extendInfo2 = previewActivity.getExtendInfo();
        shareActivityBottomSheetDialog.getAuthRequestContext = extendInfo2 != null ? ExtendInfoUtilKt.getProfileAvatar(extendInfo2) : null;
        FeedRegexData feedRegexData = shareActivityBottomSheetDialog.MyBillsEntityDataFactory;
        if (feedRegexData != null) {
            RegexUtils.Companion companion = RegexUtils.INSTANCE;
            this.feedsContent = RegexUtils.Companion.PlaceComponentResult(feedRegexData, null, false, false, 14).toString();
        }
        if (userInfoResponse != null) {
            FeedViewHolderModel.Companion companion2 = FeedViewHolderModel.INSTANCE;
            shareActivityBottomSheetDialog.PlaceComponentResult = FeedViewHolderModel.Companion.getAuthRequestContext(previewActivity, new MyFeedHeaderModel(null, userInfoResponse.getNickname(), userInfoResponse.getAvatarUrl(), false, false, userInfoResponse.getUsername(), 25, null));
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        AndroidComponentUtilsKt.MyBillsEntityDataFactory(shareActivityBottomSheetDialog, supportFragmentManager, "shareFeedActivity");
    }

    public final void getUserInfo(final PreviewActivityData previewActivity, final FragmentActivity fragmentActivity, final Function3<? super Integer, ? super FragmentActivity, ? super String, Unit> onFeedsError) {
        getGetUserInfo().execute(new GetUserInfo.Param(false), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$getUserInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ShareFeedBottomSheetManager.this.showShareActivityDialog(previewActivity, fragmentActivity, userInfoResponse);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$getUserInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Intrinsics.checkNotNullParameter(th, "");
                ShareFeedBottomSheetManager.this.dismissBottomSheetDialog();
                onFeedsError.invoke(1, fragmentActivity, null);
            }
        });
    }

    public final void submitFeed(final CreateFeedActivityRequestModel params, final FragmentActivity fragmentActivity, final Function0<Unit> onFeedsSuccess, final Function3<? super Integer, ? super FragmentActivity, ? super String, Unit> onFeedsError) {
        getGetShareFeedConsent().execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$submitFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (!z) {
                    ShareFeedBottomSheetManager.this.showEnableShareFeedConsentDialog(params, fragmentActivity, onFeedsSuccess, onFeedsError);
                    return;
                }
                CreateFeedActivity createFeedActivity = ShareFeedBottomSheetManager.this.getCreateFeedActivity();
                CreateFeedActivity.Params KClassImpl$Data$declaredNonStaticMembers$2 = CreateFeedActivityRequestModelKt.KClassImpl$Data$declaredNonStaticMembers$2(params);
                final ShareFeedBottomSheetManager shareFeedBottomSheetManager = ShareFeedBottomSheetManager.this;
                final FragmentActivity fragmentActivity2 = fragmentActivity;
                final Function0<Unit> function0 = onFeedsSuccess;
                Function1<ActivityResponse, Unit> function1 = new Function1<ActivityResponse, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$submitFeed$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ActivityResponse activityResponse) {
                        invoke2(activityResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ActivityResponse activityResponse) {
                        Intrinsics.checkNotNullParameter(activityResponse, "");
                        ShareFeedBottomSheetManager.this.dismissBottomSheetDialog();
                        CustomToastUtil customToastUtil = CustomToastUtil.MyBillsEntityDataFactory;
                        FragmentActivity fragmentActivity3 = fragmentActivity2;
                        CustomToastUtil.KClassImpl$Data$declaredNonStaticMembers$2(fragmentActivity3, R.drawable.ic_success, fragmentActivity3.getApplicationContext().getString(R.string.share_to_feed_message_success));
                        function0.invoke();
                    }
                };
                final ShareFeedBottomSheetManager shareFeedBottomSheetManager2 = ShareFeedBottomSheetManager.this;
                final Function3<Integer, FragmentActivity, String, Unit> function3 = onFeedsError;
                final FragmentActivity fragmentActivity3 = fragmentActivity;
                createFeedActivity.execute(KClassImpl$Data$declaredNonStaticMembers$2, function1, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$submitFeed$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        Intrinsics.checkNotNullParameter(th, "");
                        ShareFeedBottomSheetManager.this.dismissBottomSheetDialog();
                        function3.invoke(1, fragmentActivity3, null);
                    }
                });
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$submitFeed$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                ShareFeedBottomSheetManager.this.dismissBottomSheetDialog();
                onFeedsError.invoke(1, fragmentActivity, null);
            }
        });
    }

    public final void showEnableShareFeedConsentDialog(final CreateFeedActivityRequestModel params, final FragmentActivity fragmentActivity, final Function0<Unit> onFeedsSuccess, final Function3<? super Integer, ? super FragmentActivity, ? super String, Unit> onFeedsError) {
        CustomDialog.Builder builder = new CustomDialog.Builder(fragmentActivity);
        builder.SubSequence = fragmentActivity.getString(R.string.share_activity_consent_dialog_title);
        builder.GetContactSyncConfig = fragmentActivity.getString(R.string.share_activity_consent_dialog_description);
        builder.KClassImpl$Data$declaredNonStaticMembers$2(false);
        builder.PlaceComponentResult(false);
        builder.BuiltInFictitiousFunctionClassFactory(fragmentActivity.getString(R.string.share_activity_consent_dialog_positive_button), new Function1<View, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showEnableShareFeedConsentDialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                SaveShareFeedConsent saveShareFeedConsent = ShareFeedBottomSheetManager.this.getSaveShareFeedConsent();
                Boolean bool = Boolean.TRUE;
                final ShareFeedBottomSheetManager shareFeedBottomSheetManager = ShareFeedBottomSheetManager.this;
                final CreateFeedActivityRequestModel createFeedActivityRequestModel = params;
                final FragmentActivity fragmentActivity2 = fragmentActivity;
                final Function0<Unit> function0 = onFeedsSuccess;
                final Function3<Integer, FragmentActivity, String, Unit> function3 = onFeedsError;
                Function1<Unit, Unit> function1 = new Function1<Unit, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showEnableShareFeedConsentDialog$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                        invoke2(unit);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Unit unit) {
                        Intrinsics.checkNotNullParameter(unit, "");
                        ShareFeedBottomSheetManager.this.submitFeed(createFeedActivityRequestModel, fragmentActivity2, function0, function3);
                    }
                };
                final Function3<Integer, FragmentActivity, String, Unit> function32 = onFeedsError;
                final FragmentActivity fragmentActivity3 = fragmentActivity;
                saveShareFeedConsent.execute(bool, function1, new Function1<Exception, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showEnableShareFeedConsentDialog$1$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                        invoke2(exc);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Exception exc) {
                        Intrinsics.checkNotNullParameter(exc, "");
                        function32.invoke(1, fragmentActivity3, null);
                    }
                });
            }
        });
        builder.KClassImpl$Data$declaredNonStaticMembers$2(fragmentActivity.getString(R.string.cancel_action), new Function1<View, Unit>() { // from class: id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager$showEnableShareFeedConsentDialog$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                String str;
                Intrinsics.checkNotNullParameter(view, "");
                ShareFeedBottomSheetManager.this.dismissBottomSheetDialog();
                Function3<Integer, FragmentActivity, String, Unit> function3 = onFeedsError;
                FragmentActivity fragmentActivity2 = fragmentActivity;
                str = ShareFeedBottomSheetManager.this.feedsContent;
                function3.invoke(2, fragmentActivity2, str);
            }
        });
        builder.BuiltInFictitiousFunctionClassFactory().show();
    }

    public final int getPreviewActivityErrorCode(Throwable throwable) {
        return ((throwable instanceof NetworkException) && Intrinsics.areEqual(((NetworkException) throwable).getErrorCode(), "AE15002058020003")) ? 6 : 1;
    }

    static /* synthetic */ void failedResponse$default(ShareFeedBottomSheetManager shareFeedBottomSheetManager, BridgeCallback bridgeCallback, int i, FragmentActivity fragmentActivity, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        shareFeedBottomSheetManager.failedResponse(bridgeCallback, i, fragmentActivity, str);
    }

    public final void failedResponse(BridgeCallback bridgeCallback, int i, FragmentActivity fragmentActivity, String str) {
        CustomToastUtil customToastUtil = CustomToastUtil.MyBillsEntityDataFactory;
        CustomToastUtil.KClassImpl$Data$declaredNonStaticMembers$2(fragmentActivity, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, fragmentActivity.getApplicationContext().getString(R.string.share_to_feed_message_error));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "errorCode", (String) Integer.valueOf(i));
        jSONObject2.put((JSONObject) "feedsContent", str);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    public final void dispose() {
        getGetShareFeedConsent().dispose();
        getGetFeedPreviewActivity().dispose();
        getSaveShareFeedConsent().dispose();
        getCreateFeedActivity().dispose();
        getGetUserInfo().dispose();
    }

    public final void succeedResponse(BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        jSONObject2.put((JSONObject) "feedsContent", this.feedsContent);
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
