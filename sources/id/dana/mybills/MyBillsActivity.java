package id.dana.mybills;

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
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Key;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.databinding.ActivityMyBillsBinding;
import id.dana.databinding.ViewMyBillsMonthlyBinding;
import id.dana.databinding.ViewMyBillsOnboardingBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.MyBillsModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.domain.mybills.model.MonthlyAmountAndHighlightRequest;
import id.dana.domain.mybills.model.MyBillsMonthlyAmount;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkListener;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.lib.gcontainer.GContainer;
import id.dana.mapper.ThirdPartyServicesUrlMapper;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.ThirdPartyService;
import id.dana.mybills.adapter.MyBillsMonthlyAdapter;
import id.dana.mybills.adapter.MyBillsOnboardingAdapter;
import id.dana.mybills.adapter.QuickBuyBillsAdapter;
import id.dana.mybills.adapter.ServicesOnMyBillsAdapter;
import id.dana.mybills.di.DaggerMyBillsComponent;
import id.dana.mybills.di.MyBillsContract;
import id.dana.mybills.model.BillSubscriptionHighlightModel;
import id.dana.mybills.model.BizProductModel;
import id.dana.mybills.model.BizProductOrderModel;
import id.dana.mybills.model.HighlighTransactionPayModel;
import id.dana.mybills.model.MonthlyHighlightBillModel;
import id.dana.mybills.swipeaction.SwipeController;
import id.dana.mybills.view.AddNewBillsActivity;
import id.dana.onboarding.OnboardingParams;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.richview.CurrencyTextView;
import id.dana.service.ServiceMaintenanceUtil;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\bu\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0005\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010I\u001a\u00020H8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0013\u0010g\u001a\u00020dX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\be\u0010fR\"\u0010i\u001a\u00020h8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0017\u0010.\u001a\u0006*\u00020o0oX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bp\u0010fR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\br\u0010s"}, d2 = {"Lid/dana/mybills/MyBillsActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityMyBillsBinding;", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/String;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityMyBillsBinding;", "Lid/dana/model/ThirdPartyService;", "(Lid/dana/model/ThirdPartyService;)V", "Lid/dana/cashier/CashierEventHandler;", "cashierEventHandler", "Lid/dana/cashier/CashierEventHandler;", "getCashierEventHandler", "()Lid/dana/cashier/CashierEventHandler;", "setCashierEventHandler", "(Lid/dana/cashier/CashierEventHandler;)V", "", "lookAheadTest", "Z", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "globalNetworkPresenter", "Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "getGlobalNetworkPresenter", "()Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "setGlobalNetworkPresenter", "(Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;)V", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "h5EventPresenter", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "getH5EventPresenter", "()Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "setH5EventPresenter", "(Lid/dana/h5event/CheckoutH5EventContract$Presenter;)V", "", "Lid/dana/mybills/model/BillSubscriptionHighlightModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/adapter/MyBillsMonthlyAdapter;", "initRecordTimeStamp", "Lid/dana/mybills/adapter/MyBillsMonthlyAdapter;", "getAuthRequestContext", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingServicePresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingServicePresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setOnBoardingServicePresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "playStoreReviewPresenter", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "getPlayStoreReviewPresenter", "()Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "setPlayStoreReviewPresenter", "(Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;)V", "Lid/dana/mybills/di/MyBillsContract$Presenter;", "presenter", "Lid/dana/mybills/di/MyBillsContract$Presenter;", "getPresenter", "()Lid/dana/mybills/di/MyBillsContract$Presenter;", "setPresenter", "(Lid/dana/mybills/di/MyBillsContract$Presenter;)V", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/mybills/adapter/ServicesOnMyBillsAdapter;", "GetContactSyncConfig", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/contract/services/ServicesContract$Presenter;", "servicesPresenter", "Lid/dana/contract/services/ServicesContract$Presenter;", "getServicesPresenter", "()Lid/dana/contract/services/ServicesContract$Presenter;", "setServicesPresenter", "(Lid/dana/contract/services/ServicesContract$Presenter;)V", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "DatabaseTableConfigUtil", "Lid/dana/mybills/swipeaction/SwipeController;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/mybills/swipeaction/SwipeController;", "scheduleImpl", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyBillsActivity extends ViewBindingActivity<ActivityMyBillsBinding> {
    public static final int DEFAULT_SERVICES = 8;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
    public static final int SPAN_COUNT = 4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private List<BillSubscriptionHighlightModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private SwipeController scheduleImpl;
    @Inject
    public CashierEventHandler cashierEventHandler;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public FeatureContract.Presenter featurePresenter;
    @Inject
    public GlobalNetworkContract.Presenter globalNetworkPresenter;
    @Inject
    public CheckoutH5EventContract.Presenter h5EventPresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private MyBillsMonthlyAdapter getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    @Inject
    public BottomSheetOnBoardingContract.Presenter onBoardingServicePresenter;
    @Inject
    public PlayStoreReviewContract.Presenter playStoreReviewPresenter;
    @Inject
    public MyBillsContract.Presenter presenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    @Inject
    public ServicesContract.Presenter servicesPresenter;
    public static final byte[] $$a = {18, -87, -121, -123, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 180;
    public static final byte[] getAuthRequestContext = {113, -101, 105, Ascii.SUB, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 224;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory = "";

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ServicesOnMyBillsAdapter>() { // from class: id.dana.mybills.MyBillsActivity$serviceAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ServicesOnMyBillsAdapter invoke() {
            return new ServicesOnMyBillsAdapter();
        }
    });

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.mybills.MyBillsActivity$skeletonScreen$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewSkeletonScreen invoke() {
            ActivityMyBillsBinding binding;
            binding = MyBillsActivity.this.getBinding();
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(binding.getErrorConfigVersion);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = id.dana.R.layout.service_card_skeleton;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), id.dana.R.color.f27082131100491);
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            return viewSkeletonScreen;
        }
    });

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0021 -> B:23:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 23 - r7
            byte[] r0 = id.dana.mybills.MyBillsActivity.getAuthRequestContext
            int r6 = 56 - r6
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r8
            r3 = 0
            r8 = r7
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            int r6 = r6 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.MyBillsActivity.a(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r6 = r6 + 4
            byte[] r0 = id.dana.mybills.MyBillsActivity.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L18:
            r3 = 0
            r5 = r8
            r8 = r7
        L1b:
            r7 = r5
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.MyBillsActivity.c(int, int, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        NetworkUserEntityData$$ExternalSyntheticLambda8 = 269894703;
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
        b(true, TextUtils.getCapsMode("", 0, 0) + 109, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 4, 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{1, 11, 65534, 16, 16, 2, 0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(false, TextUtils.getOffsetAfter("", 0) + 114, 5 - TextUtils.getOffsetBefore("", 0), 4 - TextUtils.lastIndexOf("", '0', 0), new char[]{5, 17, 65517, 1, 65532}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(false, 81 - View.resolveSize(0, 0), Gravity.getAbsoluteGravity(0, 0) + 29, 48 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(true, 75 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 47, Color.alpha(0) + 64, new char[]{65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(true, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 77, 25 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 64 - KeyEvent.normalizeMetaState(0), new char[]{65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(false, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 106, (-16777171) - Color.rgb(0, 0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 61, new char[]{17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(false, 61 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 6, Drawable.resolveOpacity(0, 0) + 6, new char[]{65532, 2, 65532, 0, 65535, 7}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 18 - View.getDefaultSize(0, 0), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = getAuthRequestContext[30];
                Object[] objArr15 = new Object[1];
                a((short) 30, b, (byte) (b + 1), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), ImageFormat.getBitsPerPixel(0) + 4, (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        byte b2 = $$a[78];
                        byte b3 = $$a[47];
                        Object[] objArr17 = new Object[1];
                        c(b2, b3, b3, objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), View.MeasureSpec.makeMeasureSpec(0, 0) + 15, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 800, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 14, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 815, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 28, (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.alpha(0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 16, (char) TextUtils.getOffsetAfter("", 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {899694817, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), View.MeasureSpec.getSize(0) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b4 = getAuthRequestContext[30];
                Object[] objArr22 = new Object[1];
                a((short) 30, b4, (byte) (b4 + 1), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 61, 47 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr24 = new Object[1];
                        c((byte) (-$$a[28]), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr26 = {899694817, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b5 = getAuthRequestContext[30];
                Object[] objArr29 = new Object[1];
                a((short) 30, b5, (byte) (b5 + 1), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 118, (-16777213) - Color.rgb(0, 0, 0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 38967));
                        Object[] objArr31 = new Object[1];
                        c((byte) (-$$a[28]), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {899694817, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b6 = getAuthRequestContext[30];
                Object[] objArr36 = new Object[1];
                a((short) 30, b6, (byte) (b6 + 1), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2, (char) TextUtils.indexOf("", "", 0, 0));
                        Object[] objArr38 = new Object[1];
                        c($$a[40], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr40 = {899694817, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, AndroidCharacter.getMirror('0') - 30, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        Object[] objArr = new Object[1];
        b(true, super.getResources().getString(id.dana.R.string.request_money_add_bank_check_title).substring(14, 15).codePointAt(0) - 8, getPackageName().length() - 4, super.getResources().getString(id.dana.R.string.kyc_success_description).substring(0, 30).length() - 12, new char[]{1, 11, 65534, 16, 16, 2, 0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        b(false, 162 - AndroidCharacter.getMirror('0'), super.getResources().getString(id.dana.R.string.qr_profile_scanner_alert_message).substring(0, 1).length() + 4, super.getResources().getString(id.dana.R.string.unregistered_number_description).substring(2, 3).length() + 4, new char[]{5, 17, 65517, 1, 65532}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int codePointAt = getPackageName().codePointAt(6) + 12;
                int codePointAt2 = getPackageName().codePointAt(5) - 107;
                try {
                    byte b = (byte) (getAuthRequestContext[49] - 1);
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr3 = new Object[1];
                    a(b, b2, b2, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(false, codePointAt, codePointAt2, ((ApplicationInfo) cls2.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15}, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    int length = super.getResources().getString(id.dana.R.string.type_name_bank_or_phone_number).substring(7, 8).length() + 115;
                    int indexOf = TextUtils.indexOf("", "", 0, 0) + 14;
                    try {
                        byte b3 = (byte) (getAuthRequestContext[49] - 1);
                        byte b4 = getAuthRequestContext[25];
                        Object[] objArr5 = new Object[1];
                        a(b3, b4, b4, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        a(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        b(true, length, indexOf, ((ApplicationInfo) cls4.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n'}, objArr6);
                        baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    int keyRepeatDelay = 81 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    try {
                        byte b5 = (byte) (getAuthRequestContext[49] - 1);
                        byte b6 = getAuthRequestContext[25];
                        Object[] objArr7 = new Object[1];
                        a(b5, b6, b6, objArr7);
                        Class<?> cls5 = Class.forName((String) objArr7[0]);
                        a(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                        Object[] objArr8 = new Object[1];
                        b(false, keyRepeatDelay, ((ApplicationInfo) cls5.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 4, getPackageName().length() + 41, new char[]{JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(true, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 76, 47 - TextUtils.indexOf("", "", 0, 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 63, new char[]{65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(true, super.getResources().getString(id.dana.R.string.res_0x7f13015b_networkuserentitydata_externalsyntheticlambda0).substring(5, 6).length() + 77, View.combineMeasuredStates(0, 0) + 24, super.getResources().getString(id.dana.R.string.set_security_next).substring(1, 2).length() + 63, new char[]{65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523}, objArr10);
                        String str3 = (String) objArr10[0];
                        int pressedStateDuration = 107 - (ViewConfiguration.getPressedStateDuration() >> 16);
                        try {
                            byte b7 = (byte) (getAuthRequestContext[49] - 1);
                            byte b8 = getAuthRequestContext[25];
                            Object[] objArr11 = new Object[1];
                            a(b7, b8, b8, objArr11);
                            Class<?> cls6 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            a(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[5], objArr12);
                            Object[] objArr13 = new Object[1];
                            b(false, pressedStateDuration, ((ApplicationInfo) cls6.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 12, TextUtils.indexOf("", "", 0, 0) + 60, new char[]{17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7}, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            b(false, super.getResources().getString(id.dana.R.string.verification_list_active_title).substring(2, 4).codePointAt(0) - 56, getPackageName().length() - 2, super.getResources().getString(id.dana.R.string.social_feeds_empty_state_title).substring(5, 6).length() + 5, new char[]{65532, 2, 65532, 0, 65535, 7}, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), Process.getGidForName("") + 19, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr15);
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
            Object[] objArr16 = new Object[1];
            a((byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr16);
            Class<?> cls7 = Class.forName((String) objArr16[0]);
            byte b9 = getAuthRequestContext[30];
            Object[] objArr17 = new Object[1];
            a((short) 30, b9, (byte) (b9 + 1), objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 5, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
                    Object[] objArr19 = new Object[1];
                    c($$a[40], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr19);
                    obj3 = cls8.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 35 - KeyEvent.getDeadChar(0, 0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr21 = {-1452442546, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
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
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int keyCodeFromString = KeyEvent.keyCodeFromString("") + 109;
            int length = super.getResources().getString(id.dana.R.string.pushverify_dana_protection_recommendation).substring(5, 6).length() + 2;
            try {
                byte b = (byte) (getAuthRequestContext[49] - 1);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(false, keyCodeFromString, length, ((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(true, getPackageName().codePointAt(1) + 16, ((byte) KeyEvent.getModifierMetaStateMask()) + 15, 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n'}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), KeyEvent.keyCodeFromString("") + 18, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = (byte) (getAuthRequestContext[49] - 1);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[41], getAuthRequestContext[5], objArr2);
                Object[] objArr3 = new Object[1];
                b(false, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 76, getPackageName().length() - 4, 26 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(true, super.getResources().getString(id.dana.R.string.trusted_device_title).substring(6, 7).length() + 115, 14 - TextUtils.getOffsetAfter("", 0), 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), new char[]{65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n'}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getPresenter")
    public final MyBillsContract.Presenter getPresenter() {
        MyBillsContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(MyBillsContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getServicesPresenter")
    public final ServicesContract.Presenter getServicesPresenter() {
        ServicesContract.Presenter presenter = this.servicesPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setServicesPresenter")
    public final void setServicesPresenter(ServicesContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.servicesPresenter = presenter;
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

    @JvmName(name = "getH5EventPresenter")
    public final CheckoutH5EventContract.Presenter getH5EventPresenter() {
        CheckoutH5EventContract.Presenter presenter = this.h5EventPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setH5EventPresenter")
    public final void setH5EventPresenter(CheckoutH5EventContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.h5EventPresenter = presenter;
    }

    @JvmName(name = "getOnBoardingServicePresenter")
    public final BottomSheetOnBoardingContract.Presenter getOnBoardingServicePresenter() {
        BottomSheetOnBoardingContract.Presenter presenter = this.onBoardingServicePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnBoardingServicePresenter")
    public final void setOnBoardingServicePresenter(BottomSheetOnBoardingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.onBoardingServicePresenter = presenter;
    }

    @JvmName(name = "getGlobalNetworkPresenter")
    public final GlobalNetworkContract.Presenter getGlobalNetworkPresenter() {
        GlobalNetworkContract.Presenter presenter = this.globalNetworkPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGlobalNetworkPresenter")
    public final void setGlobalNetworkPresenter(GlobalNetworkContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.globalNetworkPresenter = presenter;
    }

    @JvmName(name = "getDeviceInformationProvider")
    public final DeviceInformationProvider getDeviceInformationProvider() {
        DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
        if (deviceInformationProvider != null) {
            return deviceInformationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
    }

    @JvmName(name = "getPlayStoreReviewPresenter")
    public final PlayStoreReviewContract.Presenter getPlayStoreReviewPresenter() {
        PlayStoreReviewContract.Presenter presenter = this.playStoreReviewPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPlayStoreReviewPresenter")
    public final void setPlayStoreReviewPresenter(PlayStoreReviewContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.playStoreReviewPresenter = presenter;
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

    @JvmName(name = "getCashierEventHandler")
    public final CashierEventHandler getCashierEventHandler() {
        CashierEventHandler cashierEventHandler = this.cashierEventHandler;
        if (cashierEventHandler != null) {
            return cashierEventHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCashierEventHandler")
    public final void setCashierEventHandler(CashierEventHandler cashierEventHandler) {
        Intrinsics.checkNotNullParameter(cashierEventHandler, "");
        this.cashierEventHandler = cashierEventHandler;
    }

    @JvmName(name = "getFeaturePresenter")
    public final FeatureContract.Presenter getFeaturePresenter() {
        FeatureContract.Presenter presenter = this.featurePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.featurePresenter = presenter;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityMyBillsBinding initViewBinding() {
        ActivityMyBillsBinding MyBillsEntityDataFactory = ActivityMyBillsBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(id.dana.R.string.my_bills_title_page));
        setMenuLeftButton(id.dana.R.drawable.btn_arrow_left);
    }

    private final void PlaceComponentResult(ThirdPartyService p0) {
        Bundle bundle = new Bundle();
        bundle.putString(DanaH5.SERVICE_KEY, p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
        if (StringsKt.equals("service_akulaku", p0.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
            bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
            DanaH5.startContainerFullUrlWithSendCredentials$default(PlaceComponentResult(this.MyBillsEntityDataFactory), new MyBillsActivity$createH5AppListener$1(this), bundle, null, 8, null);
            this.PlaceComponentResult = false;
            getH5EventPresenter().MyBillsEntityDataFactory();
        } else if (StringsKt.equals("service_danakaget", p0.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
            getOnBoardingServicePresenter().PlaceComponentResult("dana_kaget", this.MyBillsEntityDataFactory);
        } else if (StringsKt.equals("service_my_bills", p0.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
            getOnBoardingServicePresenter().PlaceComponentResult("my_bills", this.MyBillsEntityDataFactory);
        } else if (StringsKt.equals(GlobalNetworkConstants.GLOBAL_NETWORK_SERVICE, p0.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
            getGlobalNetworkPresenter().BuiltInFictitiousFunctionClassFactory();
        } else if (StringsKt.equals("service_danafood", p0.NetworkUserEntityData$$ExternalSyntheticLambda8, true)) {
            getOnBoardingServicePresenter().PlaceComponentResult("dana_food", this.MyBillsEntityDataFactory);
        } else {
            DanaH5.startContainerFullUrlWithSendCredentials$default(PlaceComponentResult(this.MyBillsEntityDataFactory), new MyBillsActivity$createH5AppListener$1(this), bundle, null, 8, null);
            this.PlaceComponentResult = false;
            getH5EventPresenter().MyBillsEntityDataFactory();
        }
    }

    private static String PlaceComponentResult(String p0) {
        if (StringsKt.contains$default((CharSequence) p0, (CharSequence) "entryPoint", false, 2, (Object) null)) {
            return p0;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(p0, "Home");
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return DanaH5.correctedUrl(authRequestContext);
    }

    public static /* synthetic */ void $r8$lambda$Qrj_3oGefbk26xF69DNhnGS4t9A(MyBillsActivity myBillsActivity, boolean z) {
        Intrinsics.checkNotNullParameter(myBillsActivity, "");
        myBillsActivity.PlaceComponentResult = z;
    }

    public static /* synthetic */ void $r8$lambda$VOXlusarbKISEQ_FUE2ug2nm3nc(MyBillsActivity myBillsActivity, View view) {
        Intrinsics.checkNotNullParameter(myBillsActivity, "");
        myBillsActivity.getPresenter().getAuthRequestContext(new MonthlyAmountAndHighlightRequest(null, null, null, null, null, true, 0, 3, 95, null));
    }

    /* renamed from: $r8$lambda$dh-BXrN2ctJzcacPQCS5-GDbU7Q */
    public static /* synthetic */ void m2674$r8$lambda$dhBXrN2ctJzcacPQCS5GDbU7Q(MyBillsActivity myBillsActivity, View view) {
        Intrinsics.checkNotNullParameter(myBillsActivity, "");
        Intent intent = new Intent(myBillsActivity, ContinualBillsActivity.class);
        List<BillSubscriptionHighlightModel> list = myBillsActivity.BuiltInFictitiousFunctionClassFactory;
        Intent putParcelableArrayListExtra = intent.putParcelableArrayListExtra(ContinualBillsActivity.CONTINUAL_DATA, list != null ? new ArrayList<>(list) : null);
        Intrinsics.checkNotNullExpressionValue(putParcelableArrayListExtra, "");
        myBillsActivity.startActivity(putParcelableArrayListExtra);
    }

    /* renamed from: $r8$lambda$ohnX5nx_876P6o3PX0fh8UIT-4E */
    public static /* synthetic */ void m2675$r8$lambda$ohnX5nx_876P6o3PX0fh8UIT4E(MyBillsActivity myBillsActivity, View view) {
        Intrinsics.checkNotNullParameter(myBillsActivity, "");
        myBillsActivity.startActivity(new Intent(myBillsActivity, AddNewBillsActivity.class));
    }

    public static final /* synthetic */ DanaH5Listener access$createH5AppListener(MyBillsActivity myBillsActivity) {
        return new MyBillsActivity$createH5AppListener$1(myBillsActivity);
    }

    public static final /* synthetic */ void access$doOnOpenH5(MyBillsActivity myBillsActivity) {
        myBillsActivity.PlaceComponentResult = false;
        myBillsActivity.getH5EventPresenter().MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ ServicesOnMyBillsAdapter access$getServiceAdapter(MyBillsActivity myBillsActivity) {
        return (ServicesOnMyBillsAdapter) myBillsActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ void access$hideSkeleton(MyBillsActivity myBillsActivity) {
        myBillsActivity.getBinding().getErrorConfigVersion.setVisibility(8);
        ((ViewSkeletonScreen) myBillsActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).PlaceComponentResult();
        if (((ViewSkeletonScreen) myBillsActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()) != null) {
            ((ViewSkeletonScreen) myBillsActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$mapDataMonthlyAmountMyBills(MyBillsActivity myBillsActivity, MyBillsMonthlyAmount myBillsMonthlyAmount) {
        ViewMyBillsMonthlyBinding viewMyBillsMonthlyBinding = myBillsActivity.getBinding().lookAheadTest;
        TextView textView = viewMyBillsMonthlyBinding.getErrorConfigVersion;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = myBillsActivity.getString(id.dana.R.string.my_bills_monthly_count);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{myBillsMonthlyAmount.getTotalCount()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
        CurrencyTextView currencyTextView = viewMyBillsMonthlyBinding.moveToNextValue;
        MoneyView totalEstimatedAmount = myBillsMonthlyAmount.getTotalEstimatedAmount();
        currencyTextView.setText(totalEstimatedAmount != null ? totalEstimatedAmount.getAmount() : null);
    }

    public static final /* synthetic */ void access$openAcService(MyBillsActivity myBillsActivity, String str, boolean z) {
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(GlobalNetworkConstants.FOREX_EXCHANGE);
            str = sb.toString();
        }
        DanaH5.startContainerFullUrl(str, new MyBillsActivity$createH5AppListener$1(myBillsActivity));
        myBillsActivity.PlaceComponentResult = false;
        myBillsActivity.getH5EventPresenter().MyBillsEntityDataFactory();
        myBillsActivity.getGlobalNetworkPresenter().getAuthRequestContext();
    }

    public static final /* synthetic */ void access$openH5(MyBillsActivity myBillsActivity, ThirdPartyService thirdPartyService, String str, String str2, String str3) {
        GContainer.closeAllContainers();
        if (GContainer.isOpeningH5()) {
            return;
        }
        myBillsActivity.MyBillsEntityDataFactory = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, str3, thirdPartyService);
        myBillsActivity.PlaceComponentResult(thirdPartyService);
    }

    public static final /* synthetic */ void access$populateMonthlyHighlightBills(MyBillsActivity myBillsActivity, MonthlyHighlightBillModel monthlyHighlightBillModel) {
        List<BillSubscriptionHighlightModel> list = monthlyHighlightBillModel.getAuthRequestContext;
        if (!(list == null || list.isEmpty())) {
            MyBillsMonthlyAdapter myBillsMonthlyAdapter = myBillsActivity.getAuthRequestContext;
            if (myBillsMonthlyAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                myBillsMonthlyAdapter = null;
            }
            myBillsMonthlyAdapter.setItems(monthlyHighlightBillModel.getAuthRequestContext);
            ConstraintLayout constraintLayout = myBillsActivity.getBinding().lookAheadTest.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(0);
            LinearLayoutCompat linearLayoutCompat = myBillsActivity.getBinding().moveToNextValue.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "");
            linearLayoutCompat.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = myBillsActivity.getBinding().lookAheadTest.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(8);
        LinearLayoutCompat linearLayoutCompat2 = myBillsActivity.getBinding().moveToNextValue.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat2, "");
        linearLayoutCompat2.setVisibility(0);
    }

    public static final /* synthetic */ void access$setupQuickBuy(final MyBillsActivity myBillsActivity, List list) {
        RecyclerView recyclerView = myBillsActivity.getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        QuickBuyBillsAdapter quickBuyBillsAdapter = new QuickBuyBillsAdapter();
        quickBuyBillsAdapter.setItems(list);
        Function1<BizProductModel, Unit> function1 = new Function1<BizProductModel, Unit>() { // from class: id.dana.mybills.MyBillsActivity$setupQuickBuy$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BizProductModel bizProductModel) {
                invoke2(bizProductModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BizProductModel bizProductModel) {
                Intrinsics.checkNotNullParameter(bizProductModel, "");
                MyBillsActivity.this.getPresenter().PlaceComponentResult(bizProductModel);
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        quickBuyBillsAdapter.getAuthRequestContext = function1;
        recyclerView.setAdapter(quickBuyBillsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
    }

    public static final /* synthetic */ void access$setupServiceList(MyBillsActivity myBillsActivity, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ThirdPartyService) next).D != 3) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        if (arrayList2.size() > 8) {
            arrayList3.addAll(arrayList2.subList(0, 8));
        } else {
            arrayList3.addAll(arrayList2);
        }
        ((ServicesOnMyBillsAdapter) myBillsActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).setItems(CollectionsKt.toList(arrayList3));
    }

    public static final /* synthetic */ void access$showErrorHeaderSection(MyBillsActivity myBillsActivity) {
        LinearLayoutCompat linearLayoutCompat = myBillsActivity.getBinding().moveToNextValue.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "");
        linearLayoutCompat.setVisibility(8);
        myBillsActivity.getBinding().scheduleImpl.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
    }

    static /* synthetic */ void openH5$default(MyBillsActivity myBillsActivity, ThirdPartyService thirdPartyService, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            str3 = "";
        }
        GContainer.closeAllContainers();
        if (GContainer.isOpeningH5()) {
            return;
        }
        myBillsActivity.MyBillsEntityDataFactory = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, str3, thirdPartyService);
        myBillsActivity.PlaceComponentResult(thirdPartyService);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        DaggerMyBillsComponent.Builder authRequestContext = DaggerMyBillsComponent.getAuthRequestContext();
        authRequestContext.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        authRequestContext.lookAheadTest = (MyBillsModule) Preconditions.getAuthRequestContext(new MyBillsModule(new MyBillsContract.View() { // from class: id.dana.mybills.MyBillsActivity$provideMyBillsModule$1
            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(MyBillsMonthlyAmount p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void MyBillsEntityDataFactory(MonthlyHighlightBillModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void getAuthRequestContext(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
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

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void PlaceComponentResult(List<BizProductModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if ((!p0.isEmpty()) != false) {
                    MyBillsActivity.access$setupQuickBuy(MyBillsActivity.this, p0);
                } else {
                    MyBillsActivity.this.getBinding().MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
                }
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                MyBillsActivity.this.getBinding().MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                MyBillsActivity.this.getBinding().MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void MyBillsEntityDataFactory(BizProductOrderModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierEventHandler cashierEventHandler = MyBillsActivity.this.getCashierEventHandler();
                MyBillsActivity myBillsActivity = MyBillsActivity.this;
                String str = p0.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(myBillsActivity, "");
                Intrinsics.checkNotNullParameter(str, "");
                cashierEventHandler.BuiltInFictitiousFunctionClassFactory(myBillsActivity, str, null, null);
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsMonthlyAmount p0, MonthlyHighlightBillModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                MyBillsActivity.this.getBinding().scheduleImpl.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                MyBillsActivity.access$mapDataMonthlyAmountMyBills(MyBillsActivity.this, p0);
                MyBillsActivity.access$populateMonthlyHighlightBills(MyBillsActivity.this, p1);
                List<BillSubscriptionHighlightModel> list = p1.getAuthRequestContext;
                if (list != null) {
                    MyBillsActivity.this.getPresenter().PlaceComponentResult(list);
                }
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyBillsActivity.access$showErrorHeaderSection(MyBillsActivity.this);
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void MyBillsEntityDataFactory(List<BillSubscriptionHighlightModel> p0) {
                MyBillsMonthlyAdapter myBillsMonthlyAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                MyBillsActivity.this.BuiltInFictitiousFunctionClassFactory = p0;
                myBillsMonthlyAdapter = MyBillsActivity.this.getAuthRequestContext;
                if (myBillsMonthlyAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    myBillsMonthlyAdapter = null;
                }
                myBillsMonthlyAdapter.setItems(p0);
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(HighlighTransactionPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                String str = p0.getAuthRequestContext;
                boolean z = false;
                if (str != null) {
                    if (str.length() > 0) {
                        z = true;
                    }
                }
                if (z) {
                    DanaH5.startContainerFullUrl(p0.getAuthRequestContext, MyBillsActivity.access$createH5AppListener(MyBillsActivity.this));
                }
            }
        }));
        authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.mybills.MyBillsActivity$provideServicesModule$1
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
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
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
            public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetThirdPartyServices(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyBillsActivity.access$setupServiceList(MyBillsActivity.this, p0);
                MyBillsActivity.access$hideSkeleton(MyBillsActivity.this);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionPost(ThirdPartyService p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyBillsActivity myBillsActivity = MyBillsActivity.this;
                String authRequestContext2 = UrlUtil.getAuthRequestContext(p0.getCallingPid);
                Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
                MyBillsActivity.access$openH5(myBillsActivity, p0, authRequestContext2, p1, MyBillsActivity.this.getDeviceInformationProvider().getDeviceUUID());
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onFeatureServices(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyBillsActivity.access$setupServiceList(MyBillsActivity.this, p0);
                MyBillsActivity.access$hideSkeleton(MyBillsActivity.this);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onCheckFavoriteServicesFeature(boolean p0) {
                MyBillsActivity.this.getServicesPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onMaintenanceAction(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServiceMaintenanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionGet(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (!UrlUtil.getErrorConfigVersion(p0.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
                    MyBillsActivity myBillsActivity = MyBillsActivity.this;
                    String authRequestContext2 = UrlUtil.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda6);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
                    MyBillsActivity.access$openH5(myBillsActivity, p0, authRequestContext2, null, null);
                    return;
                }
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (str != null) {
                    MyBillsActivity.this.getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onDirectOpen(ThirdPartyService p0, Map<String, String> p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str != null) {
                    MyBillsActivity.this.getFeaturePresenter().getAuthRequestContext(str, p1);
                }
            }
        }));
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        MyBillsActivity myBillsActivity = this;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = myBillsActivity;
        byte b = 0;
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext2 = ScanQrModule.getAuthRequestContext();
        authRequestContext2.MyBillsEntityDataFactory = myBillsActivity;
        authRequestContext.DatabaseTableConfigUtil = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext2, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = myBillsActivity;
        authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = myBillsActivity;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = myBillsActivity;
        authRequestContext.getErrorConfigVersion = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        authRequestContext.MyBillsEntityDataFactory = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.mybills.MyBillsActivity$$ExternalSyntheticLambda0
            @Override // id.dana.h5event.CheckoutH5EventContract.View
            public final void getAuthRequestContext(boolean z) {
                MyBillsActivity.$r8$lambda$Qrj_3oGefbk26xF69DNhnGS4t9A(MyBillsActivity.this, z);
            }
        }));
        authRequestContext.moveToNextValue = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(myBillsActivity)));
        authRequestContext.PlaceComponentResult = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.mybills.MyBillsActivity$initInjector$2
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

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1) {
                String PlaceComponentResult2 = p0 ? UrlUtil.PlaceComponentResult(p1, OnboardingParams.FIRST_TIME_TOP_UP) : p1;
                DanaH5.startContainerFullUrlWithSendCredentials$default(PlaceComponentResult2 != null ? PlaceComponentResult2 : p1, MyBillsActivity.access$createH5AppListener(MyBillsActivity.this), null, null, 12, null);
                MyBillsActivity.access$doOnOpenH5(MyBillsActivity.this);
            }
        }));
        authRequestContext.scheduleImpl = (GlobalNetworkModule) Preconditions.getAuthRequestContext(new GlobalNetworkModule(new GlobalNetworkListener() { // from class: id.dana.mybills.MyBillsActivity$initInjector$3
            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                String str;
                String str2;
                str = MyBillsActivity.this.MyBillsEntityDataFactory;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                MyBillsActivity myBillsActivity2 = MyBillsActivity.this;
                str2 = myBillsActivity2.MyBillsEntityDataFactory;
                MyBillsActivity.access$openAcService(myBillsActivity2, str2, p0);
            }
        }));
        authRequestContext.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(this);
        registerPresenter(getPresenter());
        ViewPager2 viewPager2 = getBinding().moveToNextValue.moveToNextValue;
        Context context = viewPager2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        Intrinsics.checkNotNullExpressionValue(viewPager2, "");
        viewPager2.setAdapter(new MyBillsOnboardingAdapter(context, new MyBillsActivity$initViewPagerOnboarding$1$1(viewPager2)));
        ViewMyBillsOnboardingBinding viewMyBillsOnboardingBinding = getBinding().moveToNextValue;
        TabLayout tabLayout = viewMyBillsOnboardingBinding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "");
        ViewPager2 viewPager22 = viewMyBillsOnboardingBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "");
        ViewPagerExtKt.getAuthRequestContext(tabLayout, viewPager22, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0137: INVOKE 
              (r2v13 'tabLayout' com.google.android.material.tabs.TabLayout)
              (r5v2 'viewPager22' androidx.viewpager2.widget.ViewPager2)
              (wrap: id.dana.extension.view.ViewPagerExtKt$attachViewPager$1 : 0x0000: SGET  A[WRAPPED] (LINE:27) id.dana.extension.view.ViewPagerExtKt$attachViewPager$1.INSTANCE id.dana.extension.view.ViewPagerExtKt$attachViewPager$1)
             type: STATIC call: id.dana.extension.view.ViewPagerExtKt.getAuthRequestContext(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, kotlin.jvm.functions.Function2):void A[MD:(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, kotlin.jvm.functions.Function2<? super com.google.android.material.tabs.TabLayout$Tab, ? super java.lang.Integer, kotlin.Unit>):void (m)] (LINE:25) in method: id.dana.mybills.MyBillsActivity.init():void, file: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.extension.view.ViewPagerExtKt$attachViewPager$1, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
            	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
            	... 15 more
            */
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.MyBillsActivity.init():void");
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (NetworkUserEntityData$$ExternalSyntheticLambda8 ^ (-5694784870793460699L))));
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
