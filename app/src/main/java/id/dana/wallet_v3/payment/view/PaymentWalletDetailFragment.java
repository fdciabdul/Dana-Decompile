package id.dana.wallet_v3.payment.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
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
import id.dana.danah5.DanaH5;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.FragmentPaymentDetailWalletBinding;
import id.dana.di.modules.OauthModule;
import id.dana.model.ThirdPartyService;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.TagFormat;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet_v3.WalletDetailBaseImplementation;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.factory.WalletIntentFactory;
import id.dana.wallet_v3.listener.DanaBalanceClickListener;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.listener.WalletDetailBaseFunction;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.payment.adapter.PaymentWalletAdapter;
import id.dana.wallet_v3.payment.di.DaggerPaymentWalletDetailComponent;
import id.dana.wallet_v3.payment.di.PaymentWalletDetailModule;
import id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract;
import id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$danaBalanceClickListener$2;
import id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$ptrCardPaymentHandle$2;
import id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$walletCardAssetClickListener$2;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.view.NewWalletFragment;
import id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset;
import id.dana.wallet_v3.view.ptr.PtrWalletFrameLayout;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.Collection;
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
import o.B;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u009f\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u009f\u0001B\b¢\u0006\u0005\b\u009e\u0001\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b!\u0010\"J%\u0010'\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\u0012J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0012J\u000f\u0010+\u001a\u00020\bH\u0014¢\u0006\u0004\b+\u0010\u0012J\u000f\u0010,\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010\u0012J\u000f\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010\u0012J\u000f\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010\u0012J\u0017\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b1\u00102J\u0018\u00106\u001a\u0002052\u0006\u00104\u001a\u000203H\u0096\u0001¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\b¢\u0006\u0004\b8\u0010\u0012J\u000f\u00109\u001a\u00020\bH\u0002¢\u0006\u0004\b9\u0010\u0012J\r\u0010:\u001a\u00020\b¢\u0006\u0004\b:\u0010\u0012J\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010\u0012J\u000f\u0010<\u001a\u00020\bH\u0016¢\u0006\u0004\b<\u0010\u0012J\u000f\u0010=\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010\u0012J\u000f\u0010>\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010\u0012J\u001d\u0010@\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0?H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010\u0012J\u0017\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u000205H\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\bH\u0002¢\u0006\u0004\bF\u0010\u0012R\u001b\u0010L\u001a\u00020G8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\"\u0010N\u001a\u00020M8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020$0?8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u0002058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u0002058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bf\u0010eR\u0014\u0010h\u001a\u00020g8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020$0?8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bj\u0010cR\u0018\u0010l\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\"\u0010o\u001a\u00020n8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001b\u0010y\u001a\u00020u8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bv\u0010I\u001a\u0004\bw\u0010xR#\u0010{\u001a\u00020z8\u0007@\u0007X\u0087.¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R \u0010\u008f\u0001\u001a\u00030\u008b\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b\u008c\u0001\u0010I\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R*\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001"}, d2 = {"Lid/dana/wallet_v3/payment/view/PaymentWalletDetailFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentPaymentDetailWalletBinding;", "Lid/dana/wallet_v3/listener/WalletDetailBaseFunction;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "backFromSearch", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", HomeTabActivity.WALLET_SECTION, "backToMainPage", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;I)V", "checkPaymentServices", "()V", "checkPaymentServicesExist", "Lid/dana/utils/danah5/DanaH5Listener;", "createH5AppListener", "()Lid/dana/utils/danah5/DanaH5Listener;", "disableSwipe", "getLayout", "()I", "Lid/dana/wallet_v3/payment/di/PaymentWalletDetailModule;", "getPaymentWalletDetailModule", "()Lid/dana/wallet_v3/payment/di/PaymentWalletDetailModule;", "Lid/dana/contract/services/ServicesModule;", "getServicesModule", "()Lid/dana/contract/services/ServicesModule;", "Lid/dana/wallet_v3/view/NewWalletFragment;", "getWalletFragment", "(Landroidx/fragment/app/FragmentManager;)Lid/dana/wallet_v3/view/NewWalletFragment;", "", "Lid/dana/model/ThirdPartyService;", "services", "key", "goToServicePage", "(Ljava/util/List;Ljava/lang/String;)V", "gotoTopupPage", "hideShimmeringSkeleton", IAPSyncCommand.COMMAND_INIT, "initInjector", "initOnClickListener", "initView", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/FragmentPaymentDetailWalletBinding;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "isFromDeeplinkWallet", "(Landroid/app/Activity;)Z", "loadData", "navigateToSearch", "onCollapseFromSearch", "onDestroyView", "onResume", "onStart", "openAddPaymentCard", "", "openBottomSheetAddAsset", "(Ljava/util/List;)V", "refreshMainWalletPage", "isDefaultIndonesian", "setupLottieBasedOnLanguage", "(Z)V", "showShimmeringSkeleton", "Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener$delegate", "Lkotlin/Lazy;", "getDanaBalanceClickListener", "()Lid/dana/wallet_v3/listener/DanaBalanceClickListener;", "danaBalanceClickListener", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "financeServices", "Ljava/util/List;", "isFromAddAsset", "Z", GriverMonitorConstants.KEY_IS_LOADING, "Lid/dana/wallet_v3/payment/view/PaymentWalletDetailFragment$onBackPressedCallback$1;", "onBackPressedCallback", "Lid/dana/wallet_v3/payment/view/PaymentWalletDetailFragment$onBackPressedCallback$1;", "paymentServices", "Lid/dana/wallet_v3/payment/adapter/PaymentWalletAdapter;", "paymentWalletAdapter", "Lid/dana/wallet_v3/payment/adapter/PaymentWalletAdapter;", "Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$Presenter;", "paymentWalletDetailPresenter", "Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$Presenter;", "getPaymentWalletDetailPresenter", "()Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$Presenter;", "setPaymentWalletDetailPresenter", "(Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$Presenter;)V", "Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardPaymentHandle$delegate", "getPtrCardPaymentHandle", "()Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardPaymentHandle", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/contract/services/ServicesContract$Presenter;", "servicesPresenter", "Lid/dana/contract/services/ServicesContract$Presenter;", "getServicesPresenter", "()Lid/dana/contract/services/ServicesContract$Presenter;", "setServicesPresenter", "(Lid/dana/contract/services/ServicesContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonScreen", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener$delegate", "getWalletCardAssetClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "walletH5ServicesImplementation", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "getWalletH5ServicesImplementation", "()Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "setWalletH5ServicesImplementation", "(Lid/dana/wallet_v3/WalletH5ServicesImplementation;)V", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "walletV3TrackerImplementation", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "getWalletV3TrackerImplementation", "()Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "setWalletV3TrackerImplementation", "(Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaymentWalletDetailFragment extends ViewBindingFragment<FragmentPaymentDetailWalletBinding> implements WalletDetailBaseFunction {
    private static int $10 = 0;
    private static int $11 = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private static final String PAYMENT_CARD_ITEMS = "PAYMENT_CARD_ITEMS";
    private static int PlaceComponentResult = 0;
    private static int getErrorConfigVersion = 1;
    private static byte[] lookAheadTest;
    private static int scheduleImpl;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public FeatureContract.Presenter featurePresenter;
    private boolean isFromAddAsset;
    private boolean isLoading;
    private PaymentWalletAdapter paymentWalletAdapter;
    @Inject
    public PaymentWalletDetailContract.Presenter paymentWalletDetailPresenter;
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
    private List<ThirdPartyService> financeServices = new ArrayList();
    private List<ThirdPartyService> paymentServices = new ArrayList();

    /* renamed from: danaBalanceClickListener$delegate  reason: from kotlin metadata */
    private final Lazy danaBalanceClickListener = LazyKt.lazy(new Function0<PaymentWalletDetailFragment$danaBalanceClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$danaBalanceClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$danaBalanceClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final PaymentWalletDetailFragment paymentWalletDetailFragment = PaymentWalletDetailFragment.this;
            return new DanaBalanceClickListener() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$danaBalanceClickListener$2.1
                @Override // id.dana.wallet_v3.listener.DanaBalanceClickListener
                public final void onBalanceVisibilityClicked(boolean isBalanceVisible) {
                }

                @Override // id.dana.wallet_v3.listener.DanaBalanceClickListener
                public final void onTopUpClicked() {
                    PaymentWalletDetailFragment.access$gotoTopupPage(PaymentWalletDetailFragment.this);
                }
            };
        }
    });
    private final PaymentWalletDetailFragment$onBackPressedCallback$1 onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$onBackPressedCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        @Override // androidx.view.OnBackPressedCallback
        public final void handleOnBackPressed() {
            PaymentWalletDetailFragment paymentWalletDetailFragment = PaymentWalletDetailFragment.this;
            FragmentPaymentDetailWalletBinding access$getBinding = PaymentWalletDetailFragment.access$getBinding(paymentWalletDetailFragment);
            RecyclerView recyclerView = access$getBinding != null ? access$getBinding.lookAheadTest : null;
            FragmentManager parentFragmentManager = PaymentWalletDetailFragment.this.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            paymentWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 0);
        }
    };

    /* renamed from: ptrCardPaymentHandle$delegate  reason: from kotlin metadata */
    private final Lazy ptrCardPaymentHandle = LazyKt.lazy(new Function0<PaymentWalletDetailFragment$ptrCardPaymentHandle$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$ptrCardPaymentHandle$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$ptrCardPaymentHandle$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final PaymentWalletDetailFragment paymentWalletDetailFragment = PaymentWalletDetailFragment.this;
            return new PtrHandler() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$ptrCardPaymentHandle$2.1
                @Override // in.srain.cube.views.ptr.PtrHandler
                public final boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                    RecyclerView recyclerView;
                    FragmentPaymentDetailWalletBinding access$getBinding = PaymentWalletDetailFragment.access$getBinding(PaymentWalletDetailFragment.this);
                    RecyclerView.LayoutManager layoutManager = (access$getBinding == null || (recyclerView = access$getBinding.lookAheadTest) == null) ? null : recyclerView.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
                    return (linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : -1) == 0;
                }

                @Override // in.srain.cube.views.ptr.PtrHandler
                public final void onRefreshBegin(PtrFrameLayout frame) {
                    PtrWalletFrameLayout ptrWalletFrameLayout;
                    PaymentWalletDetailFragment.access$navigateToSearch(PaymentWalletDetailFragment.this);
                    FragmentPaymentDetailWalletBinding access$getBinding = PaymentWalletDetailFragment.access$getBinding(PaymentWalletDetailFragment.this);
                    if (access$getBinding == null || (ptrWalletFrameLayout = access$getBinding.moveToNextValue) == null) {
                        return;
                    }
                    ptrWalletFrameLayout.refreshComplete();
                }
            };
        }
    });

    /* renamed from: walletCardAssetClickListener$delegate  reason: from kotlin metadata */
    private final Lazy walletCardAssetClickListener = LazyKt.lazy(new Function0<PaymentWalletDetailFragment$walletCardAssetClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$walletCardAssetClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$walletCardAssetClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final PaymentWalletDetailFragment paymentWalletDetailFragment = PaymentWalletDetailFragment.this;
            return new WalletCardAssetClickListener() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$walletCardAssetClickListener$2.1
                @Override // id.dana.wallet_v3.listener.WalletCardAssetClickListener
                public final void onCardClicked(WalletV3CardModel data) {
                    Intrinsics.checkNotNullParameter(data, "");
                    if (data instanceof PaymentCardModel.BankCard) {
                        String MyBillsEntityDataFactory2 = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/portal/bankcarddetail?cardIndexNo={cardIndexNo}").MyBillsEntityDataFactory(WalletConstant.CARD_INDEX_NO, ((PaymentCardModel.BankCard) data).getCardIndexNo()).MyBillsEntityDataFactory();
                        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
                        DanaH5.startContainerFullUrl(MyBillsEntityDataFactory2, PaymentWalletDetailFragment.access$createH5AppListener(PaymentWalletDetailFragment.this));
                    } else if (data instanceof PaymentCardModel.PaylaterCard) {
                        PaymentWalletDetailFragment paymentWalletDetailFragment2 = PaymentWalletDetailFragment.this;
                        PaymentWalletDetailFragment.access$goToServicePage(paymentWalletDetailFragment2, PaymentWalletDetailFragment.access$getFinanceServices$p(paymentWalletDetailFragment2), "service_akulaku");
                    } else if (data instanceof PaymentCardModel.EmptyCard) {
                        boolean z = true;
                        if ((!PaymentWalletDetailFragment.access$getPaymentServices$p(PaymentWalletDetailFragment.this).isEmpty()) != false) {
                            List access$getPaymentServices$p = PaymentWalletDetailFragment.access$getPaymentServices$p(PaymentWalletDetailFragment.this);
                            if (!(access$getPaymentServices$p instanceof Collection) || !access$getPaymentServices$p.isEmpty()) {
                                Iterator it = access$getPaymentServices$p.iterator();
                                while (it.hasNext()) {
                                    if (Intrinsics.areEqual(((ThirdPartyService) it.next()).NetworkUserEntityData$$ExternalSyntheticLambda8, "service_bank_card")) {
                                        break;
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                                PaymentWalletDetailFragment paymentWalletDetailFragment3 = PaymentWalletDetailFragment.this;
                                PaymentWalletDetailFragment.access$goToServicePage(paymentWalletDetailFragment3, PaymentWalletDetailFragment.access$getPaymentServices$p(paymentWalletDetailFragment3), "service_bank_card");
                                return;
                            }
                        }
                        PaymentWalletDetailFragment.access$openAddPaymentCard(PaymentWalletDetailFragment.this);
                    }
                }
            };
        }
    });

    public static /* synthetic */ void $r8$lambda$4WXrIelp4u_pPtMaTWPHmPmj7PM(PaymentWalletDetailFragment paymentWalletDetailFragment, View view) {
        int i = getErrorConfigVersion + 47;
        scheduleImpl = i % 128;
        char c = i % 2 != 0 ? (char) 20 : (char) 29;
        Object[] objArr = null;
        m3025initOnClickListener$lambda5(paymentWalletDetailFragment, view);
        if (c != 29) {
            int length = objArr.length;
        }
        try {
            int i2 = getErrorConfigVersion + 71;
            scheduleImpl = i2 % 128;
            if (i2 % 2 == 0) {
                return;
            }
            int length2 = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$MVFdmfOCiflpV7cAoi9inoSHuyY(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = getErrorConfigVersion + 73;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        m3028navigateToSearch$lambda4(paymentWalletDetailFragment);
        try {
            int i3 = getErrorConfigVersion + 59;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$T5yjf4-ddxMVvi0CysLxZ3ImJJA  reason: not valid java name */
    public static /* synthetic */ void m3024$r8$lambda$T5yjf4ddxMVvi0CysLxZ3ImJJA(PaymentWalletDetailFragment paymentWalletDetailFragment, View view) {
        int i = getErrorConfigVersion + 121;
        scheduleImpl = i % 128;
        char c = i % 2 != 0 ? 'P' : 'B';
        m3027initView$lambda2(paymentWalletDetailFragment, view);
        if (c == 'P') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = scheduleImpl + 69;
        getErrorConfigVersion = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        int i3 = 63 / 0;
    }

    public static /* synthetic */ void $r8$lambda$hg_PmriSVFv1Rdw2uMMZUsQZYrg(PaymentWalletDetailFragment paymentWalletDetailFragment, View view) {
        int i = getErrorConfigVersion + 69;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            m3026initOnClickListener$lambda6(paymentWalletDetailFragment, view);
            int i3 = getErrorConfigVersion + 87;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        try {
            MyBillsEntityDataFactory();
            INSTANCE = new Companion(null);
            int i = scheduleImpl + 15;
            getErrorConfigVersion = i % 128;
            if (!(i % 2 != 0)) {
                int i2 = 85 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = 1257195741;
        KClassImpl$Data$declaredNonStaticMembers$2 = -206390445;
        lookAheadTest = new byte[]{70, 82, 90, 33, 80, 71, 66, -97};
        PlaceComponentResult = 273383151;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        int i = scheduleImpl + 69;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        this._$_findViewCache.clear();
        int i3 = scheduleImpl + 47;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r3 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r3 = getGetAuthRequestContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r3 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r5 = 23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        r5 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        if (r5 == 'G') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        r4 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl + 79;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if ((r4 % 2) != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r3 = r3.findViewById(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        if (r2 == true) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
    
        r2 = r3.findViewById(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        if (r2 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        r0.put(java.lang.Integer.valueOf(r7), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (r3 == null) goto L13;
     */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r7) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r0 = r0 + 85
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L24
            java.util.Map<java.lang.Integer, android.view.View> r0 = r6._$_findViewCache
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object r3 = r0.get(r3)
            android.view.View r3 = (android.view.View) r3
            r4 = 53
            int r4 = r4 / r2
            if (r3 != 0) goto L20
            goto L32
        L20:
            r1 = r3
            goto L70
        L22:
            r7 = move-exception
            throw r7
        L24:
            java.util.Map<java.lang.Integer, android.view.View> r0 = r6._$_findViewCache     // Catch: java.lang.Exception -> L71
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L71
            java.lang.Object r3 = r0.get(r3)     // Catch: java.lang.Exception -> L71
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Exception -> L71
            if (r3 != 0) goto L20
        L32:
            android.view.View r3 = r6.getGetAuthRequestContext()
            r4 = 71
            if (r3 == 0) goto L3d
            r5 = 23
            goto L3f
        L3d:
            r5 = 71
        L3f:
            if (r5 == r4) goto L70
            int r4 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl     // Catch: java.lang.Exception -> L6e
            int r4 = r4 + 79
            int r5 = r4 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r5     // Catch: java.lang.Exception -> L6e
            int r4 = r4 % 2
            if (r4 != 0) goto L5f
            android.view.View r3 = r3.findViewById(r7)
            r1.hashCode()     // Catch: java.lang.Throwable -> L5d
            r4 = 1
            if (r3 == 0) goto L58
            goto L59
        L58:
            r2 = 1
        L59:
            if (r2 == r4) goto L70
            r1 = r3
            goto L66
        L5d:
            r7 = move-exception
            throw r7
        L5f:
            android.view.View r2 = r3.findViewById(r7)
            if (r2 == 0) goto L70
            r1 = r2
        L66:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.put(r7, r1)
            goto L70
        L6e:
            r7 = move-exception
            throw r7
        L70:
            return r1
        L71:
            r7 = move-exception
            goto L74
        L73:
            throw r7
        L74:
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment._$_findCachedViewById(int):android.view.View");
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backFromSearch(FragmentManager fragmentManager, String tag) {
        int i = getErrorConfigVersion + 119;
        scheduleImpl = i % 128;
        char c = i % 2 != 0 ? '1' : '\\';
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(tag, "");
        if (c != '1') {
            this.$$delegate_0.backFromSearch(fragmentManager, tag);
        } else {
            this.$$delegate_0.backFromSearch(fragmentManager, tag);
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = getErrorConfigVersion + 37;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backToMainPage(RecyclerView recyclerView, FragmentManager fragmentManager, int section) {
        int i = scheduleImpl + 63;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            try {
                Intrinsics.checkNotNullParameter(fragmentManager, "");
                this.$$delegate_0.backToMainPage(recyclerView, fragmentManager, section);
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(fragmentManager, "");
            this.$$delegate_0.backToMainPage(recyclerView, fragmentManager, section);
            Object obj = null;
            obj.hashCode();
        }
        int i2 = getErrorConfigVersion + 37;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        int i = scheduleImpl + 101;
        getErrorConfigVersion = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? '(' : ',') != ',') {
            obj.hashCode();
        }
        int i2 = scheduleImpl + 59;
        getErrorConfigVersion = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 25 : 'G') != 'G') {
            obj.hashCode();
            return R.layout.fragment_payment_detail_wallet;
        }
        return R.layout.fragment_payment_detail_wallet;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final NewWalletFragment getWalletFragment(FragmentManager fragmentManager) {
        int i = getErrorConfigVersion + 91;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        NewWalletFragment walletFragment = this.$$delegate_0.getWalletFragment(fragmentManager);
        int i3 = getErrorConfigVersion + 113;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return walletFragment;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final boolean isFromDeeplinkWallet(Activity activity) {
        int i = scheduleImpl + 75;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(activity, "");
        boolean isFromDeeplinkWallet = this.$$delegate_0.isFromDeeplinkWallet(activity);
        int i3 = getErrorConfigVersion + 37;
        scheduleImpl = i3 % 128;
        if ((i3 % 2 != 0 ? 'c' : 'J') != 'c') {
            return isFromDeeplinkWallet;
        }
        Object obj = null;
        obj.hashCode();
        return isFromDeeplinkWallet;
    }

    public static final /* synthetic */ DanaH5Listener access$createH5AppListener(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = scheduleImpl + 73;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        DanaH5Listener createH5AppListener = paymentWalletDetailFragment.createH5AppListener();
        int i3 = scheduleImpl + 79;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? '#' : '\r') != '#') {
            return createH5AppListener;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return createH5AppListener;
    }

    public static final /* synthetic */ FragmentPaymentDetailWalletBinding access$getBinding(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        try {
            int i = getErrorConfigVersion + 61;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
                FragmentPaymentDetailWalletBinding binding = paymentWalletDetailFragment.getBinding();
                int i3 = scheduleImpl + 71;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                return binding;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ List access$getFinanceServices$p(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = getErrorConfigVersion + 119;
        scheduleImpl = i % 128;
        try {
            if ((i % 2 != 0 ? '_' : 'H') != '_') {
                return paymentWalletDetailFragment.financeServices;
            }
            List<ThirdPartyService> list = paymentWalletDetailFragment.financeServices;
            Object obj = null;
            obj.hashCode();
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ List access$getPaymentServices$p(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = scheduleImpl + 31;
        getErrorConfigVersion = i % 128;
        if (!(i % 2 == 0)) {
            return paymentWalletDetailFragment.paymentServices;
        }
        int i2 = 24 / 0;
        return paymentWalletDetailFragment.paymentServices;
    }

    public static final /* synthetic */ PaymentWalletAdapter access$getPaymentWalletAdapter$p(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = scheduleImpl + 27;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        PaymentWalletAdapter paymentWalletAdapter = paymentWalletDetailFragment.paymentWalletAdapter;
        try {
            int i3 = getErrorConfigVersion + 119;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return paymentWalletAdapter;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$goToServicePage(PaymentWalletDetailFragment paymentWalletDetailFragment, List list, String str) {
        int i = getErrorConfigVersion + 63;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? '9' : (char) 4) != '9') {
            paymentWalletDetailFragment.goToServicePage(list, str);
            return;
        }
        paymentWalletDetailFragment.goToServicePage(list, str);
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void access$gotoTopupPage(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        try {
            int i = getErrorConfigVersion + 21;
            scheduleImpl = i % 128;
            boolean z = i % 2 != 0;
            paymentWalletDetailFragment.gotoTopupPage();
            if (z) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$hideShimmeringSkeleton(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = getErrorConfigVersion + 63;
        scheduleImpl = i % 128;
        char c = i % 2 != 0 ? 'W' : '\\';
        paymentWalletDetailFragment.hideShimmeringSkeleton();
        if (c != '\\') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = scheduleImpl + 3;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void access$navigateToSearch(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = scheduleImpl + 121;
        getErrorConfigVersion = i % 128;
        char c = i % 2 == 0 ? (char) 3 : (char) 31;
        paymentWalletDetailFragment.navigateToSearch();
        if (c != 31) {
            int i2 = 66 / 0;
        }
        int i3 = getErrorConfigVersion + 67;
        scheduleImpl = i3 % 128;
        if ((i3 % 2 != 0 ? 'M' : (char) 16) != 'M') {
            return;
        }
        int i4 = 2 / 0;
    }

    public static final /* synthetic */ void access$openAddPaymentCard(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = scheduleImpl + 53;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        paymentWalletDetailFragment.openAddPaymentCard();
        int i3 = getErrorConfigVersion + 7;
        scheduleImpl = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void access$refreshMainWalletPage(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = getErrorConfigVersion + 9;
        scheduleImpl = i % 128;
        boolean z = i % 2 != 0;
        paymentWalletDetailFragment.refreshMainWalletPage();
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static final /* synthetic */ void access$setFinanceServices$p(PaymentWalletDetailFragment paymentWalletDetailFragment, List list) {
        int i = scheduleImpl + 111;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? Typography.less : 'R') != '<') {
            paymentWalletDetailFragment.financeServices = list;
        } else {
            paymentWalletDetailFragment.financeServices = list;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = getErrorConfigVersion + 39;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
    }

    public static final /* synthetic */ void access$setPaymentServices$p(PaymentWalletDetailFragment paymentWalletDetailFragment, List list) {
        try {
            int i = getErrorConfigVersion + 73;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
                paymentWalletDetailFragment.paymentServices = list;
                int i3 = scheduleImpl + 55;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$showShimmeringSkeleton(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        int i = scheduleImpl + 115;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        paymentWalletDetailFragment.showShimmeringSkeleton();
        int i3 = scheduleImpl + 95;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* bridge */ /* synthetic */ FragmentPaymentDetailWalletBinding initViewBinding(View view) {
        try {
            int i = scheduleImpl + 61;
            getErrorConfigVersion = i % 128;
            boolean z = i % 2 != 0;
            FragmentPaymentDetailWalletBinding initViewBinding = initViewBinding(view);
            if (!z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = getErrorConfigVersion + 45;
            try {
                scheduleImpl = i2 % 128;
                if ((i2 % 2 != 0 ? '[' : 'H') != 'H') {
                    int i3 = 76 / 0;
                    return initViewBinding;
                }
                return initViewBinding;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        if ((r0 != null ? com.alibaba.fastjson.parser.JSONLexer.EOI : 'Q') != 'Q') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002b, code lost:
    
        r1 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl + 13;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getServicesPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.services.ServicesContract.Presenter getServicesPresenter() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl     // Catch: java.lang.Exception -> L3e
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1     // Catch: java.lang.Exception -> L3c
            int r0 = r0 % 2
            r1 = 76
            if (r0 != 0) goto L11
            r0 = 18
            goto L13
        L11:
            r0 = 76
        L13:
            r2 = 0
            if (r0 == r1) goto L1e
            id.dana.contract.services.ServicesContract$Presenter r0 = r4.servicesPresenter
            int r1 = r2.length     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L36
            goto L2b
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            id.dana.contract.services.ServicesContract$Presenter r0 = r4.servicesPresenter     // Catch: java.lang.Exception -> L3c
            r1 = 81
            if (r0 == 0) goto L27
            r3 = 26
            goto L29
        L27:
            r3 = 81
        L29:
            if (r3 == r1) goto L36
        L2b:
            int r1 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r1 = r1 + 13
            int r2 = r1 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r2
            int r1 = r1 % 2
            return r0
        L36:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r2
        L3c:
            r0 = move-exception
            throw r0
        L3e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getServicesPresenter():id.dana.contract.services.ServicesContract$Presenter");
    }

    @JvmName(name = "setServicesPresenter")
    public final void setServicesPresenter(ServicesContract.Presenter presenter) {
        int i = scheduleImpl + 3;
        getErrorConfigVersion = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? (char) 21 : 'G') != 21) {
            try {
                Intrinsics.checkNotNullParameter(presenter, "");
                try {
                    this.servicesPresenter = presenter;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.servicesPresenter = presenter;
            obj.hashCode();
        }
        int i2 = scheduleImpl + 27;
        getErrorConfigVersion = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        obj.hashCode();
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if ((dynamicUrlWrapper != null ? (char) 30 : '5') != '5') {
            int i = getErrorConfigVersion + 33;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return dynamicUrlWrapper;
        }
        try {
            Intrinsics.throwUninitializedPropertyAccessException("");
            try {
                int i3 = getErrorConfigVersion + 7;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        int i = scheduleImpl + 53;
        getErrorConfigVersion = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? '\'' : '#') != '#') {
            Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
            this.dynamicUrlWrapper = dynamicUrlWrapper;
            obj.hashCode();
        } else {
            Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
            this.dynamicUrlWrapper = dynamicUrlWrapper;
        }
        int i2 = getErrorConfigVersion + 87;
        scheduleImpl = i2 % 128;
        if (!(i2 % 2 == 0)) {
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0022, code lost:
    
        if ((r0 == null) != true) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:
    
        r1 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion + 95;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getReadLinkPropertiesPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl     // Catch: java.lang.Exception -> L38
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L1b
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r5.readLinkPropertiesPresenter     // Catch: java.lang.Exception -> L19
            if (r0 == 0) goto L2f
            goto L24
        L19:
            r0 = move-exception
            goto L35
        L1b:
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r5.readLinkPropertiesPresenter     // Catch: java.lang.Exception -> L38
            int r4 = r3.length     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L21
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 == r2) goto L2f
        L24:
            int r1 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r1 = r1 + 95
            int r2 = r1 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r2
            int r1 = r1 % 2
            return r0
        L2f:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L19
            return r3
        L35:
            throw r0
        L36:
            r0 = move-exception
            throw r0
        L38:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getReadLinkPropertiesPresenter():id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter");
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        int i = scheduleImpl + 19;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.readLinkPropertiesPresenter = presenter;
        int i3 = getErrorConfigVersion + 71;
        scheduleImpl = i3 % 128;
        if ((i3 % 2 != 0 ? '/' : '5') != '/') {
            return;
        }
        int i4 = 87 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0021, code lost:
    
        if (r1 != true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0023, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:
    
        r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion + 61;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if ((r0 == null) != false) goto L19;
     */
    @kotlin.jvm.JvmName(name = "getDeviceInformationProvider")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.config.DeviceInformationProvider getDeviceInformationProvider() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r0 = r0 + 85
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1b
            id.dana.data.config.DeviceInformationProvider r0 = r5.deviceInformationProvider
            int r4 = r2.length     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L15
            goto L16
        L15:
            r1 = 1
        L16:
            if (r1 == 0) goto L23
            goto L24
        L19:
            r0 = move-exception
            throw r0
        L1b:
            id.dana.data.config.DeviceInformationProvider r0 = r5.deviceInformationProvider     // Catch: java.lang.Exception -> L34
            if (r0 == 0) goto L20
            goto L21
        L20:
            r1 = 1
        L21:
            if (r1 == r3) goto L24
        L23:
            return r0
        L24:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L34
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r0 = r0 + 61
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r1
            int r0 = r0 % 2
            return r2
        L34:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getDeviceInformationProvider():id.dana.data.config.DeviceInformationProvider");
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        int i = scheduleImpl + 57;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? 'C' : '3') != '3') {
            Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
            this.deviceInformationProvider = deviceInformationProvider;
            int i2 = 72 / 0;
            return;
        }
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
    }

    @JvmName(name = "getPaymentWalletDetailPresenter")
    public final PaymentWalletDetailContract.Presenter getPaymentWalletDetailPresenter() {
        int i = scheduleImpl + 83;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        PaymentWalletDetailContract.Presenter presenter = this.paymentWalletDetailPresenter;
        if ((presenter != null ? (char) 30 : (char) 15) != 30) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        try {
            int i3 = getErrorConfigVersion + 23;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setPaymentWalletDetailPresenter")
    public final void setPaymentWalletDetailPresenter(PaymentWalletDetailContract.Presenter presenter) {
        try {
            int i = scheduleImpl + 59;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(presenter, "");
            this.paymentWalletDetailPresenter = presenter;
            int i3 = scheduleImpl + 67;
            getErrorConfigVersion = i3 % 128;
            if ((i3 % 2 == 0 ? 'V' : 'b') != 'V') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getWalletH5ServicesImplementation")
    public final WalletH5ServicesImplementation getWalletH5ServicesImplementation() {
        WalletH5ServicesImplementation walletH5ServicesImplementation = this.walletH5ServicesImplementation;
        if ((walletH5ServicesImplementation != null ? '1' : 'X') != 'X') {
            int i = getErrorConfigVersion + 49;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return walletH5ServicesImplementation;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        int i3 = scheduleImpl + 37;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    @JvmName(name = "setWalletH5ServicesImplementation")
    public final void setWalletH5ServicesImplementation(WalletH5ServicesImplementation walletH5ServicesImplementation) {
        int i = scheduleImpl + 25;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            try {
                Intrinsics.checkNotNullParameter(walletH5ServicesImplementation, "");
                this.walletH5ServicesImplementation = walletH5ServicesImplementation;
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(walletH5ServicesImplementation, "");
            this.walletH5ServicesImplementation = walletH5ServicesImplementation;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = scheduleImpl + 73;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
    
        if ((r0 != null) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0023, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion + 59;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r0 % 128;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if ((r0 % 2) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if ((r0 != null) != true) goto L18;
     */
    @kotlin.jvm.JvmName(name = "getWalletV3TrackerImplementation")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.wallet_v3.tracker.WalletV3TrackerImpl getWalletV3TrackerImplementation() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 == 0) goto L1a
            id.dana.wallet_v3.tracker.WalletV3TrackerImpl r0 = r4.walletV3TrackerImplementation
            r3 = 62
            int r3 = r3 / r2
            if (r0 == 0) goto L15
            r2 = 1
        L15:
            if (r2 == r1) goto L22
            goto L23
        L18:
            r0 = move-exception
            throw r0
        L1a:
            id.dana.wallet_v3.tracker.WalletV3TrackerImpl r0 = r4.walletV3TrackerImplementation
            if (r0 == 0) goto L1f
            goto L20
        L1f:
            r1 = 0
        L20:
            if (r1 == 0) goto L23
        L22:
            return r0
        L23:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L3b
            r1.hashCode()     // Catch: java.lang.Throwable -> L39
            return r1
        L39:
            r0 = move-exception
            throw r0
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getWalletV3TrackerImplementation():id.dana.wallet_v3.tracker.WalletV3TrackerImpl");
    }

    @JvmName(name = "setWalletV3TrackerImplementation")
    public final void setWalletV3TrackerImplementation(WalletV3TrackerImpl walletV3TrackerImpl) {
        int i = getErrorConfigVersion + 15;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? '1' : 'E') != 'E') {
            Intrinsics.checkNotNullParameter(walletV3TrackerImpl, "");
            this.walletV3TrackerImplementation = walletV3TrackerImpl;
            int i2 = 86 / 0;
        } else {
            Intrinsics.checkNotNullParameter(walletV3TrackerImpl, "");
            this.walletV3TrackerImplementation = walletV3TrackerImpl;
        }
        try {
            int i3 = getErrorConfigVersion + 69;
            scheduleImpl = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 24 : '@') != '@') {
                int i4 = 63 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0013
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "getFeaturePresenter")
    public final id.dana.contract.deeplink.path.FeatureContract.Presenter getFeaturePresenter() {
        /*
            r4 = this;
            id.dana.contract.deeplink.path.FeatureContract$Presenter r0 = r4.featurePresenter
            r1 = 1
            if (r0 == 0) goto L7
            r2 = 1
            goto L8
        L7:
            r2 = 0
        L8:
            r3 = 0
            if (r2 == r1) goto L15
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L11
            return r3
        L11:
            r0 = move-exception
            throw r0
        L13:
            r0 = move-exception
            throw r0
        L15:
            int r1 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r1 = r1 + 57
            int r2 = r1 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r2
            int r1 = r1 % 2
            int r1 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r1 = r1 + 79
            int r2 = r1 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r2
            int r1 = r1 % 2
            r2 = 63
            if (r1 != 0) goto L30
            r1 = 76
            goto L32
        L30:
            r1 = 63
        L32:
            if (r1 == r2) goto L3a
            r3.hashCode()     // Catch: java.lang.Throwable -> L38
            return r0
        L38:
            r0 = move-exception
            throw r0
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getFeaturePresenter():id.dana.contract.deeplink.path.FeatureContract$Presenter");
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        int i = getErrorConfigVersion + 81;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? 'E' : Typography.amp) == '&') {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.featurePresenter = presenter;
            return;
        }
        Intrinsics.checkNotNullParameter(presenter, "");
        this.featurePresenter = presenter;
        Object obj = null;
        obj.hashCode();
    }

    @JvmName(name = "getDanaBalanceClickListener")
    private final DanaBalanceClickListener getDanaBalanceClickListener() {
        int i = scheduleImpl + 125;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        DanaBalanceClickListener danaBalanceClickListener = (DanaBalanceClickListener) this.danaBalanceClickListener.getValue();
        int i3 = scheduleImpl + 19;
        getErrorConfigVersion = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return danaBalanceClickListener;
        }
        Object obj = null;
        obj.hashCode();
        return danaBalanceClickListener;
    }

    @JvmName(name = "getPtrCardPaymentHandle")
    private final PtrHandler getPtrCardPaymentHandle() {
        try {
            int i = getErrorConfigVersion + 81;
            try {
                scheduleImpl = i % 128;
                if ((i % 2 != 0 ? 'H' : 'W') != 'W') {
                    int i2 = 3 / 0;
                    return (PtrHandler) this.ptrCardPaymentHandle.getValue();
                }
                return (PtrHandler) this.ptrCardPaymentHandle.getValue();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        try {
            int i = getErrorConfigVersion + 77;
            try {
                scheduleImpl = i % 128;
                if (i % 2 != 0) {
                }
                super.onDestroyView();
                setEnabled(false);
                remove();
                _$_clearFindViewByIdCache();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getWalletCardAssetClickListener")
    private final WalletCardAssetClickListener getWalletCardAssetClickListener() {
        try {
            int i = getErrorConfigVersion + 15;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            WalletCardAssetClickListener walletCardAssetClickListener = (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
            int i3 = scheduleImpl + 69;
            getErrorConfigVersion = i3 % 128;
            if ((i3 % 2 == 0 ? 'V' : (char) 29) != 29) {
                Object[] objArr = null;
                int length = objArr.length;
                return walletCardAssetClickListener;
            }
            return walletCardAssetClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final FragmentPaymentDetailWalletBinding initViewBinding(View view) {
        int i = getErrorConfigVersion + 17;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(view, "");
            FragmentPaymentDetailWalletBinding MyBillsEntityDataFactory2 = FragmentPaymentDetailWalletBinding.MyBillsEntityDataFactory(view);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
            return MyBillsEntityDataFactory2;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "");
            FragmentPaymentDetailWalletBinding MyBillsEntityDataFactory3 = FragmentPaymentDetailWalletBinding.MyBillsEntityDataFactory(view);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory3, "");
            int i2 = 3 / 0;
            return MyBillsEntityDataFactory3;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        int i = scheduleImpl + 69;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        initInjector();
        initView();
        initOnClickListener();
        loadData();
        disableSwipe();
        FragmentActivity activity = getActivity();
        if (!(activity == null)) {
            int i3 = scheduleImpl + 99;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            OnBackPressedDispatcher onBackPressedDispatcher = activity.getOnBackPressedDispatcher();
            if (!(onBackPressedDispatcher == null)) {
                try {
                    onBackPressedDispatcher.PlaceComponentResult(this, this.onBackPressedCallback);
                    int i5 = getErrorConfigVersion + 121;
                    scheduleImpl = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v0, types: [id.dana.base.viewbinding.ViewBindingFragment, id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment, androidx.fragment.app.Fragment] */
    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        try {
            int i = scheduleImpl + 39;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            super.onStart();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                int i3 = getErrorConfigVersion + 121;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                if (isFromDeeplinkWallet(activity)) {
                    try {
                        int i5 = scheduleImpl + 59;
                        getErrorConfigVersion = i5 % 128;
                        int i6 = i5 % 2;
                        FragmentPaymentDetailWalletBinding fragmentPaymentDetailWalletBinding = (FragmentPaymentDetailWalletBinding) getBinding();
                        ?? r4 = 0;
                        if ((fragmentPaymentDetailWalletBinding != null ? ',' : 'U') != 'U') {
                            int i7 = scheduleImpl + 71;
                            getErrorConfigVersion = i7 % 128;
                            if (i7 % 2 == 0) {
                                RecyclerView recyclerView = fragmentPaymentDetailWalletBinding.lookAheadTest;
                                int length = r4.length;
                                r4 = recyclerView;
                            } else {
                                r4 = fragmentPaymentDetailWalletBinding.lookAheadTest;
                            }
                        }
                        FragmentManager parentFragmentManager = getParentFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                        backToMainPage(r4, parentFragmentManager, 0);
                        int i8 = scheduleImpl + 43;
                        getErrorConfigVersion = i8 % 128;
                        int i9 = i8 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        int i = scheduleImpl + 89;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        super.onResume();
        try {
            if ((this.isFromAddAsset ? (char) 19 : '2') == 19) {
                showShimmeringSkeleton();
                getPaymentWalletDetailPresenter().getPaymentAssets();
                refreshMainWalletPage();
                this.isFromAddAsset = false;
                int i3 = scheduleImpl + 111;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
            }
            int i5 = scheduleImpl + 105;
            getErrorConfigVersion = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        if (r3 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        if (r3 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
    
        r4 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion + 81;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r4 % 128;
        r4 = r4 % 2;
        r3 = r3.getString(id.dana.R.string.wallet_search_bar_hint_payment);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0098, code lost:
    
        r3 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion + 23;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r3 % 128;
        r3 = r3 % 2;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0106, code lost:
    
        if (r1 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010f, code lost:
    
        if (r1 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0111, code lost:
    
        r1 = r1;
        r3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, 10));
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012a, code lost:
    
        if (r1.hasNext() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012c, code lost:
    
        r5 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012f, code lost:
    
        r5 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0131, code lost:
    
        if (r5 == 'Y') goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0133, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0137, code lost:
    
        r5 = (android.os.Parcelable) r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x013f, code lost:
    
        if ((r5 instanceof id.dana.wallet_v3.model.PaymentCardModel) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0141, code lost:
    
        r6 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl + 7;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r6 % 128;
        r6 = r6 % 2;
        r5 = (id.dana.wallet_v3.model.PaymentCardModel) r5;
        r6 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl + 57;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0158, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0159, code lost:
    
        r3.add(r5);
        r5 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion + 83;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initView() {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.initView():void");
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    private static final void m3027initView$lambda2(PaymentWalletDetailFragment paymentWalletDetailFragment, View view) {
        int i = scheduleImpl + 43;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(paymentWalletDetailFragment, "");
            paymentWalletDetailFragment.navigateToSearch();
            int i3 = scheduleImpl + 9;
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

    private final void navigateToSearch() {
        MotionLayout motionLayout;
        FragmentPaymentDetailWalletBinding binding = getBinding();
        if ((binding != null ? (char) 28 : (char) 24) == 28) {
            MotionLayout motionLayout2 = binding.getAuthRequestContext;
            if (motionLayout2 != null) {
                int i = scheduleImpl + 29;
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                motionLayout2.setTransition(R.id.expand_to_search);
                int i3 = scheduleImpl + 91;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
            }
        }
        FragmentPaymentDetailWalletBinding binding2 = getBinding();
        if ((binding2 != null ? 'D' : (char) 6) == 6 || (motionLayout = binding2.getAuthRequestContext) == null) {
            return;
        }
        motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PaymentWalletDetailFragment.$r8$lambda$MVFdmfOCiflpV7cAoi9inoSHuyY(PaymentWalletDetailFragment.this);
            }
        });
    }

    /* renamed from: navigateToSearch$lambda-4  reason: not valid java name */
    private static final void m3028navigateToSearch$lambda4(PaymentWalletDetailFragment paymentWalletDetailFragment) {
        String str;
        int i = getErrorConfigVersion + 101;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(paymentWalletDetailFragment, "");
        WalletIntentFactory walletIntentFactory = WalletIntentFactory.INSTANCE;
        PaymentWalletDetailFragment paymentWalletDetailFragment2 = paymentWalletDetailFragment;
        WalletSearchFragment.Companion companion = WalletSearchFragment.INSTANCE;
        Context context = paymentWalletDetailFragment.getContext();
        Object[] objArr = null;
        if ((context != null ? (char) 31 : (char) 22) != 22) {
            int i3 = scheduleImpl + 21;
            getErrorConfigVersion = i3 % 128;
            boolean z = i3 % 2 != 0;
            String string = context.getString(R.string.wallet_search_bar_hint_payment);
            if (!z) {
                int length = objArr.length;
            }
            str = string;
        } else {
            int i4 = scheduleImpl + 41;
            getErrorConfigVersion = i4 % 128;
            int i5 = i4 % 2;
            str = null;
        }
        walletIntentFactory.openNewFragmentWithAnimation(paymentWalletDetailFragment2, WalletSearchFragment.Companion.newInstance$default(companion, "payment", str, null, null, 12, null));
        int i6 = scheduleImpl + 103;
        getErrorConfigVersion = i6 % 128;
        if (i6 % 2 == 0) {
            objArr.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if ((r0 != null ? 14 : 24) != 24) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = r0.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        if (r3 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        r3 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion + 81;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        if ((r3 % 2) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        r0.setTransition(id.dana.R.id.collapse_from_search);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
    
        r0 = 57 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        r0.setTransition(id.dana.R.id.collapse_from_search);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r0 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCollapseFromSearch() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L1a
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentPaymentDetailWalletBinding r0 = (id.dana.databinding.FragmentPaymentDetailWalletBinding) r0
            int r3 = r1.length     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L50
            goto L2b
        L18:
            r0 = move-exception
            throw r0
        L1a:
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentPaymentDetailWalletBinding r0 = (id.dana.databinding.FragmentPaymentDetailWalletBinding) r0
            r3 = 24
            if (r0 == 0) goto L27
            r4 = 14
            goto L29
        L27:
            r4 = 24
        L29:
            if (r4 == r3) goto L50
        L2b:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.getAuthRequestContext
            if (r0 == 0) goto L31
            r3 = 0
            goto L32
        L31:
            r3 = 1
        L32:
            if (r3 == 0) goto L35
            goto L50
        L35:
            int r3 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r3 = r3 + 81
            int r4 = r3 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r4
            int r3 = r3 % 2
            r4 = 2131363048(0x7f0a04e8, float:1.8345894E38)
            if (r3 == 0) goto L4d
            r0.setTransition(r4)
            r0 = 57
            int r0 = r0 / r2
            goto L50
        L4b:
            r0 = move-exception
            throw r0
        L4d:
            r0.setTransition(r4)
        L50:
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentPaymentDetailWalletBinding r0 = (id.dana.databinding.FragmentPaymentDetailWalletBinding) r0
            r3 = 89
            if (r0 == 0) goto L5d
            r4 = 89
            goto L5f
        L5d:
            r4 = 16
        L5f:
            if (r4 == r3) goto L62
            goto L9a
        L62:
            int r3 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r3 = r3 + 103
            int r4 = r3 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L7e
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.getAuthRequestContext
            int r1 = r1.length     // Catch: java.lang.Throwable -> L7c
            r1 = 57
            if (r0 == 0) goto L78
            r3 = 57
            goto L79
        L78:
            r3 = 7
        L79:
            if (r3 == r1) goto L82
            goto L9a
        L7c:
            r0 = move-exception
            throw r0
        L7e:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.getAuthRequestContext
            if (r0 == 0) goto L9a
        L82:
            int r1 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r1 = r1 + 73
            int r3 = r1 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r3
            int r1 = r1 % 2
            if (r1 != 0) goto L97
            r0.transitionToEnd()
            r0 = 41
            int r0 = r0 / r2
            goto L9a
        L95:
            r0 = move-exception
            throw r0
        L97:
            r0.transitionToEnd()
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.onCollapseFromSearch():void");
    }

    /* renamed from: initOnClickListener$lambda-5  reason: not valid java name */
    private static final void m3025initOnClickListener$lambda5(PaymentWalletDetailFragment paymentWalletDetailFragment, View view) {
        RecyclerView recyclerView;
        int i = getErrorConfigVersion + 109;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(paymentWalletDetailFragment, "");
        FragmentPaymentDetailWalletBinding binding = paymentWalletDetailFragment.getBinding();
        try {
            if ((binding != null ? '.' : '7') != '.') {
                recyclerView = null;
                int i3 = scheduleImpl + 73;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
            } else {
                int i5 = scheduleImpl + 5;
                try {
                    getErrorConfigVersion = i5 % 128;
                    int i6 = i5 % 2;
                    recyclerView = binding.lookAheadTest;
                } catch (Exception e) {
                    throw e;
                }
            }
            FragmentManager parentFragmentManager = paymentWalletDetailFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            paymentWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 0);
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        r0.setOnClickListener(new id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$$ExternalSyntheticLambda0(r4));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initOnClickListener() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r0 = r0 + 77
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r1
            int r0 = r0 % 2
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()     // Catch: java.lang.Exception -> L70
            id.dana.databinding.FragmentPaymentDetailWalletBinding r0 = (id.dana.databinding.FragmentPaymentDetailWalletBinding) r0     // Catch: java.lang.Exception -> L70
            r1 = 42
            if (r0 == 0) goto L17
            r2 = 42
            goto L19
        L17:
            r2 = 30
        L19:
            r3 = 0
            if (r2 == r1) goto L1d
            goto L4a
        L1d:
            int r1 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r1 = r1 + 9
            int r2 = r1 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r2
            int r1 = r1 % 2
            r2 = 16
            if (r1 == 0) goto L2e
            r1 = 35
            goto L30
        L2e:
            r1 = 16
        L30:
            if (r1 == r2) goto L3e
            com.airbnb.lottie.LottieAnimationView r0 = r0.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L3c
            r1 = 11
            int r1 = r1 / r3
            if (r0 == 0) goto L4a
            goto L42
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            r0 = move-exception
            goto L6e
        L3e:
            com.airbnb.lottie.LottieAnimationView r0 = r0.MyBillsEntityDataFactory
            if (r0 == 0) goto L4a
        L42:
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$$ExternalSyntheticLambda0 r1 = new id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$$ExternalSyntheticLambda0
            r1.<init>()
            r0.setOnClickListener(r1)
        L4a:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.databinding.FragmentPaymentDetailWalletBinding r0 = (id.dana.databinding.FragmentPaymentDetailWalletBinding) r0
            r1 = 1
            if (r0 == 0) goto L54
            r3 = 1
        L54:
            if (r3 == r1) goto L57
            goto L6f
        L57:
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r0 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L70
            if (r0 == 0) goto L6f
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$$ExternalSyntheticLambda1 r1 = new id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$$ExternalSyntheticLambda1
            r1.<init>()
            r0.setOnClickListener(r1)
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion     // Catch: java.lang.Exception -> L3c
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r1     // Catch: java.lang.Exception -> L3c
            int r0 = r0 % 2
            goto L6f
        L6e:
            throw r0
        L6f:
            return
        L70:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.initOnClickListener():void");
    }

    /* renamed from: initOnClickListener$lambda-6  reason: not valid java name */
    private static final void m3026initOnClickListener$lambda6(PaymentWalletDetailFragment paymentWalletDetailFragment, View view) {
        int i = scheduleImpl + 99;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? 'a' : (char) 29) == 29) {
            Intrinsics.checkNotNullParameter(paymentWalletDetailFragment, "");
            paymentWalletDetailFragment.getWalletV3TrackerImplementation().trackOpenAddAsset(TrackerKey.WalletAddAssetSource.ADD_PAYMENT_SECTION);
            paymentWalletDetailFragment.checkPaymentServicesExist();
            return;
        }
        Intrinsics.checkNotNullParameter(paymentWalletDetailFragment, "");
        paymentWalletDetailFragment.getWalletV3TrackerImplementation().trackOpenAddAsset(TrackerKey.WalletAddAssetSource.ADD_PAYMENT_SECTION);
        paymentWalletDetailFragment.checkPaymentServicesExist();
        int i2 = 70 / 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void checkPaymentServicesExist() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1
            int r0 = r0 % 2
            java.util.List<id.dana.model.ThirdPartyService> r0 = r5.paymentServices
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r0 == 0) goto L19
            r0 = 0
            goto L1a
        L19:
            r0 = 1
        L1a:
            if (r0 == r1) goto L69
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r0 = r0 + 125
            int r3 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r3
            int r0 = r0 % 2
            java.util.List<id.dana.model.ThirdPartyService> r0 = r5.paymentServices     // Catch: java.lang.Exception -> L67
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Exception -> L67
            boolean r3 = r0 instanceof java.util.Collection     // Catch: java.lang.Exception -> L67
            if (r3 == 0) goto L38
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L38
            goto L5c
        L38:
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L67
        L3c:
            boolean r3 = r0.hasNext()
            r4 = 64
            if (r3 == 0) goto L47
            r3 = 98
            goto L49
        L47:
            r3 = 64
        L49:
            if (r3 == r4) goto L5c
            java.lang.Object r3 = r0.next()
            id.dana.model.ThirdPartyService r3 = (id.dana.model.ThirdPartyService) r3
            java.lang.String r3 = r3.NetworkUserEntityData$$ExternalSyntheticLambda8
            java.lang.String r4 = "service_akulaku"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto L3c
            goto L5d
        L5c:
            r1 = 0
        L5d:
            if (r1 == 0) goto L69
            java.util.List<id.dana.model.ThirdPartyService> r0 = r5.paymentServices     // Catch: java.lang.Exception -> L65
            r5.openBottomSheetAddAsset(r0)     // Catch: java.lang.Exception -> L65
            return
        L65:
            r0 = move-exception
            throw r0
        L67:
            r0 = move-exception
            throw r0
        L69:
            r5.openAddPaymentCard()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.checkPaymentServicesExist():void");
    }

    private final void checkPaymentServices() {
        int i = scheduleImpl + 77;
        getErrorConfigVersion = i % 128;
        try {
            if (i % 2 == 0) {
                try {
                    getPaymentWalletDetailPresenter().getPaymentServices();
                    Object[] objArr = null;
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                getPaymentWalletDetailPresenter().getPaymentServices();
            }
            int i2 = scheduleImpl + 105;
            getErrorConfigVersion = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void openAddPaymentCard() {
        int i = getErrorConfigVersion + 49;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        this.isFromAddAsset = true;
        getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(DanaUrl.CARD_BINDING_DEEPLINK_FROM_WALLET);
        int i3 = scheduleImpl + 51;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void openBottomSheetAddAsset(List<ThirdPartyService> services) {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$openBottomSheetAddAsset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PaymentWalletDetailFragment.access$refreshMainWalletPage(PaymentWalletDetailFragment.this);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        String lowerCase = "PAYMENT".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        new BottomSheetAddAsset(function0, 1, CollectionsKt.listOf(lowerCase), 0, null, null, false, services, 120, null).show(getParentFragmentManager(), (String) null);
        try {
            int i = scheduleImpl + 77;
            try {
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void initInjector() {
        DaggerPaymentWalletDetailComponent.Builder servicesModule = DaggerPaymentWalletDetailComponent.builder().applicationComponent(getApplicationComponent()).paymentWalletDetailModule(getPaymentWalletDetailModule()).servicesModule(getServicesModule());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getActivity();
        byte b = 0;
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getMaximumFlingVelocity() >> 16) - 1520711280, (ViewConfiguration.getMaximumFlingVelocity() >> 16) - 58, (short) (Color.rgb(0, 0, 0) + 16777269), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1185025158, (byte) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr);
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = ((String) objArr[0]).intern();
        DaggerPaymentWalletDetailComponent.Builder deepLinkModule = servicesModule.deepLinkModule(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        DaggerPaymentWalletDetailComponent.Builder scanQrModule = deepLinkModule.scanQrModule(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getActivity();
        DaggerPaymentWalletDetailComponent.Builder restoreUrlModule = scanQrModule.restoreUrlModule(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        DaggerPaymentWalletDetailComponent.Builder featureModule = restoreUrlModule.featureModule(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        featureModule.oauthModule(new OauthModule(BuiltInFictitiousFunctionClassFactory, b)).build().inject(this);
        int i = scheduleImpl + 29;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
    }

    private final PaymentWalletDetailModule getPaymentWalletDetailModule() {
        try {
            PaymentWalletDetailModule paymentWalletDetailModule = new PaymentWalletDetailModule(new PaymentWalletDetailContract.View() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$getPaymentWalletDetailModule$1
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

                @Override // id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract.View
                public final void onErrorGetPaymentServices() {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract.View
                public final void onGetPaymentAsset(List<? extends PaymentCardModel> assets) {
                    Intrinsics.checkNotNullParameter(assets, "");
                    PaymentWalletDetailFragment.access$hideShimmeringSkeleton(PaymentWalletDetailFragment.this);
                    PaymentWalletAdapter access$getPaymentWalletAdapter$p = PaymentWalletDetailFragment.access$getPaymentWalletAdapter$p(PaymentWalletDetailFragment.this);
                    if (access$getPaymentWalletAdapter$p != null) {
                        access$getPaymentWalletAdapter$p.setItems(assets);
                    }
                }

                @Override // id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract.View
                public final void onSuccessGetPaymentServices(List<ThirdPartyService> thirdPartyService) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                    PaymentWalletDetailFragment.access$setPaymentServices$p(PaymentWalletDetailFragment.this, thirdPartyService);
                }
            });
            int i = getErrorConfigVersion + 113;
            scheduleImpl = i % 128;
            if ((i % 2 != 0 ? 'C' : InputCardNumberView.DIVIDER) != ' ') {
                int i2 = 33 / 0;
                return paymentWalletDetailModule;
            }
            return paymentWalletDetailModule;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void loadData() {
        int i = getErrorConfigVersion + 89;
        scheduleImpl = i % 128;
        if (i % 2 != 0) {
        }
        getServicesPresenter().BuiltInFictitiousFunctionClassFactory(WalletConstant.CATEGORY_FINANCE, true);
        checkPaymentServices();
        int i2 = getErrorConfigVersion + 25;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
    }

    private final ServicesModule getServicesModule() {
        try {
            ServicesModule servicesModule = new ServicesModule(new ServicesContract.View() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$getServicesModule$1
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
                    PaymentWalletDetailFragment.access$setFinanceServices$p(PaymentWalletDetailFragment.this, thirdPartyServices);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final void onActionPost(ThirdPartyService thirdPartyService, String authCode) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                    WalletH5ServicesImplementation walletH5ServicesImplementation = PaymentWalletDetailFragment.this.getWalletH5ServicesImplementation();
                    String authRequestContext = UrlUtil.getAuthRequestContext(thirdPartyService.getCallingPid);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    Intrinsics.checkNotNull(authCode);
                    walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, authCode, PaymentWalletDetailFragment.this.getDeviceInformationProvider().getDeviceUUID());
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final void onActionGet(ThirdPartyService thirdPartyService) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                    String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    if (str != null) {
                        PaymentWalletDetailFragment paymentWalletDetailFragment = PaymentWalletDetailFragment.this;
                        if (UrlUtil.getErrorConfigVersion(str)) {
                            paymentWalletDetailFragment.getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
                            return;
                        }
                        WalletH5ServicesImplementation walletH5ServicesImplementation = paymentWalletDetailFragment.getWalletH5ServicesImplementation();
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
                        PaymentWalletDetailFragment.this.getFeaturePresenter().getAuthRequestContext(str, params);
                    }
                }
            });
            int i = scheduleImpl + 75;
            getErrorConfigVersion = i % 128;
            if ((i % 2 == 0 ? '[' : 'G') != 'G') {
                Object obj = null;
                obj.hashCode();
                return servicesModule;
            }
            return servicesModule;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void gotoTopupPage() {
        int i = getErrorConfigVersion + 83;
        scheduleImpl = i % 128;
        if (!(i % 2 != 0)) {
            String topupUrl = getDynamicUrlWrapper().getTopupUrl(TopupSource.DANA_WALLET);
            Intrinsics.checkNotNullExpressionValue(topupUrl, "");
            DanaH5.startContainerFullUrl(topupUrl, createH5AppListener());
            return;
        }
        try {
            try {
                String topupUrl2 = getDynamicUrlWrapper().getTopupUrl(TopupSource.DANA_WALLET);
                Intrinsics.checkNotNullExpressionValue(topupUrl2, "");
                DanaH5.startContainerFullUrl(topupUrl2, createH5AppListener());
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
    
        r4 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl + 1;
        id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r4 % 128;
        r4 = r4 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void goToServicePage(java.util.List<id.dana.model.ThirdPartyService> r4, java.lang.String r5) {
        /*
            r3 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r1
            int r0 = r0 % 2
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Exception -> L6f
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Exception -> L6f
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1
            int r0 = r0 % 2
        L1a:
            boolean r0 = r4.hasNext()
            r1 = 1
            if (r0 == 0) goto L3c
            java.lang.Object r0 = r4.next()
            r2 = r0
            id.dana.model.ThirdPartyService r2 = (id.dana.model.ThirdPartyService) r2
            java.lang.String r2 = r2.NetworkUserEntityData$$ExternalSyntheticLambda8
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
            if (r2 == 0) goto L1a
            int r4 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl     // Catch: java.lang.Exception -> L3a
            int r4 = r4 + r1
            int r5 = r4 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r5     // Catch: java.lang.Exception -> L3a
            int r4 = r4 % 2
            goto L3d
        L3a:
            r4 = move-exception
            goto L6e
        L3c:
            r0 = 0
        L3d:
            id.dana.model.ThirdPartyService r0 = (id.dana.model.ThirdPartyService) r0
            r4 = 0
            if (r0 == 0) goto L44
            r5 = 0
            goto L45
        L44:
            r5 = 1
        L45:
            if (r5 == 0) goto L48
            goto L6d
        L48:
            int r5 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion     // Catch: java.lang.Exception -> L3a
            int r5 = r5 + 15
            int r2 = r5 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r2
            int r5 = r5 % 2
            if (r5 == 0) goto L56
            r5 = 0
            goto L57
        L56:
            r5 = 1
        L57:
            if (r5 == r1) goto L66
            id.dana.contract.services.ServicesContract$Presenter r5 = r3.getServicesPresenter()
            id.dana.contract.services.ServicesContract.Presenter.CC.KClassImpl$Data$declaredNonStaticMembers$2(r5, r0)
            r5 = 82
            int r5 = r5 / r4
            goto L6d
        L64:
            r4 = move-exception
            throw r4
        L66:
            id.dana.contract.services.ServicesContract$Presenter r4 = r3.getServicesPresenter()
            id.dana.contract.services.ServicesContract.Presenter.CC.KClassImpl$Data$declaredNonStaticMembers$2(r4, r0)
        L6d:
            return
        L6e:
            throw r4
        L6f:
            r4 = move-exception
            goto L72
        L71:
            throw r4
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.goToServicePage(java.util.List, java.lang.String):void");
    }

    private final DanaH5Listener createH5AppListener() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                DanaH5.dispose();
                PaymentWalletDetailFragment.access$showShimmeringSkeleton(PaymentWalletDetailFragment.this);
                PaymentWalletDetailFragment.this.getPaymentWalletDetailPresenter().getPaymentAssets();
                PaymentWalletDetailFragment.access$refreshMainWalletPage(PaymentWalletDetailFragment.this);
            }
        };
        int i = getErrorConfigVersion + 45;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? '3' : '=') != '=') {
            Object obj = null;
            obj.hashCode();
            return danaH5Listener;
        }
        return danaH5Listener;
    }

    private final void disableSwipe() {
        HomeTabActivity homeTabActivity;
        int i;
        FragmentActivity activity = getActivity();
        if (activity instanceof HomeTabActivity) {
            try {
                int i2 = getErrorConfigVersion + 3;
                scheduleImpl = i2 % 128;
                int i3 = i2 % 2;
                homeTabActivity = (HomeTabActivity) activity;
                i = scheduleImpl + 21;
            } catch (Exception e) {
                throw e;
            }
        } else {
            homeTabActivity = null;
            i = scheduleImpl + 3;
        }
        getErrorConfigVersion = i % 128;
        int i4 = i % 2;
        if (homeTabActivity != null) {
            int i5 = getErrorConfigVersion + 115;
            scheduleImpl = i5 % 128;
            int i6 = i5 % 2;
            try {
                homeTabActivity.setSwipeable(false);
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private final void refreshMainWalletPage() {
        try {
            int i = getErrorConfigVersion + 33;
            scheduleImpl = i % 128;
            if (!(i % 2 != 0)) {
                if (isAdded() ? false : true) {
                    return;
                }
            } else {
                boolean isAdded = isAdded();
                Object[] objArr = null;
                int length = objArr.length;
                if ((isAdded ? '0' : '\b') == '\b') {
                    return;
                }
            }
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            NewWalletFragment walletFragment = getWalletFragment(parentFragmentManager);
            if (walletFragment != null) {
                int i2 = getErrorConfigVersion + 23;
                scheduleImpl = i2 % 128;
                int i3 = i2 % 2;
                walletFragment.setLastAddedAssetType(1);
                try {
                    walletFragment.refreshDataBasedOnLatestAddedAssetType();
                    int i4 = getErrorConfigVersion + 31;
                    scheduleImpl = i4 % 128;
                    int i5 = i4 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if ((r0 != null ? 'A' : '\f') != 'A') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        if ((r0 != null ? 30 : 17) != 17) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        r0 = r0.lookAheadTest;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
    
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r0 = com.ethanhua.skeleton.Skeleton.BuiltInFictitiousFunctionClassFactory(r0);
        r0.BuiltInFictitiousFunctionClassFactory = id.dana.R.layout.view_wallet_detail_skeleton;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r5.paymentWalletAdapter;
        r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        r0.PlaceComponentResult = true;
        r0.getErrorConfigVersion = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory(r0.MyBillsEntityDataFactory.getContext(), id.dana.R.color.f27082131100491);
        r0.lookAheadTest = 20;
        r0.getAuthRequestContext = 5;
        r1 = new com.ethanhua.skeleton.RecyclerViewSkeletonScreen(r0, r3);
        r1.MyBillsEntityDataFactory();
        r5.skeletonScreen = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showShimmeringSkeleton() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 90
            if (r0 == 0) goto L11
            r0 = 71
            goto L13
        L11:
            r0 = 90
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L2b
            r5.isLoading = r3
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentPaymentDetailWalletBinding r0 = (id.dana.databinding.FragmentPaymentDetailWalletBinding) r0
            r1 = 65
            if (r0 == 0) goto L26
            r4 = 65
            goto L28
        L26:
            r4 = 12
        L28:
            if (r4 == r1) goto L3e
            goto L79
        L2b:
            r5.isLoading = r2
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.databinding.FragmentPaymentDetailWalletBinding r0 = (id.dana.databinding.FragmentPaymentDetailWalletBinding) r0
            r1 = 17
            if (r0 == 0) goto L3a
            r4 = 30
            goto L3c
        L3a:
            r4 = 17
        L3c:
            if (r4 == r1) goto L79
        L3e:
            androidx.recyclerview.widget.RecyclerView r0 = r0.lookAheadTest
            if (r0 == 0) goto L79
            com.ethanhua.skeleton.RecyclerViewSkeletonScreen$Builder r0 = com.ethanhua.skeleton.Skeleton.BuiltInFictitiousFunctionClassFactory(r0)
            r1 = 2131560251(0x7f0d073b, float:1.874587E38)
            r0.BuiltInFictitiousFunctionClassFactory = r1
            id.dana.wallet_v3.payment.adapter.PaymentWalletAdapter r1 = r5.paymentWalletAdapter
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = (androidx.recyclerview.widget.RecyclerView.Adapter) r1
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 1500(0x5dc, float:2.102E-42)
            r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            r0.PlaceComponentResult = r2
            androidx.recyclerview.widget.RecyclerView r1 = r0.MyBillsEntityDataFactory
            android.content.Context r1 = r1.getContext()
            r2 = 2131100491(0x7f06034b, float:1.7813365E38)
            int r1 = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory(r1, r2)
            r0.getErrorConfigVersion = r1
            r1 = 20
            r0.lookAheadTest = r1
            r1 = 5
            r0.getAuthRequestContext = r1
            com.ethanhua.skeleton.RecyclerViewSkeletonScreen r1 = new com.ethanhua.skeleton.RecyclerViewSkeletonScreen
            r1.<init>(r0, r3)
            r1.MyBillsEntityDataFactory()
            com.ethanhua.skeleton.SkeletonScreen r1 = (com.ethanhua.skeleton.SkeletonScreen) r1
            r5.skeletonScreen = r1
        L79:
            int r0 = id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.scheduleImpl
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.getErrorConfigVersion = r1
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment.showShimmeringSkeleton():void");
    }

    private final void hideShimmeringSkeleton() {
        SkeletonScreen skeletonScreen;
        int i = scheduleImpl + 95;
        getErrorConfigVersion = i % 128;
        if (i % 2 == 0) {
            try {
                this.isLoading = false;
                skeletonScreen = this.skeletonScreen;
                if ((skeletonScreen != null ? (char) 5 : 'W') == 'W') {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.isLoading = false;
            skeletonScreen = this.skeletonScreen;
            if ((skeletonScreen != null ? (char) 1 : (char) 6) != 1) {
                return;
            }
        }
        skeletonScreen.PlaceComponentResult();
        int i2 = scheduleImpl + 71;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void setupLottieBasedOnLanguage(boolean isDefaultIndonesian) {
        String str;
        if ((isDefaultIndonesian ? ']' : '^') != ']') {
            str = "json/lottie/wallet_close_detail_page_en.lottie";
        } else {
            int i = getErrorConfigVersion + 49;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            str = "json/lottie/wallet_close_detail_page_id.lottie";
        }
        FragmentPaymentDetailWalletBinding binding = getBinding();
        if ((binding != null ? 'Z' : (char) 15) != 'Z') {
            return;
        }
        try {
            int i3 = scheduleImpl + 19;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            try {
                LottieAnimationView lottieAnimationView = binding.MyBillsEntityDataFactory;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setAnimation(str);
                    int i5 = scheduleImpl + 121;
                    getErrorConfigVersion = i5 % 128;
                    int i6 = i5 % 2;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/wallet_v3/payment/view/PaymentWalletDetailFragment$Companion;", "", "", "Lid/dana/wallet_v3/model/WalletV3CardModel;", FirebaseAnalytics.Param.ITEMS, "Lid/dana/wallet_v3/payment/view/PaymentWalletDetailFragment;", "newInstance", "(Ljava/util/List;)Lid/dana/wallet_v3/payment/view/PaymentWalletDetailFragment;", "", PaymentWalletDetailFragment.PAYMENT_CARD_ITEMS, "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaymentWalletDetailFragment newInstance(List<? extends WalletV3CardModel> items) {
            Intrinsics.checkNotNullParameter(items, "");
            Bundle bundle = new Bundle();
            Object[] array = items.toArray(new WalletV3CardModel[0]);
            if (array != null) {
                bundle.putParcelableArray(PaymentWalletDetailFragment.PAYMENT_CARD_ITEMS, (Parcelable[]) array);
                PaymentWalletDetailFragment paymentWalletDetailFragment = new PaymentWalletDetailFragment();
                paymentWalletDetailFragment.setArguments(bundle);
                return paymentWalletDetailFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        int length;
        byte[] bArr;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L));
        boolean z2 = i4 == -1;
        if (z2) {
            byte[] bArr2 = lookAheadTest;
            if (bArr2 != null) {
                int i5 = $11 + 115;
                $10 = i5 % 128;
                if (i5 % 2 != 0) {
                    length = bArr2.length;
                    bArr = new byte[length];
                } else {
                    length = bArr2.length;
                    bArr = new byte[length];
                }
                for (int i6 = 0; i6 < length; i6++) {
                    int i7 = $11 + 5;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                    bArr[i6] = (byte) (bArr2[i6] ^ 3097486228508854431L);
                }
                bArr2 = bArr;
            }
            i4 = !(bArr2 != null) ? (short) (((short) (NetworkUserEntityData$$ExternalSyntheticLambda0[i + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L))) : (byte) (((byte) (lookAheadTest[i + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
        }
        if (i4 > 0) {
            try {
                b2.getAuthRequestContext = ((i + i4) - 2) + ((int) (PlaceComponentResult ^ 3097486228508854431L)) + (z2 ? 1 : 0);
                b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)));
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                byte[] bArr3 = lookAheadTest;
                if (bArr3 != null) {
                    int length2 = bArr3.length;
                    byte[] bArr4 = new byte[length2];
                    for (int i9 = 0; i9 < length2; i9++) {
                        int i10 = $10 + 97;
                        $11 = i10 % 128;
                        if (i10 % 2 == 0) {
                            bArr4[i9] = (byte) (bArr3[i9] ^ 3097486228508854431L);
                        } else {
                            bArr4[i9] = (byte) (bArr3[i9] ^ 3097486228508854431L);
                        }
                    }
                    bArr3 = bArr4;
                }
                if ((bArr3 != null ? 'E' : '6') != 'E') {
                    z = false;
                } else {
                    int i11 = $11 + 123;
                    $10 = i11 % 128;
                    if (i11 % 2 != 0) {
                    }
                    z = true;
                }
                b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                    if (z) {
                        byte[] bArr5 = lookAheadTest;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                        int i12 = $10 + 71;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                    } else {
                        short[] sArr = NetworkUserEntityData$$ExternalSyntheticLambda0;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    }
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        objArr[0] = sb.toString();
    }
}
