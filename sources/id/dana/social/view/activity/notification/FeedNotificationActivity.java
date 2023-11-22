package id.dana.social.view.activity.notification;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customsnackbarcomponent.SnackbarPosition;
import id.dana.component.customsnackbarcomponent.SnackbarState;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.databinding.ActivityFeedNotificationBinding;
import id.dana.domain.DefaultObserver;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.model.DataReady;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.adapter.FriendRequestAdapter;
import id.dana.social.adapter.FriendRequestListActivity;
import id.dana.social.adapter.SocialFeedsAdapter;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.contract.notification.FeedNotificationContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.FeedNotificationModule;
import id.dana.social.di.module.FriendRequestListModule;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import net.sqlcipher.database.SQLiteDatabase;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001WB\u0007¢\u0006\u0004\bV\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0004\u0010\u0014J%\u0010\u0018\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0014¢\u0006\u0004\b$\u0010\bJ\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\bJ\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010'J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020(0\u0015H\u0002¢\u0006\u0004\b\u0007\u0010)R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010,R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010-R\"\u0010/\u001a\u00020.8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u0010\u0007\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u0010-R\u0016\u00107\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u0010-R\u0016\u0010\u0018\u001a\u0002088\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u0010-R\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010-R\u0016\u0010\u0011\u001a\u00020J8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010\u000f\u001a\u00020M8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bP\u0010-R\u0016\u0010&\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bQ\u0010-R\u0016\u00106\u001a\u00020R8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010I\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bU\u0010-"}, d2 = {"Lid/dana/social/view/activity/notification/FeedNotificationActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityFeedNotificationBinding;", "", "getAuthRequestContext", "()Z", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "configToolbar", "BuiltInFictitiousFunctionClassFactory", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityFeedNotificationBinding;", "moveToNextValue", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "", "p0", "(I)Z", "", "Lid/dana/social/model/FeedViewHolderModel;", "p1", "PlaceComponentResult", "(Ljava/util/List;Z)V", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/view/View;", "view", "onClickRightMenuButton", "(Landroid/view/View;)V", "onResume", "getErrorConfigVersion", "DatabaseTableConfigUtil", "(Z)V", "Lid/dana/feeds/ui/model/FriendModel;", "(Ljava/util/List;)V", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/model/DataReady;", "Lio/reactivex/subjects/PublishSubject;", "Z", "Lid/dana/social/contract/notification/FeedNotificationContract$Presenter;", "feedNotificationPresenter", "Lid/dana/social/contract/notification/FeedNotificationContract$Presenter;", "getFeedNotificationPresenter", "()Lid/dana/social/contract/notification/FeedNotificationContract$Presenter;", "setFeedNotificationPresenter", "(Lid/dana/social/contract/notification/FeedNotificationContract$Presenter;)V", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/FriendRequestAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/social/adapter/FriendRequestAdapter;", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "friendRequestPresenter", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "getFriendRequestPresenter", "()Lid/dana/social/contract/FriendRequestContract$Presenter;", "setFriendRequestPresenter", "(Lid/dana/social/contract/FriendRequestContract$Presenter;)V", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "GetContactSyncConfig", "Lcom/airbnb/lottie/LottieAnimationView;", "isLayoutRequested", "Lcom/airbnb/lottie/LottieAnimationView;", "Lid/dana/social/view/activity/notification/FeedNotificationActivity$notificationClickListener$1;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/social/view/activity/notification/FeedNotificationActivity$notificationClickListener$1;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "Lid/dana/social/adapter/SocialFeedsAdapter;", "PrepareContext", "Lid/dana/social/adapter/SocialFeedsAdapter;", "FragmentBottomSheetPaymentSettingBinding", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedNotificationActivity extends ViewBindingActivity<ActivityFeedNotificationBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final PublishSubject<DataReady> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private FriendRequestAdapter PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final FeedNotificationActivity$notificationClickListener$1 scheduleImpl;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private SocialFeedsAdapter NetworkUserEntityData$$ExternalSyntheticLambda1;
    @Inject
    public FeedNotificationContract.Presenter feedNotificationPresenter;
    @Inject
    public FriendRequestContract.Presenter friendRequestPresenter;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private LottieAnimationView lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;
    public static final byte[] $$a = {36, -18, 4, 125, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 194;
    public static final byte[] getAuthRequestContext = {Ascii.EM, 108, 7, 61, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 227;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean moveToNextValue = true;

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda6 = 269894737;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.social.view.activity.notification.FeedNotificationActivity.getAuthRequestContext
            int r8 = r8 + 97
            int r7 = 56 - r7
            int r6 = 23 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L32
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L32:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + (-4)
            int r8 = r8 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.notification.FeedNotificationActivity.a(short, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 2
            int r9 = r9 + 75
            int r8 = r8 + 4
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r0 = id.dana.social.view.activity.notification.FeedNotificationActivity.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r9
            r4 = 0
            r9 = r8
            goto L2c
        L15:
            r3 = 0
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L25:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
        L2c:
            int r8 = r8 + r3
            int r8 = r8 + (-7)
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.activity.notification.FeedNotificationActivity.c(byte, int, int, java.lang.Object[]):void");
    }

    private static boolean getAuthRequestContext(int p0) {
        return p0 == 14 || p0 == 15 || p0 == 13;
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
        b(false, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 216, 15 - ((Process.getThreadPriority(0) + 20) >> 6), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(false, View.combineMeasuredStates(0, 0) + WheelView.DIVIDER_ALPHA, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3, TextUtils.indexOf("", "", 0) + 5, new char[]{65517, 1, 65532, 5, 17}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), 35 - (Process.myTid() >> 22), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(true, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 187, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 48, 47 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(false, (ViewConfiguration.getTapTimeout() >> 16) + 182, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 16, 64 - Color.argb(0, 0, 0, 0), new char[]{65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(false, ((byte) KeyEvent.getModifierMetaStateMask()) + 185, ExpandableListView.getPackedPositionType(0L) + 58, 64 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(false, View.getDefaultSize(0, 0) + 213, (ViewConfiguration.getEdgeSlop() >> 16) + 52, 61 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(false, 165 - ImageFormat.getBitsPerPixel(0), 2 - (ViewConfiguration.getPressedStateDuration() >> 16), 6 - TextUtils.getOffsetBefore("", 0), new char[]{0, 65535, 7, 65532, 2, 65532}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, 18 - View.resolveSize(0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[2], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                a(getAuthRequestContext[2], 30, 8, objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - ExpandableListView.getPackedPositionType(0L), TextUtils.getOffsetAfter("", 0) + 3, (char) TextUtils.getTrimmedLength(""));
                        Object[] objArr17 = new Object[1];
                        c($$a[31], $$a[47], $$a[78], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 800, ExpandableListView.getPackedPositionChild(0L) + 16, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 15 - TextUtils.indexOf("", ""), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (KeyEvent.getMaxKeyCode() >> 16), KeyEvent.getDeadChar(0, 0) + 29, (char) (TextUtils.getCapsMode("", 0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 800, KeyEvent.getDeadChar(0, 0) + 15, (char) TextUtils.getOffsetAfter("", 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), View.MeasureSpec.getSize(0) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-177169983, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), 18 - View.MeasureSpec.getSize(0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = {this};
                Object[] objArr21 = new Object[1];
                a(getAuthRequestContext[2], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                a(getAuthRequestContext[2], 30, 8, objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 46, (char) (ImageFormat.getBitsPerPixel(0) + 1));
                        Object[] objArr24 = new Object[1];
                        c($$a[8], $$a[28], $$a[9], objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 35 - ExpandableListView.getPackedPositionGroup(0L), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-177169983, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), 18 - TextUtils.getCapsMode("", 0, 0), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                Object[] objArr28 = new Object[1];
                a(getAuthRequestContext[2], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                a(getAuthRequestContext[2], 30, 8, objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 118, TextUtils.lastIndexOf("", '0') + 4, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 38968));
                        Object[] objArr31 = new Object[1];
                        c($$a[8], $$a[28], $$a[9], objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), TextUtils.indexOf("", "", 0) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-177169983, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                Object[] objArr35 = new Object[1];
                a(getAuthRequestContext[2], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                a(getAuthRequestContext[2], 30, 8, objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 107, 3 - TextUtils.indexOf("", "", 0, 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        Object[] objArr38 = new Object[1];
                        c((byte) ($$a[78] - 1), (byte) (-$$a[40]), (byte) ($$a[78] - 1), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ((byte) KeyEvent.getModifierMetaStateMask()), 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-177169983, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), Process.getGidForName("") + 19, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(false, TextUtils.lastIndexOf("", '0', 0, 0) + 216, getPackageName().length() + 8, TextUtils.lastIndexOf("", '0') + 19, new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        int axisFromString = MotionEvent.axisFromString("") + 221;
        int codePointAt = super.getResources().getString(R.string.dialog_positive).substring(0, 1).codePointAt(0) - 86;
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr3 = new Object[1];
            a(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], new Object[1]);
            Object[] objArr4 = new Object[1];
            b(false, axisFromString, codePointAt, ((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 28, new char[]{65517, 1, 65532, 5, 17}, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    b(false, super.getResources().getString(R.string.twilio_remove_device_dialog_title).substring(16, 18).length() + 213, 21 - (ViewConfiguration.getScrollDefaultDelay() >> 16), super.getResources().getString(R.string.friend_request_message).substring(1, 2).length() + 25, new char[]{6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f'}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    int length = super.getResources().getString(R.string.referral_my_progress).substring(7, 8).length() + 221;
                    int codePointAt2 = super.getResources().getString(R.string.maintenance_page_subtitle).substring(49, 50).codePointAt(0) - 109;
                    try {
                        byte b2 = getAuthRequestContext[25];
                        Object[] objArr6 = new Object[1];
                        a(b2, (byte) (b2 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        b(false, length, codePointAt2, ((ApplicationInfo) cls4.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2}, objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), 35 - Color.alpha(0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        b(true, super.getResources().getString(R.string.paylater_bill_detail_subtitle).substring(6, 8).length() + WSContextConstant.HANDSHAKE_RECEIVE_SIZE, super.getResources().getString(R.string.empty_state_insurance_title).substring(3, 5).length() + 46, super.getResources().getString(R.string.username_introduction).substring(4, 5).length() + 47, new char[]{30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520}, objArr8);
                        String str = (String) objArr8[0];
                        try {
                            byte b3 = getAuthRequestContext[25];
                            Object[] objArr9 = new Object[1];
                            a(b3, (byte) (b3 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], objArr10);
                            int i = ((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 149;
                            try {
                                byte b4 = getAuthRequestContext[25];
                                Object[] objArr11 = new Object[1];
                                a(b4, (byte) (b4 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], new Object[1]);
                                Object[] objArr12 = new Object[1];
                                b(false, i, ((ApplicationInfo) cls6.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 16, super.getResources().getString(R.string.same_address_checkbox_text).substring(0, 3).length() + 61, new char[]{65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519}, objArr12);
                                String str2 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                b(false, 183 - TextUtils.lastIndexOf("", '0'), getPackageName().codePointAt(1) - 42, getPackageName().length() + 57, new char[]{65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523}, objArr13);
                                String str3 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                b(false, super.getResources().getString(R.string.username_introduction).substring(4, 5).codePointAt(0) + 116, 53 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 60, new char[]{3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486}, objArr14);
                                String str4 = (String) objArr14[0];
                                int length2 = super.getResources().getString(R.string.automation_passkey_btn_activate_passkey).substring(0, 20).length() + 146;
                                int codePointAt3 = getPackageName().codePointAt(4) - 95;
                                try {
                                    byte b5 = getAuthRequestContext[25];
                                    Object[] objArr15 = new Object[1];
                                    a(b5, (byte) (b5 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr15);
                                    Class<?> cls7 = Class.forName((String) objArr15[0]);
                                    a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], new Object[1]);
                                    Object[] objArr16 = new Object[1];
                                    b(false, length2, codePointAt3, ((ApplicationInfo) cls7.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 27, new char[]{0, 65535, 7, 65532, 2, 65532}, objArr16);
                                    try {
                                        Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, 18 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr17);
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
                }
            }
            try {
                Object[] objArr18 = new Object[1];
                a(getAuthRequestContext[2], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr18);
                Class<?> cls8 = Class.forName((String) objArr18[0]);
                Object[] objArr19 = new Object[1];
                a(getAuthRequestContext[2], 30, 8, objArr19);
                try {
                    Object[] objArr20 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - Process.getGidForName(""), ExpandableListView.getPackedPositionChild(0L) + 5, (char) ((-1) - TextUtils.lastIndexOf("", '0')));
                        Object[] objArr21 = new Object[1];
                        c((byte) ($$a[78] - 1), (byte) (-$$a[40]), (byte) ($$a[78] - 1), objArr21);
                        obj3 = cls9.getMethod((String) objArr21[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                    int i2 = ((int[]) objArr22[1])[0];
                    if (((int[]) objArr22[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), TextUtils.getOffsetBefore("", 0) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr23 = {-655314578, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr23);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int packedPositionGroup = 215 - ExpandableListView.getPackedPositionGroup(0L);
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(false, packedPositionGroup, ((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 12, 26 - (ViewConfiguration.getFadingEdgeLength() >> 16), new char[]{6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f'}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(false, getPackageName().codePointAt(2) + 176, getPackageName().length() + 0, Color.alpha(0) + 18, new char[]{65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX WARN: Type inference failed for: r0v4, types: [id.dana.social.view.activity.notification.FeedNotificationActivity$notificationClickListener$1] */
    public FeedNotificationActivity() {
        PublishSubject<DataReady> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult2;
        this.scheduleImpl = new BaseSocialFeedInteraction() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$notificationClickListener$1
            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void MyBillsEntityDataFactory(int p0) {
                SocialFeedsAdapter socialFeedsAdapter;
                SocialFeedsAdapter socialFeedsAdapter2;
                SocialFeedsAdapter socialFeedsAdapter3;
                String str;
                socialFeedsAdapter = FeedNotificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                SocialFeedsAdapter socialFeedsAdapter4 = null;
                if (socialFeedsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    socialFeedsAdapter = null;
                }
                FeedViewHolderModel item = socialFeedsAdapter.getItem(p0);
                if (item != null) {
                    FeedNotificationActivity feedNotificationActivity = FeedNotificationActivity.this;
                    FeedModel feedModel = item.MyBillsEntityDataFactory;
                    if (feedModel != null) {
                        FeedNotificationActivity.access$handleNotificationRedirection(feedNotificationActivity, feedModel);
                    }
                }
                socialFeedsAdapter2 = FeedNotificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (socialFeedsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    socialFeedsAdapter2 = null;
                }
                FeedViewHolderModel item2 = socialFeedsAdapter2.getItem(p0);
                if (item2 != null) {
                    FeedNotificationActivity feedNotificationActivity2 = FeedNotificationActivity.this;
                    FeedModel feedModel2 = item2.MyBillsEntityDataFactory;
                    boolean z = false;
                    if (feedModel2 != null && feedModel2.getNewProxyInstance()) {
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                    FeedModel feedModel3 = item2.MyBillsEntityDataFactory;
                    if (feedModel3 != null) {
                        feedModel3.newProxyInstance = true;
                    }
                    socialFeedsAdapter3 = feedNotificationActivity2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (socialFeedsAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        socialFeedsAdapter4 = socialFeedsAdapter3;
                    }
                    socialFeedsAdapter4.notifyItemChanged(p0);
                    FeedModel feedModel4 = item2.MyBillsEntityDataFactory;
                    if (feedModel4 == null || (str = feedModel4.BuiltInFictitiousFunctionClassFactory) == null) {
                        return;
                    }
                    feedNotificationActivity2.getFeedNotificationPresenter().PlaceComponentResult(str);
                }
            }

            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void getAuthRequestContext(int p0) {
                SocialFeedsAdapter socialFeedsAdapter;
                SocialFeedsAdapter socialFeedsAdapter2;
                SocialFeedsAdapter socialFeedsAdapter3;
                String str;
                GroupedFeedModel groupedFeedModel;
                List<FeedModel> list;
                FeedModel feedModel;
                socialFeedsAdapter = FeedNotificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                SocialFeedsAdapter socialFeedsAdapter4 = null;
                if (socialFeedsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    socialFeedsAdapter = null;
                }
                FeedViewHolderModel item = socialFeedsAdapter.getItem(p0);
                if (item != null && (groupedFeedModel = item.BuiltInFictitiousFunctionClassFactory) != null && (list = groupedFeedModel.BuiltInFictitiousFunctionClassFactory) != null && (feedModel = (FeedModel) CollectionsKt.firstOrNull((List) list)) != null) {
                    FeedNotificationActivity.access$handleNotificationRedirection(FeedNotificationActivity.this, feedModel);
                }
                socialFeedsAdapter2 = FeedNotificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (socialFeedsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    socialFeedsAdapter2 = null;
                }
                FeedViewHolderModel item2 = socialFeedsAdapter2.getItem(p0);
                if (item2 != null) {
                    FeedNotificationActivity feedNotificationActivity = FeedNotificationActivity.this;
                    GroupedFeedModel groupedFeedModel2 = item2.BuiltInFictitiousFunctionClassFactory;
                    boolean z = false;
                    if (groupedFeedModel2 != null && groupedFeedModel2.getScheduleImpl()) {
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                    GroupedFeedModel groupedFeedModel3 = item2.BuiltInFictitiousFunctionClassFactory;
                    if (groupedFeedModel3 != null) {
                        groupedFeedModel3.scheduleImpl = true;
                    }
                    socialFeedsAdapter3 = feedNotificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (socialFeedsAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        socialFeedsAdapter4 = socialFeedsAdapter3;
                    }
                    socialFeedsAdapter4.notifyItemChanged(p0);
                    GroupedFeedModel groupedFeedModel4 = item2.BuiltInFictitiousFunctionClassFactory;
                    if (groupedFeedModel4 == null || (str = groupedFeedModel4.moveToNextValue) == null) {
                        return;
                    }
                    feedNotificationActivity.getFeedNotificationPresenter().PlaceComponentResult(str);
                }
            }
        };
    }

    @JvmName(name = "getFeedNotificationPresenter")
    public final FeedNotificationContract.Presenter getFeedNotificationPresenter() {
        FeedNotificationContract.Presenter presenter = this.feedNotificationPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFeedNotificationPresenter")
    public final void setFeedNotificationPresenter(FeedNotificationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.feedNotificationPresenter = presenter;
    }

    @JvmName(name = "getFriendRequestPresenter")
    public final FriendRequestContract.Presenter getFriendRequestPresenter() {
        FriendRequestContract.Presenter presenter = this.friendRequestPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFriendRequestPresenter")
    public final void setFriendRequestPresenter(FriendRequestContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.friendRequestPresenter = presenter;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean lookAheadTest() {
        return this.lookAheadTest != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityFeedNotificationBinding initViewBinding() {
        ActivityFeedNotificationBinding MyBillsEntityDataFactory = ActivityFeedNotificationBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.feed_notification_activity_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
        setMenuRightButton(R.drawable.ic_read_all_notification_24dp, 16);
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickRightMenuButton(View view) {
        getFeedNotificationPresenter().getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getErrorConfigVersion() {
        this.getAuthRequestContext = false;
        SocialFeedsAdapter socialFeedsAdapter = null;
        if (this.DatabaseTableConfigUtil) {
            this.MyBillsEntityDataFactory = false;
            FriendRequestAdapter friendRequestAdapter = this.PlaceComponentResult;
            if (friendRequestAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                friendRequestAdapter = null;
            }
            friendRequestAdapter.MyBillsEntityDataFactory(3, true);
            getFriendRequestPresenter().PlaceComponentResult();
            getFriendRequestPresenter().getAuthRequestContext(10);
        }
        SocialFeedsAdapter socialFeedsAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (socialFeedsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            socialFeedsAdapter = socialFeedsAdapter2;
        }
        socialFeedsAdapter.KClassImpl$Data$declaredNonStaticMembers$2();
        getFeedNotificationPresenter().PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean scheduleImpl() {
        RecyclerView.LayoutManager layoutManager = getBinding().BuiltInFictitiousFunctionClassFactory.getLayoutManager();
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    private final boolean moveToNextValue() {
        SocialFeedsAdapter socialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (socialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            socialFeedsAdapter = null;
        }
        return socialFeedsAdapter.getPlaceComponentResult() <= 0;
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        SocialFeedsAdapter socialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        SocialFeedsAdapter socialFeedsAdapter2 = null;
        if (socialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            socialFeedsAdapter = null;
        }
        SocialFeedsAdapter socialFeedsAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (socialFeedsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            socialFeedsAdapter3 = null;
        }
        if (socialFeedsAdapter.getItem(socialFeedsAdapter3.getPlaceComponentResult() - 1).getErrorConfigVersion != 14) {
            SocialFeedsAdapter socialFeedsAdapter4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (socialFeedsAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                socialFeedsAdapter4 = null;
            }
            SocialFeedsAdapter socialFeedsAdapter5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (socialFeedsAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                socialFeedsAdapter5 = null;
            }
            if (socialFeedsAdapter4.getItem(socialFeedsAdapter5.getPlaceComponentResult() - 1).getErrorConfigVersion != 15) {
                SocialFeedsAdapter socialFeedsAdapter6 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (socialFeedsAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    socialFeedsAdapter6 = null;
                }
                SocialFeedsAdapter socialFeedsAdapter7 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (socialFeedsAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    socialFeedsAdapter2 = socialFeedsAdapter7;
                }
                return socialFeedsAdapter6.getItem(socialFeedsAdapter2.getPlaceComponentResult() - 1).getErrorConfigVersion == 13;
            }
            return true;
        }
        return true;
    }

    private final boolean getAuthRequestContext() {
        return (moveToNextValue() || this.KClassImpl$Data$declaredNonStaticMembers$2 || !NetworkUserEntityData$$ExternalSyntheticLambda0()) ? false : true;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 215;
            int length = getPackageName().length() + 14;
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(false, threadPriority, length, ((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f'}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length2 = super.getResources().getString(R.string.bottom_on_boarding_body_text_top_up_second).substring(8, 9).length() + 221;
                int length3 = super.getResources().getString(R.string.maintenance_page_button).substring(7, 8).length() + 6;
                try {
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr3 = new Object[1];
                    a(b2, (byte) (b2 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(false, length2, length3, ((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), 34 - ImageFormat.getBitsPerPixel(0), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        if (this.moveToNextValue) {
            return;
        }
        getErrorConfigVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(List<FeedViewHolderModel> p0, boolean p1) {
        this.getErrorConfigVersion = p1;
        DatabaseTableConfigUtil();
        this.GetContactSyncConfig = true;
        SocialFeedsAdapter socialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        SocialFeedsAdapter socialFeedsAdapter2 = null;
        if (socialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            socialFeedsAdapter = null;
        }
        if (socialFeedsAdapter.MyBillsEntityDataFactory()) {
            SocialFeedsAdapter socialFeedsAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (socialFeedsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                socialFeedsAdapter2 = socialFeedsAdapter3;
            }
            socialFeedsAdapter2.setItems(p0);
        } else {
            SocialFeedsAdapter socialFeedsAdapter4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (socialFeedsAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                socialFeedsAdapter2 = socialFeedsAdapter4;
            }
            socialFeedsAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        SocialFeedsAdapter socialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (socialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            socialFeedsAdapter = null;
        }
        if (socialFeedsAdapter.getPlaceComponentResult() <= 0) {
            KClassImpl$Data$declaredNonStaticMembers$2(true);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(List<FriendModel> p0) {
        FriendRequestAdapter friendRequestAdapter = null;
        if (p0.isEmpty()) {
            FriendRequestAdapter friendRequestAdapter2 = this.PlaceComponentResult;
            if (friendRequestAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                friendRequestAdapter = friendRequestAdapter2;
            }
            friendRequestAdapter.setItems(new ArrayList());
            return;
        }
        FriendRequestAdapter friendRequestAdapter3 = this.PlaceComponentResult;
        if (friendRequestAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            friendRequestAdapter = friendRequestAdapter3;
        }
        ArrayList arrayList = new ArrayList();
        FriendModel.Companion companion = FriendModel.INSTANCE;
        arrayList.add(FriendModel.Companion.MyBillsEntityDataFactory());
        arrayList.addAll(CollectionsKt.take(p0, 3));
        if (p0.size() > 3) {
            FriendModel.Companion companion2 = FriendModel.INSTANCE;
            arrayList.add(FriendModel.Companion.PlaceComponentResult());
        }
        FriendModel.Companion companion3 = FriendModel.INSTANCE;
        arrayList.add(FriendModel.Companion.BuiltInFictitiousFunctionClassFactory());
        friendRequestAdapter.setItems(arrayList);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(p0 ? 0 : 8);
    }

    private final void DatabaseTableConfigUtil() {
        if (!moveToNextValue()) {
            SocialFeedsAdapter socialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            SocialFeedsAdapter socialFeedsAdapter2 = null;
            if (socialFeedsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                socialFeedsAdapter = null;
            }
            SocialFeedsAdapter socialFeedsAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (socialFeedsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                socialFeedsAdapter3 = null;
            }
            if (socialFeedsAdapter.getItem(socialFeedsAdapter3.getPlaceComponentResult() - 1).getErrorConfigVersion == 6) {
                SocialFeedsAdapter socialFeedsAdapter4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (socialFeedsAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    socialFeedsAdapter4 = null;
                }
                SocialFeedsAdapter socialFeedsAdapter5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (socialFeedsAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    socialFeedsAdapter2 = socialFeedsAdapter5;
                }
                socialFeedsAdapter4.removeItem(socialFeedsAdapter2.getPlaceComponentResult() - 1);
            }
        }
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = Completable.KClassImpl$Data$declaredNonStaticMembers$2(new Callable() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedNotificationActivity.$r8$lambda$UYEBkPBYB3iWn649NfMMeqiOrL0(FeedNotificationActivity.this);
            }
        });
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        addDisposable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(KClassImpl$Data$declaredNonStaticMembers$22, 500L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2)).q_());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == -1) {
            ArrayList parcelableArrayListExtra = data != null ? data.getParcelableArrayListExtra(FriendRequestListActivity.FRIEND_REQUEST_LIST_BUNDLE) : null;
            if (parcelableArrayListExtra == null) {
                parcelableArrayListExtra = CollectionsKt.emptyList();
            }
            getFriendRequestPresenter().getAuthRequestContext(data != null ? data.getBooleanExtra(FriendRequestListActivity.FRIEND_REQUEST_HAS_MORE_BUNDLE, false) : false);
            KClassImpl$Data$declaredNonStaticMembers$2(parcelableArrayListExtra);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lid/dana/social/view/activity/notification/FeedNotificationActivity$Companion;", "", "()V", "BUNDLE_ADD_FRIEND_ENABLED", "", "BUNDLE_REPLY_COMMENT_ENABLED", "BUNDLE_SHOW_COMMENT_BUTTON", "DISABLE_LOAD_MORE_DELAY", "", "FEED_NOTIF_COMMENT_CONTENT_TYPE", "FEED_NOTIF_REACTION_CONTENT_TYPE", "FIRST_POSITION", "", "SOURCE", "openFeedNotificationActivity", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "showCommentButton", "", "addFriendEnabled", "replyCommentEnabled", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void PlaceComponentResult(Context context, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(context, "");
            Intent intent = new Intent(context, FeedNotificationActivity.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("BUNDLE_SHOW_COMMENT_BUTTON", z);
            intent.putExtra("BUNDLE_ADD_FRIEND_ENABLED", z2);
            intent.putExtra("BUNDLE_REPLY_COMMENT_ENABLED", z3);
            context.startActivity(intent);
        }
    }

    public static /* synthetic */ Unit $r8$lambda$UYEBkPBYB3iWn649NfMMeqiOrL0(FeedNotificationActivity feedNotificationActivity) {
        Intrinsics.checkNotNullParameter(feedNotificationActivity, "");
        feedNotificationActivity.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$checkDataReady(FeedNotificationActivity feedNotificationActivity) {
        if (!feedNotificationActivity.DatabaseTableConfigUtil) {
            feedNotificationActivity.MyBillsEntityDataFactory = true;
        }
        feedNotificationActivity.BuiltInFictitiousFunctionClassFactory.onNext(new DataReady(feedNotificationActivity.MyBillsEntityDataFactory, feedNotificationActivity.getAuthRequestContext));
    }

    public static final /* synthetic */ void access$handleNotificationRedirection(FeedNotificationActivity feedNotificationActivity, FeedModel feedModel) {
        String str;
        Intent MyBillsEntityDataFactory;
        String feedNotificationRelatedActivity;
        HashMap<String, String> hashMap = feedModel.lookAheadTest;
        String str2 = (hashMap == null || (feedNotificationRelatedActivity = ExtendInfoUtilKt.getFeedNotificationRelatedActivity(hashMap)) == null) ? "" : feedNotificationRelatedActivity;
        HashMap<String, String> hashMap2 = feedModel.lookAheadTest;
        if (hashMap2 == null || (str = ExtendInfoUtilKt.getFeedNotificationRelatedComment(hashMap2)) == null) {
            str = "";
        }
        FeedModel feedModel2 = new FeedModel(str2, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda4, feedModel.scheduleImpl, feedModel.getErrorConfigVersion, feedModel.moveToNextValue, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda2, feedModel.getNewProxyInstance(), feedModel.lookAheadTest, feedModel.PlaceComponentResult, str2, feedModel.getInitRecordTimeStamp(), feedModel.getAuthRequestContext, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda8, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda7, null, null, null, null, null, null, false, null, 4177920, null);
        if (Intrinsics.areEqual(feedModel2.PlaceComponentResult, "FEED_NOTIFICATION_REACTION") || Intrinsics.areEqual(feedModel2.PlaceComponentResult, "FEED_NOTIFICATION_COMMENT")) {
            SocialActivityDetail.Companion companion = SocialActivityDetail.INSTANCE;
            FeedNotificationActivity feedNotificationActivity2 = feedNotificationActivity;
            Bundle extras = feedNotificationActivity.getIntent().getExtras();
            MyBillsEntityDataFactory = SocialActivityDetail.Companion.MyBillsEntityDataFactory(feedNotificationActivity2, feedModel2, "Feed Notification Page", str, true, extras != null ? extras.getBoolean("BUNDLE_REPLY_COMMENT_ENABLED", false) : false, false);
            feedNotificationActivity.startActivity(MyBillsEntityDataFactory);
        }
    }

    public static final /* synthetic */ void access$onTouchBottom(FeedNotificationActivity feedNotificationActivity) {
        if (feedNotificationActivity.getAuthRequestContext()) {
            feedNotificationActivity.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            if (feedNotificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                SocialFeedsAdapter socialFeedsAdapter = feedNotificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (socialFeedsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    socialFeedsAdapter = null;
                }
                socialFeedsAdapter.appendItem(new FeedViewHolderModel(6, null, null, null, null, false, 60, null));
            }
            feedNotificationActivity.getFeedNotificationPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static final /* synthetic */ void access$openFriendRequestActivity(FeedNotificationActivity feedNotificationActivity) {
        Intent intent = new Intent(feedNotificationActivity, FriendRequestListActivity.class);
        intent.putParcelableArrayListExtra(FriendRequestListActivity.FRIEND_REQUEST_LIST_BUNDLE, new ArrayList<>(feedNotificationActivity.getFriendRequestPresenter().getAuthRequestContext()));
        intent.putExtra(FriendRequestListActivity.FRIEND_REQUEST_HAS_MORE_BUNDLE, feedNotificationActivity.getFriendRequestPresenter().getScheduleImpl());
        intent.putExtra(FriendRequestListActivity.FRIEND_REQUEST_MIN_ID_BUNDLE, feedNotificationActivity.getFriendRequestPresenter().getLookAheadTest());
        feedNotificationActivity.startActivityForResult(intent, 999);
    }

    public static final /* synthetic */ void access$setInitialDataToAdapter(FeedNotificationActivity feedNotificationActivity) {
        feedNotificationActivity.PlaceComponentResult(feedNotificationActivity.getFeedNotificationPresenter().MyBillsEntityDataFactory(), feedNotificationActivity.getFeedNotificationPresenter().getBuiltInFictitiousFunctionClassFactory());
        feedNotificationActivity.KClassImpl$Data$declaredNonStaticMembers$2(feedNotificationActivity.getFriendRequestPresenter().getAuthRequestContext());
    }

    public static final /* synthetic */ void access$showSuccessSnackbar(FeedNotificationActivity feedNotificationActivity, String str) {
        ConstraintLayout constraintLayout = feedNotificationActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        CustomSnackbar.Builder MyBillsEntityDataFactory = new CustomSnackbar.Builder(constraintLayout).MyBillsEntityDataFactory(SnackbarState.SUCCESS);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_success;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = 8;
        MyBillsEntityDataFactory.moveToNextValue = 1000;
        MyBillsEntityDataFactory.initRecordTimeStamp = feedNotificationActivity.getString(R.string.approve_friend_request_success_message, str);
        SnackbarPosition snackbarPosition = SnackbarPosition.TOP;
        Intrinsics.checkNotNullParameter(snackbarPosition, "");
        MyBillsEntityDataFactory.GetContactSyncConfig = snackbarPosition;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final /* synthetic */ void access$showToast(FeedNotificationActivity feedNotificationActivity, int i, int i2, String str, String str2) {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.BuiltInFictitiousFunctionClassFactory(feedNotificationActivity, i, i2, str, str2);
    }

    public static final /* synthetic */ void access$updateAllNotificationReadStatus(FeedNotificationActivity feedNotificationActivity) {
        List<FeedModel> list;
        SocialFeedsAdapter socialFeedsAdapter = feedNotificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (socialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            socialFeedsAdapter = null;
        }
        List<FeedViewHolderModel> items = socialFeedsAdapter.getItems();
        if (items != null) {
            int i = 0;
            for (Object obj : items) {
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FeedViewHolderModel feedViewHolderModel = (FeedViewHolderModel) obj;
                if (getAuthRequestContext(feedViewHolderModel.getErrorConfigVersion)) {
                    if (feedViewHolderModel.MyBillsEntityDataFactory == null) {
                        GroupedFeedModel groupedFeedModel = feedViewHolderModel.BuiltInFictitiousFunctionClassFactory;
                        if (groupedFeedModel != null && (list = groupedFeedModel.BuiltInFictitiousFunctionClassFactory) != null) {
                            List<FeedModel> list2 = list;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                            Iterator<T> it = list2.iterator();
                            while (it.hasNext()) {
                                ((FeedModel) it.next()).newProxyInstance = true;
                                arrayList.add(Unit.INSTANCE);
                            }
                        }
                        SocialFeedsAdapter socialFeedsAdapter2 = feedNotificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (socialFeedsAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            socialFeedsAdapter2 = null;
                        }
                        socialFeedsAdapter2.notifyItemChanged(i);
                    } else {
                        FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
                        if (feedModel != null) {
                            feedModel.newProxyInstance = true;
                            SocialFeedsAdapter socialFeedsAdapter3 = feedNotificationActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            if (socialFeedsAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                socialFeedsAdapter3 = null;
                            }
                            socialFeedsAdapter3.notifyItemChanged(i);
                        }
                    }
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showToast$default(FeedNotificationActivity feedNotificationActivity, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        CustomToast.BuiltInFictitiousFunctionClassFactory(feedNotificationActivity, i, i2, str, str2);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        SocialCommonComponent socialCommonComponent = getDanaApplication().getSocialCommonComponent();
        if (socialCommonComponent != null) {
            socialCommonComponent.PlaceComponentResult(new FeedNotificationModule(new FeedNotificationContract.View() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$initComponent$1$1
                @Override // id.dana.social.contract.notification.FeedNotificationContract.View
                public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                    return "Feeds Notification";
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
                public final void showProgress() {
                    SocialFeedsAdapter socialFeedsAdapter;
                    SocialFeedsAdapter socialFeedsAdapter2;
                    socialFeedsAdapter = FeedNotificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    SocialFeedsAdapter socialFeedsAdapter3 = null;
                    if (socialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        socialFeedsAdapter = null;
                    }
                    if (socialFeedsAdapter.getPlaceComponentResult() <= 0) {
                        socialFeedsAdapter2 = FeedNotificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (socialFeedsAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            socialFeedsAdapter3 = socialFeedsAdapter2;
                        }
                        socialFeedsAdapter3.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                    SocialFeedsAdapter socialFeedsAdapter;
                    socialFeedsAdapter = FeedNotificationActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (socialFeedsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        socialFeedsAdapter = null;
                    }
                    List<FeedViewHolderModel> items = socialFeedsAdapter.getItems();
                    Intrinsics.checkNotNullExpressionValue(items, "");
                    if (CollectionsKt.removeAll((List) items, (Function1) new Function1<FeedViewHolderModel, Boolean>() { // from class: id.dana.social.adapter.SocialFeedsAdapter$removeNotifShimmer$removed$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(FeedViewHolderModel feedViewHolderModel) {
                            return Boolean.valueOf(feedViewHolderModel.getErrorConfigVersion == 17);
                        }
                    })) {
                        socialFeedsAdapter.notifyDataSetChanged();
                    }
                    FeedNotificationActivity.this.GetContactSyncConfig = true;
                }

                @Override // id.dana.social.contract.notification.FeedNotificationContract.View
                public final void PlaceComponentResult(List<FeedViewHolderModel> p0, boolean p1, boolean p2) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FeedNotificationActivity.this.moveToNextValue = false;
                    if (!p1) {
                        FeedNotificationActivity.this.PlaceComponentResult(p0, p2);
                        return;
                    }
                    FeedNotificationActivity.this.getAuthRequestContext = true;
                    FeedNotificationActivity.access$checkDataReady(FeedNotificationActivity.this);
                }

                @Override // id.dana.social.contract.notification.FeedNotificationContract.View
                public final void BuiltInFictitiousFunctionClassFactory(List<FeedViewHolderModel> p0, boolean p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FeedNotificationActivity.this.moveToNextValue = false;
                    FeedNotificationActivity.this.getErrorConfigVersion = p1;
                    FeedNotificationActivity.this.getAuthRequestContext = true;
                    FeedNotificationActivity.access$checkDataReady(FeedNotificationActivity.this);
                }

                @Override // id.dana.social.contract.notification.FeedNotificationContract.View
                public final void MyBillsEntityDataFactory() {
                    FeedNotificationActivity.access$updateAllNotificationReadStatus(FeedNotificationActivity.this);
                    FeedNotificationActivity.this.getErrorConfigVersion();
                    FeedNotificationActivity feedNotificationActivity = FeedNotificationActivity.this;
                    String string = feedNotificationActivity.getString(R.string.feed_notification_read_all_visible_success);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    String string2 = FeedNotificationActivity.this.getString(R.string.lblSuccessfullyMarkAllNotif);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    FeedNotificationActivity.access$showToast(feedNotificationActivity, R.drawable.ic_check_24_green50_filled_circle, R.drawable.bg_rounded_border_green_50, string, string2);
                }

                @Override // id.dana.social.contract.notification.FeedNotificationContract.View
                public final void PlaceComponentResult() {
                    FeedNotificationActivity feedNotificationActivity = FeedNotificationActivity.this;
                    String string = feedNotificationActivity.getString(R.string.feed_notification_read_all_visible_error);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    FeedNotificationActivity.showToast$default(feedNotificationActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_border_red_50, string, null, 8, null);
                }

                @Override // id.dana.social.contract.notification.FeedNotificationContract.View
                public final String BuiltInFictitiousFunctionClassFactory() {
                    String shownErrorMessage;
                    shownErrorMessage = FeedNotificationActivity.this.getShownErrorMessage();
                    return shownErrorMessage == null ? "" : shownErrorMessage;
                }
            }), new FriendRequestListModule(new FriendRequestContract.View() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$initComponent$1$2
                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(Throwable th, String str, String str2) {
                    FriendRequestContract.View.CC.PlaceComponentResult(th, str, str2);
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

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void PlaceComponentResult(List<FriendModel> p0, boolean p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FeedNotificationActivity.this.MyBillsEntityDataFactory = true;
                    FeedNotificationActivity.access$checkDataReady(FeedNotificationActivity.this);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void getAuthRequestContext() {
                    FeedNotificationActivity.this.MyBillsEntityDataFactory = true;
                    FeedNotificationActivity.access$checkDataReady(FeedNotificationActivity.this);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void MyBillsEntityDataFactory(FriendModel p0) {
                    FriendRequestAdapter friendRequestAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    FeedNotificationActivity.this.getFriendshipAnalyticTracker().PlaceComponentResult("Feed Notification Page");
                    FeedNotificationActivity.access$showSuccessSnackbar(FeedNotificationActivity.this, p0.lookAheadTest);
                    friendRequestAdapter = FeedNotificationActivity.this.PlaceComponentResult;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    FeedNotificationActivity.this.getFriendRequestPresenter().BuiltInFictitiousFunctionClassFactory();
                    FeedNotificationActivity.this.getErrorConfigVersion();
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void getAuthRequestContext(FriendModel p0) {
                    FriendRequestAdapter friendRequestAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    friendRequestAdapter = FeedNotificationActivity.this.PlaceComponentResult;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PENDING);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(FriendModel p0) {
                    FriendRequestAdapter friendRequestAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    FeedNotificationActivity.this.getFriendshipAnalyticTracker().getAuthRequestContext("Feed Notification Page");
                    friendRequestAdapter = FeedNotificationActivity.this.PlaceComponentResult;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    FeedNotificationActivity.this.getFriendRequestPresenter().BuiltInFictitiousFunctionClassFactory();
                    FeedNotificationActivity.this.getErrorConfigVersion();
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void PlaceComponentResult(FriendModel p0) {
                    FriendRequestAdapter friendRequestAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    friendRequestAdapter = FeedNotificationActivity.this.PlaceComponentResult;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PENDING);
                }
            })).getAuthRequestContext(this);
        }
        registerPresenter(getFeedNotificationPresenter(), getFriendRequestPresenter());
        Bundle extras = getIntent().getExtras();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = extras != null ? extras.getBoolean("BUNDLE_SHOW_COMMENT_BUTTON") : false;
        Bundle extras2 = getIntent().getExtras();
        this.DatabaseTableConfigUtil = extras2 != null ? extras2.getBoolean("BUNDLE_ADD_FRIEND_ENABLED") : false;
        SocialFeedsAdapter socialFeedsAdapter = new SocialFeedsAdapter();
        socialFeedsAdapter.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        FeedNotificationActivity$notificationClickListener$1 feedNotificationActivity$notificationClickListener$1 = this.scheduleImpl;
        Intrinsics.checkNotNullParameter(feedNotificationActivity$notificationClickListener$1, "");
        socialFeedsAdapter.getErrorConfigVersion = feedNotificationActivity$notificationClickListener$1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = socialFeedsAdapter;
        FriendRequestAdapter friendRequestAdapter = new FriendRequestAdapter(FriendRequestAdapter.FriendRequestSectionFontType.BOLD_GREY, new FriendRequestAdapter.FriendRequestListener() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$setupNotificationListAdapter$2
            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void BuiltInFictitiousFunctionClassFactory(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter2 = FeedNotificationActivity.this.PlaceComponentResult;
                if (friendRequestAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter2 = null;
                }
                friendRequestAdapter2.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FeedNotificationActivity.this.getFriendRequestPresenter().BuiltInFictitiousFunctionClassFactory(p0);
            }

            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void getAuthRequestContext(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter2 = FeedNotificationActivity.this.PlaceComponentResult;
                if (friendRequestAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter2 = null;
                }
                friendRequestAdapter2.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FeedNotificationActivity.this.getFriendRequestPresenter().getAuthRequestContext(p0);
            }

            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void PlaceComponentResult() {
                FeedNotificationActivity.access$openFriendRequestActivity(FeedNotificationActivity.this);
            }
        });
        this.PlaceComponentResult = friendRequestAdapter;
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        FriendRequestAdapter friendRequestAdapter2 = null;
        if (friendRequestAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendRequestAdapter = null;
        }
        adapterArr[0] = friendRequestAdapter;
        SocialFeedsAdapter socialFeedsAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (socialFeedsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            socialFeedsAdapter2 = null;
        }
        adapterArr[1] = socialFeedsAdapter2;
        getBinding().BuiltInFictitiousFunctionClassFactory.setAdapter(new ConcatAdapter(adapterArr));
        ActivityFeedNotificationBinding binding = getBinding();
        binding.PlaceComponentResult.setPtrHandler(new PtrHandler() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$initPullToRefreshComponent$1$1
            @Override // in.srain.cube.views.ptr.PtrHandler
            public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                return true;
            }

            @Override // in.srain.cube.views.ptr.PtrHandler
            public final void onRefreshBegin(PtrFrameLayout p0) {
                boolean lookAheadTest;
                LottieAnimationView lottieAnimationView;
                lookAheadTest = FeedNotificationActivity.this.lookAheadTest();
                if (lookAheadTest) {
                    lottieAnimationView = FeedNotificationActivity.this.lookAheadTest;
                    if (lottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lottieAnimationView = null;
                    }
                    lottieAnimationView.playAnimation();
                }
                FeedNotificationActivity.this.getErrorConfigVersion();
            }
        });
        binding.PlaceComponentResult.disableWhenHorizontalMove(true);
        final PtrClassicFrameLayout ptrClassicFrameLayout = getBinding().PlaceComponentResult;
        ptrClassicFrameLayout.setHeaderView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
        View findViewById = ptrClassicFrameLayout.getHeaderView().findViewById(R.id.lav_loading_animation);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById;
        this.lookAheadTest = lottieAnimationView;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lottieAnimationView = null;
        }
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$initPullToRefreshHeaderView$1$1
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
                Intrinsics.checkNotNullParameter(p0, "");
                PtrClassicFrameLayout.this.refreshComplete();
                this.GetContactSyncConfig = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p0) {
                boolean z;
                boolean lookAheadTest;
                LottieAnimationView lottieAnimationView2;
                Intrinsics.checkNotNullParameter(p0, "");
                z = this.GetContactSyncConfig;
                if (z) {
                    lookAheadTest = this.lookAheadTest();
                    if (lookAheadTest) {
                        lottieAnimationView2 = this.lookAheadTest;
                        if (lottieAnimationView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            lottieAnimationView2 = null;
                        }
                        lottieAnimationView2.cancelAnimation();
                    }
                }
            }
        });
        if (this.DatabaseTableConfigUtil) {
            FriendRequestAdapter friendRequestAdapter3 = this.PlaceComponentResult;
            if (friendRequestAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                friendRequestAdapter2 = friendRequestAdapter3;
            }
            friendRequestAdapter2.MyBillsEntityDataFactory(3, true);
            getFriendRequestPresenter().getAuthRequestContext(10);
        }
        getFeedNotificationPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getBinding().BuiltInFictitiousFunctionClassFactory.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$initScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                boolean scheduleImpl;
                ActivityFeedNotificationBinding binding2;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                scheduleImpl = FeedNotificationActivity.this.scheduleImpl();
                binding2 = FeedNotificationActivity.this.getBinding();
                binding2.PlaceComponentResult.setEnabled(scheduleImpl);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p0, int p1) {
                boolean z;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrollStateChanged(p0, p1);
                if (p0.canScrollVertically(130)) {
                    return;
                }
                z = FeedNotificationActivity.this.getErrorConfigVersion;
                if (z) {
                    FeedNotificationActivity.access$onTouchBottom(FeedNotificationActivity.this);
                }
            }
        });
        if (this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory()) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new DefaultObserver<DataReady>() { // from class: id.dana.social.view.activity.notification.FeedNotificationActivity$initContentObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                DataReady dataReady = (DataReady) obj;
                Intrinsics.checkNotNullParameter(dataReady, "");
                if (dataReady.getMyBillsEntityDataFactory() && dataReady.getGetAuthRequestContext()) {
                    FeedNotificationActivity.access$setInitialDataToAdapter(FeedNotificationActivity.this);
                }
            }
        });
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (NetworkUserEntityData$$ExternalSyntheticLambda6 ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
