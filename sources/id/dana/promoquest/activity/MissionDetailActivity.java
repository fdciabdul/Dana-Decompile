package id.dana.promoquest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.core.widget.NestedScrollView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.common.DividerItemDecoration;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.promoquest.quest.MissionContract;
import id.dana.contract.promoquest.redeem.RedeemMissionContract;
import id.dana.contract.promoquest.redeem.RedeemQuestContract;
import id.dana.contract.promoquest.track.TrackQuestContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMissionComponent;
import id.dana.di.modules.MissionModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.RedeemQuestModule;
import id.dana.di.modules.RedeemUserMissionModule;
import id.dana.di.modules.TrackQuestModule;
import id.dana.domain.promoquest.model.PrizeInfoEntity;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.extension.ContextExtKt;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.promoquest.PromoQuestListener;
import id.dana.promoquest.adapter.MissionDetailQuestAdapter;
import id.dana.promoquest.extension.PrizeInfoEntityExtKt;
import id.dana.promoquest.fragment.PromoQuestRewardDialogFragment;
import id.dana.promoquest.handler.PromoQuestActionFactory;
import id.dana.promoquest.handler.deeplink.PromoQuestDeeplinkActionListener;
import id.dana.promoquest.model.MissionModel;
import id.dana.promoquest.model.QuestModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ErrorUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 b2\u00020\u0001:\u0001bB\u0007¢\u0006\u0004\ba\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0005\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002¢\u0006\u0004\b\u000e\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0018\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0015\u001a\u00020+8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001b\u0010,R\"\u0010.\u001a\u00020-8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u0010\u0014\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010\u001b\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010)\u001a\u00020J8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0018\u00105\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010&\u001a\u00020W8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010[\u001a\u00020Z8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`"}, d2 = {"Lid/dana/promoquest/activity/MissionDetailActivity;", "Lid/dana/base/BaseActivity;", "Ljava/util/Date;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/Date;)Ljava/lang/String;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "PlaceComponentResult", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "(Z)V", "p1", "getAuthRequestContext", "(ZZ)V", "moveToNextValue", "scheduleImpl", "", "Lid/dana/promoquest/model/QuestModel;", "(Ljava/util/List;)V", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/Date;", "Lid/dana/promoquest/adapter/MissionDetailQuestAdapter;", "lookAheadTest", "Lid/dana/promoquest/adapter/MissionDetailQuestAdapter;", "Lid/dana/promoquest/model/MissionModel;", "Lid/dana/promoquest/model/MissionModel;", "Lid/dana/contract/promoquest/quest/MissionContract$Presenter;", "missionPresenter", "Lid/dana/contract/promoquest/quest/MissionContract$Presenter;", "getMissionPresenter", "()Lid/dana/contract/promoquest/quest/MissionContract$Presenter;", "setMissionPresenter", "(Lid/dana/contract/promoquest/quest/MissionContract$Presenter;)V", "Lid/dana/promoquest/handler/PromoQuestActionFactory;", "getErrorConfigVersion", "Lid/dana/promoquest/handler/PromoQuestActionFactory;", "GetContactSyncConfig", "I", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/promoquest/PromoQuestListener$RedeemMissionResultListener;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/promoquest/PromoQuestListener$RedeemMissionResultListener;", "Lid/dana/contract/promoquest/redeem/RedeemMissionContract$Presenter;", "redeemMissionPresenter", "Lid/dana/contract/promoquest/redeem/RedeemMissionContract$Presenter;", "getRedeemMissionPresenter", "()Lid/dana/contract/promoquest/redeem/RedeemMissionContract$Presenter;", "setRedeemMissionPresenter", "(Lid/dana/contract/promoquest/redeem/RedeemMissionContract$Presenter;)V", "Lid/dana/promoquest/PromoQuestListener$RedeemQuestResult;", "initRecordTimeStamp", "Lid/dana/promoquest/PromoQuestListener$RedeemQuestResult;", "Lid/dana/contract/promoquest/redeem/RedeemQuestContract$Presenter;", "redeemQuestPresenter", "Lid/dana/contract/promoquest/redeem/RedeemQuestContract$Presenter;", "getRedeemQuestPresenter", "()Lid/dana/contract/promoquest/redeem/RedeemQuestContract$Presenter;", "setRedeemQuestPresenter", "(Lid/dana/contract/promoquest/redeem/RedeemQuestContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/promoquest/PromoQuestListener$TrackQuestResultListener;", "DatabaseTableConfigUtil", "Lid/dana/promoquest/PromoQuestListener$TrackQuestResultListener;", "Lid/dana/contract/promoquest/track/TrackQuestContract$Presenter;", "trackPresenter", "Lid/dana/contract/promoquest/track/TrackQuestContract$Presenter;", "getTrackPresenter", "()Lid/dana/contract/promoquest/track/TrackQuestContract$Presenter;", "setTrackPresenter", "(Lid/dana/contract/promoquest/track/TrackQuestContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissionDetailActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private static int PrepareContext;
    private static char[] isLayoutRequested;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private PromoQuestListener.TrackQuestResultListener NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Date KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private PromoQuestListener.RedeemMissionResultListener scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private SkeletonScreen getErrorConfigVersion;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private PromoQuestActionFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private PromoQuestListener.RedeemQuestResult lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private MissionDetailQuestAdapter getAuthRequestContext;
    @Inject
    public MissionContract.Presenter missionPresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    @Inject
    public RedeemMissionContract.Presenter redeemMissionPresenter;
    @Inject
    public RedeemQuestContract.Presenter redeemQuestPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MissionModel MyBillsEntityDataFactory;
    @Inject
    public TrackQuestContract.Presenter trackPresenter;
    public static final byte[] $$a = {104, -68, 0, 44, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 236;
    public static final byte[] getAuthRequestContext = {97, -108, 86, -98, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 242;

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0023 -> B:23:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 23 - r8
            int r6 = r6 + 4
            int r7 = 106 - r7
            byte[] r0 = id.dana.promoquest.activity.MissionDetailActivity.getAuthRequestContext
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = 0
            r3 = r6
            r7 = r8
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r6 = r6 + 1
            int r8 = r8 + r3
            int r8 = r8 + (-4)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promoquest.activity.MissionDetailActivity.a(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.promoquest.activity.MissionDetailActivity.$$a
            int r9 = r9 * 2
            int r9 = r9 + 75
            int r7 = r7 + 4
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r9 = r8
            r3 = r9
            r4 = 0
            r8 = r7
            goto L2e
        L16:
            r3 = 0
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            int r7 = r7 + 1
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2e:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promoquest.activity.MissionDetailActivity.c(byte, int, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent generateIntent(Context context, MissionModel missionModel) {
        return Companion.BuiltInFictitiousFunctionClassFactory(context, missionModel);
    }

    static void getAuthRequestContext() {
        isLayoutRequested = new char[]{39865, 39850, 39860, 39846, 39851, 39857, 39786, 39847, 39752, 39863, 39861, 39853, 39841, 39749, 39848, 39769, 39844, 39842, 39748, 39856, 39845, 39852, 39779, 39778, 39776, 39784, 39777, 39858, 39782, 39785, 39783, 39780, 39862, 39781, 39774, 39787, 39859, 39849};
        NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        PrepareContext = 909155096;
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(null, 127 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(null, 127 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(null, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 127, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(null, 127 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(null, 127 - (ViewConfiguration.getLongPressTimeout() >> 16), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(null, 127 - KeyEvent.keyCodeFromString(""), new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(null, 127 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 54, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 4, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[68], $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 14 - MotionEvent.axisFromString(""), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 800, 15 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.lastIndexOf("", '0'), 29 - (Process.myTid() >> 22), (char) (57994 - KeyEvent.getDeadChar(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.makeMeasureSpec(0, 0), 15 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((-1) - MotionEvent.axisFromString(""))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, (-16777181) - Color.rgb(0, 0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {93563267, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), (Process.myPid() >> 22) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.resolveSize(0, 0), ExpandableListView.getPackedPositionGroup(0L) + 46, (char) ((Process.getThreadPriority(0) + 20) >> 6));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[28]), (byte) (-$$a[8]), (byte) (-$$a[9]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {93563267, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 118, 4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 38967));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[28]), (byte) (-$$a[8]), (byte) (-$$a[9]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (Process.myTid() >> 22) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {93563267, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 107, 3 - TextUtils.indexOf("", "", 0, 0), (char) View.MeasureSpec.getSize(0));
                        byte b = $$a[40];
                        byte b2 = $$a[2];
                        Object[] objArr34 = new Object[1];
                        c(b, b2, b2, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), View.MeasureSpec.getSize(0) + 35, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {93563267, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.layout_mission_detail;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(null, super.getResources().getString(R.string.add_asset_loyalty).substring(0, 9).length() + 118, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr3);
                Object[] objArr4 = new Object[1];
                b(null, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, View.combineMeasuredStates(0, 0) + 35, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, 18 - TextUtils.indexOf("", "", 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(null, getPackageName().codePointAt(5) + 17, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(null, 127 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", ""), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 911, 18 - View.combineMeasuredStates(0, 0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getReadLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.readLinkPropertiesPresenter = presenter;
    }

    @JvmName(name = "getTrackPresenter")
    public final TrackQuestContract.Presenter getTrackPresenter() {
        TrackQuestContract.Presenter presenter = this.trackPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTrackPresenter")
    public final void setTrackPresenter(TrackQuestContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.trackPresenter = presenter;
    }

    @JvmName(name = "getRedeemQuestPresenter")
    public final RedeemQuestContract.Presenter getRedeemQuestPresenter() {
        RedeemQuestContract.Presenter presenter = this.redeemQuestPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRedeemQuestPresenter")
    public final void setRedeemQuestPresenter(RedeemQuestContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.redeemQuestPresenter = presenter;
    }

    @JvmName(name = "getMissionPresenter")
    public final MissionContract.Presenter getMissionPresenter() {
        MissionContract.Presenter presenter = this.missionPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMissionPresenter")
    public final void setMissionPresenter(MissionContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.missionPresenter = presenter;
    }

    @JvmName(name = "getRedeemMissionPresenter")
    public final RedeemMissionContract.Presenter getRedeemMissionPresenter() {
        RedeemMissionContract.Presenter presenter = this.redeemMissionPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRedeemMissionPresenter")
    public final void setRedeemMissionPresenter(RedeemMissionContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.redeemMissionPresenter = presenter;
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        try {
            Object[] objArr = new Object[1];
            a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr2);
            Object[] objArr3 = new Object[1];
            b(null, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(null, getPackageName().length() + 120, new byte[]{-125, -122, -114, -115, -116}, null, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    b(null, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 127, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(null, ImageFormat.getBitsPerPixel(0) + 128, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        b(null, super.getResources().getString(R.string.home_shopping_tutorial_order_step_1).substring(34, 36).length() + 125, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        b(null, 126 - MotionEvent.axisFromString(""), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                        String str2 = (String) objArr8[0];
                        try {
                            Object[] objArr9 = new Object[1];
                            a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr10);
                            Object[] objArr11 = new Object[1];
                            b(null, ((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr11);
                            String str3 = (String) objArr11[0];
                            try {
                                Object[] objArr12 = new Object[1];
                                a(getAuthRequestContext[25], getAuthRequestContext[32], getAuthRequestContext[25], objArr12);
                                Class<?> cls5 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                a((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[13], getAuthRequestContext[27], objArr13);
                                Object[] objArr14 = new Object[1];
                                b(null, ((ApplicationInfo) cls5.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr14);
                                String str4 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                b(null, 127 - KeyEvent.keyCodeFromString(""), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr15);
                                try {
                                    Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), Process.getGidForName("") + 19, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr16);
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
                Object[] objArr17 = new Object[1];
                a((byte) 37, getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr17);
                Class<?> cls6 = Class.forName((String) objArr17[0]);
                Object[] objArr18 = new Object[1];
                a(getAuthRequestContext[35], getAuthRequestContext[7], (byte) (-getAuthRequestContext[30]), objArr18);
                try {
                    Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getDoubleTapTimeout() >> 16), TextUtils.getOffsetAfter("", 0) + 4, (char) KeyEvent.keyCodeFromString(""));
                        byte b = $$a[40];
                        byte b2 = $$a[2];
                        Object[] objArr20 = new Object[1];
                        c(b, b2, b2, objArr20);
                        obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                    int i = ((int[]) objArr21[1])[0];
                    if (((int[]) objArr21[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 35 - Color.blue(0), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr22 = {913250392, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr22);
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
                    overridePendingTransition(0, 0);
                    super.onCreate(savedInstanceState);
                    ContextExtKt.PlaceComponentResult(this);
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

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0139, code lost:
    
        if (r3.equals("COMPLETE") != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x013b, code lost:
    
        com.fullstory.instrumentation.InstrumentInjector.Resources_setImageResource((android.widget.ImageView) _$_findCachedViewById(id.dana.R.id.iv_missionstatus), id.dana.R.drawable.ic_promo_quest_mission_completed);
        r0.setText(r0.getResources().getString(id.dana.R.string.mission_completed));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00f5, code lost:
    
        if (r3.equals("FINISH") == false) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promoquest.activity.MissionDetailActivity.KClassImpl$Data$declaredNonStaticMembers$2():void");
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2(Date p0) {
        String string;
        int PlaceComponentResult2 = (int) DateTimeUtil.PlaceComponentResult(p0);
        if (PlaceComponentResult2 > 0) {
            string = getResources().getQuantityString(R.plurals.f46632131820547, PlaceComponentResult2, Integer.valueOf(PlaceComponentResult2));
        } else {
            if (p0 == null) {
                p0 = new Date();
            }
            int MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(p0);
            if (MyBillsEntityDataFactory > 0) {
                string = getResources().getQuantityString(R.plurals.f46642131820548, MyBillsEntityDataFactory, Integer.valueOf(MyBillsEntityDataFactory));
            } else if (MyBillsEntityDataFactory >= 0) {
                string = getResources().getString(R.string.expiring_soon);
            } else {
                string = getResources().getString(R.string.mission_expired);
            }
        }
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        ((RelativeLayout) _$_findCachedViewById(R.id.rv_missionprize)).setVisibility(p0 ? 0 : 8);
        if (p0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a17d1_pinfamilyaccountpresenter_removefamilyaccount_2);
            MissionModel missionModel = this.MyBillsEntityDataFactory;
            MissionModel missionModel2 = null;
            if (missionModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                missionModel = null;
            }
            textView.setText(missionModel.DatabaseTableConfigUtil);
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_missionprize_subdescription);
            MissionModel missionModel3 = this.MyBillsEntityDataFactory;
            if (missionModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                missionModel3 = null;
            }
            textView2.setText(missionModel3.getErrorConfigVersion);
            ((LinearLayout) _$_findCachedViewById(R.id.vg_missiondetail_action)).setVisibility(8);
            ((Button) _$_findCachedViewById(R.id.btn_missionprize_action)).setEnabled(true);
            ((Button) _$_findCachedViewById(R.id.btn_missionprize_action)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promoquest.activity.MissionDetailActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MissionDetailActivity.m2789$r8$lambda$4EbeuDTKwo0eYhyl8VAwndy8ts(MissionDetailActivity.this, view);
                }
            });
            MissionModel missionModel4 = this.MyBillsEntityDataFactory;
            if (missionModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                missionModel2 = missionModel4;
            }
            String str = missionModel2.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (Intrinsics.areEqual(str, "FINISH")) {
                InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.iv_missionprize_status), R.drawable.ic_promo_quest_item_claimed);
            } else if (Intrinsics.areEqual(str, "COMPLETE")) {
                InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.iv_missionprize_status), R.drawable.ic_promo_quest_item_not_claimed);
                ((Button) _$_findCachedViewById(R.id.btn_missionprize_action)).setText(R.string.redeem);
                ((LinearLayout) _$_findCachedViewById(R.id.vg_missiondetail_action)).setVisibility(0);
            } else {
                InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.iv_missionprize_status), R.drawable.ic_promo_quest_item_not_available);
            }
        }
    }

    private final void getAuthRequestContext(boolean p0, boolean p1) {
        ((ConstraintLayout) _$_findCachedViewById(R.id.rv_missiontnc)).setVisibility(p0 ? 0 : 8);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_tnc_desc);
        Unit unit = null;
        MissionModel missionModel = null;
        MissionModel missionModel2 = null;
        unit = null;
        if (textView != null) {
            MissionModel missionModel3 = this.MyBillsEntityDataFactory;
            if (missionModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                missionModel3 = null;
            }
            if (!(missionModel3.isLayoutRequested.length() > 0)) {
                textView = null;
            }
            if (textView != null) {
                textView.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 24) {
                    MissionModel missionModel4 = this.MyBillsEntityDataFactory;
                    if (missionModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        missionModel = missionModel4;
                    }
                    textView.setText(HtmlCompat.PlaceComponentResult(missionModel.isLayoutRequested, 63));
                } else {
                    MissionModel missionModel5 = this.MyBillsEntityDataFactory;
                    if (missionModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        missionModel2 = missionModel5;
                    }
                    textView.setText(HtmlCompat.PlaceComponentResult(missionModel2.isLayoutRequested, 0));
                }
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            Button button = (Button) _$_findCachedViewById(R.id.btn_mission_tnc);
            Intrinsics.checkNotNullExpressionValue(button, "");
            button.setVisibility(p1 ? 0 : 8);
            if (p1) {
                ((Button) _$_findCachedViewById(R.id.btn_mission_tnc)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promoquest.activity.MissionDetailActivity$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MissionDetailActivity.$r8$lambda$Kb_F28bfkvtXqJpkwvAFTHTdBkU(MissionDetailActivity.this, view);
                    }
                });
            }
        }
    }

    private final void PlaceComponentResult(List<QuestModel> p0) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : p0) {
            if (Intrinsics.areEqual(((QuestModel) obj).NetworkUserEntityData$$ExternalSyntheticLambda0, "ACTIVE")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMO_QUEST_DETAILS_OPEN;
        MissionModel missionModel = this.MyBillsEntityDataFactory;
        if (missionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            missionModel = null;
        }
        EventTrackerModel.Builder PlaceComponentResult2 = builder.MyBillsEntityDataFactory(TrackerKey.Property.PROMO_QUEST_NAME, missionModel.DatabaseTableConfigUtil).PlaceComponentResult(TrackerKey.Property.NUMBER_OF_UNCOMPLETED_TASKS, arrayList2.size());
        PlaceComponentResult2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult2, (byte) 0));
    }

    public final void scheduleImpl() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMO_QUEST_FINISH;
        MissionModel missionModel = this.MyBillsEntityDataFactory;
        MissionModel missionModel2 = null;
        if (missionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            missionModel = null;
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.PromoQuestProperties.MISSION_ID, missionModel.initRecordTimeStamp);
        MissionModel missionModel3 = this.MyBillsEntityDataFactory;
        if (missionModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            missionModel2 = missionModel3;
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(TrackerKey.PromoQuestProperties.MISSION_TITLE, missionModel2.DatabaseTableConfigUtil);
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
    }

    private final boolean PlaceComponentResult() {
        Rect rect = new Rect();
        ((NestedScrollView) _$_findCachedViewById(R.id.res_0x7f0a0f48_windowinsetscontrollercompat_impl20)).getDrawingRect(rect);
        float y = ((NestedScrollView) _$_findCachedViewById(R.id.res_0x7f0a0f48_windowinsetscontrollercompat_impl20)).getY();
        return ((float) rect.top) <= y && ((float) rect.bottom) >= ((float) ((NestedScrollView) _$_findCachedViewById(R.id.res_0x7f0a0f48_windowinsetscontrollercompat_impl20)).getHeight()) + y;
    }

    public final void moveToNextValue() {
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((RecyclerView) _$_findCachedViewById(R.id.rv_quest_list));
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_quest_skeleton;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 3;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        this.getErrorConfigVersion = recyclerViewSkeletonScreen;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        MissionModel missionModel = this.MyBillsEntityDataFactory;
        if (missionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            missionModel = null;
        }
        String str = missionModel.initRecordTimeStamp;
        if (str != null) {
            moveToNextValue();
            getMissionPresenter().getAuthRequestContext(str);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/promoquest/activity/MissionDetailActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/promoquest/model/MissionModel;", "p1", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/promoquest/model/MissionModel;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, MissionModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, MissionDetailActivity.class);
            intent.putExtra("MissionDetail.mission", p1);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$4EbeuDTKwo0eYhyl8VAw-ndy8ts */
    public static /* synthetic */ void m2789$r8$lambda$4EbeuDTKwo0eYhyl8VAwndy8ts(MissionDetailActivity missionDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(missionDetailActivity, "");
        RedeemMissionContract.Presenter redeemMissionPresenter = missionDetailActivity.getRedeemMissionPresenter();
        MissionModel missionModel = missionDetailActivity.MyBillsEntityDataFactory;
        if (missionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            missionModel = null;
        }
        String str = missionModel.initRecordTimeStamp;
        if (str != null) {
            redeemMissionPresenter.PlaceComponentResult(str);
        }
    }

    public static /* synthetic */ void $r8$lambda$Kb_F28bfkvtXqJpkwvAFTHTdBkU(MissionDetailActivity missionDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(missionDetailActivity, "");
        missionDetailActivity.getMissionPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$UEb1H10iXEKpzxNB8fXMTf8pDas(MissionDetailActivity missionDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(missionDetailActivity, "");
        missionDetailActivity.onBackPressed();
    }

    public static /* synthetic */ void $r8$lambda$b4yadCrGUw_nVTe4tNgbFJiMovU(MissionDetailActivity missionDetailActivity, String str) {
        Intrinsics.checkNotNullParameter(missionDetailActivity, "");
        ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter = missionDetailActivity.getReadLinkPropertiesPresenter();
        Intrinsics.checkNotNullExpressionValue(str, "");
        readLinkPropertiesPresenter.MyBillsEntityDataFactory(str);
    }

    /* renamed from: $r8$lambda$y5IVlBL64a-KjSWjwOh2rwBm8jY */
    public static /* synthetic */ void m2790$r8$lambda$y5IVlBL64aKjSWjwOh2rwBm8jY(MissionDetailActivity missionDetailActivity, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(missionDetailActivity, "");
        ViewGroup.LayoutParams layoutParams = ((CollapsingToolbarLayout) missionDetailActivity._$_findCachedViewById(R.id.collapsing_toolbar_missiondetail)).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        }
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        layoutParams2.setScrollFlags(missionDetailActivity.PlaceComponentResult() ? 0 : 3);
        ((CollapsingToolbarLayout) missionDetailActivity._$_findCachedViewById(R.id.collapsing_toolbar_missiondetail)).setLayoutParams(layoutParams2);
    }

    public static final /* synthetic */ void access$broadcastMission(MissionDetailActivity missionDetailActivity, boolean z) {
        MissionModel missionModel = missionDetailActivity.MyBillsEntityDataFactory;
        MissionModel missionModel2 = null;
        if (missionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            missionModel = null;
        }
        MissionDetailQuestAdapter missionDetailQuestAdapter = missionDetailActivity.getAuthRequestContext;
        List<QuestModel> items = missionDetailQuestAdapter != null ? missionDetailQuestAdapter.getItems() : null;
        if (items == null) {
            items = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNullParameter(items, "");
        missionModel.newProxyInstance = items;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(missionDetailActivity);
        Intent putExtra = new Intent("PromoQuest.RECEIVE_MISSION").putExtra("PromoQuest.isNeedRefreshWholeList", z);
        MissionModel missionModel3 = missionDetailActivity.MyBillsEntityDataFactory;
        if (missionModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            missionModel2 = missionModel3;
        }
        localBroadcastManager.sendBroadcast(putExtra.putExtra("PromoQuest.mission", missionModel2));
    }

    public static final /* synthetic */ void access$hideSkeleton(MissionDetailActivity missionDetailActivity) {
        SkeletonScreen skeletonScreen = missionDetailActivity.getErrorConfigVersion;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        missionDetailActivity.getErrorConfigVersion = null;
    }

    public static final /* synthetic */ void access$updateCurrentQuest(MissionDetailActivity missionDetailActivity, String str, String str2) {
        List<QuestModel> items;
        MissionDetailQuestAdapter missionDetailQuestAdapter = missionDetailActivity.getAuthRequestContext;
        if (missionDetailQuestAdapter != null && (items = missionDetailQuestAdapter.getItems()) != null) {
            int i = 0;
            for (Object obj : items) {
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                QuestModel questModel = (QuestModel) obj;
                if (Intrinsics.areEqual(questModel.getErrorConfigVersion, str)) {
                    questModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
                    MissionDetailQuestAdapter missionDetailQuestAdapter2 = missionDetailActivity.getAuthRequestContext;
                    if (missionDetailQuestAdapter2 != null) {
                        missionDetailQuestAdapter2.notifyItemChanged(i);
                    }
                }
                i++;
            }
        }
        MissionDetailQuestAdapter missionDetailQuestAdapter3 = missionDetailActivity.getAuthRequestContext;
        MissionModel missionModel = null;
        List<QuestModel> items2 = missionDetailQuestAdapter3 != null ? missionDetailQuestAdapter3.getItems() : null;
        if (items2 == null) {
            items2 = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : items2) {
            QuestModel questModel2 = (QuestModel) obj2;
            if (Intrinsics.areEqual(questModel2.NetworkUserEntityData$$ExternalSyntheticLambda0, "ACTIVE") || Intrinsics.areEqual(questModel2.NetworkUserEntityData$$ExternalSyntheticLambda0, "COMPLETE")) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        MissionModel missionModel2 = missionDetailActivity.MyBillsEntityDataFactory;
        if (missionModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            missionModel = missionModel2;
        }
        if (missionModel.getMyBillsEntityDataFactory() || !arrayList2.isEmpty()) {
            return;
        }
        missionDetailActivity.scheduleImpl();
    }

    @JvmStatic
    public static final void open(Activity activity, MissionModel missionModel) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(missionModel, "");
        activity.startActivity(Companion.BuiltInFictitiousFunctionClassFactory(activity, missionModel));
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerMissionComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerMissionComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (MissionModule) Preconditions.getAuthRequestContext(new MissionModule(new MissionContract.View() { // from class: id.dana.promoquest.activity.MissionDetailActivity$getMissionModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
            
                if ((r0 == null || r0.isEmpty()) == false) goto L18;
             */
            @Override // id.dana.contract.promoquest.quest.MissionContract.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void getAuthRequestContext(id.dana.promoquest.model.MissionModel r4) {
                /*
                    r3 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                    id.dana.promoquest.activity.MissionDetailActivity r0 = id.dana.promoquest.activity.MissionDetailActivity.this
                    id.dana.promoquest.activity.MissionDetailActivity.access$setMissionModel$p(r0, r4)
                    java.lang.String r0 = r4.initRecordTimeStamp
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L1a
                    int r0 = r0.length()
                    if (r0 == 0) goto L1a
                    r0 = 0
                    goto L1b
                L1a:
                    r0 = 1
                L1b:
                    if (r0 != 0) goto L2f
                    java.util.List<id.dana.promoquest.model.QuestModel> r0 = r4.newProxyInstance
                    java.util.Collection r0 = (java.util.Collection) r0
                    if (r0 == 0) goto L2b
                    boolean r0 = r0.isEmpty()
                    if (r0 != 0) goto L2b
                    r0 = 0
                    goto L2c
                L2b:
                    r0 = 1
                L2c:
                    if (r0 != 0) goto L2f
                    goto L30
                L2f:
                    r1 = 0
                L30:
                    if (r1 != 0) goto L33
                    r4 = 0
                L33:
                    id.dana.promoquest.activity.MissionDetailActivity r0 = id.dana.promoquest.activity.MissionDetailActivity.this
                    id.dana.promoquest.activity.MissionDetailActivity.access$initViews(r0)
                    if (r4 != 0) goto L44
                    id.dana.promoquest.activity.MissionDetailActivity r4 = id.dana.promoquest.activity.MissionDetailActivity.this
                    r0 = r3
                    id.dana.promoquest.activity.MissionDetailActivity$getMissionModule$1 r0 = (id.dana.promoquest.activity.MissionDetailActivity$getMissionModule$1) r0
                    r4.finish()
                    kotlin.Unit r4 = kotlin.Unit.INSTANCE
                L44:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.promoquest.activity.MissionDetailActivity$getMissionModule$1.getAuthRequestContext(id.dana.promoquest.model.MissionModel):void");
            }

            @Override // id.dana.contract.promoquest.quest.MissionContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                MissionDetailActivity.this.finish();
            }

            @Override // id.dana.contract.promoquest.quest.MissionContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaH5.startContainerFullUrl(p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                MissionDetailActivity.this.moveToNextValue();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                MissionDetailActivity.access$hideSkeleton(MissionDetailActivity.this);
            }
        }));
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = (RedeemQuestModule) Preconditions.getAuthRequestContext(new RedeemQuestModule(new RedeemQuestContract.View() { // from class: id.dana.promoquest.activity.MissionDetailActivity$getRedeemQuestModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.promoquest.redeem.RedeemQuestContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(PrizeInfoEntity p0) {
                PromoQuestListener.RedeemQuestResult redeemQuestResult;
                Intrinsics.checkNotNullParameter(p0, "");
                redeemQuestResult = MissionDetailActivity.this.lookAheadTest;
                if (redeemQuestResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    redeemQuestResult = null;
                }
                redeemQuestResult.KClassImpl$Data$declaredNonStaticMembers$2();
                new PromoQuestRewardDialogFragment(true, new Function0<Unit>() { // from class: id.dana.promoquest.activity.MissionDetailActivity$showRedeemDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PrizeInfoEntity prizeInfoEntity;
                        if (!r1 || (prizeInfoEntity = p0) == null) {
                            return;
                        }
                        PrizeInfoEntityExtKt.PlaceComponentResult(prizeInfoEntity, r3.getDynamicUrlWrapper());
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }).show(MissionDetailActivity.this.getSupportFragmentManager(), "PromoQuestRewardDialogFragment");
            }

            @Override // id.dana.contract.promoquest.redeem.RedeemQuestContract.View
            public final void getAuthRequestContext() {
                PromoQuestListener.RedeemQuestResult redeemQuestResult;
                PromoQuestListener.RedeemQuestResult redeemQuestResult2 = null;
                new PromoQuestRewardDialogFragment(false, new Function0<Unit>() { // from class: id.dana.promoquest.activity.MissionDetailActivity$showRedeemDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PrizeInfoEntity prizeInfoEntity;
                        if (!r1 || (prizeInfoEntity = p0) == null) {
                            return;
                        }
                        PrizeInfoEntityExtKt.PlaceComponentResult(prizeInfoEntity, r3.getDynamicUrlWrapper());
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }).show(MissionDetailActivity.this.getSupportFragmentManager(), "PromoQuestRewardDialogFragment");
                redeemQuestResult = MissionDetailActivity.this.lookAheadTest;
                if (redeemQuestResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    redeemQuestResult2 = redeemQuestResult;
                }
                redeemQuestResult2.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                PromoQuestListener.RedeemMissionResultListener unused;
                unused = MissionDetailActivity.this.scheduleImpl;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                PromoQuestListener.RedeemMissionResultListener unused;
                unused = MissionDetailActivity.this.scheduleImpl;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                PromoQuestListener.RedeemMissionResultListener unused;
                unused = MissionDetailActivity.this.scheduleImpl;
            }
        }));
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (RedeemUserMissionModule) Preconditions.getAuthRequestContext(new RedeemUserMissionModule(new RedeemMissionContract.View() { // from class: id.dana.promoquest.activity.MissionDetailActivity$getRedeemUserMissionModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.promoquest.redeem.RedeemMissionContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(PrizeInfoEntity p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                Button button = (Button) MissionDetailActivity.this._$_findCachedViewById(R.id.btn_missionprize_action);
                if (button != null) {
                    button.setVisibility(8);
                }
                InstrumentInjector.Resources_setImageResource((ImageView) MissionDetailActivity.this._$_findCachedViewById(R.id.iv_missionprize_status), R.drawable.ic_promo_quest_item_claimed);
                new PromoQuestRewardDialogFragment(true, new Function0<Unit>() { // from class: id.dana.promoquest.activity.MissionDetailActivity$showRedeemDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PrizeInfoEntity prizeInfoEntity;
                        if (!r1 || (prizeInfoEntity = p0) == null) {
                            return;
                        }
                        PrizeInfoEntityExtKt.PlaceComponentResult(prizeInfoEntity, r3.getDynamicUrlWrapper());
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }).show(MissionDetailActivity.this.getSupportFragmentManager(), "PromoQuestRewardDialogFragment");
                MissionDetailActivity.this.scheduleImpl();
                MissionDetailActivity.access$broadcastMission(MissionDetailActivity.this, true);
            }

            @Override // id.dana.contract.promoquest.redeem.RedeemMissionContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                PromoQuestListener.RedeemQuestResult redeemQuestResult;
                PromoQuestListener.RedeemQuestResult redeemQuestResult2 = null;
                new PromoQuestRewardDialogFragment(false, new Function0<Unit>() { // from class: id.dana.promoquest.activity.MissionDetailActivity$showRedeemDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PrizeInfoEntity prizeInfoEntity;
                        if (!r1 || (prizeInfoEntity = p0) == null) {
                            return;
                        }
                        PrizeInfoEntityExtKt.PlaceComponentResult(prizeInfoEntity, r3.getDynamicUrlWrapper());
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }).show(MissionDetailActivity.this.getSupportFragmentManager(), "PromoQuestRewardDialogFragment");
                redeemQuestResult = MissionDetailActivity.this.lookAheadTest;
                if (redeemQuestResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    redeemQuestResult2 = redeemQuestResult;
                }
                redeemQuestResult2.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                PromoQuestListener.RedeemMissionResultListener unused;
                unused = MissionDetailActivity.this.scheduleImpl;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                PromoQuestListener.RedeemMissionResultListener unused;
                unused = MissionDetailActivity.this.scheduleImpl;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                PromoQuestListener.RedeemMissionResultListener unused;
                unused = MissionDetailActivity.this.scheduleImpl;
            }
        }));
        BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig = (TrackQuestModule) Preconditions.getAuthRequestContext(new TrackQuestModule(new TrackQuestContract.View() { // from class: id.dana.promoquest.activity.MissionDetailActivity$getTrackModule$1
            @Override // id.dana.contract.promoquest.track.TrackQuestContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                TrackQuestContract.View.CC.PlaceComponentResult();
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
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.promoquest.track.TrackQuestContract.View
            public final void MyBillsEntityDataFactory(boolean p0, String p1) {
                PromoQuestListener.TrackQuestResultListener trackQuestResultListener;
                PromoQuestListener.TrackQuestResultListener trackQuestResultListener2;
                Intrinsics.checkNotNullParameter(p1, "");
                PromoQuestListener.TrackQuestResultListener trackQuestResultListener3 = null;
                if (p0) {
                    trackQuestResultListener2 = MissionDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (trackQuestResultListener2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        trackQuestResultListener3 = trackQuestResultListener2;
                    }
                    trackQuestResultListener3.getAuthRequestContext();
                    MissionDetailActivity.access$updateCurrentQuest(MissionDetailActivity.this, p1, "COMPLETE");
                    return;
                }
                trackQuestResultListener = MissionDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (trackQuestResultListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    trackQuestResultListener3 = trackQuestResultListener;
                }
                trackQuestResultListener3.PlaceComponentResult();
                MissionDetailActivity.access$updateCurrentQuest(MissionDetailActivity.this, p1, "FINISH");
                MissionDetailActivity.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.promoquest.track.TrackQuestContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
                PromoQuestActionFactory promoQuestActionFactory;
                PromoQuestListener.TrackQuestResultListener trackQuestResultListener;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                promoQuestActionFactory = MissionDetailActivity.this.BuiltInFictitiousFunctionClassFactory;
                if (promoQuestActionFactory != null) {
                    promoQuestActionFactory.MyBillsEntityDataFactory(p0, p1).KClassImpl$Data$declaredNonStaticMembers$2();
                }
                trackQuestResultListener = MissionDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (trackQuestResultListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    trackQuestResultListener = null;
                }
                trackQuestResultListener.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.promoquest.track.TrackQuestContract.View
            public final void PlaceComponentResult() {
                PromoQuestListener.TrackQuestResultListener trackQuestResultListener;
                trackQuestResultListener = MissionDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (trackQuestResultListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    trackQuestResultListener = null;
                }
                ErrorUtil.BuiltInFictitiousFunctionClassFactory(MissionDetailActivity.this.getBaseContext());
                trackQuestResultListener.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                MissionDetailActivity.this.showWarningDialog(p0);
            }
        }));
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.promoquest.activity.MissionDetailActivity$injectComponent$1
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
        }));
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        MissionDetailActivity missionDetailActivity = this;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = missionDetailActivity;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, r5));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = missionDetailActivity;
        BuiltInFictitiousFunctionClassFactory.scheduleImpl = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, r5));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = missionDetailActivity;
        BuiltInFictitiousFunctionClassFactory.moveToNextValue = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, r5));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = missionDetailActivity;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, r5));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = missionDetailActivity;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, r5));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, MissionModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, RedeemQuestModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig, TrackQuestModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.scheduleImpl, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.moveToNextValue, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, OauthModule.class);
        if (BuiltInFictitiousFunctionClassFactory.lookAheadTest == null) {
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, RedeemUserMissionModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerMissionComponent.MissionComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.scheduleImpl, BuiltInFictitiousFunctionClassFactory.moveToNextValue, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.lookAheadTest, BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getRedeemQuestPresenter(), getTrackPresenter(), getReadLinkPropertiesPresenter(), getMissionPresenter());
        Parcelable parcelableExtra = getIntent().getParcelableExtra("MissionDetail.mission");
        Intrinsics.checkNotNull(parcelableExtra);
        this.MyBillsEntityDataFactory = (MissionModel) parcelableExtra;
        this.BuiltInFictitiousFunctionClassFactory = new PromoQuestActionFactory(getBaseContext(), new PromoQuestDeeplinkActionListener() { // from class: id.dana.promoquest.activity.MissionDetailActivity$$ExternalSyntheticLambda4
            @Override // id.dana.promoquest.handler.deeplink.PromoQuestDeeplinkActionListener
            public final void MyBillsEntityDataFactory(String str) {
                MissionDetailActivity.$r8$lambda$b4yadCrGUw_nVTe4tNgbFJiMovU(MissionDetailActivity.this, str);
            }
        }, getDynamicUrlWrapper());
        ViewGroup.LayoutParams layoutParams = ((AppBarLayout) _$_findCachedViewById(R.id.appbarlayout_missiondetail)).getLayoutParams();
        if (layoutParams != null) {
            AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
            behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() { // from class: id.dana.promoquest.activity.MissionDetailActivity$setupAppBarLayout$1$1
                @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
                public final boolean canDrag(AppBarLayout p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    return false;
                }
            });
            ((CoordinatorLayout.LayoutParams) layoutParams).MyBillsEntityDataFactory(behavior);
        }
        ((NestedScrollView) _$_findCachedViewById(R.id.res_0x7f0a0f48_windowinsetscontrollercompat_impl20)).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.promoquest.activity.MissionDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                MissionDetailActivity.m2790$r8$lambda$y5IVlBL64aKjSWjwOh2rwBm8jY(MissionDetailActivity.this, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        PromoQuestActionFactory promoQuestActionFactory = new PromoQuestActionFactory(getBaseContext(), new PromoQuestDeeplinkActionListener() { // from class: id.dana.promoquest.activity.MissionDetailActivity$$ExternalSyntheticLambda4
            @Override // id.dana.promoquest.handler.deeplink.PromoQuestDeeplinkActionListener
            public final void MyBillsEntityDataFactory(String str) {
                MissionDetailActivity.$r8$lambda$b4yadCrGUw_nVTe4tNgbFJiMovU(MissionDetailActivity.this, str);
            }
        }, getDynamicUrlWrapper());
        PromoQuestListener.QuestAction questAction = new PromoQuestListener.QuestAction() { // from class: id.dana.promoquest.activity.MissionDetailActivity$getQuestActionListener$1
            @Override // id.dana.promoquest.PromoQuestListener.QuestAction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1, PromoQuestListener.TrackQuestResultListener p2) {
                MissionModel missionModel;
                MissionModel missionModel2;
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                MissionDetailActivity missionDetailActivity2 = MissionDetailActivity.this;
                missionDetailActivity2.NetworkUserEntityData$$ExternalSyntheticLambda0 = p2;
                missionModel = missionDetailActivity2.MyBillsEntityDataFactory;
                if (missionModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    missionModel = null;
                }
                List<QuestModel> list = missionModel.newProxyInstance;
                if ((!list.isEmpty()) == false) {
                    list = null;
                }
                QuestModel questModel = list != null ? list.get(0) : null;
                TrackQuestContract.Presenter trackPresenter = missionDetailActivity2.getTrackPresenter();
                missionModel2 = missionDetailActivity2.MyBillsEntityDataFactory;
                if (missionModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    missionModel2 = null;
                }
                String str2 = missionModel2.initRecordTimeStamp;
                if (str2 == null) {
                    return;
                }
                if (questModel != null) {
                    Map<String, String> map = questModel.PlaceComponentResult;
                    str = map != null ? map.get("bizType") : null;
                    if (str == null) {
                        str = "";
                    }
                } else {
                    str = null;
                }
                String str3 = str == null ? "" : str;
                if (questModel != null) {
                    Map<String, String> map2 = questModel.PlaceComponentResult;
                    r2 = map2 != null ? map2.get(ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID) : null;
                    if (r2 == null) {
                        r2 = "";
                    }
                }
                trackPresenter.BuiltInFictitiousFunctionClassFactory(str2, p0, p1, str3, r2 == null ? "" : r2);
            }

            @Override // id.dana.promoquest.PromoQuestListener.QuestAction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1, PromoQuestListener.RedeemQuestResult p2) {
                MissionModel missionModel;
                Intrinsics.checkNotNullParameter(p0, "");
                MissionDetailActivity missionDetailActivity2 = MissionDetailActivity.this;
                missionDetailActivity2.lookAheadTest = p2;
                missionDetailActivity2.PlaceComponentResult = p1;
                RedeemQuestContract.Presenter redeemQuestPresenter = missionDetailActivity2.getRedeemQuestPresenter();
                missionModel = missionDetailActivity2.MyBillsEntityDataFactory;
                if (missionModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    missionModel = null;
                }
                String str = missionModel.initRecordTimeStamp;
                if (str == null) {
                    return;
                }
                redeemQuestPresenter.PlaceComponentResult(str, p0);
            }
        };
        MissionDetailQuestAdapter.RedeemQuestListener redeemQuestListener = new MissionDetailQuestAdapter.RedeemQuestListener() { // from class: id.dana.promoquest.activity.MissionDetailActivity$getRedeemQuestListener$1
            @Override // id.dana.promoquest.adapter.MissionDetailQuestAdapter.RedeemQuestListener
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MissionDetailActivity.access$updateCurrentQuest(MissionDetailActivity.this, p0, "FINISH");
                MissionDetailActivity.this.BuiltInFictitiousFunctionClassFactory();
                MissionDetailActivity.access$broadcastMission(MissionDetailActivity.this, false);
            }
        };
        MissionModel missionModel = this.MyBillsEntityDataFactory;
        if (missionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            missionModel = null;
        }
        this.getAuthRequestContext = new MissionDetailQuestAdapter(promoQuestActionFactory, questAction, redeemQuestListener, missionModel.getPlaceComponentResult());
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.res_0x7f0a1366_flowkt__zipkt_combinetransform_6);
        toolbar.setNavigationIcon(R.drawable.arrow_left_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.promoquest.activity.MissionDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissionDetailActivity.$r8$lambda$UEb1H10iXEKpzxNB8fXMTf8pDas(MissionDetailActivity.this, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_quest_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(), R.dimen.MyBillsEntityDataFactory_res_0x7f07005f));
        recyclerView.setAdapter(this.getAuthRequestContext);
        MissionModel missionModel2 = this.MyBillsEntityDataFactory;
        if (missionModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            missionModel2 = null;
        }
        String str = missionModel2.initRecordTimeStamp;
        if (str == null || str.length() == 0) {
            finish();
        }
        MissionModel missionModel3 = this.MyBillsEntityDataFactory;
        if (missionModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            missionModel3 = null;
        }
        List<QuestModel> list = missionModel3.newProxyInstance;
        MissionModel missionModel4 = (((list == null || list.isEmpty()) ? (byte) 1 : (byte) 0) ^ 1) != 0 ? missionModel3 : null;
        KClassImpl$Data$declaredNonStaticMembers$2();
        if (missionModel4 == null) {
            BuiltInFictitiousFunctionClassFactory();
            Unit unit = Unit.INSTANCE;
        }
    }

    private static void b(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = isLayoutRequested;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ PrepareContext);
        if (NetworkUserEntityData$$ExternalSyntheticLambda7) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda8) {
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
