package id.dana.wallet_v3.investment.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ExpandableListView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.OnBackPressedCallback;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.databinding.FragmentInvestmentDetailWalletBinding;
import id.dana.di.modules.OauthModule;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.ThirdPartyService;
import id.dana.tracker.spm.ServicesTracker;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet_v3.WalletDetailBaseImplementation;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.investment.adapter.InvestmentWalletAdapter;
import id.dana.wallet_v3.investment.di.DaggerInvestmentWalletDetailComponent;
import id.dana.wallet_v3.investment.di.InvestmentWalletDetailModule;
import id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract;
import id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaEmasClickListener$2;
import id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaGoalsClickListener$2;
import id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaPlusClickListener$2;
import id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$ptrCardInvestmentHandle$2;
import id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$walletCardAssetClickListener$2;
import id.dana.wallet_v3.listener.DanaEmasClickListener;
import id.dana.wallet_v3.listener.DanaPlusClickListener;
import id.dana.wallet_v3.listener.GoalsClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.listener.WalletDetailBaseFunction;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.util.WalletV3ToastUtilKt;
import id.dana.wallet_v3.view.NewWalletFragment;
import id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset;
import id.dana.wallet_v3.view.ptr.PtrWalletFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.text.Typography;
import o.E;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¦\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002¦\u0001B\b¢\u0006\u0005\b¥\u0001\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\u0012J\u000f\u0010%\u001a\u00020\bH\u0014¢\u0006\u0004\b%\u0010\u0012J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0012J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0012J\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\u0012J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0014¢\u0006\u0004\b+\u0010,J\u0018\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\b¢\u0006\u0004\b2\u0010\u0012J\u000f\u00103\u001a\u00020\bH\u0002¢\u0006\u0004\b3\u0010\u0012J\r\u00104\u001a\u00020\b¢\u0006\u0004\b4\u0010\u0012J\u000f\u00105\u001a\u00020\bH\u0016¢\u0006\u0004\b5\u0010\u0012J\u000f\u00106\u001a\u00020\bH\u0016¢\u0006\u0004\b6\u0010\u0012J\u000f\u00107\u001a\u00020\bH\u0016¢\u0006\u0004\b7\u0010\u0012J\u000f\u00108\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u0010\u0012J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020/H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010\u0012J\u0017\u0010?\u001a\u00020\b2\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020D8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bK\u0010F\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bP\u0010F\u001a\u0004\bQ\u0010RR\"\u0010U\u001a\u00020T8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001a\u00020b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010j\u001a\u00020i8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001c\u0010q\u001a\b\u0012\u0004\u0012\u00020=0p8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bx\u0010wR\u0014\u0010z\u001a\u00020y8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u001c\u0010\u0080\u0001\u001a\u00020|8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b}\u0010F\u001a\u0004\b~\u0010\u007fR*\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R*\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R \u0010\u0096\u0001\u001a\u00030\u0092\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b\u0093\u0001\u0010F\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R*\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R*\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001"}, d2 = {"Lid/dana/wallet_v3/investment/view/InvestmentWalletDetailFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentInvestmentDetailWalletBinding;", "Lid/dana/wallet_v3/listener/WalletDetailBaseFunction;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "backFromSearch", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", HomeTabActivity.WALLET_SECTION, "backToMainPage", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;I)V", "disableSwipe", "()V", "Lid/dana/contract/user/GetBalanceModule;", "getBalanceModule", "()Lid/dana/contract/user/GetBalanceModule;", "Lid/dana/wallet_v3/investment/di/InvestmentWalletDetailModule;", "getInvestmentDetailModule", "()Lid/dana/wallet_v3/investment/di/InvestmentWalletDetailModule;", "getLayout", "()I", "Lid/dana/contract/services/ServicesModule;", "getServicesModule", "()Lid/dana/contract/services/ServicesModule;", "Lid/dana/wallet_v3/view/NewWalletFragment;", "getWalletFragment", "(Landroidx/fragment/app/FragmentManager;)Lid/dana/wallet_v3/view/NewWalletFragment;", "key", "goToServicePage", "(Ljava/lang/String;)V", "hideShimmeringSkeleton", IAPSyncCommand.COMMAND_INIT, "initInjector", "initOnClickListener", "initView", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/FragmentInvestmentDetailWalletBinding;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "isFromDeeplinkWallet", "(Landroid/app/Activity;)Z", "loadData", "navigateToSearch", "onCollapseFromSearch", "onDestroyView", "onResume", "onStart", "openBottomSheetAddAsset", "isDefaultIndonesian", "setupLottieBasedOnLanguage", "(Z)V", "showShimmeringSkeleton", "Lid/dana/model/ThirdPartyService;", "it", "trackServiceOpen", "(Lid/dana/model/ThirdPartyService;)V", "Lid/dana/wallet_v3/investment/view/InvestmentWalletDetailFragment$walletH5Listener$1;", "walletH5Listener", "()Lid/dana/wallet_v3/investment/view/InvestmentWalletDetailFragment$walletH5Listener$1;", "Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "danaEmasClickListener$delegate", "Lkotlin/Lazy;", "getDanaEmasClickListener", "()Lid/dana/wallet_v3/listener/DanaEmasClickListener;", "danaEmasClickListener", "Lid/dana/wallet_v3/listener/GoalsClickListener;", "danaGoalsClickListener$delegate", "getDanaGoalsClickListener", "()Lid/dana/wallet_v3/listener/GoalsClickListener;", "danaGoalsClickListener", "Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "danaPlusClickListener$delegate", "getDanaPlusClickListener", "()Lid/dana/wallet_v3/listener/DanaPlusClickListener;", "danaPlusClickListener", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "getBalancePresenter", "Lid/dana/contract/user/GetBalanceContract$Presenter;", "getGetBalancePresenter", "()Lid/dana/contract/user/GetBalanceContract$Presenter;", "setGetBalancePresenter", "(Lid/dana/contract/user/GetBalanceContract$Presenter;)V", "Lid/dana/wallet_v3/investment/presenter/InvestmentWalletDetailContract$Presenter;", "investmentPresenter", "Lid/dana/wallet_v3/investment/presenter/InvestmentWalletDetailContract$Presenter;", "getInvestmentPresenter", "()Lid/dana/wallet_v3/investment/presenter/InvestmentWalletDetailContract$Presenter;", "setInvestmentPresenter", "(Lid/dana/wallet_v3/investment/presenter/InvestmentWalletDetailContract$Presenter;)V", "", "investmentServices", "Ljava/util/List;", "Lid/dana/wallet_v3/investment/adapter/InvestmentWalletAdapter;", "investmentWalletAdapter", "Lid/dana/wallet_v3/investment/adapter/InvestmentWalletAdapter;", "isFromAddAsset", "Z", GriverMonitorConstants.KEY_IS_LOADING, "Lid/dana/wallet_v3/investment/view/InvestmentWalletDetailFragment$onBackPressedCallback$1;", "onBackPressedCallback", "Lid/dana/wallet_v3/investment/view/InvestmentWalletDetailFragment$onBackPressedCallback$1;", "Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardInvestmentHandle$delegate", "getPtrCardInvestmentHandle", "()Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardInvestmentHandle", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/contract/services/ServicesContract$Presenter;", "servicesPresenter", "Lid/dana/contract/services/ServicesContract$Presenter;", "getServicesPresenter", "()Lid/dana/contract/services/ServicesContract$Presenter;", "setServicesPresenter", "(Lid/dana/contract/services/ServicesContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonScreen", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener$delegate", "getWalletCardAssetClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "walletH5ServicesImplementation", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "getWalletH5ServicesImplementation", "()Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "setWalletH5ServicesImplementation", "(Lid/dana/wallet_v3/WalletH5ServicesImplementation;)V", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "walletV3TrackerImplementation", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "getWalletV3TrackerImplementation", "()Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "setWalletV3TrackerImplementation", "(Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvestmentWalletDetailFragment extends ViewBindingFragment<FragmentInvestmentDetailWalletBinding> implements WalletDetailBaseFunction {
    private static int $10 = 0;
    private static int $11 = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String INVESTMENT_CARD_ITEMS = "INVESTMENT_CARD_ITEMS";
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static long MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 0;
    private static int getErrorConfigVersion = 1;
    private static int lookAheadTest;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public FeatureContract.Presenter featurePresenter;
    @Inject
    public GetBalanceContract.Presenter getBalancePresenter;
    @Inject
    public InvestmentWalletDetailContract.Presenter investmentPresenter;
    private InvestmentWalletAdapter investmentWalletAdapter;
    private boolean isFromAddAsset;
    private boolean isLoading;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    @Inject
    public ServicesContract.Presenter servicesPresenter;
    private SkeletonScreen skeletonScreen;
    @Inject
    public WalletH5ServicesImplementation walletH5ServicesImplementation;
    @Inject
    public WalletV3TrackerImpl walletV3TrackerImplementation;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final /* synthetic */ WalletDetailBaseImplementation $$delegate_0 = new WalletDetailBaseImplementation();
    private List<ThirdPartyService> investmentServices = new ArrayList();
    private final InvestmentWalletDetailFragment$onBackPressedCallback$1 onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$onBackPressedCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        @Override // androidx.view.OnBackPressedCallback
        public final void handleOnBackPressed() {
            InvestmentWalletDetailFragment investmentWalletDetailFragment = InvestmentWalletDetailFragment.this;
            FragmentInvestmentDetailWalletBinding access$getBinding = InvestmentWalletDetailFragment.access$getBinding(investmentWalletDetailFragment);
            RecyclerView recyclerView = access$getBinding != null ? access$getBinding.getErrorConfigVersion : null;
            FragmentManager parentFragmentManager = InvestmentWalletDetailFragment.this.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            investmentWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 1);
        }
    };

    /* renamed from: danaGoalsClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaGoalsClickListener = LazyKt.lazy(new Function0<InvestmentWalletDetailFragment$danaGoalsClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaGoalsClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaGoalsClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final InvestmentWalletDetailFragment investmentWalletDetailFragment = InvestmentWalletDetailFragment.this;
            return new GoalsClickListener() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaGoalsClickListener$2.1
                @Override // id.dana.wallet_v3.listener.GoalsClickListener
                public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                    InvestmentWalletDetailFragment.this.getGetBalancePresenter().MyBillsEntityDataFactory("goals");
                    InvestmentWalletAdapter access$getInvestmentWalletAdapter$p = InvestmentWalletDetailFragment.access$getInvestmentWalletAdapter$p(InvestmentWalletDetailFragment.this);
                    if (access$getInvestmentWalletAdapter$p != null) {
                        access$getInvestmentWalletAdapter$p.setGoalsBalanceVisibility(Boolean.valueOf(isBalanceVisible));
                    }
                    WalletV3ToastUtilKt.showHideBalanceToast(isBalanceVisible, InvestmentWalletDetailFragment.this.getBaseActivity(), 6);
                }
            };
        }
    });

    /* renamed from: danaEmasClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaEmasClickListener = LazyKt.lazy(new Function0<InvestmentWalletDetailFragment$danaEmasClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaEmasClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaEmasClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final InvestmentWalletDetailFragment investmentWalletDetailFragment = InvestmentWalletDetailFragment.this;
            return new DanaEmasClickListener() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaEmasClickListener$2.1
                @Override // id.dana.wallet_v3.listener.DanaEmasClickListener
                public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                    InvestmentWalletDetailFragment.this.getGetBalancePresenter().MyBillsEntityDataFactory(AccountEntityRepository.BalanceType.EMAS);
                    InvestmentWalletAdapter access$getInvestmentWalletAdapter$p = InvestmentWalletDetailFragment.access$getInvestmentWalletAdapter$p(InvestmentWalletDetailFragment.this);
                    if (access$getInvestmentWalletAdapter$p != null) {
                        access$getInvestmentWalletAdapter$p.setEmasBalanceVisibility(Boolean.valueOf(isBalanceVisible));
                    }
                    WalletV3ToastUtilKt.showHideBalanceToast(isBalanceVisible, InvestmentWalletDetailFragment.this.getBaseActivity(), 5);
                }
            };
        }
    });

    /* renamed from: danaPlusClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaPlusClickListener = LazyKt.lazy(new Function0<InvestmentWalletDetailFragment$danaPlusClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaPlusClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaPlusClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final InvestmentWalletDetailFragment investmentWalletDetailFragment = InvestmentWalletDetailFragment.this;
            return new DanaPlusClickListener() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$danaPlusClickListener$2.1
                @Override // id.dana.wallet_v3.listener.DanaPlusClickListener
                public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                    InvestmentWalletDetailFragment.this.getGetBalancePresenter().MyBillsEntityDataFactory(AccountEntityRepository.BalanceType.INVESTMENT);
                    InvestmentWalletAdapter access$getInvestmentWalletAdapter$p = InvestmentWalletDetailFragment.access$getInvestmentWalletAdapter$p(InvestmentWalletDetailFragment.this);
                    if (access$getInvestmentWalletAdapter$p != null) {
                        access$getInvestmentWalletAdapter$p.setDanaPlusBalanceVisibility(Boolean.valueOf(isBalanceVisible));
                    }
                    WalletV3ToastUtilKt.showHideBalanceToast(isBalanceVisible, InvestmentWalletDetailFragment.this.getBaseActivity(), 4);
                }
            };
        }
    });

    /* renamed from: walletCardAssetClickListener$delegate  reason: from kotlin metadata */
    private final Lazy walletCardAssetClickListener = LazyKt.lazy(new Function0<InvestmentWalletDetailFragment$walletCardAssetClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$walletCardAssetClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$walletCardAssetClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final InvestmentWalletDetailFragment investmentWalletDetailFragment = InvestmentWalletDetailFragment.this;
            return new WalletCardAssetClickListener() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$walletCardAssetClickListener$2.1
                private static int $10 = 0;
                private static int $11 = 1;
                private static int BuiltInFictitiousFunctionClassFactory = 0;
                private static char[] MyBillsEntityDataFactory = {35495, 35570, 35573, 35562, 35569, 35576, 35578, 35580, 35580, 35575, 35577, 35572};
                private static int PlaceComponentResult = 1;

                @Override // id.dana.wallet_v3.listener.WalletCardAssetClickListener
                public final void onCardClicked(WalletV3CardModel data) {
                    Intrinsics.checkNotNullParameter(data, "");
                    if (!(data instanceof InvestmentCardModel.DanaGoalsCard)) {
                        if (data instanceof InvestmentCardModel.EmasCard) {
                            InvestmentWalletDetailFragment investmentWalletDetailFragment2 = InvestmentWalletDetailFragment.this;
                            Object[] objArr = new Object[1];
                            a(new int[]{0, 12, 0, 0}, false, new byte[]{1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0}, objArr);
                            InvestmentWalletDetailFragment.access$goToServicePage(investmentWalletDetailFragment2, ((String) objArr[0]).intern());
                            return;
                        } else if (data instanceof InvestmentCardModel.DanaPlusCard) {
                            InvestmentWalletDetailFragment.access$goToServicePage(InvestmentWalletDetailFragment.this, "service_dana_plus");
                            int i = BuiltInFictitiousFunctionClassFactory + 31;
                            PlaceComponentResult = i % 128;
                            if (i % 2 == 0) {
                                Object[] objArr2 = null;
                                int length = objArr2.length;
                                return;
                            }
                            return;
                        } else {
                            if ((data instanceof InvestmentCardModel.EmptyInvestmentCard ? '/' : '0') != '/') {
                                return;
                            }
                            InvestmentWalletDetailFragment.access$setFromAddAsset$p(InvestmentWalletDetailFragment.this, true);
                            InvestmentWalletDetailFragment.access$openBottomSheetAddAsset(InvestmentWalletDetailFragment.this);
                            return;
                        }
                    }
                    int i2 = PlaceComponentResult + 53;
                    BuiltInFictitiousFunctionClassFactory = i2 % 128;
                    int i3 = i2 % 2;
                    InvestmentWalletDetailFragment.access$goToServicePage(InvestmentWalletDetailFragment.this, "service_goals");
                }

                private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
                    VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int i3 = iArr[2];
                    int i4 = iArr[3];
                    char[] cArr = MyBillsEntityDataFactory;
                    if (cArr != null) {
                        int i5 = $10 + 73;
                        $11 = i5 % 128;
                        int i6 = i5 % 2;
                        int length = cArr.length;
                        char[] cArr2 = new char[length];
                        int i7 = 0;
                        while (true) {
                            if ((i7 < length ? 'I' : 'B') != 'I') {
                                break;
                            }
                            cArr2[i7] = (char) (cArr[i7] ^ 5097613533456403102L);
                            i7++;
                        }
                        int i8 = $11 + 5;
                        $10 = i8 % 128;
                        int i9 = i8 % 2;
                        cArr = cArr2;
                    }
                    char[] cArr3 = new char[i2];
                    System.arraycopy(cArr, i, cArr3, 0, i2);
                    if (!(bArr == null)) {
                        char[] cArr4 = new char[i2];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        char c = 0;
                        while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                            if (!(bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] != 1)) {
                                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                            } else {
                                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                            }
                            c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                        cArr3 = cArr4;
                    }
                    if (i4 > 0) {
                        char[] cArr5 = new char[i2];
                        try {
                            System.arraycopy(cArr3, 0, cArr5, 0, i2);
                            int i10 = i2 - i4;
                            System.arraycopy(cArr5, 0, cArr3, i10, i4);
                            System.arraycopy(cArr5, i4, cArr3, 0, i10);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    if (z) {
                        int i11 = $11 + 35;
                        $10 = i11 % 128;
                        int i12 = i11 % 2;
                        char[] cArr6 = new char[i2];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                            cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                        cArr3 = cArr6;
                    }
                    if (i3 > 0) {
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (true) {
                            if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i2) {
                                break;
                            }
                            int i13 = $11 + 79;
                            $10 = i13 % 128;
                            int i14 = i13 % 2;
                            try {
                                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                            } catch (Exception e2) {
                                throw e2;
                            }
                        }
                    }
                    objArr[0] = new String(cArr3);
                }
            };
        }
    });

    /* renamed from: ptrCardInvestmentHandle$delegate  reason: from kotlin metadata */
    private final Lazy ptrCardInvestmentHandle = LazyKt.lazy(new Function0<InvestmentWalletDetailFragment$ptrCardInvestmentHandle$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$ptrCardInvestmentHandle$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$ptrCardInvestmentHandle$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final InvestmentWalletDetailFragment investmentWalletDetailFragment = InvestmentWalletDetailFragment.this;
            return new PtrHandler() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$ptrCardInvestmentHandle$2.1
                @Override // in.srain.cube.views.ptr.PtrHandler
                public final boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                    RecyclerView recyclerView;
                    FragmentInvestmentDetailWalletBinding access$getBinding = InvestmentWalletDetailFragment.access$getBinding(InvestmentWalletDetailFragment.this);
                    RecyclerView.LayoutManager layoutManager = (access$getBinding == null || (recyclerView = access$getBinding.getErrorConfigVersion) == null) ? null : recyclerView.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
                    return (linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : -1) == 0;
                }

                @Override // in.srain.cube.views.ptr.PtrHandler
                public final void onRefreshBegin(PtrFrameLayout frame) {
                    PtrWalletFrameLayout ptrWalletFrameLayout;
                    InvestmentWalletDetailFragment.access$navigateToSearch(InvestmentWalletDetailFragment.this);
                    FragmentInvestmentDetailWalletBinding access$getBinding = InvestmentWalletDetailFragment.access$getBinding(InvestmentWalletDetailFragment.this);
                    if (access$getBinding == null || (ptrWalletFrameLayout = access$getBinding.lookAheadTest) == null) {
                        return;
                    }
                    ptrWalletFrameLayout.refreshComplete();
                }
            };
        }
    });

    public static /* synthetic */ void $r8$lambda$0lk5cRfHcOw9O7cQgxLGEb62p5Y(InvestmentWalletDetailFragment investmentWalletDetailFragment, View view) {
        int i = getErrorConfigVersion + 121;
        lookAheadTest = i % 128;
        char c = i % 2 != 0 ? 'L' : (char) 18;
        m3015initOnClickListener$lambda4(investmentWalletDetailFragment, view);
        if (c != 'L') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* renamed from: $r8$lambda$aBG9OQBhlF8qwW-1f26jc-415pw  reason: not valid java name */
    public static /* synthetic */ void m3013$r8$lambda$aBG9OQBhlF8qwW1f26jc415pw(InvestmentWalletDetailFragment investmentWalletDetailFragment) {
        int i = getErrorConfigVersion + 99;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            m3017navigateToSearch$lambda6(investmentWalletDetailFragment);
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            m3017navigateToSearch$lambda6(investmentWalletDetailFragment);
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$mM0_lCRK4cVpvAaaRmVVZgHtHMI(InvestmentWalletDetailFragment investmentWalletDetailFragment, View view) {
        int i = getErrorConfigVersion + 41;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        m3014initOnClickListener$lambda3(investmentWalletDetailFragment, view);
        try {
            int i3 = lookAheadTest + 41;
            getErrorConfigVersion = i3 % 128;
            if (i3 % 2 != 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$nhnPNQKo2lMHFT_rDbfWSTGYKD0(InvestmentWalletDetailFragment investmentWalletDetailFragment, View view) {
        int i = getErrorConfigVersion + 67;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? (char) 23 : Typography.amp) != 23) {
            try {
                m3016initOnClickListener$lambda5(investmentWalletDetailFragment, view);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        m3016initOnClickListener$lambda5(investmentWalletDetailFragment, view);
        Object obj = null;
        obj.hashCode();
    }

    static {
        try {
            KClassImpl$Data$declaredNonStaticMembers$2();
            INSTANCE = new Companion(null);
            int i = lookAheadTest + 7;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 13492;
        MyBillsEntityDataFactory = -5955146845286757015L;
        PlaceComponentResult = -956812108;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        try {
            int i = lookAheadTest + 107;
            getErrorConfigVersion = i % 128;
            if (i % 2 != 0) {
                this._$_findViewCache.clear();
                return;
            }
            this._$_findViewCache.clear();
            int i2 = 55 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        if (r1 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if ((r1 != null ? '1' : 6) != 6) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        r3 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest + 13;
        id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if ((r3 % 2) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        r3 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        r3 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        if (r3 == 22) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return r1;
     */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r6) {
        /*
            r5 = this;
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            java.lang.Object r1 = r0.get(r1)
            android.view.View r1 = (android.view.View) r1
            r2 = 0
            if (r1 != 0) goto L6f
            int r1 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest
            int r1 = r1 + 3
            int r3 = r1 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r3
            int r1 = r1 % 2
            android.view.View r1 = r5.getGetAuthRequestContext()
            if (r1 == 0) goto L6e
            int r3 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest     // Catch: java.lang.Exception -> L6c
            int r3 = r3 + 125
            int r4 = r3 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r4     // Catch: java.lang.Exception -> L6c
            int r3 = r3 % 2
            android.view.View r1 = r1.findViewById(r6)
            if (r3 != 0) goto L37
            r2.hashCode()     // Catch: java.lang.Throwable -> L35
            if (r1 == 0) goto L6e
            goto L40
        L35:
            r6 = move-exception
            throw r6
        L37:
            r3 = 6
            if (r1 == 0) goto L3d
            r4 = 49
            goto L3e
        L3d:
            r4 = 6
        L3e:
            if (r4 == r3) goto L6e
        L40:
            int r3 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest
            int r3 = r3 + 13
            int r4 = r3 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r4
            int r3 = r3 % 2
            r4 = 22
            if (r3 != 0) goto L51
            r3 = 22
            goto L53
        L51:
            r3 = 17
        L53:
            if (r3 == r4) goto L5f
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L5d
            r0.put(r6, r1)     // Catch: java.lang.Exception -> L5d
            goto L6f
        L5d:
            r6 = move-exception
            throw r6
        L5f:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r6, r1)
            r2.hashCode()     // Catch: java.lang.Throwable -> L6a
            goto L6f
        L6a:
            r6 = move-exception
            throw r6
        L6c:
            r6 = move-exception
            throw r6
        L6e:
            r1 = r2
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment._$_findCachedViewById(int):android.view.View");
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backFromSearch(FragmentManager fragmentManager, String tag) {
        int i = lookAheadTest + 77;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(fragmentManager, "");
            Intrinsics.checkNotNullParameter(tag, "");
            this.$$delegate_0.backFromSearch(fragmentManager, tag);
            int i3 = lookAheadTest + 105;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backToMainPage(RecyclerView recyclerView, FragmentManager fragmentManager, int section) {
        int i = lookAheadTest + 67;
        getErrorConfigVersion = i % 128;
        boolean z = i % 2 == 0;
        Object[] objArr = null;
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        if (z) {
            this.$$delegate_0.backToMainPage(recyclerView, fragmentManager, section);
            int length = objArr.length;
        } else {
            this.$$delegate_0.backToMainPage(recyclerView, fragmentManager, section);
        }
        int i2 = getErrorConfigVersion + 57;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 6 : 'M') != 'M') {
            int length2 = objArr.length;
        }
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        int i = getErrorConfigVersion + 23;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        int i3 = getErrorConfigVersion + 81;
        lookAheadTest = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return R.layout.fragment_investment_detail_wallet;
        }
        return R.layout.fragment_investment_detail_wallet;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final NewWalletFragment getWalletFragment(FragmentManager fragmentManager) {
        NewWalletFragment walletFragment;
        int i = getErrorConfigVersion + 33;
        lookAheadTest = i % 128;
        char c = i % 2 != 0 ? 'K' : '\n';
        Object[] objArr = null;
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        if (c != '\n') {
            walletFragment = this.$$delegate_0.getWalletFragment(fragmentManager);
            objArr.hashCode();
        } else {
            walletFragment = this.$$delegate_0.getWalletFragment(fragmentManager);
        }
        int i2 = lookAheadTest + 113;
        getErrorConfigVersion = i2 % 128;
        if (i2 % 2 != 0) {
            return walletFragment;
        }
        int length = objArr.length;
        return walletFragment;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final boolean isFromDeeplinkWallet(Activity activity) {
        int i = getErrorConfigVersion + 59;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(activity, "");
            boolean isFromDeeplinkWallet = this.$$delegate_0.isFromDeeplinkWallet(activity);
            int i3 = lookAheadTest + 19;
            getErrorConfigVersion = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
                return isFromDeeplinkWallet;
            }
            return isFromDeeplinkWallet;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ FragmentInvestmentDetailWalletBinding access$getBinding(InvestmentWalletDetailFragment investmentWalletDetailFragment) {
        try {
            int i = lookAheadTest + 95;
            getErrorConfigVersion = i % 128;
            char c = i % 2 == 0 ? 'G' : 'Z';
            FragmentInvestmentDetailWalletBinding binding = investmentWalletDetailFragment.getBinding();
            if (c != 'Z') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            return binding;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ InvestmentWalletAdapter access$getInvestmentWalletAdapter$p(InvestmentWalletDetailFragment investmentWalletDetailFragment) {
        int i = getErrorConfigVersion + 101;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        InvestmentWalletAdapter investmentWalletAdapter = investmentWalletDetailFragment.investmentWalletAdapter;
        int i3 = lookAheadTest + 31;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return investmentWalletAdapter;
    }

    public static final /* synthetic */ void access$goToServicePage(InvestmentWalletDetailFragment investmentWalletDetailFragment, String str) {
        int i = getErrorConfigVersion + 35;
        lookAheadTest = i % 128;
        if (!(i % 2 == 0)) {
            investmentWalletDetailFragment.goToServicePage(str);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            investmentWalletDetailFragment.goToServicePage(str);
        }
        try {
            int i2 = lookAheadTest + 43;
            try {
                getErrorConfigVersion = i2 % 128;
                if ((i2 % 2 == 0 ? '2' : 'E') != 'E') {
                    int i3 = 50 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$hideShimmeringSkeleton(InvestmentWalletDetailFragment investmentWalletDetailFragment) {
        int i = lookAheadTest + 5;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        investmentWalletDetailFragment.hideShimmeringSkeleton();
        int i3 = getErrorConfigVersion + 81;
        lookAheadTest = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        int i4 = 11 / 0;
    }

    public static final /* synthetic */ void access$navigateToSearch(InvestmentWalletDetailFragment investmentWalletDetailFragment) {
        int i = getErrorConfigVersion + 59;
        lookAheadTest = i % 128;
        boolean z = i % 2 != 0;
        investmentWalletDetailFragment.navigateToSearch();
        if (z) {
            int i2 = 52 / 0;
        }
    }

    public static final /* synthetic */ void access$openBottomSheetAddAsset(InvestmentWalletDetailFragment investmentWalletDetailFragment) {
        int i = getErrorConfigVersion + 81;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        investmentWalletDetailFragment.openBottomSheetAddAsset();
        int i3 = getErrorConfigVersion + 93;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$setFromAddAsset$p(InvestmentWalletDetailFragment investmentWalletDetailFragment, boolean z) {
        try {
            int i = getErrorConfigVersion + 5;
            try {
                lookAheadTest = i % 128;
                if (!(i % 2 != 0)) {
                    investmentWalletDetailFragment.isFromAddAsset = z;
                    return;
                }
                investmentWalletDetailFragment.isFromAddAsset = z;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setInvestmentServices$p(InvestmentWalletDetailFragment investmentWalletDetailFragment, List list) {
        try {
            int i = lookAheadTest + 67;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            try {
                investmentWalletDetailFragment.investmentServices = list;
                int i3 = lookAheadTest + 83;
                getErrorConfigVersion = i3 % 128;
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

    public static final /* synthetic */ void access$showShimmeringSkeleton(InvestmentWalletDetailFragment investmentWalletDetailFragment) {
        int i = getErrorConfigVersion + 111;
        lookAheadTest = i % 128;
        boolean z = i % 2 != 0;
        investmentWalletDetailFragment.showShimmeringSkeleton();
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* bridge */ /* synthetic */ FragmentInvestmentDetailWalletBinding initViewBinding(View view) {
        FragmentInvestmentDetailWalletBinding initViewBinding;
        int i = lookAheadTest + 1;
        getErrorConfigVersion = i % 128;
        if (!(i % 2 != 0)) {
            try {
                initViewBinding = initViewBinding(view);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            initViewBinding = initViewBinding(view);
        }
        int i2 = getErrorConfigVersion + 121;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        return initViewBinding;
    }

    @JvmName(name = "getInvestmentPresenter")
    public final InvestmentWalletDetailContract.Presenter getInvestmentPresenter() {
        int i = lookAheadTest + 1;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            InvestmentWalletDetailContract.Presenter presenter = this.investmentPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            int i3 = getErrorConfigVersion + 101;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            int i5 = getErrorConfigVersion + 125;
            lookAheadTest = i5 % 128;
            int i6 = i5 % 2;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setInvestmentPresenter")
    public final void setInvestmentPresenter(InvestmentWalletDetailContract.Presenter presenter) {
        int i = lookAheadTest + 39;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.investmentPresenter = presenter;
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.investmentPresenter = presenter;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getServicesPresenter")
    public final ServicesContract.Presenter getServicesPresenter() {
        int i = getErrorConfigVersion + 117;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            ServicesContract.Presenter presenter = this.servicesPresenter;
            Object obj = null;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            int i3 = getErrorConfigVersion + 1;
            lookAheadTest = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return presenter;
            }
            obj.hashCode();
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setServicesPresenter")
    public final void setServicesPresenter(ServicesContract.Presenter presenter) {
        int i = lookAheadTest + 17;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? (char) 22 : 'O') != 22) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.servicesPresenter = presenter;
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.servicesPresenter = presenter;
            int i2 = 90 / 0;
        }
        int i3 = getErrorConfigVersion + 55;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmName(name = "getGetBalancePresenter")
    public final GetBalanceContract.Presenter getGetBalancePresenter() {
        try {
            int i = getErrorConfigVersion + 87;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            GetBalanceContract.Presenter presenter = this.getBalancePresenter;
            if (presenter != null) {
                int i3 = getErrorConfigVersion + 9;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return presenter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i5 = lookAheadTest + 39;
            getErrorConfigVersion = i5 % 128;
            if ((i5 % 2 == 0 ? 'Y' : 'C') != 'C') {
                int i6 = 15 / 0;
                return null;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setGetBalancePresenter")
    public final void setGetBalancePresenter(GetBalanceContract.Presenter presenter) {
        try {
            int i = getErrorConfigVersion + 13;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(presenter, "");
            this.getBalancePresenter = presenter;
            try {
                int i3 = lookAheadTest + 23;
                getErrorConfigVersion = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return;
                }
                int i4 = 95 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getReadLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
        if (!(presenter != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        try {
            int i = getErrorConfigVersion + 73;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            int i3 = getErrorConfigVersion + 55;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        int i = getErrorConfigVersion + 53;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readLinkPropertiesPresenter = presenter;
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readLinkPropertiesPresenter = presenter;
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = getErrorConfigVersion + 99;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0020, code lost:
    
        if ((r0 != null ? '\'' : 'J') != '\'') goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002c, code lost:
    
        if ((r0 == null) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002e, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0033, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0034, code lost:
    
        r4 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion + 61;
        id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
    
        if ((r4 % 2) == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0042, code lost:
    
        if (r1 == true) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0044, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0047, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004a, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getDeviceInformationProvider")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.config.DeviceInformationProvider getDeviceInformationProvider() {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion     // Catch: java.lang.Exception -> L4d
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r1     // Catch: java.lang.Exception -> L4b
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == r2) goto L25
            id.dana.data.config.DeviceInformationProvider r0 = r6.deviceInformationProvider
            int r4 = r3.length     // Catch: java.lang.Throwable -> L23
            r4 = 39
            if (r0 == 0) goto L1e
            r5 = 39
            goto L20
        L1e:
            r5 = 74
        L20:
            if (r5 == r4) goto L34
            goto L2e
        L23:
            r0 = move-exception
            throw r0
        L25:
            id.dana.data.config.DeviceInformationProvider r0 = r6.deviceInformationProvider
            if (r0 == 0) goto L2b
            r4 = 0
            goto L2c
        L2b:
            r4 = 1
        L2c:
            if (r4 == 0) goto L34
        L2e:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r3
        L34:
            int r4 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion
            int r4 = r4 + 61
            int r5 = r4 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L41
            goto L42
        L41:
            r1 = 1
        L42:
            if (r1 == r2) goto L4a
            r3.hashCode()     // Catch: java.lang.Throwable -> L48
            return r0
        L48:
            r0 = move-exception
            throw r0
        L4a:
            return r0
        L4b:
            r0 = move-exception
            throw r0
        L4d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getDeviceInformationProvider():id.dana.data.config.DeviceInformationProvider");
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        int i = getErrorConfigVersion + 9;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
            this.deviceInformationProvider = deviceInformationProvider;
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
            this.deviceInformationProvider = deviceInformationProvider;
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getWalletH5ServicesImplementation")
    public final WalletH5ServicesImplementation getWalletH5ServicesImplementation() {
        int i = getErrorConfigVersion + 41;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        WalletH5ServicesImplementation walletH5ServicesImplementation = this.walletH5ServicesImplementation;
        if (!(walletH5ServicesImplementation != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        int i3 = getErrorConfigVersion + 83;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return walletH5ServicesImplementation;
    }

    @JvmName(name = "setWalletH5ServicesImplementation")
    public final void setWalletH5ServicesImplementation(WalletH5ServicesImplementation walletH5ServicesImplementation) {
        int i = getErrorConfigVersion + 79;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? 'Q' : (char) 30) != 30) {
            try {
                Intrinsics.checkNotNullParameter(walletH5ServicesImplementation, "");
                this.walletH5ServicesImplementation = walletH5ServicesImplementation;
                Object obj = null;
                obj.hashCode();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(walletH5ServicesImplementation, "");
        this.walletH5ServicesImplementation = walletH5ServicesImplementation;
    }

    @JvmName(name = "getWalletV3TrackerImplementation")
    public final WalletV3TrackerImpl getWalletV3TrackerImplementation() {
        try {
            WalletV3TrackerImpl walletV3TrackerImpl = this.walletV3TrackerImplementation;
            try {
                if (walletV3TrackerImpl != null) {
                    int i = getErrorConfigVersion + 19;
                    lookAheadTest = i % 128;
                    int i2 = i % 2;
                    return walletV3TrackerImpl;
                }
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i3 = getErrorConfigVersion + 113;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setWalletV3TrackerImplementation")
    public final void setWalletV3TrackerImplementation(WalletV3TrackerImpl walletV3TrackerImpl) {
        int i = lookAheadTest + 23;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? ';' : 'N') != 'N') {
            Intrinsics.checkNotNullParameter(walletV3TrackerImpl, "");
            this.walletV3TrackerImplementation = walletV3TrackerImpl;
            int i2 = 89 / 0;
        } else {
            Intrinsics.checkNotNullParameter(walletV3TrackerImpl, "");
            this.walletV3TrackerImplementation = walletV3TrackerImpl;
        }
        int i3 = getErrorConfigVersion + 13;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmName(name = "getFeaturePresenter")
    public final FeatureContract.Presenter getFeaturePresenter() {
        try {
            FeatureContract.Presenter presenter = this.featurePresenter;
            Object[] objArr = null;
            if ((presenter != null ? InputCardNumberView.DIVIDER : '\f') == '\f') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            int i = getErrorConfigVersion + 75;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            int i3 = lookAheadTest + 33;
            getErrorConfigVersion = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 30 : '\f') != 30) {
                int length = objArr.length;
                return presenter;
            }
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        try {
            int i = lookAheadTest + 119;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(presenter, "");
            this.featurePresenter = presenter;
            int i3 = lookAheadTest + 89;
            getErrorConfigVersion = i3 % 128;
            if ((i3 % 2 == 0 ? InputCardNumberView.DIVIDER : '\'') != '\'') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getDanaGoalsClickListener")
    private final GoalsClickListener getDanaGoalsClickListener() {
        int i = lookAheadTest + 63;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        GoalsClickListener goalsClickListener = (GoalsClickListener) this.danaGoalsClickListener.getValue();
        int i3 = lookAheadTest + 123;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return goalsClickListener;
    }

    @JvmName(name = "getDanaEmasClickListener")
    private final DanaEmasClickListener getDanaEmasClickListener() {
        DanaEmasClickListener danaEmasClickListener;
        int i = getErrorConfigVersion + 51;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? 'P' : '8') != '8') {
            danaEmasClickListener = (DanaEmasClickListener) this.danaEmasClickListener.getValue();
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                danaEmasClickListener = (DanaEmasClickListener) this.danaEmasClickListener.getValue();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = lookAheadTest + 69;
        getErrorConfigVersion = i2 % 128;
        if ((i2 % 2 == 0 ? 'H' : '/') != '/') {
            int i3 = 83 / 0;
            return danaEmasClickListener;
        }
        return danaEmasClickListener;
    }

    @JvmName(name = "getDanaPlusClickListener")
    private final DanaPlusClickListener getDanaPlusClickListener() {
        try {
            int i = getErrorConfigVersion + 51;
            lookAheadTest = i % 128;
            if (!(i % 2 != 0)) {
                return (DanaPlusClickListener) this.danaPlusClickListener.getValue();
            }
            DanaPlusClickListener danaPlusClickListener = (DanaPlusClickListener) this.danaPlusClickListener.getValue();
            Object obj = null;
            obj.hashCode();
            return danaPlusClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getWalletCardAssetClickListener")
    private final WalletCardAssetClickListener getWalletCardAssetClickListener() {
        try {
            int i = lookAheadTest + 115;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            WalletCardAssetClickListener walletCardAssetClickListener = (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
            int i3 = lookAheadTest + 125;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return walletCardAssetClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getPtrCardInvestmentHandle")
    private final PtrHandler getPtrCardInvestmentHandle() {
        try {
            int i = lookAheadTest + 33;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            PtrHandler ptrHandler = (PtrHandler) this.ptrCardInvestmentHandle.getValue();
            int i3 = lookAheadTest + 123;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return ptrHandler;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        RecyclerView recyclerView;
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null || !isFromDeeplinkWallet(activity)) {
            return;
        }
        int i = lookAheadTest + 117;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        FragmentInvestmentDetailWalletBinding binding = getBinding();
        RecyclerView recyclerView2 = null;
        if (binding != null) {
            try {
                int i3 = lookAheadTest + 93;
                getErrorConfigVersion = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    recyclerView = binding.getErrorConfigVersion;
                } else {
                    recyclerView = binding.getErrorConfigVersion;
                    recyclerView2.hashCode();
                }
                recyclerView2 = recyclerView;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            backToMainPage(recyclerView2, parentFragmentManager, 1);
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        int i = lookAheadTest + 101;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        super.onResume();
        if (this.isFromAddAsset) {
            int i3 = lookAheadTest + 125;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            showShimmeringSkeleton();
            getInvestmentPresenter().getInvestmentAsset();
            this.isFromAddAsset = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final FragmentInvestmentDetailWalletBinding initViewBinding(View view) {
        int i = lookAheadTest + 9;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(view, "");
            FragmentInvestmentDetailWalletBinding MyBillsEntityDataFactory2 = FragmentInvestmentDetailWalletBinding.MyBillsEntityDataFactory(view);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
            return MyBillsEntityDataFactory2;
        }
        Intrinsics.checkNotNullParameter(view, "");
        FragmentInvestmentDetailWalletBinding MyBillsEntityDataFactory3 = FragmentInvestmentDetailWalletBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory3, "");
        int i2 = 60 / 0;
        return MyBillsEntityDataFactory3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if ((r0 != null ? '(' : 'O') != '(') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        r0 = r0.getOnBackPressedDispatcher();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        if (r1 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r1 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest + 115;
        id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r1 % 128;
        r1 = r1 % 2;
        r0.PlaceComponentResult(r3, r3.onBackPressedCallback);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        disableSwipe();
        getWalletH5ServicesImplementation().setWalletH5Listener(walletH5Listener());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        return;
     */
    @Override // id.dana.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init() {
        /*
            r3 = this;
            int r0 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion     // Catch: java.lang.Exception -> L79
            int r0 = r0 + 33
            int r1 = r0 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r1     // Catch: java.lang.Exception -> L79
            int r0 = r0 % 2
            r1 = 93
            if (r0 == 0) goto L10
            r0 = 5
            goto L12
        L10:
            r0 = 93
        L12:
            if (r0 == r1) goto L36
            r3.initInjector()
            r3.initView()
            r3.initOnClickListener()
            r3.loadData()
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L34
            r1 = 40
            if (r0 == 0) goto L2f
            r2 = 40
            goto L31
        L2f:
            r2 = 79
        L31:
            if (r2 == r1) goto L48
            goto L68
        L34:
            r0 = move-exception
            throw r0
        L36:
            r3.initInjector()
            r3.initView()
            r3.initOnClickListener()
            r3.loadData()
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 == 0) goto L68
        L48:
            androidx.activity.OnBackPressedDispatcher r0 = r0.getOnBackPressedDispatcher()
            if (r0 == 0) goto L50
            r1 = 0
            goto L51
        L50:
            r1 = 1
        L51:
            if (r1 == 0) goto L54
            goto L68
        L54:
            int r1 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest
            int r1 = r1 + 115
            int r2 = r1 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r2
            int r1 = r1 % 2
            r1 = r3
            androidx.lifecycle.LifecycleOwner r1 = (androidx.view.LifecycleOwner) r1
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$onBackPressedCallback$1 r2 = r3.onBackPressedCallback
            androidx.activity.OnBackPressedCallback r2 = (androidx.view.OnBackPressedCallback) r2
            r0.PlaceComponentResult(r1, r2)
        L68:
            r3.disableSwipe()
            id.dana.wallet_v3.WalletH5ServicesImplementation r0 = r3.getWalletH5ServicesImplementation()
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$walletH5Listener$1 r1 = r3.walletH5Listener()
            id.dana.utils.danah5.DanaH5Listener r1 = (id.dana.utils.danah5.DanaH5Listener) r1
            r0.setWalletH5Listener(r1)
            return
        L79:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.init():void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        int i = lookAheadTest + 49;
        getErrorConfigVersion = i % 128;
        if (i % 2 == 0) {
        }
        super.onDestroyView();
        setEnabled(false);
        remove();
        _$_clearFindViewByIdCache();
    }

    public final void onCollapseFromSearch() {
        MotionLayout motionLayout;
        int i = getErrorConfigVersion + 117;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        FragmentInvestmentDetailWalletBinding binding = getBinding();
        if ((binding != null ? 'P' : (char) 31) == 'P' && (motionLayout = binding.getAuthRequestContext) != null) {
            motionLayout.setTransition(R.id.collapse_from_search);
        }
        FragmentInvestmentDetailWalletBinding binding2 = getBinding();
        if ((binding2 != null ? 'Q' : (char) 24) != 'Q') {
            return;
        }
        MotionLayout motionLayout2 = binding2.getAuthRequestContext;
        if ((motionLayout2 != null ? '!' : (char) 5) != '!') {
            return;
        }
        int i3 = lookAheadTest + 123;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        motionLayout2.transitionToEnd();
        if (i4 == 0) {
            Object obj = null;
            obj.hashCode();
        }
        int i5 = getErrorConfigVersion + 29;
        lookAheadTest = i5 % 128;
        int i6 = i5 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
    
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0071, code lost:
    
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        r3 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest + 5;
        id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
    
        if ((r3 % 2) != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0081, code lost:
    
        r3 = '\'';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        r3 = 'D';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
    
        if (r3 == 'D') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:
    
        r0 = r0.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008a, code lost:
    
        r3 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        r0 = r0.PlaceComponentResult;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initView() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.initView():void");
    }

    private final void initInjector() {
        DaggerInvestmentWalletDetailComponent.Builder balanceModule = DaggerInvestmentWalletDetailComponent.builder().applicationComponent(getApplicationComponent()).investmentWalletDetailModule(getInvestmentDetailModule()).servicesModule(getServicesModule()).getBalanceModule(getBalanceModule());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getActivity();
        byte b = 0;
        Object[] objArr = new Object[1];
        a(new char[]{41823, 23986, 53332, 13530, 58466, 46762, 8493, 46698}, new char[]{35336, 64081, 27611, 38402}, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{14813, 13213, 19320, 37342}, ExpandableListView.getPackedPositionGroup(0L), objArr);
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = ((String) objArr[0]).intern();
        DaggerInvestmentWalletDetailComponent.Builder deepLinkModule = balanceModule.deepLinkModule(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        DaggerInvestmentWalletDetailComponent.Builder scanQrModule = deepLinkModule.scanQrModule(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getActivity();
        DaggerInvestmentWalletDetailComponent.Builder restoreUrlModule = scanQrModule.restoreUrlModule(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        MyBillsEntityDataFactory2.PlaceComponentResult = TrackerKey.SourceType.WALLET_DETAIL;
        DaggerInvestmentWalletDetailComponent.Builder featureModule = restoreUrlModule.featureModule(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        featureModule.oauthModule(new OauthModule(BuiltInFictitiousFunctionClassFactory, b)).build().inject(this);
        int i = getErrorConfigVersion + 77;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? 'G' : (char) 23) != 'G') {
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        if (r0 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        if (r0 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        r0.setOnClickListener(new id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda2(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0067, code lost:
    
        r0 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
    
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initOnClickListener() {
        /*
            r4 = this;
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentInvestmentDetailWalletBinding r0 = (id.dana.databinding.FragmentInvestmentDetailWalletBinding) r0
            r1 = 99
            if (r0 == 0) goto Ld
            r2 = 99
            goto Lf
        Ld:
            r2 = 60
        Lf:
            if (r2 == r1) goto L12
            goto L28
        L12:
            int r1 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest
            int r1 = r1 + 57
            int r2 = r1 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r2
            int r1 = r1 % 2
            com.airbnb.lottie.LottieAnimationView r0 = r0.MyBillsEntityDataFactory
            if (r0 == 0) goto L28
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda1 r1 = new id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda1
            r1.<init>()
            r0.setOnClickListener(r1)
        L28:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentInvestmentDetailWalletBinding r0 = (id.dana.databinding.FragmentInvestmentDetailWalletBinding) r0
            r1 = 41
            if (r0 == 0) goto L74
            id.dana.databinding.ViewWalletV3SearchStubBinding r0 = r0.scheduleImpl
            if (r0 == 0) goto L39
            r2 = 93
            goto L3b
        L39:
            r2 = 41
        L3b:
            if (r2 == r1) goto L74
            int r2 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion
            int r2 = r2 + 97
            int r3 = r2 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r3
            int r2 = r2 % 2
            r3 = 58
            if (r2 == 0) goto L4e
            r2 = 58
            goto L50
        L4e:
            r2 = 16
        L50:
            if (r2 == r3) goto L57
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L74
            goto L5d
        L57:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.BuiltInFictitiousFunctionClassFactory
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L74
        L5d:
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda2 r2 = new id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda2
            r2.<init>()
            r0.setOnClickListener(r2)
            int r0 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion     // Catch: java.lang.Exception -> L70
            int r0 = r0 + 5
            int r2 = r0 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r2     // Catch: java.lang.Exception -> L92
            int r0 = r0 % 2
            goto L74
        L70:
            r0 = move-exception
            throw r0
        L72:
            r0 = move-exception
            throw r0
        L74:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentInvestmentDetailWalletBinding r0 = (id.dana.databinding.FragmentInvestmentDetailWalletBinding) r0
            if (r0 == 0) goto L94
            int r2 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion     // Catch: java.lang.Exception -> L92
            int r2 = r2 + r1
            int r1 = r2 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r1     // Catch: java.lang.Exception -> L92
            int r2 = r2 % 2
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r0 = r0.PlaceComponentResult
            if (r0 == 0) goto L94
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda3 r1 = new id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda3
            r1.<init>()
            r0.setOnClickListener(r1)
            goto L94
        L92:
            r0 = move-exception
            throw r0
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.initOnClickListener():void");
    }

    /* renamed from: initOnClickListener$lambda-3  reason: not valid java name */
    private static final void m3014initOnClickListener$lambda3(InvestmentWalletDetailFragment investmentWalletDetailFragment, View view) {
        int i = getErrorConfigVersion + 93;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(investmentWalletDetailFragment, "");
        FragmentInvestmentDetailWalletBinding binding = investmentWalletDetailFragment.getBinding();
        RecyclerView recyclerView = (binding != null ? '\\' : 'B') != '\\' ? null : binding.getErrorConfigVersion;
        try {
            FragmentManager parentFragmentManager = investmentWalletDetailFragment.getParentFragmentManager();
            try {
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                investmentWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 1);
                int i3 = lookAheadTest + 15;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: initOnClickListener$lambda-4  reason: not valid java name */
    private static final void m3015initOnClickListener$lambda4(InvestmentWalletDetailFragment investmentWalletDetailFragment, View view) {
        int i = lookAheadTest + 71;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(investmentWalletDetailFragment, "");
        investmentWalletDetailFragment.navigateToSearch();
        int i3 = getErrorConfigVersion + 101;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    /* renamed from: initOnClickListener$lambda-5  reason: not valid java name */
    private static final void m3016initOnClickListener$lambda5(InvestmentWalletDetailFragment investmentWalletDetailFragment, View view) {
        int i = getErrorConfigVersion + 55;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(investmentWalletDetailFragment, "");
        } else {
            Intrinsics.checkNotNullParameter(investmentWalletDetailFragment, "");
        }
        investmentWalletDetailFragment.isFromAddAsset = true;
        investmentWalletDetailFragment.getWalletV3TrackerImplementation().trackOpenAddAsset(TrackerKey.WalletAddAssetSource.ADD_FINANCIAL_SECTION);
        investmentWalletDetailFragment.openBottomSheetAddAsset();
        int i2 = lookAheadTest + 105;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if ((r0 != null ? 1 : '_') != '_') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r0 == null) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0031, code lost:
    
        r1 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion + 1;
        id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        if ((r1 % 2) == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        r2 = kotlin.text.Typography.less;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        if (r2 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        r0.setTransition(id.dana.R.id.expand_to_search);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        r0.setTransition(id.dana.R.id.expand_to_search);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        r0 = r3.length;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void navigateToSearch() {
        /*
            r6 = this;
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.FragmentInvestmentDetailWalletBinding r0 = (id.dana.databinding.FragmentInvestmentDetailWalletBinding) r0
            if (r0 == 0) goto L4f
            int r1 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion
            int r1 = r1 + 17
            int r2 = r1 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r2
            int r1 = r1 % 2
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L27
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.getAuthRequestContext
            int r1 = r3.length     // Catch: java.lang.Throwable -> L25
            r1 = 95
            if (r0 == 0) goto L20
            r5 = 1
            goto L22
        L20:
            r5 = 95
        L22:
            if (r5 == r1) goto L4f
            goto L31
        L25:
            r0 = move-exception
            throw r0
        L27:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.getAuthRequestContext
            if (r0 == 0) goto L2d
            r1 = 0
            goto L2e
        L2d:
            r1 = 1
        L2e:
            if (r1 == 0) goto L31
            goto L4f
        L31:
            int r1 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion
            int r1 = r1 + r4
            int r4 = r1 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r4
            int r1 = r1 % 2
            if (r1 == 0) goto L3d
            goto L3f
        L3d:
            r2 = 60
        L3f:
            r1 = 2131363508(0x7f0a06b4, float:1.8346827E38)
            if (r2 == 0) goto L48
            r0.setTransition(r1)
            goto L4f
        L48:
            r0.setTransition(r1)
            int r0 = r3.length     // Catch: java.lang.Throwable -> L4d
            goto L4f
        L4d:
            r0 = move-exception
            throw r0
        L4f:
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.FragmentInvestmentDetailWalletBinding r0 = (id.dana.databinding.FragmentInvestmentDetailWalletBinding) r0
            if (r0 == 0) goto L63
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.getAuthRequestContext
            if (r0 == 0) goto L63
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda0 r1 = new id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$$ExternalSyntheticLambda0
            r1.<init>()
            r0.transitionToEnd(r1)
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.navigateToSearch():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if ((r9 != null ? '-' : 4) != '-') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if ((r9 != null ? '\n' : 'C') != 'C') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        r1 = r9.getString(id.dana.R.string.wallet_search_bar_hint_investment);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        r9 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest + 83;
        id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* renamed from: navigateToSearch$lambda-6  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m3017navigateToSearch$lambda6(id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment r9) {
        /*
            int r0 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion
            int r0 = r0 + 49
            int r1 = r0 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = ""
            if (r0 == 0) goto L2b
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            id.dana.wallet_v3.factory.WalletIntentFactory r0 = id.dana.wallet_v3.factory.WalletIntentFactory.INSTANCE
            r2 = r9
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            id.dana.wallet_v3.view.search.view.WalletSearchFragment$Companion r3 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.INSTANCE
            android.content.Context r9 = r9.getContext()
            int r4 = r1.length     // Catch: java.lang.Throwable -> L29
            r4 = 45
            if (r9 == 0) goto L25
            r5 = 45
            goto L26
        L25:
            r5 = 4
        L26:
            if (r5 == r4) goto L44
            goto L50
        L29:
            r9 = move-exception
            throw r9
        L2b:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            id.dana.wallet_v3.factory.WalletIntentFactory r0 = id.dana.wallet_v3.factory.WalletIntentFactory.INSTANCE
            r2 = r9
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            id.dana.wallet_v3.view.search.view.WalletSearchFragment$Companion r3 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.INSTANCE
            android.content.Context r9 = r9.getContext()
            r4 = 67
            if (r9 == 0) goto L40
            r5 = 10
            goto L42
        L40:
            r5 = 67
        L42:
            if (r5 == r4) goto L50
        L44:
            r1 = 2131958053(0x7f131925, float:1.9552707E38)
            java.lang.String r1 = r9.getString(r1)
        L4b:
            r9 = r2
            r8 = r3
            r3 = r1
            r1 = r8
            goto L5b
        L50:
            int r9 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest
            int r9 = r9 + 83
            int r4 = r9 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r4
            int r9 = r9 % 2
            goto L4b
        L5b:
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            java.lang.String r2 = "financial"
            id.dana.wallet_v3.view.search.view.WalletSearchFragment r1 = id.dana.wallet_v3.view.search.view.WalletSearchFragment.Companion.newInstance$default(r1, r2, r3, r4, r5, r6, r7)
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            r0.openNewFragmentWithAnimation(r9, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.m3017navigateToSearch$lambda6(id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment):void");
    }

    public final void loadData() {
        try {
            int i = getErrorConfigVersion + 25;
            lookAheadTest = i % 128;
            if (!(i % 2 != 0)) {
                getServicesPresenter().BuiltInFictitiousFunctionClassFactory(WalletConstant.CATEGORY_FINANCE, true);
            } else {
                getServicesPresenter().BuiltInFictitiousFunctionClassFactory(WalletConstant.CATEGORY_FINANCE, false);
            }
            getGetBalancePresenter().MyBillsEntityDataFactory();
            int i2 = lookAheadTest + 53;
            getErrorConfigVersion = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 5 : (char) 0) != 5) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private final ServicesModule getServicesModule() {
        ServicesModule servicesModule = new ServicesModule(new ServicesContract.View() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$getServicesModule$1
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
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
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
            public final void onGetFilteredThirdPartyServices(List<ThirdPartyService> thirdPartyServices) {
                Intrinsics.checkNotNullParameter(thirdPartyServices, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
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

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetThirdPartyServices(List<ThirdPartyService> thirdPartyServices) {
                Intrinsics.checkNotNullParameter(thirdPartyServices, "");
                InvestmentWalletDetailFragment.access$setInvestmentServices$p(InvestmentWalletDetailFragment.this, thirdPartyServices);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionPost(ThirdPartyService thirdPartyService, String authCode) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                WalletH5ServicesImplementation walletH5ServicesImplementation = InvestmentWalletDetailFragment.this.getWalletH5ServicesImplementation();
                String authRequestContext = UrlUtil.getAuthRequestContext(thirdPartyService.getCallingPid);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                Intrinsics.checkNotNull(authCode);
                walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, authCode, InvestmentWalletDetailFragment.this.getDeviceInformationProvider().getDeviceUUID());
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionGet(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (str != null) {
                    InvestmentWalletDetailFragment investmentWalletDetailFragment = InvestmentWalletDetailFragment.this;
                    if (UrlUtil.getErrorConfigVersion(str)) {
                        InvestmentWalletDetailFragment.access$setFromAddAsset$p(investmentWalletDetailFragment, true);
                        investmentWalletDetailFragment.getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
                        return;
                    }
                    WalletH5ServicesImplementation walletH5ServicesImplementation = investmentWalletDetailFragment.getWalletH5ServicesImplementation();
                    String authRequestContext = UrlUtil.getAuthRequestContext(str);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, null, null);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onDirectOpen(ThirdPartyService thirdPartyService, Map<String, String> params) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str != null) {
                    InvestmentWalletDetailFragment.this.getFeaturePresenter().getAuthRequestContext(str, params);
                }
            }
        });
        try {
            int i = getErrorConfigVersion + 49;
            lookAheadTest = i % 128;
            if ((i % 2 != 0 ? (char) 11 : ']') != 11) {
                return servicesModule;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return servicesModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final GetBalanceModule getBalanceModule() {
        GetBalanceModule getBalanceModule = new GetBalanceModule(new GetBalanceContract.View() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$getBalanceModule$1
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

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalance(CurrencyAmountModel currencyAmountModel) {
                GetBalanceContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceDanaPlusActive(String str, String str2, DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
                GetBalanceContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceDanaPlusError() {
                GetBalanceContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceDanaPlusUnActive(DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
                GetBalanceContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceError() {
                GetBalanceContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final /* synthetic */ void onGetBalanceState(Boolean bool) {
                GetBalanceContract.View.CC.moveToNextValue();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public final void onGetAllBalanceState(List<Boolean> allBalanceVisibility) {
                InvestmentWalletAdapter access$getInvestmentWalletAdapter$p = InvestmentWalletDetailFragment.access$getInvestmentWalletAdapter$p(InvestmentWalletDetailFragment.this);
                if (access$getInvestmentWalletAdapter$p != null) {
                    access$getInvestmentWalletAdapter$p.setGoalsBalanceVisibility(allBalanceVisibility != null ? allBalanceVisibility.get(1) : null);
                }
                InvestmentWalletAdapter access$getInvestmentWalletAdapter$p2 = InvestmentWalletDetailFragment.access$getInvestmentWalletAdapter$p(InvestmentWalletDetailFragment.this);
                if (access$getInvestmentWalletAdapter$p2 != null) {
                    access$getInvestmentWalletAdapter$p2.setEmasBalanceVisibility(allBalanceVisibility != null ? allBalanceVisibility.get(3) : null);
                }
                InvestmentWalletAdapter access$getInvestmentWalletAdapter$p3 = InvestmentWalletDetailFragment.access$getInvestmentWalletAdapter$p(InvestmentWalletDetailFragment.this);
                if (access$getInvestmentWalletAdapter$p3 != null) {
                    access$getInvestmentWalletAdapter$p3.setDanaPlusBalanceVisibility(allBalanceVisibility != null ? allBalanceVisibility.get(2) : null);
                }
            }
        });
        try {
            int i = getErrorConfigVersion + 69;
            lookAheadTest = i % 128;
            if (i % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                return getBalanceModule;
            }
            return getBalanceModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final InvestmentWalletDetailModule getInvestmentDetailModule() {
        InvestmentWalletDetailModule investmentWalletDetailModule = new InvestmentWalletDetailModule(new InvestmentWalletDetailContract.View() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$getInvestmentDetailModule$1
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

            @Override // id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract.View
            public final void onSuccessGetInvestmentAsset(List<? extends InvestmentCardModel> assets) {
                Intrinsics.checkNotNullParameter(assets, "");
                InvestmentWalletDetailFragment.access$hideShimmeringSkeleton(InvestmentWalletDetailFragment.this);
                InvestmentWalletAdapter access$getInvestmentWalletAdapter$p = InvestmentWalletDetailFragment.access$getInvestmentWalletAdapter$p(InvestmentWalletDetailFragment.this);
                if (access$getInvestmentWalletAdapter$p != null) {
                    access$getInvestmentWalletAdapter$p.setItems(assets);
                }
            }

            @Override // id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract.View
            public final void onErrorGetInvestmentAsset() {
                InvestmentWalletDetailFragment.access$hideShimmeringSkeleton(InvestmentWalletDetailFragment.this);
            }
        });
        int i = lookAheadTest + 111;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? Typography.amp : (char) 29) != 29) {
            Object obj = null;
            obj.hashCode();
            return investmentWalletDetailModule;
        }
        return investmentWalletDetailModule;
    }

    private final void goToServicePage(String key) {
        Object obj;
        try {
            int i = getErrorConfigVersion + 101;
            try {
                lookAheadTest = i % 128;
                int i2 = i % 2;
                Iterator<T> it = this.investmentServices.iterator();
                while (true) {
                    if ((it.hasNext() ? '_' : '*') != '_') {
                        obj = null;
                        int i3 = getErrorConfigVersion + 51;
                        lookAheadTest = i3 % 128;
                        int i4 = i3 % 2;
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((ThirdPartyService) next).NetworkUserEntityData$$ExternalSyntheticLambda8, key)) {
                        int i5 = getErrorConfigVersion + 3;
                        lookAheadTest = i5 % 128;
                        int i6 = i5 % 2;
                        obj = next;
                        break;
                    }
                }
                ThirdPartyService thirdPartyService = (ThirdPartyService) obj;
                if (!(thirdPartyService != null)) {
                    return;
                }
                trackServiceOpen(thirdPartyService);
                getServicesPresenter().MyBillsEntityDataFactory(thirdPartyService, (Map<String, String>) null);
                int i7 = lookAheadTest + 67;
                getErrorConfigVersion = i7 % 128;
                int i8 = i7 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void trackServiceOpen(ThirdPartyService it) {
        int i = lookAheadTest + 75;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? '\r' : (char) 3) != '\r') {
            ServicesTracker.getAuthRequestContext(getContext(), it.NetworkUserEntityData$$ExternalSyntheticLambda8, it.newProxyInstance, it.NetworkUserEntityData$$ExternalSyntheticLambda6, it.NetworkUserEntityData$$ExternalSyntheticLambda0);
            return;
        }
        ServicesTracker.getAuthRequestContext(getContext(), it.NetworkUserEntityData$$ExternalSyntheticLambda8, it.newProxyInstance, it.NetworkUserEntityData$$ExternalSyntheticLambda6, it.NetworkUserEntityData$$ExternalSyntheticLambda0);
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void openBottomSheetAddAsset() {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$openBottomSheetAddAsset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                InvestmentWalletDetailFragment investmentWalletDetailFragment = InvestmentWalletDetailFragment.this;
                FragmentManager parentFragmentManager = investmentWalletDetailFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                NewWalletFragment walletFragment = investmentWalletDetailFragment.getWalletFragment(parentFragmentManager);
                if (walletFragment != null) {
                    walletFragment.setLastAddedAssetType(2);
                    walletFragment.refreshDataBasedOnLatestAddedAssetType();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        String lowerCase = "FINANCIAL".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        Object[] objArr = null;
        new BottomSheetAddAsset(function0, 2, CollectionsKt.listOf(lowerCase), 0, null, null, false, null, 248, null).show(getParentFragmentManager(), (String) null);
        int i = getErrorConfigVersion + 89;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? Typography.greater : 'Y') != '>') {
            return;
        }
        int length = objArr.length;
    }

    private final void disableSwipe() {
        HomeTabActivity homeTabActivity;
        int i;
        FragmentActivity activity = getActivity();
        if ((activity instanceof HomeTabActivity ? '+' : '@') != '@') {
            int i2 = lookAheadTest + 119;
            getErrorConfigVersion = i2 % 128;
            int i3 = i2 % 2;
            homeTabActivity = (HomeTabActivity) activity;
            i = getErrorConfigVersion + 19;
            lookAheadTest = i % 128;
        } else {
            homeTabActivity = null;
            i = lookAheadTest + 77;
            getErrorConfigVersion = i % 128;
        }
        int i4 = i % 2;
        if ((homeTabActivity != null ? '(' : '-') != '-') {
            homeTabActivity.setSwipeable(false);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$walletH5Listener$1] */
    private final InvestmentWalletDetailFragment$walletH5Listener$1 walletH5Listener() {
        ?? r0 = new DanaH5Listener() { // from class: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment$walletH5Listener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                DanaH5Listener.CC.MyBillsEntityDataFactory();
                InvestmentWalletDetailFragment.access$showShimmeringSkeleton(InvestmentWalletDetailFragment.this);
                InvestmentWalletDetailFragment.this.getInvestmentPresenter().getInvestmentAsset();
            }
        };
        int i = getErrorConfigVersion + 25;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        return r0;
    }

    private final void showShimmeringSkeleton() {
        RecyclerView recyclerView;
        this.isLoading = true;
        FragmentInvestmentDetailWalletBinding binding = getBinding();
        Object obj = null;
        if ((binding != null ? (char) 2 : (char) 30) != 2) {
            recyclerView = null;
        } else {
            int i = getErrorConfigVersion + 115;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            recyclerView = binding.getErrorConfigVersion;
        }
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(recyclerView);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_wallet_detail_skeleton;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = this.investmentWalletAdapter;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 5;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        this.skeletonScreen = recyclerViewSkeletonScreen;
        int i3 = getErrorConfigVersion + 1;
        lookAheadTest = i3 % 128;
        if (i3 % 2 != 0) {
            obj.hashCode();
        }
    }

    private final void hideShimmeringSkeleton() {
        SkeletonScreen skeletonScreen;
        try {
            int i = lookAheadTest + 15;
            try {
                getErrorConfigVersion = i % 128;
                if ((i % 2 == 0 ? (char) 1 : 'A') != 'A') {
                    this.isLoading = true;
                    skeletonScreen = this.skeletonScreen;
                    if (!(skeletonScreen != null)) {
                        return;
                    }
                } else {
                    this.isLoading = false;
                    skeletonScreen = this.skeletonScreen;
                    if ((skeletonScreen != null ? '\r' : 'X') != '\r') {
                        return;
                    }
                }
                int i2 = lookAheadTest + 75;
                getErrorConfigVersion = i2 % 128;
                int i3 = i2 % 2;
                skeletonScreen.PlaceComponentResult();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x000f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void setupLottieBasedOnLanguage(boolean r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L13
            int r7 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion     // Catch: java.lang.Exception -> L11
            int r7 = r7 + 89
            int r0 = r7 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r0     // Catch: java.lang.Exception -> L11
            int r7 = r7 % 2
            java.lang.String r7 = "json/lottie/wallet_close_detail_page_id.lottie"
            goto L15
        Lf:
            r7 = move-exception
            throw r7
        L11:
            r7 = move-exception
            goto L36
        L13:
            java.lang.String r7 = "json/lottie/wallet_close_detail_page_en.lottie"
        L15:
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.FragmentInvestmentDetailWalletBinding r0 = (id.dana.databinding.FragmentInvestmentDetailWalletBinding) r0
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L42
            int r4 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion
            int r4 = r4 + 23
            int r5 = r4 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L2e
            r4 = 1
            goto L2f
        L2e:
            r4 = 0
        L2f:
            if (r4 == r3) goto L37
            com.airbnb.lottie.LottieAnimationView r0 = r0.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto L42
            goto L3c
        L36:
            throw r7
        L37:
            com.airbnb.lottie.LottieAnimationView r0 = r0.MyBillsEntityDataFactory
            int r4 = r1.length     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L42
        L3c:
            r0.setAnimation(r7)
            goto L42
        L40:
            r7 = move-exception
            throw r7
        L42:
            int r7 = id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.lookAheadTest
            int r7 = r7 + 5
            int r0 = r7 % 128
            id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.getErrorConfigVersion = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L4f
            r2 = 1
        L4f:
            if (r2 == r3) goto L52
            return
        L52:
            int r7 = r1.length     // Catch: java.lang.Throwable -> L54
            return
        L54:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment.setupLottieBasedOnLanguage(boolean):void");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/wallet_v3/investment/view/InvestmentWalletDetailFragment$Companion;", "", "", "Lid/dana/wallet_v3/model/WalletV3CardModel;", FirebaseAnalytics.Param.ITEMS, "Lid/dana/wallet_v3/investment/view/InvestmentWalletDetailFragment;", "newInstance", "(Ljava/util/List;)Lid/dana/wallet_v3/investment/view/InvestmentWalletDetailFragment;", "", InvestmentWalletDetailFragment.INVESTMENT_CARD_ITEMS, "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InvestmentWalletDetailFragment newInstance(List<? extends WalletV3CardModel> items) {
            Intrinsics.checkNotNullParameter(items, "");
            Bundle bundle = new Bundle();
            Object[] array = items.toArray(new WalletV3CardModel[0]);
            if (array != null) {
                bundle.putParcelableArray(InvestmentWalletDetailFragment.INVESTMENT_CARD_ITEMS, (Parcelable[]) array);
                InvestmentWalletDetailFragment investmentWalletDetailFragment = new InvestmentWalletDetailFragment();
                investmentWalletDetailFragment.setArguments(bundle);
                return investmentWalletDetailFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $10 + 29;
        $11 = i2 % 128;
        while (true) {
            int i3 = i2 % 2;
            if (e.KClassImpl$Data$declaredNonStaticMembers$2 >= length3) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i4 = $11 + 1;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
            cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
            cArr4[i7] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (MyBillsEntityDataFactory ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
            i2 = $10 + 33;
            $11 = i2 % 128;
        }
    }
}
