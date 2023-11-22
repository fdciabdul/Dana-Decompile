package id.dana.nearbyme.merchantdetail;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Observer;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantDetailComponent;
import id.dana.di.modules.MerchantDetailModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogContactUs;
import id.dana.extension.ContextExtKt;
import id.dana.nearbyme.PromoListDialogFragment;
import id.dana.nearbyme.di.module.NearbyTrackerModule;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.homeshopping.HomeShoppingDialogFragment;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.adapter.MerchantLabelAdapter;
import id.dana.nearbyme.merchantdetail.adapter.MerchantLabelType;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosView;
import id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantdetail.model.MerchantInfoModel;
import id.dana.nearbyme.merchantdetail.model.MerchantLabelModel;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailMenuView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantPromoView;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.LocationUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.ShimmeringUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB\u0007¢\u0006\u0004\bP\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0006J\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0006J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0006J\u0011\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b$\u0010\u001fJ\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0006J\u000f\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0006J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0006J\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0006J\u000f\u0010*\u001a\u00020\u0004H\u0000¢\u0006\u0004\b*\u0010\u0006J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0006J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010-R\u0013\u00100\u001a\u00020.X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010/R\u0016\u0010\f\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u00102R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00104R\u0016\u0010\u000e\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00102R\"\u00107\u001a\u0002068\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010\u001c\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010>R\u0018\u0010\u001b\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010>R\"\u0010@\u001a\u00020?8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0013\u0010 \u001a\u00020FX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b$\u0010/R\"\u0010H\u001a\u00020G8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010\u001d\u001a\u00020N8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b%\u0010O"}, d2 = {"Lid/dana/nearbyme/merchantdetail/MerchantDetailActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantDetailInteraction;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantPromoView$PromoViewInteraction;", "", "dismissLoadingDialog", "()V", "", "getLayout", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", IAPSyncCommand.COMMAND_INIT, "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "()Z", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "images", "onImageLoaded", "(Ljava/util/List;)V", "Lid/dana/nearbyme/model/PromoInfoModel;", "promoInfos", "onSeeAllPromoClick", "Lid/dana/nearbyme/model/ShopModel;", "provideShopModel", "()Lid/dana/nearbyme/model/ShopModel;", "scheduleImpl", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "()Lkotlin/Unit;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "initRecordTimeStamp", "DatabaseTableConfigUtil", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", ZolozEkycH5Handler.HUMMER_FOUNDATION_SHOW_LOADING_DIALOG, "trackHomeShoppingOrder$app_productionRelease", "newProxyInstance", "isLayoutRequested", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/dialog/DanaLoadingDialog;", "Lkotlin/Lazy;", "getAuthRequestContext", "", SummaryActivity.DAYS, "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;", "merchantDetailPresenter", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;", "getMerchantDetailPresenter", "()Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;", "setMerchantDetailPresenter", "(Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "getNearbyAnalyticTracker", "()Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "setNearbyAnalyticTracker", "(Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;)V", "", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "tracker", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "getTracker", "()Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "setTracker", "(Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;)V", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailActivity extends BaseActivity implements MerchantDetailInteraction, MerchantPromoView.PromoViewInteraction {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String EXTRA_SHOP_MODEL = "EXTRA_SHOP_MODEL";
    public static final String EXTRA_SOURCE = "EXTRA_SOURCE";
    private static long isLayoutRequested;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private MerchantDetailViewState NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private SkeletonScreen scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private SkeletonScreen getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private double PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private Disposable MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private double BuiltInFictitiousFunctionClassFactory;
    @Inject
    public MerchantDetailContract.Presenter merchantDetailPresenter;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ShopModel KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public MerchantDetailAnalyticTracker tracker;
    public static final byte[] $$a = {117, -10, 119, -11, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 2;
    public static final byte[] getAuthRequestContext = {99, 56, -99, 122, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 207;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(MerchantDetailActivity.this);
        }
    });

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<String>() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$pageSource$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle extras;
            String string;
            Intent intent = MerchantDetailActivity.this.getIntent();
            return (intent == null || (extras = intent.getExtras()) == null || (string = extras.getString("EXTRA_SOURCE")) == null) ? "" : string;
        }
    });

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 97
            int r6 = 23 - r6
            int r7 = 56 - r7
            byte[] r0 = id.dana.nearbyme.merchantdetail.MerchantDetailActivity.getAuthRequestContext
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L31:
            int r8 = r8 + 1
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + (-4)
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.MerchantDetailActivity.b(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            byte[] r0 = id.dana.nearbyme.merchantdetail.MerchantDetailActivity.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r6 = -r6
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.MerchantDetailActivity.c(int, int, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        isLayoutRequested = -2675979860005459165L;
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
        a(54292 - TextUtils.lastIndexOf("", '0', 0), new char[]{47617, 28187, 4654, 50733, 59995, 40544, 17018, 30429, 6823, 52910, 62108, 42711, 19182, 32542, 8997, 55102, 64323, 44918}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((Process.myPid() >> 22) + 8329, new char[]{47629, 39568, 64295, 56210, 14368}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(12889 - ExpandableListView.getPackedPositionType(0L), new char[]{47703, 34906, 57060, 11603, 29492, 16825, 37967, 55863, 10399, 32548, 19833, 37845, 58921, 13527, 31375, 18785, 40897, 60856, 12308, 1690, 21744, 39758, 59813, 16297, 604, 20706, 42834, 62823, 15342, 3601, 23663, 41666, 61817, 50991, 5504, 22642, 44674, 64644, 50030, 4575, 26559, 43591, 63694, 52901, 7502, 25590, 45480, 33874}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 40693, new char[]{47617, 9376, 34748, 26331, 49618, 41104, 1006, 58091, 19884, 11422, 36811, 28370, 51576, 43040, 2871, 59919, 21762, 13335, 38716, 30334, 53536, 45128, 4952, 62032, 23726, 16367, 40635, 31186, 55444, 48069, 6884, 34297, 25763, 51089, 42718, 295, 57463, 17258, 8718, 36096, 27677, 53101, 44599, 2422, 59423, 19270, 10839, 38060, 30627, 54966, 45453, 4246, 62365, 21230, 15870, 40178, 32712, 57052, 47489, 6261, 64317, 23097, 50514, 42008}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(42397 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{47698, 8140, 61759, 19157, 11309, 34374, 23548, 15647, 38576, 26845, 49786, 42990, 30989, 53930, 46278, 3684, 58321, 17768, 8030, 61603, 18966, 12259, 33151, 23368, 15599, 38483, 27563, 52695, 42794, 30927, 53809, 46080, 2551, 58169, 17544, 7727, 61462, 21990, 12056, 32947, 23248, 15395, 37267, 27403, 52388, 42697, 30775, 56785, 46966, 2388, 58025, 17474, 6582, 62416, 21784, 12014, 32783, 26016, 16331, 37241, 27338, 52284, 42579, 31738}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 39749, new char[]{47624, 8529, 35998, 27615, 55047, 45571, 6609, 33964, 24620, 53100, 43708, 4598, 64882, 22677, 51150, 41753, 3669, 62868, 20686, 15388, 39781, 1722, 60922, 18813, 13439, 37800, 32515, 55893, 16776, 11458, 34823, 30542, 53921, 47607, 9519, 32801, 28599, 51958, 46643, 7628, 63689, 25629, 50011, 44760, 5589, 61743, 23649, 15278, 42723, 545, 59701, 21673, 12374, 40710, 31371, 57797, 19741, 10323, 38838, 29428}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(View.getDefaultSize(0, 0) + 48299, new char[]{47705, 1765, 49922, 35919, 18686, 5382}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) View.combineMeasuredStates(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[30], Ascii.RS, 8, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), ImageFormat.getBitsPerPixel(0) + 4, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], $$a[78], (byte) (-$$a[12]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 15 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.blue(0), 15 - TextUtils.indexOf("", "", 0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.lastIndexOf("", '0', 0), 'M' - AndroidCharacter.getMirror('0'), (char) (57994 - KeyEvent.getDeadChar(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 800, KeyEvent.keyCodeFromString("") + 15, (char) Color.red(0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {735662479, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 18, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[30], Ascii.RS, 8, objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.alpha(0), 46 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$b - 2), (byte) (-$$a[28]), (byte) ($$b - 2), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {735662479, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(getAuthRequestContext[30], Ascii.RS, 8, objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 38969));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$b - 2), (byte) (-$$a[28]), (byte) ($$b - 2), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, Color.blue(0) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {735662479, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(getAuthRequestContext[30], Ascii.RS, 8, objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 107, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 4, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[8]), $$a[40], (byte) (-$$a[9]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {735662479, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, Color.alpha(0) + 18, (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_merchant_detail;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.mark_as_paid).substring(1, 2).codePointAt(0) + 54196, new char[]{47617, 28187, 4654, 50733, 59995, 40544, 17018, 30429, 6823, 52910, 62108, 42711, 19182, 32542, 8997, 55102, 64323, 44918}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(getPackageName().length() + 8322, new char[]{47629, 39568, 64295, 56210, 14368}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(MotionEvent.axisFromString("") + 9678, new char[]{47617, 40899, 61854, 52085, 11579, 1800, 22730, 45781, 37993, 60965, 49170, 9601, 32701, 20842, 43810, 36106, 59078, 14484, 4734, 29742, 20016, 41945, 34188, 57198, 12601, 2817}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(41057 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{47619, 6772, 64208, 23345, 15233, 39915, 30802, 55430, 47384, 6521, 63942, 24098, 16015, 40684, 32602, 57254, 48159, 7295}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), KeyEvent.normalizeMetaState(0) + 35, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.msg_location_dialog_desc).substring(159, 161).length() + 12887, new char[]{47703, 34906, 57060, 11603, 29492, 16825, 37967, 55863, 10399, 32548, 19833, 37845, 58921, 13527, 31375, 18785, 40897, 60856, 12308, 1690, 21744, 39758, 59813, 16297, 604, 20706, 42834, 62823, 15342, 3601, 23663, 41666, 61817, 50991, 5504, 22642, 44674, 64644, 50030, 4575, 26559, 43591, 63694, 52901, 7502, 25590, 45480, 33874}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(Color.blue(0) + 40693, new char[]{47617, 9376, 34748, 26331, 49618, 41104, 1006, 58091, 19884, 11422, 36811, 28370, 51576, 43040, 2871, 59919, 21762, 13335, 38716, 30334, 53536, 45128, 4952, 62032, 23726, 16367, 40635, 31186, 55444, 48069, 6884, 34297, 25763, 51089, 42718, 295, 57463, 17258, 8718, 36096, 27677, 53101, 44599, 2422, 59423, 19270, 10839, 38060, 30627, 54966, 45453, 4246, 62365, 21230, 15870, 40178, 32712, 57052, 47489, 6261, 64317, 23097, 50514, 42008}, objArr7);
                    String str2 = (String) objArr7[0];
                    try {
                        byte b = getAuthRequestContext[25];
                        Object[] objArr8 = new Object[1];
                        b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr8);
                        Class<?> cls3 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 42364, new char[]{47698, 8140, 61759, 19157, 11309, 34374, 23548, 15647, 38576, 26845, 49786, 42990, 30989, 53930, 46278, 3684, 58321, 17768, 8030, 61603, 18966, 12259, 33151, 23368, 15599, 38483, 27563, 52695, 42794, 30927, 53809, 46080, 2551, 58169, 17544, 7727, 61462, 21990, 12056, 32947, 23248, 15395, 37267, 27403, 52388, 42697, 30775, 56785, 46966, 2388, 58025, 17474, 6582, 62416, 21784, 12014, 32783, 26016, 16331, 37241, 27338, 52284, 42579, 31738}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.lights_off).substring(0, 1).length() + 39748, new char[]{47624, 8529, 35998, 27615, 55047, 45571, 6609, 33964, 24620, 53100, 43708, 4598, 64882, 22677, 51150, 41753, 3669, 62868, 20686, 15388, 39781, 1722, 60922, 18813, 13439, 37800, 32515, 55893, 16776, 11458, 34823, 30542, 53921, 47607, 9519, 32801, 28599, 51958, 46643, 7628, 63689, 25629, 50011, 44760, 5589, 61743, 23649, 15278, 42723, 545, 59701, 21673, 12374, 40710, 31371, 57797, 19741, 10323, 38838, 29428}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(getPackageName().codePointAt(3) + 48199, new char[]{47705, 1765, 49922, 35919, 18686, 5382}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            Object[] objArr14 = new Object[1];
            b(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(getAuthRequestContext[30], Ascii.RS, 8, objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.combineMeasuredStates(0, 0), ExpandableListView.getPackedPositionType(0L) + 4, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    Object[] objArr17 = new Object[1];
                    c((byte) (-$$a[8]), $$a[40], (byte) (-$$a[9]), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (ViewConfiguration.getPressedStateDuration() >> 16) + 35, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {1038728116, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(9677 - TextUtils.indexOf("", "", 0), new char[]{47617, 40899, 61854, 52085, 11579, 1800, 22730, 45781, 37993, 60965, 49170, 9601, 32701, 20842, 43810, 36106, 59078, 14484, 4734, 29742, 20016, 41945, 34188, 57198, 12601, 2817}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().codePointAt(3) + 40957, new char[]{47619, 6772, 64208, 23345, 15233, 39915, 30802, 55430, 47384, 6521, 63942, 24098, 16015, 40684, 32602, 57254, 48159, 7295}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.my_bills_label_incorrect_customer_id).substring(0, 1).length() + 9676, new char[]{47617, 40899, 61854, 52085, 11579, 1800, 22730, 45781, 37993, 60965, 49170, 9601, 32701, 20842, 43810, 36106, 59078, 14484, 4734, 29742, 20016, 41945, 34188, 57198, 12601, 2817}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(TextUtils.indexOf("", "", 0) + 41057, new char[]{47619, 6772, 64208, 23345, 15233, 39915, 30802, 55430, 47384, 6521, 63942, 24098, 16015, 40684, 32602, 57254, 48159, 7295}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, ((byte) KeyEvent.getModifierMetaStateMask()) + 19, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction
    public final /* synthetic */ void updatePromoBadge(ShopModel shopModel) {
        MerchantDetailInteraction.CC.MyBillsEntityDataFactory(shopModel);
    }

    @JvmName(name = "getTracker")
    public final MerchantDetailAnalyticTracker getTracker() {
        MerchantDetailAnalyticTracker merchantDetailAnalyticTracker = this.tracker;
        if (merchantDetailAnalyticTracker != null) {
            return merchantDetailAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTracker")
    public final void setTracker(MerchantDetailAnalyticTracker merchantDetailAnalyticTracker) {
        Intrinsics.checkNotNullParameter(merchantDetailAnalyticTracker, "");
        this.tracker = merchantDetailAnalyticTracker;
    }

    @JvmName(name = "getNearbyAnalyticTracker")
    public final NearbyAnalyticTracker getNearbyAnalyticTracker() {
        NearbyAnalyticTracker nearbyAnalyticTracker = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker != null) {
            return nearbyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNearbyAnalyticTracker")
    public final void setNearbyAnalyticTracker(NearbyAnalyticTracker nearbyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(nearbyAnalyticTracker, "");
        this.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    @JvmName(name = "getMerchantDetailPresenter")
    public final MerchantDetailContract.Presenter getMerchantDetailPresenter() {
        MerchantDetailContract.Presenter presenter = this.merchantDetailPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMerchantDetailPresenter")
    public final void setMerchantDetailPresenter(MerchantDetailContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.merchantDetailPresenter = presenter;
    }

    public final ShopModel provideShopModel() {
        ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        return shopModel;
    }

    @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction
    public final void onImageLoaded(List<MerchantImageModel> images) {
        Intrinsics.checkNotNullParameter(images, "");
        SkeletonScreen skeletonScreen = this.getErrorConfigVersion;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        MerchantImageModel merchantImageModel = (MerchantImageModel) CollectionsKt.firstOrNull((List) images);
        if (merchantImageModel == null) {
            GlideApp.PlaceComponentResult(this).PlaceComponentResult(Integer.valueOf((int) R.drawable.ic_header_null)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.iv_merchant_header_image)));
            return;
        }
        String str = merchantImageModel.BuiltInFictitiousFunctionClassFactory;
        if (SvgLoader.getAuthRequestContext(str)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(this);
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (AppCompatImageView) _$_findCachedViewById(R.id.iv_merchant_header_image);
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
            return;
        }
        GlideApp.PlaceComponentResult(this).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).PlaceComponentResult((int) R.drawable.ic_header_null).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.iv_merchant_header_image)));
    }

    public final void trackHomeShoppingOrder$app_productionRelease() {
        MerchantDetailViewState merchantDetailViewState = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        MerchantDetailViewState merchantDetailViewState2 = null;
        if (merchantDetailViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailViewState = null;
        }
        ShopModel shopModel = merchantDetailViewState.PlaceComponentResult;
        NearbyAnalyticTracker nearbyAnalyticTracker = getNearbyAnalyticTracker();
        String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (str == null) {
            str = "";
        }
        String str2 = shopModel.newProxyInstance;
        if (str2 == null) {
            str2 = "";
        }
        MerchantDetailViewState merchantDetailViewState3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailViewState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantDetailViewState2 = merchantDetailViewState3;
        }
        nearbyAnalyticTracker.getAuthRequestContext(str, str2, merchantDetailViewState2.MyBillsEntityDataFactory);
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        if (!PlaceComponentResult() && LocationUtil.getAuthRequestContext(this)) {
            isLayoutRequested();
            return;
        }
        Location authRequestContext = LocationUtil.getAuthRequestContext();
        this.BuiltInFictitiousFunctionClassFactory = authRequestContext.getLatitude();
        this.PlaceComponentResult = authRequestContext.getLongitude();
        NetworkUserEntityData$$ExternalSyntheticLambda8();
    }

    private final boolean PlaceComponentResult() {
        return OSUtil.GetContactSyncConfig() && ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, "android.permission.ACCESS_FINE_LOCATION") != 0;
    }

    private final Unit initRecordTimeStamp() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_share);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantDetailActivity.m2730$r8$lambda$VGhX9GRlMLAlcPIY16yj0L81U(MerchantDetailActivity.this, view);
                }
            });
            return Unit.INSTANCE;
        }
        return null;
    }

    private final void newProxyInstance() {
        MerchantDetailAnalyticTracker tracker = getTracker();
        String str = (String) this.lookAheadTest.getValue();
        ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ShopModel shopModel2 = null;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        String str2 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (str2 == null) {
            str2 = "";
        }
        ShopModel shopModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shopModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel3 = null;
        }
        String str3 = shopModel3.newProxyInstance;
        if (str3 == null) {
            str3 = "";
        }
        ShopModel shopModel4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shopModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            shopModel2 = shopModel4;
        }
        String authRequestContext = shopModel2.getAuthRequestContext(false, ",");
        tracker.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, str3, authRequestContext != null ? authRequestContext : "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.Unit] */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        Bundle extras;
        Intent intent = getIntent();
        ?? r1 = 0;
        ShopModel shopModel = (intent == null || (extras = intent.getExtras()) == null) ? null : (ShopModel) extras.getParcelable("EXTRA_SHOP_MODEL");
        if (!(shopModel instanceof ShopModel)) {
            shopModel = null;
        }
        if (shopModel != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = shopModel;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new MerchantDetailViewState(shopModel, r1, 2, r1);
            PrepareContext();
            r1 = Unit.INSTANCE;
        }
        if (r1 == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        MerchantPhotosView merchantPhotosView = (MerchantPhotosView) _$_findCachedViewById(R.id.view_merchant_photo);
        if (merchantPhotosView != null) {
            merchantPhotosView.setShopModel(shopModel);
        }
        MerchantPhotosView merchantPhotosView2 = (MerchantPhotosView) _$_findCachedViewById(R.id.view_merchant_photo);
        if (merchantPhotosView2 != null) {
            merchantPhotosView2.loadImages();
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        MerchantDanaDealsView merchantDanaDealsView = (MerchantDanaDealsView) _$_findCachedViewById(R.id.view_merchant_dana_deals);
        if (merchantDanaDealsView != null) {
            String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            merchantDanaDealsView.getMerchantDanaDealsVoucher(str, str2);
        }
    }

    private final void lookAheadTest() {
        ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ShopModel shopModel2 = null;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        MerchantInfoView merchantInfoView = (MerchantInfoView) _$_findCachedViewById(R.id.res_0x7f0a1b4d_com_alibaba_ariver_engine_api_extopt_7);
        MerchantDetailViewState merchantDetailViewState = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailViewState = null;
        }
        merchantInfoView.bindViewState(merchantDetailViewState);
        MerchantInfoContract.Presenter merchantInfoPresenter = ((MerchantInfoView) _$_findCachedViewById(R.id.res_0x7f0a1b4d_com_alibaba_ariver_engine_api_extopt_7)).getMerchantInfoPresenter();
        String str = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (str == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(str, "");
        String str2 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (str2 == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(str2, "");
        String displayName = Calendar.getInstance().getDisplayName(7, 2, Locale.US);
        Intrinsics.checkNotNullExpressionValue(displayName, "");
        merchantInfoPresenter.getAuthRequestContext(str, str2, displayName);
        MerchantInfoContract.Presenter merchantInfoPresenter2 = ((MerchantInfoView) _$_findCachedViewById(R.id.res_0x7f0a1b4d_com_alibaba_ariver_engine_api_extopt_7)).getMerchantInfoPresenter();
        ShopModel shopModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shopModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            shopModel2 = shopModel3;
        }
        merchantInfoPresenter2.BuiltInFictitiousFunctionClassFactory(shopModel2);
    }

    private final void getErrorConfigVersion() {
        ((MerchantAverageRatingView) _$_findCachedViewById(R.id.view_average_rating)).setPageSource((String) this.lookAheadTest.getValue());
        MerchantAverageRatingView merchantAverageRatingView = (MerchantAverageRatingView) _$_findCachedViewById(R.id.view_average_rating);
        if (merchantAverageRatingView != null) {
            merchantAverageRatingView.setOnSeeAllClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantDetailActivity.$r8$lambda$C8540fWLZs_qrBoA9V7gsnmAwso(MerchantDetailActivity.this, view);
                }
            });
        }
        MerchantAverageRatingView merchantAverageRatingView2 = (MerchantAverageRatingView) _$_findCachedViewById(R.id.view_average_rating);
        if (merchantAverageRatingView2 != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (shopModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                shopModel = null;
            }
            merchantAverageRatingView2.loadAverageRating(supportFragmentManager, shopModel, true, true);
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        MerchantLatestReviewView merchantLatestReviewView = (MerchantLatestReviewView) _$_findCachedViewById(R.id.view_latest_merchant_review);
        if (merchantLatestReviewView != null) {
            merchantLatestReviewView.setPageSource((String) this.lookAheadTest.getValue());
        }
        MerchantLatestReviewView merchantLatestReviewView2 = (MerchantLatestReviewView) _$_findCachedViewById(R.id.view_latest_merchant_review);
        if (merchantLatestReviewView2 != null) {
            ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (shopModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                shopModel = null;
            }
            merchantLatestReviewView2.loadLatestReview(shopModel);
        }
    }

    private final Unit moveToNextValue() {
        MerchantDetailMenuView merchantDetailMenuView = (MerchantDetailMenuView) _$_findCachedViewById(R.id.EmojiEditTextHelper);
        MerchantDetailViewState merchantDetailViewState = null;
        if (merchantDetailMenuView != null) {
            MerchantDetailViewState merchantDetailViewState2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (merchantDetailViewState2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                merchantDetailViewState = merchantDetailViewState2;
            }
            merchantDetailMenuView.bindViewState(merchantDetailViewState);
            merchantDetailMenuView.setActionListener(new MerchantDetailMenuView.ActionListener() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$setupMerchantDetailMenu$1$1
                @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailMenuView.ActionListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    MerchantDetailActivity.access$showContactUsDialog(MerchantDetailActivity.this, p0);
                }

                @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailMenuView.ActionListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    MerchantDetailActivity.access$observeMerchantInfo(MerchantDetailActivity.this);
                }

                @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailMenuView.ActionListener
                public final void MyBillsEntityDataFactory() {
                    MerchantDetailViewState merchantDetailViewState3;
                    MerchantDetailActivity.access$trackHomeShoppingOpen(MerchantDetailActivity.this);
                    HomeShoppingDialogFragment.Companion companion = HomeShoppingDialogFragment.INSTANCE;
                    FragmentManager supportFragmentManager = MerchantDetailActivity.this.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                    merchantDetailViewState3 = MerchantDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (merchantDetailViewState3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantDetailViewState3 = null;
                    }
                    HomeShoppingDialogFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager, merchantDetailViewState3);
                }
            });
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) _$_findCachedViewById(R.id.collapsing_toolbar);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setVisibility(8);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_toolbar_title);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(0);
        }
        NestedScrollView nestedScrollView = (NestedScrollView) _$_findCachedViewById(R.id.nested_scroll_view);
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        MerchantDetailMenuView merchantDetailMenuView = (MerchantDetailMenuView) _$_findCachedViewById(R.id.EmojiEditTextHelper);
        if (merchantDetailMenuView != null) {
            merchantDetailMenuView.setVisibility(8);
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.res_0x7f0a0438_sightcameraview_icameraframelistener);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r1 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r4 = this;
            android.content.Intent r0 = r4.getIntent()
            r1 = 0
            if (r0 == 0) goto L16
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L16
            java.lang.String r2 = "EXTRA_SHOP_MODEL"
            android.os.Parcelable r0 = r0.getParcelable(r2)
            id.dana.nearbyme.model.ShopModel r0 = (id.dana.nearbyme.model.ShopModel) r0
            goto L17
        L16:
            r0 = r1
        L17:
            boolean r2 = r0 instanceof id.dana.nearbyme.model.ShopModel
            if (r2 == 0) goto L1c
            r1 = r0
        L1c:
            java.lang.String r0 = ""
            if (r1 == 0) goto L2b
            java.lang.String r2 = r1.NetworkUserEntityData$$ExternalSyntheticLambda3
            if (r2 != 0) goto L25
            r2 = r0
        L25:
            java.lang.String r1 = r1.BottomSheetCardBindingView$watcherCardNumberView$1
            if (r1 == 0) goto L49
        L29:
            r0 = r1
            goto L49
        L2b:
            android.content.Intent r1 = r4.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            if (r1 == 0) goto L48
            java.lang.String r2 = "EXTRA_MERCHANT_ID"
            java.lang.String r2 = r1.getString(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r3 = "EXTRA_SHOP_ID"
            java.lang.String r1 = r1.getString(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            goto L29
        L48:
            r2 = r0
        L49:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L54
            r1 = 1
            goto L55
        L54:
            r1 = 0
        L55:
            if (r1 == 0) goto L5f
            id.dana.nearbyme.merchantdetail.MerchantDetailContract$Presenter r1 = r4.getMerchantDetailPresenter()
            id.dana.nearbyme.merchantdetail.MerchantDetailContract.Presenter.CC.KClassImpl$Data$declaredNonStaticMembers$2(r1, r2, r0)
            return
        L5f:
            com.ethanhua.skeleton.SkeletonScreen r0 = r4.getErrorConfigVersion
            if (r0 == 0) goto L66
            r0.PlaceComponentResult()
        L66:
            com.ethanhua.skeleton.SkeletonScreen r0 = r4.scheduleImpl
            if (r0 == 0) goto L6d
            r0.PlaceComponentResult()
        L6d:
            r4.NetworkUserEntityData$$ExternalSyntheticLambda7()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.MerchantDetailActivity.KClassImpl$Data$declaredNonStaticMembers$2():void");
    }

    private final void DatabaseTableConfigUtil() {
        ((Toolbar) _$_findCachedViewById(R.id.toolbar_merchant_detail)).setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantDetailActivity.$r8$lambda$Dn4TJqcmIudOKapWcM2E0HdV778(MerchantDetailActivity.this, view);
            }
        });
        ((NestedScrollView) _$_findCachedViewById(R.id.nested_scroll_view)).setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$$ExternalSyntheticLambda6
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                MerchantDetailActivity.m2731$r8$lambda$biJvIyAApq8QJUtPB4DdEKg4_o(MerchantDetailActivity.this, nestedScrollView, i, i2, i3, i4);
            }
        });
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_toolbar_title);
        if (appCompatTextView != null) {
            ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (shopModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                shopModel = null;
            }
            String str = shopModel.newProxyInstance;
            appCompatTextView.setText(str != null ? str : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PrepareContext() {
        lookAheadTest();
        GetContactSyncConfig();
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        getErrorConfigVersion();
        NetworkUserEntityData$$ExternalSyntheticLambda1();
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        moveToNextValue();
        DatabaseTableConfigUtil();
        scheduleImpl();
        initRecordTimeStamp();
        newProxyInstance();
    }

    private final void GetContactSyncConfig() {
        MerchantPromoView merchantPromoView;
        MerchantInfoView merchantInfoView = (MerchantInfoView) _$_findCachedViewById(R.id.res_0x7f0a1b4d_com_alibaba_ariver_engine_api_extopt_7);
        if (merchantInfoView == null || (merchantPromoView = (MerchantPromoView) merchantInfoView._$_findCachedViewById(R.id.merchant_promo_view)) == null) {
            return;
        }
        merchantPromoView.setListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantPromoView.PromoViewInteraction
    public final void onSeeAllPromoClick(List<? extends PromoInfoModel> promoInfos) {
        Intrinsics.checkNotNullParameter(promoInfos, "");
        PromoListDialogFragment promoListDialogFragment = new PromoListDialogFragment(getBaseContext());
        promoListDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2 = promoInfos;
        promoListDialogFragment.show(getSupportFragmentManager(), "Show Nearby Promo List Dialog");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\f"}, d2 = {"Lid/dana/nearbyme/merchantdetail/MerchantDetailActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/nearbyme/model/ShopModel;", "p1", "", "p2", "", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/nearbyme/model/ShopModel;Ljava/lang/String;)V", "EXTRA_SHOP_MODEL", "Ljava/lang/String;", "EXTRA_SOURCE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void getAuthRequestContext(Context p0, ShopModel p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent putExtra = new Intent(p0, MerchantDetailActivity.class).putExtra("EXTRA_SHOP_MODEL", p1).putExtra("EXTRA_SOURCE", p2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            p0.startActivity(putExtra);
        }
    }

    public static /* synthetic */ void $r8$lambda$C8540fWLZs_qrBoA9V7gsnmAwso(MerchantDetailActivity merchantDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantDetailActivity, "");
        MerchantReviewDetailActivity.Companion companion = MerchantReviewDetailActivity.INSTANCE;
        MerchantDetailActivity merchantDetailActivity2 = merchantDetailActivity;
        String str = (String) merchantDetailActivity.lookAheadTest.getValue();
        ShopModel shopModel = merchantDetailActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        MerchantReviewDetailActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(merchantDetailActivity2, str, shopModel);
    }

    public static /* synthetic */ void $r8$lambda$Dn4TJqcmIudOKapWcM2E0HdV778(MerchantDetailActivity merchantDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantDetailActivity, "");
        merchantDetailActivity.onBackPressed();
    }

    /* renamed from: $r8$lambda$VGhX9GRlMLAlc-PIY-16yj0L81U  reason: not valid java name */
    public static /* synthetic */ void m2730$r8$lambda$VGhX9GRlMLAlcPIY16yj0L81U(MerchantDetailActivity merchantDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantDetailActivity, "");
        MerchantDetailViewState merchantDetailViewState = merchantDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailViewState = null;
        }
        MerchantDetailAnalyticTracker tracker = merchantDetailActivity.getTracker();
        String str = merchantDetailViewState.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6;
        Intrinsics.checkNotNullExpressionValue(str, "");
        String str2 = merchantDetailViewState.PlaceComponentResult.newProxyInstance;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        tracker.KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
        MerchantDetailActivity merchantDetailActivity2 = merchantDetailActivity;
        Object[] objArr = new Object[2];
        String str3 = merchantDetailViewState.PlaceComponentResult.newProxyInstance;
        if (str3 == null) {
            str3 = "";
        }
        objArr[0] = str3;
        objArr[1] = NearbyExtensionKt.MyBillsEntityDataFactory(merchantDetailViewState.PlaceComponentResult);
        String string = merchantDetailActivity.getString(R.string.merchant_detail_deeplink_share, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "");
        ContextExtKt.BuiltInFictitiousFunctionClassFactory(merchantDetailActivity2, string);
    }

    /* renamed from: $r8$lambda$biJvIyAApq8QJUtP-B4DdEKg4_o  reason: not valid java name */
    public static /* synthetic */ void m2731$r8$lambda$biJvIyAApq8QJUtPB4DdEKg4_o(MerchantDetailActivity merchantDetailActivity, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(merchantDetailActivity, "");
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) merchantDetailActivity._$_findCachedViewById(R.id.collapsing_toolbar);
        if (collapsingToolbarLayout == null || collapsingToolbarLayout.getMeasuredHeight() <= 0) {
            return;
        }
        ((AppCompatTextView) merchantDetailActivity._$_findCachedViewById(R.id.tv_toolbar_title)).setAlpha(i2 / ((CollapsingToolbarLayout) merchantDetailActivity._$_findCachedViewById(R.id.collapsing_toolbar)).getMeasuredHeight());
    }

    public static /* synthetic */ void $r8$lambda$e1j5Yz_qjaE5da_cKpRy8TrmrA4(MerchantDetailActivity merchantDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantDetailActivity, "");
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) merchantDetailActivity._$_findCachedViewById(R.id.collapsing_toolbar);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setVisibility(0);
        }
        NestedScrollView nestedScrollView = (NestedScrollView) merchantDetailActivity._$_findCachedViewById(R.id.nested_scroll_view);
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(0);
        }
        MerchantDetailMenuView merchantDetailMenuView = (MerchantDetailMenuView) merchantDetailActivity._$_findCachedViewById(R.id.EmojiEditTextHelper);
        if (merchantDetailMenuView != null) {
            merchantDetailMenuView.setVisibility(0);
        }
        View _$_findCachedViewById = merchantDetailActivity._$_findCachedViewById(R.id.res_0x7f0a0438_sightcameraview_icameraframelistener);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(8);
        }
        merchantDetailActivity.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void $r8$lambda$j14_gV1UZk4FI5pVuTBIff3nJhI(MerchantDetailActivity merchantDetailActivity, Location location) {
        if (location != null) {
            merchantDetailActivity.BuiltInFictitiousFunctionClassFactory = location.getLatitude();
            merchantDetailActivity.PlaceComponentResult = location.getLongitude();
        } else {
            Location authRequestContext = LocationUtil.getAuthRequestContext();
            merchantDetailActivity.BuiltInFictitiousFunctionClassFactory = authRequestContext.getLatitude();
            merchantDetailActivity.PlaceComponentResult = authRequestContext.getLongitude();
        }
        Disposable disposable = merchantDetailActivity.MyBillsEntityDataFactory;
        if (disposable != null) {
            disposable.dispose();
        }
        merchantDetailActivity.MyBillsEntityDataFactory = null;
        merchantDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8();
    }

    public static final /* synthetic */ Location access$getLocation(MerchantDetailActivity merchantDetailActivity, double d, double d2) {
        Location location = new Location("");
        location.setLatitude(d);
        location.setLongitude(d2);
        return location;
    }

    public static final /* synthetic */ void access$launchMessage(MerchantDetailActivity merchantDetailActivity, String str) {
        MerchantDetailActivity merchantDetailActivity2 = merchantDetailActivity;
        Object[] objArr = new Object[1];
        MerchantDetailViewState merchantDetailViewState = merchantDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailViewState = null;
        }
        String str2 = merchantDetailViewState.PlaceComponentResult.newProxyInstance;
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        String string = merchantDetailActivity.getString(R.string.customer_service_wa_template, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "");
        ContextExtKt.KClassImpl$Data$declaredNonStaticMembers$2(merchantDetailActivity2, str, string);
    }

    public static final /* synthetic */ void access$observeMerchantInfo(MerchantDetailActivity merchantDetailActivity) {
        final MerchantDetailMenuView merchantDetailMenuView = (MerchantDetailMenuView) merchantDetailActivity._$_findCachedViewById(R.id.EmojiEditTextHelper);
        if (merchantDetailMenuView != null) {
            MerchantDetailViewState merchantDetailViewState = merchantDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (merchantDetailViewState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantDetailViewState = null;
            }
            merchantDetailViewState.getAuthRequestContext.PlaceComponentResult(merchantDetailActivity, new Observer() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$$ExternalSyntheticLambda4
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    MerchantDetailMenuView.this.renderMenu((MerchantInfoModel) obj);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ void access$showContactUsDialog(MerchantDetailActivity merchantDetailActivity, String str) {
        DialogContactUs.Builder builder = new DialogContactUs.Builder(null, null, null, null, 15, null);
        Intrinsics.checkNotNullParameter(str, "");
        builder.getAuthRequestContext = str;
        Intrinsics.checkNotNullParameter(str, "");
        builder.PlaceComponentResult = str;
        MerchantDetailActivity$showContactUsDialog$1 merchantDetailActivity$showContactUsDialog$1 = new MerchantDetailActivity$showContactUsDialog$1(merchantDetailActivity);
        Intrinsics.checkNotNullParameter(merchantDetailActivity$showContactUsDialog$1, "");
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = merchantDetailActivity$showContactUsDialog$1;
        MerchantDetailActivity$showContactUsDialog$2 merchantDetailActivity$showContactUsDialog$2 = new MerchantDetailActivity$showContactUsDialog$2(merchantDetailActivity);
        Intrinsics.checkNotNullParameter(merchantDetailActivity$showContactUsDialog$2, "");
        builder.BuiltInFictitiousFunctionClassFactory = merchantDetailActivity$showContactUsDialog$2;
        builder.MyBillsEntityDataFactory().show(merchantDetailActivity.getSupportFragmentManager(), "DialogContactUs");
    }

    public static final /* synthetic */ void access$trackHomeShoppingOpen(MerchantDetailActivity merchantDetailActivity) {
        MerchantDetailViewState merchantDetailViewState = merchantDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailViewState = null;
        }
        merchantDetailActivity.getNearbyAnalyticTracker().MyBillsEntityDataFactory(merchantDetailViewState.PlaceComponentResult, merchantDetailViewState.MyBillsEntityDataFactory);
    }

    private final void scheduleImpl() {
        MerchantDetailActivity merchantDetailActivity = this;
        MerchantLabelAdapter merchantLabelAdapter = new MerchantLabelAdapter(merchantDetailActivity);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ProfileMenuHeaderViewHolder_ViewBinding);
        if (recyclerView != null) {
            recyclerView.setAdapter(merchantLabelAdapter);
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.ProfileMenuHeaderViewHolder_ViewBinding);
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(merchantDetailActivity, 0, false));
        }
        ArrayList arrayList = new ArrayList();
        ShopModel shopModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        if (shopModel.initRecordTimeStamp()) {
            arrayList.add(new MerchantLabelModel(MerchantLabelType.ORDER_ONLINE.getValue(), "", null, 4, null));
        }
        if (shopModel.PrepareContext()) {
            arrayList.add(new MerchantLabelModel(MerchantLabelType.QRIS.getValue(), "", null, 4, null));
        }
        if (shopModel.newProxyInstance()) {
            arrayList.add(new MerchantLabelModel(MerchantLabelType.TOP_UP.getValue(), "", null, 4, null));
        }
        if (shopModel.getErrorConfigVersion()) {
            arrayList.add(new MerchantLabelModel(MerchantLabelType.BISNIS.getValue(), "", null, 4, null));
        }
        merchantLabelAdapter.setItems(arrayList);
    }

    private final void isLayoutRequested() {
        Disposable disposable = this.MyBillsEntityDataFactory;
        if (disposable != null) {
            disposable.dispose();
        }
        this.MyBillsEntityDataFactory = null;
        Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MerchantDetailActivity.$r8$lambda$j14_gV1UZk4FI5pVuTBIff3nJhI(MerchantDetailActivity.this, (Location) obj);
            }
        });
        this.MyBillsEntityDataFactory = subscribe;
        addDisposable(subscribe);
    }

    @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction
    public final void dismissLoadingDialog() {
        ((DanaLoadingDialog) this.getAuthRequestContext.getValue()).PlaceComponentResult();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerMerchantDetailComponent.Builder MyBillsEntityDataFactory = DaggerMerchantDetailComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.getAuthRequestContext = (NearbyTrackerModule) Preconditions.getAuthRequestContext(new NearbyTrackerModule());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (MerchantDetailModule) Preconditions.getAuthRequestContext(new MerchantDetailModule(new MerchantDetailContract.View() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$initInjector$1
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

            /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // id.dana.nearbyme.merchantdetail.MerchantDetailContract.View
            public final void BuiltInFictitiousFunctionClassFactory(ShopModel p0) {
                double d;
                double d2;
                Intrinsics.checkNotNullParameter(p0, "");
                Location access$getLocation = MerchantDetailActivity.access$getLocation(MerchantDetailActivity.this, p0.DatabaseTableConfigUtil, p0.PrepareContext);
                MerchantDetailActivity merchantDetailActivity = MerchantDetailActivity.this;
                d = merchantDetailActivity.BuiltInFictitiousFunctionClassFactory;
                d2 = MerchantDetailActivity.this.PlaceComponentResult;
                p0.getErrorConfigVersion = LocationUtil.MyBillsEntityDataFactory(access$getLocation, MerchantDetailActivity.access$getLocation(merchantDetailActivity, d, d2));
                MerchantDetailActivity.this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
                ?? r2 = 0;
                MerchantDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new MerchantDetailViewState(p0, r2, 2, r2);
                MerchantDetailActivity.this.PrepareContext();
            }

            @Override // id.dana.nearbyme.merchantdetail.MerchantDetailContract.View
            public final void MyBillsEntityDataFactory(Throwable p0, String p1) {
                SkeletonScreen skeletonScreen;
                SkeletonScreen skeletonScreen2;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                skeletonScreen = MerchantDetailActivity.this.getErrorConfigVersion;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                }
                skeletonScreen2 = MerchantDetailActivity.this.scheduleImpl;
                if (skeletonScreen2 != null) {
                    skeletonScreen2.PlaceComponentResult();
                }
                MerchantDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MerchantDetailModule.class);
        if (MyBillsEntityDataFactory.getAuthRequestContext == null) {
            MyBillsEntityDataFactory.getAuthRequestContext = new NearbyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerMerchantDetailComponent.MerchantDetailComponentImpl(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0).MyBillsEntityDataFactory(this);
        registerPresenter(getMerchantDetailPresenter());
        this.getErrorConfigVersion = ShimmeringUtil.PlaceComponentResult((AppCompatImageView) _$_findCachedViewById(R.id.iv_merchant_header_image), R.layout.view_skeleton_merchant_header_image);
        BuiltInFictitiousFunctionClassFactory();
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_try_again_empty_state);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantDetailActivity.$r8$lambda$e1j5Yz_qjaE5da_cKpRy8TrmrA4(MerchantDetailActivity.this, view);
                }
            });
        }
    }

    @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction
    public final void showLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.getAuthRequestContext.getValue();
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (isLayoutRequested ^ 4796183387843776835L);
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
